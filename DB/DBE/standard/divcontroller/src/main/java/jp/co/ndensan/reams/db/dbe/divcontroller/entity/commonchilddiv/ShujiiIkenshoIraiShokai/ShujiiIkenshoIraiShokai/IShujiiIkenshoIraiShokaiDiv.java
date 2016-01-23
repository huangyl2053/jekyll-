package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShujiiIkenshoIraiShokaiDiv extends ICommonChildDivBaseProperties {

    /**
     * 主治医意見書作成依頼情報を設定します。
     *
     * @param hihokenshano 被保険者番号
     */
    public void loadInitialize(HihokenshaNo hihokenshano);
}
