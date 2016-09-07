package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IYokaigoNinteiTaskListDiv extends ICommonChildDivBaseProperties {

    public abstract void initialize(RString モード);

    public abstract RString 一覧件数();

    public abstract List<dgNinteiTaskList_Row> getCheckbox();

    public abstract List<dgNinteiTaskList_Row> getDataSource();
}
