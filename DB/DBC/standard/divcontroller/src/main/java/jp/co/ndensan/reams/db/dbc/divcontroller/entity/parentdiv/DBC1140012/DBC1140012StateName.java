package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1140012の状態名定義クラスです
 *
 * @reamsid_L DBC-2080-030 jianglaisheng
 */
public enum DBC1140012StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    平成２０年度("平成２０年度"),
    平成２０年度以外("平成２０年度以外");

    private final RString name;

    private DBC1140012StateName(String name) {
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
