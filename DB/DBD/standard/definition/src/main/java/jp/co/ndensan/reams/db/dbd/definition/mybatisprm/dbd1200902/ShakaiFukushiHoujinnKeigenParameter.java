/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表発行_SQL使用パラメタークラスです.
 *
 * @reamsid_L DBD-3981-050 x_miaocl
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenParameter {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     */
    public ShakaiFukushiHoujinnKeigenParameter(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        this.被保険者番号 = 被保険者番号;
        this.識別コード = 識別コード;
    }
}
