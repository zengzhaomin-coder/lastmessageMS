package dao;

import entity.MessageBean;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBCon;
import java.sql.Connection;
import java.util.List;

public class MessageDao {
    /**
     * 显示所有信息
     * @return
     * @throws Exception
     */
    public List<MessageBean> getMessages() throws Exception {
        Connection conn = DBCon.getConnection();
        String sql = "select mid, mcontent, publish from MessageInfo";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<MessageBean>(MessageBean.class)
            );
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void del(String mid) throws Exception {
        Connection conn = DBCon.getConnection();
        String sql = "delete from MessageInfo where mid = ?";
        try {
            new QueryRunner().update(conn, sql, mid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 删除多条信息
     * @param mids
     * @return
     * @throws Exception
     */
    public void delete(String[] mids) throws Exception {
        for (String mid: mids) {
            del(mid);
        }
    }
}
