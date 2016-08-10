/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseishoucho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakujigyoshikyushinseishoyucho.KogakuJigyoShikyuShinseishoYuchoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshikyushinseishoyuchosource.KogakuJigyoShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100071_介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）のReportSourceクラスです。
 *
 * @reamsid_L DBC-4770-090 jianglaisheng
 */
public class KogakuJigyoShikyuShinseishoYuchoReport extends Report<KogakuJigyoShikyuShinseishoYuchoSource> {

    private final KogakuJigyoShikyuShinseishoYuchoEntity parameter;

    /**
     * インスタンスを生成します。
     *
     * @param parameter KogakuJigyoShikyuShinseishoYuchoParameter
     */
    public KogakuJigyoShikyuShinseishoYuchoReport(KogakuJigyoShikyuShinseishoYuchoEntity parameter) {
        this.parameter = parameter;
    }

    @Override
    protected void writeBy(ReportSourceWriter<KogakuJigyoShikyuShinseishoYuchoSource> reportSourceWriter) {
        ShinseiJohoChohyoTempEntity 帳票出力対象データ = parameter.get帳票出力対象データ();
        RString 認証者役職名 = parameter.get認証者役職名();
        RDateTime システム日付 = parameter.getシステム日付();
        Boolean is金融機関表示 = parameter.getIs金融機関表示();
        RString 注意文 = parameter.get注意文();
        RString 連番 = parameter.get連番();

        KogakuJigyoShikyuShinseishoYuchoEditor editor = new KogakuJigyoShikyuShinseishoYuchoEditor(帳票出力対象データ,
                認証者役職名, システム日付, is金融機関表示, 注意文, 連番);
        KogakuJigyoShikyuShinseishoYuchoBuilder builder = new KogakuJigyoShikyuShinseishoYuchoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
