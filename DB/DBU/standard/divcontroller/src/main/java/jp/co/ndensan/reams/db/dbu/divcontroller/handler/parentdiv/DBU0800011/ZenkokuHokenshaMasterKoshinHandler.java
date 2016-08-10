/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0800011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.ZenkokuHokenshaMasterKoshinDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.dgHokenshas_Row;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 全国保険者マスタ更新のHandlerです。
 *
 * @reamsid_L DBU-4230-010 chenxiangyu
 */
public class ZenkokuHokenshaMasterKoshinHandler {

    private final ZenkokuHokenshaMasterKoshinDiv div;
    private static final RString 修正状態 = new RString("修正");
    private static final RString 削除状態 = new RString("削除");
    private static final RString 追加状態 = new RString("追加");

    /**
     * コンストラクタです。
     *
     * @param div ZenkokuHokenshaMasterKoshinDiv のクラスファイル
     */
    public ZenkokuHokenshaMasterKoshinHandler(ZenkokuHokenshaMasterKoshinDiv div) {
        this.div = div;
    }

    /**
     * 保険者番号の障順に保険者一覧Gridに展開します。
     *
     * @param 保険者一覧 保険者一覧List
     */
    public void set保険者一覧(List<Hokenja> 保険者一覧) {
        div.getHokenshaIchiran().getDgHokenshas().getDataSource().clear();
        for (Hokenja hokenja : 保険者一覧) {
            dgHokenshas_Row row = new dgHokenshas_Row();
            row.setHokenshaNo(hokenja.get保険者番号().value());
            row.setHokenshaName(hokenja.get保険者名());
            if (hokenja.get郵便番号() != null) {
                row.setYubinNo(hokenja.get郵便番号().getEditedYubinNo());
            }
            if (hokenja.get電話番号() != null) {
                row.setTelNo(hokenja.get電話番号().value());
            }
            if (hokenja.get住所() != null) {
                row.setJusho(hokenja.get住所());
            }
            div.getDgHokenshas().getDataSource().add(row);
        }
        div.getHokenshaIchiran().setHdnTodofuken(div.getHokenshaIchiran().getDdlTodofuken().getSelectedKey());
        div.getHokenshaIchiran().setDisplayNone(false);
        div.getHokenshaJoho().setDisplayNone(true);
    }

    /**
     * 保険者一覧パネルを非表示にし、保険者情報パネルを表示します。
     */
    public void show保険者情報() {
        div.getHokenshaJoho().setDisplayNone(false);
        RString 状態 = div.getHokenshaJoho().getHdnJotai();
        if (追加状態.equals(状態)) {
            clear保険者情報();
            div.getHokenshaJoho().getTxtHokenshaNo().setReadOnly(false);
            div.getHokenshaJoho().getTxtHokenshaName().setReadOnly(false);
            div.getHokenshaJoho().getTxtHokenshaTelNo().setReadOnly(false);
            div.getHokenshaJoho().getTxtHokenshaYubinNo().setReadOnly(false);
            div.getHokenshaJoho().getTxtHokenshaJusho().setReadOnly(false);
        } else if (修正状態.equals(状態)) {
            div.getHokenshaJoho().getTxtHokenshaNo().setReadOnly(true);
            div.getHokenshaJoho().getTxtHokenshaName().setReadOnly(false);
            div.getHokenshaJoho().getTxtHokenshaTelNo().setReadOnly(false);
            div.getHokenshaJoho().getTxtHokenshaYubinNo().setReadOnly(false);
            div.getHokenshaJoho().getTxtHokenshaJusho().setReadOnly(false);
        } else if (削除状態.equals(状態)) {
            div.getHokenshaJoho().getTxtHokenshaNo().setReadOnly(true);
            div.getHokenshaJoho().getTxtHokenshaName().setReadOnly(true);
            div.getHokenshaJoho().getTxtHokenshaTelNo().setReadOnly(true);
            div.getHokenshaJoho().getTxtHokenshaYubinNo().setReadOnly(true);
            div.getHokenshaJoho().getTxtHokenshaJusho().setReadOnly(true);
        }
    }

    /**
     * 選択された保険者で保険者情報パネルを表示します。
     *
     * @param row 選択された保険者情報
     */
    public void set保険者情報(dgHokenshas_Row row) {
        HokenshaJohoDiv hokenshaJohoDiv = div.getHokenshaJoho();
        hokenshaJohoDiv.getTxtHokenshaNo().setValue(row.getHokenshaNo());
        hokenshaJohoDiv.getTxtHokenshaName().setValue(row.getHokenshaName());
        hokenshaJohoDiv.getTxtHokenshaYubinNo().setValue(new YubinNo(row.getYubinNo()));
        hokenshaJohoDiv.getTxtHokenshaTelNo().setDomain(new TelNo(row.getTelNo()));
        hokenshaJohoDiv.getTxtHokenshaJusho().setDomain(new AtenaJusho(row.getJusho()));
    }

    /**
     * 保険者情報をクリアします。
     */
    public void clear保険者情報() {
        HokenshaJohoDiv hokenshaJohoDiv = div.getHokenshaJoho();
        hokenshaJohoDiv.getTxtHokenshaNo().clearValue();
        hokenshaJohoDiv.getTxtHokenshaName().clearValue();
        hokenshaJohoDiv.getTxtHokenshaYubinNo().clearValue();
        hokenshaJohoDiv.getTxtHokenshaTelNo().clearDomain();
        hokenshaJohoDiv.getTxtHokenshaJusho().clearDomain();
    }

    /**
     * 入力明細エリアの入力内容を保険者一覧Gridに反映させします。
     */
    public void update保険者一覧項目() {
        dgHokenshas_Row row = new dgHokenshas_Row();
        HokenshaJohoDiv hokenshaJohoDiv = div.getHokenshaJoho();
        row.setHokenshaNo(hokenshaJohoDiv.getTxtHokenshaNo().getValue());
        row.setHokenshaName(hokenshaJohoDiv.getTxtHokenshaName().getValue());
        row.setYubinNo(hokenshaJohoDiv.getTxtHokenshaYubinNo().getValue().getEditedYubinNo());
        row.setTelNo(hokenshaJohoDiv.getTxtHokenshaTelNo().getDomain().value());
        row.setJusho(hokenshaJohoDiv.getTxtHokenshaJusho().getDomain().value());
        int rowCount = 0;
        if (!追加状態.equals(hokenshaJohoDiv.getHdnJotai())) {
            rowCount = div.getHokenshaIchiran().getDgHokenshas().getClickedItem().getId();
        }
        if (修正状態.equals(hokenshaJohoDiv.getHdnJotai())) {
            if (!追加状態.equals(div.getDgHokenshas().getSelectedItems().get(0).getJotai())) {
                row.setJotai(修正状態);
            } else {
                row.setJotai(追加状態);
            }
            div.getDgHokenshas().getDataSource().set(rowCount, row);
        } else if (削除状態.equals(hokenshaJohoDiv.getHdnJotai())) {
            if (!追加状態.equals(div.getDgHokenshas().getSelectedItems().get(0).getJotai())) {
                row.setJotai(削除状態);
            } else {
                div.getDgHokenshas().getDataSource().remove(rowCount);
                return;
            }
            div.getDgHokenshas().getDataSource().set(rowCount, row);
        } else {
            row.setJotai(追加状態);
            div.getDgHokenshas().getDataSource().add(row);
        }
    }
}
