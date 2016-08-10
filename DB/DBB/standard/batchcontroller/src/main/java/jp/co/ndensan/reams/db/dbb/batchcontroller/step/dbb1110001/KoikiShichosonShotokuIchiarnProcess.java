/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shotokujohoichiranhyosakusei.ShotokuJohoIchiranhyoSakuseiGParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域市町村の所得情報一覧取得です。
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class KoikiShichosonShotokuIchiarnProcess extends BatchProcessBase<KaigoHokenShotokuTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db."
            + "mapper.relate.shotokujohoichiranhyosakusei.IShotokuJohoIchiranhyoSakuseiMapper");
    private static final RString SELECTALL = new RString(MAPPER_PATH + ".select対象データ");
    private static final RString 介護保険所得NAME = new RString("KaigoHokenShotokuTemp");
    private ShotokujohoIchiranhyoSakuseiProcessParameter processparameter;
    private ShotokuJohoIchiranhyoSakuseiGParameter parameter;

    @Override
    protected void initialize() {
        RString チェックボックス = processparameter.getチェックボックス();
        RString ラジオボタン = processparameter.getラジオボタン();
        FlexibleYear 処理年度 = processparameter.get処理年度();
        RString 出力順 = processparameter.get出力順();
        List<ShichosonJouhouResult> 市町村情報リスト = processparameter.get市町村情報リスト();
        List<LasdecCode> 市町村コードList = new ArrayList<>();
        for (ShichosonJouhouResult result : 市町村情報リスト) {
            市町村コードList.add(result.get市町村コード());
        }
        parameter = new ShotokuJohoIchiranhyoSakuseiGParameter(処理年度, チェックボックス, ラジオボタン, 市町村コードList, 出力順);
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
    protected void process(KaigoHokenShotokuTempEntity entity) {
        kaigoHokenShotokuTemp_Writer.insert(entity.toKaigoHokenShotokuTempEntity(entity));
    }

}
