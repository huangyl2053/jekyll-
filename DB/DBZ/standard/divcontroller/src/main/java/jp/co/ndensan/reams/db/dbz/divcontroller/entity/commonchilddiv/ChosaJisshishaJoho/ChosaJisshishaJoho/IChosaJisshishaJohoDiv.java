package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho;

import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IChosaJisshishaJohoDiv extends ICommonChildDivBaseProperties {
    
    /**
     * 調査実施者(記入者)Divの初期化します。
     * @param key 親画面から受け取ったパラメータ
     */
    public void intialize(ChosaJisshishaJohoModel key);
    
    /**
     * 画面モードの設定します。
     * @param value モード
     */
    public void setMode_State( ChosaJisshishaJohoDiv.State value );
}
