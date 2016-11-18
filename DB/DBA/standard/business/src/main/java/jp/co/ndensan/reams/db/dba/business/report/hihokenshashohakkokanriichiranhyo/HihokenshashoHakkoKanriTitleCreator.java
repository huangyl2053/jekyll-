/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 被保険者証・資格者証発行管理リスト関連の画面・帳票・CSVファイルで使用するタイトルを生成する機能を定義します。
 *
 * @author n8178
 */
public final class HihokenshashoHakkoKanriTitleCreator {

    private static final RString STR_介護保険 = new RString("介護保険　");
    private static final RString STR_被保険者 = new RString("被保険者");
    private static final RString STR_資格者 = new RString("資格者");
    private static final RString STR_証発行管理リスト = new RString("証発行管理リスト");
    private static final RString STR_証未回収者リスト = new RString("証未回収者リスト");
    private static final RString STR_拡張子CSV = new RString(".csv");

    private static final RString MENU_ID_被保険者証発行管理 = new RString("DBAMN72001");
    private static final RString MENU_ID_資格者証発行管理 = new RString("DBAMN72002");
    private static final RString 証発行モード_被保険者 = new RString("001");
    private static final RString 証発行モード_資格者 = new RString("002");
    private static final RString 発行対象_発行管理リスト = new RString("1");
    private static final RString 発行対象_未回収者リスト = new RString("2");

    private HihokenshashoHakkoKanriTitleCreator() {
    }

    /**
     * 画面のタイトルを作成して返します。
     *
     * @param menuID メニューID
     * @return 画面タイトル
     */
    public static RString create画面タイトル(RString menuID) {
        return create画面表示用文字列(menuID, 発行対象_発行管理リスト);
    }

    /**
     * メニューIDと対象区分から、出力対象帳票を表す画面表示用文字列を作成して返します。
     *
     * @param menuID メニューID。被保険者証発行管理 or 資格者証発行管理を想定
     * @param 対象区分 対象区分。発行管理リスト or 未回収リストを想定
     * @return 生成した文字列
     */
    public static RString create画面表示用文字列(RString menuID, RString 対象区分) {
        RStringBuilder returnTitle = new RStringBuilder();
        if (MENU_ID_被保険者証発行管理.equals(menuID)) {
            if (発行対象_発行管理リスト.equals(対象区分)) {
                returnTitle.append(STR_被保険者).append(STR_証発行管理リスト);
            } else if (発行対象_未回収者リスト.equals(対象区分)) {
                returnTitle.append(STR_被保険者).append(STR_証未回収者リスト);
            }
        } else if (MENU_ID_資格者証発行管理.equals(menuID)) {
            if (発行対象_発行管理リスト.equals(対象区分)) {
                returnTitle.append(STR_資格者).append(STR_証発行管理リスト);
            } else if (発行対象_未回収者リスト.equals(対象区分)) {
                returnTitle.append(STR_資格者).append(STR_証未回収者リスト);
            }
        }
        return returnTitle.toRString();
    }

    /**
     * 出力するCSVファイルの名称を作成します。指定した証発行モード・出力対象で作成される文字列が変化します。
     *
     * @param 証発行モード 証発行モード
     * @param 出力対象 出力対象
     * @return CSVファイル名
     */
    public static RString createCSV名称(RString 証発行モード, RString 出力対象) {
        RStringBuilder printName = new RStringBuilder();
        printName.append(create出力名(証発行モード, 出力対象));
        printName.append(STR_拡張子CSV);
        return printName.toRString();
    }

    /**
     * 出力する帳票の名称を作成します。指定した証発行モード・出力対象で作成される文字列が変化します。
     *
     * @param 証発行モード 証発行モード
     * @param 出力対象 出力対象
     * @return 帳票名
     */
    public static RString create帳票名(RString 証発行モード, RString 出力対象) {
        RStringBuilder printName = new RStringBuilder(STR_介護保険);
        printName.append(create出力名(証発行モード, 出力対象));
        return printName.toRString();
    }

    private static RString create出力名(RString 証発行モード, RString 出力対象) {
        RStringBuilder printName = new RStringBuilder();

        if (証発行モード_被保険者.equals(証発行モード)) {
            printName.append(STR_被保険者);
        } else if (証発行モード_資格者.equals(証発行モード)) {
            printName.append(STR_資格者);
        }
        if (発行対象_発行管理リスト.equals(出力対象)) {
            printName.append(STR_証発行管理リスト);
        } else if (発行対象_未回収者リスト.equals(出力対象)) {
            printName.append(STR_証未回収者リスト);
        }

        return printName.toRString();
    }
}
