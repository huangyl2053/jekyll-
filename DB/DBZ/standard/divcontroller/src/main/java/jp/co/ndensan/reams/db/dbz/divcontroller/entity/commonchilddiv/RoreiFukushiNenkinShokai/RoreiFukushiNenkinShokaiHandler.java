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
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static final RString 状態_修正 = new RString("修正");
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
     * 老齢福祉年金「追加モード」の場合、保存ボタン押下の追加処理です。
     *
     * @param roreifukushinenkinjukyusha 老齢福祉年金受給者を管理
     * @return RoreiFukushiNenkinJukyusha 老齢福祉年金受給者を管理
     */
    public RoreiFukushiNenkinJukyusha set老齢福祉年金確定ボタン押下の追加(
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
    public void setDatagridRirekichiran(RString eventJotai, boolean hasChanged) {
        datagridRireki_Row row = new datagridRireki_Row();
        int index = -1;
        if (!状態_追加.equals(eventJotai)) {
            final RDate startDate = div.getPanelInput().getTxtStartDate().getValue();
            row = ItemList.of(div.getDatagridRireki().getDataSource())
                    .filter(new IPredicate<datagridRireki_Row>() {
                        @Override
                        public boolean evaluate(datagridRireki_Row t) {
                            return Objects.equals(t.getStartDate().getValue(), startDate);
                        }
                    })
                    .findFirst()
                    .orElse(new datagridRireki_Row());
            index = div.getDatagridRireki().getDataSource().indexOf(row);
        }
        row.getStartDate().setValue(div.getPanelInput().getTxtStartDate().getValue());
        row.getEndDate().setValue(div.getPanelInput().getTxtEndDate().getValue());
        if (状態_追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getDatagridRireki().getDataSource().add(row);
            return;
        }
        if (状態_削除.equals(eventJotai) && !状態_追加.equals(row.getJotai())) {
            row.setJotai(eventJotai);
            return;
        }
        if (index == -1) {
            return;
        }
        if (状態_削除.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getDatagridRireki().getDataSource().remove(index);
            return;
        }
        if (状態_修正.equals(eventJotai)) {
            if (状態_追加.equals(row.getJotai())) {
                div.getDatagridRireki().getDataSource().set(index, row);
                return;
            }
            row.setJotai(hasChanged ? eventJotai : RString.EMPTY);
            div.getDatagridRireki().getDataSource().set(index, row);
        }
    }

    /**
     * バリデーションを行います。
     *
     * @return {@link ValidationMessageControlPairs バリデーションの結果}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        RString state = div.getPanelInput().getState();
        if (状態_削除.equals(state)) {
            return pairs; // 削除時には検査項目なし。
        }
        pairs.add(validate受給期間());
        if (状態_追加.equals(state)) {
            pairs.add(validate受給開始日_重複なし());
        }
        pairs.add(validate履歴内_受給期間_重複なし());
        return pairs;
    }

    private static class ValidationMessage implements IValidationMessage {

        private final Message message;

        private ValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private ValidationMessageControlPairs validate受給期間() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        RDate startDate = div.getPanelInput().getTxtStartDate().getValue();
        RDate endDate = div.getPanelInput().getTxtEndDate().getValue();
        if (endDate == null || startDate == null || startDate.isBeforeOrEquals(endDate)) {
            return pairs;
        }
        pairs.add(new ValidationMessageControlPair(
                new ValidationMessage(
                        UrErrorMessages.期間が不正_追加メッセージあり２,
                        startDate.wareki().toDateString().toString(),
                        endDate.wareki().toDateString().toString()
                ),
                div.getPanelInput().getTxtStartDate(), div.getPanelInput().getTxtEndDate())
        );
        return pairs;
    }

    /**
     * 老齢福祉年金「追加モード」の場合、受給開始日が、DBに既に存在していれば、エラーとする。
     *
     * @return ValidationMessageControlPairs
     */
    private ValidationMessageControlPairs validate受給開始日_重複なし() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        RoreiFukushiNenkinJohoMapperParameter parameter = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                new ShikibetsuCode(div.getShikibetsuCode()),
                new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()),
                HihokenshaNo.EMPTY,
                FlexibleDate.EMPTY);
        if (RoreiFukushiNenkinJukyushaManager.createInstance().checkSameJukyuKaishibi(parameter) > 0) {
            pairs.add(new ValidationMessageControlPair(new ValidationMessage(
                    UrErrorMessages.既に登録済, div.getPanelInput().getTxtStartDate().getValue().wareki().toDateString().toString()),
                    div.getPanelInput().getTxtStartDate())
            );
        }
        return pairs;
    }

    /**
     * 履歴一覧に１件以上、受給期間が存在する場合、受給期間が重複していれば、エラーとする。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate履歴内_受給期間_重複なし() {
        List<datagridRireki_Row> list = copiedRowsAddingInput(div.getDatagridRireki().getDataSource(), div.getPanelInput());
        Collections.sort(list, new ComparatorByStartDateSort());

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            RDate endDate = RDate.MAX;
            if (list.get(i).getEndDate().getValue() != null) {
                endDate = list.get(i).getEndDate().getValue();
            }
            RDate nextStartDate = list.get(i + 1).getStartDate().getValue();
            if (endDate.isBefore(nextStartDate)) {
                continue;
            }
            pairs.add(createValidationMessage履歴間_期間重複(div, endDate, nextStartDate));
            return pairs;
        }
        return pairs;
    }

    /**
     * 受給期間の重複判定用に、履歴データグリッドの内容をコピーします。
     * ただし、入力中のデータとキー（開始日）が同じ物は、入力中の内容に設定します。
     * また、削除データは無視します。
     *
     * @param list 現在のデータグリッドの全要素
     * @param input 入力中の内容
     * @return コピー結果
     */
    private List<datagridRireki_Row> copiedRowsAddingInput(List<datagridRireki_Row> list, panelInputDiv input) {
        List<datagridRireki_Row> tempList = new ArrayList<>();
        int size = list.size();
        RDate inputStartDate = input.getTxtStartDate().getValue();
        boolean hasAppliedInput = false;
        for (int i = 0; i < size; i++) {
            datagridRireki_Row row = list.get(i);
            // 入力中のデータは、入力内容に置き換えて設定する。
            if (Objects.equals(inputStartDate, row.getStartDate().getValue())) {
                tempList.add(i, new datagridRireki_Row(RString.EMPTY, input.getTxtStartDate(), input.getTxtEndDate()));
                hasAppliedInput = true;
                continue;
            }
            // 削除データは、スキップする。
            if (Objects.equals(状態_削除, row.getJotai())) {
                continue;
            }
            // その他は、そのまま追加する。
            tempList.add(i, new datagridRireki_Row(RString.EMPTY,
                    row.getStartDate(),
                    row.getEndDate()));
        }
        if (!hasAppliedInput) {
            tempList.add(new datagridRireki_Row(RString.EMPTY, input.getTxtStartDate(), input.getTxtEndDate()));
        }
        return tempList;
    }

    /**
     * 老齢福祉年金情報グリッドの受給開始年月日、受給廃止年月日を受給開始年月日の昇順、受給廃止年月日の昇順処理です。
     */
    public static class ComparatorByStartDateSort implements Comparator<datagridRireki_Row>, Serializable {

        private static final long serialVersionUID = -5365704613493047853L;

        @Override
        public int compare(datagridRireki_Row arg0, datagridRireki_Row arg1) {
            return arg0.getStartDate().getValue().compareTo(arg1.getStartDate().getValue());
        }

    }

    private ValidationMessageControlPair createValidationMessage履歴間_期間重複(RoreiFukushiNenkinShokaiDiv div, RDate 判定中受給廃止日, RDate 次履歴受給開始日) {
        final RDate 入力受給廃止日 = div.getPanelInput().getTxtEndDate().getValue();
        if (Objects.equals(入力受給廃止日, 判定中受給廃止日)) {
            return new ValidationMessageControlPair(
                    new ValidationMessage(
                            UrErrorMessages.期間が不正_追加メッセージあり２,
                            new RStringBuilder().append("今受給廃止日：").append(入力受給廃止日.wareki().toDateString()).toString(),
                            new RStringBuilder().append("次受給開始日：").append(次履歴受給開始日.wareki().toDateString()).toString()
                    ),
                    div.getPanelInput().getTxtEndDate(), div.getDatagridRireki()
            );
        }
        return new ValidationMessageControlPair(
                new ValidationMessage(
                        UrErrorMessages.期間が不正_追加メッセージあり２,
                        new RStringBuilder().append("前受給廃止日：").append(判定中受給廃止日.wareki().toDateString()).toString(),
                        new RStringBuilder().append("今受給開始日：").append(次履歴受給開始日.wareki().toDateString()).toString()
                ),
                div.getPanelInput().getTxtStartDate(), div.getDatagridRireki()
        );
    }

}
