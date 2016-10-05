/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤決定通知書情報取込一覧表（保険者分）帳票出力項目管理Enumクラスです。
 *
 * @reamsid_L DBC-0980-470 lijunjun
 */
public enum KagoKetteitsuchishoTorikomiIchiranHokenshaBunOutputOrder implements IReportItems {

    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("DbWT3060.\"shoKisaiHokenshaNo\"")),
    /**
     * 郵便番号
     */
    郵便番号(new RString("0019"), new RString("郵便番号"), new RString("DbWT0001.\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0020"), new RString("町域コード"), new RString("DbWT0001.\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0021"), new RString("行政区コード"), new RString("DbWT0001.\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0022"), new RString("氏名５０音カナ"), new RString("DbWT0001.\"shimei50onKana\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0360"), new RString("被保険者番号"), new RString("DbWT0001.\"hihokenshaNo\"")),
    /**
     * サービス提供年月
     */
    サービス提供年月(new RString("0361"), new RString("サービス提供年月"), new RString("DbWT3061.\"serviceTeikyoYM\"")),
    /**
     * 事業者番号
     */
    事業者番号(new RString("0362"), new RString("事業者番号"), new RString("DbWT3061.\"jigyoshoNo\"")),
    /**
     * 取り扱い年月
     */
    取り扱い年月(new RString("0363"), new RString("取り扱い年月"), new RString("DbWT3061.\"toriatsukaiYM\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KagoKetteitsuchishoTorikomiIchiranHokenshaBunOutputOrder(RString 項目ID, RString フォームフィールド名,
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
