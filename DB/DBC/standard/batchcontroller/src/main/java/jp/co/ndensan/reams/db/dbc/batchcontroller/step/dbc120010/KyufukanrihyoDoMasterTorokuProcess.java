/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoin.KyufukanrihyoDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin.HihokenshaKyufukanrihyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufukanrihyoin.IKyufukanrihyoInMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 公費負担者分・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
public class KyufukanrihyoDoMasterTorokuProcess extends BatchProcessBase<HihokenshaKyufukanrihyoEntity> {

    private IKyufukanrihyoInMapper mapper;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufukanrihyoin.IKyufukanrihyoInMapper.get給付管理票一時と被保険者一時のデータ");

    private static final RString 交換情報識別番号_平成18年3月以前 = new RString("1121");
    private static final RString 交換情報識別番号_平成18年4月以降 = new RString("1122");

    private KyufukanrihyoDoMasterTorokuProcessParameter parameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付管理票200004tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付管理票200604tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付管理票200004tableWriter
                = new BatchEntityCreatedTempTableWriter(DbT3014KyufuKanrihyo200004Entity.TABLE_NAME,
                        DbT3014KyufuKanrihyo200004Entity.class);
        給付管理票200604tableWriter
                = new BatchEntityCreatedTempTableWriter(DbT3015KyufuKanrihyo200604Entity.TABLE_NAME,
                        DbT3015KyufuKanrihyo200604Entity.class);
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKyufukanrihyoInMapper.class);
        if (SaiShoriKubun.再処理.equals(parameter.get再処理区分())) {
            mapper.do給付管理票200004TBL処理済のデータの削除();
            mapper.do給付管理票200604TBL処理済のデータの削除();
        }
    }

    @Override
    protected void process(HihokenshaKyufukanrihyoEntity entity) {
        if (交換情報識別番号_平成18年3月以前.equals(entity.get給付管理票().get交換情報識別番号())) {
            do給付管理票200004に登録する(entity.get被保険者(), entity.get給付管理票());
        } else if (交換情報識別番号_平成18年4月以降.equals(entity.get給付管理票().get交換情報識別番号())) {
            do給付管理票200604に登録する(entity.get被保険者(), entity.get給付管理票());
        }
    }

    private void do給付管理票200004に登録する(DbWT0001HihokenshaTempEntity 被保険者,
            DbWT1121KyufuKanrihyoTempEntity 給付管理票) {
        DbT3014KyufuKanrihyo200004Entity entity = new DbT3014KyufuKanrihyo200004Entity();
        entity.setShinsaYM(給付管理票.get審査年月());
        entity.setServiceTeikyoYM(給付管理票.getサービス提供年月());
        entity.setHiHokenshaNo(被保険者.get登録被保険者番号());
        entity.setKyufuKanrihyoShubetsuKubunCode(給付管理票.get給付管理票種別区分コード());
        entity.setKyufuKanrihyoMeisaiLineNo(給付管理票.get給付管理票明細行番号());
        if (null != 被保険者.get証記載保険者番号()) {
            entity.setShokisaiHokenshaNo(new HokenshaNo(被保険者.get証記載保険者番号().getColumnValue()));
        }
        if (!RString.isNullOrEmpty(給付管理票.get居宅支援事業所番号())) {
            entity.setKyotakushienJigyoshoNo(new JigyoshaNo(給付管理票.get居宅支援事業所番号()));
        }
        entity.setKyufuKanrihyoSakuseiKubunCode(給付管理票.get給付管理票情報作成区分コード());
        entity.setKyufuKanrihyoSakuseiYMD(給付管理票.get給付管理票作成年月日());
        if (!RString.isNullOrEmpty(給付管理票.get保険者番号())) {
            entity.setHokenshaNo(new HokenshaNo(給付管理票.get保険者番号()));
        }
        entity.setHiHokenshaUmareYMD(給付管理票.get被保険者生年月日());
        entity.setSeibetsuCode(給付管理票.get性別コード());
        entity.setYoKaigoJotaiKubunCode(給付管理票.get要介護状態区分コード());
        entity.setGendogakuTekiyoKaishiYM(給付管理票.get限度額適用開始年月());
        entity.setGendogakuTekiyoShuryoYM(給付管理票.get限度額適用終了年月());
        entity.setKyotakuKaigoYoboShikyuGendogaku(給付管理票.get居宅_介護予防支給限度額());
        entity.setKyotakuServicePlanSakuseiKubunCode(給付管理票.get居宅サービス計画作成区分コード());
        if (!RString.isNullOrEmpty(給付管理票.getサービス事業所番号())) {
            entity.setServiceJigyoshoNo(new JigyoshaNo(給付管理票.getサービス事業所番号()));
        }
        entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(給付管理票.get指定_基準該当_地域密着型サービス識別コード());
        if (!RString.isNullOrEmpty(給付管理票.getサービス種類コード())) {
            entity.setServiceShuruiCode(new ServiceShuruiCode(給付管理票.getサービス種類コード()));
        }
        entity.setKyufuKeikakuTanisuNissu(給付管理票.get給付計画単位数_日数());
        entity.setKyufuKeikakuNissu(給付管理票.get限度額管理期間における前月までの給付計画日数());
        entity.setShiteiServiceSubTotal(給付管理票.get指定サービス分小計());
        entity.setKijyunGaitoServiceSubTotal(給付管理票.get基準該当サービス分小計());
        entity.setKyufuKeikakuTotalTanisuNissu(給付管理票.get給付計画合計単位数_日数());
        entity.setToshoTorokuYMD(給付管理票.get当初登録年月日());
        entity.setTorikomiYM(給付管理票.get取込年月());
        給付管理票200004tableWriter.insert(entity);

    }

    private void do給付管理票200604に登録する(DbWT0001HihokenshaTempEntity 被保険者,
            DbWT1121KyufuKanrihyoTempEntity 給付管理票) {
        DbT3015KyufuKanrihyo200604Entity entity = new DbT3015KyufuKanrihyo200604Entity();
        entity.setShinsaYM(給付管理票.get審査年月());
        entity.setServiceTeikyoYM(給付管理票.getサービス提供年月());
        entity.setHiHokenshaNo(被保険者.get登録被保険者番号());
        entity.setKyufuShubetsuKubunCode(給付管理票.get給付管理票種別区分コード());
        entity.setKyufuMeisaiLineNo(給付管理票.get給付管理票明細行番号());

        if (null != 被保険者.get証記載保険者番号()) {
            entity.setShokisaiHokenshaNo(new HokenshaNo(被保険者.get証記載保険者番号().getColumnValue()));
        }
        if (!RString.isNullOrEmpty(給付管理票.get居宅支援事業所番号())) {
            entity.setKyotakushienJigyoshoNo(new JigyoshaNo(給付管理票.get居宅支援事業所番号()));
        }
        entity.setKyufuSakuseiKubunCode(給付管理票.get給付管理票情報作成区分コード());
        entity.setKyufuSakuseiYMD(給付管理票.get給付管理票作成年月日());
        if (!RString.isNullOrEmpty(給付管理票.get保険者番号())) {
            entity.setHokenshaNo(new HokenshaNo(給付管理票.get保険者番号()));
        }

        entity.setHiHokenshaUmareYMD(給付管理票.get被保険者生年月日());
        entity.setSeibetsuCode(給付管理票.get性別コード());
        entity.setYoKaigoJotaiKubunCode(給付管理票.get要介護状態区分コード());
        entity.setGendogakuTekiyoKaishiYM(給付管理票.get限度額適用開始年月());
        entity.setGendogakuTekiyoShuryoYM(給付管理票.get限度額適用終了年月());

        if (null != 給付管理票.get居宅_介護予防支給限度額()) {
            entity.setKyotakuKaigoYoboShikyuGendogaku(給付管理票.get居宅_介護予防支給限度額().intValue());
        }
        entity.setKyotakuServicePlanSakuseiKubunCode(給付管理票.get居宅サービス計画作成区分コード());
        if (!RString.isNullOrEmpty(給付管理票.getサービス事業所番号())) {
            entity.setServiceJigyoshoNo(new JigyoshaNo(給付管理票.getサービス事業所番号()));
        }
        entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(給付管理票.get指定_基準該当_地域密着型サービス識別コード());
        if (!RString.isNullOrEmpty(給付管理票.getサービス種類コード())) {
            entity.setServiceShuruiCode(new ServiceShuruiCode(給付管理票.getサービス種類コード()));
        }

        if (null != 給付管理票.get給付計画単位数_日数()) {
            entity.setKyufuKeikakuTanisuNissu(給付管理票.get給付計画単位数_日数().intValue());
        }
        if (null != 給付管理票.get限度額管理期間における前月までの給付計画日数()) {
            entity.setKyufuKeikakuNissu(給付管理票.get限度額管理期間における前月までの給付計画日数().intValue());
        }
        if (null != 給付管理票.get指定サービス分小計()) {
            entity.setShiteiServiceSubTotal(給付管理票.get指定サービス分小計().intValue());
        }
        if (null != 給付管理票.get基準該当サービス分小計()) {
            entity.setKijyunGaitoServiceSubTotal(給付管理票.get基準該当サービス分小計().intValue());
        }
        if (null != 給付管理票.get給付計画合計単位数_日数()) {
            entity.setKyufuKeikakuTotalTanisuNissu(給付管理票.get給付計画合計単位数_日数().intValue());
        }

        entity.setTantoKaigoShienSemmoninNo(給付管理票.get担当介護支援専門員番号());
        if (null != 給付管理票.get委託先の居宅介護支援事業所番号()) {
            entity.setKaigoShienJigyoshaNo(new JigyoshaNo(給付管理票.get委託先の居宅介護支援事業所番号()));
        }
        entity.setItakusakiTantoKaigoShienSemmoninNo(給付管理票.get委託先の担当介護支援専門員番号());
        entity.setToshoTorokuYMD(給付管理票.get当初登録年月日());
        entity.setTorikomiYM(給付管理票.get取込年月());
        給付管理票200604tableWriter.insert(entity);
    }

}
