package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBE-1300-080 yaodongsheng
 */
public interface INinteiInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 共通子DIVの初期化処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param subGyomuCode subGyomuCode
     * @param 厚労省IFコード 厚労省IFコード
     */
    public void initialize(ShinseishoKanriNo 申請書管理番号, RString subGyomuCode, RString 厚労省IFコード);

    /**
     * 状態の設定すます。
     *
     * @param mode mode
     */
    public void set状態(RString mode);
}
