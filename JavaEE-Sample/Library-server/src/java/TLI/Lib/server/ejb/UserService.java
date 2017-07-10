package TLI.Lib.server.ejb;

import TLI.Lib.server.models.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.security.MessageDigest;

@Stateless
@LocalBean
public class UserService {

    @PersistenceContext(unitName = "Library-serverPU")
    private EntityManager em;

    public void createUser(Users u) {
        em.persist(u);
    }

    public void updateUser(Users u) {
        em.merge(u);
    }

    public void deleteUser(Users u) {
        em.remove(em.merge(u));
    }

    public Users getUserById(Long Id) {
        return em.find(Users.class, Id);
    }

    public Users getUserByName(String N) {
        List<Users> users = getAllUsers();
        Users U = new Users();
        for (Users u : users) {
            if (u.getUsername() != null) {
                if (u.getUsername().equals(N)) {
                    U = u;
                }
            }
        }
        return U;
    }

    public String hashPW(String PW) {
        String newPW = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(PW.getBytes());

            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            System.out.println("Hex format : " + sb.toString());

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);

            }
            newPW = hexString.toString();
        } catch (Exception e) {

        }
        return newPW;
    }

    public List<Users> getAllUsers() {
        TypedQuery<Users> q = em.createQuery("SELECT u FROM Users u", Users.class);
        return q.getResultList();
    }

}
