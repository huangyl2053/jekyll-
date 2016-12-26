/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.MaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.dgYokaigoNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.MaSuKinGuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.KihonunyoShoriJotai;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.TaishoDataKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・マスキングのHandlerクラスです。
 *
 * @reamsid_L DBE-2080-010 lishengli
 */
public class MaskingHandler {

    private final MaskingDiv div;
    private static final RString 状態 = new RString("johtai");

    /**
     * コンストラクタです。
     *
     * @param div MaskingDiv
     */
    public MaskingHandler(MaskingDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・マスキングの初期化です。
     */
    public void initialize() {
        List<MaSuKinGuBusiness> マスキングList = YokaigoNinteiTaskListFinder.createInstance().
                getマスキングモード(YokaigoNinteiTaskListParameter.
                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(),
                                div.getRadTaishoDataKubun().getSelectedKey(), div.getTxtSaidaiHyojiKensu().getValue())).records();
        if (!マスキングList.isEmpty()) {
            ShinSaKaiBusiness 前マスキングModel = YokaigoNinteiTaskListFinder.createInstance().
                    get前マスキング(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(),
                                    div.getRadTaishoDataKubun().getSelectedKey(), div.getTxtSaidaiHyojiKensu().getValue()));
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前マスキングModel.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
        データグリッド部編集(マスキングList);
        setCountDisplay();
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return 要介護認定完了情報
     */
    public NinteiKanryoJoho 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        return ninteiKanryoJoho.createBuilderForEdit().setマスキング完了年月日(
                new FlexibleDate(RDate.getNowDate().toDateString())).build();
    }

    private void データグリッド部編集(List<MaSuKinGuBusiness> マスキングList) {

        List<dgYokaigoNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        int mishoriCount = 0;
        for (MaSuKinGuBusiness business : マスキングList) {
            if (is対象データ(business.has意見書マスク())) {
                dgYokaigoNinteiTaskList_Row row = new dgYokaigoNinteiTaskList_Row();
                row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
                row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
                row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
                row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                        ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
                if (business.has意見書マスク()) {
                    completeCount++;
                    row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
                    row.setJohtai(KihonunyoShoriJotai.処理可能.get略称());
                } else {
                    mishoriCount++;
                    row.setJohtai(KihonunyoShoriJotai.未処理.get略称());
                    row.setCellBgColor(状態.toString(), DataGridCellBgColor.bgColorRed);
                }
                row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());

                if (business.has特記マスク()) {
                    row.setCyoSaHyo(new RString("○"));
                }
                if (business.has概況マスク()) {
                    row.setCyoSaHyoToKi(new RString("○"));
                }
                if (business.has意見書マスク()) {
                    row.setJyuJiIiKenJyo(new RString("○"));
                }

                マスキングモードの日付設定(row, business);
                rowList.add(row);
            }
        }
        div.getDgYokaigoNinteiTaskList().setDataSource(rowList);
        その他項目編集(completeCount, mishoriCount);

    }

    private boolean is対象データ(boolean 医意見書マスク) {
        return ((div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.完了可能.getCode()) && 医意見書マスク)
                || (div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.未処理.getCode()) && !医意見書マスク)
                || (div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.すべて.getCode())));
    }

    private void その他項目編集(int 完了可能件数, int 未処理件数) {
        if (null == div.getTxtSaidaiHyojiKensu().getValue() || div.getTxtSaidaiHyojiKensu().getValue().toString().isEmpty()
                || div.getTxtSaidaiHyojiKensu().getValue().compareTo(Decimal.ZERO) == 0) {
            div.getTxtSaidaiHyojiKensu().setValue(
                    new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        }
        div.getDgYokaigoNinteiTaskList().getGridSetting().setLimitRowCount(div.getTxtSaidaiHyojiKensu().getValue().intValue());
        div.getDgYokaigoNinteiTaskList().getGridSetting().setSelectedRowCount(
                YokaigoNinteiTaskListFinder.createInstance().getマスキングモード件数(YokaigoNinteiTaskListParameter.
                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), RString.EMPTY,
                                div.getTxtSaidaiHyojiKensu().getValue())));
        div.getTxtMishoriCount().setValue(new Decimal(未処理件数));
        div.getTxtCompleteCount().setValue(new Decimal(完了可能件数));
        div.getTxtTotalCount().setValue(new Decimal(未処理件数 + 完了可能件数));
    }

    private void マスキングモードの日付設定(dgYokaigoNinteiTaskList_Row row, MaSuKinGuBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.get認定調査依頼完了年月日() != null && !business.get認定調査依頼完了年月日().isEmpty()) {
            row.getChosaIraiKanryoDay().setValue(new RDate(business.get認定調査依頼完了年月日().toString()));
        }
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getChosahyoKanryoDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.get主治医意見書作成依頼完了年月日() != null && !business.get主治医意見書作成依頼完了年月日().isEmpty()) {
            row.getIkenshoIraiKanryoDay().setValue(new RDate(business.get主治医意見書作成依頼完了年月日().toString()));
        }
    }

    private void setCountDisplay() {
        if (div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.すべて.getCode())) {
            div.getTxtMishoriCount().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(false);
        }
        if (div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.完了可能.getCode())) {
            div.getTxtMishoriCount().setDisplayNone(true);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(true);
        }
        if (div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.未処理.getCode())) {
            div.getTxtMishoriCount().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(true);
            div.getTxtTotalCount().setDisplayNone(true);
        }
    }

}
