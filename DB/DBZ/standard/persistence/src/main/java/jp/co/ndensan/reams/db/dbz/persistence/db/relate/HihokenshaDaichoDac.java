/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 被保険者台帳のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class HihokenshaDaichoDac implements IModifiable<DbT1001HihokenshaDaichoEntity> {

    private static final RString SHICHOUSON_CODE = new RString("市町村コード");
    private static final RString HIHOKENSHA_NO = new RString("被保険者番号");
    @InjectSession
    private SqlSession session;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);

    /**
     * 被保険者台帳をキー検索で１件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @return {@code Optional<DbT1001HihokenshaDaichoEntity>}
     */
    @Transaction
    public Optional<DbT1001HihokenshaDaichoEntity> select被保険者台帳ByKey(HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(HIHOKENSHA_NO.toString()));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        return Optional.ofNullable(createModel(被保険者台帳Dac.selectByKey(被保険者番号, 異動日, 枝番)));
    }

    /**
     * 被保険者台帳を全件返します。
     *
     * @return {@code IItemList<DbT1001HihokenshaDaichoEntity>}
     */
    @Transaction
    public IItemList<DbT1001HihokenshaDaichoEntity> selectAll() {

        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = 被保険者台帳Dac.selectAll();
        List<DbT1001HihokenshaDaichoEntity> list = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            list.add(createModel(被保険者台帳));
        }
        IItemList<DbT1001HihokenshaDaichoEntity> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 条件に合致する被保険者台帳のリストを返します。
     *
     * @param 市町村コード 市町村コード
     * @return IItemList<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public IItemList<DbT1001HihokenshaDaichoEntity> select被保険者台帳一覧(LasdecCode 市町村コード) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(SHICHOUSON_CODE.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(DbT1001HihokenshaDaicho.shichosonCode, 市町村コード)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        List<DbT1001HihokenshaDaichoEntity> list = new ArrayList<>();

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
     * @return {@code IItemList<DbT1001HihokenshaDaichoEntity>}
     */
    @Transaction
    public IItemList<DbT1001HihokenshaDaichoEntity> select被保険者台帳一覧(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(SHICHOUSON_CODE.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(HIHOKENSHA_NO.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(DbT1001HihokenshaDaicho.shichosonCode, 市町村コード), eq(DbT1001HihokenshaDaicho.hihokenshaNo, 被保険者番号))).
                toList(DbT1001HihokenshaDaichoEntity.class);

        List<DbT1001HihokenshaDaichoEntity> list = new ArrayList<>();

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
     * @return {@code IItemList<DbT1001HihokenshaDaichoEntity>}
     */
    @Transaction
    public IItemList<DbT1001HihokenshaDaichoEntity> select被保険者台帳一覧DescOrderByShoriTimestamp(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(SHICHOUSON_CODE.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(HIHOKENSHA_NO.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(DbT1001HihokenshaDaicho.shichosonCode, 市町村コード), eq(DbT1001HihokenshaDaicho.hihokenshaNo, 被保険者番号))).
                order(by(DbT1001HihokenshaDaicho.idoYMD, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        List<DbT1001HihokenshaDaichoEntity> list = new ArrayList<>();

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
     * @return {@code Optional<DbT1001HihokenshaDaichoEntity>}
     */
    @Transaction
    public Optional<DbT1001HihokenshaDaichoEntity> select最新被保険者台帳(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(SHICHOUSON_CODE.toString()));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(DbT1001HihokenshaDaicho.shichosonCode, 市町村コード), eq(DbT1001HihokenshaDaicho.shikibetsuCode, 識別コード))).
                order(by(DbT1001HihokenshaDaicho.idoYMD, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        return Optional.ofNullable(!被保険者台帳List.isEmpty() ? createModel(被保険者台帳List.get(0)) : null);
    }

    /**
     * 条件に合致する最新被保険者台帳を１件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@code Optional<DbT1001HihokenshaDaichoEntity>}
     */
    @Transaction
    public Optional<DbT1001HihokenshaDaichoEntity> select最新被保険者台帳(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(HIHOKENSHA_NO.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(DbT1001HihokenshaDaicho.hihokenshaNo, 被保険者番号)).
                order(by(DbT1001HihokenshaDaicho.idoYMD, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        return Optional.ofNullable(!被保険者台帳List.isEmpty() ? createModel(被保険者台帳List.get(0)) : null);
    }

    private DbT1001HihokenshaDaichoEntity createModel(DbT1001HihokenshaDaichoEntity 被保険者台帳エンティティ) {
        if (被保険者台帳エンティティ == null) {
            return null;
        }
        return new DbT1001HihokenshaDaichoEntity();
    }

    @Override
    public int insert(DbT1001HihokenshaDaichoEntity data) {
        if (data == null) {
            return 0;
        }
        return 被保険者台帳Dac.save(data);
    }

    @Override
    public int update(DbT1001HihokenshaDaichoEntity data) {
        if (data == null) {
            return 0;
        }
        return 被保険者台帳Dac.save(data);
    }

    @Override
    public int delete(DbT1001HihokenshaDaichoEntity data) {
        if (data == null) {
            return 0;
        }
        return 被保険者台帳Dac.save(data);
    }

    /**
     * 物理削除を行います。
     *
     * @param data DbT1001HihokenshaDaichoEntity
     * @return int 件数
     */
    public int deletePhysical(DbT1001HihokenshaDaichoEntity data) {
        if (data == null) {
            return 0;
        }
        return 被保険者台帳Dac.save(data);
    }

}
