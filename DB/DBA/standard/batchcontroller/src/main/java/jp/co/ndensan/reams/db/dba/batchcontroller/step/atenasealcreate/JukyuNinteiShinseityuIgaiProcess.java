/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.atenasealcreate.AtenaSealCreateResult;
import jp.co.ndensan.reams.db.dba.definition.processprm.atenasealcreate.AtenaSealCreateProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateRelate4001Entity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.DbTAtenaSealCreateTempTableEntity;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成、抽出対象者が受給認定申請中を除くの場合、データを作成します。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public class JukyuNinteiShinseityuIgaiProcess extends BatchProcessBase<AtenaSealCreateRelate4001Entity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate."
            + "IAtenaSealCreateJukyuNinteiShinseityuIgaiMapper.getJukyuNinteiShinseityuIgai");
    private AtenaSealCreateProcessParameter processParamter;
    private static final RString TABLE_宛名識別対象一時テーブル3 = new RString("DbWT2009AtenaShikibetuTaisyou3");
    List<KoikiZenShichosonJoho> koikiZenShichosonJoho;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 宛名識別対象一時テーブル3;

    @Override
    protected void initialize() {
        koikiZenShichosonJoho = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.住登外優先, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBA介護資格));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toAtenaSealCreateMybatisParameter(psmShikibetsuTaisho, psmAtesaki));
    }

    @Override
    protected void createWriter() {
        宛名識別対象一時テーブル3 = new BatchEntityCreatedTempTableWriter(TABLE_宛名識別対象一時テーブル3,
                DbTAtenaSealCreateTempTableEntity.class);
    }

    @Override
    protected void process(AtenaSealCreateRelate4001Entity entity) {
        宛名識別対象一時テーブル3.insert(new AtenaSealCreateResult().set宛名識別対象一時テーブル3(entity, processParamter));
    }
}
