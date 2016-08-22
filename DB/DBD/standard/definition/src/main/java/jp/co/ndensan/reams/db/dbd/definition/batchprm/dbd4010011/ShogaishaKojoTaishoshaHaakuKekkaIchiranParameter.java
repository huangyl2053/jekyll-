/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd4010011;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 障がい者控除対象者认定のDivControllerのバッチパラメタークラスです。
 *
 * @reamsid_L DBD-3850-010 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter extends BatchParameterBase {

    private RDate 基準日;
    private FlexibleYear 対象年度;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private boolean 前回把握時の非該当者;
    private boolean 基準日より後に資格喪失した者;

}
