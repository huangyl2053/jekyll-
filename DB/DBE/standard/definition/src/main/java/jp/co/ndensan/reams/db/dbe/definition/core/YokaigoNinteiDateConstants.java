/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定関係の日付定数を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public final class YokaigoNinteiDateConstants {

    /**
     * 認定調査完了年月日の初期状態の日付を表します。
     */
    public static final FlexibleDate 認定調査未完了年月日;
    /**
     * 認定調査依頼完了年月日の初期状態の日付を表します。
     */
    public static final FlexibleDate 認定調査依頼未完了年月日;
    /**
     * 主治医意見書登録完了年月日の初期状態の日付を表します。
     */
    public static final FlexibleDate 主治医意見書登録未完了年月日;
    /**
     * 主治医意見書作成依頼完了年月日の初期状態の日付を表します。
     */
    public static final FlexibleDate 主治医意見書作成依頼未完了年月日;

    private static final RString ZERO = new RString("00000000");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private YokaigoNinteiDateConstants() {
    }

    static {
        認定調査未完了年月日 = new FlexibleDate(ZERO);
        認定調査依頼未完了年月日 = new FlexibleDate(ZERO);
        主治医意見書登録未完了年月日 = new FlexibleDate(ZERO);
        主治医意見書作成依頼未完了年月日 = new FlexibleDate(ZERO);
    }
}
