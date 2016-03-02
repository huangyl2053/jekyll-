/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.shoukanbaraisuuchishoikkatsusakusei;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書作成バッチパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanBaraiSuuchiShoIkatsuBatchParamter extends BatchParameterBase {

    private RString 抽出モード;
    private RString 抽出条件日付From;
    private RString 抽出条件日付To;
    private RString 決定者受付年月;
    private RString 印書;
    private RString 発行日;
    private RString 文書番号;
    private RString テスト出力フラグ;
    private RString 決定日一括更新区分;
    private RString 決定日;
    private RString 利用者向け決定通知書フラグ;
    private RString 受領委任者向け決定通知書フラグ;
    private RString 振込予定日;
    private RString 支払場所;
    private RString 支払期間From;
    private RString 支払期間To;
    private RString 開始時間;
    private RString 終了時間;
    private RString 出力順ID;
}
