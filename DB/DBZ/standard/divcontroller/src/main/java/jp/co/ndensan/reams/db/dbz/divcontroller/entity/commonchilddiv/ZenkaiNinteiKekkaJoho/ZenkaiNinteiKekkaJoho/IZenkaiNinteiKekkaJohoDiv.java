package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IZenkaiNinteiKekkaJohoDiv extends ICommonChildDivBaseProperties {
    
    /**
     * 前回認定結果Divの初期化です。
     * @param subGyomuCode 画面モード
     * @param shinseishoKanriNo 申請書管理番号
     * @param 参照結果 参照結果
     */
    public void onLoad(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo,
            RString 参照結果);
}
