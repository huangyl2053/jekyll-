/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.houshold;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.houshold.HousholdEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報登録 非課税年金対象者情報のbusinessです。
 *
 * @reamsid_L DBD-4930-040 wangjie2
 */
public class HousholdBusiness {

    private final HousholdEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 非課税年金対象者情報
     */
    public HousholdBusiness(HousholdEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("非課税年金対象者情報のエンティティ"));
        this.entity = entity;
    }

    /**
     * コンストラクタです。
     *
     * @param カナ氏名 カナ氏名
     * @param 漢字氏名 漢字氏名
     * @param 生年月日 生年月日
     * @param 性別 性別
     * @param 年金保険者 年金保険者
     * @param 基礎年金番号 基礎年金番号
     * @param 現基礎年金番号 現基礎年金番号
     * @param 年金コード 年金コード
     * @param 対象年 対象年
     * @param 作成年月日 作成年月日
     * @param 通知内容 通知内容
     * @param 登録区分 登録区分
     * @param 被保険者番号 被保険者番号
     * @param 住所カナ 住所カナ
     * @param 住所漢字 住所漢字
     * @param 金額 金額
     */
    public HousholdBusiness(
            RString カナ氏名,
            RString 漢字氏名,
            RString 生年月日,
            RString 性別,
            RString 年金保険者,
            RString 基礎年金番号,
            RString 現基礎年金番号,
            RString 年金コード,
            RString 対象年,
            RString 作成年月日,
            RString 通知内容,
            RString 登録区分,
            RString 被保険者番号,
            RString 住所カナ,
            RString 住所漢字,
            RString 金額) {
        this.entity = new HousholdEntity();
        this.entity.setカナ氏名(カナ氏名);
        this.entity.set住所カナ(住所カナ);
        this.entity.set住所漢字(住所漢字);
        this.entity.set作成年月日(作成年月日);
        this.entity.set基礎年金番号(基礎年金番号);
        this.entity.set対象年(対象年);
        this.entity.set年金コード(年金コード);
        this.entity.set年金保険者(年金保険者);
        this.entity.set性別(性別);
        this.entity.set漢字氏名(漢字氏名);
        this.entity.set現基礎年金番号(現基礎年金番号);
        this.entity.set生年月日(生年月日);
        this.entity.set登録区分(登録区分);
        this.entity.set被保険者番号(被保険者番号);
        this.entity.set通知内容(通知内容);
        this.entity.set金額(金額);
    }

    /**
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    public RString getカナ氏名() {
        return entity.getカナ氏名();
    }

    /**
     * 住所カナを返します。
     *
     * @return 住所カナ
     */
    public RString get住所カナ() {
        return entity.get住所カナ();
    }

    /**
     * 住所漢字を返します。
     *
     * @return 住所漢字
     */
    public RString get住所漢字() {
        return entity.get住所漢字();
    }

    /**
     * 作成年月日を返します。
     *
     * @return 作成年月日
     */
    public RString get作成年月日() {
        return entity.get作成年月日();
    }

    /**
     * 基礎年金番号を返します。
     *
     * @return 基礎年金番号
     */
    public RString get基礎年金番号() {
        return entity.get基礎年金番号();
    }

    /**
     * 対象年を返します。
     *
     * @return 対象年
     */
    public RString get対象年() {
        return entity.get対象年();
    }

    /**
     * 年金コードを返します。
     *
     * @return 年金コード
     */
    public RString get年金コード() {
        return entity.get年金コード();
    }

    /**
     * 年金保険者を返します。
     *
     * @return 年金保険者
     */
    public RString get年金保険者() {
        return entity.get年金保険者();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 漢字氏名を返します。
     *
     * @return 漢字氏名
     */
    public RString get漢字氏名() {
        return entity.get漢字氏名();
    }

    /**
     * 現基礎年金番号を返します。
     *
     * @return 現基礎年金番号
     */
    public RString get現基礎年金番号() {
        return entity.get現基礎年金番号();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 登録区分を返します。
     *
     * @return 登録区分
     */
    public RString get登録区分() {
        return entity.get登録区分();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 通知内容を返します。
     *
     * @return 通知内容
     */
    public RString get通知内容() {
        return entity.get通知内容();
    }

    /**
     * 金額を返します。
     *
     * @return 金額
     */
    public RString get金額() {
        return entity.get金額();
    }

}
