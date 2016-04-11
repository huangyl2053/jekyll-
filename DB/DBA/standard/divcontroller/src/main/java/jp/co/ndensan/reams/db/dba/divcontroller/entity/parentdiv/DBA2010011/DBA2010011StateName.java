package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA2010011の状態名定義クラスです
 *
 * @reamsid_L DBA-0340-030 wanghui
 */
public enum DBA2010011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    事業者修正削除("事業者修正削除"),
    事業者選択("事業者選択"),
    施設修正削除("施設修正削除"),
    施設選択("施設選択");

    private final RString name;

    private DBA2010011StateName(String name) {
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
