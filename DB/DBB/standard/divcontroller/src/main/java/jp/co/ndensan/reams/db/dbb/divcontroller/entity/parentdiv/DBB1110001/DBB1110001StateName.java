package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB1110001の状態名定義クラスです
 *
 * @reamsid_L DBB-1650-010 lijunjun
 */
public enum DBB1110001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    介護保険所得情報一覧単一他社用("介護保険所得情報一覧単一他社用"),
    介護保険所得情報一覧広域用("介護保険所得情報一覧広域用");

    private final RString name;

    private DBB1110001StateName(String name) {
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
