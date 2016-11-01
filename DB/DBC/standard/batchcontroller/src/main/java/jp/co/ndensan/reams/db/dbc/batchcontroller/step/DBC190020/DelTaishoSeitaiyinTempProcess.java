/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji.IKijunsyunyunenjiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 基準収入額適用申請書_年次分作成の対象世帯員クラスTempの削除 クラスです
 *
 * @reamsid_L DBC-4630-050 jiangwenkai
 */
public class DelTaishoSeitaiyinTempProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        getMapper(IKijunsyunyunenjiMapper.class).delete対象世帯員クラスTemp();
        getMapper(IKijunsyunyunenjiMapper.class).deleteAll世帯員所得情報一時テーブル();
    }
}
