/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyoshaBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyoshaIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri.ShichosonTokubetsuKyufuJigyoshaViewState;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri.TokubetsuKyufuJigyoshaSearchResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.TokubetsuKyufuJigyoshaKannriDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaDetailServiceList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShichosonTokubetsuKyufuJigyoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShichosonTokubetuKyufuServiceManager;
import jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyoshakannri.TokubetsuKyufuJigyoshaRelateFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.business.core.date.DateEditor;
import jp.co.ndensan.reams.ur.urz.definition.core.todofuken.Todofuken;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.lang.RString.isNullOrEmpty;
import jp.co.ndensan.reams.uz.uza.math.ICheckDigit;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMNG1002_市町村特別給付・サービス事業者管理のハンドラークラスです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
public class TokubetsuKyufuJigyoshaKannriHandler {

    private final TokubetsuKyufuJigyoshaKannriDiv div;
    private final RString 有り = new RString("有り");
    private final RString 無し = new RString("無し");
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");
    private final int int5 = 5;
    private final int int9 = 9;
    private final int int10 = 10;

    /**
     * コンストラクタです。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     */
    public TokubetsuKyufuJigyoshaKannriHandler(TokubetsuKyufuJigyoshaKannriDiv div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     */
    public void initialize() {
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getDdlSearchKenCode().setDataSource(set県コードDDL());
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchJigyoshaKubun().setValue(new RString("0"));
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchGunshiCode().setValue(new RString("00"));
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchJigyoshaKubun().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchGunshiCode().setDisabled(true);
    }

    /**
     * モジュラス１０の計算方法で自動付番。
     *
     * @param icheckgigit icheckgigit
     */
    public void setモジュラス10ForSearch(ICheckDigit icheckgigit) {
        RString 連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchRenban().getValue();
        if (連番 == null || 連番.isEmpty()) {
            div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchCheckDigit().clearValue();
        } else {
            div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchCheckDigit().setValue(icheckgigit.appendModulus(連番));
        }
    }

    /**
     * モジュラス１０の計算方法で自動付番。
     *
     * @param icheckgigit icheckgigit
     */
    public void setモジュラス10ForCheck(ICheckDigit icheckgigit) {
        RString 連番 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtRenban().getValue();
        if (連番 == null || 連番.isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtCheckDigit().clearValue();
        } else {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtCheckDigit().setValue(icheckgigit.appendModulus(連番));
        }
    }

    /**
     * setサービス事業者一覧。
     *
     * @param businessList businessList
     * @param 市町村特別給付サービス事業者一覧 市町村特別給付サービス事業者一覧
     * @param viewStateList viewStateList
     */
    public void setサービス事業者一覧(List<TokubetsuKyufuJigyoshaSearchResult> businessList, ArrayList<ShichosonTokubetsuKyufuJigyosha> 市町村特別給付サービス事業者一覧,
            ArrayList<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList) {
        List<dgTokubetsuKyufuJigyoshaList_Row> rowList = new ArrayList<>();
        for (TokubetsuKyufuJigyoshaSearchResult searchresult : businessList) {
            dgTokubetsuKyufuJigyoshaList_Row row = new dgTokubetsuKyufuJigyoshaList_Row();
            row.setTxtJotai(RString.EMPTY);
            if (searchresult.get介護国保連ＩＦ異動区分().equals(new RString("01"))) {
                row.setTxtIdoKubun(new RString("新規"));
            }
            if (searchresult.get介護国保連ＩＦ異動区分().equals(new RString("02"))) {
                row.setTxtIdoKubun(new RString("変更"));
            }
            if (searchresult.get介護国保連ＩＦ異動区分().equals(new RString("03"))) {
                row.setTxtIdoKubun(new RString("終了"));
            }
            if (searchresult.get介護国保連ＩＦ異動年月日() != null) {
                row.setTxtIdoYMD(DateEditor.to和暦正式(searchresult.get介護国保連ＩＦ異動年月日()));
            }
            if (searchresult.get市町村特別給付用事業者番号() != null) {
                row.setTxtJigyoshaCode(searchresult.get市町村特別給付用事業者番号().value());
            }
            row.setTxtShinseishaName(searchresult.get申請者氏名_漢字());
            row.setTxtShinseishaJusho(searchresult.get申請者住所());
            row.setTxtServiceName(searchresult.get市町村特別給付用サービス名_略称());
            row.setTxtServiceCode(searchresult.get市町村特別給付サービス事業者Entity().getServiceCode().value());
            row.setTxtRirekiNo(new RString(searchresult.get市町村特別給付サービス事業者Entity().getRirekiNo()));
            rowList.add(row);
            ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyoshaManager().get市町村特別給付サービス事業者(
                    searchresult.get市町村特別給付用事業者番号(), searchresult.get市町村特別給付サービス事業者Entity().getServiceCode(),
                    searchresult.get市町村特別給付サービス事業者Entity().getRirekiNo());
            市町村特別給付サービス事業者一覧.add(市町村特別給付サービス事業者);
            viewStateList.add(new ShichosonTokubetsuKyufuJigyoshaViewState(市町村特別給付サービス事業者, RString.EMPTY, 市町村特別給付サービス事業者.get履歴番号()));
        }
        div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().setDataSource(rowList);
    }

    /**
     * 項目クリア。
     */
    public void set項目クリア() {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getDdlKenCode().setSelectedIndex(0);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtJigyoshaKubun().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtGunshiCode().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtRenban().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtCheckDigit().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setSelectedIndex(0);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setSelectedIndex(0);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTxtBiko().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaName().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaNameKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaYubinNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaTelNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaFaxNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaJusho().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaJushoKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaYakushoku().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaName().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaNameKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaYubinNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaJusho().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaJushoKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getDdlService().setSelectedIndex(0);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaNameKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaYubinNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJusho().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJushoKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaName().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaNameKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaYubinNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaTelNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaFaxNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJusho().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJushoKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaBiko().clearValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin().setSelectedIndex(0);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().setSelectedIndex(0);
    }

    /**
     * 追加ボタンを押した状態制御。
     */
    public void set追加ボタンを押した状態制御() {
        div.getTokubetsuKyufuJigyoshaSearch().setDisplayNone(true);
        div.getTokubetsuKyufuJigyoshaList().setDisplayNone(true);
        div.getTokubetsuKyufuJigyoshaDetail().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtBiko().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtBiko().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().setDisabled(false);
    }

    /**
     * 選択ボタンを押した状態制御。
     */
    public void set選択ボタンを押した状態制御() {
        div.getTokubetsuKyufuJigyoshaSearch().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaSearch().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaList().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaList().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtBiko().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtBiko().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().setDisplayNone(true);
    }

    /**
     * 申請一覧の削除ボタンを押下処理です。
     *
     * @param 選択row 選択row
     * @param 情報と状態ArrayList 情報と状態ArrayList
     */
    public void onSelectByDeleteButton(dgTokubetsuKyufuJigyoshaList_Row 選択row, List<ShichosonTokubetsuKyufuJigyoshaViewState> 情報と状態ArrayList) {
        RString 状態 = 選択row.getTxtJotai();
        if (状態.isEmpty() || 状態_修正.equals(状態)) {
            for (int index = 0; index < 情報と状態ArrayList.size(); index++) {
                if (情報と状態ArrayList.get(index).get市町村特別給付サービス事業者情報().get市町村特別給付用事業者番号().value().equals(選択row.getTxtJigyoshaCode())
                        && 情報と状態ArrayList.get(index).get市町村特別給付サービス事業者情報().get市町村特別給付用サービスコード().value().equals(選択row.getTxtServiceCode())
                        && new RString(情報と状態ArrayList.get(index).get市町村特別給付サービス事業者情報().get履歴番号()).equals(選択row.getTxtRirekiNo())) {
                    情報と状態ArrayList.get(index).setState(状態_削除);
                }
            }
        } else if (状態_追加.equals(状態)) {
            for (int index = 0; index < 情報と状態ArrayList.size(); index++) {
                if (情報と状態ArrayList.get(index).get市町村特別給付サービス事業者情報().get市町村特別給付用事業者番号().value().equals(選択row.getTxtJigyoshaCode())
                        && 情報と状態ArrayList.get(index).get市町村特別給付サービス事業者情報().get市町村特別給付用サービスコード().value().equals(選択row.getTxtServiceCode())
                        && new RString(情報と状態ArrayList.get(index).get市町村特別給付サービス事業者情報().get履歴番号()).equals(選択row.getTxtRirekiNo())) {
                    情報と状態ArrayList.remove(index);
                }
            }
        }
    }

    /**
     * set事業者コード。
     */
    public void set事業者コード() {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getDdlKenCode().setDataSource(set県コードDDL());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtJigyoshaKubun().setValue(new RString("0"));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtGunshiCode().setValue(new RString("00"));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtRenban().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtCheckDigit().setValue(RString.EMPTY);
    }

    /**
     * 市町村特別給付サービス事業者情報を取得します。
     *
     * @param row 当該選択行
     * @param 市町村特別給付サービス事業者一覧 画面初期の時、市町村特別給付サービス事業者一覧データを保持するリスト
     * @return 市町村特別給付サービス事業者情報
     */
    public ShichosonTokubetsuKyufuJigyosha get市町村特別給付サービス事業者情報(dgTokubetsuKyufuJigyoshaList_Row row, List<ShichosonTokubetsuKyufuJigyosha> 市町村特別給付サービス事業者一覧) {
        if (市町村特別給付サービス事業者一覧 != null) {
            for (ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者情報 : 市町村特別給付サービス事業者一覧) {
                if (市町村特別給付サービス事業者情報.get市町村特別給付用事業者番号().value().equals(row.getTxtJigyoshaCode())
                        && 市町村特別給付サービス事業者情報.get市町村特別給付用サービスコード().value().equals(row.getTxtServiceCode())
                        && new RString(市町村特別給付サービス事業者情報.get履歴番号()).equals(row.getTxtRirekiNo())) {
                    return 市町村特別給付サービス事業者情報;
                }
            }
        }
        return null;
    }

    /**
     * 該当申請のViewStateを取得します。
     *
     * @param row 選択行
     * @param viewStateList 市町村特別給付サービス事業者情報のViewStateリスト
     * @return 該当申請のViewState
     */
    public ShichosonTokubetsuKyufuJigyoshaViewState get該当申請のViewState(dgTokubetsuKyufuJigyoshaList_Row row, List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList) {
        if (viewStateList != null) {
            for (ShichosonTokubetsuKyufuJigyoshaViewState 申請ViewState : viewStateList) {
                if (申請ViewState.get市町村特別給付サービス事業者情報().get市町村特別給付用事業者番号().value().equals(row.getTxtJigyoshaCode())
                        && 申請ViewState.get市町村特別給付サービス事業者情報().get市町村特別給付用サービスコード().value().equals(row.getTxtServiceCode())
                        && new RString(申請ViewState.get市町村特別給付サービス事業者情報().get履歴番号()).equals(row.getTxtRirekiNo())) {
                    return 申請ViewState;
                }
            }
        }
        return null;
    }

    /**
     * set選択項目。
     *
     * @param 選択row 選択row
     * @param 市町村特別給付サービス事業者 市町村特別給付サービス事業者
     */
    public void set選択項目1_5(dgTokubetsuKyufuJigyoshaList_Row 選択row, ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者) {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getDdlKenCode().setDataSource(set県コードDDL());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getDdlKenCode().setSelectedKey(選択row.getTxtJigyoshaCode().substring(0, 2));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtJigyoshaKubun().setValue(new RString("0"));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtGunshiCode().setValue(new RString("00"));
        if (選択row.getTxtJigyoshaCode().length() >= int9) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtRenban().setValue(選択row.getTxtJigyoshaCode().substring(int5, int9));
        }
        if (選択row.getTxtJigyoshaCode().length() >= int10) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtCheckDigit().setValue(選択row.getTxtJigyoshaCode().substring(int9, int10));
        }
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setSelectedKey(選択row.getTxtIdoKubun());
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setValue(new RDate(選択row.getTxtIdoYMD().toString()));
        if (市町村特別給付サービス事業者 != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setSelectedKey(市町村特別給付サービス事業者.get介護国保連ＩＦ法人種別());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                    getTxtShinseishaName().setValue(市町村特別給付サービス事業者.get申請者氏名_漢字());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                    getTxtShinseishaNameKana().setValue(市町村特別給付サービス事業者.get申請者氏名_カナ());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                    getTxtShinseishaYubinNo().setValue(市町村特別給付サービス事業者.get申請者郵便番号());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                    getTxtShinseishaTelNo().setValue(市町村特別給付サービス事業者.get申請者電話番号());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                    getTxtShinseishaFaxNo().setValue(市町村特別給付サービス事業者.get申請者FAX番号());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                    getTxtShinseishaJusho().setValue(市町村特別給付サービス事業者.get申請者住所());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                    getTxtShinseishaJushoKana().setValue(市町村特別給付サービス事業者.get申請者住所_カナ());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                    getTxtDaihyoshaYakushoku().setValue(市町村特別給付サービス事業者.get事業所代表者役職());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                    getTxtDaihyoshaName().setValue(市町村特別給付サービス事業者.get事業所代表者氏名());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                    getTxtDaihyoshaNameKana().setValue(市町村特別給付サービス事業者.get事業所代表者氏名カナ());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                    getTxtDaihyoshaYubinNo().setValue(市町村特別給付サービス事業者.get事業所代表者郵便番号());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                    getTxtDaihyoshaJusho().setValue(市町村特別給付サービス事業者.get事業所代表者住所());
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                    getTxtDaihyoshaJushoKana().setValue(市町村特別給付サービス事業者.get事業所代表者住所カナ());
        }
        List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容一覧 = new ShichosonTokubetuKyufuServiceManager().get市町村特別給付サービス内容一覧();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getDdlService().setDataSource(set特別給付サービスDDL(市町村特別給付サービス内容一覧));
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getDdlService().setSelectedKey(選択row.getTxtServiceCode());
        setサービス一覧(選択row, 市町村特別給付サービス事業者);

    }

    /**
     * 「事業者情報を確定する」ボタンを押下処理です。
     *
     * @param viewStateList viewStateList
     * @param 編集情報 編集情報
     * @param 追加履歴番号 追加履歴番号
     * @param 最初情報 最初情報
     */
    public void onClick_btnSaveTemp(List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList, ShichosonTokubetsuKyufuJigyoshaViewState 編集情報,
            Integer 追加履歴番号, ShichosonTokubetsuKyufuJigyoshaViewState 最初情報) {
        if (編集情報 == null) {
            ShichosonTokubetsuKyufuJigyoshaViewState 画面情報 = get情報と状態From画面(追加履歴番号);
            set追加処理(viewStateList, 画面情報);
        } else if (状態_追加.equals(編集情報.getState())) {
            set追加修正処理(viewStateList, 編集情報);
        } else {
            set修正処理(viewStateList, 編集情報, 最初情報);
        }
        div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().setDataSource(getDataSource(viewStateList));
    }

    private void setサービス一覧(dgTokubetsuKyufuJigyoshaList_Row 選択row, ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者) {
        List<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> rowlist = new ArrayList<>();
        dgTokubetsuKyufuJigyoshaDetailServiceList_Row row = new dgTokubetsuKyufuJigyoshaDetailServiceList_Row();
        row.setTxtService(選択row.getTxtServiceName());
        row.setTxtJigyoshaCode(市町村特別給付サービス事業者.get市町村特別給付用事業者番号().value());
        row.setTxtServiceCode(市町村特別給付サービス事業者.get市町村特別給付用サービスコード().value());
        row.setTxtRirekiNo(new RString(市町村特別給付サービス事業者.get履歴番号()));
        row.setTxtKanrisha(市町村特別給付サービス事業者.get事業所管理者氏名());
        if (市町村特別給付サービス事業者.getサービス事業所事業開始年月日() != null) {
            row.setTxtJigyoKaishiYMD(DateEditor.to和暦正式(市町村特別給付サービス事業者.getサービス事業所事業開始年月日()));
        }
        if (市町村特別給付サービス事業者.getサービス事業所事業休止年月日() != null) {
            row.setTxtJigyoKyushiYMD(DateEditor.to和暦正式(市町村特別給付サービス事業者.getサービス事業所事業休止年月日()));
        }
        if (市町村特別給付サービス事業者.getサービス事業所事業廃止年月日() != null) {
            row.setTxtJigyoHaishiYMD(DateEditor.to和暦正式(市町村特別給付サービス事業者.getサービス事業所事業廃止年月日()));
        }
        if (市町村特別給付サービス事業者.getサービス事業所事業再開年月日() != null) {
            row.setTxtJigyoSaikaiYMD(DateEditor.to和暦正式(市町村特別給付サービス事業者.getサービス事業所事業再開年月日()));
        }
        if (市町村特別給付サービス事業者.get市町村特別給付登録開始年月日() != null) {
            row.setTxtTorokuKaishiYMD(DateEditor.to和暦正式(市町村特別給付サービス事業者.get市町村特別給付登録開始年月日()));
        }
        if (市町村特別給付サービス事業者.get市町村特別給付登録終了年月日() != null) {
            row.setTxtTorokuShuryoYMD(DateEditor.to和暦正式(市町村特別給付サービス事業者.get市町村特別給付登録終了年月日()));
        }
        if (市町村特別給付サービス事業者.get受領委任区分().equals(new RString(0))) {
            row.setTxtJuryoInin(無し);
        } else if (市町村特別給付サービス事業者.get受領委任区分().equals(new RString(1))) {
            row.setTxtJuryoInin(有り);
        }
        if (市町村特別給付サービス事業者.is生活保護法による指定の有()) {
            row.setTxtSeikatsuHogo(有り);
        } else {
            row.setTxtSeikatsuHogo(無し);
        }
        rowlist.add(row);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceList().
                getDgTokubetsuKyufuJigyoshaDetailServiceList().setDataSource(rowlist);
    }

    /**
     * 修正ボタンを押した状態制御。
     */
    public void set修正ボタンを押した状態制御() {
        div.getTokubetsuKyufuJigyoshaSearch().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaSearch().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaList().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaList().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtBiko().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtBiko().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().setDisplayNone(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().setDisplayNone(true);
    }

    /**
     * 情報変更あり。
     *
     * @param 市町村特別給付サービス事業者の情報 市町村特別給付サービス事業者の情報
     * @return 情報変更あり
     */
    public boolean 情報変更あり(ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者の情報) {
        return !((市町村特別給付サービス事業者の情報.get介護国保連ＩＦ異動年月日().equals(div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().getValue())
                || div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().getValue() == null && 市町村特別給付サービス事業者の情報.get介護国保連ＩＦ異動年月日().isEmpty())
                && is等しい(市町村特別給付サービス事業者の情報.get介護国保連ＩＦ異動区分(), div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().getSelectedKey())
                && is申請者情報等しい(市町村特別給付サービス事業者の情報) && is代表者情報等しい(市町村特別給付サービス事業者の情報));
    }

    /**
     * 「申請者情報からコピーする」の押した(onClick)イベントを行う。
     */
    public void setDaihyoshaCopy() {
        RString 申請者情報氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().getValue();
        RString 申請者情報氏名カナ = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().getValue();
        YubinNo 申請者情報郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().getValue();
        RString 申請者情報住所 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().getValue();
        RString 申請者情報住所カナ = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().getValue();
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().setValue(申請者情報氏名 == null ? RString.EMPTY
                : 申請者情報氏名);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().setValue(申請者情報氏名カナ == null ? RString.EMPTY
                : 申請者情報氏名カナ);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo().setValue(申請者情報郵便番号 == null ? YubinNo.EMPTY
                : 申請者情報郵便番号);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().setValue(申請者情報住所 == null ? RString.EMPTY
                : 申請者情報住所);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().setValue(申請者情報住所カナ == null ? RString.EMPTY
                : 申請者情報住所カナ);
    }

    /**
     * set詳細情報。
     *
     * @param row row
     */
    public void set詳細情報(dgTokubetsuKyufuJigyoshaDetailServiceList_Row row) {
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getTxtJigyoshaCode());
        ServiceCode サービスコード = new ServiceCode(row.getTxtServiceCode());
    }

    private List<KeyValueDataSource> set県コードDDL() {
        List<KeyValueDataSource> 県コードdataSource = new ArrayList<>();
        for (Todofuken item : Todofuken.values()) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
            keyValueDataSource.setKey(item.get都道府県住所コード());
            keyValueDataSource.setValue(item.get都道府県住所コード().concat(new RString(":")).concat(item.get名称()));
            県コードdataSource.add(keyValueDataSource);
        }
        return 県コードdataSource;
    }

    private List<KeyValueDataSource> set特別給付サービスDDL(List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容一覧) {
        List<KeyValueDataSource> 特別給付サービスdataSource = new ArrayList<>();
        for (ShichosonTokubetuKyufuService 市町村特別給付サービス内容 : 市町村特別給付サービス内容一覧) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
            keyValueDataSource.setKey(市町村特別給付サービス内容.get市町村特別給付用サービスコード());
            keyValueDataSource.setValue(市町村特別給付サービス内容.get市町村特別給付用サービスコード().concat(RString.HALF_SPACE).concat(
                    市町村特別給付サービス内容.get市町村特別給付用サービス名_略称()));
            特別給付サービスdataSource.add(keyValueDataSource);
        }
        return 特別給付サービスdataSource;
    }

    private boolean is申請者情報等しい(ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者の情報) {
        RString 氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaName().getValue();
        RString カナ氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaNameKana().getValue();
        YubinNo 郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaYubinNo().getValue();
        RString 電話番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaTelNo().getValue();
        RString 申請者FAX番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaFaxNo().getValue();
        RString 住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaJusho().getValue();
        RString カナ住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha().
                getTxtShinseishaJushoKana().getValue();
        return is等しい(市町村特別給付サービス事業者の情報.get申請者氏名_漢字(), 氏名) && is等しい(市町村特別給付サービス事業者の情報.get申請者氏名_カナ(), カナ氏名)
                && (郵便番号.equals(市町村特別給付サービス事業者の情報.get申請者郵便番号()) || 郵便番号.isEmpty() && 市町村特別給付サービス事業者の情報.get申請者郵便番号() == null)
                && is等しい(市町村特別給付サービス事業者の情報.get申請者電話番号(), 電話番号) && is等しい(市町村特別給付サービス事業者の情報.get申請者FAX番号(), 申請者FAX番号)
                && is等しい(市町村特別給付サービス事業者の情報.get申請者住所(), 住所) && is等しい(市町村特別給付サービス事業者の情報.get申請者住所_カナ(), カナ住所);
    }

    private boolean is代表者情報等しい(ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者の情報) {
        RString 役職 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaYakushoku().getValue();
        RString 氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaName().getValue();
        RString カナ氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaNameKana().getValue();
        YubinNo 郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaYubinNo().getValue();
        RString 住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaJusho().getValue();
        RString カナ住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha().
                getTxtDaihyoshaJushoKana().getValue();
        return is等しい(市町村特別給付サービス事業者の情報.get事業所代表者役職(), 役職) && is等しい(市町村特別給付サービス事業者の情報.get事業所代表者氏名(), 氏名)
                && is等しい(市町村特別給付サービス事業者の情報.get事業所代表者氏名カナ(), カナ氏名)
                && (郵便番号.equals(市町村特別給付サービス事業者の情報.get事業所代表者郵便番号()) || 郵便番号.isEmpty() && 市町村特別給付サービス事業者の情報.get事業所代表者郵便番号() == null)
                && is等しい(市町村特別給付サービス事業者の情報.get事業所管理者住所(), 住所) && is等しい(市町村特別給付サービス事業者の情報.get事業所管理者住所カナ(), カナ住所);
    }

    private boolean is等しい(RString beforeVal, RString afterVal) {
        if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal == null || afterVal.isEmpty())) {
            return true;
        } else if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal != null && !afterVal.isEmpty())) {
            return false;
        }
        return beforeVal.equals(afterVal);
    }

    private ShichosonTokubetsuKyufuJigyoshaViewState get情報と状態From画面(Integer 追加履歴番号) {
        RString 県コード = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getDdlKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtJigyoshaKubun().getText();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtGunshiCode().getText();
        RString 連番 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtRenban().getText();
        RString cd = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtCheckDigit().getText();
        JigyoshaNo 市町村特別給付用事業者番号 = new JigyoshaNo(県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cd));
        RString 市町村特別給付用サービスコード = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedKey();
        ShichosonTokubetsuKyufuJigyosha 情報 = new ShichosonTokubetsuKyufuJigyosha(市町村特別給付用事業者番号, new ServiceCode(市町村特別給付用サービスコード),
                追加履歴番号);
        ShichosonTokubetsuKyufuJigyoshaBuilder builder = 情報.createBuilderForEdit();
        RString 画面サービス事業所名 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaName().getValue();
        RString 画面サービス事業所名カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaNameKana().getValue();
        YubinNo 画面サービス事業所郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaYubinNo().getValue();
        RString 画面サービス事業所住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJusho().getValue();
        RString 画面サービス事業所住所カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJushoKana().getValue();
        RString 画面サービス事業所電話番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaTelNo().getValue();
        RString 画面サービス事業所FAX番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaFaxNo().getValue();
        RDate 画面サービス事業所事業開始年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD().getValue();
        RDate 画面サービス事業所事業休止年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD().getValue();
        RDate 画面サービス事業所事業廃止年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD().getValue();
        RDate 画面サービス事業所事業再開年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD().getValue();
        RDate 画面市町村特別給付登録開始年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().getValue();
        RDate 画面市町村特別給付登録終了年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().getValue();
        builder.set介護国保連ＩＦ異動区分(div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().getSelectedKey());
        builder.set介護国保連ＩＦ異動年月日(new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().getValue().toDateString()));
        builder.set介護国保連ＩＦ法人種別(div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().getSelectedKey());
        set申請者修正情報と状態(builder);
        set代表者修正情報と状態(builder);
        set管理者修正情報と状態(builder);
        builder.setサービス事業所名(画面サービス事業所名 == null ? RString.EMPTY : 画面サービス事業所名);
        builder.setサービス事業所名カナ(画面サービス事業所名カナ == null ? RString.EMPTY : 画面サービス事業所名カナ);
        builder.setサービス事業所郵便番号(画面サービス事業所郵便番号 == null ? YubinNo.EMPTY : 画面サービス事業所郵便番号);
        builder.setサービス事業所住所(画面サービス事業所住所 == null ? RString.EMPTY : 画面サービス事業所住所);
        builder.setサービス事業所住所カナ(画面サービス事業所住所カナ == null ? RString.EMPTY : 画面サービス事業所住所カナ);
        builder.setサービス事業所電話番号(画面サービス事業所電話番号 == null ? RString.EMPTY : 画面サービス事業所電話番号);
        builder.setサービス事業所FAX番号(画面サービス事業所FAX番号 == null ? RString.EMPTY : 画面サービス事業所FAX番号);
        builder.setサービス事業所事業開始年月日(画面サービス事業所事業開始年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面サービス事業所事業開始年月日.toDateString()));
        builder.setサービス事業所事業休止年月日(画面サービス事業所事業休止年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面サービス事業所事業休止年月日.toDateString()));
        builder.setサービス事業所事業廃止年月日(画面サービス事業所事業廃止年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面サービス事業所事業廃止年月日.toDateString()));
        builder.setサービス事業所事業再開年月日(画面サービス事業所事業再開年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面サービス事業所事業再開年月日.toDateString()));
        builder.set受領委任区分(div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin().getSelectedKey());
        builder.set市町村特別給付登録開始年月日(画面市町村特別給付登録開始年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面市町村特別給付登録開始年月日.toDateString()));
        builder.set市町村特別給付登録終了年月日(画面市町村特別給付登録終了年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面市町村特別給付登録終了年月日.toDateString()));
        if (div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().getSelectedKey().equals(new RString(0))) {
            builder.set生活保護法による指定の有(true);
        } else if (div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().getSelectedKey().equals(new RString(1))) {
            builder.set生活保護法による指定の有(false);
        }
        return new ShichosonTokubetsuKyufuJigyoshaViewState(builder.build(), 状態_追加, 追加履歴番号);
    }

    private void set追加修正処理(List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList, ShichosonTokubetsuKyufuJigyoshaViewState 編集情報) {
        ShichosonTokubetsuKyufuJigyosha 情報 = 編集情報.get市町村特別給付サービス事業者情報();
        ShichosonTokubetsuKyufuJigyoshaIdentifier id = 情報.identifier();
        boolean isDeleteed = false;
        for (int index = 0; index < viewStateList.size() && !isDeleteed; index++) {
            if (id.equals(viewStateList.get(index).get市町村特別給付サービス事業者情報().identifier())) {
                viewStateList.remove(index);
                isDeleteed = true;
            } else {
                viewStateList.get(index).setRirekiNo(viewStateList.get(index).getRirekiNo() - 1);
            }
        }
        set修正情報と状態(編集情報);
        set追加処理(viewStateList, 編集情報);
    }

    private void set修正処理(List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList,
            ShichosonTokubetsuKyufuJigyoshaViewState 編集情報, ShichosonTokubetsuKyufuJigyoshaViewState 最初情報) {
        ShichosonTokubetsuKyufuJigyosha 情報 = 編集情報.get市町村特別給付サービス事業者情報();
        ShichosonTokubetsuKyufuJigyoshaIdentifier id = 情報.identifier();
        int size = viewStateList.size();
        for (int index = 0; index < size; index++) {
            ShichosonTokubetsuKyufuJigyoshaViewState 情報と状態 = viewStateList.get(index);
            if (id.equals(情報と状態.get市町村特別給付サービス事業者情報().identifier())) {
                if (!情報変更あり(最初情報.get市町村特別給付サービス事業者情報())) {
                    最初情報.setState(RString.EMPTY);
                    最初情報.setRirekiNo(情報と状態.getRirekiNo());
                    viewStateList.remove(index);
                    add情報と状態(viewStateList, 最初情報, index, size);
                } else {
                    set修正情報と状態(情報と状態);
                }
            }
        }
    }

    private void set追加処理(List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList, ShichosonTokubetsuKyufuJigyoshaViewState 画面情報) {
        if (viewStateList.isEmpty()) {
            画面情報.setRirekiNo(0);
            viewStateList.add(画面情報);
        }
        int size = viewStateList.size();
        boolean isAdded = false;
        int 履歴番号 = viewStateList.get(size - 1).getRirekiNo();
        for (int i = 0; i <= size; i++) {
            if (!isAdded) {
                if (i == size) {
                    画面情報.setRirekiNo(履歴番号);
                    viewStateList.add(画面情報);
                    continue;
                }
                ShichosonTokubetsuKyufuJigyoshaViewState 情報 = viewStateList.get(i);
                if (!画面情報.get市町村特別給付サービス事業者情報().get介護国保連ＩＦ異動年月日()
                        .isBeforeOrEquals(情報.get市町村特別給付サービス事業者情報().get介護国保連ＩＦ異動年月日())) {
                    画面情報.setRirekiNo(情報.getRirekiNo() + 1);
                    viewStateList.add(i, 画面情報);
                    isAdded = true;
                } else {
                    情報.setRirekiNo(情報.getRirekiNo() + 1);
                }
            }
        }
    }

    private void set修正情報と状態(ShichosonTokubetsuKyufuJigyoshaViewState 情報と状態) {
        ShichosonTokubetsuKyufuJigyosha 情報 = 情報と状態.get市町村特別給付サービス事業者情報();
        ShichosonTokubetsuKyufuJigyoshaBuilder builder = 情報.createBuilderForEdit();
        RString 画面サービス事業所名 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaName().getValue();
        RString 画面サービス事業所名カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaNameKana().getValue();
        YubinNo 画面サービス事業所郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaYubinNo().getValue();
        RString 画面サービス事業所住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJusho().getValue();
        RString 画面サービス事業所住所カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJushoKana().getValue();
        RString 画面サービス事業所電話番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaTelNo().getValue();
        RString 画面サービス事業所FAX番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaFaxNo().getValue();
        RDate 画面サービス事業所事業開始年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD().getValue();
        RDate 画面サービス事業所事業休止年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD().getValue();
        RDate 画面サービス事業所事業廃止年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD().getValue();
        RDate 画面サービス事業所事業再開年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD().getValue();
        RDate 画面市町村特別給付登録開始年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().getValue();
        RDate 画面市町村特別給付登録終了年月日 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().getValue();
        builder.set介護国保連ＩＦ異動区分(div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().getSelectedKey());
        builder.set介護国保連ＩＦ異動年月日(new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().getValue().toDateString()));
        builder.set介護国保連ＩＦ法人種別(div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().getSelectedKey());
        set申請者修正情報と状態(builder);
        set代表者修正情報と状態(builder);
        set管理者修正情報と状態(builder);
        builder.setサービス事業所名(画面サービス事業所名 == null ? RString.EMPTY : 画面サービス事業所名);
        builder.setサービス事業所名カナ(画面サービス事業所名カナ == null ? RString.EMPTY : 画面サービス事業所名カナ);
        builder.setサービス事業所郵便番号(画面サービス事業所郵便番号 == null ? YubinNo.EMPTY : 画面サービス事業所郵便番号);
        builder.setサービス事業所住所(画面サービス事業所住所 == null ? RString.EMPTY : 画面サービス事業所住所);
        builder.setサービス事業所住所カナ(画面サービス事業所住所カナ == null ? RString.EMPTY : 画面サービス事業所住所カナ);
        builder.setサービス事業所電話番号(画面サービス事業所電話番号 == null ? RString.EMPTY : 画面サービス事業所電話番号);
        builder.setサービス事業所FAX番号(画面サービス事業所FAX番号 == null ? RString.EMPTY : 画面サービス事業所FAX番号);
        builder.setサービス事業所事業開始年月日(画面サービス事業所事業開始年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面サービス事業所事業開始年月日.toDateString()));
        builder.setサービス事業所事業休止年月日(画面サービス事業所事業休止年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面サービス事業所事業休止年月日.toDateString()));
        builder.setサービス事業所事業廃止年月日(画面サービス事業所事業廃止年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面サービス事業所事業廃止年月日.toDateString()));
        builder.setサービス事業所事業再開年月日(画面サービス事業所事業再開年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面サービス事業所事業再開年月日.toDateString()));
        builder.set受領委任区分(div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin().getSelectedKey());
        builder.set市町村特別給付登録開始年月日(画面市町村特別給付登録開始年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面市町村特別給付登録開始年月日.toDateString()));
        builder.set市町村特別給付登録終了年月日(画面市町村特別給付登録終了年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(画面市町村特別給付登録終了年月日.toDateString()));
        if (div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().getSelectedKey().equals(new RString(0))) {
            builder.set生活保護法による指定の有(true);
        } else if (div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().getSelectedKey().equals(new RString(1))) {
            builder.set生活保護法による指定の有(false);
        }
        情報と状態.set市町村特別給付サービス事業者情報(builder.build());
        if (情報と状態.getState() == null || 情報と状態.getState().isEmpty() || 状態_修正.equals(情報と状態.getState())) {
            情報と状態.setState(状態_修正);
        }
    }

    private void set申請者修正情報と状態(ShichosonTokubetsuKyufuJigyoshaBuilder builder) {
        RString 画面申請者氏名_漢字 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().getValue();
        RString 画面申請者氏名_カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().getValue();
        YubinNo 画面申請者郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().getValue();
        RString 画面申請者住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().getValue();
        RString 画面申請者住所_カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().getValue();
        RString 画面申請者電話番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().getValue();
        RString 画面申請者FAX番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().getValue();
        builder.set申請者氏名_漢字(画面申請者氏名_漢字 == null ? RString.EMPTY : 画面申請者氏名_漢字);
        builder.set申請者氏名_カナ(画面申請者氏名_カナ == null ? RString.EMPTY : 画面申請者氏名_カナ);
        builder.set申請者郵便番号(画面申請者郵便番号 == null ? YubinNo.EMPTY : 画面申請者郵便番号);
        builder.set申請者住所(画面申請者住所 == null ? RString.EMPTY : 画面申請者住所);
        builder.set申請者住所_カナ(画面申請者住所_カナ == null ? RString.EMPTY : 画面申請者住所_カナ);
        builder.set申請者電話番号(画面申請者電話番号 == null ? RString.EMPTY : 画面申請者電話番号);
        builder.set申請者FAX番号(画面申請者FAX番号 == null ? RString.EMPTY : 画面申請者FAX番号);
    }

    private void set代表者修正情報と状態(ShichosonTokubetsuKyufuJigyoshaBuilder builder) {
        RString 画面事業所代表者役職 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku().getValue();
        RString 画面事業所代表者氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().getValue();
        RString 画面事業所代表者氏名カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().getValue();
        YubinNo 画面事業所代表者郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo().getValue();
        RString 画面事業所代表者住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().getValue();
        RString 画面事業所代表者住所カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().
                getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().getValue();
        builder.set事業所代表者役職(画面事業所代表者役職 == null ? RString.EMPTY : 画面事業所代表者役職);
        builder.set事業所代表者氏名(画面事業所代表者氏名 == null ? RString.EMPTY : 画面事業所代表者氏名);
        builder.set事業所代表者氏名カナ(画面事業所代表者氏名カナ == null ? RString.EMPTY : 画面事業所代表者氏名カナ);
        builder.set事業所代表者郵便番号(画面事業所代表者郵便番号 == null ? YubinNo.EMPTY : 画面事業所代表者郵便番号);
        builder.set事業所代表者住所(画面事業所代表者住所 == null ? RString.EMPTY : 画面事業所代表者住所);
        builder.set事業所代表者住所カナ(画面事業所代表者住所カナ == null ? RString.EMPTY : 画面事業所代表者住所カナ);
    }

    private void set管理者修正情報と状態(ShichosonTokubetsuKyufuJigyoshaBuilder builder) {
        RString 画面事業所管理者氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName().getValue();
        RString 画面事業所管理者氏名カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaNameKana().getValue();
        YubinNo 画面事業所管理者郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaYubinNo().getValue();
        RString 画面事業所管理者住所 = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJusho().getValue();
        RString 画面事業所管理者住所カナ = div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJushoKana().getValue();
        builder.set事業所管理者氏名(画面事業所管理者氏名 == null ? RString.EMPTY : 画面事業所管理者氏名);
        builder.set事業所管理者氏名カナ(画面事業所管理者氏名カナ == null ? RString.EMPTY : 画面事業所管理者氏名カナ);
        builder.set事業所管理者郵便番号(画面事業所管理者郵便番号 == null ? YubinNo.EMPTY : 画面事業所管理者郵便番号);
        builder.set事業所管理者住所(画面事業所管理者住所 == null ? RString.EMPTY : 画面事業所管理者住所);
        builder.set事業所管理者住所カナ(画面事業所管理者住所カナ == null ? RString.EMPTY : 画面事業所管理者住所カナ);
    }

    private void add情報と状態(List<ShichosonTokubetsuKyufuJigyoshaViewState> 情報と状態ArrayList,
            ShichosonTokubetsuKyufuJigyoshaViewState 情報と状態, int index, int size) {
        if (index == size) {
            情報と状態ArrayList.add(情報と状態);
        } else {
            情報と状態ArrayList.add(index, 情報と状態);
        }
    }

    private List<dgTokubetsuKyufuJigyoshaList_Row> getDataSource(List<ShichosonTokubetsuKyufuJigyoshaViewState> 情報と状態List) {
        List<dgTokubetsuKyufuJigyoshaList_Row> rowList = new ArrayList<>();
        for (ShichosonTokubetsuKyufuJigyoshaViewState 情報と状態 : 情報と状態List) {
            ShichosonTokubetsuKyufuJigyosha 情報 = 情報と状態.get市町村特別給付サービス事業者情報();
            dgTokubetsuKyufuJigyoshaList_Row row = new dgTokubetsuKyufuJigyoshaList_Row();
            row.setTxtJotai(情報と状態.getState());
            row.setTxtIdoKubun(情報.get介護国保連ＩＦ異動区分());
            if (情報.get介護国保連ＩＦ異動年月日() != null) {
                row.setTxtIdoYMD(DateEditor.to和暦正式(情報.get介護国保連ＩＦ異動年月日()));
            }
            if (情報.get市町村特別給付用事業者番号() != null) {
                row.setTxtJigyoshaCode(情報.get市町村特別給付用事業者番号().value());
            }
            row.setTxtShinseishaName(情報.get申請者氏名_漢字());
            row.setTxtShinseishaJusho(情報.get申請者住所());
            row.setTxtServiceName(div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().
                    getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedValue());
            row.setTxtServiceCode(情報.get市町村特別給付用サービスコード().value());
            row.setTxtRirekiNo(new RString(情報.get履歴番号()));
            rowList.add(row);
            //row.setDataId(DataPassingConverter.serialize(情報.identifier()));
        }
        return rowList;
    }

}
