/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence;

import jp.co.ndensan.reams.db.dbe.entity.HatsubanKanriJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 発番管理情報を管理するインターフェースです
 *
 * @author N1013 松本直樹
 */
public interface IHatsubanKanriJohoDac {

    /**
     * 指定した項目区分と年度で発番情報を取得します
     *
     * @param 項目区分 項目年度
     * @param 年度 年度
     * @return 発番管理情報のエンティティ
     */
    HatsubanKanriJohoEntity select(RString 項目区分, RString 年度);

    /**
     * 発番管理情報を更新します
     *
     * @param data 発番管理情報エンティティ
     * @return 更新結果
     */
    int update(HatsubanKanriJohoEntity data);
}
