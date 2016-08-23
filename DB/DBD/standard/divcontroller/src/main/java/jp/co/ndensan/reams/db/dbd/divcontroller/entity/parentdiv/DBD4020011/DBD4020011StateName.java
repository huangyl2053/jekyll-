package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD4020011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBD4020011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    一覧("一覧"),
    詳細("詳細"),
    完了("完了"),
    世帯一覧from一覧("世帯一覧from一覧"),
    世帯一覧from詳細("世帯一覧from詳細");

    private final RString name;

    private DBD4020011StateName(String name) {
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
