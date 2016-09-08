/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 統計人数Entityクラスです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ToukeiNinzuEntity {

    private RString 取得条件;
    private Decimal 自立人数;
    private Decimal 経過介護人数;
    private Decimal 要支援1人数;
    private Decimal 要支援2人数;
    private Decimal 要介護1人数;
    private Decimal 要介護2人数;
    private Decimal 要介護3人数;
    private Decimal 要介護4人数;
    private Decimal 要介護5人数;
    private Decimal 合計;

}
