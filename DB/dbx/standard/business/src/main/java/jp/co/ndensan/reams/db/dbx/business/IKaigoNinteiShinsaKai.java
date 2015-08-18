/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 介護認定審査会の振る舞いを定義します。
 *
 * @author N2204 三井 沙織
 * @jpName 介護認定審査会インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IKaigoNinteiShinsaKai extends Serializable {

    /**
     * 資料作成年月日を返します。
     *
     * @return 資料作成年月日
     */
    RDate get資料作成年月日();

    /**
     * 開催予定年月日を返します。
     *
     * @return 開催予定年月日
     */
    RDate get開催予定年月日();

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    int get合議体番号();

    /**
     * 回答年月日を返します。
     *
     * @return 回答
     */
    RDate get回答年月日();
}
