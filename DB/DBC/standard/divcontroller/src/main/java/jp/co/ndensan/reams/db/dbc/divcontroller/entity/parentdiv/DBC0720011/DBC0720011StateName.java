package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0720011の状態名定義クラスです
 *
 * @reamsid_L DBC-0991-030 surun
 */
public enum DBC0720011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    申請検索("申請検索"),
    申請審査("申請審査"),
    完了("完了"),
    申請審査_保存不可("申請審査_保存不可");

    private final RString name;

    private DBC0720011StateName(String name) {
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
