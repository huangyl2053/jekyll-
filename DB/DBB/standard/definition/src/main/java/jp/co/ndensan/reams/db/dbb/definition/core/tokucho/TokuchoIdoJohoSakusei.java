package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴異動情報作成を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuchoIdoJohoSakusei {

    /**
     * 名称:前年度12月捕捉 略称:定義なし
     */
    前年度12月捕捉("前年度12月捕捉"),
    /**
     * 名称:前年度2月捕捉 略称:定義なし
     */
    前年度2月捕捉("前年度2月捕捉"),
    /**
     * 名称:_6月捕捉 略称:定義なし
     */
    _6月捕捉("_6月捕捉"),
    /**
     * 名称:_8月捕捉 略称:定義なし
     */
    _8月捕捉("_8月捕捉"),
    /**
     * 名称:_10月捕捉 略称:定義なし
     */
    _10月捕捉("_10月捕捉");

    private final RString fullName;

    private TokuchoIdoJohoSakusei(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴異動情報作成の名称を返します。
     *
     * @return 特徴異動情報作成の名称
     */
    public RString get名称() {
        return fullName;
    }
}
