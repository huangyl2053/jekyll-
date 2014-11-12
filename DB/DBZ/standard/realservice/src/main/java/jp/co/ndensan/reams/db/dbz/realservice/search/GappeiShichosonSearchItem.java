/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.search;

import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson.*;

/**
 * 合併市町村テーブルを検索する際に条件指定する項目の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum GappeiShichosonSearchItem implements ISearchItem {

    合併日(gappeiYMD),
    地域番号(chiikiNo),
    旧市町村コード(kyuShichosonCode),
    旧保険者番号(kyuHokenshaNo),
    表示有無(hyojiUmu);

    private final IColumnDefinition columnDefinition;

    private GappeiShichosonSearchItem(IColumnDefinition columnDefinition) {
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
