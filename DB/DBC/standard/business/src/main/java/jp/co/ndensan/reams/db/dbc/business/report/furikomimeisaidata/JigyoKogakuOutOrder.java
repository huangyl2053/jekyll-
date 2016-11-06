/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaidata;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細一覧表作成_事業高額の帳票出力項目管理Enumクラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public enum JigyoKogakuOutOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"DbWT0510FurikomiMeisai\".\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"DbWT0510FurikomiMeisai\".\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"DbWT0510FurikomiMeisai\".\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"DbWT0510FurikomiMeisai\".\"shimei50onKana\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("\"DbWT0510FurikomiMeisai\".\"shichosonCode\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("\"DbWT0510FurikomiMeisai\".\"shoKisaiHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"DbWT0510FurikomiMeisai\".\"hihokenshaNo\"")),
    /**
     * 申請書整理番号
     */
    決定通知番号(new RString("0307"), new RString("決定通知番号"), new RString("\"DbWT0510FurikomiMeisai\".\"ketteiTsuchiNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private JigyoKogakuOutOrder(RString 項目ID, RString フォームフィールド名,
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
