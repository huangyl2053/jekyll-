/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadatatorikomi;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査データ取込のRelateエンティティです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NinteiChosaDataTorikomiRelateEntity {

    private DbT5101NinteiShinseiJohoEntity 認定申請情報Entity;
    private DbT5105NinteiKanryoJohoEntity 認定完了情報Entity;
    private DbT5116IchijiHanteiKekkaJohoEntity 一次判定結果情報Entity;
    private DbT5201NinteichosaIraiJohoEntity 認定調査依頼情報Entity;
}
