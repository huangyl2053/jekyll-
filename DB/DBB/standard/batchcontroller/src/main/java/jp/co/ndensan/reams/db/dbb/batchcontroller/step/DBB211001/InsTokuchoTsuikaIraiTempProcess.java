/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTokuchoTsuikaIraiTempProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴追加依頼データ抽出します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsTokuchoTsuikaIraiTempProcess extends BatchProcessBase<UeT0511NenkinTokuchoKaifuJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get特徴追加依頼データ");
    private static final RString TEMP_TABLE = new RString("特徴追加依頼Temp");
    private static final RString 特別徴収_特徴開始月_月捕捉_4月開始 = new RString("04");
    private InsTokuchoTsuikaIraiTempProcessParameter parameter;

    private RString 特別徴収_特徴開始月_6月捕捉;
    private RString 特別徴収_特徴開始月_8月捕捉;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<UeT0511NenkinTokuchoKaifuJohoEntity> 特徴追加依頼Temp;

    @Override
    protected void initialize() {
        RDate nowDate = RDate.getNowDate();
        特別徴収_特徴開始月_6月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, nowDate, SubGyomuCode.DBB介護賦課);
        特別徴収_特徴開始月_8月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉, nowDate, SubGyomuCode.DBB介護賦課);
    }

    @Override
    protected IBatchReader createReader() {
        RString 通知内容コード = TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード();
        return new BatchDbReader(MYBATIS_SELECT_ID,
                parameter.toSelectTokuchoTsuikaIraiTempMyBatisParameter(通知内容コード));
    }

    @Override
    protected void createWriter() {
        特徴追加依頼Temp = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    @Override
    protected void process(UeT0511NenkinTokuchoKaifuJohoEntity t) {
        if (!((parameter.is処理対象月が10月()
                && 特別徴収_特徴開始月_月捕捉_4月開始.equals(特別徴収_特徴開始月_6月捕捉))
                || (parameter.is処理対象月が12月()
                && 特別徴収_特徴開始月_月捕捉_4月開始.equals(特別徴収_特徴開始月_8月捕捉)))) {
            特徴追加依頼Temp.insert(t);
        }
    }
}
