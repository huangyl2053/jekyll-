/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shinchokudataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinchokudataoutput.ShinchokuDataOutputMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBE491001_日次進捗データ作成ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinchokuDataOutputProcessParamter implements IBatchProcessParameter {

    private final List<RString> shinseishoKanriNoList;
    private final RString fayirukuben;
    private final RString chushutsuFromDate;
    private final RString chushutsuToDate;
    private final RString hokensha;
    private final RString hokenshaName;
    private final RString chushutsuHoho;
    private final RString hihokenshaNo;
    private final RString dataShutsuryokuUmu;
    private RString 概況調査テキス;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト List<RString>
     * @param ファイル区分 RString
     * @param 抽出期間From RString
     * @param 抽出期間To RString
     * @param 保険者 RString
     * @param 保険者名称 RString;
     * @param 抽出方法 RString
     * @param 被保険者番号
     * @param データ出力有無
     */
    public ShinchokuDataOutputProcessParamter(
            List<RString> 申請書管理番号リスト,
            RString ファイル区分,
            RString 抽出期間From,
            RString 抽出期間To,
            RString 保険者,
            RString 保険者名称,
            RString 抽出方法,
            RString 被保険者番号,
            RString データ出力有無) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.fayirukuben = ファイル区分;
        this.chushutsuFromDate = 抽出期間From;
        this.chushutsuToDate = 抽出期間To;
        this.hokensha = 保険者;
        this.hokenshaName = 保険者名称;
        this.chushutsuHoho = 抽出方法;
        this.hihokenshaNo = 被保険者番号;
        this.dataShutsuryokuUmu = データ出力有無;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return KaigoNinteiShinsakaiScheduleMybitisParamter
     */
    public ShinchokuDataOutputMybitisParamter toShinchokuDataOutputMybitisParamter() {
        return ShinchokuDataOutputMybitisParamter.createParam(shinseishoKanriNoList,
                fayirukuben, 概況調査テキス);
    }
}
