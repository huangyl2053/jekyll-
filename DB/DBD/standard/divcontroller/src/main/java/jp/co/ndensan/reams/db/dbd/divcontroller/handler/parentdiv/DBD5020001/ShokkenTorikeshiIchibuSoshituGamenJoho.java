/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJoho;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 *
 * 要介護認定処理画面の画面更新用クラスです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokkenTorikeshiIchibuSoshituGamenJoho implements Serializable {

    private YokaigoNinteiJoho 今回情報;
    private YokaigoNinteiJoho 前回情報;
    private Code 導入形態コード;

}
