package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiTodokedesha;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface INinteiShinseiTodokedeshaDiv extends ICommonChildDivBaseProperties {

    /**
     * 申請管理番号を設定します。隠しデータ
     *
     * @param hdnShinseishoKanriNo 申請管理番号
     */
    void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo);

    /**
     * 識別コードを設定します。
     *
     * @param hdnShikibetsuCode 識別コード
     */
    void setHdnShikibetsuCode(RString hdnShikibetsuCode);

    /**
     * 申請届出者氏名を設定します。
     *
     * @param hdnShimei 氏名
     */
    void setHdnShimei(RString hdnShimei);

    /**
     * 申請届出者氏名カナを設定します。
     *
     * @param hdnKanaShimei 氏名カナ
     */
    void setHdnKanaShimei(RString hdnKanaShimei);

    /**
     * 申請届出者総柄コードを設定します。
     *
     * @param hdnTsudukigara 申請届出者総柄コード
     */
    void setHdnTsudukigara(RString hdnTsudukigara);

    /**
     * 申請届出者郵便番号を設定します。
     *
     * @param hdnYubinNo 申請届出者郵便番号
     */
    void setHdnYubinNo(RString hdnYubinNo);

    /**
     * 申請届出者住所を設定します。
     *
     * @param hdnJusho 申請届出者住所
     */
    void setHdnJusho(RString hdnJusho);

    /**
     * 申請届出者電話番号を設定します。
     *
     * @param hdnTelNo 申請届出者電話番号
     */
    void setHdnTelNo(RString hdnTelNo);

    /**
     * 業務コードを設定します。
     *
     * @param hdnGyomuCode 業務コード
     */
    void setHdnGyomuCode(RString hdnGyomuCode);

    /**
     * 検索区分を設定します。
     *
     * @param hdnSerchYusenKubun 検索区分
     */
    void setHdnSerchYusenKubun(RString hdnSerchYusenKubun);

    /**
     * 申請届出代行区分コードを取得します。
     *
     * @return 申請届出代行区分コード
     */
    RString get申請届出代行区分コード();

    /**
     * 申請届出代行事業者番号を取得します。
     *
     * @return 申請届出代行事業者番号
     */
    RString get申請届出代行事業者番号();

    /**
     * 事業者区分を取得します。
     *
     * @return 事業者区分
     */
    RString get事業者区分();

    /**
     * 申請届出者氏名を取得します。
     *
     * @return 申請届出者氏名
     */
    RString get申請届出者氏名();

    /**
     * 申請届出者氏名カナを取得します。
     *
     * @return 申請届出者氏名カナ
     */
    RString get申請届出者氏名カナ();

    /**
     * 申請届出者続柄コードを取得します。
     *
     * @return 申請届出者続柄コード
     */
    RString get申請届出者続柄コード();

    /**
     * 申請届出者郵便番号を取得します。
     *
     * @return 申請届出者郵便番号
     */
    YubinNo get申請届出者郵便番号();

    /**
     * 申請届出者電話番号を取得します。
     *
     * @return 申請届出者電話番号
     */
    TelNo get申請届出者電話番号();

    /**
     * 申請届出者住所を取得します。
     *
     * @return 申請届出者住所
     */
    AtenaJusho get申請届出者住所();

    /**
     * 申請届出代行区分コードを設定します。
     *
     * @param 申請届出代行区分コード 申請届出代行区分コード
     */
    void set申請届出代行区分コード(RString 申請届出代行区分コード);

    /**
     * 申請届出代行事業者番号を設定します。
     *
     * @param 申請届出代行事業者番号 申請届出代行事業者番号
     */
    void set申請届出代行事業者番号(RString 申請届出代行事業者番号);

    /**
     * 事業者区分を設定します。
     *
     * @param 事業者区分 事業者区分
     */
    void set事業者区分(RString 事業者区分);

    /**
     * 事業者名を設定します。
     *
     * @param 事業者名 事業者名
     */
    void set事業者名(RString 事業者名);

    /**
     * 申請届出者氏名を設定します。
     *
     * @param 申請届出者氏名 申請届出者氏名
     */
    void set申請届出者氏名(RString 申請届出者氏名);

    /**
     * 申請届出者氏名カナを設定します。
     *
     * @param 申請届出者氏名カナ 申請届出者氏名カナ
     */
    void set申請届出者氏名カナ(RString 申請届出者氏名カナ);

    /**
     * 申請届出者続柄コードを設定します。
     *
     * @param 申請届出者続柄コード 申請届出者続柄コード
     */
    void set申請届出者続柄コード(RString 申請届出者続柄コード);

    /**
     * 申請届出者郵便番号を設定します。
     *
     * @param 申請届出者郵便番号 申請届出者郵便番号
     */
    void set申請届出者郵便番号(YubinNo 申請届出者郵便番号);

    /**
     * 申請届出者住所を設定します。
     *
     * @param 申請届出者住所 申請届出者住所
     */
    void set申請届出者住所(AtenaJusho 申請届出者住所);

    /**
     * 申請届出者電話番号を設定します。
     *
     * @param 申請届出者電話番号 申請届出者電話番号
     */
    void set申請届出者電話番号(TelNo 申請届出者電話番号);

    /**
     * 届出代行区分の選択値により処理を行います。
     */
    void onClickBtnZenkaiFukusha();

    /**
     * 前回の申請情報の申請届出情報の内容を取得する処理を行います。
     */
    void onChangeDdlTodokedeDaikoKubun();

    /**
     * 入力された事業者コードより事業者名称を表示します。
     */
    void onBlurJigyoshaGuide();

    /**
     * 共有子Divの初期化を行います。
     */
    void initialize();

}
