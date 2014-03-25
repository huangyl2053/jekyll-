/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の項目グループ（2009年改訂版）を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShujiiIkenshoItemGroupOf2009 implements IShujiiIkenshoItemGroup {

    /**
     * 意見書項目グループが「傷病」であることを表します。
     */
    傷病("1", "１．傷病に関する意見", "傷病"),
    /**
     * 意見書項目グループが「特別医療」であることを表します。
     */
    特別医療("2", "２．特別な医療", "特別医療"),
    /**
     * 意見書項目グループが「心身状態」であることを表します。
     */
    心身状態("3", "３．心身の状態に関する意見", "心身状態"),
    /**
     * 意見書項目グループが「生活機能_サービス」であることを表します。
     */
    生活機能_サービス("4", "４．生活機能とサービスに関する意見", "生活機能_サービス"),
    /**
     * 意見書項目グループが「特記事項」であることを表します。
     */
    特記事項("5", "５．特記すべき事項", "特記事項");
    private RString no;
    private RString name;
    private RString shortName;

    private ShujiiIkenshoItemGroupOf2009(String no, String name, String shortName) {
        this.no = new RString(no);
        this.name = new RString(name);
        this.shortName = new RString(shortName);
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
}
