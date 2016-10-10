/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaJohoTempParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidotsuchisho.IKarisanteiIdoFukaMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「更正前の対象者（追加含む）情報を更新」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class UpdIdoFukaTemp3Process extends SimpleBatchProcessBase {

    private IKarisanteiIdoFukaMapper mapper;
    private KarisanteiIdoFukaProcessParameter processParameter;
    private IdofukaJohoTempParameter parameter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKarisanteiIdoFukaMapper.class);
    }

    @Override
    protected void process() {
        parameter = IdofukaJohoTempParameter.createParameter(
                processParameter.get調定年度(), processParameter.get調定年度(), ShoriName.仮算定異動賦課.get名称(),
                processParameter.get最新調定日時(),
                TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード(),
                TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード(),
                null, new KozaSearchKeyBuilder().build(), null, null);
        mapper.update異動賦課情報一時テーブル更正前対象者情報(parameter);
    }

    @Override
    protected void afterExecute() {
    }

}
