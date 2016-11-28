/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaici;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 「本算定賦課計算」の改頁クラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class HonsanteiKekkaIcihiranPageBreak extends PageBreaker<HonsanteiKekkaIcihiranReportSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public HonsanteiKekkaIcihiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<HonsanteiKekkaIcihiranReportSource> currentSource,
            ReportLineRecord<HonsanteiKekkaIcihiranReportSource> nextSource) {
        boolean flag = false;
        flag = setBreakKeyList(currentSource, nextSource, flag);
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.性別.get項目ID())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().fukaShichosonCode.equals(nextSource.getSource().fukaShichosonCode)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.通知書番号.get項目ID())
                && !currentSource.getSource().listUpper_1.equals(nextSource.getSource().listUpper_1)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.徴収方法.get項目ID())
                && !currentSource.getSource().choshuHoho.equals(nextSource.getSource().choshuHoho)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listCenter_1.equals(nextSource.getSource().listCenter_1)) {
            flag = true;
        }
        return flag;
    }

    private boolean setBreakKeyList(ReportLineRecord<HonsanteiKekkaIcihiranReportSource> currentSource,
            ReportLineRecord<HonsanteiKekkaIcihiranReportSource> nextSource, boolean flag) {
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_8.equals(nextSource.getSource().listUpper_8)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().listUpper_7.equals(nextSource.getSource().listUpper_7)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.世帯コード.get項目ID())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.識別コード.get項目ID())
                && !currentSource.getSource().listUpper_6.equals(nextSource.getSource().listUpper_6)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().kanaMeisho.equals(nextSource.getSource().kanaMeisho)) {
            flag = true;
        }
        if (this.breakKeysList.contains(HonsanteiKekkaIcihiranOutPutOrder.生年月日.get項目ID())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
            flag = true;
        }
        return flag;
    }
}
