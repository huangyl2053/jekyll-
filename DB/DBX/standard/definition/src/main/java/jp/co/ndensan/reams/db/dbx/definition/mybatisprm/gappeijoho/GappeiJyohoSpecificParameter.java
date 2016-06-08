/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatisprm.gappeijoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村情報取得用パラメータクラス
 *
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

    /**
     * 非公開コンストラクタです。
     *
     *
     * @param hyoujium 表示有無
     * @param useHyoujium 表示有無の使用有無
     * @param shichosonCode 市町村コード
     * @param useShichosonCode 市町村コード使用有無
     * @param hokenshaNo 保険者番号
     * @param useHokenshaNo 保険者番号使用有無
     * @param chiikiNo 地域番号
     * @param useChiikiNoLike 地域番号Like使用有無
     * @param useChiikiNo 地域番号使用有無
     * @param gappeiShurui 合併種類
     * @param useGappeiShurui 合併種類使用有無
     * @param gappeiYMD 合併日
     * @param useGappeiYMD 合併日使用有無
     * @param kyuJohoFuyoToYMD 旧情報付与終了日
     * @param useKyuJohoFuyoToYMD 旧情報付与終了日使用有無
     * @param kokuhorenDataFromYMD 国保連データ連携開始日
     * @param useKokuhorenDataFromYMD 国保連データ連携開始日使用有無
     * @param kijyuYMD 基準日
     * @param useKijyuYMD 基準日使用有無
     */
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
            boolean useKijyuYMD) {
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
    }

    /**
     * 検索パラメータキー設定共通メソッド
     *
     * @param hyoujium 表示有無
     * @param shichosonCode 市町村コード
     * @param hokenshaNo 保険者番号
     * @param chiikiNo 地域番号
     * @param gappeiShurui 合併種類
     * @param gappeiYMD 合併日
     * @param kyuJohoFuyoToYMD 旧情報付与終了日
     * @param kokuhorenDataFromYMD 国保連データ連携開始日
     * @param kijyuYMD 基準日
     * @return GappeiJyohoSpecificParameter
     */
    private static GappeiJyohoSpecificParameter createParam_common(
            RString hyoujium,
            LasdecCode shichosonCode,
            HokenshaNo hokenshaNo,
            RString chiikiNo,
            RString gappeiShurui,
            FlexibleDate gappeiYMD,
            FlexibleDate kyuJohoFuyoToYMD,
            FlexibleDate kokuhorenDataFromYMD,
            FlexibleDate kijyuYMD) {

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
        // 表示有無区分
        if ("1".equals(hyoujium.toString())) {
            useHyoujium = true;
        }
        // 市町村コード
        if (shichosonCode != null) {
            useShichosonCode = true;
        }
        // 保険者番号
        if (!hokenshaNo.isEmpty()) {
            useHokenshaNo = true;
        }
        // 地域番号が入力されている場合
        if (!chiikiNo.isEmpty()) {
            // 地域番号に"%"を含める場合
            if (chiikiNo.indexOf("%") > 0) {
                useChiikiNoLike = true;
            } else {
                // 地域番号に"%"を含まない場合
                useChiikiNo = true;
            }
        }
        // 合併種類
        if (!gappeiShurui.isEmpty()) {
            useGappeiShurui = true;
        }
        // 合併日
        if (!gappeiYMD.isEmpty()) {
            useGappeiYMD = true;
        }
        // 旧CD付加終了年月日
        if (!kyuJohoFuyoToYMD.isEmpty()) {
            useKyuJohoFuyoToYMD = true;
        }
        // 国保連開始日
        if (!kokuhorenDataFromYMD.isEmpty()) {
            useKokuhorenDataFromYMD = true;
        }
        // 基準日
        if (!kijyuYMD.isEmpty()) {
            useKijyuYMD = true;
        }

        // パラメータを返却
        return new GappeiJyohoSpecificParameter(
                hyoujium, useHyoujium, shichosonCode, useShichosonCode, hokenshaNo, useHokenshaNo,
                chiikiNo, useChiikiNoLike, useChiikiNo, gappeiShurui, useGappeiShurui, gappeiYMD, useGappeiYMD,
                kyuJohoFuyoToYMD, useKyuJohoFuyoToYMD, kokuhorenDataFromYMD, useKokuhorenDataFromYMD,
                kijyuYMD, useKijyuYMD);
    }

    /**
     * 単一全合併市町村情報の取得処理の検索パラメータ設定
     *
     * @param hyoujium 表示有無
     * @return GappeiJyohoSpecificParameter
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
                FlexibleDate.EMPTY);
    }

    /**
     * 単一全合併市町村情報検索の取得処理の検索パラメータ設定
     *
     * @param hyoujiUmu 表示有無
     * @param 旧市町村コード 旧市町村コード
     * @param 旧保険者番号 旧保険者番号
     * @return GappeiJyohoSpecificParameter
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
                FlexibleDate.EMPTY);
    }

    /**
     * 広域全合併市町村情報の取得処理の検索パラメータ設定
     *
     * @param hyoujium 表示有無
     * @return GappeiJyohoSpecificParameter
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
                FlexibleDate.EMPTY);
    }

    /**
     * 広域全合併市町村情報検索の取得処理の検索パラメータ設定
     *
     * @param hyoujiUmu 表示有無
     * @param 旧市町村コード 旧市町村コード
     * @param 旧保険者番号 旧保険者番号
     * @return GappeiJyohoSpecificParameter
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
                FlexibleDate.EMPTY);
    }

    /**
     * 最新単一合併市町村情報の取得処理の検索パラメータ設定
     *
     * @param hyoujium 表示有無
     * @return GappeiJyohoSpecificParameter
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
                FlexibleDate.EMPTY);
    }

    /**
     * 最新広域合併市町村情報の取得処理の検索パラメータ設定
     *
     * @param hyoujium 表示有無
     * @return GappeiJyohoSpecificParameter
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
                FlexibleDate.EMPTY);
    }

    /**
     * 検索キーによる単一合併市町村情報の取得処理の検索パラメータ設定
     *
     * @param shichosonCode 市町村コード
     * @param hokenshaNo 保険者番号
     * @return GappeiJyohoSpecificParameter
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
                FlexibleDate.EMPTY);
    }

    /**
     * 検索キーによる広域合併市町村情報の取得処理の検索パラメータ設定
     *
     * @param chiikiNo 地域番号
     * @param gappeiShurui 合併種類
     * @param gappeiYMD 合併日
     * @param shichosonCode 市町村コード
     * @param hokenshaNo 保険者番号
     * @param kyuJohoFuyoToYMD 旧情報付与終了日
     * @param kokuhorenDataFromYMD 国保連データ連携開始日
     * @param kijyuYMD 基準日
     * @return GappeiJyohoSpecificParameter
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
                kijyuYMD);
    }

    /**
     * @return 地域番号 LIKE 使用有無
     */
    public boolean isUseChiikiNoLike() {
        return useChiikiNoLike;
    }

    /**
     * @return 地域番号 使用有無
     */
    public boolean isUseChiikiNo() {
        return useChiikiNo;
    }

    /**
     * @return 表示有無
     */
    public RString getHyoujium() {
        return hyoujium;
    }

    /**
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * @return 保険者番号
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * @return 地域番号
     */
    public RString getChiikiNo() {
        return chiikiNo;
    }

    /**
     * @return 合併種類
     */
    public RString getGappeiShurui() {
        return gappeiShurui;
    }

    /**
     * @return 合併日
     */
    public FlexibleDate getGappeiYMD() {
        return gappeiYMD;
    }

    /**
     * @return 旧情報付与終了日
     */
    public FlexibleDate getKyuJohoFuyoToYMD() {
        return kyuJohoFuyoToYMD;
    }

    /**
     * @return 国保連データ開始日
     */
    public FlexibleDate getKokuhorenDataFromYMD() {
        return kokuhorenDataFromYMD;
    }

    /**
     * @return 基準日
     */
    public FlexibleDate getKijyuYMD() {
        return kijyuYMD;
    }

    /**
     * @return 表示有無 使用有無
     */
    public boolean isUseHyoujium() {
        return useHyoujium;
    }

    /**
     * @return 市町村コード 使用有無
     */
    public boolean isUseShichosonCode() {
        return useShichosonCode;
    }

    /**
     * @return 保険者番号 使用有無
     */
    public boolean isUseHokenshaNo() {
        return useHokenshaNo;
    }

    /**
     * @return 合併種類 使用有無
     */
    public boolean isUseGappeiShurui() {
        return useGappeiShurui;
    }

    /**
     * @return 合併日 使用有無
     */
    public boolean isUseGappeiYMD() {
        return useGappeiYMD;
    }

    /**
     * @return 旧情報付与終了日 使用有無
     */
    public boolean isUseKyuJohoFuyoToYMD() {
        return useKyuJohoFuyoToYMD;
    }

    /**
     * @return 国保連データ連携開始日 使用有無
     */
    public boolean isUseKokuhorenDataFromYMD() {
        return useKokuhorenDataFromYMD;
    }

    /**
     * @return 基準日 使用有無
     */
    public boolean isUseKijyuYMD() {
        return useKijyuYMD;
    }

}
