/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice.search;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護サービス種類の情報を表す列挙型です。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス種類検索項目
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public enum KaigoServiceShuruiSearchItem implements ISearchItem {

    /**
     * 介護サービス種類
     */
    介護サービス種類(DbT7130KaigoServiceShurui.serviceShuruiCd),
    /**
     * 提供開始年月
     */
    提供開始年月(DbT7130KaigoServiceShurui.teikyoKaishiYM),
    /**
     * 提供終了年月
     */
    提供終了年月(DbT7130KaigoServiceShurui.teikyoshuryoYM),
    /**
     * 介護サービス名称
     */
    介護サービス名称(DbT7130KaigoServiceShurui.serviceShuruiMeisho),
    /**
     * 介護サービス名称略称
     */
    介護サービス名称略称(DbT7130KaigoServiceShurui.serviceShuruiRyakusho),
    /**
     * 介護サービス分類
     */
    介護サービス分類(DbT7130KaigoServiceShurui.serviceBunrruicode);
    private IColumnDefinition columnDefinition;

    private KaigoServiceShuruiSearchItem(IColumnDefinition columnDefinition) {
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
