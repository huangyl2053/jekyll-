/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.gappei;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;

/**
 * 広域合併市町村情報のインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKoikiGappeiShichosonJoho {

    /**
     * 合併情報を返します。
     *
     * @return 合併情報
     */
    IGappeiJoho get合併情報();

    /**
     * 構成市町村を返します。
     *
     * @return 構成市町村
     */
    List<IKoikiKoseiShichoson> get構成市町村();
}
