/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.ShinsakaiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiToRoKuBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinsakaiYusenWaritsukeKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・介護認定審査会登録のコントローラです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
public class ShinsakaiTorokuHandler {

//    private final RString 審査会登録モード = new RString("審査会登録モード");
    private final ShinsakaiTorokuDiv div;
    
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会登録Div
     */
    public ShinsakaiTorokuHandler(ShinsakaiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・介護認定審査会登録の初期化を設定します。
     *
     */
    public void onLoad() {
        RString key = div.getRadTaishoshaJotai().getSelectedKey();
        RString 状態区分 = new RString("");
        
        if (KEY0.equals(key)) {
            状態区分 = new RString("1");
            div.getTxtMishoriCount().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(true);
            div.getTxtTotalCount().setDisplayNone(true);
        } else if (KEY1.equals(key)) {
            状態区分 = new RString("2");
            div.getTxtMishoriCount().setDisplayNone(true);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(true);        
        } else {
            div.getTxtMishoriCount().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(false); 
        }
        
        List<ShinSaKaiToRoKuBusiness> 審査会登録List = ShinsakaiTorokuFinder.createInstance().
                    get審査会登録モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分)).records();
            if (!審査会登録List.isEmpty()) {
                ShinSaKaiBusiness 前審査会登録Model = ShinsakaiTorokuFinder.createInstance().
                        get前審査会登録(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前審査会登録Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            審査会登録モード(審査会登録List);

    }

    /**
     * 要介護認定完了情報の更新処理する。
     *
     * @param models models
     */
    public void 要介護認定完了更新(Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> models) {
        FlexibleDate 割当完了年月日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<dgNinteiTaskList_Row> 選択データ = div.getDgNinteiTaskList().getSelectedItems();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(データ.getShinseishoKanriNo());
            NinteiKanryoJohoIdentifier 要介護認定完了識別子 = new NinteiKanryoJohoIdentifier(申請書管理番号);
            NinteiKanryoJoho 要介護認定完了
                    = models.get(要介護認定完了識別子).createBuilderForEdit().set認定審査会割当完了年月日(割当完了年月日).build();
            ShinsakaiTorokuManager.createInstance().要介護認定完了更新(要介護認定完了.toEntity());
        }
    }
    
    private void 審査会登録モード(List<ShinSaKaiToRoKuBusiness> 審査会登録List) {
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (ShinSaKaiToRoKuBusiness business : 審査会登録List) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get主治医意見書登録完了年月日() != null && !business.get主治医意見書登録完了年月日().isEmpty()) {
                completeCount++;
                row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
            }
            row.setYusenWaritsukesha(business.get介護認定審査会優先振分区分コード() == null ? RString.EMPTY
                    : ShinsakaiYusenWaritsukeKubunCode.toValue(business.get介護認定審査会優先振分区分コード().getKey()).get名称());
            row.setKaisaiNumber(business.get介護認定審査会開催番号() == null ? RString.EMPTY : business.get介護認定審査会開催番号());
            row.setGogitai(new RString(String.valueOf(business.get合議体番号())));
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            審査会登録モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new Decimal(審査会登録List.size()));
        div.getTxtCompleteCount().setValue(new Decimal(completeCount));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }
    
    private void 審査会登録モードの日付設定(dgNinteiTaskList_Row row, ShinSaKaiToRoKuBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.getマスキング完了年月日() != null && !business.getマスキング完了年月日().isEmpty()) {
            row.getMaskingKanryoDay().setValue(new RDate(business.getマスキング完了年月日().toString()));
        }
        if (business.get認定審査会割当完了年月日() != null && !business.get認定審査会割当完了年月日().isEmpty()) {
            row.getShinsakaiwaritukeDay().setValue(new RDate(business.get認定審査会割当完了年月日().toString()));
        }
        if (business.get介護認定審査会開催予定年月日() != null && !business.get介護認定審査会開催予定年月日().isEmpty()) {
            row.getShinsakaiKaisaiDay().setValue(new RDate(business.get介護認定審査会開催予定年月日().toString()));
        }
        if (business.get介護認定審査会開始予定時刻() != null && !business.get介護認定審査会開始予定時刻().isEmpty()) {
            row.getShinsakaiKaisaiJikan().setValue(RTime.of(Integer.valueOf(business.get介護認定審査会開始予定時刻().substring(0, 2).toString()),
                    Integer.valueOf(business.get介護認定審査会開始予定時刻().substring(2).toString())));
        }
        if (business.get認定調査完了年月日() != null && !business.get認定調査完了年月日().isEmpty()) {
            row.getChosahyoKanryoDay().setValue(new RDate(business.get認定調査完了年月日().toString()));
        }
    }

    /**
     * 対象者状態ラジオボタンの表示処理です。
     */
    public void setJyotaiKubun() {
        onLoad();
    }
    
}
