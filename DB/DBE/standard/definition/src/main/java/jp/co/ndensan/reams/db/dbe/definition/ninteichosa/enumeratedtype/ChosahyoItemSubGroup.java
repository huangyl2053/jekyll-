/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査票項目サブグループを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosahyoItemSubGroup {

    /**
     * 2006年度の調査票項目サブグループを表す列挙型です。
     */
    public enum Of2006 implements IChosahyoItemSubGroup {

        /**
         * 調査票項目サブグループが「なし」であることを表します。
         */
        なし("なし"),
        /**
         * 調査票項目サブグループが「麻痺等の有無」であることを表します。
         */
        麻痺等の有無("1-1 麻痺等の有無(複数回答可)"),
        /**
         * 調査票項目サブグループが「拘縮の有無」であることを表します。
         */
        拘縮の有無("1-2 拘縮の有無(複数回答可)"),
        /**
         * 調査票項目サブグループが「処置内容」であることを表します。
         */
        処置内容("処置内容"),
        /**
         * 調査票項目サブグループが「特別な対応」であることを表します。
         */
        特別な対応("特別な対応");
        private RString name;

        private Of2006(String name) {
            this.name = new RString(name);
        }

        /**
         * 調査票項目サブグループの表示名称を返します。
         *
         * @return 表示名称
         */
        public RString getName() {
            return name;
        }
    }
}
