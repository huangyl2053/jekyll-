/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen;

import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;

/**
 * 更新結果確認 賦課の情報
 *
 * @reamsid_L DBB-1660-090 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoSaishn {

    private FukaJoho 賦課の情報_更正前;
    private FukaJoho 賦課の情報_更正後;
}
