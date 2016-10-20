/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力 Entityクラスです
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoOutDoBillOutEntity {

    private KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity;
    private HihokenshaTempEntity 被保険者一時Entity;
}
