/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.honsanteiidokanendofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import lombok.Getter;
import lombok.Setter;

/**
 * 調定計算と調定事由の出力です。
 *
 * @reamsid_L DBB-0910-020 zhujun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoToChoshuHoho {

    private List<FukaJoho> 賦課情報;
    private ChoshuHoho 徴収方法の情報;
}
