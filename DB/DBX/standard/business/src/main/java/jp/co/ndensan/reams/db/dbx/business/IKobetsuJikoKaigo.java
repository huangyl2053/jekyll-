/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;

/**
 * 個別事項の介護情報(資格情報＋受給情報)を表すインタフェースです。
 *
 * @author N2218 村松 優
 * @jpName 個別事項介護インタフェース
 * @bizDomain 介護
 * @category 個別事項
 * @subCategory
 * @mainClass ○
 * @reference
 */
public interface IKobetsuJikoKaigo extends Serializable {

    /**
     * 介護資格を取得します。
     *
     * @return 介護資格
     */
    IKobetsuJikoKaigoShikaku get介護資格();

    /**
     * 介護受給を取得します。
     *
     * @return 介護受給
     */
    IKobetsuJikoKaigoJukyu get介護受給();
}
