/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.util.KaigoRowState;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
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
    private static final RString ZERO = new RString(0);
    private static final int 認定期間月数なし = 0;
    private static final int 認定期間月数12ヶ月 = 12;
    private static final int 認定期間月数24ヶ月 = 24;
    private static final int 月の初めの日 = 1;
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
     * 初期化イベントです。
     *
     * @param headList headList
     * @param iChiRanList iChiRanList
     */
    public void initalize(List<ShinsakaiKekkaTorokuBusiness> headList, List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList) {
        set状態像コードドロップダウン();
        set判定結果ドロップダウン();
        set二次判定ドロップダウン();
        set審査会意見種類ドロップダウン();
        clear個別表示欄();
        set個別表示欄入力不可();
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
            List<RString> selectedKeys = new ArrayList<>();
            if (head.is審査会種類()) {
                selectedKeys.add(ダミーキー);
            }
            div.getKyotsuHyojiArea().getChkShinsakaiShurui().setSelectedItemsByKey(selectedKeys);
            div.getKyotsuHyojiArea().getTxtShinsakaiKaisaiYoteiYMD().setValue(head.get開催予定日());
        }
    }

    private void setTaishoshaIchiran(List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList) {
        List<dgTaishoshaIchiran_Row> dataSource = new ArrayList<>();
        for (ShinsakaiKekkaTorokuIChiRanBusiness business : iChiRanList) {
            RString 審査会順序 = new RString(business.get審査会順序());
            TextBoxFlexibleDate 認定申請日 = new TextBoxFlexibleDate();
            認定申請日.setValue(business.get認定申請日());
            TextBoxFlexibleDate 前回有効期間終了日 = new TextBoxFlexibleDate();
            前回有効期間終了日.setValue(business.get前回有効期間終了日());
            TextBoxFlexibleDate 二次判定日 = new TextBoxFlexibleDate();
            二次判定日.setValue(business.get二次判定日());
            TextBoxFlexibleDate 認定期間開始 = new TextBoxFlexibleDate();
            認定期間開始.setValue(business.get認定期間開始());
            TextBoxFlexibleDate 認定期間終了 = new TextBoxFlexibleDate();
            認定期間終了.setValue(business.get認定期間終了());
            RString 認定期間月数 = business.get認定期間月数();
            boolean メモフラグ = !RString.isNullOrEmpty(business.get審査会メモ());
            boolean 意見フラグ = !RString.isNullOrEmpty(business.get審査会意見());
            dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row(
                    RString.EMPTY,
                    審査会順序,
                    審査会順序.padZeroToLeft(4),
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
                    business.get今回二次判定(),
                    business.get二次判定コード(),
                    認定期間開始,
                    認定期間終了,
                    ZERO.equals(認定期間月数) ? RString.EMPTY : 認定期間月数,
                    二次判定日,
                    business.get取下区分名称(),
                    business.get取下区分コード(),
                    前回有効期間終了日,
                    business.get前回一次判定(),
                    business.get今回一次判定(),
                    business.get前回二次判定(),
                    business.get前回二次判定コード(),
                    business.get判定結果(),
                    business.get判定結果コード(),
                    business.get特定疾病(),
                    business.get状態像(),
                    business.get状態像コード(),
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
                    business.厚労省IF識別コード(),
                    business.get取下区分コード()
            );
            if (!row.getHanteiKekkaCode().isEmpty()) {
                row.setMd5(new TaishoshaIchiranRow(row).toMd5());
                row.setDeleteButtonState(DataGridButtonState.Enabled);
            } else {
                row.setDeleteButtonState(DataGridButtonState.Disabled);
            }
            dataSource.add(row);
        }
        div.getShinseishaIchiran().getDgTaishoshaIchiran().setDataSource(dataSource);
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param headList headList
     * @param iChiRanList iChiRanList
     * @param 申請書管理番号
     */
    public void initalize(
            List<ShinsakaiKekkaTorokuBusiness> headList,
            List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList,
            RString 申請書管理番号) {
        iChiRanList = select申請書管理番号(iChiRanList, 申請書管理番号);
        initalize(headList, iChiRanList);
        if (iChiRanList.size() == 1) {
            set個別表示欄入力可();
            this.displayTo個別表示欄(div.getDgTaishoshaIchiran().getDataSource().get(0), OperationMode.更新);
        }
        if (iChiRanList.isEmpty()) {
            set操作不可();
            display対象者無();
        }
    }

    /**
     * 個別エリアの値を設定します。
     *
     * @param row
     * @param mode
     */
    public void displayTo個別表示欄(dgTaishoshaIchiran_Row row, OperationMode mode) {
        reflectClickedRowTo個別事項表示欄(row);
        setInputable個別事項表示欄By(mode);
        if (mode != OperationMode.更新) {
            return;
        }
        boolean is認定 = row.getHanteiKekkaCode().equals(HanteiKekkaCode.認定.getコード());
        set個別入力制御変更By判定結果(is認定);
        if (!is認定) {
            clear個別表示欄今回入力内容判定結果以外();
        }
        div.setHdnHasChanged(toRString_個別事項表示欄());
    }

    private RString toRString_個別事項表示欄() {
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

    private void reflectClickedRowTo個別事項表示欄(dgTaishoshaIchiran_Row row) throws IllegalArgumentException {
        clear個別表示欄();
        div.getTxtHokenshaName().setValue(row.getHokenshaMeisho());
        div.getTxtHihokenshaNo().setValue(row.getHihokenshaNo());
        div.getTxtHihokenshaShimei().setValue(row.getShimei());
        div.getTxtHihoKubun().setValue(row.getHihoKubun());
        div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().setValue(row.getShinsakaiJunjo());
        div.getKobetsuHyojiArea().getTxtShinseiDay().setValue(row.getShinseiDay().getValue());
        div.getKobetsuHyojiArea().getTxtBirthYMD().setValue(new FlexibleDate(row.getSeiNenGaBi()));
        div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().setValue(row.getShinseiKubunShinseiji());
        div.getKobetsuHyojiArea().getTxtShinseiKubunLaw().setValue(row.getShinseiKubunLaw());
        div.getKobetsuHyojiArea().getTxtIchijiHantei().setValue(row.getIchijiHantei());
        if (!TorisageKubun.認定申請有効.get取下げ区分コード().value().equals(row.getTorisageKubunCode())) {
            div.getKobetsuHyojiArea().getTxtTorisageKubun().setValue(row.getTorisageKubunTx());
        }
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
    }

    private void setInputable個別事項表示欄By(OperationMode mode) {
        boolean disable = (mode == OperationMode.削除);
        div.getKobetsuHyojiArea().getBtnIchigoHantei().setDisabled(disable);
        div.getKobetsuHyojiArea().getBtnIchijiHanteiTeikeibunGuide().setDisabled(disable);
        div.getKobetsuHyojiArea().getBtnNinteiChosaJokyoShokai().setDisabled(disable);
        div.getKobetsuHyojiArea().getBtnShinsakaiMemoTeikeibunGuide().setDisabled(disable);
        div.getKobetsuHyojiArea().getBtnShinsakiIkenTeikeibunGuide().setDisabled(disable);
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setDisabled(disable);
        div.getKobetsuHyojiArea().getDdlJotaiZo().setDisabled(disable);
        div.getKobetsuHyojiArea().getDdlNijiHantei().setDisabled(disable);
        div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setDisabled(disable);
        div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setDisabled(disable);
        div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().setDisabled(disable);
        div.getKobetsuHyojiArea().getTxtNijiHanteiDay().setDisabled(disable);
        div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().setDisabled(disable);
        div.getKobetsuHyojiArea().getTxtNinteiKikanTo().setDisabled(disable);
        div.getKobetsuHyojiArea().getTxtShinsakaiIken().setDisabled(disable);
        div.getKobetsuHyojiArea().getTxtShinsakaiMemo().setDisabled(disable);
    }

    private void set個別入力制御変更By判定結果(boolean hyojiSeigyoFlag) {
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
        div.getKobetsuHyojiArea().getBtnIchigoHantei().setDisabled(!hyojiSeigyoFlag);

    }

    public RString calculateTorisageKubunCodeBy個別入力欄() {
        NinteiShinseiKubunShinsei 申請時申請区分 = get申請時申請区分();
        YokaigoJotaiKubun09 前回二次判定 = get前回二次判定();
        FlexibleDate 前回有効期間終了日 = get前回有効期間終了日();
        YokaigoJotaiKubun09 今回二次判定 = get今回二次判定();
        FlexibleDate 申請日 = div.getTxtShinseiDay().getValue();
        TorisageKubun k = TorisageKubun.toValue(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
        return k == null ? RString.EMPTY : k.get取下げ区分コード().value();
    }

    /**
     * 対象者一覧リストの値を設定します。
     *
     * @param mode {@link OperationMode}
     */
    public void set個別表示欄To更新中Row(OperationMode mode) {
        dgTaishoshaIchiran_Row row = find更新中RowOrNull();
        if (row == null) {
            return;
        }
        switch (mode) {
            case 更新:
                update更新対象Row(row);
                return;
            case 削除:
                delete更新対象Row(row);
                return;
            default:
        }
    }

    //<editor-fold defaultstate="collapsed" desc="_set個別表示欄To更新中Row">
    private dgTaishoshaIchiran_Row update更新対象Row(dgTaishoshaIchiran_Row row) {
        row.setDeleteButtonState(DataGridButtonState.Enabled);
        HanteiKekkaCode 判定結果 = get判定結果();
        if (判定結果 != null) {
            row.setHanteiKekka(判定結果.get名称());
            row.setHanteiKekkaCode(判定結果.getコード());
        } else {
            row.setHanteiKekka(RString.EMPTY);
            row.setHanteiKekkaCode(RString.EMPTY);
        }
        if (判定結果 == HanteiKekkaCode.認定) {
            NinteiShinseiKubunShinsei 申請時申請区分 = get申請時申請区分();
            YokaigoJotaiKubun09 前回二次判定 = get前回二次判定();
            FlexibleDate 前回有効期間終了日 = get前回有効期間終了日();
            YokaigoJotaiKubun09 今回二次判定 = get今回二次判定();
            FlexibleDate 申請日 = div.getTxtShinseiDay().getValue();
            NinteiShinseiKubunHorei 法令申請区分 = NinteiShinseiKubunHoreiCalculator.calculate(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
            if (法令申請区分 == null) {
                row.setShinseiKubunLaw(RString.EMPTY);
                row.setShinseiKubunLawCode(RString.EMPTY);
            } else {
                row.setShinseiKubunLaw(法令申請区分.getName());
                row.setShinseiKubunLawCode(new RString(法令申請区分.getコード()));
            }
            TorisageKubun 取下区分 = TorisageKubun.toValue(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
            if (取下区分 == null) {
                row.setTorisageKubunTx(RString.EMPTY);
                row.setTorisageKubunCode(RString.EMPTY);
            } else {
                row.setTorisageKubunTx(取下区分.getName());
                row.setTorisageKubunCode(取下区分.get取下げ区分コード().value());
            }
        } else {
            row.setShinseiKubunLaw(RString.EMPTY);
            row.setShinseiKubunLawCode(RString.EMPTY);
            RString code = row.getHenkoMaeTorisageKubunCode();
            TorisageKubun kubun = TorisageKubun.toValue(code);
            row.setTorisageKubunTx(kubun == null ? RString.EMPTY : kubun.getName());
            row.setTorisageKubunCode(code);
        }

        RDate 二次判定日 = div.getKobetsuHyojiArea().getTxtNijiHanteiDay().getValue();
        if (二次判定日 != null) {
            row.getNijiHanteiDate().setValue(new FlexibleDate(二次判定日.toDateString()));
        } else {
            row.getNijiHanteiDate().setValue(FlexibleDate.EMPTY);
        }
        RString 特定疾病 = div.getKobetsuHyojiArea().getTxtTokuteiShippei().getValue();
        if (!RString.isNullOrEmpty(特定疾病)) {
            row.setTokuteiShippei(特定疾病);
        } else {
            row.setTokuteiShippei(RString.EMPTY);
        }
        RString 状態像 = div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedValue();
        RString 状態像コード = div.getKobetsuHyojiArea().getDdlJotaiZo().getSelectedKey();
        if (!RString.isNullOrEmpty(状態像)) {
            row.setJotaizo(状態像);
            row.setJotaizoCode(状態像コード);
        } else {
            row.setJotaizo(RString.EMPTY);
            row.setJotaizoCode(RString.EMPTY);
        }

        RString 二次判定 = div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedValue();
        RString 二次判定コード = div.getKobetsuHyojiArea().getDdlNijiHantei().getSelectedKey();
        if (!RString.isNullOrEmpty(二次判定)) {
            row.setKonkaiNijiHantei(二次判定);
            row.setKonkaiNijiHanteiCode(二次判定コード);
        } else {
            row.setKonkaiNijiHantei(RString.EMPTY);
            row.setKonkaiNijiHanteiCode(RString.EMPTY);
        }
        RDate 認定期間開始日 = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        if (認定期間開始日 != null) {
            row.getNinteiKikanKaishi().setValue(
                    new FlexibleDate(認定期間開始日.toDateString()));
        } else {
            row.getNinteiKikanKaishi().setValue(FlexibleDate.EMPTY);
        }
        RDate 認定期間終了日 = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
        if (認定期間終了日 != null) {
            row.getNinteiKikanShuryo().setValue(new FlexibleDate(認定期間終了日.toDateString()));
        } else {
            row.getNinteiKikanShuryo().setValue(FlexibleDate.EMPTY);
        }
        RString 調定期間月数 = div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedValue();
        if (!RString.isNullOrEmpty(調定期間月数)) {
            row.setNinteiKikanTukisu(調定期間月数);
        } else {
            row.setNinteiKikanTukisu(RString.EMPTY);
        }
        RString 審査会意見種類 = div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().getSelectedValue();
        if (!RString.isNullOrEmpty(審査会意見種類)) {
            row.setShinsakaiIkenShurui(審査会意見種類);
        } else {
            row.setShinsakaiIkenShurui(RString.EMPTY);
        }
        RString 審査会メモ = div.getKobetsuHyojiArea().getTxtShinsakaiMemo().getValue();
        if (!RString.isNullOrEmpty(審査会メモ)) {
            row.setHidMemo(審査会メモ);
            row.setShinsakaiMemo(true);
        } else {
            row.setHidMemo(RString.EMPTY);
            row.setShinsakaiMemo(false);
        }
        RString 審査会意見 = div.getKobetsuHyojiArea().getTxtShinsakaiIken().getValue();
        if (!RString.isNullOrEmpty(審査会意見)) {
            row.setHidIken(審査会意見);
            row.setShinsakaiIken(true);
        } else {
            row.setHidIken(RString.EMPTY);
            row.setShinsakaiIken(false);
        }
        RString 審査会意見種類コード = div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().getSelectedKey();
        if (!RString.isNullOrEmpty(審査会意見種類コード)) {
            row.setHidIkenCode(審査会意見種類コード);
        } else {
            row.setHidIkenCode(RString.EMPTY);
        }
        RString 一次判定結果変更理由 = div.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu().getValue();
        if (!RString.isNullOrEmpty(一次判定結果変更理由)) {
            row.setIchijiHanteiKekkaHenkoRiyu(一次判定結果変更理由);
        } else {
            row.setIchijiHanteiKekkaHenkoRiyu(RString.EMPTY);
        }

        if (row.getMd5().isEmpty()) {
            row.setJotai(KaigoRowState.追加.getStateName());
            return row;
        }
        RString newMd5 = new TaishoshaIchiranRow(row).toMd5();
        if (Objects.equals(newMd5, row.getMd5())) {
            row.setJotai(KaigoRowState.空白.getStateName());
            return row;
        }
        row.setJotai(KaigoRowState.修正.getStateName());
        return row;
    }

    private dgTaishoshaIchiran_Row delete更新対象Row(dgTaishoshaIchiran_Row row) {
        row.setDeleteButtonState(DataGridButtonState.Disabled);
        if (row.getMd5().isEmpty()) {
            row.setJotai(KaigoRowState.空白.getStateName());
        } else {
            row.setJotai(KaigoRowState.削除.getStateName());
        }
        return row;
    }
    //</editor-fold>

    /**
     * 個別表示欄を入力可にします。
     */
    public void set個別表示欄入力可() {
        div.getKobetsuHyojiArea().setReadOnly(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタンID, true);
        div.getDgTaishoshaIchiran().setReadOnly(true);
    }

    /**
     * 個別表示欄を入力不可にします。
     *
     */
    public void set個別表示欄入力不可() {
        div.getKobetsuHyojiArea().setReadOnly(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタンID, false);
        div.getDgTaishoshaIchiran().setReadOnly(false);
    }

    //<editor-fold defaultstate="collapsed" desc="表示内容のクリア">
    /**
     * 個別エリアの値をクリアします。
     *
     */
    public void clear個別表示欄() {
        clear個別表示欄今回入力外内容();
        clear個別表示欄今回入力内容();
    }

    /**
     * 個別エリアの今回入力外内容の値をクリアします。
     */
    private void clear個別表示欄今回入力外内容() {
        div.getKobetsuHyojiArea().getTxtShinsakaiJunjo().clearValue();
        div.getTxtHokenshaName().clearValue();
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtHihokenshaShimei().clearValue();
        div.getTxtHihoKubun().clearValue();
        div.getKobetsuHyojiArea().getTxtShinseiDay().clearValue();
        div.getKobetsuHyojiArea().getTxtBirthYMD().clearValue();
        div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().clearValue();
        div.getKobetsuHyojiArea().getTxtIchijiHantei().clearValue();
        div.getKobetsuHyojiArea().getTxtTokuteiShippei().clearValue();
    }

    /**
     * 個別エリアの今回入力内容の値をクリアします。
     *
     */
    private void clear個別表示欄今回入力内容() {
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(RString.EMPTY);
        clear個別表示欄今回入力内容判定結果以外();
    }

    /**
     * 個別エリアの今回入力内容で判定結果以外の値をクリアします。
     */
    private void clear個別表示欄今回入力内容判定結果以外() {
        div.getKobetsuHyojiArea().getTxtShinseiKubunLaw().clearValue();
        div.getKobetsuHyojiArea().getTxtTorisageKubun().clearValue();
        div.getKobetsuHyojiArea().getTxtNijiHanteiDay().clearValue();
        div.getKobetsuHyojiArea().getDdlJotaiZo().setSelectedKey(RString.EMPTY);
        div.getKobetsuHyojiArea().getDdlNijiHantei().setSelectedKey(YokaigoJotaiKubun09.なし.getコード());
        div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().clearValue();
        div.getKobetsuHyojiArea().getTxtNinteiKikanTo().clearValue();
        div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setSelectedKey(new RString(認定期間月数なし));
        div.getKobetsuHyojiArea().getTxtShinsakaiMemo().clearValue();
        div.getKobetsuHyojiArea().getTxtShinsakaiIken().clearValue();
        div.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui().setSelectedKey(RString.EMPTY);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ドロップダウンリストの初期化">
    private void set状態像コードドロップダウン() {
        List<KeyValueDataSource> 状態像コードリスト = new ArrayList();
        for (YokaigoJotaizoReiCode v : YokaigoJotaizoReiCode.values()) {
            状態像コードリスト.add(new KeyValueDataSource(v.getコード(), v.get名称()));
        }
        div.getKobetsuHyojiArea().getDdlJotaiZo().setDataSource(状態像コードリスト);
    }

    private void set判定結果ドロップダウン() {
        List<KeyValueDataSource> 判定結果リスト = new ArrayList();
        for (HanteiKekkaCode v : HanteiKekkaCode.values()) {
            判定結果リスト.add(new KeyValueDataSource(v.getコード(), v.get名称()));
        }
        div.getKobetsuHyojiArea().getDdlHanteiKekka().setDataSource(判定結果リスト);
    }

    private void set二次判定ドロップダウン() {
        List<KeyValueDataSource> 二次判定リスト = new ArrayList();
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.なし.getコード(), RString.EMPTY));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要支援1.getコード(), YokaigoJotaiKubun09.要支援1.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要支援2.getコード(), YokaigoJotaiKubun09.要支援2.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護1.getコード(), YokaigoJotaiKubun09.要介護1.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護2.getコード(), YokaigoJotaiKubun09.要介護2.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護3.getコード(), YokaigoJotaiKubun09.要介護3.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護4.getコード(), YokaigoJotaiKubun09.要介護4.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.要介護5.getコード(), YokaigoJotaiKubun09.要介護5.get名称()));
        二次判定リスト.add(new KeyValueDataSource(YokaigoJotaiKubun09.非該当.getコード(), YokaigoJotaiKubun09.非該当.get名称()));
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
    //</editor-fold>

    /**
     * 「判定結果」ドロップダウンリストの選択変更の場合、対応項目の表示制御を設定します。
     *
     */
    public void set個別入力制御変更from判定結果() {
        boolean is認定 = (get判定結果() == HanteiKekkaCode.認定);
        set個別入力制御変更By判定結果(is認定);
        if (!is認定 || is判定結果変更前入力不可()) {
            clear個別表示欄今回入力内容判定結果以外();
        }
        if (is認定 || !is判定結果変更前入力不可()) {
            reflectClickedRowTo個別事項表示欄(find更新中RowOrNull());
            // 一度クリアされるので再設定する。
            div.getKobetsuHyojiArea().getDdlHanteiKekka().setSelectedKey(HanteiKekkaCode.認定.getコード());
            if (div.getTxtNijiHanteiDay().getValue() == null) {
                RDate rData = new RDate(div.getTxtKaisaiNichiji().getValue().seireki().toDateString().toString());
                div.getTxtNijiHanteiDay().setValue(rData);
            }
            set状態像Disabled(get今回二次判定() != YokaigoJotaiKubun09.要介護1);
        }
    }

    private boolean is判定結果変更前入力不可() {
        return div.getKobetsuHyojiArea().getTxtNijiHanteiDay().isReadOnly();
    }

    /**
     * 認定期間開始日を算出、設定します。
     */
    public void set認定期間開始日() {
        RDate 認定期間開始日 = calculate認定期間開始日();
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
        RDate 認定期間開始日 = get認定期間開始日();
        int 認定期間月数 = get認定期間月数();

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
    public void set認定期間月数from認定期間() {
        RDate 認定期間From = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        RDate 認定期間To = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
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
     * 申請内容から認定期間月数を算出し、これを設定します。
     */
    public void set認定期間月数from申請内容() {
        NinteiShinseiKubunShinsei 申請時申請区分 = get申請時申請区分();
        div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().setSelectedKey(new RString(calculate認定期間月数(申請時申請区分)));
    }

    /**
     * 申請区分、判定結果から開始基準日を算出します。
     *
     * @return 算出基準日
     */
    RDate calculate算出基準日() {
        NinteiShinseiKubunShinsei 申請時申請区分 = get申請時申請区分();
        FlexibleDate 申請日 = div.getKobetsuHyojiArea().getTxtShinseiDay().getValue();
        if (申請時申請区分 == null || 申請日 == null) {
            return null;
        }
        dgTaishoshaIchiran_Row 更新対象row = find更新中RowOrNull();
        RDate nijiHanteiDate = div.getKobetsuHyojiArea().getTxtNijiHanteiDay().getValue();
        FlexibleDate 二次判定日 = (nijiHanteiDate == null) ? null : new FlexibleDate(nijiHanteiDate.toDateString());
        FlexibleDate 前回有効期間終了日 = 更新対象row.getZenkaiYukoKikanShuryoDay().getValue();
        YokaigoJotaiKubun09 前回二次判定 = get前回二次判定();
        YokaigoJotaiKubun09 今回二次判定 = get今回二次判定();
        if (申請時申請区分 == NinteiShinseiKubunShinsei.新規申請) {
            return get当日(申請日);
        }

        if (申請時申請区分 == NinteiShinseiKubunShinsei.更新申請) {
            if (前回有効期間終了日 == null || 前回有効期間終了日.isEmpty()) {
                return get当日(申請日);
            }
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
            if (前回有効期間終了日 == null || 前回有効期間終了日.isEmpty()) {
                return get当日(申請日);
            }
            return get翌日(前回有効期間終了日);
        }
        return null;
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
     * 判定結果を返します。個別入力時用です。
     *
     * @return 法令申請区分
     */
    public HanteiKekkaCode get判定結果() {
        RString key = div.getKobetsuHyojiArea().getDdlHanteiKekka().getSelectedKey();
        return RString.isNullOrEmpty(key) ? null : HanteiKekkaCode.toValue(key);
    }

    /**
     * 申請時申請区分を返します。個別入力時用です。
     *
     * @return 法令申請区分
     */
    public NinteiShinseiKubunShinsei get申請時申請区分() {
        dgTaishoshaIchiran_Row 更新対象row = find更新中RowOrNull();
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
        dgTaishoshaIchiran_Row 更新対象row = find更新中RowOrNull();
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
        dgTaishoshaIchiran_Row 更新対象row = find更新中RowOrNull();
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
        dgTaishoshaIchiran_Row row = find更新中RowOrNull();
        if (row == null) {
            return null;
        }
        return row.getShinseishoKanriNo();
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
    public void set認定期間Disabled(boolean isDisabled) {
        div.getTxtNinteiKikanFrom().setDisabled(isDisabled);
        div.getTxtNinteiKikanTo().setDisabled(isDisabled);
    }

    /**
     * 個別欄の状態像のコントロール制御を設定します。
     *
     * @param isDisabled {@code true}のとき非活性
     */
    public void set状態像Disabled(boolean isDisabled) {
        if (isDisabled) {
            div.getDdlJotaiZo().setSelectedKey(RString.EMPTY);
        }
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
    public dgTaishoshaIchiran_Row find更新中RowOrNull() {
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
        dgTaishoshaIchiran_Row row = find更新中RowOrNull();
        if (row.getZenkaiYukoKikanShuryoDay().getValue() == null
                || row.getZenkaiYukoKikanShuryoDay().getValue().isEmpty()) {
            return new FlexibleDate(RString.EMPTY);
        }
        return row.getZenkaiYukoKikanShuryoDay().getValue();
    }

    /**
     * 認定期間開始日を返します。個別入力時用です。
     *
     * @return 認定期間開始日
     */
    public RDate get認定期間開始日() {
        return div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
    }

    /**
     * 認定期間終了日を返します。個別入力時用です。
     *
     * @return 認定期間終了日
     */
    public RDate get認定期間終了日() {
        return div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
    }

    /**
     * 認定期間月数を返します。個別入力時用です。
     *
     * @return 認定期間月数
     */
    public int get認定期間月数() {
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

    public static boolean is要支援要介護(YokaigoJotaiKubun09 判定内容) {
        return !(判定内容 == YokaigoJotaiKubun09.なし
                || 判定内容 == YokaigoJotaiKubun09.再調査
                || 判定内容 == YokaigoJotaiKubun09.取消
                || 判定内容 == YokaigoJotaiKubun09.非該当);
    }

    private static RDate get翌日(FlexibleDate 基準日) {
        return new RDate(基準日.plusDay(1).seireki().toDateString().toString());
    }

    private static RDate get当日(FlexibleDate 基準日) {
        try {
            return new RDate(基準日.seireki().toDateString().toString());
        } catch (Exception e) {
            throw new ApplicationException(基準日.seireki().toDateString().toString());
        }
    }

    private static int calculate認定期間月数(NinteiShinseiKubunShinsei 申請時申請区分) {
        if (申請時申請区分 == null) {
            return Integer.parseInt(getConfig新規申請有効期間().toString());
        }
        RString 認定期間月数文字列
                = (申請時申請区分 == NinteiShinseiKubunShinsei.更新申請) ? getConfig更新申請有効期間()
                        : (申請時申請区分 == NinteiShinseiKubunShinsei.新規申請) ? getConfig新規申請有効期間()
                                : (申請時申請区分 == NinteiShinseiKubunShinsei.区分変更申請) ? getConfig区分変更申請有効期間()
                                        : getConfig新規申請有効期間();
        int 認定期間月数 = Integer.parseInt(認定期間月数文字列.toString());
        return 認定期間月数;
    }

    /**
     * 一切の入力処理が行えないようにします。
     */
    public void set操作不可() {
        div.setReadOnly(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタンID, true);
    }

    /**
     * 対象者が存在しないことを表示します。
     */
    private void display対象者無() {
        div.getTaishoshaNashi().setDisplayNone(false);
    }

    private static List<ShinsakaiKekkaTorokuIChiRanBusiness> select申請書管理番号(
            List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList,
            RString 申請書管理番号) {
        List<ShinsakaiKekkaTorokuIChiRanBusiness> result = new ArrayList<>();
        for (ShinsakaiKekkaTorokuIChiRanBusiness biz : iChiRanList) {
            if (biz.get申請書管理番号().equals(申請書管理番号)) {
                result.add(biz);
            }
        }
        return result;
    }
}
