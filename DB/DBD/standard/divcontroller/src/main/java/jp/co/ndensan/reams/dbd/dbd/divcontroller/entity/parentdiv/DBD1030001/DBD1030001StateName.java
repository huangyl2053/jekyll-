package jp.co.ndensan.reams.dbd.dbd.divcontroller.entity.parentdiv.DBD1030001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD1030001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBD1030001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    一覧("一覧"),
    詳細("詳細"),
    完了("完了"),
    世帯情報from一覧("世帯情報from一覧"),
    世帯情報from詳細("世帯情報from詳細");

    private final RString name;

    private DBD1030001StateName(String name) {
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
