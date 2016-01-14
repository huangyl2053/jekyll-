/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link BemmeishaJoho}の編集を行うビルダークラスです。
 */
public class BemmeishaJohoBuilder {

    private final DbT7003BemmeishaJohoEntity entity;
    private final BemmeishaJohoIdentifier id;

    /**
     * {@link DbT7003BemmeishaJohoEntity}より{@link BemmeishaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7003BemmeishaJohoEntity}
     * @param id {@link BemmeishaJohoIdentifier}
     *
     */
    BemmeishaJohoBuilder(
            DbT7003BemmeishaJohoEntity entity,
            BemmeishaJohoIdentifier id
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
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        // entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 原処分被保険者番号を設定します。
     *
     * @param 原処分被保険者番号 原処分被保険者番号
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set原処分被保険者番号(HihokenshaNo 原処分被保険者番号) {
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        entity.setGenshobunHihokenshaNo(原処分被保険者番号);
        return this;
    }

    /**
     * 審査請求届出日を設定します。
     *
     * @param 審査請求届出日 審査請求届出日
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set審査請求届出日(FlexibleDate 審査請求届出日) {
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        entity.setShinsaseikyuTodokedeYMD(審査請求届出日);
        return this;
    }

    /**
     * 弁明書作成日を設定します。
     *
     * @param 弁明書作成日 弁明書作成日
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set弁明書作成日(FlexibleDate 弁明書作成日) {
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        entity.setBemmeishoSakuseiYMD(弁明書作成日);
        return this;
    }

    /**
     * 弁明者枝番を設定します。
     *
     * @param 弁明者枝番 弁明者枝番
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set弁明者枝番(Decimal 弁明者枝番) {
        requireNonNull(弁明者枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者枝番"));
        entity.setBemmeishaEdaban(弁明者枝番.intValue());
        return this;
    }

    /**
     * 審査請求に係る処分内容を設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link BemmeiNaiyoBuilder}
     */
    public BemmeishaJohoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求に係る処分内容"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 職員コードを設定します。
     *
     * @param 職員コード 職員コード
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set職員コード(Code 職員コード) {
        requireNonNull(職員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("職員コード"));
        //   entity.setShokuinCode(職員コード);
        return this;
    }

    /**
     * 部署コードを設定します。
     *
     * @param 部署コード 部署コード
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set部署コード(BushoCode 部署コード) {
        requireNonNull(部署コード, UrSystemErrorMessages.値がnull.getReplacedMessage("部署コード"));
        //entity.setBushoCode(部署コード);
        return this;
    }

    /**
     * 役職名を設定します。
     *
     * @param 役職名 役職名
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set役職名(RString 役職名) {
        requireNonNull(役職名, UrSystemErrorMessages.値がnull.getReplacedMessage("役職名"));
        // entity.setYakushoskuName(役職名);
        return this;
    }

    /**
     * 弁明者氏名を設定します。
     *
     * @param 弁明者氏名 弁明者氏名
     * @return {@link BemmeishaJohoBuilder}
     */
    public BemmeishaJohoBuilder set弁明者氏名(RString 弁明者氏名) {
        requireNonNull(弁明者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者氏名"));
        entity.setBemmeisha(弁明者氏名);
        return this;
    }

    /**
     * {@link BemmeishaJoho}のインスタンスを生成します。
     *
     * @return {@link BemmeishaJoho}のインスタンス
     */
    public BemmeishaJoho build() {
        return new BemmeishaJoho(entity, id);
    }
}
