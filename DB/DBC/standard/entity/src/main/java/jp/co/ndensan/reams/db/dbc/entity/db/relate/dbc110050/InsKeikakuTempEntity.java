/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求サービス計画取得のEntityクラスです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsKeikakuTempEntity implements Serializable {

    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString seiriNo;
    private JigyoshaNo jigyoshaNo;
    private RString yoshikiNo;
    private RString meisaiNo;
    private RString renban;
    private RString shiteiKijunGaitoJigyoshaKubunCode;
    private FlexibleDate kyotakuServiceSakuseiIraiYMD;
    private ServiceCode serviceCode;
    private int tanisu;
    private int kaisu;
    private int serviceTanisu;
    private Decimal tanisuTanka;
    private int serviceTanisuTotal;
    private int seikyuKingaku;
    private RString tantokangoshienSemmoninNo;
    private RString tekiyo;
    private RString shinsaHohoKubunCode;
    private FlexibleYearMonth shinsaYM;
    private RString shikyuKubunCode;
    private int tensuKingaku;
    private int shikyuKingaku;
    private int zougenTen;
    private int sagakuKingaku;
    private RString zougenRiyu;
    private RString fushikyuRiyu;
    private RString kounyuKaishuRireki;
    private DbWT2111ShokanShinseiTempEntity 償還払支給申請一時Entity;
    private DbWT1001HihokenshaTempEntity 被保険者一時Entity;
}
