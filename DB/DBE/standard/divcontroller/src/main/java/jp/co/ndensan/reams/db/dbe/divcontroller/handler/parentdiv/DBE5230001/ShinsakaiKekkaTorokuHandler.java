/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.NinteiShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuHandler {

    private final ShinsakaiKekkaTorokuDiv div;
    private static final RString キー_0 = new RString("key0");
    private static final RString 介護１ = new RString("介護１");
    private static final Decimal 月_6 = new Decimal("6");
    private static final Decimal 月_12 = new Decimal("12");
    private static final Decimal 月_24 = new Decimal("24");
    private static final RString 更新申請 = new RString("更新申請");
    private static final RString 新規申請 = new RString("新規申請");
    private static final RString 区分変更申請有効期間 = new RString("区分変更申請有効期間");
    private static final RString キー_12 = new RString("12");
    private static final RString キー_13 = new RString("13");
    private static final RString キー_21 = new RString("21");
    private static final RString キー_22 = new RString("22");
    private static final RString キー_23 = new RString("23");
    private static final RString キー_24 = new RString("24");
    private static final RString キー_25 = new RString("25");
    private static final RString キー_01 = new RString("01");
    private static final RString 更新_FLAG = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催結果登録Div
     */
    public ShinsakaiKekkaTorokuHandler(ShinsakaiKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param headList headList
     * @param iChiRanList iChiRanList
     */
    public void onLoad(List<ShinsakaiKekkaTorokuBusiness> headList, List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList) {
        setKyotsuHyojiAreaHyojiSeigyo();
        set状態像コードドロップダウン();
        set判定結果ドロップダウン();
        set二次判定ドロップダウン();
        set審査会意見種類ドロップダウン();
        setKyotsuHyojiArea(headList);
        setTaishoshaIchiran(iChiRanList);
    }

    private void setKyotsuHyojiAreaHyojiSeigyo() {
        div.getKyotsuHyojiArea().getTxtShinsakaiName().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtGogitaiNo().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtShinsaTaishosha().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtShinsakaiKaijo().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtChiku().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtShinsakaijoJusho().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtTaishoNinzu().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtKaisaiNichiji().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtKaisaiTimeRange().setReadOnly(true);
        div.getKyotsuHyojiArea().getChkShinsakaiShurui().setReadOnly(true);
        div.getKyotsuHyojiArea().getTxtStutas().setReadOnly(true);
        div.getBtnNinteiChosaJokyoShokai().setDisabled(true);
        div.getBtnToroku().setDisabled(true);
    }

    private void setKyotsuHyojiArea(List<ShinsakaiKekkaTorokuBusiness> headList) {
        for (ShinsakaiKekkaTorokuBusiness head : headList) {
            div.getKyotsuHyojiArea().getTxtShinsakaiName().setValue(head.get審査会名称());
            div.getKyotsuHyojiArea().getTxtGogitaiNo().setValue(head.get合議体名称());
            div.getKyotsuHyojiArea().getTxtShinsaTaishosha().setValue(new RString(head.get割付人数()));
            div.getKyotsuHyojiArea().getTxtShinsakaiKaijo().setValue(head.get審査会会場());
            div.getKyotsuHyojiArea().getTxtChiku().setValue(head.get審査会地区コード());
            div.getKyotsuHyojiArea().getTxtShinsakaijoJusho().
                    setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(), new Code(head.get審査会地区コード())));
            div.getKyotsuHyojiArea().getTxtTaishoNinzu().setValue(new RString(head.get対象人数()));
            div.getKyotsuHyojiArea().getTxtKaisaiNichiji().setValue(head.get開催日());
            if (!RString.isNullOrEmpty(head.get開催開始時間())) {
                div.getKyotsuHyojiArea().getTxtKaisaiTimeRange().setFromValue(new RTime(head.get開催開始時間()));
            }
            if (!RString.isNullOrEmpty(head.get開催終了時間())) {
                div.getKyotsuHyojiArea().getTxtKaisaiTimeRange().setToValue(new RTime(head.get開催終了時間()));
            }
            div.getKyotsuHyojiArea().getTxtStutas().setValue(head.getステータス());
            List<KeyValueDataSource> selectedItem = new ArrayList<>();
            if (head.is審査会種類()) {
                selectedItem.add(new KeyValueDataSource(キー_0, キー_0));
            }
            div.getKyotsuHyojiArea().getChkShinsakaiShurui().setSelectedItems(selectedItem);
        }
    }

    private void setTaishoshaIchiran(List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList) {
        List<dgTaishoshaIchiran_Row> dataSource = new ArrayList<>();
        TextBoxFlexibleDate 認定申請日 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 前回有効期間終了日 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 二次判定日 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 認定期間開始 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 認定期間終了 = new TextBoxFlexibleDate();
        boolean メモフラグ = false;
        boolean 意見フラグ = false;
        for (ShinsakaiKekkaTorokuIChiRanBusiness business : iChiRanList) {
            認定申請日.setValue(business.get認定申請日());
            前回有効期間終了日.setValue(business.get前回有効期間終了日());
            二次判定日.setValue(business.get二次判定日());
            認定期間開始.setValue(business.get認定期間開始());
            認定期間終了.setValue(business.get認定期間終了());
            if (!RString.isNullOrEmpty(business.get審査会メモ())) {
                メモフラグ = true;
            }
            if (!RString.isNullOrEmpty(business.get審査会意見())) {
                意見フラグ = true;
            }
            dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row(
                    new RString(business.get審査会順序()),
                    business.get保険者番号(),
                    business.get保険者(),
                    business.get被保番号(),
                    business.get氏名(),
                    business.get被保区分(),
                    business.get申請区分_申請時(),
                    business.get申請区分_申請時コード(),
                    business.get申請区分_法令(),
                    business.get申請区分_法令コード(),
                    認定申請日,
                    前回有効期間終了日,
                    business.get前回一次判定(),
                    business.get今回一次判定(),
                    business.get今回二次判定(),
                    business.get二次判定コード(),
                    business.get前回二次判定(),
                    business.get二次判定コード(),
                    business.get判定結果(),
                    business.get判定結果コード(),
                    二次判定日,
                    business.get特定疾病(),
                    business.get状態像(),
                    business.get状態像コード(),
                    認定期間開始,
                    認定期間終了,
                    business.get認定期間月数(),
                    メモフラグ,
                    意見フラグ,
                    business.get審査会意見種類(),
                    business.get一次判定結果変更理由(),
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    business.get生年月日(),
                    business.get審査会メモ(),
                    business.get審査会意見(),
                    business.get審査会意見種類コード(),
                    business.get一次判定結果変更理由(),
                    RString.EMPTY,
                    business.get申請書管理番号()
            );
            dataSource.add(row);
            メモフラグ = false;
            意見フラグ = false;
        }
        div.getShinseishaIchiran().getDgTaishoshaIchiran().setDataSource(dataSource);
    }

    /**
     * 個別エリアのデータを変更しました。
     *
     * @return boolean 変更あり：TRUE、変更なし：FALSE
     */
    public boolean hasChange() {
        return !div.getHdnHasChanged().equals(getInputItem());
    }

    /**
     * 対象者一覧gridエリアの値を変更しました。
     *
     */
    public void setSelectTaishoshaIchiran() {
        dgTaishoshaIchiran_Row row = div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem();
        List<dgTaishoshaIchiran_Row> rowList = div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource();
        row.setShinsakaiJunjo(div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().getValue());
        row.setSeiNenGaBi(new RString(div.getKobetsuHyojiArea().getTxtBirthYMD().getValue().toString()));
        row.setShinseiKubunShinseiji(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue());
        row.setShinseiKubunLaw(div.getKobetsuHyojiArea().getTxtShinseiKubunLow().getValue());
        row.setHanteiKekka(div.getKobetsuHyojiArea().getTxtIchijiHantei().getValue());
        row.getNijiHanteiDate().setValue(div.getKobetsuHyojiArea().getTxtNijiHanteiDay().getValue());
        row.setTokuteiShippei(div.getKobetsuHyojiArea().getTxtTokuteiShippei().getValue());
        row.setJotaizo(div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedValue());
        row.setHanteiKekka(div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedValue());
        row.setKonkaiNijiHantei(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedValue());
        row.getNinteiKikanKaishi().setValue(new FlexibleDate(div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue().toDateString()));
        row.getNinteiKikanShuryo().setValue(new FlexibleDate(div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue().toDateString()));
        row.setNinteiKikanTukisu(new RString(div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().toString()));
        row.setHidMemo(div.getKobetsuHyojiArea().getTxtShinsakaiMemo().getValue());
        row.setHidIkenCode(div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().getSelectedKey());
        row.setHidIken(div.getKobetsuHyojiArea().getTxtShinsakaiIken().getValue());
        row.setHidIchiHenKou(div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().getValue());
        rowList.set(div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedRowId(), row);

        div.getShinseishaIchiran().getDgTaishoshaIchiran().setDataSource(rowList);
        div.setHdnHasChanged(getSelectItem());
    }

    /**
     * 個別エリアの値を設定します。
     *
     */
    public void setKobetsuHyojiArea() {
        dgTaishoshaIchiran_Row row = div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem();
        div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().setValue(row.getShinsakaiJunjo());
        div.getKobetsuHyojiArea().getTxtShinseiDay().setValue(row.getShinseiDay().getValue());
        div.getKobetsuHyojiArea().getTxtBirthYMD().setValue(new FlexibleDate(row.getSeiNenGaBi()));
        div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().setValue(row.getShinseiKubunShinseiji());
        div.getKobetsuHyojiArea().getTxtShinseiKubunLow().setValue(row.getShinseiKubunLaw());
        div.getKobetsuHyojiArea().getTxtIchijiHantei().setValue(row.getHanteiKekka());
        div.getKobetsuHyojiArea().getTxtNijiHanteiDay().setValue(row.getNijiHanteiDate().getValue());
        div.getKobetsuHyojiArea().getTxtTokuteiShippei().setValue(row.getTokuteiShippei());
        if (!RString.isNullOrEmpty(row.getJotaizo())) {
            div.getKobetsuHyojiArea().getDdlJotaiZo().setSelectedValue(row.getJotaizo());
        } else {
            div.getKobetsuHyojiArea().getDdlJotaiZo().setSelectedKey(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getHanteiKekka())) {
            div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedValue(row.getHanteiKekka());
        } else {
            div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(RString.EMPTY);
        }
        div.getKobetsuHyojiArea().getDdlNijiHantei().setSelectedValue(row.getKonkaiNijiHantei());
        FlexibleDate ninteiKikanKaishi = row.getNinteiKikanKaishi().getValue();
        if (ninteiKikanKaishi != null && !ninteiKikanKaishi.isEmpty()) {
            div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().setValue(new RDate(row.getNinteiKikanKaishi().getValue().toString()));
        } else {
            div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().clearValue();
        }
        FlexibleDate ninteiKikanShuryo = row.getNinteiKikanShuryo().getValue();
        if (ninteiKikanShuryo != null && !ninteiKikanShuryo.isEmpty()) {
            div.getKobetsuHyojiArea().getTxtNinteiKikanTo().setValue(new RDate(row.getNinteiKikanShuryo().getValue().toString()));
        } else {
            div.getKobetsuHyojiArea().getTxtNinteiKikanTo().clearValue();
        }
        if (!RString.isNullOrEmpty(row.getNinteiKikanTukisu())) {
            div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setValue(new Decimal(row.getNinteiKikanTukisu().toString()));
        } else {
            div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().clearValue();
        }
        if (!RString.isNullOrEmpty(row.getHidMemo())) {
            div.getKobetsuHyojiArea().getTxtShinsakaiMemo().setValue(row.getHidMemo());
        } else {
            div.getKobetsuHyojiArea().getTxtShinsakaiMemo().setValue(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getHidIkenCode())) {
            div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setSelectedKey(row.getHidIkenCode());
        } else {
            div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setSelectedKey(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getHidIken())) {
            div.getKobetsuHyojiArea().getTxtShinsakaiIken().setValue(row.getHidIken());
        } else {
            div.getKobetsuHyojiArea().getTxtShinsakaiIken().setValue(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getIchijiHanteiKekkaHenkoRiyu())) {
            div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().setValue(row.getIchijiHanteiKekkaHenkoRiyu());
        } else {
            div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().setValue(RString.EMPTY);
        }
        div.getBtnNinteiChosaJokyoShokai().setDisabled(false);
        div.getBtnToroku().setDisabled(false);
        div.getKobetsuHyojiArea().setHasData(new RString("1"));
        div.setHdnHasChanged(getSelectItem());
    }

    /**
     * 対象者一覧リストの値を設定します。
     *
     */
    public void setTaishoshaIchiran() {
        TextBoxFlexibleDate 二次判定日 = div.getKobetsuHyojiArea().getTxtNijiHanteiDay();
        if (二次判定日.getValue() != null) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setNijiHanteiDate(二次判定日);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setNijiHanteiDate(null);
        }
        RString 特定疾病 = div.getKobetsuHyojiArea().getTxtTokuteiShippei().getValue();
        if (!RString.isNullOrEmpty(特定疾病)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setTokuteiShippei(特定疾病);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setTokuteiShippei(RString.EMPTY);
        }
        RString 状態像 = div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedValue();
        RString 状態像コード = div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedKey();
        if (!RString.isNullOrEmpty(状態像)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setJotaizo(状態像);
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setJotaizoCode(状態像コード);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setJotaizo(RString.EMPTY);
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setJotaizoCode(RString.EMPTY);
        }
        RString 判定結果 = div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedValue();
        RString 判定結果コード = div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(判定結果)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHanteiKekka(判定結果);
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHanteiKekkaCode(判定結果コード);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHanteiKekka(RString.EMPTY);
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHanteiKekkaCode(RString.EMPTY);
        }
        RString 二次判定 = div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedValue();
        RString 二次判定コード = div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey();
        if (!RString.isNullOrEmpty(二次判定)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setKonkaiNijiHantei(二次判定);
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setKonkaiNijiHanteiCode(二次判定コード);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setKonkaiNijiHantei(RString.EMPTY);
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setKonkaiNijiHanteiCode(RString.EMPTY);
        }
        RDate 認定期間開始日 = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        if (認定期間開始日 != null) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().getNinteiKikanKaishi().setValue(
                    new FlexibleDate(認定期間開始日.toDateString()));
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setNinteiKikanKaishi(null);
        }
        RDate 認定期間終了日 = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
        if (認定期間終了日 != null) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().getNinteiKikanShuryo().setValue(
                    new FlexibleDate(認定期間終了日.toDateString()));
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().getNinteiKikanShuryo().setValue(FlexibleDate.EMPTY);
        }
        Decimal 月数 = div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue();
        if (月数 != null) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setNinteiKikanTukisu(new RString(月数.toString()));
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setNinteiKikanTukisu(RString.EMPTY);
        }
        RString 審査会意見種類 = div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().getSelectedValue();
        if (!RString.isNullOrEmpty(審査会意見種類)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setShinsakaiIkenShurui(審査会意見種類);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setShinsakaiIkenShurui(RString.EMPTY);
        }
        RString 審査会メモ = div.getKobetsuHyojiArea().getTxtShinsakaiMemo().getValue();
        if (!RString.isNullOrEmpty(審査会メモ)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHidMemo(審査会メモ);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHidMemo(RString.EMPTY);
        }
        RString 審査会意見 = div.getKobetsuHyojiArea().getTxtShinsakaiIken().getValue();
        if (!RString.isNullOrEmpty(審査会意見)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHidIken(審査会意見);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHidIken(RString.EMPTY);
        }
        RString 審査会意見種類コード = div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().getSelectedKey();
        if (!RString.isNullOrEmpty(審査会意見種類コード)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHidIkenCode(審査会意見種類コード);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setHidIkenCode(RString.EMPTY);
        }
        RString 一次判定結果変更理由 = div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().getValue();
        if (!RString.isNullOrEmpty(一次判定結果変更理由)) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setIchijiHanteiKekkaHenkoRiyu(一次判定結果変更理由);
        } else {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setIchijiHanteiKekkaHenkoRiyu(RString.EMPTY);
        }
        if (!div.getHdnHasChanged().equals(getSelectItem())) {
            div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem().setUpDateFlag(更新_FLAG);
        }
    }

    /**
     * 個別エリアの値をクリアします。
     *
     */
    public void setKobetsuHyojiAreaClear() {
        div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().clearValue();
        div.getKobetsuHyojiArea().getTxtShinseiDay().clearValue();
        div.getKobetsuHyojiArea().getTxtBirthYMD().clearValue();
        div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().clearValue();
        div.getKobetsuHyojiArea().getTxtShinseiKubunLow().clearValue();
        div.getKobetsuHyojiArea().getTxtIchijiHantei().clearValue();
        div.getKobetsuHyojiArea().getTxtNijiHanteiDay().clearValue();
        div.getKobetsuHyojiArea().getTxtTokuteiShippei().clearValue();
        div.getKobetsuHyojiArea().getDdlJotaiZo().setSelectedKey(RString.EMPTY);
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(RString.EMPTY);
        div.getKobetsuHyojiArea().getDdlNijiHantei();
        div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().clearValue();
        div.getKobetsuHyojiArea().getTxtNinteiKikanTo().clearValue();
        div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().clearValue();
        div.getKobetsuHyojiArea().getTxtShinsakaiMemo().clearValue();
        div.getKobetsuHyojiArea().getTxtShinsakaiIken().clearValue();
        div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setSelectedKey(RString.EMPTY);
        div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().clearValue();
        div.getBtnNinteiChosaJokyoShokai().setDisabled(true);
        div.getBtnToroku().setDisabled(true);
    }

    private RString getSelectItem() {
        dgTaishoshaIchiran_Row row = div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem();
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(row.getShinsakaiJunjo())
                .append(row.getSeiNenGaBi())
                .append(row.getShinseiKubunShinseiji())
                .append(row.getShinseiKubunLaw())
                .append(row.getHanteiKekka())
                .append(row.getNijiHanteiDate().getValue())
                .append(row.getTokuteiShippei())
                .append(row.getJotaizo())
                .append(row.getHanteiKekkaCode())
                .append(row.getKonkaiNijiHanteiCode())
                .append(row.getNinteiKikanKaishi().getValue().toString())
                .append(row.getNinteiKikanShuryo().getValue().toString())
                .append(row.getNinteiKikanTukisu().toString())
                .append(row.getHidMemo())
                .append(row.getHidIkenCode())
                .append(row.getHidIken())
                .append(row.getHidIchiHenKou());
        return rsb.toRString();
    }

    private RString getInputItem() {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().getValue())
                .append(div.getKobetsuHyojiArea().getTxtBirthYMD().getValue())
                .append(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                .append(div.getKobetsuHyojiArea().getTxtShinseiKubunLow().getValue())
                .append(div.getKobetsuHyojiArea().getTxtIchijiHantei().getValue())
                .append(div.getKobetsuHyojiArea().getTxtNijiHanteiDay().getValue())
                .append(div.getKobetsuHyojiArea().getTxtTokuteiShippei().getValue())
                .append(div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedValue())
                .append(div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedKey())
                .append(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                .append(div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue().toDateString())
                .append(div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue().toDateString())
                .append(div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue() != null ? div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue() : RString.EMPTY)
                .append(div.getKobetsuHyojiArea().getTxtShinsakaiMemo().getValue())
                .append(div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().getSelectedKey())
                .append(div.getKobetsuHyojiArea().getTxtShinsakaiIken().getValue())
                .append(div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().getValue());
        return rsb.toRString();
    }

    private void set状態像コードドロップダウン() {
        List<KeyValueDataSource> 状態像コードリスト = new ArrayList();
        状態像コードリスト.add(new KeyValueDataSource(YokaigoJotaizoReiCode.その他.getコード(), YokaigoJotaizoReiCode.その他.get名称()));
        状態像コードリスト.add(new KeyValueDataSource(YokaigoJotaizoReiCode.不安定な状態.getコード(), YokaigoJotaizoReiCode.不安定な状態.get名称()));
        状態像コードリスト.add(new KeyValueDataSource(YokaigoJotaizoReiCode.認知機能の低下等.getコード(), YokaigoJotaizoReiCode.認知機能の低下等.get名称()));
        div.getKobetsuHyojiArea().getDdlJotaiZo().setDataSource(状態像コードリスト);
    }

    private void set判定結果ドロップダウン() {
        List<KeyValueDataSource> 判定結果リスト = new ArrayList();
        判定結果リスト.add(new KeyValueDataSource(HanteiKekkaCode.再審査.getコード(), HanteiKekkaCode.再審査.get名称()));
        判定結果リスト.add(new KeyValueDataSource(HanteiKekkaCode.再調査_意見書のみ.getコード(), HanteiKekkaCode.再調査_意見書のみ.get名称()));
        判定結果リスト.add(new KeyValueDataSource(HanteiKekkaCode.再調査_調査_意見書.getコード(), HanteiKekkaCode.再調査_調査_意見書.get名称()));
        判定結果リスト.add(new KeyValueDataSource(HanteiKekkaCode.再調査_調査のみ.getコード(), HanteiKekkaCode.再調査_調査のみ.get名称()));
        判定結果リスト.add(new KeyValueDataSource(HanteiKekkaCode.未審査.getコード(), HanteiKekkaCode.未審査.get名称()));
        判定結果リスト.add(new KeyValueDataSource(HanteiKekkaCode.認定.getコード(), HanteiKekkaCode.認定.get名称()));
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setDataSource(判定結果リスト);

    }

    private void set二次判定ドロップダウン() {
        List<KeyValueDataSource> 二次判定リスト = new ArrayList();
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.なし.getコード(), YokaigoJotaiKubun09.なし.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.再調査.getコード(), YokaigoJotaiKubun09.再調査.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.取消.getコード(), YokaigoJotaiKubun09.取消.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護1.getコード(), YokaigoJotaiKubun09.要介護1.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護2.getコード(), YokaigoJotaiKubun09.要介護2.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護3.getコード(), YokaigoJotaiKubun09.要介護3.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護4.getコード(), YokaigoJotaiKubun09.要介護4.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護5.getコード(), YokaigoJotaiKubun09.要介護5.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要支援1.getコード(), YokaigoJotaiKubun09.要支援1.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要支援2.getコード(), YokaigoJotaiKubun09.要支援2.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.非該当.getコード(), YokaigoJotaiKubun09.非該当.get名称()));
        div.getKobetsuHyojiArea().getDdlNijiHantei().setDataSource(二次判定リスト);
    }

    private void set審査会意見種類ドロップダウン() {
        List<KeyValueDataSource> 審査会意見種類リスト = new ArrayList();
        審査会意見種類リスト.add(new KeyValueDataSource(NinteiShinsakaiIkenShurui.サービス利用への意見.getコード(),
                NinteiShinsakaiIkenShurui.サービス利用への意見.get名称()));
        審査会意見種類リスト.add(new KeyValueDataSource(NinteiShinsakaiIkenShurui.必要な療養への意見.getコード(),
                NinteiShinsakaiIkenShurui.必要な療養への意見.get名称()));
        審査会意見種類リスト.add(new KeyValueDataSource(NinteiShinsakaiIkenShurui.有効期間への意見.getコード(),
                NinteiShinsakaiIkenShurui.有効期間への意見.get名称()));
        div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setDataSource(審査会意見種類リスト);

    }

    /**
     * 「判定結果」ドロップダウンリストの選択変更の場合、対応項目の表示制御を設定します。
     *
     * @param hyojiSeigyoFlag 表示制御Flag
     */
    public void setDdlNijiHanteiHenkouSeigyo(boolean hyojiSeigyoFlag) {
        if (hyojiSeigyoFlag) {
            div.getKobetsuHyojiArea().getTxtNijiHanteiDay().setReadOnly(false);
            div.getKobetsuHyojiArea().getDdlJotaiZo().setReadOnly(false);
            div.getKobetsuHyojiArea().getDdlNijiHantei().setReadOnly(false);
            div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().setReadOnly(false);
            div.getKobetsuHyojiArea().getTxtNinteiKikanTo().setReadOnly(false);
            div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setReadOnly(false);
            div.getKobetsuHyojiArea().getBtnShinsakaiMemoTeikeibunGuide().setDisabled(false);
            div.getKobetsuHyojiArea().getTxtShinsakaiMemo().setReadOnly(false);
            div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setReadOnly(false);
            div.getKobetsuHyojiArea().getTxtShinsakaiIken().setReadOnly(false);
            div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().setReadOnly(false);
            div.getKobetsuHyojiArea().getBtnIchigoHantei().setDisabled(false);
        } else {
            div.getKobetsuHyojiArea().getTxtNijiHanteiDay().setReadOnly(true);
            div.getKobetsuHyojiArea().getDdlJotaiZo().setReadOnly(true);
            div.getKobetsuHyojiArea().getDdlNijiHantei().setReadOnly(true);
            div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().setReadOnly(true);
            div.getKobetsuHyojiArea().getTxtNinteiKikanTo().setReadOnly(true);
            div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setReadOnly(true);
            div.getKobetsuHyojiArea().getBtnShinsakaiMemoTeikeibunGuide().setDisabled(true);
            div.getKobetsuHyojiArea().getTxtShinsakaiMemo().setReadOnly(true);
            div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setReadOnly(true);
            div.getKobetsuHyojiArea().getTxtShinsakaiIken().setReadOnly(true);
            div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().setReadOnly(true);
            div.getKobetsuHyojiArea().getBtnIchigoHantei().setDisabled(true);
        }
    }

    /**
     * 「二次判定」ドロップダウンリストの選択変更の場合、認定期間を設定します。
     *
     */
    public void setNinteiKikan() {
        TextBoxDate ninteiKikanFrom = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom();
        TextBoxDate ninteiKikanTo = div.getKobetsuHyojiArea().getTxtNinteiKikanTo();
        TextBox shinseiKubun = div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji();
        if (ninteiKikanFrom.getValue() == null && ninteiKikanTo.getValue() == null) {
            if (shinseiKubun != null) {
                setShinseiKubun(shinseiKubun);
            } else {
                div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setValue(
                        new Decimal(DbBusinessConfig.get(ConfigNameDBE.新規申請有効期間, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString()));
            }
            FlexibleDate shinseiDay = div.getKobetsuHyojiArea().getTxtShinseiDay().getValue();
            div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().setValue(new RDate(shinseiDay.toString()));
            div.getKobetsuHyojiArea().getTxtNinteiKikanTo().setValue(new RDate(shinseiDay.plusMonth(
                    div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().intValue()).toString()));
        }
    }

    private void setShinseiKubun(TextBox shinseiKubun) {
        if (更新申請.equals(shinseiKubun.getValue())) {
            div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setValue(
                    new Decimal(DbBusinessConfig.get(ConfigNameDBE.更新申請有効期間, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString()));
        } else if (新規申請.equals(shinseiKubun.getValue())) {
            div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setValue(
                    new Decimal(DbBusinessConfig.get(ConfigNameDBE.新規申請有効期間, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString()));
        } else if (区分変更申請有効期間.equals(shinseiKubun.getValue())) {
            div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setValue(
                    new Decimal(DbBusinessConfig.get(ConfigNameDBE.区分変更申請有効期間, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString()));
        } else {
            div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setValue(
                    new Decimal(DbBusinessConfig.get(ConfigNameDBE.新規申請有効期間, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString()));
        }
    }

    /**
     * 「二次判定」ドロップダウンリストの選択変更の場合、判定結果を設定します。
     *
     */
    public void setHanteiKekka() {
        if (キー_12.equals(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                || キー_13.equals(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                || キー_21.equals(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                || キー_22.equals(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                || キー_23.equals(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                || キー_24.equals(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                || キー_25.equals(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())) {
            div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(キー_01);
        } else {
            div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(RString.EMPTY);
        }
    }

    /**
     * 「有効月数」の値変更の場合、審査会意見定型文を設定します。
     *
     */
    public void setShinsakaiIken() {
        Decimal month = div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue();
        if (month != null) {
            if ((月_6.compareTo(month) == 0 || 月_6.compareTo(month) == -1) && (月_12.compareTo(month) == 0 || 月_12.compareTo(month) == 1)) {
                div.getKobetsuHyojiArea().getTxtShinsakaiIken().setValue(
                        DbBusinessConfig.get(ConfigNameDBE.審査会意見12, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
            } else if ((月_12.compareTo(month) == 0 || 月_12.compareTo(month) == -1) && (月_24.compareTo(month) == 0 || 月_24.compareTo(month) == 1)) {
                div.getKobetsuHyojiArea().getTxtShinsakaiIken().setValue(
                        DbBusinessConfig.get(ConfigNameDBE.審査会意見24, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
            } else {
                div.getKobetsuHyojiArea().getTxtShinsakaiIken().setValue(RString.EMPTY);
            }
        } else {
            div.getKobetsuHyojiArea().getTxtShinsakaiIken().setValue(RString.EMPTY);

        }
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
