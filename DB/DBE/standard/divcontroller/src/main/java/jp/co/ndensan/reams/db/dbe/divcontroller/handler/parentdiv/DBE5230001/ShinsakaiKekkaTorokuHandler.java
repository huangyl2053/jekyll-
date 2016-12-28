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
import jp.co.ndensan.reams.db.dbe.definition.core.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
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
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuHandler {

    private final ShinsakaiKekkaTorokuDiv div;
    private static final RString ダミーキー = new RString("key0");
    private static final int 認定期間月数なし = 0;
    private static final int 認定期間月数12ヶ月 = 12;
    private static final int 認定期間月数24ヶ月 = 24;
    private static final int 月の初めの日 = 1;
    private static final RString 更新_FLAG = new RString("1");
    private static final RString 保存するボタンID = new RString("btnUpdate");

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
        set個別表示欄入力不可();
        set状態像コードドロップダウン();
        set判定結果ドロップダウン();
        set二次判定ドロップダウン();
        set審査会意見種類ドロップダウン();
        setKyotsuHyojiArea(headList);
        setTaishoshaIchiran(iChiRanList);
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
                selectedItem.add(new KeyValueDataSource(ダミーキー, ダミーキー));
            }
            div.getKyotsuHyojiArea().getChkShinsakaiShurui().setSelectedItems(selectedItem);
            div.getKyotsuHyojiArea().getTxtShinsakaiKaisaiYoteiYMD().setValue(head.get開催予定日());
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
                    business.get取下区分名称(),
                    business.get取下区分コード().get取下げ区分コード().value(),
                    前回有効期間終了日,
                    business.get前回一次判定(),
                    business.get今回一次判定(),
                    business.get前回二次判定(),
                    business.get前回二次判定コード(),
                    business.get今回二次判定(),
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
                    business.get生年月日(),
                    business.get審査会メモ(),
                    business.get審査会意見(),
                    business.get審査会意見種類コード(),
                    business.get一次判定結果変更理由(),
                    RString.EMPTY,
                    business.get申請書管理番号(),
                    business.get一次判定(),
                    business.厚労省IF識別コード()
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
     * 個別エリアの値を設定します。
     *
     */
    public void set個別内容(dgTaishoshaIchiran_Row row) {
        clear個別表示欄Value();
        div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().setValue(row.getShinsakaiJunjo());
        div.getKobetsuHyojiArea().getTxtShinseiDay().setValue(row.getShinseiDay().getValue());
        div.getKobetsuHyojiArea().getTxtBirthYMD().setValue(new FlexibleDate(row.getSeiNenGaBi()));
        div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().setValue(row.getShinseiKubunShinseiji());
        div.getKobetsuHyojiArea().getTxtShinseiKubunLaw().setValue(row.getShinseiKubunLaw());
        div.getKobetsuHyojiArea().getTxtTorisageKubun().setValue(row.getTorisageKubunTx());
        div.getKobetsuHyojiArea().getTxtIchijiHantei().setValue(row.getIchijiHantei());
        FlexibleDate nijiHanteiDate = row.getNijiHanteiDate().getValue();
        if (nijiHanteiDate == null || nijiHanteiDate.isEmpty()) {
            div.getKobetsuHyojiArea().getTxtNijiHanteiDay().clearValue();
        } else {
            div.getKobetsuHyojiArea().getTxtNijiHanteiDay().setValue(new RDate(row.getNijiHanteiDate().getValue().toString()));
        }
        div.getKobetsuHyojiArea().getTxtTokuteiShippei().setValue(row.getTokuteiShippei());
        if (!RString.isNullOrEmpty(row.getJotaizo())) {
            div.getKobetsuHyojiArea().getDdlJotaiZo().setSelectedValue(row.getJotaizo());
        } else {
            div.getKobetsuHyojiArea().getDdlJotaiZo().setSelectedKey(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getHanteiKekkaCode())) {
            div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(row.getHanteiKekkaCode());
        } else {
            div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getKonkaiNijiHantei())) {
            div.getKobetsuHyojiArea().getDdlNijiHantei().setSelectedValue(row.getKonkaiNijiHantei());
        }
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
            div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setSelectedKey(row.getNinteiKikanTukisu());
            div.getKobetsuHyojiArea().setPrevNinteiKikanMonth(row.getNinteiKikanTukisu());
        } else {
            div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setSelectedKey(new RString(認定期間月数なし));
            div.getKobetsuHyojiArea().setPrevNinteiKikanMonth(new RString(認定期間月数なし));
        }
        div.getKobetsuHyojiArea().setPrevNinteiKikanMonth(row.getNinteiKikanTukisu());
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
        /**
         * 二次判断が「要介護１」の場合のみ、状態像の入力が必須となるがを設定
         */
        if (get今回二次判定() == YokaigoJotaiKubun09.要介護1) {
            set状態像Deisabled(false);
        } else {
            set状態像Deisabled(true);
        }
        div.setHdnHasChanged(getInputItem());
        boolean is入力可 = row.getHanteiKekkaCode().equals(HanteiKekkaCode.認定.getコード());
        set個別入力制御変更from判定結果(is入力可);
        if (!is入力可) {
            clear個別表示欄Value判定結果以外();
        }
    }

    /**
     * 対象者一覧リストの値を設定します。
     *
     */
    public void set更新対象RowFrom個別表示内容(NinteiShinseiKubunHorei 法令申請区分, TorisageKubun 取下区分) {
        dgTaishoshaIchiran_Row 更新対象row = get更新対象row();
        if (更新対象row == null) {
            return;
        }
        更新対象row.setShinseiKubunLaw(new RString(法令申請区分.toString()));
        更新対象row.setShinseiKubunLawCode(new RString(法令申請区分.getコード()));
        更新対象row.setTorisageKubunTx(new RString(取下区分.toString()));
        更新対象row.setTorisageKubunCode(取下区分.get取下げ区分コード().value());

        RDate 二次判定日 = div.getKobetsuHyojiArea().getTxtNijiHanteiDay().getValue();
        if (二次判定日 != null) {
            更新対象row.getNijiHanteiDate().setValue(new FlexibleDate(二次判定日.toDateString()));
        } else {
            更新対象row.getNijiHanteiDate().setValue(FlexibleDate.EMPTY);
        }
        RString 特定疾病 = div.getKobetsuHyojiArea().getTxtTokuteiShippei().getValue();
        if (!RString.isNullOrEmpty(特定疾病)) {
            更新対象row.setTokuteiShippei(特定疾病);
        } else {
            更新対象row.setTokuteiShippei(RString.EMPTY);
        }
        RString 状態像 = div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedValue();
        RString 状態像コード = div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedKey();
        if (!RString.isNullOrEmpty(状態像)) {
            更新対象row.setJotaizo(状態像);
            更新対象row.setJotaizoCode(状態像コード);
        } else {
            更新対象row.setJotaizo(RString.EMPTY);
            更新対象row.setJotaizoCode(RString.EMPTY);
        }
        RString 判定結果 = div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedValue();
        RString 判定結果コード = div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(判定結果)) {
            更新対象row.setHanteiKekka(判定結果);
            更新対象row.setHanteiKekkaCode(判定結果コード);
        } else {
            更新対象row.setHanteiKekka(RString.EMPTY);
            更新対象row.setHanteiKekkaCode(RString.EMPTY);
        }
        RString 二次判定 = div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedValue();
        RString 二次判定コード = div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey();
        if (!RString.isNullOrEmpty(二次判定)) {
            更新対象row.setKonkaiNijiHantei(二次判定);
            更新対象row.setKonkaiNijiHanteiCode(二次判定コード);
        } else {
            更新対象row.setKonkaiNijiHantei(RString.EMPTY);
            更新対象row.setKonkaiNijiHanteiCode(RString.EMPTY);
        }
        RDate 認定期間開始日 = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        if (認定期間開始日 != null) {
            更新対象row.getNinteiKikanKaishi().setValue(
                    new FlexibleDate(認定期間開始日.toDateString()));
        } else {
            更新対象row.getNinteiKikanKaishi().setValue(FlexibleDate.EMPTY);
        }
        RDate 認定期間終了日 = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
        if (認定期間終了日 != null) {
            更新対象row.getNinteiKikanShuryo().setValue(new FlexibleDate(認定期間終了日.toDateString()));
        } else {
            更新対象row.getNinteiKikanShuryo().setValue(FlexibleDate.EMPTY);
        }
        RString 調定期間月数 = div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedValue();
        if (!調定期間月数.isNullOrEmpty()) {
            更新対象row.setNinteiKikanTukisu(調定期間月数);
        } else {
            更新対象row.setNinteiKikanTukisu(RString.EMPTY);
        }
        RString 審査会意見種類 = div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().getSelectedValue();
        if (!RString.isNullOrEmpty(審査会意見種類)) {
            更新対象row.setShinsakaiIkenShurui(審査会意見種類);
        } else {
            更新対象row.setShinsakaiIkenShurui(RString.EMPTY);
        }
        RString 審査会メモ = div.getKobetsuHyojiArea().getTxtShinsakaiMemo().getValue();
        if (!RString.isNullOrEmpty(審査会メモ)) {
            更新対象row.setHidMemo(審査会メモ);
        } else {
            更新対象row.setHidMemo(RString.EMPTY);
        }
        RString 審査会意見 = div.getKobetsuHyojiArea().getTxtShinsakaiIken().getValue();
        if (!RString.isNullOrEmpty(審査会意見)) {
            更新対象row.setHidIken(審査会意見);
        } else {
            更新対象row.setHidIken(RString.EMPTY);
        }
        RString 審査会意見種類コード = div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().getSelectedKey();
        if (!RString.isNullOrEmpty(審査会意見種類コード)) {
            更新対象row.setHidIkenCode(審査会意見種類コード);
        } else {
            更新対象row.setHidIkenCode(RString.EMPTY);
        }
        RString 一次判定結果変更理由 = div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().getValue();
        if (!RString.isNullOrEmpty(一次判定結果変更理由)) {
            更新対象row.setIchijiHanteiKekkaHenkoRiyu(一次判定結果変更理由);
        } else {
            更新対象row.setIchijiHanteiKekkaHenkoRiyu(RString.EMPTY);
        }
        if (!div.getHdnHasChanged().equals(getInputItem())) {
            更新対象row.setUpDateFlag(更新_FLAG);
        }
    }

    /**
     * 個別表示欄を入力可にします。
     *
     */
    public void set個別表示欄入力可() {
        div.getKobetsuHyojiArea().setReadOnly(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタンID, true);

    }

    /**
     * 個別表示欄を入力不可にします。
     *
     */
    public void set個別表示欄入力不可() {
        div.getKobetsuHyojiArea().setReadOnly(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタンID, false);
    }

    /**
     * 個別エリアの値をクリアします。
     *
     */
    public void clear個別表示欄Value() {
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(RString.EMPTY);
        clear個別表示欄Value判定結果以外();
    }

    /**
     * 個別エリアの判定結果以外の値をクリアします。
     */
    public void clear個別表示欄Value判定結果以外() {
        div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().clearValue();
        div.getKobetsuHyojiArea().getTxtShinseiDay().clearValue();
        div.getKobetsuHyojiArea().getTxtBirthYMD().clearValue();
        div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().clearValue();
        div.getKobetsuHyojiArea().getTxtShinseiKubunLaw().clearValue();
        div.getKobetsuHyojiArea().getTxtTorisageKubun().clearValue();
        div.getKobetsuHyojiArea().getTxtIchijiHantei().clearValue();
        div.getKobetsuHyojiArea().getTxtNijiHanteiDay().clearValue();
        div.getKobetsuHyojiArea().getTxtTokuteiShippei().clearValue();
        div.getKobetsuHyojiArea().getDdlJotaiZo().setSelectedKey(RString.EMPTY);
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(RString.EMPTY);
        div.getKobetsuHyojiArea().getDdlNijiHantei().setSelectedKey(YokaigoJotaiKubun09.なし.getコード());
        div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().clearValue();
        div.getKobetsuHyojiArea().getTxtNinteiKikanTo().clearValue();
        div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setSelectedKey(new RString(認定期間月数なし));
        div.getKobetsuHyojiArea().getTxtShinsakaiMemo().clearValue();
        div.getKobetsuHyojiArea().getTxtShinsakaiIken().clearValue();
        div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setSelectedKey(RString.EMPTY);
        div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().clearValue();
    }

    private RString getInputItem() {
        RStringBuilder rsb = new RStringBuilder();
        RDate 認定期間From = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        RDate 認定期間To = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
        RString 認定期間開始日文字列 = (認定期間From == null) ? RString.EMPTY : 認定期間From.toDateString();
        RString 認定期間終了日文字列 = (認定期間To == null) ? RString.EMPTY : 認定期間To.toDateString();
        rsb.append(div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().getValue())
                .append(div.getKobetsuHyojiArea().getTxtBirthYMD().getValue())
                .append(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                .append(div.getKobetsuHyojiArea().getTxtShinseiKubunLaw().getValue())
                .append(div.getKobetsuHyojiArea().getTxtTorisageKubun().getValue())
                .append(div.getKobetsuHyojiArea().getTxtIchijiHantei().getValue())
                .append(div.getKobetsuHyojiArea().getTxtNijiHanteiDay().getValue())
                .append(div.getKobetsuHyojiArea().getTxtTokuteiShippei().getValue())
                .append(div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedValue())
                .append(div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedKey())
                .append(div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey())
                .append(認定期間開始日文字列)
                .append(認定期間終了日文字列)
                .append((get認定期間月数() != 0) ? new RString(get認定期間月数()) : RString.EMPTY)
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
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要支援1.getコード(), YokaigoJotaiKubun09.要支援1.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要支援2.getコード(), YokaigoJotaiKubun09.要支援2.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護1.getコード(), YokaigoJotaiKubun09.要介護1.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護2.getコード(), YokaigoJotaiKubun09.要介護2.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護3.getコード(), YokaigoJotaiKubun09.要介護3.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護4.getコード(), YokaigoJotaiKubun09.要介護4.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護5.getコード(), YokaigoJotaiKubun09.要介護5.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.非該当.getコード(), YokaigoJotaiKubun09.非該当.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.再調査.getコード(), YokaigoJotaiKubun09.再調査.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.取消.getコード(), YokaigoJotaiKubun09.取消.get名称()));

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
    public void set個別入力制御変更from判定結果() {
        boolean is入力可 = div.getDdlHanteiKekka().getSelectedKey().equals(HanteiKekkaCode.認定.getコード());
        set個別入力制御変更from判定結果(is入力可);
        if (is入力可 == false || is判定結果変更前入力可() == true) {
            clear個別表示欄Value判定結果以外();
        }
        if (is入力可 == true || is判定結果変更前入力可() == false) {
            RString 判定結果selectedKey = div.getDdlHanteiKekka().getSelectedKey();
            set個別内容(get更新対象row());
            div.getDdlHanteiKekka().getSelectedKey().equals(判定結果selectedKey);

        }
    }

    private boolean is判定結果変更前入力可() {
        return div.getKobetsuHyojiArea().getTxtNijiHanteiDay().isReadOnly();
    }

    private void set個別入力制御変更from判定結果(boolean hyojiSeigyoFlag) {
        div.getKobetsuHyojiArea().getTxtNijiHanteiDay().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getDdlJotaiZo().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getDdlNijiHantei().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getTxtNinteiKikanTo().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getBtnShinsakaiMemoTeikeibunGuide().setDisabled(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getTxtShinsakaiMemo().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getBtnShinsakiIkenTeikeibunGuide().setDisabled(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getTxtShinsakaiIken().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getBtnIchijiHanteiTeikeibunGuide().setDisabled(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().setReadOnly(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getBtnNinteiChosaJokyoShokai().setDisabled(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getBtnCancel().setDisabled(!hyojiSeigyoFlag);
        div.getKobetsuHyojiArea().getBtnToroku().setDisabled(!hyojiSeigyoFlag);
    }

    /**
     * 認定期間開始日を算出、設定します。
     */
    public void set認定期間開始日() {
        RDate 認定期間開始日 = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        if (認定期間開始日 != null) {
            return;
        }
        認定期間開始日 = calculate認定期間開始日();
        if (認定期間開始日 == null) {
            return;
        }
        div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().setValue(認定期間開始日);
    }

    /**
     * 認定期間終了日を算出、設定します。
     */
    public void set認定期間終了日() {
        RDate 認定期間終了日 = calculate認定期間終了日();
        if (認定期間終了日 == null) {
            return;
        }
        div.getKobetsuHyojiArea().getTxtNinteiKikanTo().setValue(認定期間終了日);
    }

    private RDate calculate認定期間開始日() {
        return calculate算出基準日();
    }

    private RDate calculate認定期間終了日() {
        RDate 認定期間開始日 = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        int 認定期間月数 = Integer.parseInt(div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedKey().toString());

        RDate 認定期間終了日 = 認定期間開始日.plusMonth(認定期間月数);
        if (認定期間終了日.getDayValue() == 月の初めの日) {
            return 認定期間終了日.minusDay(1);
        }
        return get当月末日(認定期間終了日.getYearMonth());
    }

    private RDate get当月末日(RYearMonth 基準年月) {
        return new RDate(基準年月.getYearValue(), 基準年月.getMonthValue(), 1).plusMonth(1).minusDay(1);
    }

    /**
     * 認定期間の入力から認定期間月数を算出し、これを設定します。
     */
    public void set認定期間月数() {
        RDate 認定期間From = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        RDate 認定期間To = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
        if (認定期間From == null && 認定期間To == null) {
            NinteiShinseiKubunShinsei 申請時申請区分 = get申請時申請区分();
            FlexibleDate 申請日 = div.getKobetsuHyojiArea().getTxtShinseiDay().getValue();
            div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setSelectedKey(new RString(calculate認定期間月数(申請時申請区分, 申請日)));
        }
        if (認定期間From != null && 認定期間To != null) {
            int 有効月数 = 認定期間To.getBetweenMonths(認定期間From);
            if (認定期間From.getDayValue() == 月の初めの日) {
                有効月数 += 1;
            }
            if (有効月数 < 認定期間月数なし) {
                有効月数 = 認定期間月数なし;
            }
            if (有効月数 > 認定期間月数24ヶ月) {
                有効月数 = 認定期間月数24ヶ月;
            }
            div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setSelectedKey(new RString(有効月数));
        }
    }

    /**
     * 申請区分、判定結果から開始基準日を算出します。
     *
     * @return 算出基準日
     */
    RDate calculate算出基準日() {
        NinteiShinseiKubunShinsei 申請時申請区分 = get申請時申請区分();
        FlexibleDate 申請日 = div.getKobetsuHyojiArea().getTxtShinseiDay().getValue();
        if (申請時申請区分 == null) {
            return null;
        }
        dgTaishoshaIchiran_Row 更新対象row = get更新対象row();
        FlexibleDate 二次判定日 = 更新対象row.getNijiHanteiDate().getValue();
        FlexibleDate 前回有効期間終了日 = 更新対象row.getZenkaiYukoKikanShuryoDay().getValue();
        YokaigoJotaiKubun09 前回二次判定 = get前回二次判定();
        YokaigoJotaiKubun09 今回二次判定 = get今回二次判定();
        if (申請時申請区分 == NinteiShinseiKubunShinsei.新規申請) {
            return get当日(申請日);
        }
        if (申請時申請区分 == NinteiShinseiKubunShinsei.更新申請) {
            return get翌日(前回有効期間終了日);
        }
        if (申請時申請区分 == NinteiShinseiKubunShinsei.区分変更申請 && 前回二次判定 != null) {
            if (compare二次判定(前回二次判定, 今回二次判定) < 0) {
                return get当日(申請日);
            }
            if (compare二次判定(前回二次判定, 今回二次判定) > 0) {
                if (二次判定日 == null) {
                    return null;
                }
                return get当日(二次判定日);
            }
            return get翌日(前回有効期間終了日);
        }
        return null;
    }

    /**
     * 「二次判定」ドロップダウンリストの選択変更の場合、判定結果を設定します。
     *
     */
    public void set判定結果DDLfrom二次判定() {
        YokaigoJotaiKubun09 今回二次判定 = get今回二次判定();
        RString selectedKey = (is要支援要介護(今回二次判定)) ? HanteiKekkaCode.認定.getコード() : RString.EMPTY;
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(selectedKey);
    }

    /**
     * 有効月数を変更した際に、他コントロール内容に影響させます。
     */
    public void change有効月数に関連するコントロール() {
        int 変更後月数 = get認定期間月数();
        int 変更前月数 = get変更前月数();
        set審査会意見定型文from有効月数(変更前月数, 変更後月数);
        set変更前月数(変更後月数);
    }

    private int get変更前月数() {
        RString 変更前月数 = div.getKobetsuHyojiArea().getPrevNinteiKikanMonth();
        if (変更前月数 == null || 変更前月数.isEmpty()) {
            return -1;
        }
        return Integer.parseInt(div.getKobetsuHyojiArea().getPrevNinteiKikanMonth().toString());
    }

    private void set変更前月数(int 有効月数) {
        div.getKobetsuHyojiArea().setPrevNinteiKikanMonth(new RString(有効月数));
    }

    /**
     * 「有効月数」の値変更の場合、審査会意見定型文を設定します。
     *
     */
    private void set審査会意見定型文from有効月数(int 変更前月数, int 変更後月数) {
        RString 文言 = get審査会意見定型文from有効月数(変更前月数, 変更後月数);
        if (文言 != null) {
            div.getKobetsuHyojiArea().getTxtShinsakaiIken().setValue(文言);
        }
    }

    private RString get審査会意見定型文from有効月数(int 変更前月数, int 変更後月数) {
        if (変更前月数 != 認定期間月数12ヶ月 && 変更後月数 == 認定期間月数12ヶ月) {
            return getConfig審査会意見12();
        }
        if (変更前月数 != 認定期間月数24ヶ月 && 変更後月数 == 認定期間月数24ヶ月) {
            return getConfig審査会意見24();
        }
        if (変更前月数 == 認定期間月数12ヶ月 && 変更後月数 != 認定期間月数12ヶ月) {
            return RString.EMPTY;
        }
        if (変更前月数 == 認定期間月数24ヶ月 && 変更後月数 != 認定期間月数24ヶ月) {
            return RString.EMPTY;
        }
        return null;
    }

    /**
     * 申請時申請区分を返します。個別入力時用です。
     *
     * @return 法令申請区分
     */
    public NinteiShinseiKubunShinsei get申請時申請区分() {
        dgTaishoshaIchiran_Row 更新対象row = get更新対象row();
        if (更新対象row == null) {
            return null;
        }
        RString 申請時申請区分 = 更新対象row.getShinseiKubunShinseijiCode();
        if (RString.isNullOrEmpty(申請時申請区分)) {
            return null;
        }
        return NinteiShinseiKubunShinsei.toValue(Integer.parseInt(申請時申請区分.toString()));
    }

    /**
     * 法令申請区分を返します。個別入力時用です。
     *
     * @return 法令申請区分
     */
    public NinteiShinseiKubunHorei get法令申請区分() {
        dgTaishoshaIchiran_Row 更新対象row = get更新対象row();
        if (更新対象row == null) {
            return null;
        }
        RString 法令申請区分 = 更新対象row.getShinseiKubunShinseijiCode();
        if (RString.isNullOrEmpty(法令申請区分)) {
            return null;
        }
        return NinteiShinseiKubunHorei.toValue(Integer.parseInt(法令申請区分.toString()));
    }

    /**
     * 前回二次判定を返します。個別入力時用です。
     *
     * @return 前回二次判定
     */
    public YokaigoJotaiKubun09 get前回二次判定() {
        dgTaishoshaIchiran_Row 更新対象row = get更新対象row();
        if (更新対象row == null) {
            return null;
        }
        RString 前回二次判定コード = 更新対象row.getZenkaiNijiHanteiCode();
        if (RString.isNullOrEmpty(前回二次判定コード)) {
            return null;
        }
        return convert要介護状態区分(前回二次判定コード);
    }

    /**
     * 今回二次判定を返します。個別入力時用です。
     *
     * @return 今回二次判定
     */
    public YokaigoJotaiKubun09 get今回二次判定() {
        RString 今回二次判定コード = div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey();
        if (RString.isNullOrEmpty(今回二次判定コード)) {
            return null;
        }
        return convert要介護状態区分(今回二次判定コード);
    }

    /**
     * 一覧データグリッド内対象行の申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        dgTaishoshaIchiran_Row 更新対象row = get更新対象row();
        if (更新対象row == null) {
            return null;
        }
        return get更新対象row().getShinseishoKanriNo();
    }

    /**
     * 審査会順序で指定した番号の一覧データグリッド対象行を選択された状態にします。
     *
     * @param 審査会順序 審査会順序
     */
    public void set選択行(RString 審査会順序) {
        List<dgTaishoshaIchiran_Row> 選択行 = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : div.getDgTaishoshaIchiran().getDataSource()) {
            if (row.getShinsakaiJunjo().equals(審査会順序)) {
                選択行.add(row);
            }
        }
        div.getDgTaishoshaIchiran().setSelectedItems(選択行);
    }

    /**
     * 個別欄の認定期間のコントロール制御を設定します。
     *
     * @param isDisabled {@code true}のとき非活性
     */
    public void set認定期間Deisabled(boolean isDisabled) {
        div.getTxtNinteiKikanFrom().setDisabled(isDisabled);
        div.getTxtNinteiKikanTo().setDisabled(isDisabled);
    }

    /**
     * 個別欄の状態像のコントロール制御を設定します。
     *
     * @param isDisabled {@code true}のとき非活性
     */
    public void set状態像Deisabled(boolean isDisabled) {
        div.getDdlJotaiZo().setDisabled(isDisabled);
    }

    /**
     * 個別欄の法令申請区分の表示内容を設定します。
     *
     * @param 法令申請区分 法令申請区分
     */
    public void set法令申請区分(NinteiShinseiKubunHorei 法令申請区分) {
        if (法令申請区分 == null) {
            div.getTxtShinseiKubunLaw().clearValue();
        } else {
            div.getTxtShinseiKubunLaw().setValue(new RString(法令申請区分.toString()));
        }
    }

    /**
     * 個別欄の取下区分の表示内容を設定します。
     *
     * @param 取下区分 取下区分
     */
    public void set取下区分(TorisageKubun 取下区分) {
        div.getTxtTorisageKubun().setValue(new RString(取下区分.toString()));
    }

    /**
     * 個別入力欄と対応する更新対象のデータグリッド行を返します。
     *
     * @return データグリッド行
     */
    public dgTaishoshaIchiran_Row get更新対象row() {
        RString 審査会順序 = div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().getValue();
        if (審査会順序 == null) {
            return null;
        }
        for (dgTaishoshaIchiran_Row row : div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getShinsakaiJunjo().equals(審査会順序)) {
                return row;
            }
        }
        return null;
    }

    /**
     * 前回有効期間終了日を返します。個別入力時用です。
     *
     * @return 前回有効期間終了日
     */
    public FlexibleDate get前回有効期間終了日() {
        dgTaishoshaIchiran_Row row = get更新対象row();
        if (row.getZenkaiYukoKikanShuryoDay().getValue() == null
                || row.getZenkaiYukoKikanShuryoDay().getValue().isEmpty()) {
            return new FlexibleDate(RString.EMPTY);
        }
        return row.getZenkaiYukoKikanShuryoDay().getValue();
    }

    private int get認定期間月数() {
        return Integer.parseInt(div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedKey().toString());
    }

    private static RString getConfig更新申請有効期間() {
        return DbBusinessConfig.get(ConfigNameDBE.更新申請有効期間, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }

    private static RString getConfig新規申請有効期間() {
        return DbBusinessConfig.get(ConfigNameDBE.新規申請有効期間, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }

    private static RString getConfig区分変更申請有効期間() {
        return DbBusinessConfig.get(ConfigNameDBE.区分変更申請有効期間, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }

    private static RString getConfig審査会意見12() {
        return DbBusinessConfig.get(ConfigNameDBE.審査会意見12, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }

    private static RString getConfig審査会意見24() {
        return DbBusinessConfig.get(ConfigNameDBE.審査会意見24, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }

    private static YokaigoJotaiKubun09 convert要介護状態区分(RString code) {
        if (code == null) {
            return YokaigoJotaiKubun09.なし;
        }
        return YokaigoJotaiKubun09.toValue(code);
    }

    private static int compare二次判定(YokaigoJotaiKubun09 前回二次判定, YokaigoJotaiKubun09 今回二次判定) {
        if ((前回二次判定 == null || !is要支援要介護(前回二次判定))
                && (今回二次判定 == null || !is要支援要介護(今回二次判定))) {
            return 0;
        }
        if (前回二次判定 == null || !is要支援要介護(前回二次判定)) {
            return -1;
        }
        if (今回二次判定 == null || !is要支援要介護(今回二次判定)) {
            return 1;
        }
        int 前回二次判定code = Integer.parseInt(前回二次判定.getコード().toString());
        int 今回二次判定code = Integer.parseInt(今回二次判定.getコード().toString());
        return Integer.compare(前回二次判定code, 今回二次判定code);
    }

    private static boolean is要支援要介護(YokaigoJotaiKubun09 判定内容) {
        // TODO 再調査の取り扱い
        return !(判定内容 == YokaigoJotaiKubun09.なし
                || 判定内容 == YokaigoJotaiKubun09.再調査
                || 判定内容 == YokaigoJotaiKubun09.取消
                || 判定内容 == YokaigoJotaiKubun09.非該当);
    }

    private static RDate get翌日(FlexibleDate 基準日) {
        return new RDate(基準日.plusDay(1).toString());
    }

    private static RDate get当日(FlexibleDate 基準日) {
        return new RDate(基準日.toString());
    }

    private static int calculate認定期間月数(NinteiShinseiKubunShinsei 申請時申請区分, FlexibleDate 申請日) {
        if (申請時申請区分 == null) {
            return Integer.parseInt(getConfig新規申請有効期間().toString());
        }
        RString 認定期間月数文字列
                = (申請時申請区分 == NinteiShinseiKubunShinsei.更新申請) ? getConfig更新申請有効期間()
                : (申請時申請区分 == NinteiShinseiKubunShinsei.新規申請) ? getConfig新規申請有効期間()
                : (申請時申請区分 == NinteiShinseiKubunShinsei.区分変更申請) ? getConfig区分変更申請有効期間()
                : getConfig新規申請有効期間();
        int 認定期間月数 = Integer.parseInt(認定期間月数文字列.toString());
        if (申請日 != null && !申請日.isEmpty() && 申請日.getDayValue() == 月の初めの日) {
            認定期間月数 += 1;
        }
        return 認定期間月数;
    }

    /**
     * 一切の入力処理が行えないようにします。
     */
    public void set操作不可() {
        div.setReadOnly(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタンID, true);
    }

}
