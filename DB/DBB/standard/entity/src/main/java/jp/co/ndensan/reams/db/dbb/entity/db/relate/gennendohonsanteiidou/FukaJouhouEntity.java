/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 賦課情報一時Entityクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJouhouEntity implements IDbAccessable {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private int rirekiNo;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private RString kozaKubun;
    private Decimal fuchoKibetsuGaku1;
    private Decimal fuchoKibetsuGaku2;
    private Decimal fuchoKibetsuGaku3;
    private Decimal fuchoKibetsuGaku4;
    private Decimal fuchoKibetsuGaku5;
    private Decimal fuchoKibetsuGaku6;
    private Decimal fuchoKibetsuGaku7;
    private Decimal fuchoKibetsuGaku8;
    private Decimal fuchoKibetsuGaku9;
    private Decimal fuchoKibetsuGaku10;
    private Decimal fuchoKibetsuGaku11;
    private Decimal fuchoKibetsuGaku12;
    private Decimal fuchoKibetsuGaku13;
    private Decimal fuchoKibetsuGaku14;
}
