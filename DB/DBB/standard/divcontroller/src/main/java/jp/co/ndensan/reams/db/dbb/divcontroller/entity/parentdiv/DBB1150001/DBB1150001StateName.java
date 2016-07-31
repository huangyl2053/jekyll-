package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB1150001の状態名定義クラスです
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public enum DBB1150001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    所得照会票個別発行個人一覧("所得照会票個別発行個人一覧"),
    所得照会票印字内容修正("所得照会票印字内容修正"),
    所得照会票発行("所得照会票発行");

    private final RString name;

    private DBB1150001StateName(String name) {
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
