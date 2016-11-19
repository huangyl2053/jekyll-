/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給（不支給）決定通知一覧表のの出力順enumクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public enum KetteiTsuchiIchiranOutPutOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号("0001", "郵便番号", "ShokanKetteiTsuchiShoMeisaiTemp.\"Atesaki_yubinNo\""),
    /**
     * 町域コード
     */
    町域コード("0002", "町域コード", "\"ShikibetsuTaisho\".\"choikiCode\""),
    /**
     * 行政区コード
     */
    行政区コード("0004", "行政区コード", "\"ShikibetsuTaisho\".\"gyoseikuCode\""),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "\"ShikibetsuTaisho\".\"kanaMeisho\""),
    /**
     * 市町村コード
     */
    市町村コード("0016", "市町村コード", "\"ShikibetsuTaisho\".\"genLasdecCode\""),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号("0103", "証記載保険者番号", "ShokanKetteiTsuchiShoMeisaiTemp.\"shoKisaiHokenshaNo\""),
    /**
     * 被保険者番号
     */
    被保険者番号("0104", "被保険者番号", "ShokanKetteiTsuchiShoMeisaiTemp.\"hiHokenshaNo\""),
    /**
     * 整理番号
     */
    整理番号("0305", "整理番号", "ShokanKetteiTsuchiShoMeisaiTemp.\"seiriNo\""),
    /**
     * 決定通知番号
     */
    決定通知番号("0307", "決定通知番号", "ShokanKetteiTsuchiShoMeisaiTemp.\"ketteiTsuchiNo\""),
    /**
     * 申請者区分
     */
    申請者区分("0325", "申請者区分", "ShokanKetteiTsuchiShoMeisaiTemp.\"shinseishaKubun\"");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KetteiTsuchiIchiranOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
        this.項目ID = new RString(項目ID);
        this.フォームフィールド名 = new RString(フォームフィールド名);
        this.myBatis項目名 = new RString(myBatis項目名);
    }

    @Override
    public RString get項目ID() {
        return this.項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return this.フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return this.myBatis項目名;
    }
}
