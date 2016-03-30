package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 被保険者台帳一覧表ボディーItemクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoHakkoIchiranhyoBodyItem {

    private final RString listUpper_1;
    private final RString listUpper_2;
    private final RString listUpper_3;
    private final RString listUpper_4;
    private final RString listUpper_5;
    private final RString listUpper_6;
    private final RString listUpper_7;
    private final RString listUpper_8;
    private final RString listUpper_9;
    private final RString listNo_1;
    private final RString listLower_1;
    private final RString listLower_2;
    private final RString listLower_3;
    private final RString listLower_4;
    private final RString listLower_5;
    private final RString listLower_6;
    private final RString listLower_7;

    /**
     * インスタンスを生成します。
     *
     * @param listUpper_1 氏名カナ
     * @param listUpper_2 性別
     * @param listUpper_3 年齢
     * @param listUpper_4 行政区
     * @param listUpper_5 識別コード
     * @param listUpper_6 状態区分
     * @param listUpper_7 生保
     * @param listUpper_8 備考
     * @param listUpper_9 No
     * @param listNo_1 被保険者番号
     * @param listLower_1 氏名
     * @param listLower_2 生年月日
     * @param listLower_3 住所
     * @param listLower_4 郵便番号
     * @param listLower_5 世帯コード
     * @param listLower_6 資格区分
     * @param listLower_7 老福
     */
    public HihokenshaDaichoHakkoIchiranhyoBodyItem(
            RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listUpper_4,
            RString listUpper_5,
            RString listUpper_6,
            RString listUpper_7,
            RString listUpper_8,
            RString listUpper_9,
            RString listNo_1,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3,
            RString listLower_4,
            RString listLower_5,
            RString listLower_6,
            RString listLower_7
    ) {
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listUpper_8 = listUpper_8;
        this.listUpper_9 = listUpper_9;
        this.listNo_1 = listNo_1;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        this.listLower_7 = listLower_7;
    }
}
