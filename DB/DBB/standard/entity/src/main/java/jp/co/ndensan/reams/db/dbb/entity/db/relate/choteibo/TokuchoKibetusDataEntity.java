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
 * 特別徴収期別のデータEntityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKibetusDataEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private RString choshuHouhou;
    private Decimal dai1kiChoteigakuGokei;
    private Decimal dai2kiChoteigakuGokei;
    private Decimal dai3kiChoteigakuGokei;
    private Decimal dai4kiChoteigakuGokei;
    private Decimal dai5kiChoteigakuGokei;
    private Decimal dai6kiChoteigakuGokei;
}
