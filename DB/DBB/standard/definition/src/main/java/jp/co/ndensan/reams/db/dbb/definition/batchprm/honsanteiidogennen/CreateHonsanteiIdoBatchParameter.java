/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 本算定異動（現年度）バッチ用のパラメータです。
 *
 * @reamsid_L DBB-0880-020 lijunjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateHonsanteiIdoBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private static final String KEY_CHOTEINENDO = "choteiNendo";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_処理対象 = "処理対象";
    private static final String KEY_抽出開始日時 = "抽出開始日時";
    private static final String KEY_抽出終了日時 = "抽出終了日時";
    private static final String KEY_特徴捕捉分 = "特徴捕捉分";
    private static final String KEY_依頼金額計算 = "依頼金額計算";
    private static final String KEY_LIST_出力帳票 = "出力帳票List";
    private static final String KEY_特徴_出力対象 = "特徴_出力対象";
    private static final String KEY_特徴_発行日 = "特徴_発行日";
    private static final String KEY_決定_チェックボックス = "決定_チェックボックス";
    private static final String KEY_決定_文書番号 = "決定_文書番号";
    private static final String KEY_決定_発行日 = "決定_発行日";
    private static final String KEY_変更_チェックボックス = "変更_チェックボックス";
    private static final String KEY_変更_対象者 = "変更_対象者";
    private static final String KEY_変更_文書番号 = "変更_文書番号";
    private static final String KEY_変更_発行日 = "変更_発行日";
    private static final String KEY_納入_対象者 = "納入_対象者";
    private static final String KEY_納入_口座振替者 = "納入_口座振替者";
    private static final String KEY_納入_発行日 = "納入_発行日";
    private static final String KEY_納入_出力方法 = "納入_出力方法";
    private static final String KEY_納入_出力期 = "納入_出力期";
    private static final String KEY_納入_生活保護対象者 = "納入_生活保護対象者";
    private static final String KEY_納入_ページごとに山分け = "納入_ページごとに山分け";
    private static final String KEY_一括発行起動フラグ = "一括発行起動フラグ";
    private static final String KEY_随時フラグ = "随時フラグ";
    private static final String KEY_算定期 = "算定期";

    @BatchParameter(key = KEY_CHOTEINENDO, name = "調定年度")
    private FlexibleYear choteiNendo;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_処理対象, name = "処理対象")
    private RString 処理対象;
    @BatchParameter(key = KEY_抽出開始日時, name = "抽出開始日時")
    private YMDHMS 抽出開始日時;
    @BatchParameter(key = KEY_抽出終了日時, name = "抽出終了日時")
    private YMDHMS 抽出終了日時;
    @BatchParameter(key = KEY_特徴捕捉分, name = "特徴捕捉分")
    private RString 特徴捕捉分;
    @BatchParameter(key = KEY_依頼金額計算, name = "依頼金額計算")
    private RString 依頼金額計算;
    @BatchParameter(key = KEY_LIST_出力帳票, name = "List<出力帳票List>")
    private List<ChohyoResult> 出力帳票List;
    @BatchParameter(key = KEY_特徴_出力対象, name = "特徴_出力対象")
    private RString 特徴_出力対象;
    @BatchParameter(key = KEY_特徴_発行日, name = "特徴_発行日")
    private FlexibleDate 特徴_発行日;
    @BatchParameter(key = KEY_決定_チェックボックス, name = "決定_チェックボックス")
    private RString 決定_チェックボックス;
    @BatchParameter(key = KEY_決定_文書番号, name = "決定_文書番号")
    private RString 決定_文書番号;
    @BatchParameter(key = KEY_決定_発行日, name = "決定_発行日")
    private FlexibleDate 決定_発行日;
    @BatchParameter(key = KEY_変更_チェックボックス, name = "変更_チェックボックス")
    private RString 変更_チェックボックス;
    @BatchParameter(key = KEY_変更_対象者, name = "変更_対象者")
    private RString 変更_対象者;
    @BatchParameter(key = KEY_変更_文書番号, name = "変更_文書番号")
    private RString 変更_文書番号;
    @BatchParameter(key = KEY_変更_発行日, name = "変更_発行日")
    private FlexibleDate 変更_発行日;
    @BatchParameter(key = KEY_納入_対象者, name = "納入_対象者")
    private RString 納入_対象者;
    @BatchParameter(key = KEY_納入_口座振替者, name = "納入_口座振替者")
    private RString 納入_口座振替者;
    @BatchParameter(key = KEY_納入_発行日, name = "納入_発行日")
    private FlexibleDate 納入_発行日;
    @BatchParameter(key = KEY_納入_出力方法, name = "納入_出力方法")
    private RString 納入_出力方法;
    @BatchParameter(key = KEY_納入_出力期, name = "納入_出力期")
    private RString 納入_出力期;
    @BatchParameter(key = KEY_納入_生活保護対象者, name = "納入_生活保護対象者")
    private RString 納入_生活保護対象者;
    @BatchParameter(key = KEY_納入_ページごとに山分け, name = "納入_ページごとに山分け")
    private RString 納入_ページごとに山分け;
    @BatchParameter(key = KEY_一括発行起動フラグ, name = "一括発行起動フラグ")
    private boolean 一括発行起動フラグ;
    @BatchParameter(key = KEY_随時フラグ, name = "随時フラグ")
    private boolean 随時フラグ;
    @BatchParameter(key = KEY_算定期, name = "算定期")
    private RString 算定期;
}
