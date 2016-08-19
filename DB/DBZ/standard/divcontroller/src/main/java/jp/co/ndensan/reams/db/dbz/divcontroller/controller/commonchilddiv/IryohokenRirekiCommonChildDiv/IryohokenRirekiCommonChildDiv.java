/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.IryohokenRirekiCommonChildDiv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.iryohokenkanyujokyo.IryohokenRirekiCommonChildDivDate;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.dgIryohokenIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.pnlIryohokenJohoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div「医療保険履歴」のイベントを定義した共有子Divです。
 *
 * @reamsid_L DBA-0230-010 hezhenzhen
 *
 */
public class IryohokenRirekiCommonChildDiv {

    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_選択 = new RString("選択");

    /**
     * 初期化します。
     *
     * @param requestDiv IryohokenRirekiCommonChildDivDiv
     * @return ResponseData<IryohokenRirekiCommonChildDivDiv>
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onLoad(IryohokenRirekiCommonChildDivDiv requestDiv) {
        ResponseData<IryohokenRirekiCommonChildDivDiv> responseData = new ResponseData<>();
        RString 医療保険情報_識別コード = requestDiv.get識別コード();
        RString mode = requestDiv.getモード();
        if (!RString.isNullOrEmpty(医療保険情報_識別コード) && !RString.isNullOrEmpty(mode)) {
            createHandlerOf(requestDiv).initialize(mode, 医療保険情報_識別コード);
        }
        responseData.data = requestDiv;
        return responseData;
    }

    /**
     * 「医療保険を追加する」ボタン押下です。
     *
     * @param requestDiv IryohokenRirekiCommonChildDivDiv
     * @return ResponseData<IryohokenRirekiCommonChildDivDiv>
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_InsertButton(IryohokenRirekiCommonChildDivDiv requestDiv) {
        requestDiv.getPnlIryohokenJoho().setVisible(true);

        requestDiv.getPnlIryohokenJoho().getTbdKanyubi().clearValue();
        requestDiv.getPnlIryohokenJoho().getTbdDattabi().clearValue();
        requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setSelectedValue(RString.EMPTY);
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().clearValue();
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().clearValue();
        requestDiv.getPnlIryohokenJoho().getTxtKigoBango().clearValue();
        requestDiv.getPnlIryohokenJoho().setStatus(状態_追加);
        requestDiv.getPnlIryohokenJoho().setVisible(true);
        requestDiv.getPnlIryohokenJoho().getTbdKanyubi().setReadOnly(false);
        requestDiv.getPnlIryohokenJoho().getTbdDattabi().setReadOnly(false);
        requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setDisabled(false);
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().setReadOnly(false);
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().setReadOnly(false);
        requestDiv.getPnlIryohokenJoho().getTxtKigoBango().setReadOnly(false);
        requestDiv.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(false);
        requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(false);

        return createResponseData(requestDiv);
    }

    /**
     * 選択ボタン押下です。
     *
     * @param requestDiv IryohokenRirekiCommonChildDivDiv
     * @return createResponseData 状態_選択
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_SelectButton(IryohokenRirekiCommonChildDivDiv requestDiv) {
        return createResponseData(setPnlIryohokenJohoData(状態_選択, requestDiv));
    }

    /**
     * 修正ボタン押下です。
     *
     * @param requestDiv IryohokenRirekiCommonChildDivDiv
     * @return createResponseData
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_ModifyButton(IryohokenRirekiCommonChildDivDiv requestDiv) {
        requestDiv.getPnlIryohokenJoho().setStatus(状態_修正);
        return createResponseData(setPnlIryohokenJohoData(状態_修正, requestDiv));
    }

    /**
     * 削除ボタン押下です。
     *
     * @param requestDiv IryohokenRirekiCommonChildDivDiv
     * @return createResponseData
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_DeleteButton(IryohokenRirekiCommonChildDivDiv requestDiv) {
        requestDiv.getPnlIryohokenJoho().setStatus(状態_削除);
        return createResponseData(setPnlIryohokenJohoData(状態_削除, requestDiv));
    }

    /**
     * 確定ボタンを押下の処理に実行されます。<br/>
     *
     * @param requestDiv IryohokenRirekiCommonChildDivDiv
     * @return 医療保険情報Divを持つResponseData
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_btnIryohokenKakute(IryohokenRirekiCommonChildDivDiv requestDiv) {

        ValidationMessageControlPairs validationMessage = createValidationHandlerOf(requestDiv).種別と保険者番号と保険者名と称記号番号の有効性チェック();
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(validationMessage).respond();
        }

        if (requestDiv.getPnlIryohokenJoho().getStatus() != null && !requestDiv.getPnlIryohokenJoho().getStatus().equals(RString.EMPTY)) {
            ifelse(requestDiv);
        }
        clear(requestDiv);

        return ResponseData.of(requestDiv).respond();
    }

    private void ifelse(IryohokenRirekiCommonChildDivDiv requestDiv) {
        RString 医療保険情報_識別コード = requestDiv.get識別コード();

        List<dgIryohokenIchiran_Row> 医療保険情報RiReKiNoSortList = requestDiv.getDgIryohokenIchiran().getDataSource();
        Collections.sort(医療保険情報RiReKiNoSortList, new RiReKiNoComparator());
        Decimal riReKiNo = Decimal.ZERO;
        if (!医療保険情報RiReKiNoSortList.isEmpty()) {
            riReKiNo = 医療保険情報RiReKiNoSortList.get(医療保険情報RiReKiNoSortList.size() - 1)
                    .getRirekiNo().getValue().add(Decimal.ONE);
        }

        List<dgIryohokenIchiran_Row> list = requestDiv.getDgIryohokenIchiran().getDataSource();
        dgIryohokenIchiran_Row ichiran_Row;
        int count = 0;
        if (new RString("追加").equals(requestDiv.getPnlIryohokenJoho().getStatus())) {
            ichiran_Row = new dgIryohokenIchiran_Row();
            ichiran_Row.getKanyuDate().setValue(new FlexibleDate(requestDiv.getPnlIryohokenJoho().getTbdKanyubi().getValue().toDateString()));
            if (requestDiv.getPnlIryohokenJoho().getTbdDattabi().getValue() == null) {
                ichiran_Row.getDattaiDate().setValue(FlexibleDate.EMPTY);
            } else {
                ichiran_Row.getDattaiDate().setValue(new FlexibleDate(requestDiv.getPnlIryohokenJoho().getTbdDattabi().getValue().toDateString()));
            }
            ichiran_Row.setShubetsu(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedValue());
            ichiran_Row.setHokenshaCode(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
            ichiran_Row.setHokenshaName(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
            ichiran_Row.setKigoNo(requestDiv.getPnlIryohokenJoho().getTxtKigoBango().getValue());
            RStringBuilder 保険者名 = new RStringBuilder();
            保険者名.append(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
            if (保険者名.toRString().isEmpty()) {
                保険者名.append(new RString(":"));
            }
            保険者名.append(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
            ichiran_Row.setHokensha(保険者名.toRString());
            ichiran_Row.setShubetsuCode(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedKey());

            ichiran_Row.getRirekiNo().setValue(riReKiNo);
            ichiran_Row.setShikibetsuCode(医療保険情報_識別コード);
            ichiran_Row.setState(状態_追加);
            ichiran_Row.setShichosonCode(requestDiv.get市町村コード());
            list.add(count, ichiran_Row);
            加入日と脱退日の有効性チェック(list, count);

        } else {
            requestDiv.getDgIryohokenIchiran().getGridSetting().selectedRowCount();
            ichiran_Row = requestDiv.getDgIryohokenIchiran().getSelectedItems().get(0);
            count = list.indexOf(ichiran_Row);

            if (状態_修正.equals(requestDiv.getPnlIryohokenJoho().getStatus())
                    && checkDataChangedError(ichiran_Row, requestDiv.getPnlIryohokenJoho())) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            }

            if (!状態_削除.equals(ichiran_Row.getState())) {

                ichiran_Row.getKanyuDate().setValue(new FlexibleDate(requestDiv.getPnlIryohokenJoho().getTbdKanyubi().getValue().toDateString()));
                ichiran_Row.getDattaiDate().setValue(requestDiv.getPnlIryohokenJoho().getTbdDattabi().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(requestDiv.getPnlIryohokenJoho().getTbdDattabi().getValue().toDateString()));

                ichiran_Row.setShubetsu(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedValue());
                ichiran_Row.setHokenshaCode(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
                ichiran_Row.setHokenshaName(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
                ichiran_Row.setKigoNo(requestDiv.getPnlIryohokenJoho().getTxtKigoBango().getValue());
                ichiran_Row.setShubetsuCode(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedKey());
                ichiran_Row.setShichosonCode(requestDiv.get市町村コード());
                RStringBuilder 保険者名 = new RStringBuilder();
                保険者名.append(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
                保険者名.append(new RString(":"));
                保険者名.append(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
                ichiran_Row.setHokensha(保険者名.toRString());
                setState(ichiran_Row, requestDiv);
            }
            if (状態_削除.equals(requestDiv.getPnlIryohokenJoho().getStatus()) && 状態_追加.equals(ichiran_Row.getState())) {
                list.remove(count);
            }
            if (状態_追加.equals(requestDiv.getPnlIryohokenJoho().getStatus())
                    || 状態_修正.equals(requestDiv.getPnlIryohokenJoho().getStatus())) {

                加入日と脱退日の有効性チェック(list, count);
            }
        }

        Collections.sort(list, new DateComparatorOrderByDesc());
    }

    private void setState(dgIryohokenIchiran_Row ichiran_Row, IryohokenRirekiCommonChildDivDiv requestDiv) {
        if (状態_修正.equals(requestDiv.getPnlIryohokenJoho().getStatus()) && !状態_追加.equals(ichiran_Row.getState())) {
            ichiran_Row.setState(状態_修正);
        }

        if (状態_削除.equals(requestDiv.getPnlIryohokenJoho().getStatus()) && !状態_追加.equals(ichiran_Row.getState())) {
            ichiran_Row.setState(状態_削除);
        }
    }

    /**
     * 加入日と脱退日の有効性チェックの処理します。
     *
     * @param dgIryohokenIchiranlist List<dgIryohokenIchiran_Row>
     * @param index
     * @return
     */
    private void 加入日と脱退日の有効性チェック(List<dgIryohokenIchiran_Row> dgIryohokenIchiranlist, int index) {
        List<IryohokenRirekiCommonChildDivDate> childDivDate = new ArrayList<>();
        dgIryohokenIchiran_Row ichiran_Row = dgIryohokenIchiranlist.get(index);

        int currentIndex = 0;

        for (dgIryohokenIchiran_Row gridIndexData : dgIryohokenIchiranlist) {

            if (index == currentIndex) {
                currentIndex++;
                continue;
            }
            currentIndex++;
            IryohokenRirekiCommonChildDivDate iryohokenRireki = new IryohokenRirekiCommonChildDivDate();
            iryohokenRireki.setKanyuDate(gridIndexData.getKanyuDate().getValue());
            iryohokenRireki.setDattaiDate(gridIndexData.getDattaiDate().getValue());

            if (!状態_削除.equals(gridIndexData.getState())) {
                if (iryohokenRireki.getDattaiDate() == null || FlexibleDate.EMPTY.equals(iryohokenRireki.getDattaiDate())) {
                    iryohokenRireki.setDattaiDate(FlexibleDate.MAX);
                }
                childDivDate.add(iryohokenRireki);
            }
        }

        IryohokenRirekiCommonChildDivDate iryohokenRirekiDate = new IryohokenRirekiCommonChildDivDate();
        if (!状態_削除.equals(ichiran_Row.getState())) {

            iryohokenRirekiDate.setKanyuDate(ichiran_Row.getKanyuDate().getValue());
            iryohokenRirekiDate.setDattaiDate(ichiran_Row.getDattaiDate().getValue());
            if (ichiran_Row.getDattaiDate() == null || FlexibleDate.EMPTY.equals(ichiran_Row.getDattaiDate().getValue())) {
                iryohokenRirekiDate.setDattaiDate(FlexibleDate.MAX);
            }
            childDivDate.add(iryohokenRirekiDate);
        }

        Collections.sort(childDivDate, new DateComparator());
        int sortIndex = childDivDate.indexOf(iryohokenRirekiDate);

        if (iryohokenRirekiDate.getDattaiDate().isBefore(iryohokenRirekiDate.getKanyuDate())) {
            throw new ApplicationException(
                    DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace("加入日", "脱退日"));
        }
        if (childDivDate.size() <= 1) {
            return;
        }
        if (sortIndex == 0) {
            IryohokenRirekiCommonChildDivDate nextData = childDivDate.get(sortIndex + 1);
            if (nextData.getKanyuDate().isBefore(iryohokenRirekiDate.getDattaiDate())) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace("脱退日", "次データの加入日"));
            }
        } else if (sortIndex == childDivDate.size() - 1) {
            IryohokenRirekiCommonChildDivDate preData = childDivDate.get(sortIndex - 1);
            if (iryohokenRirekiDate.getKanyuDate().isBefore(preData.getDattaiDate())) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace("前データの脱退日", "加入日"));
            }
        } else {

            IryohokenRirekiCommonChildDivDate preData = childDivDate.get(sortIndex - 1);
            if (ichiran_Row.getKanyuDate().getValue().isBefore(preData.getDattaiDate())) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace("前データの脱退日", "加入日"));
            } else if (childDivDate.get(sortIndex + 1).getKanyuDate().isBefore(ichiran_Row.getDattaiDate().getValue())) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace("脱退日", "次データの加入日"));
            }

        }
    }

    private static class DateComparator implements Comparator<IryohokenRirekiCommonChildDivDate>, Serializable {

        private static final long serialVersionUID = 3893667276202140686L;

        @Override
        public int compare(IryohokenRirekiCommonChildDivDate o1, IryohokenRirekiCommonChildDivDate o2) {
            return o1.getKanyuDate().compareTo(o2.getKanyuDate());
        }
    }

    private static class DateComparatorOrderByDesc implements Comparator<dgIryohokenIchiran_Row>, Serializable {

        private static final long serialVersionUID = 3893667276202140686L;

        @Override
        public int compare(dgIryohokenIchiran_Row o1, dgIryohokenIchiran_Row o2) {
            return o2.getKanyuDate().getValue().compareTo(o1.getKanyuDate().getValue());
        }
    }

    private static class RiReKiNoComparator implements Comparator<dgIryohokenIchiran_Row>, Serializable {

        private static final long serialVersionUID = 644289093934160725L;

        @Override
        public int compare(dgIryohokenIchiran_Row o1, dgIryohokenIchiran_Row o2) {
            return o1.getRirekiNo().getValue().compareTo(o2.getRirekiNo().getValue());
        }
    }

    /**
     * 取消ボタンを押下の処理に実行されます。
     *
     * @param requestDiv IryohokenRirekiCommonChildDivDiv
     * @return ResponseData<IryohokenRirekiCommonChildDivDiv>
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_btnCancel(IryohokenRirekiCommonChildDivDiv requestDiv) {
        ResponseData<IryohokenRirekiCommonChildDivDiv> response = new ResponseData<>();
        response.data = clear(requestDiv);
        requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(true);
        return response;
    }

    private IryohokenRirekiHandler createHandlerOf(IryohokenRirekiCommonChildDivDiv requestDiv) {
        return new IryohokenRirekiHandler(requestDiv);
    }

    private IryohokenRirekiValidationHandler createValidationHandlerOf(IryohokenRirekiCommonChildDivDiv requestDiv) {
        return new IryohokenRirekiValidationHandler(requestDiv);
    }

    private ResponseData<IryohokenRirekiCommonChildDivDiv> createResponseData(IryohokenRirekiCommonChildDivDiv requestDiv) {
        ResponseData<IryohokenRirekiCommonChildDivDiv> response = new ResponseData();
        response.data = requestDiv;
        return response;

    }

    private IryohokenRirekiCommonChildDivDiv setPnlIryohokenJohoData(RString 状態, IryohokenRirekiCommonChildDivDiv requestDiv) {

        requestDiv.getDgIryohokenIchiran().getGridSetting().selectedRowCount();
        dgIryohokenIchiran_Row dgIryohokenIchiranRow = requestDiv.getDgIryohokenIchiran().getSelectedItems().get(0);
        requestDiv.getPnlIryohokenJoho().getTbdKanyubi().setValue(new RDate(dgIryohokenIchiranRow.getKanyuDate().getValue().toString()));
        if (dgIryohokenIchiranRow.getDattaiDate() != null && !FlexibleDate.EMPTY.equals(dgIryohokenIchiranRow.getDattaiDate().getValue())) {
            requestDiv.getPnlIryohokenJoho().getTbdDattabi().setValue(new RDate(dgIryohokenIchiranRow.getDattaiDate().getValue().toString()));
        } else {
            requestDiv.getPnlIryohokenJoho().getTbdDattabi().clearValue();
        }

        requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setSelectedValue(dgIryohokenIchiranRow.getShubetsu());
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().setValue(dgIryohokenIchiranRow.getHokenshaCode());
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().setValue(dgIryohokenIchiranRow.getHokenshaName());
        requestDiv.getPnlIryohokenJoho().getTxtKigoBango().setValue(dgIryohokenIchiranRow.getKigoNo());
        if (状態_修正.equals(状態)) {
            requestDiv.getPnlIryohokenJoho().setVisible(true);
            requestDiv.getPnlIryohokenJoho().getTbdKanyubi().setReadOnly(false);
            requestDiv.getPnlIryohokenJoho().getTbdDattabi().setReadOnly(false);
            requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setDisabled(false);
            requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().setReadOnly(false);
            requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().setReadOnly(false);
            requestDiv.getPnlIryohokenJoho().getTxtKigoBango().setReadOnly(false);
            requestDiv.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(false);
            requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(false);
        } else {

            requestDiv.getPnlIryohokenJoho().setVisible(true);
            requestDiv.getPnlIryohokenJoho().getTbdKanyubi().setReadOnly(true);
            requestDiv.getPnlIryohokenJoho().getTbdDattabi().setReadOnly(true);
            requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setDisabled(true);
            requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().setReadOnly(true);
            requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().setReadOnly(true);
            requestDiv.getPnlIryohokenJoho().getTxtKigoBango().setReadOnly(true);
            if (状態_削除.equals(状態)) {
                requestDiv.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(false);
                requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(false);
            } else {
                requestDiv.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(true);
                requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(true);
            }
        }

        return requestDiv;
    }

    /**
     * 医療保険情報エリアの清除です。
     *
     * @param requestDiv
     * @return
     */
    private IryohokenRirekiCommonChildDivDiv clear(IryohokenRirekiCommonChildDivDiv requestDiv) {

        requestDiv.getPnlIryohokenJoho().setVisible(true);
        requestDiv.getPnlIryohokenJoho().getTbdKanyubi().setReadOnly(true);
        requestDiv.getPnlIryohokenJoho().getTbdDattabi().setReadOnly(true);
        requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setDisabled(true);
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().setReadOnly(true);
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().setReadOnly(true);
        requestDiv.getPnlIryohokenJoho().getTxtKigoBango().setReadOnly(true);
        requestDiv.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(true);
        requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(true);
        requestDiv.getPnlIryohokenJoho().getTbdKanyubi().clearValue();
        requestDiv.getPnlIryohokenJoho().getTbdDattabi().clearValue();
        requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setSelectedValue(RString.EMPTY);
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().clearValue();
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().clearValue();
        requestDiv.getPnlIryohokenJoho().getTxtKigoBango().clearValue();
        requestDiv.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(true);
        requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(true);
        return requestDiv;
    }

    private boolean checkDataChangedError(dgIryohokenIchiran_Row ichiran_Row, pnlIryohokenJohoDiv pnlIryohokenJoho) {

        FlexibleDate dattabi;
        if (pnlIryohokenJoho.getTbdDattabi().getValue() == null) {
            dattabi = FlexibleDate.EMPTY;
        } else {
            dattabi = new FlexibleDate(pnlIryohokenJoho.getTbdDattabi().getValue().toDateString());
        }

        return ichiran_Row.getKanyuDate().getValue().equals(new FlexibleDate(pnlIryohokenJoho.getTbdKanyubi().getValue().toDateString()))
                && ichiran_Row.getDattaiDate().getValue().equals(dattabi)
                && ichiran_Row.getShubetsu().equals(pnlIryohokenJoho.getDdlSyubetsu().getSelectedValue())
                && ichiran_Row.getHokenshaName().equals(pnlIryohokenJoho.getTxtHokensyaMeisho().getValue())
                && ichiran_Row.getKigoNo().equals(pnlIryohokenJoho.getTxtKigoBango().getValue())
                && ichiran_Row.getHokenshaCode().equals(pnlIryohokenJoho.getTxtHokensyaKodo().getValue());
    }
}
