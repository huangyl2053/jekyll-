package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBE-1300-140 chengsanyuan
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
     * 指定医を取得します
     *
     * @return TRUE:指定医有り FALSE:指定医なし
     */
    boolean hasShiteii();
}
