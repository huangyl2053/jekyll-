/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb013001.CaluculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001.TokuchoHeinjunka8GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.FukaCalculateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.FukaCalculateTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特徴平準化（特徴8月分）バッチクラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class InsShikakuJyohoTaishoKeisanTempProcess extends BatchProcessBase<FukaCalculateEntity> {

    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper.select賦課計算_賦課");
    private static final RString 賦課計算中間_NAME = new RString("FukaCalculateTemp");
    private TokuchoHeinjunka8GatsuProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;
    private FukaCalculateTempEntity tempEntity;
    private CaluculateFukaParameter myBatisParameter;
    private CreatCalculateEntity manager;
    private TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
    private FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
    private FlexibleYear 調定年度 = FlexibleYear.EMPTY;

    @Override
    public void initialize() {
        KozaSearchKeyBuilder kozabuilder = new KozaSearchKeyBuilder();
        kozabuilder.set業務コード(GyomuCode.DB介護保険);
        kozabuilder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        kozabuilder.set基準日(FlexibleDate.getNowDate());
        IKozaSearchKey kozaSearchKey = kozabuilder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());

        myBatisParameter = CaluculateFukaParameter.createSelectByKeyParam(kozaSearchKey, list, parameter.get調定年度(), parameter.get賦課年度());
        manager = CreatCalculateEntity.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(賦課計算中間_NAME, FukaCalculateTempEntity.class);
    }

    @Override
    protected void process(FukaCalculateEntity entity) {
        if (通知書番号.equals(entity.getTsuchishoNo())
                && 賦課年度.equals(entity.getFukaNendo())
                && 調定年度.equals(entity.getChoteiNendo())) {
            manager.creat期別金額Entity(tempEntity, entity);
            setKey(entity);
        } else {
            if (tempEntity != null) {
                tableWriter.insert(tempEntity);
            }
            tempEntity = new FukaCalculateTempEntity();
            manager.creat賦課計算Entity(tempEntity, entity);
            manager.creat賦課Entity(tempEntity, entity);
            manager.creat期別金額Entity(tempEntity, entity);
            setKey(entity);
        }
    }

    @Override
    protected void afterExecute() {
        if (tempEntity != null) {
            tableWriter.insert(tempEntity);
        }
    }

    private void setKey(FukaCalculateEntity entity) {
        賦課年度 = entity.getFukaNendo();
        調定年度 = entity.getChoteiNendo();
        通知書番号 = entity.getTsuchishoNo();
    }
}
