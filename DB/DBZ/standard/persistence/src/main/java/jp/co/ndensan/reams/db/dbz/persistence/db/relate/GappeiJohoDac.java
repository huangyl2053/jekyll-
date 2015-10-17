/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJoho.*;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 合併情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiJohoDac implements IModifiable<DbT7055GappeiJohoEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT7055GappeiJohoDac 合併情報Dac = InstanceProvider.create(DbT7055GappeiJohoDac.class);

    /**
     * 合併情報をキー検索で１件返します。
     *
     * @param 合併年月日 FlexibleDate
     * @param 地域番号 地域番号
     * @return {@code Optional<GappeiJohoModel>}
     */
    @Transaction
    public Optional<DbT7055GappeiJohoEntity> select合併情報ByKey(FlexibleDate 合併年月日, RString 地域番号) {

        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));

        return Optional.ofNullable(合併情報Dac.selectByKey(合併年月日, 地域番号));
    }

    /**
     * 全合併情報を取得します。
     *
     * @return {@code IItemList<GappeiJohoModel>}
     */
    @Transaction
    public IItemList<DbT7055GappeiJohoEntity> selectAll() {
        List<DbT7055GappeiJohoEntity> entityList = 合併情報Dac.selectAll();
        return ItemList.of(entityList);
    }

    /**
     * 指定した検索条件に合致する合併情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return 合併情報リスト
     */
    @Transaction
    public IItemList<DbT7055GappeiJohoEntity> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7055GappeiJohoEntity> entityList = accessor.
                select().
                table(DbT7055GappeiJoho.class).
                where(検索条件).
                order(by(kokuhorenDataFromYMD, Order.ASC)).
                toList(DbT7055GappeiJohoEntity.class);
        return ItemList.of(entityList);
    }

    @Override
    public int insert(DbT7055GappeiJohoEntity data) {
        if (data == null) {
            return 0;
        }
        return 合併情報Dac.insert(data);
    }

    @Override
    public int update(DbT7055GappeiJohoEntity data) {
        if (data == null) {
            return 0;
        }
        return 合併情報Dac.update(data);
    }

    @Override
    public int delete(DbT7055GappeiJohoEntity data) {
        if (data == null) {
            return 0;
        }
        return 合併情報Dac.delete(data);
    }

    /**
     * 物理削除を行います。
     *
     * @param data GappeiJohoModel
     * @return int 件数
     */
    public int deletePhysical(DbT7055GappeiJohoEntity data) {
        if (data == null) {
            return 0;
        }
        return 合併情報Dac.deletePhysical(data);
    }

}
