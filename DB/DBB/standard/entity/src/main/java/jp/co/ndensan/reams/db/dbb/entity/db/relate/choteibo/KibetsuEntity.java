/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 期別情報一時Entityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KibetsuEntity implements IDbAccessable {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private Decimal rirekiNo;
    private HihokenshaNo hihokenshaNo;
    private RString choshuHouhou;
    private int ki;
    private Decimal choteiId;
    private Decimal dai1kiChoteiGaku;
    private Decimal dai2kiChoteiGaku;
    private Decimal dai3kiChoteiGaku;
    private Decimal dai4kiChoteiGaku;
    private Decimal dai5kiChoteiGaku;
    private Decimal dai6kiChoteiGaku;
    private Decimal dai7kiChoteiGaku;
    private Decimal dai8kiChoteiGaku;
    private Decimal dai9kiChoteiGaku;
    private Decimal dai10kiChoteiGaku;
    private Decimal dai11kiChoteiGaku;
    private Decimal dai12kiChoteiGaku;
    private Decimal dai13kiChoteiGaku;
    private Decimal dai14kiChoteiGaku;
}
