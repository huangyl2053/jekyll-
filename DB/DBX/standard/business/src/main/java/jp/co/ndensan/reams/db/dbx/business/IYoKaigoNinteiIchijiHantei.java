/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 要介護認定一次判定のインタフェースです。
 *
 * @author n3310 酒井 裕亮
 * @jpName 要介護認定一次判定インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IYoKaigoNinteiIchijiHantei extends Serializable {

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    YoKaigoJotaiKubun get要介護状態区分();

    /**
     * 運動能力の低下していない認知症高齢者である場合の介護状況を加算した要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    YoKaigoJotaiKubun get要介護状態区分_認知症加算();

    /**
     * 判定年月日を返します。
     *
     * @return 判定年月日
     */
    RDate get判定年月日();
}
