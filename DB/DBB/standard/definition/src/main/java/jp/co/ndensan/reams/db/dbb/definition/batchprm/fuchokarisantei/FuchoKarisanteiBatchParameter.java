/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.fuchokarisantei;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定賦課バッチパラメータです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuchoKarisanteiBatchParameter extends BatchParameterBase {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private Object 出力帳票一覧List;
    private FlexibleDate 発行日;
    private RString 出力方法;
    private RString 出力期表示方法;
    private RString 出力期;
    private RString 対象者;
    private RString 生活保護者をまとめて先頭に出力フラグ;
    private RString ページごとに山分けフラグ;
}
