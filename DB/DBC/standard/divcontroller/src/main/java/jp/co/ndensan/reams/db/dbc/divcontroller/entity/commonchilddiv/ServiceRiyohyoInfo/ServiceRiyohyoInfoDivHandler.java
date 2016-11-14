/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyotakuKeikakuJikosakuseiKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyotakuKeikakuJikosakuseiKanriBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.YoboKeikakuJikoSakuseiKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.YoboKeikakuJikoSakuseiKanriBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.YoboKeikakuJikoSakuseiTankiRiyoNissu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.GokeiKeisan;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KubunGendo;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiNyushoResult;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeika.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeika.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.service.core.basic.YoboKeikakuJikoSakuseiTankiRiyoNissuManager;
import jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku.JigoSakuseiMeisaiTouroku;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeika.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouManager;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * サービス利用票情報DivのHandlerクラスです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoInfoDivHandler {

    private final ServiceRiyohyoInfoDiv div;
    private static final RString 居宅 = new RString("1");
    private static final RString 総合事業 = new RString("2");
    private static final RString 定値_01 = new RString("01");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 照会 = new RString("照会");
    private static final RString 合計有り = new RString("1");
    private static final RString 合計なし = new RString("0");
    private static final RString COLUMN_保険給付額 = new RString("hokenKyufugaku");
    private static final RString 事業者請求額 = new RString("事業者請求額");
    private static final RString 保険給付額 = new RString("保険給付額");
    private static final RString 暫定区分_0 = new RString("0");
    private static final RString 暫定区分_1 = new RString("1");
    private static final RString 総合事業費請求額 = new RString("総合事業費請求額");
    private static final RString 事業対象利用者負担額 = new RString("事業対象利用者負担額");
    private static final RString 保険対象利用者負担額 = new RString("保険対象利用者負担額");
    private static final RString 保険給付額説明ラベル_1 = new RString("【費用総額 × 給付率】");
    private static final RString 保険給付額説明ラベル_2 = new RString("【費用総額ー利用者負担額(合計)】");
    private static final RString 保険対象利用者負担額説明ラベル_1 = new RString("【費用総額ー総合事業費請求額】");
    private static final RString 保険対象利用者負担額説明ラベル_2 = new RString("【利用者負担額(合計)】");
    private static final RString 保険対象利用者負担額説明ラベル_3 = new RString("【費用総額ー保険給付額】");
    private static final Decimal 給付率_100 = new Decimal(100);
    private static final Decimal 給付率_90 = new Decimal(90);
    private static final Decimal 一割 = new Decimal(10);
    private static final Decimal 二割 = new Decimal(20);
    private static final RString 負担割合区分_1割 = new RString("10");
    private static final RString 負担割合区分_2割 = new RString("20");
    private static final RString 汎用キー_明細番号 = new RString("明細番号");
    private static final RString 居宅予防区分_0 = new RString("0");
    private static final RString 居宅予防区分_1 = new RString("1");
    private static final RString 限度額対象外フラグ_1 = new RString("1");
    private static final RString RSTRING_ZERO = new RString("0");
    private static final RString RSTRING_ONE = new RString("1");
    private static final RString RSTRING_TWO = new RString("2");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final RString 固定値_3 = new RString("3");
    private static final RString 定値_ハイフン = new RString("-");
    private static final Decimal DECIMAL_80 = new Decimal(80);
    private static final Decimal DECIMAL_90 = new Decimal(90);
    private static final Decimal DECIMAL_100 = new Decimal(100);
    private static final Decimal DECIMAL_1000 = new Decimal(1000);
    private static final RString RSTRING_88 = new RString("88");
    private static final RString RSTRING_10 = new RString("10");
    private static final RString RSTRING_11 = new RString("11");
    private static final RString RSTRING_82 = new RString("82");
    private static final RString RSTRING_84 = new RString("84");
    private static final RString RSTRING_85 = new RString("85");
    private static final RString RSTRING_86 = new RString("86");
    private static final RString RSTRING_83 = new RString("83");
    private static final RString RSTRING_87 = new RString("87");
    private static final RString RSTRING_89 = new RString("89");
    private static final RString RSTRING_90 = new RString("90");
    private static final RString RSTRING_91 = new RString("91");
    private static final RString RSTRING_94 = new RString("94");
    private static final RString RSTRING_95 = new RString("95");
    private static final RString RSTRING_47 = new RString("47");
    private static final RString RSTRING_48 = new RString("48");
    private static final RString RSTRING_49 = new RString("49");

    private static final RString RSTRING_08 = new RString("08");
    private static final RString RSTRING_09 = new RString("09");
    private static final RYearMonth 定値_年月 = new RYearMonth("201504");
    private static final RString RSTRING_Ⅲ = new RString("Ⅲ");
    private static final RString RSTRING_Ⅳ = new RString("Ⅳ");
    private static final RString RSTRING_Ⅱ = new RString("Ⅱ");
    private static final RString RSTRING_17 = new RString("17");
    private static final RString RSTRING_67 = new RString("67");
    private static final RString SERVICETANI = new RString("serviceTani");

    /**
     * コンストラクタです。
     *
     * @param div ServiceRiyohyoInfoDiv
     */
    public ServiceRiyohyoInfoDivHandler(ServiceRiyohyoInfoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return ServiceRiyohyoInfoDiv
     */
    public static ServiceRiyohyoInfoDivHandler of(ServiceRiyohyoInfoDiv div) {
        return new ServiceRiyohyoInfoDivHandler(div);
    }

    /**
     * 届出日をセットします。
     *
     * @param 届出日 RDate
     */
    public void setTodokedeYMD(RDate 届出日) {
        div.getTxtTodokedeYMD().setValue(届出日);
    }

    /**
     * 適用期間開始日をセットします。
     *
     * @param 適用期間開始日 RDate
     */
    public void setTekiyoKikanFrom(RDate 適用期間開始日) {
        div.getTxtTekiyoKikan().setFromValue(適用期間開始日);
    }

    /**
     * 適用期間終日をセットします。
     *
     * @param 適用期間終日 RDate
     */
    public void setTekiyoKikanTo(RDate 適用期間終日) {
        div.getTxtTekiyoKikan().setToValue(適用期間終日);
    }

    /**
     * サービス利用票情報初期化のメソッドです。
     *
     * @param 表示モード RString
     * @param 利用年月 FlexibleYearMonth
     * @param 対象年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅総合事業区分 RString
     * @param 履歴番号 int
     */
    public void init(RString 表示モード, FlexibleYearMonth 利用年月, FlexibleYearMonth 対象年月,
            HihokenshaNo 被保険者番号, RString 居宅総合事業区分, int 履歴番号) {
        ViewStateHolder.put(ViewStateKeys.表示モード, 表示モード);
        ViewStateHolder.put(ViewStateKeys.居宅総合事業区分, 居宅総合事業区分);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.利用年月, 利用年月);
        ViewStateHolder.put(ViewStateKeys.対象年月, 対象年月);
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号);
        ViewStateHolder.put(ViewStateKeys.選択有无, false);
        非活性または活性(false);
        set初期化状態(表示モード);
        画面初期化の値のクリア();
        createDDLKoshinKbn();
        div.getTxtKoshinYMD().setValue(RDate.getNowDate());
        if (利用年月 != null && !利用年月.isEmpty()) {
            RStringBuilder rst = new RStringBuilder();
            rst.append(利用年月).append(定値_01);
            div.getTxtRiyoYM().setValue(new RDate(rst.toString()));
            set区分支給限度額(被保険者番号, 居宅総合事業区分, 利用年月);
            set暫定区分制御(被保険者番号, 居宅総合事業区分, 対象年月, 履歴番号, 利用年月, 表示モード);
            setサービス利用票(被保険者番号, 対象年月, 履歴番号, 利用年月);
        } else {
            div.getTxtRiyoYM().setDisabled(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(true);
        }
        if (居宅.equals(居宅総合事業区分)) {
            div.getChkZanteiKubun().setVisible(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting()
                    .getColumn(COLUMN_保険給付額).setColumnName(保険給付額);
        } else if (総合事業.equals(居宅総合事業区分)) {
            div.getChkZanteiKubun().setVisible(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting()
                    .getColumn(COLUMN_保険給付額).setColumnName(事業者請求額);
        }
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getBtnKakutei().setDisplayNone(true);
    }

    private void set初期化状態(RString 表示モード) {
        div.getTxtTodokedeYMD().setDisabled(true);
        div.getTxtTekiyoKikan().setDisabled(true);
        div.getTxtRiyoYM().setDisabled(true);
        div.getChkZanteiKubun().setDisabled(true);
        div.getTxtKubunShikyuGendogaku().setDisabled(true);
        div.getTxtGendoKanriKikan().setDisabled(true);
        div.getBtnShowShuruiGendogaku().setDisabled(false);
        div.getServiceRiyohyoBeppyoList().setDisabled(false);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisplayNone(true);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCalcGokei().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei().setDisabled(true);
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoMeisaiNew().setDisabled(false);
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoGokeiNew().setDisabled(false);
        div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCancelMeisaiInput().setVisible(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisaiGokei().setVisible(true);

        if (追加.equals(表示モード)) {
            div.getDdlKoshinKbn().setDisabled(false);
            div.getTxtKoshinYMD().setDisabled(false);
            div.getBtnZengetsuCopy().setDisabled(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setReadOnly(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(false);
            div.getBtnKakutei().setDisabled(false);
        } else if (修正.equals(表示モード)) {
            div.getDdlKoshinKbn().setDisabled(false);
            div.getTxtKoshinYMD().setDisabled(false);
            div.getBtnZengetsuCopy().setDisabled(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setReadOnly(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(false);
            div.getBtnKakutei().setDisabled(false);
        } else if (削除.equals(表示モード)) {
            非活性または活性(true);
            div.getDdlKoshinKbn().setDisabled(false);
            div.getTxtKoshinYMD().setDisabled(false);
            div.getTxtKoshinYMD().setDisabled(false);
            div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().setDisabled(false);
            div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().setDisabled(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowSelectButtonColumn(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoFooter().getBtnBackRiyoNengetsuIchiran().setDisabled(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(false);
            div.getBtnKakutei().setDisabled(true);
        } else if (照会.equals(表示モード)) {
            非活性または活性(true);
            div.getDdlKoshinKbn().setDisabled(true);
            div.getTxtKoshinYMD().setDisabled(true);
            div.getBtnZengetsuCopy().setDisabled(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCancelMeisaiInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisaiGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(true);
            div.getBtnKakutei().setDisabled(true);
        }
    }

    private void 画面初期化の値のクリア() {
        div.getTxtTodokedeYMD().clearValue();
        div.getTxtTekiyoKikan().clearFromValue();
        div.getTxtTekiyoKikan().clearToValue();
        div.getTxtKubunShikyuGendogaku().clearValue();
        div.getTxtGendoKanriKikan().clearFromValue();
        div.getTxtGendoKanriKikan().clearToValue();
        div.getTxtRiyoYM().clearValue();
        div.getTxtKoshinYMD().clearValue();
        div.getTxtSofuYM().clearValue();
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().clearValue();
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().clearValue();
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().clearValue();
        div.getChkZanteiKubun().setSelectedItemsByKey(new ArrayList<RString>());
        div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList()
                .setDataSource(new ArrayList<dgServiceRiyohyoBeppyoList_Row>());
        事業者サービスクリア();
        div.getServiceRiyohyoBeppyoMeisai().getTxtTani().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtHdnGendogakuTaishogaiFlg().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtHdnRiyoshaFutanTeiritsuTeigakuKbn().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().clearValue();
    }

    private void 非活性または活性(boolean flg) {
        div.getTxtRiyoYM().setDisabled(flg);
        div.getChkZanteiKubun().setDisabled(flg);
        div.getDdlKoshinKbn().setDisabled(flg);
        div.getTxtKoshinYMD().setDisabled(flg);
        div.getTxtSofuYM().setDisabled(flg);
        div.getBtnZengetsuCopy().setDisabled(flg);
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoMeisaiNew().setDisabled(flg);
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoGokeiNew().setDisabled(flg);
        div.getServiceRiyohyoBeppyoRiyoNissu().setDisabled(flg);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisabled(flg);
        div.getServiceRiyohyoBeppyoGokei().setDisabled(flg);
        div.getServiceRiyohyoBeppyoMeisai().setDisabled(flg);
        div.getServiceRiyohyoBeppyoFooter().getBtnBackRiyoNengetsuIchiran().setDisabled(false);
    }

    /**
     * 区分支給限度額および期間を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅総合事業区分 RString
     * @param 利用年月 FlexibleYearMonth
     */
    public void set区分支給限度額(HihokenshaNo 被保険者番号, RString 居宅総合事業区分,
            FlexibleYearMonth 利用年月) {
        JigoSakuseiMeisaiTouroku jigoSakusei = JigoSakuseiMeisaiTouroku.createInstance();
        KubunGendo 区分支給限度額情報 = jigoSakusei.getKubunGendo(被保険者番号, 居宅総合事業区分, 利用年月);
        if (区分支給限度額情報 == null) {
            if (居宅.equals(居宅総合事業区分)) {
                List<RString> list = new ArrayList<>();
                list.add(暫定区分_1);
                div.getChkZanteiKubun().setSelectedItemsByKey(list);
            } else if (総合事業.equals(居宅総合事業区分)) {
                throw new ApplicationException(DbcErrorMessages.対象年月入力不正.getMessage().evaluate());
            }
        } else {
            div.getTxtKubunShikyuGendogaku().setValue(区分支給限度額情報.get区分支給限度額());
            div.getTxtGendoKanriKikan().setFromValue(区分支給限度額情報.get管理期間開始日() == null
                    || 区分支給限度額情報.get管理期間開始日().isEmpty() ? null
                    : new RDate(区分支給限度額情報.get管理期間開始日().toString()));
            div.getTxtGendoKanriKikan().setToValue(区分支給限度額情報.get管理期間終了日() == null
                    || 区分支給限度額情報.get管理期間終了日().isEmpty() ? null
                    : new RDate(区分支給限度額情報.get管理期間終了日().toString()));
        }
        RString 表示モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        if (!照会.equals(表示モード)) {
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(false);
        }
    }

    private void set暫定区分制御(HihokenshaNo 被保険者番号, RString 居宅総合事業区分, FlexibleYearMonth 対象年月,
            int 履歴番号, FlexibleYearMonth 利用年月, RString 表示モード) {
        JigoSakuseiMeisaiTouroku jigoSakusei = JigoSakuseiMeisaiTouroku.createInstance();
        TankiNyushoResult 短期入所情報 = jigoSakusei.getTankiNyuryo(被保険者番号, 対象年月, 履歴番号, 利用年月);
        if (短期入所情報 != null) {
            ViewStateHolder.put(ViewStateKeys.短期入所情報, (Serializable) 短期入所情報);
            if (居宅予防区分_0.equals(短期入所情報.get居宅予防区分())) {
                set短期入所(短期入所情報.get居宅短期入所情報().get前回迄利用日数(),
                        短期入所情報.get居宅短期入所情報().get今回計画利用日数(), 短期入所情報.get居宅短期入所情報().get送付年月(),
                        短期入所情報.get居宅短期入所情報().get更新区分(), 短期入所情報.get居宅短期入所情報().get暫定区分());
            } else if (居宅予防区分_1.equals(短期入所情報.get居宅予防区分())) {
                set短期入所(短期入所情報.get予防短期入所情報().get前回迄利用日数(),
                        短期入所情報.get予防短期入所情報().get今回計画利用日数(), 短期入所情報.get予防短期入所情報().get送付年月(),
                        短期入所情報.get予防短期入所情報().get更新区分(), 短期入所情報.get予防短期入所情報().get暫定区分());
            }

        } else {
            div.getDdlKoshinKbn().setSelectedKey(KyufukanrihyoSakuseiKubun.新規.getコード());
        }
        if (居宅.equals(居宅総合事業区分)) {
            int count = jigoSakusei.load利用年月チェック(被保険者番号, 利用年月);
            if (count == 0) {
                List<RString> list = new ArrayList<>();
                list.add(暫定区分_1);
                div.getChkZanteiKubun().setSelectedItemsByKey(list);
            } else {
                div.getChkZanteiKubun().setDisabled(false);
            }
            if (照会.equals(表示モード)) {
                div.getChkZanteiKubun().setDisabled(true);
            }
        }
    }

    private Decimal nullToZero(Decimal decimal) {
        return decimal == null ? Decimal.ZERO : decimal;
    }

    private void set短期入所(Decimal 前回迄利用日数, Decimal 今回計画利用日数, FlexibleYearMonth 送付年月,
            RString 更新区分, RString 暫定区分) {
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().setValue(前回迄利用日数);
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().setValue(今回計画利用日数);
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu()
                .setValue(nullToZero(前回迄利用日数).add(nullToZero(今回計画利用日数)));
        div.getTxtSofuYM().setValue(isFlexibleYearMonthNullOrEmpty(送付年月) ? null
                : new RDate(送付年月.toString().concat(定値_01.toString())));
        if (暫定区分_1.equals(暫定区分)) {
            List<RString> list = new ArrayList<>();
            list.add(暫定区分_1);
            div.getChkZanteiKubun().setSelectedItemsByKey(list);
        } else {
            div.getChkZanteiKubun().setSelectedItemsByKey(new ArrayList<RString>());
        }
        if (更新区分 == null) {
            更新区分 = RString.EMPTY;
        }
        if (送付年月 == null) {
            送付年月 = FlexibleYearMonth.EMPTY;
        }
        if (更新区分.isEmpty() && 送付年月.isEmpty()) {
            div.getDdlKoshinKbn().setSelectedKey(KyufukanrihyoSakuseiKubun.新規.getコード());
        } else if (KyufukanrihyoSakuseiKubun.新規.getコード().equals(更新区分) && 送付年月.isEmpty()) {
            div.getDdlKoshinKbn().setSelectedKey(KyufukanrihyoSakuseiKubun.新規.getコード());
        } else if (KyufukanrihyoSakuseiKubun.新規.getコード().equals(更新区分) && !送付年月.isEmpty()) {
            div.getDdlKoshinKbn().setSelectedKey(KyufukanrihyoSakuseiKubun.変更.getコード());
        } else if (KyufukanrihyoSakuseiKubun.変更.getコード().equals(更新区分)) {
            div.getDdlKoshinKbn().setSelectedKey(KyufukanrihyoSakuseiKubun.変更.getコード());
        } else if (KyufukanrihyoSakuseiKubun.取消.getコード().equals(更新区分) && 送付年月.isEmpty()) {
            div.getDdlKoshinKbn().setSelectedKey(KyufukanrihyoSakuseiKubun.変更.getコード());
        } else if (KyufukanrihyoSakuseiKubun.取消.getコード().equals(更新区分) && !送付年月.isEmpty()) {
            div.getDdlKoshinKbn().setSelectedKey(KyufukanrihyoSakuseiKubun.新規.getコード());
        }
    }

    /**
     * サービス利用票を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 利用年月 FlexibleYearMonth
     */
    public void setサービス利用票(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 利用年月) {
        JigoSakuseiMeisaiTouroku jigoSakusei = JigoSakuseiMeisaiTouroku.createInstance();
        List<KyufuJikoSakuseiResult> サービス利用票情報 = jigoSakusei.getServiceRiyouHyo(被保険者番号, 対象年月, 履歴番号, 利用年月);
        List<dgServiceRiyohyoBeppyoList_Row> rowList = new ArrayList<>();
        int i = 0;
        for (KyufuJikoSakuseiResult result : サービス利用票情報) {
            dgServiceRiyohyoBeppyoList_Row row = setRow(result);
            if (i == サービス利用票情報.size() - 1) {
                row.setHdnGokeiGyoFlag(RSTRING_ONE);
                setRowButtonState(row);
            } else {
                row.setHdnGokeiGyoFlag(RSTRING_ZERO);
            }
            rowList.add(row);
            i++;
        }
        div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowList);
        ViewStateHolder.put(ViewStateKeys.給付計画自己作成EntityList, (Serializable) サービス利用票情報);
    }

    private void setRowButtonState(dgServiceRiyohyoBeppyoList_Row row) {
        row.setSelectButtonState(DataGridButtonState.Disabled);
        row.setDeleteButtonState(DataGridButtonState.Disabled);
        row.setModifyButtonState(DataGridButtonState.Disabled);
    }

    private dgServiceRiyohyoBeppyoList_Row setRow(KyufuJikoSakuseiResult result) {
        dgServiceRiyohyoBeppyoList_Row row = new dgServiceRiyohyoBeppyoList_Row();
        row.setJigyosha(result.get事業者());
        row.setService(result.getサービス());
        row.setTani(result.get単位());
        row.setWaribikigoRitsu(result.get割引適用後率());
        row.setWaribikigoTani(result.get割引適用後単位());
        row.setKaisu(result.get回数());
        row.getServiceTani().setValue(result.getサービス単位());
        if ((RString.isNullOrEmpty(row.getTani())
                || (!定値_ハイフン.equals(row.getTani()) && Decimal.ZERO.equals(new Decimal(row.getTani().toString()))))
                && !Decimal.ZERO.equals(row.getServiceTani().getValue())) {
            row.setCellBgColor(SERVICETANI.toString(), DataGridCellBgColor.bgColorLightBlue);
        }
        row.getShuruiGendoChokaTani().setValue(result.get種類限度超過単位());
        row.getShuruiGendonaiTani().setValue(result.get種類限度内単位());
        row.getKubunGendoChokaTani().setValue(result.get区分限度超過単位());
        row.getKubunGendonaiTani().setValue(result.get区分限度内単位());
        row.setTanisuTanka(result.get単位数単価());
        row.getHiyoSogaku().setValue(result.get費用総額());
        row.setKyufuritsu(result.get給付率());
        row.getHokenKyufugaku().setValue(result.get保険給付額());
        row.getRiyoshaFutangakuTeigaku().setValue(result.get定額利用者負担単価金額());
        row.getRiyoshaFutangakuHoken().setValue(result.get保険対象利用者負担額());
        row.getRiyoshaFutangakuZengaku().setValue(result.get全額利用者負担額());
        row.setHdnJigyoshaCode(result.get事業者コード() == null ? null : result.get事業者コード().getColumnValue());
        row.setHdnServiceShuruiCode(result.getサービス種類コード() == null ? null
                : result.getサービス種類コード().getColumnValue());
        row.setHdnGendogakuTaishogaiFlag(result.get限度額対象外フラグ());
        row.setHdnRiyoshaFutanTeiritsuTeigakuKbn(result.get利用者負担定率定額区分());
        row.setHdnMeisaiNo(new RString(String.valueOf(result.get明細番号())));
        row.setHdnServiceKomokuCode(result.getサービス項目コード() == null ? null
                : result.getサービス項目コード().getColumnValue());
        row.setHdnGokeiFlag(result.is合計フラグ() ? 合計有り : 合計なし);
        return row;
    }

    private void createDDLKoshinKbn() {
        List<KeyValueDataSource> kv = new ArrayList<>();
        kv.add(new KeyValueDataSource(KyufukanrihyoSakuseiKubun.新規.getコード(), KyufukanrihyoSakuseiKubun.新規.get名称()));
        kv.add(new KeyValueDataSource(KyufukanrihyoSakuseiKubun.変更.getコード(), KyufukanrihyoSakuseiKubun.変更.get名称()));
        kv.add(new KeyValueDataSource(KyufukanrihyoSakuseiKubun.取消.getコード(), KyufukanrihyoSakuseiKubun.取消.get名称()));
        div.getDdlKoshinKbn().setDataSource(kv);
    }

    /**
     * 累積利用日数の設定メソッドです。
     */
    public void set累積利用日数() {
        Decimal 前月までの利用日数 = div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().getValue();
        Decimal 当月の計画利用日数 = div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().getValue();
        if (前月までの利用日数 == null && 当月の計画利用日数 != null) {
            div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().setValue(当月の計画利用日数);
        } else if (前月までの利用日数 != null && 当月の計画利用日数 == null) {
            div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().setValue(前月までの利用日数);
        } else if (前月までの利用日数 != null && 当月の計画利用日数 != null) {
            div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().setValue(前月までの利用日数.add(当月の計画利用日数));
        } else {
            div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().clearValue();
        }
    }

    /**
     * 事業者、明細と合計パネルにデータ反映する。
     */
    public void setパネルにデータ反映() {
        dgServiceRiyohyoBeppyoList_Row row = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getClickedItem();
        RString 表示モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        if (削除.equals(表示モード)) {
            row.setRowState(RowState.Deleted);
        }
        if (合計なし.equals(row.getHdnGokeiGyoFlag())) {
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setNyuryokuShisetsuKodo(row.getHdnJigyoshaCode());
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setサービス種類コード(row.getHdnServiceShuruiCode());
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setサービス項目コード(row.getHdnServiceKomokuCode());
//            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().initialize(row.getHdnServiceShuruiCode());
        }
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisplayNone(false);

        div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setValue(RString.isNullOrEmpty(row.getTani())
                ? null : new Decimal(row.getTani().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setValue(RString.isNullOrEmpty(row.getWaribikigoRitsu())
                ? null : new Decimal(row.getWaribikigoRitsu().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setValue(RString.isNullOrEmpty(row.getWaribikigoTani())
                ? null : new Decimal(row.getWaribikigoTani().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setValue(RString.isNullOrEmpty(row.getKaisu())
                ? null : new Decimal(row.getKaisu().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(row.getServiceTani().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setValue(row.getRiyoshaFutangakuTeigaku().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setVisible(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei().setVisible(true);
        div.getServiceRiyohyoBeppyoMeisai().getTxtHdnGendogakuTaishogaiFlg().setValue(row.getHdnGendogakuTaishogaiFlag());
        div.getServiceRiyohyoBeppyoMeisai().getTxtHdnRiyoshaFutanTeiritsuTeigakuKbn()
                .setValue(row.getHdnRiyoshaFutanTeiritsuTeigakuKbn());

        div.getServiceRiyohyoBeppyoGokei().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().setValue(row.getShuruiGendoChokaTani().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().setValue(row.getShuruiGendonaiTani().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().setValue(RString.isNullOrEmpty(row.getTanisuTanka())
                ? null : new Decimal(row.getTanisuTanka().toString()));
        div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setValue(row.getKubunGendoChokaTani().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setValue(row.getKubunGendonaiTani().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setValue(RString.isNullOrEmpty(row.getKyufuritsu())
                ? null : new Decimal(row.getKyufuritsu().toString()));
        div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().setValue(row.getHiyoSogaku().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setValue(row.getHokenKyufugaku().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setValue(row.getRiyoshaFutangakuHoken().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().setValue(row.getRiyoshaFutangakuZengaku().getValue());

        RString 居宅総合事業区分 = ViewStateHolder.get(ViewStateKeys.居宅総合事業区分, RString.class);
        if (総合事業.equals(居宅総合事業区分)) {
            div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setLabelLText(総合事業費請求額);
            div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setLabelLText(事業対象利用者負担額);
            if (RSTRING_TWO.equals(row.getHdnRiyoshaFutanTeiritsuTeigakuKbn())) {
                div.getServiceRiyohyoBeppyoGokei().getLblHokenKyufugaku().setText(保険給付額説明ラベル_2);
                div.getServiceRiyohyoBeppyoGokei().getLblRiyoshaFutangakuHoken().setText(保険対象利用者負担額説明ラベル_2);
            } else if (RSTRING_ONE.equals(row.getHdnRiyoshaFutanTeiritsuTeigakuKbn())) {
                div.getServiceRiyohyoBeppyoGokei().getLblHokenKyufugaku().setText(保険給付額説明ラベル_1);
                div.getServiceRiyohyoBeppyoGokei().getLblRiyoshaFutangakuHoken().setText(保険対象利用者負担額説明ラベル_1);
            }
        } else if (居宅.equals(居宅総合事業区分)) {
            div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setLabelLText(保険給付額);
            div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setLabelLText(保険対象利用者負担額);
            div.getServiceRiyohyoBeppyoGokei().getLblHokenKyufugaku().setText(保険給付額説明ラベル_1);
            div.getServiceRiyohyoBeppyoGokei().getLblRiyoshaFutangakuHoken().setText(保険対象利用者負担額説明ラベル_3);
        }
    }

    /**
     * 明細の計算ボタンのメッセージチェック。
     *
     * @return RString
     */
    public RString onBeforeClick_btnCalcMeisai() {
        RString サービス種類コード = div.getCcdServiceCodeInput().getサービスコード1();
        RString サービス項目コード = div.getCcdServiceCodeInput().getサービスコード2();
        Decimal 単位 = div.getServiceRiyohyoBeppyoMeisai().getTxtTani().getValue() == null
                ? Decimal.ZERO : div.getServiceRiyohyoBeppyoMeisai().getTxtTani().getValue();
        KaigoServiceNaiyouManager manager = new KaigoServiceNaiyouManager();
        List<KaigoServiceNaiyou> 利用サービスリスト = manager.getServiceCodeList(サービス種類コード, サービス項目コード);
        return 入力不可判定(利用サービスリスト, 単位);
    }

    private RString 入力不可判定(List<KaigoServiceNaiyou> 利用サービスリスト, Decimal 単位) {
        boolean 単位判定フラグ = Decimal.ZERO.compareTo(単位) <= 0;
        RString 判定フラグ = RSTRING_ZERO;
        for (KaigoServiceNaiyou item : 利用サービスリスト) {
            boolean 単位数判定フラグ = item.get単位数() - 0 < 0;
            if (単位判定フラグ && 単位数判定フラグ) {
                判定フラグ = RSTRING_ONE;
                break;
            }
            if (!単位判定フラグ && !単位数判定フラグ) {
                判定フラグ = RSTRING_TWO;
                break;
            }
        }
        return 判定フラグ;
    }

    /**
     * 「明細の計算」ボタンのイベントです。
     */
    public void onClick_btnCalcMeisai() {
        Decimal 単位 = div.getServiceRiyohyoBeppyoMeisai().getTxtTani().getValue() == null ? Decimal.ZERO
                : div.getServiceRiyohyoBeppyoMeisai().getTxtTani().getValue();
        Decimal 割引適用後率 = div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().getValue();
        Decimal 回数 = div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().getValue();
        Decimal 定額利用者負担額 = div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().getValue();
        RString サービス = div.getCcdServiceCodeInput().getサービスコード1().substring(INT_0, INT_2);

        Decimal 割引適用後単位 = 単位.multiply(割引適用後率.divide(DECIMAL_100)).roundHalfUpTo(INT_0);
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setValue(割引適用後単位);
        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(割引適用後単位.multiply(回数));
        RString 利用者負担定率定額区分 = div.getServiceRiyohyoBeppyoMeisai().getTxtHdnRiyoshaFutanTeiritsuTeigakuKbn().getValue();
        if (RSTRING_TWO.equals(利用者負担定率定額区分)) {
            if (RSTRING_88.equals(サービス)) {
                div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setValue(定額利用者負担額);
            } else {
                div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setValue(
                        定額利用者負担額.multiply(回数));
            }
        }
        div.getServiceRiyohyoBeppyoMeisai().getBtnBeppyoMeisaiKakutei().setDisabled(false);
    }

    /**
     * サービス項目コードのイベントです。
     */
    public void onChange_txtServiceEvent() {
        RString サービス種類Tmp;
        boolean サービスフラグTmp;
        KaigoServiceNaiyou 利用サービス = null;
        RString 種類コード = div.getCcdServiceTypeInput().getサービス種類コード();
        RString サービス種類コード = div.getCcdServiceCodeInput().getサービスコード1();
        RString サービス項目コード = div.getCcdServiceCodeInput().getサービスコード2();
        FlexibleYearMonth 利用年月 = new FlexibleYearMonth(div.getTxtRiyoYM().getValue().getYearMonth().toString());
        if (RString.isNullOrEmpty(種類コード)) {
            サービス種類Tmp = サービス種類コード;
            サービスフラグTmp = true;
            KaigoServiceNaiyouManager manager = new KaigoServiceNaiyouManager();
            KaigoServiceNaiyou 利用サービスリスト = manager.getServiceList(
                    サービス種類コード, サービス項目コード, 利用年月);
            利用サービス = 利用サービスリスト;
        } else {
            サービス種類Tmp = 種類コード;
            サービスフラグTmp = false;

        }
        RString 居宅総合事業区分 = ViewStateHolder.get(ViewStateKeys.居宅総合事業区分, RString.class
        );
        if (総合事業.equals(居宅総合事業区分)) {
            総合事業の場合(サービス種類Tmp, サービスフラグTmp, 利用サービス);
        }

        if (!総合事業.equals(居宅総合事業区分)
                && サービスフラグTmp && 利用サービス != null
                && (RSTRING_08.equals(利用サービス.get単位数識別().getKey())
                || RSTRING_09.equals(利用サービス.get単位数識別().getKey()))) {
            総合事業以外の場合(サービス種類Tmp, 利用サービス);
        }

        if (RSTRING_17.equals(サービス種類Tmp)
                || RSTRING_67.equals(サービス種類Tmp)
                || RSTRING_88.equals(サービス種類Tmp)) {
            div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setReadOnly(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setReadOnly(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setReadOnly(true);
            div.getBtnCalcMeisai().setVisible(false);
            div.getBtnCalcGokei().setVisible(false);
            div.getBtnBeppyoMeisaiKakutei().setVisible(false);
            div.getBtnBeppyoGokeiKakutei().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setReadOnly(false);
            div.getBtnCancelMeisaiInput().setVisible(false);
            div.getBtnCalcMeisaiGokei().setVisible(false);
        }
        if (サービスフラグTmp && 利用サービス
                != null) {
            div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setValue(
                    new Decimal(利用サービス.get単位数()));
            div.getServiceRiyohyoBeppyoMeisai().getTxtHdnGendogakuTaishogaiFlg()
                    .setValue(利用サービス.get限度額対象外フラグ());
            div.getServiceRiyohyoBeppyoMeisai().getTxtHdnRiyoshaFutanTeiritsuTeigakuKbn()
                    .setValue(利用サービス.get利用者負担定率定額区分());
        }
    }

    private void 総合事業の場合(RString サービス種類Tmp, boolean サービスフラグTmp,
            KaigoServiceNaiyou 利用サービス) throws ApplicationException {
        KaigoServiceShuruiManager serviceShuruimanager = KaigoServiceShuruiManager.createInstance();
        List<KaigoServiceShurui> result = serviceShuruimanager.getFocusServiceTypeList(サービス種類Tmp).records();
        if (result == null || result.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.サービス種類不正.getMessage());
        }
        for (KaigoServiceShurui item : result) {
            RString サービス分類コード = item.getサービス分類コード().getKey();
            if (!RSTRING_10.equals(サービス分類コード) && !RSTRING_11.equals(サービス分類コード)) {
                throw new ApplicationException(DbcErrorMessages.サービス種類不正.getMessage());
            }
        }
        List<RString> サービス種類List = new ArrayList();
        サービス種類List.add(RSTRING_82);
        サービス種類List.add(RSTRING_84);
        サービス種類List.add(RSTRING_85);
        サービス種類List.add(RSTRING_86);
        サービス種類List.add(RSTRING_83);
        サービス種類List.add(RSTRING_87);
        サービス種類List.add(RSTRING_88);
        サービス種類List.add(RSTRING_89);
        サービス種類List.add(RSTRING_90);
        サービス種類List.add(RSTRING_91);
        サービス種類List.add(RSTRING_94);
        サービス種類List.add(RSTRING_95);
        サービス種類List.add(RSTRING_47);
        サービス種類List.add(RSTRING_48);
        サービス種類List.add(RSTRING_49);
        if (!サービス種類List.contains(サービス種類Tmp)) {
            throw new ApplicationException(DbcErrorMessages.サービス種類不正.getMessage());
        }
        if (サービスフラグTmp) {
            if (利用サービス == null || !RSTRING_ONE.equals(利用サービス.get総合事業サービス区分())) {
                throw new ApplicationException(DbcErrorMessages.サービス種類不正.getMessage());
            } else if (RSTRING_TWO.equals(利用サービス.get利用者負担定率定額区分())) {
                set利用者負担額(利用サービス);
            }
        }
    }

    private void set利用者負担額(KaigoServiceNaiyou 利用サービス) {
        if (RString.isNullOrEmpty(利用サービス.get利用者負担額())) {
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setValue(Decimal.ZERO);
        } else {
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setValue(
                    new Decimal(利用サービス.get利用者負担額().toString()));
        }
    }

    private void 総合事業以外の場合(RString サービス種類Tmp, KaigoServiceNaiyou 利用サービス) {
        List<dgServiceRiyohyoBeppyoList_Row> rowList
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        for (dgServiceRiyohyoBeppyoList_Row row : rowList) {
            if (合計有り.equals(row.getHdnGokeiGyoFlag())
                    && row.getHdnJigyoshaCode().equals(div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo())
                    && row.getHdnServiceShuruiCode().equals(サービス種類Tmp)) {
                int 単位数 = 利用サービス.get単位数();
                Decimal サービス単位 = row.getServiceTani().getValue().multiply(
                        単位数).divide(DECIMAL_1000).roundHalfUpTo(INT_0);
                div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(サービス単位);
                RString 加算区分 = 利用サービス.getサービス名称().substring(利用サービス.getサービス名称().length() - INT_2);
                RYearMonth 画面利用年月 = div.getTxtRiyoYM().getValue().getYearMonth();
                利用年月判定(画面利用年月, 加算区分, サービス単位);
                Decimal 区分限度内単位
                        = row.getKubunGendonaiTani().getValue().multiply(単位数).divide(DECIMAL_1000).roundHalfUpTo(INT_0);
                div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setValue(区分限度内単位);
                Decimal サービス単位final = div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().getValue();
                div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setValue(サービス単位final.subtract(区分限度内単位));
            }
        }
    }

    private void 利用年月判定(RYearMonth 画面利用年月, RString 加算区分, Decimal サービス単位) {
        if (定値_年月.isBeforeOrEquals(画面利用年月)) {
            if (RSTRING_Ⅲ.equals(加算区分)) {
                div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(
                        サービス単位.multiply(DECIMAL_90).divide(DECIMAL_100).roundHalfUpTo(INT_0));
            } else if (RSTRING_Ⅳ.equals(加算区分)) {
                div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(
                        サービス単位.multiply(DECIMAL_80).divide(DECIMAL_100).roundHalfUpTo(INT_0));
            }
        } else {
            if (RSTRING_Ⅱ.equals(加算区分)) {
                div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(
                        サービス単位.multiply(DECIMAL_90).divide(DECIMAL_100).roundHalfUpTo(INT_0));
            } else if (RSTRING_Ⅲ.equals(加算区分)) {
                div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(
                        サービス単位.multiply(DECIMAL_80).divide(DECIMAL_100).roundHalfUpTo(INT_0));
            }
        }
    }

    /**
     * 明細情報のみ確定するのイベントです。
     *
     * @param 状態 RString
     */
    public void onClick_btnBeppyoMeisaiKakutei(RString 状態) {
        ステータス設定(状態);
        明細パネルを初期化();
        List<dgServiceRiyohyoBeppyoList_Row> rowList
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowList);
    }

    private void ステータス設定(RString 状態) throws ApplicationException {
        boolean 選択有无 = ViewStateHolder.get(ViewStateKeys.選択有无, Boolean.class);
        List<dgServiceRiyohyoBeppyoList_Row> rowList
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        dgServiceRiyohyoBeppyoList_Row row
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getClickedItem();
        if (!選択有无) {
            row = new dgServiceRiyohyoBeppyoList_Row();
            row.setRowState(RowState.Added);
            setRowInButtonMeisaiKakutei(row);
            rowList.add(row);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowList);
        } else {
            選択データありの場合(row, 状態);
            setRowInButtonMeisaiKakutei(row);
        }
        List<dgServiceRiyohyoBeppyoList_Row> rowListNew
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        rowListNew = ソードGrid(rowListNew);
        div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowListNew);

    }

    private void 選択データありの場合(dgServiceRiyohyoBeppyoList_Row row, RString 状態) throws ApplicationException {
        boolean サービスコードフラグ
                = row.getHdnServiceShuruiCode().equals(div.getCcdServiceCodeInput().getサービスコード1())
                && row.getHdnServiceKomokuCode().equals(div.getCcdServiceCodeInput().getサービスコード2());
        if (row.getHdnJigyoshaCode().equals(div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo()) && サービスコードフラグ) {
            if (row.getServiceTani().equals(div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani())) {
                throw new ApplicationException(DbcErrorMessages.重複データサービス.getMessage());
            } else {
                throw new ApplicationException(DbcErrorMessages.重複サービス.getMessage());
            }
        }
        RowState state = row.getRowState();
        if (修正.equals(状態)) {
            row.setRowState(RowState.Modified);
            if (RowState.Added.equals(state)) {
                row.setRowState(RowState.Added);
            }
        } else if (削除.equals(状態)) {
            row.setRowState(RowState.Deleted);
            if (RowState.Added.equals(state)) {
                row.setRowState(null);
            }
        }
    }

    private void 明細パネルを初期化() {
        div.getServiceRiyohyoBeppyoMeisai().setDisabled(true);
    }

    private void setRowInButtonMeisaiKakutei(dgServiceRiyohyoBeppyoList_Row row) {
        RString サービス種類コードTmp;
        RString サービス項目コードTmp;
        RString サービスTmp;
        if (!div.getCcdServiceCodeInput().isDisplayNone()) {
            サービス種類コードTmp = div.getCcdServiceCodeInput().getサービスコード1();
            サービス項目コードTmp = div.getCcdServiceCodeInput().getサービスコード2();
            サービスTmp = div.getCcdServiceCodeInput().getサービス名称();
        } else {
            サービス種類コードTmp = div.getCcdServiceTypeInput().getサービス種類コード();
            サービス項目コードTmp = RSTRING_ZERO;
            サービスTmp = div.getCcdServiceTypeInput().getサービス種類名称();
        }
        row.setJigyosha(div.getCcdJigyoshaInput().getNyuryokuShisetsuMeisho());
        row.setService(サービスTmp);
        row.setTani(new RString(div.getServiceRiyohyoBeppyoMeisai().getTxtTani().getValue().toString()));
        row.setWaribikigoRitsu(new RString(div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().getValue().toString()));
        row.setWaribikigoTani(new RString(div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().getValue().toString()));
        row.setKaisu(div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().getValue() == null ? null
                : new RString(div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().getValue().toString()));
        row.getServiceTani().setValue(div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().getValue());
        if ((RString.isNullOrEmpty(row.getTani()) || Decimal.ZERO.equals(new Decimal(row.getTani().toString())))
                && !Decimal.ZERO.equals(row.getServiceTani().getValue())) {
            row.setCellBgColor(SERVICETANI.toString(), DataGridCellBgColor.bgColorLightBlue);
        }
        row.setHdnJigyoshaCode(div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo());
        row.setHdnServiceShuruiCode(サービス種類コードTmp);
        row.setHdnGendogakuTaishogaiFlag(div.getServiceRiyohyoBeppyoMeisai().getTxtHdnGendogakuTaishogaiFlg().getValue());
        row.setHdnRiyoshaFutanTeiritsuTeigakuKbn(
                div.getServiceRiyohyoBeppyoMeisai().getTxtHdnRiyoshaFutanTeiritsuTeigakuKbn().getValue());
        row.setHdnServiceKomokuCode(サービス項目コードTmp);
        row.setHdnGokeiFlag(合計なし);
        row.setHdnGokeiGyoFlag(RSTRING_ZERO);
    }

    private List<dgServiceRiyohyoBeppyoList_Row> ソードGrid(List<dgServiceRiyohyoBeppyoList_Row> rowList) {
        Collections.sort(rowList, new Comparator<dgServiceRiyohyoBeppyoList_Row>() {
            @Override
            public int compare(dgServiceRiyohyoBeppyoList_Row arg0, dgServiceRiyohyoBeppyoList_Row arg1) {
                return sort(arg0, arg1);
            }
        });
        return rowList;
    }

    private int sort(dgServiceRiyohyoBeppyoList_Row arg0, dgServiceRiyohyoBeppyoList_Row arg1) {
        int flag = arg0.getHdnGokeiGyoFlag().compareTo(arg1.getHdnGokeiGyoFlag());
        if (flag == 0) {
            int flag1 = arg0.getHdnJigyoshaCode().compareTo(arg1.getHdnJigyoshaCode());
            if (flag1 == 0) {
                return arg0.getHdnGokeiFlag().compareTo(arg1.getHdnGokeiFlag());
            } else {
                return flag1;
            }
        }
        return flag;
    }

    /**
     * 合計の計算のイベントです。
     */
    public void onClick_btnGokeiKeisan() {
        Decimal 利用者負担額 = div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().getValue();
        Decimal 区分限度内単位 = div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().getValue();
        Decimal 区分限度超過単位 = div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().getValue();
        Decimal 種類限度内単位 = div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().getValue();
        Decimal 種類限度超過単位 = div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().getValue();
        Decimal サービス単位 = div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().getValue();
        Decimal 単位数単価 = div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().getValue();
        Decimal 給付率Decimal = div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().getValue()
                == null ? Decimal.ZERO : div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().getValue();
        HokenKyufuRitsu 給付率 = new HokenKyufuRitsu(給付率Decimal);
//        種類支給額チェック(種類限度内単位, 種類限度超過単位);
//        区分支給額チェック(区分限度内単位, 区分限度超過単位, 種類限度超過単位, サービス単位);
        JigoSakuseiMeisaiTouroku service = JigoSakuseiMeisaiTouroku.createInstance();
        GokeiKeisan 合計計算処理結果 = service.getGokeiKeisan(利用者負担額, 種類限度超過単位, 種類限度内単位,
                単位数単価, 区分限度超過単位, 区分限度内単位, 給付率, サービス単位);
        合計結果画面設定(合計計算処理結果);
        div.getServiceRiyohyoBeppyoGokei().getBtnBeppyoGokeiKakutei().setDisabled(false);
    }

//    private void 種類支給額チェック(Decimal 種類限度内単位, Decimal 種類限度超過単位) {
//        Decimal サービス単位 = div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().getValue() == null
//                ? Decimal.ZERO : div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().getValue();
//        if (Decimal.ZERO.compareTo(種類限度内単位.add(種類限度超過単位)) < 0
//                && !種類限度内単位.add(種類限度超過単位).equals(サービス単位)) {
//            throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage()
//                    .replace(種類限度単位指定エラー.toString()));
//        } else if (div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().isDisabled() && !Decimal.ZERO.equals(サービス単位)) {
//            throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage()
//                    .replace(区分限度単位指定エラー.toString()));
//        }
//    }
//
//    private void 区分支給額チェック(Decimal 区分限度内単位, Decimal 区分限度超過単位, Decimal 種類限度超過単位, Decimal サービス単位) {
//        if (Decimal.ZERO.compareTo(区分限度内単位.add(区分限度超過単位)) < 0) {
//            Decimal ワークサービス単位;
//            RString ワークメッセージ編集;
//            if (Decimal.ZERO.compareTo(区分限度内単位) < 0) {
//                ワークサービス単位 = 区分限度内単位;
//                ワークメッセージ編集 = 区分限度単位指定エラー;
//            } else if (div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().isDisabled()) {
//                ワークサービス単位 = サービス単位;
//                ワークメッセージ編集 = 種類区分限度単位指定エラー;
//            } else {
//                ワークサービス単位 = Decimal.ZERO;
//                ワークメッセージ編集 = 種類区分限度単位指定エラー;
//            }
//            if (!ワークサービス単位.equals(区分限度内単位.add(種類限度超過単位).add(区分限度超過単位))) {
//                throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage()
//                        .replace(ワークメッセージ編集.toString()));
//            }
//        } else if (!サービス単位.equals(区分限度内単位.add(種類限度超過単位).add(区分限度超過単位))
//                && (!div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().isDisabled()
//                || !RSTRING_ONE.equals(div.getServiceRiyohyoBeppyoMeisai().getTxtHdnGendogakuTaishogaiFlg().getValue()))) {
//            throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage()
//                    .replace(種類区分限度単位指定エラー.toString()));
//        }
//    }
    private void 合計結果画面設定(GokeiKeisan 合計計算処理結果) {
        if (合計計算処理結果.get費用総額() == null) {
            div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().setValue(Decimal.ZERO);
        } else {
            div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().setValue(合計計算処理結果.get費用総額());
        }
        if (合計計算処理結果.get保険給付額() == null) {
            div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setValue(Decimal.ZERO);
        } else {
            div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setValue(合計計算処理結果.get保険給付額());
        }
        if (合計計算処理結果.get保険対象利用者負担額() == null) {
            div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setValue(Decimal.ZERO);
        } else {
            div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setValue(合計計算処理結果.get保険対象利用者負担額());
        }
        if (合計計算処理結果.get全額利用者負担額() == null) {
            div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().setValue(Decimal.ZERO);
        } else {
            div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().setValue(合計計算処理結果.get全額利用者負担額());
        }
    }

    /**
     * 合計情報の確定するのイベントです。
     *
     */
    public void onClick_btnBeppyoGokeiKakutei() {
        合計反映();
        List<dgServiceRiyohyoBeppyoList_Row> rowList
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        rowList = ソードGrid(rowList);
        if (RSTRING_ONE.equals(rowList.get(rowList.size() - 1).getHdnGokeiGyoFlag())) {
            rowList.remove(rowList.size() - 1);
        }
        JigoSakuseiMeisaiTouroku service = JigoSakuseiMeisaiTouroku.createInstance();
        KyufuJikoSakuseiResult result = service.getMeisaiGoukeiListGridAdjust(rowListToResult(rowList));
        dgServiceRiyohyoBeppyoList_Row row = setRow(result);
        row.setHdnGokeiGyoFlag(RSTRING_ONE);
        setRowButtonState(row);
        rowList.add(row);
        rowList = ソードGrid(rowList);
        div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowList);
    }

    private void 合計反映() {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        boolean 選択有无 = ViewStateHolder.get(ViewStateKeys.選択有无, Boolean.class);
        List<dgServiceRiyohyoBeppyoList_Row> rowList
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        dgServiceRiyohyoBeppyoList_Row row
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getClickedItem();
        if (!選択有无) {
            row = new dgServiceRiyohyoBeppyoList_Row();
            row.setRowState(RowState.Added);
            setRowInButtonKakutei(row);
            rowList.add(row);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowList);
        } else {
            選択データありの場合(row, 状態);
            setRowInButtonKakutei(row);
        }
        List<dgServiceRiyohyoBeppyoList_Row> rowListNew
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        rowListNew = ソードGrid(rowListNew);
        div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowListNew);
    }

    private void setRowInButtonKakutei(dgServiceRiyohyoBeppyoList_Row row) {
        RString サービス種類コードTmp;
        RString サービス項目コードTmp;
        RString サービスTmp;
        if (!div.getCcdServiceCodeInput().isDisplayNone()) {
            サービス種類コードTmp = div.getCcdServiceCodeInput().getサービスコード1();
            サービス項目コードTmp = div.getCcdServiceCodeInput().getサービスコード2();
            サービスTmp = div.getCcdServiceCodeInput().getサービス名称();
        } else {
            サービス種類コードTmp = div.getCcdServiceTypeInput().getサービス種類コード();
            サービス項目コードTmp = RSTRING_ZERO;
            サービスTmp = div.getCcdServiceTypeInput().getサービス種類名称();
        }
        row.setJigyosha(div.getCcdJigyoshaInput().getNyuryokuShisetsuMeisho());
        row.setService(サービスTmp);
        row.setTani(div.getServiceRiyohyoBeppyoMeisai().getTxtTani().getValue() == null ? null
                : new RString(div.getServiceRiyohyoBeppyoMeisai().getTxtTani().getValue().toString()));
        row.setWaribikigoRitsu(div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().getValue() == null ? null
                : new RString(div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().getValue().toString()));
        row.setWaribikigoTani(div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().getValue() == null ? null
                : new RString(div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().getValue().toString()));
        row.setKaisu(div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().getValue() == null ? null
                : new RString(div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().getValue().toString()));
        row.getServiceTani().setValue(div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().getValue());
        if ((RString.isNullOrEmpty(row.getTani()) || Decimal.ZERO.equals(new Decimal(row.getTani().toString())))
                && !Decimal.ZERO.equals(row.getServiceTani().getValue())) {
            row.setCellBgColor(SERVICETANI.toString(), DataGridCellBgColor.bgColorLightBlue);
        }
        row.getShuruiGendoChokaTani().setValue(div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().getValue());
        row.getShuruiGendonaiTani().setValue(div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().getValue());
        row.setTanisuTanka(div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().getValue() == null ? null
                : new RString(div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().getValue().toString()));
        row.getKubunGendoChokaTani().setValue(div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().getValue());
        row.getKubunGendonaiTani().setValue(div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().getValue());
        row.setKyufuritsu(div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().getValue() == null ? null
                : new RString(div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().getValue().toString()));
        row.getHiyoSogaku().setValue(div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().getValue());
        row.getHokenKyufugaku().setValue(div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().getValue());
        row.getRiyoshaFutangakuHoken().setValue(div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().getValue());
        row.getRiyoshaFutangakuZengaku().setValue(div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().getValue());
        row.setHdnJigyoshaCode(div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo());
        row.setHdnServiceShuruiCode(サービス種類コードTmp);
        row.setHdnGendogakuTaishogaiFlag(div.getServiceRiyohyoBeppyoMeisai().getTxtHdnGendogakuTaishogaiFlg().getValue());
        row.setHdnRiyoshaFutanTeiritsuTeigakuKbn(
                div.getServiceRiyohyoBeppyoMeisai().getTxtHdnRiyoshaFutanTeiritsuTeigakuKbn().getValue());
        row.setHdnServiceKomokuCode(サービス項目コードTmp);
        row.setHdnGokeiFlag(合計有り);
        row.setHdnGokeiGyoFlag(RSTRING_ZERO);
    }

    private List<KyufuJikoSakuseiResult> rowListToResult(List<dgServiceRiyohyoBeppyoList_Row> rowList) {
        List<KyufuJikoSakuseiResult> resultlist = new ArrayList();
        for (dgServiceRiyohyoBeppyoList_Row row : rowList) {
            KyufuJikoSakuseiResult result = new KyufuJikoSakuseiResult();
            result.set事業者(row.getJigyosha());
            result.setサービス(row.getService());
            result.set単位(row.getTani());
            result.set割引適用後率(row.getWaribikigoRitsu());
            result.set割引適用後単位(row.getWaribikigoTani());
            result.set回数(row.getKaisu());
            result.setサービス単位(row.getServiceTani().getValue());
            result.set種類限度超過単位(row.getShuruiGendoChokaTani().getValue());
            result.set種類限度内単位(row.getShuruiGendonaiTani().getValue());
            result.set区分限度超過単位(row.getKubunGendoChokaTani().getValue());
            result.set区分限度内単位(row.getKubunGendonaiTani().getValue());
            result.set単位数単価(row.getTanisuTanka());
            result.set費用総額(row.getHiyoSogaku().getValue());
            result.set給付率(row.getKyufuritsu());
            result.set保険給付額(row.getHokenKyufugaku().getValue());
            result.set定額利用者負担単価金額(row.getRiyoshaFutangakuTeigaku().getValue());
            result.set保険対象利用者負担額(row.getRiyoshaFutangakuHoken().getValue());
            result.set全額利用者負担額(row.getRiyoshaFutangakuZengaku().getValue());
            result.set事業者コード(row.getHdnJigyoshaCode() == null ? null
                    : new JigyoshaNo(row.getHdnJigyoshaCode()));
            result.setサービス種類コード(row.getHdnServiceShuruiCode() == null ? null
                    : new ServiceShuruiCode(row.getHdnServiceShuruiCode()));
            result.set限度額対象外フラグ(row.getHdnGendogakuTaishogaiFlag());
            result.set利用者負担定率定額区分(row.getHdnRiyoshaFutanTeiritsuTeigakuKbn());
            result.setサービス項目コード(row.getHdnServiceKomokuCode() == null ? null
                    : new ServiceKomokuCode(row.getHdnServiceKomokuCode()));
            if (合計有り.equals(row.getHdnGokeiFlag())) {
                result.set合計フラグ(true);
            } else {
                result.set合計フラグ(false);
            }
            resultlist.add(result);
        }
        return resultlist;
    }

    /**
     * 合計確定のイベントです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 利用年月 FlexibleYearMonth
     */
    public void onClick_btnKakutei(HihokenshaNo 被保険者番号, FlexibleYearMonth 利用年月) {
        JigoSakuseiMeisaiTouroku jigoSakusei = JigoSakuseiMeisaiTouroku.createInstance();
        RiyoshaFutanWariaiMeisai 合計情報 = jigoSakusei.get給付率(被保険者番号, 利用年月);
        Decimal 給付率 = 給付率_90;
        if (合計情報 != null) {
            if (負担割合区分_1割.equals(合計情報.get負担割合区分())) {
                給付率 = 給付率_100.subtract(一割);
            } else if (負担割合区分_2割.equals(合計情報.get負担割合区分())) {
                給付率 = 給付率_100.subtract(二割);
            }
        }
        ViewStateHolder.put(ViewStateKeys.給付率, new HokenKyufuRitsu(給付率));
        div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setValue(給付率);

        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisplayNone(true);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
        div.getServiceRiyohyoBeppyoGokei().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoGokei().setDisabled(false);
    }

    /**
     * 「修正」ボタンの場合、データに反映します。
     */
    public void init修正() {
        dgServiceRiyohyoBeppyoList_Row row = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.給付率, new HokenKyufuRitsu(RString.isNullOrEmpty(row.getKyufuritsu())
                ? Decimal.ZERO : new Decimal(row.getKyufuritsu().toString())));
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoGokeiNew().setDisabled(false);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setNyuryokuShisetsuKodo(row.getHdnJigyoshaCode());

        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setサービス種類コード(row.getHdnServiceShuruiCode());
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setサービス項目コード(row.getHdnServiceKomokuCode());
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().initialize(row.getHdnServiceShuruiCode());

        div.getServiceRiyohyoBeppyoMeisai().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setVisible(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei().setVisible(true);
        div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setValue(RString.isNullOrEmpty(row.getTani())
                ? null : new Decimal(row.getTani().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setValue(RString.isNullOrEmpty(row.getWaribikigoRitsu())
                ? null : new Decimal(row.getWaribikigoRitsu().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setValue(RString.isNullOrEmpty(row.getWaribikigoTani())
                ? null : new Decimal(row.getWaribikigoTani().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setValue(RString.isNullOrEmpty(row.getKaisu())
                ? null : new Decimal(row.getKaisu().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(row.getServiceTani().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setValue(null);
        div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setValue(row.getRiyoshaFutangakuTeigaku().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getTxtHdnGendogakuTaishogaiFlg().setValue(row.getHdnGendogakuTaishogaiFlag());
        div.getServiceRiyohyoBeppyoMeisai().getTxtHdnRiyoshaFutanTeiritsuTeigakuKbn()
                .setValue(row.getHdnRiyoshaFutanTeiritsuTeigakuKbn());
        if (合計有り.equals(row.getHdnGokeiFlag())) {
            div.getServiceRiyohyoBeppyoGokei().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().setValue(row.getShuruiGendoChokaTani().getValue());
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().setValue(row.getShuruiGendonaiTani().getValue());
            div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().setValue(RString.isNullOrEmpty(row.getTanisuTanka())
                    ? null : new Decimal(row.getTanisuTanka().toString()));
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setValue(row.getKubunGendoChokaTani().getValue());
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setValue(row.getKubunGendonaiTani().getValue());
            div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setValue(RString.isNullOrEmpty(row.getKyufuritsu())
                    ? null : new Decimal(row.getKyufuritsu().toString()));
            div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().setValue(row.getHiyoSogaku().getValue());
            div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setValue(row.getHokenKyufugaku().getValue());
            div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setValue(row.getRiyoshaFutangakuHoken().getValue());
            div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().setValue(row.getRiyoshaFutangakuZengaku().getValue());

            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCalcGokei().setDisabled(false);
        }
        row.setRowState(RowState.Modified);
    }

    /**
     * 「削除」ボタンの場合、データに反映します。
     */
    public void init削除() {
        dgServiceRiyohyoBeppyoList_Row row = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getClickedItem();
        row.setRowState(RowState.Deleted);

        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setNyuryokuShisetsuKodo(row.getHdnJigyoshaCode());

        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setサービス種類コード(row.getHdnServiceShuruiCode());
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setサービス項目コード(row.getHdnServiceKomokuCode());
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().initialize(row.getHdnServiceShuruiCode());

        div.getServiceRiyohyoBeppyoMeisai().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setValue(RString.isNullOrEmpty(row.getTani())
                ? null : new Decimal(row.getTani().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setValue(RString.isNullOrEmpty(row.getWaribikigoRitsu())
                ? null : new Decimal(row.getWaribikigoRitsu().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setValue(RString.isNullOrEmpty(row.getWaribikigoTani())
                ? null : new Decimal(row.getWaribikigoTani().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setValue(RString.isNullOrEmpty(row.getKaisu())
                ? null : new Decimal(row.getKaisu().toString()));
        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(row.getServiceTani().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setValue(row.getRiyoshaFutangakuTeigaku().getValue());

        div.getServiceRiyohyoBeppyoGokei().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().setValue(row.getShuruiGendoChokaTani().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().setValue(row.getShuruiGendonaiTani().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().setValue(RString.isNullOrEmpty(row.getTanisuTanka())
                ? null : new Decimal(row.getTanisuTanka().toString()));
        div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setValue(row.getKubunGendoChokaTani().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setValue(row.getKubunGendonaiTani().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setValue(RString.isNullOrEmpty(row.getKyufuritsu())
                ? null : new Decimal(row.getKyufuritsu().toString()));
        div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().setValue(row.getHiyoSogaku().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setValue(row.getHokenKyufugaku().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setValue(row.getRiyoshaFutangakuHoken().getValue());
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().setValue(row.getRiyoshaFutangakuZengaku().getValue());
    }

    /**
     * 「入力を取り消す」ボタン。
     */
    public void 入力を取り消す() {
        事業者サービスクリア();
        明細情報クリア();
        合計情報クリア();
        非活性または活性(false);
        RString 表示モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisplayNone(true);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCalcGokei().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei().setDisabled(true);
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoMeisaiNew().setDisabled(false);
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoGokeiNew().setDisabled(false);
        div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCancelMeisaiInput().setVisible(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisaiGokei().setVisible(true);

        if (追加.equals(表示モード)) {
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setReadOnly(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(false);
            div.getBtnKakutei().setDisabled(false);
        } else if (修正.equals(表示モード)) {
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setReadOnly(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setDisabled(false);
            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(false);
            div.getBtnKakutei().setDisabled(false);
        } else if (削除.equals(表示モード)) {
            非活性または活性(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput().setDisabled(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoFooter().getBtnBackRiyoNengetsuIchiran().setDisabled(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(false);
            div.getBtnKakutei().setDisabled(true);
        } else if (照会.equals(表示モード)) {
            非活性または活性(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCancelMeisaiInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisaiGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(true);
            div.getBtnKakutei().setDisabled(true);
        }
    }

    /**
     * 事業者・サービスをクリアする。
     */
    public void 事業者サービスクリア() {
        div.getCcdJigyoshaInput().setNyuryokuShisetsuKodo(RString.EMPTY);
        div.getCcdJigyoshaInput().setShisetsuMeisho(RString.EMPTY);
        div.getCcdServiceCodeInput().clear();
        div.getCcdServiceTypeInput().clear();
    }

    /**
     * 明細情報をクリアする。
     */
    public void 明細情報クリア() {
        div.getServiceRiyohyoBeppyoMeisai().getTxtTani().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().clearValue();
        div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().clearValue();
    }

    /**
     * 合計情報をクリアする。
     */
    public void 合計情報クリア() {
        div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().clearValue();
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().clearValue();
    }

    /**
     * 削除処理メソッドです。
     *
     * @param 居宅総合事業区分 RString
     * @param 短期入所情報 TankiNyushoResult
     */
    public void DB削除処理(RString 居宅総合事業区分, TankiNyushoResult 短期入所情報) {
        if (総合事業.equals(居宅総合事業区分)) {
            if (短期入所情報 == null || !居宅予防区分_1.equals(短期入所情報.get居宅予防区分())) {
                return;
            }
            YoboKeikakuJikoSakuseiTankiRiyoNissuManager yoboManager = InstanceProvider
                    .create(YoboKeikakuJikoSakuseiTankiRiyoNissuManager.class);
            if (div.getTxtSofuYM().getValue() == null
                    && KyufukanrihyoSakuseiKubun.新規.getコード().equals(div.getDdlKoshinKbn().getSelectedKey())) {
                yoboManager.delete予防短期入所情報(短期入所情報.get予防短期入所情報());
            } else {
                YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder builder = 短期入所情報.get予防短期入所情報().createBuilderForEdit();
                builder.set前回迄利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().getValue())
                        .set今回計画利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().getValue())
                        .set暫定区分(div.getChkZanteiKubun().isAllSelected() ? 暫定区分_1 : 暫定区分_0)
                        .set更新区分(div.getDdlKoshinKbn().getSelectedKey())
                        .set更新年月日(div.getTxtKoshinYMD().getValue() == null ? null
                                : new FlexibleDate(div.getTxtKoshinYMD().getValue().toDateString()))
                        .set送付年月(FlexibleYearMonth.EMPTY);
                yoboManager.update予防短期入所情報(builder.build());
            }
        } else if (居宅.equals(居宅総合事業区分)) {
            if (短期入所情報 == null || !居宅予防区分_0.equals(短期入所情報.get居宅予防区分())) {
                return;
            }
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager kyoManager = InstanceProvider
                    .create(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager.class);
            if (div.getTxtSofuYM().getValue() == null
                    && KyufukanrihyoSakuseiKubun.新規.getコード().equals(div.getDdlKoshinKbn().getSelectedKey())) {
                kyoManager.delete居宅短期入所情報(短期入所情報.get居宅短期入所情報());
            } else {
                KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder builder = 短期入所情報.get居宅短期入所情報().createBuilderForEdit();
                builder.set前回迄利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().getValue())
                        .set今回計画利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().getValue())
                        .set暫定区分(div.getChkZanteiKubun().isAllSelected() ? 暫定区分_1 : 暫定区分_0)
                        .set更新区分(div.getDdlKoshinKbn().getSelectedKey())
                        .set更新年月日(div.getTxtKoshinYMD().getValue() == null ? null
                                : new FlexibleDate(div.getTxtKoshinYMD().getValue().toDateString()))
                        .set送付年月(FlexibleYearMonth.EMPTY);
                kyoManager.update居宅短期入所情報(builder.build());
            }
        }
    }

    /**
     * DB追加処理メソッドです。
     *
     * @param 居宅総合事業区分 RString
     * @param 短期入所情報 TankiNyushoResult
     */
    public void DB追加処理(RString 居宅総合事業区分, TankiNyushoResult 短期入所情報) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth 対象年月 = ViewStateHolder.get(ViewStateKeys.対象年月, FlexibleYearMonth.class);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        if (居宅.equals(居宅総合事業区分)) {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager manager
                    = InstanceProvider.create(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager.class);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅短期入所情報
                    = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(
                            被保険者番号,
                            対象年月,
                            履歴番号,
                            new FlexibleYearMonth(div.getTxtRiyoYM().getValue().getYearMonth().toDateString()));
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder builder = 居宅短期入所情報.createBuilderForEdit();
            builder.set前回迄利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().getValue())
                    .set今回計画利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().getValue())
                    .set暫定区分(div.getChkZanteiKubun().isAllSelected() ? 暫定区分_1 : 暫定区分_0)
                    .set更新区分(div.getDdlKoshinKbn().getSelectedKey())
                    .set更新年月日(div.getTxtKoshinYMD().getValue() == null ? null
                            : new FlexibleDate(div.getTxtKoshinYMD().getValue().toDateString()))
                    .set送付年月(FlexibleYearMonth.EMPTY);
            manager.insert居宅短期入所情報(builder.build());
        } else if (総合事業.equals(居宅総合事業区分)) {
            YoboKeikakuJikoSakuseiTankiRiyoNissuManager manager
                    = InstanceProvider.create(YoboKeikakuJikoSakuseiTankiRiyoNissuManager.class);
            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防短期入所情報
                    = new YoboKeikakuJikoSakuseiTankiRiyoNissu(
                            被保険者番号,
                            対象年月,
                            履歴番号,
                            new FlexibleYearMonth(div.getTxtRiyoYM().getValue().getYearMonth().toDateString()));
            YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder builder = 予防短期入所情報.createBuilderForEdit();
            builder.set前回迄利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().getValue())
                    .set今回計画利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().getValue())
                    .set暫定区分(div.getChkZanteiKubun().isAllSelected() ? 暫定区分_1 : 暫定区分_0)
                    .set更新区分(div.getDdlKoshinKbn().getSelectedKey())
                    .set更新年月日(div.getTxtKoshinYMD().getValue() == null ? null
                            : new FlexibleDate(div.getTxtKoshinYMD().getValue().toDateString()))
                    .set送付年月(FlexibleYearMonth.EMPTY);
            manager.insert予防短期入所情報(builder.build());
        }
    }

    /**
     * DB修正処理メソッドです。
     *
     * @param 居宅総合事業区分 RString
     * @param 短期入所情報 TankiNyushoResult
     */
    public void DB修正処理(RString 居宅総合事業区分, TankiNyushoResult 短期入所情報) {
        if (居宅.equals(居宅総合事業区分) && 居宅予防区分_0.equals(短期入所情報.get居宅予防区分())) {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager manager
                    = InstanceProvider.create(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager.class);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅短期入所情報 = 短期入所情報.get居宅短期入所情報();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder builder = 居宅短期入所情報.createBuilderForEdit();
            builder.set前回迄利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().getValue())
                    .set今回計画利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().getValue())
                    .set暫定区分(div.getChkZanteiKubun().isAllSelected() ? 暫定区分_1 : 暫定区分_0)
                    .set更新区分(div.getDdlKoshinKbn().getSelectedKey())
                    .set更新年月日(div.getTxtKoshinYMD().getValue() == null ? null
                            : new FlexibleDate(div.getTxtKoshinYMD().getValue().toDateString()))
                    .set送付年月(FlexibleYearMonth.EMPTY);
            manager.update居宅短期入所情報(builder.build());
        } else if (総合事業.equals(居宅総合事業区分) && 居宅予防区分_1.equals(短期入所情報.get居宅予防区分())) {
            YoboKeikakuJikoSakuseiTankiRiyoNissuManager manager
                    = InstanceProvider.create(YoboKeikakuJikoSakuseiTankiRiyoNissuManager.class);
            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防短期入所情報 = 短期入所情報.get予防短期入所情報();
            YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder builder = 予防短期入所情報.createBuilderForEdit();
            builder.set前回迄利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtZengetsuRiyoNissu().getValue())
                    .set今回計画利用日数(div.getServiceRiyohyoBeppyoRiyoNissu().getTxtTogetsuRiyoNissu().getValue())
                    .set暫定区分(div.getChkZanteiKubun().isAllSelected() ? 暫定区分_1 : 暫定区分_0)
                    .set更新区分(div.getDdlKoshinKbn().getSelectedKey())
                    .set更新年月日(div.getTxtKoshinYMD().getValue() == null ? null
                            : new FlexibleDate(div.getTxtKoshinYMD().getValue().toDateString()))
                    .set送付年月(FlexibleYearMonth.EMPTY);
            manager.update予防短期入所情報(builder.build());
        }
    }

    /**
     * 保存処理メソッドです。
     *
     * @param 居宅総合事業区分 RString
     * @param サービス利用票情報 List<KyufuJikoSakuseiResult>
     */
    public void init保存処理(RString 居宅総合事業区分, List<KyufuJikoSakuseiResult> サービス利用票情報) {
        // TODO QAのNo.1234 業務概念を取得できないので、DB保存処理できない。
        List<dgServiceRiyohyoBeppyoList_Row> rowList = div.getServiceRiyohyoBeppyoList()
                .getDgServiceRiyohyoBeppyoList().getDataSource();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth 対象年月 = ViewStateHolder.get(ViewStateKeys.対象年月, FlexibleYearMonth.class);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        FlexibleYearMonth 利用年月 = ViewStateHolder.get(ViewStateKeys.利用年月, FlexibleYearMonth.class);
        RDate 利用年月日 = div.getTxtRiyoYM().getValue();
        FlexibleYearMonth 画面の利用年月 = new FlexibleYearMonth(利用年月日.getYearMonth().toDateString());
        JigoSakuseiMeisaiTouroku jigoSakusei = JigoSakuseiMeisaiTouroku.createInstance();
        for (dgServiceRiyohyoBeppyoList_Row row : rowList) {
            if (総合事業.equals(居宅総合事業区分)) {
                if (RowState.Added.equals(row.getRowState())) {
                    CountedItem saiban = Saiban.get(SubGyomuCode.DBC介護給付, 汎用キー_明細番号, FlexibleDate.getNowDate().getNendo());
                    YoboKeikakuJikoSakuseiKanri 予防給付計画自己作成管理 = new YoboKeikakuJikoSakuseiKanri(被保険者番号,
                            対象年月, 履歴番号, 画面の利用年月, 固定値_3, Integer.parseInt(saiban.nextString().trim().toString()));
                    YoboKeikakuJikoSakuseiKanriBuilder builder = 予防給付計画自己作成管理.createBuilderForEdit();
                    builder.setサービス提供事業者番号(new JigyoshaNo(row.getHdnJigyoshaCode()))
                            .setサービス種類コード(new ServiceShuruiCode(row.getHdnServiceShuruiCode()))
                            .setサービス項目コード(RSTRING_ZERO.equals(row.getHdnServiceKomokuCode())
                                    ? ServiceKomokuCode.EMPTY : new ServiceKomokuCode(row.getHdnServiceKomokuCode()))
                            .set単位数(RString.isNullOrEmpty(row.getTani()) ? null : new Decimal(row.getTani().toString()))
                            .set回数_日数(RString.isNullOrEmpty(row.getKaisu()) ? null : new Decimal(row.getKaisu().toString()))
                            .set割引後適用率(RString.isNullOrEmpty(row.getWaribikigoRitsu()) ? null
                                    : new HokenKyufuRitsu(new Decimal(row.getWaribikigoRitsu().toString())))
                            .set割引後適用単位数(RString.isNullOrEmpty(row.getWaribikigoTani())
                                    ? null : new Decimal(row.getWaribikigoTani().toString()))
                            .set定額利用者負担単価金額(row.getRiyoshaFutangakuTeigaku().getValue())
                            .set合計明細フラグ(合計有り.equals(row.getHdnGokeiFlag()))
                            .set種類限度内単位数_日数(row.getShuruiGendonaiTani().getValue())
                            .set種類限度超過単位数_日数(row.getShuruiGendoChokaTani().getValue())
                            .set区分限度内単位数_日数(row.getKubunGendonaiTani().getValue())
                            .set区分限度超過単位数_日数(row.getKubunGendoChokaTani().getValue())
                            .set単位数単価(RString.isNullOrEmpty(row.getTanisuTanka())
                                    ? null : new Decimal(row.getTanisuTanka().toString()))
                            .set給付率(RString.isNullOrEmpty(row.getKyufuritsu())
                                    ? null : new HokenKyufuRitsu(new Decimal(row.getKyufuritsu().toString())))
                            .set給付計画単位数(row.getServiceTani().getValue());
                    jigoSakusei.save予防給付計画自己作成管理(builder.build());
                } else if (RowState.Modified.equals(row.getRowState())) {
                    YoboKeikakuJikoSakuseiKanri 予防給付計画自己作成管理 = jigoSakusei.select予防給付計画自己作成管理ByKey(
                            被保険者番号, 対象年月, 履歴番号, 利用年月, 固定値_3, Integer.parseInt(row.getHdnMeisaiNo().toString()));
                    YoboKeikakuJikoSakuseiKanriBuilder builder = 予防給付計画自己作成管理.createBuilderForEdit();
                    builder.setサービス提供事業者番号(new JigyoshaNo(row.getHdnJigyoshaCode()))
                            .setサービス種類コード(new ServiceShuruiCode(row.getHdnServiceShuruiCode()))
                            .setサービス項目コード(RSTRING_ZERO.equals(row.getHdnServiceKomokuCode())
                                    ? ServiceKomokuCode.EMPTY : new ServiceKomokuCode(row.getHdnServiceKomokuCode()))
                            .set単位数(RString.isNullOrEmpty(row.getTani()) ? null : new Decimal(row.getTani().toString()))
                            .set回数_日数(RString.isNullOrEmpty(row.getKaisu()) ? null : new Decimal(row.getKaisu().toString()))
                            .set割引後適用率(RString.isNullOrEmpty(row.getWaribikigoRitsu()) ? null
                                    : new HokenKyufuRitsu(new Decimal(row.getWaribikigoRitsu().toString())))
                            .set割引後適用単位数(RString.isNullOrEmpty(row.getWaribikigoTani())
                                    ? null : new Decimal(row.getWaribikigoTani().toString()))
                            .set定額利用者負担単価金額(row.getRiyoshaFutangakuTeigaku().getValue())
                            .set合計明細フラグ(合計有り.equals(row.getHdnGokeiFlag()))
                            .set種類限度内単位数_日数(row.getShuruiGendonaiTani().getValue())
                            .set種類限度超過単位数_日数(row.getShuruiGendoChokaTani().getValue())
                            .set区分限度内単位数_日数(row.getKubunGendonaiTani().getValue())
                            .set区分限度超過単位数_日数(row.getKubunGendoChokaTani().getValue())
                            .set単位数単価(RString.isNullOrEmpty(row.getTanisuTanka())
                                    ? null : new Decimal(row.getTanisuTanka().toString()))
                            .set給付率(RString.isNullOrEmpty(row.getKyufuritsu())
                                    ? null : new HokenKyufuRitsu(new Decimal(row.getKyufuritsu().toString())))
                            .set給付計画単位数(row.getServiceTani().getValue());
                    jigoSakusei.update予防給付計画自己作成管理(builder.build());
                } else if (RowState.Deleted.equals(row.getRowState())) {
                    YoboKeikakuJikoSakuseiKanri 予防給付計画自己作成管理 = jigoSakusei.select予防給付計画自己作成管理ByKey(
                            被保険者番号, 対象年月, 履歴番号, 利用年月, 固定値_3, Integer.parseInt(row.getHdnMeisaiNo().toString()));
                    jigoSakusei.delete予防給付計画自己作成管理(予防給付計画自己作成管理);
                }
            } else if (居宅.equals(居宅総合事業区分)) {
                if (RowState.Added.equals(row.getRowState())) {
                    CountedItem saiban = Saiban.get(SubGyomuCode.DBC介護給付, 汎用キー_明細番号, FlexibleDate.getNowDate().getNendo());
                    KyotakuKeikakuJikosakuseiKanri 居宅給付計画自己作成管理 = new KyotakuKeikakuJikosakuseiKanri(被保険者番号,
                            対象年月, 履歴番号, 画面の利用年月, 固定値_3, Integer.parseInt(saiban.nextString().trim().toString()));
                    KyotakuKeikakuJikosakuseiKanriBuilder builder = 居宅給付計画自己作成管理.createBuilderForEdit();
                    builder.setサービス提供事業者番号(new JigyoshaNo(row.getHdnJigyoshaCode()))
                            .setサービス種類コード(new ServiceShuruiCode(row.getHdnServiceShuruiCode()))
                            .setサービス項目コード(RSTRING_ZERO.equals(row.getHdnServiceKomokuCode())
                                    ? ServiceKomokuCode.EMPTY : new ServiceKomokuCode(row.getHdnServiceKomokuCode()))
                            .set単位数(RString.isNullOrEmpty(row.getTani()) ? null : new Decimal(row.getTani().toString()))
                            .set回数_日数(RString.isNullOrEmpty(row.getKaisu()) ? null : new Decimal(row.getKaisu().toString()))
                            .set割引後適用率(RString.isNullOrEmpty(row.getWaribikigoRitsu()) ? null
                                    : new HokenKyufuRitsu(new Decimal(row.getWaribikigoRitsu().toString())))
                            .set割引後適用単位数((RString.isNullOrEmpty(row.getWaribikigoTani())
                                    ? null : new Decimal(row.getWaribikigoTani().toString())))
                            .set合計明細フラグ(合計有り.equals(row.getHdnGokeiFlag()))
                            .set種類限度内単位数_日数(row.getShuruiGendonaiTani().getValue())
                            .set種類限度超過単位数_日数(row.getShuruiGendoChokaTani().getValue())
                            .set区分限度内単位数_日数(row.getKubunGendonaiTani().getValue())
                            .set区分限度超過単位数_日数(row.getKubunGendoChokaTani().getValue())
                            .set単位数単価(RString.isNullOrEmpty(row.getTanisuTanka())
                                    ? null : new Decimal(row.getTanisuTanka().toString()))
                            .set給付率(RString.isNullOrEmpty(row.getKyufuritsu())
                                    ? null : new HokenKyufuRitsu(new Decimal(row.getKyufuritsu().toString())))
                            .set給付計画単位数(row.getServiceTani().getValue());
                    jigoSakusei.save居宅給付計画自己作成管理(builder.build());
                } else if (RowState.Modified.equals(row.getRowState())) {
                    KyotakuKeikakuJikosakuseiKanri 居宅給付計画自己作成管理 = jigoSakusei.select居宅給付計画自己作成管理ByKey(
                            被保険者番号, 対象年月, 履歴番号, 利用年月, 固定値_3, Integer.parseInt(row.getHdnMeisaiNo().toString()));
                    KyotakuKeikakuJikosakuseiKanriBuilder builder = 居宅給付計画自己作成管理.createBuilderForEdit();
                    builder.setサービス提供事業者番号(new JigyoshaNo(row.getHdnJigyoshaCode()))
                            .setサービス種類コード(new ServiceShuruiCode(row.getHdnServiceShuruiCode()))
                            .setサービス項目コード(RSTRING_ZERO.equals(row.getHdnServiceKomokuCode())
                                    ? ServiceKomokuCode.EMPTY : new ServiceKomokuCode(row.getHdnServiceKomokuCode()))
                            .set単位数(RString.isNullOrEmpty(row.getTani()) ? null : new Decimal(row.getTani().toString()))
                            .set回数_日数(RString.isNullOrEmpty(row.getKaisu()) ? null : new Decimal(row.getKaisu().toString()))
                            .set割引後適用率(RString.isNullOrEmpty(row.getWaribikigoRitsu()) ? null
                                    : new HokenKyufuRitsu(new Decimal(row.getWaribikigoRitsu().toString())))
                            .set割引後適用単位数(RString.isNullOrEmpty(row.getWaribikigoTani())
                                    ? null : new Decimal(row.getWaribikigoTani().toString()))
                            .set合計明細フラグ(合計有り.equals(row.getHdnGokeiFlag()))
                            .set種類限度内単位数_日数(row.getShuruiGendonaiTani().getValue())
                            .set種類限度超過単位数_日数(row.getShuruiGendoChokaTani().getValue())
                            .set区分限度内単位数_日数(row.getKubunGendonaiTani().getValue())
                            .set区分限度超過単位数_日数(row.getKubunGendoChokaTani().getValue())
                            .set単位数単価(RString.isNullOrEmpty(row.getTanisuTanka())
                                    ? null : new Decimal(row.getTanisuTanka().toString()))
                            .set給付率(RString.isNullOrEmpty(row.getKyufuritsu())
                                    ? null : new HokenKyufuRitsu(new Decimal(row.getKyufuritsu().toString())))
                            .set給付計画単位数(row.getServiceTani().getValue());
                    jigoSakusei.update予防給付計画自己作成管理(builder.build());
                } else if (RowState.Deleted.equals(row.getRowState())) {
                    KyotakuKeikakuJikosakuseiKanri 居宅給付計画自己作成管理 = jigoSakusei.select居宅給付計画自己作成管理ByKey(
                            被保険者番号, 対象年月, 履歴番号, 利用年月, 固定値_3, Integer.parseInt(row.getHdnMeisaiNo().toString()));
                    jigoSakusei.delete居宅給付計画自己作成管理(居宅給付計画自己作成管理);
                }
            }
        }
    }

    /**
     * データ整合性チェックします。
     *
     * @param サービス利用票情報 List<KyufuJikoSakuseiResult>
     */
    public void データ整合性チェック(List<KyufuJikoSakuseiResult> サービス利用票情報) {
        if (サービス利用票情報 == null || サービス利用票情報.isEmpty()) {
            return;
        }
        Decimal サービス単位合計 = Decimal.ZERO;
        for (int index = 0; index < サービス利用票情報.size(); index++) {
            KyufuJikoSakuseiResult result = サービス利用票情報.get(index);
            if (result.is合計フラグ()) {
                if (サービス単位合計.equals(result.getサービス単位() == null ? Decimal.ZERO : result.getサービス単位())) {
                    サービス単位合計 = Decimal.ZERO;
                } else {
                    throw new ApplicationException(DbcErrorMessages.サービス単位不正.getMessage().evaluate());
                }
                限度チェック(result, index);
            }
            if (!限度額対象外フラグ_1.equals(result.get限度額対象外フラグ())) {
                サービス単位合計 = サービス単位合計.add(nullToZero(result.getサービス単位()));
            }
        }
    }

    private void 限度チェック(KyufuJikoSakuseiResult result, int index) {
        Decimal 区分限度 = nullToZero(result.get区分限度超過単位()).add(nullToZero(result.get区分限度内単位()));
        Decimal 種類限度 = nullToZero(result.get種類限度超過単位()).add(nullToZero(result.get種類限度内単位()));
        if (区分限度.compareTo(Decimal.ZERO) <= 0) {
            return;
        }
        if (Decimal.ZERO.compareTo(種類限度) < 0) {
            if (!区分限度.equals(result.get種類限度内単位())) {
                throw new ApplicationException(DbcErrorMessages.区分支給限度額不正.getMessage()
                        .replace(String.valueOf(index + INT_1)).evaluate());
            }
        } else {
            if (!区分限度.equals(result.getサービス単位())) {
                throw new ApplicationException(DbcErrorMessages.区分支給限度額不正.getMessage()
                        .replace(String.valueOf(index + INT_1)).evaluate());
            }
        }
    }

    private boolean isFlexibleYearMonthNullOrEmpty(FlexibleYearMonth data) {
        return data == null || data.isEmpty();
    }

    /**
     * サービス利用票情報取得メソッドです。
     *
     * @return List<KyufuJikoSakuseiResult>
     */
    public List<KyufuJikoSakuseiResult> getサービス利用票情報() {
        List<dgServiceRiyohyoBeppyoList_Row> rowList
                = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        return rowListToResult(rowList);
    }

    private Decimal サービス単位計算() {
        Decimal サービス単位合計 = Decimal.ZERO;
        RString 事業者 = div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo();
        RString サービス種類コード = div.getCcdServiceCodeInput().getサービスコード1();
        for (dgServiceRiyohyoBeppyoList_Row row : div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource()) {
            if (row.getHdnJigyoshaCode() != null && row.getHdnJigyoshaCode().equals(事業者)
                    && row.getHdnServiceShuruiCode() != null && row.getHdnServiceShuruiCode().equals(サービス種類コード)) {
                サービス単位合計 = サービス単位合計.add(RString.isNullOrEmpty(row.getServiceTani().getText()) ? Decimal.ZERO
                        : row.getServiceTani().getValue());
            }
        }
        return サービス単位合計;
    }
}
