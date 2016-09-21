/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額証明書発行一覧表の帳票出力項目管理Enumクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public enum JikoFutangakushomeishoShutsuryokujunEnum implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString(""), new RString("\"Atesaki_yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString(""), new RString("\"Atesaki_choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"Atesaki_gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"kogakuGassanTemp_hihokenshaNo\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString(""), new RString("\"dbT3071KogakuGassanJikoFutanGakuMeisai_hokenshaNo\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString(""), new RString("\"dbT3071KogakuGassanJikoFutanGakuMeisai_hokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"dbT3071KogakuGassanJikoFutanGakuMeisai_hihokenshaNo\"")),
    /**
     * 申請書整理番号
     */
    申請書整理番号(new RString("0337"), new RString(""), new RString("\"dbT3071KogakuGassanJikoFutanGakuMeisai_shikyuShinseishoSeiriNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private JikoFutangakushomeishoShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
