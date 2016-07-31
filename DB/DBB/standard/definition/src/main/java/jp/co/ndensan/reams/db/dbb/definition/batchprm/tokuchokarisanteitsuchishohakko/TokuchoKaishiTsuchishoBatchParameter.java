/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchokarisanteitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.KarisanteiBatchEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 特徴仮算定通知書一括発行バッチ用のパラメータです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKaishiTsuchishoBatchParameter extends BatchParameterBase {

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_出力帳票一覧 = "出力帳票一覧";
    private static final String KEY_出力対象 = "出力対象";
    private static final String KEY_発行日 = "発行日";
    private static final String KEY_一括発行起動フラグ = "一括発行起動フラグ";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<KarisanteiBatchEntity> 出力帳票一覧;
    @BatchParameter(key = KEY_出力対象, name = "出力対象")
    private RString 出力対象;
    @BatchParameter(key = KEY_発行日, name = "発行日")
    private FlexibleDate 発行日;
    @BatchParameter(key = KEY_一括発行起動フラグ, name = "一括発行起動フラグ")
    private boolean 一括発行起動フラグ;
}
