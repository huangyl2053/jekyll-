/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.jyukirendotorokushalist;

import jp.co.ndensan.reams.db.dba.definition.processprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchProcessParameter;
import jp.co.ndensan.reams.db.dba.persistence.mapper.jyukirendojouhou.IJyukiRendoJouhouMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタに更新します
 */
public class ShoriDateKanriDBUpdateProcess extends SimpleBatchProcessBase {

    private IJyukiRendoJouhouMapper jyukiRendoJouhouMapper;
    private JyukiRendoTorokushaListBatchProcessParameter processParameter;
    private static final RString 処理名 = new RString("住基連動登録者リスト");
    private static final RString 処理枝番 = new RString("0000");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度内連番 = new RString("0000");

    // TODO QA399
    private int insertCount;
    private int updateCount;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        jyukiRendoJouhouMapper = getMapper(IJyukiRendoJouhouMapper.class);
        insertCount = 0;
        updateCount = 0;
    }

    @Override
    protected void process() {
        DbT7022ShoriDateKanriEntity parameter = new DbT7022ShoriDateKanriEntity();
        parameter.setTaishoKaishiYMD(new FlexibleDate(processParameter.getKonkaikaishiYMDHMS()
                .replace("-", "").substring(0, 8)));
        parameter.setTaishoShuryoYMD(new FlexibleDate(processParameter.getKonkaishuryoYMDHMS()
                .replace("-", "").substring(0, 8)));
        if (processParameter.getZenkaikaishiYMDHMS() == null && processParameter.getZenkaishuryoYMDHMS() == null) {
            parameter.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            parameter.setShichosonCode(AssociationFinderFactory.createInstance().getAssociation()
                    .get地方公共団体コード());
            parameter.setShoriName(処理名);
            parameter.setShoriEdaban(処理枝番);
            parameter.setNendo(年度);
            parameter.setNendoNaiRenban(年度内連番);
            insertCount = jyukiRendoJouhouMapper.insertShoriDateKanri(parameter);
        } else {
            parameter.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            parameter.setShoriName(処理名);
            updateCount = jyukiRendoJouhouMapper.updateShoriDateKanri(parameter);
        }
    }
}
