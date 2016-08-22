/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmen.shinseisho.hakko.Ddb102020MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800005.HomonKaigoRiyoshaFutangakuGengakuShinseishoOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.processprm.gemmen.shinseisho.hakko.ShinseishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko.RiyoshaFutangakuGemmenShinseishoHakkoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBZ12021_4_訪問介護利用者負担額減額申請書_process処理クラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public class HomonRiyoshaFutanGengakuShinseishoHakko extends BatchProcessBase<RiyoshaFutangakuGemmenShinseishoHakkoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko."
            + "IRiyoshaFutangakuGemmenShinseishoHakkoMapper.get出力対象者情報");
    private ShinseishoHakkoProcessParameter processParamter;
    private Association association;
    private Ninshosha ninshosha;
    private HokenshaList hokenshaList;
    private List<RString> 通知書定型文;
    private RString 出力順;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        ninshosha = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, RString.EMPTY);
        hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        通知書定型文 = new ArrayList();
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, processParamter.get帳票ID(), KamokuCode.EMPTY, 1);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBD介護受給, processParamter.get帳票ID());
        List<TsuchishoTeikeibunEntity> 通知書定型文List = tsuchishoTeikeibunInfo.get通知書定型文List();
        for (TsuchishoTeikeibunEntity entity : 通知書定型文List) {
            int 項目番号 = entity.getTsuchishoTeikeibunEntity().getSentenceNo();
            RString 文章 = textHenkanRule.editText(entity.getTsuchishoTeikeibunEntity().getSentence());
            通知書定型文.add(項目番号, textHenkanRule.editText(文章));
        }
    }

    @Override
    protected IBatchReader createReader() {
        IOutputOrder order = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBD介護受給,
                processParamter.get帳票ID(),
                processParamter.get改頁出力順ID());
        出力順 = Ddb102020MyBatisOrderByClauseCreator.create(HomonKaigoRiyoshaFutangakuGengakuShinseishoOrderKey.class, order);
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toFutanGendogakuMybatisParameter(出力順));
    }

    @Override
    protected void process(RiyoshaFutangakuGemmenShinseishoHakkoEntity entity) {
        //TODO 帳票設計_DBD800005_訪問介護利用者負担額減額申請書 の実装がありません。
        //2016/08/16まで。
    }

}
