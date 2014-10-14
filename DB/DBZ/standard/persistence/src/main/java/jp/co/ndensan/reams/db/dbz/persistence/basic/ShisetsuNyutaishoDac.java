/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho.daichoShubetsu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho.nyushoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAddType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 施設入退所のデータアクセスクラスです。
 *
 * @author N3317 塚田 萌
 */
public class ShisetsuNyutaishoDac implements
        IDeletable<DbT1004ShisetsuNyutaishoEntity>,
        IInsertable<DbT1004ShisetsuNyutaishoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定する個人識別コードに対応する施設入退所Entityのリストを取得します。<br/>
     * 該当する情報がない時は空のリストを返します。
     *
     * @param 個人識別コード 個人識別コード
     * @return 施設入退所Entityのインスタンスのリスト
     */
    @Transaction
    public List<DbT1004ShisetsuNyutaishoEntity> select(ShikibetsuCode 個人識別コード) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);

        return accessor.
                select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(eq(shikibetsuCode, 個人識別コード)).
                order(by(nyushoYMD, Order.DESC)).
                toList(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 指定する個人識別コード・基準日に対応する施設入退所Entityを取得します。<br/>
     * 該当する情報がない時はnullを返します。
     *
     * @param 個人識別コード 個人識別コード
     * @param 基準日 基準日
     * @return 施設入退所Entityのインスタンス
     */
    @Transaction
    public DbT1004ShisetsuNyutaishoEntity select(ShikibetsuCode 個人識別コード, FlexibleDate 基準日) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);

        return accessor.
                select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(and(eq(shikibetsuCode, 個人識別コード), eq(nyushoYMD, 基準日))).
                toObject(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 指定する個人識別コード・台帳種別に対応する施設入退所Entityのリストを取得します。<br/>
     * 該当する情報がない時は空のリストを返します。
     *
     * @param 個人識別コード 個人識別コード
     * @param 台帳種別 台帳種別
     * @return 施設入退所Entityのインスタンスのリスト
     */
    @Transaction
    public List<DbT1004ShisetsuNyutaishoEntity> select(ShikibetsuCode 個人識別コード, DaichoType 台帳種別) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);

        return accessor.
                select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(and(eq(shikibetsuCode, 個人識別コード), eq(daichoShubetsu, 台帳種別.getCode()))).
                order(by(shoriTimestamp, Order.DESC)).
                toList(DbT1004ShisetsuNyutaishoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT1004ShisetsuNyutaishoEntity data) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.insert(data).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1004ShisetsuNyutaishoEntity data) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.insertDenialRow(data).execute();
    }
}
