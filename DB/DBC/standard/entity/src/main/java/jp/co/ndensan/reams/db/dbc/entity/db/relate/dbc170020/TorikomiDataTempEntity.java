/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170020;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * バッチ処理「給付費単位数表標準マスタ取込」に、一時テーブル「取込データ一時」のエンティティです。
 *
 * @reamsid_L DBC-3400-030 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiDataTempEntity extends DbTableEntityBase<TorikomiDataTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private ServiceShuruiCode serviceShuruiCd;
    @PrimaryKey
    @TempTableColumnOrder(2)
    private RString serviceKoumokuCd;
    @PrimaryKey
    @TempTableColumnOrder(3)
    private FlexibleYearMonth teikyoKaishiYM;
    @PrimaryKey
    @TempTableColumnOrder(4)
    private Decimal rirekiNo;
    @TempTableColumnOrder(5)
    private FlexibleYearMonth teikyoShuryoYM;
    @TempTableColumnOrder(6)
    private RString serviceName;
    @TempTableColumnOrder(7)
    private RString serviceNameRyaku;
    @TempTableColumnOrder(8)
    private int taniSu;
    @TempTableColumnOrder(9)
    private Code tanisuShikibetsuCode;
    @TempTableColumnOrder(10)
    private Code tanisuSanteiTaniCode;
    @TempTableColumnOrder(11)
    private Code idouJiyuCode;
    @TempTableColumnOrder(12)
    private RString gendogakuTaishogaiFlag;
    @TempTableColumnOrder(13)
    private RString gaibuServiceRiyoKataKubun;
    @TempTableColumnOrder(14)
    private RString tokubetsuChiikiKasanFlag;
    @TempTableColumnOrder(15)
    private RString riyosyaFutanTeiritsuTeigakuKubun;
    @TempTableColumnOrder(16)
    private RString koshinUmuFoag;
    @TempTableColumnOrder(17)
    private RString motoTensu;
    @TempTableColumnOrder(18)
    private RString motoGendogakuTaishogaiFlag;
    @TempTableColumnOrder(19)
    private RString motoTaniShikibetsuCd;
    @TempTableColumnOrder(20)
    private RString riyoshaFutanGaku;
    @TempTableColumnOrder(21)
    private RString kyufuRitsu;
    @TempTableColumnOrder(22)
    private RString nijiyoboJigyoTaishaJishiKubunHigaito;
    @TempTableColumnOrder(23)
    private RString yoshien1JukyushaJishiKubun;
    @TempTableColumnOrder(24)
    private RString yoshien2JukyushaJishiKubun;
    @TempTableColumnOrder(25)
    private RString taishoJigyoJishiKubun;
    @TempTableColumnOrder(26)
    private RString sogoJigyoServiceKubun;
    @TempTableColumnOrder(27)
    private RString seigenNissuKaisu;
    @TempTableColumnOrder(28)
    private RString santeiKaisuSeigenKikanKubun;

}
