/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200037;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳異動チェックリスト帳票のプロパティです。
 *
 * @reamsid_L DBD-1770-030 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdoCheckListProperty {

    /**
     * 帳票分類ID「DBD200037_JukyushaIdoCheckList」(受給者台帳異動チェックリスト) 出力順設定可能項目です。
     */
    public enum DBD200037_JukyushaIdoCheckListEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), new RString("")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), new RString("")),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString("番地コード"), new RString("")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), new RString("")),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString("地区１"), new RString("")),
        /**
         * 地区２
         */
        地区２(new RString("0006"), new RString("地区２"), new RString("")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), new RString("")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), new RString("")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("生年月日"), new RString("")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("性別"), new RString("")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("")),
        /**
         * 処理年月日
         */
        処理年月日(new RString("0317"), new RString("処理年月日"), new RString("")),
        /**
         * 処理種別
         */
        処理種別(new RString("0317"), new RString("処理種別"), new RString(""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBD200037_JukyushaIdoCheckListEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
