package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB2710011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB2710011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    特徴対象者登録("特徴対象者登録"),
    結果確認("結果確認");

    private final RString name;

    private DBB2710011StateName(String name) {
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
