/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820028;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyoBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.KinkyujiShoteiShikanPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.dgdKinkyujiShoteiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患）画面のハンドラクラスです
 */
public final class KinkyujiShoteiShikanPanelHandler {

    private final KinkyujiShoteiShikanPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 登録_削除 = new RString("登録_削除");
    private static final RString 改行 = new RString("\n");
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

    private KinkyujiShoteiShikanPanelHandler(KinkyujiShoteiShikanPanelDiv div) {
        this.div = div;
    }

    /**
     * 生成されたインタフェースを返します
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return KinkyujiShoteiShikanPanelHandler
     */
    public static KinkyujiShoteiShikanPanelHandler of(KinkyujiShoteiShikanPanelDiv div) {
        return new KinkyujiShoteiShikanPanelHandler(div);
    }

    /**
     * 申請共通エリア
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 申請日 RDate
     * @param 事業者番号 JigyoshaNo
     * @param 明細番号 RString
     * @param 証明書 RString
     * @param 様式番号 RString
     */
    public void initPanelHead(FlexibleYearMonth サービス年月,
            RDate 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書,
            RString 様式番号) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    /**
     * 緊急時・所定疾患一覧
     *
     * @param businessList 償還払請求所定疾患施設療養費等データ
     */
    public void initDgdKinkyujiShoteiList(List<ShokanShoteiShikkanShisetsuRyoyo> businessList) {
        List<dgdKinkyujiShoteiList_Row> lists = new ArrayList<>();
        for (ShokanShoteiShikkanShisetsuRyoyo result : businessList) {
            dgdKinkyujiShoteiList_Row row = new dgdKinkyujiShoteiList_Row();
            row.setShoteiShobyoName1(result.get所定疾患施設療養費傷病名１());
            row.setShoteiShobyoName2(result.get所定疾患施設療養費傷病名２());
            row.setShoteiShobyoName3(result.get所定疾患施設療養費傷病名３());
            if (result.get所定疾患施設療養費開始年月日１() != null) {
                row.getShoteiKaishiDate1().setValue(new RDate(
                        result.get所定疾患施設療養費開始年月日１().wareki().toDateString().toString()));
            }

            if (result.get所定疾患施設療養費開始年月日２() != null) {
                row.getShoteiKaishiDate2().setValue(new RDate(
                        result.get所定疾患施設療養費開始年月日２().wareki().toDateString().toString()));
            }

            if (result.get所定疾患施設療養費開始年月日３() != null) {
                row.getShoteiKaishiDate3().setValue(new RDate(
                        result.get所定疾患施設療養費開始年月日３().wareki().toDateString().toString()));
            }

            row.getOhshinNissu().setValue(new Decimal(result.get往診日数()));
            row.setOhshinIryoKikanName(result.get往診医療機関名());
            row.getTsuinNissu().setValue(new Decimal(result.get通院日数()));
            row.setTsuinIryoKikanName(result.get通院医療機関名());
            row.getShoteiTaniSu().setValue(new Decimal(result.get所定疾患施設療養費単位数()));
            row.getShoteiNissu().setValue(new Decimal(result.get所定疾患施設療養費日数()));
            row.getShoteiTaniGokei().setValue(new Decimal(result.get所定疾患施設療養費小計()));

            row.setKinkyuShobyoName1(result.get緊急時傷病名１());
            row.setKinkyuShobyoName2(result.get緊急時傷病名２());
            row.setKinkyuShobyoName3(result.get緊急時傷病名３());
            if (result.get緊急時治療開始年月日１() != null) {
                row.getKinkyuKaishiDate1().setValue(new RDate(
                        result.get緊急時治療開始年月日１().wareki().toDateString().toString()));
            }
            if (result.get緊急時治療開始年月日２() != null) {
                row.getKinkyuKaishiDate1().setValue(new RDate(
                        result.get緊急時治療開始年月日２().wareki().toDateString().toString()));
            }
            if (result.get緊急時治療開始年月日３() != null) {
                row.getKinkyuKaishiDate1().setValue(new RDate(
                        result.get緊急時治療開始年月日３().wareki().toDateString().toString()));
            }

            row.getKinkyuTaniSu().setValue(new Decimal(result.get緊急時治療管理単位数()));
            row.getKinkyuNissu().setValue(new Decimal(result.get緊急時治療管理日数()));
            row.getKinkyuTaniGokei().setValue(new Decimal(result.get緊急時治療管理小計()));
            row.getKinkyuRyoyohiGokeiTaniSu().setValue((new Decimal(result.get緊急時施設療養費合計単位数())));

            row.getRehabilitationTani().setValue(new Decimal(result.getリハビリテーション単位数()));
            row.getShochiTani().setValue(new Decimal(result.get処置単位数()));
            row.getShujutsuTani().setValue(new Decimal(result.get手術単位数()));
            row.getMasuiTani().setValue(new Decimal(result.get麻酔単位数()));
            row.getHoshasenTani().setValue(new Decimal(result.get放射線治療単位数()));
            row.setTekiyo(get摘要(result));
            row.setRenban(result.get連番());
            lists.add(row);
        }
        div.getDgdKinkyujiShoteiList().setDataSource(lists);
    }

    /**
     * 追加する設定
     */
    public void initAdd() {
        div.getBtnAdd().setDisabled(true);
        div.getPanelDetail().setDisplayNone(false);
        div.getPanelDetail().getPanelShobyoName().setDisabled(false);
        div.getPanelDetail().getPanelOshinTuyin().setDisabled(false);
        div.getPanelDetail().getPanelJiryoutensu().setDisabled(false);
        clear登録();
    }

    /**
     * 緊急時・所定疾患登録
     *
     * @param row dgdKinkyujiShoteiList_Row
     */
    public void set登録(dgdKinkyujiShoteiList_Row row) {

        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName1().setValue(row.getShoteiShobyoName1());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName2().setValue(row.getShoteiShobyoName2());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName3().setValue(row.getShoteiShobyoName3());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD1().setValue(
                row.getShoteiKaishiDate1().getValue());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD2().setValue(
                row.getShoteiKaishiDate2().getValue());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD3().setValue(
                row.getShoteiKaishiDate3().getValue());
        div.getPanelShobyoName().getTxtKinkyuShobyoName1().setValue(row.getKinkyuShobyoName1());
        div.getPanelShobyoName().getTxtKinkyuShobyoName2().setValue(row.getKinkyuShobyoName2());
        div.getPanelShobyoName().getTxtKinkyuShobyoName3().setValue(row.getKinkyuShobyoName3());
        div.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD1().setValue(row.getKinkyuKaishiDate1().getValue());
        div.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD2().setValue(row.getKinkyuKaishiDate2().getValue());
        div.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD3().setValue(row.getKinkyuKaishiDate3().getValue());

        div.getPanelOshinTuyin().getTxtOshinNissu().setValue(row.getOhshinNissu().getValue());
        div.getPanelOshinTuyin().getTxtOshinIryoKikanName().setValue(row.getOhshinIryoKikanName());
        div.getPanelOshinTuyin().getTxtTsuyinNissu().setValue(row.getTsuinNissu().getValue());
        div.getPanelOshinTuyin().getTxtTsuinKikanName().setValue(row.getTsuinIryoKikanName());
        div.getPanelOshinTuyin().getTxtTekiyou().setValue(row.getTekiyo());

        div.getPanelJiryoutensu().getTxtShoteiShikkanTanisu().setValue(
                row.getShoteiTaniSu().getValue());
        div.getPanelJiryoutensu().getTxtShoteiShikkanNissu().setValue(row.getShoteiNissu().getValue());
        div.getPanelJiryoutensu().getTxtShoteiShikkanSubTotal().setValue(row.getShoteiTaniGokei().getValue());
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriTanisu().setValue(row.getKinkyuTaniSu().getValue());
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriNissu().setValue(row.getKinkyuNissu().getValue());
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriSubTotal().setValue(row.getKinkyuTaniGokei().getValue());
        div.getPanelJiryoutensu().getTxtRehabilitationTanisu().setValue(row.getRehabilitationTani().getValue());
        div.getPanelJiryoutensu().getTxtShujutsuTanisu().setValue(row.getShujutsuTani().getValue());
        div.getPanelJiryoutensu().getTxtHoshasenChiryoTanisu().setValue(row.getHoshasenTani().getValue());
        div.getPanelJiryoutensu().getTxtShochiTanisu().setValue(row.getShochiTani().getValue());
        div.getPanelJiryoutensu().getTxtMasuiTanisu().setValue(row.getMasuiTani().getValue());
        div.getPanelJiryoutensu().getTxtTokuteiJiryoGoukei().setValue(row.getKinkyuRyoyohiGokeiTaniSu().getValue());
    }

    private RString get摘要(ShokanShoteiShikkanShisetsuRyoyo result) {
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
     * クリアする設定
     */
    public void clear登録() {
        div.getTxtShoteiShikkanShobyoName1().clearValue();
        div.getTxtShoteiShikkanShobyoName2().clearValue();
        div.getTxtShoteiShikkanShobyoName3().clearValue();
        div.getTxtShoteiShikkanShobyoKaishiYMD1().clearValue();
        div.getTxtShoteiShikkanShobyoKaishiYMD2().clearValue();
        div.getTxtShoteiShikkanShobyoKaishiYMD3().clearValue();

        div.getTxtKinkyuShobyoName1().clearValue();
        div.getTxtKinkyuShobyoName2().clearValue();
        div.getTxtKinkyuShobyoName3().clearValue();
        div.getTxtKinkyuChiryoKaishiYMD1().clearValue();
        div.getTxtKinkyuChiryoKaishiYMD2().clearValue();
        div.getTxtKinkyuChiryoKaishiYMD3().clearValue();

        div.getTxtOshinNissu().clearValue();
        div.getTxtOshinIryoKikanName().clearValue();
        div.getTxtTsuyinNissu().clearValue();
        div.getTxtTsuinKikanName().clearValue();
        div.getTxtTekiyou().clearValue();

        div.getTxtShoteiShikkanTanisu().clearValue();
        div.getTxtShoteiShikkanNissu().clearValue();
        div.getTxtShoteiShikkanSubTotal().clearValue();
        div.getTxtKinkyuChiryoKanriTanisu().clearValue();
        div.getTxtKinkyuChiryoKanriNissu().clearValue();
        div.getTxtKinkyuChiryoKanriSubTotal().clearValue();
        div.getTxtRehabilitationTanisu().clearValue();
        div.getTxtShujutsuTanisu().clearValue();
        div.getTxtHoshasenChiryoTanisu().clearValue();
        div.getTxtShochiTanisu().clearValue();
        div.getTxtMasuiTanisu().clearValue();
        div.getTxtTokuteiJiryoGoukei().clearValue();
    }

    /**
     * 選択行
     *
     * @return dgdKinkyujiShoteiList_Row
     */
    public dgdKinkyujiShoteiList_Row getSelectedRow() {
        return div.getDgdKinkyujiShoteiList().getDataSource().get(Integer.parseInt(div.getRowId().toString()));
    }

    /**
     * 確定する設定
     *
     * @param row dgdKinkyujiShoteiList_Row
     */
    public void confirm(dgdKinkyujiShoteiList_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            row.setRowState(RowState.Modified);
        } else if (削除.equals(state)) {
            row.setRowState(RowState.Deleted);
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
        } else if (登録_削除.equals(state)) {
            div.getDgdKinkyujiShoteiList().getDataSource().remove(Integer.parseInt(div.getRowId().toString()));
            return;
        }
        row.setShoteiShobyoName1(div.getTxtShoteiShikkanShobyoName1().getValue());
        row.setShoteiShobyoName2(div.getTxtShoteiShikkanShobyoName2().getValue());
        row.setShoteiShobyoName3(div.getTxtShoteiShikkanShobyoName3().getValue());
        row.getShoteiKaishiDate1().setValue(div.getTxtShoteiShikkanShobyoKaishiYMD1().getValue());
        row.getShoteiKaishiDate2().setValue(div.getTxtShoteiShikkanShobyoKaishiYMD2().getValue());
        row.getShoteiKaishiDate3().setValue(div.getTxtShoteiShikkanShobyoKaishiYMD3().getValue());
        row.getOhshinNissu().setValue(div.getTxtOshinNissu().getValue());
        row.setOhshinIryoKikanName(div.getTxtOshinIryoKikanName().getValue());
        row.getTsuinNissu().setValue(div.getTxtTsuyinNissu().getValue());
        row.setTsuinIryoKikanName(div.getTxtTsuinKikanName().getValue());
        row.getShoteiTaniSu().setValue(div.getTxtShoteiShikkanTanisu().getValue());
        row.getShoteiNissu().setValue(div.getTxtShoteiShikkanNissu().getValue());
        row.getShoteiTaniGokei().setValue(div.getTxtShoteiShikkanSubTotal().getValue());

        row.setKinkyuShobyoName1(div.getTxtKinkyuShobyoName1().getValue());
        row.setKinkyuShobyoName2(div.getTxtKinkyuShobyoName2().getValue());
        row.setKinkyuShobyoName3(div.getTxtKinkyuShobyoName3().getValue());
        row.getKinkyuKaishiDate1().setValue(div.getTxtKinkyuChiryoKaishiYMD1().getValue());
        row.getKinkyuKaishiDate2().setValue(div.getTxtKinkyuChiryoKaishiYMD2().getValue());
        row.getKinkyuKaishiDate3().setValue(div.getTxtKinkyuChiryoKaishiYMD3().getValue());
        row.getKinkyuTaniSu().setValue(div.getTxtKinkyuChiryoKanriTanisu().getValue());
        row.getKinkyuNissu().setValue(div.getTxtKinkyuChiryoKanriNissu().getValue());
        row.getKinkyuTaniGokei().setValue(div.getTxtKinkyuChiryoKanriSubTotal().getValue());
        row.getKinkyuRyoyohiGokeiTaniSu().setValue(div.getTxtTokuteiJiryoGoukei().getValue());

        row.getRehabilitationTani().setValue(div.getTxtRehabilitationTanisu().getValue());
        row.getShujutsuTani().setValue(div.getTxtShujutsuTanisu().getValue());
        row.getHoshasenTani().setValue(div.getTxtHoshasenChiryoTanisu().getValue());
        row.getShochiTani().setValue(div.getTxtShochiTanisu().getValue());
        row.getMasuiTani().setValue(div.getTxtMasuiTanisu().getValue());
        row.setTekiyo(div.getTxtTekiyou().getValue());

    }

    /**
     * 計算する①
     */
    public void cal1() {
        Decimal data = null;
        Decimal num1 = div.getTxtShoteiShikkanTanisu().getValue();
        Decimal num2 = div.getTxtShoteiShikkanNissu().getValue();
        if (num1 != null && num2 != null) {
            data = num1.multiply(num2);
        }
        div.getTxtShoteiShikkanSubTotal().setValue(data);
    }

    /**
     * 計算する②
     */
    public void cal2() {
        Decimal data = null;
        Decimal num1 = div.getTxtKinkyuChiryoKanriTanisu().getValue();
        Decimal num2 = div.getTxtKinkyuChiryoKanriNissu().getValue();
        if (num1 != null && num2 != null) {
            data = num1.multiply(num2);
        }
        div.getTxtKinkyuChiryoKanriSubTotal().setValue(data);
    }

    /**
     * 計算する③
     */
    public void cal3() {
        Decimal data = new Decimal(0);
        if (div.getTxtRehabilitationTanisu().getValue() != null) {
            data = data.add(div.getTxtRehabilitationTanisu().getValue());
        }
        if (div.getTxtShujutsuTanisu().getValue() != null) {
            data = data.add(div.getTxtShujutsuTanisu().getValue());
        }
        if (div.getTxtShochiTanisu().getValue() != null) {
            data = data.add(div.getTxtShochiTanisu().getValue());
        }
        if (div.getTxtMasuiTanisu().getValue() != null) {
            data = data.add(div.getTxtMasuiTanisu().getValue());
        }
        div.getTxtTokuteiJiryoGoukei().setValue(data);
    }

    /**
     * ボタン表示制御処理
     *
     * @param entity ShikibetsuNoKanri
     */
    public void getボタンを制御(ShikibetsuNoKanri entity) {

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.償還払費申請明細検索キー, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
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
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyohi().setDisabled(true);
        } else if (設定可必須.equals(entity.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 != 0) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyohi().setIconNameEnum(IconName.NONE);
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
     * 内容変更状態
     *
     * @return boolean
     */
    public boolean get内容変更状態() {
        for (dgdKinkyujiShoteiList_Row row : div.getDgdKinkyujiShoteiList().getDataSource()) {
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
     */
    public void 保存処理() {

        ServiceTeiKyoShomeishoParameter keys = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ServiceTeiKyoShomeishoParameter.class);
        JigyoshaNo 事業者番号 = keys.getJigyoshaNo();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        HihokenshaNo 被保険者番号 = keys.getHiHokenshaNo();
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().
                getValue().toDateString().substring(0, SIX));
        RString 整理番号 = keys.getSeiriNp();
        RString 明細番号 = keys.getMeisaiNo();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(
                    被保険者番号, 提供購入年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            int max連番 = 0;
            List<ShokanShoteiShikkanShisetsuRyoyo> shokanShoteiShikkanShisetsuRyoyoList = ViewStateHolder.get(
                    ViewStateKeys.償還払請求所定疾患施設療養費等データ, List.class);
            Map<RString, ShokanShoteiShikkanShisetsuRyoyo> map = new HashMap<>();
            for (ShokanShoteiShikkanShisetsuRyoyo entity : shokanShoteiShikkanShisetsuRyoyoList) {
                map.put(entity.get連番(), entity);
                if (max連番 < Integer.valueOf(entity.get連番().toString())) {
                    max連番 = Integer.valueOf(entity.get連番().toString());
                }
            }

            List<ShokanShoteiShikkanShisetsuRyoyo> list = new ArrayList<>();

            for (dgdKinkyujiShoteiList_Row row : div.getDgdKinkyujiShoteiList().getDataSource()) {
                if (RowState.Added == row.getRowState()) {
                    max連番 = max連番 + 1;
                    RString 新整理番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.
                            getコード()).nextString();
                    ShokanShoteiShikkanShisetsuRyoyo entity = new ShokanShoteiShikkanShisetsuRyoyo(
                            被保険者番号, 提供購入年月, 新整理番号, 事業者番号, 様式番号, 明細番号,
                            new RString(String.valueOf(max連番)));
                    entity = entity.added();
                    entity = buildEntity(entity, row);
                    list.add(entity);
                }
                if (RowState.Modified == row.getRowState()) {
                    ShokanShoteiShikkanShisetsuRyoyo entityModified = map.get(row.getRenban());
                    entityModified = entityModified.modified();
                    entityModified = buildEntity(entityModified, row);
                    list.add(entityModified);
                }
                if (RowState.Deleted == row.getRowState()) {
                    ShokanShoteiShikkanShisetsuRyoyo entityDeleted = map.get(row.getRenban());
                    entityDeleted = entityDeleted.deleted();
                    list.add(entityDeleted);
                }
            }

            RString 証明書コード = div.getPanelHead().getTxtShomeisho().getValue();

            ShokanKihonParameter parameter = ShokanKihonParameter.
                    createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号, 事業者番号, 証明書コード, 明細番号, 0);

            SyokanbaraihiShikyuShinseiKetteManager manager = SyokanbaraihiShikyuShinseiKetteManager.createInstance();
            manager.updShokanShoteiShikkanShisetsuRyoyo(parameter, list);
        }
    }

    private ShokanShoteiShikkanShisetsuRyoyo buildEntity(ShokanShoteiShikkanShisetsuRyoyo entity,
            dgdKinkyujiShoteiList_Row row) {
        ShokanShoteiShikkanShisetsuRyoyoBuilder builder = entity.createBuilderForEdit();
        builder.set緊急時傷病名１(row.getKinkyuShobyoName1());
        builder.set緊急時傷病名２(row.getKinkyuShobyoName2());
        builder.set緊急時傷病名３(row.getKinkyuShobyoName3());

        if (row.getKinkyuKaishiDate1().getValue() != null) {
            builder.set緊急時治療開始年月日１(new FlexibleDate(row.getKinkyuKaishiDate1().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getKinkyuKaishiDate2().getValue() != null) {
            builder.set緊急時治療開始年月日２(new FlexibleDate(row.getKinkyuKaishiDate2().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getKinkyuKaishiDate3().getValue() != null) {
            builder.set緊急時治療開始年月日３(new FlexibleDate(row.getKinkyuKaishiDate3().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getOhshinNissu().getValue() != null) {
            builder.set往診日数(Integer.valueOf(row.getOhshinNissu().getValue().toString()));
        } else {
            builder.set往診日数(0);
        }
        builder.set往診医療機関名(row.getOhshinIryoKikanName());

        if (row.getTsuinNissu().getValue() != null) {

            builder.set通院日数(Integer.valueOf(row.getTsuinNissu().getValue().toString()));
        } else {
            builder.set通院日数(0);
        }
        builder.set通院医療機関名(row.getTsuinIryoKikanName());

        if (row.getKinkyuTaniSu().getValue() != null) {
            builder.set緊急時治療管理単位数(Integer.valueOf(row.getKinkyuTaniSu().getValue().toString()));
        } else {
            builder.set緊急時治療管理単位数(0);
        }

        if (row.getKinkyuNissu().getValue() != null) {
            builder.set緊急時治療管理日数(Integer.valueOf(row.getKinkyuNissu().getValue().toString()));
        } else {
            builder.set緊急時治療管理日数(0);
        }

        if (row.getKinkyuTaniGokei().getValue() != null) {
            builder.set緊急時治療管理小計(Integer.valueOf(row.getKinkyuTaniGokei().getValue().toString()));
        } else {
            builder.set緊急時治療管理小計(0);
        }

        if (row.getRehabilitationTani().getValue() != null) {
            builder.setリハビリテーション単位数(Integer.valueOf(row.getRehabilitationTani().getValue().toString()));
        } else {
            builder.setリハビリテーション単位数(0);
        }

        if (row.getShochiTani().getValue() != null) {
            builder.set処置単位数(Integer.valueOf(row.getShochiTani().getValue().toString()));
        } else {
            builder.set処置単位数(0);
        }

        if (row.getShujutsuTani().getValue() != null) {
            builder.set手術単位数(Integer.valueOf(row.getShujutsuTani().getValue().toString()));
        } else {
            builder.set手術単位数(0);
        }

        if (row.getMasuiTani().getValue() != null) {
            builder.set麻酔単位数(Integer.valueOf(row.getMasuiTani().getValue().toString()));
        } else {
            builder.set麻酔単位数(0);
        }

        if (row.getHoshasenTani().getValue() != null) {
            builder.set放射線治療単位数(Integer.valueOf(row.getHoshasenTani().getValue().toString()));
        } else {
            builder.set放射線治療単位数(0);
        }

        RString 摘要 = row.getTekiyo();
        int length = 摘要.length();
        if (length != 0) {
            builder = build摘要(builder, length, 摘要);
        }

        builder = buildEntity2(builder, row);

        return builder.build();
    }

    private ShokanShoteiShikkanShisetsuRyoyoBuilder buildEntity2(ShokanShoteiShikkanShisetsuRyoyoBuilder builder,
            dgdKinkyujiShoteiList_Row row) {
        if (row.getKinkyuRyoyohiGokeiTaniSu().getValue() != null) {
            builder.set緊急時施設療養費合計単位数(Integer.valueOf(row.getKinkyuRyoyohiGokeiTaniSu().
                    getValue().toString()));
        } else {
            builder.set緊急時施設療養費合計単位数(0);
        }

        builder.set所定疾患施設療養費傷病名１(row.getShoteiShobyoName1());
        builder.set所定疾患施設療養費傷病名２(row.getShoteiShobyoName2());
        builder.set所定疾患施設療養費傷病名３(row.getShoteiShobyoName3());

        if (row.getShoteiKaishiDate1().getValue() != null) {
            builder.set所定疾患施設療養費開始年月日１(new FlexibleDate(row.getShoteiKaishiDate1().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getShoteiKaishiDate2().getValue() != null) {
            builder.set所定疾患施設療養費開始年月日２(new FlexibleDate(row.getShoteiKaishiDate2().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getShoteiKaishiDate3().getValue() != null) {
            builder.set所定疾患施設療養費開始年月日３(new FlexibleDate(row.getShoteiKaishiDate3().getValue()
                    .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString().toString()));
        }

        if (row.getShoteiTaniSu().getValue() != null) {
            builder.set所定疾患施設療養費単位数(Integer.valueOf(row.getShoteiTaniSu().getValue().toString()));
        }

        if (row.getShoteiNissu().getValue() != null) {
            builder.set所定疾患施設療養費日数(Integer.valueOf(row.getShoteiNissu().getValue().toString()));
        }

        if (row.getShoteiTaniGokei().getValue() != null) {
            builder.set所定疾患施設療養費小計(Integer.valueOf(row.getShoteiTaniGokei().getValue().toString()));
        }
        return builder;
    }

    private ShokanShoteiShikkanShisetsuRyoyoBuilder build摘要(ShokanShoteiShikkanShisetsuRyoyoBuilder builder,
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

    private ShokanShoteiShikkanShisetsuRyoyoBuilder build摘要2(ShokanShoteiShikkanShisetsuRyoyoBuilder builder,
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

    private ShokanShoteiShikkanShisetsuRyoyoBuilder build摘要3(ShokanShoteiShikkanShisetsuRyoyoBuilder builder,
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
     * ViewStateに以下の情報を設定する
     */
    public void putViewState() {
        ViewStateHolder.put(ViewStateKeys.処理モード, "");
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelHead().getTxtShinseiYMD().getValue());
        ServiceTeiKyoShomeishoParameter paramter = new ServiceTeiKyoShomeishoParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getValue().
                        toDateString().substring(0, SIX)),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
                div.getPanelHead().getTxtShomeisho().getValue(),
                div.getPanelHead().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請明細検索キー, paramter);
    }

}
