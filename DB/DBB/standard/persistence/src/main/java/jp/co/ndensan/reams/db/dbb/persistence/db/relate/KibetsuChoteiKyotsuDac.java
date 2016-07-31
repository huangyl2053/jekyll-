/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003Kibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.KibetsuChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IPersistable;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護期別調定共通のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class KibetsuChoteiKyotsuDac implements IPersistable<UrT0705ChoteiKyotsuEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT2003KibetsuDac 介護期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
    private final UrT0705ChoteiKyotsuDac 調定共通Dac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);

    /**
     * 介護期別調定共通情報をキー検索で１件返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 徴収方法 徴収方法
     * @param 期 期
     * @return KibetsuChoteiKyotsu
     */
    @Transaction
    public KibetsuChoteiKyotsuEntity select介護期別調定共通ByKey(
            FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, int 履歴番号, RString 徴収方法, int 期) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));

        return createRelateEntity(介護期別Dac.selectByKey(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期));
    }

    /**
     * 引数の条件に合致する介護期別調定共通のリストを返します。。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @return List<KibetsuChoteiKyotsu>
     */
    @Transaction
    public List<KibetsuChoteiKyotsuEntity> select介護期別調定共通一覧(
            FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, int 履歴番号) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2003KibetsuEntity> 介護期別List = accessor.select().
                table(DbT2003Kibetsu.class).
                where(and(
                                eq(DbT2003Kibetsu.choteiNendo, 調定年度),
                                eq(DbT2003Kibetsu.fukaNendo, 賦課年度),
                                eq(DbT2003Kibetsu.tsuchishoNo, 通知書番号),
                                eq(DbT2003Kibetsu.rirekiNo, 履歴番号))).
                toList(DbT2003KibetsuEntity.class);

        List<KibetsuChoteiKyotsuEntity> 期別調定共通リスト = new ArrayList<>();

        for (DbT2003KibetsuEntity 介護期別 : 介護期別List) {
            期別調定共通リスト.add(createRelateEntity(介護期別));
        }

        return 期別調定共通リスト;
    }

    private UrT0705ChoteiKyotsuEntity select調定共通ByKey(Long 調定ID) {
        UrT0705ChoteiKyotsuEntity entity = 調定共通Dac.selectByKey(調定ID);

        return (entity == null) ? null : entity;
    }

    private KibetsuChoteiKyotsuEntity createRelateEntity(DbT2003KibetsuEntity 介護期別エンティティ) {
        if (介護期別エンティティ == null) {
            return null;
        }

        return new KibetsuChoteiKyotsuEntity(
                介護期別エンティティ,
                select調定共通ByKey(介護期別エンティティ.getChoteiId().longValue()));
    }

    @Override
    public int insert(UrT0705ChoteiKyotsuEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

//        if (data.get介護期別モデル() != null) {
//            result = 介護期別Dac.insert(data.get介護期別モデル().getEntity());
//        }
//
//        if (data.get調定共通モデル() != null) {
        調定共通Dac.insert(data);
//        }

        return result;
    }

    @Override
    public int update(UrT0705ChoteiKyotsuEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

//        if (data.get介護期別モデル() != null) {
//            EntityDataState state = data.get介護期別モデル().getState();
//            DbT2003KibetsuEntity entity = data.get介護期別モデル().getEntity();
//            if (state == EntityDataState.Added) {
//                介護期別Dac.insert(entity);
//            } else if (state == EntityDataState.Modified) {
//                介護期別Dac.update(entity);
//            } else if (state == EntityDataState.Deleted) {
//                介護期別Dac.delete(entity);
//            }
//        }
//
//        if (data.get調定共通モデル() != null) {
        EntityDataState state = data.getState();
        UrT0705ChoteiKyotsuEntity entity = data;
        if (state == EntityDataState.Added) {
            調定共通Dac.insert(entity);
        } else if (state == EntityDataState.Modified) {
            調定共通Dac.update(entity);
        } else if (state == EntityDataState.Deleted) {
            調定共通Dac.delete(entity);
        }
//        }

        return result;
    }

    @Override
    public int delete(UrT0705ChoteiKyotsuEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

//        if (data.get介護期別モデル() != null) {
//            result = 介護期別Dac.delete(data.get介護期別モデル().getEntity());
//        }
//
//        if (data.get調定共通モデル() != null) {
        調定共通Dac.delete(data);
//        }

        return result;
    }
}
