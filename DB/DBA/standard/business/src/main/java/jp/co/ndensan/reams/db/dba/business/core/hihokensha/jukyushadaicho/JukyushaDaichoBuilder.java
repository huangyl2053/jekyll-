/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JukyushaDaicho}の編集を行うビルダークラスです。
 */
public class JukyushaDaichoBuilder {

    private final DbT4001JukyushaDaichoEntity entity;
    private final JukyushaDaichoIdentifier id;

    /**
     * {@link DbT4001JukyushaDaichoEntity}より{@link JukyushaDaicho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4001JukyushaDaichoEntity}
     * @param id {@link JukyushaDaichoIdentifier}
     *
     */
    JukyushaDaichoBuilder(
            DbT4001JukyushaDaichoEntity entity,
            JukyushaDaichoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 申請状況区分を設定します。
     *
     * @param 申請状況区分 申請状況区分
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set申請状況区分(RString 申請状況区分) {
        requireNonNull(申請状況区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請状況区分"));
        entity.setShinseiJokyoKubun(申請状況区分);
        return this;
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set支所コード(RString 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
        return this;
    }

    /**
     * 直近フラグを設定します。
     *
     * @param 直近フラグ 直近フラグ
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set直近フラグ(boolean 直近フラグ) {
        requireNonNull(直近フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("直近フラグ"));
        entity.setChokkinFlag(直近フラグ);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set申請理由(RString 申請理由) {
        requireNonNull(申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由"));
        entity.setShinseiRiyu(申請理由);
        return this;
    }

    /**
     * （届出者）申請者関係コードを設定します。
     *
     * @param 届出者_申請者関係コード 届出者_申請者関係コード
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set届出者_申請者関係コード(Code 届出者_申請者関係コード) {
        requireNonNull(届出者_申請者関係コード, UrSystemErrorMessages.値がnull.getReplacedMessage("（届出者）申請者関係コード"));
        entity.setShinseishaKankeiCode(届出者_申請者関係コード);
        return this;
    }

    /**
     * （届出者）本人との関係を設定します。
     *
     * @param 届出者_本人との関係 届出者_本人との関係
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set届出者_本人との関係(RString 届出者_本人との関係) {
        requireNonNull(届出者_本人との関係, UrSystemErrorMessages.値がnull.getReplacedMessage("（届出者）本人との関係"));
        entity.setHomninKankei(届出者_本人との関係);
        return this;
    }

    /**
     * 受給申請年月日を設定します。
     *
     * @param 受給申請年月日 受給申請年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set受給申請年月日(FlexibleDate 受給申請年月日) {
        requireNonNull(受給申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請年月日"));
        entity.setJukyuShinseiYMD(受給申請年月日);
        return this;
    }

    /**
     * ２号特定疾病コードを設定します。
     *
     * @param 二号特定疾病コード 二号特定疾病コード
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set２号特定疾病コード(Code 二号特定疾病コード) {
        requireNonNull(二号特定疾病コード, UrSystemErrorMessages.値がnull.getReplacedMessage("２号特定疾病コード"));
        entity.setNigoTokuteiShippeiCode(二号特定疾病コード);
        return this;
    }

    /**
     * 審査会依頼年月日を設定します。
     *
     * @param 審査会依頼年月日 審査会依頼年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set審査会依頼年月日(FlexibleDate 審査会依頼年月日) {
        requireNonNull(審査会依頼年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会依頼年月日"));
        entity.setShinsakaiIraiYMD(審査会依頼年月日);
        return this;
    }

    /**
     * 要介護認定状態区分コードを設定します。
     *
     * @param 要介護認定状態区分コード 要介護認定状態区分コード
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set要介護認定状態区分コード(Code 要介護認定状態区分コード) {
        requireNonNull(要介護認定状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定状態区分コード"));
        entity.setYokaigoJotaiKubunCode(要介護認定状態区分コード);
        return this;
    }

    /**
     * 認定有効期間開始年月日を設定します。
     *
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set認定有効期間開始年月日(FlexibleDate 認定有効期間開始年月日) {
        requireNonNull(認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間開始年月日"));
        entity.setNinteiYukoKikanKaishiYMD(認定有効期間開始年月日);
        return this;
    }

    /**
     * 認定有効期間終了年月日を設定します。
     *
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set認定有効期間終了年月日(FlexibleDate 認定有効期間終了年月日) {
        requireNonNull(認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間終了年月日"));
        entity.setNinteiYukoKikanShuryoYMD(認定有効期間終了年月日);
        return this;
    }

    /**
     * 認定年月日を設定します。
     *
     * @param 認定年月日 認定年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set認定年月日(FlexibleDate 認定年月日) {
        requireNonNull(認定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定年月日"));
        entity.setNinteiYMD(認定年月日);
        return this;
    }

    /**
     * みなし要介護区分コードを設定します。
     *
     * @param みなし要介護区分コード みなし要介護区分コード
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder setみなし要介護区分コード(Code みなし要介護区分コード) {
        requireNonNull(みなし要介護区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("みなし要介護区分コード"));
        entity.setMinashiCode(みなし要介護区分コード);
        return this;
    }

    /**
     * 指定サービス種類01を設定します。
     *
     * @param 指定サービス種類01 指定サービス種類01
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類01(ServiceShuruiCode 指定サービス種類01) {
        requireNonNull(指定サービス種類01, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類01"));
        entity.setShiteiServiceShurui01(指定サービス種類01);
        return this;
    }

    /**
     * 指定サービス種類02を設定します。
     *
     * @param 指定サービス種類02 指定サービス種類02
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類02(ServiceShuruiCode 指定サービス種類02) {
        requireNonNull(指定サービス種類02, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類02"));
        entity.setShiteiServiceShurui02(指定サービス種類02);
        return this;
    }

    /**
     * 指定サービス種類03を設定します。
     *
     * @param 指定サービス種類03 指定サービス種類03
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類03(ServiceShuruiCode 指定サービス種類03) {
        requireNonNull(指定サービス種類03, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類03"));
        entity.setShiteiServiceShurui03(指定サービス種類03);
        return this;
    }

    /**
     * 指定サービス種類04を設定します。
     *
     * @param 指定サービス種類04 指定サービス種類04
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類04(ServiceShuruiCode 指定サービス種類04) {
        requireNonNull(指定サービス種類04, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類04"));
        entity.setShiteiServiceShurui04(指定サービス種類04);
        return this;
    }

    /**
     * 指定サービス種類05を設定します。
     *
     * @param 指定サービス種類05 指定サービス種類05
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類05(ServiceShuruiCode 指定サービス種類05) {
        requireNonNull(指定サービス種類05, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類05"));
        entity.setShiteiServiceShurui05(指定サービス種類05);
        return this;
    }

    /**
     * 指定サービス種類06を設定します。
     *
     * @param 指定サービス種類06 指定サービス種類06
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類06(ServiceShuruiCode 指定サービス種類06) {
        requireNonNull(指定サービス種類06, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類06"));
        entity.setShiteiServiceShurui06(指定サービス種類06);
        return this;
    }

    /**
     * 指定サービス種類07を設定します。
     *
     * @param 指定サービス種類07 指定サービス種類07
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類07(ServiceShuruiCode 指定サービス種類07) {
        requireNonNull(指定サービス種類07, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類07"));
        entity.setShiteiServiceShurui07(指定サービス種類07);
        return this;
    }

    /**
     * 指定サービス種類08を設定します。
     *
     * @param 指定サービス種類08 指定サービス種類08
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類08(ServiceShuruiCode 指定サービス種類08) {
        requireNonNull(指定サービス種類08, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類08"));
        entity.setShiteiServiceShurui08(指定サービス種類08);
        return this;
    }

    /**
     * 指定サービス種類09を設定します。
     *
     * @param 指定サービス種類09 指定サービス種類09
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類09(ServiceShuruiCode 指定サービス種類09) {
        requireNonNull(指定サービス種類09, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類09"));
        entity.setShiteiServiceShurui09(指定サービス種類09);
        return this;
    }

    /**
     * 指定サービス種類10を設定します。
     *
     * @param 指定サービス種類10 指定サービス種類10
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類10(ServiceShuruiCode 指定サービス種類10) {
        requireNonNull(指定サービス種類10, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類10"));
        entity.setShiteiServiceShurui10(指定サービス種類10);
        return this;
    }

    /**
     * 指定サービス種類11を設定します。
     *
     * @param 指定サービス種類11 指定サービス種類11
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類11(ServiceShuruiCode 指定サービス種類11) {
        requireNonNull(指定サービス種類11, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類11"));
        entity.setShiteiServiceShurui11(指定サービス種類11);
        return this;
    }

    /**
     * 指定サービス種類12を設定します。
     *
     * @param 指定サービス種類12 指定サービス種類12
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類12(ServiceShuruiCode 指定サービス種類12) {
        requireNonNull(指定サービス種類12, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類12"));
        entity.setShiteiServiceShurui12(指定サービス種類12);
        return this;
    }

    /**
     * 指定サービス種類13を設定します。
     *
     * @param 指定サービス種類13 指定サービス種類13
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類13(ServiceShuruiCode 指定サービス種類13) {
        requireNonNull(指定サービス種類13, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類13"));
        entity.setShiteiServiceShurui13(指定サービス種類13);
        return this;
    }

    /**
     * 指定サービス種類14を設定します。
     *
     * @param 指定サービス種類14 指定サービス種類14
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類14(ServiceShuruiCode 指定サービス種類14) {
        requireNonNull(指定サービス種類14, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類14"));
        entity.setShiteiServiceShurui14(指定サービス種類14);
        return this;
    }

    /**
     * 指定サービス種類15を設定します。
     *
     * @param 指定サービス種類15 指定サービス種類15
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類15(ServiceShuruiCode 指定サービス種類15) {
        requireNonNull(指定サービス種類15, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類15"));
        entity.setShiteiServiceShurui15(指定サービス種類15);
        return this;
    }

    /**
     * 指定サービス種類16を設定します。
     *
     * @param 指定サービス種類16 指定サービス種類16
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類16(ServiceShuruiCode 指定サービス種類16) {
        requireNonNull(指定サービス種類16, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類16"));
        entity.setShiteiServiceShurui16(指定サービス種類16);
        return this;
    }

    /**
     * 指定サービス種類17を設定します。
     *
     * @param 指定サービス種類17 指定サービス種類17
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類17(ServiceShuruiCode 指定サービス種類17) {
        requireNonNull(指定サービス種類17, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類17"));
        entity.setShiteiServiceShurui17(指定サービス種類17);
        return this;
    }

    /**
     * 指定サービス種類18を設定します。
     *
     * @param 指定サービス種類18 指定サービス種類18
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類18(ServiceShuruiCode 指定サービス種類18) {
        requireNonNull(指定サービス種類18, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類18"));
        entity.setShiteiServiceShurui18(指定サービス種類18);
        return this;
    }

    /**
     * 指定サービス種類19を設定します。
     *
     * @param 指定サービス種類19 指定サービス種類19
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類19(ServiceShuruiCode 指定サービス種類19) {
        requireNonNull(指定サービス種類19, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類19"));
        entity.setShiteiServiceShurui19(指定サービス種類19);
        return this;
    }

    /**
     * 指定サービス種類20を設定します。
     *
     * @param 指定サービス種類20 指定サービス種類20
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類20(ServiceShuruiCode 指定サービス種類20) {
        requireNonNull(指定サービス種類20, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類20"));
        entity.setShiteiServiceShurui20(指定サービス種類20);
        return this;
    }

    /**
     * 指定サービス種類21を設定します。
     *
     * @param 指定サービス種類21 指定サービス種類21
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類21(ServiceShuruiCode 指定サービス種類21) {
        requireNonNull(指定サービス種類21, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類21"));
        entity.setShiteiServiceShurui21(指定サービス種類21);
        return this;
    }

    /**
     * 指定サービス種類22を設定します。
     *
     * @param 指定サービス種類22 指定サービス種類22
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類22(ServiceShuruiCode 指定サービス種類22) {
        requireNonNull(指定サービス種類22, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類22"));
        entity.setShiteiServiceShurui22(指定サービス種類22);
        return this;
    }

    /**
     * 指定サービス種類23を設定します。
     *
     * @param 指定サービス種類23 指定サービス種類23
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類23(ServiceShuruiCode 指定サービス種類23) {
        requireNonNull(指定サービス種類23, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類23"));
        entity.setShiteiServiceShurui23(指定サービス種類23);
        return this;
    }

    /**
     * 指定サービス種類24を設定します。
     *
     * @param 指定サービス種類24 指定サービス種類24
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類24(ServiceShuruiCode 指定サービス種類24) {
        requireNonNull(指定サービス種類24, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類24"));
        entity.setShiteiServiceShurui24(指定サービス種類24);
        return this;
    }

    /**
     * 指定サービス種類25を設定します。
     *
     * @param 指定サービス種類25 指定サービス種類25
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類25(ServiceShuruiCode 指定サービス種類25) {
        requireNonNull(指定サービス種類25, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類25"));
        entity.setShiteiServiceShurui25(指定サービス種類25);
        return this;
    }

    /**
     * 指定サービス種類26を設定します。
     *
     * @param 指定サービス種類26 指定サービス種類26
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類26(ServiceShuruiCode 指定サービス種類26) {
        requireNonNull(指定サービス種類26, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類26"));
        entity.setShiteiServiceShurui26(指定サービス種類26);
        return this;
    }

    /**
     * 指定サービス種類27を設定します。
     *
     * @param 指定サービス種類27 指定サービス種類27
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類27(ServiceShuruiCode 指定サービス種類27) {
        requireNonNull(指定サービス種類27, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類27"));
        entity.setShiteiServiceShurui27(指定サービス種類27);
        return this;
    }

    /**
     * 指定サービス種類28を設定します。
     *
     * @param 指定サービス種類28 指定サービス種類28
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類28(ServiceShuruiCode 指定サービス種類28) {
        requireNonNull(指定サービス種類28, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類28"));
        entity.setShiteiServiceShurui28(指定サービス種類28);
        return this;
    }

    /**
     * 指定サービス種類29を設定します。
     *
     * @param 指定サービス種類29 指定サービス種類29
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類29(ServiceShuruiCode 指定サービス種類29) {
        requireNonNull(指定サービス種類29, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類29"));
        entity.setShiteiServiceShurui29(指定サービス種類29);
        return this;
    }

    /**
     * 指定サービス種類30を設定します。
     *
     * @param 指定サービス種類30 指定サービス種類30
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set指定サービス種類30(ServiceShuruiCode 指定サービス種類30) {
        requireNonNull(指定サービス種類30, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類30"));
        entity.setShiteiServiceShurui30(指定サービス種類30);
        return this;
    }

    /**
     * 喪失年月日を設定します。
     *
     * @param 喪失年月日 喪失年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set喪失年月日(FlexibleDate 喪失年月日) {
        requireNonNull(喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("喪失年月日"));
        entity.setSoshitsuYMD(喪失年月日);
        return this;
    }

    /**
     * 直近異動年月日を設定します。
     *
     * @param 直近異動年月日 直近異動年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set直近異動年月日(FlexibleDate 直近異動年月日) {
        requireNonNull(直近異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("直近異動年月日"));
        entity.setChokkinIdoYMD(直近異動年月日);
        return this;
    }

    /**
     * 直近異動事由コードを設定します。
     *
     * @param 直近異動事由コード 直近異動事由コード
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set直近異動事由コード(Code 直近異動事由コード) {
        requireNonNull(直近異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("直近異動事由コード"));
        entity.setChokkinIdoJiyuCode(直近異動事由コード);
        return this;
    }

    /**
     * 有効無効区分を設定します。
     *
     * @param 有効無効区分 有効無効区分
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set有効無効区分(Code 有効無効区分) {
        requireNonNull(有効無効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("有効無効区分"));
        entity.setYukoMukoKubun(有効無効区分);
        return this;
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder setデータ区分(Code データ区分) {
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        entity.setDataKubun(データ区分);
        return this;
    }

    /**
     * 同一連番を設定します。
     *
     * @param 同一連番 同一連番
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set同一連番(RString 同一連番) {
        requireNonNull(同一連番, UrSystemErrorMessages.値がnull.getReplacedMessage("同一連番"));
        entity.setRemban(同一連番);
        return this;
    }

    /**
     * 異動理由を設定します。
     *
     * @param 異動理由 異動理由
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set異動理由(RString 異動理由) {
        requireNonNull(異動理由, UrSystemErrorMessages.値がnull.getReplacedMessage("異動理由"));
        entity.setIdoRiyu(異動理由);
        return this;
    }

    /**
     * 申請書区分を設定します。
     *
     * @param 申請書区分 申請書区分
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set申請書区分(Code 申請書区分) {
        requireNonNull(申請書区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書区分"));
        entity.setShinseishoKubun(申請書区分);
        return this;
    }

    /**
     * 削除事由コードを設定します。
     *
     * @param 削除事由コード 削除事由コード
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set削除事由コード(Code 削除事由コード) {
        requireNonNull(削除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("削除事由コード"));
        entity.setSakujoJiyuCode(削除事由コード);
        return this;
    }

    /**
     * 要支援者認定申請区分を設定します。
     *
     * @param 要支援者認定申請区分 要支援者認定申請区分
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set要支援者認定申請区分(boolean 要支援者認定申請区分) {
        requireNonNull(要支援者認定申請区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要支援者認定申請区分"));
        entity.setYoshienshaNinteiShinseiFlag(要支援者認定申請区分);
        return this;
    }

    /**
     * 支給限度単位数を設定します。
     *
     * @param 支給限度単位数 支給限度単位数
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set支給限度単位数(Decimal 支給限度単位数) {
        requireNonNull(支給限度単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度単位数"));
        entity.setShikyuGendoTanisu(支給限度単位数);
        return this;
    }

    /**
     * 支給限度有効開始年月日を設定します。
     *
     * @param 支給限度有効開始年月日 支給限度有効開始年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set支給限度有効開始年月日(FlexibleDate 支給限度有効開始年月日) {
        requireNonNull(支給限度有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度有効開始年月日"));
        entity.setShikyuGendoKaishiYMD(支給限度有効開始年月日);
        return this;
    }

    /**
     * 支給限度有効終了年月日を設定します。
     *
     * @param 支給限度有効終了年月日 支給限度有効終了年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set支給限度有効終了年月日(FlexibleDate 支給限度有効終了年月日) {
        requireNonNull(支給限度有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度有効終了年月日"));
        entity.setShikyuGendoShuryoYMD(支給限度有効終了年月日);
        return this;
    }

    /**
     * 短期入所支給限度日数を設定します。
     *
     * @param 短期入所支給限度日数 短期入所支給限度日数
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set短期入所支給限度日数(int 短期入所支給限度日数) {
        requireNonNull(短期入所支給限度日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度日数"));
        entity.setTankiSikyuGendoNissu(短期入所支給限度日数);
        return this;
    }

    /**
     * 短期入所支給限度開始年月日を設定します。
     *
     * @param 短期入所支給限度開始年月日 短期入所支給限度開始年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set短期入所支給限度開始年月日(FlexibleDate 短期入所支給限度開始年月日) {
        requireNonNull(短期入所支給限度開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度開始年月日"));
        entity.setTankiShikyuGendoKaishiYMD(短期入所支給限度開始年月日);
        return this;
    }

    /**
     * 短期入所支給限度終了年月日を設定します。
     *
     * @param 短期入所支給限度終了年月日 短期入所支給限度終了年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set短期入所支給限度終了年月日(FlexibleDate 短期入所支給限度終了年月日) {
        requireNonNull(短期入所支給限度終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度終了年月日"));
        entity.setTankiShikyuGendoShuryoYMD(短期入所支給限度終了年月日);
        return this;
    }

    /**
     * 当初認定有効開始年月日を設定します。
     *
     * @param 当初認定有効開始年月日 当初認定有効開始年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set当初認定有効開始年月日(FlexibleDate 当初認定有効開始年月日) {
        requireNonNull(当初認定有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("当初認定有効開始年月日"));
        entity.setToshoNinteiYukoKaishiYMD(当初認定有効開始年月日);
        return this;
    }

    /**
     * 当初認定有効終了年月日を設定します。
     *
     * @param 当初認定有効終了年月日 当初認定有効終了年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set当初認定有効終了年月日(FlexibleDate 当初認定有効終了年月日) {
        requireNonNull(当初認定有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("当初認定有効終了年月日"));
        entity.setToshoNinteiYukoShuryoYMD(当初認定有効終了年月日);
        return this;
    }

    /**
     * 受給資格証明書発行年月日１を設定します。
     *
     * @param 受給資格証明書発行年月日１ 受給資格証明書発行年月日１
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set受給資格証明書発行年月日１(FlexibleDate 受給資格証明書発行年月日１) {
        requireNonNull(受給資格証明書発行年月日１, UrSystemErrorMessages.値がnull.getReplacedMessage("受給資格証明書発行年月日１"));
        entity.setJukyuShikakuShomeishoHakkoYMD1(受給資格証明書発行年月日１);
        return this;
    }

    /**
     * 受給資格証明書発行年月日２を設定します。
     *
     * @param 受給資格証明書発行年月日２ 受給資格証明書発行年月日２
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set受給資格証明書発行年月日２(FlexibleDate 受給資格証明書発行年月日２) {
        requireNonNull(受給資格証明書発行年月日２, UrSystemErrorMessages.値がnull.getReplacedMessage("受給資格証明書発行年月日２"));
        entity.setJukyuShikakuShomeishoHakkoYMD2(受給資格証明書発行年月日２);
        return this;
    }

    /**
     * 診断命令書発行年月日を設定します。
     *
     * @param 診断命令書発行年月日 診断命令書発行年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set診断命令書発行年月日(FlexibleDate 診断命令書発行年月日) {
        requireNonNull(診断命令書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("診断命令書発行年月日"));
        entity.setShindanMeireishoHakkoYMD(診断命令書発行年月日);
        return this;
    }

    /**
     * ２号申請受理通知書発行年月日を設定します。
     *
     * @param 二号申請受理通知書発行年月日 二号申請受理通知書発行年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set２号申請受理通知書発行年月日(FlexibleDate 二号申請受理通知書発行年月日) {
        requireNonNull(二号申請受理通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("２号申請受理通知書発行年月日"));
        entity.setNigoShinseiJuriTsuchishoHakkoYMD(二号申請受理通知書発行年月日);
        return this;
    }

    /**
     * 認定結果通知書発行年月日を設定します。
     *
     * @param 認定結果通知書発行年月日 認定結果通知書発行年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set認定結果通知書発行年月日(FlexibleDate 認定結果通知書発行年月日) {
        requireNonNull(認定結果通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定結果通知書発行年月日"));
        entity.setNinteiKekkaTsuchishoHakkoYMD(認定結果通知書発行年月日);
        return this;
    }

    /**
     * 区分変更通知書発行年月日を設定します。
     *
     * @param 区分変更通知書発行年月日 区分変更通知書発行年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set区分変更通知書発行年月日(FlexibleDate 区分変更通知書発行年月日) {
        requireNonNull(区分変更通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("区分変更通知書発行年月日"));
        entity.setKubunHenkoTsuchishoHakkoYMD(区分変更通知書発行年月日);
        return this;
    }

    /**
     * サービス変更通知書発行年月日を設定します。
     *
     * @param サービス変更通知書発行年月日 サービス変更通知書発行年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder setサービス変更通知書発行年月日(FlexibleDate サービス変更通知書発行年月日) {
        requireNonNull(サービス変更通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス変更通知書発行年月日"));
        entity.setServiceHenkoTsuchishoHakkoYMD(サービス変更通知書発行年月日);
        return this;
    }

    /**
     * 認定却下通知書発行年月日を設定します。
     *
     * @param 認定却下通知書発行年月日 認定却下通知書発行年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set認定却下通知書発行年月日(FlexibleDate 認定却下通知書発行年月日) {
        requireNonNull(認定却下通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定却下通知書発行年月日"));
        entity.setNinteiKyakkaTsuchishoHakkoYMD(認定却下通知書発行年月日);
        return this;
    }

    /**
     * 認定取消通知書発行年月日を設定します。
     *
     * @param 認定取消通知書発行年月日 認定取消通知書発行年月日
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set認定取消通知書発行年月日(FlexibleDate 認定取消通知書発行年月日) {
        requireNonNull(認定取消通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定取消通知書発行年月日"));
        entity.setNinteiTorikeshiTsuchishoHakkoYMD(認定取消通知書発行年月日);
        return this;
    }

    /**
     * 資格取得前申請フラグを設定します。
     *
     * @param 資格取得前申請フラグ 資格取得前申請フラグ
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set資格取得前申請フラグ(boolean 資格取得前申請フラグ) {
        requireNonNull(資格取得前申請フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得前申請フラグ"));
        entity.setShikakuShutokuMaeShinseiFlag(資格取得前申請フラグ);
        return this;
    }

    /**
     * 旧措置者フラグを設定します。
     *
     * @param 旧措置者フラグ 旧措置者フラグ
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set旧措置者フラグ(boolean 旧措置者フラグ) {
        requireNonNull(旧措置者フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("旧措置者フラグ"));
        entity.setKyuSochishaFlag(旧措置者フラグ);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link JukyushaDaichoBuilder}
     */
    public JukyushaDaichoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link JukyushaDaicho}のインスタンスを生成します。
     *
     * @return {@link JukyushaDaicho}のインスタンス
     */
    public JukyushaDaicho build() {
        return new JukyushaDaicho(entity, id);
    }
}
