/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 本算定賦課計算バッチ用のパラメータです。
 *
 * @reamsid_L DBB-0780-030 xicongwang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteifukaBatchParameter extends BatchParameterBase {

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_資格基準日 = "資格基準日";
    private static final String KEY_出力帳票一覧 = "出力帳票一覧";
    private static final String KEY_特徴_出力対象 = "特徴_出力対象";
    private static final String KEY_特徴_発行日 = "特徴_発行日";
    private static final String KEY_決定変更_文書番号 = "決定変更_文書番号";
    private static final String KEY_決定変更_発行日 = "決定変更_発行日";
    private static final String KEY_納入_出力方法 = "納入_出力方法";
    private static final String KEY_納入_出力期 = "納入_出力期";
    private static final String KEY_納入_対象者 = "納入_対象者";
    private static final String KEY_納入_発行日 = "納入_発行日";
    private static final String KEY_納入_生活保護対象者をまとめて先頭に出力 = "納入_生活保護対象者をまとめて先頭に出力";
    private static final String KEY_納入_ページごとに山分け = "納入_ページごとに山分け";
    private static final String KEY_打分け条件情報 = "打分け条件情報";
    private static final String KEY_処理日時 = "処理日時";
    private static final String KEY_一括発行起動フラグ = "一括発行起動フラグ";
    private static final String KEY_画面移動フラグ = "画面移動フラグ";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_資格基準日, name = "資格基準日")
    private FlexibleDate 資格基準日;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<HonsanteifukaBatchTyouhyou> 出力帳票一覧;
    @BatchParameter(key = KEY_特徴_出力対象, name = "特徴_出力対象")
    private RString 特徴_出力対象;
    @BatchParameter(key = KEY_特徴_発行日, name = "特徴_発行日")
    private RDate 特徴_発行日;
    @BatchParameter(key = KEY_決定変更_文書番号, name = "決定変更_文書番号")
    private RString 決定変更_文書番号;
    @BatchParameter(key = KEY_決定変更_発行日, name = "決定変更_発行日")
    private RDate 決定変更_発行日;
    @BatchParameter(key = KEY_納入_出力方法, name = "納入_出力方法")
    private RString 納入_出力方法;
    @BatchParameter(key = KEY_納入_出力期, name = "納入_出力期")
    private RString 納入_出力期;
    @BatchParameter(key = KEY_納入_対象者, name = "納入_対象者")
    private RString 納入_対象者;
    @BatchParameter(key = KEY_納入_発行日, name = "納入_発行日")
    private RDate 納入_発行日;
    @BatchParameter(key = KEY_納入_生活保護対象者をまとめて先頭に出力, name = "納入_生活保護対象者をまとめて先頭に出力")
    private RString 納入_生活保護対象者をまとめて先頭に出力;
    @BatchParameter(key = KEY_納入_ページごとに山分け, name = "納入_ページごとに山分け")
    private RString 納入_ページごとに山分け;
    @BatchParameter(key = KEY_打分け条件情報, name = "打分け条件情報")
    private RString 打分け条件情報;
    @BatchParameter(key = KEY_処理日時, name = "処理日時")
    private RDateTime 処理日時;
    @BatchParameter(key = KEY_一括発行起動フラグ, name = "一括発行起動フラグ")
    private boolean 一括発行起動フラグ;
    @BatchParameter(key = KEY_画面移動フラグ, name = "画面移動フラグ")
    private boolean 画面移動フラグ;
}
