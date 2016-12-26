/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.ShujiiIryoKikanMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.ShujiiJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 主治医医療機関マスタ画面のハンドラークラスです。
 *
 * @reamsid_L DBE-0240-010 dongyabin
 */
public class KoseiShujiiIryoKikanMasterHandler {

    private static final RString 前方一致KEY = new RString("0");
    private static final RString 表示値_有効 = new RString("有効");
    private static final RString 表示値_無効 = new RString("無効");
    private static final RString CODE_有効 = new RString("yuko");
    private static final RString CODE_無効 = new RString("muko");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private final ShujiiIryoKikanMasterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 主治医医療機関情報Div
     */
    public KoseiShujiiIryoKikanMasterHandler(ShujiiIryoKikanMasterDiv div) {
        this.div = div;
    }

    /**
     * 検索条件入力項目をクリアします。
     */
    public void clearKensakuJoken() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtSearchShujiiIryokikanCodeFrom().clearValue();
        div.getTxtSearchShujiiIryokikanCodeTo().clearValue();
        div.getTxtSearchShujiiIryokikanMeisho().clearValue();
        div.getTxtSearchShujiiIryokikanKanaMeisho().clearValue();
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBE.データ出力件数閾値, new RDate("20000401"),
                SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("データ出力件数閾値")).toString()));
        div.getRadSearchJokyoFlag().setSelectedIndex(0);
        div.getDdlKikanMeisho().setSelectedKey(前方一致KEY);
        div.getDdlKikanKanaMeisho().setSelectedKey(前方一致KEY);
    }

    /**
     * 主治医医療機関一覧へのデータを設定します。
     *
     * @param 主治医医療機関情報一覧 主治医医療機関情報一覧
     * @param 最大表示件数 最大表示件数
     */
    public void setShujiKikanJohoIchiran(SearchResult<KoseiShujiiIryoKikanMasterBusiness> 主治医医療機関情報一覧, Decimal 最大表示件数) {
        List<dgShujiiIchiran_Row> dataGridList = new ArrayList<>();
        for (KoseiShujiiIryoKikanMasterBusiness koseiShujiiIryoKikanMaster : 主治医医療機関情報一覧.records()) {
            dataGridList.add(createDgShujiiIchiranRow(
                    RString.EMPTY,
                    koseiShujiiIryoKikanMaster.get市町村(),
                    koseiShujiiIryoKikanMaster.get市町村コード(),
                    koseiShujiiIryoKikanMaster.get主治医医療機関コード(),
                    koseiShujiiIryoKikanMaster.get医療機関コード(),
                    koseiShujiiIryoKikanMaster.get医療機関名称(),
                    koseiShujiiIryoKikanMaster.get医療機関名称カナ(),
                    koseiShujiiIryoKikanMaster.get郵便番号(),
                    koseiShujiiIryoKikanMaster.get住所(),
                    koseiShujiiIryoKikanMaster.get電話番号(),
                    koseiShujiiIryoKikanMaster.getFAX番号(),
                    koseiShujiiIryoKikanMaster.get代表者名(),
                    koseiShujiiIryoKikanMaster.get代表者名カナ(),
                    koseiShujiiIryoKikanMaster.is状況フラグ(),
                    koseiShujiiIryoKikanMaster.get金融機関コード(),
                    koseiShujiiIryoKikanMaster.get金融機関支店コード(),
                    koseiShujiiIryoKikanMaster.get預金種別(),
                    koseiShujiiIryoKikanMaster.get口座番号(),
                    koseiShujiiIryoKikanMaster.get口座名義人カナ(),
                    koseiShujiiIryoKikanMaster.get口座名義人()));
        }
        div.getShujiiIchiran().getDgShujiiIchiran().setDataSource(dataGridList);
        if (主治医医療機関情報一覧.exceedsLimit()) {
            div.getDgShujiiIchiran().getGridSetting().setLimitRowCount(主治医医療機関情報一覧.records().size());
            div.getDgShujiiIchiran().getGridSetting().setSelectedRowCount(主治医医療機関情報一覧.totalCount());
        } else {
            div.getDgShujiiIchiran().getGridSetting().setLimitRowCount(最大表示件数.intValue());
            div.getDgShujiiIchiran().getGridSetting().setSelectedRowCount(主治医医療機関情報一覧.totalCount());
        }
    }

    private dgShujiiIchiran_Row createDgShujiiIchiranRow(
            RString jotai,
            RString shichosonName,
            LasdecCode shichoson,
            RString shujiiIryokikanCode,
            IryoKikanCode iryokikanCode,
            RString iryoKikanMeisho,
            RString iryoKikanMeishoKana,
            YubinNo yubinNo,
            RString jusho,
            TelNo telNo,
            TelNo faxNo,
            RString daihyoshaName,
            RString daihyoshaNameKana,
            boolean jokyoFlag,
            KinyuKikanCode kinyuKikanCode,
            KinyuKikanShitenCode kinyuKikanShitenCode,
            RString yokinShubetsu,
            RString kozaNo,
            AtenaKanaMeisho kozaMeigininKana,
            AtenaMeisho kozaMeiginin
    ) {
        dgShujiiIchiran_Row row = new dgShujiiIchiran_Row();
        row.setJotai(jotai);
        // TODO　共通部品
        row.setShichoson(shichosonName);
        row.setShichosonCode(nullToEmpty(shichoson.value()));
        TextBoxCode shujiiIryoKikanCode = new TextBoxCode();
        shujiiIryoKikanCode.setValue(nullToEmpty(shujiiIryokikanCode));
        row.setShujiiIryoKikanCode(shujiiIryoKikanCode);
        row.setIryoKikanCode(iryokikanCode == null ? RString.EMPTY : nullToEmpty(iryokikanCode.getColumnValue()));
        row.setShujiiIryoKikan(nullToEmpty(iryoKikanMeisho));
        row.setShujiiIryoKikankana(nullToEmpty(iryoKikanMeishoKana));
        row.setYubinNo(editYubinNoToIchiran(yubinNo != null ? yubinNo.value() : RString.EMPTY));
        row.setJusho(nullToEmpty(jusho));
        row.setTelNo(telNo != null ? telNo.value() : RString.EMPTY);
        row.setFaxNo(faxNo != null ? faxNo.value() : RString.EMPTY);
        row.setDaihyosha(daihyoshaName != null ? daihyoshaName : RString.EMPTY);
        row.setDaihyoshakana(nullToEmpty(daihyoshaNameKana));
        row.setJokyoFlag(jokyoFlag ? 表示値_有効 : 表示値_無効);
        row.setKinyuKikanCode(kinyuKikanCode != null ? kinyuKikanCode.value() : RString.EMPTY);
        row.setKinyuKikanShitenCode(kinyuKikanShitenCode != null ? kinyuKikanShitenCode.value() : RString.EMPTY);
        row.setYokinShubetsu(yokinShubetsu);
        row.setKozaNo(kozaNo);
        row.setKozaMeigininKana(kozaMeigininKana != null ? kozaMeigininKana.value() : RString.EMPTY);
        row.setKozaMeiginin(kozaMeiginin != null ? kozaMeiginin.value() : RString.EMPTY);
        return row;
    }

    /**
     * 主治医医療機関情報を設定します。
     *
     * @param row 主治医医療機関一覧情報
     */
    public void setShujiiJohoToMeisai(dgShujiiIchiran_Row row) {
        div.getShujiiJohoInput().getTxtShichoson().setValue(nullToEmpty(row.getShichosonCode()));
        div.getShujiiJohoInput().getTxtShichosonmei().setValue(nullToEmpty(row.getShichoson()));
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setValue(nullToEmpty(row.getShujiiIryoKikanCode().getValue()));
        div.getShujiiJohoInput().getTxtiryokikanCode().setValue(nullToEmpty(row.getIryoKikanCode()));
        div.getShujiiJohoInput().getTxtiryokikanname().setValue(nullToEmpty(row.getShujiiIryoKikan()));
        div.getShujiiJohoInput().getTxtiryokikanKananame().setValue(nullToEmpty(row.getShujiiIryoKikankana()));
        div.getShujiiJohoInput().getTxtYubinNo().setValue(new YubinNo(editYubinNo(row.getYubinNo())));
        div.getShujiiJohoInput().getTxtJusho().setDomain(new AtenaJusho(row.getJusho()));
        div.getShujiiJohoInput().getTxtTelNo().setDomain(new TelNo(row.getTelNo()));
        div.getShujiiJohoInput().getTxtFaxNo().setDomain(new TelNo(row.getFaxNo()));
        div.getShujiiJohoInput().getTxtdaihyoshaname().setValue(nullToEmpty(row.getDaihyosha()));
        div.getShujiiJohoInput().getTxtdaihyoshakananame().setValue(nullToEmpty(row.getDaihyoshakana()));
        div.getShujiiJohoInput().getRadJokyoFlag().setSelectedKey(
                表示値_有効.equals(row.getJokyoFlag()) ? CODE_有効 : CODE_無効);
        div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().search(
                new KinyuKikanCode(row.getKinyuKikanCode()), new KinyuKikanShitenCode(row.getKinyuKikanShitenCode()), FlexibleDate.getNowDate());
        div.getShujiiJohoInput().getKozaJoho().getDdlYokinShubetsu().setSelectedKey(row.getYokinShubetsu() == null ? new RString(0) : row.getYokinShubetsu());
        div.getShujiiJohoInput().getKozaJoho().getTxtGinkoKozaNo().setValue(row.getKozaNo());
        div.getShujiiJohoInput().getKozaJoho().getTxtKozaMeiginin().setValue(row.getKozaMeigininKana());
        div.getShujiiJohoInput().getKozaJoho().getTxtKanjiMeiginin().setValue(row.getKozaMeiginin());
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 主治医医療機関情報を設定します。
     *
     * @param eventJotai RString
     * @param 状態 boolean
     */
    public void setShujiiIryoKikanJohoToIchiran(RString eventJotai, boolean 状態) {
        dgShujiiIchiran_Row row = new dgShujiiIchiran_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        }
        setRow(row);
        int index = div.getShujiiIchiran().getDgShujiiIchiran().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            if (状態) {
                row.setJotai(eventJotai);
            } else {
                row.setJotai(RString.EMPTY);
            }
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

    private void setRow(dgShujiiIchiran_Row row) {
        row.setShichoson(nullToEmpty(div.getShujiiJohoInput().getTxtShichosonmei().getValue()));
        row.setShichosonCode(nullToEmpty(div.getShujiiJohoInput().getTxtShichoson().getValue()));
        row.setShujiiIryoKikanCode(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode());
        row.setIryoKikanCode(nullToEmpty(div.getShujiiJohoInput().getTxtiryokikanCode().getValue()));
        row.setShujiiIryoKikan(nullToEmpty(div.getShujiiJohoInput().getTxtiryokikanname().getValue()));
        row.setShujiiIryoKikankana(nullToEmpty(div.getShujiiJohoInput().getTxtiryokikanKananame().getValue()));
        row.setYubinNo(editYubinNoToIchiran(nullToEmpty(div.getShujiiJohoInput().getTxtYubinNo().getValue().value())));
        row.setJusho(nullToEmpty(div.getShujiiJohoInput().getTxtJusho().getDomain().value()));
        row.setTelNo(nullToEmpty(div.getShujiiJohoInput().getTxtTelNo().getDomain().value()));
        row.setFaxNo(nullToEmpty(div.getShujiiJohoInput().getTxtFaxNo().getDomain().value()));
        row.setDaihyosha(div.getShujiiJohoInput().getTxtdaihyoshaname().getValue());
        row.setDaihyoshakana(div.getShujiiJohoInput().getTxtdaihyoshakananame().getValue());
        RString jokyoFlag = div.getShujiiJohoInput().getRadJokyoFlag().getSelectedKey();
        row.setJokyoFlag(CODE_有効.equals(jokyoFlag) ? 表示値_有効 : 表示値_無効);
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
        if (yubinNo.contains(ハイフン)) {
            yubinNoSb.append(yubinNo.substring(0, INDEX_3));
            yubinNoSb.append(yubinNo.substring(INDEX_4));
        } else {
            yubinNoSb.append(yubinNo);
        }
        return yubinNoSb.toRString();
    }

    /**
     * 主治医医療機関情報を設定します。
     *
     * @param shujiiIryoKikanJoho 主治医医療機関情報
     * @return ShujiiIryoKikanJoho 主治医医療機関情報
     */
    public ShujiiIryoKikanJoho editShujiiIryoKikanJoho(ShujiiIryoKikanJoho shujiiIryoKikanJoho) {
        return shujiiIryoKikanJoho.createBuilderForEdit()
                .set医療機関コード(div.getShujiiJohoInput().getTxtiryokikanCode().getValue().isEmpty() ? null
                        : new IryoKikanCode(div.getShujiiJohoInput().getTxtiryokikanCode().getValue()))
                .set医療機関名称(div.getShujiiJohoInput().getTxtiryokikanname().getValue())
                .set医療機関名称カナ(div.getShujiiJohoInput().getTxtiryokikanKananame().getValue())
                .set郵便番号(div.getShujiiJohoInput().getTxtYubinNo().getValue())
                .set住所(div.getShujiiJohoInput().getTxtJusho().getDomain().value())
                .set電話番号(div.getShujiiJohoInput().getTxtTelNo().getDomain())
                .set代表者名(new AtenaMeisho(div.getShujiiJohoInput().getTxtdaihyoshaname().getValue()))
                .set代表者名カナ(div.getShujiiJohoInput().getTxtdaihyoshakananame().getValue())
                .setFax番号(div.getShujiiJohoInput().getTxtFaxNo().getDomain())
                .set状況フラグ(CODE_有効.equals(div.getShujiiJohoInput().getRadJokyoFlag().getSelectedKey())).build();
    }

    /**
     * 調査員情報登録エリアが非活性に設定します。
     */
    public void setDisabledTrue() {
        div.getShujiiJohoInput().getTxtShichoson().setDisabled(true);
        div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getShujiiJohoInput().getTxtShichosonmei().setDisabled(true);
        div.getShujiiJohoInput().getBtnToSearchIryoKikan().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
        div.getShujiiJohoInput().getTxtiryokikanCode().setDisabled(true);
        div.getShujiiJohoInput().getTxtiryokikanname().setDisabled(true);
        div.getShujiiJohoInput().getTxtiryokikanKananame().setDisabled(true);
        div.getShujiiJohoInput().getTxtYubinNo().setDisabled(true);
        div.getShujiiJohoInput().getTxtJusho().setDisabled(true);
        div.getShujiiJohoInput().getTxtTelNo().setDisabled(true);
        div.getShujiiJohoInput().getTxtFaxNo().setDisabled(true);
        div.getShujiiJohoInput().getTxtdaihyoshaname().setDisabled(true);
        div.getShujiiJohoInput().getTxtdaihyoshakananame().setDisabled(true);
        div.getShujiiJohoInput().getRadJokyoFlag().setDisabled(true);
        div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().setDisabled(true);
        div.getShujiiJohoInput().getKozaJoho().getDdlYokinShubetsu().setDisabled(true);
        div.getShujiiJohoInput().getKozaJoho().getTxtGinkoKozaNo().setDisabled(true);
        div.getShujiiJohoInput().getKozaJoho().getTxtKozaMeiginin().setDisabled(true);
        div.getShujiiJohoInput().getKozaJoho().getTxtKanjiMeiginin().setDisabled(true);
    }

    /**
     * 主治医医療機関情報登録エリアが活性に設定します。
     */
    public void setDisabledFalse() {
        div.getShujiiJohoInput().getTxtShichoson().setDisabled(false);
        div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(false);
        div.getShujiiJohoInput().getBtnToSearchIryoKikan().setDisabled(false);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(false);
        div.getShujiiJohoInput().getTxtiryokikanCode().setDisabled(false);
        div.getShujiiJohoInput().getTxtiryokikanname().setDisabled(false);
        div.getShujiiJohoInput().getTxtiryokikanKananame().setDisabled(false);
        div.getShujiiJohoInput().getTxtYubinNo().setDisabled(false);
        div.getShujiiJohoInput().getTxtJusho().setDisabled(false);
        div.getShujiiJohoInput().getTxtTelNo().setDisabled(false);
        div.getShujiiJohoInput().getTxtFaxNo().setDisabled(false);
        div.getShujiiJohoInput().getTxtdaihyoshaname().setDisabled(false);
        div.getShujiiJohoInput().getTxtdaihyoshakananame().setDisabled(false);
        div.getShujiiJohoInput().getRadJokyoFlag().setDisabled(false);
        div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
        div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().setDisabled(false);
        div.getShujiiJohoInput().getKozaJoho().getDdlYokinShubetsu().setDisabled(false);
        div.getShujiiJohoInput().getKozaJoho().getTxtGinkoKozaNo().setDisabled(false);
        div.getShujiiJohoInput().getKozaJoho().getTxtKozaMeiginin().setDisabled(false);
        div.getShujiiJohoInput().getKozaJoho().getTxtKanjiMeiginin().setDisabled(false);
    }

    /**
     * 主治医医療機関情報登録エリアをクリアします。
     */
    public void clearShujiiIryoKikanJohoToMeisai() {
        div.getShujiiJohoInput().getTxtShichoson().clearValue();
        div.getShujiiJohoInput().getTxtShichosonmei().clearValue();
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().clearValue();
        div.getShujiiJohoInput().getTxtiryokikanCode().clearValue();
        div.getShujiiJohoInput().getTxtiryokikanname().clearValue();
        div.getShujiiJohoInput().getTxtiryokikanKananame().clearValue();
        div.getShujiiJohoInput().getTxtYubinNo().clearValue();
        div.getShujiiJohoInput().getTxtJusho().clearDomain();
        div.getShujiiJohoInput().getTxtTelNo().clearDomain();
        div.getShujiiJohoInput().getTxtFaxNo().clearDomain();
        div.getShujiiJohoInput().getTxtdaihyoshaname().clearValue();
        div.getShujiiJohoInput().getTxtdaihyoshakananame().clearValue();
        div.getShujiiJohoInput().getRadJokyoFlag().setSelectedIndex(0);
        div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().clear();
        div.getShujiiJohoInput().getKozaJoho().getDdlYokinShubetsu().setSelectedIndex(0);
        div.getShujiiJohoInput().getKozaJoho().getTxtGinkoKozaNo().clearValue();
        div.getShujiiJohoInput().getKozaJoho().getTxtKozaMeiginin().clearValue();
        div.getShujiiJohoInput().getKozaJoho().getTxtKanjiMeiginin().clearValue();
    }

    /**
     * 主治医医療機関情報登録エリアを編集します。
     *
     * @return 編集結果
     */
    public RString getInputDiv() {
        RStringBuilder inputDiv = new RStringBuilder();
        ShujiiJohoInputDiv shujiiJohoInputDiv = div.getShujiiJohoInput();
        inputDiv.append(shujiiJohoInputDiv.getTxtShujiiIryoKikanCode().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtiryokikanCode().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtiryokikanname().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtiryokikanKananame().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtYubinNo().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtJusho().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtTelNo().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtFaxNo().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtdaihyoshaname().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtdaihyoshakananame().getValue());
        inputDiv.append(shujiiJohoInputDiv.getRadJokyoFlag().getSelectedKey());
        return inputDiv.toRString();
    }

    /**
     * 市町村名の取得します。
     *
     * @param 市町村コード 市町村コード
     */
    public void onBlur_txtShichoson(RString 市町村コード) {
        div.getShujiiJohoInput().getTxtShichosonmei().setValue(市町村コード);
    }
}
