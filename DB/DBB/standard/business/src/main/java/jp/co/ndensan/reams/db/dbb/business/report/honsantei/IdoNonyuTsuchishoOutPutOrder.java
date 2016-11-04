/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsantei;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（本算定）発行一覧表の出力順クラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public enum IdoNonyuTsuchishoOutPutOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"Atesaki_yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"Atesaki_choikiCode\"")),
    /**
     * 番地コード1
     */
    番地コード1(new RString("0003"), new RString("番地コード1"), new RString("\"Atesaki_banchiCode1\"")),
    /**
     * 番地コード2
     */
    番地コード2(new RString("0003"), new RString("番地コード2"), new RString("\"Atesaki_banchiCode2\"")),
    /**
     * 番地コード3
     */
    番地コード3(new RString("0003"), new RString("番地コード3"), new RString("\"Atesaki_banchiCode3\"")),
    /**
     * 番地コード4
     */
    番地コード4(new RString("0003"), new RString("番地コード4"), new RString("\"Atesaki_banchiCode4\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"Atesaki_gyoseikuCode\"")),
    /**
     * 地区１
     */
    地区１(new RString("0005"), new RString("地区１"), new RString("\"Atesaki_chikuCode1\"")),
    /**
     * 地区２
     */
    地区２(new RString("0006"), new RString("地区２"), new RString("\"Atesaki_chikuCode2\"")),
    /**
     * 地区３
     */
    地区３(new RString("0007"), new RString("地区３"), new RString("\"Atesaki_chikuCode3\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"ShikibetsuTaisho_setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("\"ShikibetsuTaisho_shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"ShikibetsuTaisho_kanaMeisho\"")),
    /**
     * 生年月日
     */
    生年月日(new RString("0012"), new RString("生年月日"), new RString("\"ShikibetsuTaisho_seinengappiYMD\"")),
    /**
     * 性別
     */
    性別(new RString("0013"), new RString("性別"), new RString("\"ShikibetsuTaisho_seibetsuCode\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("\"dbT2015KeisangoJoho_fukaShichosonCode\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"dbT2015KeisangoJoho_hihokenshaNo\"")),
    /**
     * 納組コード
     */
    納組コード(new RString("0208"), new RString("納組コード"), new RString("\"CaT0714nokumiCode\"")),
    /**
     * 生活保護種別
     */
    生活保護種別(new RString("0116"), new RString("生活保護種別"), new RString("\"生活保護区分\"")),
    /**
     * 現金口座区分
     */
    現金口座区分(new RString("0210"), new RString("現金口座区分"), new RString("\"dbT2015KeisangoJoho_kozaKubun\"")),
    /**
     * 8月特徴開始者
     */
    //QA1854 確認中
    八月特徴開始者(new RString("0220"), new RString("八月特徴開始者"), new RString("\"dbT2015KeisangoJoho_sakuseiShoriName\"")),
    /**
     * 10月特徴開始者
     */
    //QA1854 確認中
    十月特徴開始者(new RString("0219"), new RString("十月特徴開始者"), new RString("\"dbT2015KeisangoJoho_sakuseiShoriName\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private IdoNonyuTsuchishoOutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
