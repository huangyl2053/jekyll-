/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho;

import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.*;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;

/**
 * 被保険者一時TBLと受給者情報明細一時TBL結びついたエンティティ。
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
@lombok.Getter
@lombok.Setter
public class JukyushaHihokenshaEntity {

    private DbWT0001HihokenshaTempEntity 被保険者一時;
    private DbWT5331JukyushaJohoTempEntity 受給者情報明細一時;

}
