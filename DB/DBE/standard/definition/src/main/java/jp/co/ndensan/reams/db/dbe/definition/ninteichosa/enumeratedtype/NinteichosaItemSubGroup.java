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
        なし("");
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
     * 2006年の調査項目サブグループを表す列挙型です。
     */
    public enum Of2006 implements INinteichosaItemSubGroup {

        /**
         * 調査項目サブグループが「麻痺」であることを表します。
         */
        麻痺("１．麻痺"),
        /**
         * 調査項目サブグループが「拘縮」であることを表します。
         */
        拘縮("２．拘縮");
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
     * 2009年の調査項目サブグループを表す列挙型です。
     */
    public enum Of2009 implements INinteichosaItemSubGroup {

        /**
         * 調査項目サブグループが「麻痺等の有無」であることを表します。
         */
        麻痺等の有無("1-1 麻痺等の有無(複数回答可)"),
        /**
         * 調査項目サブグループが「拘縮の有無」であることを表します。
         */
        拘縮の有無("1-2 拘縮の有無(複数回答可)"),
        /**
         * 調査項目サブグループが「処置内容」であることを表します。
         */
        処置内容("処置内容"),
        /**
         * 調査項目サブグループが「特別な対応」であることを表します。
         */
        特別な対応("特別な対応");
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
