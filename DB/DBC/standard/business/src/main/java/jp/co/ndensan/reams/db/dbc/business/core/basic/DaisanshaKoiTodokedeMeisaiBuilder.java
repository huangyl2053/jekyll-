/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3085DaisanshaKoiTodokedeMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link DaisanshaKoiTodokedeMeisai}の編集を行うビルダークラスです。
 */
public class DaisanshaKoiTodokedeMeisaiBuilder {

    private final DbT3085DaisanshaKoiTodokedeMeisaiEntity entity;
    private final DaisanshaKoiTodokedeMeisaiIdentifier id;

    /**
     * {@link DbT3085DaisanshaKoiTodokedeMeisaiEntity}より{@link DaisanshaKoiTodokedeMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3085DaisanshaKoiTodokedeMeisaiEntity}
     * @param id {@link DaisanshaKoiTodokedeMeisaiIdentifier}
     *
     */
    DaisanshaKoiTodokedeMeisaiBuilder(
            DbT3085DaisanshaKoiTodokedeMeisaiEntity entity,
            DaisanshaKoiTodokedeMeisaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link DaisanshaKoiTodokedeMeisaiBuilder}
     */
    public DaisanshaKoiTodokedeMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @return {@link DaisanshaKoiTodokedeMeisaiBuilder}
     */
    public DaisanshaKoiTodokedeMeisaiBuilder set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
        return this;
    }

    /**
     * サービス提供事業者番号を設定します。
     *
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @return {@link DaisanshaKoiTodokedeMeisaiBuilder}
     */
    public DaisanshaKoiTodokedeMeisaiBuilder setサービス提供事業者番号(JigyoshaNo サービス提供事業者番号) {
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link DaisanshaKoiTodokedeMeisaiBuilder}
     */
    public DaisanshaKoiTodokedeMeisaiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link DaisanshaKoiTodokedeMeisaiBuilder}
     */
    public DaisanshaKoiTodokedeMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * サービス利用開始年月日を設定します。
     *
     * @param サービス利用開始年月日 サービス利用開始年月日
     * @return {@link DaisanshaKoiTodokedeMeisaiBuilder}
     */
    public DaisanshaKoiTodokedeMeisaiBuilder setサービス利用開始年月日(FlexibleDate サービス利用開始年月日) {
        requireNonNull(サービス利用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス利用開始年月日"));
        entity.setServiceRiyoKaishiYMD(サービス利用開始年月日);
        return this;
    }

    /**
     * {@link DaisanshaKoiTodokedeMeisai}のインスタンスを生成します。
     *
     * @return {@link DaisanshaKoiTodokedeMeisai}のインスタンス
     */
    public DaisanshaKoiTodokedeMeisai build() {
        return new DaisanshaKoiTodokedeMeisai(entity, id);
    }
}
