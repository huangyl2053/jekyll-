/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.atenasealcreate;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名シール作成出力順のMyBatisパラメータ。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AtenaSealCreateShutsuMybatisParameter implements IMyBatisParameter {

    private final boolean has出力順;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param has出力順 has出力順
     * @param 出力順 出力順
     */
    protected AtenaSealCreateShutsuMybatisParameter(boolean has出力順,
            RString 出力順) {
        this.has出力順 = has出力順;
        this.出力順 = 出力順;
    }

    /**
     * コンストラクタです。
     *
     * @param has出力順 has出力順
     * @param 出力順 出力順
     * @return AtenaSealCreateShutsuMybatisParameter
     */
    public static AtenaSealCreateShutsuMybatisParameter creatParameter(boolean has出力順, RString 出力順) {
        return new AtenaSealCreateShutsuMybatisParameter(has出力順, 出力順);
    }
}
