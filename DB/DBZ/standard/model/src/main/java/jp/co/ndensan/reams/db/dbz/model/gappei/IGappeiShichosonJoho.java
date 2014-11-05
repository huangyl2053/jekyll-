/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.gappei;

import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;

/**
 * 合併市町村情報のインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IGappeiShichosonJoho {

    /**
     * 合併情報を返します。
     *
     * @return 合併情報
     */
    IOptional<IGappeiJoho> get合併情報();

    /**
     * 合併市町村を返します。
     *
     * @return 合併市町村
     */
    IItemList<IGappeiShichoson> get合併市町村();
}
