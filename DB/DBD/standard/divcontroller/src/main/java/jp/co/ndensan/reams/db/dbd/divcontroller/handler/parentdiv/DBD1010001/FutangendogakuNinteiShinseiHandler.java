/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.HaiguuJohoEntity;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KyoshitsuShubetsu;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.HaigushaKazeiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.YochokinShinkokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.service.core.futangendogakunintei.futangendogakuninteishinsei.FutangendogakuNinteiShinseiManager;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutangendogakuNinteiService;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 負担限度額認定申請画面ハンドラクラスです。
 *
 * @reamsid_L DBD-3590-010 huangh
 */
public class FutangendogakuNinteiShinseiHandler {

    private final FutangendogakuShinseiDiv div;

    private static final RString 申請メニューID = new RString("DBDMN21001");
    private static final RString 共通エリア_保存する = new RString("btnUpdate");
    private static final RString 拡張情報NAME = new RString("被保険者番号");
    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_EMPTYKEY = RString.EMPTY;
    private static final RString 追加状態 = new RString("Added");
    private static final RString 修正状態 = new RString("Modified");
    private static final int INT_4 = 4;
    private static final RString 認定なし = new RString("認定なし");

    /**
     * コンストラクタです。
     *
     * @param div 負担限度額認定申請画面Div
     */
    public FutangendogakuNinteiShinseiHandler(FutangendogakuShinseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 申請一覧情報ArrayList ArrayList<FutanGendogakuNintei>
     * @return ArrayList<FutanGendogakuNinteiViewState>
     */
    public ArrayList<FutanGendogakuNinteiViewState> onLoad(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            ArrayList<FutanGendogakuNintei> 申請一覧情報ArrayList) {

        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        if (申請メニューID.equals(ResponseHolder.getMenuID())) {
            div.getShinseiDetail().setTitle(new RString("申請情報"));
            div.getBtnAddShinsei().setText(new RString("申請情報を追加する"));
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(共通エリア_保存する, "申請情報を");
        } else {
            div.getShinseiDetail().setTitle(new RString("承認情報"));
            div.getBtnAddShinsei().setText(new RString("承認情報を追加する"));
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(共通エリア_保存する, "承認情報を");
        }
        div.setLockKey(new RString("DB").concat(被保険者番号.value()).concat(new RString("FutanGendoGaku")));
        RealInitialLocker.lock(new LockingKey(div.getLockKey()));
        div.getCcdAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        div.getCcdShisetsuNyushoInfo().onLoad(識別コード);

        ArrayList<FutanGendogakuNinteiViewState> new負担限度額認定申請の情報 = new ArrayList<>();
        for (FutanGendogakuNintei futanGendogakuNintei : 申請一覧情報ArrayList) {
            FutanGendogakuNintei fgn = new FutanGendogakuNintei(
                    futanGendogakuNintei.get証記載保険者番号(), futanGendogakuNintei.get被保険者番号(), futanGendogakuNintei.get履歴番号());
            fgn = copyFutanGendogakuNintei(futanGendogakuNintei, fgn, futanGendogakuNintei.get履歴番号());
            new負担限度額認定申請の情報.add(new FutanGendogakuNinteiViewState(fgn,
                    futanGendogakuNintei.getState(), futanGendogakuNintei.get履歴番号()));
        }

        set申請一覧(new負担限度額認定申請の情報);

        get利用者負担段階(申請一覧情報ArrayList);

        div.getCcdGemmenGengakuShinsei().initialize(識別コード);
        AccessLogger.log(AccessLogType.照会,
                PersonalData.of(識別コード, new ExpandedInformation(new Code("0003"), 拡張情報NAME, 被保険者番号.value())));
        return new負担限度額認定申請の情報;
    }

    /**
     * 世帯所得一覧の初期化処理です。
     *
     * @param 資格対象者 TaishoshaKey
     */
    public void 世帯所得一覧の初期化(TaishoshaKey 資格対象者) {
        YMDHMS 現在年月日日時時分秒 = YMDHMS.now();
        ShikibetsuCode 識別コード = get識別コードFromViewState(資格対象者);
        div.getCcdSetaiShotokuIchiran().initialize(識別コード,
                new FlexibleDate(現在年月日日時時分秒.getDate().toDateString()),
                new HizukeConfig().get所得年度(),
                現在年月日日時時分秒);
    }

    /**
     * 「減免情報を表示する」ボタンをクリック
     *
     * @param taishoshaKey TaishoshaKey
     */
    public void onBeforeOpenDialog_btnDispGemmenJoho(TaishoshaKey taishoshaKey) {
        div.setHihokenshaNo(get被保険者番号FromViewState(taishoshaKey).getColumnValue());
    }

    /**
     * 「申請情報を追加する」ボタンを押下
     *
     * @param 資格対象者 TaishoshaKey
     */
    public void onClick_btnAddShinsei(TaishoshaKey 資格対象者) {
        div.setJotai(追加状態);
        div.getShinseiList().setDisabled(true);
        init申請理由DDL();
        init負担段階DDL();
        init居室種別DDL();
        clear申請情報エリア(資格対象者);
        onChange_radKetteiKubun(true, 資格対象者);
        set申請情報エリア表示制御();
    }

    /**
     * 申請一覧の修正ボタンの処理
     *
     * @param 申請一覧情報ArrayList ArrayList<FutanGendogakuNinteiViewState>
     * @param 資格対象者 TaishoshaKey
     */
    public void onSelectByModifyButton(ArrayList<FutanGendogakuNinteiViewState> 申請一覧情報ArrayList,
            TaishoshaKey 資格対象者) {
        div.getShinseiList().setDisabled(true);
        div.setJotai(修正状態);
        set申請情報エリア(申請一覧情報ArrayList.get(div.getDgShinseiList().getClickedRowId()).getFutanGendogakuNintei(), 資格対象者);
        set申請情報エリア表示制御();
    }

    /**
     * 申請一覧の削除ボタンの処理
     *
     * @param list ArrayList<FutanGendogakuNinteiViewState>
     * @return ArrayList<FutanGendogakuNinteiViewState>
     */
    public ArrayList<FutanGendogakuNinteiViewState> onSelectByDeleteButton(ArrayList<FutanGendogakuNinteiViewState> list) {
        int index = div.getDgShinseiList().getClickedRowId();
        FutanGendogakuNinteiViewState ninteiViewState = list.get(index);
        if (!EntityDataState.Added.equals(ninteiViewState.getState())) {
            ninteiViewState.setState(EntityDataState.Deleted);
            list.set(index, ninteiViewState);
        } else {
            list.remove(index);
        }
        set申請一覧(list);
        return list;
    }

    /**
     * 決定区分ラジオボタンの処理
     *
     * @param is負担段階を設定 true:負担段階を再設定する false:負担段階を再設定しない
     * @param 資格対象者 TaishoshaKey
     */
    public void onChange_radKetteiKubun(boolean is負担段階を設定, TaishoshaKey 資格対象者) {
        FutangendogakuNinteiService service = FutangendogakuNinteiService.createInstance();
        if (SELECT_KEY0.equals(div.getRadKetteiKubun().getSelectedKey())) {
            div.getTxtTekiyoYMD().setDisabled(false);
            div.getTxtYukoKigenYMD().setDisabled(false);
            div.getDdlKyusochisha().setDisabled(false);
            div.getDdlRiyoshaFutanDankai().setDisabled(false);
            div.getDdlKyoshitsuShubetsu().setDisabled(false);
            div.getChkKyokaiso().setDisabled(false);
            div.getChkGekihenKanwa().setDisabled(false);
            div.getDdlShokuhi().setDisabled(false);
            div.getDdlUnitGataKoshitsu().setDisabled(false);
            div.getDdlUnitGataJunKoshitsu().setDisabled(false);
            div.getDdlJuraiGataKoshitsuTokuyo().setDisabled(false);
            div.getDdlJuraiGataKoshitsuRoken().setDisabled(false);
            div.getDdlTashoshitsu().setDisabled(false);
            div.getBtnHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().clearValue();
            init旧措置DDL();
            init居室種別DDL();
            if (is負担段階を設定) {
                init負担段階DDL();
                div.getDdlRiyoshaFutanDankai().setSelectedKey(
                        service.judge利用者負担段階(資格対象者.get被保険者番号(), 資格対象者.get識別コード()).getコード());
                onChange_ddlRiyoshaFutanDankai();
            }
        } else {
            List<KeyValueDataSource> dataSources = new ArrayList<>();
            dataSources.add(new KeyValueDataSource());
            div.getTxtTekiyoYMD().setDisabled(true);
            div.getTxtTekiyoYMD().clearValue();
            div.getTxtYukoKigenYMD().setDisabled(true);
            div.getTxtYukoKigenYMD().clearValue();
            div.getDdlKyusochisha().setDisabled(true);
            div.getDdlKyusochisha().setIsBlankLine(true);
            div.getDdlKyusochisha().setDataSource(dataSources);
            div.getDdlRiyoshaFutanDankai().setDisabled(true);
            div.getDdlRiyoshaFutanDankai().setDataSource(dataSources);
            div.getDdlKyoshitsuShubetsu().setDisabled(true);
            div.getDdlKyoshitsuShubetsu().setDataSource(dataSources);
            div.getChkKyokaiso().setDisabled(true);
            div.getChkKyokaiso().setSelectedItemsByKey(new ArrayList<RString>());
            div.getChkGekihenKanwa().setDisabled(true);
            div.getChkGekihenKanwa().setSelectedItemsByKey(new ArrayList<RString>());
            div.getDdlShokuhi().setDisabled(true);
            div.getDdlShokuhi().setDataSource(dataSources);
            div.getDdlUnitGataKoshitsu().setDisabled(true);
            div.getDdlUnitGataKoshitsu().setDataSource(dataSources);
            div.getDdlUnitGataJunKoshitsu().setDisabled(true);
            div.getDdlUnitGataJunKoshitsu().setDataSource(dataSources);
            div.getDdlJuraiGataKoshitsuTokuyo().setDisabled(true);
            div.getDdlJuraiGataKoshitsuTokuyo().setDataSource(dataSources);
            div.getDdlJuraiGataKoshitsuRoken().setDisabled(true);
            div.getDdlJuraiGataKoshitsuRoken().setDataSource(dataSources);
            div.getDdlTashoshitsu().setDisabled(true);
            div.getDdlTashoshitsu().setDataSource(dataSources);
            div.getBtnHiShoninRiyu().setDisabled(false);
            div.getTxtHiShoninRiyu().setDisabled(false);
        }
    }

    /**
     * 「申請情報を確定する」ボタンの処理
     *
     * @param list ArrayList<FutanGendogakuNinteiViewState>
     * @param 資格対象者 TaishoshaKey
     * @return ArrayList<FutanGendogakuNinteiViewState>
     */
    public ArrayList<FutanGendogakuNinteiViewState> onClick_btnShinseiKakutei(
            ArrayList<FutanGendogakuNinteiViewState> list,
            TaishoshaKey 資格対象者) {
        ArrayList<FutanGendogakuNinteiViewState> resultList = putEdited申請情報ToViewState(true, list, 資格対象者);
        div.setJotai(RString.EMPTY);
        div.getShinseiList().setDisabled(false);
        return resultList;
    }

    /**
     * 「検索結果一覧へ」ボタンの処理
     *
     * @param list ArrayList<FutanGendogakuNinteiViewState>
     * @param 資格対象者 TaishoshaKey
     * @return ArrayList<FutanGendogakuNinteiViewState>
     */
    public ArrayList<FutanGendogakuNinteiViewState> onClick_btnToSearchResult(
            ArrayList<FutanGendogakuNinteiViewState> list,
            TaishoshaKey 資格対象者) {
        ArrayList<FutanGendogakuNinteiViewState> resultList = putEdited申請情報ToViewState(false, list, 資格対象者);
        div.setJotai(RString.EMPTY);
        return resultList;
    }

    /**
     * 申請情報を保存する
     *
     * @param 申請一覧情報ArrayList ArrayList<FutanGendogakuNintei>
     * @param new認定申請情報List ArrayList<FutanGendogakuNinteiViewState>
     * @param 資格対象者 TaishoshaKey
     */
    public void 申請情報を保存する(
            ArrayList<FutanGendogakuNintei> 申請一覧情報ArrayList,
            ArrayList<FutanGendogakuNinteiViewState> new認定申請情報List,
            TaishoshaKey 資格対象者) {
        HihokenshaNo 被保険者番号 = get被保険者番号FromViewState(資格対象者);
        AccessLogger.log(
                AccessLogType.更新,
                PersonalData.of(
                        get識別コードFromViewState(資格対象者),
                        new ExpandedInformation(new Code("003"), 拡張情報NAME, 被保険者番号.value())));
        FutangendogakuNinteiShinseiManager.createInstance().save(申請一覧情報ArrayList, new認定申請情報List, 被保険者番号);
        RealInitialLocker.release(new LockingKey(div.getLockKey()));
    }

    /**
     * 「クリアする」ボタンの処理
     */
    public void onChange_ddlRiyoshaFutanDankai() {
        if (RiyoshaFutanDankai.課税層第三段階.getコード().equals(div.getDdlRiyoshaFutanDankai().getSelectedKey())) {
            div.getChkKyokaiso().setDisabled(true);
        } else {
            div.getChkKyokaiso().setDisabled(false);
        }
        init食費DDL(div.getDdlKyusochisha().getSelectedKey(), div.getDdlRiyoshaFutanDankai().getSelectedKey());
        initユニット型個室DDL(div.getDdlKyusochisha().getSelectedKey(), div.getDdlRiyoshaFutanDankai().getSelectedKey());
        initユニット型準個室DDL(div.getDdlKyusochisha().getSelectedKey(), div.getDdlRiyoshaFutanDankai().getSelectedKey());
        init従来型個室_特養等DDL(div.getDdlKyusochisha().getSelectedKey(), div.getDdlRiyoshaFutanDankai().getSelectedKey());
        init従来型個室_老健療養等DDL(div.getDdlKyusochisha().getSelectedKey(), div.getDdlRiyoshaFutanDankai().getSelectedKey());
        init多床室DDL(div.getDdlKyusochisha().getSelectedKey(), div.getDdlRiyoshaFutanDankai().getSelectedKey());
    }

    /**
     * 「情報を設定する」ボタンの処理
     *
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnHaigushaJohoSet() {
        HaiguuJohoEntity 配偶者Entity = FutangendogakuNinteiService.createInstance().find配偶者(
                div.getCcdAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近());
        if (配偶者Entity == null || !配偶者Entity.isExists()) {
            div.getRadHaigushaUmu().setSelectedKey(SELECT_KEY1);
            div.getTxtHaigushaShikibetsuCode().clearDomain();
            div.getTxtHaigushaShimeiKana().clearDomain();
            div.getTxtHaigushaShimei().clearDomain();
            div.getTxtHaigushaUmareYMD().clearValue();
            div.getTxtHaigushaRenrakusaki().clearDomain();
            div.getTxtHaigushaJusho1().clearDomain();
            div.getTxtHaigushaJusho2().clearDomain();
            div.getRadHaigushaUmu().setDisabled(true);
            div.getTxtHaigushaShikibetsuCode().setDisabled(true);
            div.getTxtHaigushaShimeiKana().setDisabled(true);
            div.getTxtHaigushaShimei().setDisabled(true);
            div.getTxtHaigushaUmareYMD().setDisabled(true);
            div.getTxtHaigushaRenrakusaki().setDisabled(true);
            div.getTxtHaigushaJusho1().setDisabled(true);
            div.getTxtHaigushaJusho2().setDisabled(true);
            return ResponseData.of(div).addMessage(DbdInformationMessages.配偶者_取得失敗.getMessage()).respond();
        } else if (HaigushaKazeiKubun.空白.getコード().equals(配偶者Entity.get課税区分())) {
            div.getRadHaigushaUmu().setSelectedKey(SELECT_KEY0);
            div.getTxtHaigushaShikibetsuCode().setDomain(配偶者Entity.get個人().get識別コード());
            div.getTxtHaigushaShimeiKana().setDomain(配偶者Entity.get個人().get名称().getKana());
            div.getTxtHaigushaShimei().setDomain(配偶者Entity.get個人().get名称().getName());
            div.getTxtHaigushaUmareYMD().setValue(new RDate(配偶者Entity.get個人().get生年月日().toFlexibleDate().toString()));
            div.getTxtHaigushaRenrakusaki().setDomain(配偶者Entity.get個人().get連絡先１());
            div.getTxtHaigushaJusho1().setDomain(new AtenaJusho(配偶者Entity.get個人().get住所().get住所()));
            div.getTxtHaigushaJusho2().setDomain(new AtenaJusho(配偶者Entity.get現住所と異なる本年1月1日住所()));
            div.getRadHaigushaKazeiKubun().clearSelectedItem();
            div.getRadHaigushaUmu().setDisabled(false);
            div.getTxtHaigushaShikibetsuCode().setDisabled(false);
            div.getTxtHaigushaShimeiKana().setDisabled(false);
            div.getTxtHaigushaShimei().setDisabled(false);
            div.getTxtHaigushaUmareYMD().setDisabled(false);
            div.getTxtHaigushaRenrakusaki().setDisabled(false);
            div.getTxtHaigushaJusho1().setDisabled(false);
            div.getTxtHaigushaJusho2().setDisabled(false);
            AccessLogger.log(AccessLogType.照会, PersonalData.of(配偶者Entity.get個人().get識別コード()));
            return ResponseData.of(div).addMessage(DbdInformationMessages.配偶者_所得_取得失敗.getMessage()).respond();
        } else {
            div.getRadHaigushaUmu().setSelectedKey(SELECT_KEY0);
            div.getTxtHaigushaShikibetsuCode().setDomain(配偶者Entity.get個人().get識別コード());
            div.getTxtHaigushaShimeiKana().setDomain(配偶者Entity.get個人().get名称().getKana());
            div.getTxtHaigushaShimei().setDomain(配偶者Entity.get個人().get名称().getName());
            div.getTxtHaigushaUmareYMD().setValue(new RDate(配偶者Entity.get個人().get生年月日().toFlexibleDate().toString()));
            div.getTxtHaigushaRenrakusaki().setDomain(配偶者Entity.get個人().get連絡先１());
            div.getTxtHaigushaJusho1().setDomain(new AtenaJusho(配偶者Entity.get個人().get住所().get住所()));
            div.getTxtHaigushaJusho2().setDomain(new AtenaJusho(配偶者Entity.get現住所と異なる本年1月1日住所()));
            div.getRadHaigushaKazeiKubun().setSelectedKey(配偶者Entity.get課税区分());
            div.getRadHaigushaUmu().setDisabled(false);
            div.getTxtHaigushaShikibetsuCode().setDisabled(false);
            div.getTxtHaigushaShimeiKana().setDisabled(false);
            div.getTxtHaigushaShimei().setDisabled(false);
            div.getTxtHaigushaUmareYMD().setDisabled(false);
            div.getTxtHaigushaRenrakusaki().setDisabled(false);
            div.getTxtHaigushaJusho1().setDisabled(false);
            div.getTxtHaigushaJusho2().setDisabled(false);
            AccessLogger.log(AccessLogType.照会, PersonalData.of(配偶者Entity.get個人().get識別コード()));
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「配偶者の有無」ボタンの処理
     */
    public void onChange_radHaigushaUmu() {
        if (SELECT_KEY1.equals(div.getRadHaigushaUmu().getSelectedKey())) {
            div.getTxtHaigushaShimeiKana().setDisabled(true);
            div.getTxtHaigushaShimeiKana().clearDomain();
            div.getTxtHaigushaShimei().setDisabled(true);
            div.getTxtHaigushaShimei().clearDomain();
            div.getTxtHaigushaUmareYMD().setDisabled(true);
            div.getTxtHaigushaUmareYMD().clearValue();
            div.getTxtHaigushaRenrakusaki().setDisabled(true);
            div.getTxtHaigushaRenrakusaki().clearDomain();
            div.getTxtHaigushaJusho1().setDisabled(true);
            div.getTxtHaigushaJusho1().clearDomain();
            div.getTxtHaigushaJusho2().setDisabled(true);
            div.getTxtHaigushaJusho2().clearDomain();
            div.getRadHaigushaKazeiKubun().setDisabled(true);
            div.getRadHaigushaKazeiKubun().setSelectedKey(SELECT_KEY0);
        } else {
            div.getTxtHaigushaShimeiKana().setDisabled(false);
            div.getTxtHaigushaShimei().setDisabled(false);
            div.getTxtHaigushaUmareYMD().setDisabled(false);
            div.getTxtHaigushaRenrakusaki().setDisabled(false);
            div.getTxtHaigushaJusho1().setDisabled(false);
            div.getTxtHaigushaJusho2().setDisabled(false);
            div.getRadHaigushaKazeiKubun().setDisabled(false);
        }
    }

    private void set申請情報エリア(FutanGendogakuNintei futanGendogakuNintei, TaishoshaKey 資格対象者) {
        div.getTxtShinseiYMD().setValue(futanGendogakuNintei.get申請年月日());
        init申請理由DDL();
        div.getDdlShinseiRiyu().setSelectedKey(futanGendogakuNintei.get申請理由区分());
        div.getCcdGemmenGengakuShinsei().initialize(get識別コードFromViewState(資格対象者));
        GemmenGengakuShinsei gemmenGengakuShinsei;
        if (!futanGendogakuNintei.getGemmenGengakuShinseiList().isEmpty()) {
            gemmenGengakuShinsei = futanGendogakuNintei.getGemmenGengakuShinseiList().get(0);
            ShinseiJoho shinseiJoho = new ShinseiJoho(
                    gemmenGengakuShinsei.get申請届出代行区分() == null
                    ? null : ShinseiTodokedeDaikoKubunCode.toValue(gemmenGengakuShinsei.get申請届出代行区分()),
                    gemmenGengakuShinsei.get申請届出者氏名(), gemmenGengakuShinsei.get申請届出者氏名カナ(), gemmenGengakuShinsei.get申請届出者続柄(),
                    gemmenGengakuShinsei.get申請届出代行事業者番号(),
                    gemmenGengakuShinsei.get事業者区分() == null ? null : JigyoshaKubun.toValue(gemmenGengakuShinsei.get事業者区分()),
                    gemmenGengakuShinsei.get申請届出者郵便番号(),
                    gemmenGengakuShinsei.get申請届出者住所(),
                    gemmenGengakuShinsei.get申請届出者電話番号());
            div.getCcdGemmenGengakuShinsei().set減免減額申請情報(shinseiJoho, futanGendogakuNintei.get申請年月日());
        }
        div.getRadHaigushaUmu().setSelectedKey(futanGendogakuNintei.is配偶者の有無() ? SELECT_KEY0 : SELECT_KEY1);
        if (futanGendogakuNintei.is配偶者の有無()) {
            div.getTxtHaigushaShikibetsuCode().setDomain(futanGendogakuNintei.get配偶者識別コード());
            div.getTxtHaigushaShimeiKana().setDomain(futanGendogakuNintei.get配偶者氏名カナ());
            div.getTxtHaigushaShimei().setDomain(futanGendogakuNintei.get配偶者氏名());

            if (futanGendogakuNintei.get配偶者生年月日() != null && futanGendogakuNintei.get配偶者生年月日().isValid()) {
                div.getTxtHaigushaUmareYMD().setValue(new RDate(futanGendogakuNintei.get配偶者生年月日().toString()));
            }
            div.getTxtHaigushaRenrakusaki().setDomain(
                    new TelNo(futanGendogakuNintei.get配偶者連絡先() == null ? RString.EMPTY : futanGendogakuNintei.get配偶者連絡先()));
            div.getTxtHaigushaJusho1().setDomain(futanGendogakuNintei.get配偶者住所());
            div.getTxtHaigushaJusho2().setDomain(futanGendogakuNintei.get配偶者住所２());
            div.getRadHaigushaKazeiKubun().setSelectedKey(
                    HaigushaKazeiKubun.課税.getコード().equals(futanGendogakuNintei.get配偶者課税区分()) ? SELECT_KEY0 : SELECT_KEY1);
        }
        List<RString> keys = new ArrayList<>();
        if (YochokinShinkokuKubun.以下.getコード().equals(futanGendogakuNintei.get預貯金申告区分())) {
            keys.add(new RString("key0"));
        }
        div.getChkYochokinKijunIka().setSelectedItemsByKey(keys);
        div.getTxtYochokinGaku().setValue(futanGendogakuNintei.get預貯金額());
        div.getTxtYukaShoken().setValue(futanGendogakuNintei.get有価証券評価概算額());
        div.getTxtSonota().setValue(futanGendogakuNintei.getその他金額());
        div.getRadKetteiKubun().setSelectedKey(
                KetteiKubun.承認する.getコード().equals(futanGendogakuNintei.get決定区分()) ? SELECT_KEY0 : SELECT_KEY1);
        onChange_radKetteiKubun(false, 資格対象者);
        div.getTxtKetteiYMD().setValue(futanGendogakuNintei.get決定年月日());
        div.getTxtTekiyoYMD().setValue(futanGendogakuNintei.get適用開始年月日());
        div.getTxtYukoKigenYMD().setValue(futanGendogakuNintei.get適用終了年月日());
        init旧措置DDL();
        div.getDdlKyusochisha().setSelectedKey(futanGendogakuNintei.get旧措置者区分());
        init負担段階DDL();
        div.getDdlRiyoshaFutanDankai().setSelectedKey(futanGendogakuNintei.get利用者負担段階());
        init居室種別DDL();
        div.getDdlKyoshitsuShubetsu().setSelectedKey(futanGendogakuNintei.get居室種別());
        div.getChkKyokaiso().setDisabled(RiyoshaFutanDankai.課税層第三段階.getコード().equals(futanGendogakuNintei.get利用者負担段階()));
        List<RString> dataSource = new ArrayList<>();
        if (futanGendogakuNintei.is境界層該当者区分()) {
            dataSource.add(SELECT_KEY0);
        }
        div.getChkKyokaiso().setSelectedItemsByKey(dataSource);
        div.getChkGekihenKanwa().setDisabled(!is平成18年or平成19年(futanGendogakuNintei.get申請年月日()));
        init食費DDL(futanGendogakuNintei.get旧措置者区分(), futanGendogakuNintei.get利用者負担段階());
        if (futanGendogakuNintei.get食費負担限度額() != null) {
            div.getDdlShokuhi().setSelectedValue(new RString(futanGendogakuNintei.get食費負担限度額().toString()).padZeroToLeft(INT_4));
        }
        initユニット型個室DDL(futanGendogakuNintei.get旧措置者区分(), futanGendogakuNintei.get利用者負担段階());
        if (futanGendogakuNintei.getユニット型個室() != null) {
            div.getDdlUnitGataKoshitsu().setSelectedValue(new RString(futanGendogakuNintei.getユニット型個室().toString()).padZeroToLeft(INT_4));
        }
        initユニット型準個室DDL(futanGendogakuNintei.get旧措置者区分(), futanGendogakuNintei.get利用者負担段階());
        if (futanGendogakuNintei.getユニット型準個室() != null) {
            div.getDdlUnitGataJunKoshitsu().setSelectedValue(new RString(futanGendogakuNintei.getユニット型準個室().toString()).padZeroToLeft(INT_4));
        }
        init従来型個室_特養等DDL(futanGendogakuNintei.get旧措置者区分(), futanGendogakuNintei.get利用者負担段階());
        if (futanGendogakuNintei.get従来型個室_特養等() != null) {
            div.getDdlJuraiGataKoshitsuTokuyo().setSelectedValue(
                    new RString(futanGendogakuNintei.get従来型個室_特養等().toString()).padZeroToLeft(INT_4));
        }
        init従来型個室_老健療養等DDL(futanGendogakuNintei.get旧措置者区分(), futanGendogakuNintei.get利用者負担段階());
        if (futanGendogakuNintei.get従来型個室_老健_療養等() != null) {
            div.getDdlJuraiGataKoshitsuRoken().setSelectedValue(
                    new RString(futanGendogakuNintei.get従来型個室_老健_療養等().toString()).padZeroToLeft(INT_4));
        }
        init多床室DDL(futanGendogakuNintei.get旧措置者区分(), futanGendogakuNintei.get利用者負担段階());
        if (futanGendogakuNintei.get多床室() != null) {
            div.getDdlTashoshitsu().setSelectedValue(new RString(futanGendogakuNintei.get多床室().toString()).padZeroToLeft(INT_4));
        }
        div.getTxtHiShoninRiyu().setValue(futanGendogakuNintei.get非承認理由());

    }

    private ShoKisaiHokenshaNo get証記載保険者番号(FlexibleDate 申請日) {

        HokenshaListLoader loader = HokenshaListLoader.createInstance();
        HokenshaList hokenshaList = loader.getShichosonCodeNameList(GyomuBunrui.介護事務);

        HihokenshaDaichoManager manager = new HihokenshaDaichoManager();
        HihokenshaDaicho daicho = manager.find最新被保険者台帳(申請日);
        if (daicho == null) {
            return new ShoKisaiHokenshaNo(RString.EMPTY);
        }
        if (daicho.get広住特措置元市町村コード() != null && !daicho.get広住特措置元市町村コード().isEmpty()) {
            return hokenshaList.get(daicho.get広住特措置元市町村コード()).get証記載保険者番号();
        }
        return hokenshaList.get(daicho.get市町村コード()).get証記載保険者番号();
    }

    private FutanGendogakuNintei 申請情報Builder(FutanGendogakuNintei futanGendogakuNintei) {
        FutanGendogakuNinteiBuilder builder = futanGendogakuNintei.createBuilderForEdit();
        builder.set申請年月日(div.getTxtShinseiYMD().getValue());
        builder.set申請理由区分(div.getDdlShinseiRiyu().getSelectedKey());
        builder.set配偶者の有無(SELECT_KEY0.equals(div.getRadHaigushaUmu().getSelectedKey()));
        builder.set配偶者識別コード(div.getTxtHaigushaShikibetsuCode().getDomain());
        builder.set配偶者氏名カナ(div.getTxtHaigushaShimeiKana().getDomain());
        builder.set配偶者氏名(div.getTxtHaigushaShimei().getDomain());

        RDate 配偶者生年月日 = div.getTxtHaigushaUmareYMD().getValue();
        builder.set配偶者生年月日(配偶者生年月日 == null ? null : new FlexibleDate(配偶者生年月日.toString()));
        builder.set配偶者連絡先(div.getTxtHaigushaRenrakusaki().getDomain().getColumnValue());
        builder.set配偶者住所(div.getTxtHaigushaJusho1().getDomain());
        builder.set配偶者住所２(div.getTxtHaigushaJusho2().getDomain());
        builder.set配偶者課税区分(
                SELECT_KEY0.equals(div.getRadHaigushaKazeiKubun().getSelectedKey())
                ? HaigushaKazeiKubun.課税.getコード() : HaigushaKazeiKubun.非課税.getコード());
        if (div.getChkYochokinKijunIka().getSelectedKeys().isEmpty()) {
            builder.set預貯金申告区分(YochokinShinkokuKubun.以下.getコード());
        } else {
            builder.set預貯金申告区分(YochokinShinkokuKubun.超過.getコード());
        }
        builder.set預貯金額(div.getTxtYochokinGaku().getValue());
        builder.set有価証券評価概算額(div.getTxtYukaShoken().getValue());
        builder.setその他金額(div.getTxtSonota().getValue());
        if (SELECT_KEY0.equals(div.getRadKetteiKubun().getSelectedKey())) {
            builder.set決定区分(KetteiKubun.承認する.getコード());
        } else {
            builder.set決定区分(KetteiKubun.承認しない.getコード());
        }
        builder.set決定年月日(div.getTxtKetteiYMD().getValue());
        if (申請メニューID.equals(ResponseHolder.getMenuID())) {
            builder.set決定区分(RString.EMPTY);
            builder.set決定年月日(FlexibleDate.EMPTY);
        }
        builder.set適用開始年月日(div.getTxtTekiyoYMD().getValue());
        builder.set適用終了年月日(div.getTxtYukoKigenYMD().getValue());
        builder.set旧措置者区分(div.getDdlKyusochisha().getSelectedKey());
        builder.set利用者負担段階(div.getDdlRiyoshaFutanDankai().getSelectedKey());
        builder.set居室種別(div.getDdlKyoshitsuShubetsu().getSelectedKey());
        builder.set食費負担限度額(
                div.getDdlShokuhi().getSelectedValue().isNullOrEmpty()
                ? null : new Decimal(div.getDdlShokuhi().getSelectedValue().toString()));
        builder.setユニット型個室(
                div.getDdlUnitGataKoshitsu().getSelectedValue().isNullOrEmpty()
                ? null : new Decimal(div.getDdlUnitGataKoshitsu().getSelectedValue().toString()));
        builder.setユニット型準個室(
                div.getDdlUnitGataJunKoshitsu().getSelectedValue().isNullOrEmpty()
                ? null : new Decimal(div.getDdlUnitGataJunKoshitsu().getSelectedValue().toString()));
        builder.set従来型個室_特養等(
                div.getDdlJuraiGataKoshitsuTokuyo().getSelectedValue().isNullOrEmpty()
                ? null : new Decimal(div.getDdlJuraiGataKoshitsuTokuyo().getSelectedValue().toString()));
        builder.set従来型個室_老健_療養等(
                div.getDdlJuraiGataKoshitsuRoken().getSelectedValue().isNullOrEmpty()
                ? null : new Decimal(div.getDdlJuraiGataKoshitsuRoken().getSelectedValue().toString()));
        builder.set多床室(
                div.getDdlTashoshitsu().getSelectedValue().isNullOrEmpty()
                ? null : new Decimal(div.getDdlTashoshitsu().getSelectedValue().toString()));
        builder.set非承認理由(div.getTxtHiShoninRiyu().getValue() == null ? RString.EMPTY : div.getTxtHiShoninRiyu().getValue());
        builder.set境界層該当者区分(!div.getChkKyokaiso().getSelectedValues().isEmpty());
        builder.set激変緩和措置対象者区分(!div.getChkGekihenKanwa().getSelectedValues().isEmpty());

        GemmenGengakuShinsei gemmenGengakuShinsei = new GemmenGengakuShinsei(
                futanGendogakuNintei.get証記載保険者番号(),
                futanGendogakuNintei.get被保険者番号(),
                GemmenGengakuShurui.負担限度額認定.getコード(),
                futanGendogakuNintei.get履歴番号());
        GemmenGengakuShinseiBuilder genmenBuilder = gemmenGengakuShinsei.createBuilderForEdit();
        if (div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出代行区分() != null) {
            genmenBuilder.set申請届出代行区分(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出代行区分().getCode());
        }
        genmenBuilder.set申請届出者氏名(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出者氏名());
        genmenBuilder.set申請届出者氏名カナ(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出者氏名カナ());
        genmenBuilder.set申請届出者続柄(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出者続柄());
        JigyoshaNo 事業者番号 = div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出代行事業者番号();
        if (!事業者番号.isEmpty()) {
            genmenBuilder.set申請届出代行事業者番号(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出代行事業者番号());
        }
        if (div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get事業者区分() != null) {
            genmenBuilder.set事業者区分(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get事業者区分().getCode());
        }
        genmenBuilder.set申請届出者郵便番号(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出者郵便番号());
        genmenBuilder.set申請届出者住所(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出者住所());
        genmenBuilder.set申請届出者電話番号(div.getCcdGemmenGengakuShinsei().get減免減額申請情報().get申請届出者電話番号());

        builder.setGemmenGengakuShinsei(genmenBuilder.build());
        return builder.build();
    }

    private boolean is平成18年or平成19年(FlexibleDate 申請年月日) {
        return 申請年月日.getYear().equals(new FlexibleDate("平成180101").getYear())
                || 申請年月日.getYear().equals(new FlexibleDate("平成190101").getYear());
    }

    private void init多床室DDL(RString 旧措置者区分, RString 利用者負担段階) {
        List<RString> list = FutangendogakuNinteiService.createInstance().load多床室負担限度額候補(
                旧措置者区分, FlexibleDate.getNowDate(), 利用者負担段階);
        div.getDdlTashoshitsu().setDataSource(createDataSourceList(list));
        div.getDdlTashoshitsu().setIsBlankLine(true);
    }

    private void init従来型個室_老健療養等DDL(RString 旧措置者区分, RString 利用者負担段階) {
        List<RString> list = FutangendogakuNinteiService.createInstance().load従来型個室老健等負担限度額候補(
                旧措置者区分, FlexibleDate.getNowDate(), 利用者負担段階);
        div.getDdlJuraiGataKoshitsuRoken().setDataSource(createDataSourceList(list));
        div.getDdlJuraiGataKoshitsuRoken().setIsBlankLine(true);
    }

    private void init従来型個室_特養等DDL(RString 旧措置者区分, RString 利用者負担段階) {
        List<RString> list = FutangendogakuNinteiService.createInstance().load従来型個室特養等負担限度額候補(
                旧措置者区分, FlexibleDate.getNowDate(), 利用者負担段階);
        div.getDdlJuraiGataKoshitsuTokuyo().setDataSource(createDataSourceList(list));
        div.getDdlJuraiGataKoshitsuTokuyo().setIsBlankLine(true);
    }

    private void initユニット型準個室DDL(RString 旧措置者区分, RString 利用者負担段階) {
        List<RString> list = FutangendogakuNinteiService.createInstance().loadユニット型準個室負担限度額候補(
                旧措置者区分, FlexibleDate.getNowDate(), 利用者負担段階);
        div.getDdlUnitGataJunKoshitsu().setDataSource(createDataSourceList(list));
        div.getDdlUnitGataJunKoshitsu().setIsBlankLine(true);
    }

    private void initユニット型個室DDL(RString 旧措置者区分, RString 利用者負担段階) {
        List<RString> list = FutangendogakuNinteiService.createInstance().loadユニット型個室負担限度額候補(
                旧措置者区分, FlexibleDate.getNowDate(), 利用者負担段階);
        div.getDdlUnitGataKoshitsu().setDataSource(createDataSourceList(list));
        div.getDdlUnitGataKoshitsu().setIsBlankLine(true);
    }

    private void init食費DDL(RString 旧措置者区分, RString 利用者負担段階) {
        List<RString> list = FutangendogakuNinteiService.createInstance().load食費負担限度額候補(
                旧措置者区分, FlexibleDate.getNowDate(), 利用者負担段階);
        div.getDdlShokuhi().setDataSource(createDataSourceList(list));
        div.getDdlKyoshitsuShubetsu().setIsBlankLine(true);
    }

    private List<KeyValueDataSource> createDataSourceList(List<RString> list) {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        int key = 0;
        for (RString 金額 : list) {
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString("key" + key), 金額);
            dataSources.add(dataSource);
            key++;
        }
        return dataSources;
    }

    private void init居室種別DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(getEmptyDataSource());
        for (KyoshitsuShubetsu shubetsu : KyoshitsuShubetsu.values()) {
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(shubetsu.getコード());
            source.setValue(shubetsu.get名称());
            dataSource.add(source);
        }
        div.getDdlKyoshitsuShubetsu().setDataSource(dataSource);
        div.getDdlKyoshitsuShubetsu().setIsBlankLine(true);
        div.getDdlKyoshitsuShubetsu().setSelectedKey(SELECT_EMPTYKEY);
    }

    private void init旧措置DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (KyuSochishaKubun kubun : KyuSochishaKubun.values()) {
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(kubun.getコード());
            source.setValue(kubun.get名称());
            dataSource.add(source);
        }
        div.getDdlKyusochisha().setDataSource(dataSource);
        div.getDdlKyusochisha().setSelectedKey(KyuSochishaKubun.非該当.getコード());
    }

    private void init負担段階DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(getEmptyDataSource());
        for (RiyoshaFutanDankai dankai : RiyoshaFutanDankai.values()) {
            if (RiyoshaFutanDankai.第四段階.equals(dankai)) {
                continue;
            }
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(dankai.getコード());
            source.setValue(dankai.get名称());
            dataSource.add(source);
        }
        div.getDdlRiyoshaFutanDankai().setDataSource(dataSource);
        div.getDdlRiyoshaFutanDankai().setIsBlankLine(true);
        div.getDdlRiyoshaFutanDankai().setSelectedKey(SELECT_EMPTYKEY);
    }

    private void init申請理由DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(getEmptyDataSource());
        for (ShinseiRiyuKubun riyuKubun : ShinseiRiyuKubun.values()) {
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(riyuKubun.getコード());
            source.setValue(riyuKubun.get名称());
            dataSource.add(source);
        }
        div.getDdlShinseiRiyu().setDataSource(dataSource);
        div.getDdlShinseiRiyu().setIsBlankLine(true);
        div.getDdlShinseiRiyu().setSelectedKey(SELECT_EMPTYKEY);
    }

    private KeyValueDataSource getEmptyDataSource() {
        return new KeyValueDataSource(SELECT_EMPTYKEY, RString.EMPTY);
    }

    private void set申請一覧(ArrayList<FutanGendogakuNinteiViewState> 申請一覧情報ArrayList) {
        List<dgShinseiList_Row> list = new ArrayList<>();
        dgShinseiList_Row row;
        for (FutanGendogakuNinteiViewState ninteiViewState : 申請一覧情報ArrayList) {
            FutanGendogakuNintei futanGendogakuNintei = ninteiViewState.getFutanGendogakuNintei();
            TextBoxFlexibleDate 申請年月日 = new TextBoxFlexibleDate();
            申請年月日.setValue(futanGendogakuNintei.get申請年月日());
            if (EntityDataState.Added.equals(futanGendogakuNintei.getState())) {
                申請年月日.setReadOnly(false);
            } else {
                申請年月日.setReadOnly(true);
            }
            TextBoxFlexibleDate 決定日 = new TextBoxFlexibleDate();
            決定日.setValue(futanGendogakuNintei.get決定年月日());
            TextBoxFlexibleDate 適用日 = new TextBoxFlexibleDate();
            適用日.setValue(futanGendogakuNintei.get適用開始年月日());
            TextBoxFlexibleDate 有効期限 = new TextBoxFlexibleDate();
            有効期限.setValue(futanGendogakuNintei.get適用終了年月日());
            TextBoxNum 食費負担限度額 = new TextBoxNum();
            食費負担限度額.setValue(futanGendogakuNintei.get食費負担限度額());
            TextBoxNum ユニット型準個室 = new TextBoxNum();
            ユニット型準個室.setValue(futanGendogakuNintei.getユニット型準個室());
            TextBoxNum ユニット型個室 = new TextBoxNum();
            ユニット型個室.setValue(futanGendogakuNintei.getユニット型個室());
            TextBoxNum 従来型個室_特養等 = new TextBoxNum();
            従来型個室_特養等.setValue(futanGendogakuNintei.get従来型個室_特養等());
            TextBoxNum 従来型個室_老健_療養等 = new TextBoxNum();
            従来型個室_老健_療養等.setValue(futanGendogakuNintei.get従来型個室_老健_療養等());
            TextBoxNum 多床室 = new TextBoxNum();
            多床室.setValue(futanGendogakuNintei.get多床室());
            row = new dgShinseiList_Row(
                    get状態(ninteiViewState.getState()),
                    申請年月日,
                    SELECT_EMPTYKEY.equals(futanGendogakuNintei.get申請理由区分())
                    ? RString.EMPTY : ShinseiRiyuKubun.toValue(futanGendogakuNintei.get申請理由区分()).get名称(),
                    get配偶者課税区分(futanGendogakuNintei),
                    YochokinShinkokuKubun.超過.getコード().equals(futanGendogakuNintei.get預貯金申告区分()),
                    SELECT_EMPTYKEY.equals(futanGendogakuNintei.get決定区分())
                    ? RString.EMPTY : KetteiKubun.toValue(futanGendogakuNintei.get決定区分()).get名称(),
                    決定日,
                    適用日,
                    有効期限,
                    KyuSochishaKubun.非該当.getコード().equals(futanGendogakuNintei.get旧措置者区分()),
                    SELECT_EMPTYKEY.equals(futanGendogakuNintei.get利用者負担段階())
                    ? RString.EMPTY : RiyoshaFutanDankai.toValue(futanGendogakuNintei.get利用者負担段階()).get略称(),
                    SELECT_EMPTYKEY.equals(futanGendogakuNintei.get居室種別())
                    ? RString.EMPTY : KyoshitsuShubetsu.toValue(futanGendogakuNintei.get居室種別()).get名称(),
                    futanGendogakuNintei.is境界層該当者区分(),
                    futanGendogakuNintei.is激変緩和措置対象者区分(),
                    食費負担限度額,
                    ユニット型個室,
                    ユニット型準個室,
                    従来型個室_特養等,
                    従来型個室_老健_療養等,
                    多床室,
                    futanGendogakuNintei.get非承認理由());
            list.add(row);
        }
        div.getDgShinseiList().setDataSource(list);
    }

    private RString get状態(EntityDataState jotai) {
        if (EntityDataState.Added.equals(jotai)) {
            return new RString("追加");
        } else if (EntityDataState.Deleted.equals(jotai)) {
            return new RString("削除");
        } else if (EntityDataState.Modified.equals(jotai)) {
            return new RString("修正");
        } else {
            return RString.EMPTY;
        }
    }

    private RString get配偶者課税区分(FutanGendogakuNintei futanGendogakuNintei) {
        if (futanGendogakuNintei.is配偶者の有無()) {
            return HaigushaKazeiKubun.toValue(futanGendogakuNintei.get配偶者課税区分()).get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private ShikibetsuCode get識別コードFromViewState(TaishoshaKey 資格対象者) {
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        return 識別コード;
    }

    private HihokenshaNo get被保険者番号FromViewState(TaishoshaKey 資格対象者) {
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        if (null == 被保険者番号) {
            被保険者番号 = HihokenshaNo.EMPTY;
        }
        div.setHihokenshaNo(被保険者番号.getColumnValue());
        return 被保険者番号;
    }

    /**
     * 申請一覧情報を取得する
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<FutanGendogakuNintei>
     */
    public List<FutanGendogakuNintei> get申請一覧情報(HihokenshaNo 被保険者番号) {
        return FutangendogakuNinteiService.createInstance().load負担限度額認定申請All(被保険者番号);
    }

    private void set申請情報エリア表示制御() {
        onChange_radHaigushaUmu();
        if (申請メニューID.equals(ResponseHolder.getMenuID())) {
            div.getRadKetteiKubun().setDisabled(true);
            div.getTxtKetteiYMD().setDisabled(true);
            div.getTxtTekiyoYMD().setDisabled(true);
            div.getTxtYukoKigenYMD().setDisabled(true);
            div.getDdlKyusochisha().setDisabled(true);
            div.getDdlRiyoshaFutanDankai().setDisabled(true);
            div.getDdlKyoshitsuShubetsu().setDisabled(true);
            div.getChkKyokaiso().setDisabled(true);
            div.getChkGekihenKanwa().setDisabled(true);
            div.getDdlShokuhi().setDisabled(true);
            div.getDdlUnitGataKoshitsu().setDisabled(true);
            div.getDdlUnitGataJunKoshitsu().setDisabled(true);
            div.getDdlJuraiGataKoshitsuTokuyo().setDisabled(true);
            div.getDdlJuraiGataKoshitsuRoken().setDisabled(true);
            div.getDdlTashoshitsu().setDisabled(true);
            div.getBtnHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
            div.getBtnShinseiKakutei().setDisplayNone(false);
            div.getBtnShoninKakutei().setDisplayNone(true);
        } else {
            div.getRadKetteiKubun().setDisabled(false);
            div.getTxtKetteiYMD().setDisabled(false);
            div.getBtnShinseiKakutei().setDisplayNone(true);
            div.getBtnShoninKakutei().setDisplayNone(false);
        }
    }

    private ArrayList<FutanGendogakuNinteiViewState> putEdited申請情報ToViewState(boolean is申請一覧表示,
            ArrayList<FutanGendogakuNinteiViewState> list, TaishoshaKey 資格対象者) {
        if (修正状態.equals(div.getJotai())) {
            int index = div.getDgShinseiList().getClickedRowId();
            FutanGendogakuNinteiViewState ninteiViewState = list.get(index);
            FutanGendogakuNintei futanGendogakuNintei = ninteiViewState.getFutanGendogakuNintei();
            FutanGendogakuNintei 申請情報 = 申請情報Builder(futanGendogakuNintei);
            申請情報 = 申請情報.modifiedModel();
            ninteiViewState.setFutanGendogakuNintei(申請情報);
            if (!EntityDataState.Added.equals(ninteiViewState.getState())) {
                ninteiViewState.setState(EntityDataState.Modified);
            }
            list.set(index, ninteiViewState);
        } else {
            int 履歴番号 = 0;
            if (!申請メニューID.equals(ResponseHolder.getMenuID())) {
                履歴番号 = 1;
            }
            FutanGendogakuNintei futanGendogakuNintei
                    = new FutanGendogakuNintei(get証記載保険者番号(
                                    div.getTxtShinseiYMD().getValue()), get被保険者番号FromViewState(資格対象者), 履歴番号);
            FutanGendogakuNintei 申請情報 = 申請情報Builder(futanGendogakuNintei);
            if (list.isEmpty()) {
                list.add(new FutanGendogakuNinteiViewState(申請情報, EntityDataState.Added, 履歴番号));
            } else {
                list = sort申請情報ListBy申請日(list, 申請情報);
            }
        }
        if (is申請一覧表示) {
            set申請一覧(list);
        }
        return list;
    }

    private ArrayList<FutanGendogakuNinteiViewState> sort申請情報ListBy申請日(
            ArrayList<FutanGendogakuNinteiViewState> list, FutanGendogakuNintei 申請情報) {
        ArrayList<FutanGendogakuNinteiViewState> newList = new ArrayList<>();
        boolean added = false;
        FutanGendogakuNintei fgn;
        FutanGendogakuNintei fgn2;
        for (int i = 0; i < list.size(); i++) {
            FutanGendogakuNinteiViewState ninteiViewState = list.get(i);
            FutanGendogakuNintei futanGendogakuNintei = ninteiViewState.getFutanGendogakuNintei();
            if (futanGendogakuNintei.get申請年月日().isBeforeOrEquals(申請情報.get申請年月日())) {
                fgn = new FutanGendogakuNintei(
                        futanGendogakuNintei.get証記載保険者番号(), futanGendogakuNintei.get被保険者番号(), futanGendogakuNintei.get履歴番号());
                fgn = copyFutanGendogakuNintei(futanGendogakuNintei, fgn, futanGendogakuNintei.get履歴番号());
                ninteiViewState.setFutanGendogakuNintei(fgn);
                newList.add(ninteiViewState);

                if (i == list.size() - 1) {
                    fgn2 = new FutanGendogakuNintei(
                            申請情報.get証記載保険者番号(), 申請情報.get被保険者番号(), futanGendogakuNintei.get履歴番号() + 1);
                    fgn2 = copyFutanGendogakuNintei(申請情報, fgn2, futanGendogakuNintei.get履歴番号() + 1);
                    FutanGendogakuNinteiViewState newNinteiViewState2
                            = new FutanGendogakuNinteiViewState(fgn2, EntityDataState.Added, fgn2.get履歴番号());
                    newList.add(newNinteiViewState2);
                    added = true;
                }

            } else if (!added && !futanGendogakuNintei.get申請年月日().isBeforeOrEquals(申請情報.get申請年月日())) {
                fgn = new FutanGendogakuNintei(
                        申請情報.get証記載保険者番号(), 申請情報.get被保険者番号(), futanGendogakuNintei.get履歴番号());
                fgn = copyFutanGendogakuNintei(申請情報, fgn, futanGendogakuNintei.get履歴番号());
                FutanGendogakuNinteiViewState newNinteiViewState = new FutanGendogakuNinteiViewState(fgn, EntityDataState.Added, fgn.get履歴番号());
                newList.add(newNinteiViewState);

                if (i == list.size() - 1) {
                    fgn2 = new FutanGendogakuNintei(
                            futanGendogakuNintei.get証記載保険者番号(), futanGendogakuNintei.get被保険者番号(), futanGendogakuNintei.get履歴番号() + 1);
                    fgn2 = copyFutanGendogakuNintei(futanGendogakuNintei, fgn2, futanGendogakuNintei.get履歴番号() + 1);
                    FutanGendogakuNinteiViewState newNinteiViewState2
                            = new FutanGendogakuNinteiViewState(fgn2, EntityDataState.Modified, fgn2.get履歴番号());
                    newList.add(newNinteiViewState2);
                } else {
                    fgn2 = new FutanGendogakuNintei(
                            futanGendogakuNintei.get証記載保険者番号(), futanGendogakuNintei.get被保険者番号(), futanGendogakuNintei.get履歴番号() + 1);
                    fgn2 = copyFutanGendogakuNintei(futanGendogakuNintei, fgn2, futanGendogakuNintei.get履歴番号() + 1);
                    ninteiViewState.setFutanGendogakuNintei(fgn2);
                    newList.add(ninteiViewState);
                }
                added = true;
            } else {
                if (i == list.size() - 1) {
                    fgn2 = new FutanGendogakuNintei(
                            futanGendogakuNintei.get証記載保険者番号(), futanGendogakuNintei.get被保険者番号(), futanGendogakuNintei.get履歴番号() + 1);
                    fgn2 = copyFutanGendogakuNintei(futanGendogakuNintei, fgn2, futanGendogakuNintei.get履歴番号() + 1);
                    FutanGendogakuNinteiViewState newNinteiViewState2
                            = new FutanGendogakuNinteiViewState(fgn2, EntityDataState.Modified, fgn2.get履歴番号());
                    newList.add(newNinteiViewState2);
                } else {
                    fgn = new FutanGendogakuNintei(
                            futanGendogakuNintei.get証記載保険者番号(), futanGendogakuNintei.get被保険者番号(), futanGendogakuNintei.get履歴番号() + 1);
                    fgn = copyFutanGendogakuNintei(futanGendogakuNintei, fgn, futanGendogakuNintei.get履歴番号() + 1);
                    ninteiViewState.setFutanGendogakuNintei(fgn);
                    newList.add(ninteiViewState);
                }
            }
        }
        if (list.isEmpty()) {
            FutanGendogakuNinteiViewState newNinteiViewState = new FutanGendogakuNinteiViewState(申請情報, EntityDataState.Added, 0);
            newList.add(newNinteiViewState);
        }
        return newList;
    }

    private FutanGendogakuNintei copyFutanGendogakuNintei(FutanGendogakuNintei formFgn, FutanGendogakuNintei toFgn, int 履歴番号) {
        FutanGendogakuNinteiBuilder builder = toFgn.createBuilderForEdit();
        builder.set申請年月日(formFgn.get申請年月日());
        builder.set申請理由区分(formFgn.get申請理由区分());
        builder.set配偶者の有無(formFgn.is配偶者の有無());
        builder.set配偶者識別コード(formFgn.get配偶者識別コード() == null ? ShikibetsuCode.EMPTY : formFgn.get配偶者識別コード());
        builder.set配偶者氏名カナ(formFgn.get配偶者氏名カナ() == null ? AtenaKanaMeisho.EMPTY : formFgn.get配偶者氏名カナ());
        builder.set配偶者氏名(formFgn.get配偶者氏名() == null ? AtenaMeisho.EMPTY : formFgn.get配偶者氏名());
        builder.set配偶者生年月日(formFgn.get配偶者生年月日() == null ? FlexibleDate.EMPTY : formFgn.get配偶者生年月日());
        builder.set配偶者連絡先(formFgn.get配偶者連絡先() == null ? RString.EMPTY : formFgn.get配偶者連絡先());
        builder.set配偶者住所(formFgn.get配偶者住所() == null ? AtenaJusho.EMPTY : formFgn.get配偶者住所());
        builder.set配偶者住所２(formFgn.get配偶者住所２() == null ? AtenaJusho.EMPTY : formFgn.get配偶者住所２());
        builder.set配偶者課税区分(formFgn.get配偶者課税区分());
        builder.set預貯金申告区分(formFgn.get預貯金申告区分());

        builder.set預貯金額(formFgn.get預貯金額());
        builder.set有価証券評価概算額(formFgn.get有価証券評価概算額());
        builder.setその他金額(formFgn.getその他金額());
        builder.set決定区分(formFgn.get決定区分());
        builder.set決定年月日(formFgn.get決定年月日() == null ? FlexibleDate.EMPTY : formFgn.get決定年月日());
        builder.set適用開始年月日(formFgn.get適用開始年月日() == null ? FlexibleDate.EMPTY : formFgn.get適用開始年月日());
        builder.set適用終了年月日(formFgn.get適用終了年月日() == null ? FlexibleDate.EMPTY : formFgn.get適用終了年月日());
        builder.set旧措置者区分(formFgn.get旧措置者区分());
        builder.set利用者負担段階(formFgn.get利用者負担段階());
        builder.set居室種別(formFgn.get居室種別());
        builder.set食費負担限度額(formFgn.get食費負担限度額());
        builder.setユニット型個室(formFgn.getユニット型個室());
        builder.setユニット型準個室(formFgn.getユニット型準個室());
        builder.set従来型個室_特養等(formFgn.get従来型個室_特養等());
        builder.set従来型個室_老健_療養等(formFgn.get従来型個室_老健_療養等());
        builder.set多床室(formFgn.get多床室());
        builder.set非承認理由(formFgn.get非承認理由() == null ? RString.EMPTY : formFgn.get非承認理由());
        if (!formFgn.getGemmenGengakuShinseiList().isEmpty()) {
            GemmenGengakuShinseiIdentifier identifier = new GemmenGengakuShinseiIdentifier(
                    formFgn.get証記載保険者番号(),
                    formFgn.get被保険者番号(),
                    GemmenGengakuShurui.負担限度額認定.getコード(),
                    formFgn.get履歴番号());

            GemmenGengakuShinsei gemmenGengakuShinsei = formFgn.getGemmenGengakuShinsei(identifier);
            gemmenGengakuShinsei = gemmenGengakuShinsei.createBuilderForEdit().set履歴番号(履歴番号).build();
            GemmenGengakuShinsei newGemmen = new GemmenGengakuShinsei(gemmenGengakuShinsei.toEntity());
            builder.setGemmenGengakuShinsei(newGemmen);
        }
        return builder.build();
    }

    private void clear申請情報エリア(TaishoshaKey 資格対象者) {
        div.getTxtShinseiYMD().clearValue();
        div.getDdlShinseiRiyu().setIsBlankLine(true);
        div.getDdlShinseiRiyu().setSelectedKey(SELECT_EMPTYKEY);
        div.getRadHaigushaUmu().setSelectedKey(SELECT_KEY1);
        div.getTxtHaigushaShikibetsuCode().clearDomain();
        div.getTxtHaigushaShimeiKana().clearDomain();
        div.getTxtHaigushaShimei().clearDomain();
        div.getTxtHaigushaUmareYMD().clearValue();
        div.getTxtHaigushaRenrakusaki().clearDomain();
        div.getTxtHaigushaJusho1().clearDomain();
        div.getTxtHaigushaJusho2().clearDomain();
        div.getRadHaigushaKazeiKubun().clearSelectedItem();
        div.getChkYochokinKijunIka().setSelectedItemsByKey(new ArrayList<RString>());
        div.getTxtYochokinGaku().clearValue();
        div.getTxtYukaShoken().clearValue();
        div.getTxtSonota().clearValue();
        div.getRadKetteiKubun().setSelectedKey(SELECT_KEY0);
        if (申請メニューID.equals(ResponseHolder.getMenuID())) {
            div.getTxtKetteiYMD().clearValue();
        } else {
            div.getTxtKetteiYMD().setValue(FlexibleDate.getNowDate());
        }
        div.getTxtTekiyoYMD().clearValue();
        div.getTxtYukoKigenYMD().clearValue();
        init旧措置DDL();
        FutangendogakuNinteiService ninteiService = FutangendogakuNinteiService.createInstance();
        if (!申請メニューID.equals(ResponseHolder.getMenuID())
                && ninteiService.is旧措置者(get被保険者番号FromViewState(資格対象者))) {
            div.getDdlKyusochisha().setSelectedKey(KyuSochishaKubun.旧措置者.getコード());
        } else {
            div.getDdlKyusochisha().setSelectedKey(KyuSochishaKubun.非該当.getコード());
        }
        List<RString> dataSource = new ArrayList<>();
        if (ninteiService.is境界層該当者(get被保険者番号FromViewState(資格対象者), FlexibleDate.getNowDate())) {
            dataSource.add(SELECT_KEY0);
        }
        if (!申請メニューID.equals(ResponseHolder.getMenuID())) {
            div.getChkKyokaiso().setSelectedItemsByKey(dataSource);
        }
        div.getDdlKyoshitsuShubetsu().setIsBlankLine(true);
        div.getDdlKyoshitsuShubetsu().setSelectedKey(SELECT_EMPTYKEY);
        div.getTxtHiShoninRiyu().clearValue();
    }

    private void get利用者負担段階(ArrayList<FutanGendogakuNintei> 申請一覧情報ArrayList) {
        FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
        RString 利用者負担段階 = RString.EMPTY;
        for (FutanGendogakuNintei 負担限度情報 : 申請一覧情報ArrayList) {
            if (KetteiKubun.承認する.getコード().equals(負担限度情報.get決定区分())
                    && 負担限度情報.get適用開始年月日().isBeforeOrEquals(システム日付)
                    && システム日付.isBeforeOrEquals(負担限度情報.get適用終了年月日())) {
                利用者負担段階 = 負担限度情報.get利用者負担段階();
                break;
            }
        }

        if (!利用者負担段階.isEmpty()) {
            div.getTxtRiyoshaFutanDankai().setValue(RiyoshaFutanDankai.toValue(利用者負担段階).get名称());
        } else {
            div.getTxtRiyoshaFutanDankai().setValue(認定なし);
        }
    }
}
