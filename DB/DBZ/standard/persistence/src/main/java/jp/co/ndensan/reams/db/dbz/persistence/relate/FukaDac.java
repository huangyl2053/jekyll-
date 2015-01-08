/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.model.FukaModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

// TODO N8156 宮本 康 別ブランチで対応中。マージ時にメソッドを追加する。
/**
 * 介護賦課のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class FukaDac implements IModifiable<FukaModel> {

    @InjectSession
    private SqlSession session;
    private final DbT2002FukaDac 介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);

    /**
     * 介護賦課をキー検索で１件返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @return IOptional<FukaModel>
     */
    @Transaction
    public IOptional<FukaModel> select介護賦課ByKey(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return DbOptional.ofNullable(createModel(介護賦課Dac.selectByKey(調定年度, 賦課年度, 通知書番号, 処理日時)));
    }

    /**
     * 条件に合致する介護賦課のリストを返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<FukaModel> select介護賦課一覧(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.choteiNendo, 調定年度), eq(DbT2002Fuka.fukaNendo, 賦課年度), eq(DbT2002Fuka.tsuchishoNo, 通知書番号))).
                toList(DbT2002FukaEntity.class);

        List<FukaModel> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);
    }

    /**
     * 条件に合致する最新介護賦課を１件返します。
     *
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return IOptional<FukaModel>
     */
    @Transaction
    public IOptional<FukaModel> select最新介護賦課(FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.fukaNendo, 賦課年度), eq(DbT2002Fuka.tsuchishoNo, 通知書番号))).
                order(by(DbT2002Fuka.choteiNendo, Order.DESC), by(DbT2002Fuka.shoriTimestamp, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        return DbOptional.ofNullable(!介護賦課List.isEmpty() ? createModel(介護賦課List.get(0)) : null);
    }

    /**
     * 条件に合致する介護賦課のリストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<FukaModel> select介護賦課一覧(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(eq(DbT2002Fuka.hihokenshaNo, 被保険者番号)).
                toList(DbT2002FukaEntity.class);

        List<FukaModel> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);
    }

    /**
     * 条件に合致する介護賦課のリストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<FukaModel> select介護賦課一覧(HihokenshaNo 被保険者番号, FlexibleYear 賦課年度) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.hihokenshaNo, 被保険者番号), eq(DbT2002Fuka.fukaNendo, 賦課年度))).
                toList(DbT2002FukaEntity.class);

        List<FukaModel> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);
    }

    private FukaModel createModel(DbT2002FukaEntity 介護賦課エンティティ) {
        if (介護賦課エンティティ == null) {
            return null;
        }
        return new FukaModel(介護賦課エンティティ);
    }

    @Override
    public int insert(FukaModel data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.insert(data.getEntity());
    }

    @Override
    public int update(FukaModel data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.update(data.getEntity());
    }

    @Override
    public int delete(FukaModel data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.delete(data.getEntity());
    }

    /**
     * 物理削除を行います。
     *
     * @param data FukaModel
     * @return int 件数
     */
    public int deletePhysical(FukaModel data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.deletePhysical(data.getEntity());
    }
}
