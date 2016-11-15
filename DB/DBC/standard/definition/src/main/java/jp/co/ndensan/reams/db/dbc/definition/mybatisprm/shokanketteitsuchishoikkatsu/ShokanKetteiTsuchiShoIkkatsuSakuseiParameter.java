/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書一括作成のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanKetteiTsuchiShoIkkatsuSakuseiParameter extends KozaSearchParameter implements IMyBatisParameter {

    private static final RString 印書_1 = new RString("1");
    private static final RString 印書_3 = new RString("3");
    private static final RString 抽出モード_1 = new RString("1");
    private static final RString 抽出モード_2 = new RString("2");
    private static final RString 抽出モード_3 = new RString("3");
    private static final RString 決定通知リアル発行区分_未発行 = new RString("0");
    private static final RString 用紙タイプ_2 = new RString("2");

    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;
    private FlexibleDate hurikomiYoteiYMD;
    private FlexibleDate dataFrom;
    private FlexibleDate dataTo;
    private FlexibleDate hakkoYMD;
    private FlexibleYearMonth ketteishaUketsukeYM;
    private RString shikyu;
    private RString hushikyu;
    private RString kozashiharai;
    private RString inshoKubun;
    private boolean isInshoKubun3;
    private boolean isRiaruHakko;
    private boolean hurikomiYoteiYMDFlag;
    private boolean hakkouYMDFlag;
    private boolean chusyutuUketsukeFlag;
    private boolean chusyutuKetteiFlag;
    private boolean chusyutuKetteiShaUketsukeFlag;
    private boolean yoshiFlag;
    private IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho1;
    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    private ShokanKetteiTsuchiShoIkkatsuSakuseiParameter(RString psmShikibetsuTaisho, RString psmAtesaki,
            FlexibleDate hurikomiYoteiYMD, FlexibleDate dataFrom, FlexibleDate dataTo, FlexibleDate hakkoYMD,
            FlexibleYearMonth ketteishaUketsukeYM, RString shikyu, RString hushikyu, RString kozashiharai, RString inshoKubun,
            boolean isInshoKubun3, boolean isRiaruHakko, boolean hurikomiYoteiYMDFlag, boolean hakkouYMDFlag,
            boolean chusyutuUketsukeFlag, boolean chusyutuKetteiFlag, boolean chusyutuKetteiShaUketsukeFlag, boolean yoshiFlag,
            IKozaSearchKey key, List<KamokuCode> list, IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho1) {
        super(key, list);
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.hurikomiYoteiYMD = hurikomiYoteiYMD;
        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
        this.hakkoYMD = hakkoYMD;
        this.ketteishaUketsukeYM = ketteishaUketsukeYM;
        this.shikyu = shikyu;
        this.hushikyu = hushikyu;
        this.kozashiharai = kozashiharai;
        this.inshoKubun = inshoKubun;
        this.isRiaruHakko = isRiaruHakko;
        this.isInshoKubun3 = isInshoKubun3;
        this.hurikomiYoteiYMDFlag = hurikomiYoteiYMDFlag;
        this.hakkouYMDFlag = hakkouYMDFlag;
        this.chusyutuUketsukeFlag = chusyutuUketsukeFlag;
        this.chusyutuKetteiFlag = chusyutuKetteiFlag;
        this.chusyutuKetteiShaUketsukeFlag = chusyutuKetteiShaUketsukeFlag;
        this.yoshiFlag = yoshiFlag;
        this.psmShikibetsuTaisho1 = psmShikibetsuTaisho1;
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(psmShikibetsuTaisho1);
    }

    /**
     * 償還払い支給（不支給）決定通知書一括作成のMyBatisパラメータを作成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象
     * @param psmAtesaki 宛先
     * @param hurikomiYoteiYMD 振込予定年月日
     * @param chusyuMode 抽出モード
     * @param insho 印書
     * @param dataFrom 抽出条件日付From
     * @param dataTo 抽出条件日付To
     * @param hakkouYMD 発行年月日
     * @param ketteishaUketsukeYM 決定者受付年月
     * @param yoshiType 用紙タイプ
     * @param key IKozaSearchKey
     * @param list List<KamokuCode>
     * @param psmShikibetsuTaisho1 IShikibetsuTaishoPSMSearchKey
     * @return 償還払い支給（不支給）決定通知書一括作成のMyBatisパラメータ
     */
    public static ShokanKetteiTsuchiShoIkkatsuSakuseiParameter createParam(RString psmShikibetsuTaisho,
            RString psmAtesaki, FlexibleDate hurikomiYoteiYMD, RString chusyuMode, RString insho, FlexibleDate dataFrom,
            FlexibleDate dataTo, FlexibleDate hakkouYMD, FlexibleYearMonth ketteishaUketsukeYM, RString yoshiType,
            IKozaSearchKey key, List<KamokuCode> list, IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho1) {

        boolean hurikomiYoteiYMDFlag = false;
        boolean hakkouYMDFlag = false;
        boolean chusyutuUketsukeFlag = false;
        boolean chusyutuKetteiFlag = false;
        boolean chusyutuKetteiShaUketsukeFlag = false;
        boolean yoshiFlag = false;
        boolean isRiaruHakko = false;
        RString inshoKubun = RString.EMPTY;
        boolean isInshoKubun3 = false;
        if (印書_1.equals(insho)) {
            inshoKubun = 決定通知リアル発行区分_未発行;
            isRiaruHakko = true;
        }
        if (印書_3.equals(insho)) {
            isInshoKubun3 = true;
        }
        if (hurikomiYoteiYMD != null) {
            hurikomiYoteiYMDFlag = true;
        }
        if (hakkouYMD != null) {
            hakkouYMDFlag = true;
        }
        if (抽出モード_1.equals(chusyuMode)) {
            chusyutuUketsukeFlag = true;
        } else if (抽出モード_2.equals(chusyuMode)) {
            chusyutuKetteiFlag = true;
        } else if (抽出モード_3.equals(chusyuMode)) {
            chusyutuKetteiShaUketsukeFlag = true;
        }
        if (用紙タイプ_2.equals(yoshiType)) {
            yoshiFlag = true;
        }

        return new ShokanKetteiTsuchiShoIkkatsuSakuseiParameter(psmShikibetsuTaisho, psmAtesaki, hurikomiYoteiYMD, dataFrom,
                dataTo, hakkouYMD, ketteishaUketsukeYM, ShikyuFushikyuKubun.支給.getコード(), ShikyuFushikyuKubun.不支給.getコード(),
                ShiharaiHohoKubun.口座払.getコード(), inshoKubun, isInshoKubun3, isRiaruHakko, hurikomiYoteiYMDFlag, hakkouYMDFlag,
                chusyutuUketsukeFlag, chusyutuKetteiFlag, chusyutuKetteiShaUketsukeFlag, yoshiFlag, key, list, psmShikibetsuTaisho1);
    }
}
