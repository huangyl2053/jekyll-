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
 * 期別合計一時Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KibetsuGokeiEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private RString choshuHouhou;
    private Decimal tobetsuChoteigakuCount;
    private Decimal futsuChoteigakuCount;
    private Decimal tobetsuTofutsuChoteigakuCount;
    private Decimal genmenCount;
    private Decimal genmenChoteigaku;
    private Decimal tkSaishutsuKampuCount;
    private Decimal tkSaishutsuKampuChoteigaku;
    private Decimal fuSaishutsuKampuCount;
    private Decimal fuSaishutsuKampuChoteigaku;
}
