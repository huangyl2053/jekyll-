/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatisprm.servicecode;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * サービスコード入力検索条件クラスです。
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SabisuKodoParameter {

    private static final RString 抽出パターン_1 = new RString("1");
    private static final RString 抽出パターン_2 = new RString("2");
    private static final RString 抽出パターン_3 = new RString("3");
    private static final RString 抽出パターン_4 = new RString("4");
    private static final RString 抽出パターン_5 = new RString("5");
    private final RString serviceShuruiCode;
    private final boolean isShuruiCodeFlag;
    private final RString serviceKoumokuCode;
    private final boolean isKoumokuCodeFlag;
    private final FlexibleYearMonth haakuKijunYM;
    private final boolean isHaakuKijunYMFlag;
    private final boolean patan1;
    private final boolean patan2;
    private final boolean patan3;
    private final boolean patan4;
    private final boolean patan5;
    private final List<RString> serviceBunrrui;

    private SabisuKodoParameter(
            RString serviceShuruiCode,
            boolean isShuruiCodeFlag,
            RString serviceKoumokuCode,
            boolean isKoumokuCodeFlag,
            FlexibleYearMonth haakuKijunYMD,
            boolean isHaakuKijunYMFlag,
            boolean patan1,
            boolean patan2,
            boolean patan3,
            boolean patan4,
            boolean patan5,
            List<RString> serviceBunrrui) {
        this.serviceShuruiCode = serviceShuruiCode;
        this.isShuruiCodeFlag = isShuruiCodeFlag;
        this.serviceKoumokuCode = serviceKoumokuCode;
        this.isKoumokuCodeFlag = isKoumokuCodeFlag;
        this.haakuKijunYM = haakuKijunYMD;
        this.isHaakuKijunYMFlag = isHaakuKijunYMFlag;
        this.patan1 = patan1;
        this.patan2 = patan2;
        this.patan3 = patan3;
        this.patan4 = patan4;
        this.patan5 = patan5;
        this.serviceBunrrui = serviceBunrrui;
    }

    /**
     * 検索パラメータの設定処理を行います。
     *
     * @param serviceShuruiCode RString
     * @param serviceKoumokuCode RString
     * @param haakuKijunYM RString
     * @return 検索パラメータ
     */
    public static SabisuKodoParameter createSearchParam(
            RString serviceShuruiCode,
            RString serviceKoumokuCode,
            FlexibleYearMonth haakuKijunYM) {
        boolean isShuruiCodeFlag = true;
        boolean isKoumokuCodeFlag = true;
        boolean isHaakuKijunYMFlag = true;
        if (serviceShuruiCode == null || serviceShuruiCode.isEmpty()) {
            isShuruiCodeFlag = false;
        }
        if (serviceKoumokuCode == null || serviceKoumokuCode.isEmpty()) {
            isKoumokuCodeFlag = false;
        }
        if (haakuKijunYM == null || haakuKijunYM.isEmpty()) {
            isHaakuKijunYMFlag = false;
        }
        return new SabisuKodoParameter(
                serviceShuruiCode,
                isShuruiCodeFlag,
                serviceKoumokuCode,
                isKoumokuCodeFlag,
                haakuKijunYM,
                isHaakuKijunYMFlag,
                false,
                false,
                false,
                false,
                false,
                null);
    }

    /**
     * サービス種類取得３の取得のパラメータを作成します。
     *
     * @param haakuKijunYM 基準年月
     * @param 抽出パターン 抽出パターン
     * @return サービス種類取得３の取得のパラメータ
     */
    public static SabisuKodoParameter createSearchParam3(FlexibleYearMonth haakuKijunYM, RString 抽出パターン) {
        return new SabisuKodoParameter(RString.EMPTY,
                false,
                RString.EMPTY,
                false,
                haakuKijunYM,
                false,
                抽出パターン_1.equals(抽出パターン),
                抽出パターン_2.equals(抽出パターン),
                抽出パターン_3.equals(抽出パターン),
                抽出パターン_4.equals(抽出パターン),
                抽出パターン_5.equals(抽出パターン),
                null);
    }

    /**
     * サービス種類取得４の取得のパラメータを作成します。
     *
     * @param haakuKijunYM 基準年月
     * @param サービス分類リスト サービス分類リスト
     * @return サービス種類取得３の取得のパラメータ
     */
    public static SabisuKodoParameter createSearchParam4(FlexibleYearMonth haakuKijunYM, List<RString> サービス分類リスト) {
        return new SabisuKodoParameter(RString.EMPTY,
                false,
                RString.EMPTY,
                false,
                haakuKijunYM,
                false,
                false,
                false,
                false,
                false,
                false,
                サービス分類リスト);
    }
}
