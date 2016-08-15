/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.JigyouKogakuKyuufuTaishouResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntityResult;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private static final RString 合 = new RString("合");
    private static final RString 老 = new RString("老");
    private static final RString 緩１ = new RString("緩１");
    private static final RString 緩2 = new RString("緩2");
    private static final RString コンマ = new RString(",");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

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
     * @param 履歴番号 int
     */
    public void 画面初期化(RString メニューID, RString 画面モード, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, int 履歴番号) {
        if ((高額サービス費支給申請書登録.equals(メニューID) || 高額介護サービス費照会.equals(メニューID))) {
            List<KogakuKyuufuTaishouListEntityResult> 高額給付対象一覧
                    = KogakuKyuufuTaishouList.createInstance().getKogakuKyuufuTaishouList(被保険者番号, サービス提供年月);
            ViewStateHolder.put(ViewStateKeys.高額給付対象一覧, (Serializable) 高額給付対象一覧);
            set高額給付対象一覧(高額給付対象一覧);
        } else if ((総合事業高額サービス費支給申請書登録.equals(メニューID)
                || 総合事業高額介護サービス費照会.equals(メニューID))) {
            List<JigyouKogakuKyuufuTaishouResult> 事業高額給付対象一覧
                    = KogakuKyuufuTaishouList.createInstance().
                    getJigyouKogakuKyuufuTaishouList(被保険者番号, サービス提供年月);
            set事業高額高額給付対象一覧(事業高額給付対象一覧);
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
            if (ONE_RS.equals(koEntity.get明細合計区分())) {
                row.setData1(koEntity.get給付対象者明細entity().get事業者番号().value());
                row.setData2(koEntity.get事業者名());
                row.setData3(koEntity.getサービス種類());
                row.getData4().setValue(koEntity.get給付対象者明細entity().getサービス費用合計額());
                row.getData5().setValue(koEntity.get給付対象者明細entity().get利用者負担額());
                row.setData9(koEntity.get給付対象者明細entity().get高額給付根拠());
                row.setData10(ONE_RS);
                row.setData11(koEntity.get給付対象者明細entity().getサービス種類コード().value());
                row.getData12().setValue(koEntity.get給付対象者明細entity().get被保険者番号().value());
                row.getData13().setValue(new RString(koEntity.get給付対象者明細entity().getサービス提供年月().toString()));
                row.getData14().setValue(new Decimal(koEntity.get給付対象者明細entity().get履歴番号()));
            } else if (TWO_RS.equals(koEntity.get明細合計区分())) {
                row.setData3(合計);
                row.getData4().setValue(koEntity.get給付対象者合計entity().getサービス費用合計額合計());
                row.getData5().setValue(koEntity.get給付対象者合計entity().get利用者負担額合計());
                row.getData6().setValue(koEntity.get給付対象者合計entity().get算定基準額());
                row.getData7().setValue(koEntity.get給付対象者合計entity().get支払済金額合計());
                row.getData8().setValue(koEntity.get給付対象者合計entity().get高額支給額());
                row.setData10(TWO_RS);
                row.getData12().setValue(koEntity.get給付対象者合計entity().get被保険者番号().value());
                row.getData13().setValue(koEntity.get給付対象者合計entity().getサービス提供年月().toDateString());
                row.getData14().setValue(koEntity.get給付対象者合計entity().get履歴番号());
            }
            rowList.add(row);
        }
        div.getDgTaishoshaIchiran().setDataSource(rowList);
    }

    /**
     * 高額給付対象一覧情報を抽出する
     *
     * @param koTaList List<KogakuKyuufuTaishouListEntityResult>
     */
    public void set事業高額高額給付対象一覧(List<JigyouKogakuKyuufuTaishouResult> koTaList) {
        List<dgTaishoshaIchiran_Row> rowList = new ArrayList<>();
        for (JigyouKogakuKyuufuTaishouResult koEntity : koTaList) {
            dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row();
            if (ONE_RS.equals(koEntity.get明細合計区分())) {
                row.setData1(koEntity.get給付対象者明細entity().get事業者番号().value());
                row.setData2(koEntity.get事業者名());
                row.setData3(koEntity.getサービス種類());
                row.getData4().setValue(koEntity.get給付対象者明細entity().getサービス費用合計額());
                row.getData5().setValue(koEntity.get給付対象者明細entity().get利用者負担額());
                row.setData9(koEntity.get給付対象者明細entity().get事業高額給付根拠());
                row.setData10(ONE_RS);
                row.setData11(koEntity.get給付対象者明細entity().getサービス種類コード().value());
            } else if (TWO_RS.equals(koEntity.get明細合計区分())) {
                row.setData3(合計);
                row.getData4().setValue(koEntity.get給付対象者合計entity().getサービス費用合計額合計());
                row.getData5().setValue(koEntity.get給付対象者合計entity().get利用者負担額合計());
                row.getData6().setValue(koEntity.get給付対象者合計entity().get算定基準額());
                row.getData7().setValue(koEntity.get給付対象者合計entity().get支払済金額合計());
                row.getData8().setValue(koEntity.get給付対象者合計entity().get事業高額支給額());
                row.setData10(TWO_RS);
            }
            rowList.add(row);
        }
        div.getDgTaishoshaIchiran().setDataSource(rowList);
    }

    public List<dgTaishoshaIchiran_Row> get給付対象一覧() {
        return div.getDgTaishoshaIchiran().getDataSource();
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

    private void get高額明細合計データ編集エリア(dgTaishoshaIchiran_Row row, RString 処理モード,
            FlexibleYearMonth サービス提供年月) {
        row.setData1(div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue());
        row.setData2(div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().getValue());
        row.getData4().setValue(div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().getValue());
        row.getData5().setValue(div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue());
        if (div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue() != null) {
            row.getData6().setValue(div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue());
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().getValue() != null) {
            row.getData7().setValue(div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().getValue());
        }
        //TODO
        row.getData8().setValue(div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().getValue().
                add(div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue()));
        if (div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().getSelectedKey().equals(ONE_RS)) {
            row.setData10(ONE_RS);
            row.setData3(div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().getValue());
        } else {
            row.setData10(TWO_RS);
            row.setData3(合計);
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue() != null
                && !div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue().isEmpty()) {
            row.setData11(div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue());
        }
        RStringBuilder builder = new RStringBuilder();
        if (サービス提供年月 != null && サービス提供年月.compareTo(new FlexibleYearMonth(平成17年10月)) <= 0) {
            if (div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().getSelectedKey().equals(key0)) {
                builder.append(月);
                builder.append(コンマ);
            }
            if (div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey().equals(key0)) {
                builder.append(低);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey().equals(key1)) {
                builder.append(市);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey().equals(key2)) {
                builder.append(生);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey().equals(key3)) {
                builder.append(現);
                builder.append(コンマ);
            }
            if (div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey().equals(key0)) {
                builder.append(低);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey().equals(key1)) {
                builder.append(市);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey().equals(key2)) {
                builder.append(生);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey().equals(key3)) {
                builder.append(現);
                builder.append(コンマ);
            }
            if (div.getMeisaiGokeiHenshuPanel().getRdbGassan().getSelectedKey().equals(key0)) {
                builder.append(単);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbGassan().getSelectedKey().equals(key1)) {
                builder.append(合);
                builder.append(コンマ);
            }
            if (div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().getSelectedKey().equals(key0)) {
                builder.append(老);
                builder.append(コンマ);
            }
            row.setData9(builder.toRString());
        } else if (サービス提供年月 != null && new FlexibleYearMonth(平成17年11月).compareTo(サービス提供年月) <= 0) {
            if (div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey().equals(key0)) {
                builder.append(低);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey().equals(key1)) {
                builder.append(市);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey().equals(key2)) {
                builder.append(生);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey().equals(key3)) {
                builder.append(現);
                builder.append(コンマ);
            }
            if (div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey().equals(key0)) {
                builder.append(低);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey().equals(key1)) {
                builder.append(市);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey().equals(key2)) {
                builder.append(生);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey().equals(key3)) {
                builder.append(現);
                builder.append(コンマ);
            }
            if (div.getMeisaiGokeiHenshuPanel().getRdbGassan().getSelectedKey().equals(key0)) {
                builder.append(単);
                builder.append(コンマ);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbGassan().getSelectedKey().equals(key1)) {
                builder.append(合);
                builder.append(コンマ);
            }
            if (div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().getSelectedKey().equals(key0)) {
                builder.append(老);
                builder.append(コンマ);
            }
            if (div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().getSelectedKey().equals(key1)) {
                builder.append(緩１);
            } else if (div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().getSelectedKey().equals(key2)) {
                builder.append(緩１);
            }
            row.setData9(builder.toRString());
        }
        if (追加.equals(処理モード)) {
            List<dgTaishoshaIchiran_Row> list = div.getDgTaishoshaIchiran().getDataSource();
            list.add(row);
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
            div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setDisabled(true);
            div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setDisabled(true);
        } else if (サービス提供年月 != null && new FlexibleYearMonth(平成17年11月).compareTo(サービス提供年月) <= 0) {
            div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().setDisabled(true);
            div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbGassan().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setDisabled(false);
            div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setDisabled(false);
        }
    }

    /**
     * 画面制御
     *
     * @param flag boolean
     */
    public void 画面制御(boolean flag) {
        div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getBtnJgyosha().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getBtnServiceSyurui().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getRdbGassan().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getBtnTorikeshi().setDisabled(flag);
        div.getMeisaiGokeiHenshuPanel().getBtnkakutei().setDisabled(flag);
    }

    public void 削除制御() {
        div.getMeisaiGokeiHenshuPanel().getBtnTorikeshi().setDisabled(false);
        div.getMeisaiGokeiHenshuPanel().getBtnkakutei().setDisabled(false);
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
     * @param サービス提供年月 FlexibleYearMonth
     */
    public void modifyRow(dgTaishoshaIchiran_Row row, RString state, FlexibleYearMonth サービス提供年月) {
        if (修正.equals(state)) {
            boolean flag = checkState(row);
            if (flag) {
                row.setData0(修正);
            }
            get高額明細合計データ編集エリア(row, state, サービス提供年月);
        } else if (追加.equals(state)) {
            row.setData0(追加);
            get高額明細合計データ編集エリア(row, state, サービス提供年月);
        } else if (削除.equals(state)) {
            if (追加.equals(row.getData0())) {
                div.getDgTaishoshaIchiran().getDataSource().remove(div.getRowId().getValue().intValue());
                clear高額明細合計データ編集エリア();
            } else {
                row.setData0(削除);
                div.getDgTaishoshaIchiran().getClickedItem().setDeleteButtonState(DataGridButtonState.Disabled);
                div.getDgTaishoshaIchiran().getClickedItem().setModifyButtonState(DataGridButtonState.Disabled);
                get高額明細合計データ編集エリア(row, state, サービス提供年月);
            }

        }

        画面制御(true);
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
        画面制御(true);
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
        if (div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue() == null
                && ddgRow.getData5() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue().
                equals(ddgRow.getData5().getValue()))) {
            return true;
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue() == null
                && ddgRow.getData6() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue().
                equals(ddgRow.getData6().getValue()))) {
            return true;
        }
        if (div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().getSelectedKey() == null
                && ddgRow.getData10() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().getSelectedKey() != null
                && !(div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().getSelectedKey().
                equals(ddgRow.getData10()))) {
            return true;
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue() == null
                && ddgRow.getData11() != null) {
            return true;
        } else if (div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue() != null
                && !(div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue().
                equals(ddgRow.getData11()))) {
            return true;
        }
        return !ddgRow.getData7().getValue().equals(
                div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().getValue());
    }

    /**
     * 明細合計区分を取得します。
     *
     * @return RString
     */
    public RString get明細合計区分() {
        return div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().getSelectedKey();
    }

    /**
     * 事業者コードを取得します。
     *
     * @return RString
     */
    public RString get事業者コード() {
        return div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return RString
     */
    public RString get事業者名称() {
        return div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().getValue();
    }

    /**
     * サービス種類を取得します。
     *
     * @return RString
     */
    public RString getサービス種類() {
        return div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue();
    }

    /**
     * サービス種類名称を取得します。
     *
     * @return RString
     */
    public RString getサービス種類名称() {
        return div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().getValue();
    }

    /**
     * サービス費用合計を取得します。
     *
     * @return Decimal
     */
    public Decimal getサービス費用合計() {
        return div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().getValue();
    }

    /**
     * 利用者負担合計を取得します。
     *
     * @return Decimal
     */
    public Decimal get利用者負担合計() {
        return div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue();
    }

    /**
     * 算定基準額を取得します。
     *
     * @return Decimal
     */
    public Decimal get算定基準額() {
        return div.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku().getValue();
    }

    /**
     * 支払済額を取得します。
     *
     * @return Decimal
     */
    public Decimal get支払済額() {
        return div.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku().getValue();
    }

    /**
     * 月遅れ区分を取得します。
     *
     * @return RString
     */
    public RString get月遅れ区分() {
        return div.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure().getSelectedKey();
    }

    /**
     * 世帯所得区分を取得します。
     *
     * @return RString
     */
    public RString get世帯所得区分() {
        return div.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun().getSelectedKey();
    }

    /**
     * 本人所得区分を取得します。
     *
     * @return RString
     */
    public RString get本人所得区分() {
        return div.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun().getSelectedKey();
    }

    /**
     * 合算区分を取得します。
     *
     * @return RString
     */
    public RString get合算区分() {
        return div.getMeisaiGokeiHenshuPanel().getRdbGassan().getSelectedKey();
    }

    /**
     * 老齢福祉年金を取得します。
     *
     * @return RString
     */
    public RString get老齢福祉年金() {
        return div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().getSelectedKey();
    }

    /**
     * 利用者負担第２段階を取得します。
     *
     * @return RString
     */
    public RString get利用者負担第２段階() {
        return div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().getSelectedKey();
    }

    /**
     * 利用者負担第２段階を取得します。
     *
     * @return RString
     */
    public RString get激変緩和区分() {
        return div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().getSelectedKey();
    }
}
