/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakugassankaigo;

import jp.co.ndensan.reams.db.dba.entity.report.kogakugassankaigo.KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のEditorです。
 *
 * @reamsid_L DBA-0540-712 lishengli
 */
public class KogakuGassanKaigoServicehiShikyuKofuShinseishoItemEditor
        implements IKogakuGassanKaigoServicehiShikyuKofuShinseishoEditor {

    private final KogakuGassanKaigoServicehiShikyuKofuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KogakuGassanKaigoServicehiShikyuKofuShinseishoItem}
     */
    protected KogakuGassanKaigoServicehiShikyuKofuShinseishoItemEditor(KogakuGassanKaigoServicehiShikyuKofuShinseishoItem item) {
        this.item = item;
    }

    /**
     * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のedit
     *
     * @param source 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のReportSource
     * @return 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のEditor
     */
    @Override
    public KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource edit(
            KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource source) {
        return editSource(source);
    }

    private KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource editSource(
            KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource source) {
        source.birthYMD = item.getBirthYMD();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.kaigoHokenshaName = item.getKaigoHokenshaName();
        source.hokenshaNo = item.getHokenshaNo();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.remban = new RString("1");
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        return source;
    }
}
