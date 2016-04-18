/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）HeaderEditor
 *
 * @reamsid_L DBB-0780-120 yangchenbing
 */
public class HeaderEditor implements INonyuTsuchIchiranEditor {

    private final NonyuTsuchIchiranItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SampleItem}
     */
    protected HeaderEditor(NonyuTsuchIchiranItem item) {
        this.item = item;
    }

    @Override
    public NonyuTsuchIchiranSource edit(NonyuTsuchIchiranSource source) {
        editprintTimeStamp(source);
        editnendo(source);
        editnendoBunKakko(source);
        editnendoBun1(source);
        editnendoBun2(source);
        return source;
    }

    private void editprintTimeStamp(NonyuTsuchIchiranSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
    }

    private void editnendo(NonyuTsuchIchiranSource source) {
        source.nendo = item.getNendo();
    }

    private void editnendoBunKakko(NonyuTsuchIchiranSource source) {
        source.nendoBunKakko = item.getNendoBunKakko();
    }

    private void editnendoBun1(NonyuTsuchIchiranSource source) {
        source.nendoBun1 = item.getNendoBun1();
    }

    private void editnendoBun2(NonyuTsuchIchiranSource source) {
        source.nendoBun2 = item.getNendoBun2();
    }
}
