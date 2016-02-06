/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.itakuservicekeikalusakuseiiraitodokedesho;

import jp.co.ndensan.reams.db.dba.entity.report.itakuservicekeikalusakuseiiraitodokedesho.ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource;

/**
 *
 * 居宅（介護予防）サービス計画作成依頼（変更）届出書Editorです。
 */
public class ItakuServiceKeikaluSakuseiIraiTodokedeshoEditor implements IItakuServiceKeikaluSakuseiIraiTodokedeshoEditor {

    private final ItakuServiceKeikaluSakuseiIraiTodokedeshoItem joho;

    /**
     * コンストラクタです。
     *
     * @param joho 居宅（介護予防）サービス計画作成依頼（変更）届出書Itemです
     */
    public ItakuServiceKeikaluSakuseiIraiTodokedeshoEditor(ItakuServiceKeikaluSakuseiIraiTodokedeshoItem joho) {
        this.joho = joho;
    }

    /**
     * 居宅（介護予防）サービス計画作成依頼（変更）届出書editです。
     *
     * @param source 居宅（介護予防）サービス計画作成依頼（変更）届出書Source
     * @return 居宅（介護予防）サービス計画作成依頼（変更）届出書
     */
    @Override
    public ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource edit(ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource source) {
        return editBody(source);
    }

    private ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource editBody(ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource source) {
        source.hihokenshaNo = joho.getHihokenshaNo();
        source.hihokenshaNameKana = joho.getHihokenshaNameKana();
        source.hihokenshaName = joho.getHihokenshaName();
        source.seibetsu = joho.getSeibetsu();
        source.birthYＭＤ = joho.getBirthYＭＤ();
        source.shiseiBun = joho.getShiseiBun();
        source.chuiBun = joho.getChuiBun();
        source.remban = joho.getRemban();
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        return source;
    }

}
