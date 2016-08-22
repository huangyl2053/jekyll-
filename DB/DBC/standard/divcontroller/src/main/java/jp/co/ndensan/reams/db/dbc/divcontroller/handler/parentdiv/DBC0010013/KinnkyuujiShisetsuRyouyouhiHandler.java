/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010013;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010013.Header2;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010013.KyufuJissekiPrm;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.dgKinkyujiShisetsuRyoyohi_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujisseki.KyufuJissekiManager;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 緊急時施設療養費のHandlerです。
 *
 * @reamsid_L DBC-2970-050 wangrenze
 */
public class KinnkyuujiShisetsuRyouyouhiHandler {

    private final RString 前月 = new RString("前月");
    private final RString 前事業者 = new RString("前事業者");
    private final KinnkyuujiShisetsuRyouyouhiDiv div;
    private final RString ZERO = new RString("0");
    //private final RString NI = new RString("2");
    private static final int INT_1 = 1;
    private static final int INT_12 = 12;

    /**
     *
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     */
    public KinnkyuujiShisetsuRyouyouhiHandler(KinnkyuujiShisetsuRyouyouhiDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 引き継ぎ情報 KyufuJissekiPrm
     */
    public void load共有子Div(KyufuJissekiPrm 引き継ぎ情報) {
        NyuryokuShikibetsuNo 識別番号 = 引き継ぎ情報.get識別番号();
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = 引き継ぎ情報.getサービス提供年月();
        RString 整理番号 = 引き継ぎ情報.get整理番号();
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, サービス提供年月, 整理番号, 識別番号);

    }

    /**
     * 画面のデータを初期化する。
     *
     */
    public void setDataGrid() {
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得 = KyufuJissekiManager.createInstance().
                get給付実績情報照会();
        List<dgKinkyujiShisetsuRyoyohi_Row> rowList = new ArrayList<>();
        // List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得 = new ArrayList<>();
        int size = 給付実績緊急時施設療養データ取得.size();
        for (int index = 0; index < size; index++) {
            rowList.add(getデータ(index, 給付実績緊急時施設療養データ取得));
            rowList.add(get後のデータ(index, 給付実績緊急時施設療養データ取得));
        }
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);

    }

    /**
     * 画面のデータを初期化する。
     *
     * @param index int
     * @param 給付実績情報 List<KyufujissekiKinkyuShisetsuRyoyo>
     * @return データ
     */
    public dgKinkyujiShisetsuRyoyohi_Row getデータ(int index, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績情報) {
        dgKinkyujiShisetsuRyoyohi_Row row = new dgKinkyujiShisetsuRyoyohi_Row();
        row.setTxtKinkyuKubun(new RString(給付実績情報.get(index).get緊急時施設療養情報レコード順次番号().toString()));
        row.getTxtShobyoName().setValue(set緊急時傷病名(給付実績情報.get(index)));
        row.getTxtChiryoKaishiYMD().setValue(set緊急時治療開始年月日(給付実績情報.get(index)));
        row.setTxtKettei(RString.EMPTY);
        row.setTxtOshinIryoKikanName(給付実績情報.get(index).get往診医療機関名());
        row.setTxtOshinNissu(new RString(給付実績情報.get(index).get往診日数()));
        row.setTxtTsuinIryoKikanName(給付実績情報.get(index).get通院医療機関名());
        row.setTxtTsuinNissu(new RString(給付実績情報.get(index).get通院日数()));
        row.setTxtKanriShokei(new RString(給付実績情報.get(index).get緊急時治療管理小計()));
        row.setTxtKanriTani(new RString(給付実績情報.get(index).get緊急時治療管理単位数()));
        row.setTxtKanriNissu(new RString(給付実績情報.get(index).get緊急時治療管理日数()));
        row.setTxtGokeiTensu(new RString(給付実績情報.get(index).get緊急時施設療養費合計点数()));
        row.setTxtRehabilitationTensu(new RString(給付実績情報.get(index).getリハビリテーション点数()));
        row.setTxtShochiTensu(new RString(給付実績情報.get(index).get処置点数()));
        row.setTxtShujutsuTensu(new RString(給付実績情報.get(index).get手術点数()));
        row.setTxtMahiTensu(new RString(給付実績情報.get(index).get麻酔点数()));
        row.setTxtHoshasenChiryoTensu(new RString(給付実績情報.get(index).get放射線治療点数()));
        row.setTxtSaiShinsaKaisu(new RString(給付実績情報.get(index).get再審査回数()));
        row.setTxtKagoKaisu(new RString(給付実績情報.get(index).get過誤回数()));
        row.setTxtShinsaYM(DateConverter.toWarekiHalf_Zero(new RYearMonth(給付実績情報.get(index).get審査年月().toString())));
        row.setTxtTekiyo1(給付実績情報.get(index).get摘要１());
        row.setTxtTekiyo2(給付実績情報.get(index).get摘要２());
        row.setTxtTekiyo3(給付実績情報.get(index).get摘要３());
        row.setTxtTekiyo4(給付実績情報.get(index).get摘要４());
        row.setTxtTekiyo5(給付実績情報.get(index).get摘要５());
        row.setTxtTekiyo6(給付実績情報.get(index).get摘要６());
        row.setTxtTekiyo7(給付実績情報.get(index).get摘要７());
        row.setTxtTekiyo8(給付実績情報.get(index).get摘要８());
        row.setTxtTekiyo9(給付実績情報.get(index).get摘要９());
        row.setTxtTekiyo10(給付実績情報.get(index).get摘要１０());
        row.setTxtTekiyo11(給付実績情報.get(index).get摘要１１());
        row.setTxtTekiyo12(給付実績情報.get(index).get摘要１２());
        row.setTxtTekiyo13(給付実績情報.get(index).get摘要１３());
        row.setTxtTekiyo14(給付実績情報.get(index).get摘要１４());
        row.setTxtTekiyo15(給付実績情報.get(index).get摘要１５());
        row.setTxtTekiyo16(給付実績情報.get(index).get摘要１６());
        row.setTxtTekiyo17(給付実績情報.get(index).get摘要１７());
        row.setTxtTekiyo18(給付実績情報.get(index).get摘要１８());
        row.setTxtTekiyo19(給付実績情報.get(index).get摘要１９());
        row.setTxtTekiyo20(給付実績情報.get(index).get摘要２０());
        return row;

    }

    /**
     * 画面のデータを初期化する。
     *
     * @param index int
     * @param 給付実績情報 List<KyufujissekiKinkyuShisetsuRyoyo>
     * @return 後のデータ
     */
    public dgKinkyujiShisetsuRyoyohi_Row get後のデータ(int index, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績情報) {
        dgKinkyujiShisetsuRyoyohi_Row row = new dgKinkyujiShisetsuRyoyohi_Row();
        row.setTxtKinkyuKubun(RString.EMPTY);
        row.getTxtShobyoName().setValue(RString.EMPTY);
        row.getTxtChiryoKaishiYMD().setValue(RString.EMPTY);
        row.setTxtKettei(new RString("後"));
        row.setTxtOshinNissu(new RString(給付実績情報.get(index).get後_往診日数()));
        row.setTxtTsuinNissu(new RString(給付実績情報.get(index).get後_通院日数()));
        row.setTxtKanriTani(new RString(給付実績情報.get(index).get後_緊急時治療管理単位数()));
        row.setTxtKanriNissu(new RString(給付実績情報.get(index).get後_緊急時治療管理日数()));
        row.setTxtRehabilitationTensu(new RString(給付実績情報.get(index).get後_リハビリテーション点数()));
        row.setTxtShochiTensu(new RString(給付実績情報.get(index).get後_処置点数()));
        row.setTxtShujutsuTensu(new RString(給付実績情報.get(index).get後_手術点数()));
        row.setTxtMahiTensu(new RString(給付実績情報.get(index).get後_麻酔点数()));
        row.setTxtHoshasenChiryoTensu(new RString(給付実績情報.get(index).get後_放射線治療点数()));
        row.setTxtTekiyo1(給付実績情報.get(index).get摘要１());
        row.setTxtTekiyo2(給付実績情報.get(index).get摘要２());
        row.setTxtTekiyo3(給付実績情報.get(index).get摘要３());
        row.setTxtTekiyo4(給付実績情報.get(index).get摘要４());
        row.setTxtTekiyo5(給付実績情報.get(index).get摘要５());
        row.setTxtTekiyo6(給付実績情報.get(index).get摘要６());
        row.setTxtTekiyo7(給付実績情報.get(index).get摘要７());
        row.setTxtTekiyo8(給付実績情報.get(index).get摘要８());
        row.setTxtTekiyo9(給付実績情報.get(index).get摘要９());
        row.setTxtTekiyo10(給付実績情報.get(index).get摘要１０());
        row.setTxtTekiyo11(給付実績情報.get(index).get摘要１１());
        row.setTxtTekiyo12(給付実績情報.get(index).get摘要１２());
        row.setTxtTekiyo13(給付実績情報.get(index).get摘要１３());
        row.setTxtTekiyo14(給付実績情報.get(index).get摘要１４());
        row.setTxtTekiyo15(給付実績情報.get(index).get摘要１５());
        row.setTxtTekiyo16(給付実績情報.get(index).get摘要１６());
        row.setTxtTekiyo17(給付実績情報.get(index).get摘要１７());
        row.setTxtTekiyo18(給付実績情報.get(index).get摘要１８());
        row.setTxtTekiyo19(給付実績情報.get(index).get摘要１９());
        row.setTxtTekiyo20(給付実績情報.get(index).get摘要２０());
        return row;
    }

    /**
     * ボタン状態の設定です。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setButton(RString サービス提供年月) {
        //TODO ＡＰＩは実装がない
        RString 識別番号 = new RString("");
        ShikibetsuNoKanri 識別番号管理 = new ShikibetsuNoKanri(識別番号, new FlexibleYearMonth(サービス提供年月));
        if (ZERO.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
//        if (NI.equals(識別番号管理.get所定疾患施設療養設定区分())
//                && 平成24年4月.isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
//            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(false);
//            div.getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
//        } else {
//            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(true);
//            div.getBtnKinkyujiShisetsuRyoyo().setDisplayNone(false);
//            if (ZERO.equals(識別番号管理.get緊急時施設療養設定区分())) {
//                div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
//            } else {
//                div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
//            }
        //   }

        div.getBtnShoteiShikkanShisetsuRyoyo()
                .setDisabled(true);
        if (ZERO.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }

        if (ZERO.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }

        if (ZERO.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }

        if (ZERO.equals(識別番号管理.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        add(識別番号管理);
    }

    /**
     * ボタン状態の設定です。
     *
     * @param サービス提供年月 サービス提供年月
     */
    private void add(ShikibetsuNoKanri 識別番号管理) {
        if (ZERO.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }

        if (ZERO.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }

        if (ZERO.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }

        if (ZERO.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }

        if (ZERO.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);

        }
    }

    /**
     * パネル状態の設定です。
     *
     */
    public void checkState() {
        div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
    }

    /**
     * パネル状態の設定です。
     *
     */
    public void changeState() {
        div.getKyufuJissekiTekiyoPanel().setIsOpen(true);
    }

    /**
     * 摘要データの設定です。
     *
     * @param 給付実績情報 dgKinkyujiShisetsuRyoyohi_Row
     * @return 摘要データ
     */
    public RString set摘要データ(dgKinkyujiShisetsuRyoyohi_Row 給付実績情報) {
        RStringBuilder rsb = new RStringBuilder();
        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo1())) {
            rsb.append(給付実績情報.getTxtTekiyo1().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo2())) {
            rsb.append(給付実績情報.getTxtTekiyo2().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo3())) {
            rsb.append(給付実績情報.getTxtTekiyo3().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo4())) {
            rsb.append(給付実績情報.getTxtTekiyo4().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo5())) {
            rsb.append(給付実績情報.getTxtTekiyo5().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo6())) {
            rsb.append(給付実績情報.getTxtTekiyo6()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo7())) {
            rsb.append(給付実績情報.getTxtTekiyo7()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo8())) {
            rsb.append(給付実績情報.getTxtTekiyo8()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo9())) {
            rsb.append(給付実績情報.getTxtTekiyo9()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo10())) {
            rsb.append(給付実績情報.getTxtTekiyo10()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo11())) {
            rsb.append(給付実績情報.getTxtTekiyo11()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo12())) {
            rsb.append(給付実績情報.getTxtTekiyo12()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo13())) {
            rsb.append(給付実績情報.getTxtTekiyo13()).append(NewLine.CRLF.getNewLineString());
        }
        add摘要データ(rsb, 給付実績情報);
        return rsb.toRString();
    }

    private void add摘要データ(RStringBuilder rsb, dgKinkyujiShisetsuRyoyohi_Row 給付実績情報) {
        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo14())) {
            rsb.append(給付実績情報.getTxtTekiyo14()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo15())) {
            rsb.append(給付実績情報.getTxtTekiyo15()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo16())) {
            rsb.append(給付実績情報.getTxtTekiyo16()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo17())) {
            rsb.append(給付実績情報.getTxtTekiyo17()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo18())) {
            rsb.append(給付実績情報.getTxtTekiyo18()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo19())) {
            rsb.append(給付実績情報.getTxtTekiyo19()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo20())) {
            rsb.append(給付実績情報.getTxtTekiyo20()).append(NewLine.CRLF.getNewLineString());
        }

    }

    /**
     * 事業者番号の設定です。
     *
     * @param 事業者番号リスト　List<Header2>
     * @param サービス提供年月　FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 样式番号 RString
     * @return int
     */
    public int get事業者番号index(List<Header2> 事業者番号リスト, RDate サービス提供年月, RString 整理番号, RString 事業者番号, RString 样式番号) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号リスト.get(index).get事業者番号().compareTo(事業者番号) == 0 && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 事業者番号.equals(事業者番号リスト.get(index).get事業者番号()) && 样式番号.equals(事業者番号リスト.get(index).get样式番号())) {
                return index;
            }
        }

        return 0;
    }

    /**
     * change年月です。
     *
     * @param changge月 RString
     */
    public void change年月(RString changge月) {
        RString 整理番号 = div.getCcdKyufuJissekiHeader().getTxtSeiriNo().getValue();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getCcdKyufuJissekiHeader().getTxtHihoNo().getValue());
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getTxtTeikyoNengetsu().getValue().toString());
        NyuryokuShikibetsuNo 識別番号 = new NyuryokuShikibetsuNo(div.getCcdKyufuJissekiHeader().getTxtYoshikiNo().getValue());
        if (前月.equals(changge月)) {
            div.getCcdKyufuJissekiHeader().initialize(被保険者番号, get前月(サービス提供年月), 整理番号, 識別番号);
        } else {
            div.getCcdKyufuJissekiHeader().initialize(被保険者番号, get次月(サービス提供年月), 整理番号, 識別番号);
        }

    }

    private FlexibleYearMonth get次月(FlexibleYearMonth サービス提供年月) {
        FlexibleYearMonth 次月;
        if (サービス提供年月.getMonthValue() != INT_12) {
            次月 = new FlexibleYearMonth(new RString(サービス提供年月.getYearValue()).concat(new RString(サービス提供年月.getMonthValue() + INT_1)));
        } else {
            次月 = new FlexibleYearMonth(new RString(サービス提供年月.getYearValue() + INT_1).concat(new RString("01")));
        }
        return 次月;
    }

    private FlexibleYearMonth get前月(FlexibleYearMonth サービス提供年月) {
        FlexibleYearMonth 前の月;
        if (サービス提供年月.getMonthValue() != INT_1) {
            前の月 = new FlexibleYearMonth(new RString(サービス提供年月.getYearValue()).concat(new RString(サービス提供年月.getMonthValue() - INT_1)));
        } else {
            前の月 = new FlexibleYearMonth(new RString(サービス提供年月.getYearValue() - INT_1).concat(new RString("12")));
        }
        return 前の月;
    }

    /**
     * change事業者です。
     *
     * @param date RString
     */
    public void change事業者(RString date) {
        List<Header2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrm.class).getComHeader().getHeader2();
        RString 事業者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrm.class).get事業者番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().getTxtSeiriNo().getValue();
        RDate サービス提供年月 = div.getCcdKyufuJissekiHeader().getTxtTeikyoNengetsu().getValue();
        RString 样式番号 = div.getCcdKyufuJissekiHeader().getTxtYoshikiNo().getValue();
        int index = get事業者番号index(事業者番号リスト, サービス提供年月, 整理番号, 事業者番号, 样式番号);
        int i;
        if (前事業者.equals(date)) {
            i = -1;
        } else {
            i = 1;
        }
        div.getCcdKyufuJissekiHeader().set事業者名称(事業者番号リスト.get(index + i).get事業者());
        div.getCcdKyufuJissekiHeader().set実績区分(事業者番号リスト.get(index + i).get給付実績区分());
        div.getCcdKyufuJissekiHeader().set整理番号(事業者番号リスト.get(index + i).get整理番号());
        div.getCcdKyufuJissekiHeader().set識別番号名称(new RString(事業者番号リスト.get(index + i).get样式番号().toString()));
        List<dgKinkyujiShisetsuRyoyohi_Row> rowList = new ArrayList<>();
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得 = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrm.class)
                .getComHeader().getHeader2().get(index + i).getData();
        int size = 給付実績緊急時施設療養データ取得.size();
        for (int ii = 0; ii < size; ii++) {
            rowList.add(getデータ(ii, 給付実績緊急時施設療養データ取得));
            rowList.add(get後のデータ(ii, 給付実績緊急時施設療養データ取得));
        }
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);
    }

    private RString set緊急時傷病名(KyufujissekiKinkyuShisetsuRyoyo 給付実績情報) {
        RStringBuilder 緊急時傷病名 = new RStringBuilder();
        if (RString.isNullOrEmpty(給付実績情報.get緊急時傷病名１())) {
            緊急時傷病名.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時傷病名.append(給付実績情報.get緊急時傷病名１())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (RString.isNullOrEmpty(給付実績情報.get緊急時傷病名２())) {
            緊急時傷病名.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時傷病名.append(給付実績情報.get緊急時傷病名２())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績情報.get緊急時傷病名３())) {
            緊急時傷病名.append(給付実績情報.get緊急時傷病名３());
        }
        return 緊急時傷病名.toRString();
    }

    private RString set緊急時治療開始年月日(KyufujissekiKinkyuShisetsuRyoyo 給付実績情報) {
        RStringBuilder 緊急時治療開始年月日 = new RStringBuilder();
        if (給付実績情報.get緊急時治療開始年月日１() == null) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日１().toString())))
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (給付実績情報.get緊急時治療開始年月日２() == null) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日２().toString())))
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (給付実績情報.get緊急時治療開始年月日３() != null) {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日３().toString())));
        }
        return 緊急時治療開始年月日.toRString();
    }
}
