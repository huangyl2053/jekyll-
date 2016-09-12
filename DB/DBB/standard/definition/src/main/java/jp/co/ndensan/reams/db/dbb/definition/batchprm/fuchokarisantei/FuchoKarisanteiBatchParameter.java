/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.fuchokarisantei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定賦課バッチパラメータです。
 *
 * @reamsid_L DBB-0710-020 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuchoKarisanteiBatchParameter extends BatchParameterBase {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private List<FuchoKariSanteiEntity> 出力帳票一覧List;
    private FlexibleDate 発行日;
    private RString 出力方法;
    private RString 出力期表示方法;
    private RString 出力期;
    private RString 対象者フラグ;
    private RString 生活保護者をまとめて先頭に出力フラグ;
    private RString ページごとに山分けフラグ;
    private boolean 一括発行起動フラグ;
}
