/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.idoriyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2512KaigoShotokuNewestEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt001FindIdoEntity;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;

/**
 * 介護保険受領委任払い取扱事業者登録通知書データEntity
 *
 * @reamsid_L DBC-2120-060 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoRiyoshaDateEntity {

    private DbT4001JukyushaDaichoEntity 受給者台帳;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
    private SetaiCode 世帯コード;
    private DbT3105SogoJigyoTaishoshaEntity 総合事業対象者;
    private DbV2512KaigoShotokuNewestEntity 介護所得ビュー;
    private UaFt001FindIdoEntity 宛名識別対象異動分;
}
