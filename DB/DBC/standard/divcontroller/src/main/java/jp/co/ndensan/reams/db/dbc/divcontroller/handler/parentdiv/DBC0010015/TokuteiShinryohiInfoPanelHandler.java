/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010015;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015.TokuteiShinryohiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015.dgTokuteiShinryohiFromH1504_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015.dgTokuteiShinryohiToH1503_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 給付実績照会_(DBC0010015)特定診療費のHandlerです
 *
 * @reamsid_L DBC-2970-070 guoqilin
 */
public class TokuteiShinryohiInfoPanelHandler {

    private final TokuteiShinryohiMainDiv div;
    private final FlexibleYearMonth 提供年月;
    private final RString 決定２ = new RString("後");
    private final RString 保険 = new RString("保険");
    private final RString 公費１ = new RString("公費１");
    private final RString 公費２ = new RString("公費２");
    private final RString 公費３ = new RString("公費３");
    private static final RString ZERO = new RString("0");
    private static final int INT_ZERO = 0;
    private static final int INT_SEX = 6;

    /**
     * コンストラクタです。
     *
     * @param div TokuteiShinryohiMainDiv
     */
    public TokuteiShinryohiInfoPanelHandler(TokuteiShinryohiMainDiv div) {
        RString 年月 = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_介護給付費見直し,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substringEmptyOnError(INT_ZERO, INT_SEX);
        this.提供年月 = new FlexibleYearMonth(年月);
        this.div = div;
    }

    /**
     * *
     * 画面初期化のメソッドです
     *
     * @param サービス提供年月 サービス提供年月
     * @param 給付実績特定診療費_特別療養費等 給付実績特定診療費_特別療養費等
     * @param 給付実績特定診療費等 給付実績特定診療費等
     */
    public void onLoad(List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> 給付実績特定診療費_特別療養費等,
            List<KyufujissekiTokuteiSinryohi> 給付実績特定診療費等, FlexibleYearMonth サービス提供年月) {
        if (提供年月.isBeforeOrEquals(サービス提供年月)) {
            for (KyufujissekiTokuteiSinryoTokubetsuRyoyo 特別療養費 : 給付実績特定診療費_特別療養費等) {
                set給付実績特定診療費_特別療養費等(特別療養費);
            }
        } else {
            for (KyufujissekiTokuteiSinryohi 特定診療費 : 給付実績特定診療費等) {
                set給付実績特定診療費等(特定診療費);
            }
        }
    }

    private void set給付実績特定診療費_特別療養費等(KyufujissekiTokuteiSinryoTokubetsuRyoyo 給付実績特定診療費_特別療養費) {
        List<dgTokuteiShinryohiFromH1504_Row> dataSources = new ArrayList<>();
        dgTokuteiShinryohiFromH1504_Row row_1 = new dgTokuteiShinryohiFromH1504_Row();
        row_1.setTxtShobyoName(給付実績特定診療費_特別療養費.get傷病名());
        row_1.setTxtShikibetsu(給付実績特定診療費_特別療養費.get識別番号());
        row_1.setTxtKettei(RString.EMPTY);
        row_1.setTxtTanisu(new RString(給付実績特定診療費_特別療養費.get単位数()));
        row_1.setTxtKaisu(new RString(給付実績特定診療費_特別療養費.get保険_回数()));
        row_1.setTxtServiceTani(new RString(給付実績特定診療費_特別療養費.get保険_ｻｰﾋﾞｽ単位数()));
        row_1.setTxtGokeiTani(new RString(給付実績特定診療費_特別療養費.get保険_合計単位数()));
        row_1.setTxtKohi1Kaisu(new RString(給付実績特定診療費_特別療養費.get公費１_回数()));
        row_1.setTxtKohi1Tani(new RString(給付実績特定診療費_特別療養費.get公費１_ｻｰﾋﾞｽ単位数()));
        row_1.setTxtKohi1GokeiTani(new RString(給付実績特定診療費_特別療養費.get公費１_合計単位数()));
        row_1.setTxtKohi2Kaisu(new RString(給付実績特定診療費_特別療養費.get公費２_回数()));
        row_1.setTxtKohi2Tani(new RString(給付実績特定診療費_特別療養費.get公費２_ｻｰﾋﾞｽ単位数()));
        row_1.setTxtKohi2GokeiTani(new RString(給付実績特定診療費_特別療養費.get公費２_合計単位数()));
        row_1.setTxtKohi3Kaisu(new RString(給付実績特定診療費_特別療養費.get公費３_回数()));
        row_1.setTxtKohi3Tani(new RString(給付実績特定診療費_特別療養費.get公費３_ｻｰﾋﾞｽ単位数()));
        row_1.setTxtKohi3GokeiTani(new RString(給付実績特定診療費_特別療養費.get公費３_合計単位数()));
        row_1.setTxtSaishinsaKaisu(new RString(給付実績特定診療費_特別療養費.get再審査回数()));
        row_1.setTxtKagoKaisu(new RString(給付実績特定診療費_特別療養費.get過誤回数()));
        row_1.setTxtShinsaYM(to日期(給付実績特定診療費_特別療養費.get審査年月()));
        row_1.setTxtBtnTekiyoNayiyo(給付実績特定診療費_特別療養費.get摘要());
        dgTokuteiShinryohiFromH1504_Row row_2 = new dgTokuteiShinryohiFromH1504_Row();
        row_2.setTxtShobyoName(RString.EMPTY);
        row_2.setTxtShikibetsu(RString.EMPTY);
        row_2.setTxtKettei(決定２);
        row_2.setTxtTanisu(new RString(給付実績特定診療費_特別療養費.get後_単位数()));
        row_2.setTxtKaisu(new RString(給付実績特定診療費_特別療養費.get後_保険_回数()));
        row_2.setTxtServiceTani(new RString(給付実績特定診療費_特別療養費.get後_保険_ｻｰﾋﾞｽ単位数()));
        row_2.setTxtGokeiTani(new RString(給付実績特定診療費_特別療養費.get後_保険_合計単位数()));
        row_2.setTxtKohi1Kaisu(new RString(給付実績特定診療費_特別療養費.get後_公費１_回数()));
        row_2.setTxtKohi1Tani(new RString(給付実績特定診療費_特別療養費.get後_公費１_ｻｰﾋﾞｽ単位数()));
        row_2.setTxtKohi1GokeiTani(new RString(給付実績特定診療費_特別療養費.get後_公費１_合計単位数()));
        row_2.setTxtKohi2Kaisu(new RString(給付実績特定診療費_特別療養費.get後_公費２_回数()));
        row_2.setTxtKohi2Tani(new RString(給付実績特定診療費_特別療養費.get後_公費２_ｻｰﾋﾞｽ単位数()));
        row_2.setTxtKohi2GokeiTani(new RString(給付実績特定診療費_特別療養費.get後_公費２_合計単位数()));
        row_2.setTxtKohi3Kaisu(new RString(給付実績特定診療費_特別療養費.get後_公費３_回数()));
        row_2.setTxtKohi3Tani(new RString(給付実績特定診療費_特別療養費.get後_公費３_ｻｰﾋﾞｽ単位数()));
        row_2.setTxtKohi3GokeiTani(new RString(給付実績特定診療費_特別療養費.get後_公費３_合計単位数()));
        row_2.setTxtSaishinsaKaisu(new RString(給付実績特定診療費_特別療養費.get再審査回数()));
        row_2.setTxtKagoKaisu(new RString(給付実績特定診療費_特別療養費.get過誤回数()));
        row_2.setTxtShinsaYM(to日期(給付実績特定診療費_特別療養費.get審査年月()));
        row_2.setTxtBtnTekiyoNayiyo(給付実績特定診療費_特別療養費.get摘要());
        dataSources.add(row_1);
        dataSources.add(row_2);
        List<dgTokuteiShinryohiToH1503_Row> dataSources1503 = new ArrayList<>();
        div.getDgTokuteiShinryohiToH1503().setDataSource(dataSources1503);
        div.getDgTokuteiShinryohiFromH1504().setDataSource(dataSources);
    }

    private void set給付実績特定診療費等(KyufujissekiTokuteiSinryohi 給付実績特定診療費) {
        List<dgTokuteiShinryohiToH1503_Row> 給付実績特定診療費Sources = new ArrayList<>();
        dgTokuteiShinryohiToH1503_Row row_保険 = new dgTokuteiShinryohiToH1503_Row();
        row_保険.setTxtShobyoName(給付実績特定診療費.get傷病名());
        row_保険.setTxtHokenKohi(this.保険);
        row_保険.setTxtKettei(RString.EMPTY);
        row_保険.setTxtShidoKanriryo(new RString(給付実績特定診療費.get保険_指導管理料等()));
        row_保険.setTxtRehabilitation(new RString(給付実績特定診療費.get保険_リハビリテーション()));
        row_保険.setTxtSeishinkaSenmonRyoho(new RString(給付実績特定診療費.get保険_精神科専門療法()));
        row_保険.setTxtTanjunXSen(new RString(給付実績特定診療費.get保険_単純エックス線()));
        row_保険.setTxtShochi(RString.EMPTY);
        row_保険.setTxtShujutu(RString.EMPTY);
        row_保険.setTxtGokeiTani(new RString(給付実績特定診療費.get保険_合計単位数()));
        row_保険.setTxtSaishinsaKaisu(new RString(給付実績特定診療費.get再審査回数()));
        row_保険.setTxtKagoKaisu(new RString(給付実績特定診療費.get過誤回数()));
        row_保険.setTxtShinsaYM(to日期(給付実績特定診療費.get審査年月()));
        row_保険.setTxtBtnTekiyoNayiyo(this.set摘要(給付実績特定診療費));
        dgTokuteiShinryohiToH1503_Row row_後_保険 = new dgTokuteiShinryohiToH1503_Row();
        row_後_保険.setTxtShobyoName(RString.EMPTY);
        row_後_保険.setTxtHokenKohi(RString.EMPTY);
        row_後_保険.setTxtKettei(this.決定２);
        row_後_保険.setTxtShidoKanriryo(new RString(給付実績特定診療費.get後_保険_指導管理料等()));
        row_後_保険.setTxtRehabilitation(new RString(給付実績特定診療費.get後_保険_リハビリテーション()));
        row_後_保険.setTxtSeishinkaSenmonRyoho(new RString(給付実績特定診療費.get後_保険_精神科専門療法()));
        row_後_保険.setTxtTanjunXSen(new RString(給付実績特定診療費.get後_保険_単純エックス線()));
        row_後_保険.setTxtShochi(RString.EMPTY);
        row_後_保険.setTxtShujutu(RString.EMPTY);
        row_後_保険.setTxtGokeiTani(new RString(給付実績特定診療費.get保険_合計単位数()));
        row_後_保険.setTxtSaishinsaKaisu(new RString(給付実績特定診療費.get再審査回数()));
        row_後_保険.setTxtKagoKaisu(new RString(給付実績特定診療費.get過誤回数()));
        row_後_保険.setTxtShinsaYM(to日期(給付実績特定診療費.get審査年月()));
        row_後_保険.setTxtBtnTekiyoNayiyo(this.set摘要(給付実績特定診療費));
        給付実績特定診療費Sources.add(row_保険);
        給付実績特定診療費Sources.add(row_後_保険);
        div.getDgTokuteiShinryohiToH1503().setDataSource(給付実績特定診療費Sources);
        this.set給付実績特定診療費等後(給付実績特定診療費);
    }

    private void set給付実績特定診療費等後(KyufujissekiTokuteiSinryohi 給付実績特定診療費) {
        List<dgTokuteiShinryohiToH1503_Row> 給付実績特定診療費Sources = new ArrayList<>();
        dgTokuteiShinryohiToH1503_Row row_公費１ = new dgTokuteiShinryohiToH1503_Row();
        row_公費１.setTxtShobyoName(給付実績特定診療費.get傷病名());
        row_公費１.setTxtHokenKohi(this.公費１);
        row_公費１.setTxtKettei(RString.EMPTY);
        row_公費１.setTxtShidoKanriryo(new RString(給付実績特定診療費.get公費１_指導管理料等()));
        row_公費１.setTxtRehabilitation(new RString(給付実績特定診療費.get公費１_リハビリテーション()));
        row_公費１.setTxtSeishinkaSenmonRyoho(new RString(給付実績特定診療費.get公費１_精神科専門療法()));
        row_公費１.setTxtTanjunXSen(new RString(給付実績特定診療費.get公費１_単純エックス線()));
        row_公費１.setTxtShochi(RString.EMPTY);
        row_公費１.setTxtShujutu(RString.EMPTY);
        row_公費１.setTxtGokeiTani(new RString(給付実績特定診療費.get公費１_合計単位数()));
        row_公費１.setTxtSaishinsaKaisu(new RString(給付実績特定診療費.get再審査回数()));
        row_公費１.setTxtKagoKaisu(new RString(給付実績特定診療費.get過誤回数()));
        row_公費１.setTxtShinsaYM(to日期(給付実績特定診療費.get審査年月()));
        row_公費１.setTxtBtnTekiyoNayiyo(this.set摘要(給付実績特定診療費));
        dgTokuteiShinryohiToH1503_Row row_後_公費１ = new dgTokuteiShinryohiToH1503_Row();
        row_後_公費１.setTxtShobyoName(RString.EMPTY);
        row_後_公費１.setTxtHokenKohi(RString.EMPTY);
        row_後_公費１.setTxtKettei(this.決定２);
        row_後_公費１.setTxtShidoKanriryo(new RString(給付実績特定診療費.get後_公費１_指導管理料等()));
        row_後_公費１.setTxtRehabilitation(new RString(給付実績特定診療費.get後_公費１_リハビリテーション()));
        row_後_公費１.setTxtSeishinkaSenmonRyoho(new RString(給付実績特定診療費.get後_公費１_精神科専門療法()));
        row_後_公費１.setTxtTanjunXSen(new RString(給付実績特定診療費.get後_公費１_単純エックス線()));
        row_後_公費１.setTxtShochi(RString.EMPTY);
        row_後_公費１.setTxtShujutu(RString.EMPTY);
        row_後_公費１.setTxtGokeiTani(new RString(給付実績特定診療費.get公費１_合計単位数()));
        row_後_公費１.setTxtSaishinsaKaisu(new RString(給付実績特定診療費.get再審査回数()));
        row_後_公費１.setTxtKagoKaisu(new RString(給付実績特定診療費.get過誤回数()));
        row_後_公費１.setTxtShinsaYM(to日期(給付実績特定診療費.get審査年月()));
        row_後_公費１.setTxtBtnTekiyoNayiyo(this.set摘要(給付実績特定診療費));
        dgTokuteiShinryohiToH1503_Row row_公費２ = new dgTokuteiShinryohiToH1503_Row();
        row_公費２.setTxtShobyoName(給付実績特定診療費.get傷病名());
        row_公費２.setTxtHokenKohi(this.公費２);
        row_公費２.setTxtKettei(RString.EMPTY);
        row_公費２.setTxtShidoKanriryo(new RString(給付実績特定診療費.get公費２_指導管理料等()));
        row_公費２.setTxtRehabilitation(new RString(給付実績特定診療費.get公費２_リハビリテーション()));
        row_公費２.setTxtSeishinkaSenmonRyoho(new RString(給付実績特定診療費.get公費２_精神科専門療法()));
        row_公費２.setTxtTanjunXSen(new RString(給付実績特定診療費.get公費２_単純エックス線()));
        row_公費２.setTxtShochi(RString.EMPTY);
        row_公費２.setTxtShujutu(RString.EMPTY);
        row_公費２.setTxtGokeiTani(new RString(給付実績特定診療費.get公費２_合計単位数()));
        row_公費２.setTxtSaishinsaKaisu(new RString(給付実績特定診療費.get再審査回数()));
        row_公費２.setTxtKagoKaisu(new RString(給付実績特定診療費.get過誤回数()));
        row_公費２.setTxtShinsaYM(to日期(給付実績特定診療費.get審査年月()));
        row_公費２.setTxtBtnTekiyoNayiyo(this.set摘要(給付実績特定診療費));
        dgTokuteiShinryohiToH1503_Row row_後_公費２ = new dgTokuteiShinryohiToH1503_Row();
        row_後_公費２.setTxtShobyoName(RString.EMPTY);
        row_後_公費２.setTxtHokenKohi(RString.EMPTY);
        row_後_公費２.setTxtKettei(this.決定２);
        row_後_公費２.setTxtShidoKanriryo(new RString(給付実績特定診療費.get後_公費２_指導管理料等()));
        row_後_公費２.setTxtRehabilitation(new RString(給付実績特定診療費.get後_公費２_リハビリテーション()));
        row_後_公費２.setTxtSeishinkaSenmonRyoho(new RString(給付実績特定診療費.get後_公費２_精神科専門療法()));
        row_後_公費２.setTxtTanjunXSen(new RString(給付実績特定診療費.get後_公費２_単純エックス線()));
        row_後_公費２.setTxtShochi(RString.EMPTY);
        row_後_公費２.setTxtShujutu(RString.EMPTY);
        row_後_公費２.setTxtGokeiTani(new RString(給付実績特定診療費.get公費２_合計単位数()));
        row_後_公費２.setTxtSaishinsaKaisu(new RString(給付実績特定診療費.get再審査回数()));
        row_後_公費２.setTxtKagoKaisu(new RString(給付実績特定診療費.get過誤回数()));
        row_後_公費２.setTxtShinsaYM(to日期(給付実績特定診療費.get審査年月()));
        row_後_公費２.setTxtBtnTekiyoNayiyo(this.set摘要(給付実績特定診療費));
        dgTokuteiShinryohiToH1503_Row row_公費３ = new dgTokuteiShinryohiToH1503_Row();
        row_公費３.setTxtShobyoName(給付実績特定診療費.get傷病名());
        row_公費３.setTxtHokenKohi(this.公費３);
        row_公費３.setTxtKettei(RString.EMPTY);
        row_公費３.setTxtShidoKanriryo(new RString(給付実績特定診療費.get公費３_指導管理料等()));
        row_公費３.setTxtRehabilitation(new RString(給付実績特定診療費.get公費３_リハビリテーション()));
        row_公費３.setTxtSeishinkaSenmonRyoho(new RString(給付実績特定診療費.get公費３_精神科専門療法()));
        row_公費３.setTxtTanjunXSen(new RString(給付実績特定診療費.get公費３_単純エックス線()));
        row_公費３.setTxtShochi(RString.EMPTY);
        row_公費３.setTxtShujutu(RString.EMPTY);
        row_公費３.setTxtGokeiTani(new RString(給付実績特定診療費.get公費３_合計単位数()));
        row_公費３.setTxtSaishinsaKaisu(new RString(給付実績特定診療費.get再審査回数()));
        row_公費３.setTxtKagoKaisu(new RString(給付実績特定診療費.get過誤回数()));
        row_公費３.setTxtShinsaYM(to日期(給付実績特定診療費.get審査年月()));
        row_公費３.setTxtBtnTekiyoNayiyo(this.set摘要(給付実績特定診療費));
        dgTokuteiShinryohiToH1503_Row row_後_公費３ = new dgTokuteiShinryohiToH1503_Row();
        row_後_公費３.setTxtShobyoName(RString.EMPTY);
        row_後_公費３.setTxtHokenKohi(RString.EMPTY);
        row_後_公費３.setTxtKettei(this.決定２);
        row_後_公費３.setTxtShidoKanriryo(new RString(給付実績特定診療費.get後_公費３_指導管理料等()));
        row_後_公費３.setTxtRehabilitation(new RString(給付実績特定診療費.get後_公費３_リハビリテーション()));
        row_後_公費３.setTxtSeishinkaSenmonRyoho(new RString(給付実績特定診療費.get後_公費３_精神科専門療法()));
        row_後_公費３.setTxtTanjunXSen(new RString(給付実績特定診療費.get後_公費３_単純エックス線()));
        row_後_公費３.setTxtShochi(RString.EMPTY);
        row_後_公費３.setTxtShujutu(RString.EMPTY);
        row_後_公費３.setTxtGokeiTani(new RString(給付実績特定診療費.get公費３_合計単位数()));
        row_後_公費３.setTxtSaishinsaKaisu(new RString(給付実績特定診療費.get再審査回数()));
        row_後_公費３.setTxtKagoKaisu(new RString(給付実績特定診療費.get過誤回数()));
        row_後_公費３.setTxtShinsaYM(to日期(給付実績特定診療費.get審査年月()));
        row_後_公費３.setTxtBtnTekiyoNayiyo(this.set摘要(給付実績特定診療費));
        給付実績特定診療費Sources.add(row_公費１);
        給付実績特定診療費Sources.add(row_後_公費１);
        給付実績特定診療費Sources.add(row_公費２);
        給付実績特定診療費Sources.add(row_後_公費２);
        給付実績特定診療費Sources.add(row_公費３);
        給付実績特定診療費Sources.add(row_後_公費３);
        List<dgTokuteiShinryohiFromH1504_Row> dataSources = new ArrayList<>();
        div.getDgTokuteiShinryohiFromH1504().setDataSource(dataSources);
        div.getDgTokuteiShinryohiToH1503().setDataSource(給付実績特定診療費Sources);
    }

    private RString set摘要(KyufujissekiTokuteiSinryohi 給付実績特定診療費) {
        RStringBuilder 摘要 = new RStringBuilder();
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１())) {
            摘要.append(給付実績特定診療費.get摘要１()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要２())) {
            摘要.append(給付実績特定診療費.get摘要２()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要３())) {
            摘要.append(給付実績特定診療費.get摘要３()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要４())) {
            摘要.append(給付実績特定診療費.get摘要４()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要５())) {
            摘要.append(給付実績特定診療費.get摘要５()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要６())) {
            摘要.append(給付実績特定診療費.get摘要６()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要７())) {
            摘要.append(給付実績特定診療費.get摘要７()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要８())) {
            摘要.append(給付実績特定診療費.get摘要８()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要９())) {
            摘要.append(給付実績特定診療費.get摘要９()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１０())) {
            摘要.append(給付実績特定診療費.get摘要１０()).append(NewLine.CRLF.getNewLineString());
        }
        this.set摘要_後(給付実績特定診療費, 摘要);
        return 摘要.toRString();
    }

    private RString set摘要_後(KyufujissekiTokuteiSinryohi 給付実績特定診療費, RStringBuilder 摘要) {
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１１())) {
            摘要.append(給付実績特定診療費.get摘要１１()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１２())) {
            摘要.append(給付実績特定診療費.get摘要１２()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１３())) {
            摘要.append(給付実績特定診療費.get摘要１３()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１４())) {
            摘要.append(給付実績特定診療費.get摘要１４()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１５())) {
            摘要.append(給付実績特定診療費.get摘要１５()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１６())) {
            摘要.append(給付実績特定診療費.get摘要１６()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１７())) {
            摘要.append(給付実績特定診療費.get摘要１７()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１８())) {
            摘要.append(給付実績特定診療費.get摘要１８()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要１９())) {
            摘要.append(給付実績特定診療費.get摘要１９()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績特定診療費.get摘要２０())) {
            摘要.append(給付実績特定診療費.get摘要２０());
        }
        return 摘要.toRString();
    }

    /**
     * 摘要情報
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void get摘要(FlexibleYearMonth サービス提供年月) {
        if (提供年月.isBeforeOrEquals(サービス提供年月)) {
            dgTokuteiShinryohiFromH1504_Row row = div.getDgTokuteiShinryohiFromH1504().getActiveRow();
            div.getTekiyoPanelPanel().getTxtTekiyo().setValue(row.getTxtBtnTekiyoNayiyo());
        } else {
            dgTokuteiShinryohiToH1503_Row row = div.getDgTokuteiShinryohiToH1503().getActiveRow();
            div.getTekiyoPanelPanel().getTxtTekiyo().setValue(row.getTxtBtnTekiyoNayiyo());
        }
    }

    /**
     *
     * 制御性設定です。
     *
     * @param 識別番号管理データ 識別番号管理データ
     */
    public void clear制御性(ShikibetsuNoKanri 識別番号管理データ) {
        div.getBtnTokuteiShinryo().setDisabled(true);
        if (ZERO.equals(識別番号管理データ.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
    }

    private RString to日期(FlexibleYearMonth 審査年月) {
        if (審査年月 != null && !審査年月.isEmpty()) {
            return 審査年月.wareki().toDateString();
        }
        return RString.EMPTY;
    }
}
