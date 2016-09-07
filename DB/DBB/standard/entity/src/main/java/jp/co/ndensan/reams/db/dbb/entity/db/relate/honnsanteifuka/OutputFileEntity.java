/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 出力帳票entity
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OutputFileEntity {

    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RString 帳票名;
    private Long 出力順ID;

}
