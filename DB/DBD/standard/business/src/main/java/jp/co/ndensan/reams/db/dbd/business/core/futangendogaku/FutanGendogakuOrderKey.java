/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.futangendogaku;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定申請一括承認（バッチ）_結果一覧出力のEnumクラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
public enum FutanGendogakuOrderKey implements IReportItems {
    /**
     * 項目ID:0001 フォームフィールド名:郵便番号 MyBatis項目名:定義なし
     */
    郵便番号("0001", "郵便番号", "\"yubinNo\""),
    /**
     * 項目ID:0002 フォームフィールド名:町域コード MyBatis項目名:定義なし
     */
    町域コード("0002", "町域コード", "\"choikiCode\""),
    /**
     * 項目ID:0004 フォームフィールド名:行政区コード MyBatis項目名:定義なし
     */
    行政区コード("0004", "行政区コード", "\"gyoseikuCode\""),
    /**
     * 項目ID:0008 フォームフィールド名:世帯コード MyBatis項目名:定義なし
     */
    世帯コード("0008", "世帯コード", "\"setaiCode\""),
    /**
     * 項目ID:0009 フォームフィールド名:識別コード MyBatis項目名:定義なし
     */
    識別コード("0009", "識別コード", "\"shikibetsuCode\""),
    /**
     * 項目ID:0010 フォームフィールド名:氏名５０音カナMyBatis項目名:定義なし
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "\"gaikokujinKanaShimei\""),
    /**
     * 項目ID:0016 フォームフィールド名:市町村コード MyBatis項目名:定義なし
     */
    市町村コード("0016", "市町村コード", "\"shichosonCode\""),
    /**
     * 項目ID:0104 フォームフィールド名:被保険者番号 MyBatis項目名:定義なし
     */
    被保険者番号("0104", "被保険者番号", "\"hihokenshaNo\"");

    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString 項目名;

    private FutanGendogakuOrderKey(String 項目ID, String フォームフィールド名, String 項目名) {
        this.項目ID = new RString(項目ID);
        this.フォームフィールド名 = new RString(フォームフィールド名);
        this.項目名 = new RString(項目名);
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
        return 項目名;
    }

}
