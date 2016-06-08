/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護資格のファクトリークラスです。
 *
 * @author N3327 三浦 凌
 * @jpName 介護資格ファクトリー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護資格
 * @mainClass
 * @reference
 * @deprecated 介護にて再設計します。
 */
public final class KaigoShikakuFactory {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoShikakuFactory() {
    }

    /**
     * 介護資格のインスタンスを生成します。
     *
     * @param 識別コード 識別コード
     * @param 保険種別 保険種別
     * @param 資格取得届出年月日 資格取得届出年月日
     * @param 資格取得年月日 資格取得年月日
     * @param 資格取得事由 資格取得事由
     * @param 資格喪失届出年月日 資格喪失届出年月日
     * @param 資格喪失年月日 資格喪失年月日
     * @param 資格喪失事由 資格喪失事由
     * @param 被保険者番号 被保険者番号
     * @param 介護保険広域構成市町村コード 介護保険広域構成市町村コード
     * @param 一号該当日 一号該当日
     * @param 資格被保険者区分 資格被保険者区分
     * @param 住所地特例者区分 住所地特例者区分
     * @return 介護資格インタフェースの実装クラス
     */
    public static IKaigoShikaku createInstance(
            ShikibetsuCode 識別コード, HokenShubetsu 保険種別,
            RDate 資格取得届出年月日, RDate 資格取得年月日, ShikakuShutokuJiyu 資格取得事由,
            RDate 資格喪失届出年月日, RDate 資格喪失年月日, ShikakuSoshitsuJiyu 資格喪失事由,
            RString 被保険者番号, RString 介護保険広域構成市町村コード, RDate 一号該当日,
            ShikakuHihokenshaKubun 資格被保険者区分, JushochiTokureishaKubun 住所地特例者区分) {
        return new _KaigoShikaku(
                識別コード, 保険種別,
                資格取得届出年月日, 資格取得年月日, 資格取得事由,
                資格喪失届出年月日, 資格喪失年月日, 資格喪失事由,
                被保険者番号, 介護保険広域構成市町村コード, 一号該当日,
                資格被保険者区分, 住所地特例者区分);
    }
}
