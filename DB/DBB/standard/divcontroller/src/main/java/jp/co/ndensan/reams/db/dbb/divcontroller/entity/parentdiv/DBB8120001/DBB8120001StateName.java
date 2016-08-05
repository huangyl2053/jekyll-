package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB8120001の状態名定義クラスです
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public enum DBB8120001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    即時賦課更正("即時賦課更正"),
    即時賦課更正_対象者検索以外("即時賦課更正_対象者検索以外"),
    完了("完了");

    private final RString name;

    private DBB8120001StateName(String name) {
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
