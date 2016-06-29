package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120003;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB1120003の状態名定義クラスです
 *
 * 画面設計_DBBGM51005_所得情報アップロード
 *
 * @reamsid_L DBB-1730-010 yangchenbing
 */
public enum DBB1120003StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default");

    private final RString name;

    private DBB1120003StateName(String name) {
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
