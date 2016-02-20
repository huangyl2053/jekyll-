/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820027;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
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
            row.getDefaultDataName4().setValue(new RDate(result.get緊急時治療開始年月日１()
                    .wareki().toDateString().toString()));
            row.getDefaultDataName5().setValue(new RDate(result.get緊急時治療開始年月日２()
                    .wareki().toDateString().toString()));
            row.getDefaultDataName6().setValue(new RDate(result.get緊急時治療開始年月日３()
                    .wareki().toDateString().toString()));

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

    public void getボタンを制御(DbT3118ShikibetsuNoKanriEntity entity) {

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.償還払費申請明細検索キー, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);

        // 基本情報
        if (設定不可.equals(entity.getKihonSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(entity.getKihonSetteiKubun())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 == 1) {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getKihonSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
        // 給付費明細
        if (設定不可.equals(entity.getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(entity.getMeisaiSetteiKubun())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 == 1) {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }
        // 特定診療費
        if (設定不可.equals(entity.getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteiShinryoSetteiKubun())) {
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 == 1) {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }

        // サービス計画費
        if (設定不可.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            // TODO サービス計画費情報件数を呼び出す
            int count4 = 1;
//                    SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
//                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 == 1) {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }

        // 特定入所者費用
        if (設定不可.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 == 1) {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
        }

        // 合計情報
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
        // 給付費明細（住特）
        if (設定不可.equals(entity.getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        } else if (設定可必須.equals(entity.getMeisaiJushochitokureiSetteiKubun())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 == 1) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }

        // 緊急時・所定疾患
        if (設定不可.equals(entity.getTokuteiShikkanSetteiKubun())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteiShikkanSetteiKubun())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 == 1) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteiShikkanSetteiKubun())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }

        // 食事費用
        if (設定不可.equals(entity.getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(entity.getShokujiHiyosetteiKubun())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 == 1) {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
        }
        // 請求額集計
        if (設定不可.equals(entity.getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(entity.getShukeiSetteiKubun())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 == 1) {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
        // 社福軽減額
        if (設定不可.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        } else if (設定可必須.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 == 1) {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
        }
    }

    public void putViewState() {
        // TODO 支給申請画面のモード　
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
