package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB1140011の状態名定義クラスです
 *
 * @author 自動生成
 * @reamsid_L DBB-1750-010 zhangrui
 */
public enum DBB1140011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期状態("初期状態"),
    所得登録("所得登録"),
    完了状態("完了状態");

    private final RString name;

    private DBB1140011StateName(String name) {
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
