/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(利用者負担割合)のOrderbyクラスです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
public enum HanyoListRiyoshaFutanwariaiOrderby implements IReportItems {

    /**
     * 項目ID:0001 フォームフィールド名:郵便番号 MyBatis項目名:定義なし
     */
    郵便番号("0001", "郵便番号", "\"ShikibetsuTaisho\".\"yubinNo\""),
    /**
     * 項目ID:0002 フォームフィールド名:町域コード MyBatis項目名:定義なし
     */
    町域コード("0002", "町域コード", "\"ShikibetsuTaisho\".\"choikiCode\""),
    /**
     * 項目ID:0003 フォームフィールド名:番地コード MyBatis項目名:定義なし
     */
    番地コード("0003", "番地コード", "\"ShikibetsuTaisho\".\"banchi\""),
    /**
     * 項目ID:0004 フォームフィールド名:行政区コード MyBatis項目名:定義なし
     */
    行政区コード("0004", "行政区コード", "\"ShikibetsuTaisho\".\"gyoseikuCode\""),
    /**
     * 項目ID:0005 フォームフィールド名:地区１ MyBatis項目名:定義なし
     */
    地区１("0005", "地区１", "\"ShikibetsuTaisho\".\"chikuCode1\""),
    /**
     * 項目ID:0006 フォームフィールド名:地区２ MyBatis項目名:定義なし
     */
    地区２("0006", "地区２", "\"ShikibetsuTaisho\".\"chikuCode2\""),
    /**
     * 項目ID:0008 フォームフィールド名:世帯コード MyBatis項目名:定義なし
     */
    世帯コード("0008", "世帯コード", "\"ShikibetsuTaisho\".\"setaiCode\""),
    /**
     * 項目ID:0009 フォームフィールド名:識別コード MyBatis項目名:定義なし
     */
    識別コード("0009", "識別コード", "\"ShikibetsuTaisho\".\"shikibetsuCode\""),
    /**
     * 項目ID:0010 フォームフィールド名:氏名５０音カナ MyBatis項目名:定義なし
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "\"ShikibetsuTaisho\".\"kanaShimei\""),
    /**
     * 項目ID:0012 フォームフィールド名:生年月日 MyBatis項目名:定義なし
     */
    生年月日("0012", "生年月日", "\"ShikibetsuTaisho\".\"seinengappiYMD\""),
    /**
     * 項目ID:0013 フォームフィールド名:性別 MyBatis項目名:定義なし
     */
    性別("0013", "性別", "\"ShikibetsuTaisho\".\"seibetsuCode\""),
    /**
     * 項目ID:0016 フォームフィールド名:市町村コード MyBatis項目名:定義なし
     */
    市町村コード("0016", "市町村コード", "被保険者台帳管理_市町村コード"),
    /**
     * 項目ID:0103 フォームフィールド名:証記載保険者番号 MyBatis項目名:定義なし
     */
    証記載保険者番号("0103", "証記載保険者番号", "利用者負担割合_証記載保険者番号"),
    /**
     * 項目ID:0104 フォームフィールド名:被保険者番号 MyBatis項目名:定義なし
     */
    被保険者番号("0104", "被保険者番号", "被保険者台帳管理_被保険者番号"),
    /**
     * 項目ID:0105 フォームフィールド名:資格取得日 MyBatis項目名:定義なし
     */
    資格取得日("0105", "資格取得日", "被保険者台帳管理_資格取得年月日"),
    /**
     * 項目ID:0106 フォームフィールド名:資格喪失日 MyBatis項目名:定義なし
     */
    資格喪失日("0106", "資格喪失日", "被保険者台帳管理_資格喪失年月日"),
    /**
     * 項目ID:0107 フォームフィールド名:資格区分(1･2) MyBatis項目名:定義なし
     */
    資格区分("0107", "資格区分(1･2)", "利用者負担割合明細_資格区分"),
    /**
     * 項目ID:0411 フォームフィールド名:認定開始日 MyBatis項目名:定義なし
     */
    認定開始日("0411", "認定開始日", "利用者負担割合明細_有効開始日");

    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString 項目名;

    private HanyoListRiyoshaFutanwariaiOrderby(String 項目ID, String フォームフィールド名, String 項目名) {
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
