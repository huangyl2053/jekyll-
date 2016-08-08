/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1110001;

import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei.ShotokuJohoIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 単一市町村の所得情報一覧取得
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class TanitsuShichosonShotokuIchiarnProcess extends BatchProcessBase<KaigoHokenShotokuTempEntity> {

    private static final int INDEX_0 = 0;
    private static final int INDEX_4 = 4;
    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db."
            + "mapper.relate.shotokujohoichiranhyosakusei.IShotokuJohoIchiranhyoSakuseiMapper");
    private static final RString SELECTALL = new RString(MAPPER_PATH + ".select介護保険所得情報一覧データ");
    private static final RString 介護保険所得NAME = new RString("KaigoHokenShotokuTemp");
    private ShotokujohoIchiranhyoSakuseiProcessParameter processparameter;
    private ShotokuJohoIchiranhyoSakuseiParameter parameter;

    @Override
    protected void initialize() {
        super.initialize();
        int システム年 = Integer.valueOf(YMDHMS.now().toString().substring(INDEX_0, INDEX_4));
        RString チェックボックス = processparameter.getチェックボックス();
        RString ラジオボタン = processparameter.getラジオボタン();
        FlexibleYear 処理年度 = processparameter.get処理年度();
        RString 出力順 = processparameter.get出力順();
        YMDHMS 開始日時 = processparameter.get開始日時();
        YMDHMS 終了日時 = processparameter.get終了日時();
        parameter = new ShotokuJohoIchiranhyoSakuseiParameter(
                処理年度, チェックボックス, ラジオボタン, LasdecCode.EMPTY, 開始日時, 終了日時, 出力順, システム年);
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter kaigoHokenShotokuTemp_Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTALL, parameter);
    }

    @Override
    protected void createWriter() {
        kaigoHokenShotokuTemp_Writer = new BatchEntityCreatedTempTableWriter(介護保険所得NAME, KaigoHokenShotokuTempEntity.class);
    }

    @Override
    protected void process(KaigoHokenShotokuTempEntity temp) {
        kaigoHokenShotokuTemp_Writer.insert(temp.toKaigoHokenShotokuTempEntity(temp));
    }

}
