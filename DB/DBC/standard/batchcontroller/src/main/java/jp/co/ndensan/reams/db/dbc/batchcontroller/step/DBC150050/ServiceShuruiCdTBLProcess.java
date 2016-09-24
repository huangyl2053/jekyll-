/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran.ServiceShuruiCdNameProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaichukanTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceShuruiCdTBLTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.ServiceShuruiCdTBLEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類一時TBL取得処理Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class ServiceShuruiCdTBLProcess
        extends BatchProcessBase<ServiceShuruiCdTBLEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.getサービス種類一時TBL");

    @BatchWriter
    BatchEntityCreatedTempTableWriter サービス種類一時TBLtableWriter;
    private static final RString サービス種類一時TBL_TABLE_NAME = new RString("DbWT3470ServiceShuruiCdTBL");
    private ServiceShuruiCdNameProcessParameter processParameter;
    private static final RString RSTRING_1 = new RString("1");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, processParameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        サービス種類一時TBLtableWriter = new BatchEntityCreatedTempTableWriter(
                サービス種類一時TBL_TABLE_NAME, DbWT3470ServiceShuruiCdTBLTempEntity.class);
    }

    @Override
    protected void process(ServiceShuruiCdTBLEntity entity) {
        DbWT3470ServiceShuruiCdTBLTempEntity tempEntity = new DbWT3470ServiceShuruiCdTBLTempEntity();
        DbWT3470ServiceMeisaichukanTempEntity dbWT3470entity = entity.getサービス明細();
        tempEntity.setRenban(dbWT3470entity.getRenban());
        tempEntity.setShikibetsuCode(dbWT3470entity.getShikibetsuCode());
        tempEntity.setJuminShubetsuCode(dbWT3470entity.getJuminShubetsuCode());
        tempEntity.setMeisho(dbWT3470entity.getMeisho());
        tempEntity.setKanaMeisho(dbWT3470entity.getKanaMeisho());
        tempEntity.setSeinengappiYMD(dbWT3470entity.getSeinengappiYMD());
        tempEntity.setAge(dbWT3470entity.getAge());
        tempEntity.setSeibetsu(dbWT3470entity.getSeibetsu());
        tempEntity.setTsuzukigaraCode(dbWT3470entity.getTsuzukigaraCode());
        tempEntity.setSetaiCode(dbWT3470entity.getSetaiCode());
        tempEntity.setSetainushiMei(dbWT3470entity.getSetainushiMei());
        tempEntity.setChoikiCode(dbWT3470entity.getChoikiCode());
        tempEntity.setYubinNo(dbWT3470entity.getYubinNo());
        tempEntity.setJushoBanchiKatagaki(dbWT3470entity.getJushoBanchiKatagaki());
        tempEntity.setJusho(dbWT3470entity.getJusho());
        tempEntity.setBanchi(dbWT3470entity.getBanchi());
        tempEntity.setKatagaki(dbWT3470entity.getKatagaki());
        tempEntity.setGyoseikuCode(dbWT3470entity.getGyoseikuCode());
        tempEntity.setGyoseikuName(dbWT3470entity.getGyoseikuName());
        tempEntity.setChikuCode1(dbWT3470entity.getChikuCode1());
        tempEntity.setChikuCode2(dbWT3470entity.getChikuCode2());
        tempEntity.setChikuCode3(dbWT3470entity.getChikuCode3());
        tempEntity.setBlank(dbWT3470entity.getBlank());
        tempEntity.setHihokennshaKubunCode(dbWT3470entity.getHihokennshaKubunCode());
        tempEntity.setShichosonCode(dbWT3470entity.getShichosonCode());
        tempEntity.setKoikinaiJushochiTokureiFlag(dbWT3470entity.getKoikinaiJushochiTokureiFlag());
        tempEntity.setKoikinaiTokureiSochimotoShichosonCode(dbWT3470entity.getKoikinaiTokureiSochimotoShichosonCode());
        tempEntity.setKyuShichosonCode(dbWT3470entity.getKyuShichosonCode());
        tempEntity.setInputShikibetsuNo(dbWT3470entity.getInputShikibetsuNo());
        tempEntity.setKyufuSakuseiKubunCode(dbWT3470entity.getKyufuSakuseiKubunCode());
        tempEntity.setShokisaiHokenshaNo(dbWT3470entity.getShokisaiHokenshaNo());
        tempEntity.setShokisaiHokenshaName(dbWT3470entity.getShokisaiHokenshaName());
        tempEntity.setHiHokenshaNo(dbWT3470entity.getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(dbWT3470entity.getServiceTeikyoYM());
        tempEntity.setKyufuJissekiKubunCode(dbWT3470entity.getKyufuJissekiKubunCode());
        tempEntity.setJigyoshoNo(dbWT3470entity.getJigyoshoNo());
        tempEntity.setJigyoshoName(dbWT3470entity.getJigyoshoName());
        tempEntity.setYoKaigoJotaiKubunCode(dbWT3470entity.getYoKaigoJotaiKubunCode());
        tempEntity.setKyuSochiNyushoshaTokureiCode(dbWT3470entity.getKyuSochiNyushoshaTokureiCode());
        tempEntity.setNinteiYukoKaishiYMD(dbWT3470entity.getNinteiYukoKaishiYMD());
        tempEntity.setNinteiYukoShuryoYMD(dbWT3470entity.getNinteiYukoShuryoYMD());
        tempEntity.setRojinHokenShichosonNo(dbWT3470entity.getRojinHokenShichosonNo());
        tempEntity.setRojinhokenJukyushaNo(dbWT3470entity.getRojinhokenJukyushaNo());
        tempEntity.setKyotakuServiceSakuseiKubunCode(dbWT3470entity.getKyotakuServiceSakuseiKubunCode());
        tempEntity.setSakujigyoshoNo(dbWT3470entity.getSakujigyoshoNo());
        tempEntity.setSakujigyoshoName(dbWT3470entity.getSakujigyoshoName());
        tempEntity.setNyushoYMD(dbWT3470entity.getNyushoYMD());
        tempEntity.setTaishoYMD(dbWT3470entity.getTaishoYMD());
        tempEntity.setNyushoJitsunissu(dbWT3470entity.getNyushoJitsunissu());
        tempEntity.setHokenKyufuritsu(dbWT3470entity.getHokenKyufuritsu());
        tempEntity.setKohi1Kyufuritsu(dbWT3470entity.getKohi1Kyufuritsu());
        tempEntity.setKohi2Kyufuritsu(dbWT3470entity.getKohi2Kyufuritsu());
        tempEntity.setKohi3Kyufuritsu(dbWT3470entity.getKohi3Kyufuritsu());
        tempEntity.setKokiHokenshaNo(dbWT3470entity.getKokiHokenshaNo());
        tempEntity.setKokiHiHokenshaNo(dbWT3470entity.getKokiHiHokenshaNo());
        tempEntity.setKokuhoHokenshaNo(dbWT3470entity.getKokuhoHokenshaNo());
        tempEntity.setKokuhoHiHokenshashoNo(dbWT3470entity.getKokuhoHiHokenshashoNo());
        tempEntity.setKokuhoKojinNo(dbWT3470entity.getKokuhoKojinNo());
        tempEntity.setServiceShuruiCode(dbWT3470entity.getServiceShuruiCode());
        tempEntity.setServiceKomokuCode(dbWT3470entity.getServiceKomokuCode());
        tempEntity.setServiceCode(dbWT3470entity.getServiceCode());
        tempEntity.setServiceName(dbWT3470entity.getServiceName());
        tempEntity.setServiceCodeName(dbWT3470entity.getServiceCodeName());
        tempEntity.setAtoTanisu(dbWT3470entity.getAtoTanisu());
        tempEntity.setAtoNissuKaisu(dbWT3470entity.getAtoNissuKaisu());
        tempEntity.setAtoKohi1TaishoNissuKaisu(dbWT3470entity.getAtoKohi1TaishoNissuKaisu());
        tempEntity.setAtoKohi2TaishoNissukaisu(dbWT3470entity.getAtoKohi2TaishoNissukaisu());
        tempEntity.setAtoKohi3TaishoNissuKaisu(dbWT3470entity.getAtoKohi3TaishoNissuKaisu());
        tempEntity.setAtoServiceTanisu(dbWT3470entity.getAtoServiceTanisu());
        tempEntity.setAtoKohi1TaishoServiceTanisu(dbWT3470entity.getAtoKohi1TaishoServiceTanisu());
        tempEntity.setAtoKohi2TaishoServiceTanisu(dbWT3470entity.getAtoKohi2TaishoServiceTanisu());
        tempEntity.setAtoKohi3TaishoServiceTanisu(dbWT3470entity.getAtoKohi3TaishoServiceTanisu());
        tempEntity.setSaishinsaKaisu(dbWT3470entity.getSaishinsaKaisu());
        tempEntity.setKagoKaisu(dbWT3470entity.getKagoKaisu());
        tempEntity.setShinsaYM(dbWT3470entity.getShinsaYM());
        tempEntity.setServiceCdTeikyoYM(entity.getサービス提供年月());
        if (RSTRING_1.equals(processParameter.get種別())) {
            サービス種類一時TBLtableWriter.insert(tempEntity);
        } else {
            サービス種類一時TBLtableWriter.update(tempEntity);
        }
    }

}
