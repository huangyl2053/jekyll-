package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IYokaigoNinteiShinsakaiIchiranListDiv extends ICommonChildDivBaseProperties {

    /**
     * 共有子Divの初期化を行います。
     *
     * @param モード
     */
    void initialize(RString モード);

    /**
     * 選択アイコン押下を行います。
     *
     * @return 開催番号
     */
    RString get開催番号();

    /**
     * 選択チェックBOXを行います。
     *
     * @return List<開催番号>
     */
    List<RString> get開催番号List();
}
