/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;

/**
 * 高額合算支給不支給決定一時TBLと被保険者一時TBLの帳票用データ。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuChohyoEntity {

    private DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 決定データ;
    private DbWT0001HihokenshaTempEntity 被保険者;

}
