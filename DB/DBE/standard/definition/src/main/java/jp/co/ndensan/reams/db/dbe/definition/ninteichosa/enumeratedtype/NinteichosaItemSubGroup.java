/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目サブグループを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaItemSubGroup {

    /**
     * 共通の調査項目サブグループを表す列挙型です。
     */
    public enum OfCommon implements INinteichosaItemSubGroup {

        /**
         * 調査項目サブグループが「なし」であることを表します。
         */
        なし("", "", "", false);
        private RString no;
        private RString name;
        private RString shortName;
        private boolean multiSelectable;

        private OfCommon(String no, String name, String shortName, boolean multiSelectable) {
            this.no = new RString(no);
            this.name = new RString(name);
            this.shortName = new RString(shortName);
            this.multiSelectable = multiSelectable;
        }

        @Override
        public RString getNo() {
            return no;
        }

        @Override
        public RString getName() {
            return name;
        }

        @Override
        public RString getShortName() {
            return shortName;
        }

        @Override
        public boolean isMultiSelectable() {
            return multiSelectable;
        }
    }

    /**
     * 2006年の調査項目サブグループを表す列挙型です。
     */
    public enum Of2006 implements INinteichosaItemSubGroup {

        /**
         * 調査項目サブグループが「麻痺」であることを表します。
         */
        麻痺("1", "１．麻痺", "麻痺", true),
        /**
         * 調査項目サブグループが「拘縮」であることを表します。
         */
        拘縮("2", "２．拘縮", "拘縮", true);
        private RString no;
        private RString name;
        private RString shortName;
        private boolean multiSelectable;

        private Of2006(String no, String name, String shortName, boolean multiSelectable) {
            this.no = new RString(no);
            this.name = new RString(name);
            this.shortName = new RString(shortName);
            this.multiSelectable = multiSelectable;
        }

        @Override
        public RString getNo() {
            return no;
        }

        @Override
        public RString getName() {
            return name;
        }

        @Override
        public RString getShortName() {
            return shortName;
        }

        @Override
        public boolean isMultiSelectable() {
            return multiSelectable;
        }
    }

    /**
     * 2009年の調査項目サブグループを表す列挙型です。
     */
    public enum Of2009 implements INinteichosaItemSubGroup {

        /**
         * 調査項目サブグループが「麻痺等の有無」であることを表します。
         */
        麻痺等の有無("1-1", "1-1 麻痺等の有無(複数回答可)", "麻痺等の有無", true),
        /**
         * 調査項目サブグループが「拘縮の有無」であることを表します。
         */
        拘縮の有無("1-2", "1-2 拘縮の有無(複数回答可)", "拘縮の有無", true),
        /**
         * 調査項目サブグループが「処置内容」であることを表します。
         */
        処置内容("6", "処置内容", "処置内容", true),
        /**
         * 調査項目サブグループが「特別な対応」であることを表します。
         */
        特別な対応("6", "特別な対応", "特別な対応", true);
        private RString no;
        private RString name;
        private RString shortName;
        private boolean multiSelectable;

        private Of2009(String no, String name, String shortName, boolean multiSelectable) {
            this.no = new RString(no);
            this.name = new RString(name);
            this.shortName = new RString(shortName);
            this.multiSelectable = multiSelectable;
        }

        @Override
        public RString getNo() {
            return no;
        }

        @Override
        public RString getName() {
            return name;
        }

        @Override
        public RString getShortName() {
            return shortName;
        }

        @Override
        public boolean isMultiSelectable() {
            return multiSelectable;
        }
    }
}
