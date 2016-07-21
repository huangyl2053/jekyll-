/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200007;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 支払方法変更管理リストのReportです。
 *
 * @reamsid_L DBD-3630-050 liangbc
 */
public class ShiharaiHohoHenkoKanriIchiranReport extends Report<ShiharaiHohoHenkoKanriIchiranReportSource> {

    private final RDateTime 作成日時;
    private final HokenshaNo 保険者番号;
    private final RString 保険者名称;
    private final IOutputOrder 出力順;
    private final ShiharaiHohoHenkoEntity 支払方法変更リストEntity;
    private int count;

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 作成日時
     * @param 保険者番号 保険者番号
     * @param 保険者名称 保険者名称
     * @param 出力順 出力順
     * @param 支払方法変更リストEntity 支払方法変更リストEntity
     * @return 社会福祉法人等利用者負担軽減対象確認申請書のReport
     */
    public static ShiharaiHohoHenkoKanriIchiranReport createReport(RDateTime 作成日時,
            HokenshaNo 保険者番号,
            RString 保険者名称,
            IOutputOrder 出力順,
            ShiharaiHohoHenkoEntity 支払方法変更リストEntity) {
        return new ShiharaiHohoHenkoKanriIchiranReport(作成日時, 保険者番号, 保険者名称, 出力順, 支払方法変更リストEntity);
    }

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 作成日時
     * @param 保険者番号 保険者番号
     * @param 保険者名称 保険者名称
     * @param 出力順 出力順
     * @param 支払方法変更リストEntity 支払方法変更リストEntity
     */
    protected ShiharaiHohoHenkoKanriIchiranReport(RDateTime 作成日時,
            HokenshaNo 保険者番号,
            RString 保険者名称,
            IOutputOrder 出力順,
            ShiharaiHohoHenkoEntity 支払方法変更リストEntity) {
        this.作成日時 = 作成日時;
        this.保険者名称 = 保険者名称;
        this.保険者番号 = 保険者番号;
        this.出力順 = 出力順;
        this.支払方法変更リストEntity = 支払方法変更リストEntity;
        this.count = 1;
    }

    /**
     * 帳票ソースファイルの「永続化処理の定義」を行います
     *
     * @param reportSourceWriter 社会福祉法人等利用者負担軽減対象確認申請書情報
     */
    @Override
    public void writeBy(ReportSourceWriter<ShiharaiHohoHenkoKanriIchiranReportSource> reportSourceWriter) {
        IShiharaiHohoHenkoKanriIchiranEditor editor
                = new ShiharaiHohoHenkoKanriIchiranEditorImpl(作成日時, 保険者番号, 保険者名称, 出力順, 支払方法変更リストEntity, count);
        IShiharaiHohoHenkoKanriIchiranBuilder builder
                = new ShiharaiHohoHenkoKanriIchiranBuilderImpl(editor);
        count = count + 1;
        reportSourceWriter.writeLine(builder);
    }
}
