/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030;

import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoTorokuChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoTorokuChushutsuTaisho;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.DBC190030ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.HihokenshaDaichoTempSixColumnEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetaiHaakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC110065_基準収入額適用申請書_異動分作成のプロセスクラスです。
 *
 * @reamsid_L DBC-4640-030 jianglaisheng
 */
public class InsSetaiyinShotokuJyohoTemp2Process extends BatchProcessBase<HihokenshaDaichoTempSixColumnEntity> {

    private static final RString TABLENAME = new RString("TmpSetaiHaaku");
    private static final RString PATH3 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc190030."
            + "IDBC190030Mapper.get被保険者台帳3");
    private static final RString PATH4 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc190030."
            + "IDBC190030Mapper.get被保険者台帳4");
    private DBC190030ProcessParameter parameter;
    private FlexibleDate 世帯員把握基準日2;
    private FlexibleYear 世帯員把握基準日2の年度;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 世帯員把握入力一時Writer;

    @Override
    protected void initialize() {
        世帯員把握基準日2 = parameter.get世帯員把握基準日2();
        世帯員把握基準日2の年度 = 世帯員把握基準日2.getNendo();

    }

    @Override
    protected void createWriter() {
        世帯員把握入力一時Writer = new BatchEntityCreatedTempTableWriter(TABLENAME, SetaiHaakuEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        RString 抽出条件 = parameter.get抽出条件();
        RString 抽出対象 = parameter.get抽出対象();
        RString path = PATH4;
        if (ShinseishoTorokuChushutsuJoken.異動分.getコード().equals(抽出条件)
                || (ShinseishoTorokuChushutsuJoken.被保険者番号.getコード().equals(抽出条件)
                && ShinseishoTorokuChushutsuTaisho.基準収入額適用申請書の該当のみ抽出.getコード().equals(抽出対象))) {
            path = PATH3;
        }
        if (ShinseishoTorokuChushutsuJoken.被保険者番号.getコード().equals(抽出条件)
                && ShinseishoTorokuChushutsuTaisho.無条件抽出.getコード().equals(抽出対象)) {
            path = PATH4;
        }
        return new BatchDbReader(path, parameter.toDBC190030MyBatisParameter());
    }

    @Override
    protected void process(HihokenshaDaichoTempSixColumnEntity entity) {
        SetaiHaakuEntity 世帯員把握入力一時 = new SetaiHaakuEntity();
        世帯員把握入力一時.setHihokenshaNo(entity.getHihokenshaNo());
        世帯員把握入力一時.setShikibetsuCode(entity.getShikibetsuCode());
        世帯員把握入力一時.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        世帯員把握入力一時.setKijunYMD(世帯員把握基準日2);
        世帯員把握入力一時.setShotokuNendo(世帯員把握基準日2の年度);
        世帯員把握入力一時Writer.insert(世帯員把握入力一時);
    }

}
