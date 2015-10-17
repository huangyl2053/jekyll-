/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;

/**
 * 調査員情報のマスタ定義です。
 *
 * @author N2204 三井 沙織
 * @jpName 調査員情報
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
@OnRshareSchema
public enum ChosainJoho implements IColumnDefinition {

    // TODO n2204三井沙織 マスタ定義が決まったらこのクラスをDBに合わせる 2013/12/31
    /**
     * 市町村コード
     */
    市町村コード(5, 0),
    /**
     * 介護事業者番号
     */
    介護事業者番号(10, 0),
    /**
     * 介護調査員番号
     */
    介護調査員番号(8, 0),
    /**
     * 事業者番号
     */
    事業者番号(10, 0),
    /**
     * 介護調査員状況
     */
    介護調査員状況(1, 0),
    /**
     * 調査員氏名
     */
    調査員氏名(80, 0),
    /**
     * 調査員氏名カナ
     */
    調査員氏名カナ(80, 0),
    /**
     * 性別
     */
    性別(1, 0),
    /**
     * 調査員資格
     */
    調査員資格(2, 0),
    /**
     * 地区コード
     */
    地区コード(8, 0),
    /**
     * 郵便番号
     */
    郵便番号(7, 0),
    /**
     * 住所
     */
    住所(50, 0),
    /**
     * 電話番号
     */
    電話番号(14, 0);
    private final int maxLength;
    private final int scale;

    private ChosainJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * @return 最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * @return 小数点以下桁数
     */
    public int getScale() {
        return scale;
    }
}
