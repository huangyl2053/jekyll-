/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820024;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.ServiceKeikakuHiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(サービス計画費)のハンドラクラスです。
 */
public class ServiceKeikakuHiPanelHandler {

    private final ServiceKeikakuHiPanelDiv div;
    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth サービス年月_200903 = new FlexibleYearMonth("200903");
    private static final FlexibleYearMonth サービス年月_200604 = new FlexibleYearMonth("200604");
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 登録モード = new RString("登録");
    private static final RString 削除モード = new RString("削除");
    private static final RString サービスコード1 = new RString("55");
    private static final int サービスコード2 = 4;
    private static final int 担当介護支援専門員番号LENGTH = 8;

    /**
     * ServiceKeikakuHiPanelHandlerコンストラクタです
     *
     * @param div ServiceKeikakuHiPanelDiv
     */
    public ServiceKeikakuHiPanelHandler(ServiceKeikakuHiPanelDiv div) {
        this.div = div;
    }

    /**
     * onLoad処理 サービス提供年月が平成２１年4月以降の場合
     *
     * @param entity200904List List<ShokanServicePlan200904Result>
     */
    public void onLoad200904(List<ShokanServicePlan200904Result> entity200904List) {
        setサービス計画費共通エリアLoad(entity200904List);
        setサービス計画費グリッドエリア(entity200904List);

    }

    /**
     * onLoad処理 サービス年月が200604～200903の場合
     *
     * @param entity200604 ShokanServicePlan200604Result
     */
    public void onLoad200604(ShokanServicePlan200604Result entity200604) {
        setサービス計画費エリア200604(entity200604);
    }

    /**
     * onLoad処理 サービス年月が200603以前の場合
     *
     * @param entity200004 ServiceKeikakuHiRealtEntity
     */
    public void onLoad20004(ShokanServicePlan200004Result entity200004) {
        setサービス計画費エリア200004(entity200004);
    }

    /**
     * 申請共通エリアの設定
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 申請日 RString
     * @param 事業者番号 JigyoshaNo
     * @param 明細番号 RString
     * @param 証明書 RString
     * @param 様式番号 RString
     */
    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            RString 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書,
            RString 様式番号) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisayiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    /**
     * ボタン制御
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri) {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        set基本情報ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set給付費明細ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定診療費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定入所者費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPanelHead().getBtnGokeiInfo().setDisabled(false);
        set給付費明細_住特ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時_所定疾患ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時施設療養費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set食事費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set請求額集計ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set社福軽減額ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 追加するボタン Handler処理
     */
    public void click追加() {
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(true);
        setサービス計画費共通エリア(null);
        clickクリア();
    }

    /**
     * グリッドの修正ボタン Handler処理
     *
     * @param row dgdYichiran_Row
     */
    public void click修正(dgdYichiran_Row row) {
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(true);
        setサービス計画費共通エリア(null);
        clickクリア();
        setサービス計画費共通エリア1(row);
        setサービス計画費登録エリア1(row);
    }

    /**
     * グリッドの削除ボタン Handler処理
     *
     * @param row dgdYichiran_Row
     */
    public void click削除(dgdYichiran_Row row) {
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(true);
        setサービス計画費共通エリア(null);
        clickクリア();
        setサービス計画費共通エリア1(row);
        setサービス計画費登録エリア1(row);
    }

    /**
     * グリッドの削除ボタン Handlerのsetです。
     */
    public void set削除() {
        div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setReadOnly(true);
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        serviceCodeInputDiv.getTxtServiceCode2().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getBtnClear().setDisabled(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getBtnKeisan().setDisabled(true);
    }

    /**
     * 「計算する」ボタン Handler処理
     */
    public void click計算Keisan() {
        Decimal data = null;
        Decimal 単位数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().getValue();
        Decimal 回数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().getValue();
        if (単位数 != null && 回数 != null) {
            data = 単位数.multiply(回数);
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().setValue(data);
        }
    }

    /**
     * サービス計画費登録パネルの入力内容をクリア
     */
    public void clickクリア() {
        setサービス計画費登録エリア(null);
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        // TODO ここは初期化です  入力してはいけません
        serviceCodeInputDiv.getTxtServiceCode1().setValue(サービスコード1);
    }

    /**
     * 「確定する」ボタンを押下 登録の場合
     */
    public void 確定_登録() {
        dgdYichiran_Row row = new dgdYichiran_Row();
        登録パネル_グリッド(row);
        List<dgdYichiran_Row> rowList = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource();
        row.setRowState(RowState.Added);
        rowList.add(row);
        div.getPanelServiceKeikakuhiUp().getDgdYichiran().setDataSource(rowList);
    }

    /**
     * 「確定する」ボタンを押下 修正の場合
     */
    public void 確定_修正() {
        dgdYichiran_Row row = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getClickedItem();
        RowState state = row.getRowState();
        if (RowState.Added.equals(state)) {
            row.setRowState(RowState.Added);
        } else {
            Boolean flag = 変更チェック(row);
            if (flag) {
                登録パネル_グリッド(row);
                row.setRowState(RowState.Modified);
            } else {
                confirm(row);
            }
        }
    }

    /**
     * 「確定する」ボタンを押下 削除の場合
     */
    public void 確定_削除() {
        dgdYichiran_Row row = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getClickedItem();
        RowState state = row.getRowState();
        if (RowState.Added.equals(state)) {
            div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource().remove(row.getId());
        } else {
            row.setRowState(RowState.Deleted);
        }
    }

    /**
     * 特定診療費・特別診療費登録エリアの「計算する」ボタンを押下 Handler処理
     */
    public void click計算keisan() {
        Decimal data = null;
        Decimal 単位数 = div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().getValue();
        Decimal 回数 = div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().getValue();
        if (単位数 != null && 回数 != null) {
            data = 単位数.multiply(回数);
            div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(data);
        }
    }

    /**
     * 画面内容の変更有無チェック Handler処理
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 画面内容の変更有無チェック Boolean
     */
    public Boolean 変更チェック処理(ServiceKeikakuHiPanelDiv div) {
        List<dgdYichiran_Row> rowList = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource();
        for (dgdYichiran_Row row : rowList) {
            if (!row.getRowState().equals(RowState.Unchanged)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 「申請を保存する」ボタン 保存処理 Handler処理
     *
     * @param 画面モード RString
     */
    public void 保存処理(RString 画面モード) {
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        if (削除モード.equals(画面モード)) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                    delShokanSyomeisyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else if (登録モード.equals(画面モード)) {
            List<ShokanServicePlan200904> entityList = new ArrayList<>();
            ShokanServicePlan200604 entity200604 = null;
            ShokanServicePlan200004 entity200004 = null;
            if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
                List<dgdYichiran_Row> rowList = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource();
                List<ShokanServicePlan200904Result> entity200904List = ViewStateHolder.get(
                        ViewStateKeys.償還払い費支給申請決定_サービス計画費, List.class);
                entityList = 保存_データ_200904(rowList, entity200904List, entityList, 被保険者番号,
                        サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            } else if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
                List<ShokanServicePlan200604Result> entity200604List = ViewStateHolder.get(
                        ViewStateKeys.償還払い費支給申請決定_サービス計画費, List.class);
                ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
                RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiDown()
                        .getDdlShiteiJigyoshaKubunCode().getSelectedKey();
                RString 審査方法区分コード = div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().getSelectedKey();
                FlexibleDate 届出日 = new FlexibleDate(div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().getValue().toString());
                Decimal 単位数 = div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().getValue();
                Decimal 単位数単価 = div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().getValue();
                Decimal 請求金額 = div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().getValue();
                RString 担当介護支援専門員番号 = div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().getValue();
                RString 摘要 = div.getPanelServiceKeikakuhiDown().getTxtTekiyo().getValue();
                RStringBuilder サービスコードBuilder = new RStringBuilder();
                RString serviceCode1 = serviceCodeInputDiv.getTxtServiceCode1().getValue();
                サービスコードBuilder.append(serviceCode1);
                サービスコードBuilder.append(serviceCodeInputDiv.getTxtServiceCode2().getValue());
                ShokanServicePlan200604 entity = entity200604List.get(0).getEntity();
                checkNull(entity);
                entity200604 = entity.createBuilderForEdit()
                        .set指定_基準該当事業者区分コード(指定_基準該当事業者区分コード)
                        .set審査方法区分コード(審査方法区分コード)
                        .set居宅サービス計画作成依頼届出年月日(届出日)
                        .set単位数(単位数.intValue())
                        .set単位数単価(単位数単価)
                        .set請求金額(請求金額.intValue())
                        .set担当介護支援専門員番号(担当介護支援専門員番号)
                        .set摘要(摘要)
                        .setサービスコード(new ServiceCode(サービスコードBuilder.toRString())).build().modified();
            } else {
                List<ShokanServicePlan200004Result> entity200004List = ViewStateHolder.get(
                        ViewStateKeys.償還払い費支給申請決定_サービス計画費, List.class);
                ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
                RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiDown()
                        .getDdlShiteiJigyoshaKubunCode().getSelectedKey();
                RString 審査方法区分コード = div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().getSelectedKey();
                FlexibleDate 届出日 = new FlexibleDate(div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().getValue().toString());
                Decimal 単位数 = div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().getValue();
                Decimal 単位数単価 = div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().getValue();
                Decimal 請求金額 = div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().getValue();
                RStringBuilder サービスコードBuilder = new RStringBuilder();
                RString serviceCode1 = serviceCodeInputDiv.getTxtServiceCode1().getValue();
                サービスコードBuilder.append(serviceCode1);
                サービスコードBuilder.append(serviceCodeInputDiv.getTxtServiceCode2().getValue());
                ShokanServicePlan200004 entity = entity200004List.get(0).getEntity();
                checkNull(entity);
                entity200004 = entity.createBuilderForEdit()
                        .set指定_基準該当事業者区分コード(指定_基準該当事業者区分コード)
                        .set審査方法区分コード(審査方法区分コード)
                        .set居宅サービス計画作成依頼届出年月日(届出日)
                        .set単位数(単位数.intValue())
                        .set単位数単価(単位数単価)
                        .set請求金額(請求金額.intValue())
                        .setサービスコード(new ServiceCode(サービスコードBuilder.toRString())).build().modified();
            }
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(
                    entityList, entity200604, entity200004, サービス年月, 明細番号);
        }
    }

    private List<ShokanServicePlan200904> 保存_データ_200904(List<dgdYichiran_Row> rowList, List<ShokanServicePlan200904Result> entity200904List,
            List<ShokanServicePlan200904> entityList, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        int max連番 = 0;
        max連番 = max連番(entity200904List);
        for (dgdYichiran_Row row : rowList) {
            if (RowState.Modified.equals(row.getRowState())) {
                ShokanServicePlan200904 entity200904 = entity200904List.get(
                        Integer.valueOf(row.getRowNum().toString())).getEntity();
                entity200904 = 保存_データ(row, entity200904);
                entityList.add(entity200904);
            } else if (RowState.Deleted.equals(row.getRowState())) {
                entityList.add(entity200904List.get(Integer.valueOf(row.getRowNum().toString())).getEntity().deleted());
            } else if (RowState.Added.equals(row.getRowState())) {
                max連番 = max連番 + 1;
                ShokanServicePlan200904 entity200904 = new ShokanServicePlan200904(
                        被保険者番号,
                        サービス年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号,
                        new RString(String.valueOf(max連番)));
                entity200904 = 保存_データ(row, entity200904);
                entityList.add(entity200904);
            }
        }
        return entityList;
    }

    private int max連番(List<ShokanServicePlan200904Result> entity200904List) {
        int max連番 = 0;
        for (ShokanServicePlan200904Result entity200904 : entity200904List) {
            if (max連番 < Integer.valueOf(entity200904.getEntity().get連番().toString())) {
                max連番 = Integer.valueOf(entity200904.getEntity().get連番().toString());
            }
        }
        return max連番;
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> confirm(dgdYichiran_Row row) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            row.setRowState(RowState.Unchanged);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void 登録パネル_グリッド(dgdYichiran_Row row) {
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        RStringBuilder サービスコードBuilder = new RStringBuilder();
        RString serviceCode1 = serviceCodeInputDiv.getTxtServiceCode1().getValue();
        サービスコードBuilder.append(serviceCode1);
        サービスコードBuilder.append(serviceCodeInputDiv.getTxtServiceCode2().getValue());
        RString サービス名称 = serviceCodeInputDiv.getTxtServiceCodeName().getValue();
        Decimal 単位数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().getValue();
        Decimal 回数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().getValue();
        Decimal サービス単位数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().getValue();
        RString 摘要 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().getValue();
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().getSelectedKey();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().getSelectedKey();
        RDate 届出日 = div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().getValue();
        RString 担当介護支援専門員番号 = div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().getValue();
        Decimal 単位数単価 = div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().getValue();
        row.setDefaultDataName1(サービスコードBuilder.toRString());
        row.setDefaultDataName6(サービス名称);
        row.getDefaultDataName2().setValue(単位数);
        row.getDefaultDataName3().setValue(回数);
        row.getDefaultDataName4().setValue(サービス単位数);
        row.setDefaultDataName5(摘要);
        row.setDefaultDataName8(指定_基準該当事業者区分コード);
        row.setDefaultDataName9(審査方法区分コード);
        row.getDefaultDataName10().setValue(届出日);
        row.setDefaultDataName11(担当介護支援専門員番号);
        row.getDefaultDataName12().setValue(単位数単価);
    }

    private ShokanServicePlan200904 保存_データ(dgdYichiran_Row row, ShokanServicePlan200904 entity200904) {
        RowState state = row.getRowState();
        ServiceCode サービスコード = new ServiceCode(row.getDefaultDataName1());
        Decimal 単位数 = row.getDefaultDataName2().getValue();
        Decimal 回数 = row.getDefaultDataName3().getValue();
        Decimal サービス単位数 = row.getDefaultDataName4().getValue();
        RString 摘要 = row.getDefaultDataName5();
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().getSelectedKey();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().getSelectedKey();
        FlexibleDate 届出日 = new FlexibleDate(div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().getValue().toString());
        RString 担当介護支援専門員番号 = div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().getValue();
        Decimal 単位数単価 = div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().getValue();
        entity200904 = entity200904.createBuilderForEdit()
                .setサービスコード(サービスコード)
                .set単位数(単位数.intValue())
                .set回数(回数.intValue())
                .setサービス単位数(サービス単位数.intValue())
                .set摘要(摘要)
                .set指定_基準該当事業者区分コード(指定_基準該当事業者区分コード)
                .set審査方法区分コード(審査方法区分コード)
                .set居宅サービス計画作成依頼届出年月日(届出日)
                .set担当介護支援専門員番号(担当介護支援専門員番号)
                .set単位数単価(単位数単価).build();
        if (RowState.Added.equals(state)) {
            entity200904 = entity200904.added();
        } else if (RowState.Deleted.equals(state)) {
            entity200904 = entity200904.deleted();
        } else if (RowState.Modified.equals(state)) {
            entity200904 = entity200904.modified();
        }
        return entity200904;
    }

    private void setサービス計画費共通エリア(ShokanServicePlan200904Result entity200904) {
        if (entity200904 == null) {
            List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDataSource(事業者区分リスト);
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setSelectedIndex(0);
            List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDataSource(審査方法区分リスト);
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setSelectedIndex(0);
            div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().clearValue();
            div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().clearValue();
            div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().clearValue();
        } else {
            List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDataSource(事業者区分リスト);
            List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDataSource(審査方法区分リスト);
            FlexibleDate 届出日 = entity200904.getEntity().get居宅サービス計画作成依頼届出年月日();
            RString 担当介護支援専門員番号 = entity200904.getEntity().get担当介護支援専門員番号();
            Decimal 単位数単価 = entity200904.getEntity().get単位数単価();
            RString 事業者区分コード = entity200904.getEntity().get指定_基準該当事業者区分コード();
            RString 審査方法区分コード = entity200904.getEntity().get審査方法区分コード();
            if (!事業者区分コード.isNullOrEmpty()) {
                div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setSelectedKey(事業者区分コード);
            } else {
                div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setSelectedIndex(0);
            }
            if (!審査方法区分コード.isNullOrEmpty()) {
                div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setSelectedKey(審査方法区分コード);
            } else {
                div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setSelectedIndex(0);
            }
            if (!届出日.isEmpty()) {
                div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setValue(new RDate(届出日.toString()));
            }
            div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().setValue(担当介護支援専門員番号);
            div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setValue(単位数単価);
        }
    }

    private void setサービス計画費共通エリア1(dgdYichiran_Row row) {
        List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
        div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDataSource(事業者区分リスト);
        List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
        div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDataSource(審査方法区分リスト);
        RDate 届出日 = row.getDefaultDataName10().getValue();
        RString 担当介護支援専門員番号 = row.getDefaultDataName11();
        Decimal 単位数単価 = row.getDefaultDataName12().getValue();
        RString 事業者区分コード = row.getDefaultDataName8();
        RString 審査方法区分コード = row.getDefaultDataName9();
        if (!事業者区分コード.isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setSelectedKey(事業者区分コード);
        } else {
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setSelectedIndex(0);
        }
        if (!審査方法区分コード.isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setSelectedKey(審査方法区分コード);
        } else {
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setSelectedIndex(0);
        }
        if (届出日 != null) {
            div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setValue(届出日);
        }
        div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().setValue(担当介護支援専門員番号);
        div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setValue(単位数単価);
    }

    private List<KeyValueDataSource> get事業者区分リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (JigyoshaKubun 事業者区分 : JigyoshaKubun.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(事業者区分.getコード(), 事業者区分.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get審査方法リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShinsaHohoKubun 審査方法 : ShinsaHohoKubun.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(審査方法.getコード(), 審査方法.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private void setサービス計画費登録エリア(ShokanServicePlan200904Result entity200904) {
        if (entity200904 == null) {
            ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
            serviceCodeInputDiv.getTxtServiceCode2().clearValue();
            serviceCodeInputDiv.getTxtServiceCode1().clearValue();
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().clearValue();
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().clearValue();
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().clearValue();
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().clearValue();
        } else {
            RString サービスコード = entity200904.getEntity().getサービスコード().getColumnValue();
            Decimal 単位数 = new Decimal(entity200904.getEntity().get単位数());
            Decimal 回数 = new Decimal(entity200904.getEntity().get回数());
            Decimal サービス単位数 = new Decimal(entity200904.getEntity().getサービス単位数());
            RString 摘要 = entity200904.getEntity().get摘要();
            ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
            if (サービスコード != null) {
                serviceCodeInputDiv.getTxtServiceCode1().setValue(サービスコード.substring(0, 2));
                serviceCodeInputDiv.getTxtServiceCode2().setValue(サービスコード.substring(サービスコード.length() - サービスコード2));
            }
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().setValue(単位数);
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().setValue(回数);
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().setValue(サービス単位数);
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().setValue(摘要);
        }
    }

    private void setサービス計画費登録エリア1(dgdYichiran_Row row) {
        RString サービスコード = row.getDefaultDataName1();
        Decimal 単位数 = row.getDefaultDataName2().getValue();
        Decimal 回数 = row.getDefaultDataName3().getValue();
        Decimal サービス単位数 = row.getDefaultDataName4().getValue();
        RString 摘要 = row.getDefaultDataName5();
        RString サービス名称 = row.getDefaultDataName6();
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        if (サービスコード != null) {
            serviceCodeInputDiv.getTxtServiceCode1().setValue(サービスコード.substring(0, 2));
            serviceCodeInputDiv.getTxtServiceCode2().setValue(サービスコード.substring(サービスコード.length() - サービスコード2));
        }
        serviceCodeInputDiv.getTxtServiceCodeName().setValue(サービス名称);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().setValue(単位数);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().setValue(回数);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().setValue(サービス単位数);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().setValue(摘要);
    }

    private void setサービス計画費共通エリアLoad(List<ShokanServicePlan200904Result> entity200904List) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ShokanServicePlan200904Result entity200904 = entity200904List.get(0);
        for (int i = 1; i < entity200904List.size(); i++) {
            if (new Decimal(entity200904.getEntity().get連番().toString())
                    .compareTo(new Decimal(entity200904List.get(i).getEntity().get連番().toString())) < 0) {
                entity200904 = entity200904List.get(i);
            }
        }
        List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
        div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDataSource(事業者区分リスト);
        List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
        div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDataSource(審査方法区分リスト);
        if (!entity200904.getEntity().get指定_基準該当事業者区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setSelectedKey(entity200904.getEntity().get指定_基準該当事業者区分コード());
        }
        if (!entity200904.getEntity().get審査方法区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setSelectedKey(entity200904.getEntity().get審査方法区分コード());
        }
        FlexibleDate 届出日 = entity200904.getEntity().get居宅サービス計画作成依頼届出年月日();
        if (!届出日.isEmpty()) {
            div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setValue(new RDate(届出日.toString()));
        }
        div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().setValue(entity200904.getEntity().get担当介護支援専門員番号());
        div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setValue(entity200904.getEntity().get単位数単価());
        if (削除モード.equals(画面モード)) {
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setDisabled(true);
        }
    }

    private void setサービス計画費グリッドエリア(List<ShokanServicePlan200904Result> entity200904List) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        List<dgdYichiran_Row> dataSource = new ArrayList<>();
        int i = 0;
        for (ShokanServicePlan200904Result entity200904 : entity200904List) {
            dgdYichiran_Row row = new dgdYichiran_Row();
            row.setRowNum(new RString(String.valueOf(i)));
            row.setDefaultDataName1(new RString(
                    entity200904.getEntity().getサービスコード().getColumnValue().toString()));
            row.setDefaultDataName6(entity200904.getServiceName());
            row.getDefaultDataName2().setValue(new Decimal(entity200904.getEntity().get単位数()));
            row.getDefaultDataName3().setValue(new Decimal(entity200904.getEntity().get回数()));
            row.getDefaultDataName4().setValue(new Decimal(entity200904.getEntity().getサービス単位数()));
            row.setDefaultDataName5(entity200904.getEntity().get摘要());
            row.setDefaultDataName7(entity200904.getEntity().get連番());
            row.setDefaultDataName8(entity200904.getEntity().get指定_基準該当事業者区分コード());
            row.setDefaultDataName9(entity200904.getEntity().get審査方法区分コード());
            FlexibleDate 届出日 = entity200904.getEntity().get居宅サービス計画作成依頼届出年月日();
            if (!届出日.isEmpty()) {
                row.getDefaultDataName10().setValue(new RDate(届出日.toString()));
            }
            row.setDefaultDataName11(entity200904.getEntity().get担当介護支援専門員番号());
            row.getDefaultDataName12().setValue(entity200904.getEntity().get単位数単価());
            i = i + 1;
            dataSource.add(row);
        }
        // TODO グリッドの請求額の合計
        div.getPanelServiceKeikakuhiUp().getTxtGokeiTanyi().setValue(Decimal.ZERO);
        div.getPanelServiceKeikakuhiUp().getTxtSeikyugaku().setValue(Decimal.ZERO);
        div.getPanelServiceKeikakuhiUp().getDgdYichiran().setDataSource(dataSource);
        if (削除モード.equals(画面モード)) {
            div.getPanelServiceKeikakuhiUp().getDgdYichiran().setReadOnly(true);
        }
    }

    private void setサービス計画費エリア200604(ShokanServicePlan200604Result entity200604) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
        div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setDataSource(事業者区分リスト);
        List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setDataSource(審査方法区分リスト);
        if (!entity200604.getEntity().get指定_基準該当事業者区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setSelectedKey(
                    entity200604.getEntity().get指定_基準該当事業者区分コード());
        }
        if (!entity200604.getEntity().get居宅サービス計画作成依頼届出年月日().isEmpty()) {
            div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(
                    new RDate(entity200604.getEntity().get居宅サービス計画作成依頼届出年月日().toString()));
        }
        if (!entity200604.getEntity().get審査方法区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedKey(entity200604.getEntity().get審査方法区分コード());
        }
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
        RString サービスコード = new RString(entity200604.getEntity().getサービスコード().getColumnValue().toString());
        if (サービスコード != null) {
            serviceCodeInputDiv.getTxtServiceCode1().setValue(サービスコード.substring(0, 2));
            serviceCodeInputDiv.getTxtServiceCode2().setValue(サービスコード.substring(サービスコード.length() - サービスコード2));
        }
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200604.getEntity().get単位数()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200604.getEntity().get単位数単価());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200604.getEntity().get請求金額()));
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setValue(entity200604.getEntity().get担当介護支援専門員番号());
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setValue(entity200604.getEntity().get摘要());
        if (削除モード.equals(画面モード)) {
            div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setDisabled(true);
        }
    }

    private void setサービス計画費エリア200004(ShokanServicePlan200004Result entity200004) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
        div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setDataSource(事業者区分リスト);
        List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setDataSource(審査方法区分リスト);
        if (!entity200004.getEntity().get指定_基準該当事業者区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setSelectedKey(
                    entity200004.getEntity().get指定_基準該当事業者区分コード());
        }
        if (!entity200004.getEntity().get居宅サービス計画作成依頼届出年月日().isEmpty()) {
            div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(
                    new RDate(entity200004.getEntity().get居宅サービス計画作成依頼届出年月日().toString()));
        }
        if (!entity200004.getEntity().get審査方法区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedKey(entity200004.getEntity().get審査方法区分コード());
        }
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
        RString サービスコード = new RString(entity200004.getEntity().getサービスコード().getColumnValue().toString());
        if (サービスコード != null) {
            serviceCodeInputDiv.getTxtServiceCode1().setValue(サービスコード.substring(0, 2));
            serviceCodeInputDiv.getTxtServiceCode2().setValue(サービスコード.substring(サービスコード.length() - サービスコード2));
        }
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200004.getEntity().get単位数()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200004.getEntity().get単位数単価());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200004.getEntity().get請求金額()));
        if (削除モード.equals(画面モード)) {
            div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setDisabled(true);
            div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setDisabled(true);
        }
    }

    private Boolean 変更チェック(dgdYichiran_Row row) {
        int flag = 0;
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        RStringBuilder サービスコードBuilder = new RStringBuilder();
        RString serviceCode1 = serviceCodeInputDiv.getTxtServiceCode1().getValue();
        サービスコードBuilder.append(serviceCode1);
        サービスコードBuilder.append(serviceCodeInputDiv.getTxtServiceCode2().getValue());
        RString serviceCodeName = serviceCodeInputDiv.getTxtServiceCodeName().getValue();
        Decimal 単位数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().getValue();
        Decimal 回数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().getValue();
        Decimal サービス単位数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().getValue();
        RString 摘要 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().getValue();
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().getSelectedKey();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().getSelectedKey();
        RDate 届出日 = div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().getValue();
        RString 担当介護支援専門員番号 = div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().getValue();
        Decimal 単位数単価 = div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().getValue();
        if (サービスコードBuilder.toRString() == null && row.getDefaultDataName1() != null) {
            return true;
        } else if (サービスコードBuilder.toRString() != null && !サービスコードBuilder.toRString().equals(row.getDefaultDataName1())) {
            return true;
        }
        flag = flag + check(serviceCodeName, row.getDefaultDataName6());
        flag = flag + check(単位数, row.getDefaultDataName2().getValue());
        flag = flag + check(回数, row.getDefaultDataName3().getValue());
        flag = flag + check(サービス単位数, row.getDefaultDataName4().getValue());
        flag = flag + check(摘要, row.getDefaultDataName5());
        flag = flag + check(指定_基準該当事業者区分コード, row.getDefaultDataName8());
        flag = flag + check(審査方法区分コード, row.getDefaultDataName9());
        flag = flag + check(届出日, row.getDefaultDataName10().getValue());
        if (担当介護支援専門員番号 == null && row.getDefaultDataName11() != null) {
            return true;
        } else if (担当介護支援専門員番号 != null && !担当介護支援専門員番号.padZeroToLeft(担当介護支援専門員番号LENGTH).equals(row.getDefaultDataName11().padZeroToLeft(担当介護支援専門員番号LENGTH))) {
            return true;
        }
        flag = flag + check(単位数単価, row.getDefaultDataName12());
        return flag != 0;
    }

    private int check(Object obj, Object object) {
        if (obj == null && object != null) {
            return 1;
        } else if (obj != null && !obj.equals(object)) {
            return 1;
        }
        return 0;
    }

    private void set基本情報ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 != 0) {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定診療費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
                div.getPanelHead().getBtnTokuteiShinryo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定入所者費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosha().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 != 0) {
                div.getPanelHead().getBtnTokuteiNyushosha().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiNyushosha().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosha().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細_住特ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 != 0) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時_所定疾患ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時施設療養費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsu().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 != 0) {
                div.getPanelHead().getBtnKinkyujiShisetsu().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShisetsu().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsu().setIconNameEnum(IconName.NONE);
        }
    }

    private void set食事費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set請求額集計ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 != 0) {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
    }

    private void set社福軽減額ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigenGaku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 != 0) {
                div.getPanelHead().getBtnShafukukeigenGaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigenGaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigenGaku().setIconNameEnum(IconName.NONE);
        }
    }

    private void checkNull(Object entity) {
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
    }
}
