package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD1070001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBD1070001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    申請一覧("申請一覧"),
    申請情報入力("申請情報入力"),
    完了メッセージ("完了メッセージ"),
    世帯情報from一覧("世帯情報from一覧"),
    世帯情報from詳細("世帯情報from詳細");

    private final RString name;

    private DBD1070001StateName(String name) {
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
