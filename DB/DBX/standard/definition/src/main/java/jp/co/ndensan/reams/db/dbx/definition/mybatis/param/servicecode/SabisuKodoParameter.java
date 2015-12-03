/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatis.param.servicecode;

import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード入力検索条件クラスです。
 */
public final class SabisuKodoParameter {

    private final KaigoServiceShuruiCode serviceShuruiCode;
    private final boolean isShuruiCodeFlag;
    private final RString serviceKoumokuCode;
    private final boolean isKoumokuCodeFlag;
    private final FlexibleYearMonth haakuKijunYM;
    private final boolean isHaakuKijunYMFlag;

    private SabisuKodoParameter(
            KaigoServiceShuruiCode serviceShuruiCode,
            boolean isShuruiCodeFlag,
            RString serviceKoumokuCode,
            boolean isKoumokuCodeFlag,
            FlexibleYearMonth haakuKijunYMD,
            boolean isHaakuKijunYMFlag) {
        this.serviceShuruiCode = serviceShuruiCode;
        this.isShuruiCodeFlag = isShuruiCodeFlag;
        this.serviceKoumokuCode = serviceKoumokuCode;
        this.isKoumokuCodeFlag = isKoumokuCodeFlag;
        this.haakuKijunYM = haakuKijunYMD;
        this.isHaakuKijunYMFlag = isHaakuKijunYMFlag;
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
            KaigoServiceShuruiCode serviceShuruiCode,
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
                isHaakuKijunYMFlag);
    }

    /**
     * serviceShuruiCodeを返します。
     *
     * @return serviceShuruiCode
     */
    public KaigoServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * serviceKoumokuCodeを返します。
     *
     * @return serviceKoumokuCode
     */
    public RString getServiceKoumokuCode() {
        return serviceKoumokuCode;
    }

    /**
     * haakuKijunYMを返します。
     *
     * @return haakuKijunYM
     */
    public FlexibleYearMonth getHaakuKijunYM() {
        return haakuKijunYM;
    }

    /**
     * isShuruiCodeFlagを返します。
     *
     * @return isShuruiCodeFlag
     */
    public boolean isIsShuruiCodeFlag() {
        return isShuruiCodeFlag;
    }

    /**
     * isKoumokuCodeFlagを返します。
     *
     * @return isKoumokuCodeFlag
     */
    public boolean isIsKoumokuCodeFlag() {
        return isKoumokuCodeFlag;
    }

    /**
     * isHaakuKijunYMFlagを返します。
     *
     * @return isHaakuKijunYMFlag
     */
    public boolean isIsHaakuKijunYMFlag() {
        return isHaakuKijunYMFlag;
    }
}
