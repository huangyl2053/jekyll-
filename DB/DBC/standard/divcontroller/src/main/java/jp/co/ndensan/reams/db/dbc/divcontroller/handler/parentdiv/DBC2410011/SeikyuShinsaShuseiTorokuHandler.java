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
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.SeikyuShinsaShuseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.dgSeikyuMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.dgSeikyu_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumnCheckBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private static final RString KEY_0 = new RString("0");
    private static final RString KEY_1 = new RString("1");
    private static final RString 口座種別KEY = new RString("0");
    private static final RString 照会 = new RString("照会");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 保存ボタン = new RString("btnUpdate");
    private static final RString 再検索ボタン = new RString("btnResearch");
    private static final RString 請求単位 = new RString("請求単位");
    private static final RString 支給決定 = new RString("決定区分支給選択時、金融機関・口座情報");
    private static final RString 不支給決定 = new RString("決定区分不支給選択時、不支給の理由");
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
            div.getChkSerchKetteiZumi().setVisible(false);
        }
        if (DBCMNE_1005.equals(menuID)) {
            div.setTitle(TITLE_1005);
        }
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存ボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索ボタン, true);
    }

    /**
     * 「請求情報集計パネルの請求合計」の処理です。
     */
    public void get請求合計() {
        Decimal 請求単価 = div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().getValue();
        Decimal 請求件数 = div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu().getValue();
        if (請求単価 == null) {
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku().setValue(Decimal.ZERO);
        }
        if (請求単価 != null && 請求件数 == null) {
            div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku().setValue(Decimal.ZERO);
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
            TextBoxDate 請求情報作成日 = new TextBoxDate();
            TextBoxNum 件数 = new TextBoxNum();
            TextBoxNum 請求金額 = new TextBoxNum();
            TextBoxDate 受付日 = new TextBoxDate();
            TextBoxDate 決定日 = new TextBoxDate();
            RString 集計関連付け番号 = RString.EMPTY;
            RString 支給_不支給区分 = RString.EMPTY;
            RString 事業者番号 = RString.EMPTY;
            RString 事業者名称 = RString.EMPTY;
            if (business.getDbT3096().get請求情報作成日() != null) {
                請求情報作成日.setValue(new RDate(business.getDbT3096().get請求情報作成日().toString()));
            }
            if (business.getDbT3096().get介護住宅改修理由書作成件数() != null) {
                件数.setValue(business.getDbT3096().get介護住宅改修理由書作成件数());
            }
            if (business.getDbT3096().get介護住宅改修理由書作成請求金額() != null) {
                請求金額.setValue(business.getDbT3096().get介護住宅改修理由書作成請求金額());
            }
            if (business.getDbT3096().get受付年月日() != null && !business.getDbT3096().get受付年月日().isEmpty()) {
                受付日.setValue(new RDate(business.getDbT3096().get受付年月日().toString()));
            }
            if (business.getDbT3094() != null) {
                if (business.getDbT3094().get支給_不支給決定年月日() != null && !business.getDbT3094().get支給_不支給決定年月日().isEmpty()) {
                    決定日.setValue(new RDate(business.getDbT3094().get支給_不支給決定年月日().toString()));
                }
                支給_不支給区分 = business.getDbT3094().get支給_不支給区分();
            }
            if (business.getDbT3096().get集計関連付け番号() != null) {
                集計関連付け番号 = business.getDbT3096().get集計関連付け番号();
            }
            if (business.getDbT3096().get介護住宅改修理由書作成事業者番号() != null) {
                事業者番号 = business.getDbT3096().get介護住宅改修理由書作成事業者番号().value();
            }
            if (business.getDbT3096().get介護住宅改修事業者名称() != null) {
                事業者名称 = business.getDbT3096().get介護住宅改修事業者名称().value();
            }
            dataGridList.add(creatdgSeikyuRow(
                    事業者番号,
                    事業者名称,
                    請求情報作成日,
                    件数,
                    請求金額,
                    受付日,
                    決定日,
                    支給_不支給区分,
                    集計関連付け番号,
                    row
            ));
        }
        div.getDgSeikyu().getDataSource().clear();
        div.getDgSeikyu().setDataSource(dataGridList);
    }

    private dgSeikyu_Row creatdgSeikyuRow(
            RString jigyoshaNo,
            RString jigyoshaMei,
            TextBoxDate seikyuJohoSakuseiYMD,
            TextBoxNum seikyuKensu,
            TextBoxNum seikyuKingaku,
            TextBoxDate uketsukeYMD,
            TextBoxDate ketteiYMD,
            RString ketteiKubun,
            RString hdnShukeiNo,
            dgSeikyu_Row row) {
        row.setJigyoshaNo(jigyoshaNo);
        row.setJigyoshaMei(jigyoshaMei);
        row.setSeikyuJohoSakuseiYMD(seikyuJohoSakuseiYMD);
        row.setSeikyuKensu(seikyuKensu);
        row.setSeikyuKingaku(seikyuKingaku);
        row.setUketsukeYMD(uketsukeYMD);
        row.setKetteiYMD(ketteiYMD);
        row.setKetteiKubun(ketteiKubun);
        row.setHdnShukeiNo(hdnShukeiNo);
        return row;
    }

    /**
     * 情報一覧です
     *
     */
    public void get情報一覧() {
        if (照会.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus()) || 削除.
                equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            div.getTxtRiyushoSakuseiTanka().setDisabled(true);
            if (DBCMNE_1005.equals(ResponseHolder.getMenuID())) {
                div.getJutakuTesuryoSeikyuKetteiPanel().setDisabled(true);
            }
        }
        if (修正.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            div.getJutakuTesuryoSeikyuKetteiPanel().setDisabled(false);
            div.getJutakuTesuryoSeikyuShosaiPanel().setDisabled(false);
            div.getTxtRiyushoSakuseiTanka().setDisabled(false);
        }
        if (削除.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            div.getTxtRiyushoSakuseiTanka().setDisabled(true);
        }
        int index = div.getDgSeikyu().getClickedRowId();
        List<SeikyuShinsaShuseiTorokuBusiness> 住宅改修理由書事業者情報リスト = ViewStateHolder
                .get(ViewStateKeys.住宅改修理由書事業者情報, SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List();
        SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報 = ViewStateHolder
                .get(ViewStateKeys.住宅改修理由書事業者情報, SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(index);
        List<dgSeikyuMeisai_Row> rowList = new ArrayList<>();
        List<SeikyuShinsaShuseiTorokuBusiness> 事業者情報明細リスト = new ArrayList<>();
        SeikyuShinsaShuseiTorokuCollect collectList = new SeikyuShinsaShuseiTorokuCollect();
        for (SeikyuShinsaShuseiTorokuBusiness 事業者情報明細 : 住宅改修理由書事業者情報リスト) {
            if (住宅改修理由書事業者情報.getDbT3096().get集計関連付け番号().equals(事業者情報明細.
                    getDbT3096().get集計関連付け番号())) {
                set請求情報明細一覧(事業者情報明細, rowList);
                事業者情報明細リスト.add(事業者情報明細);
                collectList.set事業者情報List(事業者情報明細リスト);
                ViewStateHolder.put(ViewStateKeys.住宅改修理由書事業者情報明細, collectList);
            }
        }
        if (住宅改修理由書事業者情報.getDbT3096().get口座種別() != null) {
            div.getDgSeikyuMeisai().getDataSource().clear();
            div.getDgSeikyuMeisai().setDataSource(rowList);
        }
        set請求情報詳細(住宅改修理由書事業者情報);
        明細照会情報();
        審査画面一覧(住宅改修理由書事業者情報);
    }

    private void 明細照会情報() {
        SeikyuShinsaShuseiTorokuBusiness 事業者情報明細 = ViewStateHolder.
                get(ViewStateKeys.住宅改修理由書事業者情報明細, SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(0);
        div.getSeikyuMeisaiShosaiPanel().getTxtHihokenshaNo().setValue(事業者情報明細.getDbT3095().get被保険者番号().value());
        div.getSeikyuMeisaiShosaiPanel().getTxtHihokenshaName().setValue(事業者情報明細.getDbT3095().get介護住宅改修住宅所有者().value());
        if (事業者情報明細.getDbT3095().get介護住宅改修理由書作成年月日() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseiYMD().setValue(new RDate(事業者情報明細
                    .getDbT3095().get介護住宅改修理由書作成年月日().toString()));
        }
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMeiKana().
                setValue(事業者情報明細.getDbT3095().get介護住宅改修理由書作成者名カナ());
        if (事業者情報明細.getDbT3095().get介護住宅改修理由書作成者名() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMei().setValue(事業者情報明細
                    .getDbT3095().get介護住宅改修理由書作成者名().value());
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修理由書作成申請年月日() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD().setValue(new RDate(事業者情報明細
                    .getDbT3095().get介護住宅改修理由書作成申請年月日().toString()));
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修着工年月日() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD().setValue(new RDate(事業者情報明細
                    .getDbT3095().get介護住宅改修着工年月日().toString()));
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修事業者名称() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho().
                    setValue(事業者情報明細.getDbT3095().get介護住宅改修事業者名称().value());
        }
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho().
                setValue(事業者情報明細.getDbT3095().get改修対象住宅住所());
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo().
                setValue(事業者情報明細.getDbT3095().get改修内容_箇所及び規模());
        div.getTxtRiyushoSakuseiTanka().setValue(事業者情報明細.getDbT3096().get介護住宅改修理由書作成単価());
        div.getTxtRiyushoSakuseiKensu().setValue(事業者情報明細.getDbT3096().get介護住宅改修理由書作成件数());
        div.getTxtRiyushoSakuseiSeikyuKingaku().setValue(事業者情報明細.getDbT3096().get介護住宅改修理由書作成請求金額());
    }

    /**
     * 審査画面一覧です
     *
     */
    private void 審査画面一覧(SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報) {
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID()) && 住宅改修理由書事業者情報.getDbT3094() != null) {

            if (住宅改修理由書事業者情報.getDbT3094().get支給_不支給決定年月日() != null) {
                div.getJutakuTesuryoSeikyuKetteiPanel().getTxtKetteiYMD().setValue(new RDate(住宅改修理由書事業者情報.getDbT3094().
                        get支給_不支給決定年月日().toString()));
            }
            div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().setSelectedKey(住宅改修理由書事業者情報.getDbT3094().
                    get支給_不支給区分());
            if (KEY_0.equals(住宅改修理由書事業者情報.getDbT3094().get支給_不支給区分())) {
                div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().setSelectedKey(KEY_0);
            }
            if (KEY_1.equals(住宅改修理由書事業者情報.getDbT3094().get支給_不支給区分())) {
                div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().setSelectedKey(KEY_1);
            }
            if (住宅改修理由書事業者情報.getDbT3094().get住宅改修理由書作成手数料支払予定日() != null) {
                div.getJutakuTesuryoSeikyuKetteiPanel().getTxtTesuryoShiharaiYoteiYMD().setValue(new RDate(
                        住宅改修理由書事業者情報.getDbT3094().get住宅改修理由書作成手数料支払予定日().toString()));
            }
            div.getJutakuTesuryoSeikyuKetteiPanel().getTxtFushikyuRiyu().setValue(住宅改修理由書事業者情報.getDbT3094().get償還不支給理由等());
        }
    }

    private void set請求情報詳細(SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者情報) {
        if (住宅改修理由書事業者情報.getDbT3096().get受付年月日() != null && !住宅改修理由書事業者情報.getDbT3096().get受付年月日().isEmpty()) {
            div.getTxtUketsukeYMD().setValue(new RDate(住宅改修理由書事業者情報.getDbT3096().get受付年月日().toString()));
        }
        if (住宅改修理由書事業者情報.getDbT3096().get申請年月日() != null && !住宅改修理由書事業者情報.getDbT3096().get申請年月日().isEmpty()) {
            div.getTxtShinseiYMD().setValue(new RDate(住宅改修理由書事業者情報.getDbT3096().get申請年月日().toString()));
        }
        if (住宅改修理由書事業者情報.getDbT3096().get請求情報作成日() != null) {
            div.getTxtSeikyuSakuseiYMD().setValue(new RDate(住宅改修理由書事業者情報.getDbT3096().get請求情報作成日().toString()));
        }
        if (住宅改修理由書事業者情報.getDbT3096().get識別コード() != null) {
            div.getTxtHdnShikibetsuCode().setValue(住宅改修理由書事業者情報.getDbT3096().get識別コード().value());
        }
        if (住宅改修理由書事業者情報.getDbT3096().get介護住宅改修理由書作成事業者番号() != null) {
            div.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaNo().setValue(住宅改修理由書事業者情報.getDbT3096().
                    get介護住宅改修理由書作成事業者番号().value());
        }
        if (住宅改修理由書事業者情報.getDbT3096().get介護住宅改修事業者名称() != null) {
            div.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaName().setValue(住宅改修理由書事業者情報.getDbT3096().
                    get介護住宅改修事業者名称().value());
        }
        FlexibleDate kijunYMD = FlexibleDate.getNowDate();
        if (住宅改修理由書事業者情報.getDbT3096().get金融機関コード() != null && 住宅改修理由書事業者情報.getDbT3096().get支店コード() != null) {
            RString 金融機関コード = 住宅改修理由書事業者情報.getDbT3096().get金融機関コード();
            RString 支店コード = 住宅改修理由書事業者情報.getDbT3096().get支店コード();
            KinyuKikan kinyuKikan = new KinyuKikan(new KinyuKikanCode(金融機関コード), kijunYMD);
            KinyuKikanShiten kinyuKikanShiten = new KinyuKikanShiten(kinyuKikan.get金融機関コード(), new KinyuKikanShitenCode(支店コード), kijunYMD);
            div.getJutakuTesuryoSeikyuShosaiPanel().getCcdKinyuKikanInput().set金融機関(kinyuKikan.createBuilderForEdit().
                    set金融機関支店(kinyuKikanShiten).build(), kinyuKikanShiten.get支店コード(), kijunYMD);
            div.getJutakuTesuryoSeikyuShosaiPanel().getCcdKinyuKikanInput().search(kinyuKikan.get金融機関コード(), new KinyuKikanShitenCode(支店コード), kijunYMD);
        }
        if (住宅改修理由書事業者情報.getDbT3096().get口座種別() != null) {
            div.getJutakuTesuryoSeikyuShosaiPanel().getDdlKozaShubetsu().setSelectedKey(住宅改修理由書事業者情報.getDbT3096().get口座種別());
        }
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNo().setValue(住宅改修理由書事業者情報.getDbT3096().get口座番号());
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNameKana().setValue(住宅改修理由書事業者情報.getDbT3096().get口座名義人());
        div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaName().setValue(住宅改修理由書事業者情報.getDbT3096().get口座名義人カナ());

    }

    private void set請求情報明細一覧(SeikyuShinsaShuseiTorokuBusiness 事業者情報明細, List<dgSeikyuMeisai_Row> rowList) {
        dgSeikyuMeisai_Row 明細一覧 = new dgSeikyuMeisai_Row();
        明細一覧.setChkTaishogaiFlag(new DataGridColumnCheckBox(事業者情報明細.getDbT3095().is対象外フラグ()));
        if (削除.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            明細一覧.getChkTaishogaiFlag().setDisabled(true);
            div.getJutakuTesuryoSeikyuShosaiPanel().setDisabled(true);
        }
        if (照会.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存ボタン, true);
            div.getJutakuTesuryoSeikyuShosaiPanel().setDisabled(true);
            明細一覧.getChkTaishogaiFlag().setDisabled(true);
        }
        if (事業者情報明細.getDbT3095().get被保険者番号() != null) {
            明細一覧.setHihokenshaNo(事業者情報明細.getDbT3095().get被保険者番号().value());
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修住宅所有者() != null) {
            明細一覧.setHihokenshaShimei(事業者情報明細.getDbT3095().get介護住宅改修住宅所有者().value());
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修理由書作成年月日() != null) {
            TextBoxDate 理由書作成年月日 = new TextBoxDate();
            理由書作成年月日.setValue(new RDate(事業者情報明細.getDbT3095().get介護住宅改修理由書作成年月日().toString()));
            明細一覧.setRiyushoSakuseiYMD(理由書作成年月日);
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修理由書作成者名() != null) {
            明細一覧.setRiyushoSakuseishaMei(事業者情報明細.getDbT3095().get介護住宅改修理由書作成者名().value());
        }
        if (事業者情報明細.getDbT3095().get支給申請年月日() != null) {
            TextBoxDate 支給申請年月日 = new TextBoxDate();
            支給申請年月日.setValue(new RDate(事業者情報明細.getDbT3095().get支給申請年月日().toString()));
            明細一覧.setShikyushinseiYMD(支給申請年月日);
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修着工年月日() != null) {
            TextBoxDate 着工年月日 = new TextBoxDate();
            着工年月日.setValue(new RDate(事業者情報明細.getDbT3095().get介護住宅改修着工年月日().toString()));
            明細一覧.setChakkoYMD(着工年月日);
        }
        rowList.add(明細一覧);
    }

    /**
     * 明細照会一覧です
     *
     */
    public void get明細照会一覧() {
        int index = div.getDgSeikyuMeisai().getClickedRowId();
        SeikyuShinsaShuseiTorokuBusiness 事業者情報明細 = ViewStateHolder.
                get(ViewStateKeys.住宅改修理由書事業者情報明細, SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(index);
        div.getSeikyuMeisaiShosaiPanel().getTxtHihokenshaNo().setValue(事業者情報明細.getDbT3095().get被保険者番号().value());
        div.getSeikyuMeisaiShosaiPanel().getTxtHihokenshaName().setValue(事業者情報明細.getDbT3095().get介護住宅改修住宅所有者().value());
        if (事業者情報明細.getDbT3095().get介護住宅改修理由書作成年月日() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseiYMD().setValue(new RDate(事業者情報明細
                    .getDbT3095().get介護住宅改修理由書作成年月日().toString()));
        }
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMeiKana().
                setValue(事業者情報明細.getDbT3095().get介護住宅改修理由書作成者名カナ());
        if (事業者情報明細.getDbT3095().get介護住宅改修理由書作成者名() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMei().setValue(事業者情報明細
                    .getDbT3095().get介護住宅改修理由書作成者名().value());
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修理由書作成申請年月日() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD().setValue(new RDate(事業者情報明細
                    .getDbT3095().get介護住宅改修理由書作成申請年月日().toString()));
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修着工年月日() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD().setValue(new RDate(事業者情報明細
                    .getDbT3095().get介護住宅改修着工年月日().toString()));
        }
        if (事業者情報明細.getDbT3095().get介護住宅改修事業者名称() != null) {
            div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho().
                    setValue(事業者情報明細.getDbT3095().get介護住宅改修事業者名称().value());
        }
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho().
                setValue(事業者情報明細.getDbT3095().get改修対象住宅住所());
        div.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo().
                setValue(事業者情報明細.getDbT3095().get改修内容_箇所及び規模());
        div.getTxtRiyushoSakuseiTanka().setValue(事業者情報明細.getDbT3096().get介護住宅改修理由書作成単価());
        div.getTxtRiyushoSakuseiKensu().setValue(事業者情報明細.getDbT3096().get介護住宅改修理由書作成件数());
        div.getTxtRiyushoSakuseiSeikyuKingaku().setValue(事業者情報明細.getDbT3096().get介護住宅改修理由書作成請求金額());
    }

    /**
     * 修正更新の状態です
     *
     * @param 住宅改修理由書事業者明細情報 住宅改修理由書事業者明細情報
     * @return SeikyuShinsaShuseiTorokuBusiness SeikyuShinsaShuseiTorokuBusiness
     */
    public SeikyuShinsaShuseiTorokuBusiness 修正更新(SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者明細情報) {
        JutakuKaishuRiyushoTesuryoKettei 出力決定 = 住宅改修理由書事業者明細情報.getDbT3094();
        JutakuKaishuRiyushoTesuryoMeisai 出力明細 = 住宅改修理由書事業者明細情報.getDbT3095();
        JutakuKaishuRiyushoTesuryoShukei 出力集計 = 住宅改修理由書事業者明細情報.getDbT3096();
        if (div.getDgSeikyuMeisai().getActiveRow() != null) {
            出力明細 = 出力明細.createBuilderForEdit().set対象外フラグ(div.getDgSeikyuMeisai().getActiveRow().getChkTaishogaiFlag().isValue()).build();
        }
        出力集計 = 集計更新(出力集計);
        出力明細 = 出力明細.modifiedModel();
        出力集計 = 出力集計.modifiedModel();
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID()) && 出力決定 != null) {
            出力決定 = 決定更新(出力決定);
            出力決定 = 出力決定.modifiedModel();
        } else if (DBCMNE_1005.equals(ResponseHolder.getMenuID()) && 出力決定 == null) {
            int index = div.getDgSeikyuMeisai().getClickedRowId();
            if (index == -1) {
                index = index + 1;
            }
            SeikyuShinsaShuseiTorokuBusiness 事業者情報明細 = ViewStateHolder.get(ViewStateKeys.住宅改修理由書事業者情報明細,
                    SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(index);
            ShoKisaiHokenshaNo 証記載保険者番号 = ShoKisaiHokenshaNo.EMPTY;
            JigyoshaNo 事業者番号 = JigyoshaNo.EMPTY;
            RString 集計関連付け番号 = RString.EMPTY;
            if (!事業者情報明細.getDbT3096().get証記載保険者番号().isEmpty() && 事業者情報明細.getDbT3096().get証記載保険者番号() != null) {
                証記載保険者番号 = new ShoKisaiHokenshaNo(事業者情報明細.getDbT3096().get証記載保険者番号().value().toString());
            }
            if (!事業者情報明細.getDbT3096().get介護住宅改修理由書作成事業者番号().isEmpty() && 事業者情報明細.getDbT3096().get介護住宅改修理由書作成事業者番号() != null) {
                事業者番号 = new JigyoshaNo(事業者情報明細.getDbT3096().get介護住宅改修理由書作成事業者番号().value().toString());
            }
            if (!事業者情報明細.getDbT3096().get集計関連付け番号().isEmpty()) {
                集計関連付け番号 = 事業者情報明細.getDbT3096().get集計関連付け番号();
            }
            出力決定 = new JutakuKaishuRiyushoTesuryoKettei(証記載保険者番号, 事業者番号, 集計関連付け番号, Decimal.ZERO);
            出力決定 = 決定追加(出力決定, 事業者情報明細);
        }
        SeikyuShinsaShuseiTorokuBusiness businessResult = new SeikyuShinsaShuseiTorokuBusiness();
        businessResult.setDbT3094(出力決定);
        businessResult.setDbT3095(出力明細);
        businessResult.setDbT3096(出力集計);
        return businessResult;
    }

    private JutakuKaishuRiyushoTesuryoShukei 集計更新(JutakuKaishuRiyushoTesuryoShukei 出力集計) {
        if (div.getTxtShinseiYMD().getValue() != null) {
            出力集計 = 出力集計.createBuilderForEdit().set申請年月日(new FlexibleDate(div.getTxtShinseiYMD().getValue().toString())).build();
        }
        if (div.getTxtUketsukeYMD().getValue() != null) {
            出力集計 = 出力集計.createBuilderForEdit().set受付年月日(new FlexibleDate(div.getTxtUketsukeYMD().getValue().toString())).build();
        }
        出力集計 = 出力集計.createBuilderForEdit().set識別コード(ShikibetsuCode.EMPTY).build();
        出力集計 = 出力集計.createBuilderForEdit().set介護支払方法区分(ShiharaiHohoKubun.口座払.getコード()).build();
        if (div.getCcdKinyuKikanInput().get金融機関() != null && div.getCcdKinyuKikanInput().get金融機関().get金融機関コード() != null) {
            出力集計 = 出力集計.createBuilderForEdit().set金融機関コード(new RString(div.getCcdKinyuKikanInput().get金融機関().
                    get金融機関コード().toString())).build();
        }
        if (div.getCcdKinyuKikanInput().get金融機関支店() != null && div.getCcdKinyuKikanInput().get金融機関支店().get支店コード() != null) {
            出力集計 = 出力集計.createBuilderForEdit().set支店コード(new RString(div.getCcdKinyuKikanInput().get金融機関支店().
                    get支店コード().toString())).build();
        }
        if (div.getTxtSeikyuSakuseiYMD().getValue() != null) {
            出力集計 = 出力集計.createBuilderForEdit().set請求情報作成日(new FlexibleDate(div.getTxtSeikyuSakuseiYMD().getValue().toString())).build();
        }
        出力集計 = 出力集計.createBuilderForEdit().set口座種別(div.getDdlKozaShubetsu().getSelectedKey()).build();
        if (div.getTxtKozaNo().getValue() != null) {
            出力集計 = 出力集計.createBuilderForEdit().set口座番号(div.getTxtKozaNo().getValue()).build();
        }
        if (div.getTxtKozaName().getValue() != null) {
            出力集計 = 出力集計.createBuilderForEdit().set口座名義人(div.getTxtKozaName().getValue()).build();
        }
        if (div.getTxtKozaNameKana().getValue() != null) {
            出力集計 = 出力集計.createBuilderForEdit().set口座名義人カナ(div.getTxtKozaNameKana().getValue()).build();
        }
        出力集計 = 出力集計.createBuilderForEdit().set口座ID(Decimal.ZERO).build();
        return 出力集計;
    }

    private JutakuKaishuRiyushoTesuryoKettei 決定更新(JutakuKaishuRiyushoTesuryoKettei 出力決定) {
        if (div.getTxtJigyoshaNo().getValue() != null) {
            出力決定 = 出力決定.createBuilderForEdit().set介護住宅改修理由書作成事業者番号(new JigyoshaNo(div.getTxtJigyoshaNo().getValue().
                    toString())).build();
        }
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
        return 出力決定;
    }

    private JutakuKaishuRiyushoTesuryoKettei 決定追加(JutakuKaishuRiyushoTesuryoKettei 出力決定, SeikyuShinsaShuseiTorokuBusiness 事業者情報明細) {
        出力決定.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(事業者情報明細.getDbT3096().get証記載保険者番号().value().toString())).build();
        if (div.getTxtJigyoshaNo().getValue() != null) {
            出力決定 = 出力決定.createBuilderForEdit().set介護住宅改修理由書作成事業者番号(new JigyoshaNo(div.getTxtJigyoshaNo().getValue().
                    toString())).build();
        }
        if (事業者情報明細.getDbT3096().get集計関連付け番号() != null) {
            出力決定 = 出力決定.createBuilderForEdit().set集計関連付け番号(事業者情報明細.getDbT3096().get集計関連付け番号()).build();
        }
        出力決定 = 出力決定.createBuilderForEdit().set履歴番号(Decimal.ONE).build();
        if (div.getTxtKetteiYMD().getValue() != null) {
            出力決定 = 出力決定.createBuilderForEdit().set支給_不支給決定年月日(new FlexibleDate(div.getTxtKetteiYMD().
                    getValue().toString())).build();
        }
        出力決定 = 出力決定.createBuilderForEdit().set支給_不支給区分(div.getRadShikyuFushikyuKubun().getSelectedKey()).build();
        出力決定 = 出力決定.createBuilderForEdit().set償還不支給理由等(div.getTxtFushikyuRiyu().getValue()).build();
        if (div.getTxtTesuryoShiharaiYoteiYMD().getValue() != null) {
            出力決定 = 出力決定.createBuilderForEdit().set住宅改修理由書作成手数料支払予定日(new FlexibleDate(div.getTxtTesuryoShiharaiYoteiYMD().
                    getValue().toString())).build();
        }
        出力決定 = 出力決定.createBuilderForEdit().set決定通知書作成年月日(FlexibleDate.EMPTY).build();
        出力決定 = 出力決定.createBuilderForEdit().set振込通知書作成年月日(FlexibleDate.EMPTY).build();
        return 出力決定;
    }

    /**
     * 削除更新の状態です
     *
     * @param business SeikyuShinsaShuseiTorokuBusiness business
     * @return SeikyuShinsaShuseiTorokuBusiness
     */
    public SeikyuShinsaShuseiTorokuBusiness 削除更新(SeikyuShinsaShuseiTorokuBusiness business) {
        int index = div.getDgSeikyuMeisai().getClickedRowId();
        if (index == -1) {
            index = index + 1;
        }
        SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者明細情報 = ViewStateHolder.get(ViewStateKeys.住宅改修理由書事業者情報明細,
                SeikyuShinsaShuseiTorokuCollect.class
        ).get事業者情報List().get(index);
        JutakuKaishuRiyushoTesuryoKettei 出力決定 = 住宅改修理由書事業者明細情報.getDbT3094();
        JutakuKaishuRiyushoTesuryoMeisai 出力明細 = 住宅改修理由書事業者明細情報.getDbT3095();
        JutakuKaishuRiyushoTesuryoShukei 出力集計 = 住宅改修理由書事業者明細情報.getDbT3096();
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
        div.getTxtUketsukeYMD().clearValue();
        div.getTxtShinseiYMD().clearValue();
        div.getTxtSeikyuSakuseiYMD().clearValue();
        div.getTxtHdnShikibetsuCode().clearValue();
    }

    /**
     * 請求単価チェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs 請求単価チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new SeikyuShinsaShuseiTorokuHandler.IdocheckMessages(UrErrorMessages.必須,
                    請求単位.toString())));
        }
        return validPairs;
    }

    /**
     * 決定区分チェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs 決定区分チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID())) {
            if (KEY_0.equals(div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().getSelectedKey())) {
                validPairs = 支給決定チェック(validPairs);
            }
            if (KEY_1.equals(div.getJutakuTesuryoSeikyuKetteiPanel().getRadShikyuFushikyuKubun().getSelectedKey())) {
                validPairs = 不支給決定チェック(validPairs);
            }
        }
        return validPairs;
    }

    private ValidationMessageControlPairs 支給決定チェック(ValidationMessageControlPairs validPairs) {
        if (div.getJutakuTesuryoSeikyuShosaiPanel().getDdlKozaShubetsu().getSelectedKey().isEmpty()
                && div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNo().getValue().isEmpty()
                && div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNameKana().getValue().isEmpty()
                && div.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaName().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new SeikyuShinsaShuseiTorokuHandler.IdocheckMessages(UrErrorMessages.必須,
                    支給決定.toString())));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs 不支給決定チェック(ValidationMessageControlPairs validPairs) {
        if (div.getTxtFushikyuRiyu().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new SeikyuShinsaShuseiTorokuHandler.IdocheckMessages(UrErrorMessages.必須,
                    不支給決定.toString())));
        }
        return validPairs;
    }

    /**
     * 請求情報集計パネルの変更を行う。
     *
     * @return rowSize 対象外CHK
     */
    public int 対象外CHK() {
        int rowSize = 0;
        for (dgSeikyuMeisai_Row row : div.getDgSeikyuMeisai().getDataSource()) {
            if (row.getChkTaishogaiFlag().isValue()) {
                rowSize++;
            }
        }
        return rowSize;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
