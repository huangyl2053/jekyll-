/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 共有子Div「居宅計画」の居宅サービス明細情報Entityです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceMeisaiEntity {

    private JigyoshaNo サービス提供事業者番号;
    private ServiceShuruiCode サービス種類コード;
    private ServiceKomokuCode サービス項目コード;
    private Decimal 単位数;
    private HokenKyufuRitsu 割引後適用率;
    private Decimal 割引後適用単位数;
    private Decimal 回数_日数;
    private Decimal 種類限度超過単位数;
    private Decimal 種類限度内単位数;
    private Decimal 区分限度超過単位数;
    private Decimal 区分限度内単位数;
    private Decimal 単位数単価;
    private HokenKyufuRitsu 給付率;
    private AtenaMeisho 事業者名称;
}
