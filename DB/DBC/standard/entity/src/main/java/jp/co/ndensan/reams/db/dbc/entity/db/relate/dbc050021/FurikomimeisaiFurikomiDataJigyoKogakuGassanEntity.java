/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込明細・振込みデータ作成の事業高額合算データEntityです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomimeisaiFurikomiDataJigyoKogakuGassanEntity {

    private DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity 決定entity;
    private DbT3105SogoJigyoTaishoshaEntity 総合事業entity;
}
