/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4040011;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 障がい者控除対象者認定画面のパラメータ
 *
 * @reamsid_L DBD-3870-010 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoNinteishoParameter implements IMyBatisParameter {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
}
