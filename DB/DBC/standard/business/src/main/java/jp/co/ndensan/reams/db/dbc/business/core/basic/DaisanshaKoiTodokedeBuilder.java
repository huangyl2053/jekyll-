/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3084DaisanshaKoiTodokedeEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link DaisanshaKoiTodokede}の編集を行うビルダークラスです。
 */
public class DaisanshaKoiTodokedeBuilder {

    private final DbT3084DaisanshaKoiTodokedeEntity entity;
    private final DaisanshaKoiTodokedeIdentifier id;

    /**
     * {@link DbT3084DaisanshaKoiTodokedeEntity}より{@link DaisanshaKoiTodokede}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3084DaisanshaKoiTodokedeEntity}
     * @param id {@link DaisanshaKoiTodokedeIdentifier}
     *
     */
    DaisanshaKoiTodokedeBuilder(
            DbT3084DaisanshaKoiTodokedeEntity entity,
            DaisanshaKoiTodokedeIdentifier id
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
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 届出年月日を設定します。
     *
     * @param 届出年月日 届出年月日
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set届出年月日(FlexibleDate 届出年月日) {
        requireNonNull(届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("届出年月日"));
        entity.setTodokedeYMD(届出年月日);
        return this;
    }

    /**
     * 届出人郵便番号を設定します。
     *
     * @param 届出人郵便番号 届出人郵便番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set届出人郵便番号(YubinNo 届出人郵便番号) {
        requireNonNull(届出人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人郵便番号"));
        entity.setTodokedenin_YubinNo(届出人郵便番号);
        return this;
    }

    /**
     * 届出人住所を設定します。
     *
     * @param 届出人住所 届出人住所
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set届出人住所(RString 届出人住所) {
        requireNonNull(届出人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人住所"));
        entity.setTodokedenin_Jusho(届出人住所);
        return this;
    }

    /**
     * 届出人氏名カナを設定します。
     *
     * @param 届出人氏名カナ 届出人氏名カナ
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set届出人氏名カナ(AtenaKanaMeisho 届出人氏名カナ) {
        requireNonNull(届出人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人氏名カナ"));
        entity.setTodokedenin_ShimeiKana(届出人氏名カナ);
        return this;
    }

    /**
     * 届出人氏名を設定します。
     *
     * @param 届出人氏名 届出人氏名
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set届出人氏名(AtenaMeisho 届出人氏名) {
        requireNonNull(届出人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人氏名"));
        entity.setTodokedenin_Shimei(届出人氏名);
        return this;
    }

    /**
     * 届出人電話番号を設定します。
     *
     * @param 届出人電話番号 届出人電話番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set届出人電話番号(TelNo 届出人電話番号) {
        requireNonNull(届出人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人電話番号"));
        entity.setTodokedenin_TelNo(届出人電話番号);
        return this;
    }

    /**
     * 届出人との続柄を設定します。
     *
     * @param 届出人との続柄 届出人との続柄
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set届出人との続柄(RString 届出人との続柄) {
        requireNonNull(届出人との続柄, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人との続柄"));
        entity.setTodokedenin_Zokugara(届出人との続柄);
        return this;
    }

    /**
     * 要介護状態区分を設定します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set要介護状態区分(Code 要介護状態区分) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        entity.setYokaigoJotaiKubun(要介護状態区分);
        return this;
    }

    /**
     * 認定有効期間開始年月日を設定します。
     *
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set認定有効期間開始年月日(FlexibleDate 認定有効期間開始年月日) {
        requireNonNull(認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間開始年月日"));
        entity.setNinteiYukoKaishiYMD(認定有効期間開始年月日);
        return this;
    }

    /**
     * 認定有効期間終了年月日を設定します。
     *
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set認定有効期間終了年月日(FlexibleDate 認定有効期間終了年月日) {
        requireNonNull(認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間終了年月日"));
        entity.setNinteiYukoShuryoYMD(認定有効期間終了年月日);
        return this;
    }

    /**
     * 加害者郵便番号を設定します。
     *
     * @param 加害者郵便番号 加害者郵便番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set加害者郵便番号(YubinNo 加害者郵便番号) {
        requireNonNull(加害者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者郵便番号"));
        entity.setKagaisha_YubinNo(加害者郵便番号);
        return this;
    }

    /**
     * 加害者住所を設定します。
     *
     * @param 加害者住所 加害者住所
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set加害者住所(RString 加害者住所) {
        requireNonNull(加害者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者住所"));
        entity.setKagaisha_Jusho(加害者住所);
        return this;
    }

    /**
     * 加害者氏名カナを設定します。
     *
     * @param 加害者氏名カナ 加害者氏名カナ
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set加害者氏名カナ(AtenaKanaMeisho 加害者氏名カナ) {
        requireNonNull(加害者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者氏名カナ"));
        entity.setKagaisha_ShimeiKana(加害者氏名カナ);
        return this;
    }

    /**
     * 加害者氏名を設定します。
     *
     * @param 加害者氏名 加害者氏名
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set加害者氏名(AtenaMeisho 加害者氏名) {
        requireNonNull(加害者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者氏名"));
        entity.setKagansha_Shimei(加害者氏名);
        return this;
    }

    /**
     * 加害者生年月日を設定します。
     *
     * @param 加害者生年月日 加害者生年月日
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set加害者生年月日(FlexibleDate 加害者生年月日) {
        requireNonNull(加害者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者生年月日"));
        entity.setKagaisha_UmareYMD(加害者生年月日);
        return this;
    }

    /**
     * 加害者電話番号を設定します。
     *
     * @param 加害者電話番号 加害者電話番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set加害者電話番号(TelNo 加害者電話番号) {
        requireNonNull(加害者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者電話番号"));
        entity.setKagaisha_TelNo(加害者電話番号);
        return this;
    }

    /**
     * 加害者職業を設定します。
     *
     * @param 加害者職業 加害者職業
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set加害者職業(RString 加害者職業) {
        requireNonNull(加害者職業, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者職業"));
        entity.setKagaisha_Shokugyo(加害者職業);
        return this;
    }

    /**
     * 使用者郵便番号を設定します。
     *
     * @param 使用者郵便番号 使用者郵便番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set使用者郵便番号(YubinNo 使用者郵便番号) {
        requireNonNull(使用者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者郵便番号"));
        entity.setShiyosha_YubinNo(使用者郵便番号);
        return this;
    }

    /**
     * 使用者住所を設定します。
     *
     * @param 使用者住所 使用者住所
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set使用者住所(RString 使用者住所) {
        requireNonNull(使用者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者住所"));
        entity.setShiyosha_Jusho(使用者住所);
        return this;
    }

    /**
     * 使用者氏名カナを設定します。
     *
     * @param 使用者氏名カナ 使用者氏名カナ
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set使用者氏名カナ(AtenaKanaMeisho 使用者氏名カナ) {
        requireNonNull(使用者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者氏名カナ"));
        entity.setShiyosha_ShimeiKana(使用者氏名カナ);
        return this;
    }

    /**
     * 使用者氏名を設定します。
     *
     * @param 使用者氏名 使用者氏名
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set使用者氏名(AtenaMeisho 使用者氏名) {
        requireNonNull(使用者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者氏名"));
        entity.setShiyosha_Shimei(使用者氏名);
        return this;
    }

    /**
     * 使用者生年月日を設定します。
     *
     * @param 使用者生年月日 使用者生年月日
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set使用者生年月日(FlexibleDate 使用者生年月日) {
        requireNonNull(使用者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者生年月日"));
        entity.setShiyosha_UmareYMD(使用者生年月日);
        return this;
    }

    /**
     * 使用者電話番号を設定します。
     *
     * @param 使用者電話番号 使用者電話番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set使用者電話番号(TelNo 使用者電話番号) {
        requireNonNull(使用者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者電話番号"));
        entity.setShiyosha_TelNo(使用者電話番号);
        return this;
    }

    /**
     * 使用者職業を設定します。
     *
     * @param 使用者職業 使用者職業
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set使用者職業(RString 使用者職業) {
        requireNonNull(使用者職業, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者職業"));
        entity.setShiyosha_Shokugyo(使用者職業);
        return this;
    }

    /**
     * 負傷年月日を設定します。
     *
     * @param 負傷年月日 負傷年月日
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set負傷年月日(FlexibleDate 負傷年月日) {
        requireNonNull(負傷年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負傷年月日"));
        entity.setFushoYMD(負傷年月日);
        return this;
    }

    /**
     * 負傷時間を設定します。
     *
     * @param 負傷時間 負傷時間
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set負傷時間(RString 負傷時間) {
        requireNonNull(負傷時間, UrSystemErrorMessages.値がnull.getReplacedMessage("負傷時間"));
        entity.setFushoTime(負傷時間);
        return this;
    }

    /**
     * 負傷時の場所を設定します。
     *
     * @param 負傷時の場所 負傷時の場所
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set負傷時の場所(RString 負傷時の場所) {
        requireNonNull(負傷時の場所, UrSystemErrorMessages.値がnull.getReplacedMessage("負傷時の場所"));
        entity.setFushoJi_Basho(負傷時の場所);
        return this;
    }

    /**
     * 発病原因・負傷時状況を設定します。
     *
     * @param 発病原因_負傷時状況 発病原因・負傷時状況
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set発病原因_負傷時状況(RString 発病原因_負傷時状況) {
        requireNonNull(発病原因_負傷時状況, UrSystemErrorMessages.値がnull.getReplacedMessage("発病原因・負傷時状況"));
        entity.setHasshoGeiin_FushoJiJokyo(発病原因_負傷時状況);
        return this;
    }

    /**
     * 自賠責保険契約会社名を設定します。
     *
     * @param 自賠責保険契約会社名 自賠責保険契約会社名
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set自賠責保険契約会社名(AtenaMeisho 自賠責保険契約会社名) {
        requireNonNull(自賠責保険契約会社名, UrSystemErrorMessages.値がnull.getReplacedMessage("自賠責保険契約会社名"));
        entity.setJibaisekiHoken_KeiyakuKaishaMei(自賠責保険契約会社名);
        return this;
    }

    /**
     * 自賠責保険証明書番号を設定します。
     *
     * @param 自賠責保険証明書番号 自賠責保険証明書番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set自賠責保険証明書番号(RString 自賠責保険証明書番号) {
        requireNonNull(自賠責保険証明書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自賠責保険証明書番号"));
        entity.setJibaisekiHoken_ShomeishoNo(自賠責保険証明書番号);
        return this;
    }

    /**
     * 自賠責保険契約者住所を設定します。
     *
     * @param 自賠責保険契約者住所 自賠責保険契約者住所
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set自賠責保険契約者住所(RString 自賠責保険契約者住所) {
        requireNonNull(自賠責保険契約者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("自賠責保険契約者住所"));
        entity.setJibaisekiHoken_KeiyakushaJusho(自賠責保険契約者住所);
        return this;
    }

    /**
     * 所有者住所を設定します。
     *
     * @param 所有者住所 所有者住所
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set所有者住所(RString 所有者住所) {
        requireNonNull(所有者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("所有者住所"));
        entity.setShoyushaJusho(所有者住所);
        return this;
    }

    /**
     * 所有者氏名を設定します。
     *
     * @param 所有者氏名 所有者氏名
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set所有者氏名(AtenaMeisho 所有者氏名) {
        requireNonNull(所有者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("所有者氏名"));
        entity.setShoyushaShimei(所有者氏名);
        return this;
    }

    /**
     * 登録番号を設定します。
     *
     * @param 登録番号 登録番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set登録番号(RString 登録番号) {
        requireNonNull(登録番号, UrSystemErrorMessages.値がnull.getReplacedMessage("登録番号"));
        entity.setTorokuNo(登録番号);
        return this;
    }

    /**
     * 車台番号を設定します。
     *
     * @param 車台番号 車台番号
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set車台番号(RString 車台番号) {
        requireNonNull(車台番号, UrSystemErrorMessages.値がnull.getReplacedMessage("車台番号"));
        entity.setShadaiNo(車台番号);
        return this;
    }

    /**
     * 任意保険対人保障有無を設定します。
     *
     * @param 任意保険対人保障有無 任意保険対人保障有無
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set任意保険対人保障有無(RString 任意保険対人保障有無) {
        requireNonNull(任意保険対人保障有無, UrSystemErrorMessages.値がnull.getReplacedMessage("任意保険対人保障有無"));
        entity.setNiniHoken_TaijinHoshoUmu(任意保険対人保障有無);
        return this;
    }

    /**
     * 任意保険対人保障保険契約会社名を設定します。
     *
     * @param 任意保険対人保障保険契約会社名 任意保険対人保障保険契約会社名
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set任意保険対人保障保険契約会社名(AtenaMeisho 任意保険対人保障保険契約会社名) {
        requireNonNull(任意保険対人保障保険契約会社名, UrSystemErrorMessages.値がnull.getReplacedMessage("任意保険対人保障保険契約会社名"));
        entity.setNiniHoken_TaijinHoshoKaishaMei(任意保険対人保障保険契約会社名);
        return this;
    }

    /**
     * 任意保険対人保障保険契約会社連絡先を設定します。
     *
     * @param 任意保険対人保障保険契約会社連絡先 任意保険対人保障保険契約会社連絡先
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set任意保険対人保障保険契約会社連絡先(TelNo 任意保険対人保障保険契約会社連絡先) {
        requireNonNull(任意保険対人保障保険契約会社連絡先, UrSystemErrorMessages.値がnull.getReplacedMessage("任意保険対人保障保険契約会社連絡先"));
        entity.setNiniHoken_TaijinHoshoKaishaTelNo(任意保険対人保障保険契約会社連絡先);
        return this;
    }

    /**
     * 任意保険対人保障保険契約会社担当者を設定します。
     *
     * @param 任意保険対人保障保険契約会社担当者 任意保険対人保障保険契約会社担当者
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set任意保険対人保障保険契約会社担当者(AtenaMeisho 任意保険対人保障保険契約会社担当者) {
        requireNonNull(任意保険対人保障保険契約会社担当者, UrSystemErrorMessages.値がnull.getReplacedMessage("任意保険対人保障保険契約会社担当者"));
        entity.setNiniHoken_TaijinHoshoKaishaTantosha(任意保険対人保障保険契約会社担当者);
        return this;
    }

    /**
     * 示談成立有無を設定します。
     *
     * @param 示談成立有無 示談成立有無
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set示談成立有無(RString 示談成立有無) {
        requireNonNull(示談成立有無, UrSystemErrorMessages.値がnull.getReplacedMessage("示談成立有無"));
        entity.setJidan_SeiritsuUmu(示談成立有無);
        return this;
    }

    /**
     * 示談成立年月日を設定します。
     *
     * @param 示談成立年月日 示談成立年月日
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set示談成立年月日(FlexibleDate 示談成立年月日) {
        requireNonNull(示談成立年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談成立年月日"));
        entity.setJidan_SeiritsuYMD(示談成立年月日);
        return this;
    }

    /**
     * 損害賠償交渉経過を設定します。
     *
     * @param 損害賠償交渉経過 損害賠償交渉経過
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set損害賠償交渉経過(RString 損害賠償交渉経過) {
        requireNonNull(損害賠償交渉経過, UrSystemErrorMessages.値がnull.getReplacedMessage("損害賠償交渉経過"));
        entity.setSongaiBaishoKoshoKeika(損害賠償交渉経過);
        return this;
    }

    /**
     * 事故発生状況報告書有無を設定します。
     *
     * @param 事故発生状況報告書有無 事故発生状況報告書有無
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set事故発生状況報告書有無(RString 事故発生状況報告書有無) {
        requireNonNull(事故発生状況報告書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("事故発生状況報告書有無"));
        entity.setJikoHasseiJokyoHokokushoUmu(事故発生状況報告書有無);
        return this;
    }

    /**
     * 念書兼同意書有無を設定します。
     *
     * @param 念書兼同意書有無 念書兼同意書有無
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set念書兼同意書有無(RString 念書兼同意書有無) {
        requireNonNull(念書兼同意書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("念書兼同意書有無"));
        entity.setNensho_DoishoUmu(念書兼同意書有無);
        return this;
    }

    /**
     * 誓約書有無を設定します。
     *
     * @param 誓約書有無 誓約書有無
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set誓約書有無(RString 誓約書有無) {
        requireNonNull(誓約書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("誓約書有無"));
        entity.setSeiyakushoUmu(誓約書有無);
        return this;
    }

    /**
     * 交通事故証明書有無を設定します。
     *
     * @param 交通事故証明書有無 交通事故証明書有無
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set交通事故証明書有無(RString 交通事故証明書有無) {
        requireNonNull(交通事故証明書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("交通事故証明書有無"));
        entity.setKotsuJikoShomeishoUmu(交通事故証明書有無);
        return this;
    }

    /**
     * 人身事故証明書入手不能理由書有無を設定します。
     *
     * @param 人身事故証明書入手不能理由書有無 人身事故証明書入手不能理由書有無
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set人身事故証明書入手不能理由書有無(RString 人身事故証明書入手不能理由書有無) {
        requireNonNull(人身事故証明書入手不能理由書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("人身事故証明書入手不能理由書有無"));
        entity.setJinshinJikoShomeisho_NyushuFunoRiyushoUmu(人身事故証明書入手不能理由書有無);
        return this;
    }

    /**
     * 示談書写し有無を設定します。
     *
     * @param 示談書写し有無 示談書写し有無
     * @return {@link DaisanshaKoiTodokedeBuilder}
     */
    public DaisanshaKoiTodokedeBuilder set示談書写し有無(RString 示談書写し有無) {
        requireNonNull(示談書写し有無, UrSystemErrorMessages.値がnull.getReplacedMessage("示談書写し有無"));
        entity.setJidanshoUtsushiUmu(示談書写し有無);
        return this;
    }

    /**
     * {@link DaisanshaKoiTodokede}のインスタンスを生成します。
     *
     * @return {@link DaisanshaKoiTodokede}のインスタンス
     */
    public DaisanshaKoiTodokede build() {
        return new DaisanshaKoiTodokede(entity, id);
    }
}
