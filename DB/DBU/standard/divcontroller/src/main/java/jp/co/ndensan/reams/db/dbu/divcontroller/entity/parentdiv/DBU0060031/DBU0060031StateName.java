package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0060031の状態名定義クラスです
 *
 * @reamsid_L DBU-1060-030 zhengshukai
 */
public enum DBU0060031StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期状態("初期状態"),
    完了状態("完了状態");

    private final RString name;

    private DBU0060031StateName(String name) {
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
