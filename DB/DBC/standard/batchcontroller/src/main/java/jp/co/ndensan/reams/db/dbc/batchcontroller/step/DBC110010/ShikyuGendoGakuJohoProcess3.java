/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoout.KyufukanrihyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.ShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
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

    @Override
    protected void initialize() {
        mybatisparamter = paramter.toKyufukanrihyoOutMybatisParameter();
        RString sakiEncodeKeitai = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_支給限度額一本化, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        mybatisparamter.set制度改正施行日支給限度額一本化の年月(sakiEncodeKeitai.substring(0, 値六));
        mybatisparamter.set居宅サービス区分短期入所のコード(KyotakuServiceKubun.短期入所.getコード());

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
