/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.riyoshafutanwariaihanteimanager;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * ビジネス設計_DBCMNK2001_利用者負担割合判定（service）
 *
 * @reamsid_L DBC-5010-040 quxiaodong
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiHanteiManagerParameter {

    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 対象開始日;
    private final FlexibleDate 対象終了日;

    /**
     * コンストラクタです
     *
     * @param 識別コード ShikibetsuCode
     * @param 対象開始日 FlexibleDate
     * @param 対象終了日 FlexibleDate
     */
    public RiyoshaFutanWariaiHanteiManagerParameter(
            ShikibetsuCode 識別コード,
            FlexibleDate 対象開始日,
            FlexibleDate 対象終了日) {
        this.識別コード = 識別コード;
        this.対象開始日 = 対象開始日;
        this.対象終了日 = 対象終了日;
    }
}
