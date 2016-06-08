package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IBunshoBangoInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 共有子Divの初期化を行います。
     *
     * @param 帳票ID 帳票ID
     */
    void initialize(ReportId 帳票ID);

    /**
     * 共有子Divの初期化を行います。
     *
     * @param 帳票ID 帳票ID
     * @param 基準日 基準日
     */
    void initialize(ReportId 帳票ID, FlexibleDate 基準日);

    /**
     * 「文書番号記号」「ヘッダー文字」「文書番号」「フッター文字」を連結した文字列を返します。（空白の場合はEmptyを返します。）
     *
     * @return RString
     */
    RString get文書番号();

}
