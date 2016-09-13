/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbz100001;

import jp.co.ndensan.reams.db.dbb.entity.report.atenaseal.DBZ100001AtenaSealSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBZ100001_宛名シールBuilder
 *
 * @reamsid_L DBB-5660-040 jiangxiaolong
 */
public class AtenaSealBuilder
        implements IAtenaSealBuilder {

    private final IAtenaSealEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public AtenaSealBuilder(
            IAtenaSealEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public DBZ100001AtenaSealSource build() {
        return ReportEditorJoiner.from(new DBZ100001AtenaSealSource())
                .join(bodyEditor).buildSource();
    }

}
