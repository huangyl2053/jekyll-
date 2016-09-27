/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakukaishuriyushosakusei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiReportSource;

/**
 * 帳票設計_DBC200004_利用状況一覧表のEditorです。
 *
 * @reamsid_L DBC-2850-040 lizhuoxuan
 *
 */
public class JutakuKaishuRiyushoSakuseiEditor implements IJutakuKaishuRiyushoSakuseiEditor {

    private final JutakuKaishuRiyushoSakuseiEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JutakuKaishuRiyushoSakuseiEntity}
     */
    protected JutakuKaishuRiyushoSakuseiEditor(JutakuKaishuRiyushoSakuseiEntity item) {
        this.item = item;
    }

    @Override
    public JutakuKaishuRiyushoSakuseiReportSource edit(JutakuKaishuRiyushoSakuseiReportSource source) {
        return editSource(source);
    }

    private JutakuKaishuRiyushoSakuseiReportSource editSource(JutakuKaishuRiyushoSakuseiReportSource source) {
        source.bunshoNo = item.get文書番号();
        source.uketsukeYMD = item.get受付年月日();
        source.ketteiYMD = item.get決定年月日();
        source.ketteiKekka = item.get支給_不支給();
        source.tesuryo = item.get支給金額();
        source.fushikyuRiyu = item.get不支給の理由();
        source.shiharaiHouhou = item.get支払方法();
        source.shiharaiYoteiYMD = item.get支払予定日();
        return source;
    }
}
