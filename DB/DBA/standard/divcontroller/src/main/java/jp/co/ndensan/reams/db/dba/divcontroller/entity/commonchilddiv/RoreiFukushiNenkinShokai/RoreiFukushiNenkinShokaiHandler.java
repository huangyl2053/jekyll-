/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.message.Dbamn00000ErrorMessages;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 老齢福祉年金画面のハンドラークラスです。
 *
 *
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
            if (busiRoreiFukushiNenkin.get受給終了年月日() != null) {
                row.getEndDate().setValue(new RDate(busiRoreiFukushiNenkin.get受給終了年月日().toString()));
            }
            rowList.add(row);
        }
        Collections.sort(rowList, new ComparatorByStartDateSort());
        div.getDatagridRireki().setDataSource(rowList);
        div.getPanelRireki().setDisplayNone(false);
        div.getTxtStartDate().setReadOnly(true);
        div.getTxtEndDate().setReadOnly(true);
        div.getBtnCancel().setDisabled(true);
        div.getBtnSave().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「情報を追加する」ボタン画面表示処理です。
     *
     */
    public void set老齢福祉年金追加ボタン画面表示() {
        div.getBtnCancel().setDisabled(false);
        div.getBtnSave().setDisabled(false);
        div.getTxtStartDate().setReadOnly(false);
        div.getTxtEndDate().setReadOnly(false);
        div.getPanelInput().setDisplayNone(false);
        div.getTxtStartDate().clearValue();
        div.getTxtEndDate().clearValue();
        div.getPanelRireki().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「修正」ボタン画面表示処理です。
     *
     */
    public void set老齢福祉年金修正ボタン画面表示() {
        div.getTxtEndDate().setReadOnly(false);
        div.getTxtStartDate().setReadOnly(true);
        div.getTxtStartDate().setValue(div.getDatagridRireki().getClickedItem().getStartDate().getValue());
        //if (!div.getDatagridRireki().getClickedItem().getEndDate().getValue().equals((""))) {
        div.getTxtEndDate().setValue(div.getDatagridRireki().getClickedItem().getEndDate().getValue());
        div.getPanelInput().setDisplayNone(false);
        div.getBtnCancel().setDisabled(false);
        div.getBtnSave().setDisabled(false);
        div.getPanelRireki().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「削除」ボタン画面表示処理です。
     *
     */
    public void set老齢福祉年金削除ボタン画面表示() {
        div.getTxtStartDate().setValue(div.getDatagridRireki().getClickedItem().getStartDate().getValue());
        div.getTxtEndDate().setValue(div.getDatagridRireki().getClickedItem().getEndDate().getValue());
        div.getPanelInput().setDisplayNone(false);
        div.getTxtStartDate().setReadOnly(true);
        div.getTxtEndDate().setReadOnly(true);
        div.getBtnCancel().setDisabled(false);
        div.getBtnSave().setDisabled(false);
        div.getPanelRireki().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「入力を取消」ボタン画面表示です。
     *
     */
    public void set老齢福祉年金取消ボタン画面表示() {
        div.getPanelRireki().setDisplayNone(false);
        div.getPanelInput().setDisplayNone(true);
        div.getTxtStartDate().clearValue();
        div.getTxtEndDate().clearValue();
    }

    /**
     * 老齢福祉年金情報の確定するボタン画面表示です。
     *
     */
    public void set確定ボタン画面表示() {
        div.getPanelRireki().setDisabled(false);
        div.getPanelInput().setDisplayNone(true);
        div.getTxtStartDate().clearValue();
        div.getTxtEndDate().clearValue();
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
        return roreifukushinenkinjukyusha.createBuilderForEdit()
                .set被保険者番号(new HihokenshaNo(div.getHihokenshaNo().toString()))
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
        row.getStartDate().setValue(div.getTxtStartDate().getValue());
        row.getEndDate().setValue(div.getTxtEndDate().getValue());
        int index = div.getDatagridRireki().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getDatagridRireki().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getDatagridRireki().getDataSource().remove(index);
        } else {
            row.setJotai(eventJotai);
            div.getDatagridRireki().getDataSource().set(index, row);
        }
    }

    /**
     * 老齢福祉年金「追加モード」の場合、「受給開始日の重複チェック」、 DBには、既に存在していれば、エラーとする。
     */
    public void set受給開始日の重複チェック() {
        RoreiFukushiNenkinJohoMapperParameter addCheck = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                new ShikibetsuCode(div.getShikibetsuCode()),
                new FlexibleDate(div.getTxtStartDate().getValue().toDateString()),
                HihokenshaNo.EMPTY,
                FlexibleDate.EMPTY);
        if (RoreiFukushiNenkinJukyushaManager.createInstance().checkSameJukyuKaishibi(addCheck) > 0) {
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(
                    div.getTxtStartDate().getValue().toString()));
        }
    }

    /**
     * 終了日が開始日以前の場合、メッセージを表示します。
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 終了日が開始日以前のチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(Dbamn00000ErrorMessages.終了日が開始日以前));
        return validationMessages;
    }

    /**
     * 「受給期間の重複チェック」、履歴一覧に１件以上、受給期間が存在場合、受給期間が重複していれば、エラーとする。
     *
     * @param eventJotai 状態
     */
    public void set受給期間の重複チェック(RString eventJotai) {
        datagridRireki_Row clickRow = div.getDatagridRireki().getClickedItem();
        int clickID = div.getDatagridRireki().getClickedRowId();
        List<datagridRireki_Row> list = new ArrayList<>();
        list.addAll(div.getDatagridRireki().getDataSource());
        if (状態_追加.equals(eventJotai)) {
            list.add(new datagridRireki_Row(
                    RString.EMPTY,
                    div.getTxtStartDate(),
                    div.getTxtEndDate()));
        } else {
            clickRow.getStartDate().setValue(div.getTxtStartDate().getValue());
            clickRow.getEndDate().setValue(div.getTxtEndDate().getValue());
            list.set(clickID, clickRow);
        }
        list = getSeiReKi(list);
        Collections.sort(list, new ComparatorByStartDateSort());
        for (int i = 0; i < list.size() - 1; i++) {
            if (!list.get(i).getEndDate().getValue()
                    .isBefore(list.get(i + 1).getStartDate().getValue())) {
                throw new ApplicationException(UrErrorMessages.期間が不正_追加メッセージあり２.getMessage().replace(
                        list.get(i).getEndDate().getValue().toString(), list.get(i + 1).getStartDate().getValue()
                        .toString()));
            }
        }
    }

    /**
     * 老齢福祉年金情報グリッドの受給開始年月日、受給廃止年月日を受給開始年月日の昇順、受給廃止年月日の昇順処理です。
     *
     */
    public class ComparatorByStartDateSort implements Comparator {

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
}
