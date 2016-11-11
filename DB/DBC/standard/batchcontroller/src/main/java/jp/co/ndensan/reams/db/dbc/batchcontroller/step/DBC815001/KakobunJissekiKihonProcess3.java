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
public class KakobunJissekiKihonProcess3 extends BatchProcessBase<ShiKaKuiDoDeTaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakukaigotaishoshachushutsusokyubun.IKogakuKaigoTaishoshaChushutsuSokyubunMapper.get資格異動データ抽出");
    private static final RString 宛名データ抽出 = new RString("Tempkeisantaisyo");
    private KogakuKaigoTaishoshaChushutsuSokyubun sokyubun;
    private KogakuKaigoTaishoProcessParameter parameter;
    private KakobunJissekiKihonBusiness business;
    private LasdecCode 団体コード;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempTable;

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
        tempTable = new BatchEntityCreatedTempTableWriter(宛名データ抽出,
                KakobunJissekiKihonTempTableEntity.class);
    }

    @Override
    protected void process(ShiKaKuiDoDeTaEntity entity) {
        business.setShiKalist(entity);
    }

    @Override
    protected void afterExecute() {
        List<ShiKaKuiDoDeTaEntity> datelist = sokyubun.getKakobunJissekiKihon3(parameter.get開始年月日１(),
                parameter.get終了年月日１(), business.getShiKalist());
        for (ShiKaKuiDoDeTaEntity entity : datelist) {
            tempTable.insert(business.settabentity(entity));
        }
    }
}
