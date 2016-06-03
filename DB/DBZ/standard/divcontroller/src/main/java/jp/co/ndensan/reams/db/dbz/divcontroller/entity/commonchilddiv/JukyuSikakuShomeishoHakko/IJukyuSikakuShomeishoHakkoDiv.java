package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuSikakuShomeishoHakko;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-1090-010 wangkun
 */
public interface IJukyuSikakuShomeishoHakkoDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面初期化しました。
     *
     * @param 被保険者番号
     */
    public abstract void initialize(RString 被保険者番号);

    /**
     * PanelのDivを取得しました。
     *
     * @return JukyuSikakuShomeishoHakkoDiv JukyuSikakuShomeishoHakkoDiv
     */
    public abstract JukyuSikakuShomeishoHakkoDiv getJukyuSikakuShomeishoHakkoDiv();

}
