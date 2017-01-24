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

    private final List<RString> shinseishoKanriNoList;
    private final RString fayirukuben;
    private final RString hokensha;
    private final RString hokenshaName;
    private final RString chushutsuHoho;
    private final RString chushutsuFromDate;
    private final RString chushutsuToDate;
    private final RString hihokenshaNo;
    private final RString dataShutsuryokuUmu;
    private final boolean 二次判定日FromFlag;
    private final boolean 二次判定日ToFlag;
    private static final RString 二次判定日 = new RString("二次判定日");

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param ファイル区分 ファイル区分
     * @param 保険者 保険者
     * @param 保険者名称 保険者名称
     * @param 抽出方法
     * @param 抽出期間From
     * @param 抽出期間To
     * @param 被保険者番号
     * @param データ出力有無
     * @param 二次判定日FromFlag
     * @param 二次判定日ToFlag
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private HanteiKekkaJohoShutsuryokuMybitisParamter(
            List<RString> 申請書管理番号リスト,
            RString ファイル区分,
            RString 保険者,
            RString 保険者名称,
            RString 抽出方法,
            RString 抽出期間From,
            RString 抽出期間To,
            RString 被保険者番号,
            RString データ出力有無,
            boolean 二次判定日FromFlag,
            boolean 二次判定日ToFlag) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.fayirukuben = ファイル区分;
        this.hokensha = 保険者;
        this.hokenshaName = 保険者名称;
        this.chushutsuHoho = 抽出方法;
        this.chushutsuFromDate = 抽出期間From;
        this.chushutsuToDate = 抽出期間To;
        this.hihokenshaNo = 被保険者番号;
        this.dataShutsuryokuUmu = データ出力有無;
        this.二次判定日FromFlag = 二次判定日FromFlag;
        this.二次判定日ToFlag = 二次判定日ToFlag;
    }

    /**
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param ファイル区分 ファイル区分
     * @param 保険者 保険者
     * @param 保険者名称 保険者名称
     * @param 抽出方法
     * @param 抽出期間From
     * @param 抽出期間To
     * @param 被保険者番号
     * @param データ出力有無
     * @return HanteiKekkaJohoShutsuryokuMybitisParamter
     */
    public static HanteiKekkaJohoShutsuryokuMybitisParamter createParam(
            List<RString> 申請書管理番号リスト,
            RString ファイル区分,
            RString 保険者,
            RString 保険者名称,
            RString 抽出方法,
            RString 抽出期間From,
            RString 抽出期間To,
            RString 被保険者番号,
            RString データ出力有無) {
        boolean 二次判定日FromFlag = false;
        boolean 二次判定日ToFlag = false;
        if (二次判定日.equals(抽出方法)) {
            if (!RString.isNullOrEmpty(抽出期間From)) {
                二次判定日FromFlag = true;
            }
            if (!RString.isNullOrEmpty(抽出期間To)) {
                二次判定日ToFlag = true;
            }
        }
        return new HanteiKekkaJohoShutsuryokuMybitisParamter(申請書管理番号リスト,
                ファイル区分,
                保険者,
                保険者名称,
                抽出方法,
                抽出期間From,
                抽出期間To,
                被保険者番号,
                データ出力有無,
                二次判定日FromFlag,
                二次判定日ToFlag);
    }
}
