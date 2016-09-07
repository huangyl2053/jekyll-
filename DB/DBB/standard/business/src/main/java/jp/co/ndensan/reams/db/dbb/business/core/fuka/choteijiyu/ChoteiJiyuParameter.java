/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;

/**
 * 調定事由用のパラメータクラスです。
 *
 * @reamsid_L DBB-0660-050 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiJiyuParameter {

    private FukaJoho 現年度;
    private FukaJoho 過年度;
    private List<FukaJohoList> 更正後賦課リスト;
    private ChoshuHoho 更正前徴収方法;
    private ChoshuHoho 更正後徴収方法;
}
