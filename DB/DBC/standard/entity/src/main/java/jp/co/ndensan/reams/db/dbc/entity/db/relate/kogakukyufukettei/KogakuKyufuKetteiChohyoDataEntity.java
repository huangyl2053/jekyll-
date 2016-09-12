/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3058KogakuShikyuShinsaKetteiTempEntity;

/**
 * 帳票出力対象データです。
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiChohyoDataEntity {

    private DbWT3058KogakuShikyuShinsaKetteiTempEntity ketteiTemp;
    private DbWT0001HihokenshaTempEntity hihokenshaTemp;
}
