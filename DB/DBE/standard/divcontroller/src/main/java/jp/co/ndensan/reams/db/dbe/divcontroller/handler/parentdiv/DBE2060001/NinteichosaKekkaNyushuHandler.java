/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2060001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.KanryoShoriStatus;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaKekkaNyushuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairailist.NinteichosaIraiListManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.CyoSaNyuSyuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 完了処理・認定調査結果入手のHandlerクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
public class NinteichosaKekkaNyushuHandler {

    private final NinteichosaKekkaNyushuDiv div;
    private static final RString 調査結果を登録するボタン = new RString("btnKekkaTouroku");
    private static final RString 調査票入手を完了するボタン = new RString("btnChousaResultKanryo");
    private static final RString UIContainer_DBEUC22101 = new RString("DBEUC22101");
    private static final RString 概況基本調査 = new RString("1");
    private static final RString 概況基本調査_特記 = new RString("2");
    private static final RString 概況基本調査_特記_概況特記 = new RString("3");
    private static final RString 概況特記出力する = new RString("1");
    private static final RString 列_概況特記登録 = new RString("gaikyoTokkiToroku");
    private static final RString データ有 = new RString("●");
    private static final String 列_状態 = "jotai";
    private static final int INT_0 = 0;

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査結果入手Div
     */
    public NinteichosaKekkaNyushuHandler(NinteichosaKekkaNyushuDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・認定調査結果入手に初期化を設定します。
     */
    public void onLoad() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        setDefaultControl();
        initialDataGrid();
        setCommonButtonAndTextBoxState();

    }

    /**
     * 「調査票入手を完了する」ボタンを押下する場合、ＤＢに更新する処理を実行します。
     *
     * @param 要介護認定完了情報Model 要介護認定完了情報Model
     */
    public void onClick_btnChousaResultKanryo(Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> 要介護認定完了情報Model) {
        List<dgNinteiTaskList_Row> 選択されたデータ = div.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems();
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            NinteiKanryoJohoIdentifier 要介護認定完了情報の識別子 = new NinteiKanryoJohoIdentifier(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            NinteichosaIraiListManager.createInstance().save要介護認定完了情報(要介護認定完了情報Model.get(要介護認定完了情報の識別子).
                    createBuilderForEdit().set認定調査完了年月日(FlexibleDate.getNowDate()).build().toEntity());
        }
    }

    /**
     * 対象者一覧グリッドに対象者を設定します。
     */
    public void initialDataGrid() {
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        RString 状態 = div.getRadJotaiKubun().getSelectedKey();
        Decimal 最大取得件数 = div.getTxtMaxKensu().getValue();
        boolean is特記事項必須 = false;
        boolean is概況特記必須 = false;
        if (!概況特記出力する.equals(DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            div.getDgNinteiTaskList().getGridSetting().getColumn(列_概況特記登録).setVisible(false);
        }
        if (概況基本調査_特記.equals(DbBusinessConfig.get(
                ConfigNameDBE.認定調査結果入手_必須調査票, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            is特記事項必須 = true;
        } else if (概況基本調査_特記_概況特記.equals(
                DbBusinessConfig.get(ConfigNameDBE.認定調査結果入手_必須調査票, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            is特記事項必須 = true;
            is概況特記必須 = true;
        }
        SearchResult<CyoSaNyuSyuBusiness> searchResult = YokaigoNinteiTaskListFinder.createInstance().
                get調査入手モード(YokaigoNinteiTaskListParameter.
                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態, 最大取得件数,
                                市町村コード, false, is特記事項必須, is概況特記必須));
        List<CyoSaNyuSyuBusiness> 調査入手List = searchResult.records();
        if (!調査入手List.isEmpty()) {
            ShinSaKaiBusiness 全調査入手Model = YokaigoNinteiTaskListFinder.createInstance().
                    get全調査入手モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(全調査入手Model.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
        setDataGrid(searchResult);
    }

    /**
     * 最大表示件数テキストボックスに正しい値が入っていない場合はコンフィグ値で置き換えます。
     */
    public void checkAndSetMaxKensu() {
        Decimal 最大表示件数 = div.getNinteichosakekkainput().getTxtMaxKensu().getValue();
        if (最大表示件数 != null && (INT_0 <= 最大表示件数.compareTo(div.getNinteichosakekkainput().getTxtMaxKensu().getMinValue()))
                && (INT_0 <= div.getNinteichosakekkainput().getTxtMaxKensu().getMaxValue().compareTo(最大表示件数))) {
            return;
        }

        RString 最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getNinteichosakekkainput().getTxtMaxKensu().setValue(new Decimal(最大取得件数.toString()));
    }

    /**
     * 共通ボタンの制御を行います。
     */
    public void setCommonButtonAndTextBoxState() {
        if (KanryoShoriStatus.未処理.getコード().equals(div.getNinteichosakekkainput().getRadJotaiKubun().getSelectedKey())) {
            div.getNinteichosakekkainput().getTxtMishori().setDisplayNone(false);
            div.getNinteichosakekkainput().getTxtKanryoKano().setDisplayNone(true);
            div.getNinteichosakekkainput().getTxtGokei().setDisplayNone(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査票入手を完了するボタン, true);
        } else if (KanryoShoriStatus.完了可能.getコード().equals(div.getNinteichosakekkainput().getRadJotaiKubun().getSelectedKey())) {
            div.getNinteichosakekkainput().getTxtMishori().setDisplayNone(true);
            div.getNinteichosakekkainput().getTxtKanryoKano().setDisplayNone(false);
            div.getNinteichosakekkainput().getTxtGokei().setDisplayNone(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査票入手を完了するボタン, false);
        } else {
            div.getNinteichosakekkainput().getTxtMishori().setDisplayNone(false);
            div.getNinteichosakekkainput().getTxtKanryoKano().setDisplayNone(false);
            div.getNinteichosakekkainput().getTxtGokei().setDisplayNone(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査票入手を完了するボタン, false);
        }
    }

    private void setDefaultControl() {
        RDate 基準日 = RDate.getNowDate();
        RString 状態区分 = DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分, 基準日, SubGyomuCode.DBE認定支援);
        RString 最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, 基準日, SubGyomuCode.DBU介護統計報告);

        if (RString.isNullOrEmpty(状態区分)) {
            div.getNinteichosakekkainput().getRadJotaiKubun().setSelectedKey(KanryoShoriStatus.すべて.getコード());
        } else {
            div.getNinteichosakekkainput().getRadJotaiKubun().setSelectedKey(状態区分);
        }
        if (UIContainer_DBEUC22101.equals(ResponseHolder.getUIContainerId())) {
            div.getNinteichosakekkainput().getRadJotaiKubun().setSelectedKey(KanryoShoriStatus.完了可能.getコード());
            div.getNinteichosakekkainput().getRadJotaiKubun().setDisabled(true);
        } else {
            div.getNinteichosakekkainput().getRadJotaiKubun().setDisabled(false);
        }
        if (!RString.isNullOrEmpty(最大取得件数)) {
            div.getNinteichosakekkainput().getTxtMaxKensu().setValue(new Decimal(最大取得件数.toString()));
        }
        if (!RString.isNullOrEmpty(最大取得件数上限)) {
            div.getNinteichosakekkainput().getTxtMaxKensu().setMaxValue(new Decimal(最大取得件数上限.toString()));
        }
    }

    private void setDataGrid(SearchResult<CyoSaNyuSyuBusiness> searchResult) {
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int mishoriCount = 0;
        int kanryoKanoCount = 0;
        for (CyoSaNyuSyuBusiness business : searchResult.records()) {
//            if (!isDisplay(business.get認定調査実施年月日())) {
//                continue;
//            }
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setShoKisaiHokenshaNo(business.get証記載保険者番号().value());
            row.setHokensha(RString.isNullOrEmpty(business.get保険者名()) ? RString.EMPTY : business.get保険者名());
            row.getNinteiShinseiYMD().setValue(toRDate(business.get認定申請年月日()));
            row.setHihoNo(RString.isNullOrEmpty(business.get被保険者番号()) ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(get氏名(business.get氏名()));
            row.setShinseiKubunShinseiji(get認定申請区分申請時コード(business.get認定申請区分申請時コード()));
            row.getChosaIraiKanryoYMD().setValue(toRDate(business.get認定調査依頼完了年月日()));
            row.setChosaItakusaki(RString.isNullOrEmpty(business.get調査委託先()) ? RString.EMPTY : business.get調査委託先());
            row.setChosain(RString.isNullOrEmpty(business.get調査員氏名()) ? RString.EMPTY : business.get調査員氏名());
            if (business.get認定調査実施年月日() != null && !business.get認定調査実施年月日().isEmpty()) {
                row.getChosaJisshiYMD().setValue(new RDate(business.get認定調査実施年月日().toString()));
                row.setGaikyoChosaToroku(データ有);
            } else {
                row.setGaikyoChosaToroku(RString.EMPTY);
            }
            if (business.get基本調査_申請書管理番号() != null) {
                row.setKihonChosaToroku(データ有);
            } else {
                row.setKihonChosaToroku(RString.EMPTY);
            }
            if (business.get特記事項_申請書管理番号() != null) {
                row.setTokkiJikoToroku(データ有);
            } else {
                row.setTokkiJikoToroku(RString.EMPTY);
            }
            if (business.get概況特記_申請書管理番号() != null) {
                row.setGaikyoTokkiToroku(データ有);
            } else {
                row.setGaikyoTokkiToroku(RString.EMPTY);
            }
            if (概況基本調査.equals(DbBusinessConfig.get(
                    ConfigNameDBE.認定調査結果入手_必須調査票, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                if (!RString.isNullOrEmpty(row.getGaikyoChosaToroku()) && !RString.isNullOrEmpty(row.getKihonChosaToroku())) {
                    row.setJotai(KanryoShoriStatus.完了可能.get略称());
                    kanryoKanoCount++;
                } else {
                    row.setJotai(KanryoShoriStatus.未処理.get略称());
                    row.setCellBgColor(列_状態, DataGridCellBgColor.bgColorRed);
                    mishoriCount++;
                }
            } else if (概況基本調査_特記.equals(DbBusinessConfig.get(
                    ConfigNameDBE.認定調査結果入手_必須調査票, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                if (!RString.isNullOrEmpty(row.getGaikyoChosaToroku()) && !RString.isNullOrEmpty(row.getKihonChosaToroku())
                        && !RString.isNullOrEmpty(row.getTokkiJikoToroku())) {
                    row.setJotai(KanryoShoriStatus.完了可能.get略称());
                    kanryoKanoCount++;
                } else {
                    row.setJotai(KanryoShoriStatus.未処理.get略称());
                    row.setCellBgColor(列_状態, DataGridCellBgColor.bgColorRed);
                    mishoriCount++;
                }
            } else {
                if (!RString.isNullOrEmpty(row.getGaikyoChosaToroku()) && !RString.isNullOrEmpty(row.getKihonChosaToroku())
                        && !RString.isNullOrEmpty(row.getTokkiJikoToroku()) && !RString.isNullOrEmpty(row.getGaikyoTokkiToroku())) {
                    row.setJotai(KanryoShoriStatus.完了可能.get略称());
                    kanryoKanoCount++;
                } else {
                    row.setJotai(KanryoShoriStatus.未処理.get略称());
                    row.setCellBgColor(列_状態, DataGridCellBgColor.bgColorRed);
                    mishoriCount++;
                }
            }
            row.getTokusokuHakkoYMD().setValue(toRDate(business.get認定調査督促年月日()));
            row.setTokusokuHoho(RString.isNullOrEmpty(business.get認定調査督促方法()) || business.get認定調査督促方法().equals(RString.EMPTY)
                    || business.get認定調査督促方法().equals(RString.HALF_SPACE)
                    ? RString.EMPTY : new RString(NinteichosaTokusokuHoho.toValue(business.get認定調査督促方法()).name()));
            row.getTokusokuKaisu().setValue(new Decimal(business.get認定調査督促回数()));
            row.getTokusokuKigen().setValue(toRDate(business.get認定調査期限年月日()));
            row.setTokusokuChiku(RString.isNullOrEmpty(business.get地区コード()) ? RString.EMPTY
                    : CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                            DBECodeShubetsu.調査地区コード.getコード(),
                            new Code(business.get地区コード()), new FlexibleDate(RDate.getNowDate().toDateString())));
            row.setChosaItakusakiCode(get認定調査委託先コード(business.get認定調査委託先コード()));
            row.setChosainCode(get調査員コード(business.get調査員コード()));
            row.setChikuCode(RString.isNullOrEmpty(business.get地区コード()) ? RString.EMPTY : business.get地区コード());
            row.setShinseishoKanriNo(get申請書管理番号(business.get認定申請情報_申請書管理番号()));
            row.setNinteichosaIraiRirekiNo(new RString(business.get認定調査依頼履歴番号()));

            rowList.add(row);
        }
        Decimal 最大表示件数 = div.getNinteichosakekkainput().getTxtMaxKensu().getValue();
        div.getTxtMishori().setValue(new Decimal(mishoriCount));
        div.getTxtKanryoKano().setValue(new Decimal(kanryoKanoCount));
        div.getTxtGokei().setValue(new Decimal(searchResult.records().size()));
        div.getDgNinteiTaskList().setDataSource(rowList);
        div.getDgNinteiTaskList().getGridSetting().setLimitRowCount(最大表示件数.intValue());
        div.getDgNinteiTaskList().getGridSetting().setSelectedRowCount(searchResult.totalCount());
    }

    private boolean isDisplay(FlexibleDate 認定調査実施日) {
        if (KanryoShoriStatus.未処理.getコード().equals(div.getNinteichosakekkainput().getRadJotaiKubun().getSelectedKey())) {
            return 認定調査実施日 == null || 認定調査実施日.isEmpty();

        } else if (KanryoShoriStatus.完了可能.getコード().equals(div.getNinteichosakekkainput().getRadJotaiKubun().getSelectedKey())) {
            return 認定調査実施日 != null && !認定調査実施日.isEmpty();
        }
        return true;
    }

    private RDate toRDate(FlexibleDate date) {
        return date == null || date.isEmpty() ? null : new RDate(date.toString());
    }

    private RString get氏名(AtenaMeisho meisho) {
        return meisho == null || RString.isNullOrEmpty(meisho.value()) ? RString.EMPTY : meisho.value();
    }

    private RString get認定申請区分申請時コード(Code code) {
        return code == null || RString.isNullOrEmpty(code.getKey()) ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(code.getKey()).get名称();
    }

    private RString get認定調査委託先コード(ChosaItakusakiCode code) {
        return code == null || RString.isNullOrEmpty(code.value()) ? RString.EMPTY : code.value();
    }

    private RString get調査員コード(ChosainCode code) {
        return code == null || RString.isNullOrEmpty(code.value()) ? RString.EMPTY : code.value();
    }

    private RString get申請書管理番号(ShinseishoKanriNo no) {
        return no == null || RString.isNullOrEmpty(no.value()) ? RString.EMPTY : no.value();
    }

}
