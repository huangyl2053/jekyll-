/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.CyoSaiRaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 完了処理・認定調査依頼のHandlerクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiHandler {

    private final NinteichosaIraiDiv div;
    private static final RString 使用する = new RString("1");
    private static final RString 未 = new RString("未");
    private static final RString 可 = new RString("可");
    private static final RString KEY_未 = new RString("1");
    private static final RString KEY_可 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査依頼Div
     */
    public NinteichosaIraiHandler(NinteichosaIraiDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・認定調査依頼に初期化を設定します。
     */
    public void onLoad() {
        initDataGrid();
        RString 認定調査自動割付 = DbBusinessConfig.get(ConfigNameDBE.認定調査自動割付, RDate.getNowDate());
        if (使用する.equals(認定調査自動割付)) {
            div.getBtniraiauto().setDisabled(false);
        } else {
            div.getBtniraiauto().setDisabled(true);
        }
        RString モバイル調査使用有無 = DbBusinessConfig.get(ConfigNameDBE.モバイル調査使用有無, RDate.getNowDate());
        if (使用する.equals(モバイル調査使用有無)) {
            div.getBtnchosadataoutput().setDisabled(false);
        } else {
            div.getBtnchosadataoutput().setDisabled(true);
        }

    }

    /**
     * DataGridを更新します。
     */
    public void initDataGrid() {
        RString 状態 = div.getRadShoriJyotai().getSelectedKey();
        List<CyoSaiRaiBusiness> 調査依頼List = YokaigoNinteiTaskListFinder.createInstance().
            get調査依頼モード(YokaigoNinteiTaskListParameter.
                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態)).records();
        if (!調査依頼List.isEmpty()) {
            ShinSaKaiBusiness 前調査依頼Model = YokaigoNinteiTaskListFinder.createInstance().
                get前調査依頼モード(YokaigoNinteiTaskListParameter.
                    createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前調査依頼Model.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        int notUpdateCount = 0;
        for (CyoSaiRaiBusiness business : 調査依頼List) {

            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者名() == null ? RString.EMPTY : business.get保険者名());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                                         ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            row.getChosaIraiSaichosaCount().setValue(new Decimal(business.get再調査依頼回数()));
            if (business.get認定調査依頼完了年月日() != null && !business.get認定調査依頼完了年月日().isEmpty()) {
                row.getChosaIraiKanryoDay().setValue(new RDate(business.get認定調査依頼完了年月日().toString()));
            }
            row.setChosaIraiKubun(business.get認定調査依頼区分コード() == null ? RString.EMPTY
                                  : NinteiChousaIraiKubunCode.toValue(business.get認定調査依頼区分コード().getKey()).get名称());
            row.setKonkaiChosaItakusaki(business.get今回調査委託先() == null ? RString.EMPTY : business.get今回調査委託先());
            row.setKonkaiChosain(business.get今回調査員氏名() == null ? RString.EMPTY : business.get今回調査員氏名());
            row.getKonkaiChosaCount().setValue(new Decimal(business.get今回調査調査回数()));
            row.setZenkaiChosaItakusaki(business.get前回調査委託先() == null ? RString.EMPTY : business.get前回調査委託先());
            row.setZenkaiChosain(business.get前回調査員氏名() == null ? RString.EMPTY : business.get前回調査員氏名());
            row.setZenzenkaiChosaItakusaki(business.get前前回調査委託先() == null ? RString.EMPTY : business.get前前回調査委託先());
            row.setZenzenkaiChosain(business.get前前回調査員氏名() == null ? RString.EMPTY : business.get前前回調査員氏名());
            row.setYubinNumber(business.get郵便番号() == null ? RString.EMPTY : business.get郵便番号().getEditedYubinNo());
            row.setJusho(business.get住所() == null ? RString.EMPTY : business.get住所().value());
            row.setNyushoShisetsu(business.get入所施設() == null ? RString.EMPTY : business.get入所施設().value());
            row.setChosaTokusokuHoho(business.get認定調査督促方法() == null ? RString.EMPTY
                                     : new RString(NinteichosaTokusokuHoho.toValue(business.get認定調査督促方法()).name()));
            row.getChosaTokusokuCount().setValue(new Decimal(business.get認定調査督促回数()));
            row.setChikuCode(RString.isNullOrEmpty(business.get地区コード()) ? RString.EMPTY : business.get地区コード());
            row.setChosaTokusokuChiku(business.get地区コード() == null ? RString.EMPTY
                                      : CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                                                                 DBECodeShubetsu.調査地区コード.getコード(),
                                                                 new Code(business.get地区コード()), new FlexibleDate(RDate.getNowDate().toDateString())));
            row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.get認定調査依頼履歴番号())));
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード() == null ? RString.EMPTY : business.get厚労省IF識別コード().value());
            row.setGetShoKisaiHokenshaNo(business.get証記載保険番号() == null ? RString.EMPTY : business.get証記載保険番号());
            調査依頼モードの日付設定(row, business);
            if ((RString.isNullOrEmpty(row.getKonkaiChosaItakusaki()) || RString.isNullOrEmpty(row.getKonkaiChosain()))
                || row.getChosaIraiKigen().getValue() == null
                || row.getChosaIraishoHakkoDay().getValue() == null
                || row.getChosaIraiDataShutsuryokuDay().getValue() == null) {
                notUpdateCount++;
                row.setJotai(未);
                row.setCellBgColor("jotai", DataGridCellBgColor.bgColorRed);
            } else {
                completeCount++;
                row.setJotai(可);
            }
            rowList.add(row);
        }
        div.getDgNinteiTaskList().setDataSource(rowList);

        if (状態.equals(KEY_未)) {
            div.getTxtNoUpdate().setValue(new Decimal(notUpdateCount));
            div.getTxtCompleteCount().clearValue();
            div.getTxtTotalCount().clearValue();
        } else if (状態.equals(KEY_可)) {
            div.getTxtCompleteCount().setValue(new Decimal(completeCount));
            div.getTxtNoUpdate().clearValue();
            div.getTxtTotalCount().clearValue();
        } else {
            div.getTxtTotalCount().setValue(new Decimal(調査依頼List.size()));
            div.getTxtCompleteCount().setValue(new Decimal(completeCount));
            div.getTxtNoUpdate().setValue(new Decimal(notUpdateCount));
        }
    }

    private void 調査依頼モードの日付設定(dgNinteiTaskList_Row row, CyoSaiRaiBusiness business) {

        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }

        if (business.get依頼書出力年月日() != null && !business.get依頼書出力年月日().isEmpty()) {
            row.getChosaIraishoHakkoDay().setValue(new RDate(business.get依頼書出力年月日().toString()));
        }
        if (business.get調査票等出力年月日() != null && !business.get調査票等出力年月日().isEmpty()) {
            row.getChousahyoOutput().setValue(new RDate(business.get調査票等出力年月日().toString()));
            row.getChosaIraiDataShutsuryokuDay().setValue(new RDate(business.get調査票等出力年月日().toString()));
        }
        if (business.get認定調査期限年月日() != null && !business.get認定調査期限年月日().isEmpty()) {
            row.getChosaIraiKigen().setValue(new RDate(business.get認定調査期限年月日().toString()));
        }
        if (business.get認定調査督促年月日() != null && !business.get認定調査督促年月日().isEmpty()) {
            row.getChosaTokusokuHakkoDay().setValue(new RDate(business.get認定調査督促年月日().toString()));
        }
    }
}
