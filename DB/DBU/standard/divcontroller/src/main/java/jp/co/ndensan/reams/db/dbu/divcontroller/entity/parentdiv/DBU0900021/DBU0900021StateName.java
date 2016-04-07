package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0900021の状態名定義クラスです
 *
 * @reamsid_L DBU-1080-060 houtp
 */
public enum DBU0900021StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    追加("追加"),
    修正("修正"),
    削除("削除"),
    完了("完了");

    private final RString name;

    private DBU0900021StateName(String name) {
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
