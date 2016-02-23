/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820027;

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
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面のハンドラクラスです
 *
 * @author XuPeng
 */
public class KinkyujiShisetuRyoyohiPanelHandler {

    private final KinkyujiShisetuRyoyohiPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 登録_削除 = new RString("登録_削除");
    private static final RString 改行 = new RString("\n");

    private KinkyujiShisetuRyoyohiPanelHandler(KinkyujiShisetuRyoyohiPanelDiv div) {
        this.div = div;
    }

    public static KinkyujiShisetuRyoyohiPanelHandler of(KinkyujiShisetuRyoyohiPanelDiv div) {
        return new KinkyujiShisetuRyoyohiPanelHandler(div);
    }

    public void initPanelHead(FlexibleYearMonth サービス年月,
            RDate 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書,
            RString 様式番号) {
        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

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
        if (result.get摘要１() != null && !result.get摘要１().isEmpty()) {
            tekiyou.append(result.get摘要１());
        }
        if (result.get摘要２() != null && !result.get摘要２().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要２());
        }
        if (result.get摘要３() != null && !result.get摘要３().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要３());
        }
        if (result.get摘要４() != null && !result.get摘要４().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要４());
        }
        if (result.get摘要５() != null && !result.get摘要５().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要５());
        }
        if (result.get摘要６() != null && !result.get摘要６().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要６());
        }
        if (result.get摘要７() != null && !result.get摘要７().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要７());
        }
        if (result.get摘要８() != null && !result.get摘要８().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要８());
        }
        if (result.get摘要９() != null && !result.get摘要９().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要９());
        }
        if (result.get摘要１０() != null && !result.get摘要１０().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１０());
        }
        if (result.get摘要１１() != null && !result.get摘要１１().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１１());
        }
        if (result.get摘要１２() != null && !result.get摘要１２().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１２());
        }
        if (result.get摘要１３() != null && !result.get摘要１３().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１３());
        }
        if (result.get摘要１４() != null && !result.get摘要１４().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１４());
        }
        if (result.get摘要１５() != null && !result.get摘要１５().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１５());
        }
        if (result.get摘要１６() != null && !result.get摘要１６().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１６());
        }
        if (result.get摘要１７() != null && !result.get摘要１７().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１７());
        }
        if (result.get摘要１８() != null && !result.get摘要１８().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１８());
        }
        if (result.get摘要１９() != null && !result.get摘要１９().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１９());
        }
        if (result.get摘要２０() != null && !result.get摘要２０().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要２０());
        }
        return tekiyou.toRString();
    }

    public void initAdd() {
        div.getBtnAdd().setDisabled(true);
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(false);
        clear登録();
    }

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

    public void cal1() {
        Decimal data = null;
        Decimal num1 = div.getTxtkinkyuChiryoKanriTanisu().getValue();
        Decimal num2 = div.getTxtkinkyuChiryoKanriNissu().getValue();
        if (num1 != null && num2 != null) {
            data = num1.multiply(num2);
        }
        div.getTxtkinkyuChiryoKanriSubTotal().setValue(data);
    }

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

    public void confirm(dgdKinkyujiShiseturyoyo_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
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
    }

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

    private int get連番(int i) {
        for (dgdKinkyujiShiseturyoyo_Row row : div.getDgdKinkyujiShiseturyoyo().getDataSource()) {
            if (row.getDefaultDataName21().isEmpty()) {
                continue;
            }
            if (Integer.parseInt(row.getDefaultDataName21().toString()) == i) {
                i = get連番(i + 1);
            }
        }
        return i;
    }

    public void 保存処理() {
        ServiceTeiKyoShomeishoParameter keys = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ServiceTeiKyoShomeishoParameter.class);
        JigyoshaNo 事業者番号 = keys.getJigyoshaNo();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        HihokenshaNo 被保険者番号 = keys.getHiHokenshaNo();
        FlexibleYearMonth 提供購入年月 = keys.getServiceTeikyoYM();
        //                              new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM()
//                .getDomain().seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
        RString 整理番号 = keys.getSeiriNp();
        RString 明細番号 = keys.getMeisaiNo();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(
                    被保険者番号, 提供購入年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            int max連番 = get連番(1);
            List<ShokanKinkyuShisetsuRyoyo> ShokanKinkyuShisetsuRyoyoList = ViewStateHolder.get(
                    ViewStateKeys.償還払請求緊急時施設療養, List.class);
            Map<RString, ShokanKinkyuShisetsuRyoyo> map = new HashMap<>();
            for (ShokanKinkyuShisetsuRyoyo entity : ShokanKinkyuShisetsuRyoyoList) {
                map.put(entity.get連番(), entity);
            }

            List<ShokanKinkyuShisetsuRyoyo> list = new ArrayList<>();

            for (dgdKinkyujiShiseturyoyo_Row row : div.getDgdKinkyujiShiseturyoyo().getDataSource()) {
                if (RowState.Added == row.getRowState()) {
                    ShokanKinkyuShisetsuRyoyo entity = new ShokanKinkyuShisetsuRyoyo(
                            被保険者番号, 提供購入年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                            new RString(String.valueOf(max連番)));
                    max連番 = max連番 + 1;
                    entity.added();
                    entity = buildEntity(entity, row);
                    list.add(entity);
                }
                if (RowState.Modified == row.getRowState()) {
                    ShokanKinkyuShisetsuRyoyo entityModified = map.get(row.getDefaultDataName21());
                    entityModified.modified();
                    entityModified = buildEntity(entityModified, row);
                    list.add(entityModified);
                }
                if (RowState.Deleted == row.getRowState()) {
                    ShokanKinkyuShisetsuRyoyo entityDeleted = map.get(row.getDefaultDataName21());
                    entityDeleted = entityDeleted.deleted();
                    list.add(entityDeleted);
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
            if (length <= 32) {
                builder.set摘要１(摘要);
            }
            if (length > 32 && length <= 64) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, length));
            }
            if (length > 64 && length <= 96) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, length));
            }
            if (length > 96 && length <= 128) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, length));
            }
            if (length > 128 && length <= 160) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, length));
            }
            if (length > 160 && length <= 192) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, length));
            }
            if (length > 192 && length <= 224) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, length));
            }
            if (length > 224 && length <= 256) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, length));
            }
            if (length > 256 && length <= 288) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, length));
            }
            if (length > 288 && length <= 320) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, length));
            }
            if (length > 320 && length <= 352) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, length));
            }
            if (length > 352 && length <= 384) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, length));
            }
            if (length > 384 && length <= 416) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, length));
            }
            if (length > 416 && length <= 448) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, 416));
                builder.set摘要１４(摘要.substring(416, length));
            }
            if (length > 448 && length <= 480) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, 416));
                builder.set摘要１４(摘要.substring(416, 448));
                builder.set摘要１５(摘要.substring(448, length));
            }
            if (length > 480 && length <= 512) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, 416));
                builder.set摘要１４(摘要.substring(416, 448));
                builder.set摘要１５(摘要.substring(448, 480));
                builder.set摘要１６(摘要.substring(480, length));
            }
            if (length > 512 && length <= 544) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, 416));
                builder.set摘要１４(摘要.substring(416, 448));
                builder.set摘要１５(摘要.substring(448, 480));
                builder.set摘要１６(摘要.substring(480, 512));
                builder.set摘要１７(摘要.substring(512, length));
            }
            if (length > 544 && length <= 576) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, 416));
                builder.set摘要１４(摘要.substring(416, 448));
                builder.set摘要１５(摘要.substring(448, 480));
                builder.set摘要１６(摘要.substring(480, 512));
                builder.set摘要１７(摘要.substring(512, 544));
                builder.set摘要１８(摘要.substring(544, length));
            }
            if (length > 576 && length <= 608) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, 416));
                builder.set摘要１４(摘要.substring(416, 448));
                builder.set摘要１５(摘要.substring(448, 480));
                builder.set摘要１６(摘要.substring(480, 512));
                builder.set摘要１７(摘要.substring(512, 544));
                builder.set摘要１８(摘要.substring(544, 576));
                builder.set摘要１９(摘要.substring(576, length));
            }
            if (length > 608 && length <= 640) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, 416));
                builder.set摘要１４(摘要.substring(416, 448));
                builder.set摘要１５(摘要.substring(448, 480));
                builder.set摘要１６(摘要.substring(480, 512));
                builder.set摘要１７(摘要.substring(512, 544));
                builder.set摘要１８(摘要.substring(544, 576));
                builder.set摘要１９(摘要.substring(576, 608));
                builder.set摘要２０(摘要.substring(608, length));
            }
            if (length > 640) {
                builder.set摘要１(摘要.substring(0, 32));
                builder.set摘要２(摘要.substring(32, 64));
                builder.set摘要３(摘要.substring(64, 96));
                builder.set摘要４(摘要.substring(96, 128));
                builder.set摘要５(摘要.substring(128, 160));
                builder.set摘要６(摘要.substring(160, 192));
                builder.set摘要７(摘要.substring(192, 224));
                builder.set摘要８(摘要.substring(224, 256));
                builder.set摘要９(摘要.substring(256, 288));
                builder.set摘要１０(摘要.substring(288, 320));
                builder.set摘要１１(摘要.substring(320, 352));
                builder.set摘要１２(摘要.substring(352, 384));
                builder.set摘要１３(摘要.substring(384, 416));
                builder.set摘要１４(摘要.substring(416, 448));
                builder.set摘要１５(摘要.substring(448, 480));
                builder.set摘要１６(摘要.substring(480, 512));
                builder.set摘要１７(摘要.substring(512, 544));
                builder.set摘要１８(摘要.substring(544, 576));
                builder.set摘要１９(摘要.substring(576, 608));
                builder.set摘要２０(摘要.substring(608, 640));
            }
        }

        return builder.build();
    }

    public void getボタンを制御(ShikibetsuNoKanri entity) {

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.償還払費申請明細検索キー, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);

        // 基本情報
        if (設定不可.equals(entity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(entity.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 == 1) {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
        // 給付費明細
        if (設定不可.equals(entity.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(entity.get明細設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 == 1) {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }
        // 特定診療費
        if (設定不可.equals(entity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        } else if (設定可必須.equals(entity.get特定診療費設定区分())) {
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 == 1) {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }

        // サービス計画費
        if (設定不可.equals(entity.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(entity.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 == 1) {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }

        // 特定入所者費用
        if (設定不可.equals(entity.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        } else if (設定可必須.equals(entity.get特定入所者設定区分())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 == 1) {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
        }

        // 合計情報
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
        // 給付費明細（住特）
        if (設定不可.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        } else if (設定可必須.equals(entity.get明細住所地特例設定区分())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 == 1) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }

        // 緊急時・所定疾患
        if (設定不可.equals(entity.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(entity.get緊急時施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 == 1) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }

        // 食事費用
        if (設定不可.equals(entity.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(entity.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 == 1) {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
        }
        // 請求額集計
        if (設定不可.equals(entity.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(entity.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 == 1) {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
        // 社福軽減額
        if (設定不可.equals(entity.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        } else if (設定可必須.equals(entity.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 == 1) {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
        }
    }

    public dgdKinkyujiShiseturyoyo_Row getSelectedRow() {
        return div.getDgdKinkyujiShiseturyoyo().getDataSource().get(Integer.parseInt(div.getRowId().toString()));
    }

    public void putViewState() {
        ViewStateHolder.put(ViewStateKeys.処理モード, "");
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelHead().getTxtShinseiYMD().getValue());
        ServiceTeiKyoShomeishoParameter paramter = new ServiceTeiKyoShomeishoParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getDomain().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
                div.getPanelHead().getTxtShomeisho().getValue(),
                div.getPanelHead().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請明細検索キー, paramter);
    }
}
