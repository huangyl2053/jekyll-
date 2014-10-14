/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsu.nyushoShisetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsu.nyushoShisetsuShurui;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAddType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護除外・住所地特例対象施設のデータアクセスクラスです。
 *
 * @author N3317 塚田 萌
 */
//TODO n3317塚田萌　deleteは本実装の時に対応する。
public class JogaiJushochitokureiTaishoShisetsuDac implements
        IInsertable<DbT1005KaigoJogai_TokureiTaishoShisetsuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 施設種類、施設コードを指定して該当する1件の施設情報を取得します。
     *
     * @param 施設種類 施設種類
     * @param 施設コード 施設コード
     * @return 施設entity
     */
    @Transaction
    public DbT1005KaigoJogai_TokureiTaishoShisetsuEntity select(ShisetsuType 施設種類, ShisetsuCode 施設コード) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);

        return accessor.
                select().
                table(DbT1005KaigoJogai_TokureiTaishoShisetsu.class).
                where(and(eq(nyushoShisetsuShurui, 施設種類.getCode()),
                                eq(nyushoShisetsuCode, 施設コード.value()))).
                toObject(DbT1005KaigoJogai_TokureiTaishoShisetsuEntity.class);
    }

    @Override
    @Transaction
    public int insert(DbT1005KaigoJogai_TokureiTaishoShisetsuEntity data) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.insert(data).execute();
    }
}
