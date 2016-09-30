/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran.KyufuJissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaichukanTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470chohyouShutsuryokuTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用一時TBLに登録Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class ChohyouShutsuryokuyouGetProcess
        extends BatchProcessBase<DbWT3470ServiceMeisaichukanTempEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.get帳票出力データ");
    private KyufuJissekiProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 帳票出力用一時tableWriter;
    private static final RString 帳票出力用一時_TABLE_NAME = new RString("DbWT3470chohyouShutsuryokuyou");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam_帳票出力用());
    }

    @Override
    protected void createWriter() {
        帳票出力用一時tableWriter = new BatchEntityCreatedTempTableWriter(
                帳票出力用一時_TABLE_NAME, DbWT3470chohyouShutsuryokuTempEntity.class);
    }

    @Override
    protected void process(DbWT3470ServiceMeisaichukanTempEntity entity) {
        DbWT3470chohyouShutsuryokuTempEntity tempEntity = new DbWT3470chohyouShutsuryokuTempEntity();
        tempEntity.setRenban(entity.getRenban());
        tempEntity.setShikibetsuCode(entity.getShikibetsuCode());
        tempEntity.setJuminShubetsuCode(entity.getJuminShubetsuCode());
        tempEntity.setMeisho(entity.getMeisho());
        tempEntity.setKanaMeisho(entity.getKanaMeisho());
        tempEntity.setSeinengappiYMD(entity.getSeinengappiYMD());
        tempEntity.setAge(entity.getAge());
        tempEntity.setSeibetsu(entity.getSeibetsu());
        tempEntity.setTsuzukigaraCode(entity.getTsuzukigaraCode());
        tempEntity.setSetaiCode(entity.getSetaiCode());
        tempEntity.setSetainushiMei(entity.getSetainushiMei());
        tempEntity.setChoikiCode(entity.getChoikiCode());
        tempEntity.setYubinNo(entity.getYubinNo());
        tempEntity.setJushoBanchiKatagaki(entity.getJushoBanchiKatagaki());
        tempEntity.setJusho(entity.getJusho());
        tempEntity.setBanchi(entity.getBanchi());
        tempEntity.setKatagaki(entity.getKatagaki());
        tempEntity.setGyoseikuCode(entity.getGyoseikuCode());
        tempEntity.setGyoseikuName(entity.getGyoseikuName());
        tempEntity.setChikuCode1(entity.getChikuCode1());
        tempEntity.setChikuCode2(entity.getChikuCode2());
        tempEntity.setChikuCode3(entity.getChikuCode3());
        tempEntity.setBlank(entity.getBlank());
        tempEntity.setHihokennshaKubunCode(entity.getHihokennshaKubunCode());
        tempEntity.setShichosonCode(entity.getShichosonCode());
        tempEntity.setKoikinaiJushochiTokureiFlag(entity.getKoikinaiJushochiTokureiFlag());
        tempEntity.setKoikinaiTokureiSochimotoShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCode());
        tempEntity.setKyuShichosonCode(entity.getKyuShichosonCode());
        tempEntity.setInputShikibetsuNo(entity.getInputShikibetsuNo());
        tempEntity.setKyufuSakuseiKubunCode(entity.getKyufuSakuseiKubunCode());
        tempEntity.setShokisaiHokenshaNo(entity.getShokisaiHokenshaNo());
        tempEntity.setShokisaiHokenshaName(entity.getShokisaiHokenshaName());
        tempEntity.setHiHokenshaNo(entity.getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        tempEntity.setKyufuJissekiKubunCode(entity.getKyufuJissekiKubunCode());
        tempEntity.setJigyoshoNo(entity.getJigyoshoNo());
        tempEntity.setJigyoshoName(entity.getJigyoshoName());
        tempEntity.setYoKaigoJotaiKubunCode(entity.getYoKaigoJotaiKubunCode());
        tempEntity.setKyuSochiNyushoshaTokureiCode(entity.getKyuSochiNyushoshaTokureiCode());
        tempEntity.setNinteiYukoKaishiYMD(entity.getNinteiYukoKaishiYMD());
        tempEntity.setNinteiYukoShuryoYMD(entity.getNinteiYukoShuryoYMD());
        tempEntity.setRojinHokenShichosonNo(entity.getRojinHokenShichosonNo());
        tempEntity.setRojinhokenJukyushaNo(entity.getRojinhokenJukyushaNo());
        tempEntity.setKyotakuServiceSakuseiKubunCode(entity.getKyotakuServiceSakuseiKubunCode());
        tempEntity.setSakujigyoshoNo(entity.getSakujigyoshoNo());
        tempEntity.setSakujigyoshoName(entity.getSakujigyoshoName());
        tempEntity.setNyushoYMD(entity.getNyushoYMD());
        tempEntity.setTaishoYMD(entity.getTaishoYMD());
        tempEntity.setNyushoJitsunissu(entity.getNyushoJitsunissu());
        tempEntity.setHokenKyufuritsu(entity.getHokenKyufuritsu());
        tempEntity.setKohi1Kyufuritsu(entity.getKohi1Kyufuritsu());
        tempEntity.setKohi2Kyufuritsu(entity.getKohi2Kyufuritsu());
        tempEntity.setKohi3Kyufuritsu(entity.getKohi3Kyufuritsu());
        tempEntity.setKokiHokenshaNo(entity.getKokiHokenshaNo());
        tempEntity.setKokiHiHokenshaNo(entity.getKokiHiHokenshaNo());
        tempEntity.setKokuhoHokenshaNo(entity.getKokuhoHokenshaNo());
        tempEntity.setKokuhoHiHokenshashoNo(entity.getKokuhoHiHokenshashoNo());
        tempEntity.setKokuhoKojinNo(entity.getKokuhoKojinNo());
        tempEntity.setServiceShuruiCode(entity.getServiceShuruiCode());
        tempEntity.setServiceKomokuCode(entity.getServiceKomokuCode());
        tempEntity.setServiceCode(entity.getServiceCode());
        tempEntity.setServiceName(entity.getServiceName());
        tempEntity.setServiceCodeName(entity.getServiceCodeName());
        tempEntity.setAtoTanisu(entity.getAtoTanisu());
        tempEntity.setAtoNissuKaisu(entity.getAtoNissuKaisu());
        tempEntity.setAtoKohi1TaishoNissuKaisu(entity.getAtoKohi1TaishoNissuKaisu());
        tempEntity.setAtoKohi2TaishoNissukaisu(entity.getAtoKohi2TaishoNissukaisu());
        tempEntity.setAtoKohi3TaishoNissuKaisu(entity.getAtoKohi3TaishoNissuKaisu());
        tempEntity.setAtoServiceTanisu(entity.getAtoServiceTanisu());
        tempEntity.setAtoKohi1TaishoServiceTanisu(entity.getAtoKohi1TaishoServiceTanisu());
        tempEntity.setAtoKohi2TaishoServiceTanisu(entity.getAtoKohi2TaishoServiceTanisu());
        tempEntity.setAtoKohi3TaishoServiceTanisu(entity.getAtoKohi3TaishoServiceTanisu());
        tempEntity.setSaishinsaKaisu(entity.getSaishinsaKaisu());
        tempEntity.setKagoKaisu(entity.getKagoKaisu());
        tempEntity.setShinsaYM(entity.getShinsaYM());
        帳票出力用一時tableWriter.insert(tempEntity);
    }

}
