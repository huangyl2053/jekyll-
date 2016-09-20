/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyufukanrihyo;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト(給付管理票)ORDERBYデータの編集クラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
public enum HanyoListKyufuKanriHyoOutputOrder implements IReportItems {

    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho\".\"gyoseikuCode\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"ShikibetsuTaisho\".\"setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString(""), new RString("\"DbT1001HihokenshaDaicho\".\"shichosonCode\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString(""), new RString("\"KyufuKanrihyo\".\"shokisaiHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"KyufuKanrihyo\".\"hiHokenshaNo\"")),
    /**
     * 支給区分コード
     */
    要介護度(new RString("0403"), new RString(""), new RString("")),
    /**
     * 申請書整理番号
     */
    認定開始日(new RString("0411"), new RString(""), new RString("")),
    /**
     * 新規継続区分
     */
    サービス年月(new RString("0301"), new RString(""), new RString("\"KyufuKanrihyo\".\"serviceTeikyoYM\"")),
    /**
     * 新規継続区分
     */
    計画事業者番号(new RString("0311"), new RString(""), new RString(""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HanyoListKyufuKanriHyoOutputOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
        this.項目ID = 項目ID;
        this.フォームフィールド名 = フォームフィールド名;
        this.myBatis項目名 = myBatis項目名;
    }

    @Override
    public RString get項目ID() {
        return 項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return myBatis項目名;
    }

}
