package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListDataPassModel;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBC-0940-010 yaodongsheng
 */
public interface IJyutakugaisyunaiyoListDiv extends ICommonChildDivBaseProperties {

    public void initialize(JyutakugaisyunaiyoListDataPassModel model);

    public List<dgGaisyuList_Row> get住宅改修内容一覧();
}
