/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 本算定賦課処理のバッチ起動時に設定されるパラメータ
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NonyuTsuchIchiranBatchParameter extends BatchParameterBase {

    private RString 賦課年度;
    private RString 調定年度;
    private List<NonyuTsuchIchiranentity> 出力帳票entity;
    private RString 出力期;
    private RString 発行日;
}
