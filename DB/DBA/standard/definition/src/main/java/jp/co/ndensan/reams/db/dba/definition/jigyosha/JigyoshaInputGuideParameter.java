/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.jigyosha;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者施設オブジェクトパラメータクラス。
 */
public final class JigyoshaInputGuideParameter {

    private final KaigoJigyoshaNo jigyoshaNo;
    private final boolean isJigyoshaNoFlag;
    private final FlexibleDate yukoKaishiYMDFrom;
    private final FlexibleDate yukoKaishiYMDTo;
    private final boolean isYukoKaishiYMDFromFlag;
    private final boolean isYukoKaishiYMDToFlag;
    private final AtenaMeisho jigyoshaName;
    private final boolean isJigyoshaName;
    private final YubinNo yubinNo;
    private final boolean isYubinNo;
    private final RString address;
    private final boolean isAddress;
    private final RString serviceShuRui;
    private final boolean isServiceShuRui;
    private final RString jigyoshaKbn;
    private final boolean isJigyoshaKbn;
    private final RString zennpouitti;
    private final boolean isZennpouitti;
    private final RString gunshiCode;
    private final boolean isGunshiCode;
    private final FlexibleDate systemdate;
    private final RString kenCode;
    private final RString jigyoshaShubetsu;
    private final RString kannaiKangaiKubun;
    private final int limitCount;

    private JigyoshaInputGuideParameter(
            KaigoJigyoshaNo jigyoshaNo,
            boolean isJigyoshaNoFlag,
            FlexibleDate yukoKaishiYMDFrom,
            FlexibleDate yukoKaishiYMDTo,
            boolean isYukoKaishiYMDFromFlag,
            boolean isYukoKaishiYMDToFlag,
            AtenaMeisho jigyoshaName,
            boolean isJigyoshaName,
            YubinNo yubinNo,
            boolean isYubinNo,
            RString address,
            boolean isAddress,
            RString serviceShuRui,
            boolean isServiceShuRui,
            RString jigyoshaKbn,
            boolean isJigyoshaKbn,
            RString zennpouitti,
            boolean isZennpouitti,
            RString gunshiCode,
            boolean isGunshiCode,
            FlexibleDate systemdate,
            RString kenCode,
            RString jigyoshaShubetsu,
            RString kannaiKangaiKubun,
            int limitCount) {
        this.jigyoshaNo = jigyoshaNo;
        this.isJigyoshaNoFlag = isJigyoshaNoFlag;
        this.yukoKaishiYMDFrom = yukoKaishiYMDFrom;
        this.yukoKaishiYMDTo = yukoKaishiYMDTo;
        this.isYukoKaishiYMDFromFlag = isYukoKaishiYMDFromFlag;
        this.isYukoKaishiYMDToFlag = isYukoKaishiYMDToFlag;
        this.jigyoshaName = jigyoshaName;
        this.isJigyoshaName = isJigyoshaName;
        this.yubinNo = yubinNo;
        this.isYubinNo = isYubinNo;
        this.address = address;
        this.isAddress = isAddress;
        this.serviceShuRui = serviceShuRui;
        this.isServiceShuRui = isServiceShuRui;
        this.jigyoshaKbn = jigyoshaKbn;
        this.isJigyoshaKbn = isJigyoshaKbn;
        this.zennpouitti = zennpouitti;
        this.isZennpouitti = isZennpouitti;
        this.gunshiCode = gunshiCode;
        this.isGunshiCode = isGunshiCode;
        this.systemdate = systemdate;
        this.kenCode = kenCode;
        this.jigyoshaShubetsu = jigyoshaShubetsu;
        this.kannaiKangaiKubun = kannaiKangaiKubun;
        this.limitCount = limitCount;
    }

    /**
     * 共通パラメータ設定。
     *
     * @param jigyoshaNo 事業者番号
     * @param yukoKaishiYMDFrom 有効開始日From
     * @param yukoKaishiYMDTo 有効開始日To
     * @param jigyoshaName 事業者名称
     * @param yubinNo 郵便番号
     * @param address 住所
     * @param serviceShuRui サービス種類
     * @param jigyoshaKbn 事業者区分
     * @param zennpouitti 検索条件区分
     * @param gunshiCode 郡市コード
     * @param systemdate システム日付
     * @param kenCode 県コード
     * @param jigyoshaShubetsu 事業者種別
     * @param kannaiKangaiKubun 管内・管外区分
     * @param limitCount 表示件数
     * @return JigyoshaInputGuideParameter
     */
    public static JigyoshaInputGuideParameter createParam_common(
            KaigoJigyoshaNo jigyoshaNo,
            FlexibleDate yukoKaishiYMDFrom,
            FlexibleDate yukoKaishiYMDTo,
            AtenaMeisho jigyoshaName,
            YubinNo yubinNo,
            RString address,
            RString serviceShuRui,
            RString jigyoshaKbn,
            RString zennpouitti,
            RString gunshiCode,
            FlexibleDate systemdate,
            RString kenCode,
            RString jigyoshaShubetsu,
            RString kannaiKangaiKubun,
            int limitCount) {
        boolean isJigyoshaNoFlag = false;
        boolean isYukoKaishiYMDFromFlag = false;
        boolean isYukoKaishiYMDToFlag = false;
        boolean isJigyoshaName = false;
        boolean isYubinNo = false;
        boolean isAddress = false;
        boolean isServiceShuRui = false;
        boolean isJigyoshaKbn = false;
        boolean isZennpouitti = false;
        boolean isGunshiCode = false;

        if (jigyoshaNo != null && !jigyoshaNo.value().isEmpty()) {
            isJigyoshaNoFlag = true;
        }
        if (yukoKaishiYMDFrom != null && !yukoKaishiYMDFrom.isEmpty()) {
            isYukoKaishiYMDFromFlag = true;
        }
        if (yukoKaishiYMDTo != null && !yukoKaishiYMDTo.isEmpty()) {
            isYukoKaishiYMDToFlag = true;
        }
        if (jigyoshaName != null && !jigyoshaName.isEmpty()) {
            isJigyoshaName = true;
        }
        if (yubinNo != null && !yubinNo.isEmpty()) {
            isYubinNo = true;
        }
        if (address != null && !address.isEmpty()) {
            isAddress = true;
        }
        if (serviceShuRui != null && !serviceShuRui.isEmpty()) {
            isServiceShuRui = true;
        }
        if (new RString("key0").equals(zennpouitti)) {
            isZennpouitti = false;
        }
        if (new RString("key1").equals(zennpouitti)) {
            isZennpouitti = true;
        }
        if (jigyoshaKbn != null && !jigyoshaKbn.isEmpty()) {
            isJigyoshaKbn = true;
        }
        if (gunshiCode != null && !gunshiCode.isEmpty()) {
            isGunshiCode = true;
        }

        return new JigyoshaInputGuideParameter(
                jigyoshaNo,
                isJigyoshaNoFlag,
                yukoKaishiYMDFrom,
                yukoKaishiYMDTo,
                isYukoKaishiYMDFromFlag,
                isYukoKaishiYMDToFlag,
                jigyoshaName,
                isJigyoshaName,
                yubinNo,
                isYubinNo,
                address,
                isAddress,
                serviceShuRui,
                isServiceShuRui,
                jigyoshaKbn,
                isJigyoshaKbn,
                zennpouitti,
                isZennpouitti,
                gunshiCode,
                isGunshiCode,
                systemdate,
                kenCode,
                jigyoshaShubetsu,
                kannaiKangaiKubun,
                limitCount);
    }

    /**
     * サービス事業者取得パラメータ設定。
     *
     * @param jigyoshaNo 事業者番号
     * @param yukoKaishiYMDFrom 有効開始日From
     * @param yukoKaishiYMDTo 有効開始日To
     * @param jigyoshaName 事業者名称
     * @param yubinNo 郵便番号
     * @param address 住所
     * @param serviceShuRui サービス種類
     * @param jigyoshaKbn 事業者区分
     * @param zennpouitti 検索条件区分
     * @param gunshiCode 郡市コード
     * @param systemdate システム日付
     * @param kenCode 県コード
     * @param limitCount 表示件数
     * @return createParam_common
     */
    public static JigyoshaInputGuideParameter createParam_ServiceJigyoshaInputGuide(
            KaigoJigyoshaNo jigyoshaNo,
            FlexibleDate yukoKaishiYMDFrom,
            FlexibleDate yukoKaishiYMDTo,
            AtenaMeisho jigyoshaName,
            YubinNo yubinNo,
            RString address,
            RString serviceShuRui,
            RString jigyoshaKbn,
            RString zennpouitti,
            RString gunshiCode,
            FlexibleDate systemdate,
            RString kenCode,
            int limitCount) {
        return createParam_common(
                jigyoshaNo,
                yukoKaishiYMDFrom,
                yukoKaishiYMDTo,
                jigyoshaName,
                yubinNo,
                address,
                serviceShuRui,
                jigyoshaKbn,
                zennpouitti,
                gunshiCode,
                systemdate,
                kenCode,
                RString.EMPTY,
                RString.EMPTY,
                limitCount);

    }

    /**
     * 適用除外施設取得パラメータ設定。
     *
     * @param jigyoshaNo 事業者番号
     * @param yukoKaishiYMDFrom 有効開始日From
     * @param yukoKaishiYMDTo 有効開始日To
     * @param jigyoshaName 事業者名称
     * @param yubinNo 郵便番号
     * @param address 住所
     * @param zennpouitti 検索条件区分
     * @param systemdate システム日付
     * @param jigyoshaShubetsu 事業者種別
     * @param limitCount 表示件数
     * @return createParam_common
     */
    public static JigyoshaInputGuideParameter createParam_TekiyoJogaiInputGuide(
            KaigoJigyoshaNo jigyoshaNo,
            FlexibleDate yukoKaishiYMDFrom,
            FlexibleDate yukoKaishiYMDTo,
            AtenaMeisho jigyoshaName,
            YubinNo yubinNo,
            RString address,
            RString zennpouitti,
            FlexibleDate systemdate,
            RString jigyoshaShubetsu,
            int limitCount) {
        return createParam_common(
                jigyoshaNo,
                yukoKaishiYMDFrom,
                yukoKaishiYMDTo,
                jigyoshaName,
                yubinNo,
                address,
                RString.EMPTY,
                RString.EMPTY,
                zennpouitti,
                RString.EMPTY,
                systemdate,
                RString.EMPTY,
                jigyoshaShubetsu,
                RString.EMPTY,
                limitCount);
    }

    /**
     * その他特例施設取得パラメータ設定。
     *
     * @param jigyoshaNo 事業者番号
     * @param yukoKaishiYMDFrom 有効開始日From
     * @param yukoKaishiYMDTo 有効開始日To
     * @param jigyoshaName 事業者名称
     * @param yubinNo 郵便番号
     * @param address 住所
     * @param zennpouitti 検索条件区分
     * @param systemdate システム日付
     * @param kannaiKangaiKubun 管内・管外区分
     * @param jigyoshaShubetsu 事業者種別
     * @param limitCount 表示件数
     * @return createParam_common
     */
    public static JigyoshaInputGuideParameter createParam_OtherTokureiInputGuide(
            KaigoJigyoshaNo jigyoshaNo,
            FlexibleDate yukoKaishiYMDFrom,
            FlexibleDate yukoKaishiYMDTo,
            AtenaMeisho jigyoshaName,
            YubinNo yubinNo,
            RString address,
            RString zennpouitti,
            FlexibleDate systemdate,
            RString kannaiKangaiKubun,
            RString jigyoshaShubetsu,
            int limitCount) {
        return createParam_common(
                jigyoshaNo,
                yukoKaishiYMDFrom,
                yukoKaishiYMDTo,
                jigyoshaName,
                yubinNo,
                address,
                RString.EMPTY,
                RString.EMPTY,
                zennpouitti,
                RString.EMPTY,
                systemdate,
                RString.EMPTY,
                jigyoshaShubetsu,
                kannaiKangaiKubun,
                limitCount);
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号フラグを返します。
     *
     * @return 事業者番号フラグ
     */
    public boolean isIsJigyoshaNoFlag() {
        return isJigyoshaNoFlag;
    }

    /**
     * 有効開始日Fromを返します。
     *
     * @return 有効開始日From
     */
    public FlexibleDate getYukoKaishiYMDFrom() {
        return yukoKaishiYMDFrom;
    }

    /**
     * 有効開始日Fromフラグを返します。
     *
     * @return 有効開始日Fromフラグ
     */
    public boolean isIsYukoKaishiYMDFromFlag() {
        return isYukoKaishiYMDFromFlag;
    }

    /**
     * 有効開始日Toを返します。
     *
     * @return 有効開始日To
     */
    public FlexibleDate getYukoKaishiYMDTo() {
        return yukoKaishiYMDTo;
    }

    /**
     * 有効開始日Toフラグを返します。
     *
     * @return 有効開始日Toフラグ
     */
    public boolean isIsYukoKaishiYMDToFlag() {
        return isYukoKaishiYMDToFlag;
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho getJigyoshaName() {
        return jigyoshaName;
    }

    /**
     * 事業者名称フラグを返します。
     *
     * @return 事業者名称フラグ
     */
    public boolean isIsJigyoshaName() {
        return isJigyoshaName;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号フラグを返します。
     *
     * @return 郵便番号フラグ
     */
    public boolean isIsYubinNo() {
        return isYubinNo;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString getAddress() {
        return address;
    }

    /**
     * 住所フラグを返します。
     *
     * @return 住所フラグ
     */
    public boolean isIsAddress() {
        return isAddress;
    }

    /**
     * サービス種類を返します。
     *
     * @return サービス種類
     */
    public RString getServiceShuRui() {
        return serviceShuRui;
    }

    /**
     * サービス種類フラグを返します。
     *
     * @return サービス種類フラグ
     */
    public boolean isIsServiceShuRui() {
        return isServiceShuRui;
    }

    /**
     * 事業者区分を返します。
     *
     * @return 事業者区分
     */
    public RString getJigyoshaKbn() {
        return jigyoshaKbn;
    }

    /**
     * 事業者区分フラグを返します。
     *
     * @return 事業者区分フラグ
     */
    public boolean isIsJigyoshaKbn() {
        return isJigyoshaKbn;
    }

    /**
     * 検索条件区分を返します。
     *
     * @return 検索条件区分
     */
    public RString getZennpouitti() {
        return zennpouitti;
    }

    /**
     * 検索条件区分フラグを返します。
     *
     * @return 検索条件区分フラグ
     */
    public boolean isIsZennpouitti() {
        return isZennpouitti;
    }

    /**
     * 郡市コードを返します。
     *
     * @return 郡市コード
     */
    public RString getGunshiCode() {
        return gunshiCode;
    }

    /**
     * 郡市コードフラグを返します。
     *
     * @return 郡市コードフラグ
     */
    public boolean isIsGunshiCode() {
        return isGunshiCode;
    }

    /**
     * システム日付を返します。
     *
     * @return システム日付
     */
    public FlexibleDate getSystemdate() {
        return systemdate;
    }

    /**
     * 県コードを返します。
     *
     * @return 県コード
     */
    public RString getKenCode() {
        return kenCode;
    }

    /**
     * 事業者種別を返します。
     *
     * @return 事業者種別
     */
    public RString getJigyoshaShubetsu() {
        return jigyoshaShubetsu;
    }

    /**
     * 管内・管外区分を返します。
     *
     * @return 管内・管外区分
     */
    public RString getKannaiKangaiKubun() {
        return kannaiKangaiKubun;
    }

    /**
     * 表示件数を返します。
     *
     * @return 表示件数
     */
    public int getLimitCount() {
        return limitCount;
    }
}
