/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakujikosakusei;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisai;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.kyotakukeikakujikosakusei.IKyotakuKeikakuJikoSakuseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiManager;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisaiManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成を管理するクラスです。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
public class KyotakuKeikakuJikoSakuseiManager {

    private final MapperProvider mapperProvider;
    private final DbT3007KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac;
    private final KyotakuKeikakuJikosakuseiMeisaiManager 居宅給付計画自己作成明細Manager;
    private final YoboKeikakuJikoSakuseiMeisaiManager 予防給付計画自己作成明細Manager;

    /**
     * コンストラクタです。
     */
    KyotakuKeikakuJikoSakuseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.居宅給付計画自己作成Dac = InstanceProvider.create(DbT3007KyotakuKeikakuJikoSakuseiDac.class);
        this.居宅給付計画自己作成明細Manager = KyotakuKeikakuJikosakuseiMeisaiManager.createInstance();
        this.予防給付計画自己作成明細Manager = YoboKeikakuJikoSakuseiMeisaiManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 居宅給付計画自己作成Dac 居宅給付計画自己作成Dac
     * @param 居宅給付計画自己作成明細Manager 居宅給付計画自己作成明細Manager
     * @param 予防給付計画自己作成明細Manager 予防給付計画自己作成明細Manager
     */
    KyotakuKeikakuJikoSakuseiManager(
            MapperProvider mapperProvider,
            DbT3007KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac,
            KyotakuKeikakuJikosakuseiMeisaiManager 居宅給付計画自己作成明細Manager,
            YoboKeikakuJikoSakuseiMeisaiManager 予防給付計画自己作成明細Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.居宅給付計画自己作成Dac = 居宅給付計画自己作成Dac;
        this.居宅給付計画自己作成明細Manager = 居宅給付計画自己作成明細Manager;
        this.予防給付計画自己作成明細Manager = 予防給付計画自己作成明細Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuJikoSakuseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuJikoSakuseiManager}のインスタンス
     */
    public static KyotakuKeikakuJikoSakuseiManager createInstance() {
        return InstanceProvider.create(KyotakuKeikakuJikoSakuseiManager.class);
    }

    /**
     * 主キーに合致する居宅給付計画自己作成を返します。
     *
     * @param 居宅給付計画自己作成検索条件 居宅給付計画自己作成検索条件
     * @return KyotakuKeikakuJikoSakusei nullが返る可能性があります。
     */
    @Transaction
    public KyotakuKeikakuJikoSakusei get居宅給付計画自己作成(KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件) {
        requireNonNull(居宅給付計画自己作成検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成検索条件"));
        IKyotakuKeikakuJikoSakuseiMapper mapper = mapperProvider.create(IKyotakuKeikakuJikoSakuseiMapper.class);

        KyotakuKeikakuJikoSakuseiEntity relateEntity = mapper.select居宅給付計画自己作成ByKey(居宅給付計画自己作成検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KyotakuKeikakuJikoSakusei(relateEntity);
    }

    /**
     * 居宅給付計画自己作成{@link KyotakuKeikakuJikoSakusei}を保存します。
     *
     * @param 居宅給付計画自己作成 居宅給付計画自己作成
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KyotakuKeikakuJikoSakusei 居宅給付計画自己作成) {
        requireNonNull(居宅給付計画自己作成, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成"));

        if (!居宅給付計画自己作成.hasChanged()) {
            return false;
        }
        居宅給付計画自己作成 = 居宅給付計画自己作成.modifiedModel();
        save居宅給付計画自己作成明細リスト(居宅給付計画自己作成.getKyotakuKeikakuJikosakuseiMeisaiList());
        save予防給付計画自己作成明細リスト(居宅給付計画自己作成.getYoboKeikakuJikoSakuseiMeisaiList());
        return 1 == 居宅給付計画自己作成Dac.save(居宅給付計画自己作成.toEntity());
    }

    /**
     * 居宅給付計画自己作成{@link KyotakuKeikakuJikoSakusei}を保存します。
     *
     * @param 居宅給付計画自己作成 居宅給付計画自己作成
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean saveByForDeletePhysical居宅給付計画自己作成(KyotakuKeikakuJikoSakusei 居宅給付計画自己作成) {
        requireNonNull(居宅給付計画自己作成, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成"));

        if (!居宅給付計画自己作成.hasChanged()) {
            return false;
        }
        居宅給付計画自己作成 = 居宅給付計画自己作成.modifiedModel();
        if (居宅給付計画自己作成.toEntity().getState().equals(EntityDataState.Deleted)) {
            return 1 == 居宅給付計画自己作成Dac.delete(居宅給付計画自己作成.toEntity());
        } else {
            return 1 == 居宅給付計画自己作成Dac.save(居宅給付計画自己作成.toEntity());
        }
    }

    private void save居宅給付計画自己作成明細リスト(List<KyotakuKeikakuJikosakuseiMeisai> 居宅給付計画自己作成明細List) {
        for (KyotakuKeikakuJikosakuseiMeisai 居宅給付計画自己作成明細 : 居宅給付計画自己作成明細List) {
            居宅給付計画自己作成明細Manager.save(居宅給付計画自己作成明細);
        }
    }

    private void save予防給付計画自己作成明細リスト(List<YoboKeikakuJikoSakuseiMeisai> 予防給付計画自己作成明細List) {
        for (YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 : 予防給付計画自己作成明細List) {
            予防給付計画自己作成明細Manager.save(予防給付計画自己作成明細);
        }
    }
}
