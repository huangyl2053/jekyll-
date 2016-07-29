/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.kanendoidofuka.KanendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT45001_本算定異動（過年度）パラメータクラスです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HonSanteiIdoFukaBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_処理対象 = "処理対象";
    private static final String KEY_抽出開始日時 = "抽出開始日時";
    private static final String KEY_抽出終了日時 = "抽出終了日時";
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
    @BatchParameter(key = KEY_処理対象, name = "処理対象")
    private RString 処理対象;
    @BatchParameter(key = KEY_抽出開始日時, name = "抽出開始日時")
    private RDateTime 抽出開始日時;
    @BatchParameter(key = KEY_抽出終了日時, name = "抽出終了日時")
    private RDateTime 抽出終了日時;
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

    /**
     * 本算定異動（過年度）のProcessParameterのメソッドです。
     *
     * @param システム日時 YMDHMS
     * @return 本算定異動（過年度）のMybatisParameter
     */
    public KanendoIdoFukaProcessParameter toKanendoIdoFukaProcessParameter(YMDHMS システム日時) {
        RString 出力順ID;
        if (出力帳票List != null && !出力帳票List.isEmpty()) {
            出力順ID = 出力帳票List.get(0).get出力順ID();
        } else {
            出力順ID = RString.EMPTY;
        }
        RString 日付関連_年度サイクル = DbBusinessConfig.get(ConfigNameDBB.日付関連_年度サイクル, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        return new KanendoIdoFukaProcessParameter(日付関連_年度サイクル, 調定年度, 処理対象, 抽出開始日時, 抽出終了日時, 出力順ID, システム日時);
    }

}
