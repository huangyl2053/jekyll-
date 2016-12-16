/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.ShinsakaiShukeiGenzainojokyoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会集計表（現在の状況別）のProcessParameterです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiShukeiGenzainojokyoProcessParameter implements IBatchProcessParameter {

    private boolean isJigyoJyokyoHokoku;
    private boolean isJissiJyokyoTokei;
    private boolean isSinsaHanteiJyokyo;
    private boolean isSinsaHanteiNoHenkouJokyo;
    private boolean isKaigoNinteiSinsakaiShukeihyoHanteibetsu;
    private boolean isKaigoNinteiSinsakaiShukeihyoSinseikubunbetsu;
    private boolean isKaigoNinteiSinsakaiShukeihyoGenzainojokyobetsu;
    private boolean isCsvShutsuryoku;
    private RString shutsuryokuFairuName;
    private boolean isEmptyHokensyaNo;
    private RString hokensyaNo;
    private RString hihokenshaKubun;
    private boolean isEmptyGogitaiNo;
    private int gogitaiNo;
    private List<Integer> gogitaiNoList;
    private boolean isEmptyKijyunYMD;
    private RDate kijyunYMD;
    private boolean isTaishoTsukiKubun;
    private boolean isTaishoGeppiKubun;
    private RString taishoNendoYM;
    private boolean isEmptyTaishoGeppiFrom;
    private boolean isEmptyTaishoGeppiTo;
    private RString taishoGeppiFrom;
    private RString taishoGeppiTo;
    private boolean isShinseiji;
    private boolean isHorei;

    /**
     * コンストラクタです。
     *
     * @param isJigyoJyokyoHokoku 事業状況報告出力区分
     * @param isJissiJyokyoTokei 実施状況統計出力区分
     * @param isSinsaHanteiJyokyo 審査判定状況出力区分
     * @param isSinsaHanteiNoHenkouJokyo 審査判定の変更状況出力区分
     * @param isKaigoNinteiSinsakaiShukeihyoHanteibetsu 介護認定審査会集計表（判定別）出力区分
     * @param isKaigoNinteiSinsakaiShukeihyoSinseikubunbetsu 介護認定審査会集計表（申請区分別）出力区分
     * @param isKaigoNinteiSinsakaiShukeihyoGenzainojokyobetsu 介護認定審査会集計表（現在の状況別）出力区分
     * @param isCsvShutsuryoku CSV出力区分
     * @param shutsuryokuFairuName 出力ファイル名
     * @param isEmptyHokensyaNo 空保険者番号
     * @param hokensyaNo 保険者番号
     * @param hihokenshaKubun 被保険者区分
     * @param isEmptyGogitaiNo 空合議体番号
     * @param gogitaiNo 合議体番号
     * @param gogitaiNoList 合議体番号List
     * @param isEmptyKijyunYMD 空基準日
     * @param kijyunYMD 基準日
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
    public ShinsakaiShukeiGenzainojokyoProcessParameter(
            boolean isJigyoJyokyoHokoku,
            boolean isJissiJyokyoTokei,
            boolean isSinsaHanteiJyokyo,
            boolean isSinsaHanteiNoHenkouJokyo,
            boolean isKaigoNinteiSinsakaiShukeihyoHanteibetsu,
            boolean isKaigoNinteiSinsakaiShukeihyoSinseikubunbetsu,
            boolean isKaigoNinteiSinsakaiShukeihyoGenzainojokyobetsu,
            boolean isCsvShutsuryoku,
            RString shutsuryokuFairuName,
            boolean isEmptyHokensyaNo,
            RString hokensyaNo,
            RString hihokenshaKubun,
            boolean isEmptyGogitaiNo,
            int gogitaiNo,
            List<Integer> gogitaiNoList,
            boolean isEmptyKijyunYMD,
            RDate kijyunYMD,
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
        this.isSinsaHanteiNoHenkouJokyo = isSinsaHanteiNoHenkouJokyo;
        this.isKaigoNinteiSinsakaiShukeihyoHanteibetsu = isKaigoNinteiSinsakaiShukeihyoHanteibetsu;
        this.isKaigoNinteiSinsakaiShukeihyoSinseikubunbetsu = isKaigoNinteiSinsakaiShukeihyoSinseikubunbetsu;
        this.isKaigoNinteiSinsakaiShukeihyoGenzainojokyobetsu = isKaigoNinteiSinsakaiShukeihyoGenzainojokyobetsu;
        this.isCsvShutsuryoku = isCsvShutsuryoku;
        this.shutsuryokuFairuName = shutsuryokuFairuName;
        this.isEmptyHokensyaNo = isEmptyHokensyaNo;
        this.hokensyaNo = hokensyaNo;
        this.hihokenshaKubun = hihokenshaKubun;
        this.isEmptyGogitaiNo = isEmptyGogitaiNo;
        this.gogitaiNo = gogitaiNo;
        this.gogitaiNoList = gogitaiNoList;
        this.isEmptyKijyunYMD = isEmptyKijyunYMD;
        this.kijyunYMD = kijyunYMD;
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
     * ShinsakaiShukeiGenzainojokyoMyBatisParameterに転換します。
     *
     * @return ShinsakaiShukeiGenzainojokyoMyBatisParameter
     */
    public ShinsakaiShukeiGenzainojokyoMyBatisParameter toShinsakaiShukeiGenzainojokyoMyBatisParameter() {

        return new ShinsakaiShukeiGenzainojokyoMyBatisParameter(
                isEmptyHokensyaNo,
                hokensyaNo,
                hihokenshaKubun,
                isEmptyGogitaiNo,
                gogitaiNo,
                gogitaiNoList,
                isEmptyKijyunYMD,
                isEmptyKijyunYMD ? RString.EMPTY : kijyunYMD.toDateString(),
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
