/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch.TokubetsuKyufuJigyoshaSearchBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch.TokubetsuKyufuJigyoshaSearchBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch.TokubetsuKyufuJigyoshaSearchIdentifier;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.tokubetsukyufu.TokubetsukyufuJuryoIninKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokubetsukyufu.TokubetsukyufuSeikatsuHogoShiteiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaDetailServiceList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyosha.TokubetsuKyufuJigyoshaService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.todofuken.TodofukenType;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitFactory;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitKind;
import jp.co.ndensan.reams.uz.uza.math.ICheckDigit;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 市町村特別給付・サービス事業者管理のハンドラクラスです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
public class DBC2210011MainHandler {

    private final DBC2210011MainDiv div;
    private static final int NO_3 = 3;
    private static final int NO_0 = 0;
    private static final int NO_2 = 2;
    private static final int NO_5 = 5;
    private static final int NO_6 = 6;
    private static final int NO_9 = 9;
    private static final int NO_10 = 10;
    private static final RString DBCTOKUBETSUKYUFUJIGYOSHANO = new RString("DBCTokubetsuKyufuJigyoshaNo");
    private static final int FOUR = 4;
    private static final int TWO = 2;
    private static final RString ゼロ = new RString("00");
    private static final RString いち = new RString("01");
    private static final RString ONE = new RString("1");
    private static final RString 有 = new RString("有");
    private static final RString 無 = new RString("無");
    private final RString 追加モード = new RString("追加");

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
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchGunshiCode().setValue(new RString("00"));
        div.getTokubetsuKyufuJigyoshaList().getBtnAddJigyosha().setDisabled(true);
    }

    /**
     * モジュラス１０の計算方法で自動付番。
     */
    public void onClick_binSetSearch() {
        RString 県コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getDdlSearchKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchJigyoshaKubun().getValue();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchGunshiCode().getValue().padLeft("0", TWO);
        RString 連番 = RString.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue() != null
                && !div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue().isEmpty()) {
            連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue().padLeft("0", FOUR);
        }
        ICheckDigit icheckgigit = CheckDigitFactory.getInstance(CheckDigitKind.Modulus10);
        div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().
                setValue(icheckgigit.appendModulus(県コード.concat(事業者区分).concat(郡市コード).concat(連番))
                        .substring(icheckgigit.appendModulus(県コード.concat(事業者区分).concat(郡市コード).concat(連番)).length() - 1));
        if (追加モード.equals(div.getHiddenModelOne())) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().
                    setValue(icheckgigit.appendModulus(県コード.concat(事業者区分).concat(郡市コード).concat(連番))
                            .substring(icheckgigit.appendModulus(県コード.concat(事業者区分).concat(郡市コード).concat(連番)).length() - 1));
        }
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
        RString 連番 = RString.EMPTY;
        RString 事業者番号 = RString.EMPTY;
        RString cD = RString.EMPTY;
        int 番号サイズ;
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue() != null
                && !div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue().isEmpty()) {
            連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue().padLeft("0", FOUR);
            if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText() != null
                    && !div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText().isEmpty()) {
                cD = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText();
                番号サイズ = NO_10;
                事業者番号 = 県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cD);
            } else {
                事業者番号 = 県コード.concat(事業者区分).concat(郡市コード).concat(連番);
                番号サイズ = NO_9;
            }
        } else {
            if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText() != null
                    && !div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText().isEmpty()) {
                事業者番号 = 県コード.concat(事業者区分).concat(郡市コード);
                cD = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText();
                番号サイズ = NO_6;
            } else {
                事業者番号 = 県コード.concat(事業者区分).concat(郡市コード);
                番号サイズ = NO_5;
            }
        }

        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者情報 = service.select事業者情報(事業者番号, 番号サイズ, cD);
        if (!事業者情報.isEmpty()) {
            div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().setDataSource(get事業者DataSource(事業者情報));
        } else {
            List<dgTokubetsuKyufuJigyoshaList_Row> dataSources = new ArrayList<>();
            div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().setDataSource(dataSources);
        }
        set検索する_ボタン押下後();

        return 事業者情報;
    }

    /**
     * 事業者情報を追加するButtonをクリック。
     *
     */
    public void onClick_btnAddJigyosha() {
        RString 県コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getDdlSearchKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchJigyoshaKubun().getValue();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchGunshiCode().getValue();
        RString 連番 = RString.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue() != null
                && !div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue().isEmpty()) {
            連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue().padLeft("0", FOUR);
        }
        RString cD = RString.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText() != null
                && !div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText().isEmpty()) {
            cD = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getText();
        }
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setDataSource(get県コードDDLSource());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setSelectedKey(県コード);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().setValue(事業者区分);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().setValue(郡市コード);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().setValue(連番);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().setValue(cD);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setSelectedKey(いち);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setValue(RDate.getNowDate());
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setSelectedKey(ゼロ);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().setValue(YubinNo.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().setValue(RString.EMPTY);

        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().setValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo().setValue(YubinNo.EMPTY);
        List<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> dataSources = new ArrayList<>();
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().setDataSource(dataSources);

        set事業者詳細入力_事業者情報を追加する_ボタン押下後();

    }

    /**
     * サービス事業者一覧DataGrid選択Buttonをクリック。
     *
     * @param 事業者サービス情報List List<TokubetsuKyufuJigyoshaSearchBusiness>
     * @param row dgTokubetsuKyufuJigyoshaList_Row
     */
    public void onSelect_byListSelect(List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List, dgTokubetsuKyufuJigyoshaList_Row row) {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setDataSource(get県コードDDLSource());
        set事業者情報(事業者サービス情報List, row);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().
                getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().
                getGridSetting().setIsShowModifyButtonColumn(false);
        setReadOnly(true);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setReadOnly(true);
        setServiceListReadOnly(true);
    }

    /**
     * サービス事業者一覧DataGrid修正Buttonをクリック。
     *
     * @param 事業者サービス情報List List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List
     * @param row dgTokubetsuKyufuJigyoshaList_Row
     */
    public void onSelect_byListModify(List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List, dgTokubetsuKyufuJigyoshaList_Row row) {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setDataSource(get県コードDDLSource());
        set事業者情報(事業者サービス情報List, row);
        setReadOnly(true);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setReadOnly(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().
                getGridSetting().setIsShowDeleteButtonColumn(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().
                getGridSetting().setIsShowModifyButtonColumn(true);
        setServiceListReadOnly(false);
    }

    /**
     * サービス事業者一覧DataGrid削除Buttonをクリック。
     *
     * @param 事業者サービス情報List List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List
     * @param row dgTokubetsuKyufuJigyoshaList_Row
     */
    public void onSelect_byListDelete(List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List, dgTokubetsuKyufuJigyoshaList_Row row) {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setDataSource(get県コードDDLSource());
        set事業者情報(事業者サービス情報List, row);
        setReadOnly(true);
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setReadOnly(true);
        setServiceListReadOnly(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().getGridSetting().setIsShowModifyButtonColumn(false);
        set事業者サービス情報DeleteState(事業者サービス情報List);
    }

    /**
     * 「入力を確定する」ボタンを押下します。
     *
     * @param 情報 TokubetsuKyufuJigyoshaSearchBusiness
     */
    public void setサービス一覧(TokubetsuKyufuJigyoshaSearchBusiness 情報) {
        dgTokubetsuKyufuJigyoshaDetailServiceList_Row newRow = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList()
                .getDgTokubetsuKyufuJigyoshaDetailServiceList().getActiveRow();
        newRow.setHdnServiceCode(情報.get市町村特別給付用サービスコード().value());
        newRow.setTxtService(情報.get市町村特別給付サービス事業者().getサービス().getServiceRyakushoName());
        newRow.setTxtKanrisha(情報.get事業所管理者氏名());
        if (情報.getサービス事業所事業開始年月日() != null) {
            newRow.getTxtJigyoKaishiYMD().setValue(new RDate(情報.getサービス事業所事業開始年月日().wareki().toDateString().toString()));
        }
        if (情報.getサービス事業所事業休止年月日() != null) {
            newRow.getTxtJigyoKyushiYMD().setValue(new RDate(情報.getサービス事業所事業休止年月日().wareki().toDateString().toString()));
        }
        if (情報.getサービス事業所事業廃止年月日() != null) {
            newRow.getTxtJigyoHaishiYMD().setValue(new RDate(情報.getサービス事業所事業廃止年月日().wareki().toDateString().toString()));
        }
        if (情報.getサービス事業所事業再開年月日() != null) {
            newRow.getTxtJigyoSaikaiYMD().setValue(new RDate(情報.getサービス事業所事業再開年月日().wareki().toDateString().toString()));
        }
        if (情報.get市町村特別給付登録開始年月日() != null) {
            newRow.getTxtTorokuKaishiYMD().setValue(new RDate(情報.get市町村特別給付登録開始年月日().wareki().toDateString().toString()));
        }
        if (情報.get市町村特別給付登録終了年月日() != null) {
            newRow.getTxtTorokuShuryoYMD().setValue(new RDate(情報.get市町村特別給付登録終了年月日().wareki().toDateString().toString()));
        }
        newRow.setTxtJuryoInin(TokubetsukyufuJuryoIninKubun.toValue(情報.get受領委任区分()).get名称());
        if (情報.is生活保護法による指定の有()) {
            newRow.setTxtSeikatsuHogo(TokubetsukyufuSeikatsuHogoShiteiKubun.有.get名称());
        } else {
            newRow.setTxtSeikatsuHogo(TokubetsukyufuSeikatsuHogoShiteiKubun.無.get名称());
        }
        newRow.setRowState(RowState.Modified);
    }

    /**
     * DataSouce情報取得処理する。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @return 情報と状態
     */
    public TokubetsuKyufuJigyoshaSearchBusiness get情報と状態BySelectDataSouce(List<TokubetsuKyufuJigyoshaSearchBusiness> 情報と状態ArrayList) {
        dgTokubetsuKyufuJigyoshaDetailServiceList_Row dataSouce = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList()
                .getDgTokubetsuKyufuJigyoshaDetailServiceList().getActiveRow();
        return get情報FromDataSouce(dataSouce, 情報と状態ArrayList);
    }

    /**
     * サービス追加Buttonをクリック。
     *
     */
    public void onAdd_byDetail() {
        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容 = service.selectサービス内容();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().setDataSource(get特別給付サービスDDL(市町村特別給付サービス内容));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().setSelectedValue(RString.EMPTY);
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJusho().clearValue();

        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJushoKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaNameKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaYubinNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaName().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaNameKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaYubinNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJusho().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJushoKana().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaTelNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaFaxNo().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().clearValue();
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin()
                .setSelectedKey(ONE);
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo()
                .setSelectedKey(ONE);
        setServiceInfoReadOnly(false);

    }

    /**
     * サービス一覧DataGrid選択Buttonをクリック。
     *
     * @param 事業者情報 TokubetsuKyufuJigyoshaSearchBusiness
     */
    public void onSelect_byDetailSelect(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報) {

        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容 = service.selectサービス内容();
        setサービス情報(事業者情報, 市町村特別給付サービス内容);
        setServiceInfoReadOnly(true);

    }

    /**
     * サービス一覧DataGrid修正Buttonをクリック。
     *
     * @param 事業者情報 TokubetsuKyufuJigyoshaSearchBusiness
     */
    public void onSelect_byDetailModify(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報) {
        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容 = service.selectサービス内容();
        setサービス情報(事業者情報, 市町村特別給付サービス内容);
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().setReadOnly(true);
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().setReadOnly(false);
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().setReadOnly(false);

    }

    /**
     * 前排他の設定。
     *
     * @param 事業者番号 RString
     */
    public void 前排他の設定(RString 事業者番号) {
        LockingKey 排他キー = new LockingKey(DBCTOKUBETSUKYUFUJIGYOSHANO.concat(事業者番号));
        RealInitialLocker.lock(排他キー);
    }

    /**
     * 前排他の解除。
     *
     * @param 事業者番号 RString
     */
    public void 前排他の解除(RString 事業者番号) {
        LockingKey 排他キー = new LockingKey(DBCTOKUBETSUKYUFUJIGYOSHANO.concat(事業者番号));
        RealInitialLocker.release(排他キー);
    }

    /**
     * 「申請者情報からコピー」(代表者情報パネル)ボタンを押下します。
     *
     */
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

    /**
     * 「申請者情報からコピー」(管理者情報パネル)ボタンを押下します。
     *
     */
    public void onClick_管理者情報コピー() {
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJusho()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().getValue());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJushoKana()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().getValue());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().getValue());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaNameKana()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().getValue());
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaYubinNo()
                .setValue(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().getValue());
    }

    /**
     * 「管理者情報からコピー」(事業者情報パネル)ボタンを押下します。
     *
     */
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

    /**
     * 「保存する」ボタンを押下します。
     *
     * @param サービス事業者情報 List<TokubetsuKyufuJigyoshaSearchBusiness>
     */
    public void onClick_Save(List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報) {
        if (!get共通エリア変化があるflag(サービス事業者情報)) {
            for (TokubetsuKyufuJigyoshaSearchBusiness 情報 : サービス事業者情報) {
                情報.createBuilderForEdit().set介護国保連ＩＦ法人種別(div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().getSelectedKey());
                情報.createBuilderForEdit().set介護国保連ＩＦ異動区分(div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().getSelectedKey());
                情報.createBuilderForEdit().set介護国保連ＩＦ異動年月日(new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().getValue().toDateString()));
                情報.createBuilderForEdit().set申請者氏名_漢字(div.getTokubetsuKyufuJigyoshaDetail().
                        getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().getValue());
                情報.createBuilderForEdit().set申請者氏名_カナ(div.getTokubetsuKyufuJigyoshaDetail().
                        getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().getValue());
                情報.createBuilderForEdit().set申請者住所_カナ(div.getTokubetsuKyufuJigyoshaDetail().
                        getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().getValue());
                情報.createBuilderForEdit().set申請者住所(div.getTokubetsuKyufuJigyoshaDetail().
                        getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().getValue());
                情報.createBuilderForEdit().set申請者郵便番号(div.getTokubetsuKyufuJigyoshaDetail().
                        getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().getValue());
                情報.createBuilderForEdit().set申請者電話番号(div.getTokubetsuKyufuJigyoshaDetail().
                        getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().getValue());
                情報.createBuilderForEdit().set申請者FAX番号(div.getTokubetsuKyufuJigyoshaDetail().
                        getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().getValue());
                情報.createBuilderForEdit().set事業所代表者住所カナ(div.getTokubetsuKyufuJigyoshaDetail()
                        .getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().getValue());
                情報.createBuilderForEdit().set事業所代表者住所(div.getTokubetsuKyufuJigyoshaDetail()
                        .getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().getValue());
                情報.createBuilderForEdit().set事業所代表者氏名(div.getTokubetsuKyufuJigyoshaDetail()
                        .getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().getValue());
                情報.createBuilderForEdit().set事業所代表者氏名カナ(div.getTokubetsuKyufuJigyoshaDetail()
                        .getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().getValue());
                情報.createBuilderForEdit().set事業所代表者郵便番号(div.getTokubetsuKyufuJigyoshaDetail()
                        .getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo().getValue());
                情報.createBuilderForEdit().set事業所代表者役職(div.getTokubetsuKyufuJigyoshaDetail()
                        .getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku().getValue());
                情報.get市町村特別給付サービス事業者().get事業者().setState(EntityDataState.Modified);
            }
        }
        List<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> rowList = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList()
                .getDgTokubetsuKyufuJigyoshaDetailServiceList().getDataSource();
        RString 県コード = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().getValue();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().getValue().padLeft("0", TWO);
        RString 連番 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().getValue().padLeft("0", FOUR);
        RString cD = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().getValue();
        if (追加モード.equals(div.getHiddenModelOne())) {
            for (dgTokubetsuKyufuJigyoshaDetailServiceList_Row row : rowList) {
                TokubetsuKyufuJigyoshaSearchBusiness 更新情報 = get情報FromDataSouce(row, サービス事業者情報);
                JigyoshaNo 事業者Code = new JigyoshaNo(県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cD));
                更新情報.get市町村特別給付サービス事業者().get事業者().setJigyoshaNo(事業者Code);

            }
        }
        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        for (dgTokubetsuKyufuJigyoshaDetailServiceList_Row row : rowList) {
            TokubetsuKyufuJigyoshaSearchBusiness 更新情報 = get情報FromDataSouce(row, サービス事業者情報);
            service.save事業者情報(更新情報);
        }
    }

    /**
     * 「入力を確定する」（サービス追加モード）ボタンを押下します。
     *
     * @param row dgTokubetsuKyufuJigyoshaDetailServiceList_Row
     * @param 情報 TokubetsuKyufuJigyoshaSearchBusiness
     * @return dgTokubetsuKyufuJigyoshaDetailServiceList_Row
     */
    public dgTokubetsuKyufuJigyoshaDetailServiceList_Row onClick_入力を確定_追加(dgTokubetsuKyufuJigyoshaDetailServiceList_Row row,
            TokubetsuKyufuJigyoshaSearchBusiness 情報) {
        row.setRowState(RowState.Added);
        row.setHdnServiceCode(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedKey());
        row.setTxtService(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedValue());
        row.setTxtKanrisha(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName().getValue());
        row.setTxtJigyoKaishiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD());
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD() != null) {
            row.setTxtJigyoKyushiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                    .getTxtJigyoKyushiYMD());
        } else {
            row.getTxtJigyoKyushiYMD().clearValue();
        }
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD() != null) {
            row.setTxtJigyoHaishiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                    .getTxtJigyoHaishiYMD());
        } else {
            row.getTxtJigyoHaishiYMD().clearValue();
        }
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD() != null) {
            row.setTxtJigyoSaikaiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                    .getTxtJigyoSaikaiYMD());
        } else {
            row.getTxtJigyoSaikaiYMD().clearValue();
        }
        row.setTxtTorokuKaishiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                .getTxtTorokuKaishiYMD());
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD() != null) {
            row.setTxtTorokuShuryoYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                    .getTxtTorokuShuryoYMD());
        } else {
            row.getTxtTorokuShuryoYMD().clearValue();
        }
        if (有.equals(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin().getSelectedValue())) {
            row.setTxtJuryoInin(有);
        } else {
            row.setTxtJuryoInin(無);
        }
        if (有.equals(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().getSelectedValue())) {
            row.setTxtSeikatsuHogo(有);
        } else {
            row.setTxtSeikatsuHogo(無);
        }
        row.setTxtServiceId(DataPassingConverter.serialize(情報.identifier()));
        return row;
    }

    /**
     * 「入力を確定する」（サービス修正モード）ボタンを押下します。
     *
     */
    public void onClick_入力を確定_修正() {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                .getActiveRow().setRowState(RowState.Modified);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                .getActiveRow().setHdnServiceCode(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedKey());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                .getActiveRow().setTxtService(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedValue().substring(NO_3));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                .getActiveRow().setTxtKanrisha(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha()
                        .getTxtKanrishaName().getValue());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                .getActiveRow().setTxtJigyoKaishiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                        .getTxtJigyoKaishiYMD());
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().setTxtJigyoKyushiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                            .getTxtJigyoKyushiYMD());
        } else {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().getTxtJigyoKyushiYMD().clearValue();
        }
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().setTxtJigyoHaishiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                            .getTxtJigyoHaishiYMD());
        } else {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().getTxtJigyoHaishiYMD().clearValue();
        }
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().setTxtJigyoSaikaiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                            .getTxtJigyoSaikaiYMD());
        } else {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().getTxtJigyoSaikaiYMD().clearValue();
        }
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                .getActiveRow().setTxtTorokuKaishiYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                        .getTxtTorokuKaishiYMD());
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().setTxtTorokuShuryoYMD(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha()
                            .getTxtTorokuShuryoYMD());
        } else {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().getTxtTorokuShuryoYMD().clearValue();
        }
        if (有.equals(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin().getSelectedValue())) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().setTxtJuryoInin(有);
        } else {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().setTxtJuryoInin(無);
        }
        if (有.equals(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().getSelectedValue())) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().setTxtSeikatsuHogo(有);
        } else {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getActiveRow().setTxtSeikatsuHogo(無);
        }
    }

    /**
     * 「入力を確定する」（サービス追加モード）ボタンを押下します。
     *
     * @return TokubetsuKyufuJigyoshaSearchBusiness
     */
    public TokubetsuKyufuJigyoshaSearchBusiness onClick_入力を確定_追加情報() {
        RString 県コード = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().getSelectedValue().substring(NO_0, NO_2);
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().getValue();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().getValue();
        RString 連番 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().getValue();
        RString cd = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().getValue();
        JigyoshaNo 市町村特別給付用事業者番号 = new JigyoshaNo(県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cd));
        ServiceCode 市町村特別給付用サービスコード = new ServiceCode(div.getTokubetsuKyufuJigyoshaDetailServiceInfo()
                .getDdlService().getSelectedValue().substring(NO_0, NO_6));
        int 履歴番号 = NO_0;
        TokubetsuKyufuJigyoshaSearchBusiness 追加情報 = new TokubetsuKyufuJigyoshaSearchBusiness(市町村特別給付用事業者番号, 市町村特別給付用サービスコード, 履歴番号);
        追加情報.get市町村特別給付サービス事業者().get事業者().setState(EntityDataState.Added);

        return update市町村特別給付サービス事業者情報(追加情報).build();
    }

    /**
     * 「入力を確定する」（サービス修正モード）ボタンを押下します。
     *
     * @param 修正情報 TokubetsuKyufuJigyoshaSearchBusiness
     * @return TokubetsuKyufuJigyoshaSearchBusiness
     */
    public TokubetsuKyufuJigyoshaSearchBusiness onClick_入力を確定_修正情報(TokubetsuKyufuJigyoshaSearchBusiness 修正情報) {
        修正情報.get市町村特別給付サービス事業者().get事業者().setState(EntityDataState.Modified);
        return update市町村特別給付サービス事業者情報(修正情報).build();
    }

    private TokubetsuKyufuJigyoshaSearchBuilder update市町村特別給付サービス事業者情報(TokubetsuKyufuJigyoshaSearchBusiness 更新情報) {

        TokubetsuKyufuJigyoshaSearchBuilder tokubetsuKyufuJigyoshaSearchBuilder = 更新情報.createBuilderForEdit();
        RString 異動区分 = div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().getSelectedKey();
        FlexibleDate 異動年月日 = new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().getValue().toDateString());
        RString 法人種別 = div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().getSelectedKey();

        RString 申請者氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().getValue();
        RString 申請者氏名カナ = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().getValue();
        YubinNo 申請者郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().getValue();
        RString 申請者住所 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().getValue();
        RString 申請者住所カナ = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().getValue();
        RString 申請者電話番号 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().getValue();
        RString 申請者FAX番号 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().getValue();

        RString 事業所代表者役職 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku().getValue();
        RString 事業所代表者氏名 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().getValue();
        RString 事業所代表者氏名カナ = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().getValue();
        YubinNo 事業所代表者郵便番号 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo().getValue();
        RString 事業所代表者住所 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().getValue();
        RString 事業所代表者住所カナ = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().getValue();

        RString 事業所管理者氏名 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName().getValue();
        RString 事業所管理者氏名カナ = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaNameKana().getValue();
        YubinNo 事業所管理者郵便番号 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaYubinNo().getValue();
        RString 事業所管理者住所 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJusho().getValue();
        RString 事業所管理者住所カナ = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJushoKana().getValue();

        RString サービス事業所名 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaName().getValue();
        RString サービス事業所名カナ = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaNameKana().getValue();
        YubinNo サービス事業所郵便番号 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaYubinNo().getValue();
        RString サービス事業所住所 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJusho().getValue();
        RString サービス事業所住所カナ = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJushoKana().getValue();
        RString サービス事業所電話番号 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaTelNo().getValue();
        RString サービス事業所FAX番号 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaFaxNo().getValue();

        FlexibleDate サービス事業所事業開始年月日 = new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD().getValue().toDateString());
        FlexibleDate サービス事業所事業休止年月日 = FlexibleDate.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD().getValue() != null) {
            サービス事業所事業休止年月日 = new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD().getValue().toDateString());
        }
        FlexibleDate サービス事業所事業廃止年月日 = FlexibleDate.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD().getValue() != null) {
            サービス事業所事業廃止年月日 = new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD().getValue().toDateString());
        }
        FlexibleDate サービス事業所事業再開年月日 = FlexibleDate.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD().getValue() != null) {
            サービス事業所事業再開年月日 = new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD().getValue().toDateString());
        }

        RString 受領委任区分 = div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin().getSelectedKey();
        FlexibleDate 市町村特別給付登録開始年月日 = new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().getValue().toDateString());
        FlexibleDate 市町村特別給付登録終了年月日 = FlexibleDate.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().getValue() != null) {
            市町村特別給付登録終了年月日 = new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().getValue().toDateString());
        }

        boolean 生活保護法による指定の有 = false;
        if (有.equals(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo().getSelectedValue())) {
            生活保護法による指定の有 = true;
        }
        boolean 論理削除フラグ = false;

        tokubetsuKyufuJigyoshaSearchBuilder.set介護国保連ＩＦ異動区分(異動区分);
        tokubetsuKyufuJigyoshaSearchBuilder.set介護国保連ＩＦ異動年月日(異動年月日);
        tokubetsuKyufuJigyoshaSearchBuilder.set介護国保連ＩＦ法人種別(法人種別);
        tokubetsuKyufuJigyoshaSearchBuilder.set申請者氏名_漢字(申請者氏名);
        tokubetsuKyufuJigyoshaSearchBuilder.set申請者氏名_カナ(申請者氏名カナ);
        tokubetsuKyufuJigyoshaSearchBuilder.set申請者住所(申請者住所);
        tokubetsuKyufuJigyoshaSearchBuilder.set申請者住所_カナ(申請者住所カナ);
        tokubetsuKyufuJigyoshaSearchBuilder.set申請者郵便番号(申請者郵便番号);
        tokubetsuKyufuJigyoshaSearchBuilder.set申請者電話番号(申請者電話番号);
        tokubetsuKyufuJigyoshaSearchBuilder.set申請者FAX番号(申請者FAX番号);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所代表者役職(事業所代表者役職);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所代表者氏名(事業所代表者氏名);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所代表者氏名カナ(事業所代表者氏名カナ);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所代表者住所(事業所代表者住所);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所代表者住所カナ(事業所代表者住所カナ);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所代表者郵便番号(事業所代表者郵便番号);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所管理者住所(事業所管理者住所);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所管理者住所カナ(事業所管理者住所カナ);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所管理者氏名(事業所管理者氏名);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所管理者氏名カナ(事業所管理者氏名カナ);
        tokubetsuKyufuJigyoshaSearchBuilder.set事業所管理者郵便番号(事業所管理者郵便番号);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所名(サービス事業所名);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所名カナ(サービス事業所名カナ);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所住所(サービス事業所住所);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所住所カナ(サービス事業所住所カナ);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所郵便番号(サービス事業所郵便番号);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所電話番号(サービス事業所電話番号);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所FAX番号(サービス事業所FAX番号);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所事業開始年月日(サービス事業所事業開始年月日);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所事業休止年月日(サービス事業所事業休止年月日);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所事業廃止年月日(サービス事業所事業廃止年月日);
        tokubetsuKyufuJigyoshaSearchBuilder.setサービス事業所事業再開年月日(サービス事業所事業再開年月日);
        tokubetsuKyufuJigyoshaSearchBuilder.set受領委任区分(受領委任区分);
        tokubetsuKyufuJigyoshaSearchBuilder.set市町村特別給付登録開始年月日(市町村特別給付登録開始年月日);
        tokubetsuKyufuJigyoshaSearchBuilder.set市町村特別給付登録終了年月日(市町村特別給付登録終了年月日);
        tokubetsuKyufuJigyoshaSearchBuilder.set生活保護法による指定の有(生活保護法による指定の有);
        tokubetsuKyufuJigyoshaSearchBuilder.set論理削除フラグ(論理削除フラグ);

        return tokubetsuKyufuJigyoshaSearchBuilder;
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

    private List<dgTokubetsuKyufuJigyoshaList_Row> get事業者DataSource(List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者情報List) {
        List<dgTokubetsuKyufuJigyoshaList_Row> dataSources = new ArrayList<>();
        List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者情報 = new ArrayList<>();
        RString 事業者番号 = RString.EMPTY;
        for (TokubetsuKyufuJigyoshaSearchBusiness 事業者とサービス : 事業者情報List) {
            if (事業者情報.isEmpty()) {
                事業者番号 = 事業者とサービス.get市町村特別給付サービス事業者().get事業者().getJigyoshaNo().value();
                事業者情報.add(事業者とサービス);
            } else if (事業者番号.equals(事業者とサービス.get市町村特別給付サービス事業者().get事業者().getJigyoshaNo().value())) {
                事業者情報.add(事業者とサービス);
            } else {
                事業者番号 = 事業者とサービス.get市町村特別給付サービス事業者().get事業者().getJigyoshaNo().value();
                dataSources.add(set事業者情報該当一覧(事業者情報));
                事業者情報.clear();
                事業者情報.add(事業者とサービス);
            }
        }
        dataSources.add(set事業者情報該当一覧(事業者情報));
        setサービス事業者一覧DateGirdState(dataSources, true);
        return dataSources;
    }

    private dgTokubetsuKyufuJigyoshaList_Row set事業者情報該当一覧(List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者情報) {
        dgTokubetsuKyufuJigyoshaList_Row row = new dgTokubetsuKyufuJigyoshaList_Row();
        if (JukyushaIF_IdoKubunCode.変更.getコード().padLeft("0", TWO).equals(事業者情報.get(0).get介護国保連ＩＦ異動区分())) {
            row.setTxtIdoKubun(JukyushaIF_IdoKubunCode.変更.get名称());
        } else if (JukyushaIF_IdoKubunCode.新規.getコード().padLeft("0", TWO).equals(事業者情報.get(0).get介護国保連ＩＦ異動区分())) {
            row.setTxtIdoKubun(JukyushaIF_IdoKubunCode.新規.get名称());
        } else {
            row.setTxtIdoKubun(JukyushaIF_IdoKubunCode.終了.get名称());
        }

        row.getTxtIdoYMD().setValue(new RDate(事業者情報.get(0).get介護国保連ＩＦ異動年月日().wareki().toDateString().toString()));
        row.setTxtJigyoshaCode(事業者情報.get(0).get市町村特別給付用事業者番号().value());
        row.setTxtShinseishaShimei(事業者情報.get(0).get申請者氏名_漢字());
        row.setTxtShinseishaJusho(事業者情報.get(0).get申請者住所());
        RString 市町村特別給付用サービス名 = RString.EMPTY;
        for (TokubetsuKyufuJigyoshaSearchBusiness tkjsb : 事業者情報) {
            if (tkjsb.get市町村特別給付サービス事業者().getサービス().getServiceRyakushoName() != null && !tkjsb.get市町村特別給付サービス事業者().getサービス().getServiceRyakushoName().isEmpty()) {
                市町村特別給付用サービス名 = 市町村特別給付用サービス名.concat(tkjsb.get市町村特別給付サービス事業者().getサービス().getServiceRyakushoName()).concat(new RString("、"));
            }
        }
        if (!市町村特別給付用サービス名.isEmpty()) {
            市町村特別給付用サービス名 = 市町村特別給付用サービス名.substring(0, 市町村特別給付用サービス名.length() - 1);
        }
        row.setTxtServiceName(市町村特別給付用サービス名);
        row.setDataId(DataPassingConverter.serialize(事業者情報.get(0).identifier()));
        return row;
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
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().setReadOnly(flag);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getBtnSetCheckDigit().setDisabled(flag);
    }

    private void set事業者情報(List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List, dgTokubetsuKyufuJigyoshaList_Row row) {
        TokubetsuKyufuJigyoshaSearchBusiness 事業者情報 = 事業者サービス情報List.get(0);
        RString 県コード = 事業者情報.get市町村特別給付用事業者番号().getColumnValue().substring(0, 2);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode()
                .setSelectedValue(TodofukenType.toValue(県コード).code().concat(":").concat(TodofukenType.toValue(県コード).toRString()));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().
                setValue(事業者情報.get市町村特別給付用事業者番号().value().substring(2, NO_3));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().
                setValue(事業者情報.get市町村特別給付用事業者番号().value().substring(NO_3, NO_5));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().
                setValue(事業者情報.get市町村特別給付用事業者番号().value().substring(NO_5, NO_9));
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().
                setValue(事業者情報.get市町村特別給付用事業者番号().value().substring(NO_9, NO_10));
        div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().setSelectedKey(事業者情報.get介護国保連ＩＦ法人種別());
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setSelectedKey(事業者情報.get介護国保連ＩＦ異動区分());
        if (事業者情報.get介護国保連ＩＦ異動年月日() != null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setValue(new RDate(事業者情報.get介護国保連ＩＦ異動年月日().
                    wareki().toDateString().toString()));
        }
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().
                setValue(事業者情報.get申請者氏名_漢字());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().
                setValue(事業者情報.get申請者氏名_カナ());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().
                setValue(事業者情報.get申請者郵便番号());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().
                setValue(事業者情報.get申請者住所());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().
                setValue(事業者情報.get申請者住所_カナ());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().
                setValue(事業者情報.get申請者電話番号());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().
                setValue(事業者情報.get申請者FAX番号());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().
                setValue(事業者情報.get事業所代表者住所());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana()
                .setValue(事業者情報.get事業所代表者住所カナ());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName()
                .setValue(事業者情報.get事業所代表者氏名());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana()
                .setValue(事業者情報.get事業所代表者氏名カナ());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku()
                .setValue(事業者情報.get事業所代表者役職());
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo()
                .setValue(事業者情報.get事業所代表者郵便番号());
        List<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> dataSources = new ArrayList<>();
        for (TokubetsuKyufuJigyoshaSearchBusiness 情報 : 事業者サービス情報List) {
            dgTokubetsuKyufuJigyoshaDetailServiceList_Row newRow = new dgTokubetsuKyufuJigyoshaDetailServiceList_Row();
            newRow.setHdnServiceCode(情報.get市町村特別給付用サービスコード().value());
            newRow.setTxtService(情報.get市町村特別給付サービス事業者().getサービス().getServiceRyakushoName());
            newRow.setTxtKanrisha(情報.get事業所管理者氏名());
            if (情報.getサービス事業所事業開始年月日() != null && !情報.getサービス事業所事業開始年月日().toString().isEmpty()) {
                newRow.getTxtJigyoKaishiYMD().setValue(new RDate(情報.getサービス事業所事業開始年月日().wareki().toDateString().toString()));
            }
            if (情報.getサービス事業所事業休止年月日() != null && !情報.getサービス事業所事業休止年月日().toString().isEmpty()) {
                newRow.getTxtJigyoKyushiYMD().setValue(new RDate(情報.getサービス事業所事業休止年月日().wareki().toDateString().toString()));
            }
            if (情報.getサービス事業所事業廃止年月日() != null && !情報.getサービス事業所事業廃止年月日().toString().isEmpty()) {
                newRow.getTxtJigyoHaishiYMD().setValue(new RDate(情報.getサービス事業所事業廃止年月日().wareki().toDateString().toString()));
            }
            if (情報.getサービス事業所事業再開年月日() != null && !情報.getサービス事業所事業再開年月日().toString().isEmpty()) {
                newRow.getTxtJigyoSaikaiYMD().setValue(new RDate(情報.getサービス事業所事業再開年月日().wareki().toDateString().toString()));
            }
            if (情報.get市町村特別給付登録開始年月日() != null && !情報.get市町村特別給付登録開始年月日().toString().isEmpty()) {
                newRow.getTxtTorokuKaishiYMD().setValue(new RDate(情報.get市町村特別給付登録開始年月日().wareki().toDateString().toString()));
            }
            if (情報.get市町村特別給付登録終了年月日() != null && !情報.get市町村特別給付登録終了年月日().toString().isEmpty()) {
                newRow.getTxtTorokuShuryoYMD().setValue(new RDate(情報.get市町村特別給付登録終了年月日().wareki().toDateString().toString()));
            }
            newRow.setTxtJuryoInin(TokubetsukyufuJuryoIninKubun.toValue(情報.get受領委任区分()).get名称());
            if (情報.is生活保護法による指定の有()) {
                newRow.setTxtSeikatsuHogo(TokubetsukyufuSeikatsuHogoShiteiKubun.有.get名称());
            } else {
                newRow.setTxtSeikatsuHogo(TokubetsukyufuSeikatsuHogoShiteiKubun.無.get名称());
            }
            newRow.setTxtServiceId(DataPassingConverter.serialize(情報.identifier()));
            dataSources.add(newRow);
        }

        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().
                getDgTokubetsuKyufuJigyoshaDetailServiceList().setDataSource(dataSources);

    }

    private void setサービス情報(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報,
            List<ShichosonTokubetuKyufuService> 市町村特別給付サービス内容) {
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().setDataSource(get特別給付サービスDDL(市町村特別給付サービス内容));
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().
                setSelectedKey(事業者情報.get市町村特別給付用サービスコード().value());
        if (事業者情報.get事業所管理者住所() != null && !事業者情報.get事業所管理者住所().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJusho()
                    .setValue(事業者情報.get事業所管理者住所());
        }
        if (事業者情報.get事業所管理者住所カナ() != null && !事業者情報.get事業所管理者住所カナ().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaJushoKana()
                    .setValue(事業者情報.get事業所管理者住所カナ());
        }
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaName()
                .setValue(事業者情報.get事業所管理者氏名());
        setサービス情報Detail(事業者情報);
        if (事業者情報.getサービス事業所事業開始年月日() != null && !事業者情報.getサービス事業所事業開始年月日().toString().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKaishiYMD()
                    .setValue(new RDate(事業者情報.getサービス事業所事業開始年月日().wareki().toDateString().toString()));
        }
        if (事業者情報.getサービス事業所事業廃止年月日() != null && !事業者情報.getサービス事業所事業廃止年月日().toString().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoHaishiYMD()
                    .setValue(new RDate(事業者情報.getサービス事業所事業廃止年月日().wareki().toDateString().toString()));
        }
        if (事業者情報.getサービス事業所事業休止年月日() != null && !事業者情報.getサービス事業所事業休止年月日().toString().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoKyushiYMD()
                    .setValue(new RDate(事業者情報.getサービス事業所事業休止年月日().wareki().toDateString().toString()));
        }
        if (事業者情報.getサービス事業所事業再開年月日() != null && !事業者情報.getサービス事業所事業再開年月日().toString().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoSaikaiYMD()
                    .setValue(new RDate(事業者情報.getサービス事業所事業再開年月日().wareki().toDateString().toString()));
        }
        if (事業者情報.get市町村特別給付登録開始年月日() != null && !事業者情報.get市町村特別給付登録開始年月日().toString().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD()
                    .setValue(new RDate(事業者情報.get市町村特別給付登録開始年月日().wareki().toDateString().toString()));
        }
        if (事業者情報.get市町村特別給付登録終了年月日() != null && !事業者情報.get市町村特別給付登録終了年月日().toString().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD()
                    .setValue(new RDate(事業者情報.get市町村特別給付登録終了年月日().wareki().toDateString().toString()));
        }

        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadJuryoInin()
                .setSelectedKey(事業者情報.get受領委任区分());
        if (事業者情報.is生活保護法による指定の有()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo()
                    .setSelectedKey(new RString("1"));
        } else {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getRadSeikatsuHogo()
                    .setSelectedKey(new RString("0"));
        }

    }

    private void set検索する_ボタン押下後() {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().setDisabled(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getBtnSetCheckDigit().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaSearch().getBtnSearch().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaList().getBtnAddJigyosha().setDisabled(false);

        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailHojinShubetsu().getDdlHojinShubetsu().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().setDisabled(false);

        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getBtnCopyDaihyosha().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getBtnServiceAdd().setDisabled(false);
    }

    private void set事業者詳細入力_事業者情報を追加する_ボタン押下後() {
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getDdlKenCode().setReadOnly(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtJigyoshaKubun().setReadOnly(true);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtGunshiCode().setReadOnly(true);

        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtRenban().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getTxtCheckDigit().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaCode().getBtnSetCheckDigit().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailHojinShubetsu().getDdlHojinShubetsu().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().setDisabled(false);

        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getBtnCopyDaihyosha().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo().setDisabled(false);
        div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getBtnServiceAdd().setDisabled(false);
    }

    private void setサービス事業者一覧DateGirdState(List<dgTokubetsuKyufuJigyoshaList_Row> dataSources, boolean state) {
        for (dgTokubetsuKyufuJigyoshaList_Row dataSource : dataSources) {
            if (state) {
                dataSource.setDeleteButtonState(DataGridButtonState.Enabled);
                dataSource.setSelectButtonState(DataGridButtonState.Enabled);
                dataSource.setModifyButtonState(DataGridButtonState.Enabled);
            } else {
                dataSource.setDeleteButtonState(DataGridButtonState.Disabled);
                dataSource.setSelectButtonState(DataGridButtonState.Disabled);
                dataSource.setModifyButtonState(DataGridButtonState.Disabled);
            }
        }
    }

    private TokubetsuKyufuJigyoshaSearchBusiness get情報FromDataSouce(
            dgTokubetsuKyufuJigyoshaDetailServiceList_Row dataSouce, List<TokubetsuKyufuJigyoshaSearchBusiness> 情報と状態ArrayList) {
        TokubetsuKyufuJigyoshaSearchIdentifier id
                = DataPassingConverter.deserialize(dataSouce.getTxtServiceId(), TokubetsuKyufuJigyoshaSearchIdentifier.class);
        for (TokubetsuKyufuJigyoshaSearchBusiness 情報と状態 : 情報と状態ArrayList) {
            if (id.equals(情報と状態.identifier())) {
                return 情報と状態;
            }
        }
        return null;
    }

    private void set事業者サービス情報DeleteState(List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List) {
        List<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> dataSources = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList()
                .getDgTokubetsuKyufuJigyoshaDetailServiceList().getDataSource();
        TokubetsuKyufuJigyoshaSearchBusiness 事業者削除情報;
        for (dgTokubetsuKyufuJigyoshaDetailServiceList_Row dataSource : dataSources) {
            事業者削除情報 = get情報FromDataSouce(dataSource, 事業者サービス情報List);
            事業者削除情報.get市町村特別給付サービス事業者().get事業者().setState(EntityDataState.Deleted);
        }
    }

    private void setサービス情報Detail(TokubetsuKyufuJigyoshaSearchBusiness 事業者情報) {
        if (事業者情報.get事業所管理者氏名カナ() != null && !事業者情報.get事業所管理者氏名カナ().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaNameKana()
                    .setValue(事業者情報.get事業所管理者氏名カナ());
        }
        if (事業者情報.get事業所管理者郵便番号() != null && !事業者情報.get事業所管理者郵便番号().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailKanrisha().getTxtKanrishaYubinNo()
                    .setValue(事業者情報.get事業所管理者郵便番号());
        }
        div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaName()
                .setValue(事業者情報.getサービス事業所名());
        if (事業者情報.getサービス事業所名カナ() != null && !事業者情報.getサービス事業所名カナ().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaNameKana()
                    .setValue(事業者情報.getサービス事業所名カナ());
        }
        if (事業者情報.getサービス事業所郵便番号() != null && !事業者情報.getサービス事業所郵便番号().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaYubinNo()
                    .setValue(事業者情報.getサービス事業所郵便番号());
        }
        if (事業者情報.getサービス事業所住所() != null && !事業者情報.getサービス事業所住所().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJusho()
                    .setValue(事業者情報.getサービス事業所住所());
        }
        if (事業者情報.getサービス事業所住所カナ() != null && !事業者情報.getサービス事業所住所カナ().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaJushoKana()
                    .setValue(事業者情報.getサービス事業所住所カナ());
        }
        if (事業者情報.getサービス事業所電話番号() != null && !事業者情報.getサービス事業所電話番号().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaTelNo()
                    .setValue(事業者情報.getサービス事業所電話番号());
        }
        if (事業者情報.getサービス事業所FAX番号() != null && !事業者情報.getサービス事業所FAX番号().isEmpty()) {
            div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtJigyoshaFaxNo()
                    .setValue(事業者情報.getサービス事業所FAX番号());
        }
    }

    private boolean get共通エリア変化があるflag(List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報) {
        dgTokubetsuKyufuJigyoshaDetailServiceList_Row row = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList()
                .getDgTokubetsuKyufuJigyoshaDetailServiceList().getDataSource().get(NO_0);
        TokubetsuKyufuJigyoshaSearchBusiness 情報 = get情報FromDataSouce(row, サービス事業者情報);
        if (情報.get申請者氏名_漢字() == null) {
            情報.createBuilderForEdit().set申請者氏名_漢字(RString.EMPTY);
        }
        if (情報.get申請者氏名_カナ() == null) {
            情報.createBuilderForEdit().set申請者氏名_カナ(RString.EMPTY);
        }
        if (情報.get申請者住所_カナ() == null) {
            情報.createBuilderForEdit().set申請者住所_カナ(RString.EMPTY);
        }
        if (情報.get申請者住所() == null) {
            情報.createBuilderForEdit().set申請者住所(RString.EMPTY);
        }
        if (情報.get申請者郵便番号() == null) {
            情報.createBuilderForEdit().set申請者郵便番号(YubinNo.EMPTY);
        }
        if (情報.get申請者電話番号() == null) {
            情報.createBuilderForEdit().set申請者電話番号(RString.EMPTY);
        }
        if (情報.get申請者FAX番号() == null) {
            情報.createBuilderForEdit().set申請者FAX番号(RString.EMPTY);
        }
        if (情報.get事業所代表者住所カナ() == null) {
            情報.createBuilderForEdit().set事業所代表者住所カナ(RString.EMPTY);
        }
        if (情報.get事業所代表者住所() == null) {
            情報.createBuilderForEdit().set事業所代表者住所(RString.EMPTY);
        }
        if (情報.get事業所代表者氏名() == null) {
            情報.createBuilderForEdit().set事業所代表者氏名(RString.EMPTY);
        }
        if (情報.get事業所代表者氏名カナ() == null) {
            情報.createBuilderForEdit().set事業所代表者氏名カナ(RString.EMPTY);
        }
        if (情報.get事業所代表者郵便番号() == null) {
            情報.createBuilderForEdit().set事業所代表者郵便番号(YubinNo.EMPTY);
        }
        if (情報.get事業所代表者役職() == null) {
            情報.createBuilderForEdit().set事業所代表者役職(RString.EMPTY);
        }
        if (情報.get介護国保連ＩＦ法人種別() == null) {
            情報.createBuilderForEdit().set介護国保連ＩＦ法人種別(RString.EMPTY);
        }
        if (情報.get介護国保連ＩＦ異動区分() == null) {
            情報.createBuilderForEdit().set介護国保連ＩＦ異動区分(RString.EMPTY);
        }
        if (情報.get介護国保連ＩＦ異動年月日() == null) {
            情報.createBuilderForEdit().set介護国保連ＩＦ異動年月日(FlexibleDate.EMPTY);
        }
        updateサービス事業者一覧();

        return 変更が判断する(情報);
    }

    private void updateサービス事業者一覧() {

        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().setValue(YubinNo.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYubinNo().setValue(YubinNo.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku().setValue(RString.EMPTY);
        }
        if (div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku() == null) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku().setValue(RString.EMPTY);
        }
    }

    private boolean 変更が判断する(TokubetsuKyufuJigyoshaSearchBusiness 情報) {
        if (!情報.createBuilderForEdit().build().get申請者氏名_漢字().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaName().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get申請者氏名_カナ().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaNameKana().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get申請者住所_カナ().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJushoKana().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get申請者住所().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaJusho().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get申請者郵便番号().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaYubinNo().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get申請者電話番号().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaTelNo().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get申請者FAX番号().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailShinseisha().getTxtShinseishaFaxNo().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get事業所代表者住所().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJusho().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get事業所代表者住所カナ().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaJushoKana().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get事業所代表者氏名カナ().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaNameKana().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get事業所代表者氏名().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaName().getValue())) {
            return false;
        }
        if (!情報.createBuilderForEdit().build().get事業所代表者役職().
                equals(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailDaihyosha().getTxtDaihyoshaYakushoku().getValue())) {
            return false;
        }
        if (!div.getTokubetsuKyufuJigyoshaDetail().getDdlHojinShubetsu().getSelectedKey().
                equals(情報.createBuilderForEdit().build().get介護国保連ＩＦ法人種別())) {
            return false;
        }
        if (!div.getTokubetsuKyufuJigyoshaDetail().getRadIdoKubun().getSelectedKey().
                equals(情報.createBuilderForEdit().build().get介護国保連ＩＦ異動区分())) {
            return false;
        }
        FlexibleDate 異動年月日 = new FlexibleDate(div.getTokubetsuKyufuJigyoshaDetail().getTxtIdoYMD().getValue().toDateString());
        return 異動年月日.equals(情報.createBuilderForEdit().build().get介護国保連ＩＦ異動年月日());
    }
}
