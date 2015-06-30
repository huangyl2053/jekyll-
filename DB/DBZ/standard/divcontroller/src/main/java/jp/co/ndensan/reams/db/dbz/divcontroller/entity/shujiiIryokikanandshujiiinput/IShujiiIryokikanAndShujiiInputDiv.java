package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shujiiIryokikanandshujiiinput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShujiiIryokikanAndShujiiInputDiv extends ICommonChildDivBaseProperties {

    /**
     * サブ業務コードを設定します。
     *
     * @param hdnDatabaseSubGyomuCode サブ業務コード
     */
    void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode);

    /**
     * 共有子Div「市町村連絡事項」で入力された内容を取得します。
     *
     * @return 入力された連絡事項
     */
    RString getHdnShujiiRenrakuJiko();

    /**
     * 申請書管理番号をセットします。
     *
     * @param hdnShinseishoKanriNo 申請書管理番号
     */
    void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo);

    /**
     * 市町村コードをセットします。
     *
     * @param hdnShichosonCode 市町村コード
     */
    void setHdnShichosonCode(RString hdnShichosonCode);

    /**
     * 画面にセットされた内容をクリアします。
     */
    void clear();

    RString getShujiiCode();

    RString getIryoKikanCode();

    boolean getShiteiiFlag();

    void setTxtIryoKikanCode(RString iryoKikanCode);

    void setTxtIryoKikanName(RString iryoKikanName);

    void setTxtShujiiCode(RString shujiiCode);

    void setTxtShujiiName(RString shujiiName);

    void setChkShiteii(RString chkShiteii);

    void setShiteiiFlag(boolean shiteiiFlag);

    void onBlurTxtShujiiIryokikanCode();

    void onBlurTxtShujiiCode();

}
