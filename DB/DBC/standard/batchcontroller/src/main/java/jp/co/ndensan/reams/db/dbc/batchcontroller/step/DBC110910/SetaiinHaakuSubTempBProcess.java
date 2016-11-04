/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910.SetaiinHaakuSubMybitisParamter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910.SetaiinHaakuSubTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiYinEntity;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握の作成クラスです。
 *
 * @reamsid_L DBC-2770-060 jinjue
 */
public class SetaiinHaakuSubTempBProcess extends BatchProcessBase<SetaiYinEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper.select住所地特例該当以外");
    private static final RString 世帯員所得情報一時 = new RString("SetaiYinShiyoTokuJyoHoTemp");
    private static final RString 特例該当 = new RString("1");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 世帯員所得一時;
    SetaiinHaakuSubTempProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.死亡者);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        key.set住民状態(juminJotaiList);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        SetaiinHaakuSubMybitisParamter meter = parameter.toSeigoseiBatchMybitisParamter();
        meter.set管理識別区分(parameter.get管理識別区分());
        meter.set住所地特例該当(特例該当);
        meter.setPsmShikibetsuTaisho(psmShikibetsuTaisho);
        return new BatchDbReader(MYBATIS_SELECT_ID, meter);
    }

    @Override
    protected void createWriter() {
        世帯員所得一時 = new BatchEntityCreatedTempTableWriter(世帯員所得情報一時,
                SetaiYinEntity.class);
    }

    @Override
    protected void process(SetaiYinEntity entity) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(entity.getShotaishikibetsuCode());
        entity.setShikibetsuCode(識別コード);
        SetaiCode 世帯コード = new SetaiCode(entity.getJuushotitokureigaitou());
        entity.setSetaiCode(世帯コード);
        世帯員所得一時.insert(entity);
    }
}
