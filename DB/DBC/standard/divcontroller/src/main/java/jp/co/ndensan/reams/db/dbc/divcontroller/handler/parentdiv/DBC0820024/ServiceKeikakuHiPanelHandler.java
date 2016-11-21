/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv.IServiceCodeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.ServiceKeikakuHiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払い費支給申請決定_サービス提供証明書(サービス計画費)のハンドラクラスです。
 *
 * @reamsid_L DBC-1030-010 gongliang
 */
public class ServiceKeikakuHiPanelHandler {

    private final ServiceKeikakuHiPanelDiv div;
    private static final int 連番LENGTH = 2;
    private static final RString 連番_1 = new RString("01");
    private static final RString 事業者区分BLANK = new RString("0");
    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth サービス年月_200604 = new FlexibleYearMonth("200604");
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 削除モード = new RString("削除");
    private static final int サービスコード2 = 4;
    private static final int 担当介護支援専門員番号LENGTH = 8;
    private static final Decimal DECIMAL_100 = new Decimal(100);
    private static final Comparator COMPARABLE = new Comparator<dgdYichiran_Row>() {
        @Override
        public int compare(dgdYichiran_Row o1, dgdYichiran_Row o2) {
            return -(Integer.parseInt(o1.getDefaultDataName7().toString())
                    - Integer.parseInt(o2.getDefaultDataName7().toString()));
        }
    };
    private static final int NUM0 = 0;
    private static final int NUM6 = 6;

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
     * @param 画面モード RString
     * @param entity200904ResultList List<ShokanServicePlan200904Result>
     */
    public void onLoad200904(List<ShokanServicePlan200904Result> entity200904ResultList, RString 画面モード) {
        setサービス計画費共通エリアRequired(true);
        setサービス計画費グリッドエリアRequired(false);
        setサービス計画費Required(false);
        setサービス計画費共通エリアLoad(entity200904ResultList, 画面モード);
        setサービス計画費グリッドエリア(entity200904ResultList, 画面モード);

    }

    /**
     * onLoad処理 サービス年月が200604～200903の場合
     *
     * @param 画面モード RString
     * @param entity200604Result ShokanServicePlan200604Result
     */
    public void onLoad200604(ShokanServicePlan200604Result entity200604Result, RString 画面モード) {
        setサービス計画費共通エリアRequired(false);
        setサービス計画費グリッドエリアRequired(false);
        setサービス計画費エリア200604(entity200604Result, 画面モード);
    }

    /**
     * onLoad処理 サービス年月が200603以前の場合
     *
     * @param entity200004Result ServiceKeikakuHiRealtEntity
     * @param 画面モード RString
     */
    public void onLoad200004(ShokanServicePlan200004Result entity200004Result, RString 画面モード) {
        setサービス計画費共通エリアRequired(false);
        setサービス計画費グリッドエリアRequired(false);
        setサービス計画費エリア200004(entity200004Result, 画面モード);
    }

    /**
     * 申請共通エリアの設定
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 申請日 RDate
     * @param 事業者番号 JigyoshaNo
     * @param 明細番号 RString
     * @param 様式番号 RString
     */
    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            RDate 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 様式番号) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(申請日);
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisayiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(様式番号);
    }

    /**
     * ボタン制御
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     * @param paramter ShoukanharaihishinseimeisaikensakuParameter
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri, ShoukanharaihishinseimeisaikensakuParameter paramter) {
        HihokenshaNo 被保険者番号 = paramter.get被保険者番号();
        FlexibleYearMonth サービス年月 = paramter.getサービス年月();
        RString 整理番号 = paramter.get整理番号();
        JigyoshaNo 事業者番号 = paramter.get事業者番号();
        RString 様式番号 = paramter.get様式番号();
        RString 明細番号 = paramter.get明細番号();
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
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(false);
        setサービス計画費グリッドエリアRequired(true);
        setサービス計画費共通エリア(null);
        clickクリア();
    }

    /**
     * グリッドの修正ボタン Handler処理
     *
     * @param row dgdYichiran_Row
     */
    public void click修正(dgdYichiran_Row row) {
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(false);
        setサービス計画費グリッドエリアRequired(true);
        setサービス計画費共通エリア(null);
        clickクリア();
        setサービス計画費共通エリアdown(row);
        setサービス計画費登録エリアdown(row);
    }

    /**
     * グリッドの削除ボタン Handler処理
     *
     * @param row dgdYichiran_Row
     */
    public void click削除(dgdYichiran_Row row) {
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setDisplayNone(false);
        setサービス計画費グリッドエリアRequired(false);
        setサービス計画費共通エリア(null);
        clickクリア();
        setサービス計画費共通エリアdown(row);
        setサービス計画費登録エリアdown(row);
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
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div
                .getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        serviceCodeInputDiv.setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().setReadOnly(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getBtnClear().setDisabled(true);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getBtnKeisan().setDisabled(true);
    }

    /**
     * グリッドの修正、追加button Handlerのsetです。
     */
    private void set修正_追加() {
        div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setReadOnly(false);
        div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setReadOnly(false);
        div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setReadOnly(false);
        div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().setReadOnly(false);
        div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setReadOnly(false);
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div
                .getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        serviceCodeInputDiv.setReadOnly(false);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().setReadOnly(false);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().setReadOnly(false);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().setReadOnly(false);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getBtnClear().setDisabled(false);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getBtnKeisan().setDisabled(false);
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
        }
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().setValue(data);
    }

    /**
     * サービス計画費登録パネルの入力内容をクリア
     */
    public void clickクリア() {
        setサービス計画費登録エリア();
    }

    /**
     * 「確定する」ボタンを押下 登録の場合
     *
     * @param maxRenban 最大連番
     */
    public void 確定_登録(int maxRenban) {
        setサービス計画費グリッドエリアRequired(false);
        dgdYichiran_Row row = new dgdYichiran_Row();
        登録パネル_グリッド(row, maxRenban, true);
        List<dgdYichiran_Row> rowList = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource();
        row.setRowState(RowState.Added);
        rowList.add(row);
        Collections.sort(rowList, COMPARABLE);
        Decimal 単位合計 = Decimal.ZERO;
        for (dgdYichiran_Row item : rowList) {
            単位合計 = 単位合計.add(item.getDefaultDataName4().getValue());
        }
        Decimal 請求額合計 = 単位合計.multiply(div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().getValue());
        div.getPanelServiceKeikakuhiUp().getTxtGokeiTanyi().setValue(単位合計);
        div.getPanelServiceKeikakuhiUp().getTxtSeikyugaku().setValue(請求額合計);
        div.getPanelServiceKeikakuhiUp().getDgdYichiran().setDataSource(rowList);
    }

    /**
     * 「確定する」ボタンを押下 修正の場合
     *
     * @param maxRenban 最大連番
     * @param entity200904ResultList ShokanServicePlan200904Result
     */
    public void 確定_修正(int maxRenban,
            List<ShokanServicePlan200904Result> entity200904ResultList) {
        setサービス計画費グリッドエリアRequired(false);
        dgdYichiran_Row row = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getClickedItem();
        RowState state = row.getRowState();
        Boolean flag = 変更チェック(row, entity200904ResultList);
        登録パネル_グリッド(row, maxRenban, false);
        if (RowState.Modified == state && !flag) {
            row.setRowState(RowState.Unchanged);
        } else if (RowState.Added != state) {
            row.setRowState(RowState.Modified);
        }
        List<dgdYichiran_Row> list = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource();
        Decimal 単位合計 = Decimal.ZERO;
        for (dgdYichiran_Row item : list) {
            単位合計 = 単位合計.add(item.getDefaultDataName4().getValue());
        }
        Decimal 請求額合計 = 単位合計.multiply(div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().getValue());
        div.getPanelServiceKeikakuhiUp().getTxtGokeiTanyi().setValue(単位合計);
        div.getPanelServiceKeikakuhiUp().getTxtSeikyugaku().setValue(請求額合計);
    }

    private FlexibleDate formatRDateToFlexible(RDate date) {
        if (date == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(date.toDateString());
    }

    /**
     * 「確定する」ボタンを押下 削除の場合
     */
    public void 確定_削除() {
        setサービス計画費グリッドエリアRequired(false);
        List<dgdYichiran_Row> list = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource();
        dgdYichiran_Row row = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getClickedItem();
        RowState state = row.getRowState();
        if (RowState.Added.equals(state)) {
            list.remove(row.getId());
            resetRenban(row, list);
        } else {
            row.setRowState(RowState.Deleted);
        }
        Collections.sort(list, COMPARABLE);
        div.getPanelServiceKeikakuhiUp().getDgdYichiran().setDataSource(list);
        set修正_追加();
    }

    private void resetRenban(dgdYichiran_Row row, List<dgdYichiran_Row> list) {
        int id = row.getId();
        if (id != 0) {
            RString deletedRenban = row.getDefaultDataName7();
            RString mid;
            for (dgdYichiran_Row resetRow : list) {
                if (id - resetRow.getId() == 1) {
                    mid = resetRow.getDefaultDataName7();
                    resetRow.setDefaultDataName7(deletedRenban);
                    id = id - 1;
                    deletedRenban = mid;
                }
                if (id == 0) {
                    break;
                }
            }
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
        }
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(data);
    }

    /**
     * 画面内容の変更有無チェック Handler処理
     *
     * @return 画面内容の変更有無 Boolean
     */
    public Boolean 変更チェック処理() {
        List<dgdYichiran_Row> rowList = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource();
        for (dgdYichiran_Row row : rowList) {
            if (!row.getRowState().equals(RowState.Unchanged)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param 開始時点のentity200604Result ShokanServicePlan200604Result
     * @return サービス年月が200604～200903の場合 画面内容の変更有無
     */
    public Boolean 変更チェック処理200604(ShokanServicePlan200604Result 開始時点のentity200604Result) {
        int flag = 0;
        if (開始時点のentity200604Result == null) {
            return true;
        }
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().getSelectedKey();
        RDate 届出日 = div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().getValue();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().getSelectedKey();
        RStringBuilder サービスコードBuilder = new RStringBuilder();
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
        RString serviceCode1 = serviceCodeInputDiv.getサービスコード1();
        サービスコードBuilder.append(serviceCode1);
        サービスコードBuilder.append(serviceCodeInputDiv.getサービスコード2());
        RString サービスコード名称 = serviceCodeInputDiv.getサービス名称();
        Decimal 単位数Decimal = div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().getValue();
        int 単位数 = 単位数Decimal == null ? 0 : 単位数Decimal.intValue();
        Decimal 単位数単価 = div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().getValue();
        Decimal 請求金額Decimal = div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().getValue();
        int 請求金額 = 請求金額Decimal == null ? 0 : 請求金額Decimal.intValue();
        RString 担当介護支援専門員番号 = div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().getValue();
        RString 摘要 = div.getPanelServiceKeikakuhiDown().getTxtTekiyo().getValue();
        flag = flag + check(指定_基準該当事業者区分コード, 開始時点のentity200604Result.getEntity().get指定_基準該当事業者区分コード());
        flag = flag + check(届出日, new RDate(開始時点のentity200604Result.getEntity().get居宅サービス計画作成依頼届出年月日().toString()));
        flag = flag + check(審査方法区分コード, 開始時点のentity200604Result.getEntity().get審査方法区分コード());
        flag = flag + check(サービスコードBuilder.toRString(), 開始時点のentity200604Result.getEntity().getサービスコード());
        flag = flag + check(サービスコード名称, 開始時点のentity200604Result.getServiceName());
        flag = flag + checkInt(単位数, 開始時点のentity200604Result.getEntity().get単位数());
        flag = flag + checkDecimal(単位数単価, 開始時点のentity200604Result.getEntity().get単位数単価());
        flag = flag + checkInt(請求金額, 開始時点のentity200604Result.getEntity().get請求金額());
        flag = flag + check担当介護支援専門員番号(担当介護支援専門員番号, 開始時点のentity200604Result.getEntity().get担当介護支援専門員番号());
        flag = flag + check(摘要, 開始時点のentity200604Result.getEntity().get摘要());
        return flag != 0;
    }

    /**
     * @param 開始時点のentity200004Result ShokanServicePlan200004Result
     * @return サービス年月が200603以前の場合 画面内容の変更有無
     */
    public Boolean 変更チェック処理200004(ShokanServicePlan200004Result 開始時点のentity200004Result) {
        int flag = 0;
        if (開始時点のentity200004Result == null) {
            return true;
        }
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().getSelectedKey();
        RDate 届出日 = div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().getValue();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().getSelectedKey();
        RStringBuilder サービスコードBuilder = new RStringBuilder();
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
        RString serviceCode1 = serviceCodeInputDiv.getサービスコード1();
        サービスコードBuilder.append(serviceCode1);
        サービスコードBuilder.append(serviceCodeInputDiv.getサービスコード2());
        RString サービスコード名称 = serviceCodeInputDiv.getサービス名称();
        Decimal 単位数Decimal = div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().getValue();
        int 単位数 = 単位数Decimal == null ? 0 : 単位数Decimal.intValue();
        Decimal 単位数単価 = div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().getValue();
        Decimal 請求金額Decimal = div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().getValue();
        int 請求金額 = 請求金額Decimal == null ? 0 : 請求金額Decimal.intValue();
        flag = flag + check(指定_基準該当事業者区分コード, 開始時点のentity200004Result.getEntity().get指定_基準該当事業者区分コード());
        flag = flag + check(届出日, new RDate(開始時点のentity200004Result.getEntity().get居宅サービス計画作成依頼届出年月日().toString()));
        flag = flag + check(審査方法区分コード, 開始時点のentity200004Result.getEntity().get審査方法区分コード());
        flag = flag + check(サービスコードBuilder.toRString(), 開始時点のentity200004Result.getEntity().getサービスコード());
        flag = flag + check(サービスコード名称, 開始時点のentity200004Result.getServiceName());
        flag = flag + checkInt(単位数, 開始時点のentity200004Result.getEntity().get単位数());
        flag = flag + checkDecimal(単位数単価, 開始時点のentity200004Result.getEntity().get単位数単価());
        flag = flag + checkInt(請求金額, 開始時点のentity200004Result.getEntity().get請求金額());
        return flag != 0;
    }

    /**
     * 「確定」ボタン ViewStateにDBを保存処理 Handler処理
     *
     * @param parameter ShoukanharaihishinseimeisaikensakuParameter
     * @param entity200904ResultList List<ShokanServicePlan200904Result>
     * @return サービス計画200904
     */
    public List<ShokanServicePlan200904Result> saveサービス計画200904(ShoukanharaihishinseimeisaikensakuParameter parameter, List<ShokanServicePlan200904Result> entity200904ResultList) {
        HihokenshaNo 被保険者番号 = parameter.get被保険者番号();
        FlexibleYearMonth サービス年月 = parameter.getサービス年月();
        RString 整理番号 = parameter.get整理番号();
        RString 様式番号 = parameter.get様式番号();
        RString 明細番号 = parameter.get明細番号();
        boolean 明細番号区分 = 明細番号 == null || 明細番号.isEmpty();
        JigyoshaNo 事業者番号 = parameter.get事業者番号();
        List<ShokanServicePlan200904Result> newEntity200904ResultList = new ArrayList<>();
        if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
            List<dgdYichiran_Row> rowList = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getDataSource();
            newEntity200904ResultList = 保存_データ_200904(rowList,
                    entity200904ResultList,
                    被保険者番号,
                    サービス年月,
                    事業者番号,
                    様式番号,
                    明細番号,
                    整理番号);
            if ((newEntity200904ResultList != null && !newEntity200904ResultList.isEmpty())
                    && 明細番号区分) {
                for (ShokanServicePlan200904Result entity200904Result : newEntity200904ResultList) {
                    if (!EntityDataState.Deleted.equals(entity200904Result.getEntity().toEntity().getState())) {
                        entity200904Result = new ShokanServicePlan200904Result(entity200904Result.getEntity().added(), entity200904Result.getServiceName());
                        newEntity200904ResultList.add(entity200904Result);
                    }
                }
            }
        }
        return newEntity200904ResultList;
    }

    /**
     * 「確定」ボタン ViewStateにDBを保存処理 Handler処理
     *
     * @param parameter ShoukanharaihishinseimeisaikensakuParameter
     * @param entity200604Result ShokanServicePlan200604Result
     * @return サービス計画200604
     */
    public ShokanServicePlan200604Result saveサービス計画200604(ShoukanharaihishinseimeisaikensakuParameter parameter, ShokanServicePlan200604Result entity200604Result) {
        HihokenshaNo 被保険者番号 = parameter.get被保険者番号();
        FlexibleYearMonth サービス年月 = parameter.getサービス年月();
        RString 整理番号 = parameter.get整理番号();
        RString 様式番号 = parameter.get様式番号();
        RString 明細番号 = parameter.get明細番号();
        boolean 明細番号区分 = 明細番号 == null || 明細番号.isEmpty();
        JigyoshaNo 事業者番号 = parameter.get事業者番号();
        if (サービス年月_200604.isBeforeOrEquals(サービス年月) && サービス年月.isBefore(サービス年月_200904)) {
            ShokanServicePlan200604 entity200604 = 保存_データ_200604(entity200604Result,
                    被保険者番号,
                    サービス年月,
                    事業者番号,
                    様式番号,
                    明細番号,
                    整理番号);
            if (null != entity200604) {
                if (明細番号区分) {
                    entity200604 = entity200604.added();
                } else {
                    entity200604 = entity200604.modified();
                }
                return new ShokanServicePlan200604Result(entity200604, null == entity200604Result ? RString.EMPTY : entity200604Result.getServiceName());
            }
        }
        return null;
    }

    /**
     * 「確定」ボタン ViewStateにDBを保存処理 Handler処理
     *
     * @param parameter ShoukanharaihishinseimeisaikensakuParameter
     * @param entity200004Result ShokanServicePlan200004Result
     * @return サービス計画200004
     */
    public ShokanServicePlan200004Result saveサービス計画200004(ShoukanharaihishinseimeisaikensakuParameter parameter, ShokanServicePlan200004Result entity200004Result) {
        HihokenshaNo 被保険者番号 = parameter.get被保険者番号();
        FlexibleYearMonth サービス年月 = parameter.getサービス年月();
        RString 整理番号 = parameter.get整理番号();
        RString 様式番号 = parameter.get様式番号();
        RString 明細番号 = parameter.get明細番号();
        boolean 明細番号区分 = 明細番号 == null || 明細番号.isEmpty();
        JigyoshaNo 事業者番号 = parameter.get事業者番号();
        if (サービス年月.isBefore(サービス年月_200604)) {
            ShokanServicePlan200004 entity200004 = 保存_データ_200004(entity200004Result,
                    被保険者番号,
                    サービス年月,
                    事業者番号,
                    様式番号,
                    明細番号,
                    整理番号);
            if (null != entity200004) {
                if (明細番号区分) {
                    entity200004 = entity200004.added();
                } else {
                    entity200004 = entity200004.modified();
                }
                return new ShokanServicePlan200004Result(entity200004, null == entity200004Result ? RString.EMPTY : entity200004Result.getServiceName());
            }
        }
        return null;
    }

    private List<ShokanServicePlan200904Result> 保存_データ_200904(List<dgdYichiran_Row> rowList,
            List<ShokanServicePlan200904Result> entity200904ResultList,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 整理番号) {
        List<ShokanServicePlan200904Result> newEntity200904ResultList = new ArrayList<>();
        for (dgdYichiran_Row row : rowList) {
            if (RowState.Modified.equals(row.getRowState())) {
                ShokanServicePlan200904Result entity200904Result = entity200904ResultList.get(
                        Integer.valueOf(row.getRowNum().toString()));
                ShokanServicePlan200904 entity200904 = 保存_データ(row, entity200904Result.getEntity());
                newEntity200904ResultList.add(new ShokanServicePlan200904Result(entity200904, entity200904Result.getServiceName()));
            } else if (RowState.Added.equals(row.getRowState())) {
                ShokanServicePlan200904 entity200904 = new ShokanServicePlan200904(
                        被保険者番号,
                        サービス年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号,
                        row.getDefaultDataName7());
                newEntity200904ResultList = isView200904_DB存在(entity200904ResultList, entity200904, newEntity200904ResultList, row);
            }
        }
        return newEntity200904ResultList;
    }

    private List<ShokanServicePlan200904Result> isView200904_DB存在(List<ShokanServicePlan200904Result> entity200904ResultList, ShokanServicePlan200904 entity200904,
            List<ShokanServicePlan200904Result> newEntity200904ResultList, dgdYichiran_Row row) {
        boolean isViewDB存在 = false;
        for (ShokanServicePlan200904Result 情報 : entity200904ResultList) {
            if (情報.getEntity().get被保険者番号().equals(entity200904.get被保険者番号())
                    && 情報.getEntity().getサービス提供年月().toDateString().equals(entity200904.getサービス提供年月().toDateString().substring(NUM0, NUM6))
                    && 情報.getEntity().get整理番号().equals(entity200904.get整理番号())
                    && 情報.getEntity().get事業者番号().getColumnValue().equals(entity200904.get事業者番号())
                    && 情報.getEntity().get様式番号().equals(entity200904.get様式番号())
                    && 情報.getEntity().get明細番号().equals(entity200904.get明細番号())
                    && 情報.getEntity().get連番().equals(entity200904.get連番())) {
                isViewDB存在 = true;
                break;
            }
        }
        if (!isViewDB存在) {
            entity200904 = 保存_データ(row, entity200904);
            newEntity200904ResultList.add(new ShokanServicePlan200904Result(entity200904, RString.EMPTY));
        }
        return newEntity200904ResultList;
    }

    private ShokanServicePlan200604 保存_データ_200604(
            ShokanServicePlan200604Result entity200604Result,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 整理番号) {
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiDown()
                .getDdlShiteiJigyoshaKubunCode().getSelectedKey();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().getSelectedKey();
        FlexibleDate 届出日 = get届出日(div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().getValue());
        Decimal 単位数Decimal = div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().getValue();
        int 単位数 = 単位数Decimal == null ? 0 : 単位数Decimal.intValue();
        Decimal 単位数単価 = div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().getValue();
        Decimal 請求金額Decimal = div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().getValue();
        int 請求金額 = 請求金額Decimal == null ? 0 : 請求金額Decimal.intValue();
        RString 担当介護支援専門員番号 = div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().getValue();
        RString 摘要 = div.getPanelServiceKeikakuhiDown().getTxtTekiyo().getValue();
        RStringBuilder サービスコードBuilder = new RStringBuilder();
        RString serviceCode1 = serviceCodeInputDiv.getサービスコード1();
        サービスコードBuilder.append(serviceCode1);
        サービスコードBuilder.append(serviceCodeInputDiv.getサービスコード2());

        if (entity200604Result == null) {
            ShokanServicePlan200604 entity200604 = new ShokanServicePlan200604(
                    被保険者番号,
                    サービス年月,
                    整理番号,
                    事業者番号,
                    様式番号,
                    明細番号,
                    連番_1);
            entity200604 = entity200604.createBuilderForEdit()
                    .set指定_基準該当事業者区分コード(指定_基準該当事業者区分コード)
                    .set審査方法区分コード(審査方法区分コード)
                    .set居宅サービス計画作成依頼届出年月日(届出日)
                    .set単位数(単位数)
                    .set単位数単価(単位数単価)
                    .set請求金額(請求金額)
                    .set担当介護支援専門員番号(担当介護支援専門員番号)
                    .set摘要(摘要)
                    .setサービスコード(new ServiceCode(サービスコードBuilder.toRString())).build().added();
            return entity200604;
        } else {
            ShokanServicePlan200604 entity200604 = entity200604Result.getEntity();
            entity200604 = entity200604.createBuilderForEdit()
                    .set指定_基準該当事業者区分コード(指定_基準該当事業者区分コード)
                    .set審査方法区分コード(審査方法区分コード)
                    .set居宅サービス計画作成依頼届出年月日(届出日)
                    .set単位数(単位数)
                    .set単位数単価(単位数単価)
                    .set請求金額(請求金額)
                    .set担当介護支援専門員番号(担当介護支援専門員番号)
                    .set摘要(摘要)
                    .setサービスコード(new ServiceCode(サービスコードBuilder.toRString())).build().modified();
            return entity200604;
        }
    }

    private ShokanServicePlan200004 保存_データ_200004(
            ShokanServicePlan200004Result entity200004Result,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 整理番号) {
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiDown()
                .getDdlShiteiJigyoshaKubunCode().getSelectedKey();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().getSelectedKey();
        FlexibleDate 届出日 = get届出日(div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().getValue());
        Decimal 単位数Decimal = div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().getValue();
        int 単位数 = 単位数Decimal == null ? 0 : 単位数Decimal.intValue();
        Decimal 単位数単価 = div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().getValue();
        Decimal 請求金額Decimal = div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().getValue();
        int 請求金額 = 請求金額Decimal == null ? 0 : 請求金額Decimal.intValue();
        RStringBuilder サービスコードBuilder = new RStringBuilder();
        RString serviceCode1 = serviceCodeInputDiv.getサービスコード1();
        サービスコードBuilder.append(serviceCode1);
        サービスコードBuilder.append(serviceCodeInputDiv.getサービスコード2());
        if (entity200004Result == null) {
            ShokanServicePlan200004 entity200004 = new ShokanServicePlan200004(
                    被保険者番号,
                    サービス年月,
                    整理番号,
                    事業者番号,
                    様式番号,
                    明細番号,
                    連番_1);
            entity200004 = entity200004.createBuilderForEdit()
                    .set指定_基準該当事業者区分コード(指定_基準該当事業者区分コード)
                    .set審査方法区分コード(審査方法区分コード)
                    .set居宅サービス計画作成依頼届出年月日(届出日)
                    .set単位数(単位数)
                    .set単位数単価(単位数単価)
                    .set請求金額(請求金額)
                    .setサービスコード(new ServiceCode(サービスコードBuilder.toRString())).build().added();
            return entity200004;
        } else {
            ShokanServicePlan200004 entity200004 = entity200004Result.getEntity();
            entity200004 = entity200004.createBuilderForEdit()
                    .set指定_基準該当事業者区分コード(指定_基準該当事業者区分コード)
                    .set審査方法区分コード(審査方法区分コード)
                    .set居宅サービス計画作成依頼届出年月日(届出日)
                    .set単位数(単位数)
                    .set単位数単価(単位数単価)
                    .set請求金額(請求金額)
                    .setサービスコード(new ServiceCode(サービスコードBuilder.toRString())).build().modified();
            return entity200004;
        }
    }

    private FlexibleDate get届出日(RDate date) {
        FlexibleDate 届出日 = null;
        if (date != null) {
            届出日 = new FlexibleDate(date.toString());
        }
        return 届出日;
    }

    private void 登録パネル_グリッド(dgdYichiran_Row row, int maxRenban, boolean is登録) {
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div
                .getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        RStringBuilder サービスコードBuilder = new RStringBuilder();
        RString serviceCode1 = serviceCodeInputDiv.getサービスコード1();
        サービスコードBuilder.append(serviceCode1);
        サービスコードBuilder.append(serviceCodeInputDiv.getサービスコード2());
        RString サービス名称 = serviceCodeInputDiv.getサービス名称();
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
        if (is登録) {
            row.setDefaultDataName7(new RString(maxRenban + 1));
        }
    }

    private ShokanServicePlan200904 保存_データ(dgdYichiran_Row row, ShokanServicePlan200904 entity200904) {
        RowState state = row.getRowState();
        ServiceCode サービスコード = new ServiceCode(row.getDefaultDataName1());
        Decimal 単位数Decimal = row.getDefaultDataName2().getValue();
        int 単位数 = 単位数Decimal == null ? 0 : 単位数Decimal.intValue();
        Decimal 回数Decimal = row.getDefaultDataName3().getValue();
        int 回数 = 回数Decimal == null ? 0 : 回数Decimal.intValue();
        Decimal サービス単位数Decimal = row.getDefaultDataName4().getValue();
        int サービス単位数 = サービス単位数Decimal == null ? 0 : サービス単位数Decimal.intValue();
        RString 摘要 = row.getDefaultDataName5();
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().getSelectedKey();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().getSelectedKey();
        FlexibleDate 届出日 = get届出日(div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().getValue());
        RString 担当介護支援専門員番号 = div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().getValue();
        Decimal 単位数単価Decimal = div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().getValue();
        Decimal 単位数単価 = 単位数単価Decimal == null ? Decimal.ZERO : 単位数単価Decimal;
        Decimal サービス単位数合計Decimal = div.getPanelServiceKeikakuhiUp().getTxtGokeiTanyi().getValue();
        int サービス単位数合計 = サービス単位数合計Decimal == null ? 0 : サービス単位数合計Decimal.intValue();
        Decimal 請求金額Decimal = div.getPanelServiceKeikakuhiUp().getTxtSeikyugaku().getValue();
        int 請求金額 = 請求金額Decimal == null ? 0 : 請求金額Decimal.intValue();
        entity200904 = entity200904.createBuilderForEdit()
                .setサービスコード(サービスコード)
                .set単位数(単位数)
                .set回数(回数)
                .setサービス単位数(サービス単位数)
                .set摘要(摘要)
                .set指定_基準該当事業者区分コード(指定_基準該当事業者区分コード)
                .set審査方法区分コード(審査方法区分コード)
                .set居宅サービス計画作成依頼届出年月日(届出日)
                .set担当介護支援専門員番号(担当介護支援専門員番号)
                .set単位数単価(単位数単価)
                .setサービス単位数合計(サービス単位数合計)
                .set請求金額(請求金額).build();
        if (RowState.Added.equals(state)) {
            entity200904 = entity200904.added();
        } else if (RowState.Deleted.equals(state)) {
            entity200904 = entity200904.deleted();
        } else if (RowState.Modified.equals(state)) {
            entity200904 = entity200904.modified();
        }
        return entity200904;
    }

    private void setサービス計画費共通エリア(ShokanServicePlan200904Result entity200904Result) {
        if (entity200904Result == null) {
            load事業者区分リスト200904();
            div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().clearValue();
            div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().clearValue();
            div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().clearValue();
        } else {
            List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDataSource(事業者区分リスト);
            List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDataSource(審査方法区分リスト);
            FlexibleDate 届出日 = entity200904Result.getEntity().get居宅サービス計画作成依頼届出年月日();
            RString 担当介護支援専門員番号 = entity200904Result.getEntity().get担当介護支援専門員番号();
            Decimal 単位数単価 = entity200904Result.getEntity().get単位数単価();
            RString 事業者区分コード = entity200904Result.getEntity().get指定_基準該当事業者区分コード();
            RString 審査方法区分コード = entity200904Result.getEntity().get審査方法区分コード();
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

    private void setサービス計画費共通エリアdown(dgdYichiran_Row row) {
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
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource(事業者区分BLANK, RString.EMPTY);
        dataSourceList.add(dataSourceBlank);
        List<UzT0007CodeEntity> 事業者区分リスト = CodeMaster.getCode(
                SubGyomuCode.DBC介護給付, DBCCodeShubetsu.指定_基準該当等事業所区分.getコード(), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity 事業者区分 : 事業者区分リスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource(事業者区分.getコード().value(), 事業者区分.getコード名称());
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

    private void setサービス計画費登録エリア() {
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div
                .getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        serviceCodeInputDiv.setサービス項目コード(RString.EMPTY);
        serviceCodeInputDiv.setサービス種類コード(RString.EMPTY);
        serviceCodeInputDiv.setサービス名称(RString.EMPTY);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().clearValue();
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().clearValue();
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().clearValue();
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().clearValue();
    }

    private void setサービス計画費登録エリアdown(dgdYichiran_Row row) {
        RString サービスコード = row.getDefaultDataName1();
        Decimal 単位数 = row.getDefaultDataName2().getValue();
        Decimal 回数 = row.getDefaultDataName3().getValue();
        Decimal サービス単位数 = row.getDefaultDataName4().getValue();
        RString 摘要 = row.getDefaultDataName5();
        RString サービス名称 = row.getDefaultDataName6() == null ? RString.EMPTY : row.getDefaultDataName6();
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div
                .getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        if (サービスコード != null) {
            serviceCodeInputDiv.setサービス種類コード(サービスコード.substring(0, 2));
            serviceCodeInputDiv.setサービス項目コード(サービスコード.substring(サービスコード.length() - サービスコード2));
        }
        serviceCodeInputDiv.setサービス名称(サービス名称);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().setValue(単位数);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().setValue(回数);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().setValue(サービス単位数);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().setValue(摘要);
    }

    private void setサービス計画費共通エリアLoad(List<ShokanServicePlan200904Result> entity200904ResultList, RString 画面モード) {
        ShokanServicePlan200904Result entity200904Result = entity200904ResultList.get(0);
        for (int i = 1; i < entity200904ResultList.size(); i++) {
            if (new Decimal(entity200904Result.getEntity().get連番().toString())
                    .compareTo(new Decimal(entity200904ResultList.get(i).getEntity().get連番().toString())) < 0) {
                entity200904Result = entity200904ResultList.get(i);
            }
        }
        List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
        div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDataSource(事業者区分リスト);
        List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
        div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDataSource(審査方法区分リスト);
        if (!entity200904Result.getEntity().get指定_基準該当事業者区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setSelectedKey(
                    entity200904Result.getEntity().get指定_基準該当事業者区分コード());
        }
        if (!entity200904Result.getEntity().get審査方法区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setSelectedKey(
                    entity200904Result.getEntity().get審査方法区分コード());
        }
        FlexibleDate 届出日 = entity200904Result.getEntity().get居宅サービス計画作成依頼届出年月日();
        if (!届出日.isEmpty()) {
            div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setValue(new RDate(届出日.toString()));
        }
        div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().setValue(
                entity200904Result.getEntity().get担当介護支援専門員番号());
        div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setValue(entity200904Result.getEntity().get単位数単価());
        if (削除モード.equals(画面モード)) {
            div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setDisabled(true);
            div.getPanelServiceKeikakuhiUp().getBtnAdd().setDisabled(true);
        }
    }

    private void setサービス計画費グリッドエリア(List<ShokanServicePlan200904Result> entity200904ResultList, RString 画面モード) {
        List<dgdYichiran_Row> dataSource = new ArrayList<>();
        int i = 0;
        Decimal 単位合計 = Decimal.ZERO;
        for (ShokanServicePlan200904Result entity200904Result : entity200904ResultList) {
            dgdYichiran_Row row = new dgdYichiran_Row();
            row.setRowState(getRowState(entity200904Result));
            row.setRowNum(new RString(String.valueOf(i)));
            row.setDefaultDataName1(new RString(
                    entity200904Result.getEntity().getサービスコード().getColumnValue().toString()));
            row.setDefaultDataName6(entity200904Result.getServiceName());
            row.getDefaultDataName2().setValue(new Decimal(entity200904Result.getEntity().get単位数()));
            row.getDefaultDataName3().setValue(new Decimal(entity200904Result.getEntity().get回数()));
            row.getDefaultDataName4().setValue(new Decimal(entity200904Result.getEntity().getサービス単位数()));
            row.setDefaultDataName5(entity200904Result.getEntity().get摘要());
            row.setDefaultDataName7(entity200904Result.getEntity().get連番());
            row.setDefaultDataName8(entity200904Result.getEntity().get指定_基準該当事業者区分コード());
            row.setDefaultDataName9(entity200904Result.getEntity().get審査方法区分コード());
            FlexibleDate 届出日 = entity200904Result.getEntity().get居宅サービス計画作成依頼届出年月日();
            if (!届出日.isEmpty()) {
                row.getDefaultDataName10().setValue(new RDate(届出日.toString()));
            }
            row.setDefaultDataName11(entity200904Result.getEntity().get担当介護支援専門員番号());
            row.getDefaultDataName12().setValue(entity200904Result.getEntity().get単位数単価());
            i = i + 1;
            単位合計 = 単位合計.add(new Decimal(entity200904Result.getEntity().getサービス単位数()));
            dataSource.add(row);
        }
        Decimal 請求額合計 = 単位合計.multiply(entity200904ResultList.get(0).getEntity().get単位数単価());
        div.getPanelServiceKeikakuhiUp().getTxtGokeiTanyi().setValue(単位合計);
        div.getPanelServiceKeikakuhiUp().getTxtSeikyugaku().setValue(請求額合計);
        Collections.sort(dataSource, COMPARABLE);
        div.getPanelServiceKeikakuhiUp().getDgdYichiran().setDataSource(dataSource);
        if (削除モード.equals(画面モード)) {
            div.getPanelServiceKeikakuhiUp().getDgdYichiran().setReadOnly(true);
        }
    }

    private void setサービス計画費エリア200604(ShokanServicePlan200604Result entity200604Result, RString 画面モード) {
        load事業者区分リスト200904前();
        if (!entity200604Result.getEntity().get指定_基準該当事業者区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setSelectedKey(
                    entity200604Result.getEntity().get指定_基準該当事業者区分コード());
        }
        if (!entity200604Result.getEntity().get居宅サービス計画作成依頼届出年月日().isEmpty()) {
            div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(
                    new RDate(entity200604Result.getEntity().get居宅サービス計画作成依頼届出年月日().toString()));
        }
        if (!entity200604Result.getEntity().get審査方法区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedKey(
                    entity200604Result.getEntity().get審査方法区分コード());
        }
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
        if (entity200604Result.getEntity().getサービスコード().getColumnValue() != null) {
            RString サービスコード = new RString(entity200604Result.getEntity().getサービスコード().getColumnValue().toString());
            serviceCodeInputDiv.setサービス種類コード(サービスコード.substring(0, 2));
            serviceCodeInputDiv.setサービス項目コード(サービスコード.substring(サービスコード.length() - サービスコード2));
            serviceCodeInputDiv.setサービス名称(entity200604Result.getServiceName());
        }
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200604Result.getEntity().get単位数()));
        Decimal 単位数単価 = entity200604Result.getEntity().get単位数単価();
        if (null == 単位数単価) {
            単位数単価 = new Decimal(DbBusinessConfig.get(ConfigNameDBC.初期表示_単位数単価, RDate.getNowDate(), SubGyomuCode.DBC介護給付).toString());
            単位数単価 = 単位数単価.divide(DECIMAL_100);
        }
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(単位数単価);
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200604Result.getEntity().get請求金額()));
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setValue(
                entity200604Result.getEntity().get担当介護支援専門員番号());
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setValue(entity200604Result.getEntity().get摘要());
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

    private void setサービス計画費エリア200004(ShokanServicePlan200004Result entity200004Result, RString 画面モード) {
        load事業者区分リスト200904前();
        if (!entity200004Result.getEntity().get指定_基準該当事業者区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setSelectedKey(
                    entity200004Result.getEntity().get指定_基準該当事業者区分コード());
        }
        if (!entity200004Result.getEntity().get居宅サービス計画作成依頼届出年月日().isEmpty()) {
            div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(
                    new RDate(entity200004Result.getEntity().get居宅サービス計画作成依頼届出年月日().toString()));
        }
        if (!entity200004Result.getEntity().get審査方法区分コード().isNullOrEmpty()) {
            div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedKey(
                    entity200004Result.getEntity().get審査方法区分コード());
        }
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
        if (entity200004Result.getEntity().getサービスコード().getColumnValue() != null) {
            RString サービスコード = new RString(entity200004Result.getEntity().getサービスコード().getColumnValue().toString());
            serviceCodeInputDiv.setサービス種類コード(サービスコード.substring(0, 2));
            serviceCodeInputDiv.setサービス項目コード(サービスコード.substring(サービスコード.length() - サービスコード2));
        }
        serviceCodeInputDiv.setサービス名称(entity200004Result.getServiceName());
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200004Result.getEntity().get単位数()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200004Result.getEntity().get単位数単価());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200004Result.getEntity().get請求金額()));
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

    private void setサービス計画費共通エリアRequired(boolean flag) {
        div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setRequired(flag);
        div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setRequired(flag);
        div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().setRequired(flag);
        div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().setRequired(flag);
    }

    private void setサービス計画費グリッドエリアRequired(boolean flag) {
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().setRequired(flag);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().setRequired(flag);
    }

    private void setサービス計画費Required(boolean flag) {
        div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setRequired(flag);
        div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setRequired(flag);
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setRequired(flag);
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setRequired(flag);
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setRequired(flag);
    }

    private Boolean 変更チェック(dgdYichiran_Row row, List<ShokanServicePlan200904Result> entity200904ResultList) {
        ShokanServicePlan200904Result result = null;
        for (ShokanServicePlan200904Result palnResult : entity200904ResultList) {
            if (row.getDefaultDataName7().equals(palnResult.getEntity().get連番())) {
                result = palnResult;
                break;
            }
        }
        int flag = 0;
        IServiceCodeInputCommonChildDiv serviceCodeInputDiv = div
                .getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getCcdServiceCodeInput();
        RStringBuilder サービスコードBuilder = new RStringBuilder();
        RString serviceCode1 = serviceCodeInputDiv.getサービスコード1();
        サービスコードBuilder.append(serviceCode1);
        サービスコードBuilder.append(serviceCodeInputDiv.getサービスコード2());
        Decimal 単位数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTanyiUp().getValue();
        Decimal 回数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtKaisu().getValue();
        Decimal サービス単位数 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtServiceTanyiSu().getValue();
        RString 摘要 = div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().getTxtTekiyoUp().getValue();
        RString 指定_基準該当事業者区分コード = div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().getSelectedKey();
        RString 審査方法区分コード = div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().getSelectedKey();
        FlexibleDate 届出日 = formatRDateToFlexible(div.getPanelServiceKeikakuhiUp().getTxtTodokedeYMD().getValue());
        RString 担当介護支援専門員番号 = div.getPanelServiceKeikakuhiUp().getTxtTantoKaigoshien().getValue();
        Decimal 単位数単価 = div.getPanelServiceKeikakuhiUp().getTxtTanyiTanka().getValue();
        flag = flag + check(サービスコードBuilder.toRString(), result.getEntity().getサービスコード().value());
        flag = flag + checkDecimal(単位数, new Decimal(result.getEntity().get単位数()));
        flag = flag + checkDecimal(回数, new Decimal(result.getEntity().get回数()));
        flag = flag + checkDecimal(サービス単位数, new Decimal(result.getEntity().getサービス単位数()));
        flag = flag + check(摘要, result.getEntity().get摘要());
        flag = flag + check(指定_基準該当事業者区分コード, result.getEntity().get指定_基準該当事業者区分コード());
        flag = flag + check(審査方法区分コード, result.getEntity().get審査方法区分コード());
        flag = flag + check(届出日, result.getEntity().get居宅サービス計画作成依頼届出年月日());
        flag = flag + check担当介護支援専門員番号(担当介護支援専門員番号, result.getEntity().get担当介護支援専門員番号());
        flag = flag + checkDecimal(単位数単価, result.getEntity().get単位数単価());
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

    private int checkDecimal(Decimal dec1, Decimal dec2) {
        if (dec1 == null && dec2 != null) {
            return 1;
        } else if (dec1 != null) {
            return dec1.compareTo(dec2) == 0 ? 0 : 1;
        }
        return 0;
    }

    private int check担当介護支援専門員番号(RString 番号1, RString 番号2) {
        if (番号1 == null && 番号2 == null) {
            return 0;
        } else if (番号1 != null && 番号2 != null
                && 番号1.padZeroToLeft(担当介護支援専門員番号LENGTH)
                .equals(番号2.padZeroToLeft(担当介護支援専門員番号LENGTH))) {
            return 0;
        }
        return 1;
    }

    private int checkInt(int int1, int int2) {
        return int1 == int2 ? 0 : 1;
    }

    /**
     * 審査方法区分と事業者区分の初期化200904
     */
    public void load事業者区分リスト200904() {
        List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
        div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setDataSource(事業者区分リスト);
        div.getPanelServiceKeikakuhiUp().getDdlJigyoshaKubun().setSelectedIndex(0);
        List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
        div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setDataSource(審査方法区分リスト);
        div.getPanelServiceKeikakuhiUp().getRdoShinsahouhou().setSelectedIndex(0);
    }

    /**
     * 審査方法区分と事業者区分の初期化200904前
     */
    public void load事業者区分リスト200904前() {
        List<KeyValueDataSource> 事業者区分リスト = get事業者区分リスト();
        div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setDataSource(事業者区分リスト);
        div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setSelectedIndex(0);
        List<KeyValueDataSource> 審査方法区分リスト = get審査方法リスト();
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setDataSource(審査方法区分リスト);
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedIndex(0);
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
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
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
        if (設定不可.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
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

    private RowState getRowState(ShokanServicePlan200904Result entity200904Result) {
        if (EntityDataState.Added.equals(entity200904Result.getEntity().toEntity().getState())) {
            return RowState.Added;
        } else if (EntityDataState.Modified.equals(entity200904Result.getEntity().toEntity().getState())) {
            return RowState.Modified;
        }
        return RowState.Unchanged;
    }

}
