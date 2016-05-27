/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員情報Entityクラスです。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class IinJohoRelateEntity {

    private RString shinsakaiIinShimei;
    private RString shinsakaiIinShikakuCode;
    private RString kaigoninteiShinsakaiGichoKubunCode;
    private RString shinsakaiIin;
    private RString chosaIn;
    private RString sonoTa;
}
