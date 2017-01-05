/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE491001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinchokudataoutput.ShinchokuDataOutputProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBE491001_日次進捗データ作成ですためのBatch用パラメータクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBE491001_NichijiShinchokuParameter extends BatchParameterBase {

    private static final String SHINSEISHOLANRINOLIST = "shinseishoKanriNoList";
    private static final String FAYIRUKUBEN = "fayirukuben";
    private static final String CHUSHUTSUFROMDATE = "chushutsuFromDate";
    private static final String CHUSHUTSUTODATE = "chushutsuToDate";
    private static final String HOKENSHA = "hokensha";
    @BatchParameter(key = SHINSEISHOLANRINOLIST, name = "申請書管理番号リスト")
    private List<RString> shinseishoKanriNoList;
    @BatchParameter(key = FAYIRUKUBEN, name = "ファイル区分")
    private RString fayirukuben;
    @BatchParameter(key = CHUSHUTSUFROMDATE, name = "抽出期間From")
    private RString chushutsuFromDate;
    @BatchParameter(key = CHUSHUTSUTODATE, name = "抽出期間To")
    private RString chushutsuToDate;
    @BatchParameter(key = HOKENSHA, name = "保険者")
    private RString hokensha;

    /**
     * コンストラクタです。
     */
    public DBE491001_NichijiShinchokuParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト List<RString>
     * @param ファイル区分 RString
     * @param 抽出期間From RString
     * @param 抽出期間To RString
     * @param 保険者 RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public DBE491001_NichijiShinchokuParameter(
            List<RString> 申請書管理番号リスト,
            RString ファイル区分,
            RString 抽出期間From,
            RString 抽出期間To,
            RString 保険者) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.fayirukuben = ファイル区分;
        this.chushutsuFromDate = 抽出期間From;
        this.chushutsuToDate = 抽出期間To;
        this.hokensha = 保険者;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return KaigoNinteiShinsakaiScheduleProcessParamter
     */
    public ShinchokuDataOutputProcessParamter toShinchokuDataOutputProcessParamter() {
        return new ShinchokuDataOutputProcessParamter(shinseishoKanriNoList, fayirukuben, chushutsuFromDate, chushutsuToDate, hokensha);
    }
}
