/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 本算定賦課計算バッチ用のパラメータです。
 *
 * @reamsid_L DBB-0920-020 quxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiIdoKanendoBatchParameter {

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_処理対象 = "処理対象";
    private static final String KEY_抽出開始日時 = "抽出開始日時";
    private static final String KEY_抽出終了日時 = "抽出終了日時";
    private static final String KEY_出力帳票一覧 = "出力帳票一覧";
    private static final String KEY_決定_チェックボックス = "決定_チェックボックス";
    private static final String KEY_決定_対象賦課年度 = "決定_対象賦課年度";
    private static final String KEY_決定_文書番号 = "決定_文書番号";
    private static final String KEY_決定_発行日 = "決定_発行日";
    private static final String KEY_変更_チェックボックス = "変更_チェックボックス";
    private static final String KEY_変更_対象賦課年度 = "変更_対象賦課年度";
    private static final String KEY_変更_発行日 = "変更_発行日";
    private static final String KEY_変更_文書番号 = "変更_文書番号";
    private static final String KEY_変更_対象者 = "変更_対象者";
    private static final String KEY_納入_対象賦課年度 = "納入_対象賦課年度";
    private static final String KEY_納入_発行日 = "納入_発行日";
    private static final String KEY_納入_出力期 = "納入_出力期";
    private static final String KEY_納入_対象者 = "納入_対象者";
    private static final String KEY_納入_口座振替様式 = "納入_口座振替様式";
    private static final String KEY_納入_生活保護対象者 = "納入_生活保護対象者";
    private static final String KEY_納入_ページごとに山分け = "納入_ページごとに山分け";
    private static final String KEY_一括発行起動フラグ = "一括発行起動フラグ";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_処理対象, name = "処理対象")
    private RString 処理対象;
    @BatchParameter(key = KEY_抽出開始日時, name = "抽出開始日時")
    private YMDHMS 抽出開始日時;
    @BatchParameter(key = KEY_抽出終了日時, name = "抽出終了日時")
    private YMDHMS 抽出終了日時;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<HonsanteiIdoKanendoResult> 出力帳票一覧;
    @BatchParameter(key = KEY_決定_チェックボックス, name = "決定_チェックボックス")
    private RString 決定_チェックボックス;
    @BatchParameter(key = KEY_決定_対象賦課年度, name = "決定_対象賦課年度")
    private List<FlexibleYear> 決定_対象賦課年度;
    @BatchParameter(key = KEY_決定_文書番号, name = "決定_文書番号")
    private RString 決定_文書番号;
    @BatchParameter(key = KEY_決定_発行日, name = "決定_発行日")
    private FlexibleDate 決定_発行日;
    @BatchParameter(key = KEY_変更_チェックボックス, name = "変更_チェックボックス")
    private RString 変更_チェックボックス;
    @BatchParameter(key = KEY_変更_対象賦課年度, name = "変更_対象賦課年度")
    private List<FlexibleYear> 変更_対象賦課年度;
    @BatchParameter(key = KEY_変更_発行日, name = "変更_発行日")
    private FlexibleDate 変更_発行日;
    @BatchParameter(key = KEY_変更_文書番号, name = "変更_文書番号")
    private RString 変更_文書番号;
    @BatchParameter(key = KEY_変更_対象者, name = "変更_対象者")
    private RString 変更_対象者;
    @BatchParameter(key = KEY_納入_対象賦課年度, name = "納入_対象賦課年度")
    private List<FlexibleYear> 納入_対象賦課年度;
    @BatchParameter(key = KEY_納入_発行日, name = "納入_発行日")
    private FlexibleDate 納入_発行日;
    @BatchParameter(key = KEY_納入_出力期, name = "納入_出力期")
    private RString 納入_出力期;
    @BatchParameter(key = KEY_納入_対象者, name = "納入_対象者")
    private RString 納入_対象者;
    @BatchParameter(key = KEY_納入_口座振替様式, name = "納入_口座振替様式")
    private RString 納入_口座振替様式;
    @BatchParameter(key = KEY_納入_生活保護対象者, name = "納入_生活保護対象者")
    private RString 納入_生活保護対象者;
    @BatchParameter(key = KEY_納入_ページごとに山分け, name = "納入_ページごとに山分け")
    private RString 納入_ページごとに山分け;
    @BatchParameter(key = KEY_一括発行起動フラグ, name = "一括発行起動フラグ")
    private boolean 一括発行起動フラグ;
}
