/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tukibeturanku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 月別ランクTemp一時
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuRankTemp extends DbTableEntityBase<TsukibetsuRankTemp> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private RString rankKubun4Gatsu;
    @TempTableColumnOrder(3)
    private RString rankKubun5Gatsu;
    @TempTableColumnOrder(4)
    private RString rankKubun6Gatsu;
    @TempTableColumnOrder(5)
    private RString rankKubun7Gatsu;
    @TempTableColumnOrder(6)
    private RString rankKubun8Gatsu;
    @TempTableColumnOrder(7)
    private RString rankKubun9Gatsu;
    @TempTableColumnOrder(8)
    private RString rankKubun10Gatsu;
    @TempTableColumnOrder(9)
    private RString rankKubun11Gatsu;
    @TempTableColumnOrder(10)
    private RString rankKubun12Gatsu;
    @TempTableColumnOrder(11)
    private RString rankKubun1Gatsu;
    @TempTableColumnOrder(12)
    private RString rankKubun2Gatsu;
    @TempTableColumnOrder(13)
    private RString rankKubun3Gatsu;
    @TempTableColumnOrder(14)
    private LasdecCode shichosonCode4Gatsu;
    @TempTableColumnOrder(15)
    private LasdecCode shichosonCode5Gatsu;
    @TempTableColumnOrder(16)
    private LasdecCode shichosonCode6Gatsu;
    @TempTableColumnOrder(17)
    private LasdecCode shichosonCode7Gatsu;
    @TempTableColumnOrder(18)
    private LasdecCode shichosonCode8Gatsu;
    @TempTableColumnOrder(19)
    private LasdecCode shichosonCode9Gatsu;
    @TempTableColumnOrder(20)
    private LasdecCode shichosonCode10Gatsu;
    @TempTableColumnOrder(21)
    private LasdecCode shichosonCode11Gatsu;
    @TempTableColumnOrder(22)
    private LasdecCode shichosonCode12Gatsu;
    @TempTableColumnOrder(23)
    private LasdecCode shichosonCode1Gatsu;
    @TempTableColumnOrder(24)
    private LasdecCode shichosonCode2Gatsu;
    @TempTableColumnOrder(25)
    private LasdecCode shichosonCode3Gatsu;
}
