/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinchokudataoutput;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * バッチ設計_DBE491001_日次進捗データ作成ですためのMybitis用パラメータクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class ShinchokuDataOutputMybitisParamter implements IMyBatisParameter {

    private final List<RString> shinseishoKanriNoList;
    private final RString fayirukuben;
    private final RString イメージ区分;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList List<RString>
     * @param fayirukuben RString
     */
    private ShinchokuDataOutputMybitisParamter(
            List<RString> shinseishoKanriNoList,
            RString fayirukuben,
            RString イメージ区分) {
        this.shinseishoKanriNoList = shinseishoKanriNoList;
        this.fayirukuben = fayirukuben;
        this.イメージ区分 = イメージ区分;
    }

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList List<RString>
     * @param fayirukuben RString
     * @param イメージ区分 RString
     * @return ShinchokuDataOutputMybitisParamter
     */
    public static ShinchokuDataOutputMybitisParamter createParam(
            List<RString> shinseishoKanriNoList,
            RString fayirukuben,
            RString イメージ区分) {
        return new ShinchokuDataOutputMybitisParamter(shinseishoKanriNoList, fayirukuben, イメージ区分);
    }
}
