/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *  本算定賦課内訳１
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonSanteifukaUchiwakeIchi {
    private RString 本人合計所得金額;
    private RString 本人公的年金収入額;
    private RString 本人課税区分;
    private RString 世帯課税区分;
    private RString 本人算出保険料額;
    private RString 本人減免額;
    private RString 確定年額保険料;
    private RString 賦課基準日;
    private RString 調定年月日;
    private RString 年額保険料;
}
