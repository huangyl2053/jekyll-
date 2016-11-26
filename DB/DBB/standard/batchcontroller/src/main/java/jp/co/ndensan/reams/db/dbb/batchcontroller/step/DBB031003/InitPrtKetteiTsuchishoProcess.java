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
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「最新調定日時取得」処理クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class InitPrtKetteiTsuchishoProcess extends SimpleBatchProcessBase {

    private HonsanteifukaProcessParameter parameter;
    private IHonsanteiTsuchishoIkkatsuHakkoMapper mapper;
    private static final RString キー_調定年度 = new RString("調定年度");

    /**
     * OutputParameter用キー kijunTime
     */
    public static final RString KIJUN_TIME;

    static {
        KIJUN_TIME = new RString("kijunTime");
    }

    private OutputParameter<YMDHMS> kijunTime;
    YMDHMS 最新調定日時;

    @Override
    protected void beforeExecute() {
        kijunTime = new OutputParameter<>();
        mapper = getMapper(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
    }

    @Override
    protected void process() {
        Map<String, Object> para = new HashMap<>();
        para.put(キー_調定年度.toString(), parameter.get調定年度());
        DbT7022ShoriDateKanriEntity entity = mapper.select最新調定日時(para);
        kijunTime.setValue(entity.getKijunTimestamp());
    }

    @Override
    protected void afterExecute() {
    }
}
