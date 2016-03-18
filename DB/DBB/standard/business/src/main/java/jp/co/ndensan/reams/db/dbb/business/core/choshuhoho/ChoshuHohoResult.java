/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuhoho;

import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護徴収方法のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoshuHohoResult {

    private final ChoshuHoho hoho;
    private RString choshuHoho3gat;

    /**
     * コンストラクタです。
     *
     * @param hoho ChoshuHoho
     * @param choshuHoho3gat RString
     */
    public ChoshuHohoResult(ChoshuHoho hoho, RString choshuHoho3gat) {
        this.hoho = hoho;
        this.choshuHoho3gat = choshuHoho3gat;
    }

}
