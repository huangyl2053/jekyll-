package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;

import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.TekiyoJogaiRirekiDiv.DisplayMode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 適用除外履歴Divであることを表します。
 * <p/>
 * ファサドとして利用します。
 *
 * @reamsid_L DBA-0210-010 dingyi
 */
public interface ITekiyoJogaiRirekiDiv extends ICommonChildDivBaseProperties {

    /**
     * 状態の設定します。
     *
     * @param mode mode
     * @deprecated どんな値が設定できるか全くわからない。
     */
    public void set状態(RString mode);

    /**
     * モード:DisplayMode を設定します。
     *
     * @param mode DisplayModeの設定値
     */
    public void setDiplayMode(DisplayMode mode);

    /**
     * 適用除外者管理に初期化を設定します。
     *
     * @param 識別コード 識別コード
     */
    public void initialize(ShikibetsuCode 識別コード);

    /**
     * 適用除外者管理の共有子DIVの画面内容から、適用除外者情報をDBに反映します。
     *
     * @param 識別コード 識別コード
     */
    public void saveTekiyoJogaisha(ShikibetsuCode 識別コード);

    /**
     * 適用情報一覧を取得します。
     *
     * @return 適用情報一覧 適用情報一覧
     */
    public List<datagridTekiyoJogai_Row> get適用情報一覧();

}
