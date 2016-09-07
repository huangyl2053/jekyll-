/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistory;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定外部データ出力履歴のデータアクセスクラスです
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public class DbT7204YokaigoNinteiGaibuDataOutputHistoryDac {

    @InjectSession
    private SqlSession session;

    /**
     * 要介護認定外部データ出力履歴TBLから直前のデータ出力期間を取得する
     *
     * @param dataKubun Code
     * @return DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity
     */
    @Transaction
    public DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity selectデータ出力履歴時間(Code dataKubun) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7204YokaigoNinteiGaibuDataOutputHistory.class).
                where(
                        eq(DbT7204YokaigoNinteiGaibuDataOutputHistory.dataKubun, dataKubun)).
                toObject(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity.class);
    }
}
