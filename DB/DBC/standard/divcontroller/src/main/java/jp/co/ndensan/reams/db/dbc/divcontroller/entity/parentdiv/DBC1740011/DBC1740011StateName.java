package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1740011の状態名定義クラスです
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public enum DBC1740011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    alter("alter"),
    kanryo("kanryo");

    private final RString name;

    private DBC1740011StateName(String name) {
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
