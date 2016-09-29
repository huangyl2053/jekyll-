/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.hanyolist;

import jp.co.ndensan.reams.db.dbz.entity.report.hanyolist.HanyoListReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 汎用リストのプロパティです。
 *
 * @reamsid_L DBZ-4570-020 jinge
 */
public class HanyoListProperty extends ReportPropertyBase<HanyoListReportSource> {

    /**
     * コンストラクタです。
     */
    public HanyoListProperty() {
        super(SubGyomuCode.DBZ介護共通, new ReportId("DBZ700001_HanyoList"));
    }

    /**
     * 汎用リスト出力順設定可能項目です。
     */
    public enum HanyoListEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), new RString("")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), new RString("")),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString(""), new RString("")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("")),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString(""), new RString("")),
        /**
         * 地区２
         */
        地区２(new RString("0006"), new RString(""), new RString("")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), new RString("")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), new RString("")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), new RString("")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString(""), new RString("")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("")),
        /**
         * 資格取得日
         */
        資格取得日(new RString("0105"), new RString(""), new RString("")),
        /**
         * 資格喪失日
         */
        資格喪失日(new RString("0106"), new RString(""), new RString("")),
        /**
         * 資格区分(1･2)
         */
        資格区分(new RString("0107"), new RString(""), new RString("")),
        /**
         * 要介護度
         */
        要介護度(new RString("0403"), new RString(""), new RString("")),
        /**
         * 受給申請区分
         */
        受給申請区分(new RString("0404"), new RString(""), new RString("")),
        /**
         * 認定開始日
         */
        認定開始日(new RString("0411"), new RString(""), new RString("")),
        /**
         * 受給申請日
         */
        受給申請日(new RString("0405"), new RString(""), new RString("")),
        /**
         * 老健受給者番号
         */
        老健受給者番号(new RString("0115"), new RString(""), new RString("")),
        /**
         * 指定事業者番号
         */
        指定事業者番号(new RString("0303"), new RString(""), new RString("")),
        /**
         * 認定日
         */
        認定日(new RString("0407"), new RString(""), new RString("")),
        /**
         * 調査委託日
         */
        調査委託日(new RString("0412"), new RString(""), new RString(""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private HanyoListEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
