/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic;

import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaDaichoDac implements IHihokenshaDaichoDac {

    @InjectSession
    private SqlSession session;

    @Override
    @Transaction
    public int insert(T1001HihokenshaDaichoEntity data) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.insert(data).execute();
    }

    @Override
    @Transaction
    public int delete(T1001HihokenshaDaichoEntity data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transaction
    public int update(T1001HihokenshaDaichoEntity data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
