/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshakyufujisseki.HokenshaKyufujissekiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikihon.DbWT1131KyufujissekiKihonTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.hokenshakyufujisseki.HokenshaKyufujissekiFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成の処理詳細_DB削除Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class DelDataRecordTempProcess extends BatchProcessBase<DbWT1131KyufujissekiKihonTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get給付実績基本一時Delete");

    private HokenshaKyufujissekiProcessParameter processParameter;
    private HokenshaKyufujissekiMybatisParameter mybatisParam;

    @Override
    protected void initialize() {
        mybatisParam = processParameter.toHokenshaKyufujissekiMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(DbWT1131KyufujissekiKihonTempEntity entity) {
        mybatisParam.setInputShikibetsuNo(entity.getInputShikibetsuNo());
        mybatisParam.setHiHokenshaNo(entity.getHiHokenshaNo());
        mybatisParam.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        mybatisParam.setJigyoshoNo(entity.getJigyoshoNo());
        mybatisParam.setToshiNo(entity.getToshiNo());
        HokenshaKyufujissekiFinder finder = HokenshaKyufujissekiFinder.createInstance();
        finder.delete給付実績基本(mybatisParam);
        finder.delete給付実績明細(mybatisParam);
        finder.delete給付実績緊急時施設療養(mybatisParam);
        finder.delete給付実績特定診療費(mybatisParam);
        finder.delete給付実績特定診療費_特別療養費(mybatisParam);
        finder.delete給付実績食事費用(mybatisParam);
        finder.delete給付実績居宅サービス計画費(mybatisParam);
        finder.delete給付実績福祉用具販売費(mybatisParam);
        finder.delete給付実績住宅改修費(mybatisParam);
        finder.delete給付実績集計(mybatisParam);
        finder.delete給付実績特定入所者介護サービス費用(mybatisParam);
        finder.delete給付実績社会福祉法人軽減額(mybatisParam);
        finder.delete給付実績所定疾患施設療養費等(mybatisParam);
        finder.delete給付実績明細_住所地特例(mybatisParam);
    }

    @Override
    protected void afterExecute() {
        HokenshaKyufujissekiFinder finder = HokenshaKyufujissekiFinder.createInstance();
        finder.delete給付実績高額介護サービス費();
    }
}
