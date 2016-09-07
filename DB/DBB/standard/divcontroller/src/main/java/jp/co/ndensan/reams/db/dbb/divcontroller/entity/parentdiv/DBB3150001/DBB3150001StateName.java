package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB3150001の状態名定義クラスです
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public enum DBB3150001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    介護保険料徴収猶予("介護保険料徴収猶予"),
    更新結果確認("更新結果確認");

    private final RString name;

    private DBB3150001StateName(String name) {
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
