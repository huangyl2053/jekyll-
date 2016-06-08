/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * うち種類支給限度基準額のエンティティです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShuruiShikyuGendoKizyunngakuBusiness {

    private RString serviceShurui;
    private RString shuruiShikyuKizyunngaku;
    private RString shuruiShikyuKizyunngakuTani;
}
