/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.DBC190030ProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC110065_基準収入額適用申請書_異動分作成のプロセスクラスです。
 *
 * @reamsid_L DBC-4640-030 liuyang
 */
public class InsSetaiyinShotokuJyohoTemp2Process extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private static final ReportId 帳票ID = new ReportId("DBC100064_KijunShunyugakuTekiyoShinseisho");
    private static final RString 抽出条件_異動分 = new RString("異動分");
    private static final RString 抽出条件_被保険者番号 = new RString("被保険者番号");
    private static final RString 抽出対象_基準収入額適用申請書の該当のみ抽出 = new RString("基準収入額適用申請書の該当のみ抽出");
    private static final RString 抽出対象_無条件抽出 = new RString("無条件抽出");
    private static final RString TABLENAME = new RString("TmpSetaiShotoku");
    private static final RString PATH3 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc190030."
            + "get被保険者台帳3");
    private static final RString PATH4 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc190030."
            + "get被保険者台帳4");
    private DBC190030ProcessParameter parameter;
    private FlexibleDate 世帯員把握基準日2;
    private FlexibleYear 世帯員把握基準日2の年度;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 世帯員所得情報一時Writer;

    @Override
    protected void initialize() {
        世帯員把握基準日2 = parameter.get世帯員把握基準日2();
        世帯員把握基準日2の年度 = 世帯員把握基準日2.getNendo();

    }

    @Override
    protected void createWriter() {
        世帯員所得情報一時Writer = new BatchEntityCreatedTempTableWriter(TABLENAME, SetaiShotokuEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        RString 抽出条件 = parameter.get抽出条件();
        RString 抽出対象 = parameter.get抽出対象();
        RString path = RString.EMPTY;
        if (抽出条件_異動分.equals(抽出条件) || (抽出条件_被保険者番号.equals(抽出条件)
                && 抽出対象_基準収入額適用申請書の該当のみ抽出.equals(抽出対象))) {
            path = PATH3;
        }
        if (抽出条件_被保険者番号.equals(抽出条件) && 抽出対象_無条件抽出.equals(抽出対象)) {
            path = PATH4;
        }
        RString 出力順 = new DBC190030ProcessCore().init出力順(帳票ID, parameter.get帳票出力順ID());
        return new BatchDbReader(path, parameter.toDBC190030MyBatisParameter(出力順));
    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity entity) {
        SetaiShotokuEntity 世帯員所得情報一時 = new SetaiShotokuEntity();
        世帯員所得情報一時.setHihokenshaNo(entity.getHihokenshaNo());
        世帯員所得情報一時.setShikibetsuCode(entity.getShikibetsuCode());
        世帯員所得情報一時.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        世帯員所得情報一時.setKijunYMD(世帯員把握基準日2);
        世帯員所得情報一時.setShotokuNendo(世帯員把握基準日2の年度);
        世帯員所得情報一時Writer.insert(世帯員所得情報一時);
    }

}
