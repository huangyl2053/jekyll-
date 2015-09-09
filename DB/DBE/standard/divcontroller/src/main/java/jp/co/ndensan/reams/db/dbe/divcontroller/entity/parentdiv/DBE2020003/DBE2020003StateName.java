package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2020003の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE2020003StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    スケジュール編集("スケジュール編集"),
    スケジュール照会("スケジュール照会"),
    未定者("未定者");

    private final RString name;

    private DBE2020003StateName(String name) {
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
