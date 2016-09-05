/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業状況報告情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JigyoHokokuDataCsvRelateEntity {

    private RString dataKubun;
    private RString syukeKubun;
    private RString hyouNo;
    private RString shukeiNo;
    private RString syukeTani;
    private RString tateNo;
    private RString yokoNo;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private HokenshaNo shoKisaiHokenshaNo;
    private int rirekiNo;
    private RString shikyuKubunCode;
    private Decimal shikyuKingaku;
    private Decimal shiharaiSumiKingakuGokei;
    private RString setaiShuyakuNo;
    private RString yousikiKubun;
    private RString setaiGassanJyukyuuKubun;
    private RString biko1;
    private RString biko2;
    private RString biko3;
    private RString biko4;
    private RString biko5;
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    private RString kyufuSakuseiKubunCode;
    private RString kyufuJissekiKubunCode;
    private RString kohi1FutanNo;
    private RString kohi2FutanNo;
    private RString kohi3FutanNo;
    private Decimal kohi1Shikyugaku;
    private Decimal kohi2Shikyugaku;
    private Decimal kohi3Shikyugaku;
    private FlexibleYearMonth shinsaYM;
    private RString hihokennshaKubunCode;
    private LasdecCode shichosonCode;
    private LasdecCode kyuShichosonCode;
}
