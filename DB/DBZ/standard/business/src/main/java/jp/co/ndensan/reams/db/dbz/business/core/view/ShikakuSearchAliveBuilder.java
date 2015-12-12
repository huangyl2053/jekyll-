/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShikakuSearchAlive}の編集を行うビルダークラスです。
 */
public class ShikakuSearchAliveBuilder {

    private final DbV7901ShikakuSearchEntity entity;
    private final ShikakuSearchAliveIdentifier id;

    /**
     * {@link DbV7901ShikakuSearchEntity}より{@link ShikakuSearchAlive}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV7901ShikakuSearchEntity}
     * @param id {@link ShikakuSearchAliveIdentifier}
     *
     */
    ShikakuSearchAliveBuilder(
            DbV7901ShikakuSearchEntity entity,
            ShikakuSearchAliveIdentifier id
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
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 資格取得事由コードを設定します。
     *
     * @param 資格取得事由コード 資格取得事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set資格取得事由コード(RString 資格取得事由コード) {
        requireNonNull(資格取得事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由コード"));
        entity.setShikakuShutokuJiyuCode(資格取得事由コード);
        return this;
    }

    /**
     * 資格取得年月日を設定します。
     *
     * @param 資格取得年月日 資格取得年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set資格取得年月日(FlexibleDate 資格取得年月日) {
        requireNonNull(資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得年月日"));
        entity.setShikakuShutokuYMD(資格取得年月日);
        return this;
    }

    /**
     * 被保険者区分コードを設定します。
     *
     * @param 被保険者区分コード 被保険者区分コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set被保険者区分コード(RString 被保険者区分コード) {
        requireNonNull(被保険者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        entity.setHihokennshaKubunCode(被保険者区分コード);
        return this;
    }

    /**
     * 資格喪失事由コードを設定します。
     *
     * @param 資格喪失事由コード 資格喪失事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set資格喪失事由コード(RString 資格喪失事由コード) {
        requireNonNull(資格喪失事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由コード"));
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由コード);
        return this;
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        requireNonNull(資格喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
        return this;
    }

    /**
     * 住所地特例フラグを設定します。
     *
     * @param 住所地特例フラグ 住所地特例フラグ
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set住所地特例フラグ(RString 住所地特例フラグ) {
        requireNonNull(住所地特例フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例フラグ"));
        entity.setJushochiTokureiFlag(住所地特例フラグ);
        return this;
    }

    /**
     * 資格変更事由コードを設定します。
     *
     * @param 資格変更事由コード 資格変更事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set資格変更事由コード(RString 資格変更事由コード) {
        requireNonNull(資格変更事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更事由コード"));
        entity.setShikakuHenkoJiyuCode(資格変更事由コード);
        return this;
    }

    /**
     * 資格変更年月日を設定します。
     *
     * @param 資格変更年月日 資格変更年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set資格変更年月日(FlexibleDate 資格変更年月日) {
        requireNonNull(資格変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更年月日"));
        entity.setShikakuHenkoYMD(資格変更年月日);
        return this;
    }

    /**
     * 住所地特例適用事由コードを設定します。
     *
     * @param 住所地特例適用事由コード 住所地特例適用事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set住所地特例適用事由コード(RString 住所地特例適用事由コード) {
        requireNonNull(住所地特例適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用事由コード"));
        entity.setJushochitokureiTekiyoJiyuCode(住所地特例適用事由コード);
        return this;
    }

    /**
     * 住所地特例適用年月日を設定します。
     *
     * @param 住所地特例適用年月日 住所地特例適用年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set住所地特例適用年月日(FlexibleDate 住所地特例適用年月日) {
        requireNonNull(住所地特例適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用年月日"));
        entity.setJushochitokureiTekiyoYMD(住所地特例適用年月日);
        return this;
    }

    /**
     * 住所地特例解除事由コードを設定します。
     *
     * @param 住所地特例解除事由コード 住所地特例解除事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set住所地特例解除事由コード(RString 住所地特例解除事由コード) {
        requireNonNull(住所地特例解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例解除事由コード"));
        entity.setJushochitokureiKaijoJiyuCode(住所地特例解除事由コード);
        return this;
    }

    /**
     * 住所地特例解除年月日を設定します。
     *
     * @param 住所地特例解除年月日 住所地特例解除年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set住所地特例解除年月日(FlexibleDate 住所地特例解除年月日) {
        requireNonNull(住所地特例解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例解除年月日"));
        entity.setJushochitokureiKaijoYMD(住所地特例解除年月日);
        return this;
    }

    /**
     * 広域内住所地特例フラグを設定します。
     *
     * @param 広域内住所地特例フラグ 広域内住所地特例フラグ
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set広域内住所地特例フラグ(RString 広域内住所地特例フラグ) {
        requireNonNull(広域内住所地特例フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内住所地特例フラグ"));
        entity.setKoikinaiJushochiTokureiFlag(広域内住所地特例フラグ);
        return this;
    }

    /**
     * 広住特措置元市町村コードを設定します。
     *
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set広住特措置元市町村コード(LasdecCode 広住特措置元市町村コード) {
        requireNonNull(広住特措置元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("広住特措置元市町村コード"));
        entity.setKoikinaiTokureiSochimotoShichosonCode(広住特措置元市町村コード);
        return this;
    }

    /**
     * 適用除外適用事由コードを設定します。
     *
     * @param 適用除外適用事由コード 適用除外適用事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set適用除外適用事由コード(RString 適用除外適用事由コード) {
        requireNonNull(適用除外適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外適用事由コード"));
        entity.setTekiyoJogaiTekiyoJiyuCode(適用除外適用事由コード);
        return this;
    }

    /**
     * 適用除外適用年月日を設定します。
     *
     * @param 適用除外適用年月日 適用除外適用年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set適用除外適用年月日(FlexibleDate 適用除外適用年月日) {
        requireNonNull(適用除外適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外適用年月日"));
        entity.setTekiyoJogaiTekiyoYMD(適用除外適用年月日);
        return this;
    }

    /**
     * 適用除外解除事由コードを設定します。
     *
     * @param 適用除外解除事由コード 適用除外解除事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set適用除外解除事由コード(RString 適用除外解除事由コード) {
        requireNonNull(適用除外解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外解除事由コード"));
        entity.setTekiyoJogaikaijokaijoJiyuCode(適用除外解除事由コード);
        return this;
    }

    /**
     * 適用除外解除年月日を設定します。
     *
     * @param 適用除外解除年月日 適用除外解除年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set適用除外解除年月日(FlexibleDate 適用除外解除年月日) {
        requireNonNull(適用除外解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外解除年月日"));
        entity.setTekiyoJogaiTekiyoYMD(適用除外解除年月日);
        return this;
    }

    /**
     * 他市町村住所地特例適用事由コードを設定します。
     *
     * @param 他市町村住所地特例適用事由コード 他市町村住所地特例適用事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set他市町村住所地特例適用事由コード(RString 他市町村住所地特例適用事由コード) {
        requireNonNull(他市町村住所地特例適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例適用事由コード"));
        entity.setTatokureiTekiyoJiyuCode(他市町村住所地特例適用事由コード);
        return this;
    }

    /**
     * 他市町村住所地特例適用年月日を設定します。
     *
     * @param 他市町村住所地特例適用年月日 他市町村住所地特例適用年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set他市町村住所地特例適用年月日(FlexibleDate 他市町村住所地特例適用年月日) {
        requireNonNull(他市町村住所地特例適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例適用年月日"));
        entity.setTatokureiTekiyoYMD(他市町村住所地特例適用年月日);
        return this;
    }

    /**
     * 他市町村住所地特例解除事由コードを設定します。
     *
     * @param 他市町村住所地特例解除事由コード 他市町村住所地特例解除事由コード
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set他市町村住所地特例解除事由コード(RString 他市町村住所地特例解除事由コード) {
        requireNonNull(他市町村住所地特例解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例解除事由コード"));
        entity.setTatokureiKaijoJiyuCode(他市町村住所地特例解除事由コード);
        return this;
    }

    /**
     * 他市町村住所地特例解除年月日を設定します。
     *
     * @param 他市町村住所地特例解除年月日 他市町村住所地特例解除年月日
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set他市町村住所地特例解除年月日(FlexibleDate 他市町村住所地特例解除年月日) {
        requireNonNull(他市町村住所地特例解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例解除年月日"));
        entity.setTatokureiKaijoYMD(他市町村住所地特例解除年月日);
        return this;
    }

    /**
     * 受給者台帳被保険者番号を設定します。
     *
     * @param 受給者台帳被保険者番号 受給者台帳被保険者番号
     * @return {@link ShikakuSearchAliveBuilder}
     */
    public ShikakuSearchAliveBuilder set受給者台帳被保険者番号(HihokenshaNo 受給者台帳被保険者番号) {
        requireNonNull(受給者台帳被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳被保険者番号"));
        entity.setJukyushaDaichoHihokenshaNo(受給者台帳被保険者番号);
        return this;
    }

    /**
     * {@link ShikakuSearchAlive}のインスタンスを生成します。
     *
     * @return {@link ShikakuSearchAlive}のインスタンス
     */
    public ShikakuSearchAlive build() {
        return new ShikakuSearchAlive(entity, id);
    }
}
