/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.syujii.koseishichosonmaster;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link KoseiShichosonMaster}の編集を行うビルダークラスです。
 */
public class KoseiShichosonMasterBuilder {

    private final DbT5051KoseiShichosonMasterEntity entity;
    private final KoseiShichosonMasterIdentifier id;
    private final Models<ShujiiIryoKikanJohoIdentifier, ShujiiIryoKikanJoho> shujiiIryoKikanJoho;

    /**
     * {@link DbT5051KoseiShichosonMasterEntity}より{@link KoseiShichosonMaster}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5051KoseiShichosonMasterEntity}
     * @param id {@link KoseiShichosonMasterIdentifier}
     *
     */
    KoseiShichosonMasterBuilder(
            DbT5051KoseiShichosonMasterEntity entity,
            KoseiShichosonMasterIdentifier id,
            Models<ShujiiIryoKikanJohoIdentifier, ShujiiIryoKikanJoho> shujiiIryoKikanJoho
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.shujiiIryoKikanJoho = shujiiIryoKikanJoho;

    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 国保連広域内市町村番号を設定します。
     *
     * @param 国保連広域内市町村番号 国保連広域内市町村番号
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set国保連広域内市町村番号(RString 国保連広域内市町村番号) {
        requireNonNull(国保連広域内市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連広域内市町村番号"));
        entity.setKokuhorenKoikiShichosonNo(国保連広域内市町村番号);
        return this;
    }

    /**
     * 市町村名称を設定します。
     *
     * @param 市町村名称 市町村名称
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set市町村名称(RString 市町村名称) {
        requireNonNull(市町村名称, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村名称"));
        entity.setShichosonMeisho(市町村名称);
        return this;
    }

    /**
     * 都道府県名称を設定します。
     *
     * @param 都道府県名称 都道府県名称
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set都道府県名称(RString 都道府県名称) {
        requireNonNull(都道府県名称, UrSystemErrorMessages.値がnull.getReplacedMessage("都道府県名称"));
        entity.setTodofukenMeisho(都道府県名称);
        return this;
    }

    /**
     * 郡名称を設定します。
     *
     * @param 郡名称 郡名称
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set郡名称(RString 郡名称) {
        requireNonNull(郡名称, UrSystemErrorMessages.値がnull.getReplacedMessage("郡名称"));
        entity.setGunMeisho(郡名称);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * 最優先地区コードを設定します。
     *
     * @param 最優先地区コード 最優先地区コード
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set最優先地区コード(RString 最優先地区コード) {
        requireNonNull(最優先地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("最優先地区コード"));
        entity.setYusenChikuCode(最優先地区コード);
        return this;
    }

    /**
     * 帳票用都道府県名称表示有無を設定します。
     *
     * @param 帳票用都道府県名称表示有無 帳票用都道府県名称表示有無
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set帳票用都道府県名称表示有無(RString 帳票用都道府県名称表示有無) {
        requireNonNull(帳票用都道府県名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用都道府県名称表示有無"));
        entity.setTyohyoTodoufukenHyojiUmu(帳票用都道府県名称表示有無);
        return this;
    }

    /**
     * 帳票用郡名称表示有無を設定します。
     *
     * @param 帳票用郡名称表示有無 帳票用郡名称表示有無
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set帳票用郡名称表示有無(RString 帳票用郡名称表示有無) {
        requireNonNull(帳票用郡名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用郡名称表示有無"));
        entity.setTyohyoGunHyojiUmu(帳票用郡名称表示有無);
        return this;
    }

    /**
     * 帳票用市町村名称表示有無を設定します。
     *
     * @param 帳票用市町村名称表示有無 帳票用市町村名称表示有無
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set帳票用市町村名称表示有無(RString 帳票用市町村名称表示有無) {
        requireNonNull(帳票用市町村名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用市町村名称表示有無"));
        entity.setTyohyoShichosonHyojiUmu(帳票用市町村名称表示有無);
        return this;
    }

    /**
     * 帳票用住所編集方法を設定します。
     *
     * @param 帳票用住所編集方法 帳票用住所編集方法
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set帳票用住所編集方法(RString 帳票用住所編集方法) {
        requireNonNull(帳票用住所編集方法, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用住所編集方法"));
        entity.setTyohyoJushoHenshuHouhou(帳票用住所編集方法);
        return this;
    }

    /**
     * 帳票用方書表示有無を設定します。
     *
     * @param 帳票用方書表示有無 帳票用方書表示有無
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set帳票用方書表示有無(RString 帳票用方書表示有無) {
        requireNonNull(帳票用方書表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用方書表示有無"));
        entity.setTyohyoKatagakiHyojiUmu(帳票用方書表示有無);
        return this;
    }

    /**
     * 外国人氏名表示方法を設定します。
     *
     * @param 外国人氏名表示方法 外国人氏名表示方法
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set外国人氏名表示方法(RString 外国人氏名表示方法) {
        requireNonNull(外国人氏名表示方法, UrSystemErrorMessages.値がnull.getReplacedMessage("外国人氏名表示方法"));
        entity.setGaikokujinHyojiHouhou(外国人氏名表示方法);
        return this;
    }

    /**
     * 老人保健市町村番号を設定します。
     *
     * @param 老人保健市町村番号 老人保健市町村番号
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set老人保健市町村番号(RString 老人保健市町村番号) {
        requireNonNull(老人保健市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村番号"));
        entity.setRojinhokenShichosonNo(老人保健市町村番号);
        return this;
    }

    /**
     * 老人保健受給者番号体系を設定します。
     *
     * @param 老人保健受給者番号体系 老人保健受給者番号体系
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set老人保健受給者番号体系(RString 老人保健受給者番号体系) {
        requireNonNull(老人保健受給者番号体系, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号体系"));
        entity.setRokenJukyushaNoTaikei(老人保健受給者番号体系);
        return this;
    }

    /**
     * 特徴分配集約を設定します。
     *
     * @param 特徴分配集約 特徴分配集約
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set特徴分配集約(RString 特徴分配集約) {
        requireNonNull(特徴分配集約, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴分配集約"));
        entity.setTokuchoBunpaishuyaku(特徴分配集約);
        return this;
    }

    /**
     * 移行日を設定します。
     *
     * @param 移行日 移行日
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set移行日(FlexibleDate 移行日) {
        requireNonNull(移行日, UrSystemErrorMessages.値がnull.getReplacedMessage("移行日"));
        entity.setIkoYMD(移行日);
        return this;
    }

    /**
     * 加入日を設定します。
     *
     * @param 加入日 加入日
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set加入日(FlexibleDate 加入日) {
        requireNonNull(加入日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入日"));
        entity.setKanyuYMD(加入日);
        return this;
    }

    /**
     * 離脱日を設定します。
     *
     * @param 離脱日 離脱日
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set離脱日(FlexibleDate 離脱日) {
        requireNonNull(離脱日, UrSystemErrorMessages.値がnull.getReplacedMessage("離脱日"));
        entity.setRidatsuYMD(離脱日);
        return this;
    }

    /**
     * 合併旧市町村区分を設定します。
     *
     * @param 合併旧市町村区分 合併旧市町村区分
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set合併旧市町村区分(RString 合併旧市町村区分) {
        requireNonNull(合併旧市町村区分, UrSystemErrorMessages.値がnull.getReplacedMessage("合併旧市町村区分"));
        entity.setGappeiKyuShichosonKubun(合併旧市町村区分);
        return this;
    }

    /**
     * 合併旧市町村表示有無を設定します。
     *
     * @param 合併旧市町村表示有無 合併旧市町村表示有無
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set合併旧市町村表示有無(RString 合併旧市町村表示有無) {
        requireNonNull(合併旧市町村表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("合併旧市町村表示有無"));
        entity.setGappeiKyuShichosonHyojiUmu(合併旧市町村表示有無);
        return this;
    }

    /**
     * 合併情報地域番号を設定します。
     *
     * @param 合併情報地域番号 合併情報地域番号
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set合併情報地域番号(RString 合併情報地域番号) {
        requireNonNull(合併情報地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報地域番号"));
        entity.setGappeiChiikiNo(合併情報地域番号);
        return this;
    }

    /**
     * 運用保険者番号を設定します。
     *
     * @param 運用保険者番号 運用保険者番号
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set運用保険者番号(ShoKisaiHokenshaNo 運用保険者番号) {
        requireNonNull(運用保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("運用保険者番号"));
        entity.setUnyoHokenshaNo(運用保険者番号);
        return this;
    }

    /**
     * 運用開始日を設定します。
     *
     * @param 運用開始日 運用開始日
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set運用開始日(FlexibleDate 運用開始日) {
        requireNonNull(運用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("運用開始日"));
        entity.setUnyoKaishiYMD(運用開始日);
        return this;
    }

    /**
     * 運用終了日を設定します。
     *
     * @param 運用終了日 運用終了日
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set運用終了日(FlexibleDate 運用終了日) {
        requireNonNull(運用終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("運用終了日"));
        entity.setUnyoShuryoYMD(運用終了日);
        return this;
    }

    /**
     * 運用形態区分を設定します。
     *
     * @param 運用形態区分 運用形態区分
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set運用形態区分(RString 運用形態区分) {
        requireNonNull(運用形態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("運用形態区分"));
        entity.setUnyoKeitaiKubun(運用形態区分);
        return this;
    }

    /**
     * 構成市町村マスタ情報のキー情報について判定します。<br>
     * 構成市町村マスタ情報に関連できる主治医医療機関情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は主治医医療機関情報リストに主治医医療機関情報{@link ShujiiIryoKikanJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 主治医医療機関情報 {@link ShujiiIryoKikanJoho}
     * @return {@link KoseiShichosonMasterBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public KoseiShichosonMasterBuilder setShujiiIryoKikanJoho(ShujiiIryoKikanJoho 主治医医療機関情報) {
        if (hasSameIdentifier(主治医医療機関情報.identifier())) {
            shujiiIryoKikanJoho.add(主治医医療機関情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShujiiIryoKikanJohoIdentifier 主治医医療機関情報の識別子) {
        return (entity.getShichosonCode().equals(主治医医療機関情報の識別子.get市町村コード()));
    }

    /**
     * {@link KoseiShichosonMaster}のインスタンスを生成します。
     *
     * @return {@link KoseiShichosonMaster}のインスタンス
     */
    public KoseiShichosonMaster build() {
        return new KoseiShichosonMaster(entity, id, shujiiIryoKikanJoho);
    }
}
