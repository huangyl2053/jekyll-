package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITaJushochiTokureishaKanriDiv extends ICommonChildDivBaseProperties {

    /**
     * 状態の設定すます。
     *
     * @param mode mode
     */
    public void set状態(RString mode);

    /**
     * 他住所地特例者管理に初期化を設定します
     *
     * @param 識別コード 識別コード
     */
    public void initialize(ShikibetsuCode 識別コード);

    /**
     * 他住所地特例者の共有子DIVの画面内容から、他市町村住所地特例情報をDBに反映します。
     */
    public void saveTaJushochiTokurei();
}
