/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.IkenshogetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IkenSyoNyuSyuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・主治医意見書入手のHandlerクラスです。
 *
 * @reamsid_L DBE-0330-010 lishengli
 */
public class IkenshogetHandler {

    private final IkenshogetDiv div;
    private static final RString 未処理 = new RString("未");
    private static final RString 完了可能 = new RString("可");
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div IkenshogetDiv
     */
    public IkenshogetHandler(IkenshogetDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・主治医意見書入手の初期化です。
     *
     */
    public void initialize() {
        RString key = div.getRadJyotaiKubun().getSelectedKey();
        RString 状態区分 = new RString("");

        if (KEY0.equals(key)) {
            状態区分 = new RString("1");
        } else if (KEY1.equals(key)) {
            状態区分 = new RString("2");
        }
        List<IkenSyoNyuSyuBusiness> 意見書入手List = YokaigoNinteiTaskListFinder.createInstance().
                get意見書入手モード(YokaigoNinteiTaskListParameter.
                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分)).records();

        if (!意見書入手List.isEmpty()) {
            ShinSaKaiBusiness 前意見書入手Model = YokaigoNinteiTaskListFinder.createInstance().
                    get前意見書入手(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分));
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前意見書入手Model.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }

        意見書入手モード(意見書入手List);

    }

    private void 意見書入手モード(List<IkenSyoNyuSyuBusiness> 意見書入手List) {

        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        int notCount = 0;
        for (IkenSyoNyuSyuBusiness business : 意見書入手List) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();

            if (business.get主治医意見書読取年月日() == null) {
                row.setJyotai(未処理);
                row.setCellBgColor("jyotai", DataGridCellBgColor.bgColorRed);
                notCount++;
            } else if (business.get主治医意見書読取年月日() != null) {
                row.setJyotai(完了可能);
                completeCount++;
            }
            row.setHokensha(business.get保険者名() == null ? RString.EMPTY : business.get保険者名());

            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get主治医意見書登録完了年月日() != null && !business.get主治医意見書登録完了年月日().isEmpty()) {

                row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
            }
//            row.getIkenshoNyushuTeikei().setValue(new RDate(business.get));
            row.setIkenshoIraiShokai(business.get意見書作成回数区分() == null
                    ? RString.EMPTY : IkenshoSakuseiKaisuKubun.toValue(business.get意見書作成回数区分().getKey()).get名称());
            row.setChosaTokusokuHoho(business.get主治医意見書作成督促方法() == null ? RString.EMPTY : business.get主治医意見書作成督促方法());
            row.getChosaTokusokuCount().setValue(new Decimal(business.get主治医意見書作成督促回数()));
            意見書入手モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtMisyori().setValue(new RString(String.valueOf(notCount)));
        div.getTxtKanryouKano().setValue(new RString(String.valueOf(completeCount)));
        div.getTxtGokei().setValue(new RString(String.valueOf(意見書入手List.size())));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 意見書入手モードの日付設定(dgNinteiTaskList_Row row, IkenSyoNyuSyuBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            row.getKeikaNissu().setValue(new Decimal(FlexibleDate.getNowDate().getBetweenDays(business.get認定申請年月日())));
        }
        if (business.get主治医意見書作成依頼完了年月日() != null && !business.get主治医意見書作成依頼完了年月日().isEmpty()) {
            row.getKoshinKanryoDay().setValue(new RDate(business.get主治医意見書作成依頼完了年月日().toString()));
        }
        if (business.get主治医意見書記入年月日() != null && !business.get主治医意見書記入年月日().isEmpty()) {
            row.getNyusyubi().setValue(new RDate(business.get主治医意見書記入年月日().toString()));
        }
        if (business.get主治医意見書作成督促年月日() != null && !business.get主治医意見書作成督促年月日().isEmpty()) {
            row.getChosaTokusokuHakkoDay().setValue(new RDate(business.get主治医意見書作成督促年月日().toString()));
        }

        if (business.get主治医意見書作成期限年月日() != null && !business.get主治医意見書作成期限年月日().isEmpty()) {
            row.getChosaTokusokuLiit().setValue(new RDate(business.get主治医意見書作成期限年月日().toString()));
        }
        row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
        row.setIkenshoIraiRirekiNo(new RString(String.valueOf(business.get主治医意見書作成依頼履歴番号())));
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     */
    public void 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit().set主治医意見書登録完了年月日(
                new FlexibleDate(RDate.getNowDate().toDateString())).build();
        IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
    }
}
