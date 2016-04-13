package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBA-0230-010 hezhenzhen
 */
public interface IIryohokenRirekiCommonChildDiv extends ICommonChildDivBaseProperties {

    /**
     * 医療保険履歴の初期化処理します。
     *
     * @param モード
     * @param 識別コード
     */
    public abstract void initialize(RString モード, RString 識別コード);

    /**
     * 医療保険履歴の共有子DIVの画面内容から、施設入退所履歴情報をDBに反映します。
     */
    public abstract void save();
    
    /**
     * 医療保険情報を取得します。
     * @return List<dgIryohokenIchiran_Row>
     */
    public abstract List<dgIryohokenIchiran_Row> getDataGridList();

}
