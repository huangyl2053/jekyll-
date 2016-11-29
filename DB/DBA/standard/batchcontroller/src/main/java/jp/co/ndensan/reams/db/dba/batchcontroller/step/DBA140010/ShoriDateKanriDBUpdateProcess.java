/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA140010;

import jp.co.ndensan.reams.db.dba.definition.processprm.dba140010.JyukiRendoTorokushaListBatchProcessParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jyukirendojouhou.IJyukiRendoJouhouMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタに更新します。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
public class ShoriDateKanriDBUpdateProcess extends SimpleBatchProcessBase {

    private static final RString 処理名 = new RString("住基連動登録者リスト");
    private static final RString 処理枝番 = new RString("0000");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度内連番 = new RString("0000");
    private static final int 日付桁数 = 8;
    private IJyukiRendoJouhouMapper jyukiRendoJouhouMapper;
    private JyukiRendoTorokushaListBatchProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        jyukiRendoJouhouMapper = getMapper(IJyukiRendoJouhouMapper.class);
    }

    @Override
    protected void process() {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setTaishoKaishiYMD(new FlexibleDate(processParameter.getKonkaikaishiYMDHMS()
                .replace("-", "").substring(0, 日付桁数)));
        entity.setTaishoShuryoYMD(new FlexibleDate(processParameter.getKonkaishuryoYMDHMS()
                .replace("-", "").substring(0, 日付桁数)));
        if (processParameter.getZenkaikaishiYMDHMS() == null && processParameter.getZenkaishuryoYMDHMS() == null) {
            entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            entity.setShichosonCode(AssociationFinderFactory.createInstance().getAssociation()
                    .get地方公共団体コード());
            entity.setShoriName(処理名);
            entity.setShoriEdaban(処理枝番);
            entity.setNendo(年度);
            entity.setNendoNaiRenban(年度内連番);
            jyukiRendoJouhouMapper.insertShoriDateKanri(entity);
        } else {
            entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            entity.setShoriName(処理名);
            jyukiRendoJouhouMapper.updateShoriDateKanri(entity);
        }
    }
}
