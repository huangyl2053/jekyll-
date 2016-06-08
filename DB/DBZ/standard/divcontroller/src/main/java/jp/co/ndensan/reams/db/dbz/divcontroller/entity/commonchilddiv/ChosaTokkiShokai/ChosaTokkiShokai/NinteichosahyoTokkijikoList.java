/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShokai.ChosaTokkiShokai;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;

/**
 * 認定調査特記事項番号Listクラスです。
 */
public class NinteichosahyoTokkijikoList {

    private ArrayList<ArrayList<NinteichosahyoTokkijiko>> 認定調査特記事項List;

    /**
     * 認定調査特記事項Listを取得する。
     *
     * @return 認定調査特記事項List
     */
    public ArrayList get認定調査特記事項List() {
        return 認定調査特記事項List;
    }

    /**
     * 認定調査特記事項Listを設定する。
     *
     * @param 認定調査特記事項List 認定調査特記事項List
     */
    public void setget認定調査特記事項List(ArrayList<ArrayList<NinteichosahyoTokkijiko>> 認定調査特記事項List) {
        this.認定調査特記事項List = 認定調査特記事項List;
    }
}
