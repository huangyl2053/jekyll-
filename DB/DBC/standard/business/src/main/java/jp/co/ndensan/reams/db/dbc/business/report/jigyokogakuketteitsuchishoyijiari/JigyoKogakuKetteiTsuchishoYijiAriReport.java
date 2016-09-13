/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijiari;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.jigyokogakuketteitsuchishoyijiari.JigyoKogakuKetteiTsuchishoYijiAriSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN43002_事業高額決定通知書(支払予定日あり） reportするクラスです。
 *
 * @reamsid_L DBC-2000-090 lijian
 */
public class JigyoKogakuKetteiTsuchishoYijiAriReport extends Report<JigyoKogakuKetteiTsuchishoYijiAriSource> {

    private final NinshoshaSource 認証者ソースデータ;
    private final KogakuKetteiTsuchiShoEntity 帳票情報;
    private final RString 文書番号;
    private final RString 設定値;
    private final List<RString> 通知書定型文List;

    /**
     * コンストラクタです。
     *
     * @param 設定値 RString
     * @param 帳票情報 KogakuKetteiTsuchiShoEntity
     * @param 認証者ソースデータ NinshoshaSource
     * @param 文書番号 RString
     * @param 通知書定型文List List<RString>
     *
     */
    public JigyoKogakuKetteiTsuchishoYijiAriReport(
            RString 設定値,
            KogakuKetteiTsuchiShoEntity 帳票情報,
            NinshoshaSource 認証者ソースデータ,
            RString 文書番号,
            List<RString> 通知書定型文List) {

        this.設定値 = 設定値;
        this.帳票情報 = 帳票情報;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.文書番号 = 文書番号;
        this.通知書定型文List = 通知書定型文List;

    }

    @Override
    public void writeBy(ReportSourceWriter<JigyoKogakuKetteiTsuchishoYijiAriSource> writer) {

        IJigyoKogakuKetteiTsuchishoYijiAriEditor editor = new JigyoKogakuKetteiTsuchishoYijiAriEditor(
                設定値,
                帳票情報,
                認証者ソースデータ,
                文書番号,
                通知書定型文List);

        IJigyoKogakuKetteiTsuchishoYijiAriBuilder builder = new JigyoKogakuKetteiTsuchishoYijiAriBuilder(editor);

        writer.writeLine(builder);
    }

}
