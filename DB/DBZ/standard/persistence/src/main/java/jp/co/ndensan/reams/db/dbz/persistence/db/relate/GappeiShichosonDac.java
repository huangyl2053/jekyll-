/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichoson.gappeiYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonDac implements IModifiable<DbT7056GappeiShichosonEntity> {

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
    public Optional<DbT7056GappeiShichosonEntity> select合併市町村ByKey(FlexibleDate 合併年月日, RString 地域番号, LasdecCode 旧市町村コード) {

        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));

        return Optional.ofNullable(合併市町村Dac.selectByKey(合併年月日, 地域番号, 旧市町村コード));
    }

    /**
     * 全合併市町村を取得します。
     *
     * @return {@code IItemList<GappeiShichosonModel>}
     */
    @Transaction
    public IItemList<DbT7056GappeiShichosonEntity> selectAll() {
        List<DbT7056GappeiShichosonEntity> entityList = 合併市町村Dac.selectAll();
        return ItemList.of(entityList);
    }

    /**
     * 指定した検索条件に合致する合併市町村を取得します。
     *
     * @param 検索条件 検索条件
     * @return 合併情報リスト
     */
    @Transaction
    public IItemList<DbT7056GappeiShichosonEntity> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7056GappeiShichosonEntity> entityList = accessor.
                select().
                table(DbT7056GappeiShichoson.class).
                where(検索条件).
                order(by(gappeiYMD, Order.ASC)).
                toList(DbT7056GappeiShichosonEntity.class);
        return ItemList.of(entityList);
    }

    @Override
    public int insert(DbT7056GappeiShichosonEntity data) {
        if (data == null) {
            return 0;
        }
        return 合併市町村Dac.save(data);
    }

    @Override
    public int update(DbT7056GappeiShichosonEntity data) {
        if (data == null) {
            return 0;
        }
        return 合併市町村Dac.save(data);
    }

    @Override
    public int delete(DbT7056GappeiShichosonEntity data) {
        if (data == null) {
            return 0;
        }
        data.setState(EntityDataState.Deleted);
        return 合併市町村Dac.save(data);
    }

    /**
     * 物理削除を行います。
     *
     * @param data GappeiJohoModel
     * @return int 件数
     */
    public int deletePhysical(DbT7056GappeiShichosonEntity data) {
        if (data == null) {
            return 0;
        }
        data.setState(EntityDataState.Deleted);
        return 合併市町村Dac.save(data);
    }
}
