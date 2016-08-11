/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.houshold;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.houshold.HousholdEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link HousholdBusiness}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-4930-040 wangjie2
 */
public class HousholdBuilder {

    private final HousholdEntity entity;

    /**
     * {@link HousholdEntity}より{@link HousholdBusiness}の編集用Builderクラスを生成します。
     *
     * @param entity {@link HousholdEntity}
     *
     */
    public HousholdBuilder(HousholdEntity entity) {
        this.entity = entity;
    }

    /**
     * カナ氏名を設定します。
     *
     * @param カナ氏名 カナ氏名
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder setカナ氏名(RString カナ氏名) {
        entity.setカナ氏名(カナ氏名);
        return this;
    }

    /**
     * 住所カナを設定します。
     *
     * @param 住所カナ 住所カナ
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set住所カナ(RString 住所カナ) {
        entity.set住所カナ(住所カナ);
        return this;
    }

    /**
     * 住所漢字を設定します。
     *
     * @param 住所漢字 住所漢字
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set住所漢字(RString 住所漢字) {
        entity.set住所漢字(住所漢字);
        return this;
    }

    /**
     * 漢字氏名を設定します。
     *
     * @param 漢字氏名 漢字氏名
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set漢字氏名(RString 漢字氏名) {
        entity.set漢字氏名(漢字氏名);
        return this;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set生年月日(RString 生年月日) {
        entity.set生年月日(生年月日);
        return this;
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set性別(RString 性別) {
        entity.set性別(性別);
        return this;
    }

    /**
     * 年金保険者を設定します。
     *
     * @param 年金保険者 年金保険者
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set年金保険者(RString 年金保険者) {
        entity.set年金保険者(年金保険者);
        return this;
    }

    /**
     * 基礎年金番号を設定します。
     *
     * @param 基礎年金番号 基礎年金番号
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set基礎年金番号(RString 基礎年金番号) {
        entity.set基礎年金番号(基礎年金番号);
        return this;
    }

    /**
     * 現基礎年金番号を設定します。
     *
     * @param 現基礎年金番号 現基礎年金番号
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set現基礎年金番号(RString 現基礎年金番号) {
        entity.set現基礎年金番号(現基礎年金番号);
        return this;
    }

    /**
     * 年金コードを設定します。
     *
     * @param 年金コード 年金コード
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set年金コード(RString 年金コード) {
        entity.set年金コード(年金コード);
        return this;
    }

    /**
     * 対象年を設定します。
     *
     * @param 対象年 対象年
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set対象年(RString 対象年) {
        entity.set対象年(対象年);
        return this;
    }

    /**
     * 作成年月日を設定します。
     *
     * @param 作成年月日 作成年月日
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set作成年月日(RString 作成年月日) {
        entity.set作成年月日(作成年月日);
        return this;
    }

    /**
     * 通知内容を設定します。
     *
     * @param 通知内容 通知内容
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set通知内容(RString 通知内容) {
        entity.set通知内容(通知内容);
        return this;
    }

    /**
     * 登録区分を設定します。
     *
     * @param 登録区分 登録区分
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set登録区分(RString 登録区分) {
        entity.set登録区分(登録区分);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set被保険者番号(RString 被保険者番号) {
        entity.set被保険者番号(被保険者番号);
        return this;
    }

    /**
     * 金額を設定します。
     *
     * @param 金額 金額
     * @return {@link HousholdBuilder}
     */
    public HousholdBuilder set金額(RString 金額) {
        entity.set金額(金額);
        return this;
    }

    /**
     * {@link HousholdBusiness}のインスタンスを生成します。
     *
     * @return {@link HousholdBusiness}のインスタンス
     */
    public HousholdBusiness build() {
        return new HousholdBusiness(entity);
    }

}
