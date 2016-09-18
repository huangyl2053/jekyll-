/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010023;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiCareManagementHi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCareManagementHiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010023.CareManagementMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010023.dgCareManagement_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績照会のケアマネジメント費のhandlerです。
 *
 * @reamsid_L DBC-2970-150 guoqilin
 */
public class CareManagementHandler {

    private final CareManagementMainDiv div;
    private static final RString ZERO = new RString("0");
    private static final int INT_ZERO = 0;
    private static final RString 後 = new RString("後");
    private static final RString 前月 = new RString("前月");
    private final RString 前事業者 = new RString("前事業者");

    /**
     * コンストラクタです。
     *
     * @param div KogakuKaigoServiceMainDiv
     */
    public CareManagementHandler(CareManagementMainDiv div) {
        this.div = div;
    }

    /**
     * ケアマネジメント費等選別です。
     *
     * @param 給付実績ケアマネジメント費データ等 給付実績ケアマネジメント費データ等
     * @param サービス提供年月 サービス提供年月
     * @param 事業者番号リスト 事業者番号リスト
     */
    public void set給付実績ケアマネジメント費データ(List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データ等,
            FlexibleYearMonth サービス提供年月, List<KyufuJissekiHedajyoho2> 事業者番号リスト) {
        this.setGetsuBtn(給付実績ケアマネジメント費データ等, サービス提供年月);
        List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費リスト = new ArrayList<>();
        for (KyufuJissekiCareManagementHiBusiness 給付実績ケアマネジメント費 : 給付実績ケアマネジメント費データ等) {
            if (サービス提供年月 != null && サービス提供年月.compareTo(給付実績ケアマネジメント費.get給付実績ケアマネジメント費基本情報().getサービス提供年月()) == 0) {
                給付実績ケアマネジメント費リスト.add(給付実績ケアマネジメント費);
            }
        }
        if (!給付実績ケアマネジメント費リスト.isEmpty()) {
            this.get給付実績のデータ(給付実績ケアマネジメント費リスト);
        }
        setJigyoshaBtn(事業者番号リスト);
    }

    private void get給付実績のデータ(List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データリスト) {
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データ = new ArrayList<>();
        for (KyufuJissekiCareManagementHiBusiness 給付実績ケアマネジメント費 : 給付実績ケアマネジメント費データリスト) {
            if (事業者番号.equals(to事業所番号(給付実績ケアマネジメント費.get給付実績ケアマネジメント費基本情報().get事業所番号()))
                    && 整理番号.equals(給付実績ケアマネジメント費.get給付実績ケアマネジメント費基本情報().get整理番号())
                    && 様式番号.equals(給付実績ケアマネジメント費.get給付実績ケアマネジメント費基本情報().get入力識別番号().value())) {
                給付実績ケアマネジメント費データ.add(給付実績ケアマネジメント費);
            }
        }
        if (!給付実績ケアマネジメント費データ.isEmpty()) {
            this.setData(給付実績ケアマネジメント費データ);
        }
    }

    private void setData(List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データリスト) {
        List<dgCareManagement_Row> dataSources = new ArrayList<>();
        for (KyufuJissekiCareManagementHiBusiness 給付実績ケアマネジメント費データ : 給付実績ケアマネジメント費データリスト) {
            dgCareManagement_Row row1 = new dgCareManagement_Row();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費基本情報 = 給付実績ケアマネジメント費データ.get給付実績ケアマネジメント費基本情報();
            row1.setTxtShiteiKijunKubun(給付実績ケアマネジメント費基本情報.get指定_基準該当事業所区分コード());
            row1.setTxtIraiTodokedeYMD(to日期変換(給付実績ケアマネジメント費基本情報.get居宅サービス計画作成依頼届出年月日()));
            row1.setTxtService(給付実績ケアマネジメント費データ.getサービス種類略称());
            row1.setTxtTaniTanka(単位数単価変換(給付実績ケアマネジメント費基本情報.get単位数単価()));
            row1.setTxtKettei(RString.EMPTY);
            row1.setTxtTanisu(new RString(給付実績ケアマネジメント費基本情報.get単位数()));
            row1.setTxtKaisu(new RString(給付実績ケアマネジメント費基本情報.get回数()));
            row1.setTxtServiceTanisu(new RString(給付実績ケアマネジメント費基本情報.getサービス単位数()));
            row1.setTxtServiceTanisuGokei(new RString(給付実績ケアマネジメント費基本情報.getサービス単位数合計()));
            row1.setTxtSeikyuKingaku(get金額(給付実績ケアマネジメント費基本情報.get請求金額()));
            row1.setTxtRiyoshaFutangaku(get金額(給付実績ケアマネジメント費基本情報.get利用者負担額()));
            row1.setTxtSenmoninNo(給付実績ケアマネジメント費基本情報.get担当介護支援専門員番号());
            row1.setTxtSaishinsaKaisu(new RString(給付実績ケアマネジメント費基本情報.get再審査回数()));
            row1.setTxtKagoKaisu(new RString(給付実績ケアマネジメント費基本情報.get過誤回数()));
            row1.setTxtShinsaNengetsu(to日期変換(給付実績ケアマネジメント費基本情報.get審査年月()));
            row1.setTxtTekiyo(給付実績ケアマネジメント費基本情報.get摘要());
            dgCareManagement_Row row2 = new dgCareManagement_Row();
            row2.setTxtTaniTanka(単位数単価変換(給付実績ケアマネジメント費基本情報.get単位数単価()));
            row2.setTxtKettei(後);
            row2.setTxtTanisu(new RString(給付実績ケアマネジメント費基本情報.get後_単位数()));
            row2.setTxtKaisu(new RString(給付実績ケアマネジメント費基本情報.get後_回数()));
            row2.setTxtServiceTanisu(new RString(給付実績ケアマネジメント費基本情報.get後_サービス単位数()));
            row2.setTxtServiceTanisuGokei(new RString(給付実績ケアマネジメント費基本情報.get後_サービス単位数合計()));
            row2.setTxtSeikyuKingaku(get金額(給付実績ケアマネジメント費基本情報.get後_請求金額()));
            row2.setTxtRiyoshaFutangaku(get金額(給付実績ケアマネジメント費基本情報.get後_利用者負担額()));
            row2.setTxtSenmoninNo(給付実績ケアマネジメント費基本情報.get担当介護支援専門員番号());
            row2.setTxtSaishinsaKaisu(new RString(給付実績ケアマネジメント費基本情報.get再審査回数()));
            row2.setTxtKagoKaisu(new RString(給付実績ケアマネジメント費基本情報.get過誤回数()));
            row2.setTxtShinsaNengetsu(to日期変換(給付実績ケアマネジメント費基本情報.get審査年月()));
            row2.setTxtTekiyo(給付実績ケアマネジメント費基本情報.get摘要());
            dataSources.add(row1);
            dataSources.add(row2);
        }
        div.getDgCareManagement().setDataSource(dataSources);
    }

    /**
     * change年月です。
     *
     * @param data RString
     * @param 給付実績ケアマネジメント費データリスト List<KyufuJissekiCareManagementHiBusiness>
     * @param 事業者番号リスト 事業者番号リスト
     */
    public void change年月(RString data, List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データリスト, List<KyufuJissekiHedajyoho2> 事業者番号リスト) {
        int index = INT_ZERO;
        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(給付実績ケアマネジメント費データリスト);
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        for (int i = 0; i < サービス提供年月リスト.size(); i++) {
            if (サービス提供年月.equals(サービス提供年月リスト.get(i))) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 今提供年月;
        if (前月.equals(data)) {
            今提供年月 = サービス提供年月リスト.get(index + 1);
            div.getBtnJigetsu().setDisabled(false);
        } else {
            今提供年月 = サービス提供年月リスト.get(index - 1);
            div.getBtnZengetsu().setDisabled(false);
        }
        div.getCcdKyufuJissekiHeader().setサービス提供年月(new RDate(to変換(今提供年月).toString()));
        set給付実績ケアマネジメント費データ(給付実績ケアマネジメント費データリスト, 今提供年月, 事業者番号リスト);
    }

    private void setGetsuBtn(List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データリスト, FlexibleYearMonth サービス提供年月) {
        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(給付実績ケアマネジメント費データリスト);
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        if (サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1))) {
            div.getBtnZengetsu().setDisabled(true);
        }
        if (サービス提供年月リスト.get(INT_ZERO).isBeforeOrEquals(サービス提供年月)) {
            div.getBtnJigetsu().setDisabled(true);
        }
    }

    private List<FlexibleYearMonth> getサービス提供年月リスト(List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データリスト) {
        List<FlexibleYearMonth> サービス提供年月リスト = new ArrayList<>();
        for (KyufuJissekiCareManagementHiBusiness 給付実績ケアマネジメント費 : 給付実績ケアマネジメント費データリスト) {
            FlexibleYearMonth 提供年月 = 給付実績ケアマネジメント費.get給付実績ケアマネジメント費基本情報().getサービス提供年月();
            if (!サービス提供年月リスト.contains(提供年月)) {
                サービス提供年月リスト.add(提供年月);
            }
        }
        return サービス提供年月リスト;
    }

    /**
     * 事業者ボタン状態設定。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     */
    public void setJigyoshaBtn(List<KyufuJissekiHedajyoho2> 事業者番号リスト) {
        if (!事業者番号リスト.isEmpty()) {
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
            int index = get事業者番号index(事業者番号リスト);
            if (0 < index) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index != -1 && index + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    /**
     * change事業者です。
     *
     * @param 事業者 事業者
     * @param 事業者番号リスト 事業者番号リスト
     * @param 給付実績ケアマネジメント費データリスト 給付実績ケアマネジメント費データリスト
     */
    public void change事業者(RString 事業者, List<KyufuJissekiHedajyoho2> 事業者番号リスト,
            List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データリスト) {
        int index = get事業者番号index(事業者番号リスト);
        int i;
        if (前事業者.equals(事業者)) {
            i = -1;
        } else {
            i = 1;
        }
        if (index != -1 && index + i < 事業者番号リスト.size() && 0 < index + i) {
            div.getCcdKyufuJissekiHeader().set事業者名称(事業者番号リスト.get(index + i).get事業者名称());
            div.getCcdKyufuJissekiHeader().set実績区分(事業者番号リスト.get(index + i).get給付実績区分コード());
            div.getCcdKyufuJissekiHeader().set整理番号(事業者番号リスト.get(index + i).get整理番号());
            div.getCcdKyufuJissekiHeader().set識別番号名称(事業者番号リスト.get(index + i).get識別番号名称());
            div.getCcdKyufuJissekiHeader().set様式番号(事業者番号リスト.get(index + i).get識別番号());
            div.getCcdKyufuJissekiHeader().set事業者番号(to事業所番号(事業者番号リスト.get(index + i).get事業所番号()));
            this.set給付実績ケアマネジメント費データ(給付実績ケアマネジメント費データリスト,
                    new FlexibleYearMonth(to変換(div.getCcdKyufuJissekiHeader().getサービス提供年月())), 事業者番号リスト);
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
            if (index + i - 1 > 0) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + i + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    private int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト) {
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString サービス提供年月 = to変換(div.getCcdKyufuJissekiHeader().getサービス提供年月());
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            KyufuJissekiHedajyoho2 給付実績ヘッダ情報2 = 事業者番号リスト.get(index);
            if (事業者番号.equals(to事業所番号(給付実績ヘッダ情報2.get事業所番号()))
                    && 整理番号.equals(給付実績ヘッダ情報2.get整理番号())
                    && 様式番号.equals(給付実績ヘッダ情報2.get識別番号())
                    && サービス提供年月.equals(to変換(給付実績ヘッダ情報2.getサービス提供年月()))
                    && 実績区分コード.equals(給付実績ヘッダ情報2.get給付実績区分コード())) {
                return index;
            }
        }
        return -1;
    }

    /**
     *
     * 制御性設定です。
     *
     * @param 識別番号管理データ 識別番号
     * @param サービス提供年月 サービス提供年月
     */
    public void clear制御性(ShikibetsuNoKanri 識別番号管理データ, FlexibleYearMonth サービス提供年月) {
        div.getBtnCareManagement().setDisabled(true);
        if (ZERO.equals(識別番号管理データ.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
    }

    private RString to日期変換(FlexibleYearMonth 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString to変換(FlexibleYearMonth 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.toDateString();
        }
        return RString.EMPTY;
    }

    private RString to変換(RDate 日期) {
        if (日期 != null) {
            return 日期.getYearMonth().toDateString();
        }
        return RString.EMPTY;
    }

    private RString to事業所番号(JigyoshaNo 事業所番号) {
        if (事業所番号 != null && !事業所番号.isEmpty()) {
            return 事業所番号.value();
        }
        return RString.EMPTY;
    }

    private RString to日期変換(FlexibleDate 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString 単位数単価変換(Decimal 単位数単価変換) {
        RString 単価 = RString.EMPTY;
        if (単位数単価変換 != null) {
            単価 = new RString(単位数単価変換.toString());
        }
        return 単価;
    }

    private RString get金額(int 金額) {
        if (金額 == 0) {
            return RString.EMPTY;
        }
        Decimal 金額変換 = new Decimal(金額);
        return DecimalFormatter.toコンマ区切りRString(金額変換, 0);
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        private static final long serialVersionUID = 1L;

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
        }

    }

}
