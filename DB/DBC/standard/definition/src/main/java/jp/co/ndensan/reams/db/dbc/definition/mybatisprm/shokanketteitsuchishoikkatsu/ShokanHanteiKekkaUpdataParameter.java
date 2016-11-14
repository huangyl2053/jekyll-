/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書一括作成_償還払支給判定結果更新用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanHanteiKekkaUpdataParameter implements IMyBatisParameter {

    private static final RString 印書_1 = new RString("1");
    private static final RString 印書_3 = new RString("3");
    private static final RString 抽出モード_1 = new RString("1");
    private static final RString 抽出モード_2 = new RString("2");
    private static final RString 抽出モード_3 = new RString("3");
    private static final RString 発行しない = new RString("0");
    private static final RString 決定通知リアル発行区分_未発行 = new RString("0");

    private FlexibleDate dataFrom;
    private FlexibleDate dataTo;
    private FlexibleYearMonth ketteishaUketsukeYM;
    private boolean chusyutuUketsukeFlag;
    private boolean chusyutuKetteiFlag;
    private boolean chusyutuKetteiShaUketsukeFlag;
    private boolean isRiaruHakko;
    private boolean isInshoKubun3;
    private RString inshoKubun;
    private boolean isHako;

    private ShokanHanteiKekkaUpdataParameter(FlexibleDate dataFrom, FlexibleDate dataTo, FlexibleYearMonth ketteishaUketsukeYM,
            boolean chusyutuUketsukeFlag, boolean chusyutuKetteiFlag, boolean chusyutuKetteiShaUketsukeFlag,
            boolean isRiaruHakko, boolean isInshoKubun3, RString inshoKubun, boolean isHako) {

        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
        this.ketteishaUketsukeYM = ketteishaUketsukeYM;
        this.chusyutuUketsukeFlag = chusyutuUketsukeFlag;
        this.chusyutuKetteiFlag = chusyutuKetteiFlag;
        this.chusyutuKetteiShaUketsukeFlag = chusyutuKetteiShaUketsukeFlag;
        this.isRiaruHakko = isRiaruHakko;
        this.isInshoKubun3 = isInshoKubun3;
        this.inshoKubun = inshoKubun;
        this.isHako = isHako;
    }

    /**
     * 償還払支給判定結果更新のMyBatisパラメータを作成します。
     *
     * @param chusyuMode 抽出モード
     * @param insho 印書
     * @param dataFrom 抽出条件日付From
     * @param dataTo 抽出条件日付To
     * @param ketteishaUketsukeYM 決定者受付年月
     * @param 発行有無 RString
     * @return 償還払い支給（不支給）決定通知書一括作成のMyBatisパラメータ
     */
    public static ShokanHanteiKekkaUpdataParameter createParam(RString chusyuMode, RString insho, FlexibleDate dataFrom,
            FlexibleDate dataTo, FlexibleYearMonth ketteishaUketsukeYM, RString 発行有無) {

        boolean chusyutuUketsukeFlag = false;
        boolean chusyutuKetteiFlag = false;
        boolean chusyutuKetteiShaUketsukeFlag = false;
        RString inshoKubun = RString.EMPTY;
        boolean isRiaruHakko = false;
        boolean isInshoKubun3 = false;
        boolean isHako2 = false;
        if (印書_1.equals(insho)) {
            inshoKubun = 決定通知リアル発行区分_未発行;
            isRiaruHakko = true;
        }
        if (印書_3.equals(insho)) {
            isInshoKubun3 = true;
        }
        if (抽出モード_1.equals(chusyuMode)) {
            chusyutuUketsukeFlag = true;
        } else if (抽出モード_2.equals(chusyuMode)) {
            chusyutuKetteiFlag = true;
        } else if (抽出モード_3.equals(chusyuMode)) {
            chusyutuKetteiShaUketsukeFlag = true;
        }
        if (発行しない.endsWith(発行有無)) {
            isHako2 = true;
        }
        return new ShokanHanteiKekkaUpdataParameter(dataFrom, dataTo, ketteishaUketsukeYM, chusyutuUketsukeFlag,
                chusyutuKetteiFlag, chusyutuKetteiShaUketsukeFlag, isRiaruHakko, isInshoKubun3, inshoKubun, isHako2);

    }
}
