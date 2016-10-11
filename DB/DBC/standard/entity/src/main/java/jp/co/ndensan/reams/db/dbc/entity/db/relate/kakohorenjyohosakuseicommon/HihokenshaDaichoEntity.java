/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 時点指定被保険者台帳取得関数のrelateEntityです。
 *
 * @reamsid_L DBC-2840-031 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HihokenshaDaichoEntity {

    private RString kyuShichosonCode;
    private RString koikinaiJushochiTokureiFlag;
    private RString koikinaiShichosonCd;
    private RString shichosonCode;
}
