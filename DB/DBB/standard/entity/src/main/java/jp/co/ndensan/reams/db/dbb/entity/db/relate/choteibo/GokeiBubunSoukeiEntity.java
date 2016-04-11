/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 合計部分総計一時テーブル
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GokeiBubunSoukeiEntity implements IDbAccessable {

    private RString choshuHouhou;
    private int dogetsuFlag;
    private Decimal tobetsuChoteigakuSoukei;
    private Decimal futsuChoteigakuSoukei;
    private Decimal tobetsuTofutsuChoteigakuSoukei;
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
    private Decimal genmenSoukei;
    private Decimal genmenChoteigakuSoukei;
    private Decimal tkSaishutsuKampuSoukei;
    private Decimal tkSaishutsuKampuChoteigakuSoukei;
    private Decimal fuSaishutsuKampuSoukei;
    private Decimal fuSaishutsuKampuChoteigakuSoukei;
}
