/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100065_負担割合証Report
 *
 * @reamsid_L DBC-5010-030 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiShoReport extends
        Report<FutanWariaiShoSource> {

    private final FutanWariaiShoDivParameter entity;
    private final NinshoshaSource 認証者ソースデータ;
    private final HihokenshaNo 被保険者番号;
    private final EditedKojin 編集後個人;
    private final HokenshaNo 保険者コード取得;
    private final List<IKojin> 個人;
    private final SofubutsuAtesakiSource 送付物宛先ソースデータ;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param entity FutanWariaiShoDivParameter
     * @param 認証者ソースデータ NinshoshaSource
     * @param 被保険者番号 HihokenshaNo
     * @param 編集後個人 EditedKojin
     * @param 保険者コード取得 HokenshaNo
     * @param 個人 List<IKojin>
     * @param 送付物宛先ソースデータ SofubutsuAtesakiSource
     * @param 識別コード ShikibetsuCode
     */
    public FutanWariaiShoReport(FutanWariaiShoDivParameter entity, NinshoshaSource 認証者ソースデータ, HihokenshaNo 被保険者番号,
            EditedKojin 編集後個人, HokenshaNo 保険者コード取得,
            List<IKojin> 個人, SofubutsuAtesakiSource 送付物宛先ソースデータ, ShikibetsuCode 識別コード) {
        this.entity = entity;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.被保険者番号 = 被保険者番号;
        this.編集後個人 = 編集後個人;
        this.保険者コード取得 = 保険者コード取得;
        this.個人 = 個人;
        this.送付物宛先ソースデータ = 送付物宛先ソースデータ;
        this.識別コード = 識別コード;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanWariaiShoSource> writer) {
        IFutanWariaiShoEditor editor = new FutanWariaiShoEditor(entity, 認証者ソースデータ, 被保険者番号, 編集後個人,
                保険者コード取得, 個人, 送付物宛先ソースデータ, 識別コード);
        IFutanWariaiShoBuilder builder = new FutanWariaiShoBuilder(editor);
        writer.writeLine(builder);
    }

}
