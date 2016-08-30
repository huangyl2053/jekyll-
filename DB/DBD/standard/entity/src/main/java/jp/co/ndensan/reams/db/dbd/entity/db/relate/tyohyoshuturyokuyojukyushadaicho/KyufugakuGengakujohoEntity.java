/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付額減額情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufugakuGengakujohoEntity {

    private RString 給付額減額区分;
    private RString 明細番号;
    private ShiharaiHenkoTorokuKubun 給付制限;
    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    private RString 給付率;
    private RString 徴収権消滅期間;
    private RString 納付済期間;
    private RString 減額期間;
}
