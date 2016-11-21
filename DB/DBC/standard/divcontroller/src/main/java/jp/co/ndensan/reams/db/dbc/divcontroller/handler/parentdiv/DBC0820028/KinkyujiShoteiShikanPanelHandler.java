/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820028;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyoBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.KinkyujiShoteiShikanPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.dgdKinkyujiShoteiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
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

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患）画面のハンドラクラスです
 *
 * @reamsid_L DBC-1030-050 xupeng
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
    private static final RString 書式 = new RString("%02d");
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
     * @param 被保険者番号 HihokenshaNo
     * @param 整理番号 RString
     * @param サービス年月 FlexibleYearMonth
     * @param 申請日 RDate
     * @param 事業者番号 JigyoshaNo
     * @param 明細番号 RString
     * @param 証明書 RString
     * @param 様式番号 RString
     * @param 識別コード ShikibetsuCode
     * @param 償還払ViewStateDB DbJohoViewState
     * @param parameter ShoukanharaihishinseimeisaikensakuParameter
     * @return ArrayList<ShokanShoteiShikkanShisetsuRyoyo>
     */
    public ArrayList<ShokanShoteiShikkanShisetsuRyoyo> initPanelHead(HihokenshaNo 被保険者番号,
            RString 整理番号,
            FlexibleYearMonth サービス年月,
            RDate 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書,
            RString 様式番号,
            ShikibetsuCode 識別コード,
            DbJohoViewState 償還払ViewStateDB,
            ShoukanharaihishinseimeisaikensakuParameter parameter) {

        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);

        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);

        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        ArrayList<ShokanShoteiShikkanShisetsuRyoyo> list = new ArrayList();
        if (償還払ViewStateDB != null && 償還払ViewStateDB.get償還払請求所定疾患施設療養費等データList() != null) {
            list = 償還払ViewStateDB.get償還払請求所定疾患施設療養費等データList();
        }
        list = new ArrayList<>(getUpdateList(list, parameter));
        ArrayList<ShokanShoteiShikkanShisetsuRyoyo> dbList = (ArrayList<ShokanShoteiShikkanShisetsuRyoyo>) finder.
                getShoteiShikanShisetsuRyoyohiEtcData(被保険者番号, サービス年月, 整理番号, 事業者番号,
                        様式番号, 明細番号, null);
        if (dbList != null && !dbList.isEmpty()) {
            for (ShokanShoteiShikkanShisetsuRyoyo row : dbList) {
                list.add(row);
            }
        }
        return list;
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
            row.setRowState(RowState.valueOf(result.toEntity().getState().name()));
            lists.add(row);
        }
        div.getDgdKinkyujiShoteiList().setDataSource(lists);
    }

    /**
     * 追加する設定
     */
    public void initAdd() {
        div.setRowId(RString.EMPTY);
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

    private void confirm(dgdKinkyujiShoteiList_Row row, RString state, List<ShokanShoteiShikkanShisetsuRyoyo> rowList,
            List<dgdKinkyujiShoteiList_Row> list) {
        if (修正.equals(state)) {
            boolean flag = checkState(row, rowList);
            if (flag) {
                row.setRowState(RowState.Modified);
            }
        } else if (削除.equals(state)) {
            row.setRowState(RowState.Deleted);
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            int 連番 = 0;
            for (dgdKinkyujiShoteiList_Row oldRow : list) {
                if (連番 < Integer.valueOf((oldRow.getRenban().toString()))) {
                    連番 = Integer.valueOf((oldRow.getRenban().toString()));
                }
            }
            連番 = 連番 + 1;
            row.setRenban(new RString(String.valueOf(連番)));
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

    private boolean checkState(dgdKinkyujiShoteiList_Row ddgRow, List<ShokanShoteiShikkanShisetsuRyoyo> rowList) {
        ShokanShoteiShikkanShisetsuRyoyo result = null;
        for (ShokanShoteiShikkanShisetsuRyoyo row : rowList) {
            if (ddgRow.getRenban().equals(row.get連番())) {
                result = row;
            }
        }
        if (result == null) {
            return false;
        }
        boolean 所定疾患施設療養費傷病名１flag = checkEquals(div.getTxtShoteiShikkanShobyoName1().getValue(), result.get所定疾患施設療養費傷病名１());
        boolean 所定疾患施設療養費傷病名２flag = checkEquals(div.getTxtShoteiShikkanShobyoName2().getValue(), result.get所定疾患施設療養費傷病名２());
        boolean 所定疾患施設療養費傷病名３flag = checkEquals(div.getTxtShoteiShikkanShobyoName3().getValue(), result.get所定疾患施設療養費傷病名３());
        boolean 所定疾患施設療養費開始年月日１flag = checkEquals(div.getTxtShoteiShikkanShobyoKaishiYMD1().getValue(),
                result.get所定疾患施設療養費開始年月日１() == null ? null : new RDate(result.get所定疾患施設療養費開始年月日１().toString()));
        boolean 所定疾患施設療養費開始年月日２flag = checkEquals(div.getTxtShoteiShikkanShobyoKaishiYMD2().getValue(),
                result.get所定疾患施設療養費開始年月日２() == null ? null : new RDate(result.get所定疾患施設療養費開始年月日２().toString()));
        boolean 所定疾患施設療養費開始年月日３flag = checkEquals(div.getTxtShoteiShikkanShobyoKaishiYMD3().getValue(),
                result.get所定疾患施設療養費開始年月日３() == null ? null : new RDate(result.get所定疾患施設療養費開始年月日３().toString()));
        boolean 往診日数flag = checkEquals(div.getTxtOshinNissu().getValue(), new Decimal(result.get往診日数()));
        boolean 往診医療機関名flag = checkEquals(div.getTxtOshinIryoKikanName().getValue(), result.get往診医療機関名());
        boolean 通院日数flag = checkEquals(div.getTxtTsuyinNissu().getValue(), new Decimal(result.get通院日数()));
        boolean 通院医療機関名flag = checkEquals(div.getTxtTsuinKikanName().getValue(), result.get通院医療機関名());
        boolean 所定疾患施設療養費単位数flag = checkEquals(div.getTxtShoteiShikkanTanisu().getValue(), new Decimal(result.get所定疾患施設療養費単位数()));
        boolean 所定疾患施設療養費日数flag = checkEquals(div.getTxtShoteiShikkanNissu().getValue(), new Decimal(result.get所定疾患施設療養費日数()));
        boolean 所定疾患施設療養費小計flag = checkEquals(div.getTxtShoteiShikkanSubTotal().getValue(), new Decimal(result.get所定疾患施設療養費小計()));

        boolean 緊急時傷病名１flag = checkEquals(div.getTxtKinkyuShobyoName1().getValue(), result.get緊急時傷病名１());
        boolean 緊急時傷病名２flag = checkEquals(div.getTxtKinkyuShobyoName2().getValue(), result.get緊急時傷病名２());
        boolean 緊急時傷病名３flag = checkEquals(div.getTxtKinkyuShobyoName3().getValue(), result.get緊急時傷病名３());
        boolean 緊急時治療開始年月日１flag = checkEquals(div.getTxtKinkyuChiryoKaishiYMD1().getValue(),
                result.get緊急時治療開始年月日１() == null ? null : new RDate(result.get緊急時治療開始年月日１().toString()));
        boolean 緊急時治療開始年月日２flag = checkEquals(div.getTxtKinkyuChiryoKaishiYMD2().getValue(),
                result.get緊急時治療開始年月日２() == null ? null : new RDate(result.get緊急時治療開始年月日２().toString()));
        boolean 緊急時治療開始年月日３flag = checkEquals(div.getTxtKinkyuChiryoKaishiYMD3().getValue(),
                result.get緊急時治療開始年月日３() == null ? null : new RDate(result.get緊急時治療開始年月日３().toString()));
        boolean 緊急時治療管理単位数flag = checkEquals(div.getTxtKinkyuChiryoKanriTanisu().getValue(), new Decimal(result.get緊急時治療管理単位数()));
        boolean 緊急時治療管理日数flag = checkEquals(div.getTxtKinkyuChiryoKanriNissu().getValue(), new Decimal(result.get緊急時治療管理日数()));
        boolean 緊急時治療管理小計flag = checkEquals(div.getTxtKinkyuChiryoKanriSubTotal().getValue(), new Decimal(result.get緊急時治療管理小計()));
        boolean 緊急時施設療養費合計単位数flag = checkEquals(div.getTxtTokuteiJiryoGoukei().getValue(), new Decimal(result.get緊急時施設療養費合計単位数()));

        boolean 単位数flag = checkEquals(div.getTxtRehabilitationTanisu().getValue(), new Decimal(result.getリハビリテーション単位数()));
        boolean 処置単位数flag = checkEquals(div.getTxtShujutsuTanisu().getValue(), new Decimal(result.get処置単位数()));
        boolean 放射線治療単位数flag = checkEquals(div.getTxtHoshasenChiryoTanisu().getValue(), new Decimal(result.get放射線治療単位数()));
        boolean 手術単位数flag = checkEquals(div.getTxtShochiTanisu().getValue(), new Decimal(result.get手術単位数()));
        boolean 麻酔単位数flag = checkEquals(div.getTxtMasuiTanisu().getValue(), new Decimal(result.get麻酔単位数()));
        boolean 適用flag = checkEquals(div.getTxtTekiyou().getValue(), get適用(result));

        return 所定疾患施設療養費傷病名１flag || 所定疾患施設療養費傷病名２flag || 所定疾患施設療養費傷病名３flag
                || 所定疾患施設療養費開始年月日１flag || 所定疾患施設療養費開始年月日２flag || 所定疾患施設療養費開始年月日３flag
                || 往診日数flag || 往診医療機関名flag || 通院日数flag || 通院医療機関名flag || 所定疾患施設療養費単位数flag
                || 所定疾患施設療養費日数flag || 所定疾患施設療養費小計flag || 緊急時傷病名１flag || 緊急時傷病名２flag
                || 緊急時傷病名３flag || 緊急時治療開始年月日１flag || 緊急時治療開始年月日２flag || 緊急時治療開始年月日３flag
                || 緊急時治療管理単位数flag || 緊急時治療管理日数flag || 緊急時治療管理小計flag || 緊急時施設療養費合計単位数flag
                || 単位数flag || 処置単位数flag || 放射線治療単位数flag || 手術単位数flag || 麻酔単位数flag || 適用flag;

    }

    private boolean checkEquals(Object newValue, Object oldValue) {
        if ((newValue == null && oldValue != null) || (newValue != null && oldValue == null)) {
            return true;
        } else if (newValue == null && oldValue == null) {
            return false;
        } else if (!newValue.equals(oldValue)) {
            return true;
        }
        return false;
    }

    private RString get適用(ShokanShoteiShikkanShisetsuRyoyo result) {
        RString 適用 = RString.EMPTY;
        適用 = concat適用(適用, result.get摘要１());
        適用 = concat適用(適用, result.get摘要２());
        適用 = concat適用(適用, result.get摘要３());
        適用 = concat適用(適用, result.get摘要４());
        適用 = concat適用(適用, result.get摘要５());
        適用 = concat適用(適用, result.get摘要６());
        適用 = concat適用(適用, result.get摘要７());
        適用 = concat適用(適用, result.get摘要８());
        適用 = concat適用(適用, result.get摘要９());
        適用 = concat適用(適用, result.get摘要１０());
        適用 = concat適用(適用, result.get摘要１１());
        適用 = concat適用(適用, result.get摘要１２());
        適用 = concat適用(適用, result.get摘要１３());
        適用 = concat適用(適用, result.get摘要１４());
        適用 = concat適用(適用, result.get摘要１５());
        適用 = concat適用(適用, result.get摘要１６());
        適用 = concat適用(適用, result.get摘要１７());
        適用 = concat適用(適用, result.get摘要１８());
        適用 = concat適用(適用, result.get摘要１９());
        適用 = concat適用(適用, result.get摘要２０());
        return 適用;
    }

    private RString concat適用(RString 適用, RString value) {
        if (value != null) {
            適用 = 適用.concat(value);
        }
        return 適用;
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
        if (div.getTxtHoshasenChiryoTanisu().getValue() != null) {
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
     *
     * @param keys ShoukanharaihishinseimeisaikensakuParameter
     * @param shokanShoteiShikkanShisetsuRyoyoList 償還払請求所定疾患施設療養費データ
     * @param dbJohoViewState DbJohoViewState
     * @return DbJohoViewState
     */
    public DbJohoViewState 保存処理(ShoukanharaihishinseimeisaikensakuParameter keys,
            List<ShokanShoteiShikkanShisetsuRyoyo> shokanShoteiShikkanShisetsuRyoyoList, DbJohoViewState dbJohoViewState) {

        JigyoshaNo 事業者番号 = keys.get事業者番号();
        RString 様式番号 = keys.get様式番号();
        HihokenshaNo 被保険者番号 = keys.get被保険者番号();
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().
                getValue().toDateString().substring(0, SIX));
        RString 整理番号 = keys.get整理番号();
        RString 明細番号 = keys.get明細番号();
        Map<RString, ShokanShoteiShikkanShisetsuRyoyo> map = new HashMap<>();
        for (ShokanShoteiShikkanShisetsuRyoyo entity : shokanShoteiShikkanShisetsuRyoyoList) {
            map.put(entity.get連番(), entity);
        }

        List<ShokanShoteiShikkanShisetsuRyoyo> list = new ArrayList<>();

        for (dgdKinkyujiShoteiList_Row row : div.getDgdKinkyujiShoteiList().getDataSource()) {
            if (RowState.Added == row.getRowState()) {
                ShokanShoteiShikkanShisetsuRyoyo entity = new ShokanShoteiShikkanShisetsuRyoyo(
                        被保険者番号, 提供購入年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                        new RString(String.format(書式.toString(), Integer.valueOf(row.getRenban().toString()))));
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

            ShokanKihon kihon = null;
            Integer updateNum = null;
            List<ShokanKihon> kihonList = dbJohoViewState.get償還払請求基本データList();
            if (kihonList == null) {
                kihonList = new ArrayList<>();
            }
            if (!kihonList.isEmpty()) {
                Map<Integer, ShokanKihon> kihonMap = getShokanKihonMap(kihonList, keys);
                for (Map.Entry<Integer, ShokanKihon> mapValue : kihonMap.entrySet()) {
                    kihon = mapValue.getValue();
                    updateNum = mapValue.getKey();
                    break;
                }
            }
            kihon = set基本情報(kihon);
            dbJohoViewState.set償還払請求所定疾患施設療養費等データList(new ArrayList<>(list));
            if (kihon != null && updateNum != null) {
                kihonList.set(updateNum, kihon);
                dbJohoViewState.set償還払請求基本データList(new ArrayList<>(kihonList));
            }
        }
        return dbJohoViewState;
    }

    private ShokanShoteiShikkanShisetsuRyoyo buildEntity(ShokanShoteiShikkanShisetsuRyoyo entity,
            dgdKinkyujiShoteiList_Row row) {
        ShokanShoteiShikkanShisetsuRyoyoBuilder builder = entity.createBuilderForEdit();
        builder = clear2(builder);
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

    private ShokanShoteiShikkanShisetsuRyoyoBuilder clear2(ShokanShoteiShikkanShisetsuRyoyoBuilder builder) {
        builder.set緊急時治療開始年月日１(null).set緊急時治療開始年月日２(null).
                set緊急時治療開始年月日３(null).set所定疾患施設療養費開始年月日１(null).
                set所定疾患施設療養費開始年月日２(null).set所定疾患施設療養費開始年月日３(null).
                set摘要１(null).set摘要２(null).set摘要３(null).set摘要４(null).
                set摘要５(null).set摘要６(null).set摘要７(null).set摘要８(null).
                set摘要８(null).set摘要９(null).set摘要１０(null).set摘要１１(null).
                set摘要１２(null).set摘要１３(null).set摘要１４(null).set摘要１５(null).
                set摘要１６(null).set摘要１７(null).set摘要１８(null).set摘要１９(null).
                set摘要２０(null).build();
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
        div.getDgdKinkyujiShoteiList().setReadOnly(true);
        div.getPanelDetail().setDisplayNone(true);
    }

    /**
     * 「修正ボタン」押下設置
     */
    public void click_Modify() {
        div.getPanelDetail().setDisplayNone(false);
        div.getPanelDetail().getPanelShobyoName().setDisabled(false);
        div.getPanelDetail().getPanelOshinTuyin().setDisabled(false);
        div.getPanelDetail().getPanelJiryoutensu().setDisabled(false);
        div.setRowId(new RString(String.valueOf(div.getDgdKinkyujiShoteiList().getClickedRowId())));
    }

    /**
     * 「削除ボタン」押下設置
     */
    public void click_Delete() {
        div.getPanelDetail().setDisplayNone(false);
        div.getPanelDetail().getPanelShobyoName().setDisabled(true);
        div.getPanelDetail().getPanelOshinTuyin().setDisabled(true);
        div.getPanelDetail().getPanelJiryoutensu().setDisabled(true);
        div.getPanelDetail().getBtnClear().setDisabled(true);
        div.setRowId(new RString(String.valueOf(div.getDgdKinkyujiShoteiList().getClickedRowId())));
    }

    /**
     * 「取消ボタン」押下設置
     */
    public void click_Cancel() {
        div.getBtnAdd().setDisabled(false);
        div.getPanelDetail().setDisplayNone(true);
    }

    /**
     * 「確定ボタン」押下設置
     *
     * @param state RString
     * @param rowList ShokanShoteiShikkanShisetsuRyoyo
     */
    public void click_Confirm(RString state, List<ShokanShoteiShikkanShisetsuRyoyo> rowList) {
        div.getBtnAdd().setDisabled(false);
        div.getPanelDetail().setDisplayNone(true);

        List<dgdKinkyujiShoteiList_Row> list = div.getDgdKinkyujiShoteiList().getDataSource();
        if (登録.equals(state)) {
            if (!RString.EMPTY.equals(div.getRowId())) {
                dgdKinkyujiShoteiList_Row row = getSelectedRow();
                confirm(row, state, rowList, list);
                list.set(Integer.parseInt(div.getRowId().toString()), row);
            } else {
                dgdKinkyujiShoteiList_Row row = new dgdKinkyujiShoteiList_Row();
                confirm(row, state, rowList, list);
                list.add(row);
            }
        } else if (登録_削除.equals(state)) {
            dgdKinkyujiShoteiList_Row row = getSelectedRow();
            confirm(row, state, rowList, list);
        } else {
            dgdKinkyujiShoteiList_Row row = getSelectedRow();
            confirm(row, state, rowList, list);
            list.set(Integer.parseInt(div.getRowId().toString()), row);
        }
        div.getDgdKinkyujiShoteiList().setDataSource(list);
    }

    private Map<Integer, ShokanKihon> getShokanKihonMap(
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

    private ShokanKihon set基本情報(ShokanKihon kihon) {
        if (kihon == null) {
            return null;
        }
        Decimal 金額合計 = Decimal.ZERO;
        List<dgdKinkyujiShoteiList_Row> rowList = div.getDgdKinkyujiShoteiList().getDataSource();
        for (dgdKinkyujiShoteiList_Row row : rowList) {
            if (row.getRowState() != RowState.Deleted) {
                Decimal 緊急時施設療養費合計単位数 = get金額(row.getKinkyuRyoyohiGokeiTaniSu().getValue());
                Decimal 所定疾患施設療養費小計 = get金額(row.getShoteiTaniGokei().getValue());
                金額合計 = 緊急時施設療養費合計単位数.add(所定疾患施設療養費小計);
            }
        }
        kihon = kihon.createBuilderForEdit().set緊急時施設療養費請求額(金額合計).build();
        kihon = kihon.modified();
        return kihon;
    }

    private List<ShokanShoteiShikkanShisetsuRyoyo> getUpdateList(
            List<ShokanShoteiShikkanShisetsuRyoyo> allList, ShoukanharaihishinseimeisaikensakuParameter parameter) {
        List<ShokanShoteiShikkanShisetsuRyoyo> updateList = new ArrayList<>();
        for (ShokanShoteiShikkanShisetsuRyoyo ryoyo : allList) {
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

    private Decimal get金額(Decimal 金額) {
        if (金額 == null) {
            金額 = Decimal.ZERO;
        }
        return 金額;
    }

}
