/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kyokaisogaitosha.kyokaisogaitosha;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisohokenryodankai.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisosochishinsei.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kyokaisogaitosha.KyokaisoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1006KyokaisoGaitoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kyokaisogaitosha.IKyokaisoGaitoshaMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.kyokaisogaitosha.kyokaisohokenryodankai.KyokaisoHokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbz.service.core.kyokaisogaitosha.kyokaisosochishinsei.KyokaisoSochiShinseiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層該当者を管理するクラスです。
 *
 * @reamsid_L DBA-9999-013 huangh
 */
public class KyokaisoGaitoshaManager {

    private final MapperProvider mapperProvider;
    private final DbT1006KyokaisoGaitoshaDac 境界層該当者Dac;
    private final KyokaisoHokenryoDankaiManager 境界層保険料段階Manager;
    private final KyokaisoSochiShinseiManager 境界層措置申請Manager;

    /**
     * コンストラクタです。
     */
    KyokaisoGaitoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.境界層該当者Dac = InstanceProvider.create(DbT1006KyokaisoGaitoshaDac.class);
        this.境界層保険料段階Manager = new KyokaisoHokenryoDankaiManager();
        this.境界層措置申請Manager = new KyokaisoSochiShinseiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 境界層該当者Dac 境界層該当者Dac
     * @param 境界層保険料段階Manager 境界層保険料段階Manager
     * @param 境界層措置申請Manager 境界層措置申請Manager
     */
    KyokaisoGaitoshaManager(
            MapperProvider mapperProvider,
            DbT1006KyokaisoGaitoshaDac 境界層該当者Dac,
            KyokaisoHokenryoDankaiManager 境界層保険料段階Manager,
            KyokaisoSochiShinseiManager 境界層措置申請Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.境界層該当者Dac = 境界層該当者Dac;
        this.境界層保険料段階Manager = 境界層保険料段階Manager;
        this.境界層措置申請Manager = 境界層措置申請Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyokaisoGaitoshaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyokaisoGaitoshaManager}のインスタンス
     */
    public static KyokaisoGaitoshaManager createInstance() {
        return InstanceProvider.create(KyokaisoGaitoshaManager.class);
    }

    /**
     * 主キーに合致する境界層該当者を返します。
     *
     * @param 境界層該当者検索条件 境界層該当者検索条件
     * @return KyokaisoGaitosha 【　※ツールの都合上、このカッコ部は手動で削除して下さい 境界層該当者】 nullが返る可能性があります。
     */
    @Transaction
    public KyokaisoGaitosha get境界層該当者(KyokaisoMapperParameter 境界層該当者検索条件) {
        requireNonNull(境界層該当者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層該当者検索条件"));
        IKyokaisoGaitoshaMapper mapper = mapperProvider.create(IKyokaisoGaitoshaMapper.class);

        KyokaisoGaitoshaEntity relateEntity = mapper.select境界層該当者ByKey(境界層該当者検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KyokaisoGaitosha(relateEntity);
    }

    /**
     * 境界層該当者{@link KyokaisoGaitosha}を保存します。
     *
     * @param 境界層該当者 境界層該当者
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KyokaisoGaitosha 境界層該当者) {
        requireNonNull(境界層該当者, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層該当者"));

        if (!境界層該当者.hasChanged()) {
            return false;
        }
        境界層該当者 = 境界層該当者.modifiedModel();
        save境界層保険料段階リスト(境界層該当者.getKyokaisoHokenryoDankaiList());
        save境界層措置申請リスト(境界層該当者.getKyokaisoSochiShinseiList());
        return 1 == 境界層該当者Dac.save(境界層該当者.toEntity());
    }

    private void save境界層保険料段階リスト(List<KyokaisoHokenryoDankai> 境界層保険料段階List) {
        for (KyokaisoHokenryoDankai 境界層保険料段階 : 境界層保険料段階List) {
            境界層保険料段階Manager.save境界層保険料段階(境界層保険料段階);
        }
    }

    private void save境界層措置申請リスト(List<KyokaisoSochiShinsei> 境界層措置申請List) {
        for (KyokaisoSochiShinsei 境界層措置申請 : 境界層措置申請List) {
            境界層措置申請Manager.save境界層措置申請(境界層措置申請);
        }
    }
}
