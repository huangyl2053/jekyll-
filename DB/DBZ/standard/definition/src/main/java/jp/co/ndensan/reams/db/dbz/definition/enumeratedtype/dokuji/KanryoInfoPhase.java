/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.dokuji;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了情報の現在のフェーズを表す列挙型です。
 *
 */
public enum KanryoInfoPhase {

    /**
     * コード:01 名称:申請受付 略称:定義なし
     */
    申請受付("01", "申請受付"),
    /**
     * コード:02 名称:調査依頼 略称:定義なし
     */
    調査依頼("02", "調査依頼"),
    /**
     * コード:03 名称:意見書依頼 略称:定義なし
     */
    意見書依頼("03", "意見書依頼"),
    /**
     * コード:04 名称:調査入手 略称:定義なし
     */
    調査入手("04", "調査入手"),
    /**
     * コード:05 名称:意見書入手 略称:定義なし
     */
    意見書入手("05", "意見書入手"),
    /**
     * コード:06 名称:一次判定 略称:定義なし
     */
    一次判定("06", "一次判定"),
    /**
     * コード:07 名称:マスキング 略称:定義なし
     */
    マスキング("07", "マスキング"),
    /**
     * コード:08 名称:審査会登録 略称:定義なし
     */
    審査会登録("08", "審査会登録"),
    /**
     * コード:09 名称:二次判定 略称:定義なし
     */
    二次判定("09", "二次判定"),
    /**
     * コード:10 名称:月例処理 略称:定義なし
     */
    月例処理("10", "月例処理");
    private final RString code;
    private final RString fullName;

    private KanryoInfoPhase(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 完了情報の現在のフェーズのコードを返します。
     *
     * @return 完了情報の現在のフェーズのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 完了情報の現在のフェーズの名称を返します。
     *
     * @return 完了情報の現在のフェーズの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 完了情報の現在のフェーズのコードと一致する内容を探します。
     *
     * @param code 完了情報の現在のフェーズのコード
     * @return {@code code} に対応する完了情報の現在のフェーズ
     */
    public static KanryoInfoPhase toValue(RString code) {
        for (KanryoInfoPhase shujiiOutputSort : KanryoInfoPhase.values()) {
            if (shujiiOutputSort.code.equals(code)) {
                return shujiiOutputSort;
            }
        }
        return null;
    }
}
