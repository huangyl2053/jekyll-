/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanendokoseikeisan;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendokoseikeisan.KoseigoFukaEntity;

/**
 * 更正後賦課情報取得のクラスです。
 *
 * @reamsid_L DBB-9050-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseigoFukaResult implements Serializable {

    private KoseigoFukaEntity entity;
    private ChoshuHoho choshuHoho;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param choshuHoho choshuHoho
     */
    public KoseigoFukaResult(KoseigoFukaEntity entity,
            ChoshuHoho choshuHoho) {
        this.entity = entity;
        this.choshuHoho = choshuHoho;
    }
}
