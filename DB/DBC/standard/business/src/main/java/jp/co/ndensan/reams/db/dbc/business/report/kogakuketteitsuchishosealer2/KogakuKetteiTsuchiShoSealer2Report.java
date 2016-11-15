/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishosealer2;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer21.KogakuKetteiTsuchiShoSealer2Source;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）reportするクラスです。
 *
 * @reamsid_L DBC-2000-070 lijian
 */
public class KogakuKetteiTsuchiShoSealer2Report extends Report<KogakuKetteiTsuchiShoSealer2Source> {

    private final List<RString> titleList;
    private final KogakuKetteiTsuchiShoEntity 帳票情報;
    private final NinshoshaSource 認証者ソースデータ;
    private final RString 文書番号;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param titleList List<RString>
     * @param 帳票情報 KogakuKetteiTsuchiShoEntity
     * @param 認証者ソースデータ NinshoshaSource
     * @param 文書番号 RString
     * @param 連番 int
     */
    public KogakuKetteiTsuchiShoSealer2Report(
            List<RString> titleList,
            KogakuKetteiTsuchiShoEntity 帳票情報,
            NinshoshaSource 認証者ソースデータ,
            RString 文書番号,
            int 連番) {

        this.titleList = titleList;
        this.帳票情報 = 帳票情報;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.文書番号 = 文書番号;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuKetteiTsuchiShoSealer2Source> writer) {
        IKogakuKetteiTsuchiShoSealer2Editor editor = new KogakuKetteiTsuchiShoSealer2Editor(
                titleList,
                帳票情報,
                認証者ソースデータ,
                文書番号,
                連番);
        IKogakuKetteiTsuchiShoSealer2Builder builder = new KogakuKetteiTsuchiShoSealer2Builder(editor);
        writer.writeLine(builder);
    }
}
