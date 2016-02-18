/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.relate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.jukyu.shiharaihohohenko.KanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.jukyu.shiharaihohohenko.TorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class ShiharaiHohoHenkoDac implements IModifiable<DbT4021ShiharaiHohoHenkoEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT4021ShiharaiHohoHenkoDac 支払方法変更Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
    private static final RString 番号 = new RString("被保険者番号");

    /**
     * 支払方法変更情報をキー検索で１件返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @return ShiharaiHohoHenkoModel
     */
    @Transaction
    public Optional<DbT4021ShiharaiHohoHenkoEntity> selectByKey(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号) {

        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(番号.toString()));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));

        return Optional.ofNullable(支払方法変更Dac.selectByKey(証記載保険者番号, 被保険者番号, 管理区分, 履歴番号));
    }

    /**
     * 支払方法変更のリストを返します。
     *
     * @return List<ShiharaiHohoHenkoModel>
     */
    @Transaction
    public IItemList<DbT4021ShiharaiHohoHenkoEntity> selectAll() {

        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = 支払方法変更Dac.selectAll();
        return ItemList.of(支払方法変更List);
    }

    /**
     * 支払方法変更情報の2号差止に該当する履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<ShiharaiHohoHenkoModel>
     */
    @Transaction
    public IItemList<DbT4021ShiharaiHohoHenkoEntity> select2号差止履歴(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(DbT4021ShiharaiHohoHenko.kanriKubun, KanriKubun.ニ号差止.code()),
                                eq(DbT4021ShiharaiHohoHenko.torokuKubun, TorokuKubun.二号差止登録.code()),
                                eq(DbT4021ShiharaiHohoHenko.isDeleted, false),
                                eq(DbT4021ShiharaiHohoHenko.hihokenshaNo, 被保険者番号))).
                order(by(DbT4021ShiharaiHohoHenko.rirekiNo, Order.DESC)).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
        return ItemList.of(支払方法変更List);
    }

    /**
     * 支払方法変更情報の1号償還払化に該当する履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return ShiharaiHohoHenkoModel
     */
    @Transaction
    public IItemList<DbT4021ShiharaiHohoHenkoEntity> select1号償還払化履歴(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(DbT4021ShiharaiHohoHenko.kanriKubun, KanriKubun.一号償還払い化.code()),
                                eq(DbT4021ShiharaiHohoHenko.torokuKubun, TorokuKubun.一号償還払い化登録.code()),
                                eq(DbT4021ShiharaiHohoHenko.isDeleted, false),
                                eq(DbT4021ShiharaiHohoHenko.hihokenshaNo, 被保険者番号))).
                order(by(DbT4021ShiharaiHohoHenko.rirekiNo, Order.DESC)).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
        return ItemList.of(支払方法変更List);
    }

    /**
     * 支払方法変更情報の1号減額に該当する履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return ShiharaiHohoHenkoModel
     */
    @Transaction
    public IItemList<DbT4021ShiharaiHohoHenkoEntity> select1号減額履歴(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(DbT4021ShiharaiHohoHenko.kanriKubun, KanriKubun.一号給付額減額.code()),
                                eq(DbT4021ShiharaiHohoHenko.torokuKubun, TorokuKubun.一号給付額減額登録.code()),
                                eq(DbT4021ShiharaiHohoHenko.isDeleted, false),
                                eq(DbT4021ShiharaiHohoHenko.hihokenshaNo, 被保険者番号))).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);

        return ItemList.of(支払方法変更List);
    }

    @Override
    public int insert(DbT4021ShiharaiHohoHenkoEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 支払方法変更Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(DbT4021ShiharaiHohoHenkoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 支払方法変更Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(DbT4021ShiharaiHohoHenkoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 支払方法変更Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data ShiharaiHohoHenkoModel
     * @return int 件数
     */
    public int deletePhysical(DbT4021ShiharaiHohoHenkoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 支払方法変更Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
