/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidokekka;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮算定異動賦課バッチのパラメータです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiIdoKekkaBatchParameter extends BatchParameterBase {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 処理対象月;
    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
    private List<KarisanteiIdoKekkaResult> 出力帳票List;
    private RDateTime 普徴仮算定賦課処理日時;
    private RString 依頼金額計算区分;

}
