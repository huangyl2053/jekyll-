/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収仮算定結果一覧表ののPageBreakenumクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public enum TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号("0001", "郵便番号", "\"atena_yubinNo\""),
    /**
     * 町域コード
     */
    町域コード("0002", "町域コード", "\"atena_choikiCode\""),
    /**
     * 行政区コード
     */
    行政区コード("0004", "行政区コード", "\"atena_gyoseikuCode\""),
    /**
     * 世帯コード
     */
    世帯コード("0008", "世帯コード", "\"atena_setaiCode\""),
    /**
     * 識別コード
     */
    識別コード("0009", "識別コード", "\"atena_shikibetsuCode\""),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "\"atena_kanaMeisho\""),
    /**
     * 生年月日
     */
    生年月日("0012", "生年月日", "\"atena_seinengappiYMD\""),
    /**
     * 性別
     */
    性別("0013", "性別", "\"atena_seibetsuCode\""),
    /**
     * 市町村コード
     */
    市町村コード("0016", "市町村コード", "\"fukaShichosonCode\""),
    /**
     * 通知書番号
     */
    通知書番号("0202", "通知書番号", "\"tsuchishoNo\""),
    /**
     * 被保険者番号
     */
    被保険者番号("0104", "被保険者番号", "\"hihokenshaNo\""),
    /**
     * 徴収方法
     */
    徴収方法("0209", "徴収方法", "\"shutsuryokujunTemp_choshuHoho\""),
    /**
     * 特徴開始月
     */
    特徴開始月("0213", "特徴開始月", "\"shutsuryokujunTemp_tokuchoKaisiTuki\"");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
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
