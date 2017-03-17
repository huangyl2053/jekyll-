/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 委員登録の所属機関一覧
 */
public class ShozokuKikanIchiran implements Serializable {

    private List<dgShozokuKikanIchiran_Row> 所属機関;

    /**
     * コンストラクタです。
     *
     * @param 所属機関 List<dgShozokuKikanIchiran_Row>
     */
    public ShozokuKikanIchiran(List<dgShozokuKikanIchiran_Row> 所属機関) {
        this.所属機関 = 所属機関;
    }

    /**
     * 所属機関を返します。
     *
     * @return 所属機関 List<dgShozokuKikanIchiran_Row>
     */
    public List<dgShozokuKikanIchiran_Row> get所属機関() {
        return 所属機関;
    }
}
