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
    追加適用("追加適用"),
    追加解除("追加解除"),
    追加変更("追加変更"),
    適用完了("適用完了"),
    解除完了("解除完了"),
    変更完了("変更完了"),
    転入転出保留対象者管理_追加適用("転入転出保留対象者管理_追加適用");

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
