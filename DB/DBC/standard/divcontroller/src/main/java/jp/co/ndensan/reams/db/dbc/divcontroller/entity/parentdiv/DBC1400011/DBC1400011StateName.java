package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1400011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1400011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC1400011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    検索("検索"),
    一覧("一覧"),
    申請登録("申請登録"),
    申請結果("申請結果");

    private final RString name;

    private DBC1400011StateName(String name) {
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
