/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者情報更新結果情報取込一覧表帳票のenumです。
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public enum JukyushaKoshinKekkaIchiranOutputOrder implements IReportItems {

    /**
     * 保険者番号
     */
    保険者番号(new RString("0365"), new RString("hokenshaNo"), new RString("DbWT5331.\"hokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0164"), new RString("hihokenshaNo"), new RString("DbWT0001.\"hihokenshaNo\"")),
    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("yubinNo"), new RString("DbWT0001.\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("choikiCode"), new RString("DbWT0001.\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("gyoseikuCode"), new RString("DbWT0001.\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("shimei50onKana"), new RString("DbWT0001.\"shimei50onKana\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("DbWT0001.\"shichosonCode\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private JukyushaKoshinKekkaIchiranOutputOrder(RString 項目ID, RString フォームフィールド名,
            RString myBatis項目名) {
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
