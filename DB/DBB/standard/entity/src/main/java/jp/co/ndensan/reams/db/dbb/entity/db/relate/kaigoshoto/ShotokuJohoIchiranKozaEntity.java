/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 所得情報抽出・連携バッチの出力対象データ抽出Entityです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuJohoIchiranKozaEntity {

    private KaigoShotoTempTableEntity 介護所得TempEntity;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理entity;
}
