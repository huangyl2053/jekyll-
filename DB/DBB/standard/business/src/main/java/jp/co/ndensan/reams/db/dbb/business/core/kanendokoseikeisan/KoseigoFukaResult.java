/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanendokoseikeisan;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;

/**
 * 更正後賦課情報取得のクラスです。
 *
 * @reamsid_L DBB-9050-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseigoFukaResult implements Serializable {

    private List<FukaJoho> 賦課の情報リスト;
    private ChoshuHoho choshuHoho;

    /**
     * コンストラクタです。
     *
     * @param 賦課の情報リスト List<FukaJoho>
     * @param choshuHoho choshuHoho
     */
    public KoseigoFukaResult(List<FukaJoho> 賦課の情報リスト,
            ChoshuHoho choshuHoho) {
        this.賦課の情報リスト = 賦課の情報リスト;
        this.choshuHoho = choshuHoho;
    }
}
