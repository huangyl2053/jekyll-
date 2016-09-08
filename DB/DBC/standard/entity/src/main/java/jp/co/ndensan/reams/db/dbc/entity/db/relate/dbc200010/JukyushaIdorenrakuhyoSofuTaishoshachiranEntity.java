/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200010;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBCMNF1001_1_受給者異動連絡票情報送付対象者リストのEntityクラスです
 *
 * @reamsid_L DBC-2720-040 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdorenrakuhyoSofuTaishoshachiranEntity {

    private RString 被保険者番号;
    private RString 氏名;
    private RString 区分;
    private FlexibleDate 異動年月日;
    private RString 要介護度;

    private FlexibleDate 開始認定日;
    private FlexibleDate 終了認定日;
    private RString 変更項目;

}
