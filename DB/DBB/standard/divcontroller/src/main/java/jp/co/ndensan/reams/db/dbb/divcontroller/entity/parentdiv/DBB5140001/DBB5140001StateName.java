package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB5140001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB5140001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    バッチ起動_単一("バッチ起動_単一"),
    バッチ起動_広域("バッチ起動_広域");

    private final RString name;

    private DBB5140001StateName(String name) {
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
