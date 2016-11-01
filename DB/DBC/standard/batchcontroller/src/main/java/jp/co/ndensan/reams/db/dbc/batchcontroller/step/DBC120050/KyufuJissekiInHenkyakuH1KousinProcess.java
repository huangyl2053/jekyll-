/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120050.KyufuJissekiInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111AKyufuJissekiH1Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.KyufuJissekiInHenkyakuH1DataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekiin.IKyufuJissekiInMasterTorokuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 返却データ削除・給付実績H1の新規、修正データの場合。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInHenkyakuH1KousinProcess extends BatchProcessBase<KyufuJissekiInHenkyakuH1DataEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufujissekiin.IKyufuJissekiInMasterTorokuMapper.select給付実績H1の新規修正データ");
    private IKyufuJissekiInMasterTorokuMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter 給付実績基本tableWriter;
    @BatchWriter
    private IBatchTableWriter 給付実績H1tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    private static final RString 給付実績H1一時_TABLE_NAME = new RString("DbWT111AKyufuJissekiH1");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 給付実績明細TBL名 = new RString("DbT3018KyufujissekiMeisai");
    private static final RString 給付実績緊急時施設療養TBL名 = new RString("DbT3019KyufujissekiKinkyuShisetsuRyoyo");
    private static final RString 給付実績特定診療費TBL名 = new RString("DbT3020KyufujissekiTokuteiSinryohi");
    private static final RString 給付実績特定診療費特別療養費TBL名 = new RString("DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo");
    private static final RString 給付実績食事費用TBL名 = new RString("DbT3022KyufujissekiShokujiHiyo");
    private static final RString 給付実績居宅サービス計画費TBL名 = new RString("DbT3025KyufujissekiKyotakuService");
    private static final RString 給付実績福祉用具販売費TBL名 = new RString("DbT3026KyufujissekiFukushiYoguHanbaihi");
    private static final RString 給付実績住宅改修費TBL名 = new RString("DbT3027KyufujissekiJutakuKaishuhi");
    private static final RString 給付実績特定入所者介護サービス費用TBL名 = new RString("DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyo");
    private static final RString 給付実績社会福祉法人軽減額TBL名 = new RString("DbT3030KyufuJissekiShakaiFukushiHojinKeigengaku");
    private static final RString 給付実績ケアマネジメント費TBL名 = new RString("DbT3031KyufuJissekiCareManagementHi");
    private static final RString 給付実績所定疾患施設療養費等TBL名 = new RString("DbT3032KyufujissekiShoteiShikkanShisetsuRyoyo");
    private static final RString 給付実績明細住所地特例TBL名 = new RString("DbT3106KyufujissekiMeisaiJushochiTokurei");
    private static final RString 給付実績集計TBL名 = new RString("DbT3033KyufujissekiShukei");

    @Override
    protected void initialize() {
        mapper = getMapper(IKyufuJissekiInMasterTorokuMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付実績基本tableWriter
                = new BatchPermanentTableWriter(DbT3017KyufujissekiKihonEntity.class);
        給付実績H1tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績H1一時_TABLE_NAME, DbWT111AKyufuJissekiH1Entity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(KyufuJissekiInHenkyakuH1DataEntity entity) {
        DbWT111AKyufuJissekiH1Entity 給付実績H1 = entity.get給付実績H1();
        DbT3017KyufujissekiKihonEntity 給付実績基本 = entity.get給付実績基本();
        DbWT0001HihokenshaTempEntity 被保険者一時 = entity.get被保険者一時();
        if (給付実績H1.getAtoHokenSeikyugaku().equals(給付実績基本.getAtoHokenSeikyugaku())) {
            給付実績基本.setState(EntityDataState.Deleted);
            給付実績基本tableWriter.delete(給付実績基本);

            給付実績H1.setHokenshaHoyuKyufujissekiJohoSakujoFlag(true);
            給付実績H1.setState(EntityDataState.Modified);
            給付実績H1tableWriter.update(給付実績H1);

        } else {
            do削除対象なし(給付実績H1, 被保険者一時);
        }
    }

    @Override
    protected void afterExecute() {
        KyufuJissekiInMybatisParameter parameter = new KyufuJissekiInMybatisParameter();
        parameter.set表名(給付実績明細TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績緊急時施設療養TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績特定診療費TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績特定診療費特別療養費TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績食事費用TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績居宅サービス計画費TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績福祉用具販売費TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績住宅改修費TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績特定入所者介護サービス費用TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績社会福祉法人軽減額TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績ケアマネジメント費TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績所定疾患施設療養費等TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績明細住所地特例TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        parameter.set表名(給付実績集計TBL名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
    }

    private void do削除対象なし(DbWT111AKyufuJissekiH1Entity 給付実績H1, DbWT0001HihokenshaTempEntity 被保険者一時) {
        DbWT0002KokuhorenTorikomiErrorEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorEntity();
        処理結果.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.給付実績情報内容不一致.getコード());
        処理結果.setShoHokanehshaNo(new ShoKisaiHokenshaNo(給付実績H1.getShokisaiHokenshaNo().getColumnValue()));
        処理結果.setHihokenshaNo(被保険者一時.get登録被保険者番号());
        処理結果.setKey1(給付実績H1.getKokanShikibetsuNo().getColumnValue());
        処理結果.setKey2(給付実績H1.getInputShikibetsuNo().getColumnValue());
        RString サービス提供年月 = 給付実績H1.getServiceTeikyoYM().wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
        処理結果.setKey3(サービス提供年月);
        処理結果.setKey4(給付実績H1.getJigyoshoNo().getColumnValue());
        処理結果.setKey5(給付実績H1.getSeiriNo());
        処理結果.setHihokenshaKanaShimei(被保険者一時.get宛名カナ名称());
        処理結果.setHihokenshaShimei(被保険者一時.get宛名名称());
        処理結果.setBiko(RString.EMPTY);
        処理結果リスト一時tableWriter.insert(処理結果);
    }

}
