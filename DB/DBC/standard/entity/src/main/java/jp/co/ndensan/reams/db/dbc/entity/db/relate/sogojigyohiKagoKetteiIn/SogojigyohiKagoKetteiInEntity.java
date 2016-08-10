/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohiKagoKetteiIn;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3060KagoKetteiShukeiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3061KagoKetteiMeisaiTempEntity;

/**
 *
 * @reamsid_L DBC-2550-010 fzou
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiKagoKetteiInEntity implements Serializable {

    private DbWT0001HihokenshaTempEntity 被保険者一時TBL;

    private DbWT3060KagoKetteiShukeiTempEntity 過誤決定集計一時TBL;

    private DbWT3061KagoKetteiMeisaiTempEntity 過誤決定明細一時TBL;
}
