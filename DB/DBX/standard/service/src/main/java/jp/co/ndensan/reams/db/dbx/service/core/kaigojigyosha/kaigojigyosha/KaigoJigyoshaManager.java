/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyosha;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigojigyosha.KaigoJigyoshaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.kaigojigyosha.IKaigoJigyoshaMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaManager;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者を管理するクラスです。
 */
public class KaigoJigyoshaManager {

    private final MapperProvider mapperProvider;
    private final DbT7060KaigoJigyoshaDac 介護事業者Dac;
    private final KaigoJigyoshaDaihyoshaManager 介護事業者代表者Manager;
    private final KaigoJigyoshaShiteiServiceManager 介護事業者指定サービスManager;

    /**
     * コンストラクタです。
     */
    KaigoJigyoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護事業者Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.介護事業者代表者Manager = new KaigoJigyoshaDaihyoshaManager();
        this.介護事業者指定サービスManager = new KaigoJigyoshaShiteiServiceManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護事業者Dac 介護事業者Dac
     * @param 介護事業者代表者Manager 介護事業者代表者Manager
     * @param 介護事業者指定サービスManager 介護事業者指定サービスManager
     */
    KaigoJigyoshaManager(
            MapperProvider mapperProvider,
            DbT7060KaigoJigyoshaDac 介護事業者Dac,
            KaigoJigyoshaDaihyoshaManager 介護事業者代表者Manager,
            KaigoJigyoshaShiteiServiceManager 介護事業者指定サービスManager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護事業者Dac = 介護事業者Dac;
        this.介護事業者代表者Manager = 介護事業者代表者Manager;
        this.介護事業者指定サービスManager = 介護事業者指定サービスManager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaManager}のインスタンス
     */
    public static KaigoJigyoshaManager createInstance() {
        return InstanceProvider.create(KaigoJigyoshaManager.class);
    }

    /**
     * 主キーに合致する介護事業者を返します。
     *
     * @param 介護事業者検索条件 介護事業者検索条件
     * @return KaigoJigyosha nullが返る可能性があります。
     */
    @Transaction
    public KaigoJigyosha get介護事業者(KaigoJigyoshaMapperParameter 介護事業者検索条件) {
        requireNonNull(介護事業者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者検索条件"));
        IKaigoJigyoshaMapper mapper = mapperProvider.create(IKaigoJigyoshaMapper.class);

        KaigoJigyoshaEntity relateEntity = mapper.getKaigoJigyoshaEntity(介護事業者検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KaigoJigyosha(relateEntity);
    }

    /**
     * 介護事業者{@link KaigoJigyosha}を保存します。
     *
     * @param 介護事業者 介護事業者
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KaigoJigyosha 介護事業者) {
        requireNonNull(介護事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));

        if (!介護事業者.hasChanged()) {
            return false;
        }
        介護事業者 = 介護事業者.modifiedModel();
        save介護事業者代表者リスト(介護事業者.getKaigoJigyoshaDaihyoshaList());
        save介護事業者指定サービスリスト(介護事業者.getKaigoJigyoshaShiteiServiceList());
        return 1 == 介護事業者Dac.save(介護事業者.toEntity());
    }

    private void save介護事業者代表者リスト(List<KaigoJigyoshaDaihyosha> 介護事業者代表者List) {
        for (KaigoJigyoshaDaihyosha 介護事業者代表者 : 介護事業者代表者List) {
            介護事業者代表者Manager.save介護事業者代表者(介護事業者代表者);
        }
    }

    private void save介護事業者指定サービスリスト(List<KaigoJigyoshaShiteiService> 介護事業者指定サービスList) {
        for (KaigoJigyoshaShiteiService 介護事業者指定サービス : 介護事業者指定サービスList) {
            介護事業者指定サービスManager.save介護事業者指定サービス(介護事業者指定サービス);
        }
    }
}
