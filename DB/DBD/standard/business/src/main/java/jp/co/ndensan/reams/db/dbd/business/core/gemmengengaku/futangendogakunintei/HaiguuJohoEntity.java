/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei;

import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 配偶者情報クラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HaiguuJohoEntity {

    private boolean exists;
    private IKojin 個人;
    private RString 課税区分;
    private RString 現住所と異なる本年1月1日住所;

}
