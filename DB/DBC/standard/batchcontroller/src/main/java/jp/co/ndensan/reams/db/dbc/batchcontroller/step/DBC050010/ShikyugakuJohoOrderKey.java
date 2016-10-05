/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細一覧表作成.出力順enum
 *
 * @reamsid_L DBC-2180-030 tianyh
 */
public enum ShikyugakuJohoOrderKey implements IReportItems {

    /**
     * 項目ID:0001 フォームフィールド名:郵便番号 MyBatis項目名:定義なし
     */
    郵便番号("0001", "郵便番号", "振込明細一時TBL.\"yubinNo\""),
    /**
     * 項目ID:0002 フォームフィールド名:町域コード MyBatis項目名:定義なし
     */
    町域コード("0002", "町域コード", "振込明細一時TBL.\"choikiCode\""),
    /**
     * 項目ID:0004 フォームフィールド名:行政区コード MyBatis項目名:定義なし
     */
    行政区コード("0004", "行政区コード", "振込明細一時TBL.\"gyoseikuCode\""),
    /**
     * 項目ID:0010 フォームフィールド名:氏名５０音カナ MyBatis項目名:定義なし
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "振込明細一時TBL.\"shimei50onKana\""),
    /**
     * 項目ID:0016 フォームフィールド名:市町村コード MyBatis項目名:定義なし
     */
    市町村コード("0016", "市町村コード", "振込明細一時TBL.\"shichosonCode\""),
    /**
     * 項目ID:0103 フォームフィールド名:証記載保険者番号 MyBatis項目名:定義なし
     */
    証記載保険者番号("0103", "証記載保険者番号", "振込明細一時TBL.\"shoKisaiHokenshaNo\""),
    /**
     * 項目ID:0103 フォームフィールド名:被保険者番号 MyBatis項目名:定義なし
     */
    被保険者番号("0104", "被保険者番号", "振込明細一時TBL.\"hihokenshaNo\""),
    /**
     * 項目ID:0311 フォームフィールド名:決定通知番号 MyBatis項目名:定義なし
     */
    決定通知番号("0307", "決定通知番号", "振込明細一時TBL.\"ketteiTsuchiNo\"");
    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString 項目名;

    private ShikyugakuJohoOrderKey(String 項目ID, String フォームフィールド名, String 項目名) {
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
