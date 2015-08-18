/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice.search;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyou;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護サービス内容の情報を表す列挙型です。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス内容検索項目
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public enum KaigoServiceNaiyoSearchItem implements ISearchItem {

    /**
     * 介護サービス種類コード
     */
    介護サービス種類コード(DbT7131KaigoServiceNaiyou.serviceShuruiCode),
    /**
     * 介護サービス項目コード
     */
    介護サービス項目コード(DbT7131KaigoServiceNaiyou.serviceKoumokuCode),
    /**
     * 適用開始年月
     */
    適用開始年月(DbT7131KaigoServiceNaiyou.teikyoKaishiYM),
    /**
     * 適用終了年月
     */
    適用終了年月(DbT7131KaigoServiceNaiyou.teikyoShuryoYM),
    /**
     * サービス名称
     */
    サービス名称(DbT7131KaigoServiceNaiyou.serviceName),
    /**
     * サービス略称
     */
    サービス略称(DbT7131KaigoServiceNaiyou.serviceNameRyaku),
    /**
     * 履歴番号
     */
    履歴番号(DbT7131KaigoServiceNaiyou.rirekiNo),
    /**
     * 単位数
     */
    単位数(DbT7131KaigoServiceNaiyou.taniSu),
    /**
     * 単位数識別
     */
    単位数識別(DbT7131KaigoServiceNaiyou.tanisuShikibetsuCode),
    /**
     * 単位数算定単位
     */
    単位数算定単位(DbT7131KaigoServiceNaiyou.tanisuSanteiTani);
    private IColumnDefinition columnDefinition;

    private KaigoServiceNaiyoSearchItem(IColumnDefinition columnDefinition) {
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
