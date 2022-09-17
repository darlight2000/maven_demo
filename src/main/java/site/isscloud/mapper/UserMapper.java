package site.isscloud.mapper;

import site.isscloud.domain.User;
import site.isscloud.domain.VideoOrder;

import java.util.List;

public interface UserMapper {
    public List<User> queryUserOrder();
    public List<User> queryUserOrderLazy();
    public List<VideoOrder> queryOrderByUserId(int id);
    public User getUserById(int id);

}
