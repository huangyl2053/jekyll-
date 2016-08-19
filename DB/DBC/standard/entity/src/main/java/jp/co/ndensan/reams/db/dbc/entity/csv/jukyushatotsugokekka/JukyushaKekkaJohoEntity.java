/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushatotsugokekka;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者情報突合結果情報取込（ファイル読込）のcsvEntity。
 *
 * @reamsid_L DBC-2760-010 jianglaisheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKekkaJohoEntity {
    private JukyushaKekkaJohoControlCsvEntity controlCsvEntity;
    private List<JukyushaKekkaJohoCsvMeisaiEntity> listDataEntity;
}
