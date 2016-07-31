package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0010000の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC0010000StateNm implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    給付実績照会検索("給付実績照会検索"),
    給付実績照会一覧("給付実績照会一覧");

    private final RString name;

    private DBC0010000StateNm(String name) {
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
