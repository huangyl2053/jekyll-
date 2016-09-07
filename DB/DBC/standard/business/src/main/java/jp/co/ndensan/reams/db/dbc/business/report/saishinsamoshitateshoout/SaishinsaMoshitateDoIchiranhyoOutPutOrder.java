/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsamoshitateshoout;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付再審査申立書情報送付一覧表作成帳票の出力順と改ページenum。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public enum SaishinsaMoshitateDoIchiranhyoOutPutOrder implements IReportItems {

    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("shokisaiHokenshaNo"), new RString("DbWT1741.\"shokisaiHokenshaNo\"")),
    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("yubinNo"), new RString("DbWT1001.\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("choikiCode"), new RString("DbWT1001.\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("gyoseikuCode"), new RString("DbWT1001.\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("shimei50onKana"), new RString("DbWT1001.\"shimei50onKana\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("DbWT1001.\"shichosonCode\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("hiHokenshaNo"), new RString("DbWT1741.\"hiHokenshaNo\"")),
    /**
     * 事業者番号
     */
    事業者番号(new RString("0366"), new RString("jigyoshoNo"), new RString("DbWT1741.\"jigyoshoNo\"")),
    /**
     * サービス提供年月
     */
    サービス提供年月(new RString("0364"), new RString("serviceTeikyoYM"), new RString("DbWT1741.\"serviceTeikyoYM\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private SaishinsaMoshitateDoIchiranhyoOutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
