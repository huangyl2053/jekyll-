/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd581001;

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
        tempWriter = new BatchEntityCreatedTempTableWriter(new RString("受給者台帳一時テーブル"),
                JukyushaDaichoTempEntity.class);
    }

    @Override
    protected void process(JukyushaDaichoTempEntity entity) {
        if (parameter.get出力帳票().equals(出力帳票)) {
            entity.set認定年月(entity.get認定年月日().getYearMonth().seireki().toDateString());
            entity.set受給申請年月(entity.get受給申請年月日().getYearMonth().seireki().toDateString());
            entity.set調査委託年月(entity.get調査委託年月日().getYearMonth().seireki().toDateString());
            entity.set調査終了年月(entity.get調査終了年月日().getYearMonth().seireki().toDateString());
            entity.set意見書依頼年月(entity.get意見書依頼年月日().getYearMonth().seireki().toDateString());
            entity.set意見書取寄せ年月(entity.get意見書取寄せ年月日().getYearMonth().seireki().toDateString());
            entity.set審査会依頼年月(entity.get審査会依頼年月日().getYearMonth().seireki().toDateString());
            entity.set認定審査会割当予定年月(entity.get認定審査会割当予定年月日().getYearMonth().seireki().toDateString());
            entity.set審査会資料作成年月(entity.get審査会資料作成年月日().getYearMonth().seireki().toDateString());
            entity.set認定調査予定年月(entity.get認定調査予定年月日().getYearMonth().seireki().toDateString());
            entity.set主治医意見書作成依頼予定年月(entity.get主治医意見書作成依頼予定年月日().getYearMonth().seireki().toDateString());
            tempWriter.insert(entity);
        }

    }

}
