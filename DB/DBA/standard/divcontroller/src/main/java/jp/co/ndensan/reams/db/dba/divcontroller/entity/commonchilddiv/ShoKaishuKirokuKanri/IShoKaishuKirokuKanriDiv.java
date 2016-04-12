package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-1070-020 lizhuoxuan
 */
public interface IShoKaishuKirokuKanriDiv extends ICommonChildDivBaseProperties {

    void initialize(RString 状態, HihokenshaNo 被保険者番号);
}
