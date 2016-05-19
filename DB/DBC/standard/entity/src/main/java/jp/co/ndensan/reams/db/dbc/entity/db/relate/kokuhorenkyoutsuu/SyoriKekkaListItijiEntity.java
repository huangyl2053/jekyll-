/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理結果リスト一時TBLエンティティです。
 *
 * @reamsid_L DBC-0980-550 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyoriKekkaListItijiEntity implements Serializable {

    private KokuhorenJoho_TorikomiErrorKubun エラー区分;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private RString キー1;
    private RString キー2;
    private RString キー3;
    private RString キー4;
    private RString キー5;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private RString 備考;

}
