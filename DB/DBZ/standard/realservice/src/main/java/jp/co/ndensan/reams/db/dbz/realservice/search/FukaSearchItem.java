/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.search;

import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV7902FukaSearch.*;

/**
 * 賦課検索Viewの条件検索で使用する列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum FukaSearchItem implements ISearchItem {

    /**
     * 検索項目が「賦課年度」であることを表します。
     */
    賦課年度(fukaNendo),
    /**
     * 検索項目が「通知書番号」であることを表します。
     */
    通知書番号(tsuchishoNo),
    /**
     * 検索項目が「賦課マスタ_被保険者番号」であることを表します。
     */
    賦課マスタ_被保険者番号(hihokenshaNo),
    /**
     * 検索項目が「被保険者台帳_被保険者番号」であることを表します。
     */
    被保険者台帳_被保険者番号(hihodaichoHihokenshaNo);

    private final IColumnDefinition columnDefinition;

    private FukaSearchItem(IColumnDefinition columnDefinition) {
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
