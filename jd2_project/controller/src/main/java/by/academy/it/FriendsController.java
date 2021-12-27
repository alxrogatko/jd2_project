package by.academy.it;

import by.academy.it.dao.FriendsDao;
import by.academy.it.pojo.Friends;
import by.academy.it.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsController {
    private final FriendsDao friendsDao;

    public FriendsController(FriendsDao friendsDao) {
        this.friendsDao = friendsDao;
    }

    public void addFriend(Friends friends) {
        friendsDao.addNewFriend(friends);
    }

    public List<Friends> getFriendRequests(String id) {
        return friendsDao.getFriendRequests(id);
    }

    public String getRequestStatus(String receiverId, String requesterId) {
       return friendsDao.getFriendRequestStatus(receiverId, requesterId);
    }

    public void deleteFriend(Friends friends) {
        friendsDao.deleteFriend(friends);
    }

    public void updateFriendStatus(String requesterId, String receiverId, String status) {
        friendsDao.updateFriendStatus(requesterId, receiverId, status);
    }
}
