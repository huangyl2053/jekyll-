/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.gappeijoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.sortjun.GappeiJohoSortOrder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村情報取得用パラメータクラス。
 *
 * @reamsid_L DBU-0090-010 linghuhang
 */
public final class GappeiJyohoSpecificParameter {

    private final RString hyoujium;
    private final boolean useHyoujium;
    private final LasdecCode shichosonCode;
    private final boolean useShichosonCode;
    private final HokenshaNo hokenshaNo;
    private final boolean useHokenshaNo;
    private final RString chiikiNo;
    private final boolean useChiikiNoLike;
    private final boolean useChiikiNo;
    private final RString gappeiShurui;
    private final boolean useGappeiShurui;
    private final FlexibleDate gappeiYMD;
    private final boolean useGappeiYMD;
    private final FlexibleDate kyuJohoFuyoToYMD;
    private final boolean useKyuJohoFuyoToYMD;
    private final FlexibleDate kokuhorenDataFromYMD;
    private final boolean useKokuhorenDataFromYMD;
    private final FlexibleDate kijyuYMD;
    private final boolean useKijyuYMD;
    private final GappeiJohoSortOrder gappeiJohoSortOrder;

    private GappeiJyohoSpecificParameter(
            RString hyoujium,
            boolean useHyoujium,
            LasdecCode shichosonCode,
            boolean useShichosonCode,
            HokenshaNo hokenshaNo,
            boolean useHokenshaNo,
            RString chiikiNo,
            boolean useChiikiNoLike,
            boolean useChiikiNo,
            RString gappeiShurui,
            boolean useGappeiShurui,
            FlexibleDate gappeiYMD,
            boolean useGappeiYMD,
            FlexibleDate kyuJohoFuyoToYMD,
            boolean useKyuJohoFuyoToYMD,
            FlexibleDate kokuhorenDataFromYMD,
            boolean useKokuhorenDataFromYMD,
            FlexibleDate kijyuYMD,
            boolean useKijyuYMD,
            GappeiJohoSortOrder gappeiJohoSortOrder) {
        this.hyoujium = hyoujium;
        this.useHyoujium = useHyoujium;
        this.shichosonCode = shichosonCode;
        this.useShichosonCode = useShichosonCode;
        this.hokenshaNo = hokenshaNo;
        this.useHokenshaNo = useHokenshaNo;
        this.chiikiNo = chiikiNo;
        this.useChiikiNoLike = useChiikiNoLike;
        this.useChiikiNo = useChiikiNo;
        this.gappeiShurui = gappeiShurui;
        this.useGappeiShurui = useGappeiShurui;
        this.gappeiYMD = gappeiYMD;
        this.useGappeiYMD = useGappeiYMD;
        this.kyuJohoFuyoToYMD = kyuJohoFuyoToYMD;
        this.useKyuJohoFuyoToYMD = useKyuJohoFuyoToYMD;
        this.kokuhorenDataFromYMD = kokuhorenDataFromYMD;
        this.useKokuhorenDataFromYMD = useKokuhorenDataFromYMD;
        this.kijyuYMD = kijyuYMD;
        this.useKijyuYMD = useKijyuYMD;
        this.gappeiJohoSortOrder = gappeiJohoSortOrder;
    }

    private static GappeiJyohoSpecificParameter createParam_common(
            RString hyoujium,
            LasdecCode shichosonCode,
            HokenshaNo hokenshaNo,
            RString chiikiNo,
            RString gappeiShurui,
            FlexibleDate gappeiYMD,
            FlexibleDate kyuJohoFuyoToYMD,
            FlexibleDate kokuhorenDataFromYMD,
            FlexibleDate kijyuYMD,
            GappeiJohoSortOrder gappeiJohoSortOrder) {

        boolean useHyoujium = false;
        boolean useShichosonCode = false;
        boolean useHokenshaNo = false;
        boolean useChiikiNoLike = false;
        boolean useChiikiNo = false;
        boolean useGappeiShurui = false;
        boolean useGappeiYMD = false;
        boolean useKyuJohoFuyoToYMD = false;
        boolean useKokuhorenDataFromYMD = false;
        boolean useKijyuYMD = false;
        if ("1".equals(hyoujium.toString())) {
            useHyoujium = true;
        }
        if (shichosonCode != null && !shichosonCode.isEmpty()) {
            useShichosonCode = true;
        }
        if (hokenshaNo != null && !hokenshaNo.isEmpty()) {
            useHokenshaNo = true;
        }
        if (chiikiNo != null && !chiikiNo.isEmpty()) {
            if (chiikiNo.indexOf("%") >= 0) {
                useChiikiNoLike = true;
            } else {
                useChiikiNo = true;
            }
        }
        if (gappeiShurui != null && !gappeiShurui.isEmpty()) {
            useGappeiShurui = true;
        }
        if (gappeiYMD != null && !gappeiYMD.isEmpty()) {
            useGappeiYMD = true;
        }
        if (kyuJohoFuyoToYMD != null && !kyuJohoFuyoToYMD.isEmpty()) {
            useKyuJohoFuyoToYMD = true;
        }
        if (kokuhorenDataFromYMD != null && !kokuhorenDataFromYMD.isEmpty()) {
            useKokuhorenDataFromYMD = true;
        }
        if (kijyuYMD != null && !kijyuYMD.isEmpty()) {
            useKijyuYMD = true;
        }

        return new GappeiJyohoSpecificParameter(
                hyoujium, useHyoujium, shichosonCode, useShichosonCode, hokenshaNo, useHokenshaNo,
                chiikiNo, useChiikiNoLike, useChiikiNo, gappeiShurui, useGappeiShurui, gappeiYMD, useGappeiYMD,
                kyuJohoFuyoToYMD, useKyuJohoFuyoToYMD, kokuhorenDataFromYMD, useKokuhorenDataFromYMD,
                kijyuYMD, useKijyuYMD, gappeiJohoSortOrder);
    }

    /**
     * 単一全合併市町村情報の取得処理の検索パラメータ設定します。
     *
     * @param hyoujium 表示有無区分
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForTannitsugappeijoho(RString hyoujium) {
        return createParam_common(
                hyoujium,
                null,
                HokenshaNo.EMPTY,
                RString.EMPTY,
                RString.HALF_SPACE,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                null);
    }

    /**
     * 単一全合併市町村情報検索の取得処理の検索パラメータ設定します。
     *
     * @param hyoujiUmu 表示有無区分
     * @param 旧市町村コード 旧市町村コード
     * @param 旧保険者番号 旧保険者番号
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForTannitsugappeijohokensaku(RString hyoujiUmu,
            LasdecCode 旧市町村コード, HokenshaNo 旧保険者番号) {
        return createParam_common(
                hyoujiUmu,
                旧市町村コード,
                旧保険者番号,
                RString.EMPTY,
                RString.HALF_SPACE,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                null);
    }

    /**
     * 広域全合併市町村情報の取得処理の検索パラメータ設定します。
     *
     * @param hyoujium 表示有無区分
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForKouikigappeijoho(RString hyoujium) {
        return createParam_common(
                hyoujium,
                null,
                HokenshaNo.EMPTY,
                RString.EMPTY,
                RString.HALF_SPACE,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                null);
    }

    /**
     * 広域全合併市町村情報検索の取得処理の検索パラメータ設定します。
     *
     * @param hyoujiUmu 表示有無区分
     * @param 旧市町村コード 旧市町村コード
     * @param 旧保険者番号 旧保険者番号
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForKouikigappeijohokensaku(RString hyoujiUmu,
            LasdecCode 旧市町村コード, HokenshaNo 旧保険者番号) {
        return createParam_common(
                hyoujiUmu,
                旧市町村コード,
                旧保険者番号,
                RString.EMPTY,
                RString.HALF_SPACE,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                null);
    }

    /**
     * 最新単一合併市町村情報の取得処理の検索パラメータ設定します。
     *
     * @param hyoujium 表示有無区分
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForSaishintannitsugappeijoho(RString hyoujium) {
        return createParam_common(
                hyoujium,
                null,
                HokenshaNo.EMPTY,
                RString.EMPTY,
                RString.HALF_SPACE,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                null);
    }

    /**
     * 最新広域合併市町村情報の取得処理の検索パラメータ設定します。
     *
     * @param hyoujium 表示有無区分
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForKouikigappeijohokennsaku(RString hyoujium) {
        return createParam_common(
                hyoujium,
                null,
                HokenshaNo.EMPTY,
                RString.EMPTY,
                RString.HALF_SPACE,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                null);
    }

    /**
     * 検索キーによる単一合併市町村情報の取得処理の検索パラメータ設定します。
     *
     * @param shichosonCode 市町村コード
     * @param hokenshaNo 保険者番号
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForKouikigappeijohokennsaku(
            LasdecCode shichosonCode, HokenshaNo hokenshaNo) {
        return createParam_common(
                RString.EMPTY,
                shichosonCode,
                hokenshaNo,
                RString.EMPTY,
                RString.HALF_SPACE,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                null);
    }

    /**
     * 検索キーによる広域合併市町村情報の取得処理の検索パラメータ設定します。
     *
     * @param chiikiNo 地域番号
     * @param gappeiShurui 合併種類
     * @param gappeiYMD 合併日
     * @param shichosonCode 市町村コード
     * @param hokenshaNo 保険者番号
     * @param kyuJohoFuyoToYMD 旧CD付加終了年月日
     * @param kokuhorenDataFromYMD 国保連開始日
     * @param kijyuYMD 基準日
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForKensakukikouikigappeijoho(
            RString chiikiNo, RString gappeiShurui,
            FlexibleDate gappeiYMD, LasdecCode shichosonCode,
            HokenshaNo hokenshaNo, FlexibleDate kyuJohoFuyoToYMD,
            FlexibleDate kokuhorenDataFromYMD, FlexibleDate kijyuYMD) {

        return createParam_common(
                RString.EMPTY,
                shichosonCode,
                hokenshaNo,
                chiikiNo,
                gappeiShurui,
                gappeiYMD,
                kyuJohoFuyoToYMD,
                kokuhorenDataFromYMD,
                kijyuYMD,
                null);
    }

    /**
     * 最新広域合併市町村情報の取得処理の検索パラメータ設定します。
     *
     * @param hyoujium 表示有無区分
     * @param gappeiJohoSortOrder 合併情報ソート順
     * @return GappeiJyohoSpecificParameter パラメータ
     */
    public static GappeiJyohoSpecificParameter createParamForKouikigappeijohoWithSort(RString hyoujium,
            GappeiJohoSortOrder gappeiJohoSortOrder) {
        return createParam_common(
                hyoujium,
                null,
                HokenshaNo.EMPTY,
                RString.EMPTY,
                RString.HALF_SPACE,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                gappeiJohoSortOrder);
    }

    /**
     * useChiikiNoLikeを取得します。
     *
     * @return useChiikiNoLike
     */
    public boolean isUseChiikiNoLike() {
        return useChiikiNoLike;
    }

    /**
     * useChiikiNoを取得します。
     *
     * @return useChiikiNo
     */
    public boolean isUseChiikiNo() {
        return useChiikiNo;
    }

    /**
     * hyoujiumを取得します。
     *
     * @return hyoujium
     */
    public RString getHyoujium() {
        return hyoujium;
    }

    /**
     * shichosonCodeを取得します。
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * hokenshaNoを取得します。
     *
     * @return hokenshaNo
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * chiikiNoを取得します。
     *
     * @return chiikiNo
     */
    public RString getChiikiNo() {
        return chiikiNo;
    }

    /**
     * gappeiShuruiを取得します。
     *
     * @return gappeiShurui
     */
    public RString getGappeiShurui() {
        return gappeiShurui;
    }

    /**
     * gappeiYMDを取得します。
     *
     * @return gappeiYMD
     */
    public FlexibleDate getGappeiYMD() {
        return gappeiYMD;
    }

    /**
     * kyuJohoFuyoToYMDを取得します。
     *
     * @return kyuJohoFuyoToYMD
     */
    public FlexibleDate getKyuJohoFuyoToYMD() {
        return kyuJohoFuyoToYMD;
    }

    /**
     * kokuhorenDataFromYMDを取得します。
     *
     * @return kokuhorenDataFromYMD
     */
    public FlexibleDate getKokuhorenDataFromYMD() {
        return kokuhorenDataFromYMD;
    }

    /**
     * kijyuYMDを取得します。
     *
     * @return kijyuYMD
     */
    public FlexibleDate getKijyuYMD() {
        return kijyuYMD;
    }

    /**
     * useHyoujiumを取得します。
     *
     * @return useHyoujium
     */
    public boolean isUseHyoujium() {
        return useHyoujium;
    }

    /**
     * useShichosonCodeを取得します。
     *
     * @return useShichosonCode
     */
    public boolean isUseShichosonCode() {
        return useShichosonCode;
    }

    /**
     * useHokenshaNoを取得します。
     *
     * @return useHokenshaNo
     */
    public boolean isUseHokenshaNo() {
        return useHokenshaNo;
    }

    /**
     * useGappeiShuruiを取得します。
     *
     * @return useGappeiShurui
     */
    public boolean isUseGappeiShurui() {
        return useGappeiShurui;
    }

    /**
     * useGappeiYMDを取得します。
     *
     * @return useGappeiYMD
     */
    public boolean isUseGappeiYMD() {
        return useGappeiYMD;
    }

    /**
     * useKyuJohoFuyoToYMDを取得します。
     *
     * @return useKyuJohoFuyoToYMD
     */
    public boolean isUseKyuJohoFuyoToYMD() {
        return useKyuJohoFuyoToYMD;
    }

    /**
     * useKokuhorenDataFromYMDを取得します。
     *
     * @return useKokuhorenDataFromYMD
     */
    public boolean isUseKokuhorenDataFromYMD() {
        return useKokuhorenDataFromYMD;
    }

    /**
     * useKijyuYMDを取得します。
     *
     * @return useKijyuYMD
     */
    public boolean isUseKijyuYMD() {
        return useKijyuYMD;
    }

    /**
     * gappeiJohoSortOrderを取得します。
     *
     * @return gappeiJohoSortOrder
     */
    public GappeiJohoSortOrder getGappeiJohoSortOrder() {
        return gappeiJohoSortOrder;
    }
}
