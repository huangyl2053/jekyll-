/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.ShinsahanteinoHenkojokyoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会判定状況のProcessParameterです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsahanteinoHenkojokyoProcessParameter implements IBatchProcessParameter {

    private boolean isJigyoJyokyoHokoku;
    private boolean isJissiJyokyoTokei;
    private boolean isSinsaHanteiJyokyo;
    private boolean isSinsakaiKanrenTokei;
    private boolean isCsvShutsuryoku;
    private RString shutsuryokuFairuName;
    private RDate kijyunYMD;
    private boolean isEmptyHokensyaNo;
    private RString hokensyaNo;
    private RString hihokenshaKubun;
    private boolean isEmptyGogitaiNo;
    private int gogitaiNo;
    private List<Integer> gogitaiNoList;
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

    /**
     * コンストラクタです。
     *
     * @param isJigyoJyokyoHokoku 事業状況報告出力区分
     * @param isJissiJyokyoTokei 実施状況統計出力区分
     * @param isSinsaHanteiJyokyo 審査判定状況出力区分
     * @param isSinsakaiKanrenTokei 審査会関連統計資料作成出力区分
     * @param isCsvShutsuryoku CSV出力区分
     * @param shutsuryokuFairuName 出力ファイル名
     * @param kijyunYMD 基準年月日
     * @param isEmptyHokensyaNo 空保険者番号
     * @param hokensyaNo 保険者番号
     * @param hihokenshaKubun 被保険者区分
     * @param isEmptyGogitaiNo 空合議体番号
     * @param gogitaiNo 合議体番号
     * @param gogitaiNoList 合議体番号List
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
    public ShinsahanteinoHenkojokyoProcessParameter(
            boolean isJigyoJyokyoHokoku,
            boolean isJissiJyokyoTokei,
            boolean isSinsaHanteiJyokyo,
            boolean isSinsakaiKanrenTokei,
            boolean isCsvShutsuryoku,
            RString shutsuryokuFairuName,
            RDate kijyunYMD,
            boolean isEmptyHokensyaNo,
            RString hokensyaNo,
            RString hihokenshaKubun,
            boolean isEmptyGogitaiNo,
            int gogitaiNo,
            List<Integer> gogitaiNoList,
            boolean isTaishoTsukiKubun,
            boolean isTaishoGeppiKubun,
            RString taishoNendoYM,
            boolean isEmptyTaishoGeppiFrom,
            boolean isEmptyTaishoGeppiTo,
            RString taishoGeppiFrom,
            RString taishoGeppiTo,
            boolean isShinseiji,
            boolean isHorei) {
        this.isJigyoJyokyoHokoku = isJigyoJyokyoHokoku;
        this.isJissiJyokyoTokei = isJissiJyokyoTokei;
        this.isSinsaHanteiJyokyo = isSinsaHanteiJyokyo;
        this.isSinsakaiKanrenTokei = isSinsakaiKanrenTokei;
        this.isCsvShutsuryoku = isCsvShutsuryoku;
        this.shutsuryokuFairuName = shutsuryokuFairuName;
        this.kijyunYMD = kijyunYMD;
        this.isEmptyHokensyaNo = isEmptyHokensyaNo;
        this.hokensyaNo = hokensyaNo;
        this.hihokenshaKubun = hihokenshaKubun;
        this.isEmptyGogitaiNo = isEmptyGogitaiNo;
        this.gogitaiNo = gogitaiNo;
        this.gogitaiNoList = gogitaiNoList;
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

    /**
     * ShinsahanteinoHenkojokyoMyBatisParameterに転換します。
     *
     * @return ShinsahanteinoHenkojokyoMyBatisParameter
     */
    public ShinsahanteinoHenkojokyoMyBatisParameter toShinsahanteinoHenkojokyoMyBatisParameter() {

        return new ShinsahanteinoHenkojokyoMyBatisParameter(
                isEmptyHokensyaNo,
                hokensyaNo,
                hihokenshaKubun,
                isEmptyGogitaiNo,
                gogitaiNo,
                gogitaiNoList,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                isEmptyTaishoGeppiFrom,
                isEmptyTaishoGeppiTo,
                taishoGeppiFrom,
                taishoGeppiTo,
                isShinseiji,
                isHorei);
    }

}
