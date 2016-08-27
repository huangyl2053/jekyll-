/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shogaishakojotaishoshahaakukekkaichiran;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;

/**
 * 障がい者控除対象者csv出力のentityです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaSelectedEntity {

    private DbT4038ShogaishaKoujoEntity 障がい者控除Entity;
    private DbT4010GemmenGengakuShinseiEntity 減免減額申請Entity;

}
