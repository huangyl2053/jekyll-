package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2330001の状態名定義クラスです
 *
 * @reamsid_L DBE-0060-010 zhangzhiming
 */
public enum DBE2330001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    督促状発行("督促状発行");

    private final RString name;

    private DBE2330001StateName(String name) {
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
