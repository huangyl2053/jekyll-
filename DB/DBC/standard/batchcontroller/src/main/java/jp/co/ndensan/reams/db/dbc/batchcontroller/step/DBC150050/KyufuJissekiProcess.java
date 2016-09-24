/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran.KyufuJissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.ServiceMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 「給付実績基本情報」と「給付実績居宅サービス計画費情報」のデータを取得して、マッチング処理Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class KyufuJissekiProcess
        extends BatchProcessBase<ServiceMeisaiEntity> {

    /**
     * 登録結果返した
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;
    private KyufuJissekiProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.get給付実績情報");
    @BatchWriter
    BatchEntityCreatedTempTableWriter サービス明細一時tableWriter;
    private static final RString サービス明細一時_TABLE_NAME = new RString("DbWT3470ServiceMeisai");

    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;
    private int 連番;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    @Override
    protected void initialize() {
        returnEntity = new FlowEntity();
        連番 = INT_0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        サービス明細一時tableWriter = new BatchEntityCreatedTempTableWriter(
                サービス明細一時_TABLE_NAME, DbWT3470ServiceMeisaiTempEntity.class);
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
        serviceMeisaiTempEntity.setAtoKohi1TaishoNissuKaisu(Decimal.ZERO);
        serviceMeisaiTempEntity.setAtoKohi2TaishoNissukaisu(Decimal.ZERO);
        serviceMeisaiTempEntity.setAtoKohi3TaishoNissuKaisu(Decimal.ZERO);
        serviceMeisaiTempEntity.setAtoServiceTanisu(getDecimalVaule(entity.get後_サービス単位数()));
        serviceMeisaiTempEntity.setAtoKohi1TaishoServiceTanisu(Decimal.ZERO);
        serviceMeisaiTempEntity.setAtoKohi2TaishoServiceTanisu(Decimal.ZERO);
        serviceMeisaiTempEntity.setAtoKohi3TaishoServiceTanisu(Decimal.ZERO);
        serviceMeisaiTempEntity.setSaishinsaKaisu(getDecimalVaule(entity.get再審査回数()));
        serviceMeisaiTempEntity.setKagoKaisu(getDecimalVaule(entity.get過誤回数()));
        serviceMeisaiTempEntity.setShinsaYM(entity.get審査年月());
        サービス明細一時tableWriter.insert(serviceMeisaiTempEntity);
    }

    @Override
    protected void afterExecute() {
        returnEntity.set明細データ登録件数(連番);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private Decimal getDecimalVaule(Decimal 値) {
        if (null != 値) {
            return 値;
        }
        return Decimal.ZERO;
    }

}
