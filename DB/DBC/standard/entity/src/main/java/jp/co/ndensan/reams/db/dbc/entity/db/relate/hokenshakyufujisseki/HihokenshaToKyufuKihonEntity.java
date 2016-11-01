/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshakyufujisseki;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikihon.DbWT1131KyufujissekiKihonTempEntity;

/**
 * 変換結果取込_基本の戻り値です。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaToKyufuKihonEntity {

    private DbWT1131KyufujissekiKihonTempEntity 給付実績基本一時Entity;
    private DbWT1001HihokenshaTempEntity 被保険者一時Entity;
}
