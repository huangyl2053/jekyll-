/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;

/**
 * 被保険者一時TBLと共同処理用受給者異動高額送付TBL結びついたエンティティ。
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SedaiShuuyakuBangoKanrenEntity {

    private DbWT0001HihokenshaTempEntity 被保険者;
    private List<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> 高額送付リスト;

}
