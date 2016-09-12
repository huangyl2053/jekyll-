/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranSource;

/**
 * 帳票設計_DBC200090_負担割合証発行一覧表のEditorです。
 *
 * @reamsid_L DBC-4990-061 pengxingyi
 */
public class FutanWariaiShoHakkoIchiranEditor implements IFutanWariaiShoHakkoIchiranEditor {

    private final FutanWariaiShoHakkoIchiranEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link FutanWariaiShoHakkoIchiranEntity}
     */
    public FutanWariaiShoHakkoIchiranEditor(FutanWariaiShoHakkoIchiranEntity entity) {
        this.entity = entity;
    }

    @Override
    public FutanWariaiShoHakkoIchiranSource edit(FutanWariaiShoHakkoIchiranSource source) {
        source.printTimeStamp = entity.get作成日時();
        source.nendo = entity.get年度();
        source.joken = entity.get条件();
        source.chushutsuKikanKaishi = entity.get抽出対象期間開始();
        source.chushutsuKikanShuryo = entity.get抽出対象期間終了();
        source.hakkoKubun = entity.get発行区分();
        source.kofuYmd = entity.get交付日();
        source.cityCode = entity.get保険者番号();
        source.cityName = entity.get保険者名();
        source.sort1 = entity.getソート順１();
        source.sort2 = entity.getソート順２();
        source.sort3 = entity.getソート順３();
        source.sort4 = entity.getソート順４();
        source.sort5 = entity.getソート順５();
        source.listFutanWariaisho_1 = entity.get連番();
        source.listFutanWariaisho_2 = entity.get被保険者番号();
        source.listFutanWariaisho_3 = entity.get被保険者氏名();
        source.listFutanWariaisho_4 = entity.get送付先住所();
        source.listFutanWariaisho_5 = entity.get判定日();
        source.listFutanWariaisho_6 = entity.get開始年月日();
        source.listFutanWariaisho_7 = entity.get終了年月日();
        source.listFutanWariaisho_8 = entity.get負担割合();
        source.listFutanWariaisho_9 = entity.get判定区分();
        source.listFutanWariaisho_10 = entity.get発行済();
        return source;
    }

}
