/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaAtenaEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 被保険者・宛名情報取得Process クラスです
 *
 * @reamsid_L DBC-2460-013 jiangwenkai
 */
public class HokenshaKyufujissekiOutGetHihokenshaAtenaProcess extends BatchProcessBase<HokenshaKyufujissekiOutGetHihokenshaAtenaEntity> {

    /**
     * 被保険者・宛名情報取得の取得後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;
    private static final RString TABLE_NAME = new RString("DbWT1001Hihokensha");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout."
            + "IHokenshaKyufujissekiOutMapper.select被保険者_宛名");
    private static final RString 広域内住所地特例フラグ_1 = new RString("1");
    private static int numble = 0;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter dbWT0001TableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        returnEntity = new FlowEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.dbWT0001TableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, DbWT1001HihokenshaTempEntity.class);

    }

    @Override
    protected void process(HokenshaKyufujissekiOutGetHihokenshaAtenaEntity entity) {
        DbWT1001HihokenshaTempEntity dbWT1001 = this.set被保険者一時TBL(entity);
        dbWT0001TableWriter.update(dbWT1001);
        numble++;
    }

    @Override
    protected void afterExecute() {
        returnEntity.setCodeNum(numble);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);

    }

    private DbWT1001HihokenshaTempEntity set被保険者一時TBL(HokenshaKyufujissekiOutGetHihokenshaAtenaEntity entity) {
        IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.createKojin(entity.getUaFt200Entity());
        DbV1001HihokenshaDaichoEntity dbV1001 = entity.getDbV1001Entity();
        DbWT1001HihokenshaTempEntity dbWT1001 = entity.getDbWT1001Entity();
        if (広域内住所地特例フラグ_1.equals(dbV1001.getKoikinaiJushochiTokureiFlag())) {
            dbWT1001.setShichosonCode(dbV1001.getKoikinaiTokureiSochimotoShichosonCode());
        } else {
            dbWT1001.setShichosonCode(dbV1001.getShichosonCode());
        }
        dbWT1001.setKannaiKangaiKubun(識別対象.get住所().get管内管外().toRString());
        dbWT1001.setYubinNo(識別対象.get住所().get郵便番号().getYubinNo());
        dbWT1001.setChoikiCode(getColumnValue(識別対象.get住所().get町域コード()));
        dbWT1001.setGyoseikuCode(getColumnValue(識別対象.get行政区画().getGyoseiku().getコード()));
        dbWT1001.setGyoseikuMei(識別対象.get行政区画().getGyoseiku().get名称());
        dbWT1001.setJusho(識別対象.get住所().get住所());
        dbWT1001.setBanchi(getColumnValue(識別対象.get住所().get番地().getBanchi()));
        dbWT1001.setKatagaki(getColumnValue(識別対象.get住所().get方書()));
        dbWT1001.setKanaMeisho(getColumnValue(識別対象.get名称().getKana()));
        dbWT1001.setMeisho(getColumnValue(識別対象.get名称().getName()));
        dbWT1001.setShimei50onKana(RStringUtil.convertTo清音化(getColumnValue(識別対象.get名称().getKana())));
        dbWT1001.setShikibetsuCode(識別対象.get識別コード());
        dbWT1001.setShikakuShutokuYmd(dbV1001.getShikakuShutokuYMD());
        dbWT1001.setShikakuShutokuJiyuCode(dbV1001.getShikakuShutokuJiyuCode());
        dbWT1001.setShikakuSoshitsuYmd(dbV1001.getShikakuSoshitsuYMD());
        dbWT1001.setShikakuSoshitsuJiyuCode(dbV1001.getShikakuSoshitsuJiyuCode());
        if (null != 識別対象.to個人()) {
            dbWT1001.setSeinenYmd((識別対象.to個人().get生年月日().toFlexibleDate()));
            dbWT1001.setSeibetsuCode(識別対象.to個人().get性別().getCode());
        } else {
            dbWT1001.setSeinenYmd((FlexibleDate.EMPTY));
            dbWT1001.setSeibetsuCode(RString.EMPTY);
        }
        return dbWT1001;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
