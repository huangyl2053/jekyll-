/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka;

import java.util.List;

/**
 * 受給者情報明細のCsvEntity
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaJohoCsvEntity {

    private JukyushaJohoControlCsvEntity controlCsvEntity;
    private List<JukyushaJohoDataCsvEntity> listDataEntity;

}
