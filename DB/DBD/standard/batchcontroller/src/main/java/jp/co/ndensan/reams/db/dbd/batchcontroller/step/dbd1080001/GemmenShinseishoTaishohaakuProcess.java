/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1080001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.GemmenShinseishoTaishohaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.HanteiTaishoshaTokuteiEntity;
import jp.co.ndensan.reams.db.dbd.service.core.gemmenshinseishotaishohaaku.ZenNendoResearcher;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）の_process処理クラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public class GemmenShinseishoTaishohaakuProcess extends BatchProcessBase<HanteiTaishoshaTokuteiEntity> {

    private static final RString MYBATIS_SELECT_ID_減免減額_負担 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate"
            + ".gemmenshinseishotaishohaaku.IHanteiTaishoshaTokuteiMapper.get減免減額対象者判定用根拠作成対象者_負担限度額認定");
    private static final RString MYBATIS_SELECT_ID_減免減額_利用者 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate"
            + ".gemmenshinseishotaishohaaku.IHanteiTaishoshaTokuteiMapper.get減免減額対象者判定用根拠作成対象者_利用者負担額減額");
    private static final RString MYBATIS_SELECT_ID_減免減額_訪問 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper"
            + ".relate.gemmenshinseishotaishohaaku.IHanteiTaishoshaTokuteiMapper.get減免減額対象者判定用根拠作成対象者_訪問介護利用者負担額減額");
    private static final RString MYBATIS_SELECT_ID_減免減額_社会 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper"
            + ".relate.gemmenshinseishotaishohaaku.IHanteiTaishoshaTokuteiMapper.get減免減額対象者判定用根拠作成対象者_社会福祉法人等利用者負担軽減");

    private GemmenShinseishoTaishohaakuProcessParameter processParamter;
    private FlexibleDate 終了日;
    private FlexibleDate 開始日;
    private GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity item;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter hantYoukSakusTaishosTemp;

    @Override
    protected void initialize() {
        終了日 = ZenNendoResearcher.createIntance(processParamter.get減免減額種類(), processParamter.get基準日()).get終了日();
        開始日 = ZenNendoResearcher.createIntance(processParamter.get減免減額種類(), processParamter.get基準日()).get開始日();
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.負担限度額認定)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_減免減額_負担, processParamter.toGemmenShinseishoTaishohaakuMybatisParameter(開始日, 終了日));
        } else if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.利用者負担額減額)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_減免減額_利用者, processParamter.toGemmenShinseishoTaishohaakuMybatisParameter(開始日, 終了日));
        } else if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.訪問介護利用者負担額減額)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_減免減額_訪問, processParamter.toGemmenShinseishoTaishohaakuMybatisParameter(開始日, 終了日));
        } else {
            return new BatchDbReader(MYBATIS_SELECT_ID_減免減額_社会, processParamter.toGemmenShinseishoTaishohaakuMybatisParameter(開始日, 終了日));
        }
    }

    @Override
    protected void createWriter() {
        hantYoukSakusTaishosTemp = new BatchEntityCreatedTempTableWriter(GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity.TABLE_NAME,
                GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity.class);
    }

    @Override
    protected void process(HanteiTaishoshaTokuteiEntity list) {
        item = set減免減額対象者判定用根拠作成対象者(list.get被保険者番号(), processParamter.get基準日());
        hantYoukSakusTaishosTemp.insert(item);
    }

    private GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity set減免減額対象者判定用根拠作成対象者(HihokenshaNo 被保険者番号,
            FlexibleDate 基準日) {
        GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity tempTable
                = new GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity();
        tempTable.setKijunYMD(基準日);
        tempTable.setHihokenshaNo(被保険者番号);
        return tempTable;
    }
}
