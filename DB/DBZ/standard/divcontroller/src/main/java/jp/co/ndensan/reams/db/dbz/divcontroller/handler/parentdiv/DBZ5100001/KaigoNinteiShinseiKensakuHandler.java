/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ5100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei.YouKaiGoNinTeiShinJyuKyuParameter;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei.YouKaiGoNinTeiShinNiTeiParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.dgKensakuKekkaIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定申請情報検索クラスです。
 *
 * @reamsid_L DBZ-1300-150 houtianpeng
 */
public class KaigoNinteiShinseiKensakuHandler {

    private final KaigoNinteiShinseiKensakuDiv div;

    private final RString 施設入所_あり = new RString("key0");

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
        // TODO QA1366 最近処理者情報の引数が不明です。
        div.getCcdSaikinShorisha().setInitialLoad(new ScopeCode(ScopeCodeType.識別対象.getCode()));
        div.getCcdNinteiShinseishaFinder().initialize();
    }

    /**
     * 画面の検索処理。
     *
     */
    public void kenSaKu() {
        div.getCcdSaikinShorisha().setInitialLoad(new ScopeCode(ScopeCodeType.識別対象.getCode()));
        div.getCcdNinteiShinseishaFinder().initialize();
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
            if (検索件数 > 介護認定申請情報受給.records().size()) {
                rowSize = 介護認定申請情報受給.records().size();
            } else {
                rowSize = 検索件数;
            }
            for (int i = 0; i < rowSize; i++) {

                dgKensakuKekkaIchiran_Row dgJigyoshaItiran = new dgKensakuKekkaIchiran_Row();
                dgJigyoshaItiran.setHihokenshaNo(nullTOEmpty(介護認定申請情報受給.records().get(i).get被保険者番号()));
                if (介護認定申請情報受給.records().get(i).get被保険者氏名() != null) {
                    dgJigyoshaItiran.setShimei(nullTOEmpty(介護認定申請情報受給.records().get(i).get被保険者氏名().value()));
                }
                dgJigyoshaItiran.setHihokenshaKubun(介護認定申請情報受給.records().get(i).get被保険者区分コード());
                RString 性別 = RString.EMPTY;
                if (Seibetsu.男.getコード().
                        equals(介護認定申請情報受給.records().get(i).get性別().value())) {
                    性別 = Seibetsu.男.get名称();
                } else if (Seibetsu.女.getコード().
                        equals(介護認定申請情報受給.records().get(i).get性別().value())) {
                    性別 = Seibetsu.女.get名称();
                }
                dgJigyoshaItiran.setSeibetsu(性別);
                if (介護認定申請情報受給.records().get(i).get生年月日() != null
                        && !介護認定申請情報受給.records().get(i).get生年月日().isEmpty()) {
                    dgJigyoshaItiran.getBirthYMD().setValue(new RDate(介護認定申請情報受給.
                            records().get(i).get生年月日().toString()));
                }
                if (介護認定申請情報受給.records().get(i).get郵便番号() != null) {
                    dgJigyoshaItiran.setYubinNo(介護認定申請情報受給.records().get(i).get郵便番号().value());
                }
                if (介護認定申請情報受給.records().get(i).get住所() != null) {
                    dgJigyoshaItiran.setJusho(介護認定申請情報受給.records().get(i).get住所().value());
                }
                if (介護認定申請情報受給.records().get(i).get申請書管理番号() != null
                        && !介護認定申請情報受給.records().get(i).get申請書管理番号().isEmpty()) {
                    dgJigyoshaItiran.setShinseishoKnriNo(介護認定申請情報受給.records().get(i).get申請書管理番号().value());
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
            if (検索件数 > 介護認定申請情報認定.records().size()) {
                rowSize = 介護認定申請情報認定.records().size();
            } else {
                rowSize = 検索件数;
            }
            for (int i = 0; i < rowSize; i++) {

                dgKensakuKekkaIchiran_Row dgJigyoshaItiran = new dgKensakuKekkaIchiran_Row();
                dgJigyoshaItiran.setHihokenshaNo(nullTOEmpty(介護認定申請情報認定.records().get(i).get被保険者番号()));
                if (介護認定申請情報認定.records().get(i).get被保険者氏名() != null) {
                    dgJigyoshaItiran.setShimei(nullTOEmpty(介護認定申請情報認定.records().get(i).get被保険者氏名().value()));
                }
                dgJigyoshaItiran.setHihokenshaKubun(介護認定申請情報認定.records().get(i).get被保険者区分コード());
                RString 性別 = RString.EMPTY;
                if (Seibetsu.男.getコード().toString().
                        equals(介護認定申請情報認定.records().get(i).get性別().toString())) {
                    性別 = Seibetsu.男.get名称();
                } else if (Seibetsu.女.getコード().toString().
                        equals(介護認定申請情報認定.records().get(i).get性別().toString())) {
                    性別 = Seibetsu.女.get名称();
                }
                dgJigyoshaItiran.setSeibetsu(性別);
                if (介護認定申請情報認定.records().get(i).get生年月日() != null
                        && !介護認定申請情報認定.records().get(i).get生年月日().isEmpty()) {
                    dgJigyoshaItiran.getBirthYMD().setValue(new RDate(介護認定申請情報認定.
                            records().get(i).get生年月日().toString()));
                }
                if (介護認定申請情報認定.records().get(i).get郵便番号() != null) {
                    dgJigyoshaItiran.setYubinNo(介護認定申請情報認定.records().get(i).get郵便番号().value());
                }
                if (介護認定申請情報認定.records().get(i).get住所() != null) {
                    dgJigyoshaItiran.setJusho(介護認定申請情報認定.records().get(i).get住所().value());
                }
                if (介護認定申請情報認定.records().get(i).get申請書管理番号() != null
                        && !介護認定申請情報認定.records().get(i).get申請書管理番号().isEmpty()) {
                    dgJigyoshaItiran.setShinseishoKnriNo(介護認定申請情報認定.records().get(i).get申請書管理番号().value());
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
        if (!div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                getTxtZenkaiNinteiYukoKikan().getValue().isNullOrEmpty()) {
            認定有効期間 = Integer.valueOf(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                    getTxtZenkaiNinteiYukoKikan().getValue().toString());
        }
        int 検索件数 = 0;
        if (div.getTxtMaxKensu().getValue() != null) {
            検索件数 = div.getTxtMaxKensu().getValue().intValue();
        }
        return YouKaiGoNinTeiShinJyuKyuParameter.
                createParam_受給(
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHokenshaNumber().
                        getSelectedItem().get証記載保険者番号().value(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShichosonCode().getSelectedKey(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaName().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHihokenshaNameMatchType().getSelectedKey(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getChkMinashiFlag().getSelectedKeys().isEmpty(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateTo().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtBirthDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtBirthDateTO().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShinseijiShinseiKubun().getSelectedKey()),
                        性別の取得(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHihokenshaKubun().getSelectedKey(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHoreiShinseiji().getSelectedKey()),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShoriKubun().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtYubinNo().getValue(),
                        new ChikuCode(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlChiku().getSelectedKey()),
                        施設入所_あり.equals(div.getCcdNinteiShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getRadShisetsuNyusho().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiChosaItakusakiName().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiChosainName().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlChosaJisshiBasho().getSelectedKey()),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlChosaKubun().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtChosaJisshiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtChosaJisshiDateTo().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlNinteiChosaNetakirido().getSelectedKey()),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlNinteiChosaNinchido().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtShujiiIryokikanName().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtShujiiName().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShujiIkubun().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIkenshoKinyuDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIkenshoKinyuDateTo().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShujiJohoNetakirido().getSelectedKey(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShujiJohoNinchido().getSelectedKey(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIchijiHanteiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIchijiHanteiDateTo().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlIchijiHanteiKekka().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtZenkaiNinteiChosaItakusakiName().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtZenkaiShujiiIryokikanName().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlZenkaiNijiHanteiKekka().getSelectedKey()),
                        認定有効期間,
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtZenkaiYukoKaishiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtZenkaiYukoKaishiDateTo().getValue(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getChkTsuchiShori().getSelectedKeys().isEmpty(),
                        検索件数);
    }

    /**
     * 介護認定申請情報認定Parameterの設定。
     *
     * @return YouKaiGoNinTeiShinParameter 介護認定申請情報認定Parameter
     */
    public YouKaiGoNinTeiShinNiTeiParameter 介護認定申請情報認定Parameter() {

        int 認定有効期間 = 0;
        if (!div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                getTxtNinteiYukoKikan().getValue().isNullOrEmpty()) {
            認定有効期間 = Integer.valueOf(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                    getTxtNinteiYukoKikan().getValue().toString());
        }
        int 前回認定有効期間 = 0;
        if (!div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                getTxtZenkaiNinteiYukoKikan().getValue().isNullOrEmpty()) {
            前回認定有効期間 = Integer.valueOf(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                    getTxtZenkaiNinteiYukoKikan().getValue().toString());
        }
        int 経過日数Form = 0;
        if (div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv()
                .getTxtShinseiKeikaNissu().getFromValue() != null) {
            経過日数Form = div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv()
                    .getTxtShinseiKeikaNissu().getFromValue().intValue();
        }
        int 経過日数To = 0;
        if (div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv()
                .getTxtShinseiKeikaNissu().getFromValue() != null) {
            経過日数To = div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv()
                    .getTxtShinseiKeikaNissu().getToValue().intValue();
        }
        int 検索件数 = 0;
        if (div.getTxtMaxKensu().getValue() != null) {
            検索件数 = div.getTxtMaxKensu().getValue().intValue();
        }
        return YouKaiGoNinTeiShinNiTeiParameter.
                createParam_認定(
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHokenshaNumber().
                        getSelectedItem().get証記載保険者番号().value(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShichosonCode().getSelectedKey(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaName().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHihokenshaNameMatchType().getSelectedKey(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getChkMinashiFlag().getSelectedKeys().isEmpty(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateTo().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtBirthDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtBirthDateTO().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShinseijiShinseiKubun().getSelectedKey()),
                        性別の取得(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHihokenshaKubun().getSelectedKey(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHoreiShinseiji().getSelectedKey()),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShoriKubun().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtYubinNo().getValue(),
                        new ChikuCode(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlChiku().getSelectedKey()),
                        施設入所_あり.equals(div.getCcdNinteiShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getRadShisetsuNyusho().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiChosaItakusakiName().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiChosainName().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlChosaJisshiBasho().getSelectedKey()),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlChosaKubun().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtChosaJisshiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtChosaJisshiDateTo().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlNinteiChosaNetakirido().getSelectedKey()),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlNinteiChosaNinchido().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtShujiiIryokikanName().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtShujiiName().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShujiIkubun().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIkenshoKinyuDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIkenshoKinyuDateTo().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShujiJohoNetakirido().getSelectedKey(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShujiJohoNinchido().getSelectedKey(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIchijiHanteiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIchijiHanteiDateTo().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlIchijiHanteiKekka().getSelectedKey()),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIchiGoHanteiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtIchiGoHanteiDateTo().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlIchiGohanteiKekka().getSelectedKey()),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlNijiHanteiKekka().getSelectedKey()),
                        認定有効期間,
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiYukoKaishiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiYukoKaishiDateTo().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiYukoShuryoDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNinteiYukoShuryoDate().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNijiHanteiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNijiHnateiDateTo().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtKaisaiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtKaisaiDateTo().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtKaisaiNumberStart().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtKaisaiNumberEnd().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtZenkaiNinteiChosaItakusakiName().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtZenkaiShujiiIryokikanName().getValue(),
                        new Code(div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlZenkaiNijiHanteiKekka().getSelectedKey()),
                        前回認定有効期間,
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtZenkaiYukoKaishiDateFrom().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtZenkaiYukoKaishiDateTo().getValue(),
                        div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().getCdlGeninShikkanCode().getCode(),
                        FlexibleDate.getNowDate().plusDay(経過日数Form),
                        FlexibleDate.getNowDate().plusDay(経過日数To),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkKoshinTaishoChushutsu().getSelectedKeys().isEmpty(),
                        new Code(NinteiShinseiYukoKubunCode.仮状態.getコード()),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkIchijiHantei().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkShinseiUketsuke().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkMasking().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkChosaIrai().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkShinsakaiToroku().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkIkenshoIrai().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkNijiHantei().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkChosaNyushu().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkIkenshoNyushu().getSelectedKeys().isEmpty(),
                        !div.getCcdNinteiShinseishaFinder().getNinteiShinseishaFinderDiv().
                        getChkGetsureiShori().getSelectedKeys().isEmpty(),
                        検索件数);
    }

    private RString nullTOEmpty(RString 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目;
    }

    private Code 性別の取得() {

        RString 性別_男 = RString.EMPTY;
        RString 性別_女 = RString.EMPTY;
        RString 性別 = RString.EMPTY;
        for (RString seibetsu : div.getCcdNinteiShinseishaFinder().
                getNinteiShinseishaFinderDiv().getChkSeibetsu().getSelectedValues()) {
            if (Seibetsu.男.get名称().equals(seibetsu)) {
                性別_男 = Seibetsu.男.getコード();
            } else if (Seibetsu.女.getコード().equals(seibetsu)) {
                性別_女 = Seibetsu.女.getコード();
            }
        }
        if (!性別_男.isEmpty() && 性別_女.isEmpty()) {

            性別 = Seibetsu.男.getコード();
        }

        if (性別_男.isEmpty() && !性別_女.isEmpty()) {

            性別 = Seibetsu.女.getコード();
        }

        if ((性別_男.isEmpty() && 性別_女.isEmpty()) || (!性別_男.isEmpty() && !性別_女.isEmpty())) {

            性別 = RString.EMPTY;
        }
        return new Code(性別);
    }
}
