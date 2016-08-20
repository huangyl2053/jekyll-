/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
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
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    public void set事業者名称(RString 事業者名称) {
        div.getTxtJigyosha().setValue(事業者名称);
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
     * 識別番号名称を設定します。
     *
     * @param 識別番号名称 識別番号名称
     */
    public void set識別番号名称(RString 識別番号名称) {
        div.getTxtYoshikiNo().setValue(識別番号名称);
    }

    /**
     * 保険者を設定します。
     *
     * @param 保険者名称 保険者名称
     */
    public void set保険者(RString 保険者名称) {
        div.getTxtHokensha().setValue(保険者名称);
    }

    private void set給付実績ヘッダ情報1(KyufuJissekiHedajyoho1 給付実績ヘッダ情報1) {
        div.getTxtHihoNo().setValue(get被保険者番号(給付実績ヘッダ情報1.get被保険者番号()));
        div.getTxtJuminShubetsu().setValue(get住民種別(給付実績ヘッダ情報1.get資格取得事由コード()));
        // TODO 凌護行 QA1529_#96077回答まち、項目設定が無し、 2016/08/22
//        div.getTxtYoKaigodo().setValue(給付実績ヘッダ情報1.get要介護認定状態区分コード());
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
        div.getTxtHokensha().setValue(給付実績ヘッダ情報1.get名称());
    }

    private void set給付実績ヘッダ情報2(KyufuJissekiHedajyoho2 給付実績ヘッダ情報2) {
        if (給付実績ヘッダ情報2.getサービス提供年月() != null && !給付実績ヘッダ情報2.getサービス提供年月().isEmpty()) {
            div.getTxtTeikyoNengetsu().setValue(new RDate(給付実績ヘッダ情報2.getサービス提供年月().toString()));
        }
        div.getTxtJissekiKubun().setValue(get実績区分(給付実績ヘッダ情報2.get給付実績区分コード()));
        div.getTxtSeiriNo().setValue(給付実績ヘッダ情報2.get整理番号());
        div.getTxtYoshikiNo().setValue(給付実績ヘッダ情報2.get識別番号名称());
        div.getTxtJigyosha().setValue(給付実績ヘッダ情報2.get事業者名称());
    }

    private RString get住民種別(RString 資格取得事由コード) {
        if (!RString.isNullOrEmpty(資格取得事由コード)) {
            return ShikakuShutokuJiyu.toValue(資格取得事由コード).get名称();
        }
        return RString.EMPTY;
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
}
