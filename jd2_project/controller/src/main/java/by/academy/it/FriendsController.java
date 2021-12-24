package by.academy.it;

import by.academy.it.dao.FriendsDao;
import by.academy.it.pojo.Friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsController {
    private FriendsDao friendsDao;

    public FriendsController(FriendsDao friendsDao) {
        this.friendsDao = friendsDao;
    }

    public void addFriend(Friends friends) {
        friendsDao.addNewFriend(friends);
    }

    public void deleteFriend(Friends friends) {
        friendsDao.deleteFriend(friends);
    }
}
