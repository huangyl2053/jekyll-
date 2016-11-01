/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch.TokubetsuKyufuJigyoshaSearchBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaDetailServiceList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyosha.TokubetsuKyufuJigyoshaService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.todofuken.TodofukenType;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitFactory;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitKind;
import jp.co.ndensan.reams.uz.uza.math.ICheckDigit;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @reamsid_L DBC-3430-010 liuyl
 */
public class DBC2210011MainHandler {

    private final DBC2210011MainDiv div;
    private static final int NO_3 = 3;
    private static final int NO_5 = 5;
    private static final int NO_9 = 9;
    private static final int NO_10 = 10;
    private static final RString DBCTOKUBETSUKYUFUJIGYOSHANO = new RString("DBCTokubetsuKyufuJigyoshaNo");

    /**
     * コンストラクタです。
     *
     * @param div DBC2210011MainDiv
     */
    public DBC2210011MainHandler(DBC2210011MainDiv div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     */
    public void onLoad() {
        set県コードDDL();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getDdlSearchKenCode().
                setSelectedKey(association.get地方公共団体コード().value().substring(0, 2));
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchJigyoshaKubun().setValue(new RString("0"));
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchGunshiCode().setValue(new RString("0"));
        div.getTokubetsuKyufuJigyoshaList().getBtnAddJigyosha().setDisabled(true);
    }

    /**
     * モジュラス１０の計算方法で自動付番。
     */
    public void onClick_binSetSearch() {
        RString 県コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getDdlSearchKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchJigyoshaKubun().getValue();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchGunshiCode().getValue();
        RString 連番 = RString.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue() != null) {
            連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue();
        }
        ICheckDigit icheckgigit = CheckDigitFactory.getInstance(CheckDigitKind.Modulus10);
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().
                setValue(icheckgigit.appendModulus(県コード.concat(事業者区分).concat(郡市コード).concat(連番)));
    }

    /**
     * 検索するをクリック。
     *
     * @return List<TokubetsuKyufuJigyoshaSearchBusiness>
     */
    public List<TokubetsuKyufuJigyoshaSearchBusiness> onClick_btnSearch() {
        RString 県コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getDdlSearchKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchJigyoshaKubun().getValue();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchGunshiCode().getValue();
        RString 連番 = new RString("____");
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue() != null) {
            連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue();
        }
        RString cD = new RString("_");
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getValue() != null) {
            cD = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getValue();
        }
        RString 事業者番号 = 県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cD);
        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者情報 = service.select事業者情報(事業者番号);
        if (!事業者情報.isEmpty()) {
            div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().setDataSource(get事業者DataSource(事業者情報));
        }
        return 事業者情報;
    }

    public void onClick_btnAddJigyosha() {
        RString 県コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getDdlSearchKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchJigyoshaKubun().getValue();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchGunshiCode().getValue();
        RString 連番 = RString.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue() != null) {
            連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue();
        }
        RString cD = RString.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getValue() != null) {
            cD = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getValue();
        }
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setDataSource(get県コードDDLSource());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setSelectedKey(県コード);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().setValue(事業者区分);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().setValue(郡市コード);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().setValue(連番);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().setValue(cD);
    }

    public void onSelect_byListSelect(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報, dgTokubetsuKyufuJigyoshaList_Row row) {
        set事業者情報(事業者情報, row);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().
                getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().
                getGridSetting().setIsShowModifyButtonColumn(false);
        setReadOnly(true);
        setServiceListReadOnly(true);
    }

    public void onSelect_byDetailSelect(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報,
            List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容) {
        setサービス情報(事業者情報, 市町村特別給付サービス内容);
        setServiceInfoReadOnly(true);
    }

    public void onSelect_byListModify(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報, dgTokubetsuKyufuJigyoshaList_Row row) {
        set事業者情報(事業者情報, row);
        setReadOnly(true);
        setServiceListReadOnly(false);
    }

    public void onSelect_byDetailModify(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報,
            List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容) {
        setサービス情報(事業者情報, 市町村特別給付サービス内容);
        setServiceInfoReadOnly(false);
    }

    public void 前排他の設定(RString 事業者番号) {
        LockingKey 排他キー = new LockingKey(DBCTOKUBETSUKYUFUJIGYOSHANO.concat(事業者番号));
        RealInitialLocker.lock(排他キー);
    }

    public void onSelect_byListDelete(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報, dgTokubetsuKyufuJigyoshaList_Row row) {
        set事業者情報(事業者情報, row);
        setReadOnly(true);
        setServiceListReadOnly(true);
    }

    public void onSelect_byDetailDelete(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報) {

    }

    public void onClick_btnCopyFromShinseisha() {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().getValue());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().getValue());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().getValue());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().getValue());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().getValue());
    }

    public void onClick_btnCopyFromKanrisha() {
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJusho()
                .setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJusho().getValue());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJushoKana()
                .setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                        getTokubetsuKyufuJigyoshaDetailKanrisha().
                        getTxtKanrishaJushoKana().
                        getValue());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaName()
                .setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName().getValue());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaNameKana()
                .setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                        getTokubetsuKyufuJigyoshaDetailKanrisha().
                        getTxtKanrishaNameKana().
                        getValue());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaYubinNo()
                .setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                        getTokubetsuKyufuJigyoshaDetailKanrisha().
                        getTxtKanrishaYubinNo().
                        getValue());
    }

    public void onClick_btnAddService() {
        dgTokubetsuKyufuJigyoshaDetailServiceList_Row row = new dgTokubetsuKyufuJigyoshaDetailServiceList_Row();
        row.setHdnServiceCode(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedKey());
        row.getTxtJigyoHaishiYMD().setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD().getValue());
        row.getTxtJigyoKaishiYMD().setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD().getValue());
        row.getTxtJigyoKyushiYMD().setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD().getValue());
        row.getTxtJigyoSaikaiYMD().setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD().getValue());
        row.setTxtJuryoInin(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin().getSelectedValue());
        row.setTxtKanrisha(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName().getValue());
        row.setTxtSeikatsuHogo(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().getSelectedValue());
        row.getTxtTorokuKaishiYMD().setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().getValue());
        row.getTxtTorokuShuryoYMD().setValue(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().getValue());
    }

    private void set県コードDDL() {
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getDdlSearchKenCode().setDataSource(get県コードDDLSource());
    }

    private List<KeyValueDataSource> get県コードDDLSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (TodofukenType code : TodofukenType.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.code(), code.code().concat(":").concat(code.toRString()));
            dataSource.add(data);
        }
        return dataSource;
    }

    private List<dgTokubetsuKyufuJigyoshaList_Row> get事業者DataSource(List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者情報) {
        List<dgTokubetsuKyufuJigyoshaList_Row> dataSources = new ArrayList<>();
        TokubetsuKyufuJigyoshaSearchBusiness business = 事業者情報.get(0);
        dgTokubetsuKyufuJigyoshaList_Row row = new dgTokubetsuKyufuJigyoshaList_Row();
        row.setTxtIdoKubun(business.get事業者().get介護国保連ＩＦ異動区分());
        row.getTxtIdoYMD().setValue(new RDate(business.get事業者().get介護国保連ＩＦ異動年月日().wareki().toString()));
        row.setTxtJigyoshaCode(business.get事業者().get市町村特別給付用事業者番号().value());
        row.setTxtShinseishaShimei(business.get事業者().get申請者氏名_カナ());
        row.setTxtShinseishaJusho(business.get事業者().get事業所代表者住所());
        RString 市町村特別給付用サービス名 = RString.EMPTY;
        for (TokubetsuKyufuJigyoshaSearchBusiness tkjsb : 事業者情報) {
            if (tkjsb.get市町村特別給付用サービス名() != null && !tkjsb.get市町村特別給付用サービス名().isEmpty()) {
                市町村特別給付用サービス名.concat(tkjsb.get市町村特別給付用サービス名()).compareTo(new RString("、"));
            }
        }
        市町村特別給付用サービス名.remove(市町村特別給付用サービス名.length() - 1);
        row.setTxtServiceName(市町村特別給付用サービス名);
        dataSources.add(row);
        return dataSources;
    }

    private List<KeyValueDataSource> get特別給付サービスDDL(List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容) {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        for (ShichosonTokubetuKyufuService stks : 市町村特別給付サービス内容) {
            KeyValueDataSource data = new KeyValueDataSource(stks.get市町村特別給付用サービスコード(), stks.get市町村特別給付用サービスコード().
                    concat(RString.HALF_SPACE).concat(stks.get市町村特別給付用サービス名_正式名称()));
            dataSources.add(data);
        }
        return dataSources;
    }

    private void setServiceListReadOnly(boolean flag) {
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getBtnServiceAdd().setDisabled(flag);
    }

    private void setServiceInfoReadOnly(boolean flag) {
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().setReadOnly(flag);
    }

    private void setReadOnly(boolean flag) {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getBtnSetCheckDigit().setDisabled(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setReadOnly(flag);
    }

    private void set事業者情報(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報, dgTokubetsuKyufuJigyoshaList_Row row) {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setDataSource(get県コードDDLSource());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().
                setSelectedKey(事業者情報.get事業者().get市町村特別給付用事業者番号().value().substring(0, 2));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().
                setValue(事業者情報.get事業者().get市町村特別給付用事業者番号().value().substring(2, NO_3));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().
                setValue(事業者情報.get事業者().get市町村特別給付用事業者番号().value().substring(NO_3, NO_5));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().
                setValue(事業者情報.get事業者().get市町村特別給付用事業者番号().value().substring(NO_5, NO_9));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().
                setValue(事業者情報.get事業者().get市町村特別給付用事業者番号().value().substring(NO_9, NO_10));
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setSelectedKey(事業者情報.get事業者().get介護国保連ＩＦ法人種別());
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setSelectedKey(事業者情報.get事業者().get介護国保連ＩＦ異動区分());
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setValue(new RDate(事業者情報.get事業者().get介護国保連ＩＦ異動年月日().
                wareki().toString()));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().
                setValue(事業者情報.get事業者().get申請者氏名_漢字());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().
                setValue(事業者情報.get事業者().get申請者氏名_カナ());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().
                setValue(事業者情報.get事業者().get申請者郵便番号());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().
                setValue(事業者情報.get事業者().get申請者住所());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().
                setValue(事業者情報.get事業者().get申請者住所_カナ());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().
                setValue(事業者情報.get事業者().get申請者電話番号());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().
                setValue(事業者情報.get事業者().get申請者FAX番号());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().
                setValue(事業者情報.get事業者().get事業所代表者住所());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana()
                .setValue(事業者情報.get事業者().get事業所代表者住所カナ());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName()
                .setValue(事業者情報.get事業者().get事業所代表者氏名());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana()
                .setValue(事業者情報.get事業者().get事業所代表者氏名カナ());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku()
                .setValue(事業者情報.get事業者().get事業所代表者役職());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo()
                .setValue(事業者情報.get事業者().get事業所代表者郵便番号());
        List<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> dataSources = new ArrayList<>();
        dgTokubetsuKyufuJigyoshaDetailServiceList_Row newRow = new dgTokubetsuKyufuJigyoshaDetailServiceList_Row();
        newRow.setHdnServiceCode(事業者情報.get事業者().get市町村特別給付用サービスコード().value());
        newRow.setTxtService(row.getTxtServiceName());
        newRow.setTxtKanrisha(事業者情報.get事業者().get事業所管理者氏名());
        newRow.getTxtJigyoKaishiYMD().setValue(new RDate(事業者情報.get事業者().getサービス事業所事業開始年月日().wareki().toString()));
        newRow.getTxtJigyoKyushiYMD().setValue(new RDate(事業者情報.get事業者().getサービス事業所事業休止年月日().wareki().toString()));
        newRow.getTxtJigyoHaishiYMD().setValue(new RDate(事業者情報.get事業者().getサービス事業所事業廃止年月日().wareki().toString()));
        newRow.getTxtJigyoSaikaiYMD().setValue(new RDate(事業者情報.get事業者().getサービス事業所事業再開年月日().wareki().toString()));
        newRow.getTxtTorokuKaishiYMD().setValue(new RDate(事業者情報.get事業者().get市町村特別給付登録開始年月日().wareki().toString()));
        newRow.getTxtTorokuShuryoYMD().setValue(new RDate(事業者情報.get事業者().get市町村特別給付登録終了年月日().wareki().toString()));
        //todo DBC.ENUM.特別給付_受領委任区分よりコード、表示名称をセット
        newRow.setTxtJuryoInin(事業者情報.get事業者().get受領委任区分());
        if (事業者情報.get事業者().is生活保護法による指定の有()) {
            newRow.setTxtSeikatsuHogo(new RString("有"));
        } else {
            newRow.setTxtSeikatsuHogo(new RString("無"));
        }
        dataSources.add(newRow);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().
                getDgTokubetsuKyufuJigyoshaDetailServiceList().setDataSource(dataSources);
    }

    private void setサービス情報(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報,
            List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容) {
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().setDataSource(get特別給付サービスDDL(市町村特別給付サービス内容));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().
                setSelectedKey(事業者情報.get事業者().get市町村特別給付用サービスコード().value());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJusho()
                .setValue(事業者情報.get事業者().get事業所管理者住所());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJushoKana()
                .setValue(事業者情報.get事業者().get事業所管理者住所カナ());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName()
                .setValue(事業者情報.get事業者().get事業所管理者氏名());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaNameKana()
                .setValue(事業者情報.get事業者().get事業所管理者氏名カナ());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaYubinNo()
                .setValue(事業者情報.get事業者().get事業所管理者郵便番号());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaName()
                .setValue(事業者情報.get事業者().getサービス事業所名());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaNameKana()
                .setValue(事業者情報.get事業者().getサービス事業所名カナ());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaYubinNo()
                .setValue(事業者情報.get事業者().getサービス事業所郵便番号());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJusho()
                .setValue(事業者情報.get事業者().getサービス事業所住所());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJushoKana()
                .setValue(事業者情報.get事業者().getサービス事業所住所カナ());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaTelNo()
                .setValue(事業者情報.get事業者().getサービス事業所電話番号());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaFaxNo()
                .setValue(事業者情報.get事業者().getサービス事業所FAX番号());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD()
                .setValue(new RDate(事業者情報.get事業者().getサービス事業所事業開始年月日().wareki().toString()));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD()
                .setValue(new RDate(事業者情報.get事業者().getサービス事業所事業廃止年月日().wareki().toString()));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD()
                .setValue(new RDate(事業者情報.get事業者().getサービス事業所事業休止年月日().wareki().toString()));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD()
                .setValue(new RDate(事業者情報.get事業者().getサービス事業所事業再開年月日().wareki().toString()));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD()
                .setValue(new RDate(事業者情報.get事業者().get市町村特別給付登録開始年月日().wareki().toString()));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD()
                .setValue(new RDate(事業者情報.get事業者().get市町村特別給付登録終了年月日().wareki().toString()));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin()
                .setSelectedKey(事業者情報.get事業者().get受領委任区分());
        if (事業者情報.get事業者().is生活保護法による指定の有()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo()
                    .setSelectedKey(new RString("1"));
        } else {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo()
                    .setSelectedKey(new RString("0"));
        }
    }
}
