package com.cz.lookportnews.specification;

import com.cz.lookportnews.entity.Channel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.*;

public class ChannelSpec {

    /**
     *  返回 父结点的 channel
     * @return
     */
    public static Specification<Channel> findRootChannel(){

        return new Specification<Channel>() {
            @Override
            public Predicate toPredicate(Root<Channel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Integer> id = root.get("id");
                Path<Channel> channel = root.get("channel");
                System.out.println(channel);
                return   cb.isNull(channel);
            }
        };
    }

    /**
     *  根据父结点 返回子节点
     * @param parentId
     * @return
     */
    public static Specification<Channel> findChildChannel(Long parentId){
        return new Specification<Channel>() {
            @Override
            public Predicate toPredicate(Root<Channel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        };
    }


}
