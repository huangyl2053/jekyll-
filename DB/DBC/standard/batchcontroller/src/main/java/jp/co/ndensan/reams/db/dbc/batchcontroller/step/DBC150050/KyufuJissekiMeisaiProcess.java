/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran.KyufuJissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470shoriKekkaListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.ServiceMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 「給付実績基本情報」より「給付実績明細情報」のデータを取得して、マッチング処理Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class KyufuJissekiMeisaiProcess
        extends BatchProcessBase<ServiceMeisaiEntity> {

    private KyufuJissekiProcessParameter parameter;

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.get給付実績明細情報");
    @BatchWriter
    BatchEntityCreatedTempTableWriter サービス明細一時tableWriter;
    private static final RString サービス明細一時_TABLE_NAME = new RString("DbWT3470ServiceMeisai");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT3470shoriKekkaList");

    private int 連番;
    private static final int INT_1 = 1;
    private static final RString NUM = new RString("99");
    private static final int INT_0 = 0;

    @Override
    protected void initialize() {
        連番 = parameter.get連番();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        サービス明細一時tableWriter = new BatchEntityCreatedTempTableWriter(
                サービス明細一時_TABLE_NAME, DbWT3470ServiceMeisaiTempEntity.class);
        処理結果リスト一時tableWriter = new BatchEntityCreatedTempTableWriter(
                処理結果リスト一時_TABLE_NAME, DbWT3470shoriKekkaListTempEntity.class);
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void process(ServiceMeisaiEntity entity) {
        連番 = 連番 + INT_1;
        DbWT3470ServiceMeisaiTempEntity serviceMeisaiTempEntity = new DbWT3470ServiceMeisaiTempEntity();
        serviceMeisaiTempEntity.setRenban(連番);
        serviceMeisaiTempEntity.setInputShikibetsuNo(entity.get入力識別番号());
        serviceMeisaiTempEntity.setKyufuSakuseiKubunCode(entity.get給付実績情報作成区分コード());
        serviceMeisaiTempEntity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
        serviceMeisaiTempEntity.setShokisaiHokenshaName(RString.EMPTY);
        serviceMeisaiTempEntity.setHiHokenshaNo(entity.get被保険者番号());
        serviceMeisaiTempEntity.setServiceTeikyoYM(entity.getサービス提供年月());
        serviceMeisaiTempEntity.setKyufuJissekiKubunCode(entity.get給付実績区分コード());
        serviceMeisaiTempEntity.setJigyoshoNo(entity.get事業所番号());
        serviceMeisaiTempEntity.setJigyoshoName(RString.EMPTY);
        serviceMeisaiTempEntity.setYoKaigoJotaiKubunCode(entity.get要介護状態区分コード());
        serviceMeisaiTempEntity.setKyuSochiNyushoshaTokureiCode(entity.get旧措置入所者特例コード());
        serviceMeisaiTempEntity.setNinteiYukoKaishiYMD(entity.get認定有効期間_開始年月日());
        serviceMeisaiTempEntity.setNinteiYukoShuryoYMD(entity.get認定有効期間_終了年月日());
        serviceMeisaiTempEntity.setRojinHokenShichosonNo(entity.get老人保健市町村番号());
        serviceMeisaiTempEntity.setRojinhokenJukyushaNo(entity.get老人保健受給者番号());
        serviceMeisaiTempEntity.setKyotakuServiceSakuseiKubunCode(entity.get居宅サービス計画作成区分コード());
        serviceMeisaiTempEntity.setSakujigyoshoNo(entity.get計画事業所番号());
        serviceMeisaiTempEntity.setSakujigyoshoName(RString.EMPTY);
        serviceMeisaiTempEntity.setNyushoYMD(entity.get入所院年月日());
        serviceMeisaiTempEntity.setTaishoYMD(entity.get退所院年月日());
        serviceMeisaiTempEntity.setNyushoJitsunissu(getDecimalVaule(entity.get入所院実日数()));
        serviceMeisaiTempEntity.setHokenKyufuritsu(getDecimalVaule(entity.get保険給付率()));
        serviceMeisaiTempEntity.setKohi1Kyufuritsu(getDecimalVaule(entity.get公費１給付率()));
        serviceMeisaiTempEntity.setKohi2Kyufuritsu(getDecimalVaule(entity.get公費２給付率()));
        serviceMeisaiTempEntity.setKohi3Kyufuritsu(getDecimalVaule(entity.get公費３給付率()));
        serviceMeisaiTempEntity.setKokiHokenshaNo(entity.get保険者番号_後期());
        serviceMeisaiTempEntity.setKokiHiHokenshaNo(entity.get被保険者番号_後期());
        serviceMeisaiTempEntity.setKokuhoHokenshaNo(entity.get保険者番号_国保());
        serviceMeisaiTempEntity.setKokuhoHiHokenshashoNo(entity.get被保険者証番号_国保());
        serviceMeisaiTempEntity.setKokuhoKojinNo(entity.get個人番号_国保());
        serviceMeisaiTempEntity.setServiceShuruiCode(entity.getサービス種類コード());
        serviceMeisaiTempEntity.setServiceKomokuCode(entity.getサービス項目コード());
        serviceMeisaiTempEntity.setServiceCode(entity.getサービスコード());
        serviceMeisaiTempEntity.setServiceName(RString.EMPTY);
        serviceMeisaiTempEntity.setServiceCodeName(RString.EMPTY);
        serviceMeisaiTempEntity.setAtoTanisu(getDecimalVaule(entity.get後_単位数()));
        serviceMeisaiTempEntity.setAtoNissuKaisu(getDecimalVaule(entity.get後_回数()));
        serviceMeisaiTempEntity.setAtoKohi1TaishoNissuKaisu(entity.get後公費１対象日数回数());
        serviceMeisaiTempEntity.setAtoKohi2TaishoNissukaisu(entity.get後公費２対象日数回数());
        serviceMeisaiTempEntity.setAtoKohi3TaishoNissuKaisu(entity.get後公費３対象日数回数());
        serviceMeisaiTempEntity.setAtoServiceTanisu(getDecimalVaule(entity.get後_サービス単位数()));
        serviceMeisaiTempEntity.setAtoKohi1TaishoServiceTanisu(entity.get後公費１対象サービス単位数());
        serviceMeisaiTempEntity.setAtoKohi2TaishoServiceTanisu(entity.get後公費２対象サービス単位数());
        serviceMeisaiTempEntity.setAtoKohi3TaishoServiceTanisu(entity.get後公費３対象サービス単位数());
        serviceMeisaiTempEntity.setSaishinsaKaisu(getDecimalVaule(entity.get再審査回数()));
        serviceMeisaiTempEntity.setKagoKaisu(getDecimalVaule(entity.get過誤回数()));
        serviceMeisaiTempEntity.setShinsaYM(entity.get審査年月());
        サービス明細一時tableWriter.insert(serviceMeisaiTempEntity);
    }

    @Override
    protected void afterExecute() {
        if (INT_0 == 連番) {
            DbWT3470shoriKekkaListTempEntity エラー結果 = new DbWT3470shoriKekkaListTempEntity();
            エラー結果.setErrorKubun(NUM);
            エラー結果.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
            エラー結果.setHihokenshaNo(HihokenshaNo.EMPTY);
            エラー結果.setKey1(parameter.get開始年月());
            エラー結果.setKey2(parameter.get終了年月());
            RString 対象サービス種類 = new RString("");
            for (RString code : parameter.getサービス種類コードリスト()) {
                対象サービス種類.concat(code != null ? code : RString.EMPTY);
            }
            エラー結果.setKey3(対象サービス種類);
            エラー結果.setKey4(parameter.get地区指定());
            エラー結果.setKey5(parameter.get市町村コード());
            エラー結果.setHihokenshaKanaShimei(RString.EMPTY);
            エラー結果.setHihokenshaShimei(RString.EMPTY);
            エラー結果.setBiko(RString.EMPTY);
            処理結果リスト一時tableWriter.insert(エラー結果);
        }
    }

    private Decimal getDecimalVaule(Decimal 値) {
        if (null != 値) {
            return 値;
        }
        return Decimal.ZERO;
    }

}
