package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB2110002の状態名定義クラスです
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public enum DBB2110002StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    単一状態("単一状態"),
    完了状態("完了状態"),
    広域状態("広域状態");

    private final RString name;

    private DBB2110002StateName(String name) {
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
