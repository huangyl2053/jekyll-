/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150040;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.hekinriyogakutokehyo.HekinRiyoGakuTokehyoResult;
import jp.co.ndensan.reams.db.dbc.definition.processprm.heikinriyogakuyokeihyo.HeikinriyogakuTokeihyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.KyufujissekiTempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.ShikakutempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hekinriyogakutokehyo.IHekinRiyoGakuTokehyoMapper;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 平均利用額統計表一時TBL作成のProcessフロークラスです。
 *
 * @reamsid_L DBC-3490-030 yaoyahui
 */
public class HeikinriyogakuTokeihyoProcess extends BatchProcessBase<KyufujissekiTempTblEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hekinriyogakutokehyo.IHekinRiyoGakuTokehyoMapper.get給付実績データ一時");
    private static final RString 給付実績データ一時TBL_NAME = new RString("DbWTkyufujisTempTbl");
    private static final RString 出力用一時TBL_NAME = new RString("DbWShikakutempTbl");
    private static final RString エラー内容1 = new RString("不整合データ：３９歳以下の被保険者です。");
    private static final RString 備考 = new RString("所得段階が取得できません。その他に集計されます。");
    private static final RString 集計処理 = new RString("集計処理");
    private static final int 年齢_39 = 39;
    private static final int 年齢_40 = 40;
    private static final int 年齢_64 = 64;
    private static final int 年齢_65 = 65;
    private static final RString 所得段階_２号 = new RString("２号");
    private boolean 登録フラグ;
    private HeikinriyogakuTokeihyoProcessParameter paramter;
    private IHekinRiyoGakuTokehyoMapper mapper;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績データ一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 出力用一時TBL;

    @Override
    protected void initialize() {
        mapper = getMapper(IHekinRiyoGakuTokehyoMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toHeikinriyogakuTokeihyoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        給付実績データ一時TBL = new BatchEntityCreatedTempTableWriter(給付実績データ一時TBL_NAME,
                KyufujissekiTempTblEntity.class);
        出力用一時TBL = new BatchEntityCreatedTempTableWriter(出力用一時TBL_NAME,
                ShikakutempTblEntity.class);
    }

    @Override
    protected void process(KyufujissekiTempTblEntity entity) {
        HekinRiyoGakuTokehyoResult hekinRiyoGakuTokehyoResult = new HekinRiyoGakuTokehyoResult();
        KyufujissekiTempTblEntity 給付実績データ一時Entity = hekinRiyoGakuTokehyoResult.set給付実績データ一時TBL(entity);
        給付実績データ一時Entity.setShotoku(get所得段階(entity));
        if (!登録フラグ) {
            給付実績データ一時TBL.insert(給付実績データ一時Entity);
        }
    }

    @Override
    protected void afterExecute() {
        HekinRiyoGakuTokehyoResult hekinRiyoGakuTokehyoResult = new HekinRiyoGakuTokehyoResult();
        List<ShikakutempTblEntity> 一時EntityList = hekinRiyoGakuTokehyoResult.set出力用一時TBL();
        for (ShikakutempTblEntity shikakutempTblEntity : 一時EntityList) {
            出力用一時TBL.insert(shikakutempTblEntity);
        }
    }

    private RString get所得段階(KyufujissekiTempTblEntity kyufujissekiTempTblEntity) {
        登録フラグ = false;
        RString 所得段階 = RString.EMPTY;
        AgeCalculator agecounter = new AgeCalculator(DateOfBirthFactory.createInstance(kyufujissekiTempTblEntity.getUmareYMD()),
                JuminJotai.住民,
                FlexibleDate.EMPTY,
                DateRoundingType.次月の暦上日,
                AgeArrivalDay.前日,
                new FlexibleDate(kyufujissekiTempTblEntity.getServiceTeikyoYM().toString()));
        RString 年齢 = agecounter.get年齢();
        int age = Integer.valueOf(年齢.toString());
        if (年齢_39 >= age) {
            登録フラグ = true;
            SyorikekkatempTblEntity entity = new SyorikekkatempTblEntity();
            entity.setErrorkubun(集計処理);
            entity.setHiHokenshaNo(kyufujissekiTempTblEntity.getHiHokenshaNo());
            entity.setKi1(kyufujissekiTempTblEntity.getServiceTeikyoYM());
            entity.setKi2(kyufujissekiTempTblEntity.getUmareYMD());
            entity.setKi3(RString.EMPTY);
            entity.setKi4(RString.EMPTY);
            entity.setKi5(RString.EMPTY);
            entity.setErrornaiyo(エラー内容1);
            entity.setBiko(備考);
            mapper.insert処理結果リスト一時TBL(entity);
        } else if (年齢_40 < age && age < 年齢_64) {
            所得段階 = 所得段階_２号;
        } else if (年齢_65 <= age) {
            所得段階 = RString.EMPTY;
        }
        return 所得段階;
    }
}
