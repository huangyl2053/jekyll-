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
     * @param モード モード
     */
    void initialize(RString モード);

    /**
     * 選択アイコン押下を行います。
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

    /**
     * モード_開催予定登録
     */
    public static final RString モード_開催予定登録 = new RString("kaisaiYoteiToroku");
    /**
     * モード_対象者割付
     */
    public static final RString モード_対象者割付 = new RString("taishoshaWaritsuke");
    /**
     * モード_対象者割付_自動割付使用不可
     */
    public static final RString モード_対象者割付_自動割付使用不可 = new RString("taishoshaWaritsuke_UnUseAutoWaritsuke");
    /**
     * モード_委員割付
     */
    public static final RString モード_委員割付 = new RString("iinWaritsuke");
    /**
     * モード_審査会資料
     */
    public static final RString モード_審査会資料 = new RString("shinsakaiShiryoSakusei");
    /**
     * モード_審査結果登録
     */
    public static final RString モード_審査結果登録 = new RString("shinsaKekkaToroku");
    /**
     * モード_事前結果登録
     */
    public static final RString モード_事前結果登録 = new RString("jizenKekkaToroku");
    /**
     * モード_データ出力
     */
    public static final RString モード_データ出力 = new RString("dataShutsuryoku");
    /**
     * モード_判定結果
     */
    public static final RString モード_判定結果 = new RString("hanteiKekka");
}
