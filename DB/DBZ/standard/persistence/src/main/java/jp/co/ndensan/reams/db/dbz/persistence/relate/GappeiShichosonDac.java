/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson.*;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 合併市町村のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonDac implements IModifiable<GappeiShichosonModel> {

    @InjectSession
    private SqlSession session;
    private final DbT7056GappeiShichosonDac 合併市町村Dac = InstanceProvider.create(DbT7056GappeiShichosonDac.class);

    /**
     * 合併市町村をキー検索で１件返します。
     *
     * @param 合併年月日 FlexibleDate
     * @param 地域番号 RString
     * @param 旧市町村コード LasdecCode
     * @return {@code Optional<GappeiShichosonModel>}
     */
    @Transaction
    public Optional<IGappeiShichoson> select合併市町村ByKey(FlexibleDate 合併年月日, RString 地域番号, LasdecCode 旧市町村コード) {

        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));

        return Optional.ofNullable(createModel(合併市町村Dac.selectByKey(合併年月日, 地域番号, 旧市町村コード)));
    }

    /**
     * 全合併市町村を取得します。
     *
     * @return {@code IItemList<GappeiShichosonModel>}
     */
    @Transaction
    public IItemList<IGappeiShichoson> selectAll() {
        List<DbT7056GappeiShichosonEntity> entityList = 合併市町村Dac.selectAll();
        return getModelList(entityList);
    }

    /**
     * 指定した検索条件に合致する合併市町村を取得します。
     *
     * @param 検索条件 検索条件
     * @return 合併情報リスト
     */
    @Transaction
    public IItemList<IGappeiShichoson> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7056GappeiShichosonEntity> entityList = accessor.
                select().
                table(DbT7056GappeiShichoson.class).
                where(検索条件).
                order(by(gappeiYMD, Order.ASC)).
                toList(DbT7056GappeiShichosonEntity.class);
        return getModelList(entityList);
    }

    private IItemList<IGappeiShichoson> getModelList(List<DbT7056GappeiShichosonEntity> entityList) {
        List<IGappeiShichoson> list = new ArrayList<>();
        for (DbT7056GappeiShichosonEntity entity : entityList) {
            list.add(new GappeiShichosonModel(entity));
        }
        return ItemList.of(list);
    }

    private IGappeiShichoson createModel(DbT7056GappeiShichosonEntity 合併市町村エンティティ) {
        if (合併市町村エンティティ == null) {
            return null;
        }
        return new GappeiShichosonModel(合併市町村エンティティ);
    }

    @Override
    public int insert(GappeiShichosonModel data) {
        if (data == null) {
            return 0;
        }
        return 合併市町村Dac.insert(data.getEntity());
    }

    @Override
    public int update(GappeiShichosonModel data) {
        if (data == null) {
            return 0;
        }
        return 合併市町村Dac.update(data.getEntity());
    }

    @Override
    public int delete(GappeiShichosonModel data) {
        if (data == null) {
            return 0;
        }
        return 合併市町村Dac.delete(data.getEntity());
    }

    /**
     * 物理削除を行います。
     *
     * @param data GappeiJohoModel
     * @return int 件数
     */
    public int deletePhysical(GappeiShichosonModel data) {
        if (data == null) {
            return 0;
        }
        return 合併市町村Dac.deletePhysical(data.getEntity());
    }
}
