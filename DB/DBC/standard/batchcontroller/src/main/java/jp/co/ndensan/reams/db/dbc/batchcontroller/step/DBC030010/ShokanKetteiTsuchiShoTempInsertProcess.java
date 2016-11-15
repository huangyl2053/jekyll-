/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho.ShokanKetteiTsuchiShoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払い支給不支給決定通知書一時TBLを作成します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShoTempInsertProcess extends BatchProcessBase<ShokanKetteiTsuchiShoTempTableEntity> {

    private static final RString 決定通知書情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get決定通知書情報");
    private static final RString TABLE_償還払い支給不支給決定通知書情報 = new RString("ShokanKetteiTsuchiShoTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 償還払い支給不支給決定通知書情報一時TBL;
    ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {

        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBC介護給付);
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey key1 = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());

        ShikibetsuTaishoPSMSearchKeyBuilder key2 = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho = key2.build();

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.未定義), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(宛先builder.build());
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        ShokanKetteiTsuchiShoIkkatsuSakuseiParameter sqlParam
                = ShokanKetteiTsuchiShoIkkatsuSakuseiParameter.createParam(
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                        new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString()), parameter.getHurikomiYoteiYMD(),
                        parameter.getChusyuMode(), parameter.getInsho(), parameter.getDataFrom(), parameter.getDataTo(), parameter.getHakkoYMD(),
                        parameter.getKetteishaUketsukeYM(),
                        帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                                FlexibleYear.MIN, new RString("用紙タイプ")).get設定値(), key1, list, psmShikibetsuTaisho);
        return new BatchDbReader(決定通知書情報取得SQL, sqlParam);
    }

    @Override
    protected void createWriter() {
        償還払い支給不支給決定通知書情報一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_償還払い支給不支給決定通知書情報,
                ShokanKetteiTsuchiShoTempTableEntity.class);
    }

    @Override
    protected void process(ShokanKetteiTsuchiShoTempTableEntity entity) {
        償還払い支給不支給決定通知書情報一時TBL.insert(entity);
    }
}
