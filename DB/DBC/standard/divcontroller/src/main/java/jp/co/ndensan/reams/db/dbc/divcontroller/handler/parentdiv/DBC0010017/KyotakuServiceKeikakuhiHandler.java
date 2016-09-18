/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010017;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKyotakuServiceBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.KyotakuServiceKeikakuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.dgServiceKeikakuhiFromH2104_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.dgServiceKeikakuhiToH2103_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 居宅サービス計画費のHandlerです。
 *
 * @reamsid_L DBC-2970-090 wangrenze
 */
public class KyotakuServiceKeikakuhiHandler {

    private static final RString 前月 = new RString("前月");
    private static final RString 前事業者 = new RString("前事業者");
    private final KyotakuServiceKeikakuhiDiv div;
    private static final RString DISABLED = new RString("0");
    private static final FlexibleYearMonth 平成21年3月 = new FlexibleYearMonth("200903");

    /**
     * 画面の初期化です。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     */
    public KyotakuServiceKeikakuhiHandler(KyotakuServiceKeikakuhiDiv div) {
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
     * @param business List<KyufujissekiKyotakuServiceBusiness>
     * @param サービス提供年月 FlexibleYearMonth
     */
    public void setDataGrid(List<KyufujissekiKyotakuServiceBusiness> business, FlexibleYearMonth サービス提供年月) {
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        List<KyufujissekiKyotakuServiceBusiness> 特定入所者介護サービス費用list = get給付実績データ(business,
                整理番号, 事業者番号, 様式番号, サービス提供年月.toDateString());
        List<KyufujissekiKyotakuServiceBusiness> dataToRepeat = getサービス提供年月list(business);
        if (サービス提供年月.isBeforeOrEquals(平成21年3月)) {
            List<dgServiceKeikakuhiToH2103_Row> to2013rowList = new ArrayList<>();
            for (KyufujissekiKyotakuServiceBusiness 居宅サービス計画費 : 特定入所者介護サービス費用list) {

                to2013rowList.add(get2013データ(居宅サービス計画費));
                to2013rowList.add(get2013後のデータ(居宅サービス計画費));
            }
            div.getDgServiceKeikakuhiToH2103().setDataSource(to2013rowList);
        } else {
            List<dgServiceKeikakuhiFromH2104_Row> from2014rowList = new ArrayList<>();
            for (KyufujissekiKyotakuServiceBusiness 居宅サービス計画費 : 特定入所者介護サービス費用list) {

                from2014rowList.add(get2014データ(居宅サービス計画費));
                from2014rowList.add(get2014後のデータ(居宅サービス計画費));
            }
            div.getDgServiceKeikakuhiFromH2104().setDataSource(from2014rowList);
        }
        this.setGetsuBtn(dataToRepeat, サービス提供年月);

    }

    private void setGetsuBtn(List<KyufujissekiKyotakuServiceBusiness> 居宅サービス計画費list, FlexibleYearMonth サービス提供年月) {
        Collections.sort(居宅サービス計画費list, new KyotakuServiceKeikakuhiHandler.DateComparatorServiceTeikyoYM());
        div.getBtnZengetsu().setDisabled(true);
        div.getBtnJigetsu().setDisabled(true);
        if (居宅サービス計画費list != null && !居宅サービス計画費list.isEmpty()) {
            if (!サービス提供年月.isBeforeOrEquals(居宅サービス計画費list.get(居宅サービス計画費list.size() - 1).get居宅サービス計画費().getサービス提供年月())) {
                div.getBtnZengetsu().setDisabled(false);
            }
            if (!居宅サービス計画費list.get(0).get居宅サービス計画費().getサービス提供年月()
                    .isBeforeOrEquals(サービス提供年月)) {
                div.getBtnJigetsu().setDisabled(false);
            }
        }
    }

    private dgServiceKeikakuhiToH2103_Row get2013データ(KyufujissekiKyotakuServiceBusiness business) {
        dgServiceKeikakuhiToH2103_Row row = new dgServiceKeikakuhiToH2103_Row();
        KyufujissekiKyotakuService 居宅サービス計画費 = business.get居宅サービス計画費();
        if (居宅サービス計画費.get居宅サービス計画作成依頼届出年月日() != null && !居宅サービス計画費.get居宅サービス計画作成依頼届出年月日().isEmpty()) {
            row.setTxtTodokedeYMD(new RString(居宅サービス計画費.get居宅サービス計画作成依頼届出年月日().toString()));
        }
        if (RString.isNullOrEmpty(居宅サービス計画費.getサービス計画費明細行番号())) {
            row.setTxtServiceName(居宅サービス計画費.getサービス計画費明細行番号());
        }
        if (居宅サービス計画費.get単位数単価() != null) {
            row.setTxtTaniTanka(new RString(居宅サービス計画費.get単位数単価().toString()));
        }
        row.setTxtKettei(RString.EMPTY);
        if (居宅サービス計画費.get単位数() != null) {
            row.setTxtTanisu(new RString(居宅サービス計画費.get単位数().toString()));
        }
        row.setTxtSeikyuKingaku(get金額(居宅サービス計画費.get請求金額()));
        row.setTxtTantoKaigoShienSenmoninNo(居宅サービス計画費.get担当介護支援専門員番号());
        if (!RString.isNullOrEmpty(居宅サービス計画費.get摘要())) {
            row.setTxtBiko(居宅サービス計画費.get摘要());
        } else {
            row.setTxtBiko(RString.EMPTY);
        }
        row.setTxtSaishinsaKaisu(new RString(居宅サービス計画費.get再審査回数()));
        row.setTxtKagoKaisu(new RString(居宅サービス計画費.get過誤回数()));
        if (居宅サービス計画費.get審査年月() != null && !居宅サービス計画費.get審査年月().isEmpty()) {
            row.setTxtShinsaYM(DateConverter.toWarekiHalf_Zero(new RYearMonth(居宅サービス計画費.get審査年月().toString())));
        }
        return row;
    }

    private dgServiceKeikakuhiFromH2104_Row get2014データ(KyufujissekiKyotakuServiceBusiness business) {
        dgServiceKeikakuhiFromH2104_Row row = new dgServiceKeikakuhiFromH2104_Row();
        KyufujissekiKyotakuService 居宅サービス計画費 = business.get居宅サービス計画費();
        row.setTxtShiteiKijunGaitoJigyoshoKubun(居宅サービス計画費.get指定_基準該当等事業所区分コード());
        row.setTxtIraiTodokedeYMD(DateConverter.toWarekiHalf_Zero(new RDate(居宅サービス計画費.get居宅サービス計画作成依頼届出年月日().toString())));
        if (!RString.isNullOrEmpty(居宅サービス計画費.getサービスコード().value())) {
            row.setTxtService(business.getサービス種類略称());
        } else {
            row.setTxtService(RString.EMPTY);
        }
        if (居宅サービス計画費.get単位数単価() != null) {
            row.setTxtTanisuTanka(new RString(居宅サービス計画費.get単位数単価().toString()));
        } else {
            row.setTxtTanisuTanka(RString.EMPTY);
        }
        row.setTxtKettei(RString.EMPTY);
        if (居宅サービス計画費.get単位数() != null) {
            row.setTxtMeisaiGokei(new RString(居宅サービス計画費.getサービス単位数合計().toString()));
        }
        if (居宅サービス計画費.get単位数() != null) {
            row.setTxtTanisu(new RString(居宅サービス計画費.get単位数().toString()));
        }
        row.setTxtKaisu(new RString(居宅サービス計画費.get回数()));
        if (居宅サービス計画費.getサービス単位数() != null) {
            row.setTxtServiceTanisu(new RString(居宅サービス計画費.getサービス単位数().toString()));
        }
        row.setTxtSeikyuKingaku(get金額(居宅サービス計画費.get請求金額()));
        if (!RString.isNullOrEmpty(居宅サービス計画費.get担当介護支援専門員番号())) {
            row.setTxtTantoKaigoShienSenmoninNo(居宅サービス計画費.get担当介護支援専門員番号());
        }
        row.setTxtSaishinsaKaisu(new RString(居宅サービス計画費.get再審査回数()));
        row.setTxtKagoKaisu(new RString(居宅サービス計画費.get過誤回数()));
        if (居宅サービス計画費.get審査年月() != null && !居宅サービス計画費.get審査年月().isEmpty()) {
            row.setTxtShinsaYM(DateConverter.toWarekiHalf_Zero(new RYearMonth(居宅サービス計画費.get審査年月().toString())));
        } else {
            row.setTxtShinsaYM(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(居宅サービス計画費.get摘要())) {
            row.setBtnTekiyo(居宅サービス計画費.get摘要());
        } else {
            row.setBtnTekiyo(RString.EMPTY);
        }
        return row;
    }

    private dgServiceKeikakuhiToH2103_Row get2013後のデータ(KyufujissekiKyotakuServiceBusiness business) {
        dgServiceKeikakuhiToH2103_Row row = new dgServiceKeikakuhiToH2103_Row();
        row.setTxtKettei(new RString("後"));
        KyufujissekiKyotakuService 居宅サービス計画費 = business.get居宅サービス計画費();
        if (居宅サービス計画費.get後_単位数() != null) {
            row.setTxtTanisu(new RString(居宅サービス計画費.get後_単位数().toString()));
        }
        row.setTxtSeikyuKingaku(get金額(居宅サービス計画費.get後_請求金額()));
        return row;
    }

    private dgServiceKeikakuhiFromH2104_Row get2014後のデータ(KyufujissekiKyotakuServiceBusiness business) {
        dgServiceKeikakuhiFromH2104_Row row = new dgServiceKeikakuhiFromH2104_Row();
        KyufujissekiKyotakuService 居宅サービス計画費 = business.get居宅サービス計画費();
        row.setTxtKettei(new RString("後"));
        if (居宅サービス計画費.get後_サービス単位数合計() != null) {
            row.setTxtMeisaiGokei(new RString(居宅サービス計画費.get後_サービス単位数合計().toString()));
        }
        if (居宅サービス計画費.get後_単位数() != null) {
            row.setTxtTanisu(new RString(居宅サービス計画費.get後_単位数().toString()));
        }
        row.setTxtKaisu(new RString(居宅サービス計画費.get後_回数()));
        if (居宅サービス計画費.get後_サービス単位数() != null) {
            row.setTxtServiceTanisu(new RString(居宅サービス計画費.get後_サービス単位数().toString()));
        }
        row.setTxtSeikyuKingaku(get金額(居宅サービス計画費.get後_請求金額()));
        return row;
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 ShikibetsuNoKanri
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {

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

            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
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
        div.getBtnKyotakuServiceKeikaku().setDisabled(true);
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
     * @param 給付実績居宅サービス計画費list List<KyufujissekiKyotakuServiceBusiness>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change年月(RString change月, List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費list,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        int index = 0;
        List<KyufujissekiKyotakuServiceBusiness> dataToRepeat = getサービス提供年月list(給付実績居宅サービス計画費list);
        Collections.sort(dataToRepeat, new DateComparatorServiceTeikyoYM());
        for (int i = 0; i < dataToRepeat.size(); i++) {
            if (サービス提供年月.equals(dataToRepeat.get(i).get居宅サービス計画費().getサービス提供年月())) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 年月;
        RString 新整理番号;
        NyuryokuShikibetsuNo 新識別番号;
        if (前月.equals(change月)) {
            年月 = dataToRepeat.get(index + 1).get居宅サービス計画費().getサービス提供年月();
            新整理番号 = dataToRepeat.get(index + 1).get居宅サービス計画費().get整理番号();
            新識別番号 = dataToRepeat.get(index + 1).get居宅サービス計画費().get入力識別番号();
            div.getBtnJigetsu().setDisabled(false);
        } else {
            年月 = dataToRepeat.get(index - 1).get居宅サービス計画費().getサービス提供年月();
            新整理番号 = dataToRepeat.get(index - 1).get居宅サービス計画費().get整理番号();
            新識別番号 = dataToRepeat.get(index - 1).get居宅サービス計画費().get入力識別番号();
            div.getBtnZengetsu().setDisabled(false);
        }
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 年月, 新整理番号, 新識別番号);

        setDataGrid(dataToRepeat, 年月);

    }

    private List<KyufujissekiKyotakuServiceBusiness> getサービス提供年月list(List<KyufujissekiKyotakuServiceBusiness> 居宅サービス計画費list) {
        List<FlexibleYearMonth> サービス提供年月list = new ArrayList<>();
        List<KyufujissekiKyotakuServiceBusiness> dataToRepeat = new ArrayList<>();
        for (KyufujissekiKyotakuServiceBusiness date : 居宅サービス計画費list) {
            if (!サービス提供年月list.contains(date.get居宅サービス計画費().getサービス提供年月())) {
                サービス提供年月list.add(date.get居宅サービス計画費().getサービス提供年月());
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
     * @param 給付実績居宅サービス計画費list List<KyufujissekiKyotakuServiceBusiness>
     */
    public void change事業者(RString date, List<KyufuJissekiHedajyoho2> 事業者番号リスト,
            List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費list) {
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
        setDataGrid(給付実績居宅サービス計画費list, new FlexibleYearMonth(サービス提供年月));
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (0 < index + i) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        if (index + i + 1 < 事業者番号リスト.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
    }

    private List<KyufujissekiKyotakuServiceBusiness> get給付実績データ(List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費list,
            RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiKyotakuServiceBusiness> 居宅サービス計画費list = new ArrayList<>();
        for (int index = 0; index < 給付実績居宅サービス計画費list.size(); index++) {
            if (事業者番号.equals(給付実績居宅サービス計画費list.get(index).get居宅サービス計画費().get事業所番号().value())
                    && 整理番号.equals(給付実績居宅サービス計画費list.get(index).get居宅サービス計画費().get整理番号())
                    && 様式番号.equals(給付実績居宅サービス計画費list.get(index).get居宅サービス計画費().get入力識別番号().value())
                    && サービス提供年月.equals(給付実績居宅サービス計画費list.get(index).get居宅サービス計画費().getサービス提供年月().toDateString())) {
                居宅サービス計画費list.add(給付実績居宅サービス計画費list.get(index));
            }
        }

        return 居宅サービス計画費list;
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
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (!事業者番号リスト.isEmpty()) {
            int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
            if (0 < index) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    private RString get金額(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        }
        return new RString(Decimal.ZERO.intValue());
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<KyufujissekiKyotakuServiceBusiness>, Serializable {

        private static final long serialVersionUID = -300796001015547240L;

        @Override
        public int compare(KyufujissekiKyotakuServiceBusiness o1, KyufujissekiKyotakuServiceBusiness o2) {
            return o2.get居宅サービス計画費().getサービス提供年月().compareTo(o1.get居宅サービス計画費().getサービス提供年月());
        }
    }
}
