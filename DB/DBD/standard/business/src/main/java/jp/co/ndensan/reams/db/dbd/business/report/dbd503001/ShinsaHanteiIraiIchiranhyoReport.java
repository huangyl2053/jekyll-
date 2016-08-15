/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd503001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査判定依頼一覧表のReportです。
 *
 * @reamsid_L DBD-1480-030 b_liuyang2
 */
public final class ShinsaHanteiIraiIchiranhyoReport extends Report<ShinsaHanteiIraiIchiranhyoReportSource> {

    private final List<ChohyoShuchiryokuyoShiseiJyohoEntity> 帳票出力用申請情報Entityリスト;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力用申請情報Entityリスト List<ChohyoShuchiryokuyoShiseiJyohoEntity>
     *
     * @return 介護認定審査判定依頼一覧表
     */
    public static ShinsaHanteiIraiIchiranhyoReport createReport(
            List<ChohyoShuchiryokuyoShiseiJyohoEntity> 帳票出力用申請情報Entityリスト) {
        return new ShinsaHanteiIraiIchiranhyoReport(帳票出力用申請情報Entityリスト);
    }

    private ShinsaHanteiIraiIchiranhyoReport(List<ChohyoShuchiryokuyoShiseiJyohoEntity> 帳票出力用申請情報Entityリスト) {
        this.帳票出力用申請情報Entityリスト = 帳票出力用申請情報Entityリスト;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsaHanteiIraiIchiranhyoReportSource> writer) {
        for (int index = 0; index < 帳票出力用申請情報Entityリスト.size(); index++) {
            IShinsaHanteiIraiIchiranhyoEditor bodyEditor = new ShinsaHanteiIraiIchiranhyoEditor(
                    帳票出力用申請情報Entityリスト, index);
            IShinsaHanteiIraiIchiranhyoBuilder builder = new ShinsaHanteiIraiIchiranhyoBuilder(bodyEditor);
            writer.writeLine(builder);
        }

    }
}
