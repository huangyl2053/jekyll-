package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE4010001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE4010001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    登録("登録"),
    完了("完了"),
    完了のみ登録("完了のみ登録");

    private final RString name;

    private DBE4010001StateName(String name) {
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
