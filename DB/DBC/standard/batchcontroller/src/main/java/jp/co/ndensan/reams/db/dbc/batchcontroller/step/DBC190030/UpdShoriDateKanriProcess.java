/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.UpdTaishoSeitaiyinTemp5ProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji.IKijunsyunyunenjiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 基準収入額適用申請書_異動分作成の処理日付管理マスタに更新 クラスです
 *
 * @reamsid_L DBC-4640-030 jianglaisheng
 */
public class UpdShoriDateKanriProcess extends SimpleBatchProcessBase {

    private InsTaishoSeitaiyinTempProcessParameter parameter;

    private static final int INT_0 = 0;

    @Override
    protected void process() {
        UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para = new UpdTaishoSeitaiyinTemp5ProcessMybatisParameter();
        para.set処理年度(parameter.get処理年度());
        para.set市町村コード(parameter.get市町村コード());
        para.set基準日時(YMDHMS.now());
        int 件数 = getMapper(IKijunsyunyunenjiMapper.class).select処理日付管理マスタ異動分(para);
        if (INT_0 == 件数) {
            getMapper(IKijunsyunyunenjiMapper.class).insert処理日付管理マスタ_異動分(para);
        } else {
            getMapper(IKijunsyunyunenjiMapper.class).update処理日付管理マスタ_異動分(para);
        }
    }
}
