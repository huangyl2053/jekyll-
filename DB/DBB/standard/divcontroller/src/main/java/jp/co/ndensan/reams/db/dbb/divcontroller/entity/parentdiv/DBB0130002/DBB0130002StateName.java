package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0130002の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB0130002StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    平準化確定リアル("平準化確定リアル"),
    平準化確定バッチ("平準化確定バッチ");

    private final RString name;

    private DBB0130002StateName(String name) {
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
