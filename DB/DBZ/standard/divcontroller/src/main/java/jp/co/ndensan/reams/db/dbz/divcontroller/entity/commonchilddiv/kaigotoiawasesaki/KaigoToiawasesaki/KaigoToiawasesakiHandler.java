/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigotoiawasesaki.KaigoToiawasesaki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesakiIdentifier;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護問合せ先のHandlerクラスです。
 *
 * @reamsid_L DBA-1201-040 xuyannan
 */
public class KaigoToiawasesakiHandler {

    private static final RString 表示モード_追加 = new RString("追加");
    private static final RString 表示モード_表示 = new RString("表示");
    private static final RString 介護共通 = new RString("0");
    private static final RString サブ業務単位 = new RString("1");
    private static final RString 帳票独自無し = new RString("0");
    private static final RString 帳票独自あり = new RString("1");
    private static final RString 共通問合せ先 = new RString("1行目");
    private static final RString 帳票独自問合せ先 = new RString("2行目");
    private static final RString 単位 = new RString("行目");
    private static final RString 問合せ先_帳票独自 = new RString("帳票独自");
    private static final RString 問合せ先_資格共通 = new RString("資格共通");
    private static final RString 問合せ先_賦課共通 = new RString("賦課共通");
    private static final RString 問合せ先_給付共通 = new RString("給付共通");
    private static final RString 問合せ先_受給共通 = new RString("受給共通");
    private static final RString 問合せ先_認定共通 = new RString("認定共通");
    private static final RString 問合せ先_統計共通 = new RString("統計共通");
    private static final int 件数 = 1;
    private final KaigoToiawasesakiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護問合せ先div
     */
    public KaigoToiawasesakiHandler(KaigoToiawasesakiDiv div) {
        this.div = div;
    }

    /**
     * 介護問合せ先ダイアログを表示します。
     *
     * @param oneBusiness 介護問合せ先を管理するクラス1
     * @param twoBusiness 介護問合せ先を管理するクラス2
     * @param 問合せ先管理単位 問合せ先管理単位
     */
    public void onLoad(KaigoToiawasesaki oneBusiness, KaigoToiawasesaki twoBusiness, RString 問合せ先管理単位) {
        List<dgToiawasesakiControl_Row> rowList = new ArrayList<>();
        dgToiawasesakiControl_Row oneRow = new dgToiawasesakiControl_Row();
        dgToiawasesakiControl_Row twoRow = new dgToiawasesakiControl_Row();
        if (介護共通.equals(問合せ先管理単位)) {
            oneRow.setTxtToiawasesaki(SubGyomuCode.DBZ介護共通.getGyomuName());
        } else if (サブ業務単位.equals(問合せ先管理単位)) {
            if (SubGyomuCode.DBA介護資格.value().equals(div.getHdnSubGyomuCode())) {
                oneRow.setTxtToiawasesaki(問合せ先_資格共通);
            } else if (SubGyomuCode.DBB介護賦課.value().equals(div.getHdnSubGyomuCode())) {
                oneRow.setTxtToiawasesaki(問合せ先_賦課共通);
            } else if (SubGyomuCode.DBC介護給付.value().equals(div.getHdnSubGyomuCode())) {
                oneRow.setTxtToiawasesaki(問合せ先_給付共通);
            } else if (SubGyomuCode.DBD介護受給.value().equals(div.getHdnSubGyomuCode())) {
                oneRow.setTxtToiawasesaki(問合せ先_受給共通);
            } else if (SubGyomuCode.DBE認定支援.value().equals(div.getHdnSubGyomuCode())) {
                oneRow.setTxtToiawasesaki(問合せ先_認定共通);
            } else if (SubGyomuCode.DBU介護統計報告.value().equals(div.getHdnSubGyomuCode())) {
                oneRow.setTxtToiawasesaki(問合せ先_統計共通);
            }
        }
        rowList.add(setDgToiawasesaki(oneBusiness, oneRow));
        if (twoBusiness == null) {
            div.setHdnChohyoDokujiToiawasesakiUmu(帳票独自無し);
        } else {
            div.setHdnChohyoDokujiToiawasesakiUmu(帳票独自あり);
            twoRow.setTxtToiawasesaki(問合せ先_帳票独自);
            rowList.add(setDgToiawasesaki(twoBusiness, twoRow));
        }
        div.getToiawasesakiControl().getDgToiawasesakiControl().setDataSource(rowList);
        div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(0).setDeleteButtonState(DataGridButtonState.Disabled);
        帳票独自問合せ先の制御();
    }

    /**
     * 問合せ先詳細のテータを編集します。
     *
     * @param 表示モード 表示モード
     */
    public void onClick_dataSettei(RString 表示モード) {
        if (表示モード_追加.equals(表示モード)) {
            div.setHdnSelectToiawasesaki(帳票独自問合せ先);
        } else {
            RStringBuilder builder = new RStringBuilder();
            builder.append(div.getToiawasesakiControl().getDgToiawasesakiControl().getClickedRowId() + 1);
            builder.append(単位);
            div.setHdnSelectToiawasesaki(builder.toRString());
        }
        問合せ先詳細の設定(表示モード);
        入力表示制御(表示モード);
    }

    /**
     * 問合せ先制御Gridの該当行を削除します。
     */
    public void onbtn_Delete() {
        div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().remove(
                div.getToiawasesakiControl().getDgToiawasesakiControl().getClickedRowId());
        div.setHdnChohyoDokujiToiawasesakiUmu(帳票独自無し);
        帳票独自問合せ先の制御();
    }

    /**
     * 「入力確定」を押します。
     */
    public void onbtn_OK() {
        if (帳票独自問合せ先.equals(div.getHdnSelectToiawasesaki())
                && 件数 == div.getToiawasesakiControl().getDgToiawasesakiControl().getTotalRecords()) {
            div.setHdnChohyoDokujiToiawasesakiUmu(帳票独自あり);
            dgToiawasesakiControl_Row row = new dgToiawasesakiControl_Row();
            row.setTxtToiawasesaki(問合せ先_帳票独自);
            row.setTxtYubinNo(div.getToiawasesakiShosai().getDetail1().getTxtYubinNo().getValue().value());
            row.setTxtShozaichi(div.getToiawasesakiShosai().getDetail1().getTxtShozaichi().getValue());
            row.setTxtChoshaName(div.getToiawasesakiShosai().getDetail1().getTxtChoshaName().getValue());
            row.setTxtTelNo(div.getToiawasesakiShosai().getDetail2().getTxtTelNo().getDomain().value());
            row.setTxtNaisenNo(div.getToiawasesakiShosai().getDetail2().getTxtNaisenNo().getValue());
            row.setTxtBushoName(div.getToiawasesakiShosai().getDetail2().getTxtBushoName().getValue());
            row.setTxtTantoshaName(div.getToiawasesakiShosai().getDetail2().getTxtTantoshaName().getValue());
            div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().add(row);
        } else {
            int index;
            if (共通問合せ先.equals(div.getHdnSelectToiawasesaki())) {
                index = 0;
            } else {
                index = 1;
            }
            div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(index).setTxtYubinNo(
                    div.getToiawasesakiShosai().getDetail1().getTxtYubinNo().getValue().value());
            div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(index).setTxtShozaichi(
                    div.getToiawasesakiShosai().getDetail1().getTxtShozaichi().getValue());
            div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(index).setTxtChoshaName(
                    div.getToiawasesakiShosai().getDetail1().getTxtChoshaName().getValue());
            div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(index).setTxtTelNo(
                    div.getToiawasesakiShosai().getDetail2().getTxtTelNo().getDomain().value());
            div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(index).setTxtNaisenNo(
                    div.getToiawasesakiShosai().getDetail2().getTxtNaisenNo().getValue());
            div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(index).setTxtBushoName(
                    div.getToiawasesakiShosai().getDetail2().getTxtBushoName().getValue());
            div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(index).setTxtTantoshaName(
                    div.getToiawasesakiShosai().getDetail2().getTxtTantoshaName().getValue());
        }
        入力表示制御(表示モード_表示);
    }

    /**
     * 「入力取消」を押します。
     */
    public void onbtn_Cancel() {
        clearData();
        入力表示制御(表示モード_表示);
    }

    /**
     * 一件目を更新します。
     *
     * @param models 介護問合せ先情報
     * @param oneKey 介護問合せ先の識別子
     * @return KaigoToiawasesakiBuilder ビルダークラス
     */
    public KaigoToiawasesakiBuilder updateOneRow(Models<KaigoToiawasesakiIdentifier, KaigoToiawasesaki> models,
            KaigoToiawasesakiIdentifier oneKey) {
        KaigoToiawasesaki oneKaigoToiawasesaki = models.get(oneKey);
        KaigoToiawasesakiBuilder oneBuilder = oneKaigoToiawasesaki.createBuilderForEdit();
        oneBuilder.set郵便番号(new YubinNo(
                nullTOEmpty(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(0).getTxtYubinNo())));
        oneBuilder.set所在地(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(0).getTxtShozaichi());
        oneBuilder.set庁舎名(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(0).getTxtChoshaName());
        oneBuilder.set電話番号(new TelNo(
                nullTOEmpty(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(0).getTxtTelNo())));
        oneBuilder.set内線番号(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(0).getTxtNaisenNo());
        oneBuilder.set部署名(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(0).getTxtBushoName());
        oneBuilder.set担当者名(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(0).getTxtTantoshaName());
        oneKaigoToiawasesaki.toEntity().setState(EntityDataState.Modified);
        return oneBuilder;
    }

    /**
     * 二件目を更新します。
     *
     * @param models 介護問合せ先情報
     * @param twoKey 介護問合せ先の識別子
     * @return KaigoToiawasesakiBuilder ビルダークラス
     */
    public KaigoToiawasesakiBuilder updateOrInsertTwoRow(
            Models<KaigoToiawasesakiIdentifier, KaigoToiawasesaki> models, KaigoToiawasesakiIdentifier twoKey) {
        KaigoToiawasesaki twoKaigoToiawasesaki = models.get(twoKey);
        KaigoToiawasesakiBuilder twoBuilder;
        if (twoKaigoToiawasesaki == null) {
            KaigoToiawasesaki kaigoToiawasesaki = new KaigoToiawasesaki(
                    new SubGyomuCode(div.getHdnSubGyomuCode()), new ReportId(div.getHdnChohyoBunruiID()));
            kaigoToiawasesaki.toEntity().setState(EntityDataState.Added);
            twoBuilder = kaigoToiawasesaki.createBuilderForEdit();
        } else {
            twoKaigoToiawasesaki.toEntity().setState(EntityDataState.Modified);
            twoBuilder = twoKaigoToiawasesaki.createBuilderForEdit();
        }
        twoBuilder.set郵便番号(new YubinNo(
                nullTOEmpty(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(1).getTxtYubinNo())));
        twoBuilder.set所在地(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(1).getTxtShozaichi());
        twoBuilder.set庁舎名(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(1).getTxtChoshaName());
        twoBuilder.set電話番号(new TelNo(
                nullTOEmpty(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(1).getTxtTelNo())));
        twoBuilder.set内線番号(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(1).getTxtNaisenNo());
        twoBuilder.set部署名(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(1).getTxtBushoName());
        twoBuilder.set担当者名(div.getToiawasesakiControl().getDgToiawasesakiControl().getDataSource().get(1).getTxtTantoshaName());
        return twoBuilder;
    }

    private dgToiawasesakiControl_Row setDgToiawasesaki(KaigoToiawasesaki business, dgToiawasesakiControl_Row row) {
        if (business != null) {
            row.setTxtYubinNo(nullTOEmpty(business.get郵便番号().value()));
            row.setTxtShozaichi(nullTOEmpty(business.get所在地()));
            row.setTxtChoshaName(nullTOEmpty(business.get庁舎名()));
            row.setTxtTelNo(nullTOEmpty(business.get電話番号().value()));
            row.setTxtNaisenNo(nullTOEmpty(business.get内線番号()));
            row.setTxtBushoName(nullTOEmpty(business.get部署名()));
            row.setTxtTantoshaName(nullTOEmpty(business.get担当者名()));
        }
        return row;
    }

    private void 帳票独自問合せ先の制御() {
        if (帳票独自無し.equals(div.getHdnChohyoDokujiToiawasesakiUmu())) {
            div.getToiawasesakiControl().getBtnAddChohyoDokuji().setDisabled(false);
        } else if (帳票独自あり.equals(div.getHdnChohyoDokujiToiawasesakiUmu())) {
            div.getToiawasesakiControl().getBtnAddChohyoDokuji().setDisabled(true);
        }
    }

    private void 入力表示制御(RString 表示モード) {
        boolean 表示制御;
        表示制御 = 表示モード_表示.equals(表示モード);
        div.getToiawasesakiShosai().getDetail1().getTxtYubinNo().setReadOnly(表示制御);
        div.getToiawasesakiShosai().getDetail1().getTxtShozaichi().setReadOnly(表示制御);
        div.getToiawasesakiShosai().getDetail1().getTxtChoshaName().setReadOnly(表示制御);
        div.getToiawasesakiShosai().getDetail2().getTxtTelNo().setReadOnly(表示制御);
        div.getToiawasesakiShosai().getDetail2().getTxtNaisenNo().setReadOnly(表示制御);
        div.getToiawasesakiShosai().getDetail2().getTxtBushoName().setReadOnly(表示制御);
        div.getToiawasesakiShosai().getDetail2().getTxtTantoshaName().setReadOnly(表示制御);
        div.getToiawasesakiShosai().getBtnCancel().setDisabled(表示制御);
        div.getToiawasesakiShosai().getBtnDecide().setDisabled(表示制御);
    }

    private void 問合せ先詳細の設定(RString 表示モード) {
        if (表示モード_追加.equals(表示モード)) {
            clearData();
        } else {
            dgToiawasesakiControl_Row row = div.getToiawasesakiControl().getDgToiawasesakiControl().getClickedItem();
            if (共通問合せ先.equals(div.getHdnSelectToiawasesaki())) {
                div.getToiawasesakiShosai().getLblHensyuTaisho().setText(
                        row.getTxtToiawasesaki());
            } else if (帳票独自問合せ先.equals(div.getHdnSelectToiawasesaki())) {
                div.getToiawasesakiShosai().getLblHensyuTaisho().setText(問合せ先_帳票独自);
            }
            div.getToiawasesakiShosai().getDetail1().getTxtYubinNo().setValue(new YubinNo(nullTOEmpty(row.getTxtYubinNo())));
            div.getToiawasesakiShosai().getDetail1().getTxtShozaichi().setValue(row.getTxtShozaichi());
            div.getToiawasesakiShosai().getDetail1().getTxtChoshaName().setValue(row.getTxtChoshaName());
            div.getToiawasesakiShosai().getDetail2().getTxtTelNo().setDomain(new TelNo(nullTOEmpty(row.getTxtTelNo())));
            div.getToiawasesakiShosai().getDetail2().getTxtNaisenNo().setValue(row.getTxtNaisenNo());
            div.getToiawasesakiShosai().getDetail2().getTxtBushoName().setValue(row.getTxtBushoName());
            div.getToiawasesakiShosai().getDetail2().getTxtTantoshaName().setValue(row.getTxtTantoshaName());
        }
    }

    private void clearData() {
        div.getToiawasesakiShosai().getLblHensyuTaisho().setText(RString.EMPTY);
        div.getToiawasesakiShosai().getDetail1().getTxtYubinNo().clearValue();
        div.getToiawasesakiShosai().getDetail1().getTxtShozaichi().clearValue();
        div.getToiawasesakiShosai().getDetail1().getTxtChoshaName().clearValue();
        div.getToiawasesakiShosai().getDetail2().getTxtTelNo().clearDomain();
        div.getToiawasesakiShosai().getDetail2().getTxtNaisenNo().clearValue();
        div.getToiawasesakiShosai().getDetail2().getTxtBushoName().clearValue();
        div.getToiawasesakiShosai().getDetail2().getTxtTantoshaName().clearValue();
    }

    private RString nullTOEmpty(RString 項目) {
        if (RString.isNullOrEmpty(項目)) {
            return RString.EMPTY;
        }
        return 項目;
    }
}
