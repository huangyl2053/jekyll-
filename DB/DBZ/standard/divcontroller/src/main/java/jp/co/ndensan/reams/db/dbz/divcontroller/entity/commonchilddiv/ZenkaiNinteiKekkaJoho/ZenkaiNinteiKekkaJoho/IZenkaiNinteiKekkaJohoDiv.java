package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBE-3000-020 dongyabin
 */
public interface IZenkaiNinteiKekkaJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 前回認定結果Divの初期化です。
     *
     * @param subGyomuCode 画面モード
     * @param shinseishoKanriNo 申請書管理番号
     * @param 参照結果 参照結果
     */
    public void onLoad(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo,
            RString 参照結果);

    public TextBox getTxtYokaigodo();

    public void setTxtYokaigodo(TextBox txtYokaigodo);

    public TextBoxFlexibleDate getTxtNinteiDay();

    public void setTxtNinteiDay(TextBoxFlexibleDate txtNinteiDay);

    public TextBoxFlexibleDate getTxtYukoKikanFrom();

    public void setTxtYukoKikanFrom(TextBoxFlexibleDate txtYukoKikanFrom);

    public TextBoxFlexibleDate getTxtYukoKikanTo();

    public void setTxtYukoKikanTo(TextBoxFlexibleDate txtYukoKikanTo);

    public void setMode_ShokaiButtonType(ShokaiButtonType value);
}
