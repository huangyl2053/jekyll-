/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込）のcsvFileDataEntity
 *
 * @reamsid_L DBC-2480-013 sunqingzhu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishoCsvFileDataEntity {

    private SeikyugakuTsuchishoCsvFileHeadRecordEntity headRecordEntity;
    private List<SeikyugakuTsuchishoCsvFileMeisaiEntity> listMeisaiEntity;
    private SeikyugakuTsuchishoCsvFileToreraRecode1Entity toreraRecord1Entity;

}
