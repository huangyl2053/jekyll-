/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jyushochitokureitekiyohenko;

import jp.co.ndensan.reams.db.dba.entity.report.jyushochitokureitekiyohenko.JyushochiTokureiTekiyoHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険住所地特例適用・変更・終了届Builderクラスです
 */
public final class JyushochiTokureiTekiyoHenkoBuilderImpl implements IJyushochiTokureiTekiyoHenkoBuilder {
    
    private final IJyushochiTokureiTekiyoHenkoEditor joho;
    
    /**
     * コンストラクタです。
     * @param joho 介護保険資格取得・異動・喪失届ヘッダエディターのインターフェース
     */
    public JyushochiTokureiTekiyoHenkoBuilderImpl(IJyushochiTokureiTekiyoHenkoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public JyushochiTokureiTekiyoHenkoReportSource build() {
        return ReportEditorJoiner.from(new JyushochiTokureiTekiyoHenkoReportSource()).join(joho).buildSource();
    }
    
}
