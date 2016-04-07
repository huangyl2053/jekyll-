package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2020005の状態名定義クラスです
 *
 * @reamsid_L DBE-0021-010 zhangzhiming
 */
public enum DBE2020005StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    調査地区一覧("調査地区一覧"),
    認定調査員一覧("認定調査員一覧"),
    認定調査員情報登録("認定調査員情報登録"),
    完了("完了");

    private final RString name;

    private DBE2020005StateName(String name) {
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
