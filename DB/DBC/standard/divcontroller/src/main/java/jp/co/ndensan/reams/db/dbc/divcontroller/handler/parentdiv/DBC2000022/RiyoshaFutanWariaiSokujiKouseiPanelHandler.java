/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.FutanWariaiSokujiKouseiHolder;
import jp.co.ndensan.reams.db.dbc.business.core.futanwariai.FutanWariaiSokujiKouseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerResult;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho.FutanWariaiShoDivParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.futanwariai.FutanWariaiHakkoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.futanwariai.FutanWariaiHanteiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.futanwariai.FutanWariaiShikakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariai.FutanWariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.DBC2000022PanelAllDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.DBC2000022StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.dgFutanWariai_Row;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariai.RiyoshaFutanWariaiSokujiKouseiFinder;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariai.RiyoshaFutanWariaiSokujiKouseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariaisho.FutanWariaisho;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiKonkyo;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisaiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuBuilder;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoKofuKaishuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_修正のHandlerです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class RiyoshaFutanWariaiSokujiKouseiPanelHandler {

    private final DBC2000022PanelAllDiv div;
    private final RiyoshaFutanWariaiSokujiKouseiManager manager;
    private final RiyoshaFutanWariaiSokujiKouseiFinder finder;

    private static final RString RSTZERO = new RString("0");
    private static final RString RSTONE = new RString("1");
    private static final RString RSTTWO = new RString("2");
    private static final RString CODE = new RString("0003");
    private static final RString 交付証種類 = new RString("003");
    private static final RString 負担割合証交付事由 = new RString("0016");
    private static final RString 職権変更 = new RString("職権変更");
    private static final RString 証発行不要 = new RString("証発行不要");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 前排他キー = new RString("DBCHihokenshaNo");
    private static final RString 負担割合証を印刷する = new RString("btnPrint");
    private static final RString 保存する = new RString("btnUpdate");

    /**
     * 利用者負担割合即時更正_修正のコンストラクタです。
     *
     * @param div DBC2000022PanelAllDiv
     */
    public RiyoshaFutanWariaiSokujiKouseiPanelHandler(DBC2000022PanelAllDiv div) {
        this.div = div;
        this.manager = RiyoshaFutanWariaiSokujiKouseiManager.createInstance();
        this.finder = RiyoshaFutanWariaiSokujiKouseiFinder.createInstance();
    }

    /**
     * 新規画面の初期化処理です。
     *
     * @param 確認結果 RiyoshaFutanWariaiHanteiManagerResult
     * @param 資格対象者 TaishoshaKey
     */
    public void shinkiInitialize(RiyoshaFutanWariaiHanteiManagerResult 確認結果, TaishoshaKey 資格対象者) {
        set共通部品初期化処理(資格対象者);
        setヘッダ項目(new RiyoshaFutanWariai(確認結果.get利用者負担割合entity()), RSTZERO, 確認結果.get年度());
        List<RiyoshaFutanWariaiMeisai> entityList = new ArrayList<>();
        for (int i = 0; i < 確認結果.get利用者負担割合明細list().size(); i++) {
            entityList.add(new RiyoshaFutanWariaiMeisai(確認結果.get利用者負担割合明細list().get(i)));
        }
        if (!entityList.isEmpty()) {
            List<dgFutanWariai_Row> rowsData = new ArrayList<>();
            for (RiyoshaFutanWariaiMeisai entity : entityList) {
                rowsData.add(getDataGridRow(entity, RSTZERO));
            }
            div.getDgFutanWariai().setDataSource(rowsData);
        } else {
            throw new ApplicationException(DbcErrorMessages.該当年度負担割合情報なし.getMessage());
        }
        set補足項目(new RiyoshaFutanWariai(確認結果.get利用者負担割合entity()), new RDate(確認結果.get基準日().toString()), RSTZERO);
        set初期化状態設定(RSTZERO);
    }

    /**
     * 修正画面の初期化処理です。
     *
     * @param 資格対象者 TaishoshaKey
     * @param 年度 FlexibleYear
     * @return 利用者負担割合情報
     */
    public FutanWariaiSokujiKouseiResult shuseiInitialize(TaishoshaKey 資格対象者, FlexibleYear 年度) {
        set共通部品初期化処理(資格対象者);
        FutanWariaiSokujiKouseiResult 利用者負担割合情報 = get利用者負担割合情報(資格対象者, 年度, RSTONE);
        setヘッダ項目(new RiyoshaFutanWariai(利用者負担割合情報.toEntity()), RSTONE, 年度);
        set編集項目();
        set初期化状態設定(RSTONE);
        return 利用者負担割合情報;
    }

    /**
     * 照会画面の初期化処理です。
     *
     * @param 資格対象者 TaishoshaKey
     * @param 年度 FlexibleYear
     * @return 利用者負担割合情報
     */
    public FutanWariaiSokujiKouseiResult shokaiInitialize(TaishoshaKey 資格対象者, FlexibleYear 年度) {
        set共通部品初期化処理(資格対象者);
        FutanWariaiSokujiKouseiResult 利用者負担割合情報 = get利用者負担割合情報(資格対象者, 年度, RSTTWO);
        setヘッダ項目(new RiyoshaFutanWariai(利用者負担割合情報.toEntity()), RSTTWO, 年度);
        set初期化状態設定(RSTTWO);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(負担割合証を印刷する, true);
        if (利用者負担割合情報.get利用者負担割合明細list() != null && !利用者負担割合情報.get利用者負担割合明細list().isEmpty()) {
            for (RiyoshaFutanWariaiMeisai result : 利用者負担割合情報.get利用者負担割合明細list()) {
                if (!result.get論理削除フラグ()) {
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(負担割合証を印刷する, false);
                    break;
                }
            }
        }

        return 利用者負担割合情報;
    }

    private void set共通部品初期化処理(TaishoshaKey 資格対象者) {
        div.getCcdKaigoAtenaInfo().initialize(資格対象者.get識別コード());
        div.getCcdKaigoShikakuKihon().initialize(資格対象者.get識別コード());
        AccessLogger.log(AccessLogType.照会, toPersonalData(資格対象者.get識別コード(), 資格対象者.get被保険者番号().getColumnValue()));
        LockingKey key = new LockingKey(前排他キー.concat(資格対象者.get被保険者番号().getColumnValue()));
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        } else {
            div.setDisabled(false);
        }
    }

    private void setヘッダ項目(RiyoshaFutanWariai 利用者負担割合, RString 処理区分, FlexibleYear 年度) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        if (RSTZERO.equals(処理区分)) {
            dataSourceList.add(new KeyValueDataSource(new RString(年度.getYearValue()),
                    年度.wareki().toDateString()));
        } else {
            List<RiyoshaFutanWariai> 利用者負担割合list = manager.selectBy年度と被保険者番号(年度, 利用者負担割合.get被保険者番号());
            for (RiyoshaFutanWariai result : 利用者負担割合list) {
                dataSourceList.add(new KeyValueDataSource(new RString(result.get年度().getYearValue()),
                        result.get年度().wareki().toDateString()));
            }
        }
        div.getDdlNendo().setDataSource(dataSourceList);
        div.getDdlNendo().setSelectedKey(new RString(年度.getYearValue()));
        if (RSTZERO.equals(処理区分) || RSTONE.equals(処理区分)) {
            div.getTxtHanteibi().setValue(RDate.getNowDate());
            div.getTxtHanteiKubun().setValue(FutanWariaiHanteiKubun.即時更正.get名称());
        }
        if (RSTTWO.equals(処理区分)) {
            FutanWariaiMybatisParameter mybatisParameter = new FutanWariaiMybatisParameter();
            mybatisParameter.set年度(div.getDdlNendo().getSelectedKey());
            mybatisParameter.set被保険者番号(div.getCcdKaigoShikakuKihon().get被保険者番号());
            List<RString> 履歴番号list = finder.get履歴番号BY年度(null);
            List<KeyValueDataSource> ddl履歴番号List = new ArrayList<>();
            if (履歴番号list != null && !履歴番号list.isEmpty()) {
                for (RString 履歴番号 : 履歴番号list) {
                    ddl履歴番号List.add(new KeyValueDataSource(履歴番号, 履歴番号));
                }
            }
            div.getDdlRirekiNo().setDataSource(ddl履歴番号List);
            div.getDdlRirekiNo().setSelectedKey(new RString(利用者負担割合.get履歴番号()));
            FlexibleDate 判定日 = 利用者負担割合.get判定日();
            if (判定日 != null) {
                div.getTxtHanteibi().setValue(new RDate(判定日.toString()));
            }
            div.getTxtHanteiKubun().setValue(FutanWariaiHanteiKubun.toValue(利用者負担割合.get判定区分()).get名称());
        }
    }

    private void set編集項目() {
        set資格DropDownList();
        set負担割合DropDownList();
    }

    private void set初期化状態設定(RString 処理区分) {
        if (RSTZERO.equals(処理区分)) {
            div.getDdlNendo().setDisabled(true);
            div.getDdlRirekiNo().setDisplayNone(true);
            div.getBtnHyoji().setDisplayNone(true);
            div.getBtnClear().setDisplayNone(true);
            div.getTxtHanteibi().setDisabled(true);
            div.getTxtHanteiKubun().setDisabled(true);
            div.getDgFutanWariai().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgFutanWariai().getGridSetting().setIsShowRowState(false);
            div.getBtnAddBefore().setDisplayNone(true);
            div.getBtnAddNext().setDisplayNone(true);
            div.getBtnEdit().setDisplayNone(true);
            div.getPanelEdit().setDisplayNone(true);
            div.getChkShoHakkoFuyo().setDisabled(true);
            div.getDdlHakkoKubun().setDisabled(true);
            div.getTxtKijunbi().setDisabled(true);
            div.getTxtHakkobi().setDisplayNone(true);
            div.getTxtKofubi().setDisplayNone(true);
        }
        if (RSTONE.equals(処理区分)) {
            div.getDdlNendo().setDisabled(true);
            div.getDdlRirekiNo().setDisplayNone(true);
            div.getBtnHyoji().setDisabled(true);
            div.getTxtHanteibi().setDisabled(true);
            div.getTxtHanteiKubun().setDisabled(true);
            div.getPanelEdit().getDdlShikaku().setDisabled(true);
            div.getPanelEdit().getDdlFutanWariai().setDisabled(true);
            div.getPanelEdit().getTxtTekiyoKaishibi().setDisabled(true);
            div.getPanelEdit().getTxtTekiyoShuryobi().setDisabled(true);
            div.getPanelEdit().getTxtHonninGokeiShotoku().setDisabled(true);
            div.getPanelEdit().getTxtSetaiinsu().setDisabled(true);
            div.getPanelEdit().getTxtNenkinShunyuGokei().setDisabled(true);
            div.getPanelEdit().getTxtSonotaGokei().setDisabled(true);
            div.getPanelEdit().getTxtBiko().setDisabled(true);
            div.getPanelEdit().getBtnCancel().setDisabled(true);
            div.getPanelEdit().getBtnKakutei().setDisabled(true);
            div.getChkShokkenHenko().setDisabled(true);
            div.getTxtKijunbi().setDisplayNone(true);
            div.getTxtHakkobi().setDisplayNone(true);
            div.getTxtKofubi().setDisplayNone(true);

        }
        if (RSTTWO.equals(処理区分)) {
            div.getDdlNendo().setDisabled(true);
            div.getDdlRirekiNo().setDisabled(true);
            div.getBtnHyoji().setDisabled(true);
            div.getTxtHanteibi().setDisabled(true);
            div.getTxtHanteiKubun().setDisabled(true);
            div.getDgFutanWariai().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getDgFutanWariai().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgFutanWariai().getGridSetting().setIsShowRowState(false);
            div.getBtnAddBefore().setDisplayNone(true);
            div.getBtnAddNext().setDisplayNone(true);
            div.getBtnEdit().setDisplayNone(true);
            div.getPanelEdit().setDisplayNone(true);
            div.getChkShokkenHenko().setDisabled(true);
            div.getChkShoHakkoFuyo().setDisabled(true);
            div.getDdlHakkoKubun().setDisabled(true);
            div.getTxtKijunbi().setDisplayNone(true);
        }
    }

    private FutanWariaiSokujiKouseiResult get利用者負担割合情報(TaishoshaKey 資格対象者, FlexibleYear 年度, RString 処理区分) {
        div.getDgFutanWariai().init();
        FutanWariaiMybatisParameter mybatisParameter = new FutanWariaiMybatisParameter();
        mybatisParameter.set年度(年度.toDateString());
        mybatisParameter.set被保険者番号(資格対象者.get被保険者番号().getColumnValue());
        if (RSTTWO.equals(処理区分)) {
            RiyoshaFutanWariai maxRirekiEntity = manager.selectMax履歴番号(年度, 資格対象者.get被保険者番号());
            mybatisParameter.set履歴番号(maxRirekiEntity.get履歴番号());
        }
        mybatisParameter.setFlag(処理区分);
        FutanWariaiSokujiKouseiResult 利用者負担割合情報 = finder.get利用者負担割合情報(mybatisParameter);
        if (利用者負担割合情報 != null) {
            List<dgFutanWariai_Row> rowsData = new ArrayList<>();
            for (RiyoshaFutanWariaiMeisai 利用者負担割合明細 : 利用者負担割合情報.get利用者負担割合明細list()) {
                rowsData.add(getDataGridRow(利用者負担割合明細, 処理区分));
            }
            div.getDgFutanWariai().setDataSource(rowsData);
            set補足項目(new RiyoshaFutanWariai(利用者負担割合情報.toEntity()), null, 処理区分);
        } else {
            if (利用者負担割合情報 != null) {
                setヘッダ項目(new RiyoshaFutanWariai(利用者負担割合情報.toEntity()), RSTTWO, 年度);
            }
            throw new ApplicationException(DbcErrorMessages.該当年度負担割合情報なし.getMessage());
        }

        return 利用者負担割合情報;
    }

    private dgFutanWariai_Row getDataGridRow(RiyoshaFutanWariaiMeisai 利用者負担割合明細, RString 処理区分) {
        dgFutanWariai_Row rowData = new dgFutanWariai_Row();
        rowData.setNendo(利用者負担割合明細.get年度().toDateString());
        rowData.setRirekiNo(new RString(利用者負担割合明細.get履歴番号()));
        rowData.setEdaNo(new RString(利用者負担割合明細.get枝番号()));
        rowData.setShikakuCode(利用者負担割合明細.get資格区分());
        rowData.setFutanWariaiCode(利用者負担割合明細.get負担割合区分());
        rowData.setShikaku(FutanWariaiShikakuKubun.toValue(利用者負担割合明細.get資格区分()).get名称());
        rowData.setFutanWariai(FutanwariaiKubun.toValue(利用者負担割合明細.get負担割合区分()).get名称());
        FlexibleDate 適用開始日 = 利用者負担割合明細.get有効開始日();
        FlexibleDate 適用終了日 = 利用者負担割合明細.get有効終了日();
        if (適用開始日 != null) {
            rowData.getTekiyoKaishibi().setValue(new RDate(適用開始日.toString()));
        }
        if (適用終了日 != null) {
            rowData.getTekiyoShuryobi().setValue(new RDate(適用終了日.toString()));
        }
        rowData.getGokeiShotoku().setValue(利用者負担割合明細.get本人合計所得金額());
        rowData.getSetaiinsu().setValue(Decimal.valueOf(利用者負担割合明細.get世帯１号被保険者数()));
        rowData.getNenkinShunyuGokei().setValue(利用者負担割合明細.get年金収入合計());
        rowData.getSonotaGokeiShotoku().setValue(利用者負担割合明細.getその他の合計所得金額合計());
        rowData.setBiko(利用者負担割合明細.get更正理由());
        rowData.setLogicalDeletedFlag(利用者負担割合明細.get論理削除フラグ());
        if (RSTONE.equals(処理区分) || RSTTWO.equals(処理区分)) {
            if (利用者負担割合明細.get論理削除フラグ()) {
                rowData.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
            }
        }
        return rowData;
    }

    /**
     * クリア処理です。
     *
     * @param 処理モード RString
     */
    public void clear(RString 処理モード) {
        if (DBC2000022StateName.修正.getName().equals(処理モード)) {
            div.getDgFutanWariai().getDataSource().clear();
            div.getTxtBiko().clearValue();
            div.getTxtBiko().setDisabled(true);
            div.getChkShoHakkoFuyo().setSelectedItemsByKey(new ArrayList<RString>());
            div.getDdlNendo().setDisabled(false);
            div.getBtnHyoji().setDisabled(false);
            div.getBtnAddBefore().setDisabled(true);
            div.getBtnAddNext().setDisabled(true);
            div.getBtnEdit().setDisabled(true);
            div.getDdlShikaku().setSelectedIndex(0);
            div.getDdlShikaku().setDisabled(true);
            div.getDdlFutanWariai().setSelectedIndex(0);
            div.getDdlFutanWariai().setDisabled(true);
            div.getTxtTekiyoKaishibi().clearValue();
            div.getTxtTekiyoKaishibi().setDisabled(true);
            div.getTxtTekiyoShuryobi().clearValue();
            div.getTxtTekiyoShuryobi().setDisabled(true);
            div.getTxtHonninGokeiShotoku().clearValue();
            div.getTxtHonninGokeiShotoku().setDisabled(true);
            div.getTxtSetaiinsu().clearValue();
            div.getTxtSetaiinsu().setDisabled(true);
            div.getTxtNenkinShunyuGokei().clearValue();
            div.getTxtNenkinShunyuGokei().setDisabled(true);
            div.getTxtSonotaGokei().clearValue();
            div.getTxtSonotaGokei().setDisabled(true);
            div.getBtnCancel().setDisabled(true);
            div.getBtnKakutei().setDisabled(true);
            div.getDdlHakkoKubun().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
        }
        if (DBC2000022StateName.照会.getName().equals(処理モード)) {
            div.getDgFutanWariai().getDataSource().clear();
            div.getTxtHakkobi().clearValue();
            div.getTxtKofubi().clearValue();
            div.getDdlNendo().setDisabled(false);
            div.getDdlRirekiNo().setDisabled(false);
            div.getBtnHyoji().setDisabled(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(負担割合証を印刷する, true);
        }
    }

    /**
     * 年度のonChange処理です。
     */
    public void nendoChange() {
        FutanWariaiMybatisParameter mybatisParameter = new FutanWariaiMybatisParameter();
        mybatisParameter.set年度(div.getDdlNendo().getSelectedKey());
        mybatisParameter.set被保険者番号(div.getCcdKaigoShikakuKihon().get被保険者番号());
        List<RiyoshaFutanWariai> 利用者負担割合List = finder.get利用者負担割合BY年度と被保険者番号(mybatisParameter);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (RiyoshaFutanWariai 利用者負担割合 : 利用者負担割合List) {
            dataSourceList.add(new KeyValueDataSource(new RString(利用者負担割合.get履歴番号()),
                    new RString(利用者負担割合.get履歴番号())));
        }
        div.getDdlRirekiNo().setDataSource(dataSourceList);
        div.getDdlRirekiNo().setSelectedIndex(0);
    }

    /**
     * 「表示する」ボタンの処理です。
     *
     * @param 処理モード RString
     * @return 利用者負担割合情報 FutanWariaiSokujiKouseiResult
     */
    public FutanWariaiSokujiKouseiResult onClick_Hyoji(RString 処理モード) {
        FutanWariaiSokujiKouseiResult 利用者負担割合情報 = new FutanWariaiSokujiKouseiResult();
        if (DBC2000022StateName.修正.getName().equals(処理モード)) {
            利用者負担割合情報 = setDataGridInfo(RSTONE);
            div.getDdlHakkoKubun().setDisabled(false);
        }
        if (DBC2000022StateName.照会.getName().equals(処理モード)) {
            利用者負担割合情報 = setDataGridInfo(RSTTWO);
        }
        div.getBtnAddBefore().setDisabled(false);
        div.getBtnAddNext().setDisabled(false);
        div.getBtnEdit().setDisabled(false);

        return 利用者負担割合情報;
    }

    /**
     * 【上に追加する】ボタンの処理です。
     *
     * @param 利用者負担割合 RiyoshaFutanWariai
     * @param 枝番 int
     */
    public void onClick_上に追加する(RiyoshaFutanWariai 利用者負担割合, int 枝番) {
        List<dgFutanWariai_Row> rowsData = div.getDgFutanWariai().getDataSource();
        int rowIndex = div.getDgFutanWariai().getClickedRowId();
        dgFutanWariai_Row newRowData = new dgFutanWariai_Row();
        newRowData.setNendo(利用者負担割合.get年度().toDateString());
        newRowData.setRirekiNo(new RString(利用者負担割合.get履歴番号()));
        newRowData.setEdaNo(new RString(枝番));
        newRowData.setLogicalDeletedFlag(false);
        newRowData.setRowState(RowState.Added);
        rowsData.add(rowIndex, newRowData);
        div.getDgFutanWariai().setDataSource(rowsData);
    }

    /**
     * 【下に追加する】ボタンの処理です。
     *
     * @param 利用者負担割合 RiyoshaFutanWariai
     * @param 枝番 int
     */
    public void onClick_下に追加する(RiyoshaFutanWariai 利用者負担割合, int 枝番) {
        List<dgFutanWariai_Row> rowsData = div.getDgFutanWariai().getDataSource();
        int rowIndex = div.getDgFutanWariai().getClickedRowId();
        dgFutanWariai_Row newRowData = new dgFutanWariai_Row();
        newRowData.setNendo(利用者負担割合.get年度().toDateString());
        newRowData.setRirekiNo(new RString(利用者負担割合.get履歴番号()));
        newRowData.setEdaNo(new RString(枝番));
        newRowData.setLogicalDeletedFlag(false);
        newRowData.setRowState(RowState.Added);
        if (rowIndex == div.getDgFutanWariai().getDataSource().size() - 1) {
            rowsData.add(newRowData);
        } else {
            rowsData.add(rowIndex, newRowData);
        }
        div.getDgFutanWariai().setDataSource(rowsData);
    }

    /**
     * 「修正する」ボタンの処理です。
     */
    public void onClick_btnEdit() {
        dgFutanWariai_Row rowData = div.getDgFutanWariai().getClickedItem();
        if (rowData != null) {
            if (rowData.getShikakuCode() != null && !RString.isNullOrEmpty(rowData.getShikakuCode())) {
                div.getDdlShikaku().setSelectedKey(rowData.getShikakuCode());
            }
            if (rowData.getFutanWariaiCode() != null && !RString.isNullOrEmpty(rowData.getFutanWariaiCode())) {
                div.getDdlFutanWariai().setSelectedKey(rowData.getFutanWariaiCode());
            }
            div.getTxtTekiyoKaishibi().setValue(rowData.getTekiyoKaishibi().getValue());
            div.getTxtTekiyoShuryobi().setValue(rowData.getTekiyoShuryobi().getValue());
            div.getTxtHonninGokeiShotoku().setValue(rowData.getGokeiShotoku().getValue());
            div.getTxtSetaiinsu().setValue(rowData.getSetaiinsu().getValue());
            div.getTxtNenkinShunyuGokei().setValue(rowData.getNenkinShunyuGokei().getValue());
            div.getTxtSonotaGokei().setValue(rowData.getSonotaGokeiShotoku().getValue());
            div.getTxtBiko().setValue(rowData.getBiko());
            div.getPanelEdit().setDisabled(false);
            div.getDdlShikaku().setDisabled(false);
            div.getDdlFutanWariai().setDisabled(false);
            div.getTxtTekiyoKaishibi().setDisabled(false);
            div.getTxtTekiyoShuryobi().setDisabled(false);
            div.getTxtHonninGokeiShotoku().setDisabled(false);
            div.getTxtSetaiinsu().setDisabled(false);
            div.getTxtNenkinShunyuGokei().setDisabled(false);
            div.getTxtSonotaGokei().setDisabled(false);
            div.getTxtBiko().setDisabled(false);
            div.getBtnCancel().setDisabled(false);
            div.getBtnKakutei().setDisabled(false);
        } else {
            throw new ApplicationException(UrErrorMessages.対象行を選択.getMessage());
        }
    }

    /**
     * 「取消する」ボタンの処理です。
     */
    public void onClick_btnCancel() {
        編集項目をクリアする();
    }

    /**
     * 「取消する」ボタンの処理です。
     *
     * @param 利用者負担割合 RiyoshaFutanWariai
     */
    public void onClick_btnKakutei(RiyoshaFutanWariai 利用者負担割合) {
        div.getDgFutanWariai().getClickedItem().setShikakuCode(div.getDdlShikaku().getSelectedKey());
        div.getDgFutanWariai().getClickedItem().setFutanWariaiCode(div.getDdlFutanWariai().getSelectedKey());
        div.getDgFutanWariai().getClickedItem().setShikaku(div.getDdlShikaku().getSelectedValue());
        div.getDgFutanWariai().getClickedItem().setFutanWariai(div.getDdlFutanWariai().getSelectedValue());
        div.getDgFutanWariai().getClickedItem().getTekiyoKaishibi().setValue(div.getTxtTekiyoKaishibi().getValue());
        div.getDgFutanWariai().getClickedItem().getTekiyoShuryobi().setValue(div.getTxtTekiyoShuryobi().getValue());
        div.getDgFutanWariai().getClickedItem().getGokeiShotoku().setValue(div.getTxtHonninGokeiShotoku().getValue());
        div.getDgFutanWariai().getClickedItem().getSetaiinsu().setValue(div.getTxtSetaiinsu().getValue());
        div.getDgFutanWariai().getClickedItem().getNenkinShunyuGokei().setValue(div.getTxtNenkinShunyuGokei().getValue());
        div.getDgFutanWariai().getClickedItem().getSonotaGokeiShotoku().setValue(div.getTxtSonotaGokei().getValue());
        div.getDgFutanWariai().getClickedItem().setBiko(div.getTxtBiko().getValue());
        if (!RowState.Added.equals(div.getDgFutanWariai().getClickedItem().getRowState())) {
            div.getDgFutanWariai().getClickedItem().setRowState(RowState.Modified);
        }
    }

    /**
     * 「保存する」ボタンの処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 利用者負担割合 RiyoshaFutanWariai
     * @param 利用者負担割合明細list List<RiyoshaFutanWariaiMeisai>
     * @param 利用者負担割合根拠list List<RiyoshaFutanWariaiKonkyo>
     */
    public void onClick_btnUpdate(ShikibetsuCode 識別コード,
            RiyoshaFutanWariai 利用者負担割合,
            List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細list,
            List<RiyoshaFutanWariaiKonkyo> 利用者負担割合根拠list) {
        manager.save(利用者負担割合,
                利用者負担割合明細list,
                利用者負担割合根拠list);
        AccessLogger.log(AccessLogType.更新, toPersonalData(識別コード, 利用者負担割合.get被保険者番号().getColumnValue()));
        前排他キーの解除(利用者負担割合.get被保険者番号().getColumnValue());
    }

    /**
     * 「負担割合証を印刷する」ボタンの処理です。
     *
     * @param 資格対象者 TaishoshaKey
     * @param 利用者負担割合明細 List<RiyoshaFutanWariaiMeisai>
     */
    public void onClick_btnPrint(TaishoshaKey 資格対象者, List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細) {
        FutanWariaisho futanWariaisho = FutanWariaisho.createInstance();
        FutanWariaiShoDivParameter parameter = new FutanWariaiShoDivParameter();
        parameter.setカナ氏名(div.getCcdKaigoAtenaInfo().get氏名カナ());
        parameter.set住所(div.getCcdKaigoAtenaInfo().get住所().getColumnValue());
        parameter.set氏名(div.getCcdKaigoAtenaInfo().get氏名漢字());
        parameter.set生年月日(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getShokaiData().getTxtSeinengappiYMD().getValue());
        parameter.set性別(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getShokaiData().getTxtSeibetsu().getValue());
//        futanWariaisho.getSourceData(資格対象者.get識別コード(), 資格対象者.get被保険者番号(), parameter, RSTTWO);
    }

    /**
     * 編集項目をクリアします。
     */
    public void 編集項目をクリアする() {
        div.getDdlShikaku().setSelectedIndex(0);
        div.getDdlFutanWariai().setSelectedIndex(0);
        div.getTxtTekiyoKaishibi().clearValue();
        div.getTxtTekiyoShuryobi().clearValue();
        div.getTxtHonninGokeiShotoku().clearValue();
        div.getTxtSetaiinsu().clearValue();
        div.getTxtNenkinShunyuGokei().clearValue();
        div.getTxtSonotaGokei().clearValue();
        div.getTxtBiko().clearValue();
        div.getPanelEdit().setDisabled(true);
    }

    /**
     * 利用者負担割合を設定します。
     *
     * @param 利用者負担割合 RiyoshaFutanWariai
     */
    public void 利用者負担割合編集(RiyoshaFutanWariai 利用者負担割合) {
        RiyoshaFutanWariaiBuilder 利用者負担割合builder = 利用者負担割合.createBuilderForEdit();
        利用者負担割合builder.set発行区分(div.getDdlHakkoKubun().getSelectedKey());
        利用者負担割合builder.set発行日(new FlexibleDate(div.getTxtHanteibi().getValue().toString()));
        利用者負担割合builder.set交付日(new FlexibleDate(div.getTxtKofubi().getValue().toString()));
        利用者負担割合builder.set論理削除フラグ(true);
        利用者負担割合 = 利用者負担割合builder.build();
        利用者負担割合.toEntity().setState(EntityDataState.Modified);
    }

    /**
     * 証交付回収情報を保存します。
     *
     * @param 利用者負担割合 RiyoshaFutanWariai
     */
    public void insert証交付回収(RiyoshaFutanWariai 利用者負担割合) {
        ShoKofuKaishuManager 証交付回収manager = new ShoKofuKaishuManager();
        ShoKofuKaishu max履歴番号証交付回収entity = 証交付回収manager.get証交付回収(利用者負担割合.get被保険者番号(), 交付証種類);
        ShoKofuKaishu new証交付回収 = new ShoKofuKaishu(
                new HihokenshaNo(div.getCcdKaigoShikakuKihon().get被保険者番号()),
                交付証種類,
                max履歴番号証交付回収entity.get履歴番号() + 1);
        ShoKofuKaishuBuilder 証交付回収builder = new証交付回収.createBuilderForEdit();
        証交付回収builder.set市町村コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード());
        証交付回収builder.set識別コード(
                new ShikibetsuCode(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getHdnTxtShikibetsuCode()));
        証交付回収builder.set交付年月日(new FlexibleDate(div.getTxtKofubi().getValue().toString()));
        List<dgFutanWariai_Row> list = div.getDgFutanWariai().getDataSource();
        証交付回収builder.set有効期限(new FlexibleDate(list.get(list.size() - 1).getTekiyoShuryobi().getValue().toString()));
        RString 交付事由 = div.getDdlKofuJiyu().getSelectedKey();
        if (交付事由 != null) {
            証交付回収builder.set交付事由(交付事由);
        }
        証交付回収builder.set単票発行有無フラグ(true);
        証交付回収builder.set発行処理日時(YMDHMS.now());
        証交付回収builder.set論理削除フラグ(false);
        new証交付回収 = 証交付回収builder.build();
        new証交付回収.toEntity().setState(EntityDataState.Added);
        ShoKofuKaishuManager manage = new ShoKofuKaishuManager();
        manage.save証交付回収(new証交付回収);
    }

    /**
     * 利用者負担割合情報を設定します。
     *
     * @param 利用者負担割合 RiyoshaFutanWariai
     * @param holder FutanWariaiSokujiKouseiHolder
     */
    public void kakuteiShori(RiyoshaFutanWariai 利用者負担割合, FutanWariaiSokujiKouseiHolder holder) {
        RiyoshaFutanWariaiMeisai 明細entity = holder.getRiyoshaFutanWariaiMeisai(
                new RiyoshaFutanWariaiMeisaiIdentifier(利用者負担割合.get年度(),
                        利用者負担割合.get被保険者番号(),
                        利用者負担割合.get履歴番号(),
                        Integer.parseInt(div.getDgFutanWariai().getClickedItem().getEdaNo().toString())));
        if (明細entity != null) {
            RiyoshaFutanWariaiMeisaiBuilder builderModified = 明細entity.createBuilderForEdit();
            builderModified.set資格区分(div.getDdlShikaku().getSelectedKey());
            builderModified.set負担割合区分(div.getDdlFutanWariai().getSelectedKey());
            builderModified.set有効開始日(new FlexibleDate(div.getTxtTekiyoKaishibi().getValue().toDateString()));
            builderModified.set有効終了日(new FlexibleDate(div.getTxtTekiyoShuryobi().getValue().toDateString()));
            builderModified.set本人合計所得金額(div.getTxtHonninGokeiShotoku().getValue());
            builderModified.set世帯１号被保険者数(div.getTxtSetaiinsu().getValue().intValue());
            builderModified.set年金収入合計(div.getTxtNenkinShunyuGokei().getValue());
            builderModified.setその他の合計所得金額合計(div.getTxtSonotaGokei().getValue());
            builderModified.set更正理由(div.getTxtBiko().getValue());
            builderModified.set世帯コード(new SetaiCode(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getHdnTxtSetaiCode()));
            明細entity = builderModified.build();
            明細entity.toEntity().setState(EntityDataState.Modified);
            holder.addRiyoshaFutanWariaiMeisai(明細entity);
        } else {
            RiyoshaFutanWariaiMeisai new利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(利用者負担割合.get年度(),
                    利用者負担割合.get被保険者番号(),
                    利用者負担割合.get履歴番号(),
                    Integer.parseInt(div.getDgFutanWariai().getClickedItem().getEdaNo().toString()));
            RiyoshaFutanWariaiMeisaiBuilder builder = new利用者負担割合明細.createBuilderForEdit();
            builder.set資格区分(div.getDdlShikaku().getSelectedKey());
            builder.set負担割合区分(div.getDdlFutanWariai().getSelectedKey());
            builder.set有効開始日(new FlexibleDate(div.getTxtTekiyoKaishibi().getValue().toDateString()));
            builder.set有効終了日(new FlexibleDate(div.getTxtTekiyoShuryobi().getValue().toDateString()));
            builder.set本人合計所得金額(div.getTxtHonninGokeiShotoku().getValue());
            builder.set世帯１号被保険者数(div.getTxtSetaiinsu().getValue().intValue());
            builder.set年金収入合計(div.getTxtNenkinShunyuGokei().getValue());
            builder.setその他の合計所得金額合計(div.getTxtSonotaGokei().getValue());
            builder.set更正理由(div.getTxtBiko().getValue());
            builder.set世帯コード(new SetaiCode(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getHdnTxtSetaiCode()));
            new利用者負担割合明細 = builder.build();
            new利用者負担割合明細.toEntity().setState(EntityDataState.Added);
            holder.addRiyoshaFutanWariaiMeisai(new利用者負担割合明細);
        }
        sort利用者負担割合明細(holder.get利用者負担割合明細());
        ViewStateHolder.put(ViewStateKeys.利用者負担割合明細, holder);
        List<dgFutanWariai_Row> dataGridList = new ArrayList<>();
        for (RiyoshaFutanWariaiMeisai 明細 : holder.get利用者負担割合明細()) {
            dgFutanWariai_Row rowData = new dgFutanWariai_Row();
            rowData.setNendo(明細.get年度().toDateString());
            rowData.setRirekiNo(new RString(明細.get履歴番号()));
            rowData.setEdaNo(new RString(明細.get枝番号()));
            rowData.setShikakuCode(明細.get資格区分());
            rowData.setFutanWariaiCode(明細.get負担割合区分());
            rowData.setShikaku(FutanWariaiShikakuKubun.toValue(明細.get資格区分()).get名称());
            rowData.setFutanWariai(FutanwariaiKubun.toValue(明細.get負担割合区分()).get名称());
            FlexibleDate 適用開始日 = 明細.get有効終了日();
            FlexibleDate 適用終了日 = 明細.get有効終了日();
            if (適用開始日 != null) {
                rowData.getTekiyoKaishibi().setValue(new RDate(適用開始日.toString()));
            }
            if (適用終了日 != null) {
                rowData.getTekiyoShuryobi().setValue(new RDate(適用終了日.toString()));
            }
            rowData.getGokeiShotoku().setValue(明細.get本人合計所得金額());
            rowData.getSetaiinsu().setValue(Decimal.valueOf(明細.get世帯１号被保険者数()));
            rowData.getNenkinShunyuGokei().setValue(明細.get年金収入合計());
            rowData.getSonotaGokeiShotoku().setValue(明細.getその他の合計所得金額合計());
            rowData.setBiko(明細.get更正理由());
            rowData.setLogicalDeletedFlag(明細.get論理削除フラグ());
            if (明細.get論理削除フラグ()) {
                rowData.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
            }
            dataGridList.add(rowData);
        }
        div.getDgFutanWariai().setDataSource(dataGridList);
        編集項目をクリアする();
    }

    private FutanWariaiSokujiKouseiResult setDataGridInfo(RString 処理区分) {
        FutanWariaiMybatisParameter mybatisParameter = new FutanWariaiMybatisParameter();
        mybatisParameter.set年度(div.getDdlNendo().getSelectedKey());
        mybatisParameter.set被保険者番号(div.getCcdKaigoShikakuKihon().get被保険者番号());
        if (RSTTWO.equals(処理区分)) {
            mybatisParameter.set履歴番号(Integer.parseInt(div.getDdlRirekiNo().getSelectedKey().toString()));
        }
        mybatisParameter.setFlag(処理区分);
        FutanWariaiSokujiKouseiResult 利用者負担割合情報 = finder.get利用者負担割合情報(mybatisParameter);
        if (利用者負担割合情報 != null && !利用者負担割合情報.get利用者負担割合明細list().isEmpty()) {
            List<dgFutanWariai_Row> rowsData = new ArrayList<>();
            for (RiyoshaFutanWariaiMeisai entity : 利用者負担割合情報.get利用者負担割合明細list()) {
                rowsData.add(getDataGridRow(entity, 処理区分));
            }
            div.getDgFutanWariai().setDataSource(rowsData);
            set補足項目(new RiyoshaFutanWariai(利用者負担割合情報.toEntity()), null, 処理区分);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
            throw new ApplicationException(DbcErrorMessages.該当年度負担割合情報なし.getMessage());
        }
        set編集項目();
        set初期化状態設定(処理区分);
        return 利用者負担割合情報;
    }

    private void set補足項目(RiyoshaFutanWariai 利用者負担割合, RDate 基準日, RString 処理区分) {
        set負担割合証発行区分();
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                new CodeShubetsu(負担割合証交付事由), FlexibleDate.getNowDate());
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        if (codeList != null && !codeList.isEmpty()) {
            for (UzT0007CodeEntity code : codeList) {
                dataSourceList.add(new KeyValueDataSource(code.getコード().getColumnValue(), code.getコード名称()));
            }
        }
        div.getDdlKofuJiyu().setDataSource(dataSourceList);
        if (RSTZERO.equals(処理区分)) {
            set職権変更(false);
            set証発行不要(false);
            div.getTxtKijunbi().setValue(基準日);
        }
        if (RSTONE.equals(処理区分)) {
            set職権変更(true);
            set証発行不要(利用者負担割合.is発行不要フラグ());
            div.getDdlHakkoKubun().setSelectedKey(利用者負担割合.get発行区分());
        }
        if (RSTTWO.equals(処理区分)) {
            set職権変更(利用者負担割合.is職権変更フラグ());
            set証発行不要(利用者負担割合.is発行不要フラグ());
            div.getDdlHakkoKubun().setSelectedKey(利用者負担割合.get発行区分());
            FlexibleDate 発行日 = 利用者負担割合.get発行日();
            if (発行日 != null) {
                div.getTxtHakkobi().setValue(new RDate(発行日.toString()));
            } else {
                div.getTxtHakkobi().setValue(RDate.getNowDate());
            }
            FlexibleDate 交付日 = 利用者負担割合.get交付日();
            if (交付日 != null) {
                div.getTxtKofubi().setValue(new RDate(交付日.toString()));
            } else {
                div.getTxtKofubi().setValue(RDate.getNowDate());
            }
        }
    }

    private void set証発行不要(boolean flag) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(RSTONE, 証発行不要));
        div.getChkShoHakkoFuyo().setDataSource(dataSourceList);
        if (flag) {
            List<RString> list = new ArrayList<>();
            list.add(RSTONE);
            div.getChkShoHakkoFuyo().setSelectedItemsByKey(list);
        }
    }

    private void set職権変更(boolean flag) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(RSTONE, 職権変更));
        div.getChkShokkenHenko().setDataSource(dataSourceList);
        if (flag) {
            List<RString> list = new ArrayList<>();
            list.add(RSTONE);
            div.getChkShokkenHenko().setSelectedItemsByKey(list);
        }
    }

    private void set負担割合証発行区分() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(FutanWariaiHakkoKubun.未発行.getコード(), FutanWariaiHakkoKubun.未発行.get名称()));
        dataSourceList.add(new KeyValueDataSource(FutanWariaiHakkoKubun.一括発行.getコード(), FutanWariaiHakkoKubun.一括発行.get名称()));
        dataSourceList.add(new KeyValueDataSource(FutanWariaiHakkoKubun.単票発行.getコード(), FutanWariaiHakkoKubun.単票発行.get名称()));
        div.getPanelHosokuItem().getDdlHakkoKubun().setDataSource(dataSourceList);
    }

    private void set資格DropDownList() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(FutanWariaiShikakuKubun.一号.getコード(), FutanWariaiShikakuKubun.一号.get名称()));
        dataSourceList.add(new KeyValueDataSource(FutanWariaiShikakuKubun.二号.getコード(), FutanWariaiShikakuKubun.二号.get名称()));
        dataSourceList.add(new KeyValueDataSource(FutanWariaiShikakuKubun.一号_予定.getコード(), FutanWariaiShikakuKubun.一号_予定.get名称()));
        div.getDdlShikaku().setDataSource(dataSourceList);
        div.getDdlShikaku().setSelectedIndex(0);
    }

    private void set負担割合DropDownList() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(FutanwariaiKubun._１割.getコード(), FutanwariaiKubun._１割.get名称()));
        dataSourceList.add(new KeyValueDataSource(FutanwariaiKubun._２割.getコード(), FutanwariaiKubun._２割.get名称()));
        div.getDdlFutanWariai().setDataSource(dataSourceList);
        div.getDdlFutanWariai().setSelectedIndex(0);
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 被保険者番号R, 被保険者番号);
        return PersonalData.withKojinNo(識別コード, expandedInfo);
    }

    private void 前排他キーの解除(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(前排他キー.concat(被保険者番号));
        RealInitialLocker.release(排他キー);
    }

    private void sort利用者負担割合明細(List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細list) {
        Collections.sort(利用者負担割合明細list, new Comparator<RiyoshaFutanWariaiMeisai>() {
            @Override
            public int compare(RiyoshaFutanWariaiMeisai arg0, RiyoshaFutanWariaiMeisai arg1) {
                if (arg0.get有効開始日() != null && arg1.get有効開始日() != null
                        && arg0.get有効終了日() != null && arg1.get有効終了日() != null) {
                    if (arg0.get有効開始日().compareTo(arg1.get有効開始日()) == 0) {
                        return arg0.get有効終了日().compareTo(arg1.get有効終了日());
                    } else {
                        return arg0.get有効開始日().compareTo(arg1.get有効開始日());
                    }
                }
                return 0;
            }
        });
    }
}
