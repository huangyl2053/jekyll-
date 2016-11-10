/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonBusiness;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.ShiKaKuiDoDeTaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.UaFt001FindEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoshaChushutsuSokyubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）のProcessです。
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
public class KakobunJissekiKihonProcess2 extends BatchProcessBase<UaFt001FindEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakukaigotaishoshachushutsusokyubun.IKogakuKaigoTaishoshaChushutsuSokyubunMapper.get宛名データ抽出");
    private static final RString 宛名データ抽出 = new RString("Tempkeisantaisyo");
    private KogakuKaigoTaishoshaChushutsuSokyubun sokyubun;
    private KogakuKaigoTaishoProcessParameter parameter;
    private KakobunJissekiKihonBusiness business;
    private LasdecCode 団体コード;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 過去分実績基本抽出TempTable;

    @Override
    protected void initialize() {
        business = new KakobunJissekiKihonBusiness();
        sokyubun = KogakuKaigoTaishoshaChushutsuSokyubun.createInstance();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        団体コード = association.get地方公共団体コード();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.setparameter(parameter, 団体コード.value(), RString.EMPTY));
    }

    @Override
    protected void createWriter() {
        過去分実績基本抽出TempTable = new BatchEntityCreatedTempTableWriter(宛名データ抽出,
                KakobunJissekiKihonTempTableEntity.class);
    }

    @Override
    protected void process(UaFt001FindEntity entity) {
        business.setList(entity);
    }

    @Override
    protected void afterExecute() {
        List<ShiKaKuiDoDeTaEntity> datelist = sokyubun.getKakobunJissekiKihon2(parameter.get開始年月日１(),
                parameter.get終了年月日１(), business.getList());
        for (ShiKaKuiDoDeTaEntity entity : datelist) {
            過去分実績基本抽出TempTable.insert(business.settabentity(entity));
        }
    }
}
