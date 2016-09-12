/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link YokaigoNinteiTsutisho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
public class YokaigoNinteiTsutishoBuilder {

    private final DbT4101NinteiShinseiJohoEntity 要介護認定申請情報受給Entity;
    private final DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private final DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity;

    /**
     * {@link YokaigoNinteiTsutisho}の編集用Builderクラスを生成します。
     *
     * @param 要介護認定申請情報認定Entity DbT5101NinteiShinseiJohoEntity
     * @param 主治医医療機関情報認定Entity DbT5911ShujiiIryoKikanJohoEntity
     * @param 主治医情報認定Entity DbT5912ShujiiJohoEntity
     * @param 要介護認定申請情報受給Entity DbT4101NinteiShinseiJohoEntity
     * @param 受給者台帳Entity DbT4001JukyushaDaichoEntity
     * @param 認定調査委託先情報Entity DbT4910NinteichosaItakusakiJohoEntity
     * @param 主治医医療機関情報受給Entity DbT4911ShujiiIryoKikanJohoEntity
     * @param 主治医情報受給Entity DbT4912ShujiiJohoEntity
     * @param 調査員情報Entity DbT4913ChosainJohoEntity
     * @param 要介護認定結果情報Entity DbT4102NinteiKekkaJohoEntity
     * @param 要介護認定インターフェース情報Entity DbT4003YokaigoNinteiInterfaceEntity
     */
    YokaigoNinteiTsutishoBuilder(
            DbT4101NinteiShinseiJohoEntity 要介護認定申請情報受給Entity,
            DbT4001JukyushaDaichoEntity 受給者台帳Entity,
            DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity
    ) {
        this.要介護認定申請情報受給Entity = 要介護認定申請情報受給Entity.clone();
        this.受給者台帳Entity = 受給者台帳Entity.clone();
        this.要介護認定結果情報Entity = 要介護認定結果情報Entity.clone();
    }

    /**
     * 受給者台帳履歴番号を設定します。
     *
     * @param 受給者台帳履歴番号 受給者台帳履歴番号
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳履歴番号(RString 受給者台帳履歴番号) {
        requireNonNull(受給者台帳履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳履歴番号"));
        this.受給者台帳Entity.setRirekiNo(受給者台帳履歴番号);
        return this;
    }

    /**
     * 受給者台帳申請状況区分を設定します。
     *
     * @param 受給者台帳申請状況区分 受給者台帳申請状況区分
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳申請状況区分(RString 受給者台帳申請状況区分) {
        requireNonNull(受給者台帳申請状況区分, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳申請状況区分"));
        this.受給者台帳Entity.setShinseiJokyoKubun(受給者台帳申請状況区分);
        return this;
    }

    /**
     * 受給者台帳直近フラグを設定します。
     *
     * @param 受給者台帳直近フラグ 受給者台帳直近フラグ
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳直近フラグ(boolean 受給者台帳直近フラグ) {
        requireNonNull(受給者台帳直近フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳直近フラグ"));
        this.受給者台帳Entity.setChokkinFlag(受給者台帳直近フラグ);
        return this;
    }

    /**
     * 受給者台帳審査会依頼年月日を設定します。
     *
     * @param 受給者台帳審査会依頼年月日 受給者台帳審査会依頼年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳審査会依頼年月日(FlexibleDate 受給者台帳審査会依頼年月日) {
        requireNonNull(受給者台帳審査会依頼年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳審査会依頼年月日"));
        this.受給者台帳Entity.setShinsakaiIraiYMD(受給者台帳審査会依頼年月日);
        return this;
    }

    /**
     * 受給者台帳要介護認定状態区分コードを設定します。
     *
     * @param 受給者台帳要介護認定状態区分コード 受給者台帳要介護認定状態区分コード
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳要介護認定状態区分コード(Code 受給者台帳要介護認定状態区分コード) {
        requireNonNull(受給者台帳要介護認定状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳要介護認定状態区分コード"));
        this.受給者台帳Entity.setYokaigoJotaiKubunCode(受給者台帳要介護認定状態区分コード);
        return this;
    }

    /**
     * 受給者台帳認定有効期間開始年月日を設定します。
     *
     * @param 受給者台帳認定有効期間開始年月日 受給者台帳認定有効期間開始年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳認定有効期間開始年月日(FlexibleDate 受給者台帳認定有効期間開始年月日) {
        requireNonNull(受給者台帳認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳認定有効期間開始年月日"));
        this.受給者台帳Entity.setNinteiYukoKikanKaishiYMD(受給者台帳認定有効期間開始年月日);
        return this;
    }

    /**
     * 受給者台帳認定有効期間終了年月日を設定します。
     *
     * @param 受給者台帳認定有効期間終了年月日 受給者台帳認定有効期間終了年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳認定有効期間終了年月日(FlexibleDate 受給者台帳認定有効期間終了年月日) {
        requireNonNull(受給者台帳認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳認定有効期間終了年月日"));
        this.受給者台帳Entity.setNinteiYukoKikanShuryoYMD(受給者台帳認定有効期間終了年月日);
        return this;
    }

    /**
     * 受給者台帳認定年月日を設定します。
     *
     * @param 受給者台帳認定年月日 受給者台帳認定年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳認定年月日(FlexibleDate 受給者台帳認定年月日) {
        requireNonNull(受給者台帳認定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳認定年月日"));
        this.受給者台帳Entity.setNinteiYMD(受給者台帳認定年月日);
        return this;
    }

    /**
     * 受給者台帳みなし要介護区分コードを設定します。
     *
     * @param 受給者台帳みなし要介護区分コード 受給者台帳みなし要介護区分コード
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳みなし要介護区分コード(Boolean 受給者台帳みなし要介護区分コード) {
        // TOOD. みなし要介護区分コード(minashiCode)が受給者台帳Entityにありません。
//        this.受給者台帳Entity.set(受給者台帳みなし要介護区分コード);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類01を設定します。
     *
     * @param 受給者台帳指定サービス種類01 受給者台帳指定サービス種類01
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類01(ServiceShuruiCode 受給者台帳指定サービス種類01) {
        requireNonNull(受給者台帳指定サービス種類01, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類01"));
        this.受給者台帳Entity.setShiteiServiceShurui01(受給者台帳指定サービス種類01);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類02を設定します。
     *
     * @param 受給者台帳指定サービス種類02 受給者台帳指定サービス種類02
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類02(ServiceShuruiCode 受給者台帳指定サービス種類02) {
        requireNonNull(受給者台帳指定サービス種類02, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類02"));
        this.受給者台帳Entity.setShiteiServiceShurui02(受給者台帳指定サービス種類02);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類03を設定します。
     *
     * @param 受給者台帳指定サービス種類03 受給者台帳指定サービス種類03
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類03(ServiceShuruiCode 受給者台帳指定サービス種類03) {
        requireNonNull(受給者台帳指定サービス種類03, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類03"));
        this.受給者台帳Entity.setShiteiServiceShurui03(受給者台帳指定サービス種類03);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類04を設定します。
     *
     * @param 受給者台帳指定サービス種類04 受給者台帳指定サービス種類04
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類04(ServiceShuruiCode 受給者台帳指定サービス種類04) {
        requireNonNull(受給者台帳指定サービス種類04, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類04"));
        this.受給者台帳Entity.setShiteiServiceShurui04(受給者台帳指定サービス種類04);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類05を設定します。
     *
     * @param 受給者台帳指定サービス種類05 受給者台帳指定サービス種類05
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類05(ServiceShuruiCode 受給者台帳指定サービス種類05) {
        requireNonNull(受給者台帳指定サービス種類05, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類05"));
        this.受給者台帳Entity.setShiteiServiceShurui05(受給者台帳指定サービス種類05);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類06を設定します。
     *
     * @param 受給者台帳指定サービス種類06 受給者台帳指定サービス種類06
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類06(ServiceShuruiCode 受給者台帳指定サービス種類06) {
        requireNonNull(受給者台帳指定サービス種類06, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類06"));
        this.受給者台帳Entity.setShiteiServiceShurui06(受給者台帳指定サービス種類06);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類07を設定します。
     *
     * @param 受給者台帳指定サービス種類07 受給者台帳指定サービス種類07
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類07(ServiceShuruiCode 受給者台帳指定サービス種類07) {
        requireNonNull(受給者台帳指定サービス種類07, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類07"));
        this.受給者台帳Entity.setShiteiServiceShurui07(受給者台帳指定サービス種類07);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類08を設定します。
     *
     * @param 受給者台帳指定サービス種類08 受給者台帳指定サービス種類08
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類08(ServiceShuruiCode 受給者台帳指定サービス種類08) {
        requireNonNull(受給者台帳指定サービス種類08, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類08"));
        this.受給者台帳Entity.setShiteiServiceShurui08(受給者台帳指定サービス種類08);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類09を設定します。
     *
     * @param 受給者台帳指定サービス種類09 受給者台帳指定サービス種類09
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類09(ServiceShuruiCode 受給者台帳指定サービス種類09) {
        requireNonNull(受給者台帳指定サービス種類09, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類09"));
        this.受給者台帳Entity.setShiteiServiceShurui09(受給者台帳指定サービス種類09);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類10を設定します。
     *
     * @param 受給者台帳指定サービス種類10 受給者台帳指定サービス種類10
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類10(ServiceShuruiCode 受給者台帳指定サービス種類10) {
        requireNonNull(受給者台帳指定サービス種類10, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類10"));
        this.受給者台帳Entity.setShiteiServiceShurui10(受給者台帳指定サービス種類10);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類11を設定します。
     *
     * @param 受給者台帳指定サービス種類11 受給者台帳指定サービス種類11
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類11(ServiceShuruiCode 受給者台帳指定サービス種類11) {
        requireNonNull(受給者台帳指定サービス種類11, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類11"));
        this.受給者台帳Entity.setShiteiServiceShurui11(受給者台帳指定サービス種類11);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類12を設定します。
     *
     * @param 受給者台帳指定サービス種類12 受給者台帳指定サービス種類12
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類12(ServiceShuruiCode 受給者台帳指定サービス種類12) {
        requireNonNull(受給者台帳指定サービス種類12, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類12"));
        this.受給者台帳Entity.setShiteiServiceShurui12(受給者台帳指定サービス種類12);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類13を設定します。
     *
     * @param 受給者台帳指定サービス種類13 受給者台帳指定サービス種類13
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類13(ServiceShuruiCode 受給者台帳指定サービス種類13) {
        requireNonNull(受給者台帳指定サービス種類13, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類13"));
        this.受給者台帳Entity.setShiteiServiceShurui13(受給者台帳指定サービス種類13);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類14を設定します。
     *
     * @param 受給者台帳指定サービス種類14 受給者台帳指定サービス種類14
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類14(ServiceShuruiCode 受給者台帳指定サービス種類14) {
        requireNonNull(受給者台帳指定サービス種類14, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類14"));
        this.受給者台帳Entity.setShiteiServiceShurui14(受給者台帳指定サービス種類14);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類15を設定します。
     *
     * @param 受給者台帳指定サービス種類15 受給者台帳指定サービス種類15
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類15(ServiceShuruiCode 受給者台帳指定サービス種類15) {
        requireNonNull(受給者台帳指定サービス種類15, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類15"));
        this.受給者台帳Entity.setShiteiServiceShurui15(受給者台帳指定サービス種類15);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類16を設定します。
     *
     * @param 受給者台帳指定サービス種類16 受給者台帳指定サービス種類16
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類16(ServiceShuruiCode 受給者台帳指定サービス種類16) {
        requireNonNull(受給者台帳指定サービス種類16, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類16"));
        this.受給者台帳Entity.setShiteiServiceShurui16(受給者台帳指定サービス種類16);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類17を設定します。
     *
     * @param 受給者台帳指定サービス種類17 受給者台帳指定サービス種類17
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類17(ServiceShuruiCode 受給者台帳指定サービス種類17) {
        requireNonNull(受給者台帳指定サービス種類17, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類17"));
        this.受給者台帳Entity.setShiteiServiceShurui17(受給者台帳指定サービス種類17);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類18を設定します。
     *
     * @param 受給者台帳指定サービス種類18 受給者台帳指定サービス種類18
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類18(ServiceShuruiCode 受給者台帳指定サービス種類18) {
        requireNonNull(受給者台帳指定サービス種類18, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類18"));
        this.受給者台帳Entity.setShiteiServiceShurui18(受給者台帳指定サービス種類18);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類19を設定します。
     *
     * @param 受給者台帳指定サービス種類19 受給者台帳指定サービス種類19
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類19(ServiceShuruiCode 受給者台帳指定サービス種類19) {
        requireNonNull(受給者台帳指定サービス種類19, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類19"));
        this.受給者台帳Entity.setShiteiServiceShurui19(受給者台帳指定サービス種類19);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類20を設定します。
     *
     * @param 受給者台帳指定サービス種類20 受給者台帳指定サービス種類20
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類20(ServiceShuruiCode 受給者台帳指定サービス種類20) {
        requireNonNull(受給者台帳指定サービス種類20, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類20"));
        this.受給者台帳Entity.setShiteiServiceShurui20(受給者台帳指定サービス種類20);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類21を設定します。
     *
     * @param 受給者台帳指定サービス種類21 受給者台帳指定サービス種類21
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類21(ServiceShuruiCode 受給者台帳指定サービス種類21) {
        requireNonNull(受給者台帳指定サービス種類21, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類21"));
        this.受給者台帳Entity.setShiteiServiceShurui21(受給者台帳指定サービス種類21);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類22を設定します。
     *
     * @param 受給者台帳指定サービス種類22 受給者台帳指定サービス種類22
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類22(ServiceShuruiCode 受給者台帳指定サービス種類22) {
        requireNonNull(受給者台帳指定サービス種類22, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類22"));
        this.受給者台帳Entity.setShiteiServiceShurui22(受給者台帳指定サービス種類22);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類23を設定します。
     *
     * @param 受給者台帳指定サービス種類23 受給者台帳指定サービス種類23
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類23(ServiceShuruiCode 受給者台帳指定サービス種類23) {
        requireNonNull(受給者台帳指定サービス種類23, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類23"));
        this.受給者台帳Entity.setShiteiServiceShurui23(受給者台帳指定サービス種類23);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類24を設定します。
     *
     * @param 受給者台帳指定サービス種類24 受給者台帳指定サービス種類24
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類24(ServiceShuruiCode 受給者台帳指定サービス種類24) {
        requireNonNull(受給者台帳指定サービス種類24, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類24"));
        this.受給者台帳Entity.setShiteiServiceShurui24(受給者台帳指定サービス種類24);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類25を設定します。
     *
     * @param 受給者台帳指定サービス種類25 受給者台帳指定サービス種類25
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類25(ServiceShuruiCode 受給者台帳指定サービス種類25) {
        requireNonNull(受給者台帳指定サービス種類25, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類25"));
        this.受給者台帳Entity.setShiteiServiceShurui25(受給者台帳指定サービス種類25);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類26を設定します。
     *
     * @param 受給者台帳指定サービス種類26 受給者台帳指定サービス種類26
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類26(ServiceShuruiCode 受給者台帳指定サービス種類26) {
        requireNonNull(受給者台帳指定サービス種類26, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類26"));
        this.受給者台帳Entity.setShiteiServiceShurui26(受給者台帳指定サービス種類26);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類27を設定します。
     *
     * @param 受給者台帳指定サービス種類27 受給者台帳指定サービス種類27
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類27(ServiceShuruiCode 受給者台帳指定サービス種類27) {
        requireNonNull(受給者台帳指定サービス種類27, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類27"));
        this.受給者台帳Entity.setShiteiServiceShurui27(受給者台帳指定サービス種類27);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類28を設定します。
     *
     * @param 受給者台帳指定サービス種類28 受給者台帳指定サービス種類28
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類28(ServiceShuruiCode 受給者台帳指定サービス種類28) {
        requireNonNull(受給者台帳指定サービス種類28, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類28"));
        this.受給者台帳Entity.setShiteiServiceShurui28(受給者台帳指定サービス種類28);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類29を設定します。
     *
     * @param 受給者台帳指定サービス種類29 受給者台帳指定サービス種類29
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類29(ServiceShuruiCode 受給者台帳指定サービス種類29) {
        requireNonNull(受給者台帳指定サービス種類29, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類29"));
        this.受給者台帳Entity.setShiteiServiceShurui29(受給者台帳指定サービス種類29);
        return this;
    }

    /**
     * 受給者台帳指定サービス種類30を設定します。
     *
     * @param 受給者台帳指定サービス種類30 受給者台帳指定サービス種類30
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳指定サービス種類30(ServiceShuruiCode 受給者台帳指定サービス種類30) {
        requireNonNull(受給者台帳指定サービス種類30, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳指定サービス種類30"));
        this.受給者台帳Entity.setShiteiServiceShurui30(受給者台帳指定サービス種類30);
        return this;
    }

    /**
     * 受給者台帳直近異動年月日を設定します。
     *
     * @param 受給者台帳直近異動年月日 受給者台帳直近異動年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳直近異動年月日(FlexibleDate 受給者台帳直近異動年月日) {
        requireNonNull(受給者台帳直近異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳直近異動年月日"));
        this.受給者台帳Entity.setChokkinIdoYMD(受給者台帳直近異動年月日);
        return this;
    }

    /**
     * 受給者台帳直近異動事由コードを設定します。
     *
     * @param 受給者台帳直近異動事由コード 受給者台帳直近異動事由コード
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳直近異動事由コード(Code 受給者台帳直近異動事由コード) {
        requireNonNull(受給者台帳直近異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳直近異動事由コード"));
        this.受給者台帳Entity.setChokkinIdoJiyuCode(受給者台帳直近異動事由コード);
        return this;
    }

    /**
     * 受給者台帳有効無効区分を設定します。
     *
     * @param 受給者台帳有効無効区分 受給者台帳有効無効区分
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳有効無効区分(Code 受給者台帳有効無効区分) {
        requireNonNull(受給者台帳有効無効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳有効無効区分"));
        this.受給者台帳Entity.setYukoMukoKubun(受給者台帳有効無効区分);
        return this;
    }

    /**
     * 受給者台帳データ区分を設定します。
     *
     * @param 受給者台帳データ区分 受給者台帳データ区分
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳データ区分(Code 受給者台帳データ区分) {
        requireNonNull(受給者台帳データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳データ区分"));
        this.受給者台帳Entity.setDataKubun(受給者台帳データ区分);
        return this;
    }

    /**
     * 受給者台帳同一連番を設定します。
     *
     * @param 受給者台帳同一連番 受給者台帳同一連番
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳同一連番(RString 受給者台帳同一連番) {
        requireNonNull(受給者台帳同一連番, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳同一連番"));
        this.受給者台帳Entity.setRemban(受給者台帳同一連番);
        return this;
    }

    /**
     * 受給者台帳異動理由を設定します。
     *
     * @param 受給者台帳異動理由 受給者台帳異動理由
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳異動理由(RString 受給者台帳異動理由) {
        requireNonNull(受給者台帳異動理由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳異動理由"));
        this.受給者台帳Entity.setIdoRiyu(受給者台帳異動理由);
        return this;
    }

    /**
     * 受給者台帳旧措置者フラグを設定します。
     *
     * @param 受給者台帳旧措置者フラグ 受給者台帳旧措置者フラグ
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set受給者台帳旧措置者フラグ(boolean 受給者台帳旧措置者フラグ) {
        requireNonNull(受給者台帳旧措置者フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳旧措置者フラグ"));
        this.受給者台帳Entity.setKyuSochishaFlag(受給者台帳旧措置者フラグ);
        return this;
    }

    /**
     * 認定結果通知書発行年月日を設定します。
     *
     * @param 認定結果通知書発行年月日 認定結果通知書発行年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set認定結果通知書発行年月日(FlexibleDate 認定結果通知書発行年月日) {
        requireNonNull(認定結果通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定結果通知書発行年月日"));
        this.受給者台帳Entity.setNinteiKekkaTsuchishoHakkoYMD(認定結果通知書発行年月日);
        return this;
    }

    /**
     * 区分変更通知書発行年月日を設定します。
     *
     * @param 区分変更通知書発行年月日 区分変更通知書発行年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set区分変更通知書発行年月日(FlexibleDate 区分変更通知書発行年月日) {
        requireNonNull(区分変更通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("区分変更通知書発行年月日"));
        this.受給者台帳Entity.setKubunHenkoTsuchishoHakkoYMD(区分変更通知書発行年月日);
        return this;
    }

    /**
     * サービス変更通知書発行年月日を設定します。
     *
     * @param サービス変更通知書発行年月日 サービス変更通知書発行年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder setサービス変更通知書発行年月日(FlexibleDate サービス変更通知書発行年月日) {
        requireNonNull(サービス変更通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス変更通知書発行年月日"));
        this.受給者台帳Entity.setServiceHenkoTsuchishoHakkoYMD(サービス変更通知書発行年月日);
        return this;
    }

    /**
     * 認定却下通知書発行年月日を設定します。
     *
     * @param 認定却下通知書発行年月日 認定却下通知書発行年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set認定却下通知書発行年月日(FlexibleDate 認定却下通知書発行年月日) {
        requireNonNull(認定却下通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定却下通知書発行年月日"));
        this.受給者台帳Entity.setNinteiKyakkaTsuchishoHakkoYMD(認定却下通知書発行年月日);
        return this;
    }

    /**
     * 要介護認定申請情報市町村連絡事項を設定します。
     *
     * @param 要介護認定申請情報市町村連絡事項 要介護認定申請情報市町村連絡事項
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定申請情報受給市町村連絡事項(RString 要介護認定申請情報市町村連絡事項) {
        requireNonNull(要介護認定申請情報市町村連絡事項, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報市町村連絡事項"));
        this.要介護認定申請情報受給Entity.setShichosonRenrakuJiko(要介護認定申請情報市町村連絡事項);
        return this;
    }

    /**
     * 要介護認定申請情報却下年月日を設定します。
     *
     * @param 要介護認定申請情報却下年月日 要介護認定申請情報却下年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定申請情報受給却下年月日(FlexibleDate 要介護認定申請情報却下年月日) {
        requireNonNull(要介護認定申請情報却下年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報却下年月日"));
        this.要介護認定申請情報受給Entity.setKyakkaYMD(要介護認定申請情報却下年月日);
        return this;
    }

    /**
     * 要介護認定申請情報却下理由を設定します。
     *
     * @param 要介護認定申請情報却下理由 要介護認定申請情報却下理由
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定申請情報受給却下理由(RString 要介護認定申請情報却下理由) {
        requireNonNull(要介護認定申請情報却下理由, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報却下理由"));
        this.要介護認定申請情報受給Entity.setKyakkaRiyu(要介護認定申請情報却下理由);
        return this;
    }

    /**
     * 要介護認定申請情報審査継続区分を設定します。
     *
     * @param 要介護認定申請情報審査継続区分 要介護認定申請情報審査継続区分
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定申請情報受給審査継続区分(boolean 要介護認定申請情報審査継続区分) {
        requireNonNull(要介護認定申請情報審査継続区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報審査継続区分"));
        this.要介護認定申請情報受給Entity.setShinsaKeizokuFlag(要介護認定申請情報審査継続区分);
        return this;
    }

    /**
     * 要介護認定申請情報受給取下区分コードを設定します。
     *
     * @param 要介護認定申請情報受給取下区分コード 要介護認定申請情報受給取下区分コード
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定申請情報受給取下区分コード(Code 要介護認定申請情報受給取下区分コード) {
        requireNonNull(要介護認定申請情報受給取下区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報受給取下区分コード"));
        this.要介護認定申請情報受給Entity.setTorisageKubunCode(要介護認定申請情報受給取下区分コード);
        return this;
    }

    /**
     * 要介護認定申請情報受給取下年月日を設定します。
     *
     * @param 要介護認定申請情報受給取下年月日 要介護認定申請情報受給取下年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定申請情報受給取下年月日(FlexibleDate 要介護認定申請情報受給取下年月日) {
        requireNonNull(要介護認定申請情報受給取下年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報受給取下年月日"));
        this.要介護認定申請情報受給Entity.setTorisageYMD(要介護認定申請情報受給取下年月日);
        return this;
    }

    /**
     * 要介護認定申請情報受給取下理由を設定します。
     *
     * @param 要介護認定申請情報受給取下理由 要介護認定申請情報受給取下理由
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定申請情報受給取下理由(RString 要介護認定申請情報受給取下理由) {
        requireNonNull(要介護認定申請情報受給取下理由, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報受給取下理由"));
        this.要介護認定申請情報受給Entity.setTorisageRiyu(要介護認定申請情報受給取下理由);
        return this;
    }

    /**
     * 要介護認定結果情報申請書管理番号を設定します。
     *
     * @param 要介護認定結果情報申請書管理番号 要介護認定結果情報申請書管理番号
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定結果情報申請書管理番号(ShinseishoKanriNo 要介護認定結果情報申請書管理番号) {
        requireNonNull(要介護認定結果情報申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報申請書管理番号"));
        this.要介護認定結果情報Entity.setShinseishoKanriNo(要介護認定結果情報申請書管理番号);
        return this;
    }

    /**
     * 要介護認定結果情報二次判定年月日を設定します。
     *
     * @param 要介護認定結果情報二次判定年月日 要介護認定結果情報二次判定年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定結果情報二次判定年月日(FlexibleDate 要介護認定結果情報二次判定年月日) {
        requireNonNull(要介護認定結果情報二次判定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報二次判定年月日"));
        this.要介護認定結果情報Entity.setNijiHanteiYMD(要介護認定結果情報二次判定年月日);
        return this;
    }

    /**
     * 要介護認定結果情報二次判定要介護状態区分コードを設定します。
     *
     * @param 要介護認定結果情報二次判定要介護状態区分コード 要介護認定結果情報二次判定要介護状態区分コード
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定結果情報二次判定要介護状態区分コード(Code 要介護認定結果情報二次判定要介護状態区分コード) {
        requireNonNull(要介護認定結果情報二次判定要介護状態区分コード,
                UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報二次判定要介護状態区分コード"));
        this.要介護認定結果情報Entity.setNijiHanteiYokaigoJotaiKubunCode(要介護認定結果情報二次判定要介護状態区分コード);
        return this;
    }

    /**
     * 要介護認定結果情報二次判定認定有効期間を設定します。
     *
     * @param 要介護認定結果情報二次判定認定有効期間 要介護認定結果情報二次判定認定有効期間
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定結果情報二次判定認定有効期間(Integer 要介護認定結果情報二次判定認定有効期間) {
        requireNonNull(要介護認定結果情報二次判定認定有効期間,
                UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報二次判定認定有効期間"));
        this.要介護認定結果情報Entity.setNijiHanteiNinteiYukoKikan(要介護認定結果情報二次判定認定有効期間);
        return this;
    }

    /**
     * 要介護認定結果情報二次判定認定有効開始年月日を設定します。
     *
     * @param 要介護認定結果情報二次判定認定有効開始年月日 要介護認定結果情報二次判定認定有効開始年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定結果情報二次判定認定有効開始年月日(FlexibleDate 要介護認定結果情報二次判定認定有効開始年月日) {
        requireNonNull(要介護認定結果情報二次判定認定有効開始年月日,
                UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報二次判定認定有効開始年月日"));
        this.要介護認定結果情報Entity.setNijiHanteiNinteiYukoKaishiYMD(要介護認定結果情報二次判定認定有効開始年月日);
        return this;
    }

    /**
     * 要介護認定結果情報二次判定認定有効終了年月日を設定します。
     *
     * @param 要介護認定結果情報二次判定認定有効終了年月日 要介護認定結果情報二次判定認定有効終了年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定結果情報二次判定認定有効終了年月日(FlexibleDate 要介護認定結果情報二次判定認定有効終了年月日) {
        requireNonNull(要介護認定結果情報二次判定認定有効終了年月日,
                UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報二次判定認定有効終了年月日"));
        this.要介護認定結果情報Entity.setNijiHanteiNinteiYukoShuryoYMD(要介護認定結果情報二次判定認定有効終了年月日);
        return this;
    }

    /**
     * 要介護認定結果情報介護認定審査会資料作成年月日を設定します。
     *
     * @param 要介護認定結果情報介護認定審査会資料作成年月日 要介護認定結果情報介護認定審査会資料作成年月日
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定結果情報介護認定審査会資料作成年月日(FlexibleDate 要介護認定結果情報介護認定審査会資料作成年月日) {
        requireNonNull(要介護認定結果情報介護認定審査会資料作成年月日,
                UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報介護認定審査会資料作成年月日"));
        this.要介護認定結果情報Entity.setShinsakaiShiryoSakuseiYMD(要介護認定結果情報介護認定審査会資料作成年月日);
        return this;
    }

    /**
     * 要介護認定結果情報介護認定審査会意見を設定します。
     *
     * @param 要介護認定結果情報介護認定審査会意見 要介護認定結果情報介護認定審査会意見
     * @return {@link YokaigoNinteiJohoBuilder}
     */
    public YokaigoNinteiTsutishoBuilder set要介護認定結果情報介護認定審査会意見(RString 要介護認定結果情報介護認定審査会意見) {
        requireNonNull(要介護認定結果情報介護認定審査会意見,
                UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報介護認定審査会意見"));
        this.要介護認定結果情報Entity.setShinsakaiIken(要介護認定結果情報介護認定審査会意見);
        return this;
    }

    /**
     * {@link YokaigoNinteiTsutisho}のインスタンスを生成します。
     *
     * @return {@link YokaigoNinteiTsutisho}のインスタンス
     */
    public YokaigoNinteiTsutisho build() {
        return new YokaigoNinteiTsutisho(
                要介護認定申請情報受給Entity,
                受給者台帳Entity,
                要介護認定結果情報Entity);
    }
}
