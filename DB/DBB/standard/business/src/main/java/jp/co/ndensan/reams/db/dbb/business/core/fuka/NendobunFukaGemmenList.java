/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 年度分賦課減免リスト
 *
 * @reamsid_L DBB-1660-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendobunFukaGemmenList implements Serializable {

    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private GemmenJoho 現年度;
    private GemmenJoho 過年度1;
    private GemmenJoho 過年度2;
    private GemmenJoho 過年度3;
    private GemmenJoho 過年度4;
    private GemmenJoho 過年度5;
    private FlexibleDate 賦課期日;
    private boolean has過年度賦課;
    private GemmenJoho 最新減免の情報;
}
