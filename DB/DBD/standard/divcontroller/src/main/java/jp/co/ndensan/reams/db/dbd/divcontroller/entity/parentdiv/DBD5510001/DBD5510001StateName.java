package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5510001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD5510001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBD5510001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    職権修正("職権修正"),
    職権一部喪失("職権一部喪失"),
    区分変更認定("区分変更認定"),
    サービス変更認定("サービス変更認定"),
    区変認定完了("区変認定完了"),
    サ変認定完了("サ変認定完了"),
    完了("完了");

    private final RString name;

    private DBD5510001StateName(String name) {
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
