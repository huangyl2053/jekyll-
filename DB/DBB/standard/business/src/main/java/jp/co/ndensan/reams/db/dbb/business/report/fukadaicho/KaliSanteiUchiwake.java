/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮算定内訳
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaliSanteiUchiwake {

    private RString 仮算定保険料額;
    private RString 減免額;
    private RString 仮算定確定保険料;
    private RString 賦課基準日;
    private RString 調定年月日;

}
