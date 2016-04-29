/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 段階合計一時テーブルEntityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaiGokeiEntity implements IDbAccessable {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private RString choshuHouhou;
    private int dogetsuFlag;
    private Decimal zengetsusueKensuCount;
    private Decimal zengetsusueChoteigakuCount;
    private Decimal fueZennbuKennsuuGokei;
    private Decimal fueZennbuChoteigakuGokei;
    private Decimal genZennbuKennsuuGokei;
    private Decimal genZennbuChoteigakuGokei;
    private Decimal dogetsusueKensuCount;
    private Decimal dogetsusueChoteigakuCount;
    private Decimal tokuchosyaKensuCount;
    private Decimal fuchosyaKensuCount;
    private Decimal naiheisyaKensuCount;
}
