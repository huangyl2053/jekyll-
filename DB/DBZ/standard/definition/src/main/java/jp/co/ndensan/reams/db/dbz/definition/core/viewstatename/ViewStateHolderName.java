package jp.co.ndensan.reams.db.dbz.definition.core.viewstatename;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ViewStateHolder名称を表す列挙型です。
 *
 * @author LDNS
 */
public enum ViewStateHolderName {

    /**
     * コード:無し 名称:国保連取込情報 略称:定義なし
     */
    国保連取込情報("国保連取込情報");

    private final RString fullName;

    private ViewStateHolderName(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * ViewStateHolder名称の名称を返します。
     *
     * @return ViewStateHolder名称の名称
     */
    public RString get名称() {
        return fullName;
    }
}
