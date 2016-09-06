/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hanyolistkogakugassanshikyugakukettei;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算支給額決定情報)出力順クラスです。
 *
 * @reamsid_L DBC-3101-020 jiangxiaolong
 */
public enum HanyoListKogakuGassanShikyugakuKetteiOutPutOrder implements IReportItems {

    /**
     * 被保険者番号
     */
    被保険者番号("0103", "被保険者番号", "\"DbT3074KogakuGassanShikyuFushikyuKettei\".\"dbT3074KogakuGassanShikyuFushikyuKettei_hihokenshaNo\""),
    /**
     * 対象年度
     */
    対象年度("0366", "対象年度", "\"DbT3074KogakuGassanShikyuFushikyuKettei\".\"dbT3074KogakuGassanShikyuFushikyuKettei_taishoNendo\""),
    /**
     * 保険者番号
     */
    保険者番号("0364", "保険者番号", "\"DbT3074KogakuGassanShikyuFushikyuKettei\".\"dbT3074KogakuGassanShikyuFushikyuKettei_hokenshaNo\""),
    /**
     * 支給申請書整理番号
     */
    支給申請書整理番号("0308", "支給申請書整理番号", "\"DbT3074KogakuGassanShikyuFushikyuKettei\".\"dbT3074KogakuGassanShikyuFushikyuKettei_shikyuSeiriNo\"");

    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HanyoListKogakuGassanShikyugakuKetteiOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
        this.項目ID = new RString(項目ID);
        this.フォームフィールド名 = new RString(フォームフィールド名);
        this.myBatis項目名 = new RString(myBatis項目名);
    }

    @Override
    public RString get項目ID() {
        return this.項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return this.フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return this.myBatis項目名;
    }

}
