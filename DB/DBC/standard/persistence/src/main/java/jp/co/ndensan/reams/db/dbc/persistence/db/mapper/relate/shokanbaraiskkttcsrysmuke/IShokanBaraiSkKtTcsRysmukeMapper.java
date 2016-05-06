/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraiskkttcsrysmuke;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanbaraiskkttcsrysmuke.ShokanBaraiSkKtTcsRysmukeParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraiskkttcsrysmuke.ShokanBaraiSkKtTcsRysmukeEntity;

/**
 * 償還払い支給（不支給）決定通知書（利用者向け）に対するマッパーインタフェースです
 *
 * @reamsid_L DBC-1000-050 chengsanyuan
 */
public interface IShokanBaraiSkKtTcsRysmukeMapper {

    /**
     * 受任者情報を取得します。
     *
     * @param param パラメータ
     * @return ShokanBaraiSkKtTcsRysmukeEntity
     */
    ShokanBaraiSkKtTcsRysmukeEntity get受任者情報(ShokanBaraiSkKtTcsRysmukeParameter param);

}
