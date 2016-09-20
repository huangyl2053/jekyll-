/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書のReportクラスです。
 *
 * @reamsid_L DBC-2000-050 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport extends Report<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> {

    private final KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報;
    private final int 連番;
    private final RString 設定値;
    private final List<RString> 通知書定型文List;
    private final NinshoshaSource 認証者ソースデータ;

    /**
     * コンストラクタです。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity
     * @param 連番 int
     * @param 設定値 RString
     * @param 通知書定型文List List<RString>
     * @param 認証者ソースデータ NinshoshaSource
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport(
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報,
            int 連番,
            RString 設定値,
            List<RString> 通知書定型文List,
            NinshoshaSource 認証者ソースデータ) {
        this.帳票情報 = 帳票情報;
        this.連番 = 連番;
        this.設定値 = 設定値;
        this.通知書定型文List = 通知書定型文List;
        this.認証者ソースデータ = 認証者ソースデータ;

    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> writer) {
        IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor editor
                = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor(帳票情報, 連番, 設定値, 通知書定型文List, 認証者ソースデータ);
        IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder builder = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder(editor);
        writer.writeLine(builder);
    }

}
