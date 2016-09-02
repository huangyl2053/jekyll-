/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;

/**
 * 額合算支給不支給決定一時TBLの口座情報。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuRirikoNoEntity {

    private Integer 最大履歴番号;
    private DbWT0001HihokenshaIchijiEntity 被保険者;
    private DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 通知書データ;

}
