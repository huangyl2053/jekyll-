/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 当月末の段階のデータEntityです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DangatsuDankaiDataEntity {

    private FlexibleYear choteiNendo;
    private RString choshuHouhou;
    private RString dankai;
    private int dogetsuFlag;
    private RString karisanFlag;
    private Decimal dogetsusueKensuCount;
    private Decimal dogetsusueChoteigakuCount;
    private Decimal fueKensuCount;
    private Decimal fueChoteigakuCount;
    private Decimal genKensuCount;
    private Decimal genChoteigakuCount;
}
