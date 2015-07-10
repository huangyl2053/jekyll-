package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestKaigoNinteiAtenaInfo.TestKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaigoNinteiAtenaInfoDiv extends ICommonChildDivBaseProperties {

    /**
     * 介護導入形態の値を設定します。(隠し項目)
     * 
     * @param hdnKaigoDonyuKeitai 介護導入形態の値
     */
    void setHdnKaigoDonyuKeitai(RString hdnKaigoDonyuKeitai);
    
    /**
     * 処理タイプの値を設定します。 (隠し項目)
     * @param hdnShoriType 処理タイプの値
     */
    void setHdnShoriType(RString hdnShoriType);
    /**
     * メモ識別区分を設定します。 
     * 
     * @param MemoShikibetsuKubun メモ識別区分
     */
    void setMemoShikibetsuKubun(RString MemoShikibetsuKubun);
    
    /**
     * 業務コードを設定します。(隠し項目)
     * 
     * @param hdnSubGyomuCode 業務コード
     */
    void setHdnSubGyomuCode(RString hdnSubGyomuCode);

    /**
     * 初期化
     */
     void initialize();
    
     /**
     *  (テスト用)
     * @param div TestKaigoNinteiAtenaInfoDiv
     */
    void onLoad(TestKaigoNinteiAtenaInfoDiv div);

}
