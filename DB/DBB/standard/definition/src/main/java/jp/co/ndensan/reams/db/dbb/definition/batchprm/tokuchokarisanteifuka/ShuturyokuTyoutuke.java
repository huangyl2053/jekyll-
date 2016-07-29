/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchokarisanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;

/**
 * バッチ設計_DBBBT33001_特徴仮算定賦課のparameter
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShuturyokuTyoutuke extends BatchParameterBase {

    private ReportId 帳票ID;
    private ReportId 帳票分類ID;
    private Long 出力順ID;
}
