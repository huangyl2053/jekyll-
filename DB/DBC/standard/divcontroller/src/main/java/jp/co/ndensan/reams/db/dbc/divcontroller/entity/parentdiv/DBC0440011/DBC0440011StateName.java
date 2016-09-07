package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0440011の状態名定義クラスです
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
public enum DBC0440011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    申請情報検索("申請情報検索"),
    申請情報登録("申請情報登録"),
    対象者情報登録("対象者情報登録");

    private final RString name;

    private DBC0440011StateName(String name) {
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
