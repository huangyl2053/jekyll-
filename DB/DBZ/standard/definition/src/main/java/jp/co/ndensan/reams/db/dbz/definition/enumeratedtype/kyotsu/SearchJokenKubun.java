package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索条件区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SearchJokenKubun {

    /**
     * コード:無し 名称:前方一致 略称:定義なし
     */
    前方一致("前方一致"),
    /**
     * コード:無し 名称:完全一致 略称:定義なし
     */
    完全一致("完全一致");

    private final RString fullName;

    private SearchJokenKubun(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 検索条件区分の名称を返します。
     *
     * @return 検索条件区分の名称
     */
    public RString get名称() {
        return fullName;
    }

}
