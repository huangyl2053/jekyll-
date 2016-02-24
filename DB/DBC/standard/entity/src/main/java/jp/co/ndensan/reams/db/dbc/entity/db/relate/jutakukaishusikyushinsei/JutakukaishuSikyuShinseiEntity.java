/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei;

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
public class JutakukaishuSikyuShinseiEntity implements Cloneable, Serializable {

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
     *
     * @param kaishuShinseiKubun kaishuShinseiKubun
     * @param hiHokenshaNo hiHokenshaNo
     * @param serviceTeikyoYM serviceTeikyoYM
     * @param seiriNo seiriNo
     * @param shinseiYMD shinseiYMD
     * @param shinsaYMD shinsaYMD
     * @param shikyuHushikyuKetteiKubun shikyuHushikyuKetteiKubun
     * @param ketteiYMD ketteiYMD
     * @param shiharaiKingakuTotal shiharaiKingakuTotal
     * @param jizenSeiriNo jizenSeiriNo
     */
    public JutakukaishuSikyuShinseiEntity(RString kaishuShinseiKubun,
            HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM,
            RString seiriNo,
            FlexibleDate shinseiYMD,
            FlexibleDate shinsaYMD,
            RString shikyuHushikyuKetteiKubun,
            FlexibleDate ketteiYMD,
            Decimal shiharaiKingakuTotal,
            RString jizenSeiriNo) {
        this.kaishuShinseiKubun = kaishuShinseiKubun;
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNo = seiriNo;
        this.shinseiYMD = shinseiYMD;
        this.shinsaYMD = shinsaYMD;
        this.shikyuHushikyuKetteiKubun = shikyuHushikyuKetteiKubun;
        this.ketteiYMD = ketteiYMD;
        this.shiharaiKingakuTotal = shiharaiKingakuTotal;
        this.jizenSeiriNo = jizenSeiriNo;
    }
}
