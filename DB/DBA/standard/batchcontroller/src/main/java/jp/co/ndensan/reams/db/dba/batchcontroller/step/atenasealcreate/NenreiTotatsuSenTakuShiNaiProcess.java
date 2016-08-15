/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.atenaseal.AtenaSealReportBusiness;
import jp.co.ndensan.reams.db.dba.business.core.atenasealcreate.AtenaSealCreateResult;
import jp.co.ndensan.reams.db.dba.definition.processprm.atenasealcreate.AtenaSealCreateProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateDBZ100001Entity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.DbTAtenaSealCreateTempTableEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.ShorikekkarisutoichijiTBLEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成、年齢到達予定者選択しないの場合、データを作成します。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public class NenreiTotatsuSenTakuShiNaiProcess extends BatchProcessBase<AtenaSealCreateRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate.IAtenaSealCreateMapper.getHihokenshadai");
    private AtenaSealCreateProcessParameter processParamter;
    List<KoikiZenShichosonJoho> koikiZenShichosonJoho;
    List<AtenaSealCreateRelateEntity> list = new ArrayList<>();
    List<AtenaSealReportBusiness> listBusiness = new ArrayList<>();
    List<AtenaSealCreateDBZ100001Entity> listDBZ100001 = new ArrayList<>();
    private static final RString TABLE_宛名識別対象一時テーブル2 = new RString("DbWT2009AtenaShikibetuTaisyou2");
    private static final RString TABLE_処理結果リスト一時TBL = new RString("ShorikekkarisutoichijiTBL");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 宛名識別対象一時テーブル2;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;

    @Override
    protected void initialize() {
        DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第２号被保険者到達基準年齢, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
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
        宛名識別対象一時テーブル2 = new BatchEntityCreatedTempTableWriter(TABLE_宛名識別対象一時テーブル2,
                DbTAtenaSealCreateTempTableEntity.class);
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果リスト一時TBL,
                ShorikekkarisutoichijiTBLEntity.class);
    }

    @Override
    protected void process(AtenaSealCreateRelateEntity entity) {
        宛名識別対象一時テーブル2.insert(new AtenaSealCreateResult().set宛名識別対象一時テーブル2(entity, processParamter, koikiZenShichosonJoho));
    }

}
