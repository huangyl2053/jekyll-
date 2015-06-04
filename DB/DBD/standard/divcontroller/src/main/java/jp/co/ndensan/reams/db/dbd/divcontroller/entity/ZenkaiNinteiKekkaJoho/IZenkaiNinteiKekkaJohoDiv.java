package jp.co.ndensan.reams.db.dbd.divcontroller.entity.ZenkaiNinteiKekkaJoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IZenkaiNinteiKekkaJohoDiv extends ICommonChildDivBaseProperties {

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
     * Divロード時の処理を行います。
     */
    void onLoad();

    /**
     * 共有子Div情報を全てクリアします。
     */
    void clear();
}
