package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020009;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2020009の状態名定義クラスです
 *
 * @reamsid_L DBE-0020-050 houtp
 */
public enum DBE2020009StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期化("初期化"),
    印刷("印刷");

    private final RString name;

    private DBE2020009StateName(String name) {
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
