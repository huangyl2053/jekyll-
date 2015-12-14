package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出納整理対象年度を表す列挙型です。
 *
 * @author LDNS
 */
public enum SuitoSeiriTaishoNendo {

    /**
     * 名称:現年度_増額減額 略称:定義なし
     */
    現年度_増額減額("現年度_増額減額"),
    /**
     * 名称:現年度_減額のみ 略称:定義なし
     */
    現年度_減額のみ("現年度_減額のみ"),
    /**
     * 名称:過年度_増額減額 略称:定義なし
     */
    過年度_増額減額("過年度_増額減額");

    private final RString fullName;

    private SuitoSeiriTaishoNendo(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 出納整理対象年度の名称を返します。
     *
     * @return 出納整理対象年度の名称
     */
    public RString get名称() {
        return fullName;
    }

}
