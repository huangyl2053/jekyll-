/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減額対象情報Entity
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GengakuTaishoJohoEntity {

    private RString 徴収権消滅期間;
    private RString 納付済み期間;
    private RString 給付額減額期間;
    private FlexibleDate 確定減額期間開始年月日;
    private FlexibleDate 確定減額期間終了年月日;
}
