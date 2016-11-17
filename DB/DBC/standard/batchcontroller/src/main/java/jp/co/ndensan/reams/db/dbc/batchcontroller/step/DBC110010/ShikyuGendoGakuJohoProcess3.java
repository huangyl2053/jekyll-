/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoout.KyufukanrihyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.ShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支給限度額情報取得3のクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class ShikyuGendoGakuJohoProcess3 extends BatchProcessBase<ShikyuGendoGakuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010"
            + ".IKyufukanrihyoOutMapper.get支給限度額登録3");
    private static final RString 自己作成管理一時_NAME = new RString("DbWT8211KyotakuKeikakuJikosakuseiKanri");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 自己作成管理一時TBL;
    private KyufukanrihyoOutProcessParameter paramter;
    private KyufukanrihyoOutMybatisParameter mybatisparamter;
    private final int 値六 = 6;
    private IKyufukanrihyoOutMapper mapper;
    private int count = 0;
    private static final RString 被保険者番号 = new RString("【被保険者番号】");
    private static final RString 号 = new RString("：");

    @Override
    protected void initialize() {
        mapper = getMapper(IKyufukanrihyoOutMapper.class);
        RString sakiEncodeKeitai = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_支給限度額一本化, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        mybatisparamter = paramter.toKyufukanrihyoOutMybatisParameter(RString.EMPTY,
                sakiEncodeKeitai.substring(0, 値六),
                KyotakuServiceKubun.短期入所.getコード());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, mybatisparamter);
    }

    @Override
    protected void createWriter() {
        自己作成管理一時TBL = new BatchEntityCreatedTempTableWriter(自己作成管理一時_NAME,
                KyotakuKeikakuJikosakuseiKanriTempEntity.class);
    }

    @Override
    protected void process(ShikyuGendoGakuEntity entity) {
        count++;
        DbT4001JukyushaDaichoEntity 受給者台帳Entity3 = entity.get受給者台帳Entity();
        KyotakuKeikakuJikosakuseiKanriTempEntity 居宅給付計画自己作成管理一時Entity3 = entity.get居宅給付計画自己作成管理一時Entity();
        居宅給付計画自己作成管理一時Entity3.setHyojiYokaigoJotaiKubunCode(getRString(受給者台帳Entity3.getYokaigoJotaiKubunCode()));
        居宅給付計画自己作成管理一時Entity3.setHyojiShikyuGendoTanisu(new Decimal(受給者台帳Entity3.getTankiSikyuGendoNissu()));
        居宅給付計画自己作成管理一時Entity3.setTankiYokaigoJotaiKubunCode(getRString(受給者台帳Entity3.getYokaigoJotaiKubunCode()));
        居宅給付計画自己作成管理一時Entity3.setTankiSikyuGendoNissu(new RString(String.valueOf(受給者台帳Entity3.getTankiSikyuGendoNissu())));
        居宅給付計画自己作成管理一時Entity3.setTankiShikyuGendoKaishiYM(getFlexibleYearMonth(受給者台帳Entity3.getTankiShikyuGendoKaishiYMD()));
        居宅給付計画自己作成管理一時Entity3.setTankiShikyuGendoShuryoYM(getFlexibleYearMonth(受給者台帳Entity3.getTankiShikyuGendoShuryoYMD()));
        自己作成管理一時TBL.update(居宅給付計画自己作成管理一時Entity3);
    }

    @Override
    protected void afterExecute() {
        if (1 < count) {
            List<RString> hihokenshaNo = mapper.get支給限度額情報の取得チェック();
            RStringBuilder rb = new RStringBuilder();
            rb.append(被保険者番号);
            if (0 < hihokenshaNo.size() && !hihokenshaNo.isEmpty()) {
                for (int i = 0; i < hihokenshaNo.size(); i++) {
                    rb.append(hihokenshaNo.get(i));
                    rb.append(号);
                }
                throw new BatchInterruptedException(DbcErrorMessages.受給者台帳_支給限度額情報不正.getMessage().replace(rb.toString()).toString());
            }
        }
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
