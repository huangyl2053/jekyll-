/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（過年度）バッチのパラメータです。
 *
 * @reamsid_L DBB-0910-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HonSanteiIdoKanendoFukaBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_LIST_出力帳票 = "出力帳票List";
    private static final String KEY_LIST_決定_対象賦課年度 = "決定_対象賦課年度List";
    private static final String KEY_LIST_変更_対象賦課年度 = "変更_対象賦課年度List";
    private static final String KEY_LIST_納入_対象賦課年度 = "納入_対象賦課年度List";
    private static final String KEY_決定_チェックボックス = "決定_チェックボックス";
    private static final String KEY_決定_文書番号 = "決定_文書番号";
    private static final String KEY_決定_発行日 = "決定_発行日";
    private static final String KEY_変更_チェックボックス = "変更_チェックボックス";
    private static final String KEY_変更_対象者 = "変更_対象者";
    private static final String KEY_変更_文書番号 = "変更_文書番号";
    private static final String KEY_変更_発行日 = "変更_発行日";
    private static final String KEY_納入_対象者 = "納入_対象者";
    private static final String KEY_納入_口座振替様式 = "納入_口座振替様式";
    private static final String KEY_納入_発行日 = "納入_発行日";
    private static final String KEY_納入_先頭出力 = "納入_先頭出力";
    private static final String KEY_納入_出力期 = "納入_出力期";
    private static final String KEY_納入_ページごとに山分け = "納入_ページごとに山分け";
    private static final String KEY_一括発行起動フラグ = "一括発行起動フラグ";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_LIST_出力帳票, name = "List<出力帳票List>")
    private List<ChohyoResult> 出力帳票List;
    @BatchParameter(key = KEY_決定_チェックボックス, name = "決定_チェックボックス")
    private RString 決定_チェックボックス; //[決定通知書]のチェックボックス 1：する 0：しない
    @BatchParameter(key = KEY_LIST_決定_対象賦課年度, name = "List<決定_対象賦課年度List>")
    private List<FlexibleYear> 決定_対象賦課年度;
    @BatchParameter(key = KEY_決定_発行日, name = "決定_発行日")
    private RDate 決定_発行日;
    @BatchParameter(key = KEY_決定_文書番号, name = "決定_文書番号")
    private RString 決定_文書番号;
    @BatchParameter(key = KEY_変更_チェックボックス, name = "変更_チェックボックス")
    private RString 変更_チェックボックス; //[決定通知書]のチェックボックス 1：する 0：しない
    @BatchParameter(key = KEY_LIST_変更_対象賦課年度, name = "List<変更_対象賦課年度List>")
    private List<FlexibleYear> 変更_対象賦課年度;
    @BatchParameter(key = KEY_変更_発行日, name = "変更_発行日")
    private RDate 変更_発行日;
    @BatchParameter(key = KEY_変更_文書番号, name = "変更_文書番号")
    private RString 変更_文書番号;
    @BatchParameter(key = KEY_変更_対象者, name = "変更_対象者")
    private RString 変更_対象者; //0：現金納付者 1：口座振替者 2：（すべて選択）
    @BatchParameter(key = KEY_LIST_納入_対象賦課年度, name = "List<納入_対象賦課年度List>")
    private List<FlexibleYear> 納入_対象賦課年度;
    @BatchParameter(key = KEY_納入_発行日, name = "納入_発行日")
    private RDate 納入_発行日;
    @BatchParameter(key = KEY_納入_出力期, name = "納入_出力期")
    private RString 納入_出力期;
    @BatchParameter(key = KEY_納入_対象者, name = "納入_対象者")
    private RString 納入_対象者; //0：現金納付者 1：口座振替者 2：（すべて選択）
    @BatchParameter(key = KEY_納入_口座振替様式, name = "納入_口座振替様式")
    private RString 納入_口座振替様式; //1：口座用 0：現金用
    @BatchParameter(key = KEY_納入_先頭出力, name = "納入_先頭出力")
    private RString 納入_先頭出力; //画面で設定された[納入通知書]の生活保護対象者をまとめて先頭に出力 0：する 1：しない
    @BatchParameter(key = KEY_納入_ページごとに山分け, name = "納入_ページごとに山分け")
    private RString 納入_ページ山分け; //画面で設定された[納入通知書]のページごとに山分け 0：する 1：しない
    @BatchParameter(key = KEY_一括発行起動フラグ, name = "一括発行起動フラグ")
    private boolean 一括発行起動フラグ;
}
