/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1180011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyugakuKeisanKekkaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShikyuGakuKeisanKekkaRelate;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_HokenSeido;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.ShikyugakuKeisanKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.dgKogakuGassanShikyuGakuKeisanKekka_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算支給額計算結果登録のHandlerです。
 *
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaTorokuHandler {

    private final ShikyugakuKeisanKekkaTorokuDiv div;
    private static final RString 空白 = new RString("-");
    private static final RString 所得区分_課税 = new RString("0");
    private static final RString 所得区分_非課税 = new RString("4");
    private static final RString 課税 = new RString("課税");
    private static final RString 非課税 = new RString("非課税");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_8 = 8;
    private static final int INT_11 = 11;
    private static final int 年度_2008 = 2008;
    private static final int 年度_2013 = 2013;
    private static final int 年度_2014 = 2014;
    private static final int 年度_2015 = 2015;
    private static final RString DATE_0401 = new RString("0401");
    private static final RString DATE_0731 = new RString("0731");
    private static final RString DATE_0801 = new RString("0801");
    private static final RString 追加 = new RString("追加");
    private static final RString 郵便番号MAX = new RString("9999999");
    private static final RString 仮データ = new RString("仮データ");
    private static final RString RSTRING_ZERO = new RString("0");
    private static final RString RSTRING_ONE = new RString("1");
    private static final RString RSTRING_TWO = new RString("2");
    private static final RString RSTRING_THREE = new RString("3");
    private static final RString 国保連作成 = new RString("国保連作成");
    private static final RString 保険者作成 = new RString("保険者作成");
    private static final RString 新規 = new RString("新規");
    private static final RString KEY_0 = new RString("key0");
    private static final RString 按分率 = new RString("99999999/99999999");
    private static final RString スラッシュ = new RString("/");
    private static final RString 横線 = new RString("-");

    /**
     * コンストラクタです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     */
    public ShikyugakuKeisanKekkaTorokuHandler(ShikyugakuKeisanKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッドです。
     *
     * @param 対象者 TaishoshaKey
     */
    public void initialize(TaishoshaKey 対象者) {
        div.getDgKogakuGassanShikyuGakuKeisanKekka().setDataSource(Collections.EMPTY_LIST);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().setDataSource(Collections.EMPTY_LIST);
        div.getCcdKaigoAtenaInfo().initialize(対象者.get識別コード());
        div.getCcdKaigoShikakuKihon().initialize(対象者.get被保険者番号());
        RDate システム日付 = RDate.getNowDate();
        int システム年度 = システム日付.getNendo().getYearValue();
        int システム月 = システム日付.getMonthValue();
        if (INT_8 - システム月 <= INT_0) {
            div.getTxtKensakuTaishoNendo().setFromValue(new RDate(システム年度 - INT_1));
            div.getTxtKensakuTaishoNendo().setToValue(new RDate(システム年度 - INT_1));
        } else {
            div.getTxtKensakuTaishoNendo().setFromValue(new RDate(システム年度 - INT_2));
            div.getTxtKensakuTaishoNendo().setToValue(new RDate(システム年度 - INT_2));
        }
        ドロップダウンリスト項目セット();
    }

    /**
     * set照会制御。
     */
    public void set照会制御() {
        div.getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(true);
        div.getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(true);
        div.getTxtKensakuTaishoNendo().setDisabled(true);
        div.getChkRirekiHyoji().setDisabled(true);
        div.getTxtShikyuShinseishoSeiriNoInput().setDisabled(true);
        div.getBtnAddKeisanKekka().setDisabled(true);
        div.getBtnKensaku().setDisabled(true);
    }

    /**
     * 検索結果グリッドにセットのメソッドです。
     *
     * @param resultList List<KogakuGassanShikyuGakuKeisanKekkaResult>
     */
    public void setRow(List<KogakuGassanShikyuGakuKeisanKekkaRelate> resultList) {
        List<dgKogakuGassanShikyuGakuKeisanKekka_Row> rowList = new ArrayList();
        for (KogakuGassanShikyuGakuKeisanKekkaRelate result : resultList) {
            dgKogakuGassanShikyuGakuKeisanKekka_Row row = new dgKogakuGassanShikyuGakuKeisanKekka_Row();
            if (EntityDataState.Added.equals(result.toEntity().getState())) {
                row.setRowState(RowState.Added);
            } else if (EntityDataState.Modified.equals(result.toEntity().getState())) {
                row.setRowState(RowState.Modified);
            } else if (EntityDataState.Deleted.equals(result.toEntity().getState())) {
                row.setRowState(RowState.Deleted);
            }
            if (result.toEntity().getIsDeleted() || !RSTRING_TWO.equals(result.getデータ区分())) {
                row.setSelectButtonState(DataGridButtonState.Enabled);
                row.setModifyButtonState(DataGridButtonState.Disabled);
                row.setDeleteButtonState(DataGridButtonState.Disabled);
            } else {
                row.setSelectButtonState(DataGridButtonState.Disabled);
                row.setModifyButtonState(DataGridButtonState.Enabled);
                row.setDeleteButtonState(DataGridButtonState.Enabled);
            }
            row.getTxtTaishoNendo().setValue(new RDate(result.get対象年度().getYearValue()));
            row.setTxtSanteiKubun(result.get支給額計算結果連絡先郵便番号() != null && 郵便番号MAX.equals(
                    result.get支給額計算結果連絡先郵便番号().getYubinNo()) ? 仮データ : RString.EMPTY);
            row.setTxtShikyuShinseishoSeiriNo(result.get支給申請書整理番号());
            row.setTxtJikoFutanSeiriNo(result.get自己負担額証明書整理番号());
            row.setTxtDataShurui(セットデータ区分(result.getデータ区分()));
            row.setTxtUketoriYM(result.get受取年月() == null || RString.isNullOrEmpty(result.get受取年月().toDateString()) ? null
                    : DateConverter.toWarekiHalf_Zero(new RYearMonth(result.get受取年月().toDateString())));
            row.setTxtSofuYM(result.get送付年月() == null || RString.isNullOrEmpty(result.get送付年月().toDateString()) ? null
                    : DateConverter.toWarekiHalf_Zero(new RYearMonth(result.get送付年月().toDateString())));
            row.setChkisDeleted(result.toEntity().getIsDeleted());
            row.setTxtHihokenshaNo(result.get被保険者番号().getColumnValue());
            row.setTxtShoKisaiHokenshaNo(result.get証記載保険者番号().getColumnValue());
            row.setTxtRirekiNo(new RString(result.get履歴番号()));
            rowList.add(row);
        }
        div.getDgKogakuGassanShikyuGakuKeisanKekka().setDataSource(rowList);
    }

    /**
     * 支給額結果明細グリッドセットのメソッドです。
     *
     * @param meisaiList List<KogakuGassanShikyugakuKeisanKekkaMeisai>
     */
    public void 支給額結果明細グリッド(List<KogakuGassanShikyugakuKeisanKekkaMeisai> meisaiList) {
        if (meisaiList == null) {
            div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().setDataSource(Collections.EMPTY_LIST);
            return;
        }
        List<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> rowList = new ArrayList();
        for (KogakuGassanShikyugakuKeisanKekkaMeisai item : meisaiList) {
            dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row row = new dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row();
            if (EntityDataState.Added.equals(item.toEntity().getState())) {
                row.setRowState(RowState.Added);
            } else if (EntityDataState.Modified.equals(item.toEntity().getState())) {
                row.setRowState(RowState.Modified);
            } else if (EntityDataState.Deleted.equals(item.toEntity().getState())) {
                row.setRowState(RowState.Deleted);
                row.setModifyButtonState(DataGridButtonState.Disabled);
                row.setDeleteButtonState(DataGridButtonState.Disabled);
            }
            if (item.get保険制度コード() != null && !item.get保険制度コード().isEmpty()) {
                row.setTxtHokenSeido(KaigoGassan_HokenSeido.toValue(item.get保険制度コード()).get名称());
            }
            row.setTxtUchiwakeHokenshaMei(item.get内訳保険者名());
            row.setTxtJikoFutanSeiriNo(item.get自己負担額証明書整理番号());
            row.setTxtTaishoshaShimei(item.get対象者氏名_漢字());
            row.setTxtUchiwakeHokenshaNo(item.get証記載保険者番号().getColumnValue());
            row.setTxtKokuhoHihokenshaShoKigo(item.get国保被保険者証記号());
            row.setTxtHiHokenshaShoNo(item.get被保険者_証番号());
            row.getTxtOver70Futangaku().setValue(item.get70歳以上負担額() == null ? Decimal.ZERO : new Decimal(item.get70歳以上負担額().toString()));
            row.setTxtOver70AmbunRitsu(item.get70歳以上按分率());
            row.getTxtOver70Shikyugaku().setValue(item.get70歳以上支給額() == null ? Decimal.ZERO : new Decimal(item.get70歳以上支給額().toString()));
            row.getTxtUnder70Futangaku().setValue(item.get70歳未満負担額() == null ? Decimal.ZERO : new Decimal(item.get70歳未満負担額().toString()));
            row.getTxtFutangaku().setValue(item.get負担額() == null ? Decimal.ZERO : new Decimal(item.get負担額().toString()));
            row.setTxtAmbunRitsu(item.get按分率());
            row.getTxtUnder70Shikyugaku().setValue(item.get70歳未満支給額() == null ? Decimal.ZERO : new Decimal(item.get70歳未満支給額().toString()));
            row.getTxtShikyugaku().setValue(item.get支給額() == null ? Decimal.ZERO : new Decimal(item.get支給額().toString()));
            row.setTxtHihokenshaNo(item.get被保険者番号().getColumnValue());
            row.setTxtMeisanNo(item.get明細番号());
            row.setTxtRirekiNo(new RString(item.get履歴番号().intValue()));
            row.setTxtShikyuShinseishoSeiriNo(item.get支給申請書整理番号());
            row.setTxtTaishoNendo(item.get対象年度().toDateString());
            rowList.add(row);
        }
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().setDataSource(rowList);
    }

    /**
     * 「計算結果を追加する」ボタンのメソッドです。
     */
    public void onClick_btnKeisanKekka() {
        画面項目クリア();
        div.getTxtStatusFlg().setValue(新規);
        div.getChkSaiso().setSelectedItemsByKey(Collections.EMPTY_LIST);
        連絡票整理番号項目をセット();
        年度から計算期間を算出();
        設定所得区分DDL();
    }

    /**
     * 照会状態のメソッドです。
     *
     * @param flg boolean
     */
    public void 照会状態設定(boolean flg) {
        div.getBtnUchiwakeAdd().setDisabled(flg);
        div.getDdlHokenSeido().setReadOnly(flg);
        div.getTxtShoKisaiHokenshaNo().setReadOnly(flg);
        div.getTxtHokenshaMei().setReadOnly(flg);
        div.getTxtKokuhoHihokenshaShoKigo().setReadOnly(flg);
        div.getTxtTaishoshaShimei().setReadOnly(flg);
        div.getTxtHiHokenshaShoNo().setReadOnly(flg);
        div.getTxtJikoFutanSeiriNom().setReadOnly(flg);
        div.getTxtOver70Futangaku().setReadOnly(flg);
        div.getTxtOver70Shikyugaku().setReadOnly(flg);
        div.getTxtUnder70Futangaku().setReadOnly(flg);
        div.getTxtUnder70Shikyugaku().setReadOnly(flg);
        div.getTxtOver70Biko().setReadOnly(flg);
        div.getTxtUnder70Biko().setReadOnly(flg);
        div.getBtnUchiwakeKakutei().setDisabled(flg);
        div.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setDisabled(flg);
        div.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setDisabled(flg);

        div.getDdlHokenSeido().setRequired(!flg);
        div.getTxtShoKisaiHokenshaNo().setRequired(!flg);
        div.getTxtHokenshaMei().setRequired(!flg);
        div.getTxtTaishoshaShimei().setRequired(!flg);
        div.getTxtHiHokenshaShoNo().setRequired(!flg);
        div.getTxtTaishoKeisanKikan().setToRequired(!flg);
        div.getTxtHonninShikyugaku().setRequired(!flg);
        div.getTxtTsuchiYMD().setRequired(!flg);
        div.getTxtRenrakuhyoHakkoshaMei().setRequired(!flg);
        div.getTxtRenrakuhyoHakkoshaYubinNo().setRequired(!flg);
        div.getTxtRenrakuhyoHakkoshaJusho().setRequired(!flg);
        div.getTxtToiawasesakiMeisho1().setRequired(!flg);
        div.getTxtToiawasesakiYobinNo().setRequired(!flg);
        div.getTxtToiawasesakiTelNo().setRequired(!flg);
        div.getTxtToiawasesakiJusho().setRequired(!flg);
    }

    /**
     * 画面項目クリアのメソッドです。
     */
    public void 画面項目クリア() {
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().setDataSource(Collections.EMPTY_LIST);
        支給額計算結果登録入力パネルクリア();
        計算内訳情報パネルクリア();
        支給額情報パネルクリア();
        連絡票情報パネルクリア();
    }

    /**
     * 支給額結果グリッド「選択」ボタンのメソッドです。
     *
     * @param 支給額計算結果 KogakuGassanShikyuGakuKeisanKekkaResult
     */
    public void onClick_dgShikyuGakuKeisanKekkaSelect(KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果) {
        画面項目クリア();
        支給額計算結果画面項目設定(支給額計算結果);
    }

    /**
     * 「内訳を追加する」ボタンのメソッドです。
     */
    public void onClick_btnUchiwakeAdd() {
        div.getShikyugakuKeisanKekkaTorokuUchiwakeList().setDisplayNone(true);
        div.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setDisplayNone(false);
        int 年度 = div.getTxtTaishoNendo().getValue().getNendo().getYearValue();
        if (年度_2008 == 年度) {
            div.getTxtOver70Biko().setVisible(true);
            div.getTxtUnder70Biko().setVisible(true);
        } else {
            div.getTxtOver70Biko().setVisible(false);
            div.getTxtUnder70Biko().setVisible(false);
        }
        内訳入力パネルクリア();
        明細照会状態設定(false);
    }

    /**
     * 支給結果明細グリッド「選択」ボタンのメソッドです。
     *
     * @param 支給額計算結果明細 KogakuGassanShikyugakuKeisanKekkaMeisai
     */
    public void onClick_dgShikyugakuKeisanKekkaMeisaiSelect(KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細) {
        onClick_btnUchiwakeAdd();
        内訳入力パネルデータ設定(支給額計算結果明細);
        明細照会状態設定(true);
    }

    /**
     * 支給結果明細グリッド「修正」ボタンのメソッドです。
     *
     * @param 支給額計算結果明細 KogakuGassanShikyugakuKeisanKekkaMeisai
     */
    public void onClick_dgShikyugakuKeisanKekkaMeisaiModify(KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細) {
        onClick_btnUchiwakeAdd();
        内訳入力パネルデータ設定(支給額計算結果明細);
        明細照会状態設定(false);
    }

    /**
     * 支給結果明細グリッド「削除」ボタンのメソッドです。
     *
     * @param 支給額計算結果明細 KogakuGassanShikyugakuKeisanKekkaMeisai
     */
    public void onClick_dgShikyugakuKeisanKekkaMeisaiDelete(KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細) {
        onClick_btnUchiwakeAdd();
        内訳入力パネルデータ設定(支給額計算結果明細);
        明細照会状態設定(true);
        div.getBtnUchiwakeKakutei().setDisabled(false);
    }

    private void 明細照会状態設定(boolean flg) {
        div.getDdlHokenSeido().setReadOnly(flg);
        div.getTxtShoKisaiHokenshaNo().setReadOnly(flg);
        div.getTxtHokenshaMei().setReadOnly(flg);
        div.getTxtKokuhoHihokenshaShoKigo().setReadOnly(flg);
        div.getTxtTaishoshaShimei().setReadOnly(flg);
        div.getTxtHiHokenshaShoNo().setReadOnly(flg);
        div.getTxtJikoFutanSeiriNom().setReadOnly(flg);
        div.getTxtOver70Futangaku().setReadOnly(flg);
        div.getTxtOver70Shikyugaku().setReadOnly(flg);
        div.getTxtUnder70Futangaku().setReadOnly(flg);
        div.getTxtUnder70Shikyugaku().setReadOnly(flg);
        div.getTxtOver70Biko().setReadOnly(flg);
        div.getTxtUnder70Biko().setReadOnly(flg);
        div.getBtnUchiwakeKakutei().setDisabled(flg);
    }

    /**
     * [対象計算期間終了年月日]変更時のメソッドです。
     */
    public void onChange_txtTaishoKeisanKikan() {
        設定所得区分DDL();
        div.getDdlShotokuKubun().setSelectedIndex(INT_0);
    }

    /**
     * 再計算処理のメソッドです。
     *
     * @param 状態 RString
     */
    public void 再計算処理(RString 状態) {
        処理1();
        処理2();
        按分率計算処理(状態);
    }

    /**
     * 「内訳一覧に戻る」ボタンのメソッドです。
     */
    public void onClick_btnUchiwakeIchiramModoru() {
        div.getShikyugakuKeisanKekkaTorokuUchiwakeList().setDisplayNone(false);
        div.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setDisplayNone(true);
        内訳入力パネルクリア();
    }

    /**
     * 支給額計算結果明細編集のメソッドです。
     *
     * @param 支給額計算結果明細 KogakuGassanShikyugakuKeisanKekkaMeisai
     * @param 対象者 TaishoshaKey
     * @return KogakuGassanShikyugakuKeisanKekkaMeisai
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細編集(
            KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細, TaishoshaKey 対象者) {
        if (支給額計算結果明細 == null) {
            HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
            FlexibleYear 対象年度 = new FlexibleYear(div.getTxtTaishoNendo().getValue().getYear().toDateString());
            HokenshaNo 証記載保険者番号 = new HokenshaNo(div.getTxtShoKisaiHokenshaNoa().getValue());
            RString 支給申請書整理番号 = div.getTxtShikyuShinseishoSeiriNo().getValue();
            int 明細番号Max = div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getDataSource().size();
            RString 明細番号 = new RString(明細番号Max + INT_1);
            Decimal 履歴番号 = Decimal.ONE;
            支給額計算結果明細 = new KogakuGassanShikyugakuKeisanKekkaMeisai(
                    被保険者番号,
                    対象年度,
                    証記載保険者番号,
                    支給申請書整理番号,
                    明細番号,
                    履歴番号
            );
        }
        return 支給額計算結果明細.createBuilderForEdit()
                .set保険制度コード(div.getDdlHokenSeido().getSelectedKey())
                .set内訳保険者番号(div.getTxtShoKisaiHokenshaNo().getValue())
                .set国保被保険者証記号(div.getTxtKokuhoHihokenshaShoKigo().getValue())
                .set被保険者_証番号(div.getTxtHiHokenshaShoNo().getValue())
                .set内訳保険者名(div.getTxtHokenshaMei().getValue())
                .set自己負担額証明書整理番号(div.getTxtJikoFutanSeiriNom().getValue())
                .set対象者氏名_漢字(div.getTxtTaishoshaShimei().getValue())
                .set70歳以上負担額(div.getTxtOver70Futangaku().getValue() == null ? RSTRING_ZERO
                        : new RString(div.getTxtOver70Futangaku().getValue().toString()))
                .set70歳以上按分率(横線.equals(div.getTxtOver70AmbunRitsu().getValue()) ? 按分率
                        : div.getTxtOver70AmbunRitsu().getValue())
                .set70歳以上支給額(div.getTxtOver70Shikyugaku().getValue() == null ? RSTRING_ZERO
                        : new RString(div.getTxtOver70Shikyugaku().getValue().toString()))
                .set70歳未満負担額(div.getTxtUnder70Futangaku().getValue() == null ? RSTRING_ZERO
                        : new RString(div.getTxtUnder70Futangaku().getValue().toString()))
                .set負担額(div.getTxtFutangaku().getValue() == null ? RSTRING_ZERO
                        : new RString(div.getTxtFutangaku().getValue().toString()))
                .set按分率(横線.equals(div.getTxtAmbunRitsu().getValue()) ? 按分率
                        : div.getTxtAmbunRitsu().getValue())
                .set70歳未満支給額(div.getTxtUnder70Shikyugaku().getValue() == null ? RSTRING_ZERO
                        : new RString(div.getTxtUnder70Shikyugaku().getValue().toString()))
                .set支給額(div.getTxtShikyuGaku().getValue() == null ? RSTRING_ZERO
                        : new RString(div.getTxtShikyuGaku().getValue().toString()))
                .set備考欄記載70歳以上負担額(div.getTxtOver70Biko().getValue() == null ? RSTRING_ZERO
                        : new RString(div.getTxtOver70Biko().getValue().toString()))
                .set備考欄記載70歳未満負担額(div.getTxtUnder70Biko().getValue() == null ? RSTRING_ZERO
                        : new RString(div.getTxtUnder70Biko().getValue().toString()))
                .setデータ区分(RSTRING_TWO)
                .build();
    }

    /**
     * 内訳合計額計算処理のメソッドです。
     */
    public void 内訳合計額計算処理() {
        Decimal 内訳WK1 = Decimal.ZERO;
        Decimal 内訳WK3 = Decimal.ZERO;
        Decimal 内訳WK4 = Decimal.ZERO;
        Decimal 内訳WK5 = Decimal.ZERO;
        Decimal 内訳WK7 = Decimal.ZERO;
        Decimal 内訳WK8 = Decimal.ZERO;
        List<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> rowList = div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getDataSource();
        for (dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row row : rowList) {
            if (!RowState.Deleted.equals(row.getRowState())) {
                内訳WK1 = 内訳WK1.add(RString.isNullOrEmpty(row.getTxtOver70Futangaku().getText())
                        ? Decimal.ZERO : new Decimal(row.getTxtOver70Futangaku().getValue().toString()));
                内訳WK3 = 内訳WK3.add(RString.isNullOrEmpty(row.getTxtOver70Shikyugaku().getText())
                        ? Decimal.ZERO : new Decimal(row.getTxtOver70Shikyugaku().getValue().toString()));
                内訳WK4 = 内訳WK4.add(RString.isNullOrEmpty(row.getTxtUnder70Futangaku().getText())
                        ? Decimal.ZERO : new Decimal(row.getTxtUnder70Futangaku().getValue().toString()));
                内訳WK5 = 内訳WK5.add(RString.isNullOrEmpty(row.getTxtFutangaku().getText())
                        ? Decimal.ZERO : new Decimal(row.getTxtFutangaku().getValue().toString()));
                内訳WK7 = 内訳WK7.add(RString.isNullOrEmpty(row.getTxtUnder70Shikyugaku().getText())
                        ? Decimal.ZERO : new Decimal(row.getTxtUnder70Shikyugaku().getValue().toString()));
                内訳WK8 = 内訳WK8.add(RString.isNullOrEmpty(row.getTxtShikyugaku().getText())
                        ? Decimal.ZERO : new Decimal(row.getTxtShikyugaku().getValue().toString()));
            }
        }
        div.getTxtJohoOver70FutangakuGokei().setValue(内訳WK1);
        div.getTxtJohoOver70ShikyugakuGokei().setValue(内訳WK3);
        div.getTxtJohoUnder70FutangakuGokei().setValue(内訳WK4);
        div.getTxtJohoFutangakuGokei().setValue(内訳WK5);
        div.getTxtJohoUnder70ShikyugakuGokei().setValue(内訳WK7);
        div.getTxtJohoShikyugakuGokei().setValue(内訳WK8);
        div.getTxtSetaiFutanSogaku().setValue(内訳WK1.add(内訳WK4));
        div.getTxtSetaiShikyuSogaku().setValue(内訳WK8);
        div.getTxtOver70SetaiShikyuSogaku().setValue(内訳WK3);
        div.getTxtSetaiGassanGaku().setValue(内訳WK5);
        div.getTxtOver70SetaiGassanGaku().setValue(内訳WK1);
    }

    /**
     * 支給額計算結果編集のメソッドです。
     *
     * @param 支給額計算結果 KogakuGassanShikyugakuKeisanKekkaRelate
     * @param 状態 RString
     * @return KogakuGassanShikyugakuKeisanKekkaRelate
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果編集(
            KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果, RString 状態) {
        return 支給額計算結果.createBuilderForEdit()
                .set保険制度コード(追加.equals(状態) ? KaigoGassan_HokenSeido.介護.getCode()
                        : 支給額計算結果.get保険制度コード())
                .set自己負担額証明書整理番号(div.getTxtJikoFutanSeiriNo().getValue())
                .set対象計算期間開始年月日(rDateToFixibleDate(div.getTxtTaishoKeisanKikan().getFromValue()))
                .set対象計算期間終了年月日(rDateToFixibleDate(div.getTxtTaishoKeisanKikan().getToValue()))
                .set世帯負担総額(div.getTxtSetaiFutanSogaku().getValue())
                .set介護等合算一部負担金等世帯合算額(div.getTxtSetaiGassanGaku().getValue())
                .set70歳以上介護等合算一部負担金等世帯合算額(div.getTxtOver70SetaiGassanGaku().getValue())
                .set所得区分(div.getDdlShotokuKubun().getSelectedKey())
                .set70歳以上の者に係る所得区分(div.getDdlOver70ShotokuKubun().getSelectedKey())
                .set介護等合算算定基準額(div.getTxtSanteiKijunGaku().getValue())
                .set70歳以上介護等合算算定基準額(div.getTxtOver70SanteiKijyunGaku().getValue())
                .set世帯支給総額(div.getTxtSetaiShikyuSogaku().getValue())
                .setうち70歳以上分世帯支給総額(div.getTxtOver70SetaiShikyuSogaku().getValue())
                .set按分後支給額(div.getTxtHonninShikyugaku().getValue())
                .setうち70歳以上分按分後支給額(div.getTxtOver70HonninShikyugaku().getValue())
                .set介護低所得者Ⅰ再計算実施の有無(Collections.EMPTY_LIST.equals(
                                div.getCblTeiShotoku1SaiKeisanUmu().getSelectedKeys()) ? RSTRING_ONE : RSTRING_TWO)
                .set備考(div.getTxtBiko().getValue())
                .set通知年月日(rDateToFixibleDate(div.getTxtTsuchiYMD().getValue()))
                .set連絡票発行者名(RString.isNullOrEmpty(div.getTxtRenrakuhyoHakkoshaMei().getValue())
                        ? null : new AtenaMeisho(div.getTxtRenrakuhyoHakkoshaMei().getValue()))
                .set連絡票発行者郵便番号(div.getTxtRenrakuhyoHakkoshaYubinNo().getValue())
                .set連絡票発行者住所(div.getTxtRenrakuhyoHakkoshaJusho().getValue())
                .set問い合わせ先郵便番号(div.getTxtToiawasesakiYobinNo().getValue())
                .set問い合わせ先住所(div.getTxtToiawasesakiJusho().getValue())
                .set問い合わせ先名称1(div.getTxtToiawasesakiMeisho1().getValue())
                .set問い合わせ先名称2(div.getTxtToiawasesakiMeisho2().getValue())
                .set問い合わせ先電話番号(RString.isNullOrEmpty(div.getTxtToiawasesakiTelNo().getValue())
                        ? null : new TelNo(div.getTxtToiawasesakiTelNo().getValue()))
                .set70歳以上負担額合計(div.getTxtJohoOver70FutangakuGokei().getValue())
                .set70歳以上支給額合計(div.getTxtJohoOver70ShikyugakuGokei().getValue())
                .set70歳未満負担額合計(div.getTxtJohoUnder70FutangakuGokei().getValue())
                .set負担額の合計額(div.getTxtJohoFutangakuGokei().getValue())
                .set70歳未満支給額合計(div.getTxtJohoUnder70ShikyugakuGokei().getValue())
                .set支給額合計額(div.getTxtJohoShikyugakuGokei().getValue())
                .setデータ区分(RSTRING_TWO)
                .set再送フラグ(Collections.EMPTY_LIST.equals(
                                div.getChkSaiso().getSelectedKeys()) ? RSTRING_ZERO : RSTRING_ONE)
                .build();
    }

    private void ドロップダウンリスト項目セット() {
        保険制度DDL();
        設定所得区分DDL();
        設定70歳以上の者に係る所得区分DDL();
    }

    private void 保険制度DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (KaigoGassan_HokenSeido tiem : KaigoGassan_HokenSeido.values()) {
            if (tiem.getCode().isEmpty()) {
                continue;
            }
            dataSource.add(new KeyValueDataSource(tiem.getCode(), tiem.get名称()));
        }
        div.getDdlHokenSeido().setDataSource(dataSource);
    }

    private void 設定所得区分DDL() {
        int 年度 = div.getTxtTaishoKeisanKikan().getToValue() == null
                ? RDate.getNowDate().getNendo().getYearValue() : div.getTxtTaishoKeisanKikan().getToValue().getNendo().getYearValue();
        List<KeyValueDataSource> h25年度以前 = new ArrayList();
        h25年度以前.add(new KeyValueDataSource(空白, RString.EMPTY));
        h25年度以前.add(new KeyValueDataSource(所得区分_課税, 課税));
        h25年度以前.add(new KeyValueDataSource(所得区分_非課税, 非課税));
        h25年度以前.add(new KeyValueDataSource(KaigoGassan_ShotokuKbn.上位所得者.getCode(),
                KaigoGassan_ShotokuKbn.上位所得者.get名称()));
        List<KeyValueDataSource> h26年度以降 = new ArrayList();
        h26年度以降.add(new KeyValueDataSource(空白, RString.EMPTY));
        List<KeyValueDataSource> h27年1月以降 = new ArrayList();
        h27年1月以降.add(new KeyValueDataSource(空白, RString.EMPTY));
        for (KaigoGassan_ShotokuKbn type : KaigoGassan_ShotokuKbn.values()) {
            h27年1月以降.add(new KeyValueDataSource(type.getCode(), type.get名称()));
            if (KaigoGassan_ShotokuKbn.区分ア.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分イ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分ウ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分エ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分オ.get名称().equals(type.get名称())) {
                h26年度以降.add(new KeyValueDataSource(type.getCode(), type.get名称()));
            }
        }
        if (0 <= 年度_2013 - 年度) {
            div.getDdlShotokuKubun().setDataSource(h25年度以前);
        } else if (年度_2014 - 年度 < 0 && 年度 - 年度_2015 <= 0) {
            div.getDdlShotokuKubun().setDataSource(h26年度以降);
        } else {
            div.getDdlShotokuKubun().setDataSource(h27年1月以降);
        }
    }

    private void 設定70歳以上の者に係る所得区分DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (KaigoGassan_Over70_ShotokuKbn tiem : KaigoGassan_Over70_ShotokuKbn.values()) {
            if (tiem.getCode().isEmpty()) {
                continue;
            }
            dataSource.add(new KeyValueDataSource(tiem.getCode(), tiem.get名称()));
        }
        div.getDdlOver70ShotokuKubun().setDataSource(dataSource);
    }

    private RString セットデータ区分(RString データ区分) {
        if (RSTRING_ONE.equals(データ区分) || RSTRING_THREE.equals(データ区分)) {
            return 国保連作成;
        } else if (RSTRING_TWO.equals(データ区分)) {
            return 保険者作成;
        } else {
            return null;
        }
    }

    private void 連絡票整理番号項目をセット() {
        RString 連絡票整理番号 = div.getTxtShikyuShinseishoSeiriNoInput().getValue();
        div.getTxtTaishoNendo().setValue(new RDate(連絡票整理番号.substring(INT_0, INT_3).toString()));
        div.getTxtShoKisaiHokenshaNoa().setValue(連絡票整理番号.substring(INT_3, INT_11));
        div.getTxtShikyuShinseishoSeiriNo().setValue(連絡票整理番号);
        if (div.getTxtTaishoNendo().getValue().getYearValue() == 年度_2008) {
            div.getTxtOver70Biko().setVisible(true);
            div.getTxtUnder70Biko().setVisible(true);
        } else {
            div.getTxtOver70Biko().setVisible(false);
            div.getTxtUnder70Biko().setVisible(false);
        }
    }

    private void 年度から計算期間を算出() {
        int 年度 = div.getTxtTaishoNendo().getValue().getYearValue();
        RDate 計算期間FROM;
        if (年度_2008 == 年度) {
            計算期間FROM = new RDate(new RString(年度).concat(DATE_0401).toString());
        } else {
            計算期間FROM = new RDate(new RString(年度).concat(DATE_0801).toString());
        }
        RDate 計算期間TO = new RDate(new RString(年度 + INT_1).concat(DATE_0731).toString());
        div.getTxtTaishoKeisanKikan().setFromValue(計算期間FROM);
        div.getTxtTaishoKeisanKikan().setToValue(計算期間TO);
    }

    private RDate flexibleDateToRDate(FlexibleDate date) {
        if (date == null || new RString(date.toString()).isEmpty()) {
            return null;
        }
        return new RDate(date.toString());
    }

    private FlexibleDate rDateToFixibleDate(RDate date) {
        if (date == null || new RString(date.toString()).isEmpty()) {
            return null;
        }
        return new FlexibleDate(date.toString());
    }

    private void 支給額計算結果登録入力パネルクリア() {
        div.getTxtSanteiKubun().clearValue();
        div.getTxtStatusFlg().clearValue();
        div.getTxtTaishoNendo().clearValue();
        div.getTxtShoKisaiHokenshaNoa().clearValue();
        div.getTxtShikyuShinseishoSeiriNo().clearValue();
        div.getTxtSofuYM().clearValue();
        div.getChkSaiso().setSelectedItemsByKey(Collections.EMPTY_LIST);
    }

    private void 計算内訳情報パネルクリア() {
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().setDataSource(Collections.EMPTY_LIST);
        合計情報パネルクリア();
        内訳入力パネルクリア();
    }

    private void 支給額情報パネルクリア() {
        div.getTxtTaishoKeisanKikan().clearFromValue();
        div.getTxtTaishoKeisanKikan().clearToValue();
        div.getTxtJikoFutanSeiriNo().clearValue();
        div.getDdlShotokuKubun().setSelectedIndex(INT_0);
        div.getDdlOver70ShotokuKubun().setSelectedIndex(INT_0);

        div.getTxtSetaiFutanSogaku().setValue(Decimal.ZERO);
        div.getTxtSetaiShikyuSogaku().setValue(Decimal.ZERO);
        div.getTxtOver70SetaiShikyuSogaku().setValue(Decimal.ZERO);
        div.getTxtSetaiGassanGaku().setValue(Decimal.ZERO);
        div.getTxtOver70SetaiGassanGaku().setValue(Decimal.ZERO);
        div.getTxtHonninShikyugaku().setValue(Decimal.ZERO);
        div.getTxtOver70HonninShikyugaku().setValue(Decimal.ZERO);
        div.getTxtSanteiKijunGaku().setValue(Decimal.ZERO);
        div.getTxtOver70SanteiKijyunGaku().setValue(Decimal.ZERO);
        div.getCblTeiShotoku1SaiKeisanUmu().setSelectedItemsByKey(Collections.EMPTY_LIST);
        div.getTxtBiko().clearValue();
    }

    private void 連絡票情報パネルクリア() {
        div.getTxtTsuchiYMD().clearValue();
        div.getTxtRenrakuhyoHakkoshaMei().clearValue();
        div.getTxtRenrakuhyoHakkoshaYubinNo().clearValue();
        div.getTxtRenrakuhyoHakkoshaJusho().clearValue();
        div.getTxtToiawasesakiMeisho1().clearValue();
        div.getTxtToiawasesakiYobinNo().clearValue();
        div.getTxtToiawasesakiMeisho2().clearValue();
        div.getTxtToiawasesakiTelNo().clearValue();
        div.getTxtToiawasesakiJusho().clearValue();
    }

    private void 合計情報パネルクリア() {
        div.getTxtJohoOver70FutangakuGokei().clearValue();
        div.getTxtJohoOver70ShikyugakuGokei().clearValue();
        div.getTxtJohoUnder70FutangakuGokei().clearValue();
        div.getTxtJohoFutangakuGokei().clearValue();
        div.getTxtJohoUnder70ShikyugakuGokei().clearValue();
        div.getTxtJohoShikyugakuGokei().clearValue();
    }

    private void 内訳入力パネルクリア() {
        div.getDdlHokenSeido().setSelectedIndex(INT_0);
        div.getTxtShoKisaiHokenshaNo().clearValue();
        div.getTxtHokenshaMei().clearValue();
        div.getTxtKokuhoHihokenshaShoKigo().clearValue();
        div.getTxtTaishoshaShimei().clearValue();
        div.getTxtHiHokenshaShoNo().clearValue();
        div.getTxtJikoFutanSeiriNom().clearValue();
        div.getTxtOver70Futangaku().clearValue();
        div.getTxtOver70AmbunRitsu().clearValue();
        div.getTxtOver70Shikyugaku().clearValue();
        div.getTxtUnder70Futangaku().clearValue();
        div.getTxtFutangaku().clearValue();
        div.getTxtAmbunRitsu().clearValue();
        div.getTxtUnder70Shikyugaku().clearValue();
        div.getTxtShikyuGaku().clearValue();
        div.getTxtOver70Biko().clearValue();
        div.getTxtUnder70Biko().clearValue();
    }

    private void 支給額計算結果画面項目設定(KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果) {
        支給額計算結果登録入力パネル項目設定(支給額計算結果);
        支給額結果明細グリッド(支給額計算結果.get高額合算支給額計算結果list());
        合計情報パネル項目設定(支給額計算結果);
        支給額情報パネル項目設定(支給額計算結果);
        連絡票情報パネル項目設定(支給額計算結果);
    }

    private void 支給額計算結果登録入力パネル項目設定(KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果) {
        RString 支給額計算結果連絡先郵便番号 = 支給額計算結果.get支給額計算結果連絡先郵便番号() == null
                ? null : 支給額計算結果.get支給額計算結果連絡先郵便番号().getYubinNo();
        div.getTxtSanteiKubun().setValue(郵便番号MAX.equals(支給額計算結果連絡先郵便番号) ? 仮データ : RString.EMPTY);
        int 対象年度 = 支給額計算結果.get対象年度().getYearValue();
        div.getTxtTaishoNendo().setValue(new RDate(支給額計算結果.get対象年度().getYearValue()));
        if (対象年度 == 年度_2008) {
            div.getTxtOver70Biko().setVisible(true);
            div.getTxtUnder70Biko().setVisible(true);
        } else {
            div.getTxtOver70Biko().setVisible(false);
            div.getTxtUnder70Biko().setVisible(false);
        }
        div.getTxtShoKisaiHokenshaNoa().setValue(支給額計算結果.get証記載保険者番号().getColumnValue());
        div.getTxtShikyuShinseishoSeiriNo().setValue(支給額計算結果.get支給申請書整理番号());
        div.getTxtSofuYM().setValue(支給額計算結果.get送付年月() == null || RString.isNullOrEmpty(支給額計算結果.get送付年月().toDateString()) ? null
                : new RDate(支給額計算結果.get送付年月().toString()));
        if (RSTRING_ZERO.equals(支給額計算結果.get再送フラグ())) {
            div.getChkSaiso().setSelectedItemsByKey(Collections.EMPTY_LIST);
        } else {
            List<RString> keyList = new ArrayList();
            keyList.add(KEY_0);
            div.getChkSaiso().setSelectedItemsByKey(keyList);
        }
    }

    private void 合計情報パネル項目設定(KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果) {
        div.getTxtJohoOver70FutangakuGokei().setValue(支給額計算結果.get70歳以上負担額合計());
        div.getTxtJohoOver70ShikyugakuGokei().setValue(支給額計算結果.get70歳以上支給額合計());
        div.getTxtJohoUnder70FutangakuGokei().setValue(支給額計算結果.get70歳未満負担額合計());
        div.getTxtJohoFutangakuGokei().setValue(支給額計算結果.get負担額の合計額());
        div.getTxtJohoUnder70ShikyugakuGokei().setValue(支給額計算結果.get70歳未満支給額合計());
        div.getTxtJohoShikyugakuGokei().setValue(支給額計算結果.get支給額合計額());
    }

    private void 支給額情報パネル項目設定(KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果) {
        div.getTxtTaishoKeisanKikan().setFromValue(flexibleDateToRDate(支給額計算結果.get対象計算期間開始年月日()));
        div.getTxtTaishoKeisanKikan().setToValue(flexibleDateToRDate(支給額計算結果.get対象計算期間終了年月日()));
        div.getTxtJikoFutanSeiriNo().setValue(支給額計算結果.get自己負担額証明書整理番号());
        設定所得区分DDL();
        if (null != 支給額計算結果.get所得区分() && !支給額計算結果.get所得区分().isEmpty()) {
            div.getDdlShotokuKubun().setSelectedKey(支給額計算結果.get所得区分());
        } else {
            div.getDdlShotokuKubun().setSelectedIndex(INT_0);
        }
        if (null != 支給額計算結果.get70歳以上の者に係る所得区分() && !支給額計算結果.get70歳以上の者に係る所得区分().isEmpty()) {
            div.getDdlOver70ShotokuKubun().setSelectedKey(支給額計算結果.get70歳以上の者に係る所得区分());
        } else {
            div.getDdlOver70ShotokuKubun().setSelectedIndex(INT_0);
        }

        div.getTxtSetaiFutanSogaku().setValue(nvlDecimal(支給額計算結果.get世帯負担総額()));
        div.getTxtSetaiShikyuSogaku().setValue(nvlDecimal(支給額計算結果.get世帯支給総額()));
        div.getTxtOver70SetaiShikyuSogaku().setValue(nvlDecimal(支給額計算結果.getうち70歳以上分世帯支給総額()));
        div.getTxtSetaiGassanGaku().setValue(nvlDecimal(支給額計算結果.get介護等合算一部負担金等世帯合算額()));
        div.getTxtOver70SetaiGassanGaku().setValue(nvlDecimal(支給額計算結果.get70歳以上介護等合算一部負担金等世帯合算額()));
        div.getTxtHonninShikyugaku().setValue(nvlDecimal(支給額計算結果.get按分後支給額()));
        div.getTxtOver70HonninShikyugaku().setValue(nvlDecimal(支給額計算結果.getうち70歳以上分按分後支給額()));
        div.getTxtSanteiKijunGaku().setValue(nvlDecimal(支給額計算結果.get介護等合算算定基準額()));
        div.getTxtOver70SanteiKijyunGaku().setValue(nvlDecimal(支給額計算結果.get70歳以上介護等合算算定基準額()));
        if (RSTRING_ONE.equals(支給額計算結果.get介護低所得者Ⅰ再計算実施の有無())) {
            div.getCblTeiShotoku1SaiKeisanUmu().setSelectedItemsByKey(Collections.EMPTY_LIST);
        } else {
            List<RString> keyList = new ArrayList();
            keyList.add(KEY_0);
            div.getCblTeiShotoku1SaiKeisanUmu().setSelectedItemsByKey(keyList);
        }
        div.getTxtBiko().setValue(支給額計算結果.get備考());
    }

    private Decimal nvlDecimal(Decimal obj) {
        return obj == null ? Decimal.ZERO : obj;
    }

    private void 連絡票情報パネル項目設定(KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果) {
        div.getTxtTsuchiYMD().setValue(flexibleDateToRDate(支給額計算結果.get通知年月日()));
        div.getTxtRenrakuhyoHakkoshaMei().setValue(支給額計算結果.get連絡票発行者名() == null
                ? null : 支給額計算結果.get連絡票発行者名().getColumnValue());
        div.getTxtRenrakuhyoHakkoshaYubinNo().setValue(支給額計算結果.get連絡票発行者郵便番号());
        div.getTxtRenrakuhyoHakkoshaJusho().setValue(支給額計算結果.get連絡票発行者住所());
        div.getTxtToiawasesakiMeisho1().setValue(支給額計算結果.get問い合わせ先名称1());
        div.getTxtToiawasesakiYobinNo().setValue(支給額計算結果.get問い合わせ先郵便番号());
        div.getTxtToiawasesakiMeisho2().setValue(支給額計算結果.get問い合わせ先名称2());
        div.getTxtToiawasesakiTelNo().setValue(支給額計算結果.get問い合わせ先電話番号() == null
                ? null : 支給額計算結果.get問い合わせ先電話番号().getColumnValue());
        div.getTxtToiawasesakiJusho().setValue(支給額計算結果.get問い合わせ先住所());
    }

    private void 内訳入力パネルデータ設定(KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細) {
        div.getDdlHokenSeido().setSelectedKey(支給額計算結果明細.get保険制度コード());
        div.getTxtShoKisaiHokenshaNo().setValue(支給額計算結果明細.get内訳保険者番号());
        div.getTxtHokenshaMei().setValue(支給額計算結果明細.get内訳保険者名());
        div.getTxtKokuhoHihokenshaShoKigo().setValue(支給額計算結果明細.get国保被保険者証記号());
        div.getTxtTaishoshaShimei().setValue(支給額計算結果明細.get対象者氏名_漢字());
        div.getTxtHiHokenshaShoNo().setValue(支給額計算結果明細.get被保険者_証番号());
        div.getTxtJikoFutanSeiriNom().setValue(支給額計算結果明細.get自己負担額証明書整理番号());
        div.getTxtOver70Futangaku().setValue(RString.isNullOrEmpty(支給額計算結果明細.get70歳以上負担額())
                ? Decimal.ZERO : new Decimal(支給額計算結果明細.get70歳以上負担額().toString()));
        div.getTxtOver70AmbunRitsu().setValue(支給額計算結果明細.get70歳以上按分率());
        div.getTxtOver70Shikyugaku().setValue(RString.isNullOrEmpty(支給額計算結果明細.get70歳以上支給額())
                ? Decimal.ZERO : new Decimal(支給額計算結果明細.get70歳以上支給額().toString()));
        div.getTxtUnder70Futangaku().setValue(RString.isNullOrEmpty(支給額計算結果明細.get70歳未満負担額())
                ? Decimal.ZERO : new Decimal(支給額計算結果明細.get70歳未満負担額().toString()));
        div.getTxtFutangaku().setValue(RString.isNullOrEmpty(支給額計算結果明細.get負担額())
                ? Decimal.ZERO : new Decimal(支給額計算結果明細.get負担額().toString()));
        div.getTxtAmbunRitsu().setValue(支給額計算結果明細.get按分率());
        div.getTxtUnder70Shikyugaku().setValue(RString.isNullOrEmpty(支給額計算結果明細.get70歳未満支給額())
                ? Decimal.ZERO : new Decimal(支給額計算結果明細.get70歳未満支給額().toString()));
        div.getTxtShikyuGaku().setValue(RString.isNullOrEmpty(支給額計算結果明細.get支給額())
                ? Decimal.ZERO : new Decimal(支給額計算結果明細.get支給額().toString()));
        div.getTxtOver70Biko().setValue(RString.isNullOrEmpty(支給額計算結果明細.get備考欄記載70歳以上負担額())
                ? Decimal.ZERO : new Decimal(支給額計算結果明細.get備考欄記載70歳以上負担額().toString()));
        div.getTxtUnder70Biko().setValue(RString.isNullOrEmpty(支給額計算結果明細.get備考欄記載70歳未満負担額())
                ? Decimal.ZERO : new Decimal(支給額計算結果明細.get備考欄記載70歳未満負担額().toString()));
    }

    private void 処理1() {
        Decimal 未満負担額 = div.getTxtUnder70Futangaku().getValue() == null ? Decimal.ZERO : div.getTxtUnder70Futangaku().getValue();
        Decimal 以上負担額 = div.getTxtOver70Futangaku().getValue() == null ? Decimal.ZERO : div.getTxtOver70Futangaku().getValue();
        Decimal 以上支給額 = div.getTxtOver70Shikyugaku().getValue() == null ? Decimal.ZERO : div.getTxtOver70Shikyugaku().getValue();
        div.getTxtFutangaku().setValue(未満負担額.add((以上負担額.subtract(以上支給額))));
    }

    private void 処理2() {
        Decimal 以上支給額 = div.getTxtOver70Shikyugaku().getValue() == null ? Decimal.ZERO : div.getTxtOver70Shikyugaku().getValue();
        Decimal 未満支給額 = div.getTxtUnder70Shikyugaku().getValue() == null ? Decimal.ZERO : div.getTxtUnder70Shikyugaku().getValue();
        div.getTxtShikyuGaku().setValue(以上支給額.add(未満支給額));
    }

    private void 按分率計算処理(RString 状態) {
        List<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> rowList = div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getDataSource();
        Decimal 以上負担額合計 = Decimal.ZERO;
        Decimal 負担額合計 = Decimal.ZERO;
        for (dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row row : rowList) {
            if (!RowState.Deleted.equals(row.getRowState())) {
                以上負担額合計 = 以上負担額合計.add(RString.isNullOrEmpty(row.getTxtOver70Futangaku().getText())
                        ? Decimal.ZERO : new Decimal(row.getTxtOver70Futangaku().getValue().toString()));
                負担額合計 = 負担額合計.add(RString.isNullOrEmpty(row.getTxtFutangaku().getText())
                        ? Decimal.ZERO : new Decimal(row.getTxtFutangaku().getValue().toString()));
            }
        }
        if (!追加.equals(状態)) {
            dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row clickedRow = div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getClickedItem();
            以上負担額合計 = 以上負担額合計.subtract(RString.isNullOrEmpty(clickedRow.getTxtOver70Futangaku().getText())
                    ? Decimal.ZERO : new Decimal(clickedRow.getTxtOver70Futangaku().getValue().toString()));
            負担額合計 = 負担額合計.subtract(RString.isNullOrEmpty(clickedRow.getTxtFutangaku().getText())
                    ? Decimal.ZERO : new Decimal(clickedRow.getTxtFutangaku().getValue().toString()));
        }
        Decimal 以上負担額 = div.getTxtOver70Futangaku().getValue() == null ? Decimal.ZERO : div.getTxtOver70Futangaku().getValue();
        Decimal 負担額 = div.getTxtFutangaku().getValue() == null ? Decimal.ZERO : div.getTxtFutangaku().getValue();
        set以上負担額分率(以上負担額, 以上負担額合計.add(以上負担額));
        set負担額分率(負担額, 負担額合計.add(負担額));
    }

    private void set負担額分率(Decimal 負担額, Decimal 負担額合計) {
        if (!Decimal.ZERO.equals(負担額) && Decimal.ZERO.equals(負担額合計)) {
            div.getTxtAmbunRitsu().setValue(new RString(負担額.toString()).concat(スラッシュ).concat(new RString(負担額.toString())));
        } else if (Decimal.ZERO.equals(負担額) && !Decimal.ZERO.equals(負担額合計)) {
            div.getTxtAmbunRitsu().setValue(横線);
        } else if (Decimal.ZERO.equals(負担額) && Decimal.ZERO.equals(負担額合計)) {
            div.getTxtAmbunRitsu().setValue(横線);
        } else {
            div.getTxtAmbunRitsu().setValue(new RString(負担額.toString()).concat(スラッシュ).concat(new RString(負担額合計.toString())));
        }
    }

    private void set以上負担額分率(Decimal 以上負担額, Decimal 以上負担額合計) {
        if (!Decimal.ZERO.equals(以上負担額) && Decimal.ZERO.equals(以上負担額合計)) {
            div.getTxtOver70AmbunRitsu().setValue(new RString(以上負担額.toString()).concat(スラッシュ).concat(new RString(以上負担額.toString())));
        } else if (Decimal.ZERO.equals(以上負担額) && !Decimal.ZERO.equals(以上負担額合計)) {
            div.getTxtOver70AmbunRitsu().setValue(横線);
        } else if (Decimal.ZERO.equals(以上負担額) && Decimal.ZERO.equals(以上負担額合計)) {
            div.getTxtOver70AmbunRitsu().setValue(横線);
        } else {
            div.getTxtOver70AmbunRitsu().setValue(new RString(以上負担額.toString()).concat(スラッシュ).concat(new RString(以上負担額合計.toString())));
        }
    }
}
