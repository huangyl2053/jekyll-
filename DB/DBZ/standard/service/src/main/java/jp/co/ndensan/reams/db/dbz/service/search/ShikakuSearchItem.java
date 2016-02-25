/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.search;

import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV7901ShikakuSearch.JukyushaDaichoHihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV7901ShikakuSearch.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV7901ShikakuSearch.jushochiTokureiFlag;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV7901ShikakuSearch.shikakuSoshitsuYMD;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchItem;

/**
 * 資格検索Viewの条件検索で使用する列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShikakuSearchItem implements ISearchItem {

    /**
     * 検索項目が「被保険者番号」であることを表します。
     */
    被保険者番号(hihokenshaNo),
    /**
     * 検索項目が「住所地特例フラグ」であることを表します。
     */
    住所地特例フラグ(jushochiTokureiFlag),
    /**
     * 検索項目が「資格喪失日」であることを表します。
     */
    資格喪失日(shikakuSoshitsuYMD),
    /**
     * 検索項目が「受給者台帳_被保険者番号」であることを表します。
     */
    受給者台帳_被保険者番号(JukyushaDaichoHihokenshaNo);

    private final IColumnDefinition columnDefinition;

    private ShikakuSearchItem(IColumnDefinition columnDefinition) {
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
