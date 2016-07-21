/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 本算定異動（現年度）結果一覧表帳票Propertyクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouProperty extends ReportPropertyBase<GenNendoHonsanteiIdouSource> {

    private static final RString FORMAT = new RString("\"");

    /**
     * コンストラクタです。
     */
    public GenNendoHonsanteiIdouProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200015.getReportId());
    }

    /**
     * 帳票分類ID「DBB200015_HonsanteiIdouKekkaIchiran」（本算定賦課計算）出力順設定可能項目です。
     */
    public enum DBB200015HonsanteiIdouKekkaIchiranEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), new RString("atena_yubinNo")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), new RString("atena_choikiCode")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), FORMAT.concat(new RString("dbT2015KeisangoJoho_setaiCode")).concat(FORMAT)),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), FORMAT.concat(new RString("dbT2015KeisangoJoho_shikibetsuCode")).concat(FORMAT)),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("setaiCode")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("生年月日"), new RString("atena_seinengappiYMD")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("性別"), new RString("atena_seibetsuCode")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("shichosonCode")),
        /**
         * 通知書番号
         */
        通知書番号(new RString("0202"), new RString("通知書番号"), FORMAT.concat(new RString("dbT2015KeisangoJoho_tsuchishoNo")).concat(FORMAT)),
        /**
         * 徴収方法
         */
        徴収方法(new RString("0209"), new RString("徴収方法"), new RString("")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), FORMAT.concat(new RString("dbT2015KeisangoJoho_hihokenshaNo")).concat(FORMAT));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB200015HonsanteiIdouKekkaIchiranEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
}
