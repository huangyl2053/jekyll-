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
 * 被保険者を検索する際に、検索条件指定に使用するSearchItemです
 *
 * @author n8178 城間篤人
 */
public enum HihokenshaSearchItem implements ISearchItem {

    市町村コード(shichosonCode),
    識別コード(shikibetsuCode),
    被保険者番号(hihokenshaNo);

    private final IColumnDefinition columnDefinition;

    private HihokenshaSearchItem(IColumnDefinition columnDefinition) {
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
