package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IChosaItakusakiAndChosainInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 共有子Divの初期化を行います。
     *
     * @param モード モード
     */
    void initialize(RString モード);

    /**
     * 認定調査委託先情報の市町村コード
     *
     * @param HdnShichosonCode 市町村コード
     */
    void setHdnShichosonCode(RString HdnShichosonCode);

    /**
     * 認定調査委託先情報の申請管理番号
     *
     * @param HdnShinseishoKanriNo 申請管理番号
     */
    void setHdnShinseishoKanriNo(RString HdnShinseishoKanriNo);
}
