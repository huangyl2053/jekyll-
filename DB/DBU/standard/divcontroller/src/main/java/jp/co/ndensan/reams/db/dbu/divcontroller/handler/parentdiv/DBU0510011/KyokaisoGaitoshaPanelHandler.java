/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0510011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoGaitoshaJoho;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoHokenryo;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.KyokaisoGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dgKyokaisouGaitouItran_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dghokenryoNofu_Row;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 境界層該当者台帳管理Handlerクラスです。
 */
public class KyokaisoGaitoshaPanelHandler {

    private static final RString 照会 = new RString("照会");
    private static final RString 更新 = new RString("更新");
    private static final RString 措置_該当区分 = new RString("1");
    private static final RString 措置_非該当区分 = new RString("2");
    private static final RString 措置区分_該当 = new RString("該当");
    private static final RString 措置区分_非該当 = new RString("非該当");
    private static final RString 記載解除_区分 = new RString("1");
    private static final RString 記載解除無_区分 = new RString("2");
    private static final RString 記載解除_解除 = new RString("解除する");
    private static final RString 記載解除_解除無 = new RString("解除しない");
    private static final RString 保険料納付減額フラグ_適用 = new RString("1");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RDate 申請年月日 = new RDate("20150401");

    private final KyokaisoGaitoshaPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 境界層該当者台帳管理Div
     */
    public KyokaisoGaitoshaPanelHandler(KyokaisoGaitoshaPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 境界層該当一覧情報 境界層該当一覧情報
     */
    public void onLoad(SearchResult<KyokaisoGaitoshaJoho> 境界層該当一覧情報) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (照会.equals(状態)) {
            set境界層該当一覧(境界層該当一覧情報.records(), 状態);
            div.getBtnTuika().setVisible(false);
            div.getDgKyokaisouGaitouItran().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getDgKyokaisouGaitouItran().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgKyokaisouGaitouItran().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
        if (更新.equals(状態)) {
            set境界層該当一覧(境界層該当一覧情報.records(), 状態);
        }
    }

    /**
     * 追加ボタンが押下された場合、境界層該当一覧エリアを閉じて、明細エリアを空白で表示します。
     */
    public void onClick_btnTuika() {
        div.getKyokaisouGaitouItiran().setIranState(状態_追加);
        div.getDghokenryoNofu().getGridSetting().setIsShowSelectButtonColumn(true);
        div.getDghokenryoNofu().getGridSetting().setIsShowDeleteButtonColumn(true);
        div.getRadSochiGaitouKubun().setSelectedKey(措置_該当区分);
        div.getRadKyufukakuGengakuKisaiKaijyo().setSelectedKey(記載解除_区分);
        div.getRadHyojunFutanGaku().setSelectedKey(措置_該当区分);
        div.getRadKyojuhiFutanGakuGengaku().setSelectedKey(措置_該当区分);
        div.getRadShokuhiFutangakuGengaku().setSelectedKey(措置_該当区分);
        div.getRadGogakuServiceJokengaku().setSelectedKey(措置_該当区分);
        div.getRadHokenryoNofuGengaku().setSelectedKey(保険料納付減額フラグ_適用);
        div.getTxtHohenryoNofuFromDate().setDisabled(true);
        div.getTxtHohenryoNofuToDate().setDisabled(true);
        div.getDdlTekiyouSuruShutokuDankai().setDisabled(true);
        div.getBtnCancel().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
    }

    /**
     * 選択ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param row 境界層該当一覧選択したデータ
     * @param 境界層保険料段階情報 境界層保険料段階情報
     */
    public void onClick_ShowSelectButton(
            dgKyokaisouGaitouItran_Row row,
            SearchResult<KyokaisoHokenryo> 境界層保険料段階情報) {
        div.getKyokaisouGaitouItiran().setIranState(RString.EMPTY);
        set境界層該当明細(row, 境界層保険料段階情報);
        set境界層該当明細非活性();
        List<KeyValueDataSource> dataSourceList = 居住費軽減後居室種類ドロップダウンリスト();
        div.getDdlKyoshituShurui().setDataSource(dataSourceList);
    }

    /**
     * 修正ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param row 境界層該当一覧選択したデータ
     * @param 境界層保険料段階情報 境界層保険料段階情報
     */
    public void onClick_ShowModifyButton(
            dgKyokaisouGaitouItran_Row row,
            SearchResult<KyokaisoHokenryo> 境界層保険料段階情報) {
        div.getKyokaisouGaitouItiran().setIranState(状態_修正);
        set境界層該当明細(row, 境界層保険料段階情報);
        div.getBtnTuikaSuru().setDisabled(false);
        div.getBtnCancel().setDisabled(false);
        div.getBtnKakutei().setDisabled(false);
    }

    /**
     * 削除が押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param row 境界層該当一覧選択したデータ
     * @param 境界層保険料段階情報 境界層保険料段階情報
     */
    public void onClick_ShowDeleteButton(
            dgKyokaisouGaitouItran_Row row,
            SearchResult<KyokaisoHokenryo> 境界層保険料段階情報) {
        div.getKyokaisouGaitouItiran().setIranState(状態_削除);
        set境界層該当明細(row, 境界層保険料段階情報);
        set境界層該当明細非活性();
        List<dghokenryoNofu_Row> nofu_rowList = new ArrayList<>();
        for (KyokaisoHokenryo 境界層保険料段階 : 境界層保険料段階情報.records()) {
            dghokenryoNofu_Row nofu_row = new dghokenryoNofu_Row();
            nofu_row.setModifyButtonState(DataGridButtonState.Disabled);
            nofu_row.setDeleteButtonState(DataGridButtonState.Disabled);
            nofu_row.setDefaultDataName0(RString.EMPTY);
            nofu_row.setDefaultDataName1(年月フォーマット(境界層保険料段階.get適用開始年月()));
            nofu_row.setDefaultDataName2(年月フォーマット(境界層保険料段階.get適用終了年月()));
            // TODO 凌護行　保険料段階(DbT2013)のビジネスクラスが無し、QA496回答まち、2016/1/18
//            nofu_row.setDefaultDataName3(RString.EMPTY);
            nofu_row.setDefaultDataName4(new RString(境界層保険料段階.get履歴番号().toString()));
            nofu_rowList.add(nofu_row);
        }
        div.getDghokenryoNofu().setDataSource(nofu_rowList);
    }

    /**
     * 保険料納付を追加するボタンが押下された場合、保険料納付入力エリアの項目が活性になる。
     */
    public void onClick_btnTuikaSuru() {
        div.getTxtHohenryoNofuFromDate().setDisabled(false);
        div.getTxtHohenryoNofuToDate().setDisabled(false);
        div.getDdlTekiyouSuruShutokuDankai().setDisabled(false);
        div.getBtnCancel().setDisabled(false);
        div.getBtnKakutei().setDisabled(false);
    }

    /**
     * 保険料納付を修正ボタンが押下された場合、保険料納付を表示します。
     *
     * @param nofu_Row 保険料納付
     */
    public void onClick_ModifyButton(dghokenryoNofu_Row nofu_Row) {
        div.getTxtHohenryoNofuFromDate().setValue(new RDate(nofu_Row.getDefaultDataName1().toString()));
        div.getTxtHohenryoNofuToDate().setValue(new RDate(nofu_Row.getDefaultDataName2().toString()));
        // TODO 凌護行　保険料段階(DbT2013)のビジネスクラスが無し、QA496回答まち、2016/1/18
//        div.getDdlTekiyouSuruShutokuDankai().setSelectedKey(nofu_Row.getDefaultDataName3());
        div.getTxtHohenryoNofuFromDate().setDisabled(false);
        div.getTxtHohenryoNofuToDate().setDisabled(false);
        div.getDdlTekiyouSuruShutokuDankai().setDisabled(false);
        div.getBtnCancel().setDisabled(false);
        div.getBtnKakutei().setDisabled(false);
    }

    /**
     * 保険料納付を削除ボタンが押下された場合、保険料納付を表示します。
     *
     * @param nofu_Row 保険料納付
     */
    public void onClick_DeleteButton(dghokenryoNofu_Row nofu_Row) {
        div.getTxtHohenryoNofuFromDate().setValue(new RDate(nofu_Row.getDefaultDataName1().toString()));
        div.getTxtHohenryoNofuToDate().setValue(new RDate(nofu_Row.getDefaultDataName2().toString()));
        // TODO 凌護行　保険料段階(DbT2013)のビジネスクラスが無し、QA496回答まち、2016/1/18
//        div.getDdlTekiyouSuruShutokuDankai().setSelectedKey(nofu_Row.getDefaultDataName3());
        div.getTxtHohenryoNofuFromDate().setDisabled(true);
        div.getTxtHohenryoNofuToDate().setDisabled(true);
        div.getDdlTekiyouSuruShutokuDankai().setDisabled(true);
        div.getBtnCancel().setDisabled(false);
        div.getBtnKakutei().setDisabled(false);
    }

    /**
     * 取消するボタンが押下された場合、保険料納付入力エリアに入力した内容をクリアする。
     */
    public void onClick_btnCancel() {
        div.getTxtHohenryoNofuFromDate().clearValue();
        div.getTxtHohenryoNofuToDate().clearValue();
        div.getDdlTekiyouSuruShutokuDankai().setSelectedKey(RString.EMPTY);
    }

    /**
     * 確認ボタンが押下された場合、保険料納付減額Grid一覧を表示します。
     *
     * @param イベント状態 イベント状態
     */
    public void onClick_btnKakutei(RString イベント状態) {

        dghokenryoNofu_Row row = new dghokenryoNofu_Row();
        if (!状態_追加.equals(div.getHokenryoNofuGengaku().getState())
                && !div.getHokenryoNofuGengaku().getState().isEmpty()) {
            row = div.getDghokenryoNofu().getActiveRow();
        }
        row.setDefaultDataName1(年月フォーマット(new FlexibleYearMonth(
                div.getTxtHohenryoNofuFromDate().getValue().getYearMonth().toString().replace(new RString("."), RString.EMPTY))));
        row.setDefaultDataName2(年月フォーマット(new FlexibleYearMonth(
                div.getTxtHohenryoNofuToDate().getValue().getYearMonth().toString().replace(new RString("."), RString.EMPTY))));
        // TODO 凌護行　保険料段階(DbT2013)のビジネスクラスが無し、QA496回答まち、2016/1/18
//        div.getDghokenryoNofu().getActiveRow().setDefaultDataName3(new RString(div.getTxtHohenryoNofuToDate().toString()));
        int index = div.getDghokenryoNofu().getClickedRowId();
        if (状態_追加.equals(div.getHokenryoNofuGengaku().getState())
                || div.getHokenryoNofuGengaku().getState().isEmpty()) {
            row.setDefaultDataName0(状態_追加);
            div.getDghokenryoNofu().getDataSource().add(row);
        } else if (状態_修正.equals(div.getHokenryoNofuGengaku().getState())) {
            div.getDghokenryoNofu().getDataSource().set(index, row);
            row.setDefaultDataName0(状態_修正);
        } else if (状態_削除.equals(div.getHokenryoNofuGengaku().getState())) {
            if (状態_追加.equals(row.getDefaultDataName0())) {
                div.getDghokenryoNofu().getDataSource().remove(index);
            }
            row.setDefaultDataName0(状態_削除);
        } else {
            row.setDefaultDataName0(RString.EMPTY);
            div.getDghokenryoNofu().getDataSource().set(index, row);
        }
        div.getHokenryoNofuGengaku().setState(RString.EMPTY);
        div.getTxtHohenryoNofuFromDate().clearValue();
        div.getTxtHohenryoNofuToDate().clearValue();
        div.getDdlTekiyouSuruShutokuDankai().setSelectedKey(RString.EMPTY);
    }

    /**
     * 「保存する」ボタンが押下された場合、境界層該当一覧エリア一覧を表示します。
     *
     * @param 境界層該当一覧情報 境界層該当一覧情報
     */
    public void onClick_ShowUpdate(SearchResult<KyokaisoGaitoshaJoho> 境界層該当一覧情報) {
        set境界層該当一覧(境界層該当一覧情報.records(), RString.EMPTY);
        div.getCcdKanryoMessage().setMessage(
                new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY, true);
        div.getBtnTuika().setDisabled(true);
    }

    /**
     * 保険料納付情報を設定します。
     *
     * @param hokenryoDankai 保険料納付情報
     * @param 最新リンク番号 最新リンク番号
     * @return KyokaisoHokenryoDankai 保険料納付情報
     */
    public KyokaisoHokenryoDankai editHokenryoDankai(
            KyokaisoHokenryoDankai hokenryoDankai,
            Decimal 最新リンク番号) {
        return hokenryoDankai.createBuilderForEdit()
                .set適用終了年月(new FlexibleYearMonth(div.getTxtHohenryoNofuToDate().getValue().seireki().getYearMonth().replace(new RString("."), RString.EMPTY)))
                // TODO 凌護行　保険料段階(DbT2013)のビジネスクラスが無し、QA496回答まち、2016/1/18
                //                .set保険料納付減額後保険料段階(div.getDdlTekiyouSuruShutokuDankai().getSelectedKey())
                .build();
    }

    /**
     * 保険料納付情報を設定します。
     *
     * @param hokenryoDankai 保険料納付情報
     * @return KyokaisoHokenryoDankai 保険料納付情報
     */
    public KyokaisoHokenryoDankai delHokenryoDankai(
            KyokaisoHokenryoDankai hokenryoDankai) {
        return hokenryoDankai.createBuilderForEdit()
                .build();
    }

    /**
     * 境界層該当者情報を設定します。
     *
     * @param kyokaisoGaitosha 境界層該当者情報
     * @return 境界層該当者情報
     */
    public KyokaisoGaitosha editKyokaisoGaitosha(KyokaisoGaitosha kyokaisoGaitosha) {
        Decimal 高額ｻｰﾋﾞｽ費減額後上限額 = new Decimal("0");
        if (!div.getDdlSeidaiJogengaku().getSelectedKey().isEmpty()) {
            高額ｻｰﾋﾞｽ費減額後上限額 = new Decimal(div.getDdlSeidaiJogengaku().getSelectedKey().toString());
        }
        return kyokaisoGaitosha.createBuilderForEdit()
                .set適用開始年月日(new FlexibleDate(div.getTxtKaishibi().getValue().toDateString()))
                .set適用終了年月日(new FlexibleDate(div.getTxtShuryobi().getValue().toDateString()))
                .set境界層措置決定年月日(new FlexibleDate(div.getTxtKeteibi().getValue().toDateString()))
                .set給付額減額記載解除フラグ(div.getRadKyufukakuGengakuKisaiKaijyo().getSelectedKey())
                .set標準負担額額該当フラグ(div.getRadHyojunFutanGaku().getSelectedKey())
                .set標準負担軽減後負担額(div.getTxtHyojunFutanKeigenAtoFutanGaku().getValue())
                .set居住費等負担額減額該当フラグ(div.getRadKyojuhiFutanGakuGengaku().getSelectedKey())
                // TODO 凌護行 居住費軽減・負担限度額段階ドロップダウンリストの設定値不明  QA446回答まち、2016/1/18
                //                .set居住費軽減後居室種類コード(div.getDdlKyoshituShurui().getSelectedKey())
                .set居住費軽減後負担額(div.getTxtKeigenAtoFutanGaku().getValue())
                .set食費負担額減額該当フラグ(div.getRadShokuhiFutangakuGengaku().getSelectedKey())
                .set食費軽減後負担額(div.getTxtShokuhiGenkenAtoFutangaku().getValue())
                .set高額ｻｰﾋﾞｽ費上限額減額該当フラグ(div.getRadGogakuServiceJokengaku().getSelectedKey())
                .set高額ｻｰﾋﾞｽ費減額後上限額(高額ｻｰﾋﾞｽ費減額後上限額)
                .set保険料納付減額フラグ(div.getRadHokenryoNofuGengaku().getSelectedKey())
                .build();
    }

    /**
     * 境界層措置申請情報を設定します。
     *
     * @param kyokaisoSochiShinsei 境界層措置申請情報
     * @return 境界層措置申請情報
     */
    public KyokaisoSochiShinsei editKyokaisoSochiShinsei(KyokaisoSochiShinsei kyokaisoSochiShinsei) {
        if (状態_追加.equals(div.getKyokaisouGaitouItiran().getIranState())) {
            kyokaisoSochiShinsei.createBuilderForEdit()
                    .set申請_廃止区分(new RString("1"));
        }
        return kyokaisoSochiShinsei.createBuilderForEdit()
                .set申請年月日(new FlexibleDate(div.getTxtShiseibi().getValue().toDateString()))
                .set受付年月日(new FlexibleDate(div.getTxtShiseibi().getValue().toDateString()))
                .set申請_廃止年月日(new FlexibleDate(div.getTxtShiseiHaishibi().getValue().toDateString()))
                .set保護不要根拠減額金額(div.getTxtHogoFuyoKonshoGengakuKingaku().getValue())
                .set境界層証明書交付年月日(new FlexibleDate(div.getTxtShomeishoKoufuDate().getValue().toDateString()))
                .set給付額減額取消_減額自己負担月額(div.getTxtKyufugakuJikoFutanGetsugaku().getValue())
                .set居住費軽減_減額自己負担月額(div.getTxtKyojuhiJikoFutanGetsugaku().getValue())
                // TODO 凌護行 居住費軽減・負担限度額段階ドロップダウンリストの設定値不明  QA446回答まち、2016/1/18
                //                .set居住費軽減_負担限度額段階コード(div.getDdlKyojuhiGendogakuDankai().getSelectedKey())
                .set食費軽減_減額自己負担月額(div.getTxtShokuhiJikoFutanGetsugaku().getValue())
                // TODO 凌護行 食費軽減・負担限度額段階ドロップダウンリスト の設定値不明  QA446回答まち、2016/1/18
                //                .set食費軽減_負担限度額段階コード(div.getDdlShokuhiGakenFutanGendogakuDankai().getSelectedKey())
                .set利用者負担世帯合算額_減額自己負担月額(div.getTxtKaigoHokenryoJikoFutanGetsugaku().getValue())
                .set保険料減額_減額自己負担月額(div.getTxtRiyoshaFutanSeidaiGokeigaku().getValue())
                .set減額自己負担月額合計額(div.getTxtJikoFutanGetsugakuGokeigaku().getValue())
                .set境界層措置決定年月日(new FlexibleDate(div.getTxtKeteibi().getValue().toDateString()))
                .set措置該当_非該当区分(div.getRadSochiGaitouKubun().getSelectedKey())
                .build();
    }

    /**
     * 取消ボタンが押下された場合、明細エリアを閉じて、境界層該当一覧エリアで表示します。
     */
    public void onClick_ShowCancel() {
        div.getTxtShiseibi().clearValue();
        div.getTxtKeteibi().clearValue();
        div.getTxtKaishibi().clearValue();
        div.getTxtShuryobi().clearValue();
        div.getRadSochiGaitouKubun().setSelectedKey(措置_該当区分);
        div.getRadKyufukakuGengakuKisaiKaijyo().setSelectedKey(記載解除_区分);
        div.getRadHyojunFutanGaku().setSelectedKey(措置_該当区分);
        div.getRadKyojuhiFutanGakuGengaku().setSelectedKey(措置_該当区分);
        div.getRadShokuhiFutangakuGengaku().setSelectedKey(措置_該当区分);
        div.getRadGogakuServiceJokengaku().setSelectedKey(措置_該当区分);
        div.getRadHokenryoNofuGengaku().setSelectedKey(保険料納付減額フラグ_適用);
        div.getTxtHyojunFutanKeigenAtoFutanGaku().clearValue();
        div.getDdlKyoshituShurui().setSelectedKey(RString.EMPTY);
        div.getTxtKeigenAtoFutanGaku().clearValue();
        div.getTxtShokuhiGenkenAtoFutangaku().clearValue();
        div.getDdlSeidaiJogengaku().setSelectedKey(RString.EMPTY);
        div.getTxtHohenryoNofuFromDate().clearValue();
        div.getTxtHohenryoNofuToDate().clearValue();
        div.getDdlTekiyouSuruShutokuDankai().setSelectedKey(RString.EMPTY);
        div.getDghokenryoNofu().getDataSource().clear();
        div.getTxtShiseiHaishibi().clearValue();
        div.getTxtHogoFuyoKonshoGengakuKingaku().clearValue();
        div.getTxtShomeishoKoufuDate().clearValue();
        div.getTxtKyufugakuJikoFutanGetsugaku().clearValue();
        div.getDdlKyojuhiGendogakuDankai().setSelectedKey(RString.EMPTY);
        div.getTxtKyojuhiJikoFutanGetsugaku().clearValue();
        div.getTxtShokuhiJikoFutanGetsugaku().clearValue();
        div.getDdlShokuhiGakenFutanGendogakuDankai().setSelectedKey(RString.EMPTY);
        div.getTxtKaigoHokenryoJikoFutanGetsugaku().clearValue();
        div.getTxtRiyoshaFutanSeidaiGokeigaku().clearValue();
        div.getTxtJikoFutanGetsugakuGokeigaku().clearValue();
        div.getKyokaisouGaitouItiran().setIranState(RString.EMPTY);
    }

    private void set境界層該当一覧(List<KyokaisoGaitoshaJoho> 境界層該当一覧情報, RString 状態) {
        List<dgKyokaisouGaitouItran_Row> rowList = new ArrayList<>();
        for (KyokaisoGaitoshaJoho 境界層該当一覧 : 境界層該当一覧情報) {
            dgKyokaisouGaitouItran_Row row = new dgKyokaisouGaitouItran_Row();
            if (状態.isEmpty()) {
                row.setSelectButtonState(DataGridButtonState.Disabled);
                row.setModifyButtonState(DataGridButtonState.Disabled);
                row.setDeleteButtonState(DataGridButtonState.Disabled);
            }
            row.setDefaultDataName0(日付フォーマット(境界層該当一覧.get申請年月日()));
            row.setDefaultDataName1(日付フォーマット(境界層該当一覧.get境界層措置決定年月日()));
            row.setDefaultDataName2(措置該当_非該当(境界層該当一覧.get措置該当_非該当区分()));
            row.setDefaultDataName3(日付フォーマット(境界層該当一覧.get適用開始年月日()));
            row.setDefaultDataName4(日付フォーマット(境界層該当一覧.get適用終了年月日()));
            row.setDefaultDataName5(記載解除(境界層該当一覧.get給付額減額記載解除フラグ()));
            row.setDefaultDataName6(new RString(nullToZero(境界層該当一覧.get保護不要根拠減額金額()).toString()));
            RString 居住費軽減後居室種類コード = nullToEmpty(境界層該当一覧.get居住費軽減後居室種類コード());
            if (居住費軽減後居室種類コード.isEmpty()) {
                row.setDefaultDataName7(RString.EMPTY);
            } else {
                RString 居住費軽減後居室種類 = CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBZ介護共通,
                        new CodeShubetsu("0243"),
                        new Code(境界層該当一覧.get居住費軽減後居室種類コード()));
                row.setDefaultDataName7(nullToEmpty(居住費軽減後居室種類));
            }
            row.setDefaultDataName8(new RString(nullToZero(境界層該当一覧.get居住費軽減後負担額()).toString()));
            row.setDefaultDataName9(new RString(nullToZero(境界層該当一覧.get食費軽減後負担額()).toString()));
            row.setDefaultDataName10(new RString(nullToZero(境界層該当一覧.get高額ｻｰﾋﾞｽ費減額後上限額()).toString()));
            // TODO 凌護行　保険料段階(DbT2013)のビジネスクラスが無し、QA496回答まち、2016/1/18
            row.setDefaultDataName11(new RString("コード名により、コードを取得"));
            // TODO 凌護行　境界層措置決定日の設定処理が無し、QA418回答まち、2016/1/18
            row.setDefaultDataName12(new RString("境界層措置決定日の設定処理が無し、QAまち"));
            row.setDefaultDataName13(new RString(nullToZero(境界層該当一覧.get給付額減額取消_減額自己負担月額()).toString()));
            row.setDefaultDataName14(new RString(nullToZero(境界層該当一覧.get居住費軽減_減額自己負担月額()).toString()));
            row.setDefaultDataName15(nullToEmpty(境界層該当一覧.get居住費軽減_負担限度額段階コード()));
            row.setDefaultDataName16(nullToEmpty(境界層該当一覧.get食費軽減_負担限度額段階コード()));
            row.setDefaultDataName17(new RString(nullToZero(境界層該当一覧.get利用者負担世帯合算額_減額自己負担月額()).toString()));
            row.setDefaultDataName18(new RString(nullToZero(境界層該当一覧.get保険料減額_減額自己負担月額()).toString()));
            row.setDefaultDataName19(new RString(nullToZero(境界層該当一覧.get減額自己負担月額合計額()).toString()));
            row.setDefaultDataName20(措置該当_非該当(境界層該当一覧.get標準負担額額該当フラグ()));
            row.setDefaultDataName21(new RString(nullToZero(境界層該当一覧.get標準負担軽減後負担額()).toString()));
            row.setDefaultDataName22(措置該当_非該当(境界層該当一覧.get居住費等負担額減額該当フラグ()));
            row.setDefaultDataName23(措置該当_非該当(境界層該当一覧.get食費負担額減額該当フラグ()));
            row.setDefaultDataName24(措置該当_非該当(境界層該当一覧.get高額ｻｰﾋﾞｽ費上限額減額該当フラグ()));
            row.setDefaultDataName25(境界層該当一覧.get保険料納付減額フラグ());
            row.setDefaultDataName26(居住費軽減後居室種類コード);
            // TODO 凌護行 DBに項目「リンク番号」が無し、現在「DB取得が履歴番号です」使用です、　QA328回答まち、 2016/1/18
            row.setDefaultDataName27(new RString(境界層該当一覧.getリンク番号().toString()));
            row.setDefaultDataName28(日付フォーマット(境界層該当一覧.get申請_廃止年月日()));
            row.setDefaultDataName29(日付フォーマット(境界層該当一覧.get境界層証明書交付年月日()));
            row.setDefaultDataName30(new RString(nullToZero(境界層該当一覧.get食費軽減_減額自己負担月額()).toString()));
            rowList.add(row);

        }
        div.getDgKyokaisouGaitouItran().setDataSource(rowList);
    }

    private void set境界層該当明細(
            dgKyokaisouGaitouItran_Row row,
            SearchResult<KyokaisoHokenryo> 境界層保険料段階情報) {
        div.getDghokenryoNofu().getGridSetting().setIsShowSelectButtonColumn(true);
        div.getTxtShiseibi().setValue(new RDate(row.getDefaultDataName0().toString()));
        div.getRadSochiGaitouKubun().setSelectedKey(措置区分(row.getDefaultDataName2()));
        div.getTxtKeteibi().setValue(new RDate(row.getDefaultDataName1().toString()));
        div.getTxtKaishibi().setValue(new RDate(row.getDefaultDataName3().toString()));
        div.getTxtShuryobi().setValue(new RDate(row.getDefaultDataName4().toString()));
        div.getRadKyufukakuGengakuKisaiKaijyo().setSelectedKey(記載解除区分(row.getDefaultDataName5()));
        div.getRadHyojunFutanGaku().setSelectedKey(措置区分(row.getDefaultDataName20()));
        div.getTxtHyojunFutanKeigenAtoFutanGaku().setValue(new Decimal(row.getDefaultDataName21().toString()));
        div.getRadKyojuhiFutanGakuGengaku().setSelectedKey(措置区分(row.getDefaultDataName22()));
        List<KeyValueDataSource> dataSourceList = 居住費軽減後居室種類ドロップダウンリスト();
        List<KeyValueDataSource> sourceList = new ArrayList<>();
        for (KeyValueDataSource dataSource : dataSourceList) {
            if (row.getDefaultDataName26().equals(dataSource.getKey())) {
                sourceList.add(dataSource);
            }
        }
        div.getDdlKyoshituShurui().setDataSource(sourceList);
        div.getTxtKeigenAtoFutanGaku().setValue(new Decimal(row.getDefaultDataName8().toString()));
        div.getRadShokuhiFutangakuGengaku().setSelectedKey(措置区分(row.getDefaultDataName23()));
        div.getTxtShokuhiGenkenAtoFutangaku().setValue(new Decimal(row.getDefaultDataName9().toString()));
        div.getRadGogakuServiceJokengaku().setSelectedKey(措置区分(row.getDefaultDataName24()));
        div.getRadHokenryoNofuGengaku().setSelectedKey(row.getDefaultDataName25());
        div.getDdlSeidaiJogengaku().setDataSource(読替後高額介護世帯上限額ドロップダウンリスト(new RDate(row.getDefaultDataName0().toString())));
        List<dghokenryoNofu_Row> nofu_rowList = new ArrayList<>();
        for (KyokaisoHokenryo 境界層保険料段階 : 境界層保険料段階情報.records()) {
            dghokenryoNofu_Row nofu_row = new dghokenryoNofu_Row();
            nofu_row.setDefaultDataName0(RString.EMPTY);
            nofu_row.setDefaultDataName1(年月フォーマット(境界層保険料段階.get適用開始年月()));
            nofu_row.setDefaultDataName2(年月フォーマット(境界層保険料段階.get適用終了年月()));
            // TODO 仕様不明
            nofu_row.setDefaultDataName3(RString.EMPTY);
            nofu_row.setDefaultDataName4(new RString(境界層保険料段階.get履歴番号().toString()));
            nofu_rowList.add(nofu_row);
        }
        div.getDghokenryoNofu().setDataSource(nofu_rowList);
        div.getTxtShiseiHaishibi().setValue(new RDate(row.getDefaultDataName28().toString()));
        div.getTxtHogoFuyoKonshoGengakuKingaku().setValue(new Decimal(row.getDefaultDataName6().toString()));
        div.getTxtShomeishoKoufuDate().setValue(new RDate(row.getDefaultDataName29().toString()));
        div.getTxtKyufugakuJikoFutanGetsugaku().setValue(new Decimal(row.getDefaultDataName13().toString()));
        // TODO 凌護行 居住費軽減・負担限度額段階ドロップダウンリストの設定値不明  QA446回答まち、2016/1/18
//        div.getDdlKyojuhiGendogakuDankai().setSelectedKey(照会);
        div.getTxtKyojuhiJikoFutanGetsugaku().setValue(new Decimal(row.getDefaultDataName14().toString()));
        div.getTxtShokuhiJikoFutanGetsugaku().setValue(new Decimal(row.getDefaultDataName30().toString()));
        // TODO 凌護行 食費軽減・負担限度額段階ドロップダウンリスト の設定値不明  QA446回答まち、2016/1/18
//        div.getDdlShokuhiGakenFutanGendogakuDankai().setSelectedKey(照会);
        div.getTxtKaigoHokenryoJikoFutanGetsugaku().setValue(new Decimal(row.getDefaultDataName18().toString()));
        div.getTxtRiyoshaFutanSeidaiGokeigaku().setValue(new Decimal(row.getDefaultDataName17().toString()));
        div.getTxtJikoFutanGetsugakuGokeigaku().setValue(new Decimal(row.getDefaultDataName19().toString()));
        div.getMeisaiAreaPanel().setRirekiNo(row.getDefaultDataName27());
        div.getTxtHohenryoNofuFromDate().setDisabled(true);
        div.getTxtHohenryoNofuToDate().setDisabled(true);
        div.getDdlTekiyouSuruShutokuDankai().setDisabled(true);
        div.getBtnCancel().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
        div.getBtnTuikaSuru().setDisabled(true);

    }

    private void set境界層該当明細非活性() {
        div.getTxtShiseibi().setDisabled(true);
        div.getRadSochiGaitouKubun().setDisabled(true);
        div.getTxtKeteibi().setDisabled(true);
        div.getTxtKaishibi().setDisabled(true);
        div.getTxtShuryobi().setDisabled(true);
        div.getRadKyufukakuGengakuKisaiKaijyo().setDisabled(true);
        div.getRadHyojunFutanGaku().setDisabled(true);
        div.getTxtHyojunFutanKeigenAtoFutanGaku().setDisabled(true);
        div.getRadKyojuhiFutanGakuGengaku().setDisabled(true);
        div.getDdlKyoshituShurui().setDisabled(true);
        div.getTxtKeigenAtoFutanGaku().setDisabled(true);
        div.getRadShokuhiFutangakuGengaku().setDisabled(true);
        div.getTxtShokuhiGenkenAtoFutangaku().setDisabled(true);
        div.getRadGogakuServiceJokengaku().setDisabled(true);
        div.getDdlSeidaiJogengaku().setDisabled(true);
        div.getRadHokenryoNofuGengaku().setDisabled(true);
        div.getBtnTuikaSuru().setDisabled(true);
        div.getTxtShiseiHaishibi().setDisabled(true);
        div.getTxtHogoFuyoKonshoGengakuKingaku().setDisabled(true);
        div.getTxtShomeishoKoufuDate().setDisabled(true);
        div.getTxtKyufugakuJikoFutanGetsugaku().setDisabled(true);
        div.getDdlKyojuhiGendogakuDankai().setDisabled(true);
        div.getTxtKyojuhiJikoFutanGetsugaku().setDisabled(true);
        div.getTxtShokuhiJikoFutanGetsugaku().setDisabled(true);
        div.getDdlShokuhiGakenFutanGendogakuDankai().setDisabled(true);
        div.getTxtKaigoHokenryoJikoFutanGetsugaku().setDisabled(true);
        div.getTxtRiyoshaFutanSeidaiGokeigaku().setDisabled(true);
        div.getTxtJikoFutanGetsugakuGokeigaku().setDisabled(true);
    }

    private List<KeyValueDataSource> 居住費軽減後居室種類ドロップダウンリスト() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<UzT0007CodeEntity> dataSourceList = CodeMaster.getCode(SubGyomuCode.DBZ介護共通, new CodeShubetsu("0243"));
        for (UzT0007CodeEntity entity : dataSourceList) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().getColumnValue());
            keyValue.setValue(entity.getコード名称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private List<KeyValueDataSource> 読替後高額介護世帯上限額ドロップダウンリスト(RDate 申請日) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        if (申請日.isBefore(申請年月日)) {
            KeyValueDataSource 第1段階 = new KeyValueDataSource();
            第1段階.setValue(ConfigNameDBC.第1段階_高額介護サービス費支給_自己負担上限月額.get名称());
            第1段階.setKey(BusinessConfig.get(ConfigNameDBC.第1段階_高額介護サービス費支給_自己負担上限月額, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第2段階 = new KeyValueDataSource();
            第2段階.setValue(ConfigNameDBC.第2段階_高額介護サービス費支給_自己負担上限月額.get名称());
            第2段階.setKey(BusinessConfig.get(ConfigNameDBC.第2段階_高額介護サービス費支給_自己負担上限月額, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第3段階 = new KeyValueDataSource();
            第3段階.setValue(ConfigNameDBC.第3段階_高額介護サービス費支給_自己負担上限月額.get名称());
            第3段階.setKey(BusinessConfig.get(ConfigNameDBC.第3段階_高額介護サービス費支給_自己負担上限月額, SubGyomuCode.DBC介護給付));
            dataSourceList.add(第1段階);
            dataSourceList.add(第2段階);
            dataSourceList.add(第3段階);
        } else {
            KeyValueDataSource 第1段階 = new KeyValueDataSource();
            第1段階.setValue(ConfigNameDBC.第1段階_高額介護サービス費支給_201504以降_自己負担上限月額.get名称());
            第1段階.setKey(BusinessConfig.get(ConfigNameDBC.第1段階_高額介護サービス費支給_201504以降_自己負担上限月額, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第2段階 = new KeyValueDataSource();
            第2段階.setValue(ConfigNameDBC.第2段階_高額介護サービス費支給_201504以降_自己負担上限月額.get名称());
            第2段階.setKey(BusinessConfig.get(ConfigNameDBC.第2段階_高額介護サービス費支給_201504以降_自己負担上限月額, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第3段階 = new KeyValueDataSource();
            第3段階.setValue(ConfigNameDBC.第3段階_高額介護サービス費支給_201504以降_自己負担上限月額.get名称());
            第3段階.setKey(BusinessConfig.get(ConfigNameDBC.第3段階_高額介護サービス費支給_201504以降_自己負担上限月額, SubGyomuCode.DBC介護給付));
            dataSourceList.add(第1段階);
            dataSourceList.add(第2段階);
            dataSourceList.add(第3段階);
        }
        return dataSourceList;
    }

    private RString 日付フォーマット(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString 年月フォーマット(FlexibleYearMonth 年月) {
        if (年月 == null || 年月.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString 措置該当_非該当(RString 措置区分) {
        RString 措置 = 措置区分_該当;
        if (措置区分 == null || 措置区分.isEmpty()) {
            return RString.EMPTY;
        }
        if (措置_非該当区分.equals(措置区分)) {
            措置 = 措置区分_非該当;
        }
        return 措置;
    }

    private RString 措置区分(RString 措置該当_非該当) {
        RString 措置 = 措置_該当区分;
        if (措置該当_非該当 == null || 措置該当_非該当.isEmpty()) {
            return 措置;
        }
        if (措置区分_非該当.equals(措置該当_非該当)) {
            措置 = 措置_非該当区分;
        }
        return 措置;
    }

    private RString 記載解除(RString 記載解除区分) {
        RString 記載解除 = 記載解除_解除;
        if (記載解除区分 == null || 記載解除区分.isEmpty()) {
            return RString.EMPTY;
        }
        if (記載解除無_区分.equals(記載解除区分)) {
            記載解除 = 記載解除_解除無;
        }
        return 記載解除;
    }

    private RString 記載解除区分(RString 記載解除) {
        RString 記載解除区分 = 記載解除_区分;
        if (記載解除 == null || 記載解除.isEmpty()) {
            return 記載解除区分;
        }
        if (記載解除_解除無.equals(記載解除)) {
            記載解除区分 = 記載解除無_区分;
        }
        return 記載解除区分;
    }

    private Decimal nullToZero(Decimal obj) {
        if (obj == null) {
            return Decimal.ZERO;
        }
        return obj;
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
