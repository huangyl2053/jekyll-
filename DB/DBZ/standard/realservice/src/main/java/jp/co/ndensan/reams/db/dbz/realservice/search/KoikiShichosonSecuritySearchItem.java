/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.search;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurity.*;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchItem;

/**
 * 広域市町村セキュリティテーブルを検索する際に条件指定する項目の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum KoikiShichosonSecuritySearchItem implements ISearchItem {

    /**
     * 検索項目が「グループID」であることを表します。
     */
    グループID(groupID);

    private final IColumnDefinition columnDefinition;

    private KoikiShichosonSecuritySearchItem(IColumnDefinition columnDefinition) {
        this.columnDefinition = columnDefinition;
    }

    @Override
    public String getItemName() {
        return columnDefinition.name();
    }

    @Override
    public IColumnDefinition getColumnDefinition() {
        return columnDefinition;
    }
}
