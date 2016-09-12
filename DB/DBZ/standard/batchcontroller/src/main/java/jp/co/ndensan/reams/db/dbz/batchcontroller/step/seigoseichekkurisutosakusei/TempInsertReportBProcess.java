/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.step.seigoseichekkurisutosakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.seigoseichekkurisutosakusei.SeigoseiChekkuRisutoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seigoseichekkurisutosakusei.SeigoseiChekkuMybitisParamter;
import jp.co.ndensan.reams.db.dbz.definition.processprm.seigoseichekkurisutosakusei.SeigoseiChekkuProcessParamter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seigoseichekkurisutosakusei.SeigoseiChekkuRisutoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seigoseichekkurisutosakusei.SeigoseiChekkuTempTableBEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.seigoseichekkurisutosakusei.ISeigoseiChekkuRisutoMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 整合性チェックリストの作成クラスです。
 *
 * @reamsid_L DBA-5800-030 zhangzhiming
 */
public class TempInsertReportBProcess extends BatchProcessBase<SeigoseiChekkuRisutoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.seigoseichekkurisutosakusei."
            + "ISeigoseiChekkuRisutoMapper.get宛名入力情報");
    private SeigoseiChekkuProcessParamter processPrm;
    ISeigoseiChekkuRisutoMapper mapper;
    private static final RString TABLE_整合性チェック情報B = new RString("SeigoseiChekkuRisutoTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 整合性チェック情報一時ファイルB;
    @BatchWriter
    private BatchPermanentTableWriter<DbT1014SeigoseiCheckEntity> dbT1014Temp;

    @Override
    protected void initialize() {
        mapper = getMapper(ISeigoseiChekkuRisutoMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminJotai> 住民状態 = new ArrayList<>();
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        key.set住民種別(住民種別);
        住民状態.add(JuminJotai.住民);
        key.set住民状態(住民状態);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        SeigoseiChekkuMybitisParamter sqlParam
                = SeigoseiChekkuMybitisParamter.createParam(processPrm.toSeigoseiBatchMybitisParamter(),
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, sqlParam);
    }

    @Override
    protected void createWriter() {
        整合性チェック情報一時ファイルB = new BatchEntityCreatedTempTableWriter(TABLE_整合性チェック情報B,
                SeigoseiChekkuTempTableBEntity.class);
        dbT1014Temp = new BatchPermanentTableWriter<>(DbT1014SeigoseiCheckEntity.class);
    }

    @Override
    protected void process(SeigoseiChekkuRisutoEntity entity) {
        整合性チェック情報一時ファイルB.insert(SeigoseiChekkuRisutoBusiness.set整合性チェック情報一時ファイルB(entity));
    }

    @Override
    protected void afterExecute() {
        List<DbT1014SeigoseiCheckEntity> entityList = mapper.get整合性チェック情報();
        for (DbT1014SeigoseiCheckEntity entity : entityList) {
            dbT1014Temp.delete(entity);
        }
    }
}
