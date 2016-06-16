/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定申請者の情報です。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiJohoEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private int ninteichosaRirekiNo;
    private int shinsakaiOrder;
    private FlexibleDate ninteiShinseiYMD;
    private FlexibleDate shinsakaiKaisaiYMD;
    private FlexibleDate ninteichosaJisshiYMD;
}
