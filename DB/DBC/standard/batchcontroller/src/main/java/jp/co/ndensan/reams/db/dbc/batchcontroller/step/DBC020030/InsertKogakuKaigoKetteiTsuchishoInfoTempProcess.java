/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceshikyukettei.KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.InsertKetteiTsuchishoInfoTempMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.DbWT0203ShoriKekkaKakuninListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額サービス等支給（不支給）決定通知書情報一時TBLの登録処理のクラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public class InsertKogakuKaigoKetteiTsuchishoInfoTempProcess extends BatchProcessBase<KetteiTsuchishoInfoTempResultEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservice.IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper.select高額サービス情報");
    private static final RString 高額サービス決定通知書情報一時_TABLE_NAME = new RString("KetteiTsuchishoInfoTempEntity");
    private static final RString 処理結果確認リスト一時_TABLE_NAME = new RString("DbWT0203ShoriKekkaKakuninList");

    private KogakuKaigoServiceProcessParameter parameter;
    ServicehiShikyuKetteiTsuchisho manager;
    private InsertKetteiTsuchishoInfoTempMybatisParameter mybatisParameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額サービス決定通知書情報一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果確認リスト一時tableWriter;

    @Override
    protected void initialize() {
        manager = ServicehiShikyuKetteiTsuchisho.createInstance();

    }

    @Override
    protected void createWriter() {
        高額サービス決定通知書情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額サービス決定通知書情報一時_TABLE_NAME, KetteiTsuchishoInfoTempEntity.class);
        処理結果確認リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果確認リスト一時_TABLE_NAME, DbWT0203ShoriKekkaKakuninListTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set基準日(new FlexibleDate(RDate.getNowDate().toDateString())).build();
        List<KamokuCode> kamokuList = new ShunoKamokuAuthority().
                get参照権限科目コード(UrControlDataFactory.createInstance().getLoginInfo().getUserId());
        FlexibleDate 抽出条件日付From = new FlexibleDate(parameter.get抽出条件日付From().toDateString());
        FlexibleDate 抽出条件日付To = new FlexibleDate(parameter.get抽出条件日付To().toDateString());
        mybatisParameter = new InsertKetteiTsuchishoInfoTempMybatisParameter(parameter.get抽出モード(), 抽出条件日付From,
                抽出条件日付To, parameter.get決定者受付年月(), parameter.get印書(), parameter.get高額自動償還(), searchKey, kamokuList);
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void process(KetteiTsuchishoInfoTempResultEntity entity) {
        高額サービス決定通知書情報一時tableWriter.insert(manager.to決定通知書情報(entity));
        if (null == entity.get宛名()) {
            処理結果確認リスト一時tableWriter.insert(get処理結果確認リスト(entity));
        }
    }

    private DbWT0203ShoriKekkaKakuninListTempEntity get処理結果確認リスト(KetteiTsuchishoInfoTempResultEntity entity) {

        DbWT0203ShoriKekkaKakuninListTempEntity returnEntity = new DbWT0203ShoriKekkaKakuninListTempEntity();
        returnEntity.setErrorKubun(KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun.宛名取得.getコード());
        returnEntity.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
        returnEntity.setHihokenshaNo(entity.get被保険者番号());
        returnEntity.setKey1(entity.getサービス提供年月().wareki().toDateString());
        returnEntity.setKey2(new RString(entity.get履歴番号()));
        returnEntity.setKey3(RString.EMPTY);
        returnEntity.setKey4(RString.EMPTY);
        returnEntity.setKey5(RString.EMPTY);
        returnEntity.setHihokenshaShimei(RString.EMPTY);
        returnEntity.setBiko(RString.EMPTY);
        return returnEntity;
    }

}
