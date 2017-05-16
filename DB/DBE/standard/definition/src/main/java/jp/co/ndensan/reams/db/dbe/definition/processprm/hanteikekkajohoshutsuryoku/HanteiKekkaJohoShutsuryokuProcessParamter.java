/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshutsuryoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 判定結果情報出力(保険者)を特定するためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-0190-030 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class HanteiKekkaJohoShutsuryokuProcessParamter implements IBatchProcessParameter {

    private final List<RString> shinseishoKanriNoList;
    private final List<RString> hihokenshaNoList;
    private final RString fayirukuben;
    private final RString hokensha;
    private final RString hokenshaName;
    private final RString chushutsuHoho;
    private final RString chushutsuFromDate;
    private final RString chushutsuToDate;
    private final RString hihokenshaNo;
    private final RString dataShutsuryokuUmu;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param 被保険者番号リスト 被保険者番号リスト
     * @param ファイル区分 ファイル区分
     * @param 保険者 保険者
     * @param 保険者名称 保険者名称
     * @param 抽出方法
     * @param 抽出期間From
     * @param 抽出期間To
     * @param 被保険者番号
     * @param データ出力有無
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public HanteiKekkaJohoShutsuryokuProcessParamter(
            List<RString> 申請書管理番号リスト,
            List<RString> 被保険者番号リスト,
            RString ファイル区分,
            RString 保険者,
            RString 保険者名称,
            RString 抽出方法,
            RString 抽出期間From,
            RString 抽出期間To,
            RString 被保険者番号,
            RString データ出力有無) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.hihokenshaNoList = 被保険者番号リスト;
        this.fayirukuben = ファイル区分;
        this.hokensha = 保険者;
        this.hokenshaName = 保険者名称;
        this.chushutsuHoho = 抽出方法;
        this.chushutsuFromDate = 抽出期間From;
        this.chushutsuToDate = 抽出期間To;
        this.hihokenshaNo = 被保険者番号;
        this.dataShutsuryokuUmu = データ出力有無;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HanteiKekkaJohoShutsuryokuMybitisParamter toHanteiKekkaJohoShutsuryokuMybitisParamter() {
        return HanteiKekkaJohoShutsuryokuMybitisParamter.createParam(shinseishoKanriNoList, fayirukuben,
                hokensha, hokenshaName, chushutsuHoho, chushutsuFromDate, chushutsuToDate, hihokenshaNo, dataShutsuryokuUmu);
    }

}
