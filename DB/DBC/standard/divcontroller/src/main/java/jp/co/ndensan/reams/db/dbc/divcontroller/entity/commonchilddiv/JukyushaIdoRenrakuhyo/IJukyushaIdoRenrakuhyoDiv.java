package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public interface IJukyushaIdoRenrakuhyoDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面初期化のメソッドです。
     *
     * @param 処理モード RString
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 int
     * @param 論理削除フラグ boolean
     * @param 異動日 FlexibleDate
     */
    public void initialize(RString 処理モード, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            int 履歴番号, boolean 論理削除フラグ, FlexibleDate 異動日);

    /**
     * 「事業区分」操作制御のメソッドです。
     *
     */
    public void onClick_radNijiyoboJigyoKubun();

    /**
     * 「計画作成区分」操作制御のメソッドです。
     *
     */
    public void onClick_radKyotakuServiceSakuseiKubun();

    /**
     * 異動日focus outのメソッドです。
     *
     */
    public void onBlur_txtIdoYMD();

    /**
     * 支援事業者番号focus outのメソッドです。
     *
     */
    public void onBlur_txtKyotakuKaigoShienJigyoshoNo();

    /**
     * 住所地特例の保険者番号focus outのメソッドです。
     *
     */
    public void onBlur_txtShisetsuShozaiHokenjaNo();

    /**
     * (共有子Div)受給者異動連絡票バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck();

    /**
     * 受給者異動送付をを取得のメソッドです。
     *
     * @return JukyushaIdoRenrakuhyo
     */
    public JukyushaIdoRenrakuhyo get受給者異動送付();

    /**
     * 出力用受給者訂正情報Entityをを取得のメソッドです。
     *
     * @return JukyushaIdoRenrakuhyoSakuseiRelateEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity get受給者訂正連絡票Entity();

    /**
     * 出力用受給者異動連絡票Entityをを取得のメソッドです。
     *
     * @return JukyushaIdoRenrakuhyoSakuseiRelateEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity get受給者異動連絡票Entity();

}
