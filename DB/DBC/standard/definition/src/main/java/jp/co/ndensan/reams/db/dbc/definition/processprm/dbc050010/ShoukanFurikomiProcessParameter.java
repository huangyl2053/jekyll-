/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiIchiranChushutsuTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.ShoukanFurikomiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 償還のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanFurikomiProcessParameter implements IBatchProcessParameter {

    private Furikomi_ShihraiHohoShitei 支払方法;
    private Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象;
    private boolean 再処理フラグ;
    private FlexibleDate 開始年月日;
    private FlexibleDate 終了年月日;
    private FlexibleDate 対象作成年月日;

    /**
     * コンストラクタ
     *
     * @param 支払方法 Furikomi_ShihraiHohoShitei
     * @param 抽出対象 Furikomi_MeisaiIchiranChushutsuTaisho
     * @param 再処理フラグ boolean
     * @param 開始年月日 FlexibleDate
     * @param 終了年月日 FlexibleDate
     * @param 対象作成年月日 FlexibleDate
     */
    public ShoukanFurikomiProcessParameter(Furikomi_ShihraiHohoShitei 支払方法, Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象,
            boolean 再処理フラグ, FlexibleDate 開始年月日, FlexibleDate 終了年月日, FlexibleDate 対象作成年月日) {
        this.支払方法 = 支払方法;
        this.抽出対象 = 抽出対象;
        this.再処理フラグ = 再処理フラグ;
        this.開始年月日 = 開始年月日;
        this.終了年月日 = 終了年月日;
        this.対象作成年月日 = 対象作成年月日;
    }

    /**
     * データ取得のMybaticParameter作成する。
     *
     * @return {@link KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter}
     */
    public ShoukanFurikomiMybatisParameter toFurikomimeisaiFurikomiMybatisParameter() {
        return new ShoukanFurikomiMybatisParameter(支払方法, 抽出対象, 再処理フラグ, 開始年月日, 終了年月日, 対象作成年月日);
    }
}
