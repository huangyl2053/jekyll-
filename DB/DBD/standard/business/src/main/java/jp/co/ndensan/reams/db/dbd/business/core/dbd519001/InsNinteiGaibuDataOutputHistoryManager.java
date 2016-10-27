/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd519001;

import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.Datakubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.InsNinteiGaibuDataOutputHistoryProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 要介護認定外部データ出力履歴_business処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class InsNinteiGaibuDataOutputHistoryManager {

    /**
     * 要介護認定外部データ出力履歴。
     *
     * @param entity DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity
     * @param parameter InsNinteiGaibuDataOutputHistoryProcessParameter
     */
    public void set要介護認定外部データ出力履歴(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity,
            InsNinteiGaibuDataOutputHistoryProcessParameter parameter) {
        entity.setDataOutputKaishiYMDHMS(parameter.get開始日時());
        entity.setDataOutputShuryoYMDHMS(parameter.get終了日時());
    }

    /**
     * 要介護認定外部データ出力履歴。
     *
     * @param parameter InsNinteiGaibuDataOutputHistoryProcessParameter
     * @return DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity
     */
    public DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity get出力履歴(InsNinteiGaibuDataOutputHistoryProcessParameter parameter) {
        DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity = new DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity();
        entity.setDataKubun(new Code(Datakubun.申請情報.getコード()));
        entity.setDataOutputKaishiYMDHMS(parameter.get開始日時());
        entity.setDataOutputShuryoYMDHMS(parameter.get終了日時());
        return entity;
    }
}
