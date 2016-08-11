/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KubunGendo;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiNyushoResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku.JigoSakuseiMeisaiTouroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * サービス利用票情報DivのHandlerクラスです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoInfoDivHandler {

    private final ServiceRiyohyoInfoDiv div;
    private static final RString 居宅 = new RString("1");
    private static final RString 総合事業 = new RString("2");
    private static final RString 暫定区分 = new RString("1");
    private static final RString 定値_01 = new RString("01");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 照会 = new RString("照会");
    private static final RString 台帳種別表示有り = new RString("台帳種別表示有り");
    private static final RString 定額利用者負担 = new RString("riyoshaFutangakuTeigaku");

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
        set初期化状態(表示モード);
        if (利用年月 != null && !利用年月.isEmpty()) {
            RStringBuilder rst = new RStringBuilder();
            rst.append(利用年月).append(定値_01);
            div.getTxtRiyoYM().setValue(new RDate(rst.toString()));
            set区分支給限度額(被保険者番号, 居宅総合事業区分, 利用年月);
            set暫定区分制御(被保険者番号, 対象年月, 履歴番号, 利用年月);
            setサービス利用票(被保険者番号, 対象年月, 履歴番号, 利用年月);
        } else {
            div.getTxtRiyoYM().setDisabled(false);
            div.getBtnUpdate().setDisabled(true);
        }
        if (居宅.equals(居宅総合事業区分)) {
            div.getChkZanteiKubun().setVisible(true);
        } else if (総合事業.equals(居宅総合事業区分)) {
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting()
                    .getColumn(定額利用者負担).setVisible(false);
            div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setVisible(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setVisible(true);
        }
    }

    private void set初期化状態(RString 表示モード) {
        div.getTxtTodokedeYMD().setDisabled(true);
        div.getTxtTekiyoKikan().setDisabled(true);
        div.getTxtRiyoYM().setDisabled(true);
        div.getChkZanteiKubun().setDisabled(true);
        div.getTxtKubunShikyuGendogaku().setDisabled(true);
        div.getTxtGendoKanriKikan().setDisabled(true);
        div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setDisabled(true);
        div.getServiceRiyohyoBeppyoMeisai().getBtnBeppyoMeisaiKakutei().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtHiyoSogaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtHokenKyufugaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuHoken().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getTxtRiyoshaFutangakuZengaku().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getBtnCalcGokei().setDisabled(true);
        div.getServiceRiyohyoBeppyoGokei().getBtnBeppyoGokeiKakutei().setDisabled(true);
        if (追加.equals(表示モード)) {
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setVisible(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setVisible(false);
            div.getServiceRiyohyoBeppyoMeisai().setVisible(false);
            div.getServiceRiyohyoBeppyoGokei().setVisible(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(true);
        } else if (修正.equals(表示モード)) {
            div.getBtnZengetsuCopy().setDisabled(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setVisible(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setVisible(false);
            div.getServiceRiyohyoBeppyoMeisai().setVisible(false);
            div.getServiceRiyohyoBeppyoGokei().setVisible(false);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(true);
        } else if (削除.equals(表示モード)) {
            div.getDdlKoshinKbn().setDisabled(true);
            div.getTxtKoshinYMD().setDisabled(true);
            div.getBtnZengetsuCopy().setDisabled(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setVisible(false);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(true);
        } else if (照会.equals(表示モード)) {
            div.getDdlKoshinKbn().setDisabled(true);
            div.getTxtKoshinYMD().setDisabled(true);
            div.getBtnZengetsuCopy().setDisabled(true);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getBtnCalcMeisai().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getBtnCancelMeisaiInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoMeisai().getBtnCalcMeisaiGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendoChokaTani().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtShuruiGendonaiTani().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendoChokaTani().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().getBtnCancelGokeiInput().setDisabled(true);
            div.getServiceRiyohyoBeppyoGokei().setDisabled(true);
            div.getServiceRiyohyoBeppyoFooter().getBtnUpdate().setDisabled(true);
        }
    }

    private void set区分支給限度額(HihokenshaNo 被保険者番号, RString 居宅総合事業区分, FlexibleYearMonth 利用年月) {
        JigoSakuseiMeisaiTouroku jigoSakusei = JigoSakuseiMeisaiTouroku.createInstance();
        KubunGendo 区分支給限度額情報 = jigoSakusei.getKubunGendo(被保険者番号, 居宅総合事業区分, 利用年月);
        if (区分支給限度額情報 == null) {
            if (居宅.equals(居宅総合事業区分)) {
                List<RString> list = new ArrayList<>();
                list.add(暫定区分);
                div.getChkZanteiKubun().setDisabledItemsByKey(list);
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
            div.getBtnUpdate().setDisabled(true);
        }
    }

    private void set暫定区分制御(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 利用年月) {
        createDDLKoshinKbn();
        JigoSakuseiMeisaiTouroku jigoSakusei = JigoSakuseiMeisaiTouroku.createInstance();
        TankiNyushoResult 短期入所情報 = jigoSakusei.getTankiNyuryo(被保険者番号, 対象年月, 履歴番号, 利用年月);
        if (短期入所情報 != null) {
            RString 更新区分 = 短期入所情報.getEntity().get更新区分();
            if (更新区分 == null) {
                更新区分 = RString.EMPTY;
            }
            FlexibleYearMonth 送付年月 = 短期入所情報.getEntity().get送付年月();
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
        if (サービス利用票情報 == null || サービス利用票情報.isEmpty()) {
            div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowList);
            return;
        }
        for (KyufuJikoSakuseiResult result : サービス利用票情報) {
            dgServiceRiyohyoBeppyoList_Row row = new dgServiceRiyohyoBeppyoList_Row();
            row.setJigyosha(result.get事業者());
            row.setService(result.getサービス());
            row.getTani().setValue(result.get単位());
            row.getWaribikigoRitsu().setValue(result.get割引適用後率() == null ? null
                    : result.get割引適用後率().getColumnValue());
            row.getWaribikigoTani().setValue(result.get割引適用後単位());
            row.getKaisu().setValue(result.get回数());
            row.getServiceTani().setValue(result.getサービス単位());
            row.getShuruiGendoChokaTani().setValue(result.get種類限度超過単位());
            row.getShuruiGendonaiTani().setValue(result.get種類限度内単位());
            row.getKubunGendoChokaTani().setValue(result.get区分限度超過単位());
            row.getKubunGendonaiTani().setValue(result.get区分限度内単位());
            row.getTanisuTanka().setValue(result.get単位数単価());
            row.getHiyoSogaku().setValue(result.get費用総額());
            row.getKyufuritsu().setValue(result.get給付率() == null ? null : result.get給付率().getColumnValue());
            row.getHokenKyufugaku().setValue(result.get保険給付額());
            //TODO
            row.getRiyoshaFutangakuTeigaku().setValue(result.get定額利用者負担単価金額());
            row.getRiyoshaFutangakuHoken().setValue(result.get保険対象利用者負担額());
            row.getRiyoshaFutangakuZengaku().setValue(result.get全額利用者負担額());
            row.setHdnJigyoshaCode(result.get事業者コード() == null ? null : result.get事業者コード().getColumnValue());
            row.setHdnServiceShuruiCode(result.getサービス種類コード() == null ? null
                    : result.getサービス種類コード().getColumnValue());
            row.setHdnGendogakuTaishogaiFlag(result.get限度額対象外フラグ());
            row.setHdnServiceKomokuCode(result.getサービス項目コード() == null ? null
                    : result.getサービス項目コード().getColumnValue());
            rowList.add(row);
        }
        div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().setDataSource(rowList);
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
        if (前月までの利用日数 != null && 当月の計画利用日数 != null) {
            div.getServiceRiyohyoBeppyoRiyoNissu().getTxtRuikeiRiyoNissu().setValue(前月までの利用日数.add(当月の計画利用日数));
        }
    }

    /**
     * 事業者、明細と合計パネルにデータ反映する。
     */
    public void setパネルにデータ反映() {
        dgServiceRiyohyoBeppyoList_Row row = div.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getClickedItem();
        //TODO
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示有り);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().initialize();
        //TODO
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().initialize();
        if (row.getHdnServiceShuruiCode() != null) {
            div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().initialize(row.getHdnServiceShuruiCode());
        }

        div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setValue(row.getTani().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setValue(row.getWaribikigoRitsu().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setValue(row.getWaribikigoTani().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setValue(row.getKaisu().getValue());
        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setValue(row.getServiceTani().getValue());
        RString 居宅総合事業区分 = ViewStateHolder.get(ViewStateKeys.居宅総合事業区分, RString.class);
        if (総合事業.equals(居宅総合事業区分)) {
            div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setValue(row.getWaribikigoTani().getValue());
            div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setValue(row.getWaribikigoTani().getValue());
        }
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setValue(row.getWaribikigoTani().getValue());

    }
}
