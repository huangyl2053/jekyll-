/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.SinsakaiHanteiJyokyoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会判定状況のProcessParameterです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SinsakaiHanteiJyokyoProcessParameter implements IBatchProcessParameter {

    private boolean isEmptyHokensyaNo;
    private RString hokensyaNo;
    private RString hihokenshaKubun;
    private boolean isEmptyTaishoNendo;
    private boolean isEmptyGogitaiNo;
    private int gogitaiNo;
    private boolean taishoTsukiKubun;
    private boolean taishoGeppiKubun;
    private RString taishoNendoKaishiYM;
    private RString taishoNendoShuryoYM;
    private RString taishoNendoYM;
    private boolean isEmptyTaishoGeppiFrom;
    private boolean isEmptyTaishoGeppiTo;
    private RString taishoGeppiFrom;
    private RString taishoGeppiTo;
    private LasdecCode shichosonCode;

    /**
     * コンストラクタです。
     *
     * @param isEmptyHokensyaNo 空保険者番号
     * @param hokensyaNo 保険者番号
     * @param hihokenshaKubun 被保険者区分
     * @param isEmptyTaishoNendo 空対象年度
     * @param isEmptyGogitaiNo 空合議体番号
     * @param gogitaiNo 合議体番号
     * @param taishoTsukiKubun 対象月編集区分
     * @param taishoGeppiKubun 対象月日編集区分
     * @param taishoNendoKaishiYM 対象年度開始日
     * @param taishoNendoShuryoYM 対象年度終了日
     * @param taishoNendoYM 対象年月
     * @param isEmptyTaishoGeppiFrom 空対象月日開始
     * @param isEmptyTaishoGeppiTo 空対象月日終了
     * @param taishoGeppiFrom 対象月日開始
     * @param taishoGeppiTo 対象月日終了
     * @param shichosonCode 市町村コード
     */
    public SinsakaiHanteiJyokyoProcessParameter(
            boolean isEmptyHokensyaNo,
            RString hokensyaNo,
            RString hihokenshaKubun,
            boolean isEmptyTaishoNendo,
            boolean isEmptyGogitaiNo,
            int gogitaiNo,
            boolean taishoTsukiKubun,
            boolean taishoGeppiKubun,
            RString taishoNendoKaishiYM,
            RString taishoNendoShuryoYM,
            RString taishoNendoYM,
            boolean isEmptyTaishoGeppiFrom,
            boolean isEmptyTaishoGeppiTo,
            RString taishoGeppiFrom,
            RString taishoGeppiTo,
            LasdecCode shichosonCode) {
        this.isEmptyHokensyaNo = isEmptyHokensyaNo;
        this.hokensyaNo = hokensyaNo;
        this.hihokenshaKubun = hihokenshaKubun;
        this.isEmptyTaishoNendo = isEmptyTaishoNendo;
        this.isEmptyGogitaiNo = isEmptyGogitaiNo;
        this.gogitaiNo = gogitaiNo;
        this.taishoTsukiKubun = taishoTsukiKubun;
        this.taishoGeppiKubun = taishoGeppiKubun;
        this.taishoNendoKaishiYM = taishoNendoKaishiYM;
        this.taishoNendoShuryoYM = taishoNendoShuryoYM;
        this.taishoNendoYM = taishoNendoYM;
        this.isEmptyTaishoGeppiFrom = isEmptyTaishoGeppiFrom;
        this.isEmptyTaishoGeppiTo = isEmptyTaishoGeppiTo;
        this.taishoGeppiFrom = taishoGeppiFrom;
        this.taishoGeppiTo = taishoGeppiTo;
        this.shichosonCode = shichosonCode;
    }

    /**
     * SinsakaiHanteiJyokyoMyBatisParameterに転換します。
     *
     * @return SinsakaiHanteiJyokyoMyBatisParameter
     */
    public SinsakaiHanteiJyokyoMyBatisParameter toSinsakaiHanteiJyokyoMyBatisParameter() {

        return new SinsakaiHanteiJyokyoMyBatisParameter(
                isEmptyHokensyaNo,
                hokensyaNo,
                hihokenshaKubun,
                isEmptyTaishoNendo,
                isEmptyGogitaiNo,
                gogitaiNo,
                taishoTsukiKubun,
                taishoGeppiKubun,
                taishoNendoKaishiYM,
                taishoNendoShuryoYM,
                taishoNendoYM,
                isEmptyTaishoGeppiFrom,
                isEmptyTaishoGeppiTo,
                taishoGeppiFrom,
                taishoGeppiTo,
                shichosonCode);
    }

}
