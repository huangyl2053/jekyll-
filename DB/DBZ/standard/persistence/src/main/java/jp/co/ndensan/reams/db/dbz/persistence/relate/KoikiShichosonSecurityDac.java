/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurityEntity;
import jp.co.ndensan.reams.db.dbz.model.KoikiShichosonSecurityModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurity.*;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7057KoikiShichosonSecurityDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 広域市町村セキュリティのデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class KoikiShichosonSecurityDac implements IModifiable<KoikiShichosonSecurityModel> {

    @InjectSession
    private SqlSession session;
    private final DbT7057KoikiShichosonSecurityDac 広域市町村セキュリティDac = InstanceProvider.create(DbT7057KoikiShichosonSecurityDac.class);

    /**
     * 広域市町村セキュリティをキー検索で１件返します。
     *
     * @param グループID RString
     * @return {@code Optional<KoikiShichosonSecurityModel>}
     */
    @Transaction
    public Optional<KoikiShichosonSecurityModel> select広域市町村セキュリティByKey(RString グループID) {

        requireNonNull(グループID, UrSystemErrorMessages.値がnull.getReplacedMessage("グループID"));

        return Optional.ofNullable(createModel(広域市町村セキュリティDac.selectByKey(グループID)));
    }

    /**
     * 全合併市町村を取得します。
     *
     * @return {@code IItemList<KoikiShichosonSecurityModel>}
     */
    @Transaction
    public IItemList<KoikiShichosonSecurityModel> selectAll() {
        List<DbT7057KoikiShichosonSecurityEntity> entityList = 広域市町村セキュリティDac.selectAll();
        return getModelList(entityList);
    }

    /**
     * 指定した検索条件に合致する広域市町村セキュリティを取得します。
     *
     * @param 検索条件 検索条件
     * @return {@code IItemList<KoikiShichosonSecurityModel>}
     */
    @Transaction
    public IItemList<KoikiShichosonSecurityModel> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7057KoikiShichosonSecurityEntity> entityList = accessor.
                select().
                table(DbT7057KoikiShichosonSecurity.class).
                where(検索条件).
                order(by(groupID, Order.ASC)).
                toList(DbT7057KoikiShichosonSecurityEntity.class);
        return getModelList(entityList);
    }

    private IItemList<KoikiShichosonSecurityModel> getModelList(List<DbT7057KoikiShichosonSecurityEntity> entityList) {
        List<KoikiShichosonSecurityModel> list = new ArrayList<>();
        for (DbT7057KoikiShichosonSecurityEntity entity : entityList) {
            list.add(new KoikiShichosonSecurityModel(entity));
        }
        return ItemList.of(list);
    }

    private KoikiShichosonSecurityModel createModel(DbT7057KoikiShichosonSecurityEntity 広域市町村セキュリティエンティティ) {
        if (広域市町村セキュリティエンティティ == null) {
            return null;
        }
        return new KoikiShichosonSecurityModel(広域市町村セキュリティエンティティ);
    }

    @Override
    public int insert(KoikiShichosonSecurityModel data) {
        if (data == null) {
            return 0;
        }
        return 広域市町村セキュリティDac.insert(data.getEntity());
    }

    @Override
    public int update(KoikiShichosonSecurityModel data) {
        if (data == null) {
            return 0;
        }
        return 広域市町村セキュリティDac.update(data.getEntity());
    }

    @Override
    public int delete(KoikiShichosonSecurityModel data) {
        if (data == null) {
            return 0;
        }
        return 広域市町村セキュリティDac.delete(data.getEntity());
    }

    /**
     * 物理削除を行います。
     *
     * @param data GappeiJohoModel
     * @return int 件数
     */
    public int deletePhysical(KoikiShichosonSecurityModel data) {
        if (data == null) {
            return 0;
        }
        return 広域市町村セキュリティDac.deletePhysical(data.getEntity());
    }
}
