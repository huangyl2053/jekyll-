/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成依頼(手動)一覧のクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoirairirekiichiranShudouEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private int ikenshoIraiRirekiNo;
    private RString ikenshoIraiKubun;
    private Code ishiKubunCode;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private RString shujiiCode;
}
