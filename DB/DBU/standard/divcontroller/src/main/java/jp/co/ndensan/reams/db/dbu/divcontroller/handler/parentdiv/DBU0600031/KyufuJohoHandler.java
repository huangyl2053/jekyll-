/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbu.business.core.kyufujoho.KyufuJohoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho.KounyukingakuParamter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600031.KyufuJohoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceBunrui;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合照会_給付情報のHandlerです。
 *
 * @reamsid_L DBU-4100-040 wanghuafeng
 */
public class KyufuJohoHandler {

    private static final int MONTH_3 = 3;
    private final KyufuJohoDiv div;

    /**
     * インスタンスです。
     *
     * @param div KyufuJohoDiv
     */
    public KyufuJohoHandler(KyufuJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化です。
     *
     * @param key TaishoshaKey
     */
    public void onLoad(TaishoshaKey key) {
        div.getCcdKaigoatenaInfo().initialize(key.get識別コード());
        div.getCcdKaigoShikakuKihon().initialize(key.get被保険者番号());
        div.getBtnKyufuInfo().setDisabled(true);
    }

    /**
     * 居宅サービス計画情報の取得です。
     *
     * @param kyufuJoho KyufuJohoBusiness
     */
    public void set居宅サービス計画情報(KyufuJohoBusiness kyufuJoho) {
        if (kyufuJoho != null) {
            div.getTxtTodokede().setValue(new RDate(kyufuJoho.get届出年月日().toString()));
            div.getTxtKeikakuSakuseiKubun().setValue(set作成区分(kyufuJoho));
        }

    }

    /**
     * 前年度福祉用具販売費情報の取得です。
     *
     * @param kyufuJoho KyufuJohoBusiness
     */
    public void set前年度情報(KyufuJohoBusiness kyufuJoho) {
        RDate date = RDate.getNowDate();
        if (date.getMonthValue() <= MONTH_3) {
            div.getTxtMaeNando().setValue(new RString(date.getYearValue() - 2));
        } else {
            div.getTxtMaeNando().setValue(new RString(date.getYearValue() - 1));
        }
        if (kyufuJoho != null) {
            div.getTxtMaeKingakuGoukei().setValue(カンマ編集(kyufuJoho.get購入金額()));
            div.getTxtMaeSeihutankuGoukei().setValue(カンマ編集(kyufuJoho.get保険請求額()));
            div.getTxtMaeSeikyukuGoukei().setValue(カンマ編集(kyufuJoho.get利用者負担額()));
        }
    }

    /**
     * 今年度福祉用具販売費情報の取得です。
     *
     * @param kyufuJoho KyufuJohoBusiness
     */
    public void set今年度情報(KyufuJohoBusiness kyufuJoho) {
        RDate date = RDate.getNowDate();
        if (date.getMonthValue() <= MONTH_3) {
            div.getTxtKonNando().setValue(new RString(date.getYearValue() - 1));
        } else {
            div.getTxtKonNando().setValue(new RString(date.getYearValue()));
        }
        if (kyufuJoho != null) {
            div.getTxtKonKingakuGoukei().setValue(カンマ編集(kyufuJoho.get購入金額()));
            div.getTxtKonSeihutankuGoukei().setValue(カンマ編集(kyufuJoho.get保険請求額()));
            div.getTxtKonSeikyukuGoukei().setValue(カンマ編集(kyufuJoho.get利用者負担額()));
        }
    }

    /**
     * 住宅改修費情報の取得です。
     *
     * @param kyufuJoho List<KyufuJohoBusiness>
     */
    public void set住宅改修費用合計(KyufuJohoBusiness kyufuJoho) {
        if (kyufuJoho != null) {
            div.getTxtKaishuuHiyouGoukei().setValue(カンマ編集(kyufuJoho.get改修費用合計()));
        }
    }

    /**
     * 住宅改修請求負担額の取得です。
     *
     * @param kyufuJoho KyufuJohoBusiness
     */
    public void set住宅改修請求負担額(KyufuJohoBusiness kyufuJoho) {
        if (kyufuJoho != null) {
            div.getTxtHokenSeikyuGakuGoukei().setValue(カンマ編集(kyufuJoho.get保険請求額()));
            div.getTxtRiyoushaHutanGakuGoukei().setValue(カンマ編集(kyufuJoho.get利用者負担額()));
        }
    }

    /**
     * サービス利用状況情報の取得です。
     *
     * @param kyufuJohos KyufuJohoBusiness
     */
    public void set利用状況情報(List<KyufuJohoBusiness> kyufuJohos) {
        for (KyufuJohoBusiness kyufuJoho : kyufuJohos) {
            div.getTxtSaishinSabisu().setValue(set最新サービス内容(kyufuJoho));
        }
    }

    /**
     * 前年度抽出範囲のセットです。
     *
     * @param key TaishoshaKey
     * @return KounyukingakuParamter
     */
    public KounyukingakuParamter set前年度抽出範囲(TaishoshaKey key) {
        RDate date = RDate.getNowDate();
        StringBuilder 前年度抽出開始年月 = new StringBuilder();
        StringBuilder 前年度抽出終了年月 = new StringBuilder();
        if (date.getMonthValue() <= MONTH_3) {
            前年度抽出開始年月.append(date.getYearValue() - 2);
            前年度抽出開始年月.append("04");
            前年度抽出終了年月.append(date.getYearValue() - 1);
            前年度抽出終了年月.append("03");
        } else {
            前年度抽出開始年月.append(date.getYearValue() - 1);
            前年度抽出開始年月.append("04");
            前年度抽出終了年月.append(date.getYearValue());
            前年度抽出終了年月.append("03");
        }
        return KounyukingakuParamter.createParameter(key.get被保険者番号().value(), new RString(前年度抽出開始年月.toString()),
                new RString(前年度抽出終了年月.toString()), ShikyuFushikyuKubun.支給.getコード());
    }

    /**
     * 今年度抽出範囲のセットです。
     *
     * @param key TaishoshaKey
     * @return KounyukingakuParamter
     */
    public KounyukingakuParamter set今年度抽出範囲(TaishoshaKey key) {
        RDate date = RDate.getNowDate();
        StringBuilder 今年度抽出開始年月 = new StringBuilder();
        StringBuilder 今年度抽出終了年月 = new StringBuilder();
        if (date.getMonthValue() <= MONTH_3) {
            今年度抽出開始年月.append(date.getYearValue() - 1);
            今年度抽出開始年月.append("04");
            今年度抽出終了年月.append(date.getYearValue());
            今年度抽出終了年月.append("03");
        } else {
            今年度抽出開始年月.append(date.getYearValue());
            今年度抽出開始年月.append("04");
            今年度抽出終了年月.append(date.getYearValue() + 1);
            今年度抽出終了年月.append("03");
        }
        return KounyukingakuParamter.createParameter(key.get被保険者番号().value(), new RString(今年度抽出開始年月.toString()),
                new RString(今年度抽出終了年月.toString()), ShikyuFushikyuKubun.支給.getコード());
    }

    /**
     * サービス分類コードのセットです。
     *
     * @return List
     */
    public List get分類コード() {
        List bunnrui = new ArrayList();
        bunnrui.add(ServiceBunrui.居宅サービス.getコード());
        bunnrui.add(ServiceBunrui.施設サービス.getコード());
        bunnrui.add(ServiceBunrui.地域密着型サービス.getコード());
        return bunnrui;
    }

    private RString set作成区分(KyufuJohoBusiness kyufujoho) {
        if (kyufujoho.get事業作成区分() != null) {
            div.getTxtKeikakuSakuseiKubun().setValue(kyufujoho.get事業作成区分());
            div.getTxtTekyouKikan().setFromValue(new RDate(kyufujoho.get事業適用開始().toString()));
            div.getTxtTekyouKikan().setToValue(new RDate(kyufujoho.get事業適用終了().toString()));
            div.getTxtZigyoushaKodo().setValue(kyufujoho.get計画事業所番号());
            if (kyufujoho.get事業者名称() != null) {
                div.getTxtZigyoushaMesai().setValue(kyufujoho.get事業者名称().get事業者名称().value());
            }
        }
        if (kyufujoho.get自己計画作成区分() != null) {
            div.getTxtKeikakuSakuseiKubun().setValue(kyufujoho.get自己計画作成区分());
            div.getTxtTekyouKikan().setFromValue(new RDate(kyufujoho.get自己適用開始().toString()));
            div.getTxtTekyouKikan().setToValue(new RDate(kyufujoho.get自己適用終了().toString()));
            div.getTxtZigyoushaKodo().setValue(RString.EMPTY);
            div.getTxtZigyoushaMesai().setValue(RString.EMPTY);
        }
        return RString.EMPTY;
    }

    private RString カンマ編集(int kegaku) {
        Decimal 金額カンマ = new Decimal(kegaku);
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(金額カンマ, 0));
        return new RString(金額カンマ.toString());
    }

    private RString set最新サービス内容(KyufuJohoBusiness kyufuJoho) {
        RString 提供年月 = RString.EMPTY;
        RString 分類コード = RString.EMPTY;
        if (ServiceBunrui.施設サービス.getコード().equals(kyufuJoho.getサービス分類コード())) {
            提供年月 = kyufuJoho.getサービス提供年月();
            分類コード = kyufuJoho.getサービス分類コード();
        }
        if (ServiceBunrui.居宅サービス.getコード().equals(kyufuJoho.getサービス分類コード())) {
            if (!kyufuJoho.getサービス提供年月().equals(提供年月)) {
                提供年月 = kyufuJoho.getサービス提供年月();
                分類コード = kyufuJoho.getサービス分類コード();
            } else {
                if (提供年月.isEmpty() || 分類コード.equals(ServiceBunrui.地域密着型サービス.getコード())) {
                    分類コード = kyufuJoho.getサービス分類コード();
                }
            }
        }
        if (ServiceBunrui.地域密着型サービス.getコード().equals(kyufuJoho.getサービス分類コード())) {
            if (!kyufuJoho.getサービス提供年月().equals(提供年月)) {
                分類コード = kyufuJoho.getサービス分類コード();
            } else {
                if (提供年月.isEmpty()) {
                    分類コード = kyufuJoho.getサービス分類コード();
                }
            }
        }
        return ServiceBunrui.toValue(分類コード).get名称();
    }
}
