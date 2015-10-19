/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査員の振る舞いを定義します。
 *
 * @author N2204 三井 沙織
 * @jpName 認定調査員インタフェース
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
public interface INinteiChosain {

    /**
     * 介護調査員番号を返します。
     *
     * @return 介護調査員番号
     */
    RString get介護調査員番号();

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    IName get氏名();

    /**
     * 所属事業者を返します。
     *
     * @return 所属事業者
     */
    IKaigoJigyosha get所属事業者();
}
