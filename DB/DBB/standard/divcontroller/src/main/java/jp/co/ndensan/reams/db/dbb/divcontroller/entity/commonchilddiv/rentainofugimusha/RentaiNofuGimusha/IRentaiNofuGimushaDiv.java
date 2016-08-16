package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.rentainofugimusha.RentaiNofuGimusha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBB-5700-010 chenaoqi
 */
public interface IRentaiNofuGimushaDiv extends ICommonChildDivBaseProperties {

    /**
     * 連帯納付義務者Divの初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void initialize(HihokenshaNo 被保険者番号);

}
