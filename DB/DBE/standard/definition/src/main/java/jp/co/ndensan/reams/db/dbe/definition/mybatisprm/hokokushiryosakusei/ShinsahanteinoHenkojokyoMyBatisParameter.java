/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会判定状況のMyBatisParameterです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsahanteinoHenkojokyoMyBatisParameter implements IMyBatisParameter {

    private boolean isEmptyHokensyaNo;
    private RString hokensyaNo;
    private RString hihokenshaKubun;
    private boolean isEmptyGogitaiNo;
    private int gogitaiNo;
    private boolean isTaishoTsukiKubun;
    private boolean isTaishoGeppiKubun;
    private RString taishoNendoYM;
    private boolean isEmptyTaishoGeppiFrom;
    private boolean isEmptyTaishoGeppiTo;
    private RString taishoGeppiFrom;
    private RString taishoGeppiTo;
    private LasdecCode shichosonCode;
    private boolean isShinseiji;
    private boolean isHorei;
    private RString ninteiShinseiKubun;
    private int yukoKikan;
    private boolean isJissiZumi;
    private RString jyotaiHenkoKubun;

    /**
     * コンストラクタです。
     *
     * @param isEmptyHokensyaNo 空保険者番号
     * @param hokensyaNo 保険者番号
     * @param hihokenshaKubun 被保険者区分
     * @param isEmptyGogitaiNo 空合議体番号
     * @param gogitaiNo 合議体番号
     * @param isTaishoTsukiKubun 対象月編集区分
     * @param isTaishoGeppiKubun 対象月日編集区分
     * @param taishoNendoYM 対象年月
     * @param isEmptyTaishoGeppiFrom 空対象月日開始
     * @param isEmptyTaishoGeppiTo 空対象月日終了
     * @param taishoGeppiFrom 対象月日開始
     * @param taishoGeppiTo 対象月日終了
     * @param isShinseiji 申請区分(申請時)
     * @param isHorei 申請区分(法令)
     */
    public ShinsahanteinoHenkojokyoMyBatisParameter(
            boolean isEmptyHokensyaNo,
            RString hokensyaNo,
            RString hihokenshaKubun,
            boolean isEmptyGogitaiNo,
            int gogitaiNo,
            boolean isTaishoTsukiKubun,
            boolean isTaishoGeppiKubun,
            RString taishoNendoYM,
            boolean isEmptyTaishoGeppiFrom,
            boolean isEmptyTaishoGeppiTo,
            RString taishoGeppiFrom,
            RString taishoGeppiTo,
            boolean isShinseiji,
            boolean isHorei) {
        this.isEmptyHokensyaNo = isEmptyHokensyaNo;
        this.hokensyaNo = hokensyaNo;
        this.hihokenshaKubun = hihokenshaKubun;
        this.isEmptyGogitaiNo = isEmptyGogitaiNo;
        this.gogitaiNo = gogitaiNo;
        this.isTaishoTsukiKubun = isTaishoTsukiKubun;
        this.isTaishoGeppiKubun = isTaishoGeppiKubun;
        this.taishoNendoYM = taishoNendoYM;
        this.isEmptyTaishoGeppiFrom = isEmptyTaishoGeppiFrom;
        this.isEmptyTaishoGeppiTo = isEmptyTaishoGeppiTo;
        this.taishoGeppiFrom = taishoGeppiFrom;
        this.taishoGeppiTo = taishoGeppiTo;
        this.isShinseiji = isShinseiji;
        this.isHorei = isHorei;
    }
}
