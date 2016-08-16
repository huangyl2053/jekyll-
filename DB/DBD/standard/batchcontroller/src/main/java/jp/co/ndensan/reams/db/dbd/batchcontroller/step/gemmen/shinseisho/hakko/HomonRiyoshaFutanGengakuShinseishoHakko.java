/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko;

import jp.co.ndensan.reams.db.dbd.definition.processprm.gemmen.shinseisho.hakko.ShinseishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko.RiyoshaFutangakuGemmenShinseishoHakkoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBZ12021_4_訪問介護利用者負担額減額申請書_process処理クラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public class HomonRiyoshaFutanGengakuShinseishoHakko extends BatchProcessBase<RiyoshaFutangakuGemmenShinseishoHakkoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko."
            + "IRiyoshaFutangakuGemmenShinseishoHakkoMapper.get出力対象者情報");
    private ShinseishoHakkoProcessParameter processParamter;
    private RString 出力順;

    @Override
    protected IBatchReader createReader() {
        IOutputOrder order = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBD介護受給,
                processParamter.get帳票ID(),
                processParamter.get改頁出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(null, order);
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toFutanGendogakuMybatisParameter(出力順));
    }

    @Override
    protected void process(RiyoshaFutangakuGemmenShinseishoHakkoEntity entity) {
        //TODO 帳票設計_DBD800005_訪問介護利用者負担額減額申請書 の実装がありません。
        //2016/08/16まで。
    }

}
