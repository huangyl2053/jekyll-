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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.NinteiShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuHandler {

    private final ShinsakaiKekkaTorokuDiv div;
    private final RString key0 = new RString("key0");
    private final RString 介護１ = new RString("介護１");

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
        for (ShinsakaiKekkaTorokuBusiness head : headList) {
            div.getKyotsuHyojiArea().getTxtShinsakaiName().setValue(head.get審査会名称());
            div.getKyotsuHyojiArea().getTxtGogitaiNo().setValue(head.get合議体名称());
            div.getKyotsuHyojiArea().getTxtShinsaTaishosha().setValue(new RString(head.get割付人数()));
            div.getKyotsuHyojiArea().getTxtShinsakaiKaijo().setValue(head.get審査会会場());
            div.getKyotsuHyojiArea().getTxtChiku().setValue(head.get審査会地区コード());
            div.getKyotsuHyojiArea().getTxtChiku().
                    setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, new CodeShubetsu("5001"), new Code(head.get審査会地区コード())));
            div.getKyotsuHyojiArea().getTxtTaishoNinzu().setValue(new RString(head.get対象人数()));
            div.getKyotsuHyojiArea().getTxtKaisaiNichiji().setValue(head.get開催日());
            div.getKyotsuHyojiArea().getTxtKaisaiTimeRange().setFromValue(new RTime(head.get開催開始時間()));
            div.getKyotsuHyojiArea().getTxtKaisaiTimeRange().setToValue(new RTime(head.get開催終了時間()));
            div.getKyotsuHyojiArea().getTxtStutas().setValue(head.getステータス());
            List<KeyValueDataSource> selectedItem = new ArrayList<>();
            if (head.is審査会種類()) {
                selectedItem.add(new KeyValueDataSource(key0, key0));
            }
            div.getKyotsuHyojiArea().getChkShinsakaiShurui().setSelectedItems(selectedItem);
        }
        setTaishoshaIchiran(iChiRanList);
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
                    business.get申請区分_法令(),
                    認定申請日,
                    前回有効期間終了日,
                    business.get前回一次判定(),
                    business.get今回一次判定(),
                    business.get今回二次判定(),
                    business.get前回二次判定(),
                    business.get判定結果(),
                    二次判定日,
                    business.get特定疾病(),
                    business.get状態像コード(),
                    認定期間開始,
                    認定期間終了,
                    business.get認定期間月数(),
                    メモフラグ,
                    意見フラグ,
                    NinteiShinsakaiIkenShurui.toValue(business.get審査会意見種類()).get名称(),
                    key0,
                    key0,
                    key0,
                    key0,
                    key0,
                    new RString(business.get生年月日().toString()),
                    business.get審査会メモ(),
                    business.get審査会意見(),
                    business.get審査会意見種類(),
                    business.get一次判定結果変更理由());
            dataSource.add(row);
            メモフラグ = false;
            意見フラグ = false;
        }
        div.getShinseishaIchiran().getDgTaishoshaIchiran().setDataSource(dataSource);
    }

    /**
     * 設定期間Fromと設定期間Toの前後順チェック
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 設定期間Fromと設定期間Toの前後順() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue()
                .isBefore(div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuHandler.IdocheckMessages(
                    UrErrorMessages.期間が不正_追加メッセージあり２, "設定期間From", "設定期間To")));
        }
        return validPairs;
    }

    /**
     * 有効月数チェック
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 有効月数チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(Decimal.ZERO) == 0) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        }
        return validPairs;
    }

    /**
     * 有効月数範囲チェック
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 有効月数範囲チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if ((NinteiShinseiShinseijiKubunCode.新規申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                || NinteiShinseiShinseijiKubunCode.区分変更申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue()))
                && !((div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(Decimal.ONE) >= 0)
                && (div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(new Decimal("12"))) <= 0)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        } else if (NinteiShinseiShinseijiKubunCode.更新申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                && !((div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(Decimal.ONE) >= 0)
                && (div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(new Decimal("24"))) <= 0)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        }
        return validPairs;
    }

    /**
     * 対象者一覧件数チェック
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 対象者一覧件数チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuHandler.IdocheckMessages(UrErrorMessages.該当データなし)));
        }
        return validPairs;
    }

    /**
     * 入力チェック
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (介護１.equals(div.getTxtIchijiHantei().getValue())
                && div.getDdlJotaiZo().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuHandler.IdocheckMessages(UrErrorMessages.必須項目), div.getDdlJotaiZo()));
        }
        return validPairs;
    }

    /**
     * 個別エリアのデータを変更しました。
     *
     * @return boolean 変更あり：TRUE、変更なし：FALSE
     */
    public boolean hasChange() {
        return !div.getKobetsuHyojiArea().getHasData().equals(getInputItem());
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
        div.getKobetsuHyojiArea().getTxtBirthYMD().setValue(new FlexibleDate(row.getSeiNenGaBi()));
        div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().setValue(row.getShinseiKubunShinseiji());
        div.getKobetsuHyojiArea().getTxtShinseiKubunLow().setValue(row.getShinseiKubunLaw());
        div.getKobetsuHyojiArea().getTxtIchijiHantei().setValue(row.getHanteiKekka());
        div.getKobetsuHyojiArea().getTxtNijiHanteiDay().setValue(row.getNijiHanteiDate().getValue());
        div.getKobetsuHyojiArea().getTxtTokuteiShippei().setValue(row.getTokuteiShippei());
        set状態像コードドロップダウン();
        set判定結果ドロップダウン();
        set二次判定ドロップダウン();
        set審査会意見種類ドロップダウン();
        div.getKobetsuHyojiArea().getDdlJotaiZo().setSelectedValue(row.getJotaizo());
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedValue(row.getHanteiKekka());
        div.getKobetsuHyojiArea().getDdlNijiHantei().setSelectedValue(row.getKonkaiNijiHantei());
        div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().setValue(new RDate(row.getNinteiKikanKaishi().getValue().toString()));
        div.getKobetsuHyojiArea().getTxtNinteiKikanTo().setValue(new RDate(row.getNinteiKikanShuryo().getValue().toString()));
        div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().setValue(new Decimal(row.getNinteiKikanTukisu().toString()));
        div.getKobetsuHyojiArea().getTxtShinsakaiMemo().setValue(row.getHidMemo());
        div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setSelectedKey(row.getHidIkenCode());
        div.getKobetsuHyojiArea().getTxtShinsakaiIken().setValue(row.getHidIken());
        div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().setValue(row.getHidIchiHenKou());
        div.setHdnHasChanged(getSelectItem());
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
                .append(row.getHanteiKekka())
                .append(row.getKonkaiNijiHantei())
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
                .append(div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedKey())
                .append(div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedKey())
                .append(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                .append(div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue().toDateString())
                .append(div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue().toDateString())
                .append(div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue())
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
