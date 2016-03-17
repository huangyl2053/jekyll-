    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.NinteichosaResultEntryTargetsData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaResultEntryTargetDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * NinteichosaResultEntryTargetDivを制御します。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaResultEntryTarget {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onLoad(NinteichosaResultEntryTargetDiv div) {
        dgTargetPersons(div).setDataSource(_findTarget());
        setDisabled_btnCommonToCompleteChosa(true);
        for (dgNinteichosaResultTaishosha_Row row : dgTargetPersons(div).getDataSource()) {
            if (canBeSet_chosaKanryoDate(row)) {
                setDisabled_btnCommonToCompleteChosa(false);
                break;
            }
        }
        return _createResponseData(div);
    }

    private void setDisabled_btnCommonToCompleteChosa(boolean disabled) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnCommonToCompleteChosa"), disabled);
    }

    /**
     * データグリッドの選択ボタンを押したときの処理です。
     *
     * @param div NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onClick_btnToDecide(NinteichosaResultEntryTargetDiv div) {
        return _createResponseData(div);
    }

    public ResponseData<NinteichosaResultEntryTargetDiv>
            onSelect_dgNinteichosaResultTaishosha(NinteichosaResultEntryTargetDiv div) {
        List<dgNinteichosaResultTaishosha_Row> dataSource = new ArrayList<>();
        for (dgNinteichosaResultTaishosha_Row row : dgTargetPersons(div).getDataSource()) {
            if (row.getSelected()) {
                NinteichosaResultTaishosha.save(dgTargetPersons(div).getClickedItem());
                row.getBtnToDecide().setDisabled(false);
            } else {
                row.getBtnToDecide().setDisabled(true);
            }
            dataSource.add(row);
        }
        div.getDgNinteichosaResultTaishosha().setDataSource(dataSource);
        return _createResponseData(div);
    }

    /**
     * 復帰時の処理です。
     *
     * @param div NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onResume(NinteichosaResultEntryTargetDiv div) {
        dgNinteichosaResultTaishosha_Row target = NinteichosaResultTaishosha.get();
        if (target != null) {
            setDisabled_btnCommonToCompleteChosa(true);
            List<dgNinteichosaResultTaishosha_Row> list = new ArrayList<>();
            for (dgNinteichosaResultTaishosha_Row row : dgTargetPersons(div).getDataSource()) {
                if (row.getHihokenshaNo().equals(target.getHihokenshaNo())) {
                    list.add(target);
                    if (canBeSet_chosaKanryoDate(target)) {
                        setDisabled_btnCommonToCompleteChosa(false);
                    }
                } else {
                    list.add(row);
                    if (canBeSet_chosaKanryoDate(row)) {
                        setDisabled_btnCommonToCompleteChosa(false);
                    }
                }
            }
            dgTargetPersons(div).setDataSource(list);
        }
        return _createResponseData(div);
    }

    private List<dgNinteichosaResultTaishosha_Row> _findTarget() {
        return new NinteichosaResultEntryTargetsData().get認定調査依頼登録対象者一覧().asConvertedType();
    }

    /**
     * btnCommonToCompleteChosaを押下したときの処理です。
     *
     * @param div NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onClick_btnCommonToCompleteChosa(NinteichosaResultEntryTargetDiv div) {
        List<dgNinteichosaResultTaishosha_Row> dataSource = new ArrayList<>();
        setDisabled_btnCommonToCompleteChosa(true);
        for (dgNinteichosaResultTaishosha_Row row : dgTargetPersons(div).getDataSource()) {
            if (canBeSet_chosaKanryoDate(row)) {
                if (row.getSelected()) {
                    row.getChosaKanryoDate().setValue(FlexibleDate.getNowDate());
                } else {
                    setDisabled_btnCommonToCompleteChosa(false);
                }
            }
            dataSource.add(row);
        }
        dgTargetPersons(div).setDataSource(dataSource);
        return _createResponseData(div);
    }

    private DataGrid<dgNinteichosaResultTaishosha_Row> dgTargetPersons(NinteichosaResultEntryTargetDiv div) {
        return div.getDgNinteichosaResultTaishosha();
    }

    private boolean canBeSet_chosaKanryoDate(dgNinteichosaResultTaishosha_Row target) {
        return !isEmpty_調査依頼日(target) && !isEmpty_調査実施日(target) && isEmpty_調査完了日(target);
    }

    private boolean isEmpty_調査依頼日(dgNinteichosaResultTaishosha_Row target) {
        return isEmpty(target.getChosaIraiDate().getValue());
    }

    private boolean isEmpty_調査実施日(dgNinteichosaResultTaishosha_Row target) {
        return isEmpty(target.getChosaJisshiDate().getValue());
    }

    private boolean isEmpty_調査完了日(dgNinteichosaResultTaishosha_Row target) {
        return isEmpty(target.getChosaKanryoDate().getValue());
    }

    private boolean isEmpty(FlexibleDate date) {
        return (date == null) || (FlexibleDate.EMPTY.equals(date));
    }

    /**
     * dgNinteichosaResultTaishosha_Row を一時的に保持できます。
     */
    static final class NinteichosaResultTaishosha {

        private dgNinteichosaResultTaishosha_Row savedRow;

        private NinteichosaResultTaishosha() {
        }

        private static class NinteichosaResultTaishoshaHolder {

            public static final NinteichosaResultTaishosha INTSTANCE
                    = new NinteichosaResultTaishosha();
        }

        private void setSavedRow(dgNinteichosaResultTaishosha_Row row) {
            this.savedRow = row;
        }

        private dgNinteichosaResultTaishosha_Row getSavedRow() {
            return this.savedRow;
        }

        static void save(dgNinteichosaResultTaishosha_Row target) {
            NinteichosaResultTaishoshaHolder.INTSTANCE.setSavedRow(target);
        }

        static dgNinteichosaResultTaishosha_Row get() {
            return NinteichosaResultTaishoshaHolder.INTSTANCE.getSavedRow();
        }
    }

    private ResponseData<NinteichosaResultEntryTargetDiv> _createResponseData(NinteichosaResultEntryTargetDiv div) {
        ResponseData<NinteichosaResultEntryTargetDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

}
