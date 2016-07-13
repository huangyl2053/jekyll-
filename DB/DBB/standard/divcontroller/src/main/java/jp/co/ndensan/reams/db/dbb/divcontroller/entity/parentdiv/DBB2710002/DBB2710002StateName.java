package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB2710002の状態名定義クラスです<br/>
 *
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
public enum DBB2710002StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    特別徴収対象者一覧作成("特別徴収対象者一覧作成"),
    同定非同定表示("同定非同定表示"),
    特別徴収同定一覧("特別徴収同定一覧"),
    特別徴収未同定一覧("特別徴収未同定一覧"),
    特別徴収同定候補者一覧("特別徴収同定候補者一覧"),
    完了("完了");

    private final RString name;

    private DBB2710002StateName(String name) {
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
