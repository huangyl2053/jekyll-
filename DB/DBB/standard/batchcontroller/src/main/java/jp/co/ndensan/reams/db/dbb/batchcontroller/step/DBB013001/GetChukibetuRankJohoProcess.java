/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001.TokuchoHeinjunka8GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tukibeturanku.TsukibetsuRankTemp;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 月別ランクTemp一時テーブルに登録クラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class GetChukibetuRankJohoProcess extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private static final RString 月別ランク一時_TABLE_NAME = new RString("TsukibetsuRankTemp");
    private static final RString ONE = new RString("1");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper.do月別ランクTemp一時テーブルに登録");

    private Code 導入形態コード;
    private List<MonthShichoson> 月別ランク情報リスト;
    private TokuchoHeinjunka8GatsuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 月別ランクTemp一時tableWriter;

    @Override
    protected void initialize() {
        ShichosonSecurityJoho 市町村情報セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        導入形態コード = 市町村情報セキュリティ.get導入形態コード();

    }

    @Override
    protected void createWriter() {
        月別ランクTemp一時tableWriter = new BatchEntityCreatedTempTableWriter(
                月別ランク一時_TABLE_NAME, TsukibetsuRankTemp.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity entity) {
        if (null == entity || null == 導入形態コード) {
            return;
        }
        TsukibetsuRankTemp rankuEntity = new TsukibetsuRankTemp();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey())) {

            RString 合併情報区分 = DbBusinessConfig.get(
                    ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            if (ONE.equals(合併情報区分)) {

                get月別ランク情報(new HihokenshaDaicho(entity));
                rankuEntity.setHihokenshaNo(entity.getHihokenshaNo());
                set月別ランク(rankuEntity, 月別ランク情報リスト);
                月別ランクTemp一時tableWriter.insert(rankuEntity);
            }
        }
    }

    private void get月別ランク情報(HihokenshaDaicho 資格の情報) {
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<HihokenshaDaicho> 資格の情報リスト = new ArrayList<>();
        資格の情報リスト.add(資格の情報);
        月別ランク情報リスト = rank.get月別ランク情報(資格の情報リスト, parameter.get賦課年度());
    }

    private void set月別ランク(TsukibetsuRankTemp rankuEntity, List<MonthShichoson> 月別ランク情報リスト) {
        for (MonthShichoson 月別ランク情報 : 月別ランク情報リスト) {
            RString コード = 月別ランク情報.get月().getコード();
            RString 区分 = 月別ランク情報.getランク区分();
            LasdecCode 市町村コード = 月別ランク情報.get市町村コード();
            if (Tsuki._4月.getコード().equals(コード)) {
                rankuEntity.setRankKubun4Gatsu(区分);
                rankuEntity.setShichosonCode4Gatsu(市町村コード);
            } else if (Tsuki._5月.getコード().equals(コード)) {
                rankuEntity.setRankKubun5Gatsu(区分);
                rankuEntity.setShichosonCode5Gatsu(市町村コード);
            } else if (Tsuki._6月.getコード().equals(コード)) {
                rankuEntity.setRankKubun6Gatsu(区分);
                rankuEntity.setShichosonCode6Gatsu(市町村コード);
            } else if (Tsuki._7月.getコード().equals(コード)) {
                rankuEntity.setRankKubun7Gatsu(区分);
                rankuEntity.setShichosonCode7Gatsu(市町村コード);
            } else if (Tsuki._8月.getコード().equals(コード)) {
                rankuEntity.setRankKubun8Gatsu(区分);
                rankuEntity.setShichosonCode8Gatsu(市町村コード);
            } else if (Tsuki._9月.getコード().equals(コード)) {
                rankuEntity.setRankKubun9Gatsu(区分);
                rankuEntity.setShichosonCode9Gatsu(市町村コード);
            } else if (Tsuki._10月.getコード().equals(コード)) {
                rankuEntity.setRankKubun10Gatsu(区分);
                rankuEntity.setShichosonCode10Gatsu(市町村コード);
            } else if (Tsuki._11月.getコード().equals(コード)) {
                rankuEntity.setRankKubun11Gatsu(区分);
                rankuEntity.setShichosonCode11Gatsu(市町村コード);
            } else if (Tsuki._12月.getコード().equals(コード)) {
                rankuEntity.setRankKubun12Gatsu(区分);
                rankuEntity.setShichosonCode12Gatsu(市町村コード);
            } else if (Tsuki._1月.getコード().equals(コード)) {
                rankuEntity.setRankKubun1Gatsu(区分);
                rankuEntity.setShichosonCode1Gatsu(市町村コード);
            } else if (Tsuki._2月.getコード().equals(コード)) {
                rankuEntity.setRankKubun2Gatsu(区分);
                rankuEntity.setShichosonCode2Gatsu(市町村コード);
            } else if (Tsuki._3月.getコード().equals(コード)) {
                rankuEntity.setRankKubun3Gatsu(区分);
                rankuEntity.setShichosonCode3Gatsu(市町村コード);
            }
        }
    }
}
