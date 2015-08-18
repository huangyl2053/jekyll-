/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 介護保険受給者のインタフェースです。
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IKaigoHokenJukyusha extends Serializable {

    /**
     * 要介護認定リストを返します。
     *
     * @return 要介護認定リスト
     */
    List<IYoKaigoNintei> get要介護認定();

    /**
     * 直近異動年月日を返します。
     *
     * @return 直近異動年月日
     */
    RDate get直近異動年月日();

    /**
     * 個人を返します。
     *
     * @return 個人
     */
    IKojin get個人();

    /**
     * 喪失年月日を返します。
     *
     * @return 喪失年月日
     */
    RDate get喪失年月日();
}
