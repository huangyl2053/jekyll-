/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisantei;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮算定額変更通知書発行一覧表の出力順クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public enum KariHenkoTsuchishoOutPutOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"atesaki_yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"atesaki_choikiCode\"")),
    /**
     * 番地コード
     */
    番地コード(new RString("0003"), new RString("番地コード"), new RString("\"atesaki_banchiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"atesaki_gyoseikuCode\"")),
    /**
     * 地区１
     */
    地区１(new RString("0005"), new RString("地区１"), new RString("\"atesaki_chikuCode1\"")),
    /**
     * 地区２
     */
    地区２(new RString("0006"), new RString("地区２"), new RString("\"atesaki_chikuCode2\"")),
    /**
     * 地区３
     */
    地区３(new RString("0007"), new RString("地区３"), new RString("\"atesaki_chikuCode3\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"shikibetsuTaisho_setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("\"shikibetsuTaisho_shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"shikibetsuTaisho_kanaMeisho\"")),
    /**
     * 生年月日
     */
    生年月日(new RString("0012"), new RString("生年月日"), new RString("\"shikibetsuTaisho_seinengappiYMD\"")),
    /**
     * 性別
     */
    性別(new RString("0013"), new RString("性別"), new RString("\"shikibetsuTaisho_seibetsuCode\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("\"dbT2015KeisangoJoho_fukaShichosonCode\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"dbT2015KeisangoJoho_hihokenshaNo\"")),
    /**
     * 年金コード
     */
    年金コード(new RString("0206"), new RString("年金コード"), new RString("\"dbT2015KeisangoJoho_kariNenkinCode\"")),
    /**
     * 納組コード
     */
    納組コード(new RString("0208"), new RString("納組コード"), new RString("\"caT0714nokumiCode\"")),
    /**
     * 生活保護種別
     */
    生活保護種別(new RString("0116"), new RString("生活保護種別"), new RString("\"dbT2015KeisangoJoho_seihofujoShurui\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KariHenkoTsuchishoOutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
