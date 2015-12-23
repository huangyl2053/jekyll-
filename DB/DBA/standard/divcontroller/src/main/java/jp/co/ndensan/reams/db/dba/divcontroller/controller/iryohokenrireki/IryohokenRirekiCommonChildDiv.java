/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.iryohokenrireki;

import jp.co.ndensan.reams.db.dba.business.iryohokenkanyujokyo.IryohokenRirekiCommonChildDivDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiCommonChildDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.dgIryohokenIchiran_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.pnlIryohokenJohoDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;

import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 共有子Div「医療保険履歴」のイベントを定義した共有子Divです。
 *
 */
public class IryohokenRirekiCommonChildDiv {

    /**
     * 初期化します。
     *
     * @param requestDiv
     * @return responseData
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onLoad(IryohokenRirekiCommonChildDivDiv requestDiv) {

        ResponseData<IryohokenRirekiCommonChildDivDiv> responseData = new ResponseData<>();

        List<UzT0007CodeEntity> entityList = CodeMaster.getCode(new CodeShubetsu(new RString("0001")));
        List<KeyValueDataSource> keyvalueList = new ArrayList<>();

        for (UzT0007CodeEntity codeEntity : entityList) {
            keyvalueList.add(new KeyValueDataSource(codeEntity.getコード().getKey(), codeEntity.getコード名称()));
        }

        requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setDataSource(keyvalueList);
        createHandlerOf(requestDiv).initialize(new RString("登録"), new RString("0001"));
        responseData.data = requestDiv;
        return responseData;
    }

    /**
     * 「医療保険を追加する」ボタン。<br/>
     *
     * @param requestDiv 医療保険情報Div
     * @return createResponseData
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_InsertButton(IryohokenRirekiCommonChildDivDiv requestDiv) {
        requestDiv.getPnlIryohokenJoho().setVisible(true);

        requestDiv.getPnlIryohokenJoho().getTbdKanyubi().clearValue();
        requestDiv.getPnlIryohokenJoho().getTbdDattabi().clearValue();
        requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().setSelectedValue(RString.EMPTY);
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().clearValue();
        requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().clearValue();
        requestDiv.getPnlIryohokenJoho().getTxtKigoBango().clearValue();
        requestDiv.getPnlIryohokenJoho().setStatus(new RString("追加"));
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
     * 選択ボタン。<br/>
     *
     * @param requestDiv 医療保険情報Div
     * @return 医療保険情報リスト
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_SelectButton(IryohokenRirekiCommonChildDivDiv requestDiv) {

        return createResponseData(setPnlIryohokenJohoData(new RString("選択"), requestDiv));

    }

    /**
     * 修正ボタン。<br/>
     *
     * @param requestDiv 医療保険情報Div
     * @return 医療保険情報リスト
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_ModifyButton(IryohokenRirekiCommonChildDivDiv requestDiv) {

        requestDiv.getPnlIryohokenJoho().setStatus(new RString("修正"));
        return createResponseData(setPnlIryohokenJohoData(new RString("修正"), requestDiv));
    }

    /**
     * 削除ボタン。<br/>
     *
     *
     * @param requestDiv 医療保険情報Div
     * @return createResponseData
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_DeleteButton(IryohokenRirekiCommonChildDivDiv requestDiv) {

        requestDiv.getPnlIryohokenJoho().setStatus(new RString("削除"));
        return createResponseData(setPnlIryohokenJohoData(new RString("削除"), requestDiv));
    }

    /**
     * 確定ボタンを押下の処理に実行されます。<br/>
     *
     * @param requestDiv
     * @return 医療保険情報Divを持つResponseData
     */
    public ResponseData<IryohokenRirekiCommonChildDivDiv> onClick_btnIryohokenKakute(IryohokenRirekiCommonChildDivDiv requestDiv) {

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
            ichiran_Row.setDefaultDataName2(new RString("追加"));
            list.add(count, ichiran_Row);
            加入日と脱退日の有効性チェック(list, count);

        } else {
            requestDiv.getDgIryohokenIchiran().getGridSetting().selectedRowCount();
            ichiran_Row = requestDiv.getDgIryohokenIchiran().getSelectedItems().get(0);
            count = list.indexOf(ichiran_Row);

            if (new RString("修正").equals(requestDiv.getPnlIryohokenJoho().getStatus())) {
                if (checkDataChangedError(ichiran_Row, requestDiv.getPnlIryohokenJoho())) {
                    throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
                }
            }

            if (!new RString("削除").equals(ichiran_Row.getDefaultDataName2())) {

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

                if (new RString("修正").equals(requestDiv.getPnlIryohokenJoho().getStatus())) {
                    if (!new RString("追加").equals(ichiran_Row.getDefaultDataName2())) {
                        ichiran_Row.setDefaultDataName2(new RString("修正"));
                    }
                }

                if (new RString("削除").equals(requestDiv.getPnlIryohokenJoho().getStatus())) {
                    if (!new RString("追加").equals(ichiran_Row.getDefaultDataName2())) {
                        ichiran_Row.setDefaultDataName2(new RString("削除"));
                    }
                }
            }
            if (new RString("削除").equals(requestDiv.getPnlIryohokenJoho().getStatus()) && new RString("追加").equals(ichiran_Row.getDefaultDataName2())) {
                list.remove(count);
            }
            if (new RString("追加").equals(requestDiv.getPnlIryohokenJoho().getStatus()) || new RString("修正").equals(requestDiv.getPnlIryohokenJoho().getStatus())) {

                加入日と脱退日の有効性チェック(list, count);
            }
        }
        clear(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 加入日と脱退日の有効性チェックの処理します。
     *
     * @param ichiran_Row
     * @return 証回収記録管理Divを持つResponseData
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

            if (!new RString("削除").equals(gridIndexData.getDefaultDataName2())) {
                if (gridIndexData.getDefaultDataName4() == null || RString.EMPTY.equals(gridIndexData.getDefaultDataName4())) {
                    iryohokenRireki.setDefaultDataName4(RDate.MAX.toDateString());
                }
                childDivDate.add(iryohokenRireki);
            }
        }

        IryohokenRirekiCommonChildDivDate iryohokenRirekiDate = new IryohokenRirekiCommonChildDivDate();
        if (!new RString("削除").equals(ichiran_Row.getDefaultDataName2())) {

            iryohokenRirekiDate.setDefaultDataName3(ichiran_Row.getDefaultDataName3());
            iryohokenRirekiDate.setDefaultDataName4(ichiran_Row.getDefaultDataName4());
            if (ichiran_Row.getDefaultDataName4() == null || RString.EMPTY.equals(ichiran_Row.getDefaultDataName4())) {
                iryohokenRirekiDate.setDefaultDataName4(RDate.MAX.toDateString());
            }
            childDivDate.add(iryohokenRirekiDate);
        }

        Collections.sort(childDivDate);
        int sortIndex = childDivDate.indexOf(iryohokenRirekiDate);

        if (ichiran_Row.getDefaultDataName4().compareTo(ichiran_Row.getDefaultDataName3()) < 0) {
            throw new ApplicationException(
                    DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                            ichiran_Row.getDefaultDataName4().toString(), ichiran_Row.getDefaultDataName3().toString()));
        }
        if (sortIndex == 0) {
            IryohokenRirekiCommonChildDivDate commonChildDivDate = childDivDate.get(sortIndex + 1);
            if (commonChildDivDate.getDefaultDataName3().compareTo(ichiran_Row.getDefaultDataName4()) < 0) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                                ichiran_Row.getDefaultDataName4().toString(), commonChildDivDate.getDefaultDataName3().toString()));
            }
        } else if (sortIndex == childDivDate.size() - 1) {
            IryohokenRirekiCommonChildDivDate commonChildDivDate = childDivDate.get(sortIndex - 1);
            if (ichiran_Row.getDefaultDataName3().compareTo(commonChildDivDate.getDefaultDataName4()) < 0) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                                commonChildDivDate.getDefaultDataName4().toString(), ichiran_Row.getDefaultDataName3().toString()));
            }
        } else {

            IryohokenRirekiCommonChildDivDate commonChildDivDateOn = childDivDate.get(sortIndex - 1);
            if (ichiran_Row.getDefaultDataName3().compareTo(commonChildDivDateOn.getDefaultDataName4()) < 0) {
                throw new ApplicationException(
                        DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                                commonChildDivDateOn.getDefaultDataName4().toString(), ichiran_Row.getDefaultDataName4().toString()));
            } else {
                IryohokenRirekiCommonChildDivDate commonChildDivDateNext = childDivDate.get(sortIndex + 1);

                if (commonChildDivDateNext.getDefaultDataName3().compareTo(ichiran_Row.getDefaultDataName4()) < 0) {
                    throw new ApplicationException(
                            DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(
                                    ichiran_Row.getDefaultDataName4().toString(), commonChildDivDateNext.getDefaultDataName3().toString()));
                }
            }
        }
    }

    /**
     * 取消ボタンを押下の処理に実行されます。<br/>
     *
     * @param requestDiv
     * @return 証回収記録管理Divを持つResponseData
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
        if (new RString("修正").equals(状態)) {
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
            if (new RString("削除").equals(状態)) {
                requestDiv.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(false);
                requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(false);
            } else {
                requestDiv.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(true);
                requestDiv.getPlIryohokenRireki().getBtnCancel().setDisabled(true);
            }
        }

        return requestDiv;
    }

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
        if (pnlIryohokenJoho.getTbdDattabi().getValue() == null || RString.EMPTY.equals(pnlIryohokenJoho.getTbdDattabi().getValue().toDateString())) {
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
