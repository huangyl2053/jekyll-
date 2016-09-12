/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査決定通知書情報取込共通処理（保険者分・ファイル読込）のdataEntity。
 *
 * @reamsid_L DBC-2520-012 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInDataEntity {

    private SaishinsaKetteiHokenshaInCsvHeadEntity csvHeadEntity;
    private List<SaishinsaKetteiHokenshaInCsvMeisaiEntity> listCsvMeisaiEntity;
    private SaishinsaKetteiHokenshaInCsvGokeiEntity csvGokeiEntity;
}
