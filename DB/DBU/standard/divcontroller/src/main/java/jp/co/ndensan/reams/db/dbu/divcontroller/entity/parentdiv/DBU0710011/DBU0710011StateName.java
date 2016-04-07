package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0710011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0710011の状態名定義クラスです
 * @reamsid_L DBU-1140-010 dongyabin
 * @author 自動生成
 */
public enum DBU0710011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default");

    private final RString name;

    private DBU0710011StateName(String name) {
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
