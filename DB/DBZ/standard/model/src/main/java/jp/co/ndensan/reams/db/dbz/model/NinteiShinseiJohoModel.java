/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定申請情報のモデルクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiShinseiJohoModel implements Serializable {

    private DbT5001NinteiShinseiJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public NinteiShinseiJohoModel() {
        entity = new DbT5001NinteiShinseiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5001NinteiShinseiJohoEntity
     */
    public NinteiShinseiJohoModel(DbT5001NinteiShinseiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5001NinteiShinseiJohoEntityを返します。
     *
     * @return DbT5001NinteiShinseiJohoEntity
     */
    public DbT5001NinteiShinseiJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT5001NinteiShinseiJohoEntityを設定します。
     *
     * @param entity DbT5001NinteiShinseiJohoEntity
     */
    public void setEntity(DbT5001NinteiShinseiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public RString get支所コード() {
        return entity.getShishoCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
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
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請枝番コードを返します。
     *
     * @return 認定申請枝番コード
     */
    public EdabanCode get認定申請枝番コード() {
        return entity.getNinteiShinseiEdabanCode();
    }

    /**
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 認定申請区分（法令）コードを返します。
     *
     * @return 認定申請区分（法令）コード
     */
    public Code get認定申請区分法令コード() {
        return entity.getNinteiShinseiHoreiKubunCode();
    }

    /**
     * 認定申請有効区分を返します。
     *
     * @return 認定申請有効区分
     */
    public Code get認定申請有効区分() {
        return entity.getNinteiShinseiYukoKubunCode();
    }

    /**
     * 要介護申請・要支援申請の区分を返します。
     *
     * @return 要介護申請・要支援申請の区分
     */
    public RString get要介護申請要支援申請の区分() {
        return entity.getShienShinseiKubun();
    }

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    public RString get認定申請理由() {
        return entity.getShinseiRiyu();
    }

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード
     */
    public Code get前回要介護状態区分コード() {
        return entity.getZenYokaigoKubunCode();
    }

    /**
     * 前回認定有効期間を返します。
     *
     * @return 前回認定有効期間
     */
    public int get前回認定有効期間() {
        return entity.getZenYukoKikan();
    }

    /**
     * 情報提供への同意有無を返します。
     *
     * @return 情報提供への同意有無 {true:同意有 false:同意無}
     */
    public boolean is情報提供への同意() {
        return entity.getJohoteikyoDouiUmuKubun();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 認定調査識別コードを返します。
     *
     * @return 認定調査識別コード
     */
    public Code get認定調査識別コード() {
        return entity.getNinteichosaShikibetsuCode();
    }

    /**
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.getIkenshoIraiRirekiNo();
    }

    /**
     * 介護医療機関コードを返します。
     *
     * @return 介護医療機関コード
     */
    public RString get介護医療機関コード() {
        return entity.getKaigoIryokikanCode();
    }

    /**
     * 介護医師コードを返します。
     *
     * @return 介護医師コード
     */
    public RString get介護医師コード() {
        return entity.getKaigoIshiCode();
    }

    /**
     * みなし要介護区分コードを返します。
     *
     * @return みなし要介護区分コード
     */
    public RString getみなし要介護区分コード() {
        return entity.getMinashiCode();
    }

    /**
     * 認定延期通知発行に対する同意有無を返します。
     *
     * @return 認定延期通知発行に対する同意有無 {true:同意有 false:同意無}
     */
    public boolean is認定延期通知発行に対する同意() {
        return entity.getEnkitsuchiDoiUmuKubun();
    }

    /**
     * 施設入所の有無を返します。
     *
     * @return 施設入所の有無 {true:入所有 false:入所無}
     */
    public boolean is施設入所() {
        return entity.getShisetsuNyushoUmuKubun();
    }

    /**
     * 市町村連絡事項を返します。
     *
     * @return 市町村連絡事項
     */
    public RString get市町村連絡事項() {
        return entity.getSichosonRenrakuJiko();
    }

    /**
     * 取下げ区分コードを返します。
     *
     * @return 取下げ区分コード
     */
    public Code get取下げ区分コード() {
        return entity.getTorisageKubunCode();
    }

    /**
     * 取下げ理由を返します。
     *
     * @return 取下げ理由
     */
    public RString get取下げ理由() {
        return entity.getTorisageRiyu();
    }

    /**
     * 取下げ年月日を返します。
     *
     * @return 取下げ年月日
     */
    public FlexibleDate get取下げ年月日() {
        return entity.getTorisageYMD();
    }

    /**
     * 審査継続区分を返します。
     *
     * @return 審査継続区分 {true:審査継続 false:審査継続ではない}
     */
    public boolean is審査継続() {
        return entity.getShinsaKeizokuKubun();
    }

    /**
     * 要介護認定審査会優先振分区分コードを返します。
     *
     * @return 要介護認定審査会優先振分区分コード
     */
    public Code get要介護認定審査会優先振分区分コード() {
        return entity.getShinsakaiYusenWaritsukeKubunCode();
    }

    /**
     * IF送付年月日を返します。
     *
     * @return IF送付年月日
     */
    public FlexibleDate getIF送付年月日() {
        return entity.getIfSofuYMD();
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void set申請書管理番号(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(RString 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     */
    public void set支所コード(RString 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(RString 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
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
     * 認定申請年月日を設定します。
     *
     * @param 認定申請年月日 認定申請年月日
     */
    public void set認定申請年月日(FlexibleDate 認定申請年月日) {
        requireNonNull(認定申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請年月日"));
        entity.setNinteiShinseiYMD(認定申請年月日);
    }

    /**
     * 認定申請枝番コードを設定します。
     *
     * @param 認定申請枝番コード 認定申請枝番コード
     */
    public void set認定申請枝番コード(EdabanCode 認定申請枝番コード) {
        requireNonNull(認定申請枝番コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請枝番コード"));
        entity.setNinteiShinseiEdabanCode(認定申請枝番コード);
    }

    /**
     * 認定申請区分（申請時）コードを設定します。
     *
     * @param 認定申請区分申請時コード 認定申請区分申請時コード
     */
    public void set認定申請区分申請時コード(Code 認定申請区分申請時コード) {
        requireNonNull(認定申請区分申請時コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請区分申請時コード"));
        entity.setNinteiShinseiShinseijiKubunCode(認定申請区分申請時コード);
    }

    /**
     * 認定申請区分（法令）コードを設定します。
     *
     * @param 認定申請区分法令コード 認定申請区分法令コード
     */
    public void set認定申請区分法令コード(Code 認定申請区分法令コード) {
        requireNonNull(認定申請区分法令コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請区分法令コード"));
        entity.setNinteiShinseiHoreiKubunCode(認定申請区分法令コード);
    }

    /**
     * 認定申請有効区分を設定します。
     *
     * @param 認定申請有効区分 認定申請有効区分
     */
    public void set認定申請有効区分(Code 認定申請有効区分) {
        requireNonNull(認定申請有効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請有効区分"));
        entity.setNinteiShinseiYukoKubunCode(認定申請有効区分);
    }

    /**
     * 要介護申請・要支援申請の区分を設定します。
     *
     * @param 要介護申請要支援申請の区分 要介護申請要支援申請の区分
     */
    public void set要介護申請要支援申請の区分(RString 要介護申請要支援申請の区分) {
        requireNonNull(要介護申請要支援申請の区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護申請要支援申請の区分"));
        entity.setShienShinseiKubun(要介護申請要支援申請の区分);
    }

    /**
     * 認定申請理由を設定します。
     *
     * @param 認定申請理由 認定申請理由
     */
    public void set認定申請理由(RString 認定申請理由) {
        requireNonNull(認定申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請理由"));
        entity.setShinseiRiyu(認定申請理由);
    }

    /**
     * 前回要介護状態区分コードを設定します。
     *
     * @param 前回要介護状態区分コード 前回要介護状態区分コード
     */
    public void set前回要介護状態区分コード(Code 前回要介護状態区分コード) {
        requireNonNull(前回要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("前回要介護状態区分コード"));
        entity.setZenYokaigoKubunCode(前回要介護状態区分コード);
    }

    /**
     * 前回認定有効期間を設定します。
     *
     * @param 前回認定有効期間 前回認定有効期間
     */
    public void set前回認定有効期間(int 前回認定有効期間) {
        requireNonNull(前回認定有効期間, UrSystemErrorMessages.値がnull.getReplacedMessage("前回認定有効期間"));
        entity.setZenYukoKikan(前回認定有効期間);
    }

    /**
     * 情報提供への同意有無を設定します。
     *
     * @param 情報提供への同意有無 情報提供への同意有無
     */
    public void set情報提供への同意有無(boolean 情報提供への同意有無) {
        requireNonNull(情報提供への同意有無, UrSystemErrorMessages.値がnull.getReplacedMessage("情報提供への同意有無"));
        entity.setJohoteikyoDouiUmuKubun(情報提供への同意有無);
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public void set認定調査依頼履歴番号(int 認定調査依頼履歴番号) {
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        entity.setNinteichosaIraiRirekiNo(認定調査依頼履歴番号);
    }

    /**
     * 認定調査識別コードを設定します。
     *
     * @param 認定調査識別コード 認定調査識別コード
     */
    public void set認定調査識別コード(Code 認定調査識別コード) {
        requireNonNull(認定調査識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査識別コード"));
        entity.setNinteichosaShikibetsuCode(認定調査識別コード);
    }

    /**
     * 主治医意見書作成依頼履歴番号を設定します。
     *
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public void set主治医意見書作成依頼履歴番号(int 主治医意見書作成依頼履歴番号) {
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
    }

    /**
     * 介護医療機関コードを設定します。
     *
     * @param 介護医療機関コード 介護医療機関コード
     */
    public void set介護医療機関コード(RString 介護医療機関コード) {
        requireNonNull(介護医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護医療機関コード"));
        entity.setKaigoIryokikanCode(介護医療機関コード);
    }

    /**
     * 介護医師コードを設定します。
     *
     * @param 介護医師コード 介護医師コード
     */
    public void set介護医師コード(RString 介護医師コード) {
        requireNonNull(介護医師コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護医師コード"));
        entity.setKaigoIshiCode(介護医師コード);
    }

    /**
     * みなし要介護区分コードを設定します。
     *
     * @param みなし要介護区分コード みなし要介護区分コード
     */
    public void setみなし要介護区分コード(RString みなし要介護区分コード) {
        requireNonNull(みなし要介護区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("みなし要介護区分コード"));
        entity.setMinashiCode(みなし要介護区分コード);
    }

    /**
     * 認定延期通知発行に対する同意有無を設定します。
     *
     * @param 認定延期通知発行に対する同意有無 認定延期通知発行に対する同意有無
     */
    public void set認定延期通知発行に対する同意有無(boolean 認定延期通知発行に対する同意有無) {
        requireNonNull(認定延期通知発行に対する同意有無, UrSystemErrorMessages.値がnull.getReplacedMessage("認定延期通知発行に対する同意有無"));
        entity.setEnkitsuchiDoiUmuKubun(認定延期通知発行に対する同意有無);
    }

    /**
     * 施設入所の有無を設定します。
     *
     * @param 施設入所の有無 施設入所の有無
     */
    public void set施設入所の有無(boolean 施設入所の有無) {
        requireNonNull(施設入所の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("施設入所の有無"));
        entity.setShisetsuNyushoUmuKubun(施設入所の有無);
    }

    /**
     * 市町村連絡事項を設定します。
     *
     * @param 市町村連絡事項 市町村連絡事項
     */
    public void set市町村連絡事項(RString 市町村連絡事項) {
        requireNonNull(市町村連絡事項, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村連絡事項"));
        entity.setSichosonRenrakuJiko(市町村連絡事項);
    }

    /**
     * 取下げ区分コードを設定します。
     *
     * @param 取下げ区分コード 取下げ区分コード
     */
    public void set取下げ区分コード(Code 取下げ区分コード) {
        requireNonNull(取下げ区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("取下げ区分コード"));
        entity.setTorisageKubunCode(取下げ区分コード);
    }

    /**
     * 取下げ理由を設定します。
     *
     * @param 取下げ理由 取下げ理由
     */
    public void set取下げ理由(RString 取下げ理由) {
        requireNonNull(取下げ理由, UrSystemErrorMessages.値がnull.getReplacedMessage("取下げ理由"));
        entity.setTorisageRiyu(取下げ理由);
    }

    /**
     * 取下げ年月日を設定します。
     *
     * @param 取下げ年月日 取下げ年月日
     */
    public void set取下げ年月日(FlexibleDate 取下げ年月日) {
        requireNonNull(取下げ年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("取下げ年月日"));
        entity.setTorisageYMD(取下げ年月日);
    }

    /**
     * 審査継続区分を設定します。
     *
     * @param 審査継続区分 審査継続区分
     */
    public void set審査継続区分(boolean 審査継続区分) {
        requireNonNull(審査継続区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査継続区分"));
        entity.setShinsaKeizokuKubun(審査継続区分);
    }

    /**
     * 要介護認定審査会優先振分区分コードを設定します。
     *
     * @param 要介護認定審査会優先振分区分コード 要介護認定審査会優先振分区分コード
     */
    public void set要介護認定審査会優先振分区分コード(Code 要介護認定審査会優先振分区分コード) {
        requireNonNull(要介護認定審査会優先振分区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定審査会優先振分区分コード"));
        entity.setShinsakaiYusenWaritsukeKubunCode(要介護認定審査会優先振分区分コード);
    }

    /**
     * IF送付年月日を設定します。
     *
     * @param if送付年月日 IF送付年月日
     */
    public void setIF送付年月日(FlexibleDate if送付年月日) {
        requireNonNull(if送付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("IF送付年月日"));
        entity.setIfSofuYMD(if送付年月日);
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
