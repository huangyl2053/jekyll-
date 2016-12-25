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
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
    private static final RString 調査票特記イメージ_C4101 = new RString("C4101_BAK.PNG");
    private static final RString 調査票特記イメージ_C4102 = new RString("C4102_BAK.PNG");
    private static final RString 調査票特記イメージ_C4103 = new RString("C4103_BAK.PNG");
    private static final RString 調査票特記イメージ_C4104 = new RString("C4104_BAK.PNG");
    private static final RString 調査票特記イメージ_C4105 = new RString("C4105_BAK.PNG");
    private static final RString 調査票特記イメージ_C4106 = new RString("C4106_BAK.PNG");
    private static final RString 主治医意見書イメージ_E0001 = new RString("E0001_BAK.PNG");
    private static final RString 主治医意見書イメージ_E0002 = new RString("E0002_BAK.PNG");
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
            if (is対象データ(business.get主治医意見書登録完了年月日())) {
                dgYokaigoNinteiTaskList_Row row = new dgYokaigoNinteiTaskList_Row();
                row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
                row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
                row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
                row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                        ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
                if (business.get主治医意見書登録完了年月日() != null && !business.get主治医意見書登録完了年月日().isEmpty()) {
                    completeCount++;
                    row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
                    row.setJohtai(KihonunyoShoriJotai.処理可能.get略称());
                } else {
                    mishoriCount++;
                    row.setJohtai(KihonunyoShoriJotai.未処理.get略称());
                    row.setCellBgColor(状態.toString(), DataGridCellBgColor.bgColorRed);
                }
                row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());

                if (get調査票特記(business.getイメージ共有ファイルID())) {
                    row.setCyoSaHyoToKi(new RString("○"));
                }
                if (get主治医意見書(business.getイメージ共有ファイルID())) {
                    row.setJyuJiIiKenJyo(new RString("○"));
                }

                マスキングモードの日付設定(row, business);
                rowList.add(row);
            }
        }
        div.getDgYokaigoNinteiTaskList().setDataSource(rowList);
        その他項目編集(completeCount, mishoriCount);

    }

    private boolean is対象データ(FlexibleDate 主治医意見書登録完了年月日) {
        if (div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.すべて.getCode())) {
            return true;
        }
        if (div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.完了可能.getCode())
                && (null != 主治医意見書登録完了年月日) && (!主治医意見書登録完了年月日.isEmpty())) {
            return true;
        }
        if (div.getRadTaishoDataKubun().getSelectedKey().equals(TaishoDataKubun.未処理.getCode())
                && (null == 主治医意見書登録完了年月日 || 主治医意見書登録完了年月日.isEmpty())) {
            return true;
        }
        return false;
    }

    private void その他項目編集(int 完了可能件数, int 未処理件数) {
        div.getDgYokaigoNinteiTaskList().getGridSetting().setLimitRowCount(div.getTxtSaidaiHyojiKensu().getValue().intValue());
        div.getDgYokaigoNinteiTaskList().getGridSetting().setSelectedRowCount(
                YokaigoNinteiTaskListFinder.createInstance().getマスキングモード件数(YokaigoNinteiTaskListParameter.
                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), RString.EMPTY,
                                div.getTxtSaidaiHyojiKensu().getValue())));
        div.getTxtMishoriCount().setValue(new Decimal(未処理件数));
        div.getTxtCompleteCount().setValue(new Decimal(完了可能件数));
        div.getTxtTotalCount().setValue(new Decimal(未処理件数 + 完了可能件数));
    }

    private boolean get調査票特記(RDateTime sharedFileId) {

        return RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4101))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4102))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4103))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4104))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4105))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4106));
    }

    private boolean get主治医意見書(RDateTime sharedFileId) {

        return RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 主治医意見書イメージ_E0001))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 主治医意見書イメージ_E0002));
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージ名) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージ名);
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
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
