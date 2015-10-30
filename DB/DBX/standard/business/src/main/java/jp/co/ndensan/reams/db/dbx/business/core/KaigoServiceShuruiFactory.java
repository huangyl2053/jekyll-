/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護サービス種類のファクトリークラスです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス種類ファクトリー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public final class KaigoServiceShuruiFactory {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoServiceShuruiFactory() {
    }

    /**
     * 介護サービス種類のインスタンスを生成します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 提供年月 提供年月
     * @param サービス種類名称 サービス種類名称
     * @param サービス種類名称略称 サービス種類名称略称
     * @param サービス分類 サービス分類
     * @return 介護サービス種類インターフェース
     */
    public static IKaigoServiceShurui getInstance(KaigoServiceShuruiCode サービス種類コード, Range<FlexibleYearMonth> 提供年月, RString サービス種類名称,
            RString サービス種類名称略称, KaigoServiceBunruiCode サービス分類) {

        return new _KaigoServiceShurui(サービス種類コード, 提供年月, サービス種類名称, サービス種類名称略称, サービス分類);
    }
}
