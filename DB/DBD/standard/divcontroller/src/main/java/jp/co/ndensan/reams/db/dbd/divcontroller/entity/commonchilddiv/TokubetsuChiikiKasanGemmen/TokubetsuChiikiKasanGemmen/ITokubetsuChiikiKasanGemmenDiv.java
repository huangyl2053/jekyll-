package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;

/*
 * このコードはツールによって生成されました。
 *
 *@reamsid_L DBD-3560-070 wangjie2
 */
public interface ITokubetsuChiikiKasanGemmenDiv extends ICommonChildDivBaseProperties, IDialogDiv {

    public List<TokubetsuchiikiKasanGemmen> initializa(HihokenshaNo 被保険者番号);

}
