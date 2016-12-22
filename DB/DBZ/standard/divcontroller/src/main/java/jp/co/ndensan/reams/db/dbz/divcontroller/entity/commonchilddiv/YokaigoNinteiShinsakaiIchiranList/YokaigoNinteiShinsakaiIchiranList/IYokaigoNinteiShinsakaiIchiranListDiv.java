package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBE-0120-010 lishengli
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
     */
    void get開催番号();

    /**
     * 選択チェックBOXを行います。
     *
     * @return List<開催番号>
     */
    List<RString> get開催番号List();

    /**
     * 一覧件数を取得する。
     *
     * @return 一覧件数
     */
    int get一覧件数();

    /**
     * SelectedGridLineを取得する。
     *
     */
    void getSelectedGridLine();

    /**
     * 一覧グリッドの高さを指定します。
     *
     * @param height 指定する高さ
     */
    void set一覧グリッド高さ指定(RString height);
}
