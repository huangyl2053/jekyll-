/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.riyoshafutanwariaihanteimanager;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * ビジネス設計_DBCMNK2001_利用者負担割合判定（service）
 *
 * @reamsid_L DBC-5010-040 quxiaodong
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiHanteiParameter {

    private final FlexibleYear 所得年度;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです
     *
     * @param 所得年度 FlexibleYear
     * @param 識別コード ShikibetsuCode
     */
    public RiyoshaFutanWariaiHanteiParameter(
            FlexibleYear 所得年度,
            ShikibetsuCode 識別コード) {
        this.所得年度 = 所得年度;
        this.識別コード = 識別コード;
    }
}
