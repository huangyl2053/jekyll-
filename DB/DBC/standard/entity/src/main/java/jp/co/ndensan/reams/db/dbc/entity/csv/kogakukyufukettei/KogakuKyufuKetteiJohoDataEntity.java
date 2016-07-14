/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費決定情報取込みのDataEntity
 *
 * @reamsid_L DBC-0980-390 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiJohoDataEntity {

    private KogakuKyufuKetteiJohoCsvHeadEntity csvHeadEntity;
    private List<KogakuKyufuKetteiJohoCsvMeisaiEntity> listCsvMeisaiEntity;

}
