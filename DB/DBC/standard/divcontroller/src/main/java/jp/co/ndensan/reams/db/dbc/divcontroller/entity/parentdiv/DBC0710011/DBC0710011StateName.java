package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0710011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC0710011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    支給申請モード("支給申請モード"),
    事前申請モード("事前申請モード");

    private final RString name;

    private DBC0710011StateName(String name) {
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
