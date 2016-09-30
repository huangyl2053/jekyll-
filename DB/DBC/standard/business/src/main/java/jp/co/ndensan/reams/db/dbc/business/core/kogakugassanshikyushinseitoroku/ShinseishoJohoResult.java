/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyushinseitoroku;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請書情報検索結果です。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseishoJohoResult {

    private KogakuGassanShinseisho 高額合算申請書;
    private AtenaMeisho 被保険者名;
    private ShikibetsuCode 識別コード;
}
