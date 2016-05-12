/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 本算定賦課計算のパラメータ
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiFukaExtraBatchParameter extends BatchParameterBase {

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_資格基準日 = "資格基準日";
    private static final String KEY_処理日時 = "処理日時";
    private static final String KEY_出力帳票一覧リスタ = "KEY_出力帳票一覧リスタ";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_資格基準日, name = "資格基準日")
    private FlexibleDate 資格基準日;
    @BatchParameter(key = KEY_処理日時, name = "処理日時")
    private YMDHMS 処理日時;
    @BatchParameter(key = KEY_出力帳票一覧リスタ, name = "KEY_出力帳票一覧リスタ")
    private List<HonsanteiFukaEntity> 出力帳票一覧List;

}
