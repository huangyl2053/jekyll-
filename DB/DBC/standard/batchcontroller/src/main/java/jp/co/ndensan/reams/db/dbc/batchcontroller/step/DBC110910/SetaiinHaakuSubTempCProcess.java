/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiYinEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握の作成クラスです。
 *
 * @reamsid_L DBC-2770-040 jinjue
 */
public class SetaiinHaakuSubTempCProcess extends BatchProcessBase<SetaiYinEntity> {

    private static final RString 本人区分 = new RString("１：本人");
    private static final RString 本人区分以外 = new RString("2：世帯員");
    private static final RString 本人課税区分 = new RString("１:本人課税区分");
    private static final RString 世帯課税区分 = new RString("１：世帯課税区分");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper.select住所地特例以外の以外");
    private static final RString 世帯員所得情報一時 = new RString("SetaiYinShiyoTokuJyoHoTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 世帯員所得一時;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        世帯員所得一時 = new BatchEntityCreatedTempTableWriter(世帯員所得情報一時,
                SetaiYinEntity.class);
    }

    @Override
    protected void process(SetaiYinEntity entity) {
        ISetaiFinder finder = ShikibetsuTaishoService.getSetaiFinder();
        ISetai isetai = finder.findBy識別コード(GyomuCode.DB介護保険, entity.getShikibetsuCode(),
                entity.getJukyuYMD());
        IKojins kojins = isetai.get世帯員リスト();
        ShikibetsuCode 識別コード = entity.getShikibetsuCode();
        for (IKojin コード : kojins) {
            entity.setShikibetsuCode(コード.get識別コード());
            if (識別コード == コード.get識別コード()) {
                entity.setHonninnkubun(本人区分);
            } else {
                entity.setHonninnkubun(本人区分以外);
            }
        }
        entity.setShotaishikibetsuCode(isetai.getSetaiCode().getColumnValue());
        if (本人区分.equals(entity.getHonninnkubun())) {
            entity.setShotaikazeikubun(本人課税区分);
        }
        if (本人区分以外.equals(entity.getHonninnkubun())) {
            entity.setShotaikazeikubun(世帯課税区分);
        }
        世帯員所得一時.insert(entity);
    }
}
