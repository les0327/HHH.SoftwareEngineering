import model.DAO.UserDAO;
import model.entity.User;

public class Main {

        public static void main(String[] args) {
//            ActionDAO dao = new ActionDAO();
//            UserDAO userdao = new UserDAO();
//            List<Action> list = dao.getAll();
//            list.forEach(System.out::println);
//
//            Action action = new Action();
//            action.setType(ActionType.DELETE_ADVERT);
//            action.setActor(userdao.getByKey(1));
//            action.setAuthor(userdao.getByKey(2));
//            action.setDate(new Date());
//
//            dao.save(action);
//
//            User user = new User();
//            user.setName("Name");
//            user.setEmail("Email");
//            user.setPassword("Password");
//
//            userdao.save(user);
//
//            dao.getAll().forEach(System.out::println);
//            userdao.getAll().forEach(System.out::println);

            UserDAO dao = new UserDAO();

            System.out.println(dao.getByEmail("Vova@email.com"));
        }
}
