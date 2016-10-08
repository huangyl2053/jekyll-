/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.UpdTaishoSeitaiyinTemp5ProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji.IKijunsyunyunenjiMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 基準収入額適用申請書_年次分作成の処理日付管理マスタに更新 クラスです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
public class UpdShoriDateKanriProcess extends SimpleBatchProcessBase {

    private InsTaishoSeitaiyinTempProcessParameter parameter;

    private static final int INT_0 = 0;

    @Override
    protected void process() {
        UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para = new UpdTaishoSeitaiyinTemp5ProcessMybatisParameter();
        para.set処理年度(parameter.get処理年度());
        para.set市町村コード(parameter.get市町村コード());
        List<DbT7022ShoriDateKanriEntity> entityList = getMapper(IKijunsyunyunenjiMapper.class).select処理日付管理マスタ(para);
        if (INT_0 == entityList.size()) {
            getMapper(IKijunsyunyunenjiMapper.class).insert処理日付管理マスタ(para);
        } else {
            getMapper(IKijunsyunyunenjiMapper.class).update処理日付管理マスタ(para);
        }

    }
}
