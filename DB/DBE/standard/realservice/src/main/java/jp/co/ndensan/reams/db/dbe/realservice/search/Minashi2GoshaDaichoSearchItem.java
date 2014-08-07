/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.search;

import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaicho.*;

/**
 * みなし2号被保険者区分者台帳を検索する際に使用するSearchItemです。
 *
 * @author N8211 田辺 紘一
 */
public enum Minashi2GoshaDaichoSearchItem implements ISearchItem {

    //検索項目は取り合えず下記のみで、後に追加予定
    市町村コード(shichosonCode),
    識別コード(shikibetsuCode),
    被保険者番号(hihokenshaNo),
    みなし2号被保険者区分(hihokenshaKubunCode);

    private final IColumnDefinition columnDefinition;

    private Minashi2GoshaDaichoSearchItem(IColumnDefinition columnDefinition) {
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
