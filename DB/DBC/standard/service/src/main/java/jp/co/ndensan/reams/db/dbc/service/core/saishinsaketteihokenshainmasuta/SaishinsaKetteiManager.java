/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshainmasuta;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteihokenshainmasutatoroku.SaishinsaKetteiHokenshaInMasutaTorokuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku.SaiShinsaKetteiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku.SaiShinsaKetteiShukeiTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3063SaishinsaKetteiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3064SaishinsaKetteiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsaketteihokenshainmasutatoroku.ISaishinsaKetteiHokenshaInMasutaTorokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * DBCMNF2002-17x_再審査決定通知書情報取込共通処理（マスタ登録）
 *
 * @reamsid_L DBC-2520-011 sunhui
 */
public class SaishinsaKetteiManager {

    private static final RString 交換情報識別番号_172 = new RString("172");
    private static final RString 交換情報識別番号_652 = new RString("652");
    private static final RString 交換情報識別番号_178 = new RString("178");
    private static final RString 交換情報識別番号_662 = new RString("662");
    private static final RString 再処理区分_1 = new RString("1");
    private final MapperProvider mapperProvider;
    private final DbT3063SaishinsaKetteiShukeiDac 再審査決定集計Dac;
    private final DbT3064SaishinsaKetteiMeisaiDac 再審査決定明細Dac;

    /**
     * コンストラクタです。
     */
    SaishinsaKetteiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        再審査決定集計Dac = InstanceProvider.create(DbT3063SaishinsaKetteiShukeiDac.class);
        再審査決定明細Dac = InstanceProvider.create(DbT3064SaishinsaKetteiMeisaiDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 再審査決定集計Dac DbT3063SaishinsaKetteiShukeiDac
     * @param 再審査決定明細Dac DbT3064SaishinsaKetteiMeisaiDac
     */
    SaishinsaKetteiManager(
            MapperProvider mapperProvider,
            DbT3063SaishinsaKetteiShukeiDac 再審査決定集計Dac,
            DbT3064SaishinsaKetteiMeisaiDac 再審査決定明細Dac) {
        this.mapperProvider = mapperProvider;
        this.再審査決定集計Dac = 再審査決定集計Dac;
        this.再審査決定明細Dac = 再審査決定明細Dac;
    }

    /**
     * コンストラクタです。
     *
     * @return SaishinsaKetteiManager
     */
    public static SaishinsaKetteiManager createInstance() {
        return InstanceProvider.create(SaishinsaKetteiManager.class);
    }

    /**
     * 再審査決定通知書情報取込共通処理（マスタ登録）
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 再処理区分 RString
     * @param 出力順ID Long
     * @param 交換情報識別番号 RString
     */
    public void saishinsaKetteiHokenshaInMasutaToroku(FlexibleYearMonth 処理年月,
            RString 再処理区分, Long 出力順ID, RString 交換情報識別番号) {
        ISaishinsaKetteiHokenshaInMasutaTorokuMapper mapper = mapperProvider.create(ISaishinsaKetteiHokenshaInMasutaTorokuMapper.class);
        SaishinsaKetteiHokenshaInMasutaTorokuMybatisParameter param = new SaishinsaKetteiHokenshaInMasutaTorokuMybatisParameter();

        RString 保険者区分 = get保険者区分(交換情報識別番号);
        if (再処理区分_1.equals(再処理区分)) {
            param.set取込年月(処理年月);
            param.set保険者区分(保険者区分);
            List<DbT3064SaishinsaKetteiMeisaiEntity> 明細テーブルList = 再審査決定明細Dac.selectAllBy(param.get取込年月(), param.get保険者区分());
            List<DbT3063SaishinsaKetteiShukeiEntity> 集計テーブルList = 再審査決定集計Dac.selectAllBy(param.get取込年月(), param.get保険者区分());

            if (明細テーブルList != null) {
                for (DbT3064SaishinsaKetteiMeisaiEntity entity : 明細テーブルList) {
                    entity.setState(EntityDataState.Deleted);
                    再審査決定明細Dac.delete(entity);
                }
            }

            if (集計テーブルList != null) {
                for (DbT3063SaishinsaKetteiShukeiEntity entity : 集計テーブルList) {
                    entity.setState(EntityDataState.Deleted);
                    再審査決定集計Dac.delete(entity);
                }
            }
        }

        List<SaiShinsaKetteiMeisaiTempEntity> 明細List = mapper.getSaiShinsaKetteiMeisaiTempTBLData();
        if (明細List != null) {
            for (SaiShinsaKetteiMeisaiTempEntity 明細Entity : 明細List) {
                insert再審査決定明細(明細Entity, 保険者区分);
            }
        }

        List<SaiShinsaKetteiShukeiTempEntity> 集計List = mapper.getSaiShinsaKetteiShukeiTempTBLData();
        if (集計List != null) {
            for (SaiShinsaKetteiShukeiTempEntity 集計Entity : 集計List) {
                insert再審査決定集計(集計Entity, 保険者区分);
            }
        }
    }

    /**
     * insert再審査決定集計
     *
     * @param entity SaiShinsaKetteiShukeiTempEntity
     * @param 保険者区分 RString
     */
    private void insert再審査決定集計(SaiShinsaKetteiShukeiTempEntity entity, RString 保険者区分) {
        DbT3063SaishinsaKetteiShukeiEntity 再審査決定集計Entity = new DbT3063SaishinsaKetteiShukeiEntity();
        再審査決定集計Entity.setToriatsukaiYM(entity.get取扱年月());
        再審査決定集計Entity.setHokenshaKubun(保険者区分);
        再審査決定集計Entity.setRirekiNo(entity.get履歴番号());
        再審査決定集計Entity.setKaigoKyufuhiSeikyuKensu(entity.get介護給付費_請求_件数());
        再審査決定集計Entity.setKaigoKyufuhiSeikyuTanisu(entity.get介護給付費_請求_単位数());
        再審査決定集計Entity.setKaigoKyufuhiSeikyuFutangaku(entity.get介護給付費_請求_保険者負担額());
        再審査決定集計Entity.setKaigoKyufuhiKetteiKensu(entity.get介護給付費_決定_件数());
        再審査決定集計Entity.setKaigoKyufuhiKetteiTanisu(entity.get介護給付費_決定_単位数());
        再審査決定集計Entity.setKaigoKyufuhiKetteiFutangaku(entity.get介護給付費_決定_保険者負担額());
        再審査決定集計Entity.setKaigoKyufuhiChoseiKensu(entity.get介護給付費_調整_件数());
        再審査決定集計Entity.setKaigoKyufuhiChoseiTanisu(entity.get介護給付費_調整_単位数());
        再審査決定集計Entity.setKaigoKyufuhiChoseiFutangaku(entity.get介護給付費_調整_保険者負担額());
        再審査決定集計Entity.setKogakuKaigoServicehiSeikyuKensu(entity.get高額介護サービス費_請求_件数());
        再審査決定集計Entity.setKogakuKaigoServicehiSeikyuTanisu(entity.get高額介護サービス費_請求_単位数());
        再審査決定集計Entity.setKogakuKaigoServicehiSeikyuFutangaku(entity.get高額介護サービス費_請求_保険者負担額());
        再審査決定集計Entity.setKogakuKaigoServicehiKetteiKensu(entity.get高額介護サービス費_決定_件数());
        再審査決定集計Entity.setKogakuKaigoServicehiKetteiTanisu(entity.get高額介護サービス費_決定_単位数());
        再審査決定集計Entity.setKogakuKaigoServicehiKetteiFutangaku(entity.get高額介護サービス費_決定_保険者負担額());
        再審査決定集計Entity.setKogakuKaigoServicehiChoseiKensu(entity.get介護給付費_調整_件数());
        再審査決定集計Entity.setKogakuKaigoServicehiChoseiTanisu(entity.get高額介護サービス費_調整_単位数());
        再審査決定集計Entity.setKogakuKaigoServicehiChoseiFutangaku(entity.get高額介護サービス費_調整_保険者負担額());
        再審査決定集計Entity.setKohiFutanshaNo(entity.get証記載保険者番号());
        再審査決定集計Entity.setSakuseiYMD(entity.get作成年月日());
        再審査決定集計Entity.setSinsaiinkaiName(entity.get審査委員会名());
        再審査決定集計Entity.setTorikomiYM(entity.get取込年月());

        再審査決定集計Entity.setState(EntityDataState.Added);
        再審査決定集計Dac.save(再審査決定集計Entity);
    }

    /**
     * insert再審査決定明細
     *
     * @param entity SaiShinsaKetteiMeisaiTempEntity
     * @param 保険者区分 RString
     */
    private void insert再審査決定明細(SaiShinsaKetteiMeisaiTempEntity entity, RString 保険者区分) {
        DbT3064SaishinsaKetteiMeisaiEntity 再審査決定明細Entity = new DbT3064SaishinsaKetteiMeisaiEntity();
        再審査決定明細Entity.setToriatsukaiYM(entity.get取扱年月());
        再審査決定明細Entity.setHokenshaKubun(保険者区分);
        再審査決定明細Entity.setRirekiNo(entity.get履歴番号().intValue());
        再審査決定明細Entity.setJigyoshoNo(entity.get事業所番号());
        再審査決定明細Entity.setJigyoshoName(entity.get事業所名());
        再審査決定明細Entity.setHiHokenshaNo(entity.get登録被保険者番号());
        再審査決定明細Entity.setKohiJukyushaNo(entity.get公費受給者番号());
        再審査決定明細Entity.setShokisaiHokenshaNo(entity.get公費証記載保険者番号());
        再審査決定明細Entity.setServiceTeikyoYM(entity.getサービス提供年月());
        再審査決定明細Entity.setServiceShuruiCode(entity.getサービス種類コード());
        再審査決定明細Entity.setServiceShuruiName(entity.getサービス種類名());
        再審査決定明細Entity.setMoushitateJiyuCode(entity.get申立事由コード());
        再審査決定明細Entity.setMoushitateJiyu(entity.get申立事由());
        再審査決定明細Entity.setSaishinsaResultCode(entity.get再審査結果コード());
        再審査決定明細Entity.setToshoSeikyuTanisu(entity.get当初請求単位数());
        再審査決定明細Entity.setGenshinSeikyuTanisu(entity.get原審単位数());
        再審査決定明細Entity.setMoushitateTanisu(entity.get申立単位数());
        再審査決定明細Entity.setKetteiTanisu(entity.get決定単位数());
        再審査決定明細Entity.setChoseiTanisu(entity.get調整単位数());
        再審査決定明細Entity.setHokenshaFutangaku(entity.get保険者負担額());
        再審査決定明細Entity.setTorikomiYM(entity.get取込年月());

        再審査決定明細Entity.setState(EntityDataState.Added);
        再審査決定明細Dac.save(再審査決定明細Entity);
    }

    /**
     * get保険者区分
     *
     * @param 交換情報識別番号 RString
     */
    private RString get保険者区分(RString 交換情報識別番号) {
        RString 保険者区分 = RString.EMPTY;
        if (交換情報識別番号_172.equals(交換情報識別番号)) {
            保険者区分 = new RString("1");
        } else if (交換情報識別番号_652.equals(交換情報識別番号)) {
            保険者区分 = new RString("2");

        } else if (交換情報識別番号_178.equals(交換情報識別番号)) {
            保険者区分 = new RString("3");

        } else if (交換情報識別番号_662.equals(交換情報識別番号)) {
            保険者区分 = new RString("4");
        }
        return 保険者区分;
    }
}
