package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoDailogButton;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ISeikatsuHogoJohoDailogButtonDiv extends ICommonChildDivBaseProperties {

    /**
     * 医療保険履歴ダイアログBTNの初期化を行います。
     *
     * @param shikibetsuCode 識別コード
     * @param gyomuCode 業務コード
     */
    void initialize(RString shikibetsuCode, RString gyomuCode);
}
