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
 * 段階小計一時Entityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaiShokeiEntity implements IDbAccessable {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private RString choshuHouhou;
    private RString dankai;
    private int dogetsuFlag;
    private RString karisanFlag;
    private Decimal zengetsusueKensu;
    private Decimal zengetsusueChoteigakuCount;
    private Decimal fueKensu;
    private Decimal fueChoteigakuCount;
    private Decimal genKensu;
    private Decimal genChoteigakuCount;
    private Decimal dogetsusueKensu;
    private Decimal dogetsusueChoteigakuCount;
    private Decimal tokuchosyaKensu;
    private Decimal fuchosyaKensu;
    private Decimal naiheisyaKensu;
}
