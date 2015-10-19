/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護サービス種類コードを表すインターフェースです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護サービスタイプコードインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス種類
 * @mainClass
 * @reference
 */
public interface IKaigoServiceTypeCode {

    /**
     * 介護サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    RString getValue();
}
