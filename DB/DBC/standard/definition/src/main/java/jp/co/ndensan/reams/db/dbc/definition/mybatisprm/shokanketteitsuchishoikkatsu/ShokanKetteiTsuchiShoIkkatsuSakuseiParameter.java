/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
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
public final class ShokanKetteiTsuchiShoIkkatsuSakuseiParameter implements IMyBatisParameter {

    private static final RString 印書_1 = new RString("1");
    private static final RString 印書_2 = new RString("2");
    private static final RString 印書_3 = new RString("3");
    private static final RString 抽出モード_1 = new RString("1");
    private static final RString 抽出モード_2 = new RString("2");
    private static final RString 抽出モード_3 = new RString("3");
    private static final RString 決定通知リアル発行区分_発行済 = new RString("1");
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
    private boolean hurikomiYoteiYMDFlag;
    private boolean hakkouYMDFlag;
    private boolean chusyutuUketsukeFlag;
    private boolean chusyutuKetteiFlag;
    private boolean chusyutuKetteiShaUketsukeFlag;
    private boolean yoshiFlag;

    private ShokanKetteiTsuchiShoIkkatsuSakuseiParameter(RString psmShikibetsuTaisho, RString psmAtesaki,
            FlexibleDate hurikomiYoteiYMD, FlexibleDate dataFrom, FlexibleDate dataTo, FlexibleDate hakkoYMD,
            FlexibleYearMonth ketteishaUketsukeYM, RString shikyu, RString hushikyu, RString kozashiharai,
            RString inshoKubun, boolean hurikomiYoteiYMDFlag, boolean hakkouYMDFlag, boolean chusyutuUketsukeFlag,
            boolean chusyutuKetteiFlag, boolean chusyutuKetteiShaUketsukeFlag, boolean yoshiFlag) {

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
        this.hurikomiYoteiYMDFlag = hurikomiYoteiYMDFlag;
        this.hakkouYMDFlag = hakkouYMDFlag;
        this.chusyutuUketsukeFlag = chusyutuUketsukeFlag;
        this.chusyutuKetteiFlag = chusyutuKetteiFlag;
        this.chusyutuKetteiShaUketsukeFlag = chusyutuKetteiShaUketsukeFlag;
        this.yoshiFlag = yoshiFlag;
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
     * @return 償還払い支給（不支給）決定通知書一括作成のMyBatisパラメータ
     */
    public static ShokanKetteiTsuchiShoIkkatsuSakuseiParameter createParam(RString psmShikibetsuTaisho,
            RString psmAtesaki, FlexibleDate hurikomiYoteiYMD, RString chusyuMode, RString insho, FlexibleDate dataFrom,
            FlexibleDate dataTo, FlexibleDate hakkouYMD, FlexibleYearMonth ketteishaUketsukeYM, RString yoshiType) {

        boolean hurikomiYoteiYMDFlag = false;
        boolean hakkouYMDFlag = false;
        boolean chusyutuUketsukeFlag = false;
        boolean chusyutuKetteiFlag = false;
        boolean chusyutuKetteiShaUketsukeFlag = false;
        boolean yoshiFlag = false;
        RString inshoKubun = RString.EMPTY;
        if (hurikomiYoteiYMD != null) {
            hurikomiYoteiYMDFlag = true;
        }
        if (hakkouYMD != null) {
            hakkouYMDFlag = true;
        }
        if (印書_1.equals(insho) || 印書_2.equals(insho)) {
            inshoKubun = 決定通知リアル発行区分_発行済;
        } else if (印書_3.equals(insho)) {
            inshoKubun = 決定通知リアル発行区分_未発行;
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
                ShiharaiHohoKubun.口座払.getコード(), inshoKubun, hurikomiYoteiYMDFlag, hakkouYMDFlag, chusyutuUketsukeFlag,
                chusyutuKetteiFlag, chusyutuKetteiShaUketsukeFlag, yoshiFlag);
    }
}
