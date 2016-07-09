/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengkettsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.report.homkaigriysfutggengkettsuchisho.HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource;

/**
 * 訪問介護等利用者負担額減額決定通知書ボディEditorです。
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public class HomKaigRiysFutgGengKettsuchishoBodyEditor implements IHomKaigRiysFutgGengKettsuchishoEditor {

    private final HomKaigRiysFutgGengKettsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 訪問介護等利用者負担額減額決定通知書
     */
    public HomKaigRiysFutgGengKettsuchishoBodyEditor(HomKaigRiysFutgGengKettsuchishoItem item) {
        this.item = item;
    }

    /**
     * 訪問介護等利用者負担額減額決定通知書ボディEditorです。
     *
     * @param source 訪問介護等利用者負担額減額決定通知書Source
     * @return 訪問介護等利用者負担額減額決定通知書Source
     */
    @Override
    public HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource edit(HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource source) {
        return bodyEdit(source);
    }

    private HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource bodyEdit(HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource source) {
        return source;

    }
}
