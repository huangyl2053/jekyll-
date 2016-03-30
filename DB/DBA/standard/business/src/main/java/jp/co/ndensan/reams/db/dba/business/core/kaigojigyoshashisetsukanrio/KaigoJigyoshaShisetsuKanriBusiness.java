/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護事業者・施設管理のBusinessクラスです。
 */
public class KaigoJigyoshaShisetsuKanriBusiness {

    private final KaigoJigyoshaShisetsuKanriRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 調査委託先＆調査員ガイドEntity
     */
    public KaigoJigyoshaShisetsuKanriBusiness(KaigoJigyoshaShisetsuKanriRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 有効開始日を取得します。
     *
     * @return 有効開始日
     */
    public RString get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了日を取得します。
     *
     * @return 有効終了日
     */
    public RString get有効終了日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 事業者名を取得します。
     *
     * @return 事業者名（ｶﾅ）
     */
    public RString get事業者名() {
        return entity.getJigyoshaName();
    }

    /**
     * 事業者名（ｶﾅ）を取得します。
     *
     * @return 事業者名（ｶﾅ）
     */
    public RString get事業者名ｶﾅ() {
        return entity.getJigyoshaNameKana();
    }

    /**
     * 事業開始日を取得します。
     *
     * @return 事業開始日
     */
    public RString get事業開始日() {
        return entity.getJigyoKaishiYMD();
    }

    /**
     * 事業休止日を取得します。
     *
     * @return 事業休止日
     */
    public RString get事業休止日() {
        return entity.getJigyoSaikaiYMD();
    }

    /**
     * 事業再開日を取得します。
     *
     * @return 事業再開日
     */
    public RString get事業再開日() {
        return entity.getJigyoSaikaiYMD();
    }

    /**
     * 事業廃止日を取得します。
     *
     * @return 事業廃止日
     */
    public RString get事業廃止日() {
        return entity.getJigyoHaishiYMD();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を取得します。
     *
     * @return FAX番号
     */
    public RString getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJigyoshaAddress();
    }

    /**
     * 住所（ｶﾅ）を取得します。
     *
     * @return 住所（ｶﾅ）
     */
    public RString get住所ｶﾅ() {
        return entity.getJigyoshaKanaAddress();
    }

    /**
     * 所在市町村を取得します。
     *
     * @return 所在市町村
     */
    public RString get所在市町村() {
        return entity.getShozaiShichoson();
    }

    /**
     * サービス実施地域を取得します。
     *
     * @return サービス実施地域
     */
    public RString getサービス実施地域() {
        return entity.getServiceJisshiChiiki();
    }

    /**
     * 所属人数を取得します。
     *
     * @return 所属人数
     */
    public RString get所属人数() {
        return entity.getShozokuNinzu();
    }

    /**
     * 利用者数を取得します。
     *
     * @return 利用者数
     */
    public RString get利用者数() {
        return entity.getRiyoshaSu();
    }

    /**
     * ベット数を取得します。
     *
     * @return ベット数
     */
    public RString getベット数() {
        return entity.getBedSu();
    }

    /**
     * 宛先人名を取得します。
     *
     * @return 宛先人名
     */
    public RString get宛先人名() {
        return entity.getAtesakininName();
    }

    /**
     * 宛先人名（ｶﾅ）を取得します。
     *
     * @return 宛先人名（ｶﾅ）
     */
    public RString get宛先人名ｶﾅ() {
        return entity.getAtesakininNamekana();
    }

    /**
     * 宛先部署を取得します。
     *
     * @return 宛先部署
     */
    public RString get宛先部署() {
        return entity.getAtesakiBusho();
    }

    /**
     * 法人等種別を取得します。
     *
     * @return 法人等種別
     */
    public RString get法人等種別() {
        return entity.getHojinShubetsu();
    }

    /**
     * 基準該当等事業者区分を取得します。
     *
     * @return 基準該当等事業者区分
     */
    public RString get基準該当等事業者区分() {
        return entity.getShiteiKijungaitoJigyoshaKubun();
    }

    /**
     * 備考を取得します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * 代表者名を取得します。
     *
     * @return 代表者名
     */
    public RString get代表者名() {
        return entity.getDaihyoshaShimei();
    }

    /**
     * 代表者名カナを取得します。
     *
     * @return 代表者名カナ
     */
    public RString get代表者名カナ() {
        return entity.getDaihyoshaKanaShimei();
    }

    /**
     * 代表者郵便番号を取得します。
     *
     * @return 代表者郵便番号
     */
    public RString get代表者郵便番号() {
        return entity.getDaihyoshaYubinNo();
    }

    /**
     * 代表者住所を取得します。
     *
     * @return 代表者住所
     */
    public RString get代表者住所() {
        return entity.getDaihyoshaJusho();
    }

    /**
     * 代表者住所カナを取得します。
     *
     * @return 代表者住所カナ
     */
    public RString get代表者住所カナ() {
        return entity.getDaihyoshaKanaJusho();
    }

    /**
     * 代表者役職名を取得します。
     *
     * @return 代表者役職名
     */
    public RString get代表者役職名() {
        return entity.getDaihyoshaYakushokuMei();
    }

    /**
     * 開設者名称を取得します。
     *
     * @return 開設者名称
     */
    public RString get開設者名称() {
        return entity.getKaisetsushaShimei();
    }

    /**
     * 開設者名称カナを取得します。
     *
     * @return 開設者名称カナ
     */
    public RString get開設者名称カナ() {
        return entity.getKaisetsushaKanaShimei();
    }

    /**
     * 開設者郵便番号を取得します。
     *
     * @return 開設者郵便番号
     */
    public RString get開設者郵便番号() {
        return entity.getKaisetsushaYubinNo();
    }

    /**
     * 開設者住所を取得します。
     *
     * @return 開設者住所
     */
    public RString get開設者住所() {
        return entity.getKaisetsushaJusho();
    }

    /**
     * 開設者住所カナを取得します。
     *
     * @return 開設者住所カナ
     */
    public RString get開設者住所カナ() {
        return entity.getKaisetsushaKanaJusho();
    }

    /**
     * 開設者電話番号を取得します。
     *
     * @return 開設者電話番号
     */
    public RString get開設者電話番号() {
        return entity.getKaisetsushaTelNo();
    }

    /**
     * 開設者ＦＡＸ番号を取得します。
     *
     * @return 開設者ＦＡＸ番号
     */
    public RString get開設者ＦＡＸ番号() {
        return entity.getKaisetsushaFaxNo();
    }
}
