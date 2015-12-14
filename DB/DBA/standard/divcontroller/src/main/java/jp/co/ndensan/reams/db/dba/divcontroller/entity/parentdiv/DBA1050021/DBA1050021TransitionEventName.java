package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA1050021のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBA1050021TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    資格異動訂正に戻る("資格異動訂正に戻る"),
    資格異動の訂正を保存する("資格異動の訂正を保存する");

    private final RString name;

    private DBA1050021TransitionEventName(String name) {
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
