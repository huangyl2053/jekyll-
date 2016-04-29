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
 * その他部分のデータEntityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SonotaBubunDataEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private RString choshuHouhou;
    private int dogetsuFlag;
    private Decimal zengetsusueKensuSoukei;
    private Decimal zengetsusueChoteigakuSoukei;
    private Decimal fueZennbuKennsuuSoukei;
    private Decimal fueZennbuChoteigakuSoukei;
    private Decimal genZennbuKennsuuSoukei;
    private Decimal genZennbuChoteigakuSoukei;
    private Decimal dogetsusueKensuSoukei;
    private Decimal dogetsusueChoteigakuSoukei;
    private Decimal tokuchosyaKensuSoukei;
    private Decimal fuchosyaKensuSoukei;
    private Decimal naiheisyaKensuSoukei;
}
