/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link BemmeiNaiyo}の編集を行うビルダークラスです。
 */
public class BemmeiNaiyoBuilder {

    private final DbT7002BemmeiNaiyoEntity entity;
    private final BemmeiNaiyoIdentifier id;

    /**
     * {@link DbT7002BemmeiNaiyoEntity}より{@link BemmeiNaiyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7002BemmeiNaiyoEntity}
     * @param id {@link BemmeiNaiyoIdentifier}
     *
     */
    BemmeiNaiyoBuilder(
            DbT7002BemmeiNaiyoEntity entity,
            BemmeiNaiyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeiNaiyoBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        //  entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeiNaiyoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 原処分被保険者番号を設定します。
     *
     * @param 原処分被保険者番号 原処分被保険者番号
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeiNaiyoBuilder set原処分被保険者番号(HihokenshaNo 原処分被保険者番号) {
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        entity.setGenshobunHihokenshaNo(原処分被保険者番号);
        return this;
    }

    /**
     * 審査請求届出日を設定します。
     *
     * @param 審査請求届出日 審査請求届出日
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeiNaiyoBuilder set審査請求届出日(FlexibleDate 審査請求届出日) {
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        entity.setShinsaseikyuTodokedeYMD(審査請求届出日);
        return this;
    }

    /**
     * 弁明書作成日を設定します。
     *
     * @param 弁明書作成日 弁明書作成日
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeiNaiyoBuilder set弁明書作成日(FlexibleDate 弁明書作成日) {
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        entity.setBemmeishoSakuseiYMD(弁明書作成日);
        return this;
    }

    /**
     * 審査請求に係る処分内容を設定します。
     *
     * @param 審査請求に係る処分内容 審査請求に係る処分内容
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeiNaiyoBuilder set審査請求に係る処分内容(RString 審査請求に係る処分内容) {
        requireNonNull(審査請求に係る処分内容, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求に係る処分内容"));
        entity.setShinsaseikyuKankeiShobunNaiyo(審査請求に係る処分内容);
        return this;
    }

    /**
     * 弁明内容を設定します。
     *
     * @param 弁明内容 弁明内容
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeiNaiyoBuilder set弁明内容(RString 弁明内容) {
        requireNonNull(弁明内容, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明内容"));
        entity.setBemmeiNaiyo(弁明内容);
        return this;
    }

    /**
     * 弁明書作成日提出日を設定します。
     *
     * @param 弁明書作成日提出日 弁明書作成日提出日
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeiNaiyoBuilder set弁明書作成日提出日(FlexibleDate 弁明書作成日提出日) {
        requireNonNull(弁明書作成日提出日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日提出日"));
        //  entity.setBemmeishoSakuseiTeishutsuYMD(弁明書作成日提出日);
        return this;
    }

    /**
     * {@link BemmeiNaiyo}のインスタンスを生成します。
     *
     * @return {@link BemmeiNaiyo}のインスタンス
     */
    public BemmeiNaiyo build() {
        return new BemmeiNaiyo(entity, id);
    }

    /**
     * setBemmeishaJoho
     *
     * @param createBemmeishaJoho BemmeishaJoho
     * @return BemmeiNaiyoBuilder
     */
    public BemmeiNaiyoBuilder setBemmeishaJoho(BemmeishaJoho createBemmeishaJoho) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
