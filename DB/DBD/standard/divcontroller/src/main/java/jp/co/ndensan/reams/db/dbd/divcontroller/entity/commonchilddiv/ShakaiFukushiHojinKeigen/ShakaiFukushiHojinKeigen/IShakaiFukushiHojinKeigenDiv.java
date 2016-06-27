package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBD-3560-050 wangjie2
 */
public interface IShakaiFukushiHojinKeigenDiv extends ICommonChildDivBaseProperties, IDialogDiv {

    public List<ShakaifukuRiyoshaFutanKeigen> initializa(HihokenshaNo 被保険者番号);

}
