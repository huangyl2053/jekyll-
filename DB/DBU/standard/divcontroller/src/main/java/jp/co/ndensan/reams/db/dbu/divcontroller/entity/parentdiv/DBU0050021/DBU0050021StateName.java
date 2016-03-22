package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0050021の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBU0050021StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    del("del"),
    add("add"),
    mod("mod"),
    com("com");

    private final RString name;

    private DBU0050021StateName(String name) {
        this.name = new RString(name);
    }

    /**
     * getName
     *
     * @return 名前
     */
    @Override
    public RString getName() {
        return name;
    }
// </editor-fold>
}
