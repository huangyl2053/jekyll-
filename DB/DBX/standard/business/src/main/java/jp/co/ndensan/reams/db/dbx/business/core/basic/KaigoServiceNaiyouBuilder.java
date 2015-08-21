/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoServiceIdoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KaigoServiceNaiyou}の編集を行うビルダークラスです。
 */
public class KaigoServiceNaiyouBuilder {

    private final DbT7131KaigoServiceNaiyouEntity entity;
    private final KaigoServiceNaiyouIdentifier id;

    /**
     * {@link DbT7131KaigoServiceNaiyouEntity}より{@link KaigoServiceNaiyou}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7131KaigoServiceNaiyouEntity}
     * @param id {@link KaigoServiceNaiyouIdentifier}
     *
     */
    KaigoServiceNaiyouBuilder(
            DbT7131KaigoServiceNaiyouEntity entity,
            KaigoServiceNaiyouIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder setサービス種類コード(KaigoServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder setサービス項目コード(RString サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKoumokuCode(サービス項目コード);
        return this;
    }

    /**
     * 提供開始年月を設定します。
     *
     * @param 提供開始年月 提供開始年月
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set提供開始年月(FlexibleYearMonth 提供開始年月) {
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        entity.setTeikyoKaishiYM(提供開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 提供終了年月を設定します。
     *
     * @param 提供終了年月 提供終了年月
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set提供終了年月(FlexibleYearMonth 提供終了年月) {
        requireNonNull(提供終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供終了年月"));
        entity.setTeikyoShuryoYM(提供終了年月);
        return this;
    }

    /**
     * サービス名称を設定します。
     *
     * @param サービス名称 サービス名称
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder setサービス名称(RString サービス名称) {
        requireNonNull(サービス名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス名称"));
        entity.setServiceName(サービス名称);
        return this;
    }

    /**
     * サービス略称を設定します。
     *
     * @param サービス略称 サービス略称
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder setサービス略称(RString サービス略称) {
        requireNonNull(サービス略称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス略称"));
        entity.setServiceNameRyaku(サービス略称);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set単位数(int 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
        return this;
    }

    /**
     * 単位数識別を設定します。
     *
     * @param 単位数識別 単位数識別
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set単位数識別(Code 単位数識別) {
        requireNonNull(単位数識別, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数識別"));
        entity.setTanisuShikibetsuCode(new TanisuShikibetsu(単位数識別));
        return this;
    }

    /**
     * 単位数算定単位を設定します。
     *
     * @param 単位数算定単位 単位数算定単位
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set単位数算定単位(Code 単位数算定単位) {
        requireNonNull(単位数算定単位, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数算定単位"));
        entity.setTanisuSanteiTani(new TanisuSanteiTani(単位数算定単位));
        return this;
    }

    /**
     * 異動事由を設定します。
     *
     * @param 異動事由 異動事由
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set異動事由(Code 異動事由) {
        requireNonNull(異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由"));
        entity.setIdouJiyuCode(new KaigoServiceIdoJiyu(異動事由));
        return this;
    }

    /**
     * {@link KaigoServiceNaiyou}のインスタンスを生成します。
     *
     * @return {@link KaigoServiceNaiyou}のインスタンス
     */
    public KaigoServiceNaiyou build() {
        return new KaigoServiceNaiyou(entity, id);
    }
}
