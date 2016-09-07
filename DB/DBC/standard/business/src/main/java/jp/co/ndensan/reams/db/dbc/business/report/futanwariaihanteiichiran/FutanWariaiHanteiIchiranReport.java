/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.FutanwariaiHanteiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaihanteiichiran.FutanWariaiHanteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担割合判定一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBC-4980-040 yuanzhenxia
 */
public class FutanWariaiHanteiIchiranReport extends Report<FutanWariaiHanteiIchiranSource> {

    private final FutanWariaiHanteiIchiranProcessParameter processParameter;
    private final FutanwariaiHanteiIchiranEntity entity;

    /**
     * コンストラクタです。
     *
     * @param processParameter FutanWariaiHanteiIchiranProcessParameter
     * @param entity FutanwariaiHanteiIchiranEntity
     */
    public FutanWariaiHanteiIchiranReport(FutanWariaiHanteiIchiranProcessParameter processParameter, FutanwariaiHanteiIchiranEntity entity) {
        this.entity = entity;
        this.processParameter = processParameter;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanWariaiHanteiIchiranSource> writer) {
        IFutanWariaiHanteiIchiranEditor editor = new FutanWariaiHanteiIchiranEditor(processParameter, entity);
        IFutanWariaiHanteiIchiranBuilder builder = new FutanWariaiHanteiIchiranBuilder(editor);
        writer.writeLine(builder);
    }

}
