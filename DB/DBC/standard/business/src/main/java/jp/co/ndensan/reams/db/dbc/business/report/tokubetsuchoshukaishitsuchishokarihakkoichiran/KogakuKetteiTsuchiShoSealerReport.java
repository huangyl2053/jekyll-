/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer.KogakuKetteiTsuchiShoSealerSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）reportするクラスです。
 *
 * @reamsid_L DBC-2000-060 lijian
 */
public class KogakuKetteiTsuchiShoSealerReport extends Report<KogakuKetteiTsuchiShoSealerSource> {

    private final KogakuKetteiTsuchiShoEntity 帳票情報;
    private final RString 文書番号;
    private final List<RString> 通知書定型文list;
    private final List<RString> インフォlist;
    private final NinshoshaSource 認証者ソースデータ;
    private final List<RString> titleList;
    private final int 通番;

    /**
     * コンストラクタです。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoEntity
     * @param 文書番号 RString
     * @param 通知書定型文list List<RString>
     * @param インフォlist List<RString>
     * @param 認証者ソースデータ NinshoshaSource
     * @param titleList List<RString>
     * @param 通番 int
     */
    public KogakuKetteiTsuchiShoSealerReport(
            KogakuKetteiTsuchiShoEntity 帳票情報,
            RString 文書番号,
            List<RString> 通知書定型文list,
            List<RString> インフォlist,
            NinshoshaSource 認証者ソースデータ,
            List<RString> titleList,
            int 通番) {

        this.帳票情報 = 帳票情報;
        this.文書番号 = 文書番号;
        this.通知書定型文list = 通知書定型文list;
        this.インフォlist = インフォlist;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.titleList = titleList;
        this.通番 = 通番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuKetteiTsuchiShoSealerSource> writer) {
        IKogakuKetteiTsuchiShoSealerEditor editor = new KogakuKetteiTsuchiShoSealerEditor(
                帳票情報,
                文書番号,
                通知書定型文list,
                インフォlist,
                認証者ソースデータ,
                titleList,
                通番);
        IKogakuKetteiTsuchiShoSealerBuilder builder = new KogakuKetteiTsuchiShoSealerBuilder(editor);
        writer.writeLine(builder);
    }

}
