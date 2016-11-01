/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokarisanteitsuchishohakko.FuchoKarisanteiTsuchishoHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014003.FuchoKarisanteiTsuchishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokaritsuchishoikkatsuhakko.IFuchoKarisanteiTsuchishoHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「最新調定日時取得」処理クラスです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
public class SaishinChoteiNichijiShutokuProcess extends SimpleBatchProcessBase {

    /**
     * OutputParameter用キー 最新調定日時
     */
    public static final RString 最新調定日時;
    private static final RString 基準日時 = new RString("kijuntimestamp");
    private FuchoKarisanteiTsuchishoHakkoProcessParameter processParameter;
    private IFuchoKarisanteiTsuchishoHakkoMapper mapper;

    static {
        最新調定日時 = new RString("調定日時");
    }
    private OutputParameter<RString> 調定日時;

    @Override
    protected void beforeExecute() {
        調定日時 = new OutputParameter<>();
        mapper = getMapper(IFuchoKarisanteiTsuchishoHakkoMapper.class);
    }

    @Override
    protected void process() {
        FuchoKarisanteiTsuchishoHakkoMybatisParameter parameter = new FuchoKarisanteiTsuchishoHakkoMybatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
        調定日時.setValue(new RString(mapper.get最新調定日時(parameter).get(基準日時.toString()).toString()));
    }

    @Override
    protected void afterExecute() {
    }
}
