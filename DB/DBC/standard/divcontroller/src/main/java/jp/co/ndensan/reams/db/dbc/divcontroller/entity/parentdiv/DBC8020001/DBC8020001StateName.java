package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC8020001の状態名定義クラスです
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public enum DBC8020001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    高額合算("高額合算"),
    事業高額("事業高額"),
    事業高額合算("事業高額合算");

    private final RString name;

    private DBC8020001StateName(String name) {
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
