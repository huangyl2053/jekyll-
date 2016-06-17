package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2310001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 画面設計_DBBGM84001_2_特徴制度間Ｉ／Ｆ（単一他社）
 *
 * @reamsid_L DBB-1830-010 yangchenbing
 */
public enum DBB2310001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了("完了");

    private final RString name;

    private DBB2310001TransitionEventName(String name) {
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
