/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakukeiyakukakuninsho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jyuryoitakukeiyakukakuninsho.JyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN31003_介護保険受領委任契約承認（不承認）確認書（利用者向け）Report
 *
 * @reamsid_L DBC-2130-070 liuxiaoyu
 */
public class JyuryoItakuKeiyakuKakuninShoReport
        extends Report<JyuryoItakuKeiyakuKakuninShoSource> {

    private final KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity 帳票出力対象データ;
    private final NinshoshaSource 認証者情報;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力対象データ KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity
     * @param 認証者情報 NinshoshaSource
     */
    public JyuryoItakuKeiyakuKakuninShoReport(
            KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity 帳票出力対象データ,
            NinshoshaSource 認証者情報) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.認証者情報 = 認証者情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoSource> writer) {
        writeLine(writer, 帳票出力対象データ, 認証者情報);
    }

    private void writeLine(ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoSource> writer,
            KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity 帳票出力対象データ,
            NinshoshaSource 認証者情報) {
        IJyuryoItakuKeiyakuKakuninShoEditor bodyEditor
                = new JyuryoItakuKeiyakuKakuninShoEditor(帳票出力対象データ, 認証者情報);
        IJyuryoItakuKeiyakuKakuninShoBuilder builder
                = new JyuryoItakuKeiyakuKakuninShoBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
