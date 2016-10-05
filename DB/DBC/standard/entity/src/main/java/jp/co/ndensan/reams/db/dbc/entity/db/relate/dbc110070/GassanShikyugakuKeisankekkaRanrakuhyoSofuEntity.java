/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;

/**
 * 出力対象データのエンティティクラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity {

    private DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity 高額合算支給額計算結果一時;
    private DbWT1001HihokenshaTempEntity 被保険者一時;
}
