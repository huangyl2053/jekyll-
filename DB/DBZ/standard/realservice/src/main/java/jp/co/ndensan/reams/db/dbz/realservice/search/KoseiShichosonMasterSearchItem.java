/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.search;

import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster.*;

/**
 * 構成市町村マスタテーブルを検索する際に条件指定する項目の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum KoseiShichosonMasterSearchItem implements ISearchItem {

    /**
     * 検索項目が「市町村コード」であることを表します。
     */
    市町村コード(shichosonCode),
    /**
     * 検索項目が「証記載保険者番号」であることを表します。
     */
    証記載保険者番号(shoKisaiHokenshaNo),
    /**
     * 検索項目が「合併旧市町村表示有無」であることを表します。
     */
    合併旧市町村表示有無(gappeiKyuShichosonHyojiUmu),
    /**
     * 検索項目が「合併情報地域番号」であることを表します。
     */
    合併情報地域番号(gappeiLinkNo);

    private final IColumnDefinition columnDefinition;

    private KoseiShichosonMasterSearchItem(IColumnDefinition columnDefinition) {
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
