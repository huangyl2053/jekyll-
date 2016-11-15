/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0510011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbu.business.core.kyokaisogaitosha.KyokaisoGaitoshaJoho;
import jp.co.ndensan.reams.db.dbu.business.core.kyokaisogaitosha.KyokaisoHokenryo;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.KyokaisoGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dgKyokaisouGaitouItran_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dghokenryoNofu_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBZCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitoshaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankaiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinseiBuilder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 境界層該当者台帳管理Handlerクラスです。
 *
 * @reamsid_L DBU-0430-010 linghuhang
 */
public class KyokaisoGaitoshaPanelHandler {

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
    private static final RString 非該当フラグ = new RString("2");

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
    public void onLoad(List<KyokaisoGaitoshaJoho> 境界層該当一覧情報) {
        div.getDdlKyojuhiGendogakuDankai().setDataSource(居住費軽減負担限度額段階ドロップダウンリスト());
        div.getDdlKyoshituShurui().setDataSource(居住費軽減後居室種類ドロップダウンリスト());
        div.getDdlShokuhiGakenFutanGendogakuDankai().setDataSource(居住費軽減負担限度額段階ドロップダウンリスト());
        set境界層該当一覧(境界層該当一覧情報);
    }

    /**
     * 追加ボタンが押下された場合、境界層該当一覧エリアを閉じて、明細エリアを空白で表示します。
     */
    public void onClick_btnTuika() {
        div.getDdlSeidaiJogengaku().setDataSource(
                読替後高額介護世帯上限額ドロップダウンリスト(RDate.getNowDate()));
        div.getDdlTekiyouSuruShutokuDankai().setDataSource(
                所得段階ドロップダウンリスト(RDate.getNowDate()));
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
            List<KyokaisoHokenryo> 境界層保険料段階情報) {
        div.getKyokaisouGaitouItiran().setIranState(RString.EMPTY);
        div.getDdlSeidaiJogengaku().setDataSource(
                読替後高額介護世帯上限額ドロップダウンリスト(new RDate(row.getShinseiDate().toString())));
        div.getDdlTekiyouSuruShutokuDankai().setDataSource(
                所得段階ドロップダウンリスト(new RDate(row.getShinseiDate().toString())));
        set境界層該当明細(row, 境界層保険料段階情報);
        set境界層該当明細非活性();
    }

    /**
     * 修正ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param row 境界層該当一覧選択したデータ
     * @param 境界層保険料段階情報 境界層保険料段階情報
     */
    public void onClick_ShowModifyButton(
            dgKyokaisouGaitouItran_Row row,
            List<KyokaisoHokenryo> 境界層保険料段階情報) {
        div.getKyokaisouGaitouItiran().setIranState(状態_修正);
        div.getBtnTuikaSuru().setDisabled(false);
        div.getBtnCancel().setDisabled(false);
        div.getBtnKakutei().setDisabled(false);
        div.getDdlSeidaiJogengaku().setDataSource(
                読替後高額介護世帯上限額ドロップダウンリスト(new RDate(row.getShinseiDate().toString())));
        div.getDdlTekiyouSuruShutokuDankai().setDataSource(
                所得段階ドロップダウンリスト(new RDate(row.getShinseiDate().toString())));
        set境界層該当明細(row, 境界層保険料段階情報);
        set境界層該当明細活性();
        onClick_radHyojunFutanGaku();
        onClick_radkyojuhiFutanGakuGengaku();
        onClick_radShokuhiFutangakuGengaku();
        onClick_radGogakuServiceJoken();
        onClick_radHokenryoNofuGengaku();
    }

    /**
     * 削除が押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param row 境界層該当一覧選択したデータ
     * @param 境界層保険料段階情報 境界層保険料段階情報
     */
    public void onClick_ShowDeleteButton(
            dgKyokaisouGaitouItran_Row row,
            List<KyokaisoHokenryo> 境界層保険料段階情報) {
        div.getKyokaisouGaitouItiran().setIranState(状態_削除);
        div.getDdlSeidaiJogengaku().setDataSource(
                読替後高額介護世帯上限額ドロップダウンリスト(new RDate(row.getShinseiDate().toString())));
        div.getDdlTekiyouSuruShutokuDankai().setDataSource(
                所得段階ドロップダウンリスト(new RDate(row.getShinseiDate().toString())));
        set境界層該当明細(row, 境界層保険料段階情報);
        set境界層該当明細非活性();
    }

    /**
     * 該当・非該当を押下された場合、標準負担額の項目が活性・不活性になる。
     */
    public void onClick_radHyojunFutanGaku() {
        if (非該当フラグ.equals(div.getRadHyojunFutanGaku().getSelectedKey())) {
            div.getTxtHyojunFutanKeigenAtoFutanGaku().setDisabled(true);
        } else {
            div.getTxtHyojunFutanKeigenAtoFutanGaku().setDisabled(false);
        }
    }

    /**
     * 該当・非該当を押下された場合、居住費等負担額減額の項目が活性・不活性になる。
     */
    public void onClick_radkyojuhiFutanGakuGengaku() {
        if (非該当フラグ.equals(div.getRadKyojuhiFutanGakuGengaku().getSelectedKey())) {
            div.getDdlKyoshituShurui().setDisabled(true);
            div.getTxtKeigenAtoFutanGaku().setDisabled(true);
        } else {
            div.getDdlKyoshituShurui().setDisabled(false);
            div.getTxtKeigenAtoFutanGaku().setDisabled(false);
        }
    }

    /**
     * 該当・非該当を押下された場合、食費負担額減額の項目が活性・不活性になる。
     */
    public void onClick_radShokuhiFutangakuGengaku() {
        if (非該当フラグ.equals(div.getRadShokuhiFutangakuGengaku().getSelectedKey())) {
            div.getTxtShokuhiGenkenAtoFutangaku().setDisabled(true);
        } else {
            div.getTxtShokuhiGenkenAtoFutangaku().setDisabled(false);
        }
    }

    /**
     * 該当・非該当を押下された場合、高額サービス費上限額減額の項目が活性・不活性になる。
     */
    public void onClick_radGogakuServiceJoken() {
        if (非該当フラグ.equals(div.getRadGogakuServiceJokengaku().getSelectedKey())) {
            div.getDdlSeidaiJogengaku().setDisabled(true);
        } else {
            div.getDdlSeidaiJogengaku().setDisabled(false);
        }
    }

    /**
     * 適用する・適用しないを押下された場合、項目が活性・不活性になる。
     */
    public void onClick_radHokenryoNofuGengaku() {
        if (非該当フラグ.equals(div.getRadHokenryoNofuGengaku().getSelectedKey())) {
            div.getHohenryoNofuPanel().setDisabled(true);
            div.getTxtHohenryoNofuFromDate().setDisabled(true);
            div.getTxtHohenryoNofuToDate().setDisabled(true);
            div.getDdlTekiyouSuruShutokuDankai().setDisabled(true);
            div.getBtnCancel().setDisabled(true);
            div.getBtnKakutei().setDisabled(true);
        } else {
            div.getHohenryoNofuPanel().setDisabled(false);
        }
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
        if (nofu_Row.getTekiyoKaishiDate() != null && !nofu_Row.getTekiyoKaishiDate().isEmpty()) {
            div.getTxtHohenryoNofuFromDate().setValue(new RDate(nofu_Row.getTekiyoKaishiDate().toString()));
        }
        if (nofu_Row.getTekiyoShuryoDate() != null && !nofu_Row.getTekiyoShuryoDate().isEmpty()) {
            div.getTxtHohenryoNofuToDate().setValue(new RDate(nofu_Row.getTekiyoShuryoDate().toString()));
        }
        div.getDdlTekiyouSuruShutokuDankai().setSelectedValue(nofu_Row.getHokenryoDankai());
        div.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setHiddenRirekiNo(nofu_Row.getTekiyoRirekiNo());
        div.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setHiddenLinkNo(nofu_Row.getTekiyoRirekiNo());
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
        if (nofu_Row.getTekiyoKaishiDate() != null && !nofu_Row.getTekiyoKaishiDate().isEmpty()) {
            div.getTxtHohenryoNofuFromDate().setValue(new RDate(nofu_Row.getTekiyoKaishiDate().toString()));
        }
        if (nofu_Row.getTekiyoShuryoDate() != null && !nofu_Row.getTekiyoShuryoDate().isEmpty()) {
            div.getTxtHohenryoNofuToDate().setValue(new RDate(nofu_Row.getTekiyoShuryoDate().toString()));
        }
        div.getDdlTekiyouSuruShutokuDankai().setSelectedValue(nofu_Row.getHokenryoDankai());
        div.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setHiddenRirekiNo(nofu_Row.getTekiyoRirekiNo());
        div.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setHiddenLinkNo(nofu_Row.getTekiyoRirekiNo());
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
        div.getTxtHohenryoNofuFromDate().setDisabled(true);
        div.getTxtHohenryoNofuToDate().setDisabled(true);
        div.getDdlTekiyouSuruShutokuDankai().setDisabled(true);
        div.getBtnCancel().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
    }

    /**
     * 確認ボタンが押下された場合、保険料納付減額Grid一覧を表示します。
     *
     * @param イベント状態 イベント状態
     * @param 最新リンク番号 最新リンク番号
     * @param 最新履歴番号 最新履歴番号
     */
    public void onClick_btnKakutei(RString イベント状態, int 最新リンク番号, int 最新履歴番号) {
        dghokenryoNofu_Row row = div.getDghokenryoNofu().getActiveRow();
        if (row == null) {
            row = new dghokenryoNofu_Row();
        }
        if (!状態_追加.equals(div.getHokenryoNofuGengaku().getTekiyoState())
                && !div.getHokenryoNofuGengaku().getTekiyoState().isEmpty()) {
            row = div.getDghokenryoNofu().getActiveRow();
        }
        if (div.getTxtHohenryoNofuFromDate().getValue() != null) {
            row.setTekiyoKaishiDate(年月フォーマット(new FlexibleYearMonth(
                    div.getTxtHohenryoNofuFromDate().getValue().getYearMonth().toString().replace(new RString("."), RString.EMPTY))));
        } else {
            row.setTekiyoKaishiDate(RString.EMPTY);
        }
        if (div.getTxtHohenryoNofuToDate().getValue() != null) {
            row.setTekiyoShuryoDate(年月フォーマット(new FlexibleYearMonth(
                    div.getTxtHohenryoNofuToDate().getValue().getYearMonth().toString().replace(new RString("."), RString.EMPTY))));
        } else {
            row.setTekiyoShuryoDate(RString.EMPTY);
        }
        row.setHokenryoDankai(div.getDdlTekiyouSuruShutokuDankai().getSelectedValue());
        row.setTekiyoLinkNo(new RString(Integer.toString(最新リンク番号)));
        row.setTekiyoRirekiNo(new RString(Integer.toString(最新履歴番号)));
        int index = div.getDghokenryoNofu().getClickedRowId();
        if (状態_追加.equals(div.getHokenryoNofuGengaku().getTekiyoState())
                || div.getHokenryoNofuGengaku().getTekiyoState().isEmpty()) {
            row.setHiddenTekiyoKaishiDate(年月フォーマット(new FlexibleYearMonth(
                    div.getTxtHohenryoNofuFromDate().getValue().getYearMonth().toString().replace(new RString("."), RString.EMPTY))));
            row.setState(状態_追加);
            div.getDghokenryoNofu().getDataSource().add(row);
        } else if (状態_修正.equals(div.getHokenryoNofuGengaku().getTekiyoState())) {
            if (状態_削除.equals(row.getState()) || !状態_追加.equals(row.getState())) {
                row.setState(状態_修正);
                div.getDghokenryoNofu().getDataSource().set(index, row);
            }
        } else if (状態_削除.equals(div.getHokenryoNofuGengaku().getTekiyoState())) {
            if (状態_追加.equals(row.getState())) {
                div.getDghokenryoNofu().getDataSource().remove(index);
            } else {
                row.setState(状態_削除);
            }
        } else {
            row.setState(RString.EMPTY);
            div.getDghokenryoNofu().getDataSource().set(index, row);
        }
        div.getHokenryoNofuGengaku().setTekiyoState(RString.EMPTY);
        div.getTxtHohenryoNofuFromDate().clearValue();
        div.getTxtHohenryoNofuToDate().clearValue();
        div.getDdlTekiyouSuruShutokuDankai().setSelectedKey(RString.EMPTY);
        div.getTxtHohenryoNofuFromDate().setDisabled(true);
        div.getTxtHohenryoNofuToDate().setDisabled(true);
        div.getDdlTekiyouSuruShutokuDankai().setDisabled(true);
        div.getBtnCancel().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
    }

    /**
     * 保険料納付情報を設定します。
     *
     * @param hokenryoDankai 保険料納付情報
     * @return KyokaisoHokenryoDankai 保険料納付情報
     */
    public KyokaisoHokenryoDankai editHokenryoDankai(
            KyokaisoHokenryoDankai hokenryoDankai) {
        KyokaisoHokenryoDankaiBuilder 境界層保険料段階 = hokenryoDankai.createBuilderForEdit();
        if (div.getTxtHohenryoNofuToDate().getValue() != null) {
            境界層保険料段階.set適用終了年月(new FlexibleYearMonth(
                    div.getTxtHohenryoNofuToDate().getValue().seireki().getYearMonth().replace(new RString("."), RString.EMPTY)));
        }
        if (div.getDdlTekiyouSuruShutokuDankai().getSelectedKey() != null && !div.getDdlTekiyouSuruShutokuDankai().getSelectedKey().isEmpty()) {
            境界層保険料段階.set保険料納付減額後保険料段階(div.getDdlTekiyouSuruShutokuDankai().getSelectedKey());
        }
        return 境界層保険料段階.build();
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
        KyokaisoGaitoshaBuilder 境界層該当者情報 = kyokaisoGaitosha.createBuilderForEdit();
        if (div.getTxtKaishibi() != null && div.getTxtKaishibi().getValue() != null) {
            境界層該当者情報.set適用開始年月日(new FlexibleDate(div.getTxtKaishibi().getValue().toDateString()));
        }
        if (div.getTxtShuryobi() != null && div.getTxtShuryobi().getValue() != null) {
            境界層該当者情報.set適用終了年月日(new FlexibleDate(div.getTxtShuryobi().getValue().toDateString()));
        }
        if (div.getTxtKeteibi() != null && div.getTxtKeteibi().getValue() != null) {
            境界層該当者情報.set境界層措置決定年月日(new FlexibleDate(div.getTxtKeteibi().getValue().toDateString()));
        }
        if (!RString.isNullOrEmpty(div.getRadKyufukakuGengakuKisaiKaijyo().getSelectedKey())) {
            境界層該当者情報.set給付額減額記載解除フラグ(div.getRadKyufukakuGengakuKisaiKaijyo().getSelectedKey());
        }
        if (!RString.isNullOrEmpty(div.getRadHyojunFutanGaku().getSelectedKey())) {
            境界層該当者情報.set標準負担額額該当フラグ(div.getRadHyojunFutanGaku().getSelectedKey());
        }
        if (div.getTxtHyojunFutanKeigenAtoFutanGaku() != null && div.getTxtHyojunFutanKeigenAtoFutanGaku().getValue() != null) {
            境界層該当者情報.set標準負担軽減後負担額(div.getTxtHyojunFutanKeigenAtoFutanGaku().getValue());
        }
        if (!RString.isNullOrEmpty(div.getRadKyojuhiFutanGakuGengaku().getSelectedKey())) {
            境界層該当者情報.set居住費等負担額減額該当フラグ(div.getRadKyojuhiFutanGakuGengaku().getSelectedKey());
        }
        return set項目(境界層該当者情報);
    }

    private KyokaisoGaitosha set項目(KyokaisoGaitoshaBuilder 境界層該当者情報) {
        if (!RString.isNullOrEmpty(div.getDdlKyoshituShurui().getSelectedKey())) {
            境界層該当者情報.set居住費軽減後居室種類コード(div.getDdlKyoshituShurui().getSelectedKey());
        }
        if (div.getTxtKeigenAtoFutanGaku() != null && div.getTxtKeigenAtoFutanGaku().getValue() != null) {
            境界層該当者情報.set居住費軽減後負担額(div.getTxtKeigenAtoFutanGaku().getValue());
        }
        if (!RString.isNullOrEmpty(div.getRadShokuhiFutangakuGengaku().getSelectedKey())) {
            境界層該当者情報.set食費負担額減額該当フラグ(div.getRadShokuhiFutangakuGengaku().getSelectedKey());
        }
        if (div.getTxtShokuhiGenkenAtoFutangaku() != null && div.getTxtShokuhiGenkenAtoFutangaku().getValue() != null) {
            境界層該当者情報.set食費軽減後負担額(div.getTxtShokuhiGenkenAtoFutangaku().getValue());
        }
        if (!RString.isNullOrEmpty(div.getRadGogakuServiceJokengaku().getSelectedKey())) {
            境界層該当者情報.set高額ｻｰﾋﾞｽ費上限額減額該当フラグ(div.getRadGogakuServiceJokengaku().getSelectedKey());
        }
        if (!RString.isNullOrEmpty(div.getDdlSeidaiJogengaku().getSelectedKey())) {
            境界層該当者情報.set高額ｻｰﾋﾞｽ費減額後上限額(new Decimal(div.getDdlSeidaiJogengaku().getSelectedKey().toString()));
        }
        if (!RString.isNullOrEmpty(div.getRadHokenryoNofuGengaku().getSelectedKey())) {
            境界層該当者情報.set保険料納付減額フラグ(div.getRadHokenryoNofuGengaku().getSelectedKey());
        }
        return 境界層該当者情報.build();
    }

    /**
     * 境界層措置申請情報を設定します。
     *
     * @param kyokaisoSochiShinsei 境界層措置申請情報
     * @return 境界層措置申請情報
     */
    public KyokaisoSochiShinsei editKyokaisoSochiShinsei(KyokaisoSochiShinsei kyokaisoSochiShinsei) {
        KyokaisoSochiShinseiBuilder 境界層措置申請 = kyokaisoSochiShinsei.createBuilderForEdit();
        if (div.getTxtShiseibi() != null && div.getTxtShiseibi().getValue() != null) {
            境界層措置申請.set申請年月日(new FlexibleDate(div.getTxtShiseibi().getValue().toDateString()));
        }
        if (div.getTxtShiseibi() != null && div.getTxtShiseibi().getValue() != null) {
            境界層措置申請.set受付年月日(new FlexibleDate(div.getTxtShiseibi().getValue().toDateString()));
        }
        if (div.getTxtShiseiHaishibi() != null && div.getTxtShiseiHaishibi().getValue() != null) {
            境界層措置申請.set申請_廃止年月日(new FlexibleDate(div.getTxtShiseiHaishibi().getValue().toDateString()));
        }
        if (div.getTxtHogoFuyoKonshoGengakuKingaku() != null && div.getTxtHogoFuyoKonshoGengakuKingaku().getValue() != null) {
            境界層措置申請.set保護不要根拠減額金額(div.getTxtHogoFuyoKonshoGengakuKingaku().getValue());
        }
        if (div.getTxtShomeishoKoufuDate() != null && div.getTxtShomeishoKoufuDate().getValue() != null) {
            境界層措置申請.set境界層証明書交付年月日(new FlexibleDate(div.getTxtShomeishoKoufuDate().getValue().toDateString()));
        }
        if (div.getTxtKyufugakuJikoFutanGetsugaku() != null && div.getTxtKyufugakuJikoFutanGetsugaku().getValue() != null) {
            境界層措置申請.set給付額減額取消_減額自己負担月額(div.getTxtKyufugakuJikoFutanGetsugaku().getValue());
        }
        if (div.getTxtKyojuhiJikoFutanGetsugaku() != null && div.getTxtKyojuhiJikoFutanGetsugaku().getValue() != null) {
            境界層措置申請.set居住費軽減_減額自己負担月額(div.getTxtKyojuhiJikoFutanGetsugaku().getValue());
        }
        if (!RString.isNullOrEmpty(div.getDdlKyojuhiGendogakuDankai().getSelectedKey())) {
            境界層措置申請.set居住費軽減_負担限度額段階コード(div.getDdlKyojuhiGendogakuDankai().getSelectedKey());
        }
        return set項目(境界層措置申請);
    }

    private KyokaisoSochiShinsei set項目(KyokaisoSochiShinseiBuilder 境界層措置申請) {
        if (div.getTxtShokuhiJikoFutanGetsugaku() != null && div.getTxtShokuhiJikoFutanGetsugaku().getValue() != null) {
            境界層措置申請.set食費軽減_減額自己負担月額(div.getTxtShokuhiJikoFutanGetsugaku().getValue());
        }
        if (!RString.isNullOrEmpty(div.getDdlShokuhiGakenFutanGendogakuDankai().getSelectedKey())) {
            境界層措置申請.set食費軽減_負担限度額段階コード(div.getDdlShokuhiGakenFutanGendogakuDankai().getSelectedKey());
        }
        if (div.getTxtKaigoHokenryoJikoFutanGetsugaku() != null && div.getTxtKaigoHokenryoJikoFutanGetsugaku().getValue() != null) {
            境界層措置申請.set利用者負担世帯合算額_減額自己負担月額(div.getTxtKaigoHokenryoJikoFutanGetsugaku().getValue());
        }
        if (div.getTxtRiyoshaFutanSeidaiGokeigaku() != null && div.getTxtRiyoshaFutanSeidaiGokeigaku().getValue() != null) {
            境界層措置申請.set保険料減額_減額自己負担月額(div.getTxtRiyoshaFutanSeidaiGokeigaku().getValue());
        }
        if (div.getTxtJikoFutanGetsugakuGokeigaku() != null && div.getTxtJikoFutanGetsugakuGokeigaku().getValue() != null) {
            境界層措置申請.set減額自己負担月額合計額(div.getTxtJikoFutanGetsugakuGokeigaku().getValue());
        }
        if (div.getTxtKeteibi() != null && div.getTxtKeteibi().getValue() != null) {
            境界層措置申請.set境界層措置決定年月日(new FlexibleDate(div.getTxtKeteibi().getValue().toDateString()));
        }
        if (!RString.isNullOrEmpty(div.getRadSochiGaitouKubun().getSelectedKey())) {
            境界層措置申請.set措置該当_非該当区分(div.getRadSochiGaitouKubun().getSelectedKey());
        }
        return 境界層措置申請
                .set申請_廃止区分(new RString("1"))
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

    private void set境界層該当一覧(List<KyokaisoGaitoshaJoho> 境界層該当一覧情報) {
        List<dgKyokaisouGaitouItran_Row> rowList = new ArrayList<>();
        for (KyokaisoGaitoshaJoho 境界層該当一覧 : 境界層該当一覧情報) {
            dgKyokaisouGaitouItran_Row row = new dgKyokaisouGaitouItran_Row();
            row.setShinseiDate(日付フォーマット(境界層該当一覧.get申請年月日()));
            row.setKetteiDate(日付フォーマット(境界層該当一覧.get境界層措置決定年月日()));
            row.setSochiGaitoHigaitoKubun(措置該当_非該当(境界層該当一覧.get措置該当_非該当区分()));
            row.setKaishiDate(日付フォーマット(境界層該当一覧.get適用開始年月日()));
            row.setShuryoDate(日付フォーマット(境界層該当一覧.get適用終了年月日()));
            row.setKyuhugakuGengakuKisaiKaijo(記載解除(境界層該当一覧.get給付額減額記載解除フラグ()));
            row.getHogoFuyoKonkyoGengakuKingaku().setValue(nullToZero(境界層該当一覧.get保護不要根拠減額金額()));
            row.setKyojuhiKeigengoKyoshitsuShurui(nullToEmpty(
                    get居住費軽減後居室種類(境界層該当一覧.get居住費軽減後居室種類コード())));
            row.getKyojuhiKeigengoFutangaku().setValue(nullToZero(境界層該当一覧.get居住費軽減後負担額()));
            row.getSyokuhiKeigengoFutangaku().setValue(nullToZero(境界層該当一覧.get食費軽減後負担額()));
            row.getYomikaegoKogakuKaigoSetaiJogengaku().setValue(nullToZero(境界層該当一覧.get高額ｻｰﾋﾞｽ費減額後上限額()));
            row.setKaigoHokenryoTeigengoSyotokuDankai(
                    select所得段階(境界層該当一覧.get申請年月日(),
                            境界層該当一覧.get保険料納付減額後保険料段階() == null ? RString.EMPTY : 境界層該当一覧.get保険料納付減額後保険料段階()));
            row.setKyokaisoSochiKetteiDate(日付フォーマット(境界層該当一覧.get境界層措置決定年月日()));
            row.getKyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku().setValue(nullToZero(境界層該当一覧.get給付額減額取消_減額自己負担月額()));
            row.getKyojuhiKeigenGengakuJikofutanGetsugaku().setValue(nullToZero(境界層該当一覧.get居住費軽減_減額自己負担月額()));
            row.setKyojuhiKeigenFutanGendogakuDankai(nullToEmpty(境界層該当一覧.get居住費軽減_負担限度額段階コード()));
            row.setShokuhiKeigenFutanGendogakuDankai(nullToEmpty(境界層該当一覧.get食費軽減_負担限度額段階コード()));
            row.getRiyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku().setValue(
                    nullToZero(境界層該当一覧.get利用者負担世帯合算額_減額自己負担月額()));
            row.getKaigoHokenryoGengakuGengakuJikofutanGetsugaku().setValue(
                    nullToZero(境界層該当一覧.get保険料減額_減額自己負担月額()));
            row.getGengakuJikofutanGetsugakuGokeigaku().setValue(nullToZero(境界層該当一覧.get減額自己負担月額合計額()));
            row.setRirekiNo(new RString(境界層該当一覧.get履歴番号().toString()));
            row.setLinkNo(new RString(境界層該当一覧.getリンク番号().toString()));
            row.setShinseiHaishiYMD(日期転換(境界層該当一覧.get申請_廃止年月日()));
            row.setKyokaisoShomeishoKofuYMD(日期転換(境界層該当一覧.get境界層証明書交付年月日()));
            row.getShokuhiKeigenGengakuJikofutanGetsugaku().setValue(
                    nullToZero(境界層該当一覧.get食費軽減_減額自己負担月額()));
            row.setSochiGaitoHigaito(境界層該当一覧.get措置該当_非該当区分());
            row.setKyuhugakuGengakuKisaiKaijoFlag(境界層該当一覧.get給付額減額記載解除フラグ());
            row.setKyojuhiKeigengoKyoshitsuShuruiCode(境界層該当一覧.get居住費軽減後居室種類コード());
            row.setHyojunFutanGengakuGaitoFlag(境界層該当一覧.get標準負担額額該当フラグ());
            row.setKyojuhinadoFutangakugengakuGaitoFlag(境界層該当一覧.get居住費等負担額減額該当フラグ());
            row.setShokuhiKeigengoHutangakuGaitoFlag(境界層該当一覧.get食費負担額減額該当フラグ());
            row.setKogakuServicehiJogengakuGengakuGaitoFlag(境界層該当一覧.get高額ｻｰﾋﾞｽ費上限額減額該当フラグ());
            row.setKogakuServicehiJogengakuGengakugoJogengaku(new RString(nullToZero(境界層該当一覧.get高額ｻｰﾋﾞｽ費減額後上限額()).toString()));
            row.setHokenryoNofuGengakuFlag(境界層該当一覧.get保険料納付減額フラグ());
            row.setKyojuhiKeigenFutanGendogakuDankaiCode(境界層該当一覧.get居住費軽減_負担限度額段階コード());
            row.setShokuhiKeigenFutanGendogakuDankaiCode(境界層該当一覧.get食費軽減_負担限度額段階コード());
            row.setHyojunFutanKeigengoFutangaku(new RString(nullToZero(境界層該当一覧.get標準負担軽減後負担額()).toString()));
            rowList.add(row);

        }
        div.getDgKyokaisouGaitouItran().setDataSource(rowList);
    }

    private RString 日期転換(FlexibleDate 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return new RString(日期.toString());
        }
        return RString.EMPTY;
    }

    private void 日期転換(dgKyokaisouGaitouItran_Row row) {
        if (!RString.isNullOrEmpty(row.getKyokaisoSochiKetteiDate())) {
            div.getTxtKeteibi().setValue(new RDate(row.getKyokaisoSochiKetteiDate().toString()));
        }
        if (!RString.isNullOrEmpty(row.getKaishiDate())) {
            div.getTxtKaishibi().setValue(new RDate(row.getKaishiDate().toString()));
        }
        if (!RString.isNullOrEmpty(row.getShuryoDate())) {
            div.getTxtShuryobi().setValue(new RDate(row.getShuryoDate().toString()));
        }
        if (!RString.isNullOrEmpty(row.getShinseiHaishiYMD())) {
            div.getTxtShiseiHaishibi().setValue(new RDate(row.getShinseiHaishiYMD().toString()));
        }
        if (!RString.isNullOrEmpty(row.getKyokaisoShomeishoKofuYMD())) {
            div.getTxtShomeishoKoufuDate().setValue(new RDate(row.getKyokaisoShomeishoKofuYMD().toString()));
        }
    }

    private void set境界層該当明細(
            dgKyokaisouGaitouItran_Row row,
            List<KyokaisoHokenryo> 境界層保険料段階情報) {
        div.getDghokenryoNofu().getGridSetting().setIsShowSelectButtonColumn(true);
        div.getTxtShiseibi().setValue(new RDate(row.getShinseiDate().toString()));
        div.getRadSochiGaitouKubun().setSelectedKey(row.getSochiGaitoHigaito());
        日期転換(row);
        div.getRadKyufukakuGengakuKisaiKaijyo().setSelectedKey(row.getKyuhugakuGengakuKisaiKaijoFlag());
        div.getRadHyojunFutanGaku().setSelectedKey(row.getHyojunFutanGengakuGaitoFlag());
        div.getTxtHyojunFutanKeigenAtoFutanGaku().setValue(new Decimal(row.getHyojunFutanKeigengoFutangaku().toString()));
        div.getRadKyojuhiFutanGakuGengaku().setSelectedKey(row.getKyojuhinadoFutangakugengakuGaitoFlag());
        select居住費軽減後居室種類(row.getKyojuhiKeigengoKyoshitsuShuruiCode());
        div.getTxtKeigenAtoFutanGaku().setValue(row.getKyojuhiKeigengoFutangaku().getValue());
        div.getRadShokuhiFutangakuGengaku().setSelectedKey(row.getShokuhiKeigengoHutangakuGaitoFlag());
        div.getTxtShokuhiGenkenAtoFutangaku().setValue(row.getSyokuhiKeigengoFutangaku().getValue());
        div.getRadGogakuServiceJokengaku().setSelectedKey(row.getKogakuServicehiJogengakuGengakuGaitoFlag());
        select読替後高額介護世帯上限額(new RDate(row.getShinseiDate().toString()),
                row.getKogakuServicehiJogengakuGengakugoJogengaku());
        div.getRadHokenryoNofuGengaku().setSelectedKey(row.getHokenryoNofuGengakuFlag());
        境界層保険料段階一覧(境界層保険料段階情報, new RDate(row.getShinseiDate().toString()));
        div.getTxtHogoFuyoKonshoGengakuKingaku().setValue(row.getHogoFuyoKonkyoGengakuKingaku().getValue());
        div.getTxtKyufugakuJikoFutanGetsugaku().setValue(
                row.getKyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku().getValue());
        select居住費軽減負担限度額段階(row.getKyojuhiKeigenFutanGendogakuDankaiCode());
        div.getTxtKyojuhiJikoFutanGetsugaku().setValue(row.getKyojuhiKeigenGengakuJikofutanGetsugaku().getValue());
        div.getTxtShokuhiJikoFutanGetsugaku().setValue(row.getShokuhiKeigenGengakuJikofutanGetsugaku().getValue());
        select食費軽減負担限度額段階(row.getShokuhiKeigenFutanGendogakuDankaiCode());
        div.getTxtKaigoHokenryoJikoFutanGetsugaku().setValue(row.getKaigoHokenryoGengakuGengakuJikofutanGetsugaku().getValue());
        div.getTxtRiyoshaFutanSeidaiGokeigaku().setValue(row.getRiyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku().getValue());
        div.getTxtJikoFutanGetsugakuGokeigaku().setValue(row.getGengakuJikofutanGetsugakuGokeigaku().getValue());
        div.getMeisaiAreaPanel().setGaitoshaLinkNo(row.getLinkNo());
        div.getTxtHohenryoNofuFromDate().setDisabled(true);
        div.getTxtHohenryoNofuToDate().setDisabled(true);
        div.getDdlTekiyouSuruShutokuDankai().setDisabled(true);
        div.getBtnCancel().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
        div.getBtnTuikaSuru().setDisabled(true);

    }

    private void 境界層保険料段階一覧(List<KyokaisoHokenryo> 境界層保険料段階情報, RDate 申請年月日) {
        List<dghokenryoNofu_Row> nofu_rowList = new ArrayList<>();
        for (KyokaisoHokenryo 境界層保険料段階 : 境界層保険料段階情報) {
            dghokenryoNofu_Row nofu_row = new dghokenryoNofu_Row();
            if (状態_削除.equals(div.getKyokaisouGaitouItiran().getIranState())) {
                nofu_row.setSelectButtonState(DataGridButtonState.Disabled);
                nofu_row.setModifyButtonState(DataGridButtonState.Disabled);
                nofu_row.setDeleteButtonState(DataGridButtonState.Disabled);
            }
            nofu_row.setState(RString.EMPTY);
            nofu_row.setTekiyoKaishiDate(年月フォーマット(境界層保険料段階.get適用開始年月()));
            nofu_row.setTekiyoShuryoDate(年月フォーマット(境界層保険料段階.get適用終了年月()));
            nofu_row.setHokenryoDankai(select所得段階(new FlexibleDate(申請年月日.toDateString()),
                    境界層保険料段階.get保険料納付減額後保険料段階()));
            nofu_row.setTekiyoRirekiNo(new RString(境界層保険料段階.get履歴番号().toString()));
            nofu_row.setTekiyoLinkNo(new RString(境界層保険料段階.getリンク番号().toString()));
            nofu_row.setHiddenTekiyoKaishiDate(年月フォーマット(境界層保険料段階.get適用開始年月()));
            nofu_rowList.add(nofu_row);
        }
        div.getDghokenryoNofu().setDataSource(nofu_rowList);
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

    private void set境界層該当明細活性() {
        div.getTxtShiseibi().setDisabled(false);
        div.getRadSochiGaitouKubun().setDisabled(false);
        div.getTxtKeteibi().setDisabled(false);
        div.getTxtKaishibi().setDisabled(false);
        div.getTxtShuryobi().setDisabled(false);
        div.getRadKyufukakuGengakuKisaiKaijyo().setDisabled(false);
        div.getRadHyojunFutanGaku().setDisabled(false);
        div.getTxtHyojunFutanKeigenAtoFutanGaku().setDisabled(false);
        div.getRadKyojuhiFutanGakuGengaku().setDisabled(false);
        div.getDdlKyoshituShurui().setDisabled(false);
        div.getTxtKeigenAtoFutanGaku().setDisabled(false);
        div.getRadShokuhiFutangakuGengaku().setDisabled(false);
        div.getTxtShokuhiGenkenAtoFutangaku().setDisabled(false);
        div.getRadGogakuServiceJokengaku().setDisabled(false);
        div.getDdlSeidaiJogengaku().setDisabled(false);
        div.getRadHokenryoNofuGengaku().setDisabled(false);
        div.getBtnTuikaSuru().setDisabled(false);
        div.getTxtShiseiHaishibi().setDisabled(false);
        div.getTxtHogoFuyoKonshoGengakuKingaku().setDisabled(false);
        div.getTxtShomeishoKoufuDate().setDisabled(false);
        div.getTxtKyufugakuJikoFutanGetsugaku().setDisabled(false);
        div.getDdlKyojuhiGendogakuDankai().setDisabled(false);
        div.getTxtKyojuhiJikoFutanGetsugaku().setDisabled(false);
        div.getTxtShokuhiJikoFutanGetsugaku().setDisabled(false);
        div.getDdlShokuhiGakenFutanGendogakuDankai().setDisabled(false);
        div.getTxtKaigoHokenryoJikoFutanGetsugaku().setDisabled(false);
        div.getTxtRiyoshaFutanSeidaiGokeigaku().setDisabled(false);
        div.getTxtJikoFutanGetsugakuGokeigaku().setDisabled(false);
    }

    private List<KeyValueDataSource> 居住費軽減負担限度額段階ドロップダウンリスト() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (RiyoshaFutanDankai riyoshaFutanDankai : RiyoshaFutanDankai.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(riyoshaFutanDankai.getコード());
            keyValue.setValue(riyoshaFutanDankai.get名称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private void select居住費軽減負担限度額段階(RString 居住費軽減負担限度額段階コード) {
        List<KeyValueDataSource> 居住費軽減負担限度額段階List = 居住費軽減負担限度額段階ドロップダウンリスト();
        for (KeyValueDataSource keyValue : 居住費軽減負担限度額段階List) {
            if (!RString.isNullOrEmpty(居住費軽減負担限度額段階コード)
                    && 居住費軽減負担限度額段階コード.equals(keyValue.getKey())) {
                div.getDdlKyojuhiGendogakuDankai().setSelectedKey(居住費軽減負担限度額段階コード);
                div.getDdlKyojuhiGendogakuDankai().setSelectedValue(keyValue.getValue());
            }
        }
    }

    private void select食費軽減負担限度額段階(RString 食費軽減負担限度額段階コード) {
        List<KeyValueDataSource> 居住費軽減負担限度額段階List = 居住費軽減負担限度額段階ドロップダウンリスト();
        for (KeyValueDataSource keyValue : 居住費軽減負担限度額段階List) {
            if (!RString.isNullOrEmpty(食費軽減負担限度額段階コード)
                    && 食費軽減負担限度額段階コード.equals(keyValue.getKey())) {
                div.getDdlShokuhiGakenFutanGendogakuDankai().setSelectedKey(食費軽減負担限度額段階コード);
                div.getDdlShokuhiGakenFutanGendogakuDankai().setSelectedValue(keyValue.getValue());
            }
        }
    }

    private List<KeyValueDataSource> 居住費軽減後居室種類ドロップダウンリスト() {
        FlexibleDate 基準日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<UzT0007CodeEntity> dataSourceList = CodeMaster.getCode(SubGyomuCode.DBZ介護共通,
                DBZCodeShubetsu.居室種類.getコード(), 基準日);
        for (UzT0007CodeEntity entity : dataSourceList) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().getColumnValue());
            keyValue.setValue(entity.getコード名称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private void select居住費軽減後居室種類(RString 居住費軽減後居室種類コード) {
        List<KeyValueDataSource> 居住費軽減後居室種類List = 居住費軽減後居室種類ドロップダウンリスト();
        for (KeyValueDataSource keyValue : 居住費軽減後居室種類List) {
            if (!RString.isNullOrEmpty(居住費軽減後居室種類コード)
                    && 居住費軽減後居室種類コード.equals(keyValue.getKey())) {
                div.getDdlKyoshituShurui().setSelectedKey(居住費軽減後居室種類コード);
                div.getDdlKyoshituShurui().setSelectedValue(keyValue.getValue());
            }
        }
    }

    private void select読替後高額介護世帯上限額(RDate 申請日, RString 高額介護世帯上限額) {
        List<KeyValueDataSource> 高額介護世帯上限額List = 読替後高額介護世帯上限額ドロップダウンリスト(申請日);
        for (KeyValueDataSource keyValue : 高額介護世帯上限額List) {
            if (!RString.isNullOrEmpty(高額介護世帯上限額) && 高額介護世帯上限額.equals(keyValue.getKey())) {
                div.getDdlSeidaiJogengaku().setSelectedKey(高額介護世帯上限額);
                div.getDdlSeidaiJogengaku().setSelectedValue(keyValue.getValue());
            }
        }
    }

    private List<KeyValueDataSource> 読替後高額介護世帯上限額ドロップダウンリスト(RDate 申請日) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        RDate 適用基準日 = RDate.getNowDate();
        if (申請日.isBefore(申請年月日)) {
            KeyValueDataSource 第1段階 = new KeyValueDataSource();
            第1段階.setValue(読替後高額介護世帯上限額カンマ処理(ConfigNameDBC.第1段階_高額介護サービス費支給_自己負担上限月額, 適用基準日));
            第1段階.setKey(DbBusinessConfig.get(ConfigNameDBC.第1段階_高額介護サービス費支給_自己負担上限月額, 適用基準日, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第2段階 = new KeyValueDataSource();
            第2段階.setValue(読替後高額介護世帯上限額カンマ処理(ConfigNameDBC.第2段階_高額介護サービス費支給_自己負担上限月額, 適用基準日));
            第2段階.setKey(DbBusinessConfig.get(ConfigNameDBC.第2段階_高額介護サービス費支給_自己負担上限月額, 適用基準日, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第3段階 = new KeyValueDataSource();
            第3段階.setValue(読替後高額介護世帯上限額カンマ処理(ConfigNameDBC.第3段階_高額介護サービス費支給_自己負担上限月額, 適用基準日));
            第3段階.setKey(DbBusinessConfig.get(ConfigNameDBC.第3段階_高額介護サービス費支給_自己負担上限月額, 適用基準日, SubGyomuCode.DBC介護給付));
            dataSourceList.add(第1段階);
            dataSourceList.add(第2段階);
            dataSourceList.add(第3段階);
        } else {
            KeyValueDataSource 第1段階 = new KeyValueDataSource();
            第1段階.setValue(読替後高額介護世帯上限額カンマ処理(ConfigNameDBC.第1段階_高額介護サービス費支給_201504以降_自己負担上限月額, 適用基準日));
            第1段階.setKey(DbBusinessConfig.get(ConfigNameDBC.第1段階_高額介護サービス費支給_201504以降_自己負担上限月額, 適用基準日, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第2段階 = new KeyValueDataSource();
            第2段階.setValue(読替後高額介護世帯上限額カンマ処理(ConfigNameDBC.第2段階_高額介護サービス費支給_201504以降_自己負担上限月額, 適用基準日));
            第2段階.setKey(DbBusinessConfig.get(ConfigNameDBC.第2段階_高額介護サービス費支給_201504以降_自己負担上限月額, 適用基準日, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第3段階 = new KeyValueDataSource();
            第3段階.setValue(読替後高額介護世帯上限額カンマ処理(ConfigNameDBC.第3段階_高額介護サービス費支給_201504以降_自己負担上限月額, 適用基準日));
            第3段階.setKey(DbBusinessConfig.get(ConfigNameDBC.第3段階_高額介護サービス費支給_201504以降_自己負担上限月額, 適用基準日, SubGyomuCode.DBC介護給付));
            KeyValueDataSource 第4段階 = new KeyValueDataSource();
            第4段階.setValue(読替後高額介護世帯上限額カンマ処理(ConfigNameDBC.第4段階_高額介護サービス費支給_201504以降_自己負担上限月額, 適用基準日));
            第4段階.setKey(DbBusinessConfig.get(ConfigNameDBC.第4段階_高額介護サービス費支給_201504以降_自己負担上限月額, 適用基準日, SubGyomuCode.DBC介護給付));
            dataSourceList.add(第1段階);
            dataSourceList.add(第2段階);
            dataSourceList.add(第3段階);
            dataSourceList.add(第4段階);
        }
        return dataSourceList;
    }

    private RString 読替後高額介護世帯上限額カンマ処理(ConfigNameDBC con, RDate 適用基準日) {
        Decimal dec = new Decimal(DbBusinessConfig.get(con, 適用基準日, SubGyomuCode.DBC介護給付).toString());
        return DecimalFormatter.toコンマ区切りRString(dec, 0);
    }

    private List<KeyValueDataSource> 所得段階ドロップダウンリスト(RDate 申請日) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        List<HokenryoDankai> 所得段階 = HokenryoDankaiSettings.createInstance().
                get保険料段階ListIn(new FlexibleYear(申請日.getYear().toDateString())).asList();
        for (HokenryoDankai hokenryo : 所得段階) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(hokenryo.get段階Index());
            keyValue.setValue(hokenryo.get表記());
            dataSourceList.add(keyValue);
        }
        return dataSourceList;
    }

    private RString select所得段階(FlexibleDate 申請日, RString 段階インデックス) {
        if (申請日 == null || 申請日.isEmpty()) {
            return RString.EMPTY;
        }
        List<KeyValueDataSource> dataSourceList = 所得段階ドロップダウンリスト(new RDate(申請日.toString()));
        for (KeyValueDataSource keyValue : dataSourceList) {
            if (!RString.isNullOrEmpty(段階インデックス) && 段階インデックス.equals(keyValue.getKey())) {
                return keyValue.getValue();
            }
        }
        return RString.EMPTY;
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

    private Decimal nullToZero(Decimal obj) {
        if (obj == null) {
            return Decimal.ZERO;
        }
        return obj;
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null || obj.isEmpty()) {
            return RString.EMPTY;
        }
        return obj;
    }

    private RString get居住費軽減後居室種類(RString 居住費軽減後居室種類コード) {
        if (居住費軽減後居室種類コード == null || 居住費軽減後居室種類コード.isEmpty()) {
            return RString.EMPTY;
        }
        FlexibleDate 基准日 = new FlexibleDate(RDate.getNowDate().toDateString());
        return CodeMaster.getCodeMeisho(
                SubGyomuCode.DBZ介護共通,
                DBZCodeShubetsu.居室種類.getコード(),
                new Code(居住費軽減後居室種類コード), 基准日);
    }
}
