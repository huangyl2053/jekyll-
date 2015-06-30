package jp.co.ndensan.reams.db.dbz.divcontroller.entity.chosaitakusakiandchosaininput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IChosaItakusakiAndChosainInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 調査連絡番号を設定します。
     *
     * @param hdnChosainRenrakuJiko 調査連絡番号
     */
    void setHdnChosainRenrakuJiko(RString hdnChosainRenrakuJiko);

    /**
     * 申請書管理番号を設定します。
     *
     * @param hdnShinseishoKanriNo 申請書管理番号
     */
    void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo);

    /**
     * 業務コードを設定します。
     *
     * @param hdnDatabaseSubGyomuCode 業務コード
     */
    void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode);

    /**
     * 市町村コードを設定します。
     *
     * @param hdnShichosonCode 市町村コード
     */
    void setHdnShichosonCode(RString hdnShichosonCode);

    /**
     * 共有子Divの初期化を行います。
     */
    void onClickBtnClear();

    /**
     * 更新処理を行います。
     */
    void onClickbtnToroku();

    RString getChosain();

    RString getChosaItakusakiCode();

    void setTxtChosaItakusakiCode(RString chosaItakusakiCode);

    void setTxtChosaItakusakiName(RString chosaItakusakiName);

    void setTxtChosainCode(RString chosainCode);

    void setTxtChosainName(RString chosainName);

    void onBlurTxtChosaItakusakiCode();

    void onBlurTxtShujiiCode();
}
