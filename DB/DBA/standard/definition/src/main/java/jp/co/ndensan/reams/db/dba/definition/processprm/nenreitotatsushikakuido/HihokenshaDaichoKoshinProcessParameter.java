/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsushikakuido.AtenaMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格異動対象者情報取得_バッチ用のパラメータです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoKoshinProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 開始日;
    private FlexibleDate 終了日;

    /**
     * 抽出条件の生成のMybatisパラメータを作成します。
     *
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     * @param 開始日
     * @param 終了日
     * @return 抽出条件の生成のMybatisパラメータ
     */
    public AtenaMybatisParameter toAtenaMybatisParameter(IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey,
            FlexibleDate 開始日, FlexibleDate 終了日) {

        return new AtenaMybatisParameter(shikibetsuTaishoPSMSearchKey, this.開始日, this.終了日);
    }
}
