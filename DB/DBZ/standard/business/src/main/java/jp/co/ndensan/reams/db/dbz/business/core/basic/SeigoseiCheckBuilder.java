/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link DbT1014SeigoseiCheck}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public class SeigoseiCheckBuilder {

    private final DbT1014SeigoseiCheckEntity entity;
    private final SeigoseiCheckIdentifier id;

    /**
     * {@link DbT1014SeigoseiCheckEntity}より{@link DbT1014SeigoseiCheck}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1014SeigoseiCheckEntity}
     * @param id {@link SeigoseiCheckIdentifier}
     *
     */
    SeigoseiCheckBuilder(
            DbT1014SeigoseiCheckEntity entity,
            SeigoseiCheckIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 対象外フラグを設定します。
     *
     * @param 対象外フラグ 対象外フラグ
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set対象外フラグ(boolean 対象外フラグ) {
        requireNonNull(対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("対象外フラグ"));
        entity.setTaishogaiFlag(対象外フラグ);
        return this;
    }

    /**
     * 不整合理由コードを設定します。
     *
     * @param 不整合理由コード 不整合理由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set不整合理由コード(RString 不整合理由コード) {
        requireNonNull(不整合理由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("不整合理由コード"));
        entity.setFuseigoRiyuCode(不整合理由コード);
        return this;
    }

    /**
     * 登録日時を設定します。
     *
     * @param 登録日時 登録日時
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set登録日時(RDateTime 登録日時) {
        requireNonNull(登録日時, UrSystemErrorMessages.値がnull.getReplacedMessage("登録日時"));
        entity.setTorokuTimestamp(登録日時);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRierkiNo(履歴番号);
        return this;
    }

    /**
     * 異動年月日を設定します。
     *
     * @param 異動年月日 異動年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
        return this;
    }

    /**
     * 届出年月日を設定します。
     *
     * @param 届出年月日 届出年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set届出年月日(FlexibleDate 届出年月日) {
        requireNonNull(届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("届出年月日"));
        entity.setTodokedeYMD(届出年月日);
        return this;
    }

    /**
     * 異動事由コードを設定します。
     *
     * @param 異動事由コード 異動事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set異動事由コード(RString 異動事由コード) {
        requireNonNull(異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由コード"));
        entity.setIdoJiyuCode(異動事由コード);
        return this;
    }

    /**
     * 処理事由コードを設定します。
     *
     * @param 処理事由コード 処理事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set処理事由コード(RString 処理事由コード) {
        requireNonNull(処理事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("処理事由コード"));
        entity.setShoriJiyuCode(処理事由コード);
        return this;
    }

    /**
     * 処理年月日を設定します。
     *
     * @param 処理年月日 処理年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set処理年月日(FlexibleDate 処理年月日) {
        requireNonNull(処理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月日"));
        entity.setShoriYMD(処理年月日);
        return this;
    }

    /**
     * 住民種別コードを設定します。
     *
     * @param 住民種別コード 住民種別コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set住民種別コード(RString 住民種別コード) {
        requireNonNull(住民種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住民種別コード"));
        entity.setJuminShubetsuCode(住民種別コード);
        return this;
    }

    /**
     * 住民状態コードを設定します。
     *
     * @param 住民状態コード 住民状態コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set住民状態コード(RString 住民状態コード) {
        requireNonNull(住民状態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住民状態コード"));
        entity.setJuminJotaiCode(住民状態コード);
        return this;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set生年月日(FlexibleDate 生年月日) {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        entity.setSeinengappiYMD(生年月日);
        return this;
    }

    /**
     * 登録事由コードを設定します。
     *
     * @param 登録事由コード 登録事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set登録事由コード(RString 登録事由コード) {
        requireNonNull(登録事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("登録事由コード"));
        entity.setTorokuJiyuCode(登録事由コード);
        return this;
    }

    /**
     * 登録異動年月日を設定します。
     *
     * @param 登録異動年月日 登録異動年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set登録異動年月日(FlexibleDate 登録異動年月日) {
        requireNonNull(登録異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録異動年月日"));
        entity.setTorokuIdoYMD(登録異動年月日);
        return this;
    }

    /**
     * 登録届出年月日を設定します。
     *
     * @param 登録届出年月日 登録届出年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set登録届出年月日(FlexibleDate 登録届出年月日) {
        requireNonNull(登録届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録届出年月日"));
        entity.setTorokuTodokedeYMD(登録届出年月日);
        return this;
    }

    /**
     * 消除事由コードを設定します。
     *
     * @param 消除事由コード 消除事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set消除事由コード(RString 消除事由コード) {
        requireNonNull(消除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("消除事由コード"));
        entity.setShojoJiyuCode(消除事由コード);
        return this;
    }

    /**
     * 消除異動年月日を設定します。
     *
     * @param 消除異動年月日 消除異動年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set消除異動年月日(FlexibleDate 消除異動年月日) {
        requireNonNull(消除異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("消除異動年月日"));
        entity.setShojoIdoYMD(消除異動年月日);
        return this;
    }

    /**
     * 消除届出年月日を設定します。
     *
     * @param 消除届出年月日 消除届出年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set消除届出年月日(FlexibleDate 消除届出年月日) {
        requireNonNull(消除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("消除届出年月日"));
        entity.setShojoTodokedeYMD(消除届出年月日);
        return this;
    }

    /**
     * 消除通知フラグを設定します。
     *
     * @param 消除通知フラグ 消除通知フラグ
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set消除通知フラグ(boolean 消除通知フラグ) {
        requireNonNull(消除通知フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("消除通知フラグ"));
        entity.setShojoTsuchiFlag(消除通知フラグ);
        return this;
    }

    /**
     * 転出予定異動年月日を設定します。
     *
     * @param 転出予定異動年月日 転出予定異動年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set転出予定異動年月日(FlexibleDate 転出予定異動年月日) {
        requireNonNull(転出予定異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("転出予定異動年月日"));
        entity.setTenshutsuYoteiIdoYMD(転出予定異動年月日);
        return this;
    }

    /**
     * 転出確定異動年月日を設定します。
     *
     * @param 転出確定異動年月日 転出確定異動年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set転出確定異動年月日(FlexibleDate 転出確定異動年月日) {
        requireNonNull(転出確定異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("転出確定異動年月日"));
        entity.setTenshutsuKakuteiIdoYMD(転出確定異動年月日);
        return this;
    }

    /**
     * 転出確定通知年月日を設定します。
     *
     * @param 転出確定通知年月日 転出確定通知年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set転出確定通知年月日(FlexibleDate 転出確定通知年月日) {
        requireNonNull(転出確定通知年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("転出確定通知年月日"));
        entity.setTenshutsuKakuteiTsuchiYMD(転出確定通知年月日);
        return this;
    }

    /**
     * 台帳種別を設定します。
     *
     * @param 台帳種別 台帳種別
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set台帳種別(RString 台帳種別) {
        requireNonNull(台帳種別, UrSystemErrorMessages.値がnull.getReplacedMessage("台帳種別"));
        entity.setDaichoShubetsu(台帳種別);
        return this;
    }

    /**
     * 資格異動日を設定します。
     *
     * @param 資格異動日 資格異動日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set資格異動日(FlexibleDate 資格異動日) {
        requireNonNull(資格異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格異動日"));
        entity.setShikakuIdoYMD(資格異動日);
        return this;
    }

    /**
     * 資格異動枝番を設定します。
     *
     * @param 資格異動枝番 資格異動枝番
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set資格異動枝番(RString 資格異動枝番) {
        requireNonNull(資格異動枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("資格異動枝番"));
        entity.setShikakuIdoEdaNo(資格異動枝番);
        return this;
    }

    /**
     * 資格異動事由コードを設定します。
     *
     * @param 資格異動事由コード 資格異動事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set資格異動事由コード(RString 資格異動事由コード) {
        requireNonNull(資格異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格異動事由コード"));
        entity.setShikakuIdoJiyuCode(資格異動事由コード);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 取得適用事由コードを設定します。
     *
     * @param 取得適用事由コード 取得適用事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set取得適用事由コード(RString 取得適用事由コード) {
        requireNonNull(取得適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("取得適用事由コード"));
        entity.setShutokuTekiyoJiyuCode(取得適用事由コード);
        return this;
    }

    /**
     * 取得適用年月日を設定します。
     *
     * @param 取得適用年月日 取得適用年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set取得適用年月日(FlexibleDate 取得適用年月日) {
        requireNonNull(取得適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("取得適用年月日"));
        entity.setShutokuTekiyoYMD(取得適用年月日);
        return this;
    }

    /**
     * 取得適用届出年月日を設定します。
     *
     * @param 取得適用届出年月日 取得適用届出年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set取得適用届出年月日(FlexibleDate 取得適用届出年月日) {
        requireNonNull(取得適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("取得適用届出年月日"));
        entity.setShutokuTekiyoTodokedeYMD(取得適用届出年月日);
        return this;
    }

    /**
     * 喪失解除事由コードを設定します。
     *
     * @param 喪失解除事由コード 喪失解除事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set喪失解除事由コード(RString 喪失解除事由コード) {
        requireNonNull(喪失解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("喪失解除事由コード"));
        entity.setSoshitsuKaijoJiyuCode(喪失解除事由コード);
        return this;
    }

    /**
     * 喪失解除年月日を設定します。
     *
     * @param 喪失解除年月日 喪失解除年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set喪失解除年月日(FlexibleDate 喪失解除年月日) {
        requireNonNull(喪失解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("喪失解除年月日"));
        entity.setSoshitsuKaijoYMD(喪失解除年月日);
        return this;
    }

    /**
     * 喪失解除届出年月日を設定します。
     *
     * @param 喪失解除届出年月日 喪失解除届出年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set喪失解除届出年月日(FlexibleDate 喪失解除届出年月日) {
        requireNonNull(喪失解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("喪失解除届出年月日"));
        entity.setSoshitsuKaijoTodokedeYMD(喪失解除届出年月日);
        return this;
    }

    /**
     * 第１号取得年月日を設定します。
     *
     * @param 第１号取得年月日 第１号取得年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set第１号取得年月日(FlexibleDate 第１号取得年月日) {
        requireNonNull(第１号取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("第１号取得年月日"));
        entity.setIchigoShutokuYMD(第１号取得年月日);
        return this;
    }

    /**
     * 被保険者区分コードを設定します。
     *
     * @param 被保険者区分コード 被保険者区分コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set被保険者区分コード(RString 被保険者区分コード) {
        requireNonNull(被保険者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        entity.setHihokenshaKubunCode(被保険者区分コード);
        return this;
    }

    /**
     * 資格変更事由コードを設定します。
     *
     * @param 資格変更事由コード 資格変更事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set資格変更事由コード(RString 資格変更事由コード) {
        requireNonNull(資格変更事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更事由コード"));
        entity.setShikakuHenkoJiyuCode(資格変更事由コード);
        return this;
    }

    /**
     * 資格変更年月日を設定します。
     *
     * @param 資格変更年月日 資格変更年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set資格変更年月日(FlexibleDate 資格変更年月日) {
        requireNonNull(資格変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更年月日"));
        entity.setShikakuHenkoYMD(資格変更年月日);
        return this;
    }

    /**
     * 資格変更届出年月日を設定します。
     *
     * @param 資格変更届出年月日 資格変更届出年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set資格変更届出年月日(FlexibleDate 資格変更届出年月日) {
        requireNonNull(資格変更届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更届出年月日"));
        entity.setShikakuHenkoTodokedeYMD(資格変更届出年月日);
        return this;
    }

    /**
     * 住特適用事由コードを設定します。
     *
     * @param 住特適用事由コード 住特適用事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set住特適用事由コード(RString 住特適用事由コード) {
        requireNonNull(住特適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住特適用事由コード"));
        entity.setJutokuTekiyoJiyuCode(住特適用事由コード);
        return this;
    }

    /**
     * 住特適用年月日を設定します。
     *
     * @param 住特適用年月日 住特適用年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set住特適用年月日(FlexibleDate 住特適用年月日) {
        requireNonNull(住特適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住特適用年月日"));
        entity.setJutokuTekiyoYMD(住特適用年月日);
        return this;
    }

    /**
     * 住特適用届出年月日を設定します。
     *
     * @param 住特適用届出年月日 住特適用届出年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set住特適用届出年月日(FlexibleDate 住特適用届出年月日) {
        requireNonNull(住特適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住特適用届出年月日"));
        entity.setJutokuTekiyoTodokedeYMD(住特適用届出年月日);
        return this;
    }

    /**
     * 住特解除事由コードを設定します。
     *
     * @param 住特解除事由コード 住特解除事由コード
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set住特解除事由コード(RString 住特解除事由コード) {
        requireNonNull(住特解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住特解除事由コード"));
        entity.setJutokuKaijoJiyuCode(住特解除事由コード);
        return this;
    }

    /**
     * 住特解除年月日を設定します。
     *
     * @param 住特解除年月日 住特解除年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set住特解除年月日(FlexibleDate 住特解除年月日) {
        requireNonNull(住特解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住特解除年月日"));
        entity.setJutokuKaijoYMD(住特解除年月日);
        return this;
    }

    /**
     * 住特解除届出年月日を設定します。
     *
     * @param 住特解除届出年月日 住特解除届出年月日
     * @return {@link SeigoseiCheckBuilder}
     */
    public SeigoseiCheckBuilder set住特解除届出年月日(FlexibleDate 住特解除届出年月日) {
        requireNonNull(住特解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住特解除届出年月日"));
        entity.setJutokuKaijoTodokedeYMD(住特解除届出年月日);
        return this;
    }

    /**
     * {@link DbT1014SeigoseiCheck}のインスタンスを生成します。
     *
     * @return {@link DbT1014SeigoseiCheck}のインスタンス
     */
    public SeigoseiCheck build() {
        return new SeigoseiCheck(entity, id);
    }
}
