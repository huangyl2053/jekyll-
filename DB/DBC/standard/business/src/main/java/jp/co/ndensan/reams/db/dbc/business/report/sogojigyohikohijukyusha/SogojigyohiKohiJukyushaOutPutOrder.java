/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikohijukyusha;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費公費受給者別一覧表帳票のPageBreakenumです。
 *
 * @reamsid_L DBC-4710-040 chenjie
 */
public enum SogojigyohiKohiJukyushaOutPutOrder implements IReportItems {

    /**
     * 公費負担者番号
     */
    公費負担者番号(new RString("0134"), new RString("kohiFutanshaNo"), new RString("DbWT6412.\"kohiFutanshaNo\"")),
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
    市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("DbWT0001.\"shichosonCode\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("hihokenshaNo"), new RString("DbWT0001.\"hihokenshaNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private SogojigyohiKohiJukyushaOutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
