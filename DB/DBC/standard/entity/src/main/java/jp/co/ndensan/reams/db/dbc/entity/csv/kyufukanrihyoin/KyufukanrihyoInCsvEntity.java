/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu.KokuhorenkyoutsuControlCsvEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付管理票情報取込（ファイル読込）のcsvEntity。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoInCsvEntity {

    private KokuhorenkyoutsuControlCsvEntity controlCsvEntity;
    private List<KyufukanrihyoInMeisaiZenEntity> listMeisaiZenEntity;
    private List<KyufukanrihyoInMeisaiGoEntity> listMeisaiGoEntity;

}
