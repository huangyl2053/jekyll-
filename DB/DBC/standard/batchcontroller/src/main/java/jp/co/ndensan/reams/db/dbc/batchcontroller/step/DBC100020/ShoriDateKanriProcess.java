/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100020.KaishuriyushoShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタのProcessクラスです。
 *
 * @reamsid_L DBC-2850-030 jinjue
 */
public class ShoriDateKanriProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kaishuriyushoshikyuketteitsuchishosakusei.IKaishuriyushoShikyuKetteitsuchishoSakuseiMapper.select処理日付管理");
    @BatchWriter
    private BatchPermanentTableWriter 処理日付管理マスタ;
    private KaishuriyushoShikyuKetteitsuchishoProcessParameter processParameter;
    private final RString 処理名 = ShoriName.住宅改修理由書作成手数料支給不支給決定通知書作成.get名称();
    private final RString 処理枝番 = new RString("0000");
    private final FlexibleYear 年度 = new FlexibleYear("0000");
    private final RString 年度内連番 = new RString("0001");

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
        processParameter.setPsmShikibetsuTaisho(psmShikibetsuTaisho);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisPatameter());
    }

    @Override
    protected void initialize() {
        処理日付管理マスタ = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        if (entity == null) {
            DbT7022ShoriDateKanriEntity entity22 = new DbT7022ShoriDateKanriEntity();
            entity22.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            entity22.setShichosonCode(processParameter.get市町村コード());
            entity22.setShoriName(処理名);
            entity22.setShoriEdaban(処理枝番);
            entity22.setNendo(年度);
            entity22.setNendoNaiRenban(年度内連番);
            entity22.setTaishoKaishiYMD(processParameter.get決定開始日());
            entity22.setTaishoShuryoYMD(processParameter.get決定終了日());
            処理日付管理マスタ.insert(entity22);
        } else {
            entity.setTaishoKaishiYMD(processParameter.get決定開始日());
            entity.setTaishoShuryoYMD(processParameter.get決定終了日());
            処理日付管理マスタ.update(entity);
        }
    }
}
