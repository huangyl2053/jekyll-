/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 不服審査申立情報のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class FufukuMoshitateModel implements Serializable {

    private DbT7001FufukuMoshitateEntity entity;

    /**
     * コンストラクタです。
     */
    public FufukuMoshitateModel() {
        entity = new DbT7001FufukuMoshitateEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7001FufukuMoshitateEntity
     */
    public FufukuMoshitateModel(DbT7001FufukuMoshitateEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7001FufukuMoshitateEntityを返します。
     *
     * @return DbT7001FufukuMoshitateEntity
     */
    public DbT7001FufukuMoshitateEntity getEntity() {
        return entity;
    }

    /**
     * DbT7001FufukuMoshitateEntityを設定します。
     *
     * @param entity DbT7001FufukuMoshitateEntity
     */
    public void setEntity(DbT7001FufukuMoshitateEntity entity) {
        this.entity = entity;
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
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 原処分被保険者番号を返します。
     *
     * @return 原処分被保険者番号
     */
    public HihokenshaNo get原処分被保険者番号() {
        return entity.getGenshobunsHihokennshaNo();
    }

    /**
     * 審査請求届出日を返します。
     *
     * @return 審査請求届出日
     */
    public FlexibleDate get審査請求届出日() {
        return entity.getShinsaSeikyuTodokedeYMD();
    }

    /**
     * 原処分被保険者郵便番号を返します。
     *
     * @return 原処分被保険者郵便番号
     */
    public YubinNo get原処分被保険者郵便番号() {
        return entity.getGenshobunHihokenshaYubinNo();
    }

    /**
     * 原処分被保険者住所を返します。
     *
     * @return 原処分被保険者住所
     */
    public AtenaJusho get原処分被保険者住所() {
        return entity.getGenshobunHihokenshaJusho();
    }

    /**
     * 原処分被保険者氏名を返します。
     *
     * @return 原処分被保険者氏名
     */
    public AtenaMeisho get原処分被保険者氏名() {
        return entity.getGenshobunHihokenshaShimei();
    }

    /**
     * 原処分被保険者電話番号を返します。
     *
     * @return 原処分被保険者電話番号
     */
    public TelNo get原処分被保険者電話番号() {
        return entity.getGenshobunHihokenshaTelNo();
    }

    /**
     * 原処分被保険者生年月日を返します。
     *
     * @return 原処分被保険者生年月日
     */
    public FlexibleDate get原処分被保険者生年月日() {
        return entity.getGenshobunHihokenshaBirthYMD();
    }

    /**
     * 審査請求人郵便番号を返します。
     *
     * @return 審査請求人郵便番号
     */
    public YubinNo get審査請求人郵便番号() {
        return entity.getShinsaSeikyuninYubinNo();
    }

    /**
     * 審査請求人住所を返します。
     *
     * @return 審査請求人住所
     */
    public AtenaJusho get審査請求人住所() {
        return entity.getShinsaSeikyuninJusho();
    }

    /**
     * 審査請求人氏名を返します。
     *
     * @return 審査請求人氏名
     */
    public AtenaMeisho get審査請求人氏名() {
        return entity.getShinsaSeikyuninShimei();
    }

    /**
     * 審査請求人電話番号を返します。
     *
     * @return 審査請求人電話番号
     */
    public TelNo get審査請求人電話番号() {
        return entity.getShinsaSeikyuninTelNo();
    }

    /**
     * 被保険者との関係コードを返します。
     *
     * @return 被保険者との関係コード
     */
    public Code get被保険者との関係コード() {
        return entity.getHihokenshaTonoKankeiCode();
    }

    /**
     * 代理人郵便番号を返します。
     *
     * @return 代理人郵便番号
     */
    public YubinNo get代理人郵便番号() {
        return entity.getDairininYubinNo();
    }

    /**
     * 代理人住所を返します。
     *
     * @return 代理人住所
     */
    public AtenaJusho get代理人住所() {
        return entity.getDairininJusho();
    }

    /**
     * 代理人氏名を返します。
     *
     * @return 代理人氏名
     */
    public AtenaMeisho get代理人氏名() {
        return entity.getDairininShimei();
    }

    /**
     * 代理人電話番号を返します。
     *
     * @return 代理人電話番号
     */
    public TelNo get代理人電話番号() {
        return entity.getDairininTelNo();
    }

    /**
     * 処分庁を返します。
     *
     * @return 処分庁
     */
    public RString get処分庁() {
        return entity.getShobunCho();
    }

    /**
     * 処分日を返します。
     *
     * @return 処分日
     */
    public FlexibleDate get処分日() {
        return entity.getShobunYMD();
    }

    /**
     * 処分種類コードを返します。
     *
     * @return 処分種類コード
     */
    public Code get処分種類コード() {
        return entity.getShobunShuruiCode();
    }

    /**
     * 処分があったことを知った日を返します。
     *
     * @return 処分があったことを知った日
     */
    public FlexibleDate get処分があったことを知った日() {
        return entity.getShobunKakuninYMD();
    }

    /**
     * 審査請求の理由を返します。
     *
     * @return 審査請求の理由
     */
    public RString get審査請求の理由() {
        return entity.getShinsaSeikyuRiyu();
    }

    /**
     * 処分庁教示の有無及び教示の内容を返します。
     *
     * @return 処分庁教示の有無及び教示の内容
     */
    public RString get処分庁教示の有無及び教示の内容() {
        return entity.getShobunChoKyojiNaiyo();
    }

    /**
     * 添付書類等を返します。
     *
     * @return 添付書類等
     */
    public boolean get添付書類等() {
        return entity.getTempuShoruiTo();
    }

    /**
     * 審査請求取下日を返します。
     *
     * @return 審査請求取下日
     */
    public FlexibleDate get審査請求取下日() {
        return entity.getShinsaSeikyuTorisageYMD();
    }

    /**
     * 弁明書登録フラグを返します。
     *
     * @return 弁明書登録フラグ
     */
    public boolean get弁明書登録フラグ() {
        return entity.getBemmeishoTorokuFlag();
    }

    /**
     * 弁明書作成日を返します。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate get弁明書作成日() {
        return entity.getBemmeishoSakuseiYMD();
    }

    /**
     * 裁決日を返します。
     *
     * @return 裁決日
     */
    public FlexibleDate get裁決日() {
        return entity.getSaiketsuYMD();
    }

    /**
     * 裁決結果を返します。
     *
     * @return 裁決結果
     */
    public RString get裁決結果() {
        return entity.getSaiketsuKekka();
    }

    /**
     * 裁決理由を返します。
     *
     * @return 裁決理由
     */
    public RString get裁決理由() {
        return entity.getSaiketsuRiyu();
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
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 原処分被保険者番号を設定します。
     *
     * @param 原処分被保険者番号 原処分被保険者番号
     */
    public void set原処分被保険者番号(HihokenshaNo 原処分被保険者番号) {
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        entity.setGenshobunsHihokennshaNo(原処分被保険者番号);
    }

    /**
     * 審査請求届出日を設定します。
     *
     * @param 審査請求届出日 審査請求届出日
     */
    public void set審査請求届出日(FlexibleDate 審査請求届出日) {
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        entity.setShinsaSeikyuTodokedeYMD(審査請求届出日);
    }

    /**
     * 原処分被保険者郵便番号を設定します。
     *
     * @param 原処分被保険者郵便番号 原処分被保険者郵便番号
     */
    public void set原処分被保険者郵便番号(YubinNo 原処分被保険者郵便番号) {
        requireNonNull(原処分被保険者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者郵便番号"));
        entity.setGenshobunHihokenshaYubinNo(原処分被保険者郵便番号);
    }

    /**
     * 原処分被保険者住所を設定します。
     *
     * @param 原処分被保険者住所 原処分被保険者住所
     */
    public void set原処分被保険者住所(AtenaJusho 原処分被保険者住所) {
        requireNonNull(原処分被保険者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者住所"));
        entity.setGenshobunHihokenshaJusho(原処分被保険者住所);
    }

    /**
     * 原処分被保険者氏名を設定します。
     *
     * @param 原処分被保険者氏名 原処分被保険者氏名
     */
    public void set原処分被保険者氏名(AtenaMeisho 原処分被保険者氏名) {
        requireNonNull(原処分被保険者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者氏名"));
        entity.setGenshobunHihokenshaShimei(原処分被保険者氏名);
    }

    /**
     * 原処分被保険者電話番号を設定します。
     *
     * @param 原処分被保険者電話番号 原処分被保険者電話番号
     */
    public void set原処分被保険者電話番号(TelNo 原処分被保険者電話番号) {
        requireNonNull(原処分被保険者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者電話番号"));
        entity.setGenshobunHihokenshaTelNo(原処分被保険者電話番号);
    }

    /**
     * 原処分被保険者生年月日を設定します。
     *
     * @param 原処分被保険者生年月日 原処分被保険者生年月日
     */
    public void set原処分被保険者生年月日(FlexibleDate 原処分被保険者生年月日) {
        requireNonNull(原処分被保険者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者生年月日"));
        entity.setGenshobunHihokenshaBirthYMD(原処分被保険者生年月日);
    }

    /**
     * 審査請求人郵便番号を設定します。
     *
     * @param 審査請求人郵便番号 審査請求人郵便番号
     */
    public void set審査請求人郵便番号(YubinNo 審査請求人郵便番号) {
        requireNonNull(審査請求人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求人郵便番号"));
        entity.setShinsaSeikyuninYubinNo(審査請求人郵便番号);
    }

    /**
     * 審査請求人住所を設定します。
     *
     * @param 審査請求人住所 審査請求人住所
     */
    public void set審査請求人住所(AtenaJusho 審査請求人住所) {
        requireNonNull(審査請求人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求人住所"));
        entity.setShinsaSeikyuninJusho(審査請求人住所);
    }

    /**
     * 審査請求人氏名を設定します。
     *
     * @param 審査請求人氏名 審査請求人氏名
     */
    public void set審査請求人氏名(AtenaMeisho 審査請求人氏名) {
        requireNonNull(審査請求人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求人氏名"));
        entity.setShinsaSeikyuninShimei(審査請求人氏名);
    }

    /**
     * 審査請求人電話番号を設定します。
     *
     * @param 審査請求人電話番号 審査請求人電話番号
     */
    public void set審査請求人電話番号(TelNo 審査請求人電話番号) {
        requireNonNull(審査請求人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求人電話番号"));
        entity.setShinsaSeikyuninTelNo(審査請求人電話番号);
    }

    /**
     * 被保険者との関係コードを設定します。
     *
     * @param 被保険者との関係コード 被保険者との関係コード
     */
    public void set被保険者との関係コード(Code 被保険者との関係コード) {
        requireNonNull(被保険者との関係コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者との関係コード"));
        entity.setHihokenshaTonoKankeiCode(被保険者との関係コード);
    }

    /**
     * 代理人郵便番号を設定します。
     *
     * @param 代理人郵便番号 代理人郵便番号
     */
    public void set代理人郵便番号(YubinNo 代理人郵便番号) {
        requireNonNull(代理人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("代理人郵便番号"));
        entity.setDairininYubinNo(代理人郵便番号);
    }

    /**
     * 代理人住所を設定します。
     *
     * @param 代理人住所 代理人住所
     */
    public void set代理人住所(AtenaJusho 代理人住所) {
        requireNonNull(代理人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("代理人住所"));
        entity.setDairininJusho(代理人住所);
    }

    /**
     * 代理人氏名を設定します。
     *
     * @param 代理人氏名 代理人氏名
     */
    public void set代理人氏名(AtenaMeisho 代理人氏名) {
        requireNonNull(代理人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("代理人氏名"));
        entity.setDairininShimei(代理人氏名);
    }

    /**
     * 代理人電話番号を設定します。
     *
     * @param 代理人電話番号 代理人電話番号
     */
    public void set代理人電話番号(TelNo 代理人電話番号) {
        requireNonNull(代理人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("代理人電話番号"));
        entity.setDairininTelNo(代理人電話番号);
    }

    /**
     * 処分庁を設定します。
     *
     * @param 処分庁 処分庁
     */
    public void set処分庁(RString 処分庁) {
        requireNonNull(処分庁, UrSystemErrorMessages.値がnull.getReplacedMessage("処分庁"));
        entity.setShobunCho(処分庁);
    }

    /**
     * 処分日を設定します。
     *
     * @param 処分日 処分日
     */
    public void set処分日(FlexibleDate 処分日) {
        requireNonNull(処分日, UrSystemErrorMessages.値がnull.getReplacedMessage("処分日"));
        entity.setShobunYMD(処分日);
    }

    /**
     * 処分種類コードを設定します。
     *
     * @param 処分種類コード 処分種類コード
     */
    public void set処分種類コード(Code 処分種類コード) {
        requireNonNull(処分種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("処分種類コード"));
        entity.setShobunShuruiCode(処分種類コード);
    }

    /**
     * 処分があったことを知った日を設定します。
     *
     * @param 処分があったことを知った日 処分があったことを知った日
     */
    public void set処分があったことを知った日(FlexibleDate 処分があったことを知った日) {
        requireNonNull(処分があったことを知った日, UrSystemErrorMessages.値がnull.getReplacedMessage("処分があったことを知った日"));
        entity.setShobunKakuninYMD(処分があったことを知った日);
    }

    /**
     * 審査請求の理由を設定します。
     *
     * @param 審査請求の理由 審査請求の理由
     */
    public void set審査請求の理由(RString 審査請求の理由) {
        requireNonNull(審査請求の理由, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求の理由"));
        entity.setShinsaSeikyuRiyu(審査請求の理由);
    }

    /**
     * 処分庁教示の有無及び教示の内容を設定します。
     *
     * @param 処分庁教示の有無及び教示の内容 処分庁教示の有無及び教示の内容
     */
    public void set処分庁教示の有無及び教示の内容(RString 処分庁教示の有無及び教示の内容) {
        requireNonNull(処分庁教示の有無及び教示の内容, UrSystemErrorMessages.値がnull.getReplacedMessage("処分庁教示の有無及び教示の内容"));
        entity.setShobunChoKyojiNaiyo(処分庁教示の有無及び教示の内容);
    }

    /**
     * 添付書類等を設定します。
     *
     * @param 添付書類等 添付書類等
     */
    public void set添付書類等(boolean 添付書類等) {
        requireNonNull(添付書類等, UrSystemErrorMessages.値がnull.getReplacedMessage("添付書類等"));
        entity.setTempuShoruiTo(添付書類等);
    }

    /**
     * 審査請求取下日を設定します。
     *
     * @param 審査請求取下日 審査請求取下日
     */
    public void set審査請求取下日(FlexibleDate 審査請求取下日) {
        requireNonNull(審査請求取下日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求取下日"));
        entity.setShinsaSeikyuTorisageYMD(審査請求取下日);
    }

    /**
     * 弁明書登録フラグを設定します。
     *
     * @param 弁明書登録フラグ 弁明書登録フラグ
     */
    public void set弁明書登録フラグ(boolean 弁明書登録フラグ) {
        requireNonNull(弁明書登録フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書登録フラグ"));
        entity.setBemmeishoTorokuFlag(弁明書登録フラグ);
    }

    /**
     * 弁明書作成日を設定します。
     *
     * @param 弁明書作成日 弁明書作成日
     */
    public void set弁明書作成日(FlexibleDate 弁明書作成日) {
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        entity.setBemmeishoSakuseiYMD(弁明書作成日);
    }

    /**
     * 裁決日を設定します。
     *
     * @param 裁決日 裁決日
     */
    public void set裁決日(FlexibleDate 裁決日) {
        requireNonNull(裁決日, UrSystemErrorMessages.値がnull.getReplacedMessage("裁決日"));
        entity.setSaiketsuYMD(裁決日);
    }

    /**
     * 裁決結果を設定します。
     *
     * @param 裁決結果 裁決結果
     */
    public void set裁決結果(RString 裁決結果) {
        requireNonNull(裁決結果, UrSystemErrorMessages.値がnull.getReplacedMessage("裁決結果"));
        entity.setSaiketsuKekka(裁決結果);
    }

    /**
     * 裁決理由を設定します。
     *
     * @param 裁決理由 裁決理由
     */
    public void set裁決理由(RString 裁決理由) {
        requireNonNull(裁決理由, UrSystemErrorMessages.値がnull.getReplacedMessage("裁決理由"));
        entity.setSaiketsuRiyu(裁決理由);
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
