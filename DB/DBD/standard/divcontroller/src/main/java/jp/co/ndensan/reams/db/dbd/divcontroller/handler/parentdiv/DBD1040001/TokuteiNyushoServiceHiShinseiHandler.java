/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenService;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 画面設計_DBDGM21005_1_特別地域加算減免申請のハンドラークラスです。
 *
 * @reamsid_L DBD-3680-010 miaojin
 */
public class TokuteiNyushoServiceHiShinseiHandler {

    private final TokuteiNyushoServiceHiShinseiDiv div;
    private final RString 申請メニュー = new RString("DBDMN21005");
    //private final RString 申請メニュー = new RString("menu1");
    //private final RString 承認メニュー = new RString("menu1");
    private final RString 承認メニュー = new RString("DBDMN22005");
    private final RString 申請情報を追加する = new RString("申請情報を追加する");
    private static final RString 承認情報を追加する = new RString("承認情報を追加する");
    private static final RString 申請情報 = new RString("申請情報");
    private static final RString 承認情報 = new RString("承認情報");
    private static final RString BTNUPDATE_FIELDNAME = new RString("btnUpdate");
    private static final RString 申請情報を = new RString("申請情報を");
    private static final RString 承認情報を = new RString("承認情報を");
    private static final RString 承認する_KEY = new RString("1");
    private static final RString 承認しない_KEY = new RString("0");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div 特別地域加算減免申請のコントロールdiv
     */
    public TokuteiNyushoServiceHiShinseiHandler(TokuteiNyushoServiceHiShinseiDiv div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     *
     * @param taishoshaKey 前画面から渡された「対象者キー」
     */
    public void initialize(TaishoshaKey taishoshaKey) {
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.getCcdAtenaInfo().initialize(識別コード);
        div.getCcdShinseiJoho().initialize(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getCcdKaigoKihon().initialize(被保険者番号);
        }
        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            div.getShinsei().getShinseiList().getBtnAddShinsei().setText(申請情報を追加する);
            div.getShinseiDetail().setTitle(申請情報);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(BTNUPDATE_FIELDNAME, 申請情報を.toString());
            div.getShinsei().getShinseiList().setDisplayNone(false);
            div.getShinsei().getShinseiDetail().setDisplayNone(true);
        } else if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            div.getShinsei().getShinseiList().getBtnAddShinsei().setText(承認情報を追加する);
            div.getShinseiDetail().setTitle(承認情報);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(BTNUPDATE_FIELDNAME, 承認情報を.toString());
            div.getShinsei().getShinseiList().setDisplayNone(false);
            div.getShinsei().getShinseiDetail().setDisplayNone(true);
        }
        set初期状態制御();
    }

    /**
     * 一覧エリアの初期設定です。
     *
     * @param 特別地域加算減免申請の情報List 特別地域加算減免申請の情報List
     * @param viewStateList 特別地域加算減免申請の情報のViewStateリスト
     */
    public void 申請一覧エリアの初期設定(List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List, ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList) {
        List<dgShinseiList_Row> rowlist = new ArrayList<>();
        for (TokubetsuchiikiKasanGemmen 特別地域加算減免申請情報 : 特別地域加算減免申請の情報List) {
            dgShinseiList_Row row = new dgShinseiList_Row();
            row.setKakuninNo(特別地域加算減免申請情報.get確認番号());
            row.getTxtShinseiYMD().setValue(特別地域加算減免申請情報.get申請年月日());
            row.setShinseiRiyu(特別地域加算減免申請情報.get申請事由());
            row.setKetteiKubun(特別地域加算減免申請情報.get決定区分());
            row.getTxtKetteiYMD().setValue(特別地域加算減免申請情報.get決定年月日());
            row.getTxtTekiyoYMD().setValue(特別地域加算減免申請情報.get適用開始年月日());
            row.getTxtYukoKigenYMD().setValue(特別地域加算減免申請情報.get適用終了年月日());
            if (特別地域加算減免申請情報.get減額率() != null) {
                row.setKeigenritsu(new RString(特別地域加算減免申請情報.get減額率().value().toString()));
            }
            row.setShoninShinaiRiyu(特別地域加算減免申請情報.get非承認理由());
            row.setHiddenShoKisaiHokenshaNo(特別地域加算減免申請情報.get証記載保険者番号().value());
            row.setHiddenShinseiRirekiNo(new RString(特別地域加算減免申請情報.get履歴番号()));
            rowlist.add(row);
            viewStateList.add(new TokubetsuChiikiKasanGemmenViewState(特別地域加算減免申請情報, EntityDataState.Unchanged, 特別地域加算減免申請情報.get履歴番号()));
        }
        div.getShinsei().getShinseiList().getDgShinseiList().setDataSource(rowlist);
    }

    /**
     * 一覧エリアの初期設定です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void 前排他の設定(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("TokuchiGemmen")));
        RealInitialLocker.lock(排他キー);
    }

    /**
     * 「申請情報を追加する/承認情報を追加する」ボタン押下の処理です。
     *
     * @param 資格対象者 資格対象者
     */
    public void set追加するボタン押下(TaishoshaKey 資格対象者) {
        set情報クリア(資格対象者);
        div.getShinseiDetail().getRadKettaiKubun().setSelectedKey(承認する_KEY);
        div.getShinseiDetail().getTxtKettaiYMD().setValue(FlexibleDate.getNowDate());
        div.getShinseiDetail().setDisplayNone(false);
        div.getShinseiList().setDisplayNone(true);
        set情報エリア追加状態制御();
    }

    /**
     * 特別地域加算減免申請の情報を取得します。
     *
     * @param row 当該選択行
     * @param 特別地域加算減免申請の情報List 画面初期の時、特別地域加算減免申請の情報データを保持するリスト
     * @return 特別地域加算減免申請の情報
     */
    public TokubetsuchiikiKasanGemmen get特別地域加算減免申請の情報(dgShinseiList_Row row, List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List) {
        if (特別地域加算減免申請の情報List != null) {
            for (TokubetsuchiikiKasanGemmen 特別地域加算減免申請の情報 : 特別地域加算減免申請の情報List) {
                if (特別地域加算減免申請の情報.get証記載保険者番号().value().equals(row.getHiddenShoKisaiHokenshaNo())
                        && new RString(特別地域加算減免申請の情報.get履歴番号()).equals(row.getHiddenShinseiRirekiNo())) {
                    return 特別地域加算減免申請の情報;
                }
            }
        }
        return null;
    }

    /**
     * 該当申請のViewStateを取得します。
     *
     * @param row 選択行
     * @param viewStateList 特別地域加算減免申請の情報のViewStateリスト
     * @return 該当申請のViewState
     */
    public TokubetsuChiikiKasanGemmenViewState get該当申請のViewState(dgShinseiList_Row row, List<TokubetsuChiikiKasanGemmenViewState> viewStateList) {
        if (viewStateList != null) {
            for (TokubetsuChiikiKasanGemmenViewState 申請ViewState : viewStateList) {
                if (申請ViewState.getTokubetsuchiikiKasanGemmen().get証記載保険者番号().value().equals(row.getHiddenShoKisaiHokenshaNo())
                        && new RString(申請ViewState.getTokubetsuchiikiKasanGemmen().get履歴番号()).equals(row.getHiddenShinseiRirekiNo())) {
                    return 申請ViewState;
                }
            }
        }
        return null;
    }

    /**
     * 申請一覧の修正ボタン押下の処理です。
     *
     * @param row 選択行
     * @param 資格対象者 前画面から渡された「対象者キー」
     * @param 特別地域加算減免ViewState 特別地域加算減免の情報のViewState
     */
    public void set申請一覧の修正ボタンをクリック(dgShinseiList_Row row, TaishoshaKey 資格対象者, TokubetsuChiikiKasanGemmenViewState 特別地域加算減免ViewState) {
        set情報クリア(資格対象者);
        div.getShinseiDetail().setDisplayNone(false);
        div.getShinseiList().setDisplayNone(true);
        if (特別地域加算減免ViewState != null) {
            div.getCcdShinseiJoho().set減免減額申請情報(get減免減額申請情報(特別地域加算減免ViewState), FlexibleDate.getNowDate());
        }
        set情報エリア修正状態制御();
        set情報エリア(row);
    }

    /**
     * 申請一覧の削除ボタン押下の処理です。
     *
     * @param row 選択行
     * @param viewStateList viewStateList
     * @param newViewStatesList newViewStatesList
     */
    public void set申請一覧の削除ボタンをクリック(dgShinseiList_Row row, ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList,
            ArrayList<TokubetsuChiikiKasanGemmenViewState> newViewStatesList) {
        if (viewStateList == null) {
            viewStateList = new ArrayList<>();
        }
        if (追加.equals(row.getJotai())) {
            div.getShinsei().getShinseiList().getDgShinseiList().getDataSource().remove(row);
            for (TokubetsuChiikiKasanGemmenViewState 特別地域加算減免申請情報 : viewStateList) {
                if (特別地域加算減免申請情報.getTokubetsuchiikiKasanGemmen().get証記載保険者番号().getColumnValue().equals(row.getHiddenShoKisaiHokenshaNo())
                        && new RString(特別地域加算減免申請情報.getTokubetsuchiikiKasanGemmen().get履歴番号()).equals(row.getHiddenShinseiRirekiNo())) {
                    viewStateList.remove(特別地域加算減免申請情報);
                    break;
                }
            }
        } else {
            row.setJotai(削除);
            for (TokubetsuChiikiKasanGemmenViewState 特別地域加算減免申請情報 : viewStateList) {
                if (特別地域加算減免申請情報.getTokubetsuchiikiKasanGemmen().get証記載保険者番号().getColumnValue().equals(row.getHiddenShoKisaiHokenshaNo())
                        && new RString(特別地域加算減免申請情報.getTokubetsuchiikiKasanGemmen().get履歴番号()).equals(row.getHiddenShinseiRirekiNo())) {
                    TokubetsuChiikiKasanGemmenViewState deleteJoho = 特別地域加算減免申請情報.createBuilderForEdit().setState(EntityDataState.Deleted).build();
                    newViewStatesList.add(deleteJoho);
                } else {
                    newViewStatesList.add(特別地域加算減免申請情報);
                }
            }
        }
    }

    /**
     * 特別地域加算減免申請画面を「決定区分」を押下する。
     */
    public void onClick_radKetteiKubun() {
        RString selectKey = div.getShinseiDetail().getRadKettaiKubun().getSelectedKey();
        if (selectKey.equals(承認する_KEY)) {
            div.getShinseiDetail().getBtnHiShoninRiyu().setDisabled(true);
            div.getShinseiDetail().getTxtHiShoninRiyu().setDisabled(true);
            div.getShinseiDetail().getTxtKeigenRitsu().setDisabled(false);
            div.getShinseiDetail().getTxtKakuninNo().setDisabled(false);
        } else if (selectKey.equals(承認しない_KEY)) {
            div.getShinseiDetail().getBtnHiShoninRiyu().setDisabled(false);
            div.getShinseiDetail().getTxtHiShoninRiyu().setDisabled(false);
            div.getShinseiDetail().getTxtKeigenRitsu().setDisabled(true);
            div.getShinseiDetail().getTxtKakuninNo().setDisabled(true);
        }
    }

    /**
     * 特別地域加算減免申請画面を「申請一覧に戻る」を押下する。
     *
     * @param 資格対象者 資格対象者
     */
    public void set申請一覧に戻る(TaishoshaKey 資格対象者) {
        set情報クリア(資格対象者);
        div.getShinsei().getShinseiList().setDisplayNone(false);
        div.getShinsei().getShinseiDetail().setDisplayNone(true);
    }

    /**
     * 申請情報についてい、変更のところがあるか判断します。
     *
     * @param 特別地域加算減免申請の情報 特別地域加算減免申請の情報
     * @return 判断結果 true:変更あり
     */
    public boolean 申請情報_変更あり(TokubetsuchiikiKasanGemmen 特別地域加算減免申請の情報) {

        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            return !(is等しい(特別地域加算減免申請の情報.get申請事由(), div.getShinseiDetail().getTxtShinseiRiyu().getValue())
                    && 特別地域加算減免申請の情報.get申請年月日().equals(div.getShinseiDetail().getTxtShinseiYMD().getValue())
                    && is減免減額申請共有子Div等しい(特別地域加算減免申請の情報)
                    && is等しい(特別地域加算減免申請の情報.get非承認理由(), div.getShinseiDetail().getTxtHiShoninRiyu().getValue()));
        }
        return !(is等しい(特別地域加算減免申請の情報.get申請事由(), div.getShinseiDetail().getTxtShinseiRiyu().getValue())
                && 特別地域加算減免申請の情報.get申請年月日().equals(div.getShinseiDetail().getTxtShinseiYMD().getValue())
                && is減免減額申請共有子Div等しい(特別地域加算減免申請の情報)
                && is承認情報等しい(特別地域加算減免申請の情報));
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @param 申請日 申請日
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号(FlexibleDate 申請日) {
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

    /**
     * 「申請情報を確定する」ボタン押下の処理です。
     *
     * @param viewStateList 処理開始の時、特別地域加算減免申請ListのViewState
     * @param newViewStateList 処理した後、特別地域加算減免申請ListのViewState
     * @param state 当該データの状態
     * @param gemmenGengakuShinsei 減免減額申請
     * @param builder 利用者負担額減額のBuilder
     * @param 証記載保険者番号 当該データの証記載保険者番号
     * @param 履歴番号 当該データの履歴番号
     * @param taishoshaKey 前画面から渡された「対象者キー」
     */
    public void 申請情報を確定するボタン押下(ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList,
            ArrayList<TokubetsuChiikiKasanGemmenViewState> newViewStateList,
            EntityDataState state, GemmenGengakuShinsei gemmenGengakuShinsei, TokubetsuchiikiKasanGemmenBuilder builder,
            ShoKisaiHokenshaNo 証記載保険者番号, int 履歴番号, TaishoshaKey taishoshaKey) {

        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder
                = setGemmenGengakuShinseiBuilderBy入力データ(gemmenGengakuShinsei.createBuilderForEdit());
        RString 決定区分 = div.getShinseiDetail().getRadKettaiKubun().getSelectedKey();
        Decimal 軽減率 = div.getShinseiDetail().getTxtKeigenRitsu().getValue();
        builder.set申請事由(div.getShinseiDetail().getTxtShinseiRiyu().getValue());
        builder.set申請年月日(div.getShinseiDetail().getTxtShinseiYMD().getValue());
        builder.setGemmenGengakuShinsei(gemmenGengakuShinseiBuilder.build());
        TokubetsuChiikiKasanGemmenViewState inputView = new TokubetsuChiikiKasanGemmenViewState(builder.build(), state, 履歴番号);

        newViewStateList.add(inputView);
        for (TokubetsuChiikiKasanGemmenViewState viewState : viewStateList) {
            if (viewState.getTokubetsuchiikiKasanGemmen().get履歴番号() != inputView.getTokubetsuchiikiKasanGemmen().get履歴番号()) {
                newViewStateList.add(viewState);
            }
        }

        List<dgShinseiList_Row> pageList = div.getShinseiList().getDgShinseiList().getDataSource();
        boolean is新規 = true;
        RString 状態 = RString.EMPTY;
        if (EntityDataState.Added == state) {
            状態 = 追加;
        } else if (EntityDataState.Modified == state) {
            状態 = 修正;
        }

        for (dgShinseiList_Row row : pageList) {
            if (row.getHiddenShoKisaiHokenshaNo().equals(証記載保険者番号.value())
                    && row.getHiddenShinseiRirekiNo().equals(new RString(履歴番号))) {
                row.getTxtShinseiYMD().setValue(div.getShinseiDetail().getTxtShinseiYMD().getValue());
                row.setShinseiRiyu(div.getShinseiDetail().getTxtShinseiRiyu().getValue());
                row.setJotai(状態);
                row.setShoninShinaiRiyu(div.getShinseiDetail().getTxtHiShoninRiyu().getText());
                row.setKetteiKubun(決定区分);
                if (軽減率 != null) {
                    row.setKeigenritsu(new RString(軽減率.toString()));
                }
                is新規 = false;
            }
        }
        List<dgShinseiList_Row> newRowList = new ArrayList<>(pageList);
        if (is新規) {
            dgShinseiList_Row row = new dgShinseiList_Row();
            row.getTxtShinseiYMD().setValue(div.getShinseiDetail().getTxtShinseiYMD().getValue());
            row.setShinseiRiyu(div.getShinseiDetail().getTxtShinseiRiyu().getValue());
            row.setJotai(追加);
            row.setShoninShinaiRiyu(div.getShinseiDetail().getTxtHiShoninRiyu().getText());
            row.setKetteiKubun(決定区分);
            if (軽減率 != null) {
                row.setKeigenritsu(new RString(軽減率.toString()));
            }
            row.setHiddenShoKisaiHokenshaNo(証記載保険者番号.value());
            row.setHiddenShinseiRirekiNo(new RString(履歴番号));
            newRowList.add(row);
        }
        div.getShinseiList().getDgShinseiList().setDataSource(newRowList);
        set情報クリア(taishoshaKey);
        set初期状態制御();
        div.getShinsei().getShinseiList().setDisplayNone(false);
        div.getShinsei().getShinseiDetail().setDisplayNone(true);
    }

    /**
     * 「申請情報を確定する」ボタン押下の処理です。
     *
     * @param viewStateList 処理開始の時、特別地域加算減免申請ListのViewState
     * @param newViewStateList 処理した後、特別地域加算減免申請ListのViewState
     * @param state 当該データの状態
     * @param gemmenGengakuShinsei 減免減額申請
     * @param builder 利用者負担額減額のBuilder
     * @param 証記載保険者番号 当該データの証記載保険者番号
     * @param 履歴番号 当該データの履歴番号
     * @param taishoshaKey 前画面から渡された「対象者キー」
     */
    public void 承認情報を確定するボタン押下(ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList,
            ArrayList<TokubetsuChiikiKasanGemmenViewState> newViewStateList,
            EntityDataState state, GemmenGengakuShinsei gemmenGengakuShinsei, TokubetsuchiikiKasanGemmenBuilder builder,
            ShoKisaiHokenshaNo 証記載保険者番号, int 履歴番号, TaishoshaKey taishoshaKey) {

        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder
                = setGemmenGengakuShinseiBuilderBy入力データ(gemmenGengakuShinsei.createBuilderForEdit());
        RString 決定区分 = div.getShinseiDetail().getRadKettaiKubun().getSelectedKey();
        RString 確認番号 = RString.EMPTY;
        FlexibleDate 決定日 = FlexibleDate.EMPTY;
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 有効期限 = FlexibleDate.EMPTY;
        HokenKyufuRitsu 軽減率 = HokenKyufuRitsu.ZERO;
        RString 非承認理由 = RString.EMPTY;
        if (承認する_KEY.equals(決定区分)) {
            軽減率 = new HokenKyufuRitsu(div.getShinseiDetail().getTxtKeigenRitsu().getValue());
            確認番号 = div.getShinseiDetail().getTxtKakuninNo().getValue();
            決定日 = div.getShinseiDetail().getTxtKettaiYMD().getValue();
            適用日 = div.getShinseiDetail().getTxtTekiyoYMD().getValue();
            有効期限 = div.getShinseiDetail().getTxtYukoKigenYMD().getValue();
        } else {
            軽減率 = new HokenKyufuRitsu(div.getShinseiDetail().getTxtKeigenRitsu().getValue());
            確認番号 = div.getShinseiDetail().getKetteiJoho().getTxtKakuninNo().getText();
            決定日 = div.getShinseiDetail().getTxtKettaiYMD().getValue();
            適用日 = div.getShinseiDetail().getTxtTekiyoYMD().getValue();
            有効期限 = div.getShinseiDetail().getTxtYukoKigenYMD().getValue();
            非承認理由 = div.getShinseiDetail().getTxtHiShoninRiyu().getText();
        }
        builder.set減額率(軽減率);
        builder.set確認番号(確認番号);
        builder.set決定区分(決定区分);
        builder.set決定年月日(決定日);
        builder.set適用開始年月日(適用日);
        builder.set適用終了年月日(有効期限);
        builder.set非承認理由(非承認理由);
        builder.set申請事由(div.getShinseiDetail().getTxtShinseiRiyu().getValue());
        builder.set申請年月日(div.getShinseiDetail().getTxtShinseiYMD().getValue());
        builder.setGemmenGengakuShinsei(gemmenGengakuShinseiBuilder.build());
        TokubetsuChiikiKasanGemmenViewState inputView = new TokubetsuChiikiKasanGemmenViewState(builder.build(), state, 履歴番号);

        newViewStateList.add(inputView);
        for (TokubetsuChiikiKasanGemmenViewState viewState : viewStateList) {
            if (viewState.getTokubetsuchiikiKasanGemmen().get履歴番号() != inputView.getTokubetsuchiikiKasanGemmen().get履歴番号()) {
                newViewStateList.add(viewState);
            }
        }

        List<dgShinseiList_Row> pageList = div.getShinseiList().getDgShinseiList().getDataSource();
        boolean is新規 = true;
        RString 状態 = RString.EMPTY;
        if (EntityDataState.Added == state) {
            状態 = 追加;
        } else if (EntityDataState.Modified == state) {
            状態 = 修正;
        }

        for (dgShinseiList_Row row : pageList) {
            if (row.getHiddenShoKisaiHokenshaNo().equals(証記載保険者番号.value())
                    && row.getHiddenShinseiRirekiNo().equals(new RString(履歴番号))) {
                row.getTxtShinseiYMD().setValue(div.getShinseiDetail().getTxtShinseiYMD().getValue());
                row.setShinseiRiyu(div.getShinseiDetail().getTxtShinseiRiyu().getValue());
                row.setJotai(状態);
                row.setKetteiKubun(決定区分);
                row.getTxtKetteiYMD().setValue(決定日);
                row.getTxtTekiyoYMD().setValue(適用日);
                row.getTxtYukoKigenYMD().setValue(有効期限);
                if (軽減率 != null) {
                    row.setKeigenritsu(new RString(軽減率.value().toString()));
                }
                row.setKakuninNo(確認番号);
                row.setShoninShinaiRiyu(非承認理由);
                is新規 = false;
            }
        }
        List<dgShinseiList_Row> newRowList = new ArrayList<>(pageList);
        if (is新規) {
            dgShinseiList_Row row = new dgShinseiList_Row();
            row.getTxtShinseiYMD().setValue(div.getShinseiDetail().getTxtShinseiYMD().getValue());
            row.setShinseiRiyu(div.getShinseiDetail().getTxtShinseiRiyu().getValue());
            row.setJotai(追加);
            row.setKetteiKubun(決定区分);
            row.getTxtKetteiYMD().setValue(決定日);
            row.getTxtTekiyoYMD().setValue(適用日);
            row.getTxtYukoKigenYMD().setValue(有効期限);
            if (軽減率 != null) {
                row.setKeigenritsu(new RString(軽減率.value().toString()));
            }
            row.setKakuninNo(確認番号);
            row.setShoninShinaiRiyu(非承認理由);
            row.setHiddenShoKisaiHokenshaNo(証記載保険者番号.value());
            row.setHiddenShinseiRirekiNo(new RString(履歴番号));
            newRowList.add(row);
        }
        div.getShinseiList().getDgShinseiList().setDataSource(newRowList);
        set情報クリア(taishoshaKey);
        set初期状態制御();
        div.getShinsei().getShinseiList().setDisplayNone(false);
        div.getShinsei().getShinseiDetail().setDisplayNone(true);
    }

    /**
     * 申請情報エリアの入力情報をクリアします。
     *
     * @param taishoshaKey 前画面から渡された「対象者キー」
     */
    public void 入力情報をクリア(TaishoshaKey taishoshaKey) {
        set情報クリア(taishoshaKey);
    }

    /**
     * 申請一覧変更有無チェックを行います。
     *
     * @param list 利用者負担額減額の情報のViewStateリスト
     * @return true:変更あり false:変更なし
     */
    public boolean 申請一覧_変更あり(ArrayList<TokubetsuChiikiKasanGemmenViewState> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        boolean 変更あり = false;
        for (TokubetsuChiikiKasanGemmenViewState tckgvs : list) {
            if (EntityDataState.Unchanged != tckgvs.getState()) {
                変更あり = true;
            }
        }
        return 変更あり;
    }

    /**
     * アクセスログのPersonalDataを取得する処理です。
     *
     * @param taishoshaKey 前画面から渡された「対象者キー」
     * @return PersonalData
     */
    public PersonalData toPersonalData(TaishoshaKey taishoshaKey) {
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * 有効期限を取得する処理です。
     */
    public void get有効期限By適用日() {
        TokubetsuChiikiKasanGemmenService service = TokubetsuChiikiKasanGemmenService.createIntance();

        FlexibleDate 適用日 = div.getShinseiDetail().getTxtTekiyoYMD().getValue();
        if (適用日.isValid()) {
            FlexibleDate 有効期限 = service.estimate有効期限(適用日);
            div.getShinseiDetail().getTxtYukoKigenYMD().setValue(有効期限);
        }
    }

    private GemmenGengakuShinseiBuilder setGemmenGengakuShinseiBuilderBy入力データ(GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder) {
        if (div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行区分() != null) {
            gemmenGengakuShinseiBuilder.set申請届出代行区分(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行区分().getCode());
        } else {
            gemmenGengakuShinseiBuilder.set申請届出代行区分(RString.EMPTY);
        }
        gemmenGengakuShinseiBuilder.set申請届出者氏名(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名());
        gemmenGengakuShinseiBuilder.set申請届出者氏名カナ(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名カナ());
        gemmenGengakuShinseiBuilder.set申請届出者続柄(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者続柄());
        JigyoshaNo 事業者番号 = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行事業者番号();
        if (!事業者番号.isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出代行事業者番号(事業者番号);
        }
        if (div.getCcdShinseiJoho().get減免減額申請情報().get事業者区分() != null) {
            gemmenGengakuShinseiBuilder.set事業者区分(div.getCcdShinseiJoho().get減免減額申請情報().get事業者区分().getCode());
        } else {
            gemmenGengakuShinseiBuilder.set事業者区分(RString.EMPTY);
        }
        gemmenGengakuShinseiBuilder.set申請届出者郵便番号(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者郵便番号());
        gemmenGengakuShinseiBuilder.set申請届出者住所(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者住所());
        gemmenGengakuShinseiBuilder.set申請届出者電話番号(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者電話番号());
        return gemmenGengakuShinseiBuilder;
    }

    private void set初期状態制御() {
        div.getShinsei().getBtnDispSetaiJoho().setDisabled(false);
        div.getShinsei().getBtnDispGemmenJoho().setDisabled(false);
        div.getShinsei().getShinseiList().getBtnAddShinsei().setDisabled(false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(BTNUPDATE_FIELDNAME, false);
    }

    private void set情報クリア(TaishoshaKey 資格対象者) {
        if (資格対象者 != null) {
            ShikibetsuCode 識別コード = 資格対象者.get識別コード();
            div.getShinseiDetail().getCcdShinseiJoho().initialize(識別コード);
        }
        div.getShinseiDetail().getTxtShinseiYMD().clearValue();
        div.getShinseiDetail().getTxtShinseiRiyu().clearValue();
        div.getShinseiDetail().getRadKettaiKubun().clearSelectedItem();
        div.getShinseiDetail().getTxtKettaiYMD().clearValue();
        div.getShinseiDetail().getTxtTekiyoYMD().clearValue();
        div.getShinseiDetail().getTxtYukoKigenYMD().clearValue();
        div.getShinseiDetail().getTxtKeigenRitsu().clearValue();
        div.getShinseiDetail().getTxtKakuninNo().clearValue();
        div.getShinseiDetail().getTxtHiShoninRiyu().clearValue();
    }

    private void set情報エリア追加状態制御() {
        div.getShinsei().getBtnDispSetaiJoho().setDisabled(false);
        div.getShinsei().getBtnDispGemmenJoho().setDisabled(false);
        div.getShinseiDetail().getTxtShinseiYMD().setDisabled(false);
        div.getShinseiDetail().getTxtShinseiRiyu().setDisabled(false);
        div.getShinseiDetail().getRadKettaiKubun().setDisabled(true);
        div.getShinseiDetail().getTxtKettaiYMD().setDisabled(true);
        div.getShinseiDetail().getTxtTekiyoYMD().setDisabled(true);
        div.getShinseiDetail().getTxtYukoKigenYMD().setDisabled(true);
        div.getShinseiDetail().getTxtKeigenRitsu().setDisabled(true);
        div.getShinseiDetail().getTxtKakuninNo().setDisabled(true);
        div.getShinseiDetail().getBtnHiShoninRiyu().setDisabled(true);
        div.getShinseiDetail().getTxtHiShoninRiyu().setDisabled(true);
        div.getShinseiDetail().getBtnBackToShinseiList().setDisabled(false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(BTNUPDATE_FIELDNAME, true);
        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            div.getShinseiDetail().getTxtDetermineShinsei().setDisplayNone(false);
            div.getShinseiDetail().getBtnConfirm().setDisplayNone(true);
        } else if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            div.getShinseiDetail().getTxtDetermineShinsei().setDisplayNone(true);
            div.getShinseiDetail().getBtnConfirm().setDisplayNone(false);
        }
    }

    private ShinseiJoho get減免減額申請情報(TokubetsuChiikiKasanGemmenViewState 特別地域加算減免ViewState) {
        ShinseiTodokedeDaikoKubunCode 申請届出代行区分 = null;
        AtenaMeisho 申請届出者氏名 = null;
        AtenaKanaMeisho 申請届出者氏名カナ = null;
        RString 申請届出者続柄 = RString.EMPTY;
        YubinNo 申請届出者郵便番号 = null;
        AtenaJusho 申請届出者住所 = null;
        TelNo 申請届出者電話番号 = null;
        JigyoshaNo 申請届出代行事業者番号 = null;
        JigyoshaKubun 事業者区分 = null;

        if (特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().size() > 0) {
            if (特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出代行区分() != null
                    && !特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出代行区分().isEmpty()) {
                申請届出代行区分 = ShinseiTodokedeDaikoKubunCode.toValue(
                        特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出代行区分());
            }
            申請届出者氏名 = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出者氏名();
            申請届出者氏名カナ = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出者氏名カナ();
            申請届出者続柄 = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出者続柄();
            if (特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出代行事業者番号() != null) {
                申請届出代行事業者番号 = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出代行事業者番号();
            }
            if (特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get事業者区分() != null
                    && !特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get事業者区分().isEmpty()) {
                事業者区分 = JigyoshaKubun.toValue(特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get事業者区分());
            }
            申請届出者郵便番号 = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出者郵便番号();
            申請届出者住所 = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出者住所();
            申請届出者電話番号 = 特別地域加算減免ViewState.getTokubetsuchiikiKasanGemmen().getGemmenGengakuShinseiList().get(0).get申請届出者電話番号();
        }
        return new ShinseiJoho(申請届出代行区分,
                申請届出者氏名, 申請届出者氏名カナ, 申請届出者続柄, 申請届出代行事業者番号, 事業者区分, 申請届出者郵便番号, 申請届出者住所, 申請届出者電話番号);

    }

    private void set情報エリア修正状態制御() {
        div.getShinsei().getBtnDispSetaiJoho().setDisabled(false);
        div.getShinsei().getBtnDispGemmenJoho().setDisabled(false);
        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            div.getShinseiDetail().getTxtShinseiYMD().setDisabled(true);
            div.getShinseiDetail().getTxtShinseiRiyu().setDisabled(true);
            div.getShinseiDetail().getRadKettaiKubun().setDisabled(true);
            div.getShinseiDetail().getTxtKettaiYMD().setDisabled(true);
            div.getShinseiDetail().getTxtTekiyoYMD().setDisabled(true);
            div.getShinseiDetail().getTxtYukoKigenYMD().setDisabled(true);
            div.getShinseiDetail().getTxtKeigenRitsu().setDisabled(true);
            div.getShinseiDetail().getTxtKakuninNo().setDisabled(true);
            div.getShinseiDetail().getBtnHiShoninRiyu().setDisabled(true);
            div.getShinseiDetail().getTxtHiShoninRiyu().setDisabled(true);
            div.getShinseiDetail().getTxtDetermineShinsei().setDisplayNone(false);
            div.getShinseiDetail().getBtnConfirm().setDisplayNone(true);
        } else if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            div.getShinseiDetail().getTxtShinseiYMD().setDisabled(false);
            div.getShinseiDetail().getTxtShinseiRiyu().setDisabled(false);
            div.getShinseiDetail().getRadKettaiKubun().setDisabled(false);
            div.getShinseiDetail().getTxtKettaiYMD().setDisabled(false);
            div.getShinseiDetail().getTxtTekiyoYMD().setDisabled(false);
            div.getShinseiDetail().getTxtYukoKigenYMD().setDisabled(false);
            div.getShinseiDetail().getTxtKeigenRitsu().setDisabled(false);
            div.getShinseiDetail().getTxtKakuninNo().setDisabled(false);
            div.getShinseiDetail().getBtnHiShoninRiyu().setDisabled(false);
            div.getShinseiDetail().getTxtHiShoninRiyu().setDisabled(false);
            div.getShinseiDetail().getTxtDetermineShinsei().setDisplayNone(true);
            div.getShinseiDetail().getBtnConfirm().setDisplayNone(false);
        }
        div.getShinseiDetail().getBtnBackToShinseiList().setDisabled(false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(BTNUPDATE_FIELDNAME, true);
    }

    private void set情報エリア(dgShinseiList_Row row) {
        div.getShinsei().getShinseiDetail().getTxtShinseiYMD().setValue(row.getTxtShinseiYMD().getValue());
        div.getShinsei().getShinseiDetail().getTxtShinseiRiyu().setValue(row.getShinseiRiyu());
        div.getShinsei().getShinseiDetail().getRadKettaiKubun().setSelectedKey(row.getKetteiKubun());
        div.getShinsei().getShinseiDetail().getTxtKettaiYMD().setValue(row.getTxtKetteiYMD().getValue());
        div.getShinsei().getShinseiDetail().getTxtTekiyoYMD().setValue(row.getTxtTekiyoYMD().getValue());
        div.getShinsei().getShinseiDetail().getTxtYukoKigenYMD().setValue(row.getTxtYukoKigenYMD().getValue());
        if (row.getKeigenritsu() != null) {
            div.getShinsei().getShinseiDetail().getTxtKeigenRitsu().setValue(new Decimal(row.getKeigenritsu().toString()));
        } else {
            div.getShinsei().getShinseiDetail().getTxtKeigenRitsu().setValue(Decimal.ZERO);
        }
        div.getShinsei().getShinseiDetail().getTxtKakuninNo().setValue(row.getKakuninNo());
        div.getShinsei().getShinseiDetail().getTxtHiShoninRiyu().setValue(row.getShoninShinaiRiyu());
    }

    private boolean is承認情報等しい(TokubetsuchiikiKasanGemmen 特別地域加算減免申請の情報) {

        RString 決定区分 = div.getShinseiDetail().getRadKettaiKubun().getSelectedKey();
        RString 決定区分コード = RString.EMPTY;

        if (承認する_KEY.equals(決定区分)) {
            決定区分コード = KetteiKubun.承認する.getコード();
        } else if (承認しない_KEY.equals(決定区分)) {
            決定区分コード = KetteiKubun.承認しない.getコード();
        }
        Decimal 軽減率 = 特別地域加算減免申請の情報.get減額率() == null ? HokenKyufuRitsu.ZERO.value() : 特別地域加算減免申請の情報.get減額率().value();
        if (承認する_KEY.equals(決定区分)) {
            return is等しい(特別地域加算減免申請の情報.get決定区分(), 決定区分コード)
                    && 特別地域加算減免申請の情報.get決定年月日().equals(div.getShinseiDetail().getTxtKettaiYMD().getValue())
                    && (div.getShinseiDetail().getTxtTekiyoYMD().getValue().equals(特別地域加算減免申請の情報.get適用開始年月日())
                    || div.getShinseiDetail().getTxtTekiyoYMD().getValue().isEmpty() && 特別地域加算減免申請の情報.get適用開始年月日() == null)
                    && (div.getShinseiDetail().getTxtYukoKigenYMD().getValue().equals(特別地域加算減免申請の情報.get適用終了年月日())
                    || div.getShinseiDetail().getTxtYukoKigenYMD().getValue().isEmpty() && 特別地域加算減免申請の情報.get適用終了年月日() == null)
                    && 軽減率.compareTo(div.getShinseiDetail().getTxtKeigenRitsu().getValue()) == 0
                    && is等しい(特別地域加算減免申請の情報.get非承認理由(), div.getShinseiDetail().getTxtHiShoninRiyu().getValue())
                    && is等しい(特別地域加算減免申請の情報.get確認番号(), div.getShinseiDetail().getTxtKakuninNo().getValue());
        }
        return is等しい(特別地域加算減免申請の情報.get決定区分(), 決定区分コード)
                && 特別地域加算減免申請の情報.get決定年月日().equals(div.getShinseiDetail().getTxtKettaiYMD().getValue())
                && is等しい(特別地域加算減免申請の情報.get非承認理由(), div.getShinseiDetail().getTxtHiShoninRiyu().getValue());
    }

    private boolean is減免減額申請共有子Div等しい(TokubetsuchiikiKasanGemmen 特別地域加算減免申請の情報) {
        GemmenGengakuShinsei gemmenGengakuShinsei;
        if (特別地域加算減免申請の情報.getGemmenGengakuShinseiList().size() > 0) {
            gemmenGengakuShinsei = 特別地域加算減免申請の情報.getGemmenGengakuShinseiList().get(0);
        } else {
            gemmenGengakuShinsei = new GemmenGengakuShinsei(
                    ShoKisaiHokenshaNo.EMPTY, HihokenshaNo.EMPTY, GemmenGengakuShurui.特別地域加算減免.getコード(), 0);
        }

        RString 申請届出代行区分page = get申請届出代行区分page();

        RString 申請届出者氏名data = get申請届出者氏名data(gemmenGengakuShinsei);
        RString 申請届出者氏名page = get申請届出者氏名page();

        RString 申請届出者氏名カナdata = get申請届出者氏名カナdata(gemmenGengakuShinsei);
        RString 申請届出者氏名カナpage = get申請届出者氏名カナpage();

        RString 申請届出代行事業者番号data = get申請届出代行事業者番号data(gemmenGengakuShinsei);
        RString 申請届出代行事業者番号page = get申請届出代行事業者番号page();

        RString 事業者区分page = 事業者区分page();

        RString 申請届出者郵便番号data = get申請届出者郵便番号data(gemmenGengakuShinsei);
        RString 申請届出者郵便番号page = get申請届出者郵便番号page();

        RString 申請届出者住所data = get申請届出者住所data(gemmenGengakuShinsei);
        RString 申請届出者住所page = get申請届出者住所page();

        RString 申請届出者電話番号data = get申請届出者電話番号data(gemmenGengakuShinsei);
        RString 申請届出者電話番号page = get申請届出者電話番号page();

        return is等しい(gemmenGengakuShinsei.get申請届出代行区分(), 申請届出代行区分page)
                && is等しい(申請届出者氏名data, 申請届出者氏名page)
                && is等しい(申請届出者氏名カナdata, 申請届出者氏名カナpage)
                && is等しい(gemmenGengakuShinsei.get申請届出者続柄(), div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者続柄())
                && is等しい(申請届出代行事業者番号data, 申請届出代行事業者番号page)
                && is等しい(gemmenGengakuShinsei.get事業者区分(), 事業者区分page)
                && is等しい(申請届出者郵便番号data, 申請届出者郵便番号page)
                && is等しい(申請届出者住所data, 申請届出者住所page)
                && is等しい(申請届出者電話番号data, 申請届出者電話番号page);

    }

    private RString get申請届出代行区分page() {
        RString 申請届出代行区分page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行区分() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行区分().getCode();
        return 申請届出代行区分page;
    }

    private RString get申請届出者氏名data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        return gemmenGengakuShinsei.get申請届出者氏名() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者氏名().getColumnValue();
    }

    private RString get申請届出者氏名page() {
        RString 申請届出者氏名page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名().getColumnValue();
        return 申請届出者氏名page;
    }

    private RString get申請届出者氏名カナdata(GemmenGengakuShinsei gemmenGengakuShinsei) {
        return gemmenGengakuShinsei.get申請届出者氏名カナ() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者氏名カナ().getColumnValue();
    }

    private RString get申請届出者氏名カナpage() {
        RString 申請届出者氏名カナpage = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名カナ() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名カナ().getColumnValue();
        return 申請届出者氏名カナpage;
    }

    private RString get申請届出代行事業者番号data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        return gemmenGengakuShinsei.get申請届出代行事業者番号() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出代行事業者番号().getColumnValue();
    }

    private RString get申請届出代行事業者番号page() {
        RString 申請届出代行事業者番号page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行事業者番号() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行事業者番号().getColumnValue();
        return 申請届出代行事業者番号page;
    }

    private RString 事業者区分page() {
        return div.getCcdShinseiJoho().get減免減額申請情報().get事業者区分() == null ? RString.EMPTY : div.getCcdShinseiJoho().get減免減額申請情報().get事業者区分().getCode();
    }

    private RString get申請届出者郵便番号data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        return gemmenGengakuShinsei.get申請届出者郵便番号() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者郵便番号().getColumnValue();
    }

    private RString get申請届出者郵便番号page() {
        RString 申請届出者郵便番号page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者郵便番号() == null
                ? RString.EMPTY : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者郵便番号().getColumnValue();
        return 申請届出者郵便番号page;
    }

    private RString get申請届出者住所data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        return gemmenGengakuShinsei.get申請届出者住所() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者住所().getColumnValue();
    }

    private RString get申請届出者住所page() {
        RString 申請届出者住所page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者住所() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者住所().getColumnValue();
        return 申請届出者住所page;
    }

    private RString get申請届出者電話番号data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        return gemmenGengakuShinsei.get申請届出者電話番号() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者電話番号().getColumnValue();
    }

    private RString get申請届出者電話番号page() {
        RString 申請届出者電話番号page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者電話番号() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者電話番号().getColumnValue();
        return 申請届出者電話番号page;
    }

    private boolean is等しい(RString beforeVal, RString afterVal) {
        if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal == null || afterVal.isEmpty())) {
            return true;
        } else if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal != null && !afterVal.isEmpty())) {
            return false;
        }
        return beforeVal.equals(afterVal);
    }
}
