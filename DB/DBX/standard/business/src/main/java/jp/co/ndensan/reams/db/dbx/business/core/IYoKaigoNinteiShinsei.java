/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiYukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請のインタフェースです。
 *
 * @author n3310 酒井 裕亮
 * @jpName 要介護認定申請インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IYoKaigoNinteiShinsei extends Serializable {

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    RString get申請書管理番号();

    /**
     * 介護保険被保険者番号を返します。
     *
     * @return 介護保険被保険者番号
     */
    RString get介護保険被保険者番号();

    /**
     * 申請有効区分を返します。
     *
     * @return 申請有効区分
     */
    NinteiShinseiYukoKubun get申請有効区分();

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    RDate get申請年月日();

    /**
     * 申請時の認定申請区分を返します。
     *
     * @return 認定申請区分(申請時)
     */
    NinteiShinseiKubunShinsei get認定申請区分_申請時();

    /**
     * 法令により定められている申請時の認定申請区分を返します。
     *
     * @return 認定申請区分(法令)
     */
    NinteiShinseiKubunHorei get認定申請区分_法令();

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    RString get認定申請理由();

    /**
     * 地方公共団体コードを返します。
     *
     * @return 地方公共団体コード
     */
    LasdecCode get地方公共団体コード();

    /**
     * 認定申請の取下げ区分を返します。
     *
     * @return 取下げ区分
     */
    TorisageKubun get取下げ区分();
}
