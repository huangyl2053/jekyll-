/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010013;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.dgKinkyujiShisetsuRyoyohi_Row;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 緊急時施設療養費のHandlerです。
 *
 * @reamsid_L DBC-2970-050 wangrenze
 */
public class KinnkyuujiShisetsuRyouyouhiHandler {

    private static final RString 前月 = new RString("前月");
    private static final RString 前事業者 = new RString("前事業者");
    private final KinnkyuujiShisetsuRyouyouhiDiv div;
    private static final RString DISABLED = new RString("0");

    /**
     * 初期化
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     */
    public KinnkyuujiShisetsuRyouyouhiHandler(KinnkyuujiShisetsuRyouyouhiDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 引き継ぎ情報 KyufuJissekiPrmBusiness
     * @param 整理番号 RString
     * @param サービス提供年月 FlexibleYearMonth
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void load共有子Div(KyufuJissekiPrmBusiness 引き継ぎ情報, RString 整理番号, FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 識別番号) {
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.getKojinKakuteiKey().get被保険者番号();
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, サービス提供年月, 整理番号, 識別番号);

    }

    /**
     * 画面のデータを初期化する。
     *
     * @param 給付実績緊急時施設療養データ取得 List<KyufujissekiKinkyuShisetsuRyoyo>
     */
    public void setDataGrid(List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得) {
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString();
        List<KyufujissekiKinkyuShisetsuRyoyo> 特定入所者介護サービス費用list = get給付実績データ(給付実績緊急時施設療養データ取得,
                整理番号, 事業者番号, 様式番号, サービス提供年月);
        List<KyufujissekiKinkyuShisetsuRyoyo> dataToRepeat = getサービス提供年月list(給付実績緊急時施設療養データ取得);
        List<dgKinkyujiShisetsuRyoyohi_Row> rowList = new ArrayList<>();
        int size = 特定入所者介護サービス費用list.size();
        for (int index = 0; index < size; index++) {
            rowList.add(getデータ(index, 特定入所者介護サービス費用list));
            rowList.add(get後のデータ(index, 特定入所者介護サービス費用list));
        }
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);
        this.setGetsuBtn(dataToRepeat, new FlexibleYearMonth(サービス提供年月));

    }

    private void setGetsuBtn(List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得, FlexibleYearMonth サービス提供年月) {
        Collections.sort(給付実績緊急時施設療養データ取得, new KinnkyuujiShisetsuRyouyouhiHandler.DateComparatorServiceTeikyoYM());
        if (サービス提供年月.isBeforeOrEquals(給付実績緊急時施設療養データ取得.get(給付実績緊急時施設療養データ取得.size() - 1).getサービス提供年月())) {
            div.getBtnZengetsu().setDisabled(true);
        }
        if (給付実績緊急時施設療養データ取得.get(0).getサービス提供年月()
                .isBeforeOrEquals(サービス提供年月)) {
            div.getBtnJigetsu().setDisabled(true);
        }
    }

    private dgKinkyujiShisetsuRyoyohi_Row getデータ(int index, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績情報) {
        dgKinkyujiShisetsuRyoyohi_Row row = new dgKinkyujiShisetsuRyoyohi_Row();
        row.setTxtKinkyuKubun(給付実績情報.get(index).get緊急時施設療養情報レコード順次番号());
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
        if (給付実績情報.get(index).get審査年月() != null && !給付実績情報.get(index).get審査年月().isEmpty()) {
            row.setTxtShinsaYM(DateConverter.toWarekiHalf_Zero(new RYearMonth(給付実績情報.get(index).get審査年月().toString())));
        } else {
            row.setTxtShinsaYM(RString.EMPTY);
        }
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

    private dgKinkyujiShisetsuRyoyohi_Row get後のデータ(int index, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績情報) {
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
     * @param 識別番号管理 ShikibetsuNoKanri
     */
    public void setButton(FlexibleYearMonth サービス提供年月, ShikibetsuNoKanri 識別番号管理) {

        if (DISABLED.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(false);
        }
        div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        if (DISABLED.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }

        add(識別番号管理);
    }

    private void add(ShikibetsuNoKanri 識別番号管理) {
        if (DISABLED.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
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
     * @return 摘要データ 摘要データ
     */
    public RString set摘要データ(dgKinkyujiShisetsuRyoyohi_Row 給付実績情報) {
        RStringBuilder 摘要データ = new RStringBuilder();
        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo1())) {
            摘要データ.append(給付実績情報.getTxtTekiyo1().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo2())) {
            摘要データ.append(給付実績情報.getTxtTekiyo2().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo3())) {
            摘要データ.append(給付実績情報.getTxtTekiyo3().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo4())) {
            摘要データ.append(給付実績情報.getTxtTekiyo4().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo5())) {
            摘要データ.append(給付実績情報.getTxtTekiyo5().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo6())) {
            摘要データ.append(給付実績情報.getTxtTekiyo6()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo7())) {
            摘要データ.append(給付実績情報.getTxtTekiyo7()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo8())) {
            摘要データ.append(給付実績情報.getTxtTekiyo8()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo9())) {
            摘要データ.append(給付実績情報.getTxtTekiyo9()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo10())) {
            摘要データ.append(給付実績情報.getTxtTekiyo10()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo11())) {
            摘要データ.append(給付実績情報.getTxtTekiyo11()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo12())) {
            摘要データ.append(給付実績情報.getTxtTekiyo12()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo13())) {
            摘要データ.append(給付実績情報.getTxtTekiyo13()).append(NewLine.CRLF.getNewLineString());
        }
        add摘要データ(摘要データ, 給付実績情報);
        return 摘要データ.toRString();
    }

    private void add摘要データ(RStringBuilder 摘要データ, dgKinkyujiShisetsuRyoyohi_Row 給付実績情報) {
        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo14())) {
            摘要データ.append(給付実績情報.getTxtTekiyo14()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo15())) {
            摘要データ.append(給付実績情報.getTxtTekiyo15()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo16())) {
            摘要データ.append(給付実績情報.getTxtTekiyo16()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo17())) {
            摘要データ.append(給付実績情報.getTxtTekiyo17()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo18())) {
            摘要データ.append(給付実績情報.getTxtTekiyo18()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo19())) {
            摘要データ.append(給付実績情報.getTxtTekiyo19()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo20())) {
            摘要データ.append(給付実績情報.getTxtTekiyo20()).append(NewLine.CRLF.getNewLineString());
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
     * @param change月 RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 給付実績緊急時施設療養データ取得 List<KyufujissekiKinkyuShisetsuRyoyo>
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change年月(RString change月, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        int index = 0;
        List<KyufujissekiKinkyuShisetsuRyoyo> dataToRepeat = getサービス提供年月list(給付実績緊急時施設療養データ取得);
        Collections.sort(dataToRepeat, new DateComparatorServiceTeikyoYM());
        for (int i = 0; i < dataToRepeat.size(); i++) {
            if (サービス提供年月.equals(dataToRepeat.get(i).getサービス提供年月())) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 年月;
        RString 新整理番号;
        NyuryokuShikibetsuNo 新識別番号;
        if (前月.equals(change月)) {
            年月 = dataToRepeat.get(index + 1).getサービス提供年月();
            新整理番号 = dataToRepeat.get(index + 1).get整理番号();
            新識別番号 = dataToRepeat.get(index + 1).get入力識別番号();
            div.getBtnJigetsu().setDisabled(false);
        } else {
            年月 = dataToRepeat.get(index - 1).getサービス提供年月();
            新整理番号 = dataToRepeat.get(index - 1).get整理番号();
            新識別番号 = dataToRepeat.get(index - 1).get入力識別番号();
            div.getBtnZengetsu().setDisabled(false);
        }
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 年月, 新整理番号, 新識別番号);

        setDataGrid(dataToRepeat);

    }

    private List<KyufujissekiKinkyuShisetsuRyoyo> getサービス提供年月list(List<KyufujissekiKinkyuShisetsuRyoyo> 居宅サービス計画費list) {
        List<FlexibleYearMonth> サービス提供年月list = new ArrayList<>();
        List<KyufujissekiKinkyuShisetsuRyoyo> dataToRepeat = new ArrayList<>();
        for (KyufujissekiKinkyuShisetsuRyoyo date : 居宅サービス計画費list) {
            if (!サービス提供年月list.contains(date.getサービス提供年月())) {
                サービス提供年月list.add(date.getサービス提供年月());
                dataToRepeat.add(date);
            }
        }
        return dataToRepeat;
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
        setDataGrid(給付実績緊急時施設療養データ取得);
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (0 < index + i) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        if (index + i + 1 < 事業者番号リスト.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
    }

    private List<KyufujissekiKinkyuShisetsuRyoyo> get給付実績データ(List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiKinkyuShisetsuRyoyo> 緊急時施設療養データ = new ArrayList<>();
        for (int index = 0; index < 給付実績緊急時施設療養データ取得.size(); index++) {
            if (事業者番号.equals(給付実績緊急時施設療養データ取得.get(index).get事業所番号().value())
                    && 整理番号.equals(給付実績緊急時施設療養データ取得.get(index).get整理番号())
                    && 様式番号.equals(給付実績緊急時施設療養データ取得.get(index).get入力識別番号().value())
                    && サービス提供年月.equals(給付実績緊急時施設療養データ取得.get(index).getサービス提供年月().toDateString())) {
                緊急時施設療養データ.add(給付実績緊急時施設療養データ取得.get(index));
            }
        }

        return 緊急時施設療養データ;
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
        if (給付実績情報.get緊急時治療開始年月日１() == null || 給付実績情報.get緊急時治療開始年月日１().isEmpty()) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日１().toString())))
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (給付実績情報.get緊急時治療開始年月日２() == null || 給付実績情報.get緊急時治療開始年月日２().isEmpty()) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日２().toString())))
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (給付実績情報.get緊急時治療開始年月日３() != null && !給付実績情報.get緊急時治療開始年月日３().isEmpty()) {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日３().toString())));
        }
        return 緊急時治療開始年月日.toRString();
    }

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

    private static class DateComparatorServiceTeikyoYM implements Comparator<KyufujissekiKinkyuShisetsuRyoyo>, Serializable {

        private static final long serialVersionUID = -300796001015547240L;

        @Override
        public int compare(KyufujissekiKinkyuShisetsuRyoyo o1, KyufujissekiKinkyuShisetsuRyoyo o2) {
            return o2.getサービス提供年月().compareTo(o1.getサービス提供年月());
        }
    }
}
