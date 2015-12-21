package jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList;

import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 共有子Div「保険者リスト」であることを表します。
 */
public interface IHokenshaListDiv extends ICommonChildDivBaseProperties {

    /**
     * 保険者リストDDLを設定します。
     */
    void loadHokenshaList();
}
