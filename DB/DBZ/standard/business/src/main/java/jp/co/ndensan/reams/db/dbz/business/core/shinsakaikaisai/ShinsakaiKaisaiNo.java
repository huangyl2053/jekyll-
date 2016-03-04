/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 開催番号クラスです。
 */
public class ShinsakaiKaisaiNo implements Serializable {

    private final List<RString> 開催番号List;

    /**
     * コンストラクタです.
     *
     * @param 開催番号List List<開催番号>
     */
    public ShinsakaiKaisaiNo(List<RString> 開催番号List) {
        this.開催番号List = 開催番号List;
    }

    /**
     * 開催番号Listを取得します。
     *
     * @return List<開催番号>
     */
    public List<RString> get開催番号List() {
        return 開催番号List;
    }
}
