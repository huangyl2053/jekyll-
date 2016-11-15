package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBCN130001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBCN130001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    証明書検索("証明書検索"),
    証明書登録("証明書登録"),
    処理完了("処理完了"),
    証明書登録照会("証明書登録照会");

    private final RString name;

    private DBCN130001StateName(String name) {
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
