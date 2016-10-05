/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「更正前の対象者（追加含む）情報を更新」処理クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class UpdHonsanteiTsuchishoTmpTaisyoshaDataProcess extends SimpleBatchProcessBase {

    private static final RString キー_最新調定日時 = new RString("最新調定日時");
    private static final RString キー_調定年度 = new RString("調定年度");
    private IHonsanteiTsuchishoIkkatsuHakkoMapper mapper;
    private HonsanteifukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
    }

    @Override
    protected void process() {
        Map<String, Object> para = new HashMap<>();
        para.put(キー_最新調定日時.toString(), processParameter.get最新調定日時());
        para.put(キー_調定年度.toString(), processParameter.get調定年度().minusYear(1));
        mapper.update本算定通知書一時_対象者仮徴収更正前(para);
        para.put(キー_調定年度.toString(), processParameter.get調定年度());
        mapper.update本算定通知書一時_対象者本徴収更正前(para);
    }

    @Override
    protected void afterExecute() {
    }
}
