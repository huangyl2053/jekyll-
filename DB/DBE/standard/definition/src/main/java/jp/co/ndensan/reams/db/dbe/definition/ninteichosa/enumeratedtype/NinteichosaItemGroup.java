/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目グループを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaItemGroup {

    /**
     * 共通の調査項目グループを表す列挙型です。
     */
    public enum OfCommon implements INinteichosaItemGroup {

        /**
         * 調査項目グループが「なし」であることを表します。
         */
        なし("なし");
        private RString name;

        private OfCommon(String name) {
            this.name = new RString(name);
        }

        @Override
        public RString getName() {
            return name;
        }
    }

    /**
     * 2006年の調査項目グループを表す列挙型です。
     */
    public enum Of2006 implements INinteichosaItemGroup {

        /**
         * 調査項目グループが「サービス状況」であることを表します。
         */
        サービス状況(""),
        /**
         * 調査項目グループが「概況特記事項」であることを表します。
         */
        概況特記事項(""),
        /**
         * 調査項目グループが「第１群」であることを表します。
         */
        第１群("第１群（麻痺拘縮）"),
        /**
         * 調査項目グループが「第２群」であることを表します。
         */
        第２群("第２群（　移動　）"),
        /**
         * 調査項目グループが「第３群」であることを表します。
         */
        第３群("第３群（複雑動作）"),
        /**
         * 調査項目グループが「第４群」であることを表します。
         */
        第４群("第４群（特別介護）"),
        /**
         * 調査項目グループが「第５群」であることを表します。
         */
        第５群("第５群（身の回り）"),
        /**
         * 調査項目グループが「第６群」であることを表します。
         */
        第６群("第６群（意思疏通）"),
        /**
         * 調査項目グループが「第７群」であることを表します。
         */
        第７群("第７群（問題行動）"),
        /**
         * 調査項目グループが「特別医療」であることを表します。
         */
        特別医療("＜特別な医療＞"),
        /**
         * 調査項目グループが「自立度」であることを表します。
         */
        自立度("");
        private RString name;

        private Of2006(String name) {
            this.name = new RString(name);
        }

        @Override
        public RString getName() {
            return name;
        }
    }

    /**
     * 2009年の調査項目グループを表す列挙型です。
     */
    public enum Of2009 implements INinteichosaItemGroup {

        /**
         * 調査項目グループが「サービス状況」であることを表します。
         */
        サービス状況(""),
        /**
         * 調査項目グループが「概況特記事項」であることを表します。
         */
        概況特記事項(""),
        /**
         * 調査項目グループが「第１群」であることを表します。
         */
        第１群("第１群（身体機能・起居動作）"),
        /**
         * 調査項目グループが「第２群」であることを表します。
         */
        第２群("第２群（生活機能）"),
        /**
         * 調査項目グループが「第３群」であることを表します。
         */
        第３群("第３群（認知機能）"),
        /**
         * 調査項目グループが「第４群」であることを表します。
         */
        第４群("第４群（精神・行動障害）"),
        /**
         * 調査項目グループが「第５群」であることを表します。
         */
        第５群("第５群（社会生活への適応）"),
        /**
         * 調査項目グループが「特別医療」であることを表します。
         */
        特別医療("６ 過去14日間にうけた特別な医療について（複数回答可）"),
        /**
         * 調査項目グループが「自立度」であることを表します。
         */
        自立度("７ 調査対象者の日常生活自立度について");
        private RString name;

        private Of2009(String name) {
            this.name = new RString(name);
        }

        @Override
        public RString getName() {
            return name;
        }
    }
}
