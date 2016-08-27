/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表発行_SQL使用パラメタークラスです.
 *
 * @reamsid_L DBD-3981-050 x_miaocl
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenListMybatisParameter implements IMyBatisParameter {

    private RString 出力順;
    private RString psmShikibetsuTaisho;

    /**
     * 非課税年金対象者情報_該当一覧の引数を返します。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     */
    public ShakaiFukushiHoujinnKeigenListMybatisParameter(RString psmShikibetsuTaisho, RString 出力順) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.出力順 = 出力順;

    }
}
