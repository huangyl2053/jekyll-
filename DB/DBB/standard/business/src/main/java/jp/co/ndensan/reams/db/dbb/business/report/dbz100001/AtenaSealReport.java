/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbz100001;

import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealParameterEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.atenaseal.DBZ100001AtenaSealSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBZ100001_宛名シールReport
 *
 * @reamsid_L DBB-5660-040 jiangxiaolong
 */
public class AtenaSealReport
        extends Report<DBZ100001AtenaSealSource> {

    private final DBZ100001AtenaSealParameterEntity paramter;

    /**
     * インスタンスを生成します
     *
     * @param paramter DBZ100001AtenaSealParameterEntity
     */
    public AtenaSealReport(
            DBZ100001AtenaSealParameterEntity paramter) {
        this.paramter = paramter;
    }

    @Override
    public void writeBy(ReportSourceWriter<DBZ100001AtenaSealSource> writer) {
        writeLine(writer, paramter);
    }

    private void writeLine(ReportSourceWriter<DBZ100001AtenaSealSource> writer,
            DBZ100001AtenaSealParameterEntity paramter) {
        IAtenaSealEditor bodyEditor
                = new AtenaSealEditor(paramter);
        IAtenaSealBuilder builder
                = new AtenaSealBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
