/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBC0150011_サービス提供票別表 Entity
 *
 * @reamsid_L DBC-5110-010 xupeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TankiRiyoNissuResult {

    private Decimal 前回迄利用日数;
    private Decimal 今回計画利用日数;
}
