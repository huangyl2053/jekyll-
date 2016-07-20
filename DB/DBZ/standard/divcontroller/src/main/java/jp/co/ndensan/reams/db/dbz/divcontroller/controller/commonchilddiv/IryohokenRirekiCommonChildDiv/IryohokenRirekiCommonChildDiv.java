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
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
        RString 医療保険情報_識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, RString.class);
        List<dgIryohokenIchiran_Row> 医療保険情報RiReKiNoSortList = requestDiv.getDgIryohokenIchiran().getDataSource();
        Collections.sort(医療保険情報RiReKiNoSortList, new RiReKiNoComparator());
        Decimal riReKiNo = Decimal.ZERO;
        if (!医療保険情報RiReKiNoSortList.isEmpty()) {
            riReKiNo = 医療保険情報RiReKiNoSortList.get(医療保険情報RiReKiNoSortList.size() - 1)
                    .getDefaultDataName9().getValue().add(Decimal.ONE);
        }

        List<dgIryohokenIchiran_Row> list = requestDiv.getDgIryohokenIchiran().getDataSource();
        dgIryohokenIchiran_Row ichiran_Row;
        int count = 0;
        if (new RString("追加").equals(requestDiv.getPnlIryohokenJoho().getStatus())) {
            ichiran_Row = new dgIryohokenIchiran_Row();
            ichiran_Row.setDefaultDataName3(requestDiv.getPnlIryohokenJoho().getTbdKanyubi().getValue().wareki().toDateString());
            if (requestDiv.getPnlIryohokenJoho().getTbdDattabi().getValue() == null) {
                ichiran_Row.setDefaultDataName4(RString.EMPTY);
            } else {
                ichiran_Row.setDefaultDataName4(requestDiv.getPnlIryohokenJoho().getTbdDattabi().getValue().wareki().toDateString());
            }
            ichiran_Row.setDefaultDataName5(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedValue());
            ichiran_Row.setDefaultDataName8(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
            ichiran_Row.setDefaultDataName6(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
            ichiran_Row.setDefaultDataName7(requestDiv.getPnlIryohokenJoho().getTxtKigoBango().getValue());
            RStringBuilder 保険者名 = new RStringBuilder();
            保険者名.append(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
            保険者名.append(new RString(":"));
            保険者名.append(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
            ichiran_Row.setDefaultDataName10(保険者名.toRString());
            ichiran_Row.setDefaultDataName11(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedKey());
            ichiran_Row.setDefaultDataName12(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
            ichiran_Row.setDefaultDataName13(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());

            ichiran_Row.getDefaultDataName9().setValue(riReKiNo);
            ichiran_Row.setDefaultDataName0(医療保険情報_識別コード);
            ichiran_Row.setDefaultDataName2(状態_追加);
            ichiran_Row.setDefaultDataName1(RString.EMPTY);
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

            if (!状態_削除.equals(ichiran_Row.getDefaultDataName2())) {

                ichiran_Row.setDefaultDataName3(requestDiv.getPnlIryohokenJoho().getTbdKanyubi().getValue().wareki().toDateString());
                ichiran_Row.setDefaultDataName4(requestDiv.getPnlIryohokenJoho().getTbdDattabi().getValue() == null
                        ? RString.EMPTY : requestDiv.getPnlIryohokenJoho().getTbdDattabi().getValue().wareki().toDateString());

                ichiran_Row.setDefaultDataName5(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedValue());
                ichiran_Row.setDefaultDataName8(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
                ichiran_Row.setDefaultDataName6(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
                ichiran_Row.setDefaultDataName7(requestDiv.getPnlIryohokenJoho().getTxtKigoBango().getValue());
                ichiran_Row.setDefaultDataName11(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedKey());
                ichiran_Row.setDefaultDataName12(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
                ichiran_Row.setDefaultDataName13(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
                RStringBuilder 保険者名 = new RStringBuilder();
                保険者名.append(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue());
                保険者名.append(new RString(":"));
                保険者名.append(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue());
                ichiran_Row.setDefaultDataName10(保険者名.toRString());
                setState(ichiran_Row, requestDiv);
            }
            if (状態_削除.equals(requestDiv.getPnlIryohokenJoho().getStatus()) && 状態_追加.equals(ichiran_Row.getDefaultDataName2())) {
                list.remove(count);
            }
            if (状態_追加.equals(requestDiv.getPnlIryohokenJoho().getStatus())
                    || 状態_修正.equals(requestDiv.getPnlIryohokenJoho().getStatus())) {

                加入日と脱退日の有効性チェック(list, count);
            }
        }
    }

    private void setState(dgIryohokenIchiran_Row ichiran_Row, IryohokenRirekiCommonChildDivDiv requestDiv) {
        if (状態_修正.equals(requestDiv.getPnlIryohokenJoho().getStatus()) && !状態_追加.equals(ichiran_Row.getDefaultDataName2())) {
            ichiran_Row.setDefaultDataName2(状態_修正);
        }

        if (状態_削除.equals(requestDiv.getPnlIryohokenJoho().getStatus()) && !状態_追加.equals(ichiran_Row.getDefaultDataName2())) {
            ichiran_Row.setDefaultDataName2(状態_削除);
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
            iryohokenRireki.setDefaultDataName3(gridIndexData.getDefaultDataName3());
            iryohokenRireki.setDefaultDataName4(gridIndexData.getDefaultDataName4());

            if (!状態_削除.equals(gridIndexData.getDefaultDataName2())) {
                if (gridIndexData.getDefaultDataName4() == null || RString.EMPTY.equals(gridIndexData.getDefaultDataName4())) {
                    iryohokenRireki.setDefaultDataName4(RDate.MAX.toDateString());
                }
                childDivDate.add(iryohokenRireki);
            }
        }

        IryohokenRirekiCommonChildDivDate iryohokenRirekiDate = new IryohokenRirekiCommonChildDivDate();
        if (!状態_削除.equals(ichiran_Row.getDefaultDataName2())) {

            iryohokenRirekiDate.setDefaultDataName3(ichiran_Row.getDefaultDataName3());
            iryohokenRirekiDate.setDefaultDataName4(ichiran_Row.getDefaultDataName4());
            if (ichiran_Row.getDefaultDataName4() == null || RString.EMPTY.equals(ichiran_Row.getDefaultDataName4())) {
                iryohokenRirekiDate.setDefaultDataName4(RDate.MAX.toDateString());
            }
            childDivDate.add(iryohokenRirekiDate);
        }

        Collections.sort(childDivDate, new DateComparator());
        int sortIndex = childDivDate.indexOf(iryohokenRirekiDate);

        if (new RDate(ichiran_Row.getDefaultDataName4().toString()).isBefore(new RDate(ichiran_Row.getDefaultDataName3().toString()))) {
            throw new ApplicationException(
                    DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                            ichiran_Row.getDefaultDataName3().toString(), ichiran_Row.getDefaultDataName4().toString()));
        }
        if (childDivDate.size() <= 1) {
            return;
        }
        if (sortIndex == 0) {
            IryohokenRirekiCommonChildDivDate nextData = childDivDate.get(sortIndex + 1);
            if (new RDate(ichiran_Row.getDefaultDataName3().toString()).isBefore(new RDate(nextData.getDefaultDataName4().toString()))) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                                ichiran_Row.getDefaultDataName4().toString(), nextData.getDefaultDataName3().toString()));
            }
        } else if (sortIndex == childDivDate.size() - 1) {
            IryohokenRirekiCommonChildDivDate preData = childDivDate.get(sortIndex - 1);
            if (new RDate(ichiran_Row.getDefaultDataName3().toString()).isBefore(new RDate(preData.getDefaultDataName4().toString()))) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                                preData.getDefaultDataName4().toString(), ichiran_Row.getDefaultDataName3().toString()));
            }
        } else {

            IryohokenRirekiCommonChildDivDate preData = childDivDate.get(sortIndex - 1);
            if (new RDate(ichiran_Row.getDefaultDataName3().toString()).isBefore(new RDate(preData.getDefaultDataName4().toString()))) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                                preData.getDefaultDataName4().toString(), ichiran_Row.getDefaultDataName3().toString()));
            } else if (new RDate(ichiran_Row.getDefaultDataName4().toString())
                    .isBefore(new RDate(childDivDate.get(sortIndex + 1).getDefaultDataName3().toString()))) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                                ichiran_Row.getDefaultDataName4().toString(), childDivDate.get(sortIndex + 1).getDefaultDataName3().toString()));
            }

        }
    }

    private static class DateComparator implements Comparator<IryohokenRirekiCommonChildDivDate>, Serializable {

        private static final long serialVersionUID = 3893667276202140686L;

        @Override
        public int compare(IryohokenRirekiCommonChildDivDate o1, IryohokenRirekiCommonChildDivDate o2) {
            return o1.getDefaultDataName3().compareTo(o2.getDefaultDataName3());
        }
    }

    private static class RiReKiNoComparator implements Comparator<dgIryohokenIchiran_Row>, Serializable {

        private static final long serialVersionUID = 644289093934160725L;

        @Override
        public int compare(dgIryohokenIchiran_Row o1, dgIryohokenIchiran_Row o2) {
            return o1.getDefaultDataName9().getValue().compareTo(o2.getDefaultDataName9().getValue());
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
        requestDiv.getPnlIryohokenJoho().getTbdKanyubi().setValue(new RDate(dgIryohokenIchiranRow.getDefaultDataName3().toString()));
        if (dgIryohokenIchiranRow.getDefaultDataName4() != null && !RString.EMPTY.equals(dgIryohokenIchiranRow.getDefaultDataName4())) {
            requestDiv.getPnlIryohokenJoho().getTbdDattabi().setValue(new RDate(dgIryohokenIchiranRow.getDefaultDataName4().toString()));
        } else {
            requestDiv.getPnlIryohokenJoho().getTbdDattabi().clearValue();
        }

        requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setSelectedValue(dgIryohokenIchiranRow.getDefaultDataName5());
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().setValue(dgIryohokenIchiranRow.getDefaultDataName8());
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().setValue(dgIryohokenIchiranRow.getDefaultDataName6());
        requestDiv.getPnlIryohokenJoho().getTxtKigoBango().setValue(dgIryohokenIchiranRow.getDefaultDataName7());
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

        RString dattabi;
        if (pnlIryohokenJoho.getTbdDattabi().getValue() == null) {
            dattabi = RString.EMPTY;
        } else {
            dattabi = pnlIryohokenJoho.getTbdDattabi().getValue().wareki().toDateString();
        }

        return ichiran_Row.getDefaultDataName3().equals(pnlIryohokenJoho.getTbdKanyubi().getValue().wareki().toDateString())
                && ichiran_Row.getDefaultDataName4().equals(dattabi)
                && ichiran_Row.getDefaultDataName5().equals(pnlIryohokenJoho.getDdlSyubetsu().getSelectedValue())
                && ichiran_Row.getDefaultDataName6().equals(pnlIryohokenJoho.getTxtHokensyaMeisho().getValue())
                && ichiran_Row.getDefaultDataName7().equals(pnlIryohokenJoho.getTxtKigoBango().getValue())
                && ichiran_Row.getDefaultDataName8().equals(pnlIryohokenJoho.getTxtHokensyaKodo().getValue());
    }
}
