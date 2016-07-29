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

    private RString 帳票グループ;
    private RString 普徴仮算定異動方法;
    private RString 特徴_発行日;
    private RString 仮算定額変更_発行日;
    private RString 文書番号;
    private RString 納入_出力期;
    private RString 納入_出力方式;
    private RString 納入_発行日;
    private RString 納入_対象者;
    private RString 納入_生活保護対象者;
    private RString 納入_ページごとに山分け;
    private RString 特徴仮算定賦課処理日時;
    private boolean 一括発行起動フラグ;
    private RString 算定期;

}
