/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111AKyufuJissekiH1Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.KyufuJissekiInHenkyakuH1DataEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekiin.IKyufuJissekiInMasterTorokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuShoriKekkaListInsertManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
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
    private IBatchTableWriter 給付実績H1tableWriter;
    private static final RString 給付実績H1一時_TABLE_NAME = new RString("DbWT111AKyufuJissekiH1");

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
        給付実績H1tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績H1一時_TABLE_NAME, DbWT111AKyufuJissekiH1Entity.class);
    }

    @Override
    protected void process(KyufuJissekiInHenkyakuH1DataEntity entity) {
        DbWT111AKyufuJissekiH1Entity 給付実績H1 = entity.get給付実績H1();
        DbT3017KyufujissekiKihonEntity 給付実績基本 = entity.get給付実績基本();
        DbWT0001HihokenshaTempEntity 被保険者一時 = entity.get被保険者一時();
        if (給付実績H1.getAtoHokenSeikyugaku().equals(給付実績基本.getAtoHokenSeikyugaku())) {
            給付実績基本.setState(EntityDataState.Deleted);
            mapper.delete給付実績基本byPK(給付実績基本);
            給付実績H1.setHokenshaHoyuKyufujissekiJohoSakujoFlag(true);
            給付実績H1.setState(EntityDataState.Modified);
            給付実績H1tableWriter.update(給付実績H1);
        } else {
            do削除対象なし(給付実績H1, 被保険者一時);
        }
    }

    private void do削除対象なし(DbWT111AKyufuJissekiH1Entity 給付実績H1, DbWT0001HihokenshaTempEntity 被保険者一時) {
        DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        処理結果.setエラー区分(KokuhorenJoho_TorikomiErrorKubun.給付実績情報内容不一致.getコード());
        処理結果.set証記載保険者番号(new ShoKisaiHokenshaNo(給付実績H1.getShokisaiHokenshaNo().getColumnValue()));
        処理結果.set被保険者番号(被保険者一時.get登録被保険者番号());
        処理結果.setキー1(給付実績H1.getKokanShikibetsuNo().getColumnValue());
        処理結果.setキー2(給付実績H1.getInputShikibetsuNo().getColumnValue());
        RString サービス提供年月 = 給付実績H1.getServiceTeikyoYM().wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
        処理結果.setキー3(サービス提供年月);
        処理結果.setキー4(給付実績H1.getJigyoshoNo().getColumnValue());
        処理結果.setキー5(給付実績H1.getSeiriNo());
        処理結果.set被保険者カナ氏名(被保険者一時.get宛名カナ名称());
        処理結果.set被保険者氏名(被保険者一時.get宛名名称());
        処理結果.set備考(RString.EMPTY);
        KokuhorenKyoutsuuShoriKekkaListInsertManager.do一意排他登録(処理結果);
    }

}
