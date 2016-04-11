package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-0210-010 dingyi
 */
public interface ITekiyoJogaiRirekiDiv extends ICommonChildDivBaseProperties {

    /**
     * 状態の設定します。
     *
     * @param mode mode
     */
    public void set状態(RString mode);

    /**
     * 適用除外者管理に初期化を設定します。
     *
     * @param 識別コード 識別コード
     */
    public void initialize(ShikibetsuCode 識別コード);

    /**
     * 適用除外者管理の共有子DIVの画面内容から、適用除外者情報をDBに反映します。
     *
     * @param 識別コード 識別コード
     */
    public void saveTekiyoJogaisha(ShikibetsuCode 識別コード);

}
