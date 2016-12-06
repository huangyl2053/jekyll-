/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiijoho.ShujiiMaster;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * 主治医マスタ画面のハンドラークラスです。
 *
 * @reamsid_L DBE-0250-010 suguangjun
 */
public class ShujiiMasterHandler {

    private static final RString 表示値_有効 = new RString("有効");
    private static final RString 表示値_無効 = new RString("無効");
    private static final RString 表示値_可能 = new RString("なれる");
    private static final RString 表示値_不可 = new RString("なれない");
    private static final RString 指定医_可能 = new RString("True");
    private static final RString 指定医_不可 = new RString("False");
    private static final RString CODE_有効 = new RString("yuko");
    private static final RString CODE_無効 = new RString("muko");
    private static final RString 表示値_男 = new RString("男");
    private static final RString 表示値_女 = new RString("女");
    private static final RString CODE_M = new RString("1");
    private static final RString CODE_W = new RString("2");
    private static final RString CODE_MAN = new RString("key0");
    private static final RString CODE_WOMAN = new RString("key1");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final RString KEY_0 = new RString("0");

    private final ShujiiMasterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 主治医マスタDiv
     */
    public ShujiiMasterHandler(ShujiiMasterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void load() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtSearchShujiiIryokikanCodeFrom().clearValue();
        div.getTxtSearchShujiiIryokikanCodeTo().clearValue();
        div.getTxtSearchShujiiIryokikanMeisho().clearValue();
        div.getTxtSearchShujiiIryokikanKanaMeisho().clearValue();
        div.getTxtSearchShujiiCodeFrom().clearValue();
        div.getTxtSearchShujiiCodeTo().clearValue();
        div.getTxtSearchShujiiShimei().clearValue();
        div.getTxtSearchShujiiKanaShimei().clearValue();
        div.getRadSearchJokyoFlag().setSelectedIndex(0);
        div.getTxtSaidaiHyojiKensu().clearValue();
        div.getDdlKikanMeisho().setSelectedKey(KEY_0);
        div.getDdlKikanKanaMeisho().setSelectedKey(KEY_0);
        div.getDdlShujiiMeisho().setSelectedKey(KEY_0);
        div.getDdlShujiiKanaMeisho().setSelectedKey(KEY_0);
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBE.データ出力件数閾値, new RDate("20000401"),
                SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("データ出力件数閾値")).toString()));
    }

    /**
     * 主治医一覧へのデータを設定します。
     *
     * @param shujiiMasterList 主治医一覧List
     */
    public void setShujiiIchiran(List<ShujiiMaster> shujiiMasterList) {
        List<dgShujiiIchiran_Row> dataGridList = new ArrayList<>();
        for (ShujiiMaster shujiiMaster : shujiiMasterList) {
            dataGridList.add(createDgShujiiIchiranRow(
                    RString.EMPTY,
                    shujiiMaster.get市町村コード(),
                    shujiiMaster.get市町村名称(),
                    shujiiMaster.get主治医氏名(),
                    shujiiMaster.get主治医カナ(),
                    shujiiMaster.get主治医コード(),
                    shujiiMaster.get主治医医療機関コード(),
                    shujiiMaster.get医療機関名称(),
                    shujiiMaster.get診療科名称(),
                    shujiiMaster.is指定医フラグ(),
                    shujiiMaster.is状況フラグ(),
                    shujiiMaster.get郵便番号(),
                    shujiiMaster.get住所(),
                    shujiiMaster.get電話番号(),
                    shujiiMaster.getFAX番号(),
                    shujiiMaster.get性別()));
        }
        div.getShujiiIchiran().getDgShujiiIchiran().setDataSource(dataGridList);
    }

    private dgShujiiIchiran_Row createDgShujiiIchiranRow(
            RString jotai,
            LasdecCode shichosonCode,
            RString shichoson,
            RString shujiiShimei,
            RString shujiiKanaShimei,
            RString shujiiNo,
            RString shujiiIryoKikanNo,
            RString shujiiIryoKikan,
            RString shinryoka,
            boolean shiteii,
            boolean jokyoFlag,
            YubinNo yubinNo,
            AtenaJusho jusho,
            TelNo telNo,
            TelNo faxNo,
            RString seibetsu
    ) {
        dgShujiiIchiran_Row row = new dgShujiiIchiran_Row();
        row.setJotai(jotai);
        row.setShichosonCode(new RString(shichosonCode.toString()));
        row.setShichoson(shichoson);
        row.setShujiiShimei(shujiiShimei);
        row.setShujiiKanaShimei(shujiiKanaShimei);
        TextBoxCode shujiiCode = new TextBoxCode();
        shujiiCode.setValue(shujiiNo);
        row.setShujiiCode(shujiiCode);
        TextBoxCode shujiiIryoKikanCode = new TextBoxCode();
        shujiiIryoKikanCode.setValue(shujiiIryoKikanNo);
        row.setShujiiIryoKikanCode(shujiiIryoKikanCode);
        row.setShujiiIryoKikan(shujiiIryoKikan);
        row.setShinryoka(shinryoka);
        row.setShiteii(shiteii ? 表示値_可能 : 表示値_不可);
        row.setJokyoFlag(jokyoFlag ? 表示値_有効 : 表示値_無効);
        row.setYubinNo(editYubinNoToIchiran(yubinNo != null ? yubinNo.value() : RString.EMPTY));
        row.setJusho(jusho != null ? jusho.value() : RString.EMPTY);
        row.setTelNo(telNo != null ? telNo.value() : RString.EMPTY);
        row.setFaxNo(faxNo != null ? faxNo.value() : RString.EMPTY);
        if (CODE_M.equals(seibetsu)) {
            row.setSeibetsu(表示値_男);
        } else if (CODE_W.equals(seibetsu)) {
            row.setSeibetsu(表示値_女);
        }
        return row;
    }

    /**
     * 主治医情報を設定します。
     *
     * @param row 主治医一覧情報
     */
    public void setShujiiJohoToMeisai(dgShujiiIchiran_Row row) {
        div.getShujiiJohoInput().getTxtShichoson().setValue(nullToEmpty(row.getShichosonCode()));
        div.getShujiiJohoInput().getTxtShichosonmei().setValue(nullToEmpty(row.getShichoson()));
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setValue(
                nullToEmpty(row.getShujiiIryoKikanCode().getValue()));
        div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setValue(nullToEmpty(row.getShujiiIryoKikan()));
        div.getShujiiJohoInput().getTxtShujiiCode().setValue(nullToEmpty(row.getShujiiCode().getValue()));
        div.getShujiiJohoInput().getTxtShujiiShimei().setValue(nullToEmpty(row.getShujiiShimei()));
        div.getShujiiJohoInput().getTxtShujiiKanaShimei().setValue(nullToEmpty(row.getShujiiKanaShimei()));
        div.getShujiiJohoInput().getRadSeibetsu().setSelectedKey(
                表示値_男.equals(row.getSeibetsu()) ? CODE_MAN : CODE_WOMAN);
        div.getShujiiJohoInput().getRadShiteiiFlag().setSelectedKey(
                表示値_可能.equals(row.getShiteii()) ? 指定医_可能 : 指定医_不可);
        div.getShujiiJohoInput().getTxtShinryokaMei().setValue(nullToEmpty(row.getShinryoka()));
        
        div.getShujiiJohoInput().getTxtYubinNo().setValue(new YubinNo(editYubinNo(row.getYubinNo())));
        div.getShujiiJohoInput().getTxtJusho().setDomain(new AtenaJusho(row.getJusho()));
        div.getShujiiJohoInput().getTxtTelNo().setDomain(new TelNo(row.getTelNo()));
        div.getShujiiJohoInput().getTxtFaxNo().setDomain(new TelNo(row.getFaxNo()));
        div.getShujiiJohoInput().getRadJokyoFlag().setSelectedKey(
                表示値_有効.equals(row.getJokyoFlag()) ? CODE_有効 : CODE_無効);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 主治医情報を設定します。
     *
     * @param eventJotai 状態
     */
    public void setShujiiJohoToIchiran(RString eventJotai) {
        dgShujiiIchiran_Row row = new dgShujiiIchiran_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        }
        row.setShichoson(nullToEmpty(div.getShujiiJohoInput().getTxtShichosonmei().getValue()));
        row.setShichosonCode(nullToEmpty(div.getShujiiJohoInput().getTxtShichoson().getValue()));
        row.setShujiiCode(div.getShujiiJohoInput().getTxtShujiiCode());
        row.setShujiiShimei(nullToEmpty(div.getShujiiJohoInput().getTxtShujiiShimei().getValue()));
        row.setShujiiKanaShimei(nullToEmpty(div.getShujiiJohoInput().getTxtShujiiKanaShimei().getValue()));
        row.setShujiiIryoKikanCode(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode());
        row.setShujiiIryoKikan(nullToEmpty(div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().getValue()));
        RString seibetsu = div.getShujiiJohoInput().getRadSeibetsu().getSelectedKey();
        if (CODE_MAN.equals(seibetsu)) {
            row.setSeibetsu(表示値_男);
        } else if (CODE_WOMAN.equals(seibetsu)) {
            row.setSeibetsu(表示値_女);
        }
        RString shiteiiFlag = div.getShujiiJohoInput().getRadShiteiiFlag().getSelectedKey();
        row.setShiteii(指定医_可能.equals(shiteiiFlag) ? 表示値_可能 : 表示値_不可);
        RString jokyoFlag = div.getShujiiJohoInput().getRadJokyoFlag().getSelectedKey();
        row.setJokyoFlag(CODE_有効.equals(jokyoFlag) ? 表示値_有効 : 表示値_無効);
        row.setShinryoka(div.getShujiiJohoInput().getTxtShinryokaMei().getValue());
        row.setYubinNo(editYubinNoToIchiran(nullToEmpty(div.getShujiiJohoInput().getTxtYubinNo().getValue().value())));
        row.setJusho(nullToEmpty(div.getShujiiJohoInput().getTxtJusho().getDomain().value()));
        row.setTelNo(nullToEmpty(div.getShujiiJohoInput().getTxtTelNo().getDomain().value()));
        row.setFaxNo(nullToEmpty(div.getShujiiJohoInput().getTxtFaxNo().getDomain().value()));
        int index = div.getShujiiIchiran().getDgShujiiIchiran().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getShujiiIchiran().getDgShujiiIchiran().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getShujiiIchiran().getDgShujiiIchiran().getDataSource().remove(index);
        } else if (状態_修正.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getShujiiIchiran().getDgShujiiIchiran().getDataSource().set(index, row);
        } else {
            row.setJotai(eventJotai);
            div.getShujiiIchiran().getDgShujiiIchiran().getDataSource().set(index, row);
        }
    }

    private RString editYubinNoToIchiran(RString yubinNo) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (INDEX_3 <= yubinNo.length()) {
            yubinNoSb.append(yubinNo.substring(0, INDEX_3));
            yubinNoSb.append(ハイフン);
            yubinNoSb.append(yubinNo.substring(INDEX_3));
        } else {
            yubinNoSb.append(yubinNo);
        }
        return yubinNoSb.toRString();
    }

    private RString editYubinNo(RString yubinNo) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (yubinNo.length() == INDEX_4) {
            yubinNo = yubinNo.remove(INDEX_3);
        } 
        if (yubinNo.contains(ハイフン)) {
            yubinNoSb.append(yubinNo.substring(0, INDEX_4));
            yubinNoSb.append(yubinNo.substring(INDEX_4));
        } else {
            yubinNoSb.append(yubinNo);
        }
        return yubinNoSb.toRString();
    }

    /**
     * 主治医情報を設定します。
     *
     * @param shujiiJoho 主治医情報
     * @return ShujiiJoho 主治医情報
     */
    public ShujiiJoho editShujiiJoho(ShujiiJoho shujiiJoho) {
        return shujiiJoho.createBuilderForEdit().set主治医氏名(div.getShujiiJohoInput().getTxtShujiiShimei().getValue())
                .set主治医カナ(new AtenaKanaMeisho(div.getShujiiJohoInput().getTxtShujiiKanaShimei().getValue()))
                .set性別(new Code(CODE_MAN.equals(div.getShujiiJohoInput().
                                        getRadSeibetsu().getSelectedKey()) ? CODE_M : CODE_W))
                .set指定医フラグ(指定医_可能.equals(div.getShujiiJohoInput().getRadShiteiiFlag().getSelectedKey()))
                .set診療科名称(div.getShujiiJohoInput().getTxtShinryokaMei().getValue())
                .set郵便番号(div.getShujiiJohoInput().getTxtYubinNo().getValue())
                .set住所(div.getShujiiJohoInput().getTxtJusho().getDomain().getColumnValue())
                .set電話番号(div.getShujiiJohoInput().getTxtTelNo().getDomain())
                .setFAX番号(div.getShujiiJohoInput().getTxtFaxNo().getDomain())
                .set状況フラグ(CODE_有効.equals(div.getShujiiJohoInput().getRadJokyoFlag().getSelectedKey())).build();
    }

    /**
     * 主治医情報登録エリアをクリアします。
     */
    public void clearShujiiJohoInputMeisai() {
        div.getShujiiJohoInput().getTxtShichoson().clearValue();
        div.getShujiiJohoInput().getTxtShichosonmei().clearValue();
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().clearValue();
        div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().clearValue();
        div.getShujiiJohoInput().getTxtShujiiCode().clearValue();
        div.getShujiiJohoInput().getTxtShujiiShimei().clearValue();
        div.getShujiiJohoInput().getTxtShujiiKanaShimei().clearValue();
        div.getShujiiJohoInput().getRadSeibetsu().setSelectedIndex(0);
        div.getShujiiJohoInput().getRadShiteiiFlag().setSelectedIndex(0);
        div.getShujiiJohoInput().getTxtShinryokaMei().clearValue();
        div.getShujiiJohoInput().getTxtYubinNo().clearValue();
        div.getShujiiJohoInput().getTxtJusho().clearDomain();
        div.getShujiiJohoInput().getTxtTelNo().clearDomain();
        div.getShujiiJohoInput().getTxtFaxNo().clearDomain();
        div.getShujiiJohoInput().getRadJokyoFlag().setSelectedIndex(0);
    }

    /**
     * 主治医情報登録エリアが非活性に設定します。
     */
    public void setDisabledTrueToShujiiJohoInputMeisai() {
        div.getShujiiJohoInput().getTxtShichoson().setDisabled(true);
        div.getShujiiJohoInput().getTxtShichosonmei().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiCode().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiShimei().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiKanaShimei().setDisabled(true);
        div.getShujiiJohoInput().getRadSeibetsu().setDisabled(true);
        div.getShujiiJohoInput().getRadShiteiiFlag().setDisabled(true);
        div.getShujiiJohoInput().getTxtShinryokaMei().setDisabled(true);
        div.getShujiiJohoInput().getTxtYubinNo().setDisabled(true);
        div.getShujiiJohoInput().getTxtJusho().setDisabled(true);
        div.getShujiiJohoInput().getTxtTelNo().setDisabled(true);
        div.getShujiiJohoInput().getTxtFaxNo().setDisabled(true);
        div.getShujiiJohoInput().getRadJokyoFlag().setDisabled(true);
    }

    /**
     * 主治医情報登録エリアが活性に設定します。
     */
    public void setDisabledFalseToShujiiJohoInputMeisai() {
        div.getShujiiJohoInput().getTxtShichoson().setDisabled(false);
        div.getShujiiJohoInput().getTxtShichosonmei().setDisabled(false);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(false);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setDisabled(false);
        div.getShujiiJohoInput().getTxtShujiiCode().setDisabled(false);
        div.getShujiiJohoInput().getTxtShujiiShimei().setDisabled(false);
        div.getShujiiJohoInput().getTxtShujiiKanaShimei().setDisabled(false);
        div.getShujiiJohoInput().getRadSeibetsu().setDisabled(false);
        div.getShujiiJohoInput().getRadShiteiiFlag().setDisabled(false);
        div.getShujiiJohoInput().getTxtShinryokaMei().setDisabled(false);
        div.getShujiiJohoInput().getTxtYubinNo().setDisabled(false);
        div.getShujiiJohoInput().getTxtJusho().setDisabled(false);
        div.getShujiiJohoInput().getTxtTelNo().setDisabled(false);
        div.getShujiiJohoInput().getTxtFaxNo().setDisabled(false);
        div.getShujiiJohoInput().getRadJokyoFlag().setDisabled(false);
    }

    /**
     * 主治医情報登録エリアを編集します。
     *
     * @return 編集結果
     */
    public RString getInputDiv() {
        RStringBuilder inputDiv = new RStringBuilder();
        ShujiiJohoInputDiv shujiiJohoInputDiv = div.getShujiiJohoInput();
        inputDiv.append(shujiiJohoInputDiv.getTxtShichoson().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtShichosonmei().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtShujiiIryoKikanCode().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtShujiiIryoKikanMei().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtShujiiCode().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtShujiiShimei().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtShujiiKanaShimei().getValue());
        inputDiv.append(shujiiJohoInputDiv.getRadSeibetsu().getSelectedKey());
        inputDiv.append(shujiiJohoInputDiv.getRadShiteiiFlag().getSelectedKey());
        inputDiv.append(shujiiJohoInputDiv.getTxtShinryokaMei().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtYubinNo().getValue().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtJusho().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtTelNo().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtFaxNo().getDomain().value());
        inputDiv.append((shujiiJohoInputDiv.getRadJokyoFlag().getSelectedKey()));
        return inputDiv.toRString();
    }
}
