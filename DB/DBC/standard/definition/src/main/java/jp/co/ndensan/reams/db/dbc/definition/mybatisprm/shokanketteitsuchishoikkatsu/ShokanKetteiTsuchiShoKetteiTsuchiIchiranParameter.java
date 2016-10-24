/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書一括作成_決定通知一覧表帳票データ取得のMyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter implements IMyBatisParameter {

    private final RString 出力順;
    private final boolean has出力順;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param has出力順 出力順存在かどうか
     * @param 出力順 出力順
     * @param psmShikibetsuTaisho 宛名識別対象
     */
    private ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter(boolean has出力順, RString 出力順, RString psmShikibetsuTaisho) {
        this.has出力順 = has出力順;
        this.出力順 = 出力順;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * コンストラクタです。
     *
     * @param 出力順 出力順
     * @param psmShikibetsuTaisho 宛名識別対象
     * @return 償還払い支給（不支給）決定通知書一括作成_決定通知一覧表帳票データ取得のMyBatisパラメータクラス
     */
    public static ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter toMybatisParameter(RString 出力順, RString psmShikibetsuTaisho) {
        return new ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter(!RString.isNullOrEmpty(出力順), 出力順, psmShikibetsuTaisho);
    }
}
