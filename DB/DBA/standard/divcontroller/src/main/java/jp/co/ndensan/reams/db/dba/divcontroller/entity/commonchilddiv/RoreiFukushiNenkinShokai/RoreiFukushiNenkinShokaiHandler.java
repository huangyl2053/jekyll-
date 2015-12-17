/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.ViewStateKeys;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 老齢福祉年金情報です。
 *
 *
 */
public class RoreiFukushiNenkinShokaiHandler {

    private final RoreiFukushiNenkinShokaiDiv div;

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
     * @param 一覧情報
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
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
                = Models.create(一覧情報);
        ViewStateHolder.put(ViewStateKeys.老齢福祉年金情報一覧, roreiFukushiNenkinJukyusha);
        div.getDatagridRireki().setDataSource(rowList);
        div.getPanelInput().setDisplayNone(true);
        div.getPanelRireki().setDisplayNone(false);
        div.getPanelInput().getTxtStartDate().setDisabled(false);
        div.getPanelInput().getTxtEndDate().setDisabled(false);
    }

    /**
     * 老齢福祉年金情報の「情報を追加する」ボタン処理です。
     *
     */
    public void set老齢福祉年金追加ボタン画面表示() {
        div.getPanelRireki().setDisplayNone(true);
        div.getPanelInput().setDisplayNone(false);
    }

    /**
     * 老齢福祉年金情報の「修正」ボタン処理です。
     *
     */
    public void set老齢福祉年金修正ボタン画面表示() {
        div.getPanelInput().getTxtStartDate().setValue(new RDate(div.getDatagridRireki().getClickedItem().getStartDate()
                .toString()));
        if (!div.getDatagridRireki().getClickedItem().getEndDate().isEmpty()) {
            div.getPanelInput().getTxtEndDate().setValue(new RDate(div.getDatagridRireki().getClickedItem().getEndDate()
                    .toString()));
        }
        div.getPanelRireki().setDisplayNone(true);
        div.getPanelInput().setDisplayNone(false);
    }

    /**
     * 老齢福祉年金情報の「削除」ボタン処理です。
     *
     */
    public void set老齢福祉年金削除ボタン画面表示() {
        div.getPanelInput().getTxtStartDate().setValue(new RDate(div.getDatagridRireki().getClickedItem().getStartDate()
                .toString()));
        if (!div.getDatagridRireki().getClickedItem().getEndDate().isEmpty()) {
            div.getPanelInput().getTxtEndDate().setValue(new RDate(div.getDatagridRireki().getClickedItem().getEndDate()
                    .toString()));
        }
        div.getPanelRireki().setDisplayNone(true);
        div.getPanelInput().setDisplayNone(false);
        div.getPanelInput().getTxtStartDate().setDisabled(true);
        div.getPanelInput().getTxtEndDate().setDisabled(true);
    }

    /**
     * 老齢福祉年金情報の「入力を取消」ボタンです。
     *
     */
    public void set老齢福祉年金取消ボタン画面表示() {
        div.getPanelInput().getTxtStartDate().setDisabled(false);
        div.getPanelInput().getTxtEndDate().setDisabled(false);
        div.getPanelRireki().setDisplayNone(false);
        div.getPanelInput().setDisplayNone(true);
        div.getPanelInput().getTxtStartDate().clearValue();
        div.getPanelInput().getTxtEndDate().clearValue();
    }

    /**
     * 老齢福祉年金情報の「保存する」ボタン入力チェックです。
     *
     * @return List<RoreiFukushiNenkinJohoMapperParameter> 老齢福祉年金情報パラメータ
     */
    public List<RoreiFukushiNenkinJohoMapperParameter> set老齢福祉年金入力チェック() {
        if (div.getTxtStartDate().getValue().isBefore(div.getTxtEndDate().getValue())) {
            // TODO QA 238 2015/12/15 提出
            // throw new ApplicationException(UrErrorMessages.日付の前後関係逆転以降.getMessage());
        }
        List<datagridRireki_Row> list = div.getDatagridRireki().getDataSource();
        List<RoreiFukushiNenkinJohoMapperParameter> kikancheck = new ArrayList();
        for (datagridRireki_Row row : list) {
            RDate startDate = new RDate(row.getStartDate().toString());
            RDate endDate = RDate.MIN;
            if (!row.getEndDate().isEmpty()) {
                endDate = new RDate(row.getEndDate().toString());
            }
            RoreiFukushiNenkinJohoMapperParameter pa = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                    new ShikibetsuCode(div.getShikibetsuCode()),
                    new FlexibleDate(startDate.toDateString()),
                    new HihokenshaNo(div.getHihokenshaNo()),
                    new FlexibleDate(endDate.toDateString()));
            kikancheck.add(pa);
        }
        return kikancheck;
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
                        new FlexibleDate(div.getPanelInput().getTxtEndDate().getValue().toDateString())).build();
            }
        }
        return new RoreiFukushiNenkinJukyusha(
                new ShikibetsuCode(div.getShikibetsuCode()),
                new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()));
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
                new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()));
    }

    /**
     * 老齢福祉年金「追加モード」の場合、「受給開始日の重複チェック」です。
     *
     */
    public void set老齢福祉年金追加チェック() {
        RoreiFukushiNenkinJohoMapperParameter addCheck = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                new ShikibetsuCode(div.getShikibetsuCode()),
                new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()),
                HihokenshaNo.EMPTY,
                FlexibleDate.EMPTY);
        if (RoreiFukushiNenkinJukyushaManager.createInstance().checkSameJukyuKaishibi(addCheck) > 0) {
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage());
        }
    }

    /**
     * 老齢福祉年金「追加モード」の場合、保存ボタン押下の追加処理です。
     *
     * @param busiRoreiFukushiNenkin 老齢福祉年金受給者を管理
     * @return RoreiFukushiNenkinJukyusha 老齢福祉年金受給者を管理
     */
    public RoreiFukushiNenkinJukyusha set年金保存ボタン押下の追加(RoreiFukushiNenkinJukyusha busiRoreiFukushiNenkin) {
        busiRoreiFukushiNenkin = busiRoreiFukushiNenkin.createBuilderForEdit().set受給廃止年月日(
                new FlexibleDate(div.getPanelInput().getTxtEndDate().getValue().toDateString())).build();
        busiRoreiFukushiNenkin = busiRoreiFukushiNenkin.createBuilderForEdit().set被保険者番号(
                new HihokenshaNo(div.getHihokenshaNo().toString())).build();
        return busiRoreiFukushiNenkin;
    }
}
