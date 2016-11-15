/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijiari;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書((支払予定日あり))のReportクラスです。
 *
 * @reamsid_L DBC-2000-040 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport extends Report<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> {

    private final KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報;
    private final int 連番;
    private final List<RString> titleList;
    private final List<RString> 通知書定型文List;
    private final NinshoshaSource 認証者ソースデータ;
    private final ChohyoSeigyoKyotsu 帳票制御共通情報;
    private final RString 金融機関コード;
    private final SofubutsuAtesakiSource compSofubutsuAtesakiソース;

    /**
     * コンストラクタです。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity
     * @param 連番 int
     * @param titleList RString
     * @param 通知書定型文List List<RString>
     * @param 認証者ソースデータ NinshoshaSource
     * @param 帳票制御共通情報 ChohyoSeigyoKyotsu
     * @param 金融機関コード RString
     * @param compSofubutsuAtesakiソース SofubutsuAtesakiSource
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport(
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報,
            int 連番,
            List<RString> titleList,
            List<RString> 通知書定型文List,
            NinshoshaSource 認証者ソースデータ,
            ChohyoSeigyoKyotsu 帳票制御共通情報,
            RString 金融機関コード,
            SofubutsuAtesakiSource compSofubutsuAtesakiソース) {
        this.帳票情報 = 帳票情報;
        this.連番 = 連番;
        this.titleList = titleList;
        this.通知書定型文List = 通知書定型文List;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.帳票制御共通情報 = 帳票制御共通情報;
        this.金融機関コード = 金融機関コード;
        this.compSofubutsuAtesakiソース = compSofubutsuAtesakiソース;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> writer) {
        IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiEditor editor
                = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiEditor(
                        帳票情報, 連番, titleList, 通知書定型文List, 認証者ソースデータ, 帳票制御共通情報, 金融機関コード, compSofubutsuAtesakiソース);
        IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiBuilder builder = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiBuilder(editor);
        writer.writeLine(builder);
    }
}
