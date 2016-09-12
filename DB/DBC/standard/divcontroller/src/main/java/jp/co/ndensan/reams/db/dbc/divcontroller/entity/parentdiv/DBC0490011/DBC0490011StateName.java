package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0490011の状態名定義クラスです
 *
 * @reamsid_L DBC-2000-010 chenhui
 */
public enum DBC0490011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    高額介護サービス費支給決定通知書作成("高額介護サービス費支給決定通知書作成");

    private final RString name;

    private DBC0490011StateName(String name) {
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
