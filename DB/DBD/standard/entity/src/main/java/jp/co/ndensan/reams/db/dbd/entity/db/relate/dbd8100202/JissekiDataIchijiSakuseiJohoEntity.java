/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 実績データ一時作成SQL検索結果Entityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JissekiDataIchijiSakuseiJohoEntity {

    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理NewestEntity;
    private DbT4037HikazeNenkinTaishoshaEntity 非課税年金対象者Entity;
    private RString 履歴番号;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
}
