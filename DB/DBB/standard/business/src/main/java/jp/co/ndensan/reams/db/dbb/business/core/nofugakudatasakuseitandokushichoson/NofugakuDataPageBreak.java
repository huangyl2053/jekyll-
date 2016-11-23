/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nofugakudatasakuseitandokushichoson;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirandaihyo.NofugakuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 納付額一覧表 PageBreaker
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
public class NofugakuDataPageBreak extends PageBreaker<NofugakuIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys List<RString>
     */
    public NofugakuDataPageBreak(List<RString> breakKeys) {
        this.breakKeysList = breakKeys;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<NofugakuIchiranSource> currentSource,
            ReportLineRecord<NofugakuIchiranSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.行政区コード.get項目ID())
                && !currentSource.getSource().list5_1.equals(nextSource.getSource().list5_1)) {
            flg = true;
        } else if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.世帯コード.get項目ID())
                && !currentSource.getSource().list3_1.equals(nextSource.getSource().list3_1)) {
            flg = true;
        } else if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.識別コード.get項目ID())
                && !currentSource.getSource().list2_1.equals(nextSource.getSource().list2_1)) {
            flg = true;
        } else if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.生年月日.get項目ID())
                && !currentSource.getSource().list6_3.equals(nextSource.getSource().list6_3)) {
            flg = true;
        } else if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.性別.get項目ID())
                && !currentSource.getSource().list6_2.equals(nextSource.getSource().list6_2)) {
            flg = true;
        } else {
            flg = isBreakTwo(currentSource, nextSource);
        }
        return flg;
    }

    private boolean isBreakTwo(ReportLineRecord<NofugakuIchiranSource> currentSource,
            ReportLineRecord<NofugakuIchiranSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.市町村コード.get項目ID())
                && !currentSource.getSource().cityCd.equals(nextSource.getSource().cityCd)) {
            flg = true;
        } else if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().list1_1.equals(nextSource.getSource().list1_1)) {
            flg = true;
        } else if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.徴収方法.get項目ID())
                && !currentSource.getSource().list6_4.equals(nextSource.getSource().list6_4)) {
            flg = true;
        } else if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flg = true;
        } else if (this.breakKeysList.contains(NofugakuDataOutput.BreakerFieldsEnum.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().kanaMeisho.equals(nextSource.getSource().kanaMeisho)) {
            flg = true;
        }
        return flg;
    }
}
