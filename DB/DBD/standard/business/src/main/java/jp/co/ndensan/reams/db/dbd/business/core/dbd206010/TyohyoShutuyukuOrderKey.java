/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd206010;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のEnumクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
public enum TyohyoShutuyukuOrderKey implements IReportItems {

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
     * 項目ID:0010 フォームフィールド名:氏名５０音カナMyBatis項目名:定義なし
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "\"gaikokujinKanaShimei\""),
    /**
     * 項目ID:0016 フォームフィールド名:市町村コード MyBatis項目名:定義なし
     */
    市町村コード("0016", "市町村コード", "\"shichosonCode\""),
    /**
     * 項目ID:0103 フォームフィールド名:証記載保険者番号 MyBatis項目名:定義なし
     */
    証記載保険者番号("0103", "証記載保険者番号", "\"shoKisaiHokenshaNo\""),
    /**
     * 項目ID:0104 フォームフィールド名:被保険者番号 MyBatis項目名:定義なし
     */
    被保険者番号("0104", "被保険者番号", "\"hihokenshaNo\""),
    /**
     * 項目ID:0403 フォームフィールド名:要介護度 MyBatis項目名:定義なし
     */
    要介護度("0403", "要介護度", "");

    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString 項目名;

    private TyohyoShutuyukuOrderKey(String 項目ID, String フォームフィールド名, String 項目名) {
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
