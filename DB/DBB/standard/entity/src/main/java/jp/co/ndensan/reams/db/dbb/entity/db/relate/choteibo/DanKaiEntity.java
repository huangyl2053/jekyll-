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
 * 段階情報一時Entityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DanKaiEntity implements IDbAccessable {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private Decimal rirekiNo;
    private HihokenshaNo hihokenshaNo;
    private RString dankai;
    private RString choshuHouhou;
    private Decimal choteiId;
    private int dogetsuFlag;
    private RString karisanFlag;
    private Decimal zengetsusueChoteigaku;
    private Decimal fueChoteigaku;
    private Decimal genChoteigaku;
    private Decimal dogetsusueChoteigaku;

}
