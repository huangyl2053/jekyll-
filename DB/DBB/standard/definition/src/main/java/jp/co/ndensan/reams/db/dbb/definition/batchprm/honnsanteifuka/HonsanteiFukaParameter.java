/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honnsanteifuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定賦課計算のバッチパラメータです。
 *
 * @reamsid_L DBB-0730-010 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiFukaParameter extends BatchParameterBase {

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_資格基準日 = "資格基準日";
    private static final String KEY_バッチ起動時処理日時 = "バッチ起動時処理日時";
    private static final String KEY_出力帳票一覧 = "出力帳票一覧";
    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private RString 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private RString 賦課年度;
    @BatchParameter(key = KEY_資格基準日, name = "資格基準日")
    private RString 資格基準日;
    @BatchParameter(key = KEY_バッチ起動時処理日時, name = "バッチ起動時処理日時")
    private RString バッチ起動時処理日時;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<TyouhyouEntity> 出力帳票一覧;

}
