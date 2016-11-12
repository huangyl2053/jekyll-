/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_TaishoNengetsu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.RiyojokyoTokeihyoMeisaiListProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1512JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス提供年月単位ごとのデータ登録のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class ServiceTeikyoYMSakuseiProcess extends BatchProcessBase<DbWT1512JukyushaDaichoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select抽出範囲外データ");

    private static final RString TABLE_受給者台帳一時 = new RString("DbWT1512JukyushaDaicho");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 受給者台帳一時TBL;
    private RiyojokyoTokeihyoMeisaiListProcessParameter parameter;
    FlexibleYearMonth 開始年月;
    FlexibleYearMonth 終了年月;

    FlexibleYearMonth 基準サービス提供年月;
    FlexibleYearMonth 分割終了年月;
    HihokenshaNo 前回被保険者番号;
    RString 前回要介護認定状態区分コード;
    DbWT1512JukyushaDaichoEntity tempEntity;

    @Override
    protected void initialize() {
        if (Tokeihyo_TaishoNengetsu.サービス提供年月.getコード().equals(parameter.get対象年月())) {
            開始年月 = parameter.get開始年月();
            終了年月 = parameter.get終了年月();
        } else {
            IRiyoJokyoTokeihyoMeisaiListSakuseiMapper mapper = getMapper(IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.class);
            開始年月 = mapper.selectMinサービス提供年月();
            終了年月 = mapper.selectMaxサービス提供年月();
        }
        前回被保険者番号 = HihokenshaNo.EMPTY;
        基準サービス提供年月 = FlexibleYearMonth.EMPTY;
        分割終了年月 = FlexibleYearMonth.EMPTY;
        前回要介護認定状態区分コード = RString.EMPTY;
        tempEntity = null;
    }

    @Override
    protected void createWriter() {
        受給者台帳一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_受給者台帳一時,
                DbWT1512JukyushaDaichoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbWT1512JukyushaDaichoEntity entity) {

        if (tempEntity == null) {
            insertサービス提供年月単位(entity.clone(), 開始年月);
        } else if (!前回被保険者番号.equals(entity.getHihokenshaNo())) {
            insertサービス提供年月単位(tempEntity, 基準サービス提供年月);
            insertサービス提供年月単位(entity.clone(), 基準サービス提供年月);
        } else if (基準サービス提供年月.compareTo(entity.getNinteiYukoKikanKaishiYM()) != 0) {
            insertサービス提供年月単位(tempEntity, 基準サービス提供年月);
            insertサービス提供年月単位(entity.clone(), 基準サービス提供年月);
        } else if (0 <= 前回要介護認定状態区分コード.compareTo(entity.getYokaigoJotaiKubunCode().value())) {
            insertサービス提供年月単位(tempEntity, 基準サービス提供年月);
        }
        if (!前回被保険者番号.equals(entity.getHihokenshaNo())) {
            基準サービス提供年月 = 開始年月;
        }
        if (entity.getNinteiYukoKikanShuryoYM().isBeforeOrEquals(終了年月)) {
            分割終了年月 = entity.getNinteiYukoKikanShuryoYM();
        } else {
            分割終了年月 = 終了年月;
        }
        int count = 分割終了年月.getBetweenMonths(基準サービス提供年月);
        if (0 < count) {
            基準サービス提供年月 = 基準サービス提供年月.plusMonth(1);
        }
        for (int i = 1; i <= count - 1; i++) {
            insertサービス提供年月単位(entity.clone(), 基準サービス提供年月);
            基準サービス提供年月 = 基準サービス提供年月.plusMonth(1);
        }
        tempEntity = entity.clone();
        //      tempEntity.setServiceTeikyoYM(基準サービス提供年月);
        前回要介護認定状態区分コード = entity.getYokaigoJotaiKubunCode().value();
        前回被保険者番号 = entity.getHihokenshaNo();

    }

    @Override
    protected void afterExecute() {
        if (tempEntity != null) {
            insertサービス提供年月単位(tempEntity, 基準サービス提供年月);
        }
    }

    private void insertサービス提供年月単位(DbWT1512JukyushaDaichoEntity entity, FlexibleYearMonth サービス提供年月) {
        entity.setServiceTeikyoYM(サービス提供年月);
        受給者台帳一時TBL.insert(entity);
    }
}
