/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.gennendohonsanteiidou;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（現年度）のバッチパラメータです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GennendoIdoFukaParameter extends BatchParameterBase {

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_抽出開始日時 = "抽出開始日時";
    private static final String KEY_抽出終了日時 = "抽出終了日時";
    private static final String KEY_出力帳票一覧 = "出力帳票一覧";
    private static final String KEY_処理対象 = "処理対象";
    private static final String KEY_異動賦課で同時に計算する特徴捕捉分 = "異動賦課で同時に計算する特徴捕捉分";
    private static final String KEY_特徴捕捉対象者の依頼金額計算 = "特徴捕捉対象者の依頼金額計算";
    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private RString 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private RString 賦課年度;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<TyouhyouEntity> 出力帳票一覧;
    @BatchParameter(key = KEY_抽出開始日時, name = "抽出開始日時")
    private RString 抽出開始日時;
    @BatchParameter(key = KEY_抽出終了日時, name = "抽出終了日時")
    private RString 抽出終了日時;
    @BatchParameter(key = KEY_処理対象, name = "処理対象")
    private RString 処理対象;
    @BatchParameter(key = KEY_異動賦課で同時に計算する特徴捕捉分, name = "異動賦課で同時に計算する特徴捕捉分")
    private RString 異動賦課で同時に計算する特徴捕捉分;
    @BatchParameter(key = KEY_特徴捕捉対象者の依頼金額計算, name = "特徴捕捉対象者の依頼金額計算")
    private RString 特徴捕捉対象者の依頼金額計算;

}
