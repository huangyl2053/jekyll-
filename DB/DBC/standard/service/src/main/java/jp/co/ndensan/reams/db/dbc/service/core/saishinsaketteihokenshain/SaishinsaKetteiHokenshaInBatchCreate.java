/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKetteiHokenshaInCSVGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKetteiHokenshaInCSVHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKetteiHokenshaInCSVMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3063SaishinsaKetteiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3064SaishinsaKetteiMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 再審査決定通知書情報取込BatchCreate
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiHokenshaInBatchCreate {

    private static final char TRIM_MOJI = '"';
    private static final RString 保険者区分 = new RString("1");
    private static final int INDEX = 1;

    /**
     * CSVデータより、一時テーブルエンティティを作成する。
     *
     * @param csvHeadEntity CSVデータヘッダ部
     * @param csvMeisaiEntity CSVデータ明細部
     * @param 連番 連番
     * @return SaishinsaKetteiHokenshaInMeisaiEntity
     */
    public SaishinsaKetteiHokenshaInMeisaiEntity createMeisaiEntity(
            SaishinsaKetteiHokenshaInCSVHeadEntity csvHeadEntity,
            SaishinsaKetteiHokenshaInCSVMeisaiEntity csvMeisaiEntity, Decimal 連番) {
        DbT3064SaishinsaKetteiMeisaiDac 明細Dac = InstanceProvider.create(DbT3064SaishinsaKetteiMeisaiDac.class);
        DbT3064SaishinsaKetteiMeisaiEntity 明細Entity = 明細Dac.selectByKey(new FlexibleYearMonth(
                csvHeadEntity.get取扱年月()), 保険者区分);
        SaishinsaKetteiHokenshaInMeisaiEntity meisaiEntity = new SaishinsaKetteiHokenshaInMeisaiEntity();
        meisaiEntity.setToriatsukaiYM(new FlexibleYearMonth(trim囲み文字(csvHeadEntity.get取扱年月())));
        if (明細Entity == null) {
            meisaiEntity.setRirekiNo(連番.intValue());
        } else {
            meisaiEntity.setRirekiNo(new Decimal(明細Entity.getRirekiNo()).add(連番).intValue());
        }
        meisaiEntity.setJigyoshoNo(new JigyoshaNo(trim囲み文字(csvMeisaiEntity.get事業所番号())));
        meisaiEntity.setJigyoshoName(trim囲み文字(csvMeisaiEntity.get事業所名()));
        meisaiEntity.setHiHokenshaNo(new HihokenshaNo(trim囲み文字(csvMeisaiEntity.get被保険者番号())));
        meisaiEntity.setHiHokenshaName(trim囲み文字(csvMeisaiEntity.get被保険者氏名()));
        meisaiEntity.setServiceTeikyoYM(new FlexibleYearMonth(trim囲み文字(csvMeisaiEntity.getサービス提供年月())));
        meisaiEntity.setServiceShuruiCode(new ServiceShuruiCode(trim囲み文字(csvMeisaiEntity.getサービス種類コード())));
        meisaiEntity.setServiceShuruiName(trim囲み文字(csvMeisaiEntity.getサービス種類名()));
        meisaiEntity.setMoushitateJiyuCode(trim囲み文字(csvMeisaiEntity.get申立事由コード()));
        meisaiEntity.setMoushitateJiyu(trim囲み文字(csvMeisaiEntity.get申立事由()));
        meisaiEntity.setSaishinsaResultCode(trim囲み文字(csvMeisaiEntity.get再審査結果コード()));
        meisaiEntity.setToshoSeikyuTanisu(checkDecimal(csvMeisaiEntity.get当初請求単位数()));
        meisaiEntity.setGenshinSeikyuTanisu(checkDecimal(csvMeisaiEntity.get原番単位数()));
        meisaiEntity.setMoushitateTanisu(checkDecimal(csvMeisaiEntity.get申立単位数()));
        meisaiEntity.setKetteiTanisu(checkDecimal(csvMeisaiEntity.get決定単位数()));
        meisaiEntity.setChoseiTanisu(checkDecimal(csvMeisaiEntity.get調整単位数()));
        meisaiEntity.setHokenshaFutangaku(checkDecimal(csvMeisaiEntity.get保険者負担額()));
        meisaiEntity.setShikibetsuCode(ShikibetsuCode.EMPTY);

        return meisaiEntity;

    }

    /**
     * CSVデータより、一時テーブルエンティティを作成する。
     *
     * @param csvHeadEntity CSVデータヘッダ部
     * @param csvGokeiEntity CSVデータ集計部
     * @return SaishinsaKetteiHokenshaInGokeiEntity
     */
    public SaishinsaKetteiHokenshaInGokeiEntity createGokeiEntity(
            SaishinsaKetteiHokenshaInCSVHeadEntity csvHeadEntity,
            SaishinsaKetteiHokenshaInCSVGokeiEntity csvGokeiEntity) {

        SaishinsaKetteiHokenshaInGokeiEntity gokeiEntity = new SaishinsaKetteiHokenshaInGokeiEntity();
        gokeiEntity.setToriatsukaiYM(new FlexibleYearMonth(trim囲み文字(csvHeadEntity.get取扱年月())));
        DbT3063SaishinsaKetteiShukeiDac 集計Dac = InstanceProvider.create(DbT3063SaishinsaKetteiShukeiDac.class);
        DbT3063SaishinsaKetteiShukeiEntity 集計Entity = 集計Dac.selectByKey(new FlexibleYearMonth(
                csvHeadEntity.get取扱年月()), 保険者区分);
        if (集計Entity == null) {
            gokeiEntity.setRirekiNo(INDEX);
        } else {
            gokeiEntity.setRirekiNo(集計Entity.getRirekiNo().add(Decimal.ONE).intValue());
        }
        gokeiEntity.setKaigoKyufuhiSeikyuKensu(
                checkDecimal(csvGokeiEntity.get介護給付費_請求_件数()));
        gokeiEntity.setKaigoKyufuhiSeikyuTanisu(
                checkDecimal(csvGokeiEntity.get介護給付費_請求_単位数()));
        gokeiEntity.setKaigoKyufuhiSeikyuFutangaku(
                checkDecimal(csvGokeiEntity.get介護給付費_請求_保険者負担額()));
        gokeiEntity.setKaigoKyufuhiKetteiKensu(
                checkDecimal(csvGokeiEntity.get介護給付費_決定_件数()));
        gokeiEntity.setKaigoKyufuhiKetteiTanisu(
                checkDecimal(csvGokeiEntity.get介護給付費_決定_単位数()));
        gokeiEntity.setKaigoKyufuhiKetteiFutangaku(
                checkDecimal(csvGokeiEntity.get介護給付費_決定_保険者負担額()));
        gokeiEntity.setKaigoKyufuhiChoseiKensu(
                checkDecimal(csvGokeiEntity.get介護給付費_調整_件数()));
        gokeiEntity.setKaigoKyufuhiChoseiTanisu(
                checkDecimal(csvGokeiEntity.get介護給付費_調整_単位数()));
        gokeiEntity.setKaigoKyufuhiChoseiFutangaku(
                checkDecimal(csvGokeiEntity.get介護給付費_調整_保険者負担額()));
        gokeiEntity.setKogakuKaigoServicehiSeikyuKensu(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_請求_件数()));
        gokeiEntity.setKogakuKaigoServicehiSeikyuTanisu(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_請求_単位数()));
        gokeiEntity.setKogakuKaigoServicehiSeikyuFutangaku(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_請求_保険者負担額()));
        gokeiEntity.setKogakuKaigoServicehiKetteiKensu(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_決定_件数()));
        gokeiEntity.setKogakuKaigoServicehiKetteiTanisu(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_決定_単位数()));
        gokeiEntity.setKogakuKaigoServicehiKetteiFutangaku(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_決定_保険者負担額()));
        gokeiEntity.setKogakuKaigoServicehiChoseiKensu(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_調整_件数()));
        gokeiEntity.setKogakuKaigoServicehiChoseiTanisu(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_調整_単位数()));
        gokeiEntity.setKogakuKaigoServicehiChoseiFutangaku(
                checkDecimal(csvGokeiEntity.get高額介護サービス費_調整_保険者負担額()));
        gokeiEntity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(trim囲み文字(csvHeadEntity.get証記載保険者番号())));
        gokeiEntity.setShoKisaiHokenshaName(trim囲み文字(csvHeadEntity.get証記載保険者名()));
        gokeiEntity.setSakuseiYMD(new FlexibleDate(trim囲み文字(csvHeadEntity.get作成年月日())));
        gokeiEntity.setKokukoRengoukaiNa(trim囲み文字(csvHeadEntity.get国保連合会名()));
        gokeiEntity.setSinsaiinkaiName(trim囲み文字(csvHeadEntity.get審査委員会名()));

        return gokeiEntity;
    }

    /**
     * trim囲み文字
     *
     * @param 対象文字列 対象文字列
     * @return RString
     */
    public RString trim囲み文字(RString 対象文字列) {

        if (null != 対象文字列 && !RString.EMPTY.equals(対象文字列)) {
            return 対象文字列.trim(TRIM_MOJI);
        }

        return RString.EMPTY;
    }

    private Decimal checkDecimal(RString 金額) {
        if (金額.isNullOrEmpty()) {
            return Decimal.ZERO;
        }

        return new Decimal(金額.toString());
    }

}
