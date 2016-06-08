/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 要介護認定結果を表すインタフェースです。
 *
 * @author n3310 酒井 裕亮
 * @jpName 要介護認定結果インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IYoKaigoNinteiKekka extends Serializable {

    /**
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    RDate get認定年月日();

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    YoKaigoJotaiKubun get要介護状態区分();

    /**
     * 認定有効期間を返します。
     *
     * @return 認定有効期間
     */
    Range<RDate> get認定有効期間();

    /**
     * 介護認定審査会意見を返します。
     *
     * @return 介護認定審査会意見
     */
    RString get介護認定審査会意見();

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    RDate get異動年月日();

    /**
     * 特定疾病を返します。
     *
     * @return 特定疾病
     */
    RString get特定疾病();
}
