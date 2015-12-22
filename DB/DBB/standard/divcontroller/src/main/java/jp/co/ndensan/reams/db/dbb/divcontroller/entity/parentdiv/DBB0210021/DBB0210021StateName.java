package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0210021の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB0210021StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    単一市町村("単一市町村"),
    広域市町村("広域市町村");

    private final RString name;

    private DBB0210021StateName(String name) {
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
