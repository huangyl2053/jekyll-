package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴依頼情報作成を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuchoIraiJohoSakusei {

    /**
     * 名称:_4月捕捉 略称:定義なし
     */
    _4月捕捉("_4月捕捉");

    private final RString fullName;

    private TokuchoIraiJohoSakusei(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴依頼情報作成の名称を返します。
     *
     * @return 特徴依頼情報作成の名称
     */
    public RString get名称() {
        return fullName;
    }

}
