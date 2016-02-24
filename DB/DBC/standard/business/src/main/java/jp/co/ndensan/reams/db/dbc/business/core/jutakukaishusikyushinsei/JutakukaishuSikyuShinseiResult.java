/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修費支給申請情報クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakukaishuSikyuShinseiResult implements Cloneable, Serializable {

    private RString kaishuShinseiKubun;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString seiriNo;
    private FlexibleDate shinseiYMD;
    private FlexibleDate shinsaYMD;
    private RString shikyuHushikyuKetteiKubun;
    private FlexibleDate ketteiYMD;
    private Decimal shiharaiKingakuTotal;
    private RString jizenSeiriNo;

    /**
     * コンストラクタです。
     */
    public JutakukaishuSikyuShinseiResult() {
        this.kaishuShinseiKubun = null;
        this.hiHokenshaNo = null;
        this.serviceTeikyoYM = null;
        this.seiriNo = null;
        this.shinseiYMD = null;
        this.shinsaYMD = null;
        this.shikyuHushikyuKetteiKubun = null;
        this.ketteiYMD = null;
        this.shiharaiKingakuTotal = null;
        this.jizenSeiriNo = null;
    }
}
