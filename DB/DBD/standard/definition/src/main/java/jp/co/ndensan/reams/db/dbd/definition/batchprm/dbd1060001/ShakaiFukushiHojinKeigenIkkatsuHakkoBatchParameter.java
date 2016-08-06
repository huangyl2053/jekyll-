/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1060001;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人等利用者負担軽減の場合のパラメータです。
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiFukushiHojinKeigenIkkatsuHakkoBatchParameter extends BatchParameterBase {

    private static final String TANPYOHAKKOKUBUN = "tanpyoHakkoKubun";
    private static final String NENDOKAISHIYMD = "nendoKaishiYMD";
    private static final String NENDOSHURYOYMD = "nendoShuryoYMD";
    private static final String KETTEIYMDFROM = "ketteiYMDFrom";
    private static final String KETTEIYMDTO = "ketteiYMDTo";
    private static final String NINTEISHOHAKKOFLAG = "ninteishoHakkoFlag";
    private static final String NINTEISHOKOFUYMD = "ninteishoKofuYMD";
    private static final String TSUCHISHOHAKKOFLAG = "tsuchishoHakkoFlag";
    private static final String TSUCHISHOHAKKOYMD = "tsuchishoHakkoYMD";
    private static final String TSUCHISHOBUNSHONO = "tsuchishoBunshoNo";
    private static final String KAIPAGESHUTSURYOKUJUNID = "kaiPageShutsuryokuJunId";

    @BatchParameter(key = TANPYOHAKKOKUBUN, name = "単票発行区分")
    private boolean tanpyoHakkoKubun;
    @BatchParameter(key = NENDOKAISHIYMD, name = "年度開始日")
    private FlexibleDate nendoKaishiYMD;
    @BatchParameter(key = NENDOSHURYOYMD, name = "年度終了日")
    private FlexibleDate nendoShuryoYMD;
    @BatchParameter(key = KETTEIYMDFROM, name = "決定日FROM")
    private FlexibleDate ketteiYMDFrom;
    @BatchParameter(key = KETTEIYMDTO, name = "決定日TO")
    private FlexibleDate ketteiYMDTo;
    @BatchParameter(key = NINTEISHOHAKKOFLAG, name = "認定証発行フラグ")
    private boolean ninteishoHakkoFlag;
    @BatchParameter(key = NINTEISHOKOFUYMD, name = "認定証の交付日")
    private FlexibleDate ninteishoKofuYMD;
    @BatchParameter(key = TSUCHISHOHAKKOFLAG, name = "通知書発行フラグ")
    private boolean tsuchishoHakkoFlag;
    @BatchParameter(key = TSUCHISHOHAKKOYMD, name = "通知書の発行日")
    private FlexibleDate tsuchishoHakkoYMD;
    @BatchParameter(key = TSUCHISHOBUNSHONO, name = "通知書の文書番号")
    private RString tsuchishoBunshoNo;
    @BatchParameter(key = KAIPAGESHUTSURYOKUJUNID, name = "改頁出力順ID")
    private RString kaiPageShutsuryokuJunId;

    /**
     * コンストラクタです。
     */
    public ShakaiFukushiHojinKeigenIkkatsuHakkoBatchParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param tanpyoHakkoKubun boolean
     * @param nendoKaishiYMD FlexibleDate
     * @param nendoShuryoYMD FlexibleDate
     * @param ketteiYMDFrom FlexibleDate
     * @param ketteiYMDTo FlexibleDate
     * @param ninteishoHakkoFlag boolean
     * @param ninteishoKofuYMD FlexibleDate
     * @param tsuchishoHakkoFlag boolean
     * @param tsuchishoHakkoYMD FlexibleDate
     * @param tsuchishoBunshoNo RString
     * @param kaiPageShutsuryokuJunId1 RString
     *
     */
    public ShakaiFukushiHojinKeigenIkkatsuHakkoBatchParameter(boolean tanpyoHakkoKubun, FlexibleDate nendoKaishiYMD,
            FlexibleDate nendoShuryoYMD, FlexibleDate ketteiYMDFrom, FlexibleDate ketteiYMDTo,
            boolean ninteishoHakkoFlag, FlexibleDate ninteishoKofuYMD, boolean tsuchishoHakkoFlag, FlexibleDate tsuchishoHakkoYMD,
            RString tsuchishoBunshoNo, RString kaiPageShutsuryokuJunId1) {
        this.tanpyoHakkoKubun = tanpyoHakkoKubun;
        this.nendoKaishiYMD = nendoKaishiYMD;
        this.nendoShuryoYMD = nendoShuryoYMD;
        this.ketteiYMDFrom = ketteiYMDFrom;
        this.ketteiYMDTo = ketteiYMDTo;
        this.ninteishoHakkoFlag = ninteishoHakkoFlag;
        this.ninteishoKofuYMD = ninteishoKofuYMD;
        this.tsuchishoHakkoFlag = tsuchishoHakkoFlag;
        this.tsuchishoHakkoYMD = tsuchishoHakkoYMD;
        this.tsuchishoBunshoNo = tsuchishoBunshoNo;
        this.kaiPageShutsuryokuJunId = kaiPageShutsuryokuJunId1;
    }
}
