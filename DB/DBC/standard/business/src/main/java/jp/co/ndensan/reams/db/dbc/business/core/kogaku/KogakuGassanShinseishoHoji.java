/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算申請書保持データです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoHoji {

    private RString メニューID;
    private RString 申請状態;
    private RString 申請状況;
    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private HokenshaNo 保険者番号;
    private Decimal 履歴番号;
    private Decimal 支給申請書整理番号;
    private RString 整理番号;
    private List<KogakuGassanShinseishoResult> 高額合算申請書;
    private List<KogakuGassanShinseishoKanyurekiResult> 加入歴;
}
