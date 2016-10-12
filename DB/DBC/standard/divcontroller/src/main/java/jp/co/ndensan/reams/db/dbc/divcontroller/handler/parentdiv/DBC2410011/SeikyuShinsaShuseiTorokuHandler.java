/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2410011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoShukei;
import jp.co.ndensan.reams.db.dbc.business.core.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuCollect;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.SeikyuShinsaShuseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.dgSeikyuMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.dgSeikyu_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JutakuKaishuRiyushoTesuryoKetteiManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JutakuKaishuRiyushoTesuryoMeisaiManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JutakuKaishuRiyushoTesuryoShukeiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)のクラスです。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
public class SeikyuShinsaShuseiTorokuHandler {

    private static final RString TITLE_1004 = new RString("住宅改修理由書作成手数料　請求審査修正登録");
    private static final RString TITLE_1005 = new RString("住宅改修理由書作成手数料　請求審査結果登録");
    private static final RString DBCMNE_1004 = new RString("DBCMNE1004");
    private static final RString DBCMNE_1005 = new RString("DBCMNE1005");
    private static final RString 請求単位 = new RString("請求単位");
    private static final RString 支給決定 = new RString("決定区分支給選択時、金融機関・口座情報");
    private static final RString 不支給決定 = new RString("決定区分不支給選択時、不支給の理由");
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString 口座種別KEY = new RString("key0");
    private static final RString 照会 = new RString("照会");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private final SeikyuShinsaShuseiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public SeikyuShinsaShuseiTorokuHandler(SeikyuShinsaShuseiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param menuID menuID
     */
    public void onLoad(RString menuID) {
        if (DBCMNE_1004.equals(menuID)) {
            div.setTitle(TITLE_1004);
            div.getJutakuTesuryoSeikyuKetteiPanel().setDisplayNone(false);
            div.getJutakuTesuryoSeikyuShosaiPanel().setIsOpen(false);
        }
        if (DBCMNE_1005.equals(menuID)) {
            div.setTitle(TITLE_1005);
            div.getJutakuTesuryoSeikyuKetteiPanel().setIsOpen(true);
        }
        div.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSerchJigyosyaName().setDisabled(false);
        div.getJutakuTesuryoSeikyuJohoPanel().getDgSeikyu().setDisabled(false);
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaNo().setDisabled(false);
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaName().setDisabled(false);
        div.getJutakuTesuryoSeikyuShosaiPanel().getDdlKozaShubetsu().setDisabled(true);
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNo().setDisabled(true);
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNameKana().setDisabled(true);
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaName().setDisabled(true);
        div.getJutakuTesuryoSeikyuMeisai().setDisabled(false);
        div.getSeikyuMeisaiShosaiPanel().setDisabled(false);
        div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu().setDisabled(false);
        div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().setDisabled(false);
        div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku().setDisabled(true);
    }

    /**
     * 「請求情報集計パネルの請求合計」の処理です。
     */
    public void get請求合計() {
        Decimal 請求単価 = div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().getValue();
        Decimal 請求件数 = div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu().getValue();
        if (請求単価 == null && 請求件数 == null) {
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().setValue(Decimal.ZERO);
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu().setValue(Decimal.ZERO);
            Decimal 請求単価Null = div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().getValue();
            Decimal 請求件数Null = div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu().getValue();
            Decimal 請求合計 = 請求件数Null.multiply(請求単価Null);
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku().setValue(請求合計);
        }
        if (請求単価 == null && 請求件数 != null) {
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().setValue(Decimal.ZERO);
            Decimal 請求単価Null = div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().getValue();
            Decimal 請求合計 = 請求件数.multiply(請求単価Null);
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku().setValue(請求合計);
        }
        if (請求単価 != null && 請求件数 == null) {
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu().setValue(Decimal.ZERO);
            Decimal 請求件数Null = div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu().getValue();
            Decimal 請求合計 = 請求件数Null.multiply(請求単価);
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku().setValue(請求合計);
        }
        if (請求単価 != null && 請求件数 != null) {
            Decimal 請求合計 = 請求件数.multiply(請求単価);
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku().setValue(請求合計);
        }
    }

    /**
     * 「検索する」の処理です。
     *
     * @param 一覧情報 一覧情報
     */
    public void get検索一覧(List<SeikyuShinsaShuseiTorokuBusiness> 一覧情報) {
        List<dgSeikyu_Row> dataGridList = new ArrayList<>();
        for (SeikyuShinsaShuseiTorokuBusiness business : 一覧情報) {
            dgSeikyu_Row row = new dgSeikyu_Row();
            RString 請求情報作成日 = RString.EMPTY;
            RString 件数 = RString.EMPTY;
            RString 請求金額 = RString.EMPTY;
            RString 決定日 = RString.EMPTY;

            if (!business.getDbT3095().get介護住宅改修理由書作成申請年月日().isEmpty()) {
                請求情報作成日 = business.getDbT3095().get介護住宅改修理由書作成申請年月日().wareki().toDateString();
            }
            if (business.getDbT3096().get介護住宅改修理由書作成件数() != null) {
                件数 = new RString(business.getDbT3096().get介護住宅改修理由書作成件数().toString());
            }
            if (business.getDbT3096().get介護住宅改修理由書作成請求金額() != null) {
                請求金額 = new RString(kinngakuFormat(business.getDbT3096().get介護住宅改修理由書作成請求金額()).toString());
            }
            if (!business.getDbT3094().get支給_不支給決定年月日().isEmpty()) {
                決定日 = business.getDbT3094().get支給_不支給決定年月日().wareki().toDateString();
            }

            dataGridList.add(creatdgSeikyuRow(
                    business.getDbT3096().get介護住宅改修理由書作成事業者番号().value(),
                    business.getDbT3096().get介護住宅改修事業者名称().value(),
                    請求情報作成日,
                    件数,
                    請求金額,
                    決定日,
                    business.getDbT3094().get支給_不支給区分(),
                    row
            ));
        }
        div.getDgSeikyu().getDataSource().clear();
        div.getDgSeikyu().setDataSource(dataGridList);
    }

    private dgSeikyu_Row creatdgSeikyuRow(
            RString defaultDataName1,
            RString defaultDataName2,
            RString defaultDataName3,
            RString defaultDataName4,
            RString defaultDataName5,
            RString defaultDataName6,
            RString defaultDataName7,
            dgSeikyu_Row row) {
        row.setDefaultDataName1(defaultDataName1);
        row.setDefaultDataName2(defaultDataName2);
        row.setDefaultDataName3(defaultDataName3);
        row.setDefaultDataName4(defaultDataName4);
        row.setDefaultDataName5(defaultDataName5);
        row.setDefaultDataName6(defaultDataName6);
        row.setDefaultDataName7(defaultDataName7);
        return row;
    }

    /**
     * 情報一覧です
     *
     */
    public void get情報一覧() {
        div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus();
        dgSeikyu_Row row = div.getDgSeikyu().getActiveRow();
        int index = div.getDgSeikyu().getClickedRowId();
        SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報 = ViewStateHolder
                .get(ViewStateKeys.住宅改修理由書事業者情報, SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(index);
        this.set画面一覧(row, 住宅改修理由書事業者情報);
        if (照会.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            div.getDgSeikyuMeisai().getGridSetting().getColumns().get(1).setVisible(false);
            this.審査画面一覧(住宅改修理由書事業者情報);
        }
        if (修正.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            div.getDgSeikyuMeisai().getGridSetting().getColumns().get(1).setVisible(true);
        }
        if (削除.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            div.getDgSeikyuMeisai().getGridSetting().getColumns().get(1).setVisible(true);
        }
    }

    /**
     * 審査画面一覧です
     *
     */
    private void 審査画面一覧(SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報) {
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID())) {
            div.getJutakuTesuryoSeikyuKetteiPanel().setVisible(true);
            div.getJutakuTesuryoSeikyuKetteiPanel().setIsOpen(false);
            div.getJutakuTesuryoSeikyuKetteiPanel().setDisabled(true);
            if (!住宅改修理由書事業者情報.getDbT3094().get決定年月日().isEmpty()) {
                div.getJutakuTesuryoSeikyuKetteiPanel().getTxtKetteiYMD().setValue(new RDate(住宅改修理由書事業者情報.getDbT3094().get決定年月日().wareki().toDateString().toString()));
            }
            div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().setSelectedKey(住宅改修理由書事業者情報.getDbT3094().get支給_不支給区分());
            if (!住宅改修理由書事業者情報.getDbT3094().get住宅改修理由書作成手数料支払予定日().isEmpty()) {
                div.getJutakuTesuryoSeikyuKetteiPanel().getTxtTesuryoShiharaiYoteiYMD().setValue(new RDate(住宅改修理由書事業者情報.getDbT3094().get住宅改修理由書作成手数料支払予定日().toString()));
            }
            div.getJutakuTesuryoSeikyuKetteiPanel().getTxtFushikyuRiyu().setValue(住宅改修理由書事業者情報.getDbT3094().get償還不支給理由等());
        }
    }

    /**
     * 画面一覧です
     *
     */
    private void set画面一覧(dgSeikyu_Row row, SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報) {
        div.getTxtHdnShikibetsuCode().setValue(住宅改修理由書事業者情報.getDbT3095().get識別コード().value());
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaNo().setValue(row.getDefaultDataName1());
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaName().setValue(row.getDefaultDataName2());
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtSeikyuSakuseiYMD().setValue(row.getDefaultDataName3());
        div.getJutakuTesuryoSeikyuShosaiPanel().getCcdKinyuKikanInput().getKinyuKikanCode();
        FlexibleDate kijunYMD = FlexibleDate.getNowDate();
        RString 金融機関コード = 住宅改修理由書事業者情報.getDbT3096().get金融機関コード();
        RString 支店コード = 住宅改修理由書事業者情報.getDbT3096().get支店コード();
        KinyuKikan kinyuKikan = new KinyuKikan(new KinyuKikanCode(金融機関コード), kijunYMD);
        KinyuKikanShiten kinyuKikanShiten = new KinyuKikanShiten(kinyuKikan.get金融機関コード(), new KinyuKikanShitenCode(支店コード), kijunYMD);
        div.getJutakuTesuryoSeikyuShosaiPanel().getCcdKinyuKikanInput().set金融機関(kinyuKikan.createBuilderForEdit().
                set金融機関支店(kinyuKikanShiten).build(), kinyuKikanShiten.get支店コード(), kijunYMD);
        div.getJutakuTesuryoSeikyuShosaiPanel().getCcdKinyuKikanInput().search(kinyuKikan.
                get金融機関コード(), new KinyuKikanShitenCode(支店コード), kijunYMD);
        div.getJutakuTesuryoSeikyuShosaiPanel().getDdlKozaShubetsu().setSelectedKey(住宅改修理由書事業者情報.getDbT3096().get口座種別());
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNo().setValue(住宅改修理由書事業者情報.getDbT3096().get口座番号());
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNameKana().setValue(住宅改修理由書事業者情報.getDbT3096().get口座名義人カナ());
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaName().setValue(住宅改修理由書事業者情報.getDbT3096().get口座名義人());
        List<dgSeikyuMeisai_Row> rowList = new ArrayList<>();
        dgSeikyuMeisai_Row 明細一覧 = new dgSeikyuMeisai_Row();
        明細一覧.setDefaultDataName1(住宅改修理由書事業者情報.getDbT3095().get被保険者番号().value());
        明細一覧.setDefaultDataName0(住宅改修理由書事業者情報.getDbT3095().get対象外フラグ());
        if (!住宅改修理由書事業者情報.getDbT3095().get介護住宅改修住宅所有者().isEmpty()) {
            明細一覧.setDefaultDataName3(住宅改修理由書事業者情報.getDbT3095().get介護住宅改修住宅所有者().value());
        }
        if (!住宅改修理由書事業者情報.getDbT3095().get介護住宅改修理由書作成年月日().isEmpty()) {
            明細一覧.setDefaultDataName4(住宅改修理由書事業者情報.getDbT3095().get介護住宅改修理由書作成年月日().wareki().toDateString());
        }

        明細一覧.setDefaultDataName5(住宅改修理由書事業者情報.getDbT3095().get介護住宅改修理由書作成者名().value());

        if (!住宅改修理由書事業者情報.getDbT3095().get支給申請年月日().isEmpty()) {
            明細一覧.setDefaultDataName6(住宅改修理由書事業者情報.getDbT3095().get支給申請年月日().wareki().toDateString());
        }
        if (!住宅改修理由書事業者情報.getDbT3095().get介護住宅改修着工年月日().isEmpty()) {
            明細一覧.setDefaultDataName7(住宅改修理由書事業者情報.getDbT3095().get介護住宅改修着工年月日().wareki().toDateString());
        }
        rowList.add(明細一覧);
        div.getJutakuTesuryoSeikyuShosaiPanel().getDgSeikyuMeisai().getDataSource().clear();
        div.getJutakuTesuryoSeikyuShosaiPanel().getDgSeikyuMeisai().setDataSource(rowList);
    }

    /**
     * 明細照会一覧です
     *
     */
    public void get明細照会一覧() {

        if (!div.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().isIsOpen()) {
            div.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().isIsOpen();
        }
        int index = div.getDgSeikyu().getClickedRowId();
        SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報 = ViewStateHolder
                .get(ViewStateKeys.住宅改修理由書事業者情報, SeikyuShinsaShuseiTorokuCollect.class
                ).get事業者情報List().get(index);
        div.getSeikyuMeisaiShosaiPanel()
                .getTxtHihokenshaNo().setValue(住宅改修理由書事業者情報.getDbT3095().get被保険者番号().value());
        div.getSeikyuMeisaiShosaiPanel()
                .getTxtHihokenshaName().setValue(住宅改修理由書事業者情報.getDbT3095().get介護住宅改修住宅所有者().value());

        if (!住宅改修理由書事業者情報.getDbT3095().get介護住宅改修理由書作成年月日().isEmpty()) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseiYMD().setValue(new RDate(住宅改修理由書事業者情報
                    .getDbT3095().get介護住宅改修理由書作成年月日().wareki().toDateString().toString()));
        }
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMeiKana().setValue(住宅改修理由書事業者情報
                .getDbT3095().get介護住宅改修理由書作成者名カナ());
        if (!住宅改修理由書事業者情報.getDbT3095().get介護住宅改修理由書作成者名().isEmpty()) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMei().setValue(住宅改修理由書事業者情報
                    .getDbT3095().get介護住宅改修理由書作成者名().value());
        }
        if (!住宅改修理由書事業者情報.getDbT3095().get介護住宅改修理由書作成申請年月日().isEmpty()) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD().setValue(new RDate(住宅改修理由書事業者情報
                    .getDbT3095().get介護住宅改修理由書作成申請年月日().wareki().toDateString().toString()));
        }

        if (!住宅改修理由書事業者情報.getDbT3095().get介護住宅改修着工年月日().isEmpty()) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD().setValue(new RDate(住宅改修理由書事業者情報
                    .getDbT3095().get介護住宅改修着工年月日().wareki().toDateString().toString()));
        }

        if (!住宅改修理由書事業者情報.getDbT3095().get介護住宅改修事業者名称().isEmpty()) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho().setValue(住宅改修理由書事業者情報
                    .getDbT3095().get介護住宅改修事業者名称().value());
        }

        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho().setValue(住宅改修理由書事業者情報
                .getDbT3095().get改修対象住宅住所());

        div.getSeikyuMeisaiShosaiPanel()
                .getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo().setValue(住宅改修理由書事業者情報
                        .getDbT3095().get改修内容_箇所及び規模());
        div.getTxtRiyushoSakuseiTanka().setValue(住宅改修理由書事業者情報.getDbT3096().get介護住宅改修理由書作成単価());
        div.getTxtRiyushoSakuseiKensu().setValue(住宅改修理由書事業者情報.getDbT3096().get介護住宅改修理由書作成件数());
        div.getTxtRiyushoSakuseiSeikyuKingaku().setValue(住宅改修理由書事業者情報.getDbT3096().get介護住宅改修理由書作成請求金額());
    }

    /**
     * 操作確認です
     *
     */
    public void get操作確認() {
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            this.get情報一覧();
        }
    }

    /**
     * 入力のチェックです
     *
     */
    public void 入力チェック() {
        div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().getValue();
        if (div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().getValue().toString().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(請求単位.toString()));
        }
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID())) {
            if (KEY_0.equals(div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().getSelectedKey()) && div.
                    getJutakuTesuryoSeikyuShosaiPanel().getDdlKozaShubetsu().getSelectedKey().isEmpty() && div.
                    getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNo().getValue().isEmpty() && div.getJutakuTesuryoSeikyuShosaiPanel().
                    getTxtKozaNameKana().getValue().isEmpty() && div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaName().getValue().isEmpty()) {
                throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(支給決定.toString()));
            }
            if (KEY_1.equals(div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().getSelectedKey()) && div.
                    getTxtFushikyuRiyu().getValue().isEmpty()) {
                throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(不支給決定.toString()));
            }
        }
    }

    /**
     * 内容の変更状態です
     *
     * @param business SeikyuShinsaShuseiTorokuBusiness business
     * @return boolean
     */
    public boolean is内容変更状態(SeikyuShinsaShuseiTorokuBusiness business) {

        Decimal 請求単価New = div.getTxtRiyushoSakuseiTanka().getValue();
        Decimal 請求単価Old = business.getDbT3096().get介護住宅改修理由書作成単価();
        if (請求単価New == null) {
            div.getTxtRiyushoSakuseiTanka().setValue(Decimal.ZERO);
            Decimal 請求単価Null = div.getTxtRiyushoSakuseiTanka().getValue();
            if (!請求単価Null.equals(請求単価Old)) {
                return true;
            }
        }
        if (請求単価New != null && !請求単価New.equals(請求単価Old)) {
            return true;
        }
        this.入力チェック();
        return false;
    }

    /**
     * 修正更新の状態です
     *
     * @param business SeikyuShinsaShuseiTorokuBusiness
     * @return SeikyuShinsaShuseiTorokuBusiness SeikyuShinsaShuseiTorokuBusiness
     */
    public SeikyuShinsaShuseiTorokuBusiness 修正更新(SeikyuShinsaShuseiTorokuBusiness business) {
        SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報 = ViewStateHolder.get(ViewStateKeys.住宅改修理由書事業者情報,
                SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(div.getDgSeikyu().getClickedRowId());
        JutakuKaishuRiyushoTesuryoKettei 出力決定 = 住宅改修理由書事業者情報.getDbT3094();
        JutakuKaishuRiyushoTesuryoMeisai 出力明細 = 住宅改修理由書事業者情報.getDbT3095();
        JutakuKaishuRiyushoTesuryoMeisaiManager 出力明細MANAGER = new JutakuKaishuRiyushoTesuryoMeisaiManager();
        JutakuKaishuRiyushoTesuryoKetteiManager 出力決定MANAGER = new JutakuKaishuRiyushoTesuryoKetteiManager();
        if (DBCMNE_1004.equals(ResponseHolder.getMenuID())) {
            出力明細 = 出力明細.createBuilderForEdit().set対象外フラグ(div.getDgSeikyuMeisai().getActiveRow().
                    getDefaultDataName0().booleanValue()).build();
            出力明細MANAGER.save住宅改修理由書作成手数料請求明細(出力明細);
        }
        if (div.getDgSeikyuMeisai().getActiveRow() != null) {
            出力明細 = 出力明細.createBuilderForEdit().set対象外フラグ(div.getDgSeikyuMeisai().getActiveRow().getDefaultDataName0()
                    .booleanValue()).build();
        }
        出力明細 = 出力明細.modifiedModel();
        出力明細MANAGER.save住宅改修理由書作成手数料請求明細(出力明細);
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID())) {
            if (div.getTxtKetteiYMD().getValue() != null) {
                出力決定 = 出力決定.createBuilderForEdit().set支給_不支給決定年月日(new FlexibleDate(div.getTxtKetteiYMD().getValue()
                        .toString())).build();
            }
            出力決定 = 出力決定.createBuilderForEdit().set支給_不支給区分(div.getRadShikyuFushikyuKubun().getSelectedKey()).build();
            出力決定 = 出力決定.createBuilderForEdit().set償還不支給理由等(div.getTxtFushikyuRiyu().getValue()).build();
            if (div.getTxtTesuryoShiharaiYoteiYMD().getValue() != null) {
                出力決定 = 出力決定.createBuilderForEdit().set住宅改修理由書作成手数料支払予定日(new FlexibleDate(div
                        .getTxtTesuryoShiharaiYoteiYMD().getValue().toString())).build();
            }
            出力決定 = 出力決定.modifiedModel();
            出力決定MANAGER.save住宅改修理由書作成手数料請求決定(出力決定);
        }
        SeikyuShinsaShuseiTorokuBusiness businessResult = new SeikyuShinsaShuseiTorokuBusiness();
        businessResult.setDbT3094(出力決定);
        businessResult.setDbT3095(出力明細);
        return businessResult;
    }

    /**
     * 削除更新の状態です
     *
     * @param business SeikyuShinsaShuseiTorokuBusiness business
     * @return SeikyuShinsaShuseiTorokuBusiness
     */
    public SeikyuShinsaShuseiTorokuBusiness 削除更新(SeikyuShinsaShuseiTorokuBusiness business) {
        SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報 = ViewStateHolder.get(ViewStateKeys.住宅改修理由書事業者情報,
                SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(div.getDgSeikyu().getClickedRowId());
        JutakuKaishuRiyushoTesuryoKettei 出力決定 = 住宅改修理由書事業者情報.getDbT3094();
        JutakuKaishuRiyushoTesuryoMeisai 出力明細 = 住宅改修理由書事業者情報.getDbT3095();
        JutakuKaishuRiyushoTesuryoShukei 出力集計 = 住宅改修理由書事業者情報.getDbT3096();
        JutakuKaishuRiyushoTesuryoMeisaiManager 出力明細MANAGER = new JutakuKaishuRiyushoTesuryoMeisaiManager();
        JutakuKaishuRiyushoTesuryoKetteiManager 出力決定MANAGER = new JutakuKaishuRiyushoTesuryoKetteiManager();
        JutakuKaishuRiyushoTesuryoShukeiManager 出力集計Manager = new JutakuKaishuRiyushoTesuryoShukeiManager();
        出力明細MANAGER.save住宅改修理由書作成手数料請求明細(出力明細.deleted());
        出力集計Manager.save住宅改修理由書作成手数料請求集計(出力集計.deleted());
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID())) {
            出力決定MANAGER.save住宅改修理由書作成手数料請求決定(出力決定.deleted());
        }
        SeikyuShinsaShuseiTorokuBusiness businessResult = new SeikyuShinsaShuseiTorokuBusiness();
        businessResult.setDbT3094(出力決定);
        businessResult.setDbT3095(出力明細);
        businessResult.setDbT3096(出力集計);
        return businessResult;
    }

    /**
     * データのクリアです
     */
    public void クリアデータ() {
        div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().clearSelectedItem();
        div.getJutakuTesuryoSeikyuKetteiPanel().getTxtFushikyuRiyu().clearValue();
        div.getJutakuTesuryoSeikyuKetteiPanel().getTxtKetteiYMD().clearValue();
        div.getJutakuTesuryoSeikyuKetteiPanel().getTxtTesuryoShiharaiYoteiYMD().clearValue();
        div.getJutakuTesuryoSeikyuShosaiPanel().getCcdKinyuKikanInput().clear();
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaNo().clearValue();
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaName().clearValue();
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtSeikyuSakuseiYMD().clearValue();
        div.getJutakuTesuryoSeikyuShosaiPanel().getDdlKozaShubetsu().setSelectedKey(口座種別KEY);
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNo().clearValue();
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNameKana().clearValue();
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaName().clearValue();
        div.getDgSeikyuMeisai().getDataSource().clear();
        div.getSeikyuMeisaiShosaiPanel().getTxtHihokenshaNo().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getTxtHihokenshaName().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getTxtRiyushoSakuseiYMD().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getTxtRiyushoSakuseishaMeiKana().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getTxtRiyushoSakuseishaMei().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho().clearValue();
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo().clearValue();
        div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().clearValue();
        div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu().clearValue();
        div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku().clearValue();
    }

    private RString kinngakuFormat(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(date, 0);
    }
}
