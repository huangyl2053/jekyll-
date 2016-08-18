/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費過誤決定通知書情報取込（公費負担者分）取込一覧表帳票の出力順と改ページenum。
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
public enum SogojigyohiKagoKetteitsuchishoTorikomiOutPutOrder implements IReportItems {

    /**
     * 公費負担者番号
     */
    公費負担者番号(new RString("0134"), new RString("kohiFutanshaNo"), new RString("DbWT3061.\"kohiFutanshaNo\"")),
    /**
     * 郵便番号			
     */
    郵便番号(new RString("0019"), new RString("yubinNo"), new RString("DbWT0001.\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0020"), new RString("choikiCode"), new RString("DbWT0001.\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0021"), new RString("gyoseikuCode"), new RString("DbWT0001.\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0022"), new RString("shimei50onKana"), new RString("DbWT0001.\"shimei50onKana\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0023"), new RString("shichosonCode"), new RString("DbWT0001.\"shichosonCode\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0360"), new RString("hihokenshaNo"), new RString("DbWT0001.\"hihokenshaNo\"")),
    /**
     * サービス提供年月
     */
    サービス提供年月(new RString("0361"), new RString("serviceTeikyoYM"), new RString("DbWT3061.\"serviceTeikyoYM\"")),
    /**
     * 事業者番号
     */
    事業者番号(new RString("0362"), new RString("jigyoshoNo"), new RString("DbWT3061.\"jigyoshoNo\"")),
    /**
     * 取り扱い年月
     */
    取り扱い年月(new RString("0363"), new RString("toriatsukaiYM"), new RString("DbWT3061.\"toriatsukaiYM\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private SogojigyohiKagoKetteitsuchishoTorikomiOutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
