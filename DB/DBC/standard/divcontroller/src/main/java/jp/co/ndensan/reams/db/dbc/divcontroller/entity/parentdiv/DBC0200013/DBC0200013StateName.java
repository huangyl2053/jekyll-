package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200013;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0200013の状態名定義クラスです
 *
 * @reamsid_L DBC-3300-050 wangxingpeng
 */
public enum DBC0200013StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    高額合算補正済自己負担額情報("高額合算補正済自己負担額情報");

    private final RString name;

    private DBC0200013StateName(String name) {
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
