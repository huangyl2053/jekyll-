/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakugassan;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成の帳票出力項目管理Enumクラスです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public enum KogakugassanHoseisumiJikofutangakuOutputOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"DbWT1001Hihokensha\".\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"DbWT1001Hihokensha\".\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"DbWT1001Hihokensha\".\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"DbWT1001Hihokensha\".\"shimei50onKana\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("\"DbWT1001Hihokensha\".\"shichosonCode\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("\"DbWT37K1KogakuGassanJikoFutanGaku\".\"shoKisaiHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"DbWT37K1KogakuGassanJikoFutanGaku\".\"hihokenshaNo\"")),
    /**
     * 対象年度
     */
    対象年度(new RString("0334"), new RString("対象年度"), new RString("\"DbWT37K1KogakuGassanJikoFutanGaku\".\"taishoNendo\"")),
    /**
     * 申請書整理番号
     */
    申請書整理番号(new RString("0337"), new RString("申請書整理番号"), new RString("\"DbWT37K1KogakuGassanJikoFutanGaku\".\"shikyuShinseishoSeiriNo\"")),
    /**
     * 受取年月
     */
    受取年月(new RString("0371"), new RString("受取年月"), new RString("\"DbWT37K1KogakuGassanJikoFutanGaku\".\"shomeisho_UketoriYM\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KogakugassanHoseisumiJikofutangakuOutputOrder(RString 項目ID, RString フォームフィールド名,
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
