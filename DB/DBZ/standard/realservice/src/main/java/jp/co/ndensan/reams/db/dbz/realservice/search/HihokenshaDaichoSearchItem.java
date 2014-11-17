/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.search;

import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.*;

/**
 * 被保険者台帳テーブルを検索する際に条件指定する項目の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum HihokenshaDaichoSearchItem implements ISearchItem {

    市町村コード(shichosonCode),
    識別コード(shikibetsuCode);

    private final IColumnDefinition columnDefinition;

    private HihokenshaDaichoSearchItem(IColumnDefinition columnDefinition) {
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
