package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC2000022の状態名定義クラスです
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public enum DBC2000022StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    新規("新規"),
    修正("修正"),
    照会("照会");

    private final RString name;

    private DBC2000022StateName(String name) {
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
