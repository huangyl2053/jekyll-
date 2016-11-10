/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業報告資料.集計結果値のEntityです。
 *
 * @reamsid_L DBU-5560-040 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompResultEntity {

    private RString 集計番号;
    private Decimal 要支援１;
    private Decimal 要支援２;
    private Decimal 非該当;
    private Decimal 経過的要介護;
    private Decimal 要介護１;
    private Decimal 要介護２;
    private Decimal 要介護３;
    private Decimal 要介護４;
    private Decimal 要介護５;
    private Decimal 要支援１＿１;
    private Decimal 要支援２＿１;
    private Decimal 非該当＿１;
    private Decimal 経過的要介護＿１;
    private Decimal 要介護１＿１;
    private Decimal 要介護２＿１;
    private Decimal 要介護３＿１;
    private Decimal 要介護４＿１;
    private Decimal 要介護５＿１;
}
