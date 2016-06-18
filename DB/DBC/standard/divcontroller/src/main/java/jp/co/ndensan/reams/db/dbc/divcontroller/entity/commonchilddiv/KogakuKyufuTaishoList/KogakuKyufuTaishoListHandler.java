/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntityResult;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBCKD00006_高額給付対象一覧共有子Div
 *
 * @reamsid_L DBC-2020-030 quxiaodong
 */
public class KogakuKyufuTaishoListHandler {

    private final KogakuKyufuTaishoListDiv div;
    private static final RString ONE_RS = new RString("1");
    private static final RString TWO_RS = new RString("2");
    private static final RString 高額サービス費支給申請書登録 = new RString("DBCMN42001");
    private static final RString 高額介護サービス費照会 = new RString("DBCMN11004");
    private static final RString 総合事業高額サービス費支給申請書登録 = new RString("DBCMN42002");
    private static final RString 総合事業高額介護サービス費照会 = new RString("DBCMN11016");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 明細編集モード = new RString("明細編集モード");
    private static final RString 合計 = new RString("合計");
    private static final RString 平成17年10月 = new RString("200510");
    private static final RString 平成17年11月 = new RString("200511");
    private static final RString key0 = new RString("key0");
    private static final RString key1 = new RString("key1");
    private static final RString key2 = new RString("key2");
    private static final RString key3 = new RString("key3");
    private static final RString 月 = new RString("月");
    private static final RString 低 = new RString("低");
    private static final RString 市 = new RString("市");
    private static final RString 生 = new RString("生");
    private static final RString 現 = new RString("現");
    private static final RString 単 = new RString("単");
    private static final RString 老 = new RString("老");
    private static final RString 緩１ = new RString("緩１");
    private static final RString 緩2 = new RString("緩2");
    private static final RString コンマ = new RString(",");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");

    /**
     * コンストラクタです。
     *
     * @param div KogakuKyufuTaishoListDiv
     */
    public KogakuKyufuTaishoListHandler(KogakuKyufuTaishoListDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KogakuKyufuTaishoListDiv
     */
    public static KogakuKyufuTaishoListHandler of(KogakuKyufuTaishoListDiv div) {
        return new KogakuKyufuTaishoListHandler(div);
    }

    /**
     * 画面初期化
     *
     * @param メニューID RString
     * @param 画面モード RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 RString
     */
    public void 画面初期化(RString メニューID, RString 画面モード, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 履歴番号) {
        if ((高額サービス費支給申請書登録.equals(メニューID) || 高額介護サービス費照会.equals(メニューID))) {
            List<KogakuKyuufuTaishouListEntityResult> 高額給付対象一覧
                    = KogakuKyuufuTaishouList.createInstance().getKogakuKyuufuTaishouList(被保険者番号, サービス提供年月);
            set高額給付対象一覧(高額給付対象一覧);
        } else if ((総合事業高額サービス費支給申請書登録.equals(メニューID)
                || 総合事業高額介護サービス費照会.equals(メニューID))) {
            List<KogakuKyuufuTaishouListEntityResult> 事業高額給付対象一覧
                    = KogakuKyuufuTaishouList.createInstance().
                    getJigyouKogakuKyuufuTaishouList(被保険者番号, サービス提供年月);
            set高額給付対象一覧(事業高額給付対象一覧);
        }
        if (照会モード.equals(画面モード)) {
            set照会モード();
        } else if (明細編集モード.equals(画面モード)) {
            set明細編集モード();
        }
    }

    /**
     * 高額給付対象一覧情報を抽出する
     *
     * @param koTaList List<KogakuKyuufuTaishouListEntityResult>
     */
    public void set高額給付対象一覧(List<KogakuKyuufuTaishouListEntityResult> koTaList) {
        List<dgTaishoshaIchiran_Row> rowList = new ArrayList<>();
        for (KogakuKyuufuTaishouListEntityResult koEntity : koTaList) {
            dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row();
            if (koEntity.getEntity().get事業者番号() != null && ONE_RS.equals(koEntity.getEntity().get明細合計区分())) {
                row.setData1(koEntity.getEntity().get事業者番号().value());
            }
            if (ONE_RS.equals(koEntity.getEntity().get明細合計区分())) {
                row.setData2(koEntity.getEntity().get事業者名());
            }
            if (ONE_RS.equals(koEntity.getEntity().get明細合計区分())) {
                row.setData3(koEntity.getEntity().getサービス種類());
            } else {
                row.setData3(合計);
            }
            if (ONE_RS.equals(koEntity.getEntity().get明細合計区分())
                    && koEntity.getEntity().getサービス費用合計額() != null) {
                row.getData4().setValue(koEntity.getEntity().getサービス費用合計額());
            } else if (TWO_RS.equals(koEntity.getEntity().get明細合計区分())
                    && koEntity.getEntity().getサービス費用合計額合計() != null) {
                row.getData4().setValue(koEntity.getEntity().getサービス費用合計額合計());
            }
            if (ONE_RS.equals(koEntity.getEntity().get明細合計区分())
                    && koEntity.getEntity().get利用者負担額() != null) {
                row.getData5().setValue(koEntity.getEntity().get利用者負担額());
            } else if (TWO_RS.equals(koEntity.getEntity().get明細合計区分())
                    && koEntity.getEntity().get利用者負担額合計() != null) {
                row.getData5().setValue(koEntity.getEntity().get利用者負担額合計());
            }
            if (koEntity.getEntity().get算定基準額() != null) {
                row.getData6().setValue(koEntity.getEntity().get算定基準額());
            }
            if (koEntity.getEntity().get支払済金額合計() != null) {
                row.getData7().setValue(koEntity.getEntity().get支払済金額合計());
            }
            if (koEntity.getEntity().get高額支給額() != null) {
                row.getData8().setValue(koEntity.getEntity().get高額支給額());
            }
            row.setData9(koEntity.getEntity().get高額給付根拠());
            row.setData10(koEntity.getEntity().get明細合計区分());
            if (koEntity.getEntity().getサービス種類コード() != null
                    && ONE_RS.equals(koEntity.getEntity().get明細合計区分())) {
                row.setData11(koEntity.getEntity().getサービス種類コード().value());
            }
            rowList.add(row);
        }
        div.getDgTaishoshaIchiran().setDataSource(rowList);
    }

    /**
     * 高額明細合計データ編集エリア
     *
     * @param サービス提供年月 FlexibleYearMonth
     */
    public void set高額明細合計データ編集エリア(FlexibleYearMonth サービス提供年月) {
        dgTaishoshaIchiran_Row row = div.getDgTaishoshaIchiran().getClickedItem();
        div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().setSelectedKey(row.getData10());
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().setValue(row.getData1());
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().setValue(row.getData2());
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().setValue(row.getData11());
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().setValue(row.getData3());
        if (row.getData4().getValue() != null) {
            div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().setValue(row.getData4().getValue());
        }
        if (row.getData5().getValue() != null) {
            div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().setValue(row.getData5().getValue());
        }
        if (row.getData6().getValue() != null) {
            div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().setValue(row.getData6().getValue());
        }
        if (row.getData7().getValue() != null) {
            div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().setValue(row.getData7().getValue());
        }
        if (row.getData9() != null && !row.getData9().isEmpty()) {
            set高額判定根拠(サービス提供年月, row.getData9());
        }
        div.getRowId().setValue(new Decimal(row.getId()));
    }

    private void set高額判定根拠(FlexibleYearMonth サービス提供年月, RString 高額判定根拠) {
        if (サービス提供年月 != null && サービス提供年月.compareTo(new FlexibleYearMonth(平成17年10月)) <= 0) {
            if (高額判定根拠.contains(月)) {
                div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().setSelectedKey(key0);
            } else {
                div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().setSelectedKey(key1);
            }
            List<RString> list = 高額判定根拠.split(コンマ.toString());
            if (list.get(1).equals(低)) {
                div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key0);
            } else if (list.get(1).equals(市)) {
                div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key1);
            } else if (list.get(1).equals(生)) {
                div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key2);
            } else if (list.get(1).equals(現)) {
                div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key3);
            }
            if (list.get(2).equals(低)) {
                div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key0);
            } else if (list.get(2).equals(市)) {
                div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key1);
            } else if (list.get(2).equals(生)) {
                div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key2);
            } else if (list.get(2).equals(現)) {
                div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key3);
            }
            if (高額判定根拠.contains(単)) {
                div.getMeisaiGokeiHenshuPanel().getRdbGassan().setSelectedKey(key0);
            } else {
                div.getMeisaiGokeiHenshuPanel().getRdbGassan().setSelectedKey(key1);
            }
            if (高額判定根拠.contains(老)) {
                div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setSelectedKey(key0);
            } else {
                div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setSelectedKey(key1);
            }
        } else if (サービス提供年月 != null && new FlexibleYearMonth(平成17年11月).compareTo(サービス提供年月) <= 0) {
            List<RString> list = 高額判定根拠.split(コンマ.toString());
            if (list.get(0).equals(低)) {
                div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key0);
            } else if (list.get(0).equals(市)) {
                div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key1);
            } else if (list.get(0).equals(生)) {
                div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key2);
            } else if (list.get(0).equals(現)) {
                div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key3);
            }
            if (list.get(1).equals(低)) {
                div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key0);
            } else if (list.get(1).equals(市)) {
                div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key1);
            } else if (list.get(1).equals(生)) {
                div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key2);
            } else if (list.get(1).equals(現)) {
                div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key3);
            }
            if (高額判定根拠.contains(単)) {
                div.getMeisaiGokeiHenshuPanel().getRdbGassan().setSelectedKey(key0);
            } else {
                div.getMeisaiGokeiHenshuPanel().getRdbGassan().setSelectedKey(key1);
            }
            if (高額判定根拠.contains(老)) {
                div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setSelectedKey(key0);
            } else {
                div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setSelectedKey(key1);
            }
            if (高額判定根拠.contains(TWO_RS)) {
                div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setSelectedKey(key0);
            } else {
                div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setSelectedKey(key1);
            }
            if (高額判定根拠.contains(緩１)) {
                div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setSelectedKey(key1);
            } else if (高額判定根拠.contains(緩2)) {
                div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setSelectedKey(key2);
            } else {
                div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setSelectedKey(key0);
            }
        }
    }

    /**
     * 修正制御
     *
     * @param サービス提供年月 FlexibleYearMonth
     */
    public void 修正制御(FlexibleYearMonth サービス提供年月) {
        if (サービス提供年月 != null && サービス提供年月.compareTo(new FlexibleYearMonth(平成17年10月)) <= 0) {
            div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbGassan().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setDisabled(false);
        } else if (サービス提供年月 != null && new FlexibleYearMonth(平成17年11月).compareTo(サービス提供年月) <= 0) {
            div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbGassan().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setDisabled(false);
        }
        div.getMeisaiGokeiHenshuPanel().getBtnTorikeshi().setDisabled(false);
        div.getMeisaiGokeiHenshuPanel().getBtnkakutei().setDisabled(false);
    }

    /**
     * 削除制御
     *
     *
     */
    public void 削除制御() {
        div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getBtnJgyosha().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getBtnServiceSyurui().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getRdbGassan().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setDisabled(true);
    }

    /**
     * 高額明細合計データ編集エリア一覧に内容を反映する。
     *
     * @param row dgTaishoshaIchiran_Row
     */
    public void get高額明細合計データ編集エリア(dgTaishoshaIchiran_Row row) {
        row.setData1(div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue());
        row.setData2(div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().getValue());
        row.setData3(div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().getValue());
        row.getData4().setValue(div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().getValue());
        row.getData5().setValue(div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue());
        if (div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue() != null) {
            row.getData6().setValue(div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue());
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().getValue() != null) {
            row.getData7().setValue(div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().getValue());
        }
    }

    /**
     * selectRow
     *
     * @return dgTaishoshaIchiran_Row
     */
    public dgTaishoshaIchiran_Row selectRow() {
        return div.getDgTaishoshaIchiran().getDataSource().get(
                Integer.parseInt(div.getRowId().getValue().toString()));
    }

    /**
     * modifyRow
     *
     * @param row dgTaishoshaIchiran_Row
     * @param state RString
     */
    public void modifyRow(dgTaishoshaIchiran_Row row, RString state) {
        if (修正.equals(state)) {
            boolean flag = checkState(row);
            if (flag) {
                row.setData0(修正);
                get高額明細合計データ編集エリア(row);
            }
        } else if (追加.equals(state)) {
            row.setData0(追加);
            get高額明細合計データ編集エリア(row);
        }
        高額明細合計データ編集非活性(true);
    }

    /**
     * 高額明細合計データ編集活性
     *
     * @param flag boolean
     */
    public void 高額明細合計データ編集非活性(boolean flag) {
        div.getMeisaiGokeiHenshuPanel().setDisabled(flag);
    }

    /**
     * 照会モード設定
     */
    public void set照会モード() {
        div.getBtnTsuika().setVisible(false);
        div.getDgTaishoshaIchiran().getGridSetting().setIsShowModifyButtonColumn(false);
        div.getDgTaishoshaIchiran().getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getDgTaishoshaIchiran().getGridSetting().getColumns().get(2).setVisible(false);
        div.getMeisaiGokeiHenshuPanel().setDisplayNone(true);
        div.getDgTaishoshaIchiran().getGridSetting().getColumns().get(0).setVisible(false);
    }

    /**
     * 明細編集モード設定
     */
    public void set明細編集モード() {
        div.getMeisaiGokeiHenshuPanel().setDisabled(true);
        div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().setSelectedKey(key1);
        div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key1);
        div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key1);
    }

    /**
     * clear高額明細合計データ編集エリア
     */
    public void clear高額明細合計データ編集エリア() {
        div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().setSelectedKey(ONE_RS);
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().clearValue();
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().clearValue();
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().clearValue();
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().clearValue();
        div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().clearValue();
        div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().clearValue();
        div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().clearValue();
        div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().clearValue();
        div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().setSelectedKey(key1);
        div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setSelectedKey(key1);
        div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setSelectedKey(key1);
        div.getMeisaiGokeiHenshuPanel().getRdbGassan().setSelectedKey(key0);
        div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setSelectedKey(key0);
        div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setSelectedKey(key0);
        div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setSelectedKey(key0);
    }

    private boolean checkState(dgTaishoshaIchiran_Row ddgRow) {
        if (div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue() == null && ddgRow.getData1() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue().equals(ddgRow.getData1()))) {
            return true;
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().getValue() == null && ddgRow.getData2() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().getValue().equals(ddgRow.getData2()))) {
            return true;
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().getValue() == null && ddgRow.getData3() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().getValue().equals(ddgRow.getData3()))) {
            return true;
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().getValue() == null && ddgRow.getData4() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().getValue().
                equals(ddgRow.getData4().getValue()))) {
            return true;
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue() == null && ddgRow.getData5() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue().
                equals(ddgRow.getData5().getValue()))) {
            return true;
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue() == null && ddgRow.getData6() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue().
                equals(ddgRow.getData6().getValue()))) {
            return true;
        }
        return !ddgRow.getData7().getValue().equals(div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().getValue());
    }
}
