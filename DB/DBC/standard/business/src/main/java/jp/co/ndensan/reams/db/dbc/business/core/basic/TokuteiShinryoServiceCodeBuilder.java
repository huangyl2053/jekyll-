/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link TokuteiShinryoServiceCode}の編集を行うビルダークラスです。
 */
public class TokuteiShinryoServiceCodeBuilder {

    private final DbT7120TokuteiShinryoServiceCodeEntity entity;
    private final TokuteiShinryoServiceCodeIdentifier id;

    /**
     * {@link DbT7120TokuteiShinryoServiceCodeEntity}より{@link TokuteiShinryoServiceCode}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7120TokuteiShinryoServiceCodeEntity}
     * @param id {@link TokuteiShinryoServiceCodeIdentifier}
     *
     */
    TokuteiShinryoServiceCodeBuilder(
            DbT7120TokuteiShinryoServiceCodeEntity entity,
            TokuteiShinryoServiceCodeIdentifier id
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
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * サービス名称を設定します。
     *
     * @param サービス名称 サービス名称
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder setサービス名称(RString サービス名称) {
        requireNonNull(サービス名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス名称"));
        entity.setServiceMeisho(サービス名称);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
        return this;
    }

    /**
     * 単位数識別を設定します。
     *
     * @param 単位数識別 単位数識別
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set単位数識別(RString 単位数識別) {
        requireNonNull(単位数識別, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数識別"));
        entity.setTaniSuShikibetsu(単位数識別);
        return this;
    }

    /**
     * 算定単位を設定します。
     *
     * @param 算定単位 算定単位
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set算定単位(RString 算定単位) {
        requireNonNull(算定単位, UrSystemErrorMessages.値がnull.getReplacedMessage("算定単位"));
        entity.setSanteiTani(算定単位);
        return this;
    }

    /**
     * 合成識別区分を設定します。
     *
     * @param 合成識別区分 合成識別区分
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set合成識別区分(RString 合成識別区分) {
        requireNonNull(合成識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("合成識別区分"));
        entity.setGoseiShikibetsuKubun(合成識別区分);
        return this;
    }

    /**
     * 特定診療区分コードを設定します。
     *
     * @param 特定診療区分コード 特定診療区分コード
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set特定診療区分コード(RString 特定診療区分コード) {
        requireNonNull(特定診療区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療区分コード"));
        entity.setTokuteiShinryoKubunCode(特定診療区分コード);
        return this;
    }

    /**
     * 特定診療項目コードを設定します。
     *
     * @param 特定診療項目コード 特定診療項目コード
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set特定診療項目コード(RString 特定診療項目コード) {
        requireNonNull(特定診療項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療項目コード"));
        entity.setTokuteiShinryoKomokuCode(特定診療項目コード);
        return this;
    }

    /**
     * 算定制約期間を設定します。
     *
     * @param 算定制約期間 算定制約期間
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set算定制約期間(RString 算定制約期間) {
        requireNonNull(算定制約期間, UrSystemErrorMessages.値がnull.getReplacedMessage("算定制約期間"));
        entity.setSanteiSeiyakuKikan(算定制約期間);
        return this;
    }

    /**
     * 算定制約回数を設定します。
     *
     * @param 算定制約回数 算定制約回数
     * @return {@link TokuteiShinryoServiceCodeBuilder}
     */
    public TokuteiShinryoServiceCodeBuilder set算定制約回数(Decimal 算定制約回数) {
        requireNonNull(算定制約回数, UrSystemErrorMessages.値がnull.getReplacedMessage("算定制約回数"));
        entity.setSanteiSeiyakuKaisu(算定制約回数);
        return this;
    }

    /**
     * {@link TokuteiShinryoServiceCode}のインスタンスを生成します。
     *
     * @return {@link TokuteiShinryoServiceCode}のインスタンス
     */
    public TokuteiShinryoServiceCode build() {
        return new TokuteiShinryoServiceCode(entity, id);
    }
}
