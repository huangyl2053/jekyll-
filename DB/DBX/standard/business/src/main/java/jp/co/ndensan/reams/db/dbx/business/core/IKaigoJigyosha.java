/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.HojinsShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShiteiKijunGaitoJigyoshoKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者の情報を保持するインターフェースです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 * @deprecated 不要なインターフェースのため削除されます。{@link KaigoJigyosha}を使用してください。
 */
public interface IKaigoJigyosha {

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    KaigoJigyoshaNo get事業者番号();

    /**
     * 有効開始日を返します。
     *
     * @return 有効開始日
     */
    FlexibleDate get有効開始日();

    /**
     * 有効終了日を返します。
     *
     * @return 有効終了日
     */
    FlexibleDate get有効終了日();

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    FlexibleDate get異動日();

    /**
     * 異動事由を返します。
     *
     * @return 異動事由
     */
    RString get異動事由();

    /**
     * 事業開始日を返します。
     *
     * @return 事業開始日
     */
    FlexibleDate get事業開始日();

    /**
     * 事業休止日を返します。
     *
     * @return 事業休止日
     */
    FlexibleDate get事業休止日();

    /**
     * 事業再開日を返します。
     *
     * @return 事業再開日
     */
    FlexibleDate get事業再開日();

    /**
     * 事業廃止日を返します。
     *
     * @return 事業廃止日
     */
    FlexibleDate get事業廃止日();

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    AtenaMeisho get事業者名称();

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    AtenaKanaMeisho get事業者名称カナ();

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    YubinNo get郵便番号();

    /**
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    AtenaJusho get事業者住所();

    /**
     * 事業者住所カナを返します。
     *
     * @return 事業者住所カナ
     */
    RString get事業者住所カナ();

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    TelNo get電話番号();

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    TelNo getFAX番号();

    /**
     * 宛先部署を返します。
     *
     * @return 宛先部署
     */
    RString get宛先部署();

    /**
     * 宛先人名を返します。
     *
     * @return 宛先人名
     */
    AtenaMeisho get宛先人名();

    /**
     * 宛先人名カナを返します。
     *
     * @return 宛先人名カナ
     */
    AtenaKanaMeisho get宛先人名カナ();

    /**
     * 銀行コードを返します。
     *
     * @return 銀行コード
     */
    KinyuKikanCode get銀行コード();

    /**
     * 支店コードを返します。
     *
     * @return 支店コード
     */
    KinyuKikanShitenCode get支店コード();

    /**
     * 口座種別を返します。
     *
     * @return 口座種別
     */
    RString get口座種別();

    /**
     * 口座番号を返します。
     *
     * @return 口座番号
     */
    RString get口座番号();

    /**
     * 口座名義人を返します。
     *
     * @return 口座名義人
     */
    AtenaMeisho get口座名義人();

    /**
     * 口座名義人カナを返します。
     *
     * @return 口座名義人カナ
     */
    AtenaKanaMeisho get口座名義人カナ();

    /**
     * 指定基準該当等事業所区分を返します。
     *
     * @return 指定基準該当等事業所区分
     */
    ShiteiKijunGaitoJigyoshoKubun get指定基準該当等事業所区分();

    /**
     * 所在市町村を返します。
     *
     * @return 所在市町村
     */
    RString get所在市町村();

    /**
     * サービス実施地域を返します。
     *
     * @return サービス実施地域
     */
    RString getサービス実施地域();

    /**
     * 法人等種別を返します。
     *
     * @return 法人等種別
     */
    HojinsShubetsu get法人等種別();

    /**
     * ベッド数を返します。
     *
     * @return ベッド数
     */
    int getベッド数();

    /**
     * 所属人数を返します。
     *
     * @return 所属人数
     */
    int get所属人数();

    /**
     * 利用者数を返します。
     *
     * @return 利用者数
     */
    int get利用者数();

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    RString get備考();
}
