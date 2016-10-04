/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_エラー区分列挙型です。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
public enum KaigoGassan_ErrorKubun {

    /**
     * コード:01 名称:一般 略称:定義なし
     */
    被保険者情報取得エラー("01", "被保険者情報取得エラー", "被保険者・宛名情報取得", "被保険者台帳が存在しません。"),
    /**
     * コード:02 名称:一般 略称:定義なし
     */
    宛名取得エラー("02", "宛名取得エラー", "被保険者・宛名情報取得", "宛名が存在しません。"),
    /**
     * コード:03 名称:一般 略称:定義なし
     */
    高額支給額集計エラー("03", "高額支給額集計エラー", "高額支給額集計", "高額支給額がマイナス値です。"),
    /**
     * コード:04 名称:一般 略称:定義なし
     */
    資格期間エラー("04", "資格期間エラー", "資格期間不正", "");

    private final RString code;
    private final RString fullName;
    private final RString キー1;
    private final RString キー2;

    private KaigoGassan_ErrorKubun(String code, String fullName, String キー1, String キー2) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
        this.キー1 = new RString(キー1);
        this.キー2 = new RString(キー2);
    }

    /**
     * 介護合算_エラー区分のコードを返します。
     *
     * @return 介護合算_エラー区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_エラー区分の名称を返します。
     *
     * @return 介護合算_エラー区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_エラー区分のキー1を返します。
     *
     * @return キー1
     */
    public RString getキー1() {
        return キー1;
    }

    /**
     * 介護合算_エラー区分のキー2を返します。
     *
     * @return キー2
     */
    public RString getキー2() {
        return キー2;
    }

}
