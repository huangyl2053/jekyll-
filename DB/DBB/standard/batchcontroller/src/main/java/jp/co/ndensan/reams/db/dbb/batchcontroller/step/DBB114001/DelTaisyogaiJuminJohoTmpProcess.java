/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.ShikibetsuCodeListParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.ShotokuNendoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuJouhouEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 対象外の住民情報を更新のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class DelTaisyogaiJuminJohoTmpProcess extends SimpleBatchProcessBase {

    private static final int INT_1 = 1;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private ShotokuNendoParameter myBaticParameter;
    private IShotokushokaihyoMapper mapper;
    private List<ShikibetsuCode> 識別コードList;
    private ShikibetsuCodeListParameter 識別コードparameter;
    private List<ShotokuJouhouEntity> 所得情報List;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IShotokushokaihyoMapper.class);
        myBaticParameter = creatParameter(processParameter);
        識別コードparameter = new ShikibetsuCodeListParameter();
        識別コードList = mapper.select除外の住民(myBaticParameter);
        所得情報List = mapper.select所得情報(processParameter.get処理年度());
    }

    @Override
    protected void process() {
        if (所得情報List != null && !所得情報List.isEmpty()) {
            for (ShotokuJouhouEntity entity : 所得情報List) {
                if (!識別コードList.contains(entity.get識別コード())) {
                    識別コードList.add(entity.get識別コード());
                }
            }
        }
        識別コードparameter.set識別コードList(識別コードList);
        mapper.delete所得照会候補者(識別コードparameter);
    }

    private ShotokuNendoParameter creatParameter(ShotokuShokaihyoHakkoProcessParameter processParameter) {
        ShotokuNendoParameter parameter = new ShotokuNendoParameter();
        parameter.set処理年度_0101(new FlexibleDate(processParameter.get処理年度().getYearValue(), INT_1, INT_1));
        return parameter;
    }

}
