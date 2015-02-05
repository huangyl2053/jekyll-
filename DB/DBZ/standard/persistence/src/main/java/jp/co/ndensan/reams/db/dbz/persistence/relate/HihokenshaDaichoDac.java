/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 被保険者台帳のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class HihokenshaDaichoDac implements IModifiable<HihokenshaDaichoModel> {

    @InjectSession
    private SqlSession session;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);

    /**
     * 被保険者台帳をキー検索で１件返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return {@code Optional<HihokenshaDaichoModel>}
     */
    @Transaction
    public Optional<HihokenshaDaichoModel> select被保険者台帳ByKey(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, ShoriTimestamp 処理日時) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return Optional.ofNullable(createModel(被保険者台帳Dac.selectByKey(市町村コード, 被保険者番号, 処理日時)));
    }

    /**
     * 被保険者台帳を全件返します。
     *
     * @return {@code IItemList<HihokenshaDaichoModel>}
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> selectAll() {

        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = 被保険者台帳Dac.selectAll();
        List<HihokenshaDaichoModel> list = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            list.add(createModel(被保険者台帳));
        }
        IItemList<HihokenshaDaichoModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 条件に合致する被保険者台帳のリストを返します。
     *
     * @param 市町村コード 市町村コード
     * @return IItemList<HihokenshaDaichoModel>
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> select被保険者台帳一覧(LasdecCode 市町村コード) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(DbT1001HihokenshaDaicho.shichosonCode, 市町村コード)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        List<HihokenshaDaichoModel> list = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            list.add(createModel(被保険者台帳));
        }

        return ItemList.of(list);
    }

    /**
     * 条件に合致する被保険者台帳のリストを返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return {@code IItemList<HihokenshaDaichoModel>}
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> select被保険者台帳一覧(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(DbT1001HihokenshaDaicho.shichosonCode, 市町村コード), eq(DbT1001HihokenshaDaicho.hihokenshaNo, 被保険者番号))).
                toList(DbT1001HihokenshaDaichoEntity.class);

        List<HihokenshaDaichoModel> list = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            list.add(createModel(被保険者台帳));
        }

        return ItemList.of(list);
    }

    /**
     * 条件に合致する被保険者台帳のリストを返します。返却されるListは処理日時の降順になります。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return {@code IItemList<HihokenshaDaichoModel>}
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> select被保険者台帳一覧DescOrderByShoriTimestamp(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(DbT1001HihokenshaDaicho.shichosonCode, 市町村コード), eq(DbT1001HihokenshaDaicho.hihokenshaNo, 被保険者番号))).
                order(by(DbT1001HihokenshaDaicho.shoriTimestamp, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        List<HihokenshaDaichoModel> list = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            list.add(createModel(被保険者台帳));
        }

        return ItemList.of(list);
    }

    /**
     * 条件に合致する最新被保険者台帳を１件返します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @return {@code Optional<HihokenshaDaichoModel>}
     */
    @Transaction
    public Optional<HihokenshaDaichoModel> select最新被保険者台帳(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(DbT1001HihokenshaDaicho.shichosonCode, 市町村コード), eq(DbT1001HihokenshaDaicho.shikibetsuCode, 識別コード))).
                order(by(DbT1001HihokenshaDaicho.shoriTimestamp, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        return Optional.ofNullable(!被保険者台帳List.isEmpty() ? createModel(被保険者台帳List.get(0)) : null);
    }

    /**
     * 条件に合致する最新被保険者台帳を１件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@code Optional<HihokenshaDaichoModel>}
     */
    @Transaction
    public Optional<HihokenshaDaichoModel> select最新被保険者台帳(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(DbT1001HihokenshaDaicho.hihokenshaNo, 被保険者番号)).
                order(by(DbT1001HihokenshaDaicho.shoriTimestamp, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        return Optional.ofNullable(!被保険者台帳List.isEmpty() ? createModel(被保険者台帳List.get(0)) : null);
    }

    private HihokenshaDaichoModel createModel(DbT1001HihokenshaDaichoEntity 被保険者台帳エンティティ) {
        if (被保険者台帳エンティティ == null) {
            return null;
        }
        return new HihokenshaDaichoModel(被保険者台帳エンティティ);
    }

    @Override
    public int insert(HihokenshaDaichoModel data) {
        if (data == null) {
            return 0;
        }
        return 被保険者台帳Dac.insert(data.getEntity());
    }

    @Override
    public int update(HihokenshaDaichoModel data) {
        if (data == null) {
            return 0;
        }
        return 被保険者台帳Dac.update(data.getEntity());
    }

    @Override
    public int delete(HihokenshaDaichoModel data) {
        if (data == null) {
            return 0;
        }
        return 被保険者台帳Dac.delete(data.getEntity());
    }

    /**
     * 物理削除を行います。
     *
     * @param data HihokenshaDaichoModel
     * @return int 件数
     */
    public int deletePhysical(HihokenshaDaichoModel data) {
        if (data == null) {
            return 0;
        }
        return 被保険者台帳Dac.deletePhysical(data.getEntity());
    }
}
