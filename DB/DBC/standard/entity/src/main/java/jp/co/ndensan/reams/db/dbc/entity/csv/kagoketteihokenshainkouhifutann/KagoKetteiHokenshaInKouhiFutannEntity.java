/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshainkouhifutann;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定通知書情報取込共通処理（公費負担者分・ファイル読込）のcsvEntity
 *
 * @reamsid_L DBC-0980-421 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInKouhiFutannEntity {

    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private List<KagoKetteiHokenshaInKouhiFutannDataEntity> listDataEntity;

}
