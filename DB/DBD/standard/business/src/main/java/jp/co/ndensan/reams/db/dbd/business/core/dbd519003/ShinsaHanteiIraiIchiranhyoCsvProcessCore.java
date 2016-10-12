/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd519003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190003.ShinsaHanteiIraiIchiranhyoCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失（死亡）データの業務処理クラスです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public class ShinsaHanteiIraiIchiranhyoCsvProcessCore {

    private static final RString ファイル名_日本語 = new RString("資格喪失（死亡）データ送信ファイル");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBD519003"));
    private static final RString 今回開始日時 = new RString("【今回開始日時】");
    private static final RString 今回終了日時 = new RString("【今回終了日時】");
    private static final ReportId REPORT_DBD503001 = ReportIdDBD.DBD503001.getReportId();
    private static final int 先頭9桁 = 9;

    /**
     * 資格喪失（死亡）データのCSVEntityを作成する。
     *
     * @param entity 帳票出力用申請情報Entity
     * @return 資格喪失（死亡）データのCSVEntity
     */
    public ShinsaHanteiIraiIchiranhyoCsvEntity toCsvEntity(ChohyoShuchiryokuyoShiseiJyohoEntity entity) {
        ShinsaHanteiIraiIchiranhyoCsvEntity csvEntity = new ShinsaHanteiIraiIchiranhyoCsvEntity();
        csvEntity.set識別コード(entity.get識別コード().value());
        csvEntity.set保険者番号(entity.get証記載保険者番号().value());
        csvEntity.set被保険者番号(entity.get被保険者番号().value());
        FlexibleDate date = entity.get認定申請年月日();
        FlexibleDate newdate = new FlexibleDate(date.getYearValue(), date.getMonthValue(), 1);
        csvEntity.set認定申請日(newdate.wareki().toDateString());
        csvEntity.set枝番(entity.get枝番());
        csvEntity.set申請区分法令コード(new RString(NinteiShinseiKubunShinsei.職権.toString()));
        csvEntity.set申請区分申請時コード(new RString(NinteiShinseiKubunShinsei.資格喪失_死亡.toString()));
        csvEntity.set取下区分コード(new RString(NinteiShinseiYukoKubunCode.有効.toString()));
        csvEntity.set被保険者区分コード(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        csvEntity.set申請代行区分コード(ShinseiTodokedeDaikoKubunCode.toValue(entity.get申請届出代行区分コード().value()).get名称());
        if (entity.get生年月日() != null) {
            csvEntity.set生年月日(entity.get生年月日().wareki().toDateString());
        }
        if (entity.get性別() != null) {
            csvEntity.set性別コード(Seibetsu.toValue(entity.get性別()).get名称());
        }
        if (entity.get前回要介護状態区分コード() != null) {
            csvEntity.set前回の認定審査会結果(YokaigoJotaiKubun09.toValue(entity.get前回要介護状態区分コード().value()).get名称());
        }
        return csvEntity;
    }

    /**
     * 資格喪失（死亡）データ帳票を出力する。
     *
     * @param batchReportWriter BatchReportWriter<ShinsaHanteiIraiIchiranhyoReportSource>
     * @param para RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter
     * @param association Association
     * @return ReportOutputJokenhyoItem
     */
    public ReportOutputJokenhyoItem 資格喪失帳票出力(BatchReportWriter<ShinsaHanteiIraiIchiranhyoReportSource> batchReportWriter,
            RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter para, Association association) {
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                REPORT_DBD503001.getColumnValue().substring(0, 先頭9桁),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD503001.getReportName(),
                new RString(batchReportWriter.getPageCount()),
                new RString("なし"),
                new RString("なし"),
                contribute(para));
        return item;
    }

    /**
     * 資格喪失（死亡）データCSVを出力する。
     *
     * @param 连番 int
     * @param para RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter
     * @param association Association
     * @return EucFileOutputJokenhyoItem
     */
    public EucFileOutputJokenhyoItem 資格喪失CSV出力(int 连番, RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter para,
            Association association) {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                ファイル名_日本語,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                para.getNewfilename(),
                EUC_ENTITY_ID.toRString(),
                new RString(连番),
                contribute(para));
        return item;
    }

    private List<RString> contribute(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter para) {
        List<RString> 出力条件 = new ArrayList<>();
        if (para.getKonkaikaishidatetime() != null && para.getKonkaikaishidatetime().getDate().isWareki()) {
            出力条件.add(今回開始日時.concat(para.getKonkaikaishidatetime().getDate().wareki().toDateString()));
        }
        if (para.getKonkaishoridatetime() != null && para.getKonkaishoridatetime().getDate().isWareki()) {
            出力条件.add(今回終了日時.concat(para.getKonkaishoridatetime().getDate().wareki().toDateString()));
        }
        return 出力条件;
    }
}
