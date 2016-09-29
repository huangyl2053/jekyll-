/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070.AtenaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempRelateEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 宛名情報を、被保険者番号を経由して取得する、更新用一時の内容を更新する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class AtenaJohoForShikyugakuUpdateTempProcess extends BatchProcessBase<ShikyugakuUpdateTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get宛名情報");

    private static final RString TABLE_NAME = new RString("ShikyugakuUpdateTemp");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        AtenaJohoMybatisParameter parameter = new AtenaJohoMybatisParameter(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).set基準日(FlexibleDate.getNowDate()).build());
        return new BatchDbReader(MYBATIS_ID, parameter);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuUpdateTempEntity.class);
    }

    @Override
    protected void process(ShikyugakuUpdateTempRelateEntity entity) {
        ShikyugakuUpdateTempEntity 更新用一時 = entity.get更新用一時();
        更新用一時.setYubinNo(entity.get宛名().getYubinNo());
        更新用一時.setShikibetsuCode(entity.get宛名().getShikibetsuCode());
        更新用一時.setJushoCode(get全国住所コード(entity.get宛名().getZenkokuJushoCode()));
        更新用一時.setGyoseiCode(get行政区コード(entity.get宛名().getGyoseikuCode()));
        更新用一時.setAtenaKanaShimei(entity.get宛名().getKanaMeisho());
        更新用一時.setAtenaShimei(entity.get宛名().getMeisho());
        更新用一時.setSeinengappiYMD(entity.get宛名().getSeinengappiYMD());
        更新用一時.setShichosonCode(entity.get宛名().getGenLasdecCode());

        更新用一時.setState(EntityDataState.Modified);
        tempDbWriter.update(更新用一時);
    }

    private RString get全国住所コード(ZenkokuJushoCode zenkokuJushoCode) {
        return zenkokuJushoCode == null ? RString.EMPTY : zenkokuJushoCode.getColumnValue();
    }

    private RString get行政区コード(GyoseikuCode gyoseikuCode) {
        return gyoseikuCode == null ? RString.EMPTY : gyoseikuCode.getColumnValue();
    }
}
