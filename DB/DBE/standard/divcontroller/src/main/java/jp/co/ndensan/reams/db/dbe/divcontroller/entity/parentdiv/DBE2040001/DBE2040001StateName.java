package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2040001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE2040001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    登録("登録"),
    完了("完了"),
    依頼内容入力("依頼内容入力"),
    完了のみ登録("完了のみ登録"),
    依頼日のみ入力("依頼日のみ入力");

    private final RString name;

    private DBE2040001StateName(String name) {
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
