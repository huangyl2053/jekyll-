/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteifukamanager;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;

/**
 * 資格等最新化（４月開始）クラスです。
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
@lombok.Getter
@lombok.Setter
public class SikakuSaisinnsiki {

    private FukaJoho 賦課の情報_４月開始;
    private ChoshuHoho 徴収方法の情報_４月開始;
    private HihokenshaDaicho 資格の情報_４月開始;
    private List<SeikatsuHogoJukyusha> 生保の情報List_４月開始;
    private List<RoreiFukushiNenkinJukyusha> 老齢の情報List_４月開始;

    /**
     * SikakuSaisinnsiki
     *
     * @param 賦課の情報_４月開始 FukaJoho
     * @param 徴収方法の情報_４月開始 ChoshuHoho
     * @param 資格の情報_４月開始 HihokenshaDaicho
     * @param 生保の情報List_４月開始 List
     * @param 老齢の情報List_４月開始 List
     */
    public SikakuSaisinnsiki(
            FukaJoho 賦課の情報_４月開始,
            ChoshuHoho 徴収方法の情報_４月開始,
            HihokenshaDaicho 資格の情報_４月開始,
            List<SeikatsuHogoJukyusha> 生保の情報List_４月開始,
            List<RoreiFukushiNenkinJukyusha> 老齢の情報List_４月開始) {
        this.賦課の情報_４月開始 = 賦課の情報_４月開始;
        this.徴収方法の情報_４月開始 = 徴収方法の情報_４月開始;
        this.資格の情報_４月開始 = 資格の情報_４月開始;
        this.生保の情報List_４月開始 = 生保の情報List_４月開始;
        this.老齢の情報List_４月開始 = 老齢の情報List_４月開始;
    }
}
