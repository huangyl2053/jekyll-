/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * HihonkenshanoResultのクラスです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HihonkenshaNoResult implements IDbAccessable {

    private RString hihonkenshaNo;

    /**
     * HihonkenshanoResult のコンストラクタです。
     */
    public HihonkenshaNoResult() {
    }

    /**
     * HihonkenshanoResultのコンストラクタです。
     *
     * @param hihonkenshaNo RString
     */
    public HihonkenshaNoResult(RString hihonkenshaNo) {
        this.hihonkenshaNo = hihonkenshaNo;
    }

}
