/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD581001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd581001.YokaigoJissiJyokyohyoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001.JukyushaDaichoTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定実施状況表（統計表）の作成_process処理クラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
public class JissiJyokyohyoReportProcess extends BatchProcessBase<JukyushaDaichoTempEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigojissijyokyohyo."
                    + "IYokaigoJissiJyokyohyoMapper.get受給者台帳マスタ");

    private YokaigoJissiJyokyohyoProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter tempWriter;
    private static final RString 出力帳票 = new RString("要介護認定実施状況表（その月に申請・認定を受けた受給者の統計）");

    @Override
    protected void initialize() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        parameter.set導入形態コード(ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().getColumnValue());
        parameter.set概況調査テキストイメージ区分(DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        parameter.setPsmShikibetsuTaisho(psmShikibetsuTaisho);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toYokaigoJissiJyokyohyoMybatisParameter());

    }

    @Override
    protected void createWriter() {
        tempWriter = new BatchEntityCreatedTempTableWriter(JukyushaDaichoTempEntity.TABLE_NAME,
                JukyushaDaichoTempEntity.class);
    }

    @Override
    protected void process(JukyushaDaichoTempEntity entity) {
        if (parameter.get出力帳票().equals(出力帳票)) {
            if (checkEmpty(entity.getNinteiYMD())) {
                entity.setNinteiYM(entity.getNinteiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getJukyuShinseiYMD())) {
                entity.setJukyuShinseiYM(entity.getJukyuShinseiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getNinteichosaIraiYMD())) {
                entity.setNinteichosaIraiYM(entity.getNinteichosaIraiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getNinteichosaJisshiYMD())) {
                entity.setNinteichosaJisshiYM(entity.getNinteichosaJisshiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getIkenshoSakuseiIraiYMD())) {
                entity.setIkenshoSakuseiIraiYM(entity.getIkenshoSakuseiIraiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getIkenshoJuryoYMD())) {
                entity.setIkenshoJuryoYM(entity.getIkenshoJuryoYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getShinsakaiIraiYMD())) {
                entity.setShinsakaiIraiYM(entity.getShinsakaiIraiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getNinteiShinsakaiWariateYoteiYMD())) {
                entity.setNinteiShinsakaiWariateYoteiYM(entity.getNinteiShinsakaiWariateYoteiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getShinsakaiShiryoSakuseiYMD())) {
                entity.setShinsakaiShiryoSakuseiYM(entity.getShinsakaiShiryoSakuseiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getNinteichosaYoteiYMD())) {
                entity.setNinteichosaYoteiYM(entity.getNinteichosaYoteiYMD().getYearMonth().seireki().toDateString());
            }
            if (checkEmpty(entity.getIkenshoSakuseiIraiYoteiYMD())) {
                entity.setIkenshoSakuseiIraiYoteiYM(entity.getIkenshoSakuseiIraiYoteiYMD().getYearMonth().seireki().toDateString());
            }
            tempWriter.insert(entity);
        }
    }

    private boolean checkEmpty(FlexibleDate ymd) {
        return ymd != null && !ymd.isEmpty();
    }
}
