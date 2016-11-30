package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0020011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC0020011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期表示("初期表示"),
    届出表示("届出表示"),
    明細表示("明細表示"),
    総合照会から("総合照会から");

    private final RString name;

    private DBC0020011StateName(String name) {
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
