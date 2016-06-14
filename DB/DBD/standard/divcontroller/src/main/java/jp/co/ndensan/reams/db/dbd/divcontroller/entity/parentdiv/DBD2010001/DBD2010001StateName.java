package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD2010001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBD2010001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    支払方法変更管理("支払方法変更管理"),
    完了("完了");

    private final RString name;

    private DBD2010001StateName(String name) {
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
