package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5180001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5180001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE5180001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    介護認定審査会審査対象データ出力("介護認定審査会審査対象データ出力");

    private final RString name;

    private DBE5180001StateName(String name) {
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
