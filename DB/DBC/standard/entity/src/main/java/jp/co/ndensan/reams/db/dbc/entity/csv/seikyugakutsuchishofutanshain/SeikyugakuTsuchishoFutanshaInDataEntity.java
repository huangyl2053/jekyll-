/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込・公費負担者分）のcsvEntity
 *
 * @reamsid_L DBC-2790-011 hemin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishoFutanshaInDataEntity {

    private SeikyugakuTsuchishoFutanshaInCsvHeadEntity csvHeadEntity;
    private List<SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity> listCsvMeisaiEntity;
    private SeikyugakuTsuchishoFutanshaInCsvGokeiEntity csvGokeiEntity;
}
