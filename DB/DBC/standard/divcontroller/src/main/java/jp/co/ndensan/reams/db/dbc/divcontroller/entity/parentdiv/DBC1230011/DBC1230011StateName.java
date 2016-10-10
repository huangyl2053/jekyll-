package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1230011の状態名定義クラスです
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public enum DBC1230011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    支給決定情報一覧("支給決定情報一覧"),
    支給決定情報補正("支給決定情報補正");

    private final RString name;

    private DBC1230011StateName(String name) {
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
