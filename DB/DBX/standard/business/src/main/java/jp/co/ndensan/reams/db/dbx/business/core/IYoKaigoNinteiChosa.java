/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の振る舞いを定義します。
 *
 * @author N2204 三井 沙織
 * @jpName 要介護認定調査インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IYoKaigoNinteiChosa extends Serializable {

    /**
     * 依頼年月日を返します。
     *
     * @return 依頼年月日
     */
    RDate get依頼年月日();

    /**
     * 実施年月日を返します。
     *
     * @return 実施年月日
     */
    RDate get実施年月日();

    /**
     * 完了年月日を返します。
     *
     * @return 完了年月日
     */
    RDate get完了年月日();

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    RString get認定調査員コード();

    /**
     * 認定調査員氏名を返します。
     *
     * @return 認定調査員氏名
     */
    RString get認定調査員氏名();

    /**
     * 事業者コードを返します。
     *
     * @return 事業者コード
     */
    RString get事業者コード();

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    RString get事業者名称();
}
