package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB1120002の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB1120002StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    所得情報抽出連携単一他社用("所得情報抽出連携単一他社用");

    private final RString name;

    private DBB1120002StateName(String name) {
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
