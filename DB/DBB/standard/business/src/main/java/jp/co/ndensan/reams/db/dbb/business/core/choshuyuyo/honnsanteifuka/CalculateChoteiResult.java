/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.honnsanteifuka;

import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import lombok.Getter;
import lombok.Setter;

/**
 * 調定計算の出力結果
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CalculateChoteiResult {

    private FukaJoho 賦課情報;
    private ChoshuHoho 徴収方法情報;
}
