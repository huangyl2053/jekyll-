package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA2040011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBA2040011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    適用状態("適用状態"),
    解除状態("解除状態"),
    変更状態("変更状態"),
    完了状態("完了状態");

    private final RString name;

    private DBA2040011StateName(String name) {
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
