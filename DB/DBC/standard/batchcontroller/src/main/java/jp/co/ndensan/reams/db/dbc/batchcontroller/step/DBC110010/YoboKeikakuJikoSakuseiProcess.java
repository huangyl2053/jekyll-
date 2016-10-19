/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeikakujikosakuseikanri.KyotakuKeikakuJikosakuseiKanriResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3120YoboKeikakuJikoSakuseiKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.ShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.YoboKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付管理票作成.予防給付計画自己作成情報の取得のクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class YoboKeikakuJikoSakuseiProcess extends BatchProcessBase<YoboKeikakuJikoSakuseiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper.get予防給付計画自己作成情報の取得");
    private static final RString 自己作成管理一時_NAME = new RString("DbWT8211KyotakuKeikakuJikosakuseiKanri");
    private static final RString 被保険者一時TBL_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時TBL_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private KyufukanrihyoOutProcessParameter paramter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 自己作成管理一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;
    private int 連番;
    private long 登録件数;
    private IKyufukanrihyoOutMapper mapper;
    private final int 值零 = 0;
    private final int 值六 = 6;
    private OutputParameter<Integer> outCount;
    /**
     * 送付対象データ取得件数合計です。
     */
    public static final RString PARAMETER_OUT_OUTCOUNT;

    static {
        PARAMETER_OUT_OUTCOUNT = new RString("outCount");
    }

    @Override
    protected void initialize() {
        連番 = paramter.get連番() + 1;
        outCount = new OutputParameter<>();

    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toKyufukanrihyoOutMybatisParameter());

    }

    @Override
    protected void createWriter() {
        自己作成管理一時TBL = new BatchEntityCreatedTempTableWriter(自己作成管理一時_NAME,
                KyotakuKeikakuJikosakuseiKanriTempEntity.class);
        被保険者一時TBL = new BatchEntityCreatedTempTableWriter(被保険者一時TBL_NAME,
                HihokenshaTempEntity.class);
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TBL_NAME,
                KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(YoboKeikakuJikoSakuseiEntity entity) {
        KyotakuKeikakuJikosakuseiKanriResult kyotakuKeikakuResult = new KyotakuKeikakuJikosakuseiKanriResult();

        DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity 予防給付計画自己作成短期利用日数entity = entity.get予防給付計画自己作成短期利用日数entity();
        List<DbT3120YoboKeikakuJikoSakuseiKanriEntity> 予防給付計画自己作成管理entity = entity.get予防給付計画自己作成管理entity();
        for (DbT3120YoboKeikakuJikoSakuseiKanriEntity yoboKeikakuEntity : 予防給付計画自己作成管理entity) {
            自己作成管理一時TBL.insert(kyotakuKeikakuResult.edit居宅給付計画自己作成Entity2(予防給付計画自己作成短期利用日数entity,
                    yoboKeikakuEntity, 連番));
            被保険者一時TBL.insert(kyotakuKeikakuResult.edit被保険entity(予防給付計画自己作成短期利用日数entity, yoboKeikakuEntity, 連番));
            連番++;
        }
    }

    @Override
    protected void afterExecute() {
        mapper = getMapper(IKyufukanrihyoOutMapper.class);
        KyotakuKeikakuJikosakuseiKanriResult kyotakuKeikakuResult = new KyotakuKeikakuJikosakuseiKanriResult();
        if (連番 == 0) {

            登録件数 = 自己作成管理一時TBL.getInsertCount();
            if (登録件数 < 1) {
                処理結果リスト一時TBL.insert(kyotakuKeikakuResult.edit処理結果リスト一時TBL());
            }
        }
        List<ShikyuGendoGakuEntity> 支給限度額entity1 = mapper.get支給限度額登録1();
        if (0 < 支給限度額entity1.size()) {
            for (ShikyuGendoGakuEntity shikyuGendoGakuEntity : 支給限度額entity1) {
                if (shikyuGendoGakuEntity != null) {
                    DbT4001JukyushaDaichoEntity 受給者台帳Entity1 = shikyuGendoGakuEntity.get受給者台帳Entity();
                    KyotakuKeikakuJikosakuseiKanriTempEntity 居宅給付計画自己作成管理一時Entity1 = shikyuGendoGakuEntity.get居宅給付計画自己作成管理一時Entity();
                    居宅給付計画自己作成管理一時Entity1.setHyojiYokaigoJotaiKubunCode(getRString(受給者台帳Entity1.getYokaigoJotaiKubunCode()));
                    自己作成管理一時TBL.update(居宅給付計画自己作成管理一時Entity1);
                }
            }
        }

        List<ShikyuGendoGakuEntity> 支給限度額entity2 = mapper.get支給限度額登録2();
        if (0 < 支給限度額entity2.size()) {
            for (ShikyuGendoGakuEntity shikyuGendoGakuEntity : 支給限度額entity2) {

                if (shikyuGendoGakuEntity != null) {
                    DbT4001JukyushaDaichoEntity 受給者台帳Entity2 = shikyuGendoGakuEntity.get受給者台帳Entity();
                    KyotakuKeikakuJikosakuseiKanriTempEntity 居宅給付計画自己作成管理一時Entity2 = shikyuGendoGakuEntity.get居宅給付計画自己作成管理一時Entity();
                    居宅給付計画自己作成管理一時Entity2.setHyojiShikyuGendoTanisu(受給者台帳Entity2.getShikyuGendoTanisu());
                    居宅給付計画自己作成管理一時Entity2.setYokaigoJotaiKubunCode(getRString(受給者台帳Entity2.getYokaigoJotaiKubunCode()));
                    居宅給付計画自己作成管理一時Entity2.setNinteiYukoKikanKaishiYM(getFlexibleYearMonth(受給者台帳Entity2.getNinteiYukoKikanKaishiYMD()));
                    居宅給付計画自己作成管理一時Entity2.setNinteiYukoKikanShuryoYM(getFlexibleYearMonth(受給者台帳Entity2.getNinteiYukoKikanShuryoYMD()));
                    居宅給付計画自己作成管理一時Entity2.setShikyuGendoTanisu(受給者台帳Entity2.getShikyuGendoTanisu());
                    居宅給付計画自己作成管理一時Entity2.setShikyuGendoKaishiYM(getFlexibleYearMonth(受給者台帳Entity2.getShikyuGendoKaishiYMD()));
                    居宅給付計画自己作成管理一時Entity2.setShikyuGendoShuryoYM(getFlexibleYearMonth(受給者台帳Entity2.getShikyuGendoShuryoYMD()));
                    自己作成管理一時TBL.update(居宅給付計画自己作成管理一時Entity2);
                }
            }
        } else {
            List<HihokenshaNo> hihokenshaNo = mapper.get支給限度額情報の取得チェック();
            RStringBuilder rb = new RStringBuilder();
            rb.append(new RString("【被保険者番号】"));
            if (0 < hihokenshaNo.size() && !hihokenshaNo.isEmpty()) {
                for (int i = 0; i < hihokenshaNo.size(); i++) {
                    rb.append(hihokenshaNo.get(i));
                    rb.append(new RString("："));
                }
                throw new BatchInterruptedException(DbcErrorMessages.受給者台帳_支給限度額情報不正.getMessage().replace(rb.toString()).toString());
            }
        }

        RString sakiEncodeKeitai = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_支給限度額一本化, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        paramter.toKyufukanrihyoOutMybatisParameter().set制度改正施行日支給限度額一本化の年月(sakiEncodeKeitai.substring(值零, 值六));
        paramter.toKyufukanrihyoOutMybatisParameter().set居宅サービス区分短期入所のコード(KyotakuServiceKubun.短期入所.getコード());
        List<ShikyuGendoGakuEntity> 支給限度額entity3 = mapper.get支給限度額登録3(paramter.toKyufukanrihyoOutMybatisParameter());
        if (0 < 支給限度額entity3.size()) {
            for (ShikyuGendoGakuEntity shikyuGendoGakuEntity : 支給限度額entity3) {
                if (shikyuGendoGakuEntity != null) {
                    DbT4001JukyushaDaichoEntity 受給者台帳Entity3 = shikyuGendoGakuEntity.get受給者台帳Entity();
                    KyotakuKeikakuJikosakuseiKanriTempEntity 居宅給付計画自己作成管理一時Entity3 = shikyuGendoGakuEntity.get居宅給付計画自己作成管理一時Entity();
                    居宅給付計画自己作成管理一時Entity3.setHyojiYokaigoJotaiKubunCode(getRString(受給者台帳Entity3.getYokaigoJotaiKubunCode()));
                    居宅給付計画自己作成管理一時Entity3.setHyojiShikyuGendoTanisu(new Decimal(受給者台帳Entity3.getTankiSikyuGendoNissu()));
                    居宅給付計画自己作成管理一時Entity3.setTankiYokaigoJotaiKubunCode(getRString(受給者台帳Entity3.getYokaigoJotaiKubunCode()));
                    居宅給付計画自己作成管理一時Entity3.setTankiSikyuGendoNissu(new RString(String.valueOf(受給者台帳Entity3.getTankiSikyuGendoNissu())));
                    居宅給付計画自己作成管理一時Entity3.setTankiShikyuGendoKaishiYM(getFlexibleYearMonth(受給者台帳Entity3.getTankiShikyuGendoKaishiYMD()));
                    居宅給付計画自己作成管理一時Entity3.setTankiShikyuGendoShuryoYM(getFlexibleYearMonth(受給者台帳Entity3.getTankiShikyuGendoShuryoYMD()));
                    自己作成管理一時TBL.update(居宅給付計画自己作成管理一時Entity3);
                }
            }
        }

        List<ShikyuGendoGakuEntity> 支給限度額entity4 = mapper.get支給限度額登録4();
        if (0 < 支給限度額entity4.size()) {
            for (ShikyuGendoGakuEntity shikyuGendoGakuEntity : 支給限度額entity4) {
                if (shikyuGendoGakuEntity != null) {
                    DbT7109KubunShikyuGendoGakuEntity 居宅サービス区分支給限度額Entity = shikyuGendoGakuEntity.get居宅サービス区分支給限度額Entity();
                    KyotakuKeikakuJikosakuseiKanriTempEntity 居宅給付計画自己作成管理一時Entity4 = shikyuGendoGakuEntity.get居宅給付計画自己作成管理一時Entity();
                    居宅給付計画自己作成管理一時Entity4.setHyojiShikyuGendoTanisu(居宅サービス区分支給限度額Entity.getShikyuGendoTaniSu());
                    居宅給付計画自己作成管理一時Entity4.setShikyuGendoKaishiYM(居宅サービス区分支給限度額Entity.getTekiyoKaishiYM());
                    自己作成管理一時TBL.update(居宅給付計画自己作成管理一時Entity4);
                }
            }
        }
        outCount.setValue(連番);
    }

    private FlexibleYearMonth getFlexibleYearMonth(FlexibleDate fb) {
        if (fb == null) {
            return FlexibleYearMonth.EMPTY;
        }
        if (fb.isEmpty()) {
            return FlexibleYearMonth.EMPTY;
        }
        return fb.getYearMonth();
    }

    private RString getRString(Code cd) {
        if (cd == null) {
            return RString.EMPTY;
        }
        if (cd.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(cd.toString());
    }
}
