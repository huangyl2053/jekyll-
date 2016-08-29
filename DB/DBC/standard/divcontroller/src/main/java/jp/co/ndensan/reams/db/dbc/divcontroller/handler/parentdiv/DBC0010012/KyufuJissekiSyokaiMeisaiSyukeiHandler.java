/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.dgKyufuJissekiShukei_Row;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 給付実績照会_明細集計画面処理handlerクラスです。
 *
 * @reamsid_L DBC-2970-040 wangxiaodong
 */
public class KyufuJissekiSyokaiMeisaiSyukeiHandler {

    private static final FlexibleYearMonth 平成24年4月 = new FlexibleYearMonth("201204");
    private static final RString 任意設定可 = new RString("2");
    private static final RString 非活性 = new RString("0");
    private static final RString 前月 = new RString("前月");
    private static final RString 前事業者 = new RString("前事業者");
    private static final int 年の初月 = 1;
    private static final int 年の末月 = 12;
    private final KyufuJissekiSyokaiMeisaiSyukeiDiv div;

    /**
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     */
    public KyufuJissekiSyokaiMeisaiSyukeiHandler(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 整理番号 RString
     * @param サービス提供年月 FlexibleYearMonth
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void load共有子Div(HihokenshaNo 被保険者番号, RString 整理番号, FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 識別番号) {
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, サービス提供年月, 整理番号, 識別番号);
    }

    /**
     * 画面のデータを初期化する。
     *
     * @param 給付実績緊急時施設療養データ取得 List<KyufujissekiKinkyuShisetsuRyoyo>
     */
    public void setDataGrid(List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得) {
        List<dgKyufuJissekiShukei_Row> rowList = new ArrayList<>();
        int size = 給付実績緊急時施設療養データ取得.size();
        for (int index = 0; index < size; index++) {
            rowList.add(getデータ(index, 給付実績緊急時施設療養データ取得));
//            rowList.add(get後のデータ(index, 給付実績緊急時施設療養データ取得));
        }
        div.getDgKyufuJissekiShukei().setDataSource(rowList);

    }

    private dgKyufuJissekiShukei_Row getデータ(int index, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績情報) {
        dgKyufuJissekiShukei_Row row = new dgKyufuJissekiShukei_Row();
        row.setTxtJitsuNissu(給付実績情報.get(index).get緊急時施設療養情報レコード順次番号());
//        row.setTxtKinkyuKubun(給付実績情報.get(index).get緊急時施設療養情報レコード順次番号());
//        row.getTxtShobyoName().setValue(set緊急時傷病名(給付実績情報.get(index)));
//        row.getTxtChiryoKaishiYMD().setValue(set緊急時治療開始年月日(給付実績情報.get(index)));
//        row.setTxtKettei(RString.EMPTY);
//        row.setTxtOshinIryoKikanName(給付実績情報.get(index).get往診医療機関名());
//        row.setTxtOshinNissu(new RString(給付実績情報.get(index).get往診日数()));
//        row.setTxtTsuinIryoKikanName(給付実績情報.get(index).get通院医療機関名());
//        row.setTxtTsuinNissu(new RString(給付実績情報.get(index).get通院日数()));
//        row.setTxtKanriShokei(new RString(給付実績情報.get(index).get緊急時治療管理小計()));
//        row.setTxtKanriTani(new RString(給付実績情報.get(index).get緊急時治療管理単位数()));
//        row.setTxtKanriNissu(new RString(給付実績情報.get(index).get緊急時治療管理日数()));
//        row.setTxtGokeiTensu(new RString(給付実績情報.get(index).get緊急時施設療養費合計点数()));
//        row.setTxtRehabilitationTensu(new RString(給付実績情報.get(index).getリハビリテーション点数()));
//        row.setTxtShochiTensu(new RString(給付実績情報.get(index).get処置点数()));
//        row.setTxtShujutsuTensu(new RString(給付実績情報.get(index).get手術点数()));
//        row.setTxtMahiTensu(new RString(給付実績情報.get(index).get麻酔点数()));
//        row.setTxtHoshasenChiryoTensu(new RString(給付実績情報.get(index).get放射線治療点数()));
        row.setTxtSaiShinsaKaisu(new RString(給付実績情報.get(index).get再審査回数()));
        row.setTxtKagoKaisu(new RString(給付実績情報.get(index).get過誤回数()));
        if (給付実績情報.get(index).get審査年月() != null && 給付実績情報.get(index).get審査年月().isEmpty()) {
            row.setTxtShinsaYM(DateConverter.toWarekiHalf_Zero(new RYearMonth(給付実績情報.get(index).get審査年月().toString())));
        } else {
            row.setTxtShinsaYM(RString.EMPTY);
        }
        return row;

    }

//    private dgKyufuJissekiShukei_Row get後のデータ(int index, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績情報) {
//        dgKyufuJissekiShukei_Row row = new dgKyufuJissekiShukei_Row();
//        row.setTxtKinkyuKubun(RString.EMPTY);
//        row.getTxtShobyoName().setValue(RString.EMPTY);
//        row.getTxtChiryoKaishiYMD().setValue(RString.EMPTY);
//        row.setTxtKettei(new RString("後"));
//        row.setTxtOshinNissu(new RString(給付実績情報.get(index).get後_往診日数()));
//        row.setTxtTsuinNissu(new RString(給付実績情報.get(index).get後_通院日数()));
//        row.setTxtKanriTani(new RString(給付実績情報.get(index).get後_緊急時治療管理単位数()));
//        row.setTxtKanriNissu(new RString(給付実績情報.get(index).get後_緊急時治療管理日数()));
//        row.setTxtRehabilitationTensu(new RString(給付実績情報.get(index).get後_リハビリテーション点数()));
//        row.setTxtShochiTensu(new RString(給付実績情報.get(index).get後_処置点数()));
//        row.setTxtShujutsuTensu(new RString(給付実績情報.get(index).get後_手術点数()));
//        row.setTxtMahiTensu(new RString(給付実績情報.get(index).get後_麻酔点数()));
//        row.setTxtHoshasenChiryoTensu(new RString(給付実績情報.get(index).get後_放射線治療点数()));
//        return row;
//    }
    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 ShikibetsuNoKanri
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理, FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 識別番号) {
        if (非活性.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (任意設定可.equals(識別番号管理.get所定疾患施設療養設定区分())
                && 平成24年4月.isBeforeOrEquals(サービス提供年月)) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(false);
            div.getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(true);
            div.getBtnKinkyujiShisetsuRyoyo().setDisplayNone(false);
            if (非活性.equals(識別番号管理.get緊急時施設療養設定区分())) {
                div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            } else {
                div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
            }
        }
        div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        if (非活性.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }

        if (非活性.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }

        add(識別番号管理);
    }

    private void add(ShikibetsuNoKanri 識別番号管理) {
        if (非活性.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }

        if (非活性.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }

        if (非活性.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }

        if (非活性.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }

        if (非活性.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);

        }
    }

    /**
     * 事業者番号の設定です。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     * @return index index
     */
    public int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号.equals(事業者番号リスト.get(index).get事業所番号().value())
                    && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 様式番号.equals(事業者番号リスト.get(index).get識別番号())
                    && サービス提供年月.equals(事業者番号リスト.get(index).getサービス提供年月().toDateString())
                    && 実績区分コード.equals(事業者番号リスト.get(index).get給付実績区分コード())) {
                return index;
            }
        }
        return 0;
    }

    /**
     * change年月です。
     *
     * @param changge月 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 給付実績緊急時施設療養データ取得 List<KyufujissekiKinkyuShisetsuRyoyo>
     */
    public void change年月(RString changge月, HihokenshaNo 被保険者番号, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得) {
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();

        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().toString());
//        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        NyuryokuShikibetsuNo 識別番号 = new NyuryokuShikibetsuNo(div.getCcdKyufuJissekiHeader().get様式番号());
        FlexibleYearMonth 年月;
        if (前月.equals(changge月)) {
            年月 = get前月(サービス提供年月);
            div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 年月, 整理番号, 識別番号);
        } else {
            年月 = get次月(サービス提供年月);
            div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 年月, 整理番号, 識別番号);
        }

//        List<KyufujissekiKinkyuShisetsuRyoyo> 実績緊急時施設療養データ = get給付実績データ(給付実績緊急時施設療養データ取得, 整理番号, 事業者番号, new RString(識別番号.toString()), 年月.toDateString());
//        setDataGrid(実績緊急時施設療養データ);
    }

    private FlexibleYearMonth get次月(FlexibleYearMonth サービス提供年月) {
        FlexibleYearMonth 次月;
        if (サービス提供年月.getMonthValue() != 年の末月) {
            次月 = new FlexibleYearMonth(new RString(サービス提供年月.getYearValue()).concat(new RString(サービス提供年月.getMonthValue() + 1)));
        } else {
            次月 = new FlexibleYearMonth(new RString(サービス提供年月.getYearValue() + 1).concat(new RString("01")));
        }
        return 次月;
    }

    private FlexibleYearMonth get前月(FlexibleYearMonth サービス提供年月) {

        if (サービス提供年月.getMonthValue() != 年の初月) {
            return new FlexibleYearMonth(new RString(サービス提供年月.getYearValue()).concat(new RString(サービス提供年月.getMonthValue() - 1)));
        } else {
            return new FlexibleYearMonth(new RString(サービス提供年月.getYearValue() - 1).concat(new RString("12")));
        }

    }

    /**
     * change事業者です。
     *
     * @param date RString
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 給付実績緊急時施設療養データ取得 List<KyufujissekiKinkyuShisetsuRyoyo>
     */
    public void change事業者(RString date, List<KyufuJissekiHedajyoho2> 事業者番号リスト, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得) {
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        RDate サービス提供 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        RString サービス提供年月 = サービス提供.getYearMonth().toDateString();
        int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
        int i;
        if (前事業者.equals(date)) {
            i = -1;
        } else {
            i = 1;
        }
        div.getCcdKyufuJissekiHeader().set事業者名称(事業者番号リスト.get(index + i).get事業者名称());
        div.getCcdKyufuJissekiHeader().set事業者番号(事業者番号リスト.get(index + i).get事業所番号().value());
        div.getCcdKyufuJissekiHeader().set実績区分(事業者番号リスト.get(index + i).get給付実績区分コード());
        div.getCcdKyufuJissekiHeader().set整理番号(事業者番号リスト.get(index + i).get整理番号());
        div.getCcdKyufuJissekiHeader().set識別番号名称(事業者番号リスト.get(index + i).get識別番号名称());
        div.getCcdKyufuJissekiHeader().set様式番号(事業者番号リスト.get(index + i).get識別番号());
//        List<KyufujissekiMeisai> 緊急時施設療養データ = get給付実績データ(給付実績緊急時施設療養データ取得,
//                事業者番号リスト.get(index + i).get整理番号(),
//                事業者番号リスト.get(index + i).get事業所番号().value(),
//                事業者番号リスト.get(index + i).get識別番号(),
//                事業者番号リスト.get(index + i).getサービス提供年月().toDateString());
//        setDataGrid(緊急時施設療養データ);
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (0 < index + i) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        if (index + i + 1 < 事業者番号リスト.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
    }

    /**
     * get給付実績データです。
     *
     * @param 給付実績明細 List<KyufujissekiKinkyuShisetsuRyoyo>
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @param 事業者番号 RString
     * @param サービス提供年月 RString
     * @return 緊急時施設療養データ List<KyufujissekiKinkyuShisetsuRyoyo>
     */
    public List<KyufujissekiMeisai> get給付実績明細(List<KyufujissekiMeisai> 給付実績明細, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiMeisai> 給付実績明細データ = new ArrayList<>();
        for (int index = 0; index < 給付実績明細.size(); index++) {
            if (事業者番号.equals(給付実績明細.get(index).get事業所番号().value())
                    && 整理番号.equals(給付実績明細.get(index).get整理番号())
                    && 様式番号.equals(給付実績明細.get(index).get入力識別番号().value())
                    && サービス提供年月.equals(給付実績明細.get(index).getサービス提供年月().toDateString())) {
                給付実績明細データ.add(給付実績明細.get(index));
            }
        }

        return 給付実績明細データ;
    }

//    private RString set緊急時傷病名(KyufujissekiKinkyuShisetsuRyoyo 給付実績情報) {
//        RStringBuilder 緊急時傷病名 = new RStringBuilder();
//        if (RString.isNullOrEmpty(給付実績情報.get緊急時傷病名１())) {
//            緊急時傷病名.append(NewLine.CRLF.getNewLineString());
//        } else {
//            緊急時傷病名.append(給付実績情報.get緊急時傷病名１())
//                    .append(NewLine.CRLF.getNewLineString());
//        }
//        if (RString.isNullOrEmpty(給付実績情報.get緊急時傷病名２())) {
//            緊急時傷病名.append(NewLine.CRLF.getNewLineString());
//        } else {
//            緊急時傷病名.append(給付実績情報.get緊急時傷病名２())
//                    .append(NewLine.CRLF.getNewLineString());
//        }
//        if (!RString.isNullOrEmpty(給付実績情報.get緊急時傷病名３())) {
//            緊急時傷病名.append(給付実績情報.get緊急時傷病名３());
//        }
//        return 緊急時傷病名.toRString();
//    }
//    private RString set緊急時治療開始年月日(KyufujissekiKinkyuShisetsuRyoyo 給付実績情報) {
//        RStringBuilder 緊急時治療開始年月日 = new RStringBuilder();
//        if (給付実績情報.get緊急時治療開始年月日１() == null || 給付実績情報.get緊急時治療開始年月日１().isEmpty()) {
//            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
//        } else {
//            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日１().toString())))
//                    .append(NewLine.CRLF.getNewLineString());
//        }
//        if (給付実績情報.get緊急時治療開始年月日２() == null || 給付実績情報.get緊急時治療開始年月日２().isEmpty()) {
//            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
//        } else {
//            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日２().toString())))
//                    .append(NewLine.CRLF.getNewLineString());
//        }
//        if (給付実績情報.get緊急時治療開始年月日３() != null && !給付実績情報.get緊急時治療開始年月日３().isEmpty()) {
//            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日３().toString())));
//        }
//        return 緊急時治療開始年月日.toRString();
//    }
    /**
     * 事業者btnのstateです。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @param 事業者番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     */
    public void check事業者btn(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        if (!事業者番号リスト.isEmpty()) {
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
            int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
            if (0 < index) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }
}
