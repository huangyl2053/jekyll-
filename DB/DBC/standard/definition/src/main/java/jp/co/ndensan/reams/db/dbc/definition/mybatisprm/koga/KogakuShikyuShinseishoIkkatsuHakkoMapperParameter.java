/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.koga;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;

/**
 * 高額サービス費給付お知らせ通知書作成のハンドラクラスです。
 *
 * @reamsid_L DBC-4770-010 zhengshenlei
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShikyuShinseishoIkkatsuHakkoMapperParameter {

    private final HihokenshaNo hihokenshaNo;
    private final HokenshaNo shoKisaiHokenshaNo;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 HokenshaNo
     */
    private KogakuShikyuShinseishoIkkatsuHakkoMapperParameter(
            HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号
    ) {
        this.hihokenshaNo = 被保険者番号;
        this.shoKisaiHokenshaNo = 証記載保険者番号;
    }

    /**
     * 徴収方法変更のパラメータを生成します
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 HokenshaNo
     * @return KogakuShikyuShinseishoIkkatsuHakkoMapperParameter
     */
    public static KogakuShikyuShinseishoIkkatsuHakkoMapperParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号) {
        return new KogakuShikyuShinseishoIkkatsuHakkoMapperParameter(被保険者番号, 証記載保険者番号);
    }
}
