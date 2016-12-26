/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijipanteisyori.IChiJiPanTeiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiShoriKekka;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.KanryoshoriIchijihanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.dgHanteiTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 完了処理・一次判定のHandlerクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
public class KanryoshoriIchijihanteiHandler {

    private static final RString STATUS_KANRYO_MI = new RString("未");
    private static final RString STATUS_KANRYO_KANOU = new RString("可");
    private final KanryoshoriIchijihanteiDiv div;

    private static final RString COMMONBUTTON_KANRYO = new RString("btnCompleteIchijiHantei");
    private static final RString COMMONBUTTON_UPDATE_ICHIJIHANTEI = new RString("btnUpdateHanteiKekka");
    private static final RString COMMONBUTTON_ICHIJI_HANTEI = new RString("btnIchijiHantei");

    private static final RString 完了処理_一次判定 = new RString("DBEMN11006");

    private static final RString 状態区分_未処理 = new RString("1");
    private static final RString 状態区分_完了可能 = new RString("2");
    private static final RString 状態区分_すべて = new RString("3");

    private static final RString 一次判定_OK = new RString("OK");
    private static final RString 一次判定_NG = new RString("NG");

    /**
     * コンストラクタです。
     *
     * @param div KanryoshoriIchijihanteiDiv
     */
    public KanryoshoriIchijihanteiHandler(KanryoshoriIchijihanteiDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・一次判定の初期化です。
     *
     */
    public void initialize() {

        RString 状態区分 = DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().setSelectedKey(状態区分);
        div.setRadStatusBefore(状態区分);

        div.setModeType(ModeType.SHOKAI_MODE.getValue());

        setSearchMaxValue();
        set対象者一覧();
        set対象者数();
    }

    /**
     *
     */
    public void set対象者一覧() {
        List<IChiJiPanTeiSyoRiBusiness> list = get一次判定結果情報();
        対象者一覧の編集(list);
    }

    private void setSearchMaxValue() {
        RString 取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 最大上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMaxCount().setValue(new Decimal(取得件数.toString()));
        div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMaxCount().setMaxValue(new Decimal(最大上限.toString()));
        div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMaxCount().setMinValue(Decimal.ONE);

        div.setTxtMaxCountBefore(取得件数);
    }

    /**
     * 検索条件を前の状態に戻します。
     */
    public void resetSearchCondition() {

        RString 状態区分 = div.getRadStatusBefore();
        div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().setSelectedKey(状態区分);

        RString 取得件数 = div.getTxtMaxCountBefore();
        div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMaxCount().setValue(new Decimal(取得件数.toString()));
    }

    /**
     * 検索条件の設定値を隠し値に保持します。
     */
    public void setHiddenSearchCondition() {

        RString 状態区分 = div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().getSelectedKey();
        div.setRadStatusBefore(状態区分);

        RString 取得件数 = new RString(div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMaxCount().getValue().toString());
        div.setTxtMaxCountBefore(取得件数);
    }

    /**
     * ラジオボタンの選択状態に合わせて、共通ボタンの表示非表示を切り替えます。
     */
    public void setCommonButtonDisplayNone() {

        RString 状態区分 = div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().getSelectedKey();

        if (状態区分_未処理.equals(状態区分)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_KANRYO, true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_UPDATE_ICHIJIHANTEI, false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_ICHIJI_HANTEI, false);
        } else if (状態区分_完了可能.equals(状態区分)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_KANRYO, false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_UPDATE_ICHIJIHANTEI, true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_ICHIJI_HANTEI, true);
        } else if (状態区分_すべて.equals(状態区分)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_KANRYO, false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_UPDATE_ICHIJIHANTEI, false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMONBUTTON_ICHIJI_HANTEI, false);
        }
    }

    /**
     * 一次判定結果情報を取得します。
     *
     * @return 一次判定結果情報（表示用）のリスト
     */
    public List<IChiJiPanTeiSyoRiBusiness> get一次判定結果情報() {
        IChiJiPanTeiSyoRiParameter parameter = createMybatisParameter();

        IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
        List<IChiJiPanTeiSyoRiBusiness> businessList = manager.get対象者一覧(parameter).records();

        if (!businessList.isEmpty()) {
            List<IchijiHanteiKekkaJoho> kekkaJohoList = manager.get要介護認定一次判定結果情報(parameter).records();
            ViewStateHolder.put(ViewStateKeys.要介護認定一次判定結果情報, Models.create(kekkaJohoList));
        } else {
            ViewStateHolder.put(ViewStateKeys.要介護認定一次判定結果情報, Models.create(new ArrayList()));
        }
        return businessList;
    }

    private IChiJiPanTeiSyoRiParameter createMybatisParameter() {
        return createMybatisParameter(Collections.<RString>emptyList());
    }

    private IChiJiPanTeiSyoRiParameter createMybatisParameter(ShinseishoKanriNo shinseishoKanriNo) {
        List<RString> shinseishoKanriNoList = new ArrayList<>();
        shinseishoKanriNoList.add(shinseishoKanriNo.getColumnValue());
        return createMybatisParameter(shinseishoKanriNoList);
    }

    private IChiJiPanTeiSyoRiParameter createMybatisParameter(List<RString> shinseishoKanriNoList) {

        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);

        RString 完了可能区分 = div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().getSelectedKey();

        RString 取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        Decimal 取得件数num = new Decimal(取得件数.toString());
        Decimal 検索件数 = div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMaxCount().getValue();
        if (検索件数 == null || 検索件数.compareTo(Decimal.ONE) < 0 || 取得件数num.compareTo(検索件数) < 0) {
            setSearchMaxValue();
            検索件数 = 取得件数num;
        }

        return IChiJiPanTeiSyoRiParameter.
                createParameterOf一次判定完了処理(
                        ShoriJotaiKubun.通常.getコード(),
                        ShoriJotaiKubun.延期.getコード(),
                        イメージ区分,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY,
                        検索件数,
                        完了処理_一次判定,
                        shinseishoKanriNoList,
                        完了可能区分);
    }

    /**
     * 対象者一覧の編集。
     *
     * @param 一次判定対象者一覧List List<IChiJiPanTeiSyoRiBusiness>
     */
    public void 対象者一覧の編集(List<IChiJiPanTeiSyoRiBusiness> 一次判定対象者一覧List) {

        List<dgHanteiTaishosha_Row> rowList = new ArrayList<>();
        for (IChiJiPanTeiSyoRiBusiness business : 一次判定対象者一覧List) {
            dgHanteiTaishosha_Row row = new dgHanteiTaishosha_Row();
            setRowData(row, business);
            rowList.add(row);
        }
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().setDataSource(rowList);
    }

    private dgHanteiTaishosha_Row setRowData(dgHanteiTaishosha_Row row, IChiJiPanTeiSyoRiBusiness business) {
        row.setColumnState(RString.EMPTY);
        row.setHokensha(business.get市町村名称());
        row.setHihokenNo(business.get被保険者番号());
        row.setHihokenshaName(business.get被保険者氏名().value());
        row.getShinseibi().setValue(business.get認定申請年月日());
        row.setShinseiKbnShin(NinteiShinseiShinseijiKubunCode.
                toValue(business.get認定申請区分_申請時コード().value()).get名称());
        row.getIchijiHanteibi().setValue(business.get要介護認定一次判定年月日());

        if (business.get要介護認定一次判定結果コード() != null) {
            row.setIchijiHanteiKekkaCode(business.get要介護認定一次判定結果コード().getColumnValue());
            row.setIchijiHanteiKekka(get一次判定結果名称(new Code(business.
                    get厚労省IF識別コード()), business.get要介護認定一次判定結果コード()));
        }
        if (business.get要介護認定一次判定結果コード_認知症加算() != null) {
            row.setIchijiHanteiKekkaNinchishoKasanCode(business.get要介護認定一次判定結果コード_認知症加算().getColumnValue());
            row.setIchijiHanteiKekkaNinchishoKasan(get一次判定結果名称(new Code(business.
                    get厚労省IF識別コード()), business.get要介護認定一次判定結果コード_認知症加算()));
        }
        row.setKeikokuCode(business.get要介護認定一次判定警告コード());
        row.getChosaJissibi().setValue(business.get認定調査実施年月日());
        row.getIkenshoJuryobi().setValue(business.get主治医意見書受領年月日());
        row.setKijunJikan(new RString(String.valueOf(business.get要介護認定等基準時間())));
        row.setKijunJikanShokuji(new RString(String.valueOf(business.get要介護認定等基準時間_食事())));
        row.setKijunJikanHaisetsu(new RString(String.valueOf(business.get要介護認定等基準時間_排泄())));
        row.setKijunJikanIdo(new RString(String.valueOf(business.get要介護認定等基準時間_移動())));
        row.setKijunJikanSeiketsuHoji(new RString(String.valueOf(business.get要介護認定等基準時間_清潔保持())));
        row.setKijunJikanKansetsuCare(new RString(String.valueOf(business.get要介護認定等基準時間_間接ケア())));
        row.setKijunJikanBPSDKanren(new RString(String.valueOf(business.get要介護認定等基準時間_BPSD関連())));
        row.setKijunJikanKinoKunren(new RString(String.valueOf(business.get要介護認定等基準時間_機能訓練())));
        row.setKijunJikanIryoKanren(new RString(String.valueOf(business.get要介護認定等基準時間_医療関連())));
        row.setKijunJikanNinchishoKasan(new RString(String.valueOf(business.get要介護認定等基準時間_認知症加算())));
        row.setChukanHyokaKomoku1gun(new RString(String.valueOf(business.get中間評価項目得点第1群())));
        row.setChukanHyokaKomoku2gun(new RString(String.valueOf(business.get中間評価項目得点第2群())));
        row.setChukanHyokaKomoku3gun(new RString(String.valueOf(business.get中間評価項目得点第3群())));
        row.setChukanHyokaKomoku4gun(new RString(String.valueOf(business.get中間評価項目得点第4群())));
        row.setChukanHyokaKomoku5gun(new RString(String.valueOf(business.get中間評価項目得点第5群())));
        if (business.get要介護認定状態の安定性コード() != null && !business.get要介護認定状態の安定性コード().isEmpty()) {
            row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称());
        }
        if (business.get認知症自立度Ⅱ以上の蓋然性() != null) {
            row.setNinchishoJiritsudoIIijoNoGaizensei(new RString(String.valueOf(business.get認知症自立度Ⅱ以上の蓋然性().roundUpTo(2))));
        }
        if (business.get推定される給付区分コード() != null && !business.get推定される給付区分コード().isEmpty()) {
            row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(business.get推定される給付区分コード().value()).get名称());
        }
        row.setShinseishoKanriNo(business.get申請書管理番号().value());
        row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード());

        row.setHanteiKekka(RString.EMPTY);
        setStatusOfGridData(row);
        return row;
    }

    private RString get一次判定結果名称(Code 厚労省IF識別コード, Code 一次判定結果コード) {

        if (厚労省IF識別コード != null && 一次判定結果コード != null && !一次判定結果コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                return IchijiHanteiKekkaCode99.toValue(一次判定結果コード.getKey()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                return IchijiHanteiKekkaCode02.toValue(一次判定結果コード.getKey()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                return IchijiHanteiKekkaCode06.toValue(一次判定結果コード.getKey()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                return IchijiHanteiKekkaCode09.toValue(一次判定結果コード.getKey()).get名称();
            }
        }
        return RString.EMPTY;
    }

    private void setStatusOfGridData(dgHanteiTaishosha_Row row) {

        if (row.getIchijiHanteibi().getValue().isEmpty()) {
            row.setCellBgColor("columnState", DataGridCellBgColor.bgColorRed);
            row.setColumnState(STATUS_KANRYO_MI);
        } else {
            row.setCellBgColor("columnState", DataGridCellBgColor.bgColorNormal);
            row.setColumnState(STATUS_KANRYO_KANOU);
        }
    }

    /**
     * 画面上に処理対象者数を表示するためのテキストボックスの初期化・表示非表示の切り替えを行います。
     */
    public void set対象者数() {

        int mishoriValue = 0;
        int kanryoKanoValue = 0;
        List<dgHanteiTaishosha_Row> dataSource = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getDataSource();

        for (dgHanteiTaishosha_Row row : dataSource) {
            if (STATUS_KANRYO_MI.equals(row.getColumnState())) {
                mishoriValue++;
            } else {
                kanryoKanoValue++;
            }
        }

        RString 状態区分 = div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().getSelectedKey();
        if (状態区分_未処理.equals(状態区分)) {
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMishori().setDisplayNone(false);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMishori().setValue(new Decimal(mishoriValue));
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtKanryoKano().setDisplayNone(true);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtSum().setDisplayNone(true);

        } else if (状態区分_完了可能.equals(状態区分)) {
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMishori().setDisplayNone(true);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtKanryoKano().setDisplayNone(false);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtKanryoKano().setValue(new Decimal(kanryoKanoValue));
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtSum().setDisplayNone(true);
        } else if (状態区分_すべて.equals(状態区分)) {
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMishori().setDisplayNone(false);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMishori().setValue(new Decimal(mishoriValue));
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtKanryoKano().setDisplayNone(false);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtKanryoKano().setValue(new Decimal(kanryoKanoValue));
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtSum().setDisplayNone(false);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtSum().setValue(new Decimal(mishoriValue + kanryoKanoValue));
        }

    }

    /**
     * グリッド上の変更をキャンセルします。
     */
    public void cancelModified() {
        dgHanteiTaishosha_Row row = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getClickedItem();
        if (!row.getRowState().equals(RowState.Modified)) {
            return;
        }

        ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(row.getShinseishoKanriNo());

        IChiJiPanTeiSyoRiParameter parameter = createMybatisParameter(shinseishoKanriNo);

        IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
        List<IChiJiPanTeiSyoRiBusiness> businessList = manager.get対象者一覧(parameter).records();

        if (businessList == null || businessList.isEmpty() || !(businessList.size() == 1)) {
            return;
        }

        IChiJiPanTeiSyoRiBusiness business = businessList.get(0);
        setRowData(row, business);

        List<IchijiHanteiKekkaJoho> kekkaJohoList = manager.get要介護認定一次判定結果情報(parameter).records();
        IchijiHanteiKekkaJoho kekkaJoho = kekkaJohoList.get(0);

        Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models
                = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
        models.add(kekkaJoho);
        ViewStateHolder.put(ViewStateKeys.要介護認定一次判定結果情報, models);
    }

    /**
     * 個人情報につながるデータについて、アクセスログを記録します。
     *
     * @param row dgHanteiTaishosha_Row
     * @param accessType AccessLogType
     */
    public void setLogOfPersonalData(dgHanteiTaishosha_Row row, AccessLogType accessType) {

        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                new RString("申請書管理番号"), row.getShinseishoKanriNo()));
        AccessLogger.log(accessType, personalData);
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return NinteiKanryoJoho
     */
    public NinteiKanryoJoho 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        return ninteiKanryoJoho.createBuilderForEdit().set要介護認定一次判定完了年月日(FlexibleDate.getNowDate()).build();

    }

    /**
     * 照会ボタンでダイアログを開く時に必要になる。、対象行のデータをDataPassingするための前処理です。
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setClickedIchijiHanteiData(ShinseishoKanriNo shinseishoKanriNo) {

        Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models;
        IchijiHanteiKekkaJohoIdentifier identifier;
        RString hanteiKekkaStr = RString.EMPTY;
        models = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);

        if (models != null && !models.aliveValues().isEmpty()) {
            identifier = new IchijiHanteiKekkaJohoIdentifier(shinseishoKanriNo);
            IchijiHanteiKekkaJoho hanteiKekka = models.get(identifier);
            hanteiKekkaStr = hanteiKekka != null ? DataPassingConverter.serialize(hanteiKekka) : hanteiKekkaStr;
        }
        div.setIchijiHanteiKekka(hanteiKekkaStr);
    }

    /**
     * グリッド上の選択項目から申請書管理番号を取得します。
     *
     * @return 申請書管理番号のList
     */
    public List<ShinseishoKanriNo> getSelected申請書管理番号() {

        List<dgHanteiTaishosha_Row> selectedList = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getSelectedItems();

        List<ShinseishoKanriNo> 申請書管理番号List = new ArrayList<>();
        for (dgHanteiTaishosha_Row selectedItem : selectedList) {
            RString rowShinseishoKanriNo = selectedItem.getShinseishoKanriNo();
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(rowShinseishoKanriNo);
            申請書管理番号List.add(申請書管理番号);
        }
        return 申請書管理番号List;
    }

    /**
     * 一次判定処理結果を元に、対象者一覧を更新します。
     *
     * @param row 対象者一覧
     * @param kekka 要介護認定一次判定結果情報
     */
    public void update対象者一覧(dgHanteiTaishosha_Row row, IchijiHanteiShoriKekka kekka) {

        IchijiHanteiKekkaJoho ichijiHantei = kekka.getHanteiKekka();

        if (ichijiHantei == null) {
            return;
        }

        if (kekka.isError()) {
            row.setHanteiKekka(一次判定_NG);
            row.setCellBgColor("hanteiKekka", DataGridCellBgColor.bgColorRed);
            return;
        }
        row.setRowState(RowState.Modified);
        row.setHanteiKekka(一次判定_OK);
        row.setCellBgColor("hanteiKekka", DataGridCellBgColor.bgColorNormal);

        if (ichijiHantei.get要介護認定一次判定年月日() != null) {
            row.getIchijiHanteibi().setValue(ichijiHantei.get要介護認定一次判定年月日());
        }
        if (!isNullOrEmpty(ichijiHantei.get要介護認定一次判定結果コード())) {
            row.setIchijiHanteiKekkaCode(ichijiHantei.get要介護認定一次判定結果コード().getColumnValue());
            row.setIchijiHanteiKekka(IchijiHanteiKekkaCode09.toValue(ichijiHantei.
                    get要介護認定一次判定結果コード().value()).get名称());
        }
        if (!isNullOrEmpty(ichijiHantei.get要介護認定一次判定結果コード_認知症加算())) {
            row.setIchijiHanteiKekkaNinchishoKasanCode(ichijiHantei.get要介護認定一次判定結果コード_認知症加算().getColumnValue());
            row.setIchijiHanteiKekkaNinchishoKasan(IchijiHanteiKekkaCode09.
                    toValue(ichijiHantei.get要介護認定一次判定結果コード_認知症加算().value()).get名称());
        }
        if (ichijiHantei.get要介護認定一次判定警告コード() != null) {
            row.setKeikokuCode(ichijiHantei.get要介護認定一次判定警告コード());
        }
        row.setKijunJikan(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間())));
        row.setKijunJikanShokuji(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_食事())));
        row.setKijunJikanHaisetsu(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_排泄())));
        row.setKijunJikanIdo(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_移動())));
        row.setKijunJikanSeiketsuHoji(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_清潔保持())));
        row.setKijunJikanKansetsuCare(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_間接ケア())));
        row.setKijunJikanBPSDKanren(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_BPSD関連())));
        row.setKijunJikanKinoKunren(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_機能訓練())));
        row.setKijunJikanIryoKanren(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_医療関連())));
        row.setKijunJikanNinchishoKasan(new RString(String.valueOf(ichijiHantei.get要介護認定等基準時間_認知症加算())));
        row.setChukanHyokaKomoku1gun(new RString(String.valueOf(ichijiHantei.get中間評価項目得点第1群())));
        row.setChukanHyokaKomoku2gun(new RString(String.valueOf(ichijiHantei.get中間評価項目得点第2群())));
        row.setChukanHyokaKomoku3gun(new RString(String.valueOf(ichijiHantei.get中間評価項目得点第3群())));
        row.setChukanHyokaKomoku4gun(new RString(String.valueOf(ichijiHantei.get中間評価項目得点第4群())));
        row.setChukanHyokaKomoku5gun(new RString(String.valueOf(ichijiHantei.get中間評価項目得点第5群())));
        if (!isNullOrEmpty(ichijiHantei.get要介護認定状態の安定性コード())) {
            row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(ichijiHantei.get要介護認定状態の安定性コード().value()).get名称());
        }
        if (ichijiHantei.get認知症自立度Ⅱ以上の蓋然性() != null) {
            row.setNinchishoJiritsudoIIijoNoGaizensei(new RString(String.valueOf(ichijiHantei.get認知症自立度Ⅱ以上の蓋然性())));
        }
        if (!isNullOrEmpty(ichijiHantei.get認知機能及び状態安定性から推定される給付区分コード())) {
            row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(ichijiHantei.get認知機能及び状態安定性から推定される給付区分コード().value()).get名称());
        }

        //div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getDataSource().set(index, row);
    }

    private boolean isNullOrEmpty(Code code) {
        return code == null || code.isEmpty();
    }

    /**
     * 対象者の編集処理を行う前に、内容に変化があるかどうかをチェックします。
     *
     * @param row 対象者一覧のデータ
     * @param business 要介護認定一次判定結果情報
     * @return 値を比較して、1項目でも差がある場合はtrueを返す。それ以外の場合はfalseを返す。
     */
    public boolean notEqualsRowData(dgHanteiTaishosha_Row row, IchijiHanteiKekkaJoho business) {

        if (business == null) {
            return false;
        }

        if (business.get要介護認定一次判定年月日() != null
                && !row.getIchijiHanteibi().getValue().equals(business.get要介護認定一次判定年月日())) {
            return true;
        }

        if (notEqualsRowData一次判定結果コード(row, business)) {
            return true;
        }

        if (business.get要介護認定一次判定結果コード_認知症加算() != null
                && !row.getIchijiHanteiKekkaNinchishoKasanCode().equals(business.get要介護認定一次判定結果コード_認知症加算().getColumnValue())) {
            return true;
        }
        if (business.get要介護認定一次判定警告コード() != null
                && !row.getKeikokuCode().equals(business.get要介護認定一次判定警告コード())) {
            return true;
        }

        if (notEqualsRowData基準時間(row, business)) {
            return true;
        }
        if (notEqualsRowData中間評価項目(row, business)) {
            return true;
        }

        if (business.get要介護認定状態の安定性コード() != null && !business.get要介護認定状態の安定性コード().isEmpty()
                && !row.getJotaiAnteiseiCode().equals(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称())) {
            return true;
        }
        if (business.get認知症自立度Ⅱ以上の蓋然性() != null
                && !row.getNinchishoJiritsudoIIijoNoGaizensei().equals(new RString(String.valueOf(business.get認知症自立度Ⅱ以上の蓋然性())))) {
            return true;
        }
        if (business.get認知機能及び状態安定性から推定される給付区分コード() != null
                && !business.get認知機能及び状態安定性から推定される給付区分コード().isEmpty()) {
            return !row.getSuiteiKyufuKubunCode().equals(SuiteiKyufuKubunCode
                    .toValue(business.get認知機能及び状態安定性から推定される給付区分コード().value()).get名称());
        }

        return false;
    }

    private boolean notEqualsRowData一次判定結果コード(dgHanteiTaishosha_Row row, IchijiHanteiKekkaJoho business) {

        if (business.get要介護認定一次判定結果コード() != null) {
            if (!row.getIchijiHanteiKekkaCode().equals(business.get要介護認定一次判定結果コード().getColumnValue())) {
                return true;
            }
            if (!row.getIchijiHanteiKekka().equals(IchijiHanteiKekkaCode09.toValue(business.
                    get要介護認定一次判定結果コード().value()).get名称())) {
                return true;
            }
        }
        return false;
    }

    private boolean notEqualsRowData基準時間(dgHanteiTaishosha_Row row, IchijiHanteiKekkaJoho business) {

        if (!row.getKijunJikan().equals(new RString(String.valueOf(business.get要介護認定等基準時間())))) {
            return true;
        }
        if (!row.getKijunJikanShokuji().equals(new RString(String.valueOf(business.get要介護認定等基準時間_食事())))) {
            return true;
        }
        if (!row.getKijunJikanHaisetsu().equals(new RString(String.valueOf(business.get要介護認定等基準時間_排泄())))) {
            return true;
        }
        if (!row.getKijunJikanIdo().equals(new RString(String.valueOf(business.get要介護認定等基準時間_移動())))) {
            return true;
        }
        if (!row.getKijunJikanSeiketsuHoji().equals(new RString(String.valueOf(business.get要介護認定等基準時間_清潔保持())))) {
            return true;
        }
        if (!row.getKijunJikanKansetsuCare().equals(new RString(String.valueOf(business.get要介護認定等基準時間_間接ケア())))) {
            return true;
        }
        if (!row.getKijunJikanBPSDKanren().equals(new RString(String.valueOf(business.get要介護認定等基準時間_BPSD関連())))) {
            return true;
        }
        if (!row.getKijunJikanKinoKunren().equals(new RString(String.valueOf(business.get要介護認定等基準時間_機能訓練())))) {
            return true;
        }
        if (!row.getKijunJikanIryoKanren().equals(new RString(String.valueOf(business.get要介護認定等基準時間_医療関連())))) {
            return true;
        }
        return !row.getKijunJikanNinchishoKasan().equals(new RString(String.valueOf(business.get要介護認定等基準時間_認知症加算())));
    }

    private boolean notEqualsRowData中間評価項目(dgHanteiTaishosha_Row row, IchijiHanteiKekkaJoho business) {

        if (!row.getChukanHyokaKomoku1gun().equals(new RString(String.valueOf(business.get中間評価項目得点第1群())))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku2gun().equals(new RString(String.valueOf(business.get中間評価項目得点第2群())))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku3gun().equals(new RString(String.valueOf(business.get中間評価項目得点第3群())))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku4gun().equals(new RString(String.valueOf(business.get中間評価項目得点第4群())))) {
            return true;
        }
        return !row.getChukanHyokaKomoku5gun().equals(new RString(String.valueOf(business.get中間評価項目得点第5群())));
    }

    /**
     * 対象者一覧を更新します。また、一次判定結果にエラーが出なかったデータのみ、ViewState上のデータも合わせて更新します。
     *
     * @param kekkaList 一次判定処理結果List
     */
    public void updateGridAndViewStateData(List<IchijiHanteiShoriKekka> kekkaList) {

        List<dgHanteiTaishosha_Row> selectedList = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getSelectedItems();

        for (dgHanteiTaishosha_Row row : selectedList) {
            ShinseishoKanriNo rowShinseishoKanriNo = new ShinseishoKanriNo(row.getShinseishoKanriNo());
            IchijiHanteiShoriKekka kekka = get(kekkaList, rowShinseishoKanriNo);
            if (kekka == null) {
                continue;
            }
            update対象者一覧(row, kekka);

            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models = ViewStateHolder
                    .get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
            if (models == null) {
                models = Models.create(new ArrayList<IchijiHanteiKekkaJoho>());
            }
            if (!kekka.isError()) {
                IchijiHanteiKekkaJoho joho = models.get(kekka.getHanteiKekka().identifier());
                if (joho == null) {
                    models.add(kekka.getHanteiKekka());
                } else {
                    joho = updateIchijiHanteiKekkaJoho(joho, kekka.getHanteiKekka());
                    models.add(joho);
                }
            }
            ViewStateHolder.put(ViewStateKeys.要介護認定一次判定結果情報, models);
        }

    }

    private IchijiHanteiShoriKekka get(List<IchijiHanteiShoriKekka> kekkaList, ShinseishoKanriNo shinseishoKanriNo) {
        for (IchijiHanteiShoriKekka kekka : kekkaList) {
            if (kekka.getShinseishoKanriNo().equals(shinseishoKanriNo)) {
                return kekka;
            }
        }
        return null;
    }

    private IchijiHanteiKekkaJoho updateIchijiHanteiKekkaJoho(IchijiHanteiKekkaJoho original, IchijiHanteiKekkaJoho updateData) {

        IchijiHanteiKekkaJohoBuilder builder = original.createBuilderForEdit();
        builder.set仮一次判定区分(false);
        builder.set要介護認定一次判定年月日(new FlexibleDate(RDate.getNowDate().toDateString()));

        builder.set要介護認定一次判定結果コード(updateData.get要介護認定一次判定結果コード());
        builder.set要介護認定一次判定結果コード_認知症加算(updateData.get要介護認定一次判定結果コード_認知症加算());

        builder.set要介護認定等基準時間(updateData.get要介護認定等基準時間());
        builder.set要介護認定等基準時間_食事(updateData.get要介護認定等基準時間_食事());
        builder.set要介護認定等基準時間_排泄(updateData.get要介護認定等基準時間_排泄());
        builder.set要介護認定等基準時間_移動(updateData.get要介護認定等基準時間_移動());
        builder.set要介護認定等基準時間_清潔保持(updateData.get要介護認定等基準時間_清潔保持());
        builder.set要介護認定等基準時間_間接ケア(updateData.get要介護認定等基準時間_間接ケア());
        builder.set要介護認定等基準時間_BPSD関連(updateData.get要介護認定等基準時間_BPSD関連());
        builder.set要介護認定等基準時間_機能訓練(updateData.get要介護認定等基準時間_機能訓練());
        builder.set要介護認定等基準時間_医療関連(updateData.get要介護認定等基準時間_医療関連());
        builder.set要介護認定等基準時間_認知症加算(updateData.get要介護認定等基準時間_認知症加算());
        builder.set中間評価項目得点第1群(updateData.get中間評価項目得点第1群());
        builder.set中間評価項目得点第2群(updateData.get中間評価項目得点第2群());
        builder.set中間評価項目得点第3群(updateData.get中間評価項目得点第3群());
        builder.set中間評価項目得点第4群(updateData.get中間評価項目得点第4群());
        builder.set中間評価項目得点第5群(updateData.get中間評価項目得点第5群());
        builder.set中間評価項目得点第6群(updateData.get中間評価項目得点第6群());
        builder.set中間評価項目得点第7群(updateData.get中間評価項目得点第7群());

        builder.set要介護認定状態の安定性コード(updateData.get要介護認定状態の安定性コード());
        builder.set認知症自立度Ⅱ以上の蓋然性(updateData.get認知症自立度Ⅱ以上の蓋然性());
        builder.set認知機能及び状態安定性から推定される給付区分コード(updateData.get認知機能及び状態安定性から推定される給付区分コード());

        builder.set運動能力の低下していない認知症高齢者の指標コード(Code.EMPTY);
        builder.set日常生活自立度の組み合わせ_自立(0);
        builder.set日常生活自立度の組み合わせ_要支援(0);
        builder.set日常生活自立度の組み合わせ_要介護１(0);
        builder.set日常生活自立度の組み合わせ_要介護２(0);
        builder.set日常生活自立度の組み合わせ_要介護３(0);
        builder.set日常生活自立度の組み合わせ_要介護４(0);
        builder.set日常生活自立度の組み合わせ_要介護５(0);
        builder.set認知症高齢者の日常生活自立度の蓋然性評価コード(Code.EMPTY);
        builder.set認知症高齢者の日常生活自立度の蓋然性評価(0);
        builder.set一次判定結果送付区分(RString.EMPTY);
        builder.set一次判定結果送付年月日(FlexibleDate.EMPTY);
        builder.setチャート(RString.EMPTY);
        builder.set状態像(RString.EMPTY);

        return builder.build();
    }

    /**
     * グリッド上に表示されている情報を元にCSVデータを作成します。
     *
     * @param row グリッドの1行
     * @return １行分のCSVデータ
     */
    public KanryoshoriCsvEntity getCsvData(dgHanteiTaishosha_Row row) {
        return new KanryoshoriCsvEntity(
                row.getShinseishoKanriNo(),
                row.getHokensha(),
                row.getHihokenNo(),
                row.getHihokenshaName(),
                new RString(row.getShinseibi().getValue().toString()),
                row.getShinseiKbnShin(),
                new RString(row.getIchijiHanteibi().getValue().toString()),
                row.getIchijiHanteiKekka(),
                row.getIchijiHanteiKekkaCode(),
                row.getIchijiHanteiKekkaNinchishoKasan(),
                row.getIchijiHanteiKekkaNinchishoKasanCode(),
                row.getKeikokuCode(),
                new RString(row.getChosaJissibi().getValue().toString()),
                new RString(row.getIkenshoJuryobi().getValue().toString()),
                row.getKijunJikan(),
                row.getKijunJikanShokuji(),
                row.getKijunJikanHaisetsu(),
                row.getKijunJikanIdo(),
                row.getKijunJikanSeiketsuHoji(),
                row.getKijunJikanKansetsuCare(),
                row.getKijunJikanBPSDKanren(),
                row.getKijunJikanKinoKunren(),
                row.getKijunJikanIryoKanren(),
                row.getKijunJikanNinchishoKasan(),
                row.getChukanHyokaKomoku1gun(),
                row.getChukanHyokaKomoku2gun(),
                row.getChukanHyokaKomoku3gun(),
                row.getChukanHyokaKomoku4gun(),
                row.getChukanHyokaKomoku5gun(),
                row.getJotaiAnteiseiCode(),
                row.getNinchishoJiritsudoIIijoNoGaizensei(),
                row.getSuiteiKyufuKubunCode(),
                row.getKoroshoIfShikibetsuCode()
        );
    }
}
