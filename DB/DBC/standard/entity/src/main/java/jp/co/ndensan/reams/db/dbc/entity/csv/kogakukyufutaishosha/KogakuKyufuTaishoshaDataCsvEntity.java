/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha;

import java.util.List;

/**
 * 高額介護サービス費給付対象者のCsvEntity
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoshaDataCsvEntity {

    private KogakuKyufuTaishoshaHeadCsvEntity headCsvEntity;
    private List<KogakuKyufuTaishoshaGroupCsvEntity> listGroupCsvEntity;

}
