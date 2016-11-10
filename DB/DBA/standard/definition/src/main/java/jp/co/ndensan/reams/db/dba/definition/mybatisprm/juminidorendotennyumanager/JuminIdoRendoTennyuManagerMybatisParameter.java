/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminidorendotennyumanager;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録_転入のMyBatisパラメータ。
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JuminIdoRendoTennyuManagerMybatisParameter implements IMyBatisParameter {

    private final RString 宛名識別対象PSM;
    private final ShikibetsuCode 転出識別コード;

    /**
     * コンストラクタです。
     *
     * @param 転出識別コード 転出識別コード
     * @param 宛名識別対象PSM 宛名識別対象PSM
     */
    protected JuminIdoRendoTennyuManagerMybatisParameter(RString 宛名識別対象PSM,
            ShikibetsuCode 転出識別コード) {
        this.宛名識別対象PSM = 宛名識別対象PSM;
        this.転出識別コード = 転出識別コード;
    }

    /**
     * コンストラクタです。
     *
     * @param 転出識別コード 転出識別コード
     * @param 宛名識別対象PSM 宛名識別対象PSM
     * @return AtenaSealCreateShutsuMybatisParameter
     */
    public static JuminIdoRendoTennyuManagerMybatisParameter creatParameter(RString 宛名識別対象PSM, ShikibetsuCode 転出識別コード) {
        return new JuminIdoRendoTennyuManagerMybatisParameter(宛名識別対象PSM, 転出識別コード);
    }
}
