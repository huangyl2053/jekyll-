/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.HihokenshaShikibetsuTaishoMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 被保険者・宛名情報取得の取得処理Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class HihokenshaShikibetsuTaishoProcess
        extends BatchProcessBase<HihokenshaShikibetsuTaishoMeisaiEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.get被保険者宛名情報");
    @BatchWriter
    BatchEntityCreatedTempTableWriter サービス明細一時tableWriter;
    private static final RString サービス明細一時_TABLE_NAME = new RString("DbWT3470ServiceMeisai");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        サービス明細一時tableWriter = new BatchEntityCreatedTempTableWriter(
                サービス明細一時_TABLE_NAME, DbWT3470ServiceMeisaiTempEntity.class);
    }

    @Override
    protected void process(HihokenshaShikibetsuTaishoMeisaiEntity entity) {
        DbWT3470ServiceMeisaiTempEntity serviceMeisaiTempEntity = entity.getサービス明細();
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = entity.get被保険者台帳管理();
        UaFt200FindShikibetsuTaishoEntity 宛名 = entity.get宛名();
        if (宛名 != null) {
            IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.createKojin(宛名);
            set宛名(識別対象, serviceMeisaiTempEntity);
            serviceMeisaiTempEntity.setTsuzukigaraCode(宛名.getTsuzukigaraCode());
        }
        if (被保険者台帳管理 != null) {
            serviceMeisaiTempEntity.setHihokennshaKubunCode(被保険者台帳管理.getHihokennshaKubunCode());
            serviceMeisaiTempEntity.setShichosonCode(被保険者台帳管理.getShichosonCode());
            serviceMeisaiTempEntity.setKoikinaiJushochiTokureiFlag(被保険者台帳管理.getKoikinaiJushochiTokureiFlag());
            serviceMeisaiTempEntity.setKoikinaiTokureiSochimotoShichosonCode(
                    被保険者台帳管理.getKoikinaiTokureiSochimotoShichosonCode());
            serviceMeisaiTempEntity.setKyuShichosonCode(被保険者台帳管理.getKyuShichosonCode());
        }
        サービス明細一時tableWriter.update(serviceMeisaiTempEntity);
    }

    private void set宛名(IShikibetsuTaisho 識別対象, DbWT3470ServiceMeisaiTempEntity serviceMeisaiTempEntity) {
        serviceMeisaiTempEntity.setShikibetsuCode(識別対象.get識別コード());
        serviceMeisaiTempEntity.setJuminShubetsuCode(識別対象.get住民種別().getCode());
        if (識別対象.get名称() != null) {
            serviceMeisaiTempEntity.setMeisho(識別対象.get名称().getName());
            serviceMeisaiTempEntity.setKanaMeisho(識別対象.get名称().getKana());
        }
        if (null != 識別対象.to個人()) {
            serviceMeisaiTempEntity.setSeinengappiYMD(識別対象.to個人().get生年月日().toFlexibleDate());
            serviceMeisaiTempEntity.setAge(new AgeCalculator(識別対象.to個人().get生年月日(),
                    識別対象.to個人().get住民状態(),
                    識別対象.to個人().get消除異動年月日(),
                    AgeArrivalDay.前日).get年齢());
            serviceMeisaiTempEntity.setSeibetsu(識別対象.to個人().get性別().getCode());
        }

        serviceMeisaiTempEntity.setSetaiCode(識別対象.get世帯コード());
        serviceMeisaiTempEntity.setSetainushiMei(識別対象.get世帯主名());
        if (識別対象.get住所() != null) {
            serviceMeisaiTempEntity.setChoikiCode(識別対象.get住所().get町域コード());
            serviceMeisaiTempEntity.setYubinNo(識別対象.get住所().get郵便番号());
            if (識別対象.get住所().get住所() != null
                    && 識別対象.get住所().get番地() != null
                    && 識別対象.get住所().get方書() != null) {
                serviceMeisaiTempEntity.setJushoBanchiKatagaki(識別対象.get住所().get住所()
                        .concat(getColumnValue(識別対象.get住所().get番地().getBanchi()))
                        .concat(getColumnValue(識別対象.get住所().get方書())));
            }
            serviceMeisaiTempEntity.setJusho(識別対象.get住所().get住所());
            serviceMeisaiTempEntity.setBanchi(getColumnValue(識別対象.get住所().get番地().getBanchi()));
            serviceMeisaiTempEntity.setKatagaki(getColumnValue(識別対象.get住所().get方書()));
        }
        if (識別対象.get行政区画() != null) {
            if (識別対象.get行政区画().getGyoseiku() != null) {
                serviceMeisaiTempEntity.setGyoseikuCode(識別対象.get行政区画().getGyoseiku().getコード());
                serviceMeisaiTempEntity.setGyoseikuName(識別対象.get行政区画().getGyoseiku().get名称());
            }
            if (識別対象.get行政区画().getChiku1() != null) {
                serviceMeisaiTempEntity.setChikuCode1(
                        getColumnValue(識別対象.get行政区画().getChiku1().getコード()));
            }
            if (識別対象.get行政区画().getChiku2() != null) {
                serviceMeisaiTempEntity.setChikuCode2(
                        getColumnValue(識別対象.get行政区画().getChiku2().getコード()));
            }
            if (識別対象.get行政区画().getChiku3() != null) {
                serviceMeisaiTempEntity.setChikuCode3(
                        getColumnValue(識別対象.get行政区画().getChiku3().getコード()));
            }
        }

        serviceMeisaiTempEntity.setBlank(RString.HALF_SPACE);

    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
