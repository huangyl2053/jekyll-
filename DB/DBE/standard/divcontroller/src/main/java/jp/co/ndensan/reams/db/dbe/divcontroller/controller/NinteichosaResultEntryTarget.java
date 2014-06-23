    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.NinteichosaResultEntryTargetsData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.NinteichosaResultEntryTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
        div.getDgNinteichosaResultTaishosha().setDataSource(_findTarget());
        setDisabled_btnToFinish(div, true);
        return _createResponseData(div);
    }

    private void setDisabled_btnToFinish(NinteichosaResultEntryTargetDiv div, boolean disabled) {
        div.getButtonsForNinteichosaResultEntryTarget().getBtnToFinish().setDisabled(disabled);
    }

    /**
     * データグリッドの選択ボタンを押したときの処理です。
     *
     * @param div NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onClick_btnToDecide(NinteichosaResultEntryTargetDiv div) {
        Holder.save(dgTargetPersons(div).getClickedItem());
        return _createResponseData(div);
    }

    /**
     * 復帰時の処理です。
     *
     * @param div NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onResume(NinteichosaResultEntryTargetDiv div) {
        dgNinteichosaResultTaishosha_Row target = Holder.get();
        if (target != null) {
            Holder.remove();
            setDisabled_btnToFinish(div, false);
            List<dgNinteichosaResultTaishosha_Row> list = new ArrayList<>();
            for (dgNinteichosaResultTaishosha_Row row : _findTarget()) {
                if (row.getHihokenshaNo().equals(target.getHihokenshaNo())) {
                    list.add(target);
                } else {
                    list.add(row);
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
     * 復帰時の処理です。
     *
     * @param div NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onClick_btnToFinish(NinteichosaResultEntryTargetDiv div) {
        List<dgNinteichosaResultTaishosha_Row> dataSource = new ArrayList<>();
        for (dgNinteichosaResultTaishosha_Row selectedRow : dgTargetPersons(div).getSelectedItems()) {
            if (canBeSet_chosaKanryoDate(selectedRow)) {
                selectedRow.getChosaKanryoDate().setValue(FlexibleDate.getNowDate());
            }
            dataSource.add(selectedRow);
        }
        dataSource.addAll(DataGridUtil.unselectedItems(dgTargetPersons(div)));
        dgTargetPersons(div).setDataSource(dataSource);
        return _createResponseData(div);
    }

    private DataGrid<dgNinteichosaResultTaishosha_Row> dgTargetPersons(NinteichosaResultEntryTargetDiv div) {
        return div.getDgNinteichosaResultTaishosha();
    }

    private boolean canBeSet_chosaKanryoDate(dgNinteichosaResultTaishosha_Row target) {
        return !isEmpty_調査依頼日(target) && !isEmpty_調査実施日(target);
    }

    private boolean isEmpty_調査依頼日(dgNinteichosaResultTaishosha_Row target) {
        return isEmpty(target.getChosaIraiDate().getValue());
    }

    private boolean isEmpty_調査実施日(dgNinteichosaResultTaishosha_Row target) {
        return isEmpty(target.getChosaJisshiDate().getValue());
    }

    private boolean isEmpty(FlexibleDate date) {
        return (date == null) || (FlexibleDate.EMPTY.equals(date));
    }

    /**
     * dgNinteichosaResultTaishosha_Row を一時的に保持できます。
     */
    static final class Holder {

        private Holder() {
        }
        private static final RString KEY = new RString("NinteichosaResultEntryTarget");

        static void save(dgNinteichosaResultTaishosha_Row target) {
            ViewStateHolder.put(KEY, target);
        }

        static dgNinteichosaResultTaishosha_Row get() {
            return (dgNinteichosaResultTaishosha_Row) ViewStateHolder.get(
                    KEY.toString(), dgNinteichosaResultTaishosha_Row.class);
        }

        static void remove() {
            ViewStateHolder.remove(KEY);
        }
    }

    private ResponseData<NinteichosaResultEntryTargetDiv> _createResponseData(NinteichosaResultEntryTargetDiv div) {
        ResponseData<NinteichosaResultEntryTargetDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

}
