/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 介護サービス種類の情報を表すインターフェイスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護サービスタイプインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス種類
 * @mainClass ○
 * @reference
 */
public interface IKaigoServiceType {

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    IKaigoServiceTypeCode getサービス種類コード();

    /**
     * 提供開始年月日を取得します。
     *
     * @return 提供開始年月
     */
    RYearMonth get提供開始年月();

    /**
     * サービス種類名称を取得します。
     *
     * @return サービス種類名称
     */
    RString getサービス種類名称();

    /**
     * サービス種類略称を取得します。
     *
     * @return サービス種類略称
     */
    RString getサービス種類略称();

    /**
     * サービス分類を取得します。
     *
     * @return サービス分類
     */
    RString getサービス分類();
}
