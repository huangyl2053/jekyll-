/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.search;

import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJoho.*;

/**
 * 合併情報テーブルを検索する際に条件指定する項目の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum GappeiJohoSearchItem implements ISearchItem {

    合併日(gappeiYMD),
    地域番号(chiikiNo),
    市町村コード(shichosonCode),
    保険者番号(hokenshaNo),
    国保連データ連携開始日(kokuhorenDataFromYMD);

    private final IColumnDefinition columnDefinition;

    private GappeiJohoSearchItem(IColumnDefinition columnDefinition) {
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
