/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3058KogakuShikyuShinsaKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;

/**
 * 未更新の審査決定一時データ　と　審査決定一時データと同じ被保険者番号、サービス提供年月をもつ判定結果データ<br>
 * （判定結果送付済＆審査結果未反映のみ）。
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiHanteiEntity {

    private DbWT3058KogakuShikyuShinsaKetteiTempEntity ketteiTemp;
    private DbWT0001HihokenshaTempEntity hihokenshaTemp;
    private List<DbT3057KogakuShikyuHanteiKekkaEntity> kekkaList;
}
