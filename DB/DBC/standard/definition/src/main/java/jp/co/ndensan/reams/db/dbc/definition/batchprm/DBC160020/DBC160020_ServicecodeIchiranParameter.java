/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC160020;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * サービスコード一覧表画面で入力されたデータより、バッチ用パラメータクラスを作成する。
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC160020_ServicecodeIchiranParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private RYearMonth 基準年月;
    private RString 抽出条件区分;
    private RString サービス種類コード;
    private RString サービス項目コード;
    private List<RString> サービス分類s;
    private boolean is帳票で出力;
    private boolean isＣＳＶファイルで出力;
    private RString 表題;
    private boolean is項目名付加;
    private boolean is連番付加;
    private boolean is日付編集;
}
