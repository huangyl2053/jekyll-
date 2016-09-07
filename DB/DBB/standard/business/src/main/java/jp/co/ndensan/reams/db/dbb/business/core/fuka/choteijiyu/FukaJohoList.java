/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu;

import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;

/**
 * 更正後賦課の情報リストのクラスです。
 *
 * @reamsid_L DBB-0660-050 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoList {

    private FukaJoho 現年度;
    private FukaJoho 過年度;
}
