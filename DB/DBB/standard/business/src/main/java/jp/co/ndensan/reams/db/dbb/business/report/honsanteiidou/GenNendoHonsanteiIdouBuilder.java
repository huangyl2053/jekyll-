/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 本算定異動（現年度）結果一覧表帳票Builderクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouBuilder implements IGenNendoHonsanteiIdouBuilder {

    private final IGenNendoHonsanteiIdouEditor header;
    private final IGenNendoHonsanteiIdouEditor body;

    /**
     * インスタンスを生成します
     *
     * @param header IGenNendoHonsanteiIdouEditor
     * @param body IGenNendoHonsanteiIdouEditor
     */
    public GenNendoHonsanteiIdouBuilder(IGenNendoHonsanteiIdouEditor header, IGenNendoHonsanteiIdouEditor body) {
        this.header = header;
        this.body = body;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GenNendoHonsanteiIdouSource}
     */
    @Override
    public GenNendoHonsanteiIdouSource build() {
        return ReportEditorJoiner.from(new GenNendoHonsanteiIdouSource()).join(header).join(body).buildSource();
    }
}
