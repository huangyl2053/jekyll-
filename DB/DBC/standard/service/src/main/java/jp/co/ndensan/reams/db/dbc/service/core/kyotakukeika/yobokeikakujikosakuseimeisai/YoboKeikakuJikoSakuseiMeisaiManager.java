/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.yobokeikakujikosakuseimeisai;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseigokei.YoboKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseitankiriyonissu.YoboKeikakuJikoSakuseiTankiRiyoNissu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.yobokeikakujikosakuseimeisai.IYoboKeikakuJikoSakuseiMeisaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.yobokeikakujikosakuseigokei.YoboKeikakuJikoSakuseiGokeiManager;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.yobokeikakujikosakuseitankiriyonissu.YoboKeikakuJikoSakuseiTankiRiyoNissuManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 予防給付計画自己作成明細を管理するクラスです。
 */
public class YoboKeikakuJikoSakuseiMeisaiManager {

    private final MapperProvider mapperProvider;
    private final DbT3011YoboKeikakuJikoSakuseiMeisaiDac 予防給付計画自己作成明細Dac;
    private final YoboKeikakuJikoSakuseiGokeiManager 予防給付計画自己作成合計Manager;
    private final YoboKeikakuJikoSakuseiTankiRiyoNissuManager 予防給付計画自己作成短期利用日数Manager;

    /**
     * コンストラクタです。
     */
    YoboKeikakuJikoSakuseiMeisaiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.予防給付計画自己作成明細Dac = InstanceProvider.create(DbT3011YoboKeikakuJikoSakuseiMeisaiDac.class);
        this.予防給付計画自己作成合計Manager = new YoboKeikakuJikoSakuseiGokeiManager();
        this.予防給付計画自己作成短期利用日数Manager = new YoboKeikakuJikoSakuseiTankiRiyoNissuManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 予防給付計画自己作成明細Dac 予防給付計画自己作成明細Dac
     * @param 予防給付計画自己作成合計Manager 予防給付計画自己作成合計Manager
     * @param 予防給付計画自己作成短期利用日数Manager 予防給付計画自己作成短期利用日数Manager
     */
    YoboKeikakuJikoSakuseiMeisaiManager(
            MapperProvider mapperProvider,
            DbT3011YoboKeikakuJikoSakuseiMeisaiDac 予防給付計画自己作成明細Dac,
            YoboKeikakuJikoSakuseiGokeiManager 予防給付計画自己作成合計Manager,
            YoboKeikakuJikoSakuseiTankiRiyoNissuManager 予防給付計画自己作成短期利用日数Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.予防給付計画自己作成明細Dac = 予防給付計画自己作成明細Dac;
        this.予防給付計画自己作成合計Manager = 予防給付計画自己作成合計Manager;
        this.予防給付計画自己作成短期利用日数Manager = 予防給付計画自己作成短期利用日数Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YoboKeikakuJikoSakuseiMeisaiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YoboKeikakuJikoSakuseiMeisaiManager}のインスタンス
     */
    public static YoboKeikakuJikoSakuseiMeisaiManager createInstance() {
        return InstanceProvider.create(YoboKeikakuJikoSakuseiMeisaiManager.class);
    }

    /**
     * 主キーに合致する予防給付計画自己作成明細を返します。
     *
     * @param 予防給付計画自己作成明細検索条件 予防給付計画自己作成明細検索条件
     * @return YoboKeikakuJikoSakuseiMeisai nullが返る可能性があります。
     */
    @Transaction
    public YoboKeikakuJikoSakuseiMeisai get予防給付計画自己作成明細(YoboKeikakuJikoSakuseiMeisaiMapperParameter 予防給付計画自己作成明細検索条件) {
        requireNonNull(予防給付計画自己作成明細検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成明細検索条件"));
        IYoboKeikakuJikoSakuseiMeisaiMapper mapper = mapperProvider.create(IYoboKeikakuJikoSakuseiMeisaiMapper.class);

        YoboKeikakuJikoSakuseiMeisaiEntity relateEntity = mapper.select予防給付計画自己作成明細ByKey(予防給付計画自己作成明細検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new YoboKeikakuJikoSakuseiMeisai(relateEntity);
    }

    /**
     * 予防給付計画自己作成明細{@link YoboKeikakuJikoSakuseiMeisai}を保存します。
     *
     * @param 予防給付計画自己作成明細 予防給付計画自己作成明細
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細) {
        requireNonNull(予防給付計画自己作成明細, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成明細"));

        if (!予防給付計画自己作成明細.hasChanged()) {
            return false;
        }
        予防給付計画自己作成明細 = 予防給付計画自己作成明細.modifiedModel();
        save予防給付計画自己作成合計リスト(予防給付計画自己作成明細.getYoboKeikakuJikoSakuseiGokeiList());
        save予防給付計画自己作成短期利用日数リスト(予防給付計画自己作成明細.getYoboKeikakuJikoSakuseiTankiRiyoNissuList());
        return 1 == 予防給付計画自己作成明細Dac.save(予防給付計画自己作成明細.toEntity());
    }

    private void save予防給付計画自己作成合計リスト(List<YoboKeikakuJikoSakuseiGokei> 予防給付計画自己作成合計List) {
        for (YoboKeikakuJikoSakuseiGokei 予防給付計画自己作成合計 : 予防給付計画自己作成合計List) {
            予防給付計画自己作成合計Manager.save予防給付計画自己作成合計(予防給付計画自己作成合計);
        }
    }

    private void save予防給付計画自己作成短期利用日数リスト(List<YoboKeikakuJikoSakuseiTankiRiyoNissu> 予防給付計画自己作成短期利用日数List) {
        for (YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数 : 予防給付計画自己作成短期利用日数List) {
            予防給付計画自己作成短期利用日数Manager.save予防給付計画自己作成短期利用日数(予防給付計画自己作成短期利用日数);
        }
    }
}
