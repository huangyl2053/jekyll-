/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査情報の取得のEntityクラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaIraiJohoRelateEntity {

    private List<DbT5105NinteiKanryoJohoEntity> ninteiKanryoJohoEntity;
    private List<DbT5201NinteichosaIraiJohoEntity> ninteichosaIraiJohoEntity;
}
