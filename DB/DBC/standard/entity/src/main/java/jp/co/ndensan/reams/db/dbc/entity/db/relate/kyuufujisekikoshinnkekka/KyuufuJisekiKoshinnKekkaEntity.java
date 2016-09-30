/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyuufujisekikoshinnkekka;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiTempEntity;

/**
 * 給付実績更新結果一覧表
 *
 * @reamsid_L DBC-2460-030 lijian
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyuufuJisekiKoshinnKekkaEntity {

    private DbWT1001HihokenshaTempEntity 被保険者一時Entity;
    private DbWT1111KyufuJissekiTempEntity 給付実績一時Entity;

}
