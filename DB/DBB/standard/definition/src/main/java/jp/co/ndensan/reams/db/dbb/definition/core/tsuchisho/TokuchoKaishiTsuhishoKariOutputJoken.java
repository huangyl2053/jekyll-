package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始通知書仮算定出力条件を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuchoKaishiTsuhishoKariOutputJoken {

    /**
     * 名称:全件_追加候補者含む 略称:定義なし
     */
    全件_追加候補者含む("全件_追加候補者含む"),
    /**
     * 名称:全件_追加候補者含まない 略称:定義なし
     */
    全件_追加候補者含まない("全件_追加候補者含まない"),
    /**
     * 名称:追加候補者のみ全て 略称:定義なし
     */
    追加候補者のみ全て("追加候補者のみ全て"),
    /**
     * 名称:_4月特別徴収開始の追加候補者のみ 略称:定義なし
     */
    _4月特別徴収開始の追加候補者のみ("_4月特別徴収開始の追加候補者のみ"),
    /**
     * 名称:_6月特別徴収開始の追加候補者のみ 略称:定義なし
     */
    _6月特別徴収開始の追加候補者のみ("_6月特別徴収開始の追加候補者のみ");

    private final RString fullName;

    private TokuchoKaishiTsuhishoKariOutputJoken(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴開始通知書仮算定出力条件の名称を返します。
     *
     * @return 特徴開始通知書仮算定出力条件の名称
     */
    public RString get名称() {
        return fullName;
    }
}
