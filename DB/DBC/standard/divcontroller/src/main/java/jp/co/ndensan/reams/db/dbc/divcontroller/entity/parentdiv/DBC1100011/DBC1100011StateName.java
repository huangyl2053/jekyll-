package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1100011の状態名定義クラスです
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public enum DBC1100011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    申請登録("申請登録"),
    変更取下げ("変更取下げ"),
    申請登録加入履歴一覧("申請登録加入履歴一覧"),
    申請登録加入履歴情報("申請登録加入履歴情報"),
    処理完了("処理完了");

    private final RString name;

    private DBC1100011StateName(String name) {
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
