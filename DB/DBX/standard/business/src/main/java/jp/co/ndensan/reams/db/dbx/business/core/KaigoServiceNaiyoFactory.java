/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護サービス内容のファクトリークラスです
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス内容ファクトリー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public final class KaigoServiceNaiyoFactory {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoServiceNaiyoFactory() {
    }

    /**
     * 介護サービス内容のインスタンスを生成します。
     *
     * @param サービスコード サービスコード
     * @param 適用年月 適用年月
     * @param 履歴番号 履歴番号
     * @param サービス名称 サービス名称
     * @param サービス略称 サービス略称
     * @param 介護サービス単位 介護サービス単位
     * @return 介護サービス内容インターフェース
     */
    public static _KaigoServiceNaiyo getInstance(IKaigoServiceCode サービスコード, Range<FlexibleYearMonth> 適用年月,
            int 履歴番号, RString サービス名称, RString サービス略称, IKaigoServiceTani 介護サービス単位) {
        return new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
    }
}
