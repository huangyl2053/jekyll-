/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishorenchotate;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyuKetteiTsuchisho {

    private SofubutsuAtesakiSource 送付物宛先;
    private RString 文書番号;
    private FlexibleDate 発行日;
    private RString title;
    private RString title21;
    private RString title221;
    private RString title222;
    private RString title231;
    private RString title232;
    private RString title24;
    private RString 文書1;
    private RString 被保険者氏名;
    private HihokenshaNo 被保険者番号;
    private DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity 事業高額合算支給不支給決定;
    private IKoza 口座情報;
    private RString 文書2;
    private RString 文書3;
    private RString 文書4;
    private RString 文書5;
    private RString 文書6;
    private RString 文書7;
    private RString 通番;

}
