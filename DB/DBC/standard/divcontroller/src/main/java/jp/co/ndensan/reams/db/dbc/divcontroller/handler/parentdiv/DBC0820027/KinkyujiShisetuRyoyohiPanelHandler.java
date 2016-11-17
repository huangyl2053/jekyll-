/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面のハンドラクラスです
 *
 * @reamsid_L DBC-1030-060 xupeng
 */
public final class KinkyujiShisetuRyoyohiPanelHandler {

    private final KinkyujiShisetuRyoyohiPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 登録_削除 = new RString("登録_削除");
    private static final RString 確定する = new RString("Element1");
    private static final int 位置１ = 32;
    private static final int 位置２ = 64;
    private static final int 位置３ = 96;
    private static final int 位置４ = 128;
    private static final int 位置５ = 160;
    private static final int 位置６ = 192;
    private static final int 位置７ = 224;
    private static final int 位置８ = 256;
    private static final int 位置９ = 288;
    private static final int 位置１０ = 320;
    private static final int 位置１１ = 352;
    private static final int 位置１２ = 384;
    private static final int 位置１３ = 416;
    private static final int 位置１４ = 448;
    private static final int 位置１５ = 480;
    private static final int 位置１６ = 512;
    private static final int 位置１７ = 544;
    private static final int 位置１８ = 576;
    private static final int 位置１９ = 608;
    private static final int 位置２０ = 640;
    private static final int SIX = 6;
    private static final Comparator COMPARABLE = new Comparator<dgdKinkyujiShiseturyoyo_Row>() {
        @Override
        public int compare(dgdKinkyujiShiseturyoyo_Row o1, dgdKinkyujiShiseturyoyo_Row o2) {
            return -(Integer.parseInt(o1.getDefaultDataName21().toString())
                    - Integer.parseInt(o2.getDefaultDataName21().toString()));
        }
    };

    private KinkyujiShisetuRyoyohiPanelHandler(KinkyujiShisetuRyoyohiPanelDiv div) {
        this.div = div;
    }

    /**
     * 生成されたインタフェースを返します
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     * @return KinkyujiShisetuRyoyohiPanelHandler
     */
    public static KinkyujiShisetuRyoyohiPanelHandler of(KinkyujiShisetuRyoyohiPanelDiv div) {
        return new KinkyujiShisetuRyoyohiPanelHandler(div);
    }

    /**
     * 申請共通エリア
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 整理番号 RString
     * @param サービス年月 FlexibleYearMonth
     * @param 申請日 RDate
     * @param 事業者番号 JigyoshaNo
     * @param 明細番号 RString
     * @param 証明書 RString
     * @param 様式番号 RString
     * @param 識別コード ShikibetsuCode
     */
    public void initPanelHead(HihokenshaNo 被保険者番号,
            RString 整理番号,
            FlexibleYearMonth サービス年月,
            RDate 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書,
            RString 様式番号,
            ShikibetsuCode 識別コード) {
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);

        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);

    }

    /**
     * 緊急時施設療養費一覧
     *
     * @param list 償還払請求緊急時施設療養データ
     */
    public void initDgdKinkyujiShiseturyoyo(List<ShokanKinkyuShisetsuRyoyo> list) {
        List<dgdKinkyujiShiseturyoyo_Row> lists = new ArrayList<>();
        for (ShokanKinkyuShisetsuRyoyo result : list) {
            dgdKinkyujiShiseturyoyo_Row row = new dgdKinkyujiShiseturyoyo_Row();
            setRow(row, result);
            lists.add(row);
        }
        Collections.sort(lists, COMPARABLE);
        div.getDgdKinkyujiShiseturyoyo().setDataSource(lists);
    }

    private void setRow(dgdKinkyujiShiseturyoyo_Row row, ShokanKinkyuShisetsuRyoyo result) {
        row.setDefaultDataName1(result.get緊急時傷病名１());
        row.setDefaultDataName2(result.get緊急時傷病名２());
        row.setDefaultDataName3(result.get緊急時傷病名３());
        if (result.get緊急時治療開始年月日１() != null && !result.get緊急時治療開始年月日１().isEmpty()) {
            row.getDefaultDataName4().setValue(new RDate(result.get緊急時治療開始年月日１()
                    .wareki().toDateString().toString()));
        }
        if (result.get緊急時治療開始年月日２() != null && !result.get緊急時治療開始年月日２().isEmpty()) {
            row.getDefaultDataName5().setValue(new RDate(result.get緊急時治療開始年月日２()
                    .wareki().toDateString().toString()));
        }
        if (result.get緊急時治療開始年月日３() != null && !result.get緊急時治療開始年月日３().isEmpty()) {
            row.getDefaultDataName6().setValue(new RDate(result.get緊急時治療開始年月日３()
                    .wareki().toDateString().toString()));
        }

        row.getDefaultDataName7().setValue(new Decimal(result.get往診日数()));
        row.setDefaultDataName8(result.get往診医療機関名());
        row.getDefaultDataName9().setValue(new Decimal(result.get通院日数()));
        row.setDefaultDataName10(result.get通院医療機関名());

        row.getDefaultDataName11().setValue(new Decimal(result.get緊急時治療管理単位数()));
        row.getDefaultDataName12().setValue(new Decimal(result.get緊急時治療管理日数()));
        row.getDefaultDataName13().setValue(new Decimal(result.get緊急時治療管理小計()));
        row.getDefaultDataName14().setValue(new Decimal(result.get緊急時施設療養費合計単位数()));

        row.getDefaultDataName15().setValue(new Decimal(result.getリハビリテーション単位数()));
        row.getDefaultDataName16().setValue(new Decimal(result.get処置単位数()));
        row.getDefaultDataName17().setValue(new Decimal(result.get手術単位数()));
        row.getDefaultDataName18().setValue(new Decimal(result.get麻酔単位数()));
        row.getDefaultDataName19().setValue(new Decimal(result.get放射線治療単位数()));
        row.setDefaultDataName20(get摘要(result));
        row.setDefaultDataName21(result.get連番());
    }

    /**
     * 追加する設定
     */
    public void initAdd() {
        div.setRowId(RString.EMPTY);
        div.getBtnAdd().setDisabled(true);
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(false);
        div.getPanelShobyoName().setDisabled(false);
        div.getPanelOshinTsuyin().setDisabled(false);
        div.getPanelJiryoTensuu().setDisabled(false);
        div.getBtnClear().setDisabled(false);
        clear登録();
    }

    /**
     * 緊急時施設療養費登録
     *
     * @param row 緊急時施設療養費一覧
     */
    public void set登録(dgdKinkyujiShiseturyoyo_Row row) {
        div.getTxtKinkyuShobyoName1().setValue(row.getDefaultDataName1());
        div.getTxtKinkyuShobyoName2().setValue(row.getDefaultDataName2());
        div.getTxtKinkyuShobyoName3().setValue(row.getDefaultDataName3());
        div.getTxtKinkyuJiryoStartYMD1().setValue(row.getDefaultDataName4().getValue());
        div.getTxtKinkyuJiryoStartYMD2().setValue(row.getDefaultDataName5().getValue());
        div.getTxtKinkyuJiryoStartYMD3().setValue(row.getDefaultDataName6().getValue());

        div.getTxtOshinNissu().setValue(row.getDefaultDataName7().getValue());
        div.getTxtOshinYiryokikanName().setValue(row.getDefaultDataName8());
        div.getTxtTuyinNissu().setValue(row.getDefaultDataName9().getValue());
        div.getTxtTuyinYiryokikanName().setValue(row.getDefaultDataName10());
        div.getTxtTikiyo().setValue(row.getDefaultDataName20());

        div.getTxtkinkyuChiryoKanriTanisu().setValue(row.getDefaultDataName11().getValue());
        div.getTxtkinkyuChiryoKanriNissu().setValue(row.getDefaultDataName12().getValue());
        div.getTxtkinkyuChiryoKanriSubTotal().setValue(row.getDefaultDataName13().getValue());
        div.getTxtrehabilitationTanisu().setValue(row.getDefaultDataName15().getValue());
        div.getTxtShochiTanisu().setValue(row.getDefaultDataName16().getValue());
        div.getTxtshujutsuTanisu().setValue(row.getDefaultDataName17().getValue());
        div.getTxtMasuiTanisu().setValue(row.getDefaultDataName18().getValue());
        div.getTxtHoshasenChiryoTanisu().setValue(row.getDefaultDataName19().getValue());
        div.getTxtKinkyuShisetsuRyoyohiTotalTanisu().setValue(row.getDefaultDataName14().getValue());

    }

    /**
     * クリアする設定
     */
    public void clear登録() {
        div.getTxtKinkyuShobyoName1().clearValue();
        div.getTxtKinkyuShobyoName2().clearValue();
        div.getTxtKinkyuShobyoName3().clearValue();
        div.getTxtKinkyuJiryoStartYMD1().clearValue();
        div.getTxtKinkyuJiryoStartYMD2().clearValue();
        div.getTxtKinkyuJiryoStartYMD3().clearValue();

        div.getTxtOshinNissu().clearValue();
        div.getTxtOshinYiryokikanName().clearValue();
        div.getTxtTuyinNissu().clearValue();
        div.getTxtTuyinYiryokikanName().clearValue();
        div.getTxtTikiyo().clearValue();

        div.getTxtkinkyuChiryoKanriTanisu().clearValue();
        div.getTxtkinkyuChiryoKanriNissu().clearValue();
        div.getTxtkinkyuChiryoKanriSubTotal().clearValue();
        div.getTxtrehabilitationTanisu().clearValue();
        div.getTxtshujutsuTanisu().clearValue();
        div.getTxtHoshasenChiryoTanisu().clearValue();
        div.getTxtShochiTanisu().clearValue();
        div.getTxtMasuiTanisu().clearValue();
        div.getTxtKinkyuShisetsuRyoyohiTotalTanisu().clearValue();
    }

    /**
     * 計算する①
     */
    public void cal1() {
        Decimal data = null;
        Decimal num1 = div.getTxtkinkyuChiryoKanriTanisu().getValue();
        Decimal num2 = div.getTxtkinkyuChiryoKanriNissu().getValue();
        if (num1 != null && num2 != null) {
            data = num1.multiply(num2);
        }
        div.getTxtkinkyuChiryoKanriSubTotal().setValue(data);
    }

    /**
     * 計算する②
     */
    public void cal2() {
        Decimal data = new Decimal(0);
        if (div.getTxtrehabilitationTanisu().getValue() != null) {
            data = data.add(div.getTxtrehabilitationTanisu().getValue());
        }
        if (div.getTxtshujutsuTanisu().getValue() != null) {
            data = data.add(div.getTxtshujutsuTanisu().getValue());
        }
        if (div.getTxtHoshasenChiryoTanisu().getValue() != null) {
            data = data.add(div.getTxtHoshasenChiryoTanisu().getValue());
        }
        if (div.getTxtShochiTanisu().getValue() != null) {
            data = data.add(div.getTxtShochiTanisu().getValue());
        }
        if (div.getTxtMasuiTanisu().getValue() != null) {
            data = data.add(div.getTxtMasuiTanisu().getValue());
        }
        div.getTxtKinkyuShisetsuRyoyohiTotalTanisu().setValue(data);
    }

    private void confirm(dgdKinkyujiShiseturyoyo_Row row, RString state, List<ShokanKinkyuShisetsuRyoyo> dbList) {
        if (修正.equals(state)) {
            if (isデータ修正(row, dbList)) {
                row.setRowState(RowState.Modified);
            } else {
                row.setRowState(RowState.Unchanged);
            }
        } else if (削除.equals(state)) {
            row.setRowState(RowState.Deleted);
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
        } else if (登録_削除.equals(state)) {
            div.getDgdKinkyujiShiseturyoyo().getDataSource().remove(Integer.parseInt(div.getRowId().toString()));
            return;
        }

        row.setDefaultDataName1(div.getTxtKinkyuShobyoName1().getValue());
        row.setDefaultDataName2(div.getTxtKinkyuShobyoName2().getValue());
        row.setDefaultDataName3(div.getTxtKinkyuShobyoName3().getValue());
        row.getDefaultDataName4().setValue(div.getTxtKinkyuJiryoStartYMD1().getValue());
        row.getDefaultDataName5().setValue(div.getTxtKinkyuJiryoStartYMD2().getValue());
        row.getDefaultDataName6().setValue(div.getTxtKinkyuJiryoStartYMD3().getValue());

        row.getDefaultDataName7().setValue(div.getTxtOshinNissu().getValue());
        row.setDefaultDataName8(div.getTxtOshinYiryokikanName().getValue());
        row.getDefaultDataName9().setValue(div.getTxtTuyinNissu().getValue());
        row.setDefaultDataName10(div.getTxtTuyinYiryokikanName().getValue());

        row.getDefaultDataName11().setValue(div.getTxtkinkyuChiryoKanriTanisu().getValue());
        row.getDefaultDataName12().setValue(div.getTxtkinkyuChiryoKanriNissu().getValue());
        row.getDefaultDataName13().setValue(div.getTxtkinkyuChiryoKanriSubTotal().getValue());
        row.getDefaultDataName14().setValue(div.getTxtKinkyuShisetsuRyoyohiTotalTanisu().getValue());

        row.getDefaultDataName15().setValue(div.getTxtrehabilitationTanisu().getValue());
        row.getDefaultDataName16().setValue(div.getTxtShochiTanisu().getValue());
        row.getDefaultDataName17().setValue(div.getTxtshujutsuTanisu().getValue());
        row.getDefaultDataName18().setValue(div.getTxtMasuiTanisu().getValue());
        row.getDefaultDataName19().setValue(div.getTxtHoshasenChiryoTanisu().getValue());
        row.setDefaultDataName20(div.getTxtTikiyo().getValue());
    }

    private boolean isデータ修正(dgdKinkyujiShiseturyoyo_Row row, List<ShokanKinkyuShisetsuRyoyo> dbList) {
        for (ShokanKinkyuShisetsuRyoyo ryoyo : dbList) {
            if ((ryoyo.get連番().equals(row.getDefaultDataName21())
                    && (isDataHenkouAri1(ryoyo, row)
                    || ryoyo.get緊急時治療管理単位数() != formatDecimalToInteger(row.getDefaultDataName11().getValue())
                    || ryoyo.get緊急時治療管理日数() != formatDecimalToInteger(row.getDefaultDataName12().getValue())
                    || ryoyo.get緊急時治療管理小計() != formatDecimalToInteger(row.getDefaultDataName13().getValue())
                    || ryoyo.get緊急時施設療養費合計単位数() != formatDecimalToInteger(row.getDefaultDataName14().getValue())
                    || ryoyo.getリハビリテーション単位数() != formatDecimalToInteger(row.getDefaultDataName15().getValue())
                    || ryoyo.get処置単位数() != formatDecimalToInteger(row.getDefaultDataName16().getValue())
                    || ryoyo.get手術単位数() != formatDecimalToInteger(row.getDefaultDataName17().getValue())
                    || ryoyo.get麻酔単位数() != formatDecimalToInteger(row.getDefaultDataName18().getValue())
                    || ryoyo.get放射線治療単位数() != formatDecimalToInteger(row.getDefaultDataName19().getValue())
                    || !get摘要(ryoyo).equals(row.getDefaultDataName20()))) || row.getRowState() != RowState.Modified) {
                return true;
            }
        }
        return false;
    }

    private boolean isDataHenkouAri1(ShokanKinkyuShisetsuRyoyo ryoyo, dgdKinkyujiShiseturyoyo_Row row) {
        return !ryoyo.get緊急時傷病名１().equals(row.getDefaultDataName1())
                || !ryoyo.get緊急時傷病名２().equals(row.getDefaultDataName2())
                || !ryoyo.get緊急時傷病名３().equals(row.getDefaultDataName3())
                || !ryoyo.get緊急時治療開始年月日１().equals(formatRDateToFlexibleDate(row.getDefaultDataName4().getValue()))
                || !ryoyo.get緊急時治療開始年月日２().equals(formatRDateToFlexibleDate(row.getDefaultDataName5().getValue()))
                || !ryoyo.get緊急時治療開始年月日３().equals(formatRDateToFlexibleDate(row.getDefaultDataName6().getValue()))
                || ryoyo.get往診日数() != formatDecimalToInteger(row.getDefaultDataName7().getValue())
                || !ryoyo.get往診医療機関名().equals(row.getDefaultDataName8())
                || ryoyo.get通院日数() != formatDecimalToInteger(row.getDefaultDataName9().getValue())
                || !ryoyo.get通院医療機関名().equals(row.getDefaultDataName10());
    }

    private FlexibleDate formatRDateToFlexibleDate(RDate date) {
        if (date == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(date.toDateString());
    }

    private Integer formatDecimalToInteger(Decimal dec) {
        if (dec == null) {
            return 0;
        }
        return dec.intValue();
    }

    private RString get摘要(ShokanKinkyuShisetsuRyoyo ryoyo) {
        RStringBuilder builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(ryoyo.get摘要１())) {
            builder.append(ryoyo.get摘要１());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要２())) {
            builder.append(ryoyo.get摘要２());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要３())) {
            builder.append(ryoyo.get摘要３());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要４())) {
            builder.append(ryoyo.get摘要４());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要５())) {
            builder.append(ryoyo.get摘要５());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要６())) {
            builder.append(ryoyo.get摘要６());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要７())) {
            builder.append(ryoyo.get摘要７());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要８())) {
            builder.append(ryoyo.get摘要８());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要９())) {
            builder.append(ryoyo.get摘要９());
        }
        set摘要2(ryoyo, builder);
        if (builder.length() == 0) {
            return RString.EMPTY;
        }
        return builder.toRString();
    }

    private void set摘要2(ShokanKinkyuShisetsuRyoyo ryoyo, RStringBuilder builder) {
        if (!RString.isNullOrEmpty(ryoyo.get摘要１０())) {
            builder.append(ryoyo.get摘要１０());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１１())) {
            builder.append(ryoyo.get摘要１１());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１２())) {
            builder.append(ryoyo.get摘要１２());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１３())) {
            builder.append(ryoyo.get摘要１３());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１４())) {
            builder.append(ryoyo.get摘要１４());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１５())) {
            builder.append(ryoyo.get摘要１５());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１６())) {
            builder.append(ryoyo.get摘要１６());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１７())) {
            builder.append(ryoyo.get摘要１７());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１８())) {
            builder.append(ryoyo.get摘要１８());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要１９())) {
            builder.append(ryoyo.get摘要１９());
        }
        if (!RString.isNullOrEmpty(ryoyo.get摘要２０())) {
            builder.append(ryoyo.get摘要２０());
        }
    }

    /**
     * 内容変更状態
     *
     * @return boolean
     */
    public boolean get内容変更状態() {
        for (dgdKinkyujiShiseturyoyo_Row row : div.getDgdKinkyujiShiseturyoyo().getDataSource()) {
            if (RowState.Modified.equals(row.getRowState())
                    || RowState.Added.equals(row.getRowState())
                    || RowState.Deleted.equals(row.getRowState())) {
                return true;
            }
        }
        return false;
    }

    private ShokanKinkyuShisetsuRyoyo build摘要(ShokanKinkyuShisetsuRyoyo ryoyo, RString 摘要) {
        int length = 摘要.length();
        if (length <= 位置１) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要).build();
        }
        if (length > 位置１ && length <= 位置２) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, length))
                    .build();
        }
        if (length > 位置２ && length <= 位置３) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, length))
                    .build();
        }
        if (length > 位置３ && length <= 位置４) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, length))
                    .build();
        }
        if (length > 位置４ && length <= 位置５) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, length))
                    .build();
        }
        if (length > 位置５ && length <= 位置６) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, length))
                    .build();
        }
        if (length > 位置６ && length <= 位置７) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, length))
                    .build();
        }
        if (length > 位置７ && length <= 位置８) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, length))
                    .build();
        }

        ryoyo = build摘要2(ryoyo, length, 摘要);
        return ryoyo;
    }

    private ShokanKinkyuShisetsuRyoyo build摘要2(ShokanKinkyuShisetsuRyoyo ryoyo,
            int length, RString 摘要) {
        if (length > 位置８ && length <= 位置９) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, length))
                    .build();
        }
        if (length > 位置９ && length <= 位置１０) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, length))
                    .build();
        }
        if (length > 位置１０ && length <= 位置１１) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, length))
                    .build();
        }
        if (length > 位置１１ && length <= 位置１２) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, length))
                    .build();
        }
        if (length > 位置１２ && length <= 位置１３) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, length))
                    .build();
        }
        if (length > 位置１３ && length <= 位置１４) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, 位置１３))
                    .set摘要１４(摘要.substring(位置１３, length))
                    .build();
        }
        ryoyo = build摘要3(ryoyo, length, 摘要);
        return ryoyo;
    }

    private ShokanKinkyuShisetsuRyoyo build摘要3(ShokanKinkyuShisetsuRyoyo ryoyo,
            int length, RString 摘要) {
        if (length > 位置１４ && length <= 位置１５) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, 位置１３))
                    .set摘要１４(摘要.substring(位置１３, 位置１４))
                    .set摘要１５(摘要.substring(位置１４, length))
                    .build();
        }
        if (length > 位置１５ && length <= 位置１６) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, 位置１３))
                    .set摘要１４(摘要.substring(位置１３, 位置１４))
                    .set摘要１５(摘要.substring(位置１４, 位置１５))
                    .set摘要１６(摘要.substring(位置１５, length))
                    .build();
        }
        if (length > 位置１６ && length <= 位置１７) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, 位置１３))
                    .set摘要１４(摘要.substring(位置１３, 位置１４))
                    .set摘要１５(摘要.substring(位置１４, 位置１５))
                    .set摘要１６(摘要.substring(位置１５, 位置１６))
                    .set摘要１７(摘要.substring(位置１６, length))
                    .build();
        }
        if (length > 位置１７ && length <= 位置１８) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, 位置１３))
                    .set摘要１４(摘要.substring(位置１３, 位置１４))
                    .set摘要１５(摘要.substring(位置１４, 位置１５))
                    .set摘要１６(摘要.substring(位置１５, 位置１６))
                    .set摘要１７(摘要.substring(位置１６, 位置１７))
                    .set摘要１８(摘要.substring(位置１７, length))
                    .build();
        }
        if (length > 位置１８ && length <= 位置１９) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, 位置１３))
                    .set摘要１４(摘要.substring(位置１３, 位置１４))
                    .set摘要１５(摘要.substring(位置１４, 位置１５))
                    .set摘要１６(摘要.substring(位置１５, 位置１６))
                    .set摘要１７(摘要.substring(位置１６, 位置１７))
                    .set摘要１８(摘要.substring(位置１７, 位置１８))
                    .set摘要１９(摘要.substring(位置１８, length))
                    .build();
        }
        if (length > 位置１９ && length <= 位置２０) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, 位置１３))
                    .set摘要１４(摘要.substring(位置１３, 位置１４))
                    .set摘要１５(摘要.substring(位置１４, 位置１５))
                    .set摘要１６(摘要.substring(位置１５, 位置１６))
                    .set摘要１７(摘要.substring(位置１６, 位置１７))
                    .set摘要１８(摘要.substring(位置１７, 位置１８))
                    .set摘要１９(摘要.substring(位置１８, 位置１９))
                    .set摘要２０(摘要.substring(位置１９, length))
                    .build();
        }
        if (length > 位置２０) {
            ryoyo = ryoyo.createBuilderForEdit().set摘要１(摘要.substring(0, 位置１))
                    .set摘要２(摘要.substring(位置１, 位置２))
                    .set摘要３(摘要.substring(位置２, 位置３))
                    .set摘要４(摘要.substring(位置３, 位置４))
                    .set摘要５(摘要.substring(位置４, 位置５))
                    .set摘要６(摘要.substring(位置５, 位置６))
                    .set摘要７(摘要.substring(位置６, 位置７))
                    .set摘要８(摘要.substring(位置７, 位置８))
                    .set摘要９(摘要.substring(位置８, 位置９))
                    .set摘要１０(摘要.substring(位置９, 位置１０))
                    .set摘要１１(摘要.substring(位置１０, 位置１１))
                    .set摘要１２(摘要.substring(位置１１, 位置１２))
                    .set摘要１３(摘要.substring(位置１２, 位置１３))
                    .set摘要１４(摘要.substring(位置１３, 位置１４))
                    .set摘要１５(摘要.substring(位置１４, 位置１５))
                    .set摘要１６(摘要.substring(位置１５, 位置１６))
                    .set摘要１７(摘要.substring(位置１６, 位置１７))
                    .set摘要１８(摘要.substring(位置１７, 位置１８))
                    .set摘要１９(摘要.substring(位置１８, 位置１９))
                    .set摘要２０(摘要.substring(位置１９, 位置２０))
                    .build();
        }
        return ryoyo;
    }

    /**
     * ボタン表示制御処理
     *
     * @param entity ShikibetsuNoKanri
     * @param count 基本情報件数
     */
    public void getボタンを制御(ShikibetsuNoKanri entity, int count) {
        if (設定不可.equals(entity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(entity.get基本設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }

        if (設定不可.equals(entity.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(entity.get明細設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }

        if (設定不可.equals(entity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        } else if (設定可必須.equals(entity.get特定診療費設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }

        getボタンを制御2(entity, count);
        getボタンを制御3(entity, count);
    }

    private void getボタンを制御2(ShikibetsuNoKanri entity, int count) {
        if (設定不可.equals(entity.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(entity.get居宅計画費設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }

        if (設定不可.equals(entity.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        } else if (設定可必須.equals(entity.get特定入所者設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
        }

        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);

        if (設定不可.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        } else if (設定可必須.equals(entity.get明細住所地特例設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }
    }

    private void getボタンを制御3(ShikibetsuNoKanri entity, int count) {
        if (設定不可.equals(entity.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(entity.get緊急時施設療養設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }

        if (設定不可.equals(entity.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(entity.get食事費用設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
        }

        if (設定不可.equals(entity.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(entity.get集計設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }

        if (設定不可.equals(entity.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        } else if (設定可必須.equals(entity.get社会福祉法人軽減設定区分())) {
            if (count != 0) {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * 選択行
     *
     * @return dgdKinkyujiShiseturyoyo_Row
     */
    public dgdKinkyujiShiseturyoyo_Row getSelectedRow() {
        return div.getDgdKinkyujiShiseturyoyo().getDataSource().get(Integer.parseInt(div.getRowId().toString()));
    }

    /**
     * Parameterに以下の情報を設定する
     *
     * @return ShoukanharaihishinseimeisaikensakuParameter
     */
    public ShoukanharaihishinseimeisaikensakuParameter setParameter() {
        FlexibleYearMonth サービス年月 = FlexibleYearMonth.EMPTY;
        RDate 申請日 = null;
        JigyoshaNo 事業者番号 = JigyoshaNo.EMPTY;
        RString 様式番号 = RString.EMPTY;
        RString 明細番号 = RString.EMPTY;
        if (div.getPanelHead().getTxtServiceTeikyoYM() != null) {
            サービス年月 = new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getValue().
                    toDateString().substring(0, SIX));
        }
        if (div.getPanelHead().getTxtShinseiYMD() != null) {
            申請日 = div.getPanelHead().getTxtShinseiYMD().getValue();
        }
        if (div.getPanelHead().getTxtJigyoshaBango() != null) {
            事業者番号 = new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue());
        }
        if (div.getPanelHead().getTxtShomeisho() != null) {
            様式番号 = div.getPanelHead().getTxtShomeisho().getValue();
        }
        if (div.getPanelHead().getTxtMeisaiBango().getValue() != null) {
            明細番号 = div.getPanelHead().getTxtMeisaiBango().getValue();
        }
        ShoukanharaihishinseimeisaikensakuParameter parameter = new ShoukanharaihishinseimeisaikensakuParameter(
                null,
                サービス年月,
                申請日,
                null,
                事業者番号,
                様式番号,
                明細番号);
        return parameter;
    }

    /**
     * 削除初期化
     */
    public void init_Delete() {
        div.getBtnAdd().setDisabled(true);
        div.getDgdKinkyujiShiseturyoyo().setReadOnly(true);
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(確定する, true);
    }

    /**
     * 新規修正モード初期化
     */
    public void init_Added() {
        div.getBtnAdd().setDisabled(false);
        div.getDgdKinkyujiShiseturyoyo().setReadOnly(false);
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(確定する, false);
    }

    /**
     * 「修正ボタン」押下設置
     */
    public void click_Modify() {
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(false);
        div.getPanelShobyoName().setDisabled(false);
        div.getPanelOshinTsuyin().setDisabled(false);
        div.getPanelJiryoTensuu().setDisabled(false);
        div.getBtnClear().setDisabled(false);
        div.setRowId(new RString(String.valueOf(div.getDgdKinkyujiShiseturyoyo().getClickedRowId())));
    }

    /**
     * 「削除ボタン」押下設置
     */
    public void click_Delete() {
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(false);
        div.getPanelShobyoName().setDisabled(true);
        div.getPanelOshinTsuyin().setDisabled(true);
        div.getPanelJiryoTensuu().setDisabled(true);
        div.getBtnClear().setDisabled(true);
        div.setRowId(new RString(String.valueOf(div.getDgdKinkyujiShiseturyoyo().getClickedRowId())));
    }

    /**
     * 「取消ボタン」押下設置
     */
    public void click_Cancel() {
        div.getBtnAdd().setDisabled(false);
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
    }

    /**
     * 「確定ボタン」押下設置
     *
     * @param state 状態
     * @param renban 連番
     * @param dbList ShokanKinkyuShisetsuRyoyo
     * @return is追加
     */
    public boolean click_Confirm(RString state, int renban, List<ShokanKinkyuShisetsuRyoyo> dbList) {
        div.getBtnAdd().setDisabled(false);
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
        boolean is追加 = false;
        List<dgdKinkyujiShiseturyoyo_Row> list = div.getDgdKinkyujiShiseturyoyo().getDataSource();
        if (登録.equals(state)) {
            if (!RString.EMPTY.equals(div.getRowId())) {
                dgdKinkyujiShiseturyoyo_Row row = getSelectedRow();
                confirm(row, state, dbList);
                list.set(Integer.parseInt(div.getRowId().toString()), row);
            } else {
                is追加 = true;
                dgdKinkyujiShiseturyoyo_Row row = new dgdKinkyujiShiseturyoyo_Row();
                row.setDefaultDataName21(new RString(renban + 1));
                confirm(row, state, dbList);
                list.add(row);
            }
        } else if (登録_削除.equals(state)) {
            dgdKinkyujiShiseturyoyo_Row row = getSelectedRow();
            confirm(row, state, dbList);
        } else {
            dgdKinkyujiShiseturyoyo_Row row = getSelectedRow();
            confirm(row, state, dbList);
            list.set(Integer.parseInt(div.getRowId().toString()), row);
        }
        Collections.sort(list, COMPARABLE);
        div.getDgdKinkyujiShiseturyoyo().setDataSource(list);
        return is追加;
    }

    /**
     * 入力チェック
     *
     * @return isデータ変更
     */
    public boolean isデータ変更() {
        for (dgdKinkyujiShiseturyoyo_Row row : div.getDgdKinkyujiShiseturyoyo().getDataSource()) {
            if (RowState.Unchanged != row.getRowState()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 最大連番を取る
     *
     * @param list {@link ShokanKinkyuShisetsuRyoyo}のリスト
     * @return 最大連番
     */
    public int get最大連番(List<ShokanKinkyuShisetsuRyoyo> list) {
        int renban = 0;
        for (ShokanKinkyuShisetsuRyoyo shokanKinyuShisetsuRyoyo : list) {
            int renbanlist = Integer.parseInt(shokanKinyuShisetsuRyoyo.get連番().toString());
            if (renbanlist - renban > 0) {
                renban = renbanlist;
            }
        }
        return renban;
    }

    /**
     * 更新リストを取る
     *
     * @param list {@link ShokanKinkyuShisetsuRyoyo}リスト
     * @param parameter ShoukanharaihishinseimeisaikensakuParameter
     * @param updateList ShokanKinkyuShisetsuRyoyo
     * @return 更新リスト
     */
    public List<ShokanKinkyuShisetsuRyoyo> get更新リスト(
            List<ShokanKinkyuShisetsuRyoyo> list, ShoukanharaihishinseimeisaikensakuParameter parameter,
            List<ShokanKinkyuShisetsuRyoyo> updateList) {
        List<dgdKinkyujiShiseturyoyo_Row> rowList = div.getDgdKinkyujiShiseturyoyo().getDataSource();
        List<dgdKinkyujiShiseturyoyo_Row> addedRowList = new ArrayList<>();
        List<dgdKinkyujiShiseturyoyo_Row> updateRowList = new ArrayList<>();
        List<dgdKinkyujiShiseturyoyo_Row> deletedRowList = new ArrayList<>();
        for (dgdKinkyujiShiseturyoyo_Row row : rowList) {
            if (row.getRowState() == RowState.Added) {
                addedRowList.add(row);
            }
            if (row.getRowState() == RowState.Deleted) {
                deletedRowList.add(row);
            }
            if (row.getRowState() == RowState.Modified) {
                updateRowList.add(row);
            }
        }

        for (ShokanKinkyuShisetsuRyoyo ryoyo : list) {
            for (dgdKinkyujiShiseturyoyo_Row updateRow : updateRowList) {
                if (ryoyo.get連番().equals(updateRow.getDefaultDataName21())) {
                    ryoyo = set償還払請求緊急時施設療養(ryoyo, updateRow);
                    ryoyo = ryoyo.modified();
                    updateList.add(ryoyo);
                }
            }
            for (dgdKinkyujiShiseturyoyo_Row deletedRow : deletedRowList) {
                if (ryoyo.get連番().equals(deletedRow.getDefaultDataName21())) {
                    ryoyo = ryoyo.deleted();
                    updateList.add(ryoyo);
                }
            }
        }
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getPanelCcd().getCcdKaigoShikakuKihon().get被保険者番号());
        FlexibleYearMonth サービス提供年月 = FlexibleYearMonth.EMPTY;
        if (div.getPanelHead().getTxtServiceTeikyoYM().getValue() != null) {
            サービス提供年月 = new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getValue().
                    toDateString().substring(0, SIX));
        }
        RString 整理番号 = parameter.get整理番号();
        JigyoshaNo 事業者番号 = parameter.get事業者番号();
        RString 様式番号 = parameter.get様式番号();
        RString 明細番号 = parameter.get明細番号();
        for (dgdKinkyujiShiseturyoyo_Row addedRow : addedRowList) {
            ShokanKinkyuShisetsuRyoyo ryoyo = new ShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, addedRow.getDefaultDataName21());
            ryoyo = set償還払請求緊急時施設療養(ryoyo, addedRow);
            updateList.add(ryoyo);
        }
        return updateList;
    }

    private ShokanKinkyuShisetsuRyoyo set償還払請求緊急時施設療養(
            ShokanKinkyuShisetsuRyoyo ryoyo, dgdKinkyujiShiseturyoyo_Row updateRow) {
        ryoyo = ryoyo.createBuilderForEdit()
                .set緊急時傷病名１(updateRow.getDefaultDataName1())
                .set緊急時傷病名２(updateRow.getDefaultDataName2())
                .set緊急時傷病名３(updateRow.getDefaultDataName3())
                .set緊急時治療開始年月日１(updateRow.getDefaultDataName4().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(updateRow.getDefaultDataName4().getValue().toDateString()))
                .set緊急時治療開始年月日２(updateRow.getDefaultDataName5().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(updateRow.getDefaultDataName5().getValue().toDateString()))
                .set緊急時治療開始年月日３(updateRow.getDefaultDataName6().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(updateRow.getDefaultDataName6().getValue().toDateString()))
                .set往診医療機関名(updateRow.getDefaultDataName8())
                .set通院医療機関名(updateRow.getDefaultDataName10())
                .build();
        if (updateRow.getDefaultDataName7().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set往診日数(updateRow.getDefaultDataName7().getValue().intValue())
                    .build();
        }
        if (updateRow.getDefaultDataName9().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set通院日数(updateRow.getDefaultDataName7().getValue().intValue())
                    .build();
        }
        if (updateRow.getDefaultDataName11().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set緊急時治療管理単位数(updateRow.getDefaultDataName11().getValue().intValue())
                    .build();
        }

        if (updateRow.getDefaultDataName12().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set緊急時治療管理日数(updateRow.getDefaultDataName12().getValue().intValue())
                    .build();
        }
        ryoyo = set緊急時施設療養Data(updateRow, ryoyo);
        RString 摘要 = updateRow.getDefaultDataName20();
        ryoyo = build摘要(ryoyo, 摘要);
        return ryoyo;
    }

    private ShokanKinkyuShisetsuRyoyo set緊急時施設療養Data(dgdKinkyujiShiseturyoyo_Row updateRow, ShokanKinkyuShisetsuRyoyo ryoyo) {
        if (updateRow.getDefaultDataName13().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set緊急時治療管理小計(updateRow.getDefaultDataName13().getValue().intValue())
                    .build();
        }
        if (updateRow.getDefaultDataName15().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .setリハビリテーション単位数(updateRow.getDefaultDataName15().getValue().intValue())
                    .build();
        }
        if (updateRow.getDefaultDataName16().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set処置単位数(updateRow.getDefaultDataName16().getValue().intValue())
                    .build();
        }
        if (updateRow.getDefaultDataName17().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set手術単位数(updateRow.getDefaultDataName17().getValue().intValue())
                    .build();
        }
        if (updateRow.getDefaultDataName18().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set麻酔単位数(updateRow.getDefaultDataName18().getValue().intValue())
                    .build();
        }
        if (updateRow.getDefaultDataName19().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set放射線治療単位数(updateRow.getDefaultDataName19().getValue().intValue())
                    .build();
        }
        if (updateRow.getDefaultDataName14().getValue() != null) {
            ryoyo = ryoyo.createBuilderForEdit()
                    .set緊急時施設療養費合計単位数(updateRow.getDefaultDataName14().getValue().intValue())
                    .build();
        }
        return ryoyo;
    }

    /**
     * 緊急時施設療養費一覧
     *
     * @param list ShokanKinkyuShisetsuRyoyo
     * @param updateList ShokanKinkyuShisetsuRyoyo
     * @param map Map
     * @return ShokanKinkyuShisetsuRyoyo
     */
    public List<ShokanKinkyuShisetsuRyoyo> setRealList(
            List<ShokanKinkyuShisetsuRyoyo> list, List<ShokanKinkyuShisetsuRyoyo> updateList,
            Map<RString, RString> map) {
        List<dgdKinkyujiShiseturyoyo_Row> rowList = new ArrayList<>();
        List<ShokanKinkyuShisetsuRyoyo> realList = new ArrayList<>();
        for (Map.Entry<RString, RString> mapValue : map.entrySet()) {
            dgdKinkyujiShiseturyoyo_Row row = new dgdKinkyujiShiseturyoyo_Row();
            boolean isModifiedorDeleted = false;
            for (ShokanKinkyuShisetsuRyoyo updateRyoyo : updateList) {
                if (mapValue.getKey().equals(updateRyoyo.get連番())) {
                    setRow(row, updateRyoyo);
                    RowState rowState = RowState.valueOf(mapValue.getValue().toString());
                    if (rowState == RowState.Modified || rowState == RowState.Deleted) {
                        isModifiedorDeleted = true;
                    }
                    row.setRowState(rowState);
                    rowList.add(row);
                    realList.add(updateRyoyo);
                    break;
                }
            }
            if (!isModifiedorDeleted) {
                for (ShokanKinkyuShisetsuRyoyo result : list) {
                    if (mapValue.getKey().equals(result.get連番())) {
                        setRow(row, result);
                        row.setRowState(RowState.valueOf(mapValue.getValue().toString()));
                        rowList.add(row);
                        realList.add(result);
                        break;
                    }
                }
            }
        }
        Collections.sort(rowList, COMPARABLE);
        div.getDgdKinkyujiShiseturyoyo().setDataSource(rowList);
        return realList;
    }

    /**
     * データグリッドについてのMapを取る
     *
     * @return map
     */
    public Map<RString, RString> getDataGridMap() {
        Map<RString, RString> map = new HashMap<>();
        for (dgdKinkyujiShiseturyoyo_Row row : div.getDgdKinkyujiShiseturyoyo().getDataSource()) {
            map.put(row.getDefaultDataName21(), new RString(row.getRowState().name()));
        }
        return map;
    }

    /**
     * 確定するボタンをクリックする前のチェック処理
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public List<ValidationMessageControlPairs> checkKakutei() {
        List<ValidationMessageControlPairs> checkout = new ArrayList<>();
        KinkyujiShisetuRyoyohiPanelValidationHandler checkHandler = new KinkyujiShisetuRyoyohiPanelValidationHandler(div);
        checkout.add(checkHandler.validateチェック());
        return checkout;
    }

    /**
     * 基本情報を取る
     *
     * @param kihon ShokanKihon
     * @return 基本情報
     */
    public ShokanKihon set基本情報(ShokanKihon kihon) {
        if (kihon == null) {
            return null;
        }
        Decimal 金額合計 = Decimal.ZERO;
        List<dgdKinkyujiShiseturyoyo_Row> rowList = div.getDgdKinkyujiShiseturyoyo().getDataSource();
        for (dgdKinkyujiShiseturyoyo_Row row : rowList) {
            if (row.getRowState() != RowState.Deleted) {
                金額合計 = 金額合計.add(null == row.getDefaultDataName14().getValue()
                        ? Decimal.ZERO : row.getDefaultDataName14().getValue());
            }
        }
        kihon = kihon.createBuilderForEdit().set緊急時施設療養費請求額(金額合計).build();
        kihon = kihon.modified();
        return kihon;
    }

    /**
     * 該当データを取得します。
     *
     * @param allList ShokanKinkyuShisetsuRyoyo
     * @param parameter ShoukanharaihishinseimeisaikensakuParameter
     * @return List<ShokanKinkyuShisetsuRyoyo>
     */
    public List<ShokanKinkyuShisetsuRyoyo> getUpdateList(
            List<ShokanKinkyuShisetsuRyoyo> allList, ShoukanharaihishinseimeisaikensakuParameter parameter) {
        List<ShokanKinkyuShisetsuRyoyo> updateList = new ArrayList<>();
        for (ShokanKinkyuShisetsuRyoyo ryoyo : allList) {
            if (ryoyo.get被保険者番号().equals(parameter.get被保険者番号())
                    && ryoyo.getサービス提供年月().equals(parameter.getサービス年月())
                    && ryoyo.get整理番号().equals(parameter.get整理番号())
                    && ryoyo.get事業者番号().equals(parameter.get事業者番号())
                    && ryoyo.get様式番号().equals(parameter.get様式番号())
                    && ryoyo.get明細番号().equals(parameter.get明細番号())) {
                updateList.add(ryoyo);
            }
        }
        return updateList;
    }

    /**
     * 基本情報のMapを取る
     *
     * @param kihonList ShokanKihon
     * @param kensakuParameter ShoukanharaihishinseimeisaikensakuParameter
     * @return Map
     */
    public Map<Integer, ShokanKihon> getShokanKihonMap(
            List<ShokanKihon> kihonList, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        Map<Integer, ShokanKihon> map = new HashMap<>();
        for (int i = 0; i < kihonList.size(); i++) {
            ShokanKihon kihon = kihonList.get(i);
            if (kensakuParameter.get被保険者番号().equals(kihon.get被保険者番号())
                    && kensakuParameter.getサービス年月().equals(kihon.getサービス提供年月())
                    && kensakuParameter.get事業者番号().equals(kihon.get事業者番号())
                    && kensakuParameter.get整理番号().equals(kihon.get整理番号())
                    && kensakuParameter.get明細番号().equals(kihon.get明細番号())
                    && kensakuParameter.get様式番号().equals(kihon.get様式番号())) {
                map.put(i, kihon);
            }
        }
        return map;
    }

    /**
     * 該当データ以外の更新リストを取る
     *
     * @param updateList ShokanKinkyuShisetsuRyoyo
     * @param kensakuParameter ShoukanharaihishinseimeisaikensakuParameter
     * @return updateList
     */
    public List<ShokanKinkyuShisetsuRyoyo> removeLastData(
            List<ShokanKinkyuShisetsuRyoyo> updateList, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        for (int i = 0; i < updateList.size(); i++) {
            ShokanKinkyuShisetsuRyoyo ryoyo = updateList.get(i);
            if (ryoyo.get被保険者番号().equals(kensakuParameter.get被保険者番号())
                    && ryoyo.getサービス提供年月().equals(kensakuParameter.getサービス年月())
                    && ryoyo.get整理番号().equals(kensakuParameter.get整理番号())
                    && ryoyo.get事業者番号().equals(kensakuParameter.get事業者番号())
                    && ryoyo.get様式番号().equals(kensakuParameter.get様式番号())
                    && ryoyo.get明細番号().equals(kensakuParameter.get明細番号())) {
                updateList.remove(i);
            }
        }
        return updateList;
    }

}
