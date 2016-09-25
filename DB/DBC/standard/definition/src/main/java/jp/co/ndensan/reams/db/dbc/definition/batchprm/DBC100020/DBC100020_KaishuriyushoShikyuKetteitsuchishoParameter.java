/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC100020;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成のバッチパラメータです。
 *
 * @reamsid_L DBC-2850-030 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter extends BatchParameterBase {

    @BatchParameter(key = "開始申請年月日", name = "申請年月日（開始）")
    private RString 市町村コード;
    @BatchParameter(key = "決定日（開始日）", name = "決定日（開始日）")
    private FlexibleDate 決定日_開始日;
    @BatchParameter(key = "決定日（終了日）", name = "決定日（終了日）")
    private FlexibleDate 決定日_終了日;
    @BatchParameter(key = "指定事業者のみフラグ", name = "指定事業者のみフラグ")
    private boolean 指定事業者のみフラグ;
    @BatchParameter(key = "事業者コード", name = "事業者コード")
    private RString 事業者コード;
    @BatchParameter(key = "文書情報", name = "文書情報")
    private RString 文書情報;
    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private Long 出力順ID;
    @BatchParameter(key = "作成日", name = "作成日")
    private FlexibleDate 作成日;

    /**
     * コンストラクタです。
     */
    public DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter() {
    }
}
