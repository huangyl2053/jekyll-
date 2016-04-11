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
 * 期別部分のデータEntityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KibetsuBubunDataEntity {

    private FlexibleYear choteiNendo;
    private RString choshuHouhou;
    private Decimal tobetsuChoteigakuSoukei;
    private Decimal futsuChoteigakuSoukei;
    private Decimal tobetsuTofutsuChoteigakuSoukei;
    private Decimal genmenSoukei;
    private Decimal genmenChoteigakuSoukei;
    private Decimal tkSaishutsuKampuSoukei;
    private Decimal tkSaishutsuKampuChoteigakuSoukei;
    private Decimal fuSaishutsuKampuSoukei;
    private Decimal fuSaishutsuKampuChoteigakuSoukei;
}
