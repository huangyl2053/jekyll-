/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.UpdateProcessParameter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.IDbT5201NinteichosaIraiJohoMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報テーブルの更新処理のクラスです。
 */
public class UpadteDataProcess extends SimpleBatchProcessBase {

    private UpdateProcessParameter processParameter;
    private IDbT5201NinteichosaIraiJohoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IDbT5201NinteichosaIraiJohoMapper.class);

    }

    @Override
    @Transaction
    protected void process() {

        List<RString> noList = processParameter.get申請書管理番号List();
        for (RString shinseishoKanriNo : noList) {
            
            LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue()
                    .concat(new RString("ShinseishoKanriNo")).concat(shinseishoKanriNo)); 
            boolean getLock = RealInitialLocker.tryGetLock(排他キー); 
            if (getLock) {
                mapper.update認定調査依頼情報BY申請書管理番号(processParameter.toNinteiChosaTokusokujoMybatisParameter(shinseishoKanriNo));
                RealInitialLocker.release(排他キー); 
            } else { 
                throw new ApplicationException(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage()); 
            }
        }
    }

}
