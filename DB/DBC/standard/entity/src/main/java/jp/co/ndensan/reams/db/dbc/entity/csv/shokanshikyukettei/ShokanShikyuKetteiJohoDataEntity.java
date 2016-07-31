/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.shokanshikyukettei;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給決定情報取込のDataEntity
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiJohoDataEntity {

    private ShokanShikyuKetteiJohoCsvHeadEntity csvHeadEntity;
    private List<ShokanShikyuKetteiJohoCsvMeisaiEntity> listCsvMeisaiEntity;

}
