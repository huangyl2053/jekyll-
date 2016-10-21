/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakukeiyakukakuninshokeiyaku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jyuryoitakukeiyakukakuninshokeiyaku.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN31003_介護保険受領委任契約承認（不承認）確認書（事業者用）Report
 *
 * @reamsid_L DBC-2130-020 liuxiaoyu
 */
public class JyuryoItakuKeiyakuKakuninShoKeiyakuReport
        extends Report<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> {

    private final KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity 帳票出力対象データ;
    private final NinshoshaSource 認証者情報;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力対象データ KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity
     * @param 認証者情報 NinshoshaSource
     */
    public JyuryoItakuKeiyakuKakuninShoKeiyakuReport(
            KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity 帳票出力対象データ,
            NinshoshaSource 認証者情報) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.認証者情報 = 認証者情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> writer) {
        writeLine(writer, 帳票出力対象データ, 認証者情報);
    }

    private void writeLine(ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> writer,
            KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity 帳票出力対象データ, NinshoshaSource 認証者情報) {
        IJyuryoItakuKeiyakuKakuninShoKeiyakuEditor bodyEditor
                = new JyuryoItakuKeiyakuKakuninShoKeiyakuEditor(帳票出力対象データ, 認証者情報);
        IJyuryoItakuKeiyakuKakuninShoKeiyakuBuilder builder
                = new JyuryoItakuKeiyakuKakuninShoKeiyakuBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
