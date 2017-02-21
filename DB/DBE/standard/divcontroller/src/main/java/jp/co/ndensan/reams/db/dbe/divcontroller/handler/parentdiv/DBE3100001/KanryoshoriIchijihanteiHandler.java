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
import jp.co.ndensan.reams.db.dbe.definition.core.KanryoShoriStatus;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.KanryoshoriIchijihanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.dgHanteiTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・一次判定のHandlerクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
public class KanryoshoriIchijihanteiHandler {

    private static final RString STATUS_KANRYO_MI = new RString("未");
    private static final RString STATUS_KANRYO_KANOU = new RString("可");
    private static final RString COMMONBUTTON_KANRYO = new RString("btnCompleteIchijiHantei");
    private static final RString 完了処理_一次判定 = new RString("DBEMN11006");
    private static final RString 一次判定処理 = new RString("DBEMN51001");
    private static final RString 一次判定_OK = new RString("OK");
    private static final RString 一次判定_NG = new RString("NG");
    private static final RString マスキングチェックタイミング_一次判定後 = new RString("1");
    private static final int DIVIDE_VALUE = 10;
    private static final int ROUND_UP = 2;
    private final KanryoshoriIchijihanteiDiv div;

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
        div.getIchijiHanteiShoriTaishoshaIchiran().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);

        RString 状態区分 = DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().setSelectedKey(状態区分);
        div.setRadStatusBefore(状態区分);

        RString menuId = ResponseHolder.getMenuID();
        if (一次判定処理.equals(menuId)) {
            div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().setSelectedKey(KanryoShoriStatus.完了可能.getコード());
            div.setRadStatusBefore(KanryoShoriStatus.完了可能.getコード());

            div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdateHanteiKekka"), true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnIchijiHantei"), true);
        }

        div.setModeType(ModeType.SHOKAI_MODE.getValue());

        setSearchMaxValue();
        set対象者一覧();
        set対象者数();

        setBtnCompleteIchijiHanteiPrefixText();
        setCommonButtonDisabled();

    }

    /**
     * 対象者一覧に対して、DBから取得出来る一次判定対象者情報を設定します。
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
    public void setCommonButtonDisabled() {
        RString 状態区分 = div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().getSelectedKey();
        if (KanryoShoriStatus.未処理.getコード().equals(状態区分)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMONBUTTON_KANRYO, true);
        } else if (KanryoShoriStatus.完了可能.getコード().equals(状態区分)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMONBUTTON_KANRYO, false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMONBUTTON_KANRYO, false);
        }
    }

    /**
     * 一次判定結果情報を取得します。また、検索上限以上のデータが条件に合致した場合に、グリッド上に実際に取得できたはずの件数を設定します。
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
        ShoKisaiHokenshaNo 証記載保険者No = div.getIchijiHanteiShoriTaishoshaIchiran()
                .getCcdHokenshaList().getSelectedItem().get証記載保険者番号();

        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);

        RString 完了可能区分 = div.getIchijiHanteiShoriTaishoshaIchiran().getRadStatus().getSelectedKey();

        RString 取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        Decimal 取得件数num = new Decimal(取得件数.toString());
        Decimal 検索件数 = div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMaxCount().getValue();
        if (検索件数 == null || 検索件数.compareTo(Decimal.ONE) < 0 || 取得件数num.compareTo(検索件数) < 0) {
            setSearchMaxValue();
            検索件数 = 取得件数num;
        }

        return IChiJiPanTeiSyoRiParameter.
                createParameterOf一次判定完了処理(
                        証記載保険者No,
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

        IChiJiPanTeiSyoRiParameter parameter = createMybatisParameter();
        IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
        Decimal 検索件数 = div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMaxCount().getValue();
        Decimal dataNum = new Decimal(manager.get対象者件数(IChiJiPanTeiSyoRiParameter.createParameterOf一次判定対象件数(parameter)));
        if (検索件数.compareTo(dataNum) < 0) {
            div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getGridSetting().setLimitRowCount(検索件数.intValue());
            div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getGridSetting().setSelectedRowCount(dataNum.intValue());
        } else {
            div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getGridSetting().setLimitRowCount(0);
            div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getGridSetting().setSelectedRowCount(0);
        }
    }

    private dgHanteiTaishosha_Row setRowData(dgHanteiTaishosha_Row row, IChiJiPanTeiSyoRiBusiness business) {
        row.setRowState(RowState.Unchanged);
        row.setColumnState(RString.EMPTY);
        row.setHokensha(business.get市町村名称());
        row.setHihokenNo(business.get被保険者番号());
        row.setHihokenshaName(business.get被保険者氏名().value());
        row.getShinseibi().setValue(business.get認定申請年月日());
        row.setShinseiKbnShin(NinteiShinseiShinseijiKubunCode.
                toValue(business.get認定申請区分_申請時コード().value()).get名称());
        row.getIchijiHanteibi().setValue(business.get要介護認定一次判定年月日());
        if (business.get要介護認定一次判定年月日() != null && business.get要介護認定一次判定年月日() != FlexibleDate.EMPTY) {
            row.setIchijiHanteiKubun(KariIchijiHanteiKubun.toValue(business.get仮一次判定区分()).get略称());
        } else {
            row.setIchijiHanteiKubun(RString.EMPTY);
        }

        if (business.get要介護認定一次判定結果コード() != null) {
            row.setIchijiHanteiKekkaCode(business.get要介護認定一次判定結果コード().getColumnValue());
            row.setIchijiHanteiKekka(get一次判定結果名称(new Code(business.
                    get厚労省IF識別コード()), business.get要介護認定一次判定結果コード()));
        } else {
            row.setIchijiHanteiKekkaCode(RString.EMPTY);
            row.setIchijiHanteiKekka(RString.EMPTY);
        }

        if (business.get要介護認定一次判定結果コード_認知症加算() != null) {
            row.setIchijiHanteiKekkaNinchishoKasanCode(business.get要介護認定一次判定結果コード_認知症加算().getColumnValue());
            row.setIchijiHanteiKekkaNinchishoKasan(get一次判定結果名称(new Code(business.
                    get厚労省IF識別コード()), business.get要介護認定一次判定結果コード_認知症加算()));
        } else {
            row.setIchijiHanteiKekkaNinchishoKasanCode(RString.EMPTY);
            row.setIchijiHanteiKekkaNinchishoKasan(RString.EMPTY);
        }

        if (business.get要介護認定一次判定警告コード() != null) {
            if (is警告コードAllZERO(business.get要介護認定一次判定警告コード())) {
                row.setKeikokuCode(RString.EMPTY);
            } else {
                row.setKeikokuCode(business.get要介護認定一次判定警告コード());
            }
            row.setHiddenKeikokuCode(business.get要介護認定一次判定警告コード());
        }

        row.getChosaJissibi().setValue(business.get認定調査実施年月日());
        row.getIkenshoJuryobi().setValue(business.get主治医意見書受領年月日());
        if (business.get主治医意見書登録完了年月日() != null) {
            row.setIkenshoJuryo(new RString("●"));
        } else {
            row.setIkenshoJuryo(RString.EMPTY);
        }

        row.getKijunJikan().setValue(divideValue(business.get要介護認定等基準時間()));
        row.getKijunJikanShokuji().setValue(divideValue(business.get要介護認定等基準時間_食事()));
        row.getKijunJikanHaisetsu().setValue(divideValue(business.get要介護認定等基準時間_排泄()));
        row.getKijunJikanIdo().setValue(divideValue(business.get要介護認定等基準時間_移動()));
        row.getKijunJikanSeiketsuHoji().setValue(divideValue(business.get要介護認定等基準時間_清潔保持()));
        row.getKijunJikanKansetsuCare().setValue(divideValue(business.get要介護認定等基準時間_間接ケア()));
        row.getKijunJikanBPSDKanren().setValue(divideValue(business.get要介護認定等基準時間_BPSD関連()));
        row.getKijunJikanKinoKunren().setValue(divideValue(business.get要介護認定等基準時間_機能訓練()));
        row.getKijunJikanIryoKanren().setValue(divideValue(business.get要介護認定等基準時間_医療関連()));
        row.getKijunJikanNinchishoKasan().setValue(divideValue(business.get要介護認定等基準時間_認知症加算()));
        row.getChukanHyokaKomoku1gun().setValue(divideValue(business.get中間評価項目得点第1群()));
        row.getChukanHyokaKomoku2gun().setValue(divideValue(business.get中間評価項目得点第2群()));
        row.getChukanHyokaKomoku3gun().setValue(divideValue(business.get中間評価項目得点第3群()));
        row.getChukanHyokaKomoku4gun().setValue(divideValue(business.get中間評価項目得点第4群()));
        row.getChukanHyokaKomoku5gun().setValue(divideValue(business.get中間評価項目得点第5群()));

        if (!RString.isNullOrEmpty(row.getIchijiHanteiKekkaCode())) {
            set認知症自立度(business.get申請書管理番号(), row);
        }

        if (business.get要介護認定状態の安定性コード() != null && !business.get要介護認定状態の安定性コード().isEmpty()) {
            row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称());
        } else {
            row.setJotaiAnteiseiCode(RString.EMPTY);
        }

        if (business.get認知症自立度Ⅱ以上の蓋然性() != null) {
            row.getNinchishoJiritsudoIIijoNoGaizensei().setValue(business.get認知症自立度Ⅱ以上の蓋然性());
            if (business.get認知症自立度Ⅱ以上の蓋然性().compareTo(Decimal.ZERO) < 0) {
                row.getNinchishoJiritsudoIIijoNoGaizensei().setValue(null);
            }
            row.getHiddenNinchishoJiritsudoIIijoNoGaizensei().setValue(business.get認知症自立度Ⅱ以上の蓋然性());
        }

        if (business.get推定される給付区分コード() != null && !business.get推定される給付区分コード().isEmpty()) {
            row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(business.get推定される給付区分コード().value()).get名称());
        } else {
            row.setSuiteiKyufuKubunCode(RString.EMPTY);
        }

        row.setShinseishoKanriNo(business.get申請書管理番号().value());
        row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード());

        row.setHanteiKekka(RString.EMPTY);
        setStatusOfGridData(row, business);
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

    private void setStatusOfGridData(dgHanteiTaishosha_Row row, IChiJiPanTeiSyoRiBusiness business) {
        if (KariIchijiHanteiKubun.本一次判定.get略称().equals(row.getIchijiHanteiKubun())
                && business.get主治医意見書作成依頼完了年月日() != null
                && business.get主治医意見書登録完了年月日() != null) {
            row.setCellBgColor("columnState", DataGridCellBgColor.bgColorNormal);
            row.setColumnState(STATUS_KANRYO_KANOU);
        } else {
            row.setCellBgColor("columnState", DataGridCellBgColor.bgColorRed);
            row.setColumnState(STATUS_KANRYO_MI);
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
        if (KanryoShoriStatus.未処理.getコード().equals(状態区分)) {
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMishori().setDisplayNone(false);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMishori().setValue(new Decimal(mishoriValue));
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtKanryoKano().setDisplayNone(true);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtSum().setDisplayNone(true);

        } else if (KanryoShoriStatus.完了可能.getコード().equals(状態区分)) {
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtMishori().setDisplayNone(true);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtKanryoKano().setDisplayNone(false);
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtKanryoKano().setValue(new Decimal(kanryoKanoValue));
            div.getIchijiHanteiShoriTaishoshaIchiran().getTxtSum().setDisplayNone(true);
        } else {
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
     *
     * @param row キャンセル対象のグリッド行
     */
    public void cancelModified(dgHanteiTaishosha_Row row) {

        ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(row.getShinseishoKanriNo());

        IChiJiPanTeiSyoRiParameter parameter = createMybatisParameter(shinseishoKanriNo);

        IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
        List<IChiJiPanTeiSyoRiBusiness> businessList = manager.get対象者一覧(parameter).records();

        if (businessList == null || businessList.isEmpty() || !(businessList.size() == 1)) {
            return;
        }

        IChiJiPanTeiSyoRiBusiness business = businessList.get(0);
        setRowData(row, business);

        Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models
                = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
        List<IchijiHanteiKekkaJoho> kekkaJohoList = manager.get要介護認定一次判定結果情報(parameter).records();

        if (kekkaJohoList == null || kekkaJohoList.isEmpty() || !(kekkaJohoList.size() == 1)) {
            IchijiHanteiKekkaJohoIdentifier id = new IchijiHanteiKekkaJohoIdentifier(shinseishoKanriNo);
            models.deleteOrRemove(id);
        } else {
            IchijiHanteiKekkaJoho kekkaJoho = kekkaJohoList.get(0);
            models.add(kekkaJoho);
        }
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
     *//*
     public void setClickedIchijiHanteiData(ShinseishoKanriNo shinseishoKanriNo) {

     Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models
     = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
     RString hanteiKekkaStr = RString.EMPTY;

     if (models != null && !models.values().isEmpty()) {
     IchijiHanteiKekkaJohoIdentifier identifier = new IchijiHanteiKekkaJohoIdentifier(shinseishoKanriNo);
     IchijiHanteiKekkaJoho hanteiKekka = models.get(identifier);
     hanteiKekkaStr = hanteiKekka != null ? DataPassingConverter.serialize(hanteiKekka) : hanteiKekkaStr;
     }
     div.setIchijiHanteiKekka(hanteiKekkaStr);
     }
     */

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
            if (RString.isNullOrEmpty(row.getIkenshoJuryo())) {
                row.setIchijiHanteiKubun(KariIchijiHanteiKubun.仮一次判定.get略称());
            } else {
                row.setIchijiHanteiKubun(KariIchijiHanteiKubun.本一次判定.get略称());
            }
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
            if (is警告コードAllZERO(ichijiHantei.get要介護認定一次判定警告コード())) {
                row.setKeikokuCode(RString.EMPTY);
            } else {
                row.setKeikokuCode(ichijiHantei.get要介護認定一次判定警告コード());
            }
            row.setHiddenKeikokuCode(ichijiHantei.get要介護認定一次判定警告コード());
        }

        row.getKijunJikan().setValue(divideValue(ichijiHantei.get要介護認定等基準時間()));
        row.getKijunJikanShokuji().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_食事()));
        row.getKijunJikanHaisetsu().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_排泄()));
        row.getKijunJikanIdo().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_移動()));
        row.getKijunJikanSeiketsuHoji().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_清潔保持()));
        row.getKijunJikanKansetsuCare().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_間接ケア()));
        row.getKijunJikanBPSDKanren().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_BPSD関連()));
        row.getKijunJikanKinoKunren().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_機能訓練()));
        row.getKijunJikanIryoKanren().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_医療関連()));
        row.getKijunJikanNinchishoKasan().setValue(divideValue(ichijiHantei.get要介護認定等基準時間_認知症加算()));
        row.getChukanHyokaKomoku1gun().setValue(divideValue(ichijiHantei.get中間評価項目得点第1群()));
        row.getChukanHyokaKomoku2gun().setValue(divideValue(ichijiHantei.get中間評価項目得点第2群()));
        row.getChukanHyokaKomoku3gun().setValue(divideValue(ichijiHantei.get中間評価項目得点第3群()));
        row.getChukanHyokaKomoku4gun().setValue(divideValue(ichijiHantei.get中間評価項目得点第4群()));
        row.getChukanHyokaKomoku5gun().setValue(divideValue(ichijiHantei.get中間評価項目得点第5群()));

        if (!RString.isNullOrEmpty(row.getIchijiHanteiKekkaCode())) {
            set認知症自立度(new ShinseishoKanriNo(row.getShinseishoKanriNo()), row);
        }

        if (!isNullOrEmpty(ichijiHantei.get要介護認定状態の安定性コード())) {
            row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(ichijiHantei.get要介護認定状態の安定性コード().value()).get名称());
        }

        if (ichijiHantei.get認知症自立度Ⅱ以上の蓋然性() != null) {
            row.getNinchishoJiritsudoIIijoNoGaizensei().setValue(ichijiHantei.get認知症自立度Ⅱ以上の蓋然性());
            if (ichijiHantei.get認知症自立度Ⅱ以上の蓋然性().compareTo(Decimal.ZERO) < 0) {
                row.getNinchishoJiritsudoIIijoNoGaizensei().setValue(null);
            }
            row.getHiddenNinchishoJiritsudoIIijoNoGaizensei().setValue(ichijiHantei.get認知症自立度Ⅱ以上の蓋然性());
        }

        if (!isNullOrEmpty(ichijiHantei.get認知機能及び状態安定性から推定される給付区分コード())) {
            row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(ichijiHantei.get認知機能及び状態安定性から推定される給付区分コード().value()).get名称());
        }
    }

    /**
     * 要介護認定基準時間や中間評価項目などの整数値を、10で割った値で返します。
     *
     * @param value 整数値
     * @return Decimal化した値。
     */
    private Decimal divideValue(int value) {
        return new Decimal(value).divide(DIVIDE_VALUE);
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
                && !row.getHiddenKeikokuCode().equals(business.get要介護認定一次判定警告コード())) {
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
                && !row.getHiddenNinchishoJiritsudoIIijoNoGaizensei().getValue().equals(business.get認知症自立度Ⅱ以上の蓋然性())) {
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

        if (!row.getKijunJikan().getValue().equals(divideValue(business.get要介護認定等基準時間()))) {
            return true;
        }
        if (!row.getKijunJikanShokuji().getValue().equals(divideValue(business.get要介護認定等基準時間_食事()))) {
            return true;
        }
        if (!row.getKijunJikanHaisetsu().getValue().equals(divideValue(business.get要介護認定等基準時間_排泄()))) {
            return true;
        }
        if (!row.getKijunJikanIdo().getValue().equals(divideValue(business.get要介護認定等基準時間_移動()))) {
            return true;
        }
        if (!row.getKijunJikanSeiketsuHoji().getValue().equals(divideValue(business.get要介護認定等基準時間_清潔保持()))) {
            return true;
        }
        if (!row.getKijunJikanKansetsuCare().getValue().equals(divideValue(business.get要介護認定等基準時間_間接ケア()))) {
            return true;
        }
        if (!row.getKijunJikanBPSDKanren().getValue().equals(divideValue(business.get要介護認定等基準時間_BPSD関連()))) {
            return true;
        }
        if (!row.getKijunJikanKinoKunren().getValue().equals(divideValue(business.get要介護認定等基準時間_機能訓練()))) {
            return true;
        }
        if (!row.getKijunJikanIryoKanren().getValue().equals(divideValue(business.get要介護認定等基準時間_医療関連()))) {
            return true;
        }
        return !row.getKijunJikanNinchishoKasan().getValue().equals(divideValue(business.get要介護認定等基準時間_認知症加算()));
    }

    private boolean notEqualsRowData中間評価項目(dgHanteiTaishosha_Row row, IchijiHanteiKekkaJoho business) {

        if (!row.getChukanHyokaKomoku1gun().getValue().equals(divideValue(business.get中間評価項目得点第1群()))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku2gun().getValue().equals(divideValue(business.get中間評価項目得点第2群()))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku3gun().getValue().equals(divideValue(business.get中間評価項目得点第3群()))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku4gun().getValue().equals(divideValue(business.get中間評価項目得点第4群()))) {
            return true;
        }
        return !row.getChukanHyokaKomoku5gun().getValue().equals(divideValue(business.get中間評価項目得点第5群()));
    }

    /**
     * 対象者一覧を更新します。また、一次判定結果にエラーが出なかったデータのみ、ViewState上のデータも合わせて更新します。
     *
     * @param kekkaList 一次判定処理結果List
     */
    public void updateGridAndViewStateData(List<IchijiHanteiShoriKekka> kekkaList) {
        Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models = ViewStateHolder
                .get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
        if (models == null) {
            models = Models.create(new ArrayList<IchijiHanteiKekkaJoho>());
        }

        List<dgHanteiTaishosha_Row> selectedList = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getSelectedItems();
        for (dgHanteiTaishosha_Row row : selectedList) {
            ShinseishoKanriNo rowShinseishoKanriNo = new ShinseishoKanriNo(row.getShinseishoKanriNo());
            IchijiHanteiShoriKekka kekka = get(kekkaList, rowShinseishoKanriNo);
            if (kekka == null) {
                continue;
            }
            update対象者一覧(row, kekka);

            if (!kekka.isError()) {
                IchijiHanteiKekkaJoho joho = models.get(kekka.getHanteiKekka().identifier());
                if (joho == null) {
                    models.add(get一次判定結果情報_仮一次判定区分編集(kekka.getHanteiKekka(), row));
                } else {
                    joho = updateIchijiHanteiKekkaJoho(joho, get一次判定結果情報_仮一次判定区分編集(kekka.getHanteiKekka(), row));
                    models.add(joho);
                }
            }
        }
        ViewStateHolder.put(ViewStateKeys.要介護認定一次判定結果情報, models);
        List<dgHanteiTaishosha_Row> clearSelectedList = new ArrayList<>();
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().setSelectedItems(clearSelectedList);
    }

    private IchijiHanteiKekkaJoho get一次判定結果情報_仮一次判定区分編集(IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho, dgHanteiTaishosha_Row row) {
        IchijiHanteiKekkaJohoBuilder builder = ichijiHanteiKekkaJoho.createBuilderForEdit();
        builder.set仮一次判定区分(RString.isNullOrEmpty(row.getIkenshoJuryo()));
        return builder.build();
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
        builder.set仮一次判定区分(updateData.get仮一次判定区分());
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
                row.getColumnState(),
                row.getShinseishoKanriNo(),
                row.getHokensha(),
                row.getHihokenNo(),
                row.getHihokenshaName(),
                toSeirekiDateString(row.getShinseibi().getValue()),
                row.getShinseiKbnShin(),
                row.getIkenshoJuryo(),
                toSeirekiDateString(row.getIchijiHanteibi().getValue()),
                row.getIchijiHanteiKekka(),
                row.getIchijiHanteiKekkaCode(),
                row.getIchijiHanteiKubun(),
                row.getIchijiHanteiKekkaNinchishoKasan(),
                row.getIchijiHanteiKekkaNinchishoKasanCode(),
                row.getHiddenKeikokuCode(),
                toSeirekiDateString(row.getChosaJissibi().getValue()),
                toSeirekiDateString(row.getIkenshoJuryobi().getValue()),
                new RString(row.getKijunJikan().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanShokuji().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanHaisetsu().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanIdo().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanSeiketsuHoji().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanKansetsuCare().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanBPSDKanren().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanKinoKunren().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanIryoKanren().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getKijunJikanNinchishoKasan().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getChukanHyokaKomoku1gun().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getChukanHyokaKomoku2gun().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getChukanHyokaKomoku3gun().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getChukanHyokaKomoku4gun().getValue().roundHalfUpTo(ROUND_UP).toString()),
                new RString(row.getChukanHyokaKomoku5gun().getValue().roundHalfUpTo(ROUND_UP).toString()),
                row.getNinteiChosaTorikomiUmu(),
                row.getNinteiChosaNinchishodo(),
                row.getIkenshoTorikomiUmu(),
                row.getIkenshoNinchishodo(),
                row.getNinchishoJiritsudoIIijoNoGaizensei().getValue() == null ? RString.EMPTY
                : new RString(row.getNinchishoJiritsudoIIijoNoGaizensei().getValue().roundHalfUpTo(ROUND_UP).toString()),
                row.getJotaiAnteiseiCode(),
                row.getSuiteiKyufuKubunCode(),
                row.getKoroshoIfShikibetsuCode()
        );
    }

    private RString toSeirekiDateString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private void set認知症自立度(ShinseishoKanriNo shinseishoKanriNo, dgHanteiTaishosha_Row row) {
        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
        List<RString> jiritsudoCode = manager.get認知症高齢者自立度コード(shinseishoKanriNo);
        if (!jiritsudoCode.isEmpty()) {
            if (jiritsudoCode.get(0).isEmpty()) {
                row.setNinteiChosaTorikomiUmu(RString.EMPTY);
                row.setNinteiChosaNinchishodo(RString.EMPTY);
            } else {
                row.setNinteiChosaTorikomiUmu(new RString("済"));
                row.setNinteiChosaNinchishodo(NinchishoNichijoSeikatsuJiritsudoCode.toValue(jiritsudoCode.get(0)).get名称());
            }
            if (jiritsudoCode.get(1).isEmpty()) {
                row.setIkenshoTorikomiUmu(RString.EMPTY);
                row.setIkenshoNinchishodo(RString.EMPTY);
            } else {
                row.setIkenshoTorikomiUmu(new RString("済"));
                row.setIkenshoNinchishodo(NinchishoNichijoSeikatsuJiritsudoCode.toValue(jiritsudoCode.get(1)).get名称());
            }
        }
    }

    private void setBtnCompleteIchijiHanteiPrefixText() {
        if (!マスキングチェックタイミング_一次判定後.equals(DbBusinessConfig.get(ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate()))) {
            CommonButtonHolder.setPrefixTextByCommonButtonFieldName(COMMONBUTTON_KANRYO, "申請を審査会登録に");
        }
    }

    private boolean is警告コードAllZERO(RString 警告コード) {
        return 警告コード.toString().matches("^0+$");
    }
}
