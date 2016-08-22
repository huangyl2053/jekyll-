/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800005;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問介護利用者負担額減額申請書 出力順設定可能項目です。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public enum HomonKaigoRiyoshaFutangakuGengakuShinseishoOrderKey implements IReportItems {

    /**
     * 項目ID:0001 フォームフィールド名:郵便番号 MyBatis項目名:郵便番号
     */
    郵便番号("0001", "郵便番号", "郵便番号"),
    /**
     * 項目ID:0002 フォームフィールド名:町域コード MyBatis項目名:町域コード
     */
    町域コード("0002", "町域コード", "町域コード"),
    /**
     * 項目ID:0004 フォームフィールド名:行政区コード MyBatis項目名:行政区コード
     */
    行政区コード("0004", "行政区コード", "行政区コード"),
    /**
     * 項目ID:0010 フォームフィールド名:氏名５０音カナ MyBatis項目名:氏名５０音カナ
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "氏名５０音カナ"),
    /**
     * 項目ID:0012 フォームフィールド名:生年月日 MyBatis項目名:生年月日
     */
    生年月日("0012", "生年月日", "生年月日"),
    /**
     * 項目ID:0016 フォームフィールド名:市町村コード MyBatis項目名:市町村コード
     */
    市町村コード("0016", "市町村コード", "市町村コード"),
    /**
     * 項目ID:0104 フォームフィールド名:被保険者番号 MyBatis項目名:被保険者番号
     */
    被保険者番号("0104", "被保険者番号", "被保険者番号");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString 項目名;

    private HomonKaigoRiyoshaFutangakuGengakuShinseishoOrderKey(String 項目ID, String フォームフィールド名, String 項目名) {
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
