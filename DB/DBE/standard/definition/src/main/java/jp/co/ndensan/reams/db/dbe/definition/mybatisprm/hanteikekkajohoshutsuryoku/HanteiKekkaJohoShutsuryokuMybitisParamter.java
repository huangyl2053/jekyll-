/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshutsuryoku;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 判定結果情報出力(保険者)を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0190-030 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class HanteiKekkaJohoShutsuryokuMybitisParamter implements IMyBatisParameter {

    private final List<RString> shinseishoKanriNo;
    private final RString nijiHanteiYMDFrom;
    private final RString nijiHanteiYMDTo;
    private final boolean 二次判定日FromFlag;
    private final boolean 二次判定日ToFlag;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 二次判定日From 二次判定日From
     * @param 二次判定日To 二次判定日To
     * @param 二次判定日FromFlag 二次判定日FromFlag
     * @param 二次判定日ToFlag 二次判定日ToFlag
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private HanteiKekkaJohoShutsuryokuMybitisParamter(
            List<RString> 申請書管理番号,
            RString 二次判定日From,
            RString 二次判定日To,
            boolean 二次判定日FromFlag,
            boolean 二次判定日ToFlag) {
        this.shinseishoKanriNo = 申請書管理番号;
        this.nijiHanteiYMDFrom = 二次判定日From;
        this.nijiHanteiYMDTo = 二次判定日To;
        this.二次判定日FromFlag = 二次判定日FromFlag;
        this.二次判定日ToFlag = 二次判定日ToFlag;
    }

    /**
     * @param 申請書管理番号 申請書管理番号
     * @param 二次判定日From 二次判定日From
     * @param 二次判定日To 二次判定日To
     * @return HanteiKekkaJohoShutsuryokuMybitisParamter
     */
    public static HanteiKekkaJohoShutsuryokuMybitisParamter createParam(
            List<RString> 申請書管理番号,
            RString 二次判定日From,
            RString 二次判定日To) {
        boolean 二次判定日FromFlag = false;
        boolean 二次判定日ToFlag = false;
        if (!RString.isNullOrEmpty(二次判定日From)) {
            二次判定日FromFlag = true;
        }
        if (!RString.isNullOrEmpty(二次判定日To)) {
            二次判定日ToFlag = true;
        }
        return new HanteiKekkaJohoShutsuryokuMybitisParamter(申請書管理番号,
                二次判定日From,
                二次判定日To,
                二次判定日FromFlag,
                二次判定日ToFlag);
    }
}
