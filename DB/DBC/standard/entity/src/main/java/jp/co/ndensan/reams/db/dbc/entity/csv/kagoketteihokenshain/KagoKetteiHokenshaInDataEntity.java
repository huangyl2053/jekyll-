/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定通知書情報取込共通処理（保険者分・ファイル読込）のdataEntity
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInDataEntity {

    private KagoKetteiHokenshaInHeadCsvEntity headCsvEntity;
    private List<KagoKetteiHokenshaInMeisaiCsvEntity> listMeisaiCsvEntity;
    private KagoKetteiHokenshaInGokeiCsvEntity gokeiCsvEntity;
}
