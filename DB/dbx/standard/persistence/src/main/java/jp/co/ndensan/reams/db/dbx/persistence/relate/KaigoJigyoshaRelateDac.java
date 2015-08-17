/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.db.IModifiable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者台帳のデータアクセスクラスです。
 *
 * @author N8187 久保田 英男
 * @jpName
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
public class KaigoJigyoshaRelateDac implements IModifiable<KaigoJigyoshaRelateEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT7060KaigoJigyoshaDac 介護事業者Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
    private final DbT7062KaigoJigyoshaDaihyoshaDac 介護事業者代表者Dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
    private final DbT7063KaigoJigyoshaShiteiServiceDac 介護事業者指定サービスDac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);

    /**
     * 事業者番号に合致する介護事業者台帳のリストを返します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @return List<KaigoJigyoshaRelateEntity>
     */
    @Transaction
    public List<KaigoJigyoshaRelateEntity> selectByJigyoshaNo(KaigoJigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7060KaigoJigyoshaEntity> 介護事業者List = accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(eq(DbT7060KaigoJigyosha.jigyoshaNo, 事業者番号)).
                order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).
                toList(DbT7060KaigoJigyoshaEntity.class);

        List<KaigoJigyoshaRelateEntity> result = new ArrayList<>();
        for (DbT7060KaigoJigyoshaEntity 介護事業者 : 介護事業者List) {
            result.add(createRelateEntity(介護事業者));
        }

        return result;
    }

    private KaigoJigyoshaRelateEntity createRelateEntity(DbT7060KaigoJigyoshaEntity 介護事業者エンティティ) {
        if (介護事業者エンティティ == null) {
            return null;
        }

        return new KaigoJigyoshaRelateEntity(
                介護事業者エンティティ,
                介護事業者代表者Dac.selectByKey(介護事業者エンティティ.getJigyoshaNo(), 介護事業者エンティティ.getYukoKaishiYMD()),
                介護事業者指定サービスDac.selectBy事業者番号(介護事業者エンティティ.getJigyoshaNo()));
    }

    @Override
    public int insert(KaigoJigyoshaRelateEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }
        if (data.get事業者エンティティ() != null) {
            result = 介護事業者Dac.insert(data.get事業者エンティティ());
        }
        if (data.get事業者代表者エンティティ() != null) {
            介護事業者代表者Dac.insert(data.get事業者代表者エンティティ());
        }
        if (data.get事業者指定サービスエンティティリスト() != null) {
            for (DbT7063KaigoJigyoshaShiteiServiceEntity entity : data.get事業者指定サービスエンティティリスト()) {
                介護事業者指定サービスDac.insert(entity);
            }
        }
        return result;
    }

//TODO n3317塚田萌　更新方法が確定したら対応する
    @Override
    public int update(KaigoJigyoshaRelateEntity data) {
        int result = 0;

//        if (data == null) {
//            return result;
//        }
//        if (data.get介護事業者モデル() != null) {
//            result = 介護事業者Dac.update(data.get介護事業者モデル().getEntity());
//        }
//        if (data.get介護事業者代表者モデル() != null) {
//            EntityDataState state = data.get介護事業者代表者モデル().getState();
//            UrT0520KaigoJigyoshaDaihyoshaEntity entity = data.get介護事業者代表者モデル().getEntity();
//            if (state == EntityDataState.Added) {
//                介護事業者代表者Dac.insert(entity);
//            } else if (state == EntityDataState.Modified) {
//                介護事業者代表者Dac.update(entity);
//            } else if (state == EntityDataState.Deleted) {
//                介護事業者代表者Dac.delete(entity);
//            }
//        }
//        if (data.get介護事業者指定サービスモデルList() != null) {
//            for (KaigoJigyoshaShiteiServiceModel model : data.get介護事業者指定サービスモデルList()) {
//                EntityDataState state = model.getState();
//                UrT0521KaigoJigyoshaShiteiServiceEntity entity = model.getEntity();
//                if (state == EntityDataState.Added) {
//                    介護事業者指定サービスDac.insert(entity);
//                } else if (state == EntityDataState.Modified) {
//                    介護事業者指定サービスDac.update(entity);
//                } else if (state == EntityDataState.Deleted) {
//                    介護事業者指定サービスDac.delete(entity);
//                }
//            }
//        }
        return result;
    }

    @Override
    public int delete(KaigoJigyoshaRelateEntity data) {
        int result = 0;

//        if (data == null) {
//            return result;
//        }
//        if (data.get介護事業者モデル() != null) {
//            result = 介護事業者Dac.delete(data.get介護事業者モデル().getEntity());
//        }
//        if (data.get介護事業者代表者モデル() != null) {
//            介護事業者代表者Dac.delete(data.get介護事業者代表者モデル().getEntity());
//        }
//        if (data.get介護事業者指定サービスモデルList() != null) {
//            for (KaigoJigyoshaShiteiServiceModel model : data.get介護事業者指定サービスモデルList()) {
//                介護事業者指定サービスDac.delete(model.getEntity());
//            }
//        }
        return result;
    }
}
