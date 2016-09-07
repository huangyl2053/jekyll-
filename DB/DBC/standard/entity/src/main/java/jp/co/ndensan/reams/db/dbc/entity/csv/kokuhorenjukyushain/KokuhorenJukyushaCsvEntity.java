/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 国保連保有受給者情報取込CSVファイルレコード構成Entity
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenJukyushaCsvEntity {

    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private List<KokuhorenJukyushaDataCsvEntity> listDataEntity;
}
