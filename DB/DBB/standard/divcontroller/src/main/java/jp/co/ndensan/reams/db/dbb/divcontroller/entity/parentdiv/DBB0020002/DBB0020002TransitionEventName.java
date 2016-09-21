package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0020002のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBB0020002TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    即時賦課更正("即時賦課更正"),
    資格不整合修正("資格不整合修正"),
    処理完了("処理完了");

    private final RString name;

    private DBB0020002TransitionEventName(String name) {
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
