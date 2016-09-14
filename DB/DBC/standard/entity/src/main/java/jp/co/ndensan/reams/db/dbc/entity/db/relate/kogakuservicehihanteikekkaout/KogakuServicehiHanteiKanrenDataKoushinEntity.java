/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1001HihokenshaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者一時TBLと高額介護サービス費支給一時TBL結びついたエンティティ。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiHanteiKanrenDataKoushinEntity {

    private DbWT1001HihokenshaEntity 被保険者;
    private DbWT3411KogakuShikyuShinseiEntity 高額介護;
    private DbT3057KogakuShikyuHanteiKekkaEntity 支給判定結果;

}
