/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakujikosakuseimeisai;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseigokei.KyotakuKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseitankinyushoriyonissu.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.kyotakukeikakujikosakuseimeisai.IKyotakuKeikakuJikosakuseiMeisaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakujikosakuseigokei.KyotakuKeikakuJikoSakuseiGokeiManager;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakujikosakuseitankinyushoriyonissu.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成明細を管理するクラスです。
 */
public class KyotakuKeikakuJikosakuseiMeisaiManager {

    private final MapperProvider mapperProvider;
    private final DbT3008KyotakuKeikakuJikosakuseiMeisaiDac 居宅給付計画自己作成明細Dac;
    private final KyotakuKeikakuJikoSakuseiGokeiManager 居宅給付計画自己作成合計Manager;
    private final KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager 居宅給付計画自己作成短期入所利用日数Manager;

    /**
     * コンストラクタです。
     */
    KyotakuKeikakuJikosakuseiMeisaiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.居宅給付計画自己作成明細Dac = InstanceProvider.create(DbT3008KyotakuKeikakuJikosakuseiMeisaiDac.class);
        this.居宅給付計画自己作成合計Manager = new KyotakuKeikakuJikoSakuseiGokeiManager();
        this.居宅給付計画自己作成短期入所利用日数Manager = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 居宅給付計画自己作成明細Dac 居宅給付計画自己作成明細Dac
     * @param 居宅給付計画自己作成合計Manager 居宅給付計画自己作成合計Manager
     * @param 居宅給付計画自己作成短期入所利用日数Manager 居宅給付計画自己作成短期入所利用日数Manager
     */
    KyotakuKeikakuJikosakuseiMeisaiManager(
            MapperProvider mapperProvider,
            DbT3008KyotakuKeikakuJikosakuseiMeisaiDac 居宅給付計画自己作成明細Dac,
            KyotakuKeikakuJikoSakuseiGokeiManager 居宅給付計画自己作成合計Manager,
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager 居宅給付計画自己作成短期入所利用日数Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.居宅給付計画自己作成明細Dac = 居宅給付計画自己作成明細Dac;
        this.居宅給付計画自己作成合計Manager = 居宅給付計画自己作成合計Manager;
        this.居宅給付計画自己作成短期入所利用日数Manager = 居宅給付計画自己作成短期入所利用日数Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuJikosakuseiMeisaiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuJikosakuseiMeisaiManager}のインスタンス
     */
    public static KyotakuKeikakuJikosakuseiMeisaiManager createInstance() {
        return InstanceProvider.create(KyotakuKeikakuJikosakuseiMeisaiManager.class);
    }

    /**
     * 主キーに合致する居宅給付計画自己作成明細を返します。
     *
     * @param 居宅給付計画自己作成明細検索条件 居宅給付計画自己作成明細検索条件
     * @return KyotakuKeikakuJikosakuseiMeisai nullが返る可能性があります。
     */
    @Transaction
    public KyotakuKeikakuJikosakuseiMeisai get居宅給付計画自己作成明細(KyotakuKeikakuJikosakuseiMeisaiMapperParameter 居宅給付計画自己作成明細検索条件) {
        requireNonNull(居宅給付計画自己作成明細検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成明細検索条件"));
        IKyotakuKeikakuJikosakuseiMeisaiMapper mapper = mapperProvider.create(IKyotakuKeikakuJikosakuseiMeisaiMapper.class);

        KyotakuKeikakuJikosakuseiMeisaiEntity relateEntity = mapper.select居宅給付計画自己作成明細ByKey(居宅給付計画自己作成明細検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KyotakuKeikakuJikosakuseiMeisai(relateEntity);
    }

    /**
     * 居宅給付計画自己作成明細{@link KyotakuKeikakuJikosakuseiMeisai}を保存します。
     *
     * @param 居宅給付計画自己作成明細 居宅給付計画自己作成明細
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KyotakuKeikakuJikosakuseiMeisai 居宅給付計画自己作成明細) {
        requireNonNull(居宅給付計画自己作成明細, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成明細"));

        if (!居宅給付計画自己作成明細.hasChanged()) {
            return false;
        }
        居宅給付計画自己作成明細 = 居宅給付計画自己作成明細.modifiedModel();
        save居宅給付計画自己作成合計リスト(居宅給付計画自己作成明細.getKyotakuKeikakuJikoSakuseiGokeiList());
        save居宅給付計画自己作成短期入所利用日数リスト(居宅給付計画自己作成明細.getKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuList());
        return 1 == 居宅給付計画自己作成明細Dac.save(居宅給付計画自己作成明細.toEntity());
    }

    private void save居宅給付計画自己作成合計リスト(List<KyotakuKeikakuJikoSakuseiGokei> 居宅給付計画自己作成合計List) {
        for (KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計 : 居宅給付計画自己作成合計List) {
            居宅給付計画自己作成合計Manager.save居宅給付計画自己作成合計(居宅給付計画自己作成合計);
        }
    }

    private void save居宅給付計画自己作成短期入所利用日数リスト(List<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> 居宅給付計画自己作成短期入所利用日数List) {
        for (KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数 : 居宅給付計画自己作成短期入所利用日数List) {
            居宅給付計画自己作成短期入所利用日数Manager.save居宅給付計画自己作成短期入所利用日数(居宅給付計画自己作成短期入所利用日数);
        }
    }
}
