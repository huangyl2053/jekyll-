package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB9020001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB9020001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    平成27年以降("平成27年以降"),
    平成26年("平成26年"),
    平成24年から平25年まで("平成24年から平25年まで"),
    平成21年から平成23年まで("平成21年から平成23年まで"),
    平成18年から平成20年("平成18年から平成20年"),
    平成17年以前("平成17年以前"),
    完了("完了"),
    初期状態("初期状態");

    private final RString name;

    private DBB9020001StateName(String name) {
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
