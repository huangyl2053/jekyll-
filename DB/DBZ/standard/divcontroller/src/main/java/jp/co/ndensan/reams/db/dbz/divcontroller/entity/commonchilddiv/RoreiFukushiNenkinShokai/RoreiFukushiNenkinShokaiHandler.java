/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 老齢福祉年金画面のハンドラークラスです。
 *
 * @reamsid_L DBA-0220-010 dongyabin
 */
public class RoreiFukushiNenkinShokaiHandler {

    private final RoreiFukushiNenkinShokaiDiv div;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public RoreiFukushiNenkinShokaiHandler(RoreiFukushiNenkinShokaiDiv div) {
        this.div = div;
    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param 一覧情報 老齢福祉年金受給者リスト情報
     */
    public void set老齢福祉年金情報一覧表示グリッド(List<RoreiFukushiNenkinJukyusha> 一覧情報) {
        List<datagridRireki_Row> rowList = new ArrayList<>();
        for (RoreiFukushiNenkinJukyusha busiRoreiFukushiNenkin : 一覧情報) {
            datagridRireki_Row row = new datagridRireki_Row();
            row.getStartDate().setValue(new RDate(busiRoreiFukushiNenkin.get受給開始年月日().toString()));
            if (busiRoreiFukushiNenkin.get受給終了年月日() != null && busiRoreiFukushiNenkin.get受給終了年月日().isValid()) {
                row.getEndDate().setValue(new RDate(busiRoreiFukushiNenkin.get受給終了年月日().toString()));
            }
            rowList.add(row);
        }
        Collections.sort(rowList, new ComparatorByStartDateSort());
        div.getDatagridRireki().setDataSource(rowList);
        div.getPanelRireki().setDisplayNone(false);
        div.getPanelInput().getTxtStartDate().setDisabled(true);
        div.getPanelInput().getTxtEndDate().setDisabled(true);
        div.getPanelInput().getBtnCancel().setDisabled(true);
        div.getPanelInput().getBtnSave().setDisabled(true);
        if (RoreiFukushiNenkinShokaiDiv.ModeC.init.equals(div.getMode_ModeC())) {
            div.getPanelRireki().setDisabled(true);
            div.getPanelInput().setDisplayNone(true);
            div.getDatagridRireki().getGridSetting().getColumn(new RString("jotai")).setVisible(false);
            div.getDatagridRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDatagridRireki().getGridSetting().setIsShowModifyButtonColumn(false);
        }
    }

    /**
     * 老齢福祉年金情報の「情報を追加する」ボタン画面表示処理です。
     *
     */
    public void set老齢福祉年金追加ボタン画面表示() {
        div.getPanelInput().setDisabled(false);
        div.getPanelInput().getBtnCancel().setDisabled(false);
        div.getPanelInput().getBtnSave().setDisabled(false);
        div.getPanelInput().getTxtStartDate().setDisabled(false);
        div.getPanelInput().getTxtEndDate().setDisabled(false);
        div.getPanelInput().setDisplayNone(false);
        div.getPanelInput().getTxtStartDate().clearValue();
        div.getPanelInput().getTxtEndDate().clearValue();
        div.getPanelRireki().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「修正」ボタン画面表示処理です。
     *
     */
    public void set老齢福祉年金修正ボタン画面表示() {
        div.getPanelInput().setDisabled(false);
        div.getPanelInput().getTxtEndDate().setDisabled(false);
        div.getPanelInput().getTxtStartDate().setDisabled(true);
        div.getPanelInput().getTxtStartDate().setValue(div.getDatagridRireki().getClickedItem().getStartDate().getValue());
        div.getPanelInput().getTxtEndDate().setValue(div.getDatagridRireki().getClickedItem().getEndDate().getValue());
        div.getPanelInput().setDisplayNone(false);
        div.getPanelInput().getBtnCancel().setDisabled(false);
        div.getPanelInput().getBtnSave().setDisabled(false);
        div.getPanelRireki().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「削除」ボタン画面表示処理です。
     *
     */
    public void set老齢福祉年金削除ボタン画面表示() {
        div.getPanelInput().setDisabled(false);
        div.getPanelInput().getTxtStartDate().setValue(div.getDatagridRireki().getClickedItem().getStartDate().getValue());
        div.getPanelInput().getTxtEndDate().setValue(div.getDatagridRireki().getClickedItem().getEndDate().getValue());
        div.getPanelInput().setDisplayNone(false);
        div.getPanelInput().getTxtStartDate().setDisabled(true);
        div.getPanelInput().getTxtEndDate().setDisabled(true);
        div.getPanelInput().getBtnCancel().setDisabled(false);
        div.getPanelInput().getBtnSave().setDisabled(false);
        div.getPanelRireki().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「入力を取消」ボタン画面表示です。
     *
     */
    public void set老齢福祉年金取消ボタン画面表示() {
        div.getPanelRireki().setDisabled(false);
        div.getPanelInput().getTxtStartDate().clearValue();
        div.getPanelInput().getTxtEndDate().clearValue();
        div.getPanelInput().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の確定するボタン画面表示です。
     *
     */
    public void set確定ボタン画面表示() {
        div.getPanelRireki().setDisabled(false);
        div.getPanelInput().getBtnCancel().setDisabled(true);
        div.getPanelInput().getBtnSave().setDisabled(true);
        div.getPanelInput().getTxtStartDate().clearValue();
        div.getPanelInput().getTxtEndDate().clearValue();
        div.getPanelInput().getTxtStartDate().setDisabled(true);
        div.getPanelInput().getTxtEndDate().setDisabled(true);

    }

    /**
     * 老齢福祉年金「更新モード」の場合、保存ボタン押下の更新処理です。
     *
     * @param roreifukushinenkinjukyusha 老齢福祉年金受給者を管理
     * @return RoreiFukushiNenkinJukyusha 老齢福祉年金受給者を管理
     */
    public RoreiFukushiNenkinJukyusha set老齢福祉年金確定ボタン押下の更新処理(
            RoreiFukushiNenkinJukyusha roreifukushinenkinjukyusha) {
        return roreifukushinenkinjukyusha.createBuilderForEdit().set受給廃止年月日(new FlexibleDate(
                div.getPanelInput().getTxtEndDate().getValue().toDateString())).build();
    }

    /**
     * 老齢福祉年金「削除モード」の場合、保存ボタン押下の削除処理です。
     *
     * @param roreifukushinenkinjukyusha 老齢福祉年金受給者を管理
     * @return RoreiFukushiNenkinJukyusha 老齢福祉年金受給者を管理
     */
    public RoreiFukushiNenkinJukyusha set老齢福祉年金確定ボタン押下の削除処理(
            RoreiFukushiNenkinJukyusha roreifukushinenkinjukyusha) {
        return roreifukushinenkinjukyusha.createBuilderForEdit()
                .set受給廃止年月日(new FlexibleDate(div.getPanelInput().getTxtEndDate().getValue().toDateString()))
                .build();
    }

    /**
     * 老齢福祉年金「追加モード」の場合、保存ボタン押下の追加処理です。
     *
     * @param roreifukushinenkinjukyusha 老齢福祉年金受給者を管理
     * @return RoreiFukushiNenkinJukyusha 老齢福祉年金受給者を管理
     */
    public RoreiFukushiNenkinJukyusha set年金確定ボタン押下の追加(
            RoreiFukushiNenkinJukyusha roreifukushinenkinjukyusha) {
        if (div.getPanelInput().getTxtEndDate().getValue() == null) {
            return roreifukushinenkinjukyusha.createBuilderForEdit()
                    .set被保険者番号(new HihokenshaNo(div.getHihokenshaNo()))
                    .set受給廃止年月日(null)
                    .build();
        }
        return roreifukushinenkinjukyusha.createBuilderForEdit()
                .set被保険者番号(new HihokenshaNo(div.getHihokenshaNo()))
                .set受給廃止年月日(new FlexibleDate(div.getPanelInput().getTxtEndDate().getValue().toDateString()))
                .build();
    }

    /**
     * 老齢福祉年金情報を設定します。
     *
     * @param eventJotai 状態
     */
    public void setDatagridRirekichiran(RString eventJotai) {
        datagridRireki_Row row = new datagridRireki_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = div.getDatagridRireki().getActiveRow();
        }
        row.getStartDate().setValue(div.getPanelInput().getTxtStartDate().getValue());
        row.getEndDate().setValue(div.getPanelInput().getTxtEndDate().getValue());
        int index = div.getDatagridRireki().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getDatagridRireki().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai)
                   && !状態_追加.equals(div.getDatagridRireki().getActiveRow().getJotai())) {
            row.setJotai(eventJotai);
        } else if (状態_削除.equals(eventJotai)
                   && 状態_追加.equals(div.getDatagridRireki().getActiveRow().getJotai())) {
            div.getDatagridRireki().getDataSource().remove(index);
        } else {
            row.setJotai(eventJotai);
            div.getDatagridRireki().getDataSource().set(index, row);
        }
    }

    /**
     * 老齢福祉年金「追加モード」の場合、「受給開始日の重複チェック」、 DBには、既に存在していれば、エラーとする。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs set受給開始日の重複チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RoreiFukushiNenkinJohoMapperParameter addCheck = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                new ShikibetsuCode(div.getShikibetsuCode()),
                new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()),
                HihokenshaNo.EMPTY,
                FlexibleDate.EMPTY);
        if (RoreiFukushiNenkinJukyushaManager.createInstance().checkSameJukyuKaishibi(addCheck) > 0) {
            addMessage_既に登録済(validPairs,
                    div.getPanelInput().getTxtStartDate().getValue().toString());
        }
        return validPairs;
    }

    /**
     * 「受給期間の重複チェック」、履歴一覧に１件以上、受給期間が存在場合、受給期間が重複していれば、エラーとする。
     *
     * @param eventJotai 状態
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs set受給期間の重複チェック(RString eventJotai) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        datagridRireki_Row clickRow = div.getDatagridRireki().getClickedItem();
        int clickID = div.getDatagridRireki().getClickedRowId();
        List<datagridRireki_Row> list = new ArrayList<>();
        list.addAll(div.getDatagridRireki().getDataSource());
        if (状態_追加.equals(eventJotai)) {
            list.add(new datagridRireki_Row(
                    RString.EMPTY,
                    div.getPanelInput().getTxtStartDate(),
                    div.getPanelInput().getTxtEndDate()));
        } else {
            clickRow.getStartDate().setValue(div.getPanelInput().getTxtStartDate().getValue());
            clickRow.getEndDate().setValue(div.getPanelInput().getTxtEndDate().getValue());
            list.set(clickID, clickRow);
        }
        list = getSeiReKi(list);
        Collections.sort(list, new ComparatorByStartDateSort());
        for (int i = 0; i < list.size() - 1; i++) {
            RDate date = RDate.MAX;
            if (list.get(i).getEndDate().getValue() != null) {
                date = list.get(i).getEndDate().getValue();
            }
            if (!date.isBefore(list.get(i + 1).getStartDate().getValue())) {
                addMessage(validPairs,
                        date.toString(),
                        list.get(i + 1).getStartDate().getValue().toString());
            }
        }
        return validPairs;
    }

    /**
     * 老齢福祉年金情報グリッドの受給開始年月日、受給廃止年月日を受給開始年月日の昇順、受給廃止年月日の昇順処理です。
     *
     */
    public static class ComparatorByStartDateSort implements Comparator, Serializable {

        private static final long serialVersionUID = -5365704613493047853L;

        @Override
        public int compare(Object arg0, Object arg1) {
            datagridRireki_Row row0 = (datagridRireki_Row) arg0;
            datagridRireki_Row row1 = (datagridRireki_Row) arg1;
            return row0.getStartDate().getValue().compareTo(row1.getStartDate().getValue());
        }

    }

    private List<datagridRireki_Row> getSeiReKi(List<datagridRireki_Row> list) {
        List<datagridRireki_Row> tempList = new ArrayList<>();
        for (datagridRireki_Row row : list) {
            tempList.add(new datagridRireki_Row(RString.EMPTY,
                    row.getStartDate(),
                    row.getEndDate()));
        }
        return tempList;
    }

    /**
     * 期間が不正チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param replace 受給開始日
     * @param replace1 受給廃止日
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs addMessage(ValidationMessageControlPairs validPairs, String replace, String replace1) {
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                UrErrorMessages.期間が不正_追加メッセージあり２, replace, replace1), div.getPanelInput()
                .getTxtStartDate(), div.getPanelInput().getTxtEndDate()));
        return validPairs;
    }

    private ValidationMessageControlPairs addMessage_既に登録済(ValidationMessageControlPairs validPairs, String replace) {
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                UrErrorMessages.既に登録済, replace), div.getPanelInput().getTxtStartDate()));
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
