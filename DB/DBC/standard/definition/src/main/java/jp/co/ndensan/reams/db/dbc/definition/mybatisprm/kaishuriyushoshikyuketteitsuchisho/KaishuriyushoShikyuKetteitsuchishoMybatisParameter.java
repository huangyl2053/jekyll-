/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaishuriyushoshikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KaishuriyushoShikyuKetteitsuchishoMybatisParameter implements IMyBatisParameter {

    private RString 市町村コード;
    private final RString サブ業務コード = new RString("DBC");
    private final RString 処理名 = new RString("住宅改修理由書作成手数料支給（不支給）決定通知書作成");

    private KaishuriyushoShikyuKetteitsuchishoMybatisParameter(RString 市町村コード) {
        this.市町村コード = 市町村コード;
    }

    /**
     * 前回の実行情報取得のパラメータを作成します。
     *
     * @param 市町村コード 市町村コード
     * @return KaishuriyushoShikyuKetteitsuchishoMybatisParameter
     */
    public static KaishuriyushoShikyuKetteitsuchishoMybatisParameter create前回の実行情報取得パラメータ(RString 市町村コード) {
        return new KaishuriyushoShikyuKetteitsuchishoMybatisParameter(市町村コード);
    }

}
