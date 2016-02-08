package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBZ0400002の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBZ0400002StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    メンテナンス("メンテナンス"),
    完了メッセージ表示("完了メッセージ表示");

    private final RString name;

    private DBZ0400002StateName(String name) {
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
