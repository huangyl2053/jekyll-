/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.gennendohonsanteiidou;

import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;

/**
 * 調定計算のオブジェクトクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CaluculateChoteiResult {

    private FukaJoho 賦課の情報;
    private ChoshuHoho 徴収方法の情報;
}
