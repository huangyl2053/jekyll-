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
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.ViewStateKeys;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.message.Dbamn00000ErrorMessages;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 老齢福祉年金情報です。
 *
 *
 */
public class RoreiFukushiNenkinShokaiHandler {

    private final RoreiFukushiNenkinShokaiDiv div;
    private static final RString 追加 = new RString("追加");

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
            row.setStartDate(busiRoreiFukushiNenkin.get受給開始年月日().wareki().toDateString());
            if (busiRoreiFukushiNenkin.get受給終了年月日() != null) {
                row.setEndDate(busiRoreiFukushiNenkin.get受給終了年月日().wareki().toDateString());
            }
            rowList.add(row);
        }
        Collections.sort(rowList, new ComparatorByStartDateSort());
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
                = Models.create(一覧情報);
        ViewStateHolder.put(ViewStateKeys.老齢福祉年金情報一覧, roreiFukushiNenkinJukyusha);
        div.getDatagridRireki().setDataSource(rowList);
        div.getPanelInput().setDisplayNone(true);
        div.getPanelRireki().setDisplayNone(false);
        div.getTxtStartDate().setDisabled(false);
        div.getTxtEndDate().setDisabled(false);
    }

    /**
     * 老齢福祉年金情報の「情報を追加する」ボタン処理です。
     *
     */
    public void set老齢福祉年金追加ボタン画面表示() {
        div.getTxtStartDate().clearValue();
        div.getTxtEndDate().clearValue();
        div.getPanelRireki().setDisplayNone(true);
        div.getPanelInput().setDisplayNone(false);
    }

    /**
     * 老齢福祉年金情報の「修正」ボタン処理です。
     *
     */
    public void set老齢福祉年金修正ボタン画面表示() {
        div.getTxtStartDate().setValue(new RDate(div.getDatagridRireki().getClickedItem().getStartDate()
                .toString()));
        if (!div.getDatagridRireki().getClickedItem().getEndDate().isEmpty()) {
            div.getTxtEndDate().setValue(new RDate(div.getDatagridRireki().getClickedItem().getEndDate()
                    .toString()));
        }
        div.getPanelRireki().setDisplayNone(true);
        div.getTxtStartDate().setReadOnly(true);
        div.getPanelInput().setDisplayNone(false);
    }

    /**
     * 老齢福祉年金情報の「削除」ボタン処理です。
     *
     */
    public void set老齢福祉年金削除ボタン画面表示() {
        div.getTxtStartDate().setValue(new RDate(div.getDatagridRireki().getClickedItem().getStartDate()
                .toString()));
        if (!div.getDatagridRireki().getClickedItem().getEndDate().isEmpty()) {
            div.getTxtEndDate().setValue(new RDate(div.getDatagridRireki().getClickedItem().getEndDate()
                    .toString()));
        }
        div.getPanelRireki().setDisplayNone(true);
        div.getPanelInput().setDisplayNone(false);
        div.getTxtStartDate().setDisabled(true);
        div.getTxtEndDate().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「入力を取消」ボタンです。
     *
     */
    public void set老齢福祉年金取消ボタン画面表示() {
        div.getTxtStartDate().setDisabled(false);
        div.getTxtEndDate().setDisabled(false);
        div.getPanelRireki().setDisplayNone(false);
        div.getPanelInput().setDisplayNone(true);
        div.getTxtStartDate().clearValue();
        div.getTxtEndDate().clearValue();
    }

    /**
     * 老齢福祉年金「更新モード」の場合、保存ボタン押下の更新処理です。
     *
     * @return RoreiFukushiNenkinJukyusha 老齢福祉年金受給者を管理
     */
    public RoreiFukushiNenkinJukyusha set老齢福祉年金保存ボタン押下の更新処理() {
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyushaList
                = ViewStateHolder.get(ViewStateKeys.老齢福祉年金情報一覧, Models.class);
        for (RoreiFukushiNenkinJukyusha rorei : roreiFukushiNenkinJukyushaList) {
            if (rorei.identifier().get識別コード().getColumnValue().equals(div.getShikibetsuCode())
                    && rorei.identifier().get受給開始年月日().equals(new FlexibleDate(div.getTxtStartDate().getValue()
                                    .toDateString()))) {
                return rorei.createBuilderForEdit().set受給廃止年月日(
                        new FlexibleDate(div.getTxtEndDate().getValue().toDateString())).build();
            }
        }
        return new RoreiFukushiNenkinJukyusha(
                new ShikibetsuCode(div.getShikibetsuCode()),
                new FlexibleDate(div.getTxtStartDate().getValue().toDateString()));
    }

    /**
     * 老齢福祉年金「削除モード」の場合、保存ボタン押下の削除処理です。
     *
     * @return RoreiFukushiNenkinJukyusha 老齢福祉年金受給者を管理
     */
    public RoreiFukushiNenkinJukyusha set老齢福祉年金保存ボタン押下の削除処理() {
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyushaList
                = ViewStateHolder.get(ViewStateKeys.老齢福祉年金情報一覧, Models.class);
        for (RoreiFukushiNenkinJukyusha rorei : roreiFukushiNenkinJukyushaList) {
            if (rorei.identifier().get識別コード().getColumnValue().equals(div.getShikibetsuCode())
                    && rorei.identifier().get受給開始年月日().equals(new FlexibleDate(div.getTxtStartDate().getValue()
                                    .toDateString()))) {
                return rorei.deleted();
            }
        }
        return new RoreiFukushiNenkinJukyusha(new ShikibetsuCode(div.getShikibetsuCode()),
                new FlexibleDate(div.getTxtStartDate().getValue().toDateString()));
    }

    /**
     * 老齢福祉年金「追加モード」の場合、保存ボタン押下の追加処理です。
     *
     * @param busiRoreiFukushiNenkin 老齢福祉年金受給者を管理
     * @return RoreiFukushiNenkinJukyusha 老齢福祉年金受給者を管理
     */
    public RoreiFukushiNenkinJukyusha set年金保存ボタン押下の追加(RoreiFukushiNenkinJukyusha busiRoreiFukushiNenkin) {
        busiRoreiFukushiNenkin = busiRoreiFukushiNenkin.createBuilderForEdit().set受給廃止年月日(
                new FlexibleDate(div.getTxtEndDate().getValue().toDateString())).build();
        busiRoreiFukushiNenkin = busiRoreiFukushiNenkin.createBuilderForEdit().set被保険者番号(
                new HihokenshaNo(div.getHihokenshaNo().toString())).build();
        return busiRoreiFukushiNenkin;
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
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage());
        }
    }

    /**
     * 終了日が開始日以前の場合、メッセージを表示します。
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 終了日が開始日以前のチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        // TODO QA 238 2015/12/15 提出 メッセージを待ち
        validationMessages.add(new ValidationMessageControlPair(Dbamn00000ErrorMessages.終了日が開始日以前));
        return validationMessages;
    }

    /**
     * 老齢福祉年金「受給期間の重複チェック」、履歴一覧に１件以上、受給期間が存在場合、受給期間が重複していれば、エラーとする。
     *
     */
    public void set受給期間の重複チェック() {
        datagridRireki_Row clickRow = div.getDatagridRireki().getClickedItem();
        int clickID = div.getDatagridRireki().getClickedRowId();
        List<datagridRireki_Row> list = div.getDatagridRireki().getDataSource();
        if (追加.equals(div.getModel())) {
            list.add(new datagridRireki_Row(div.getTxtStartDate().getValue().toDateString(),
                    div.getTxtEndDate().getValue().toDateString()));
        } else {
            clickRow.setStartDate(div.getTxtStartDate().getValue().wareki().toDateString());
            clickRow.setEndDate(div.getTxtEndDate().getValue().wareki().toDateString());
            list.set(clickID, clickRow);
        }
        list = getSeiReKi(list);
        Collections.sort(list, new ComparatorByStartDateSort());
        for (int i = 0; i < list.size() - 1; i++) {
            if (!new RDate(list.get(i).getEndDate().toString())
                    .isBefore(new RDate(list.get(i + 1).getStartDate().toString()))) {
                throw new ApplicationException(UrErrorMessages.期間が不正_追加メッセージあり２.getMessage().replace(
                        list.get(i).getEndDate().toString(), list.get(i + 1).getStartDate().toString()));
            }
        }
    }

    private List<datagridRireki_Row> getSeiReKi(List<datagridRireki_Row> list) {
        List<datagridRireki_Row> tempList = new ArrayList<>();
        for (datagridRireki_Row row : list) {
            tempList.add(new datagridRireki_Row(new RDate(row.getStartDate().toString())
                    .seireki().separator(Separator.NONE).toDateString(),
                    new RDate(row.getEndDate().toString())
                    .seireki().separator(Separator.NONE).toDateString()));
        }
        return tempList;
    }

    /**
     * 老齢福祉年金情報グリッドの受給開始年月日、受給廃止年月日を受給開始年月日の昇順、受給廃止年月日の昇順処理です。
     *
     */
    public static class ComparatorByStartDateSort implements Comparator {

        @Override
        public int compare(Object arg0, Object arg1) {
            datagridRireki_Row row0 = (datagridRireki_Row) arg0;
            datagridRireki_Row row1 = (datagridRireki_Row) arg1;
            return row0.getStartDate().compareTo(row1.getStartDate());
        }
    }
}
