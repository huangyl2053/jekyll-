/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ5100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei.YouKaiGoNinTeiShinJyuKyuParameter;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei.YouKaiGoNinTeiShinNiTeiParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.dgKensakuKekkaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定申請情報検索クラスです。
 *
 * @reamsid_L DBZ-1300-150 houtianpeng
 */
public class KaigoNinteiShinseiKensakuHandler {

    private final KaigoNinteiShinseiKensakuDiv div;

    private final RString 施設入所_あり = new RString("key0");
    private static final RString 戻るボタン = new RString("btnCommonModoru");
    private static final RString 再検索 = new RString("btnResearch");
    private static final RString 検索 = new RString("btnSearch");
    private static final RString 検索状態 = new RString("検索状態");

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定申請情報検索Div
     */
    public KaigoNinteiShinseiKensakuHandler(KaigoNinteiShinseiKensakuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     *
     */
    public void initialize() {
        div.getCcdNinteiShinseishaFinder().initialize();
    }

    /**
     * 状態の設定。
     *
     * @param 受給認定 GyomuBunrui
     * @param 状態フラグ RString
     */
    public void setJyoTai(GyomuBunrui 受給認定, RString 状態フラグ) {

        if (GyomuBunrui.介護事務.equals(受給認定)) {

            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(戻るボタン, true);
        }
        if (検索状態.equals(状態フラグ)) {

            div.getKensakuKekka().setDisplayNone(false);
            div.getCcdNinteiShinseishaFinder().setDisplayNone(true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索, false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索, true);
        } else {

            div.getKensakuKekka().setDisplayNone(true);
            div.getCcdNinteiShinseishaFinder().setDisplayNone(false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索, true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索, false);
        }
    }

    /**
     * 介護認定申請情報受給にグリッドを設定します。
     *
     * @param 介護認定申請情報受給 介護認定申請情報受給
     */
    public void 介護認定申請情報受給_グリッドの設定(SearchResult<HokenshaNinteiShinseiJoho> 介護認定申請情報受給) {

        List<dgKensakuKekkaIchiran_Row> dgKensakuKekkaIchiranList = new ArrayList();
        int 検索件数 = 0;
        if (div.getTxtMaxKensu().getValue() != null) {
            検索件数 = div.getTxtMaxKensu().getValue().intValue();
        }
        if (!介護認定申請情報受給.records().isEmpty()) {

            int rowSize;
            if (介護認定申請情報受給.records().size() < 検索件数) {
                rowSize = 介護認定申請情報受給.records().size();
            } else {
                rowSize = 検索件数;
            }
            for (int i = 0; i < rowSize; i++) {

                HokenshaNinteiShinseiJoho shinseiJoho = 介護認定申請情報受給.records().get(i);
                dgKensakuKekkaIchiran_Row dgJigyoshaItiran = new dgKensakuKekkaIchiran_Row();
                dgJigyoshaItiran.setHihokenshaNo(nullTOEmpty(shinseiJoho.get被保険者番号()));
                if (shinseiJoho.get被保険者氏名() != null) {
                    dgJigyoshaItiran.setShimei(nullTOEmpty(shinseiJoho.get被保険者氏名().value()));
                }
                dgJigyoshaItiran.setHihokenshaKubun(shinseiJoho.get被保険者区分コード());
                RString 性別 = RString.EMPTY;
                if (Seibetsu.男.getコード().
                        equals(shinseiJoho.get性別().value())) {
                    性別 = Seibetsu.男.get名称();
                } else if (Seibetsu.女.getコード().
                        equals(shinseiJoho.get性別().value())) {
                    性別 = Seibetsu.女.get名称();
                }
                dgJigyoshaItiran.setSeibetsu(性別);
                if (shinseiJoho.get生年月日() != null
                        && !shinseiJoho.get生年月日().isEmpty()) {
                    dgJigyoshaItiran.getBirthYMD().setValue(new RDate(介護認定申請情報受給.
                            records().get(i).get生年月日().toString()));
                }
                if (shinseiJoho.get郵便番号() != null) {
                    dgJigyoshaItiran.setYubinNo(shinseiJoho.get郵便番号().value());
                }
                if (shinseiJoho.get住所() != null) {
                    dgJigyoshaItiran.setJusho(shinseiJoho.get住所().value());
                }
                if (shinseiJoho.get申請書管理番号() != null
                        && !shinseiJoho.get申請書管理番号().isEmpty()) {
                    dgJigyoshaItiran.setShinseishoKnriNo(shinseiJoho.get申請書管理番号().value());
                }
                dgKensakuKekkaIchiranList.add(dgJigyoshaItiran);
            }
            DataGridSetting dataGrid = div.getDgKensakuKekkaIchiran().getGridSetting();
            dataGrid.setLimitRowCount(検索件数);
            dataGrid.setSelectedRowCount(介護認定申請情報受給.totalCount());
            div.getDgKensakuKekkaIchiran().setGridSetting(dataGrid);
            div.getDgKensakuKekkaIchiran().setDataSource(dgKensakuKekkaIchiranList);
            div.getBtnJokenClear().setDisplayNone(true);
            div.getTxtMaxKensu().setDisplayNone(true);
        } else {
            div.getDgKensakuKekkaIchiran().setDataSource(dgKensakuKekkaIchiranList);
        }
    }

    /**
     * 介護認定申請情報認定にグリッドを設定します。
     *
     * @param 介護認定申請情報認定 介護認定申請情報認定
     */
    public void 介護認定申請情報認定_グリッドの設定(SearchResult<NinteiShinseiJoho> 介護認定申請情報認定) {

        List<dgKensakuKekkaIchiran_Row> dgKensakuKekkaIchiranList = new ArrayList();
        int 検索件数 = 0;
        if (div.getTxtMaxKensu().getValue() != null) {
            検索件数 = div.getTxtMaxKensu().getValue().intValue();
        }
        if (!介護認定申請情報認定.records().isEmpty()) {

            int rowSize;
            if (介護認定申請情報認定.records().size() < 検索件数) {
                rowSize = 介護認定申請情報認定.records().size();
            } else {
                rowSize = 検索件数;
            }
            for (int i = 0; i < rowSize; i++) {

                NinteiShinseiJoho shinseiJoho = 介護認定申請情報認定.records().get(i);
                dgKensakuKekkaIchiran_Row dgJigyoshaItiran = new dgKensakuKekkaIchiran_Row();
                dgJigyoshaItiran.setHihokenshaNo(nullTOEmpty(shinseiJoho.get被保険者番号()));
                if (shinseiJoho.get被保険者氏名() != null) {
                    dgJigyoshaItiran.setShimei(nullTOEmpty(shinseiJoho.get被保険者氏名().value()));
                }
                dgJigyoshaItiran.setHihokenshaKubun(shinseiJoho.get被保険者区分コード());
                RString 性別 = RString.EMPTY;
                if (Seibetsu.男.getコード().toString().
                        equals(shinseiJoho.get性別().toString())) {
                    性別 = Seibetsu.男.get名称();
                } else if (Seibetsu.女.getコード().toString().
                        equals(shinseiJoho.get性別().toString())) {
                    性別 = Seibetsu.女.get名称();
                }
                dgJigyoshaItiran.setSeibetsu(性別);
                if (shinseiJoho.get生年月日() != null
                        && !shinseiJoho.get生年月日().isEmpty()) {
                    dgJigyoshaItiran.getBirthYMD().setValue(new RDate(介護認定申請情報認定.
                            records().get(i).get生年月日().toString()));
                }
                if (shinseiJoho.get郵便番号() != null) {
                    dgJigyoshaItiran.setYubinNo(shinseiJoho.get郵便番号().value());
                }
                if (shinseiJoho.get住所() != null) {
                    dgJigyoshaItiran.setJusho(shinseiJoho.get住所().value());
                }
                if (shinseiJoho.get申請書管理番号() != null
                        && !shinseiJoho.get申請書管理番号().isEmpty()) {
                    dgJigyoshaItiran.setShinseishoKnriNo(shinseiJoho.get申請書管理番号().value());
                }
                dgKensakuKekkaIchiranList.add(dgJigyoshaItiran);
            }
            DataGridSetting dataGrid = div.getDgKensakuKekkaIchiran().getGridSetting();
            dataGrid.setLimitRowCount(検索件数);
            dataGrid.setSelectedRowCount(介護認定申請情報認定.totalCount());
            div.getDgKensakuKekkaIchiran().setGridSetting(dataGrid);
            div.getDgKensakuKekkaIchiran().setDataSource(dgKensakuKekkaIchiranList);
            div.getBtnJokenClear().setDisplayNone(true);
            div.getTxtMaxKensu().setDisplayNone(true);
        } else {

            div.getDgKensakuKekkaIchiran().setDataSource(dgKensakuKekkaIchiranList);
        }
    }

    /**
     * 介護認定申請情報受給Parameterの設定。
     *
     * @return YouKaiGoNinTeiShinParameter 介護認定申請情報受給Parameter
     */
    public YouKaiGoNinTeiShinJyuKyuParameter 介護認定申請情報受給Parameter() {

        int 認定有効期間 = 0;
        NinteiShinseishaFinderDiv finderDiv = div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv();
        if (!RString.isNullOrEmpty(finderDiv.
                getTxtZenkaiNinteiYukoKikan().getValue())) {
            認定有効期間 = Integer.valueOf(finderDiv.
                    getTxtZenkaiNinteiYukoKikan().getValue().toString());
        }
        int 検索件数 = 0;
        if (div.getTxtMaxKensu().getValue() != null) {
            検索件数 = div.getTxtMaxKensu().getValue().intValue();
        }
        return YouKaiGoNinTeiShinJyuKyuParameter.
                createParam_受給(
                        finderDiv.getTxtHihokenshaNumber().getValue(),
                        finderDiv.getDdlHokenshaNumber().
                        getSelectedItem().get証記載保険者番号().value(),
                        finderDiv.getDdlShichosonCode().getSelectedKey(),
                        finderDiv.getTxtHihokenshaName().getValue(),
                        finderDiv.getDdlHihokenshaNameMatchType().getSelectedKey(),
                        !finderDiv.getChkMinashiFlag().getSelectedKeys().isEmpty(),
                        finderDiv.getTxtNinteiShinseiDateFrom().getValue(),
                        finderDiv.getTxtNinteiShinseiDateTo().getValue(),
                        finderDiv.getTxtBirthDateFrom().getValue(),
                        finderDiv.getTxtBirthDateTO().getValue(),
                        new Code(finderDiv.getDdlShinseijiShinseiKubun().getSelectedKey()),
                        性別男の取得(),
                        性別女の取得(),
                        finderDiv.getDdlHihokenshaKubun().getSelectedKey(),
                        new Code(finderDiv.getDdlHoreiShinseiji().getSelectedKey()),
                        new Code(finderDiv.getDdlShoriKubun().getSelectedKey()),
                        finderDiv.getTxtYubinNo().getValue(),
                        new ChikuCode(finderDiv.getDdlChiku().getSelectedKey()),
                        施設入所_あり.equals(div.getCcdNinteiShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getRadShisetsuNyusho().getSelectedKey()),
                        finderDiv.getTxtNinteiChosaItakusakiName().getValue(),
                        finderDiv.getTxtNinteiChosainName().getValue(),
                        new Code(finderDiv.getDdlChosaJisshiBasho().getSelectedKey()),
                        new Code(finderDiv.getDdlChosaKubun().getSelectedKey()),
                        finderDiv.getTxtChosaJisshiDateFrom().getValue(),
                        finderDiv.getTxtChosaJisshiDateTo().getValue(),
                        new Code(finderDiv.getDdlNinteiChosaNetakirido().getSelectedKey()),
                        new Code(finderDiv.getDdlNinteiChosaNinchido().getSelectedKey()),
                        finderDiv.getTxtShujiiIryokikanName().getValue(),
                        finderDiv.getTxtShujiiName().getValue(),
                        new Code(finderDiv.getDdlShujiIkubun().getSelectedKey()),
                        finderDiv.getTxtIkenshoKinyuDateFrom().getValue(),
                        finderDiv.getTxtIkenshoKinyuDateTo().getValue(),
                        finderDiv.getDdlShujiJohoNetakirido().getSelectedKey(),
                        finderDiv.getDdlShujiJohoNinchido().getSelectedKey(),
                        finderDiv.getTxtIchijiHanteiDateFrom().getValue(),
                        finderDiv.getTxtIchijiHanteiDateTo().getValue(),
                        new Code(finderDiv.getDdlIchijiHanteiKekka().getSelectedKey()),
                        finderDiv.getTxtZenkaiNinteiChosaItakusakiName().getValue(),
                        finderDiv.getTxtZenkaiShujiiIryokikanName().getValue(),
                        new Code(finderDiv.getDdlZenkaiNijiHanteiKekka().getSelectedKey()),
                        認定有効期間,
                        finderDiv.getTxtZenkaiYukoKaishiDateFrom().getValue(),
                        finderDiv.getTxtZenkaiYukoKaishiDateTo().getValue(),
                        !finderDiv.getChkTsuchiShori().getSelectedKeys().isEmpty(),
                        検索件数);
    }

    /**
     * 介護認定申請情報認定Parameterの設定。
     *
     * @return YouKaiGoNinTeiShinParameter 介護認定申請情報認定Parameter
     */
    public YouKaiGoNinTeiShinNiTeiParameter 介護認定申請情報認定Parameter() {

        int 認定有効期間 = 0;
        NinteiShinseishaFinderDiv finderDiv = div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv();
        if (!RString.isNullOrEmpty(finderDiv.
                getTxtNinteiYukoKikan().getValue())) {
            認定有効期間 = Integer.valueOf(finderDiv.
                    getTxtNinteiYukoKikan().getValue().toString());
        }
        int 前回認定有効期間 = 0;
        if (!RString.isNullOrEmpty(finderDiv.
                getTxtZenkaiNinteiYukoKikan().getValue())) {
            前回認定有効期間 = Integer.valueOf(finderDiv.
                    getTxtZenkaiNinteiYukoKikan().getValue().toString());
        }
        int 経過日数Form = 0;
        if (finderDiv
                .getTxtShinseiKeikaNissu().getFromValue() != null) {
            経過日数Form = finderDiv
                    .getTxtShinseiKeikaNissu().getFromValue().intValue();
        }
        int 経過日数To = 0;
        if (finderDiv
                .getTxtShinseiKeikaNissu().getToValue() != null) {
            経過日数To = finderDiv
                    .getTxtShinseiKeikaNissu().getToValue().intValue();
        }
        int 検索件数 = 0;
        if (div.getTxtMaxKensu().getValue() != null) {
            検索件数 = div.getTxtMaxKensu().getValue().intValue();
        }
        return YouKaiGoNinTeiShinNiTeiParameter.
                createParam_認定(
                        finderDiv.getTxtHihokenshaNumber().getValue(),
                        finderDiv.getDdlHokenshaNumber().
                        getSelectedItem().get証記載保険者番号().value(),
                        finderDiv.getDdlShichosonCode().getSelectedKey(),
                        finderDiv.getTxtHihokenshaName().getValue(),
                        finderDiv.getDdlHihokenshaNameMatchType().getSelectedKey(),
                        !finderDiv.getChkMinashiFlag().getSelectedKeys().isEmpty(),
                        finderDiv.getTxtNinteiShinseiDateFrom().getValue(),
                        finderDiv.getTxtNinteiShinseiDateTo().getValue(),
                        finderDiv.getTxtBirthDateFrom().getValue(),
                        finderDiv.getTxtBirthDateTO().getValue(),
                        new Code(finderDiv.getDdlShinseijiShinseiKubun().getSelectedKey()),
                        性別男の取得(),
                        性別女の取得(),
                        finderDiv.getDdlHihokenshaKubun().getSelectedKey(),
                        new Code(finderDiv.getDdlHoreiShinseiji().getSelectedKey()),
                        new Code(finderDiv.getDdlShoriKubun().getSelectedKey()),
                        finderDiv.getTxtYubinNo().getValue(),
                        new ChikuCode(finderDiv.getDdlChiku().getSelectedKey()),
                        施設入所_あり.equals(div.getCcdNinteiShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getRadShisetsuNyusho().getSelectedKey()),
                        finderDiv.getTxtNinteiChosaItakusakiName().getValue(),
                        finderDiv.getTxtNinteiChosainName().getValue(),
                        new Code(finderDiv.getDdlChosaJisshiBasho().getSelectedKey()),
                        new Code(finderDiv.getDdlChosaKubun().getSelectedKey()),
                        finderDiv.getTxtChosaJisshiDateFrom().getValue(),
                        finderDiv.getTxtChosaJisshiDateTo().getValue(),
                        new Code(finderDiv.getDdlNinteiChosaNetakirido().getSelectedKey()),
                        new Code(finderDiv.getDdlNinteiChosaNinchido().getSelectedKey()),
                        finderDiv.getTxtShujiiIryokikanName().getValue(),
                        finderDiv.getTxtShujiiName().getValue(),
                        new Code(finderDiv.getDdlShujiIkubun().getSelectedKey()),
                        finderDiv.getTxtIkenshoKinyuDateFrom().getValue(),
                        finderDiv.getTxtIkenshoKinyuDateTo().getValue(),
                        finderDiv.getDdlShujiJohoNetakirido().getSelectedKey(),
                        finderDiv.getDdlShujiJohoNinchido().getSelectedKey(),
                        finderDiv.getTxtIchijiHanteiDateFrom().getValue(),
                        finderDiv.getTxtIchijiHanteiDateTo().getValue(),
                        new Code(finderDiv.getDdlIchijiHanteiKekka().getSelectedKey()),
                        finderDiv.getTxtIchiGoHanteiDateFrom().getValue(),
                        finderDiv.getTxtIchiGoHanteiDateTo().getValue(),
                        new Code(finderDiv.getDdlIchiGohanteiKekka().getSelectedKey()),
                        new Code(finderDiv.getDdlNijiHanteiKekka().getSelectedKey()),
                        認定有効期間,
                        finderDiv.getTxtNinteiYukoKaishiDateFrom().getValue(),
                        finderDiv.getTxtNinteiYukoKaishiDateTo().getValue(),
                        finderDiv.getTxtNinteiYukoShuryoDateFrom().getValue(),
                        finderDiv.getTxtNinteiYukoShuryoDate().getValue(),
                        finderDiv.getTxtNijiHanteiDateFrom().getValue(),
                        finderDiv.getTxtNijiHnateiDateTo().getValue(),
                        finderDiv.getTxtKaisaiDateFrom().getValue(),
                        finderDiv.getTxtKaisaiDateTo().getValue(),
                        finderDiv.getTxtKaisaiNumberStart().getValue(),
                        finderDiv.getTxtKaisaiNumberEnd().getValue(),
                        finderDiv.getTxtZenkaiNinteiChosaItakusakiName().getValue(),
                        finderDiv.getTxtZenkaiShujiiIryokikanName().getValue(),
                        new Code(finderDiv.getDdlZenkaiNijiHanteiKekka().getSelectedKey()),
                        前回認定有効期間,
                        finderDiv.getTxtZenkaiYukoKaishiDateFrom().getValue(),
                        finderDiv.getTxtZenkaiYukoKaishiDateTo().getValue(),
                        finderDiv.getCdlGeninShikkanCode().getCode(),
                        FlexibleDate.getNowDate().plusDay(経過日数Form),
                        FlexibleDate.getNowDate().plusDay(経過日数To),
                        !finderDiv.
                        getChkKoshinTaishoChushutsu().getSelectedKeys().isEmpty(),
                        new Code(NinteiShinseiYukoKubunCode.仮状態.getコード()),
                        !finderDiv.
                        getChkIchijiHantei().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkShinseiUketsuke().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkMasking().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkChosaIrai().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkShinsakaiToroku().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkIkenshoIrai().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkNijiHantei().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkChosaNyushu().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkIkenshoNyushu().getSelectedKeys().isEmpty(),
                        !finderDiv.
                        getChkGetsureiShori().getSelectedKeys().isEmpty(),
                        検索件数);
    }

    private RString nullTOEmpty(RString 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目;
    }

    private Code 性別男の取得() {

        RString 性別_男 = RString.EMPTY;
        for (RString seibetsu : div.getCcdNinteiShinseishaFinder().
                getNinteiShinseishaFinderDiv().getChkSeibetsu().getSelectedValues()) {
            if (Seibetsu.男.get名称().equals(seibetsu)) {
                性別_男 = Seibetsu.男.getコード();
            }
        }
        return new Code(性別_男);
    }

    private Code 性別女の取得() {

        RString 性別_女 = RString.EMPTY;
        for (RString seibetsu : div.getCcdNinteiShinseishaFinder().
                getNinteiShinseishaFinderDiv().getChkSeibetsu().getSelectedValues()) {
            if (Seibetsu.女.get名称().equals(seibetsu)) {
                性別_女 = Seibetsu.女.getコード();
            }
        }
        return new Code(性別_女);
    }
}
