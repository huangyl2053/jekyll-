/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jukyusyaidoujohorirek;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * JukyushaIdoRenrakuhyoErrorTeisei_1_受給者異動連絡票エラー訂正のEntityクラスです。
 *
 * @reamsid_L DBC-2720-080 liuxiaoyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyusyaIdouJohoRirekEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private FlexibleDate 異動日;
    private HihokenshaNo 被保番号;
    private RString かな氏名;
    private RString 項目;
}
