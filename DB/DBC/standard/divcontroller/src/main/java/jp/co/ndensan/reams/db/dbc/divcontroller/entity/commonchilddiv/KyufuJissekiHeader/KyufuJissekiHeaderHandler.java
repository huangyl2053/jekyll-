/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績基本情報共有子Divクラス。
 *
 * @reamsid_L DBC-2970-160 linghuhang
 */
public class KyufuJissekiHeaderHandler {

    private final KyufuJissekiHeaderDiv div;
    private static final int INT_6 = 6;

    /**
     * コンストラクタです。
     *
     * @param div 給付実績基本情報Div
     */
    public KyufuJissekiHeaderHandler(KyufuJissekiHeaderDiv div) {
        this.div = div;
    }

    /**
     * 給付実績基本情報に初期化を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 識別番号 識別番号
     */
    public void initialize(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号, NyuryokuShikibetsuNo 識別番号) {
        List<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1 = KyufuJissekiShokaiFinder.createInstance().
                getKyufuJissekiHeaderJoho1(被保険者番号).records();
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = KyufuJissekiShokaiFinder.createInstance().
                getKyufuJissekiHeaderJoho2(被保険者番号, サービス提供年月, 整理番号, 識別番号).records();
        if (給付実績ヘッダ情報1 != null && !給付実績ヘッダ情報1.isEmpty()) {
            set給付実績ヘッダ情報1(給付実績ヘッダ情報1.get(0));
        }
        if (給付実績ヘッダ情報2 != null && !給付実績ヘッダ情報2.isEmpty()) {
            set給付実績ヘッダ情報2(給付実績ヘッダ情報2.get(0));
        }
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月 サービス提供年月
     */
    public RDate getサービス提供年月() {
        return div.getTxtTeikyoNengetsu().getValue();
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(RDate サービス提供年月) {
        div.getTxtTeikyoNengetsu().setValue(サービス提供年月);
    }

    /**
     * 実績区分を設定します。
     *
     * @param 実績区分 実績区分
     */
    public void set実績区分(RString 実績区分) {
        div.getTxtJissekiKubun().setValue(get実績区分(実績区分));
        div.setHiddenJissekiKubun(実績区分);
    }

    /**
     * 実績区分コードを取得します。
     *
     * @return 実績区分コード 実績区分コード
     */
    public RString get実績区分コード() {
        return div.getHiddenJissekiKubun();
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    public void set事業者名称(RString 事業者名称) {
        div.getJigyosha().setValue(事業者名称);
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(RString 事業者番号) {
        div.setHiddenJigyoshaCode(事業者番号);
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号 事業者番号
     */
    public RString get事業者番号() {
        return div.getHiddenJigyoshaCode();
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        div.getTxtSeiriNo().setValue(整理番号);
    }

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号 整理番号
     */
    public RString get整理番号() {
        return div.getTxtSeiriNo().getValue();
    }

    /**
     * 識別番号名称を設定します。
     *
     * @param 識別番号名称 識別番号名称
     */
    public void set識別番号名称(RString 識別番号名称) {
        div.getTxtYoshikiNo().setValue(識別番号名称);
    }

    /**
     * 様式番号を取得します。
     *
     * @return 様式番号 様式番号
     */
    public RString get様式番号() {
        return div.getHiddenYoshikiNo();
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     */
    public void set様式番号(RString 様式番号) {
        div.setHiddenYoshikiNo(様式番号);
    }

    /**
     * 要介護度を取得します。
     *
     * @return 要介護度
     */
    public RString get要介護度() {
        return div.getTxtYoKaigodo().getValue();
    }

    private void set給付実績ヘッダ情報1(KyufuJissekiHedajyoho1 給付実績ヘッダ情報1) {
        div.getTxtHihoNo().setValue(get被保険者番号(給付実績ヘッダ情報1.get被保険者番号()));
        div.getTxtJuminShubetsu().setValue(給付実績ヘッダ情報1.get住民種別());
        if (給付実績ヘッダ情報1.get認定年月日() != null && !給付実績ヘッダ情報1.get認定年月日().isEmpty()
                && !RString.isNullOrEmpty(給付実績ヘッダ情報1.get要介護認定状態区分コード())) {
            div.getTxtYoKaigodo().setValue(YokaigoJotaiKubunSupport.toValue(
                    給付実績ヘッダ情報1.get認定年月日().getYearMonth(), 給付実績ヘッダ情報1.get要介護認定状態区分コード()).getName());
        }
        if (給付実績ヘッダ情報1.get認定有効期間開始年月日() != null && !給付実績ヘッダ情報1.get認定有効期間開始年月日().isEmpty()) {
            div.getTxtYukoKikan().setFromValue(new RDate(給付実績ヘッダ情報1.get認定有効期間開始年月日().toString()));
        }
        if (給付実績ヘッダ情報1.get認定有効期間終了年月日() != null && !給付実績ヘッダ情報1.get認定有効期間終了年月日().isEmpty()) {
            div.getTxtYukoKikan().setToValue(new RDate(給付実績ヘッダ情報1.get認定有効期間終了年月日().toString()));
        }
        div.getTxtShimei().setValue(給付実績ヘッダ情報1.get名称());
        div.getTxtSeibetsu().setValue(get性別(給付実績ヘッダ情報1.get性別コード()));
        if (給付実績ヘッダ情報1.get生年月日() != null && !給付実績ヘッダ情報1.get生年月日().isEmpty()) {
            div.getTxtSeinengappi().setValue(new RDate(給付実績ヘッダ情報1.get生年月日().toString()));
        }
    }

    private void set給付実績ヘッダ情報2(KyufuJissekiHedajyoho2 給付実績ヘッダ情報2) {
        if (給付実績ヘッダ情報2.getサービス提供年月() != null && !給付実績ヘッダ情報2.getサービス提供年月().isEmpty()) {
            div.getTxtTeikyoNengetsu().setValue(new RDate(給付実績ヘッダ情報2.getサービス提供年月().toString()));
        }
        div.setHiddenJissekiKubun(給付実績ヘッダ情報2.get給付実績区分コード());
        div.getTxtJissekiKubun().setValue(get実績区分(給付実績ヘッダ情報2.get給付実績区分コード()));
        div.getTxtSeiriNo().setValue(給付実績ヘッダ情報2.get整理番号());
        div.getTxtYoshikiNo().setValue(給付実績ヘッダ情報2.get識別番号名称());
        div.setHiddenYoshikiNo(給付実績ヘッダ情報2.get識別番号());
        div.setHiddenJigyoshaCode(get事業所番号(給付実績ヘッダ情報2.get事業所番号()));
        div.getJigyosha().setValue(給付実績ヘッダ情報2.get事業者名称());
    }

    private RString get性別(RString 性別コード) {
        if (!RString.isNullOrEmpty(性別コード)) {
            return Seibetsu.toValue(性別コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get実績区分(RString 実績区分コード) {
        if (!RString.isNullOrEmpty(実績区分コード)) {
            return KyufuJissekiKubun.toValue(実績区分コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get被保険者番号(HihokenshaNo 被保険者番号) {
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            return 被保険者番号.value();
        }
        return RString.EMPTY;
    }

    private RString get事業所番号(JigyoshaNo 事業所番号) {
        if (事業所番号 != null && !事業所番号.isEmpty()) {
            return 事業所番号.value();
        }
        return RString.EMPTY;
    }

    /**
     * 被保情報を設定します。
     *
     * @param 給付実績基本情報子Divデータ 給付実績基本情報子Divデータ
     */
    public void set被保情報(KyufuJissekiHeader 給付実績基本情報子Divデータ) {
        div.getTxtHihoNo().setValue(給付実績基本情報子Divデータ.get被保険者番号());
        div.getTxtJuminShubetsu().setValue(給付実績基本情報子Divデータ.get住民種別());
        div.getTxtYoKaigodo().setValue(給付実績基本情報子Divデータ.get要介護度());
        div.getTxtYukoKikan().setFromValue(給付実績基本情報子Divデータ.get有効期間開始年月日());
        div.getTxtYukoKikan().setToValue(給付実績基本情報子Divデータ.get有効期間終了年月日());
        div.getTxtShimei().setValue(給付実績基本情報子Divデータ.get氏名());
        div.getTxtSeibetsu().setValue(給付実績基本情報子Divデータ.get性別());
        div.getTxtSeinengappi().setValue(給付実績基本情報子Divデータ.get生年月日());
    }

    /**
     * 被保情報を設定します。
     *
     * @param csData_A 給付実績基本情報子Divデータ
     */
    public void set被保情報2(KyufuJissekiKihonShukeiRelate csData_A) {
        KyufujissekiKihon 給付実績基本データ = csData_A.get給付実績基本データ();
        ShikibetsuNoKanri 識別番号管理 = csData_A.get識別番号管理();
        div.getTxtTeikyoNengetsu().setValue(new RDate(
                給付実績基本データ.getサービス提供年月().getYearValue(), 給付実績基本データ.getサービス提供年月().getMonthValue(), 1));
        if (!RString.isNullOrEmpty(給付実績基本データ.get給付実績情報作成区分コード())) {
            div.getTxtSakuseiKubun().setValue(KyufuSakuseiKubun.toValue(給付実績基本データ.get給付実績情報作成区分コード()).get名称());
        } else {
            div.getTxtSakuseiKubun().clearValue();
        }
        if (null == 給付実績基本データ.get証記載保険者番号() || 給付実績基本データ.get証記載保険者番号().isEmpty()) {
            div.getTxtShokisaiHokenshaNo().clearValue();
        } else {
            RString 証記載保険者番号 = 給付実績基本データ.get証記載保険者番号().getColumnValue();
            証記載保険者番号 = (証記載保険者番号.length() <= INT_6
                    ? 証記載保険者番号 : 証記載保険者番号.substring(証記載保険者番号.length() - INT_6)).replace("0", "");
            div.getTxtShokisaiHokenshaNo().setValue(証記載保険者番号);
        }
        set実績区分(給付実績基本データ.get給付実績区分コード());
        set整理番号(給付実績基本データ.get整理番号());
        set識別番号名称(識別番号管理.get識別番号());
        div.getTxtYoshikiMeisho().setValue(識別番号管理.get名称());
        if (csData_A.get事業者名称() != null) {
            div.getJigyosha().setValue(csData_A.get事業者名称().getColumnValue());
        } else {
            div.getJigyosha().clearValue();
        }
        if (給付実績基本データ.get事業者番号() != null) {
            RString 事業者番号 = 給付実績基本データ.get事業者番号().getColumnValue();
            if (事業者番号.isEmpty() || Integer.parseInt(事業者番号.toString()) == 0) {
                div.getTxtJigyoshaNo().clearValue();
                div.getJigyosha().clearValue();
            } else {
                div.getTxtJigyoshaNo().setValue(給付実績基本データ.get事業者番号().getColumnValue());
            }
        } else {
            div.getTxtJigyoshaNo().clearValue();
            div.getJigyosha().clearValue();
        }
    }

    /**
     * 給付実績基本情報データを取得します。
     *
     * @return 給付実績基本情報データ 給付実績基本情報データ
     */
    public KyufuJissekiHeaderAll get給付実績基本情報データ() {
        KyufuJissekiHeaderAll 給付実績基本情報 = new KyufuJissekiHeaderAll();
        給付実績基本情報.set被保険者番号(div.getTxtHihoNo().getValue());
        給付実績基本情報.set住民種別(div.getTxtJuminShubetsu().getValue());
        給付実績基本情報.set要介護度(div.getTxtYoKaigodo().getValue());
        給付実績基本情報.set氏名(div.getTxtShimei().getValue());
        給付実績基本情報.set性別(div.getTxtSeibetsu().getValue());
        給付実績基本情報.set有効期間開始年月日(div.getTxtYukoKikan().getFromValue());
        給付実績基本情報.set有効期間終了年月日(div.getTxtYukoKikan().getToValue());
        給付実績基本情報.set生年月日(div.getTxtSeinengappi().getValue());
        給付実績基本情報.set提供年月(div.getTxtTeikyoNengetsu().getValue());
        給付実績基本情報.set実績区分(div.getTxtJissekiKubun().getValue());
        給付実績基本情報.set作成区分(div.getTxtSakuseiKubun().getValue());
        給付実績基本情報.set整理番号(div.getTxtSeiriNo().getValue());
        給付実績基本情報.set証記載保険者番号(div.getTxtShokisaiHokenshaNo().getValue());
        給付実績基本情報.set様式番号(div.getTxtYoshikiNo().getValue());
        給付実績基本情報.set様式番号_Name(div.getTxtYoshikiMeisho().getValue());
        給付実績基本情報.set事業者(div.getTxtJigyoshaNo().getValue());
        給付実績基本情報.set事業者_Name(div.getJigyosha().getValue());
        return 給付実績基本情報;
    }

    /**
     * 給付実績基本情報を設定します。
     *
     * @param 給付実績基本情報 給付実績基本情報子Divデータ
     */
    public void set給付実績基本情報データ(KyufuJissekiHeaderAll 給付実績基本情報) {
        div.getTxtHihoNo().setValue(給付実績基本情報.get被保険者番号());
        div.getTxtJuminShubetsu().setValue(給付実績基本情報.get住民種別());
        div.getTxtYoKaigodo().setValue(給付実績基本情報.get要介護度());
        div.getTxtYukoKikan().setFromValue(給付実績基本情報.get有効期間開始年月日());
        div.getTxtYukoKikan().setToValue(給付実績基本情報.get有効期間終了年月日());
        div.getTxtShimei().setValue(給付実績基本情報.get氏名());
        div.getTxtSeibetsu().setValue(給付実績基本情報.get性別());
        div.getTxtSeinengappi().setValue(給付実績基本情報.get生年月日());
        div.getTxtTeikyoNengetsu().setValue(給付実績基本情報.get提供年月());
        div.getTxtSakuseiKubun().setValue(給付実績基本情報.get作成区分());
        div.getTxtShokisaiHokenshaNo()
                .setValue(給付実績基本情報.get証記載保険者番号());
        div.getTxtJissekiKubun().setValue(給付実績基本情報.get実績区分());
        set整理番号(給付実績基本情報.get整理番号());
        set識別番号名称(給付実績基本情報.get様式番号());
        div.getTxtYoshikiMeisho().setValue(給付実績基本情報.get様式番号_Name());
        div.getTxtJigyoshaNo().setValue(給付実績基本情報.get事業者());
        div.getJigyosha().setValue(給付実績基本情報.get事業者_Name());
    }
}
