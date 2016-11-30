/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaici;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「本算定賦課計算」の出力順クラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public enum HonsanteiKekkaIcihiranOutPutOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"ShikibetsuTaisho\".\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"ShikibetsuTaisho\".\"choikiCode\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"dbT2015KeisangoJoho_setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("\"dbT2015KeisangoJoho_shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"ShikibetsuTaisho\".\"kanaMeisho\"")),
    /**
     * 生年月日
     */
    生年月日(new RString("0012"), new RString("生年月日"), new RString("\"ShikibetsuTaisho\".\"seinengappiYMD\"")),
    /**
     * 性別
     */
    性別(new RString("0013"), new RString("性別"), new RString("\"ShikibetsuTaisho\".\"seibetsuCode\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("\"dbT2015KeisangoJoho_fukaShichosonCode\"")),
    /**
     * 通知書番号
     */
    通知書番号(new RString("0202"), new RString("通知書番号"), new RString("\"dbT2015KeisangoJoho_tsuchishoNo\"")),
    /**
     * 徴収方法
     */
    徴収方法(new RString("0209"), new RString("徴収方法"), new RString("\"ShuturyokuTemp_choshuHoho\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"dbT2015KeisangoJoho_hihokenshaNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HonsanteiKekkaIcihiranOutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
