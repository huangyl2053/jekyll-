package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoUploadPanel.KaigoUploadPanel;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * アップロードダイアログのハンドラークラスです。
 *
 * @reamsid_L DBZ-4530-010 houtianpeng
 */
public interface IKaigoUploadPanelDiv extends ICommonChildDivBaseProperties {

    public void setFileName(RString ファイル名称);

    public void setフォルダ(RString 出力先フォルダ);

    public void setToJiRu();

    public void initialize(RString 処理モード);

}
