package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0510011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBU0510011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    照会("照会"),
    更新("更新"),
    追加("追加"),
    保存("保存"),
    選択("選択");

    private final RString name;

    private DBU0510011StateName(String name) {
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
