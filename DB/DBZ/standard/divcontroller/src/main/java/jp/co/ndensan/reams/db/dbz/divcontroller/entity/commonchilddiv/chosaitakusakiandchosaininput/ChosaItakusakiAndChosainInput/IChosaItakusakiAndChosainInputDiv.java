package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBZ-1300-030 zhangguopeng
 */
public interface IChosaItakusakiAndChosainInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 共有子Divの初期化を行います。
     *
     * @param モード モード
     */
    void initialize(RString モード);

    /**
     * 共有子Divの初期化を行います。
     *
     * @param モード モード
     * @param 調査委託先コード 調査委託先コード
     * @param 調査委託先名 調査委託先名
     * @param 調査員コード 調査員コード
     * @param 調査員名 調査員名
     */
    void initialize(RString モード, RString 調査委託先コード, RString 調査委託先名, RString 調査員コード, RString 調査員名);

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
