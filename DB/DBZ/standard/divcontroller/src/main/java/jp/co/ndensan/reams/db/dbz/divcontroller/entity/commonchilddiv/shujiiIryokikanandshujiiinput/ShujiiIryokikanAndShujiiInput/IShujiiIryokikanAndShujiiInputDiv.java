package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv.ShoriType;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBZ-1300-140 chengsanyuan
 */
public interface IShujiiIryokikanAndShujiiInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面にセットされた内容をクリアします。
     *
     * @param shichosonCode 市町村コード
     * @param shinseishoKanriNo 申請書管理番号
     * @param gyomuCode サブ業務コード
     */
    void initialize(LasdecCode shichosonCode, ShinseishoKanriNo shinseishoKanriNo, SubGyomuCode gyomuCode);

    /**
     * 画面にセットされた内容を設定します。
     *
     * @param shichosonCode 市町村コード
     * @param shinseishoKanriNo 申請書管理番号
     * @param gyomuCode サブ業務コード
     * @param shujiiIryokikanCode 主治医医療機関コード
     * @param iryoKikanMeisho 医療機関名称
     * @param shujiiCode 主治医コード
     * @param shujiiName 主治医氏名
     */
    void initialize(LasdecCode shichosonCode, ShinseishoKanriNo shinseishoKanriNo, SubGyomuCode gyomuCode, RString shujiiIryokikanCode,
            RString iryoKikanMeisho, RString shujiiCode, RString shujiiName);

    /**
     * 主治医コードを取得します
     *
     * @return RString
     */
    RString getShujiiCode();

    /**
     * 主治医医療機関コードを取得します
     *
     * @return RString
     */
    RString getIryoKikanCode();

    /**
     * 主治医医療機関名称を取得します
     *
     * @return RString
     */
    RString getIryoKikanName();

    /**
     * 主治医名称を取得します
     *
     * @return RString
     */
    RString getShujiiName();

    /**
     * 主治医への連絡事項を取得します
     *
     * @return RString
     */
    RString getRenrakuJiko();

    /**
     * 主治医への連絡事項を設定します
     *
     * @param renrakuJiko 主治医への連絡事項
     */
    void setRenrakuJiko(RString renrakuJiko);

    /**
     * 指定医を取得します
     *
     * @return TRUE:指定医有り FALSE:指定医なし
     */
    boolean hasShiteii();

    /**
     * 指定医を設定します
     *
     * @param isChecked TRUE:指定医有り FALSE:指定医なし
     */
    void setShiteii(boolean isChecked);

    /**
     * テキストボックスのクリア
     */
    void clear();

    /**
     * ShoriTypeの設定
     *
     * @param value ShoriType
     */
    void setMode_ShoriType(ShoriType value);

    /**
     * txtIryoKikanCodeの設定
     *
     * @param txtIryoKikanCode TextBoxCode
     */
    public void setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode);

    /**
     * txtIryoKikanNameの設定
     *
     * @param txtIryoKikanName TextBox
     */
    public void setTxtIryoKikanName(TextBox txtIryoKikanName);

    /**
     * txtShujiiCodeの設定
     *
     * @param txtShujiiCode TextBoxCode
     */
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode);

    /**
     * txtShujiiNameの設定
     *
     * @param txtShujiiName TextBox
     */
    public void setTxtShujiiName(TextBox txtShujiiName);
}
