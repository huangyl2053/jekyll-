/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始通知書(本算定）の発行する用パラメータクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class PrtTokuchoKaishiTsuchishoHonsanteiParameter implements IMyBatisParameter {

    private final RString 出力対象;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 出力対象 RString
     * @param 出力順 RString
     */
    private PrtTokuchoKaishiTsuchishoHonsanteiParameter(
            RString 出力対象,
            RString 出力順) {
        this.出力対象 = 出力対象;
        this.出力順 = 出力順;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 出力対象 RString
     * @param 出力順 RString
     * @return PrtTokuchoKaishiTsuchishoHonsanteiParameter パラメータ
     */
    public static PrtTokuchoKaishiTsuchishoHonsanteiParameter createSelectByKeyParam(
            RString 出力対象,
            RString 出力順) {
        return new PrtTokuchoKaishiTsuchishoHonsanteiParameter(出力対象, 出力順);
    }
}
