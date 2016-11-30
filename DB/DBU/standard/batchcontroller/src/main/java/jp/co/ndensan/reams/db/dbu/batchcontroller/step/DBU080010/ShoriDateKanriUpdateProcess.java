/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoMybatisParamater;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理更新のバッチ処理です。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
public class ShoriDateKanriUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString GET_SHORIDATEKANRI = new RString("jp.co.ndensan.reams"
            + ".db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo.ITokuteiKojinJohoTeikyoMapper.getShoriDateKanriByShoriName");
    private static final RString ワークフローＩＤ_特定個人情報提供 = new RString("DBUWFC2001");
    private static final RString ワークフローＩＤ_スケジューラ = new RString("DBUWFC2002");
    private static final RString 処理名_全件版改定用 = new RString("特定個人情報提供（全件／版改定用）");
    private static final RString 処理名_異動用 = new RString("特定個人情報提供（異動用）");
    private static final RString 処理名_当初 = new RString("特定個人情報提供（当初）");
    private static final FlexibleDate システム日付 = FlexibleDate.getNowDate();

    private TokuteiKojinJohoTeikyoProcessParameter processParameter;
    private TokuteiKojinJohoTeikyoMybatisParamater mybitisParamter;

    @BatchWriter
    private BatchPermanentTableWriter tableWriter;

    @Override
    protected void initialize() {
        mybitisParamter = new TokuteiKojinJohoTeikyoMybatisParamater();
        mybitisParamter.setSubGyomuCode(SubGyomuCode.DBU介護統計報告.value());
        if (ワークフローＩＤ_特定個人情報提供.equals(processParameter.getワークフローID())) {
            mybitisParamter.setShoriName1(処理名_全件版改定用);
            if (processParameter.get新規異動区分().equals(ShinkiIdoKubun.当初.getコード())) {
                mybitisParamter.setTosyo(true);
                mybitisParamter.setShoriName2(処理名_当初);
            }
        } else if (ワークフローＩＤ_スケジューラ.equals(processParameter.getワークフローID())) {
            mybitisParamter.setShoriName1(処理名_異動用);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(GET_SHORIDATEKANRI, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        entity.setKijunYMD(システム日付);
        entity.setKijunTimestamp(null);
        entity.setTaishoKaishiYMD(FlexibleDate.EMPTY);
        entity.setTaishoKaishiTimestamp(new YMDHMS(processParameter.get対象開始日時()));
        entity.setTaishoShuryoYMD(FlexibleDate.EMPTY);
        entity.setTaishoShuryoTimestamp(new YMDHMS(processParameter.get対象終了日時()));
        tableWriter.update(entity);
    }

}
