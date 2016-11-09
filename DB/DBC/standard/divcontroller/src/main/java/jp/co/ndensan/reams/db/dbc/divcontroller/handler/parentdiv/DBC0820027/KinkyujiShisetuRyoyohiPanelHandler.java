/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyoBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
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
    private static final int ZERO = 0;

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
     * @return ArrayList<ShokanKinkyuShisetsuRyoyo>
     */
    public ArrayList<ShokanKinkyuShisetsuRyoyo> initPanelHead(HihokenshaNo 被保険者番号,
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

        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        ArrayList<ShokanKinkyuShisetsuRyoyo> list = (ArrayList<ShokanKinkyuShisetsuRyoyo>) finder.
                getKinkyujiShisetsuRyoyoData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        return list;
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
            row.setDefaultDataName1(result.get緊急時傷病名１());
            row.setDefaultDataName2(result.get緊急時傷病名２());
            row.setDefaultDataName3(result.get緊急時傷病名３());
            if (result.get緊急時治療開始年月日１() != null) {
                row.getDefaultDataName4().setValue(new RDate(result.get緊急時治療開始年月日１()
                        .wareki().toDateString().toString()));
            }
            if (result.get緊急時治療開始年月日２() != null) {
                row.getDefaultDataName5().setValue(new RDate(result.get緊急時治療開始年月日２()
                        .wareki().toDateString().toString()));
            }
            if (result.get緊急時治療開始年月日３() != null) {
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
            lists.add(row);
        }
        div.getDgdKinkyujiShiseturyoyo().setDataSource(lists);
    }

    private RString get摘要(ShokanKinkyuShisetsuRyoyo result) {
        RStringBuilder tekiyou = new RStringBuilder("");
        tekiyou.append(result.get摘要１()).append(result.get摘要２()).
                append(result.get摘要３()).append(result.get摘要４()).
                append(result.get摘要５()).append(result.get摘要６()).
                append(result.get摘要７()).append(result.get摘要８()).
                append(result.get摘要９()).append(result.get摘要１０()).
                append(result.get摘要１１()).append(result.get摘要１２()).
                append(result.get摘要１３()).append(result.get摘要１４()).
                append(result.get摘要１５()).append(result.get摘要１６()).
                append(result.get摘要１７()).append(result.get摘要１８()).
                append(result.get摘要１９()).append(result.get摘要２０());
        return tekiyou.toRString();
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

    private void confirm(dgdKinkyujiShiseturyoyo_Row row, RString state) {
        if (修正.equals(state)) {
            row.setRowState(RowState.Modified);
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

    /**
     * 申請を保存する設定
     *
     * @param keys ShoukanharaihishinseimeisaikensakuParameter
     * @param 処理モード RString
     * @param shokanKinkyuShisetsuRyoyoList List<ShokanKinkyuShisetsuRyoyo>
     */
    public void 保存処理(ShoukanharaihishinseimeisaikensakuParameter keys,
            RString 処理モード, List<ShokanKinkyuShisetsuRyoyo> shokanKinkyuShisetsuRyoyoList) {
        JigyoshaNo 事業者番号 = keys.get事業者番号();
        RString 様式番号 = keys.get様式番号();
        HihokenshaNo 被保険者番号 = keys.get被保険者番号();
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().
                getValue().toDateString().substring(0, SIX));
        RString 整理番号 = keys.get整理番号();
        RString 明細番号 = keys.get明細番号();
        if (削除.equals(処理モード)) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(
                    被保険者番号, 提供購入年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            int max連番 = 0;
            Map<RString, ShokanKinkyuShisetsuRyoyo> map = new HashMap<>();
            for (ShokanKinkyuShisetsuRyoyo entity : shokanKinkyuShisetsuRyoyoList) {
                map.put(entity.get連番(), entity);
                if (max連番 < Integer.valueOf(entity.get連番().toString())) {
                    max連番 = Integer.valueOf(entity.get連番().toString());
                }
            }

            List<ShokanKinkyuShisetsuRyoyo> list = new ArrayList<>();

            for (dgdKinkyujiShiseturyoyo_Row row : div.getDgdKinkyujiShiseturyoyo().getDataSource()) {
                if (RowState.Added == row.getRowState()) {
                    max連番 = max連番 + 1;
                    ShokanKinkyuShisetsuRyoyo entity = new ShokanKinkyuShisetsuRyoyo(
                            被保険者番号, 提供購入年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                            new RString(String.format("%02d", max連番)));
                    entity = entity.added();
                    entity = buildEntity(entity, row);
                    list.add(entity);
                } else if (RowState.Modified == row.getRowState()) {
                    ShokanKinkyuShisetsuRyoyo entityModified = map.get(row.getDefaultDataName21());
                    entityModified = entityModified.modified();
                    entityModified = buildEntity(entityModified, row);
                    list.add(entityModified);
                } else if (RowState.Deleted == row.getRowState()) {
                    ShokanKinkyuShisetsuRyoyo entityDeleted = map.get(row.getDefaultDataName21());
                    entityDeleted = entityDeleted.deleted();
                    list.add(entityDeleted);
                } else {
                    list.add(map.get(row.getDefaultDataName21()));
                }
            }
            RString 証明書コード = div.getPanelHead().getTxtShomeisho().getValue();

            ShokanKihonParameter parameter = ShokanKihonParameter.
                    createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号, 事業者番号, 証明書コード, 明細番号, 0);
            SyokanbaraihiShikyuShinseiKetteManager manager = SyokanbaraihiShikyuShinseiKetteManager.createInstance();
            manager.updShokanKinkyuShisetsuRyoyo(parameter, list);
        }
    }

    private ShokanKinkyuShisetsuRyoyo buildEntity(ShokanKinkyuShisetsuRyoyo entity, dgdKinkyujiShiseturyoyo_Row row) {
        ShokanKinkyuShisetsuRyoyoBuilder builder = entity.createBuilderForEdit();
        builder = clear2(builder);
        builder.set緊急時傷病名１(row.getDefaultDataName1());
        builder.set緊急時傷病名２(row.getDefaultDataName2());
        builder.set緊急時傷病名３(row.getDefaultDataName3());

        if (row.getDefaultDataName4().getValue() != null) {
            builder.set緊急時治療開始年月日１(new FlexibleDate(row.getDefaultDataName4().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getDefaultDataName5().getValue() != null) {
            builder.set緊急時治療開始年月日２(new FlexibleDate(row.getDefaultDataName5().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getDefaultDataName6().getValue() != null) {
            builder.set緊急時治療開始年月日３(new FlexibleDate(row.getDefaultDataName6().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getDefaultDataName7().getValue() != null) {
            builder.set往診日数(Integer.valueOf(row.getDefaultDataName7().getValue().toString()));
        }
        builder.set往診医療機関名(row.getDefaultDataName8());

        if (row.getDefaultDataName9().getValue() != null) {
            builder.set通院日数(Integer.valueOf(row.getDefaultDataName9().getValue().toString()));
        }
        builder.set通院医療機関名(row.getDefaultDataName10());

        if (row.getDefaultDataName11().getValue() != null) {
            builder.set緊急時治療管理単位数(Integer.valueOf(row.getDefaultDataName11().getValue().toString()));
        }

        if (row.getDefaultDataName12().getValue() != null) {
            builder.set緊急時治療管理日数(Integer.valueOf(row.getDefaultDataName12().getValue().toString()));
        }

        if (row.getDefaultDataName13().getValue() != null) {
            builder.set緊急時治療管理小計(Integer.valueOf(row.getDefaultDataName13().getValue().toString()));
        }

        if (row.getDefaultDataName15().getValue() != null) {
            builder.setリハビリテーション単位数(Integer.valueOf(row.getDefaultDataName15().getValue().toString()));
        }

        if (row.getDefaultDataName16().getValue() != null) {
            builder.set処置単位数(Integer.valueOf(row.getDefaultDataName16().getValue().toString()));
        }

        if (row.getDefaultDataName17().getValue() != null) {
            builder.set手術単位数(Integer.valueOf(row.getDefaultDataName17().getValue().toString()));
        }

        if (row.getDefaultDataName18().getValue() != null) {
            builder.set麻酔単位数(Integer.valueOf(row.getDefaultDataName18().getValue().toString()));
        }

        if (row.getDefaultDataName19().getValue() != null) {
            builder.set放射線治療単位数(Integer.valueOf(row.getDefaultDataName19().getValue().toString()));
        }

        if (row.getDefaultDataName14().getValue() != null) {
            builder.set緊急時施設療養費合計単位数(Integer.valueOf(row.getDefaultDataName14().getValue().toString()));
        }

        RString 摘要 = row.getDefaultDataName20();
        int length = 摘要.length();
        if (length != 0) {
            builder = build摘要(builder, length, 摘要);
        }
        return builder.build();
    }

    private ShokanKinkyuShisetsuRyoyoBuilder clear2(ShokanKinkyuShisetsuRyoyoBuilder builder) {
        builder.set緊急時治療開始年月日１(null).set緊急時治療開始年月日２(null).set緊急時治療開始年月日３(null).
                set往診日数(ZERO).set通院日数(ZERO).set緊急時治療管理単位数(ZERO).set緊急時治療管理日数(ZERO).
                set緊急時治療管理小計(ZERO).setリハビリテーション単位数(ZERO).set処置単位数(ZERO).
                set手術単位数(ZERO).set麻酔単位数(ZERO).set放射線治療単位数(ZERO).
                set緊急時施設療養費合計単位数(ZERO).set摘要１(null).set摘要２(null).set摘要３(null).
                set摘要４(null).set摘要５(null).set摘要６(null).set摘要７(null).set摘要８(null).
                set摘要８(null).set摘要９(null).set摘要１０(null).set摘要１１(null).
                set摘要１２(null).set摘要１３(null).set摘要１４(null).set摘要１５(null).
                set摘要１６(null).set摘要１７(null).set摘要１８(null).set摘要１９(null).
                set摘要２０(null).build();
        return builder;
    }

    private ShokanKinkyuShisetsuRyoyoBuilder build摘要(ShokanKinkyuShisetsuRyoyoBuilder builder,
            int length, RString 摘要) {
        if (length <= 位置１) {
            builder.set摘要１(摘要);
        }
        if (length > 位置１ && length <= 位置２) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, length));
        }
        if (length > 位置２ && length <= 位置３) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, length));
        }
        if (length > 位置３ && length <= 位置４) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, length));
        }
        if (length > 位置４ && length <= 位置５) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, length));
        }
        if (length > 位置５ && length <= 位置６) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, length));
        }
        if (length > 位置６ && length <= 位置７) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, length));
        }
        if (length > 位置７ && length <= 位置８) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, length));
        }

        builder = build摘要2(builder, length, 摘要);
        return builder;
    }

    private ShokanKinkyuShisetsuRyoyoBuilder build摘要2(ShokanKinkyuShisetsuRyoyoBuilder builder,
            int length, RString 摘要) {
        if (length > 位置８ && length <= 位置９) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, length));
        }
        if (length > 位置９ && length <= 位置１０) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, length));
        }
        if (length > 位置１０ && length <= 位置１１) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, length));
        }
        if (length > 位置１１ && length <= 位置１２) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, length));
        }
        if (length > 位置１２ && length <= 位置１３) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, length));
        }
        if (length > 位置１３ && length <= 位置１４) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, 位置１３));
            builder.set摘要１４(摘要.substring(位置１３, length));
        }
        builder = build摘要3(builder, length, 摘要);
        return builder;
    }

    private ShokanKinkyuShisetsuRyoyoBuilder build摘要3(ShokanKinkyuShisetsuRyoyoBuilder builder,
            int length, RString 摘要) {
        if (length > 位置１４ && length <= 位置１５) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, 位置１３));
            builder.set摘要１４(摘要.substring(位置１３, 位置１４));
            builder.set摘要１５(摘要.substring(位置１４, length));
        }
        if (length > 位置１５ && length <= 位置１６) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, 位置１３));
            builder.set摘要１４(摘要.substring(位置１３, 位置１４));
            builder.set摘要１５(摘要.substring(位置１４, 位置１５));
            builder.set摘要１６(摘要.substring(位置１５, length));
        }
        if (length > 位置１６ && length <= 位置１７) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, 位置１３));
            builder.set摘要１４(摘要.substring(位置１３, 位置１４));
            builder.set摘要１５(摘要.substring(位置１４, 位置１５));
            builder.set摘要１６(摘要.substring(位置１５, 位置１６));
            builder.set摘要１７(摘要.substring(位置１６, length));
        }
        if (length > 位置１７ && length <= 位置１８) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, 位置１３));
            builder.set摘要１４(摘要.substring(位置１３, 位置１４));
            builder.set摘要１５(摘要.substring(位置１４, 位置１５));
            builder.set摘要１６(摘要.substring(位置１５, 位置１６));
            builder.set摘要１７(摘要.substring(位置１６, 位置１７));
            builder.set摘要１８(摘要.substring(位置１７, length));
        }
        if (length > 位置１８ && length <= 位置１９) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, 位置１３));
            builder.set摘要１４(摘要.substring(位置１３, 位置１４));
            builder.set摘要１５(摘要.substring(位置１４, 位置１５));
            builder.set摘要１６(摘要.substring(位置１５, 位置１６));
            builder.set摘要１７(摘要.substring(位置１６, 位置１７));
            builder.set摘要１８(摘要.substring(位置１７, 位置１８));
            builder.set摘要１９(摘要.substring(位置１８, length));
        }
        if (length > 位置１９ && length <= 位置２０) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, 位置１３));
            builder.set摘要１４(摘要.substring(位置１３, 位置１４));
            builder.set摘要１５(摘要.substring(位置１４, 位置１５));
            builder.set摘要１６(摘要.substring(位置１５, 位置１６));
            builder.set摘要１７(摘要.substring(位置１６, 位置１７));
            builder.set摘要１８(摘要.substring(位置１７, 位置１８));
            builder.set摘要１９(摘要.substring(位置１８, 位置１９));
            builder.set摘要２０(摘要.substring(位置１９, length));
        }
        if (length > 位置２０) {
            builder.set摘要１(摘要.substring(0, 位置１));
            builder.set摘要２(摘要.substring(位置１, 位置２));
            builder.set摘要３(摘要.substring(位置２, 位置３));
            builder.set摘要４(摘要.substring(位置３, 位置４));
            builder.set摘要５(摘要.substring(位置４, 位置５));
            builder.set摘要６(摘要.substring(位置５, 位置６));
            builder.set摘要７(摘要.substring(位置６, 位置７));
            builder.set摘要８(摘要.substring(位置７, 位置８));
            builder.set摘要９(摘要.substring(位置８, 位置９));
            builder.set摘要１０(摘要.substring(位置９, 位置１０));
            builder.set摘要１１(摘要.substring(位置１０, 位置１１));
            builder.set摘要１２(摘要.substring(位置１１, 位置１２));
            builder.set摘要１３(摘要.substring(位置１２, 位置１３));
            builder.set摘要１４(摘要.substring(位置１３, 位置１４));
            builder.set摘要１５(摘要.substring(位置１４, 位置１５));
            builder.set摘要１６(摘要.substring(位置１５, 位置１６));
            builder.set摘要１７(摘要.substring(位置１６, 位置１７));
            builder.set摘要１８(摘要.substring(位置１７, 位置１８));
            builder.set摘要１９(摘要.substring(位置１８, 位置１９));
            builder.set摘要２０(摘要.substring(位置１９, 位置２０));
        }
        return builder;
    }

    /**
     * ボタン表示制御処理
     *
     * @param entity ShikibetsuNoKanri
     * @param parameter ShoukanharaihishinseimeisaikensakuParameter
     */
    public void getボタンを制御(ShikibetsuNoKanri entity, ShoukanharaihishinseimeisaikensakuParameter parameter) {

        FlexibleYearMonth サービス年月 = parameter.getサービス年月();
        HihokenshaNo 被保険者番号 = parameter.get被保険者番号();
        RString 整理番号 = parameter.get整理番号();
        JigyoshaNo 事業者番号 = parameter.get事業者番号();
        RString 明細番号 = parameter.get明細番号();
        RString 様式番号 = parameter.get様式番号();

        if (設定不可.equals(entity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(entity.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 != 0) {
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
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
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
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 != 0) {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }

        getボタンを制御2(entity, サービス年月, 被保険者番号, 整理番号, 事業者番号, 明細番号, 様式番号);
        getボタンを制御3(entity, サービス年月, 被保険者番号, 整理番号, 事業者番号, 明細番号, 様式番号);
    }

    private void getボタンを制御2(ShikibetsuNoKanri entity, FlexibleYearMonth サービス年月,
            HihokenshaNo 被保険者番号, RString 整理番号, JigyoshaNo 事業者番号,
            RString 明細番号, RString 様式番号) {

        if (設定不可.equals(entity.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(entity.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 != 0) {
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
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 != 0) {
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
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 != 0) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }
    }

    private void getボタンを制御3(ShikibetsuNoKanri entity, FlexibleYearMonth サービス年月,
            HihokenshaNo 被保険者番号, RString 整理番号, JigyoshaNo 事業者番号,
            RString 明細番号, RString 様式番号) {

        if (設定不可.equals(entity.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(entity.get緊急時施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
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
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
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
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 != 0) {
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
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 != 0) {
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
     * @param state RString
     */
    public void click_Confirm(RString state) {
        div.getBtnAdd().setDisabled(false);
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);

        List<dgdKinkyujiShiseturyoyo_Row> list = div.getDgdKinkyujiShiseturyoyo().getDataSource();
        if (登録.equals(state)) {
            if (!RString.EMPTY.equals(div.getRowId())) {
                dgdKinkyujiShiseturyoyo_Row row = getSelectedRow();
                confirm(row, state);
                list.set(Integer.parseInt(div.getRowId().toString()), row);
            } else {
                dgdKinkyujiShiseturyoyo_Row row = new dgdKinkyujiShiseturyoyo_Row();
                confirm(row, state);
                list.add(row);
            }
        } else if (登録_削除.equals(state)) {
            dgdKinkyujiShiseturyoyo_Row row = getSelectedRow();
            confirm(row, state);
        } else {
            dgdKinkyujiShiseturyoyo_Row row = getSelectedRow();
            confirm(row, state);
            list.set(Integer.parseInt(div.getRowId().toString()), row);
        }
        div.getDgdKinkyujiShiseturyoyo().setDataSource(list);
    }

    /**
     * 入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック() {
        KinkyujiShisetuRyoyohiPanelValidationHandler validationHandler = new KinkyujiShisetuRyoyohiPanelValidationHandler();
        ValidationMessageControlPairs validPairs;
        for (dgdKinkyujiShiseturyoyo_Row row : div.getDgdKinkyujiShiseturyoyo().getDataSource()) {
            if (RowState.Added == row.getRowState() || RowState.Modified == row.getRowState()) {
                validPairs = validationHandler.必須チェックValidate(row);
                if (validPairs.iterator().hasNext()) {
                    return validPairs;
                }
            }
        }
        return null;
    }
}
