/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibehihokensixya;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 段階別被保険者数一覧。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibeHihokensixyaForReport implements IDbAccessable {

    private RString flag;
    private LasdecCode shichosonCode;
    private RString 保険者設定段階;
    private Decimal 保険者設定;
}
