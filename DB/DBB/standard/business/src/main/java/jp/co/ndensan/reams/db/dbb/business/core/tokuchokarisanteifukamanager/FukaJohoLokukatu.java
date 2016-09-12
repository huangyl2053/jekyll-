/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteifukamanager;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課情報の計算登録（6月開始）クラスです。
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoLokukatu {

    private Decimal choteigaku;
    private RString hokenryoDankai;
    private FlexibleDate seihoKaishiYMD;
    private FlexibleDate seihoHaishiYMD;
    private FlexibleDate ronenKaishiYMD;
    private FlexibleDate ronenHaishiYMD;
    private RString setaikazeiKubun;
    private RString kazeiKubun;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkinShunyuGaku;
    private ChoshuHoho 徴収方法の情報_6月開始;
    private HihokenshaDaicho 資格の情報_6月開始;
    private List<SeikatsuHogoJukyusha> 生保の情報List_6月開始;
    private List<RoreiFukushiNenkinJukyusha> 老齢の情報List_6月開始;

    /**
     * FukaJohoLokukatu
     *
     * @param choteigaku Decimal
     * @param hokenryoDankai RString
     * @param seihoKaishiYMD FlexibleDate
     * @param seihoHaishiYMD FlexibleDate
     * @param ronenKaishiYMD FlexibleDate
     * @param ronenHaishiYMD FlexibleDate
     * @param setaikazeiKubun RString
     * @param kazeiKubun RString
     * @param gokeiShotokuGaku Decimal
     * @param nenkinShunyuGaku Decimal
     * @param 徴収方法の情報_6月開始 ChoshuHoho
     * @param 資格の情報_6月開始 HihokenshaDaicho
     * @param 生保の情報List_6月開始 List
     * @param 老齢の情報List_6月開始 List
     */
    public FukaJohoLokukatu(
            Decimal choteigaku,
            RString hokenryoDankai,
            FlexibleDate seihoKaishiYMD,
            FlexibleDate seihoHaishiYMD,
            FlexibleDate ronenKaishiYMD,
            FlexibleDate ronenHaishiYMD,
            RString setaikazeiKubun,
            RString kazeiKubun,
            Decimal gokeiShotokuGaku,
            Decimal nenkinShunyuGaku,
            ChoshuHoho 徴収方法の情報_6月開始,
            HihokenshaDaicho 資格の情報_6月開始,
            List<SeikatsuHogoJukyusha> 生保の情報List_6月開始,
            List<RoreiFukushiNenkinJukyusha> 老齢の情報List_6月開始) {
        this.choteigaku = choteigaku;
        this.hokenryoDankai = hokenryoDankai;
        this.seihoKaishiYMD = seihoKaishiYMD;
        this.seihoHaishiYMD = seihoHaishiYMD;
        this.ronenKaishiYMD = ronenKaishiYMD;
        this.ronenHaishiYMD = ronenHaishiYMD;
        this.setaikazeiKubun = setaikazeiKubun;
        this.kazeiKubun = kazeiKubun;
        this.gokeiShotokuGaku = gokeiShotokuGaku;
        this.nenkinShunyuGaku = nenkinShunyuGaku;
        this.徴収方法の情報_6月開始 = 徴収方法の情報_6月開始;
        this.資格の情報_6月開始 = 資格の情報_6月開始;
        this.生保の情報List_6月開始 = 生保の情報List_6月開始;
        this.老齢の情報List_6月開始 = 老齢の情報List_6月開始;
    }

}
