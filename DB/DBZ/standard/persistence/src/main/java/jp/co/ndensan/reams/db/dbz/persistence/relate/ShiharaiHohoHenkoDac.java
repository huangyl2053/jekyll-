/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.KanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.TorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.model.ShiharaiHohoHenkoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
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
public class ShiharaiHohoHenkoDac implements IModifiable<ShiharaiHohoHenkoModel> {

    @InjectSession
    private SqlSession session;
    private final DbT4021ShiharaiHohoHenkoDac 支払方法変更Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);

    /**
     * 支払方法変更情報をキー検索で１件返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 処理日時 処理日時
     * @return ShiharaiHohoHenkoModel
     */
    @Transaction
    public IOptional<ShiharaiHohoHenkoModel> selectByKey(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            KanriKubun 管理区分,
            YMDHMS 処理日時) {

        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));

        return DbOptional.ofNullable(createModel(支払方法変更Dac.selectByKey(証記載保険者番号, 被保険者番号, 管理区分.code(), 処理日時)));
    }

    /**
     * 支払方法変更のリストを返します。
     *
     * @return List<ShiharaiHohoHenkoModel>
     */
    @Transaction
    public IItemList<ShiharaiHohoHenkoModel> selectAll() {

        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = 支払方法変更Dac.selectAll();
        List<ShiharaiHohoHenkoModel> list = new ArrayList<>();

        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更 : 支払方法変更List) {
            list.add(createModel(支払方法変更));
        }
        IItemList<ShiharaiHohoHenkoModel> 支払方法リスト = ItemList.of(list);

        return 支払方法リスト;
    }

    /**
     * 支払方法変更情報の2号差止に該当する履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<ShiharaiHohoHenkoModel>
     */
    @Transaction
    public IItemList<ShiharaiHohoHenkoModel> select2号差止履歴(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(DbT4021ShiharaiHohoHenko.kanriKubun, KanriKubun.ニ号差止.code()),
                                eq(DbT4021ShiharaiHohoHenko.torokuKubun, TorokuKubun.二号差止登録.code()),
                                eq(DbT4021ShiharaiHohoHenko.isDeleted, false),
                                eq(DbT4021ShiharaiHohoHenko.hihokenshaNo, 被保険者番号))).
                order(by(DbT4021ShiharaiHohoHenko.shoriTimestamp, Order.DESC)).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);

        List<ShiharaiHohoHenkoModel> list = new ArrayList<>();
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更 : 支払方法変更List) {
            list.add(createModel(支払方法変更));
        }
        IItemList<ShiharaiHohoHenkoModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 支払方法変更情報の1号償還払化に該当する履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return ShiharaiHohoHenkoModel
     */
    @Transaction
    public IItemList<ShiharaiHohoHenkoModel> select1号償還払化履歴(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(DbT4021ShiharaiHohoHenko.kanriKubun, KanriKubun.一号償還払い化.code()),
                                eq(DbT4021ShiharaiHohoHenko.torokuKubun, TorokuKubun.一号償還払い化登録.code()),
                                eq(DbT4021ShiharaiHohoHenko.isDeleted, false),
                                eq(DbT4021ShiharaiHohoHenko.hihokenshaNo, 被保険者番号))).
                order(by(DbT4021ShiharaiHohoHenko.shoriTimestamp, Order.DESC)).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
        List<ShiharaiHohoHenkoModel> list = new ArrayList<>();
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更 : 支払方法変更List) {
            list.add(createModel(支払方法変更));
        }
        IItemList<ShiharaiHohoHenkoModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 支払方法変更情報の1号減額に該当する履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return ShiharaiHohoHenkoModel
     */
    @Transaction
    public IItemList<ShiharaiHohoHenkoModel> select1号減額履歴(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(DbT4021ShiharaiHohoHenko.kanriKubun, KanriKubun.一号給付額減額.code()),
                                eq(DbT4021ShiharaiHohoHenko.torokuKubun, TorokuKubun.一号給付額減額登録.code()),
                                eq(DbT4021ShiharaiHohoHenko.isDeleted, false),
                                eq(DbT4021ShiharaiHohoHenko.hihokenshaNo, 被保険者番号))).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
        List<ShiharaiHohoHenkoModel> list = new ArrayList<>();
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更 : 支払方法変更List) {
            list.add(createModel(支払方法変更));
        }
        IItemList<ShiharaiHohoHenkoModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    private ShiharaiHohoHenkoModel createModel(DbT4021ShiharaiHohoHenkoEntity 支払方法変更エンティティ) {
        if (支払方法変更エンティティ == null) {
            return null;
        }

        return new ShiharaiHohoHenkoModel(支払方法変更エンティティ);
    }

    @Override
    public int insert(ShiharaiHohoHenkoModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 支払方法変更Dac.insert(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(ShiharaiHohoHenkoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 支払方法変更Dac.update(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(ShiharaiHohoHenkoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 支払方法変更Dac.delete(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data ShiharaiHohoHenkoModel
     * @return int 件数
     */
    public int deletePhysical(ShiharaiHohoHenkoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 支払方法変更Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
