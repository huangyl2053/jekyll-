package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri;

import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITaJushochiTokureishaKanriDiv extends ICommonChildDivBaseProperties {

    /**
     * 他住所地特例者管理に初期化を設定します
     */
    public void initialize();

    /**
     * 他住所地特例者の共有子DIVの画面内容から、他市町村住所地特例情報をDBに反映します。
     */
    public void saveTaJushochiTokurei();
}
