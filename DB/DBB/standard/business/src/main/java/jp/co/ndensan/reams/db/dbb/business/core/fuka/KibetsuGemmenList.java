/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期別減免情報Entityです。
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KibetsuGemmenList implements Serializable {

    private RString 普徴期;
    private RString 普徴月;
    private RString 普徴期別減免前;
    private RString 普徴期別納期限;
    private RString 特徴期;
    private RString 特徴月;
    private RString 特徴期別金額;
    private RString 特徴期別減免前;
}
