/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5320001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 認定結果通知書発行出力対象を定義した列挙型です。
 *
 * @reamsid_L DBD-1430-020 lit
 */
public enum ShutsuryokuTaishoKubun implements IRStringConvertable {

    /**
     * 事務広域 <br />
     * コード : 0
     */
    認定結果通知書(new RString("0"), new RString("認定結果通知書")),
    /**
     * サービス変更通知書 <br />
     * コード : 1
     */
    サービス変更通知書(new RString("1"), new RString("サービス変更通知書")),
    /**
     * 要介護度変更通知書 <br />
     * コード : 2
     */
    要介護度変更通知書(new RString("2"), new RString("要介護度変更通知書"));

    private final RString code;
    private final RString name;

    private ShutsuryokuTaishoKubun(RString code, RString name) {
        this.code = code;
        this.name = name;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * Nameを返却します。
     *
     * @return Name
     */
    public RString getName() {
        return this.name;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
