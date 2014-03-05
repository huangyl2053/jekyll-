/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査票項目グループを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosahyoItemGroup {

    /**
     * 2006年度の調査票項目グループを表す列挙型です。
     */
    public enum Of2006 implements IChosahyoItemGroup {

        /**
         * 調査票項目グループが「第１群」であることを表します。
         */
        第１群("第１群（身体機能・起居動作）"),
        /**
         * 調査票項目グループが「第２群」であることを表します。
         */
        第２群("第２群（生活機能）"),
        /**
         * 調査票項目グループが「第３群」であることを表します。
         */
        第３群("第３群（認知機能）"),
        /**
         * 調査票項目グループが「第４群」であることを表します。
         */
        第４群("第４群（精神・行動障害）"),
        /**
         * 調査票項目グループが「第５群」であることを表します。
         */
        第５群("第５群（社会生活への適応）"),
        /**
         * 調査票項目グループが「特別医療」であることを表します。
         */
        特別医療("６ 過去14日間にうけた特別な医療について（複数回答可）"),
        /**
         * 調査票項目グループが「自立度」であることを表します。
         */
        自立度("７ 調査対象者の日常生活自立度について");
        private RString name;

        private Of2006(String name) {
            this.name = new RString(name);
        }

        /**
         * 調査票項目グループの表示名称を返します。
         *
         * @return 表示名称
         */
        public RString getName() {
            return name;
        }
    }
}
