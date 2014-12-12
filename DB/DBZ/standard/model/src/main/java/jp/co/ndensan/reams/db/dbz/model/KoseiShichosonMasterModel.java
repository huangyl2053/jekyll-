/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村マスタのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class KoseiShichosonMasterModel implements Serializable {

    private DbT7051KoseiShichosonMasterEntity entity;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonMasterModel() {
        entity = new DbT7051KoseiShichosonMasterEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7051KoseiShichosonMasterEntity
     */
    public KoseiShichosonMasterModel(DbT7051KoseiShichosonMasterEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7051KoseiShichosonMasterEntityを返します。
     *
     * @return DbT7051KoseiShichosonMasterEntity
     */
    public DbT7051KoseiShichosonMasterEntity getEntity() {
        return entity;
    }

    /**
     * DbT7051KoseiShichosonMasterEntityを設定します。
     *
     * @param entity DbT7051KoseiShichosonMasterEntity
     */
    public void setEntity(DbT7051KoseiShichosonMasterEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村識別IDを返します。
     *
     * @return 市町村識別ID
     */
    public RString get市町村識別ID() {
        return entity.getShichosonShokibetsuID();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 国保連広域内市町村番号を返します。
     *
     * @return 国保連広域内市町村番号
     */
    public RString get国保連広域内市町村番号() {
        return entity.getKokuhorenKoikiShichosonNo();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 都道府県名称を返します。
     *
     * @return 都道府県名称
     */
    public RString get都道府県名称() {
        return entity.getTodofukenMeisho();
    }

    /**
     * 郡名称を返します。
     *
     * @return 郡名称
     */
    public RString get郡名称() {
        return entity.getGunMeisho();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 最優先地区コードを返します。
     *
     * @return 最優先地区コード
     */
    public RString get最優先地区コード() {
        return entity.getYusenChikuCode();
    }

    /**
     * 帳票用都道府県名称表示有無を返します。
     *
     * @return 帳票用都道府県名称表示有無
     */
    public RString get帳票用都道府県名称表示有無() {
        return entity.getTyohyoTodoufukenHyojiUmu();
    }

    /**
     * 帳票用郡名称表示有無を返します。
     *
     * @return 帳票用郡名称表示有無
     */
    public RString get帳票用郡名称表示有無() {
        return entity.getTyohyoGunHyojiUmu();
    }

    /**
     * 帳票用市町村名称表示有無を返します。
     *
     * @return 帳票用市町村名称表示有無
     */
    public RString get帳票用市町村名称表示有無() {
        return entity.getTyohyoShichosonHyojiUmu();
    }

    /**
     * 帳票用住所編集方法を返します。
     *
     * @return 帳票用住所編集方法
     */
    public RString get帳票用住所編集方法() {
        return entity.getTyohyoJushoHenshuHouhou();
    }

    /**
     * 帳票用方書表示有無を返します。
     *
     * @return 帳票用方書表示有無
     */
    public RString get帳票用方書表示有無() {
        return entity.getTyohyoKatagakiHyojiUmu();
    }

    /**
     * 外国人氏名表示方法を返します。
     *
     * @return 外国人氏名表示方法
     */
    public RString get外国人氏名表示方法() {
        return entity.getGaikokujinHyojiHouhou();
    }

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return entity.getRojinhokenShichosonNo();
    }

    /**
     * 老人保健受給者番号体系を返します。
     *
     * @return 老人保健受給者番号体系
     */
    public RString get老人保健受給者番号体系() {
        return entity.getRokenJukyushaNoTaikei();
    }

    /**
     * 移行日を返します。
     *
     * @return 移行日
     */
    public FlexibleDate get移行日() {
        return entity.getIkoYMD();
    }

    /**
     * 加入日を返します。
     *
     * @return 加入日
     */
    public FlexibleDate get加入日() {
        return entity.getKanyuYMD();
    }

    /**
     * 離脱日を返します。
     *
     * @return 離脱日
     */
    public FlexibleDate get離脱日() {
        return entity.getRidatsuYMD();
    }

    /**
     * 合併旧市町村区分を返します。
     *
     * @return 合併旧市町村区分
     */
    public RString get合併旧市町村区分() {
        return entity.getGappeiKyuShichosonKubun();
    }

    /**
     * 合併旧市町村表示有無を返します。
     *
     * @return 合併旧市町村表示有無
     */
    public RString get合併旧市町村表示有無() {
        return entity.getGappeiKyuShichosonHyojiUmu();
    }

    /**
     * 合併情報リンク番号を返します。
     *
     * @return 合併情報リンク番号
     */
    public RString get合併情報リンク番号() {
        return entity.getGappeiChiikiNo();
    }

    /**
     * 運用保険者番号を返します。
     *
     * @return 運用保険者番号
     */
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return entity.getUnyoHokenshaNo();
    }

    /**
     * 運用開始日を返します。
     *
     * @return 運用開始日
     */
    public FlexibleDate get運用開始日() {
        return entity.getUnyoKaishiYMD();
    }

    /**
     * 運用終了日を返します。
     *
     * @return 運用終了日
     */
    public FlexibleDate get運用終了日() {
        return entity.getUnyoShuryoYMD();
    }

    /**
     * 運用形態区分を返します。
     *
     * @return 運用形態区分
     */
    public RString get運用形態区分() {
        return entity.getUnyoKeitaiKubun();
    }

    /**
     * 市町村識別IDを設定します。
     *
     * @param 市町村識別ID 市町村識別ID
     */
    public void set市町村識別ID(RString 市町村識別ID) {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        entity.setShichosonShokibetsuID(市町村識別ID);
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 国保連広域内市町村番号を設定します。
     *
     * @param 国保連広域内市町村番号 国保連広域内市町村番号
     */
    public void set国保連広域内市町村番号(RString 国保連広域内市町村番号) {
        requireNonNull(国保連広域内市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連広域内市町村番号"));
        entity.setKokuhorenKoikiShichosonNo(国保連広域内市町村番号);
    }

    /**
     * 市町村名称を設定します。
     *
     * @param 市町村名称 市町村名称
     */
    public void set市町村名称(RString 市町村名称) {
        requireNonNull(市町村名称, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村名称"));
        entity.setShichosonMeisho(市町村名称);
    }

    /**
     * 都道府県名称を設定します。
     *
     * @param 都道府県名称 都道府県名称
     */
    public void set都道府県名称(RString 都道府県名称) {
        requireNonNull(都道府県名称, UrSystemErrorMessages.値がnull.getReplacedMessage("都道府県名称"));
        entity.setTodofukenMeisho(都道府県名称);
    }

    /**
     * 郡名称を設定します。
     *
     * @param 郡名称 郡名称
     */
    public void set郡名称(RString 郡名称) {
        requireNonNull(郡名称, UrSystemErrorMessages.値がnull.getReplacedMessage("郡名称"));
        entity.setGunMeisho(郡名称);
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     */
    public void set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     */
    public void set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     */
    public void set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
    }

    /**
     * 最優先地区コードを設定します。
     *
     * @param 最優先地区コード 最優先地区コード
     */
    public void set最優先地区コード(RString 最優先地区コード) {
        requireNonNull(最優先地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("最優先地区コード"));
        entity.setYusenChikuCode(最優先地区コード);
    }

    /**
     * 帳票用都道府県名称表示有無を設定します。
     *
     * @param 帳票用都道府県名称表示有無 帳票用都道府県名称表示有無
     */
    public void set帳票用都道府県名称表示有無(RString 帳票用都道府県名称表示有無) {
        requireNonNull(帳票用都道府県名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用都道府県名称表示有無"));
        entity.setTyohyoTodoufukenHyojiUmu(帳票用都道府県名称表示有無);
    }

    /**
     * 帳票用郡名称表示有無を設定します。
     *
     * @param 帳票用郡名称表示有無 帳票用郡名称表示有無
     */
    public void set帳票用郡名称表示有無(RString 帳票用郡名称表示有無) {
        requireNonNull(帳票用郡名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用郡名称表示有無"));
        entity.setTyohyoGunHyojiUmu(帳票用郡名称表示有無);
    }

    /**
     * 帳票用市町村名称表示有無を設定します。
     *
     * @param 帳票用市町村名称表示有無 帳票用市町村名称表示有無
     */
    public void set帳票用市町村名称表示有無(RString 帳票用市町村名称表示有無) {
        requireNonNull(帳票用市町村名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用市町村名称表示有無"));
        entity.setTyohyoShichosonHyojiUmu(帳票用市町村名称表示有無);
    }

    /**
     * 帳票用住所編集方法を設定します。
     *
     * @param 帳票用住所編集方法 帳票用住所編集方法
     */
    public void set帳票用住所編集方法(RString 帳票用住所編集方法) {
        requireNonNull(帳票用住所編集方法, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用住所編集方法"));
        entity.setTyohyoJushoHenshuHouhou(帳票用住所編集方法);
    }

    /**
     * 帳票用方書表示有無を設定します。
     *
     * @param 帳票用方書表示有無 帳票用方書表示有無
     */
    public void set帳票用方書表示有無(RString 帳票用方書表示有無) {
        requireNonNull(帳票用方書表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用方書表示有無"));
        entity.setTyohyoKatagakiHyojiUmu(帳票用方書表示有無);
    }

    /**
     * 外国人氏名表示方法を設定します。
     *
     * @param 外国人氏名表示方法 外国人氏名表示方法
     */
    public void set外国人氏名表示方法(RString 外国人氏名表示方法) {
        requireNonNull(外国人氏名表示方法, UrSystemErrorMessages.値がnull.getReplacedMessage("外国人氏名表示方法"));
        entity.setGaikokujinHyojiHouhou(外国人氏名表示方法);
    }

    /**
     * 老人保健市町村番号を設定します。
     *
     * @param 老人保健市町村番号 老人保健市町村番号
     */
    public void set老人保健市町村番号(RString 老人保健市町村番号) {
        requireNonNull(老人保健市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村番号"));
        entity.setRojinhokenShichosonNo(老人保健市町村番号);
    }

    /**
     * 老人保健受給者番号体系を設定します。
     *
     * @param 老人保健受給者番号体系 老人保健受給者番号体系
     */
    public void set老人保健受給者番号体系(RString 老人保健受給者番号体系) {
        requireNonNull(老人保健受給者番号体系, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号体系"));
        entity.setRokenJukyushaNoTaikei(老人保健受給者番号体系);
    }

    /**
     * 移行日を設定します。
     *
     * @param 移行日 移行日
     */
    public void set移行日(FlexibleDate 移行日) {
        requireNonNull(移行日, UrSystemErrorMessages.値がnull.getReplacedMessage("移行日"));
        entity.setIkoYMD(移行日);
    }

    /**
     * 加入日を設定します。
     *
     * @param 加入日 加入日
     */
    public void set加入日(FlexibleDate 加入日) {
        requireNonNull(加入日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入日"));
        entity.setKanyuYMD(加入日);
    }

    /**
     * 離脱日を設定します。
     *
     * @param 離脱日 離脱日
     */
    public void set離脱日(FlexibleDate 離脱日) {
        requireNonNull(離脱日, UrSystemErrorMessages.値がnull.getReplacedMessage("離脱日"));
        entity.setRidatsuYMD(離脱日);
    }

    /**
     * 合併旧市町村区分を設定します。
     *
     * @param 合併旧市町村区分 合併旧市町村区分
     */
    public void set合併旧市町村区分(RString 合併旧市町村区分) {
        requireNonNull(合併旧市町村区分, UrSystemErrorMessages.値がnull.getReplacedMessage("合併旧市町村区分"));
        entity.setGappeiKyuShichosonKubun(合併旧市町村区分);
    }

    /**
     * 合併旧市町村表示有無を設定します。
     *
     * @param 合併旧市町村表示有無 合併旧市町村表示有無
     */
    public void set合併旧市町村表示有無(RString 合併旧市町村表示有無) {
        requireNonNull(合併旧市町村表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("合併旧市町村表示有無"));
        entity.setGappeiKyuShichosonHyojiUmu(合併旧市町村表示有無);
    }

    /**
     * 合併情報リンク番号を設定します。
     *
     * @param 合併情報リンク番号 合併情報リンク番号
     */
    public void set合併情報リンク番号(RString 合併情報リンク番号) {
        requireNonNull(合併情報リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報リンク番号"));
        entity.setGappeiChiikiNo(合併情報リンク番号);
    }

    /**
     * 運用保険者番号を設定します。
     *
     * @param 運用保険者番号 運用保険者番号
     */
    public void set運用保険者番号(ShoKisaiHokenshaNo 運用保険者番号) {
        requireNonNull(運用保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("運用保険者番号"));
        entity.setUnyoHokenshaNo(運用保険者番号);
    }

    /**
     * 運用開始日を設定します。
     *
     * @param 運用開始日 運用開始日
     */
    public void set運用開始日(FlexibleDate 運用開始日) {
        requireNonNull(運用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("運用開始日"));
        entity.setUnyoKaishiYMD(運用開始日);
    }

    /**
     * 運用終了日を設定します。
     *
     * @param 運用終了日 運用終了日
     */
    public void set運用終了日(FlexibleDate 運用終了日) {
        requireNonNull(運用終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("運用終了日"));
        entity.setUnyoShuryoYMD(運用終了日);
    }

    /**
     * 運用形態区分を設定します。
     *
     * @param 運用形態区分 運用形態区分
     */
    public void set運用形態区分(RString 運用形態区分) {
        requireNonNull(運用形態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("運用形態区分"));
        entity.setUnyoKeitaiKubun(運用形態区分);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
