/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu;

import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険資格取得・異動・喪失届Builderクラスです
 */
public final class ShikakushutokuIdoSoshitsuBuilderImpl implements IShikakushutokuIdoSoshitsuBuilder {
    
    private final IShikakushutokuIdoSoshitsuEditor joho;
    
    /**
     * コンストラクタです。
     * @param joho 介護保険資格取得・異動・喪失届ヘッダエディターのインターフェース
     */
    public ShikakushutokuIdoSoshitsuBuilderImpl(IShikakushutokuIdoSoshitsuEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public ShikakushutokuIdoSoshitsuReportSource build() {
        return ReportEditorJoiner.from(new ShikakushutokuIdoSoshitsuReportSource()).join(joho).buildSource();
    }
    
}
