/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanri;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanri.hokaiseiShikoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 介護認定法改正管理のデータアクセスクラスです
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public class DbT7202KaigoNinteiHokaiseiKanriDac {

    @InjectSession
    private SqlSession session;

    /**
     * すべての介護認定法改正管理情報取得
     *
     * @return すべての介護認定法改正管理情報
     */
    public List<DbT7202KaigoNinteiHokaiseiKanriEntity> get介護認定法改正管理情報() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7202KaigoNinteiHokaiseiKanri.class).
                order(by(hokaiseiShikoYMD, Order.DESC)).
                toList(DbT7202KaigoNinteiHokaiseiKanriEntity.class);
    }

}
