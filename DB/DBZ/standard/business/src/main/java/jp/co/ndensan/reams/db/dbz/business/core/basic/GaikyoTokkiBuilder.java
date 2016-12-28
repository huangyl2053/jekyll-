/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link GaikyoTokki}の編集を行うビルダークラスです。
 */
public class GaikyoTokkiBuilder {

    private final DbT5206GaikyoTokkiEntity entity;
    private final GaikyoTokkiIdentifier id;

    /**
     * {@link DbT5206GaikyoTokkiEntity}より{@link GaikyoTokki}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5206GaikyoTokkiEntity}
     * @param id {@link GaikyoTokkiIdentifier}
     *
     */
    GaikyoTokkiBuilder(
            DbT5206GaikyoTokkiEntity entity,
            GaikyoTokkiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set認定調査依頼履歴番号(int 認定調査依頼履歴番号) {
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        return this;
    }

    /**
     * 概況特記テキストイメージ区分を設定します。
     *
     * @param 概況特記テキストイメージ区分 概況特記テキストイメージ区分
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set概況特記テキストイメージ区分(RString 概況特記テキストイメージ区分) {
        requireNonNull(概況特記テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記テキストイメージ区分"));
        entity.setGaikyoTokkiTextImageKubun(概況特記テキストイメージ区分);
        return this;
    }

    /**
     * 原本マスク区分を設定します。
     *
     * @param 原本マスク区分 原本マスク区分
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set原本マスク区分(Code 原本マスク区分) {
        requireNonNull(原本マスク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク区分"));
        entity.setGenponMaskKubun(原本マスク区分);
        return this;
    }

    /**
     * 住宅改修(回収箇所)を設定します。
     *
     * @param 住宅改修 住宅改修(回収箇所)
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set住宅改修(RString 住宅改修) {
        requireNonNull(住宅改修, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修"));
        entity.setJutakuKaishu(住宅改修);
        return this;
    }

    /**
     * 市町村特別給付サービス種類名。
     *
     * @param 市町村特別給付サービス種類名 市町村特別給付サービス種類名
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set市町村特別給付サービス種類名(RString 市町村特別給付サービス種類名) {
        requireNonNull(市町村特別給付サービス種類名, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付サービス種類名"));
        entity.setTokubetsuKyufuService(市町村特別給付サービス種類名);
        return this;
    }

    /**
     * 介護保険給付以外の在宅サービス種類名。
     *
     * @param 介護保険給付以外の在宅サービス種類名 介護保険給付以外の在宅サービス種類名
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set介護保険給付以外の在宅サービス種類名(RString 介護保険給付以外の在宅サービス種類名) {
        requireNonNull(介護保険給付以外の在宅サービス種類名, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険給付以外の在宅サービス種類名"));
        entity.setZaitakuService(介護保険給付以外の在宅サービス種類名);
        return this;
    }

    /**
     * 概況特記事項_主訴を設定します。
     *
     * @param 概況特記事項_主訴 概況特記事項_主訴
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set概況特記事項_主訴(RString 概況特記事項_主訴) {
        requireNonNull(概況特記事項_主訴, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記事項_主訴"));
        entity.setShuso(概況特記事項_主訴);
        return this;
    }

    /**
     * 概況特記_主訴_イメージ共有ファイルIDを設定します。
     *
     * @param 概況特記_主訴_イメージ共有ファイルID 概況特記_主訴_イメージ共有ファイルID
     * @return {@link GaikyoTokkiBuilder}
     */
//    public GaikyoTokkiBuilder set概況特記_主訴_イメージ共有ファイルID(RDateTime 概況特記_主訴_イメージ共有ファイルID) {
//        requireNonNull(概況特記_主訴_イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記_主訴_イメージ共有ファイルID"));
//        entity.setShusoImageSharedFileId(概況特記_主訴_イメージ共有ファイルID);
//        return this;
//    }
    /**
     * 概況特記_主訴_マスキングイメージ共有ファイルIDを設定します。
     *
     * @param 概況特記_主訴_マスキングイメージ共有ファイルID 概況特記_主訴_マスキングイメージ共有ファイルID
     * @return {@link GaikyoTokkiBuilder}
     */
//    public GaikyoTokkiBuilder set概況特記_主訴_マスキングイメージ共有ファイルID(RDateTime 概況特記_主訴_マスキングイメージ共有ファイルID) {
//        requireNonNull(概況特記_主訴_マスキングイメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記_主訴_マスキングイメージ共有ファイルID"));
//        entity.setShusoMaskingImageSharedFileId(概況特記_主訴_マスキングイメージ共有ファイルID);
//        return this;
//    }
    /**
     * 概況特記事項_家族状況を設定します。
     *
     * @param 概況特記事項_家族状況 概況特記事項_家族状況
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set概況特記事項_家族状況(RString 概況特記事項_家族状況) {
        requireNonNull(概況特記事項_家族状況, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記事項_家族状況"));
        entity.setKazokuJokyo(概況特記事項_家族状況);
        return this;
    }

    /**
     * 概況特記_家族状況_イメージ共有ファイルIDを設定します。
     *
     * @param 概況特記_家族状況_イメージ共有ファイルID 概況特記_家族状況_イメージ共有ファイルID
     * @return {@link GaikyoTokkiBuilder}
     */
//    public GaikyoTokkiBuilder set概況特記_家族状況_イメージ共有ファイルID(RDateTime 概況特記_家族状況_イメージ共有ファイルID) {
//        requireNonNull(概況特記_家族状況_イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記_家族状況_イメージ共有ファイルID"));
//        entity.setKazokuJokyoImageSharedFileId(概況特記_家族状況_イメージ共有ファイルID);
//        return this;
//    }
    /**
     * 概況特記_家族状況_マスキングイメージ共有ファイルIDを設定します。
     *
     * @param 概況特記_家族状況_マスキングイメージ共有ファイルID 概況特記_家族状況_マスキングイメージ共有ファイルID
     * @return {@link GaikyoTokkiBuilder}
     */
//    public GaikyoTokkiBuilder set概況特記_家族状況_マスキングイメージ共有ファイルID(RDateTime 概況特記_家族状況_マスキングイメージ共有ファイルID) {
//        requireNonNull(概況特記_家族状況_マスキングイメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記_家族状況_マスキングイメージ共有ファイルID"));
//        entity.setKazokuJokyoMaskingImageSharedFileId(概況特記_家族状況_マスキングイメージ共有ファイルID);
//        return this;
//    }
    /**
     * 概況特記事項_居住環境を設定します。
     *
     * @param 概況特記事項_居住環境 概況特記事項_居住環境
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set概況特記事項_居住環境(RString 概況特記事項_居住環境) {
        requireNonNull(概況特記事項_居住環境, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記事項_居住環境"));
        entity.setKyojuKankyo(概況特記事項_居住環境);
        return this;
    }

    /**
     * 概況特記_居住環境_イメージ共有ファイルIDを設定します。
     *
     * @param 概況特記_居住環境_イメージ共有ファイルID 概況特記_居住環境_イメージ共有ファイルID
     * @return {@link GaikyoTokkiBuilder}
     */
//    public GaikyoTokkiBuilder set概況特記_居住環境_イメージ共有ファイルID(RDateTime 概況特記_居住環境_イメージ共有ファイルID) {
//        requireNonNull(概況特記_居住環境_イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記_居住環境_イメージ共有ファイルID"));
//        entity.setKyojuKankyoImageSharedFileId(概況特記_居住環境_イメージ共有ファイルID);
//        return this;
//    }
    /**
     * 概況特記_居住環境_マスキングイメージ共有ファイルIDを設定します。
     *
     * @param 概況特記_居住環境_マスキングイメージ共有ファイルID 概況特記_居住環境_マスキングイメージ共有ファイルID
     * @return {@link GaikyoTokkiBuilder}
     */
//    public GaikyoTokkiBuilder set概況特記_居住環境_マスキングイメージ共有ファイルID(RDateTime 概況特記_居住環境_マスキングイメージ共有ファイルID) {
//        requireNonNull(概況特記_居住環境_マスキングイメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記_居住環境_マスキングイメージ共有ファイルID"));
//        entity.setKyojuKankyoMaskingImageSharedFileId(概況特記_居住環境_マスキングイメージ共有ファイルID);
//        return this;
//    }
    /**
     * 概況特記事項_機器_器械を設定します。
     *
     * @param 概況特記事項_機器_器械 概況特記事項_機器_器械
     * @return {@link GaikyoTokkiBuilder}
     */
    public GaikyoTokkiBuilder set概況特記事項_機器_器械(RString 概況特記事項_機器_器械) {
        requireNonNull(概況特記事項_機器_器械, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記事項_機器_器械"));
        entity.setKikaiKiki(概況特記事項_機器_器械);
        return this;
    }

    /**
     * 概況特記_機器_器械_イメージ共有ファイルIDを設定します。
     *
     * @param 概況特記_機器_器械_イメージ共有ファイルID 概況特記_機器_器械_イメージ共有ファイルID
     * @return {@link GaikyoTokkiBuilder}
     */
//    public GaikyoTokkiBuilder set概況特記_機器_器械_イメージ共有ファイルID(RDateTime 概況特記_機器_器械_イメージ共有ファイルID) {
//        requireNonNull(概況特記_機器_器械_イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記_機器_器械_イメージ共有ファイルID"));
//        entity.setKikaiKikiImageSharedFileId(概況特記_機器_器械_イメージ共有ファイルID);
//        return this;
//    }
    /**
     * 概況特記_機器_器械_マスキングイメージ共有ファイルIDを設定します。
     *
     * @param 概況特記_機器_器械_マスキングイメージ共有ファイルID 概況特記_機器_器械_マスキングイメージ共有ファイルID
     * @return {@link GaikyoTokkiBuilder}
     */
//    public GaikyoTokkiBuilder set概況特記_機器_器械_マスキングイメージ共有ファイルID(RDateTime 概況特記_機器_器械_マスキングイメージ共有ファイルID) {
//        requireNonNull(概況特記_機器_器械_マスキングイメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記_機器_器械_マスキングイメージ共有ファイルID"));
//        entity.setKikaiKikiMaskingImageSharedFileId(概況特記_機器_器械_マスキングイメージ共有ファイルID);
//        return this;
//    }
    /**
     * {@link GaikyoTokki}のインスタンスを生成します。
     *
     * @return {@link GaikyoTokki}のインスタンス
     */
    public GaikyoTokki build() {
        return new GaikyoTokki(entity, id);
    }
}
