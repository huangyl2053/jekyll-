/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 総合事業対象者情報クラスです
 *
 * @reamsid_L DBD-3830-040 tianyh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogoJigyoTaishoshaJoho {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate checklistJisshiYMD;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
}
