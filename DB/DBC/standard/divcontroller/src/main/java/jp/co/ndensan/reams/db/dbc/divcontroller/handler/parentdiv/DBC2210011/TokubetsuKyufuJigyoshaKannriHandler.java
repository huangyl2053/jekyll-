/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri.TokubetsuKyufuJigyoshaSearchResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.TokubetsuKyufuJigyoshaKannriDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShichosonTokubetsuKyufuJigyoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShichosonTokubetuKyufuServiceManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.business.core.date.DateEditor;
import jp.co.ndensan.reams.ur.urz.definition.core.todofuken.Todofuken;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.ICheckDigit;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMNG1002_市町村特別給付・サービス事業者管理のハンドラークラスです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
public class TokubetsuKyufuJigyoshaKannriHandler {

    private final TokubetsuKyufuJigyoshaKannriDiv div;

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
    public void setモジュラス１０(ICheckDigit icheckgigit) {
        RString 連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchRenban().getValue();
        if (連番 == null || 連番.isEmpty()) {
            div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchCheckDigit().clearValue();
        } else {
            div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchCheckDigit().setValue(icheckgigit.appendModulus(連番));
        }
    }

    /**
     * setサービス事業者一覧。
     *
     * @param businessList businessList
     */
    public void setサービス事業者一覧(List<TokubetsuKyufuJigyoshaSearchResult> businessList) {
        List<dgTokubetsuKyufuJigyoshaList_Row> rowList = new ArrayList<>();
        for (TokubetsuKyufuJigyoshaSearchResult searchresult : businessList) {
            dgTokubetsuKyufuJigyoshaList_Row row = new dgTokubetsuKyufuJigyoshaList_Row();
            row.setTxtIdoKubun(searchresult.get介護国保連ＩＦ異動区分());
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
     * set選択項目。
     *
     * @param 選択row 選択row
     */
    public void set選択項目1_5(dgTokubetsuKyufuJigyoshaList_Row 選択row) {
        RString 事業者コード = 選択row.getTxtJigyoshaCode();
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getDdlKenCode().setDataSource(set県コードDDL());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getDdlKenCode().setSelectedKey(事業者コード.substring(0, 2));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtJigyoshaKubun().setValue(new RString("0"));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtGunshiCode().setValue(new RString("00"));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtRenban().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtCheckDigit().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setSelectedKey(選択row.getTxtIdoKubun());
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setValue(new RDate(選択row.getTxtIdoYMD().toString()));
        ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyoshaManager().get市町村特別給付サービス事業者(
                new JigyoshaNo(事業者コード), new ServiceCode(選択row.getTxtServiceCode()), Integer.parseInt(選択row.getTxtRirekiNo().toString()));
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
        List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容一覧 = new ShichosonTokubetuKyufuServiceManager().get市町村特別給付サービス内容一覧();
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getDdlService().setDataSource(set県コードDDL(市町村特別給付サービス内容一覧));
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getDdlService().setSelectedKey(選択row.getTxtServiceCode());
        if (市町村特別給付サービス事業者.getサービス事業所事業開始年月日() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD().
                    setValue(new RDate(市町村特別給付サービス事業者.getサービス事業所事業開始年月日().toString()));
        }
        if (市町村特別給付サービス事業者.getサービス事業所事業休止年月日() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD().
                    setValue(new RDate(市町村特別給付サービス事業者.getサービス事業所事業休止年月日().toString()));
        }
        if (市町村特別給付サービス事業者.getサービス事業所事業廃止年月日() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD().
                    setValue(new RDate(市町村特別給付サービス事業者.getサービス事業所事業廃止年月日().toString()));
        }
        if (市町村特別給付サービス事業者.getサービス事業所事業再開年月日() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD().
                    setValue(new RDate(市町村特別給付サービス事業者.getサービス事業所事業再開年月日().toString()));
        }
        if (市町村特別給付サービス事業者.get市町村特別給付登録開始年月日() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().
                    setValue(new RDate(市町村特別給付サービス事業者.get市町村特別給付登録開始年月日().toString()));
        }
        if (市町村特別給付サービス事業者.get市町村特別給付登録終了年月日() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().
                    setValue(new RDate(市町村特別給付サービス事業者.get市町村特別給付登録終了年月日().toString()));
        }
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin().setSelectedKey(市町村特別給付サービス事業者.get受領委任区分());
        div.getTokubetsuKyufuJigyoshaDetail().getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().setWrap(市町村特別給付サービス事業者.is生活保護法による指定の有());
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

    private List<KeyValueDataSource> set県コードDDL(List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容一覧) {
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
}
