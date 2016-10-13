/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * ＜中間DB＞高額合算支給決定通知書データentityクラスです。
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanJikofutangakuInfoHoseiTempEntity implements IDbAccessable, Serializable {

    private RString sourceArea;
    private RString kaipejiArea;
    private RString shinseiYMDShiteiMikeisanKubun;
    private RString tyushutuTaishouKubun;

    private RString seiriNo;
    private int rirekiNo1;
    private FlexibleYearMonth jikoFutan_KeisanYM;

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo hokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private int rirekiNo2;

    private RString hokenSeidoCode;
    private RString hokenshaMei;
    private RString kokuho_HihokenshaShoKigo;
    private AtenaKanaMeisho hihokenshaShimeiKana;
    private AtenaMeisho hihokenshaShimei;
    private FlexibleDate umareYMD;
    private Code seibetsuCode;
    private RString shotokuKubun;
    private RString over70_ShotokuKubun;
    private RString jikoFutanSeiriNo;
    private RString koki_HokenshaNo;
    private RString koki_HihokenshaNo;
    private RString kokuho_HokenshaNo;
    private RString kokuho_HihokenshaShoNo;
    private RString kokuho_KojinNo;
    private RString idoKubun;
    private RString hoseiZumiSofuKubun;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private FlexibleDate hihokenshaKaishiYMD;
    private FlexibleDate hihokenshaShuryoYMD;
    private FlexibleDate shinseiYMD;

    private Decimal tounen_04_JikoFutanGaku;
    private Decimal tounen_04_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_04_Under_70KogakuShikyuGaku;
    private Decimal tounen_04_Over_70_74KogakuShikyuGaku;
    private RString tounen_04_Tekiyo;

    private Decimal tounen_05_JikoFutanGaku;
    private Decimal tounen_05_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_05_Under_70KogakuShikyuGaku;
    private Decimal tounen_05_Over_70_74KogakuShikyuGaku;
    private RString tounen_05_Tekiyo;

    private Decimal tounen_06_JikoFutanGaku;
    private Decimal tounen_06_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_06_Under_70KogakuShikyuGaku;
    private Decimal tounen_06_Over_70_74KogakuShikyuGaku;
    private RString tounen_06_Tekiyo;

    private Decimal tounen_07_JikoFutanGaku;
    private Decimal tounen_07_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_07_Under_70KogakuShikyuGaku;
    private Decimal tounen_07_Over_70_74KogakuShikyuGaku;
    private RString tounen_07_Tekiyo;

    private Decimal tounen_08_JikoFutanGaku;
    private Decimal tounen_08_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_08_Under_70KogakuShikyuGaku;
    private Decimal tounen_08_Over_70_74KogakuShikyuGaku;
    private RString tounen_08_Tekiyo;

    private Decimal tounen_09_JikoFutanGaku;
    private Decimal tounen_09_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_09_Under_70KogakuShikyuGaku;
    private Decimal tounen_09_Over_70_74KogakuShikyuGaku;
    private RString tounen_09_Tekiyo;

    private Decimal tounen_10_JikoFutanGaku;
    private Decimal tounen_10_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_10_Under_70KogakuShikyuGaku;
    private Decimal tounen_10_Over_70_74KogakuShikyuGaku;
    private RString tounen_10_Tekiyo;

    private Decimal tounen_11_JikoFutanGaku;
    private Decimal tounen_11_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_11_Under_70KogakuShikyuGaku;
    private Decimal tounen_11_Over_70_74KogakuShikyuGaku;
    private RString tounen_11_Tekiyo;

    private Decimal tounen_12_JikoFutanGaku;
    private Decimal tounen_12_Uchisu_70_74JikoFutanGaku;
    private Decimal tounen_12_Under_70KogakuShikyuGaku;
    private Decimal tounen_12_Over_70_74KogakuShikyuGaku;
    private RString tounen_12_Tekiyo;

    private Decimal yokunen_01_JikoFutanGaku;
    private Decimal yokunen_01_Uchisu_70_74JikoFutanGaku;
    private Decimal yokunen_01_Under_70KogakuShikyuGaku;
    private Decimal yokunen_01_Over_70_74KogakuShikyuGaku;
    private RString yokunen_01_Tekiyo;

    private Decimal yokunen_02_JikoFutanGaku;
    private Decimal yokunen_02_Uchisu_70_74JikoFutanGaku;
    private Decimal yokunen_02_Under_70KogakuShikyuGaku;
    private Decimal yokunen_02_Over_70_74KogakuShikyuGaku;
    private RString yokunen_02_Tekiyo;

    private Decimal yokunen_03_JikoFutanGaku;
    private Decimal yokunen_03_Uchisu_70_74JikoFutanGaku;
    private Decimal yokunen_03_Under_70KogakuShikyuGaku;
    private Decimal yokunen_03_Over_70_74KogakuShikyuGaku;
    private RString yokunen_03_Tekiyo;

    private Decimal yokunen_04_JikoFutanGaku;
    private Decimal yokunen_04_Uchisu_70_74JikoFutanGaku;
    private Decimal yokunen_04_Under_70KogakuShikyuGaku;
    private Decimal yokunen_04_Over_70_74KogakuShikyuGaku;
    private RString yokunen_04_Tekiyo;

    private Decimal yokunen_05_JikoFutanGaku;
    private Decimal yokunen_05_Uchisu_70_74JikoFutanGaku;
    private Decimal yokunen_05_Under_70KogakuShikyuGaku;
    private Decimal yokunen_05_Over_70_74KogakuShikyuGaku;
    private RString yokunen_05_Tekiyo;

    private Decimal yokunen_06_JikoFutanGaku;
    private Decimal yokunen_06_Uchisu_70_74JikoFutanGaku;
    private Decimal yokunen_06_Under_70KogakuShikyuGaku;
    private Decimal yokunen_06_Over_70_74KogakuShikyuGaku;
    private RString yokunen_06_Tekiyo;

    private Decimal yokunen_07_JikoFutanGaku;
    private Decimal yokunen_07_Uchisu_70_74JikoFutanGaku;
    private Decimal yokunen_07_Under_70KogakuShikyuGaku;
    private Decimal yokunen_07_Over_70_74KogakuShikyuGaku;
    private RString yokunen_07_Tekiyo;
    private Decimal gokei_JikoFutanGaku;
    private Decimal gokei_70_74JikoFutanGaku;
    private Decimal gokei_Under70KogakuShikyuGaku;
    private Decimal gokei_70_74KogakuShikyuGaku;

    private Decimal tounen_04_sumi_JikoFutanGaku;
    private Decimal tounen_04_sumi_70_74JikoFutanGaku;
    private Decimal tounen_04_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_04_sumi_70_74KogakuShikyuGaku;
    private RString tounen_04_sumi_Tekiyo;

    private Decimal tounen_05_sumi_JikoFutanGaku;
    private Decimal tounen_05_sumi_70_74JikoFutanGaku;
    private Decimal tounen_05_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_05_sumi_70_74KogakuShikyuGaku;
    private RString tounen_05_sumi_Tekiyo;

    private Decimal tounen_06_sumi_JikoFutanGaku;
    private Decimal tounen_06_sumi_70_74JikoFutanGaku;
    private Decimal tounen_06_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_06_sumi_70_74KogakuShikyuGaku;
    private RString tounen_06_sumi_Tekiyo;

    private Decimal tounen_07_sumi_JikoFutanGaku;
    private Decimal tounen_07_sumi_70_74JikoFutanGaku;
    private Decimal tounen_07_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_07_sumi_70_74KogakuShikyuGaku;
    private RString tounen_07_sumi_Tekiyo;

    private Decimal tounen_08_sumi_JikoFutanGaku;
    private Decimal tounen_08_sumi_70_74JikoFutanGaku;
    private Decimal tounen_08_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_08_sumi_70_74KogakuShikyuGaku;
    private RString tounen_08_sumi_Tekiyo;

    private Decimal tounen_09_sumi_JikoFutanGaku;
    private Decimal tounen_09_sumi_70_74JikoFutanGaku;
    private Decimal tounen_09_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_09_sumi_70_74KogakuShikyuGaku;
    private RString tounen_09_sumi_Tekiyo;

    private Decimal tounen_10_sumi_JikoFutanGaku;
    private Decimal tounen_10_sumi_70_74JikoFutanGaku;
    private Decimal tounen_10_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_10_sumi_70_74KogakuShikyuGaku;
    private RString tounen_10_sumi_Tekiyo;

    private Decimal tounen_11_sumi_JikoFutanGaku;
    private Decimal tounen_11_sumi_70_74JikoFutanGaku;
    private Decimal tounen_11_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_11_sumi_70_74KogakuShikyuGaku;
    private RString tounen_11_sumi_Tekiyo;

    private Decimal tounen_12_sumi_JikoFutanGaku;
    private Decimal tounen_12_sumi_70_74JikoFutanGaku;
    private Decimal tounen_12_sumi_under_70KogakuShikyuGaku;
    private Decimal tounen_12_sumi_70_74KogakuShikyuGaku;
    private RString tounen_12_sumi_Tekiyo;

    private Decimal yokunen_01_sumi_JikoFutanGaku;
    private Decimal yokunen_01_sumi_70_74JikoFutanGaku;
    private Decimal yokunen_01_sumi_under_70KogakuShikyuGaku;
    private Decimal yokunen_01_sumi_70_74KogakuShikyuGaku;
    private RString yokunen_01_sumi_Tekiyo;

    private Decimal yokunen_02_sumi_JikoFutanGaku;
    private Decimal yokunen_02_sumi_70_74JikoFutanGaku;
    private Decimal yokunen_02_sumi_under_70KogakuShikyuGaku;
    private Decimal yokunen_02_sumi_70_74KogakuShikyuGaku;
    private RString yokunen_02_sumi_Tekiyo;

    private Decimal yokunen_03_sumi_JikoFutanGaku;
    private Decimal yokunen_03_sumi_70_74JikoFutanGaku;
    private Decimal yokunen_03_sumi_under_70KogakuShikyuGaku;
    private Decimal yokunen_03_sumi_70_74KogakuShikyuGaku;
    private RString yokunen_03_sumi_Tekiyo;

    private Decimal yokunen_04_sumi_JikoFutanGaku;
    private Decimal yokunen_04_sumi_70_74JikoFutanGaku;
    private Decimal yokunen_04_sumi_under_70KogakuShikyuGaku;
    private Decimal yokunen_04_sumi_70_74KogakuShikyuGaku;
    private RString yokunen_04_sumi_Tekiyo;

    private Decimal yokunen_05_sumi_JikoFutanGaku;
    private Decimal yokunen_05_sumi_70_74JikoFutanGaku;
    private Decimal yokunen_05_sumi_under_70KogakuShikyuGaku;
    private Decimal yokunen_05_sumi_70_74KogakuShikyuGaku;
    private RString yokunen_05_sumi_Tekiyo;

    private Decimal yokunen_06_sumi_JikoFutanGaku;
    private Decimal yokunen_06_sumi_70_74JikoFutanGaku;
    private Decimal yokunen_06_sumi_under_70KogakuShikyuGaku;
    private Decimal yokunen_06_sumi_70_74KogakuShikyuGaku;
    private RString yokunen_06_sumi_Tekiyo;

    private Decimal yokunen_07_sumi_JikoFutanGaku;
    private Decimal yokunen_07_sumi_70_74JikoFutanGaku;
    private Decimal yokunen_07_sumi_under_70KogakuShikyuGaku;
    private Decimal yokunen_07_sumi_70_74KogakuShikyuGaku;
    private RString yokunen_07_sumi_Tekiyo;

    private Decimal sumi_Gokei_JikoFutanGaku;
    private Decimal sumi_Gokei_70_74JikoFutanGaku;
    private Decimal sumi_Gokei_Under70KogakuShikyuGaku;
    private Decimal sumi_Gokei_70_74KogakuShikyuGaku;

    private AtenaMeisho atesakiShimei;
    private YubinNo atesakiYubinNo;
    private RString atesakiJusho;

    private RString madoguchi_TaishoshaHanteiCode;
    private RString shiharaiBasho;
    private FlexibleDate shikaraiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString shikaraiKaishiYMD_Yoobi;
    private RString shiharaiShuryoYMD_Yoobi;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;

    private RString biko;

    private RString dataSakuseiKubun;
    private FlexibleYearMonth kakunin_UketoriYM;
    private FlexibleYearMonth hoseiZumi_SofuYM;
    private FlexibleYearMonth shomeisho_UketoriYM;
    private RString saisoFlag;
    private RString sofuTaishoGaiFlag;
    private FlexibleDate jikoFutanKeisanYMD;
    private FlexibleDate shomeiShoSakuseiYMD;
    private RString koki_KokuhoShoriKubun;
    private RString jikoFutangakuShomeishoRealHakkoFlag;
    private FlexibleDate batchHoseiJissiYMD;
    private FlexibleDate realHoseiJissiYMD;

    private RString juminShubetsuCode;
    private LasdecCode shichosonCode;
    private YubinNo yubinNo;
    private ZenkokuJushoCode zenkokuJushoCode;
    private GyoseikuCode gyoseikuCode;
    private RString ichiranBiko;
    private RString jikoFutanGakuHoseiJissi;
    private RString kogakuShikyuGakuGakuHoseiJissi;
    private RString ichiranKakuninKubun;
    private RString ichiranKakuninKubun2;
}
