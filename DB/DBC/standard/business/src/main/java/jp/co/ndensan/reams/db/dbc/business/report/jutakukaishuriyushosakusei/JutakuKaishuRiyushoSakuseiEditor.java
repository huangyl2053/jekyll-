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
        source.hakkoYMD = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinShoryaku = item.getKoinShoryaku();
        source.bunshoNo = item.getBunshoNo();
        source.sofusakiYubinNo = item.getSofusakiYubinNo();
        source.sofusakiJusho = item.getSofusakiJusho();
        source.sofusakiShimei = item.getSofusakiShimei();
        source.jigyoshoCustomerBarCode = item.getJigyoshoCustomerBarCode();
        source.tsuchoBun = item.getTsuchoBun();
        source.uketsukeYMD = item.getUketsukeYMD();
        source.ketteiYMD = item.getKetteiYMD();
        source.ketteiKekka = item.getKetteiKekka();
        source.tesuryo = item.getTesuryo();
        source.fushikyuRiyu = item.getFushikyuRiyu();
        source.shiharaiHouhou = item.getShiharaiHouhou();
        source.shiharaiYoteiYMD = item.getShiharaiYoteiYMD();
        source.tsuchiBun = item.getTsuchiBun();
        source.choshaBushoName = item.getChoshaBushoName();
        source.tantoName = item.getTantoName();
        source.yubinBango = item.getYubinBango();
        source.shozaichi = item.getShozaichi();
        source.telNo = item.getTelNo();
        source.naisenLabel = item.getNaisenLabel();
        source.naisenNo = item.getNaisenNo();
        source.faxNo = item.getFaxNo();
        return source;
    }
}
