/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.ninteishinseijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;

/**
 * 介護認定外部データ出力履歴を管理するクラスです。
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public class YokaigoNinteiGaibuDataOutputHistory {

    private final DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity
     */
    public YokaigoNinteiGaibuDataOutputHistory(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定外部データ出力履歴"));
        this.entity = entity;
    }

    /**
     * データ区分のgetメソッドです。
     * <br/>
     * <br/>1:申請情報、2:４マスタ、3:資格喪失(死亡)情報
     *
     * @return データ区分
     */
    public Code getDataKubun() {
        return entity.getDataKubun();
    }

    /**
     * データ出力開始年月日時分のgetメソッドです。
     *
     * @return データ出力開始年月日時分
     */
    public YMDHM getDataOutputKaishiYMDHM() {
        return entity.getDataOutputKaishiYMDHM();
    }

    /**
     * データ出力終了年月日時分のgetメソッドです。
     *
     * @return データ出力終了年月日時分
     */
    public YMDHM getDataOutputShuryoYMDHM() {
        return entity.getDataOutputShuryoYMDHM();
    }

}
