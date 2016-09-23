/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110040;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.DbWT3411KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiGetSoufuDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額サービス費給付判定結果情報作成・送付対象データ取得を実行する。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
public class KogakuServicehiHanteiGetSoufuDataProcess extends BatchProcessBase<KogakuServicehiHanteiGetSoufuDataEntity> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_OUTPUTCOUNT;

    static {
        PARAMETER_OUT_OUTPUTCOUNT = new RString("outputCount");
    }

    private OutputParameter<Integer> outputCount;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakuservicehihanteikekkaout.IKogakuServicehiHanteikekkaOutJohoMapper.select送付対象データリスト");
    private KogakuServicehiHanteiProcessParameter parameter;
    private KogakuServicehiHanteiMybatisParameter mybatisParameter;
    private int 連番;
    private static final Integer INDEX_0 = 0;
    private static final RString エラー区分_送付対象なし = new RString("01");

    @BatchWriter
    private IBatchTableWriter 被保険者一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 高額介護サービス費支給一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString 高額介護サービス費支給一時_TABLE_NAME = new RString("DbWT3411KogakuShikyuShinsei");

    @Override
    protected void initialize() {
        outputCount = new OutputParameter<>();
        mybatisParameter = new KogakuServicehiHanteiMybatisParameter();
        mybatisParameter.set再処理区分(parameter.get再処理区分());
        mybatisParameter.set処理年月(parameter.get処理年月());
        連番 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT1001HihokenshaEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT1002KokuhorenSakuseiErrorTempEntity.class);
        高額介護サービス費支給一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額介護サービス費支給一時_TABLE_NAME, DbWT3411KogakuShikyuShinseiEntity.class);
    }

    @Override
    protected void process(KogakuServicehiHanteiGetSoufuDataEntity entity) {
        連番 = 連番 + 1;
        insert高額介護サービス費支給一時TBL(entity);
        insert被保険者一時TBL(entity);
    }

    @Override
    protected void afterExecute() {

        if (連番 == INDEX_0) {
            DbWT1002KokuhorenSakuseiErrorTempEntity errorTempentity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
            errorTempentity.setErrorKubun(エラー区分_送付対象なし);
            errorTempentity.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
            errorTempentity.setHihokenshaNo(HihokenshaNo.EMPTY);
            errorTempentity.setKey1(RString.EMPTY);
            errorTempentity.setKey2(RString.EMPTY);
            errorTempentity.setKey3(RString.EMPTY);
            errorTempentity.setKey4(RString.EMPTY);
            errorTempentity.setKey5(RString.EMPTY);
            errorTempentity.setHihokenshaKanaShimei(RString.EMPTY);
            errorTempentity.setHihokenshaShimei(RString.EMPTY);
            errorTempentity.setBiko(RString.EMPTY);
            errorTempentity.setState(EntityDataState.Added);
            処理結果リスト一時tableWriter.insert(errorTempentity);
        }
        outputCount.setValue(連番);
    }

    private void insert高額介護サービス費支給一時TBL(KogakuServicehiHanteiGetSoufuDataEntity entity) {
        DbT3056KogakuShikyuShinseiEntity 支給申請 = entity.get支給申請();
        DbT3057KogakuShikyuHanteiKekkaEntity 支給判定結果 = entity.get支給判定結果();
        DbWT3411KogakuShikyuShinseiEntity 高額介護サービス費支給 = new DbWT3411KogakuShikyuShinseiEntity();
        高額介護サービス費支給.setRenban(連番);
        高額介護サービス費支給.setHihokenshaNo(支給申請.getHihokenshaNo());
        高額介護サービス費支給.setServiceTeikyoYM(支給申請.getServiceTeikyoYM());
        高額介護サービス費支給.setShoKisaiHokenshaNo(支給申請.getShoKisaiHokenshaNo());
        高額介護サービス費支給.setRirekiNo(支給申請.getRirekiNo());
        高額介護サービス費支給.setUketsukeYMD(支給申請.getUketsukeYMD());
        高額介護サービス費支給.setShinseiYMD(支給申請.getShinseiYMD());
        高額介護サービス費支給.setShinseiRiyu(支給申請.getShinseiRiyu());
        高額介護サービス費支給.setShinseishaKubun(支給申請.getShinseishaKubun());
        高額介護サービス費支給.setShinseishaShimei(支給申請.getShinseishaShimei());
        高額介護サービス費支給.setShinseishaShimeiKana(支給申請.getShinseishaShimeiKana());
        高額介護サービス費支給.setShinseishaJusho(支給申請.getShinseishaJusho());
        高額介護サービス費支給.setShinseishaTelNo(支給申請.getShinseishaTelNo());
        高額介護サービス費支給.setShinseiJigyoshaNo(支給申請.getShinseiJigyoshaNo());
        高額介護サービス費支給.setShiharaiHohoKubunCode(支給申請.getShiharaiHohoKubunCode());
        高額介護サービス費支給.setShiharaiBasho(支給申請.getShiharaiBasho());
        高額介護サービス費支給.setShiharaiKaishiYMD(支給申請.getShiharaiKaishiYMD());
        高額介護サービス費支給.setShiharaiShuryoYMD(支給申請.getShiharaiShuryoYMD());
        高額介護サービス費支給.setHeichoNaiyo(支給申請.getHeichoNaiyo());
        高額介護サービス費支給.setShiharaiKaishiTime(支給申請.getShiharaiKaishiTime());
        高額介護サービス費支給.setShiharaiShuryoTime(支給申請.getShiharaiShuryoTime());
        高額介護サービス費支給.setKozaID(支給申請.getKozaID());
        高額介護サービス費支給.setJuryoininKeiyakuNo(支給申請.getJuryoininKeiyakuNo());
        高額介護サービス費支給.setKetteiYMD(支給判定結果.getKetteiYMD());
        高額介護サービス費支給.setHonninShiharaiGaku(支給判定結果.getHonninShiharaiGaku());
        高額介護サービス費支給.setShikyuKubunCode(支給判定結果.getShikyuKubunCode());
        高額介護サービス費支給.setShikyuKingaku(支給判定結果.getShikyuKingaku());
        高額介護サービス費支給.setFushikyuRiyu(支給判定結果.getFushikyuRiyu());
        高額介護サービス費支給.setShinsaHohoKubun(支給判定結果.getShinsaHohoKubun());
        高額介護サービス費支給.setHanteiKekkaSofuYM(支給判定結果.getHanteiKekkaSofuYM());
        高額介護サービス費支給.setSaiSofuFlag(支給判定結果.getSaiSofuFlag());
        高額介護サービス費支給.setHanteiKekkaSofuFuyoFlag(支給判定結果.getHanteiKekkaSofuFuyoFlag());
        高額介護サービス費支給.setShinsaKekkaHaneiKubun(支給判定結果.getShinsaKekkaHaneiKubun());
        高額介護サービス費支給.setKetteiTsuchishoSakuseiYMD(支給判定結果.getKetteiTsuchishoSakuseiYMD());
        高額介護サービス費支給.setFurikomiMeisaishoSakuseiYMD(支給判定結果.getFurikomiMeisaishoSakuseiYMD());
        高額介護サービス費支給.setHokenshaNo(HokenshaNo.EMPTY);
        高額介護サービス費支給.setHokenshaName(RString.EMPTY);
        高額介護サービス費支給.setSofuJogaiFlag(false);
        高額介護サービス費支給.setState(EntityDataState.Added);
        高額介護サービス費支給一時tableWriter.insert(高額介護サービス費支給);

    }

    private void insert被保険者一時TBL(KogakuServicehiHanteiGetSoufuDataEntity entity) {
        DbT3056KogakuShikyuShinseiEntity 支給申請 = entity.get支給申請();
        DbWT1001HihokenshaEntity 被保険者明細 = new DbWT1001HihokenshaEntity();
        被保険者明細.setExRenban(連番);
        被保険者明細.setExHokenshaNo(HokenshaNo.EMPTY);
        被保険者明細.setExHokenshaName(RString.EMPTY);
        被保険者明細.setExShoHokenshaNo(new ShoKisaiHokenshaNo(支給申請.getShoKisaiHokenshaNo().getColumnValue()));
        被保険者明細.setExHihokenshaNo(支給申請.getHihokenshaNo());
        被保険者明細.setExServiceTeikyoYm(支給申請.getServiceTeikyoYM());
        被保険者明細.setHenkanFlag(false);
        被保険者明細.setOldShichosonCode(LasdecCode.EMPTY);
        被保険者明細.setSofuHihokenshaNo(支給申請.getHihokenshaNo());
        被保険者明細.setShichosonCode(LasdecCode.EMPTY);
        被保険者明細.setKannaiKangaiKubun(RString.EMPTY);
        被保険者明細.setYubinNo(RString.EMPTY);
        被保険者明細.setChoikiCode(RString.EMPTY);
        被保険者明細.setGyoseikuCode(RString.EMPTY);
        被保険者明細.setGyoseikuMei(RString.EMPTY);
        被保険者明細.setJusho(RString.EMPTY);
        被保険者明細.setBanchi(RString.EMPTY);
        被保険者明細.setKatagaki(RString.EMPTY);
        被保険者明細.setKanaMeisho(RString.EMPTY);
        被保険者明細.setMeisho(RString.EMPTY);
        被保険者明細.setShimei50onKana(RString.EMPTY);
        被保険者明細.setShikibetsuCode(ShikibetsuCode.EMPTY);
        被保険者明細.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        被保険者明細.setShikakuShutokuJiyuCode(RString.EMPTY);
        被保険者明細.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        被保険者明細.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        被保険者明細.setSetaiShuyakuNo(RString.EMPTY);
        被保険者明細.setSeinenYmd(FlexibleDate.EMPTY);
        被保険者明細.setSeibetsuCode(RString.EMPTY);
        被保険者明細.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        被保険者明細.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        被保険者明細.setState(EntityDataState.Added);
        被保険者一時tableWriter.insert(被保険者明細);
    }
}
