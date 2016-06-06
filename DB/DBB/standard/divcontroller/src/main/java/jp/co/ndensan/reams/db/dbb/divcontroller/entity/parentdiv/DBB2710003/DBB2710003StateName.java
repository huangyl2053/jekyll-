package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710003;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB2710003の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB2710003StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    同定非同定表示("同定非同定表示"),
    特別徴収同定一覧("特別徴収同定一覧"),
    特別徴収未同定一覧("特別徴収未同定一覧"),
    特別徴収同定候補者一覧("特別徴収同定候補者一覧"),
    完了("完了");

    private final RString name;

    private DBB2710003StateName(String name) {
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
