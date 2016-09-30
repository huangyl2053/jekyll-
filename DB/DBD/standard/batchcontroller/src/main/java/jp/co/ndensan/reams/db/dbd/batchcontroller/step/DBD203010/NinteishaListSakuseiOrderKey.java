/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD203010;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人軽減認定者リスト作成_バッチフ処理クラスです。
 *
 * @reamsid_L DBD-3830-030 tianyh
 */
public enum NinteishaListSakuseiOrderKey implements IReportItems {

    /**
     * 項目ID:0001 フォームフィールド名:郵便番号 MyBatis項目名:定義なし
     */
    郵便番号("0001", "郵便番号", "\"ShikibetsuTaisho\".\"yubinNo\""),
    //    郵便番号("0001", "郵便番号", "shikibetsuCode.\"yubinNo\""),
    /**
     * 項目ID:0002 フォームフィールド名:町域コード MyBatis項目名:定義なし
     */
    町域コード("0002", "町域コード", "\"ShikibetsuTaisho\".\"choikiCode\""),
    //    町域コード("0002", "町域コード", "shikibetsuCode.\"choikiCode\""),
    /**
     * 項目ID:0003 フォームフィールド名:番地コード MyBatis項目名:定義なし
     */
    番地コード("0003", "番地コード", "\"ShikibetsuTaisho\".\"banchiCode1\""),
    //    番地コード("0003", "番地コード", "shikibetsuCode.\"banchiCode1\""),
    /**
     * 項目ID:0004 フォームフィールド名:行政区コード MyBatis項目名:定義なし
     */
    行政区コード("0004", "行政区コード", "\"ShikibetsuTaisho\".\"gyoseikuCode\""),
    /**
     * 項目ID:0005 フォームフィールド名:地区１ MyBatis項目名:定義なし
     */
    地区１("0005", "地区１", "\"ShikibetsuTaisho\".\"chikuName1\""),
    /**
     * 項目ID:0006 フォームフィールド名:地区 2 MyBatis項目名:定義なし
     */
    地区2("0006", "地区2", "\"ShikibetsuTaisho\".\"chikuName2\""),
    /**
     * 項目ID:0008 フォームフィールド名:世帯コードMyBatis項目名:定義なし
     */
    世帯コード("0008", "世帯コード", "\"ShikibetsuTaisho\".\"setaiCode\""),
    //    世帯コード("0008", "世帯コード", "shikibetsuCode.\"setaiCode\""),
    /**
     * 項目ID:0009 フォームフィールド名:識別コードMyBatis項目名:定義なし
     */
    識別コード("0009", "識別コード", "\"ShikibetsuTaisho\".\"shikibetsuCode\""),
    //    識別コード("0009", "識別コード", "shikibetsuCode.\"shikibetsuCode\""),
    /**
     * 項目ID:0010 フォームフィールド名:氏名５０音カナMyBatis項目名:定義なし
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "\"ShikibetsuTaisho\".\"gaikokujinKanaShimei\""),
    /**
     * 項目ID:0012 フォームフィールド名:生年月日MyBatis項目名:定義なし
     */
    生年月日("0012", "生年月日", "\"ShikibetsuTaisho\".\"seinengappiYMD\""),
    /**
     * 項目ID:0013 フォームフィールド名:性別MyBatis項目名:定義なし
     */
    性別("0013", "性別", "\"ShikibetsuTaisho\".\"seibetsuCode\""),
    /**
     * 項目ID:0016 フォームフィールド名:市町村コード MyBatis項目名:定義なし
     */
    市町村コード("0013", "市町村コード", "受給者台帳Newest.\"shichosonCode\""),
    /**
     * 項目ID:0103 フォームフィールド名:証記載保険者番号 MyBatis項目名:定義なし
     */
    証記載保険者番号("0103", "証記載保険者番号", "社会福祉法人等利用者負担軽減.\"shoKisaiHokenshaNo\""),
    /**
     * 項目ID:0104 フォームフィールド名:被保険者番号 MyBatis項目名:定義なし
     */
    被保険者番号("0104", "被保険者番号", "被保険者番号"),
    /**
     * 項目ID:0110 フォームフィールド名:確認番号 MyBatis項目名:定義なし
     */
    確認番号("0110", "確認番号", "社会福祉法人等利用者負担軽減.\"kakuninNo\""),
    /**
     * 項目ID:0311 フォームフィールド名:計画事業者番号 MyBatis項目名:定義なし
     */
    計画事業者番号("0311", "計画事業者番号", "計画事業者番号");

    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString 項目名;

    private NinteishaListSakuseiOrderKey(String 項目ID, String フォームフィールド名, String 項目名) {
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
