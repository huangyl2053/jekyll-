package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4020011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA4020011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBA4020011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    他市町村住所特例者照会("他市町村住所特例者照会"),
    完了("完了");

    private final RString name;

    private DBA4020011StateName(String name) {
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
