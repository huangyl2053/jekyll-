/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout;

import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者一時TBLと再審査申立一時TBL結びついたエンティティ。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateAndHihokenshaKanrenEntity {

    private DbWT1741SaishinsaMoshitateEntity 再審査申立;
    private DbWT1001HihokenshaEntity 被保険者;

}
