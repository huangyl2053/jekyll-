/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者番号及び名称及び印のエンティティです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaBangoMeishoInDataEntity {

    private RString hokenshaNo;
    private RString hokenshaJusho;
    private RString hokenshaName;
    private RString hokenshaTelno;
    private RString denshiKoin;
}
