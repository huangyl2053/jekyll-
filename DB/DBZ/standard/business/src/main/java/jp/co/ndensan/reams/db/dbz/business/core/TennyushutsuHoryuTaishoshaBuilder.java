/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link TennyushutsuHoryuTaishosha}の編集を行うビルダークラスです。
 */
public class TennyushutsuHoryuTaishoshaBuilder {

    private final DbT1010TennyushutsuHoryuTaishoshaEntity entity;
    private final TennyushutsuHoryuTaishoshaIdentifier id;

    /**
     * {@link DbT1010TennyushutsuHoryuTaishoshaEntity}より{@link TennyushutsuHoryuTaishosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1010TennyushutsuHoryuTaishoshaEntity}
     * @param id {@link TennyushutsuHoryuTaishoshaIdentifier}
     *
     */
    TennyushutsuHoryuTaishoshaBuilder(
            DbT1010TennyushutsuHoryuTaishoshaEntity entity,
            TennyushutsuHoryuTaishoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 作成事由コードを設定します。
     *
     * @param 作成事由コード 作成事由コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set作成事由コード(RString 作成事由コード) {
        requireNonNull(作成事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("作成事由コード"));
        entity.setSakuseiJiyuCode(作成事由コード);
        return this;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード 世帯コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set世帯コード(SetaiCode 世帯コード) {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        entity.setSetaiCode(世帯コード);
        return this;
    }

    /**
     * 住民種別コードを設定します。
     *
     * @param 住民種別コード 住民種別コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set住民種別コード(RString 住民種別コード) {
        requireNonNull(住民種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住民種別コード"));
        entity.setJuminShubetsuCode(住民種別コード);
        return this;
    }

    /**
     * 住民状態コードを設定します。
     *
     * @param 住民状態コード 住民状態コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set住民状態コード(RString 住民状態コード) {
        requireNonNull(住民状態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住民状態コード"));
        entity.setJuminJotaiCode(住民状態コード);
        return this;
    }

    /**
     * 宛名氏名を設定します。
     *
     * @param 宛名氏名 宛名氏名
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set宛名氏名(AtenaMeisho 宛名氏名) {
        requireNonNull(宛名氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("宛名氏名"));
        entity.setAtenaShimei(宛名氏名);
        return this;
    }

    /**
     * 宛名カナ氏名を設定します。
     *
     * @param 宛名カナ氏名 宛名カナ氏名
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set宛名カナ氏名(AtenaKanaMeisho 宛名カナ氏名) {
        requireNonNull(宛名カナ氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("宛名カナ氏名"));
        entity.setAtenaKanaShimei(宛名カナ氏名);
        return this;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set生年月日(FlexibleDate 生年月日) {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        entity.setSeinengappiYMD(生年月日);
        return this;
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード 性別コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set性別コード(RString 性別コード) {
        requireNonNull(性別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("性別コード"));
        entity.setSeibetsuCode(性別コード);
        return this;
    }

    /**
     * 異動事由コードを設定します。
     *
     * @param 異動事由コード 異動事由コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set異動事由コード(RString 異動事由コード) {
        requireNonNull(異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由コード"));
        entity.setIdoJiyuCode(異動事由コード);
        return this;
    }

    /**
     * 登録異動年月日を設定します。
     *
     * @param 登録異動年月日 登録異動年月日
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set登録異動年月日(FlexibleDate 登録異動年月日) {
        requireNonNull(登録異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録異動年月日"));
        entity.setTorokuIdoYMD(登録異動年月日);
        return this;
    }

    /**
     * 登録届出年月日を設定します。
     *
     * @param 登録届出年月日 登録届出年月日
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set登録届出年月日(FlexibleDate 登録届出年月日) {
        requireNonNull(登録届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録届出年月日"));
        entity.setTorokuTodokedeYMD(登録届出年月日);
        return this;
    }

    /**
     * 消除異動年月日を設定します。
     *
     * @param 消除異動年月日 消除異動年月日
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set消除異動年月日(FlexibleDate 消除異動年月日) {
        requireNonNull(消除異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("消除異動年月日"));
        entity.setShojoIdoYMD(消除異動年月日);
        return this;
    }

    /**
     * 消除届出年月日を設定します。
     *
     * @param 消除届出年月日 消除届出年月日
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set消除届出年月日(FlexibleDate 消除届出年月日) {
        requireNonNull(消除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("消除届出年月日"));
        entity.setShojoIdoTodokedeYMD(消除届出年月日);
        return this;
    }

    /**
     * 転出予定異動年月日を設定します。
     *
     * @param 転出予定異動年月日 転出予定異動年月日
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出予定異動年月日(FlexibleDate 転出予定異動年月日) {
        requireNonNull(転出予定異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("転出予定異動年月日"));
        entity.setTenshutsuYoteiIdoYMD(転出予定異動年月日);
        return this;
    }

    /**
     * 転出確定異動年月日を設定します。
     *
     * @param 転出確定異動年月日 転出確定異動年月日
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出確定異動年月日(FlexibleDate 転出確定異動年月日) {
        requireNonNull(転出確定異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("転出確定異動年月日"));
        entity.setTenshutsuKakuteiIdoYMD(転出確定異動年月日);
        return this;
    }

    /**
     * 転出確定異動通知年月日を設定します。
     *
     * @param 転出確定異動通知年月日 転出確定異動通知年月日
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出確定異動通知年月日(FlexibleDate 転出確定異動通知年月日) {
        requireNonNull(転出確定異動通知年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("転出確定異動通知年月日"));
        entity.setTenshutsuKakuteiIdoTsuchiYMD(転出確定異動通知年月日);
        return this;
    }

    /**
     * 全国住所コードを設定します。
     *
     * @param 全国住所コード 全国住所コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set全国住所コード(RString 全国住所コード) {
        requireNonNull(全国住所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("全国住所コード"));
        entity.setZenkokuJushoCode(全国住所コード);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 番地を設定します。
     *
     * @param 番地 番地
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set番地(AtenaBanchi 番地) {
        requireNonNull(番地, UrSystemErrorMessages.値がnull.getReplacedMessage("番地"));
        entity.setBanchi(番地);
        return this;
    }

    /**
     * 方書を設定します。
     *
     * @param 方書 方書
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set方書(Katagaki 方書) {
        requireNonNull(方書, UrSystemErrorMessages.値がnull.getReplacedMessage("方書"));
        entity.setKatagaki(方書);
        return this;
    }

    /**
     * 転出予定全国住所コードを設定します。
     *
     * @param 転出予定全国住所コード 転出予定全国住所コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出予定全国住所コード(ZenkokuJushoCode 転出予定全国住所コード) {
        requireNonNull(転出予定全国住所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("転出予定全国住所コード"));
        entity.setTenshutsuYoteiZenkokuJushoCode(転出予定全国住所コード);
        return this;
    }

    /**
     * 転出予定住所を設定します。
     *
     * @param 転出予定住所 転出予定住所
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出予定住所(AtenaJusho 転出予定住所) {
        requireNonNull(転出予定住所, UrSystemErrorMessages.値がnull.getReplacedMessage("転出予定住所"));
        entity.setTenshutsuYoteiJusho(転出予定住所);
        return this;
    }

    /**
     * 転出予定番地を設定します。
     *
     * @param 転出予定番地 転出予定番地
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出予定番地(AtenaBanchi 転出予定番地) {
        requireNonNull(転出予定番地, UrSystemErrorMessages.値がnull.getReplacedMessage("転出予定番地"));
        entity.setTenshutsuYoteiBanchi(転出予定番地);
        return this;
    }

    /**
     * 転出予定方書を設定します。
     *
     * @param 転出予定方書 転出予定方書
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出予定方書(Katagaki 転出予定方書) {
        requireNonNull(転出予定方書, UrSystemErrorMessages.値がnull.getReplacedMessage("転出予定方書"));
        entity.setTenshutsuYoteiKatagaki(転出予定方書);
        return this;
    }

    /**
     * 転出確定全国住所コードを設定します。
     *
     * @param 転出確定全国住所コード 転出確定全国住所コード
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出確定全国住所コード(ZenkokuJushoCode 転出確定全国住所コード) {
        requireNonNull(転出確定全国住所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("転出確定全国住所コード"));
        entity.setTenshutsuKakuteiZenkokuJushoCode(転出確定全国住所コード);
        return this;
    }

    /**
     * 転出確定住所を設定します。
     *
     * @param 転出確定住所 転出確定住所
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出確定住所(AtenaJusho 転出確定住所) {
        requireNonNull(転出確定住所, UrSystemErrorMessages.値がnull.getReplacedMessage("転出確定住所"));
        entity.setTenshutsuKakuteiJusho(転出確定住所);
        return this;
    }

    /**
     * 転出確定番地を設定します。
     *
     * @param 転出確定番地 転出確定番地
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出確定番地(AtenaBanchi 転出確定番地) {
        requireNonNull(転出確定番地, UrSystemErrorMessages.値がnull.getReplacedMessage("転出確定番地"));
        entity.setTenshutsuKakuteiBanchi(転出確定番地);
        return this;
    }

    /**
     * 転出確定方書を設定します。
     *
     * @param 転出確定方書 転出確定方書
     * @return {@link TennyushutsuHoryuTaishoshaBuilder}
     */
    public TennyushutsuHoryuTaishoshaBuilder set転出確定方書(Katagaki 転出確定方書) {
        requireNonNull(転出確定方書, UrSystemErrorMessages.値がnull.getReplacedMessage("転出確定方書"));
        entity.setTenshutsuKakuteiKatagaki(転出確定方書);
        return this;
    }

    /**
     * {@link TennyushutsuHoryuTaishosha}のインスタンスを生成します。
     *
     * @return {@link TennyushutsuHoryuTaishosha}のインスタンス
     */
    public TennyushutsuHoryuTaishosha build() {
        return new TennyushutsuHoryuTaishosha(entity, id);
    }
}
