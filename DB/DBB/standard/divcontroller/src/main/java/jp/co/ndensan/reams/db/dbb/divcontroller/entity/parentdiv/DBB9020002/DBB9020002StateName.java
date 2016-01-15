package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB9020002の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB9020002StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    平21年以降("平21年以降"),
    平18年から平20年まで("平18年から平20年まで"),
    平17年以前("平17年以前"),
    完了("完了"),
    初期状態("初期状態");

    private final RString name;

    private DBB9020002StateName(String name) {
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
