/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.nenreitotatsutorokushalistbatch;

import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.IBreakPageColumnMapping;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票「年齢到達者一覧表」を表す列挙型です。
 *
 * @author n3423
 */
public enum BreakPageRelateItem implements IBreakPageColumnMapping {

    /**
     * 世帯コード
     */
    setaiCode("setaiCode", "世帯コード", "listUpper_1"),
    /**
     * 識別コード
     */
    shikibetsuCode("shikibetsuCode", "識別コード", "listLower_1"),
    /**
     * 氏名５０音カナ
     */
    shimei50onKana("shimei50onKana", "氏名５０音カナ", "listUpper_2"),
    /**
     * 市町村コード
     */
    shichosonCode("shichosonCode", "市町村コード", "shichosonCode"),
    /**
     * 被保険者番号
     */
    hihokenshaNo("hihokenshaNo", "被保険者番号", "listHihokenshaNo_1");

    private final RString column;
    private final RString item;
    private final RString breakPageName;

    /**
     * コンストラクタです。
     *
     * @param column 項目名
     * @param tableName テーブル名
     */
    BreakPageRelateItem(String column, String item, String breakPageName) {
        this.column = new RString(column);
        this.item = new RString(item);
        this.breakPageName = new RString(breakPageName);
    }

    @Override
    public RString getColumn() {
        return this.column;
    }

    @Override
    public RString getItem() {
        return this.item;
    }

    @Override
    public RString getBreakPageName() {
        return this.breakPageName;
    }

    @Override
    public BreakPageRelateItem toValue(RString item) {
        for (BreakPageRelateItem relateitem : BreakPageRelateItem.values()) {
            if (relateitem.item.equals(item)) {
                return relateitem;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("該当の項目名").toString());
    }
}
