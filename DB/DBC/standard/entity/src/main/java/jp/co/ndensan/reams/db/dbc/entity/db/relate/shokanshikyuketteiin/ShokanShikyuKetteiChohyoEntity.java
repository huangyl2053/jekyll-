/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給決定情報取込の帳票出力対象です。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiChohyoEntity {

    private int 連番;
    private DbWT0001HihokenshaTempEntity 被保険者;
    private DbWT3036ShokanHanteiKekkaTempEntity 判定結果;

}
