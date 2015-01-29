/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3084DaisanshaKoiTodokedeEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為届出のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DaisanshaKoiTodokedeModel implements Serializable {

    private DbT3084DaisanshaKoiTodokedeEntity entity;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiTodokedeModel() {
        entity = new DbT3084DaisanshaKoiTodokedeEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3084DaisanshaKoiTodokedeEntity
     */
    public DaisanshaKoiTodokedeModel(DbT3084DaisanshaKoiTodokedeEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3084DaisanshaKoiTodokedeEntityを返します。
     *
     * @return DbT3084DaisanshaKoiTodokedeEntity
     */
    public DbT3084DaisanshaKoiTodokedeEntity getEntity() {
        return entity;
    }

    /**
     * DbT3084DaisanshaKoiTodokedeEntityを設定します。
     *
     * @param entity DbT3084DaisanshaKoiTodokedeEntity
     */
    public void setEntity(DbT3084DaisanshaKoiTodokedeEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 第三者行為届出管理番号を返します。
     *
     * @return 第三者行為届出管理番号
     */
    public RString get第三者行為届出管理番号() {
        return entity.getTodokedeKanriNo();
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
     * 届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get届出年月日() {
        return entity.getTodokedeYMD();
    }

    /**
     * 届出人郵便番号を返します。
     *
     * @return 届出人郵便番号
     */
    public YubinNo get届出人郵便番号() {
        return entity.getTodokedenin_YubinNo();
    }

    /**
     * 届出人住所を返します。
     *
     * @return 届出人住所
     */
    public RString get届出人住所() {
        return entity.getTodokedenin_Jusho();
    }

    /**
     * 届出人氏名カナを返します。
     *
     * @return 届出人氏名カナ
     */
    public AtenaKanaMeisho get届出人氏名カナ() {
        return entity.getTodokedenin_ShimeiKana();
    }

    /**
     * 届出人氏名を返します。
     *
     * @return 届出人氏名
     */
    public AtenaMeisho get届出人氏名() {
        return entity.getTodokedenin_Shimei();
    }

    /**
     * 届出人電話番号を返します。
     *
     * @return 届出人電話番号
     */
    public TelNo get届出人電話番号() {
        return entity.getTodokedenin_TelNo();
    }

    /**
     * 届出人との続柄を返します。
     *
     * @return 届出人との続柄
     */
    public RString get届出人との続柄() {
        return entity.getTodokedenin_Zokugara();
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public Code get要介護状態区分() {
        return entity.getYokaigoJotaiKubun();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.getNinteiYukoKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.getNinteiYukoShuryoYMD();
    }

    /**
     * 加害者郵便番号を返します。
     *
     * @return 加害者郵便番号
     */
    public YubinNo get加害者郵便番号() {
        return entity.getKagaisha_YubinNo();
    }

    /**
     * 加害者住所を返します。
     *
     * @return 加害者住所
     */
    public RString get加害者住所() {
        return entity.getKagaisha_Jusho();
    }

    /**
     * 加害者氏名カナを返します。
     *
     * @return 加害者氏名カナ
     */
    public AtenaKanaMeisho get加害者氏名カナ() {
        return entity.getKagaisha_ShimeiKana();
    }

    /**
     * 加害者氏名を返します。
     *
     * @return 加害者氏名
     */
    public AtenaMeisho get加害者氏名() {
        return entity.getKagansha_Shimei();
    }

    /**
     * 加害者生年月日を返します。
     *
     * @return 加害者生年月日
     */
    public FlexibleDate get加害者生年月日() {
        return entity.getKagaisha_UmareYMD();
    }

    /**
     * 加害者電話番号を返します。
     *
     * @return 加害者電話番号
     */
    public TelNo get加害者電話番号() {
        return entity.getKagaisha_TelNo();
    }

    /**
     * 加害者職業を返します。
     *
     * @return 加害者職業
     */
    public RString get加害者職業() {
        return entity.getKagaisha_Shokugyo();
    }

    /**
     * 使用者郵便番号を返します。
     *
     * @return 使用者郵便番号
     */
    public YubinNo get使用者郵便番号() {
        return entity.getShiyosha_YubinNo();
    }

    /**
     * 使用者住所を返します。
     *
     * @return 使用者住所
     */
    public RString get使用者住所() {
        return entity.getShiyosha_Jusho();
    }

    /**
     * 使用者氏名カナを返します。
     *
     * @return 使用者氏名カナ
     */
    public AtenaKanaMeisho get使用者氏名カナ() {
        return entity.getShiyosha_ShimeiKana();
    }

    /**
     * 使用者氏名を返します。
     *
     * @return 使用者氏名
     */
    public AtenaMeisho get使用者氏名() {
        return entity.getShiyosha_Shimei();
    }

    /**
     * 使用者生年月日を返します。
     *
     * @return 使用者生年月日
     */
    public FlexibleDate get使用者生年月日() {
        return entity.getShiyosha_UmareYMD();
    }

    /**
     * 使用者電話番号を返します。
     *
     * @return 使用者電話番号
     */
    public TelNo get使用者電話番号() {
        return entity.getShiyosha_TelNo();
    }

    /**
     * 使用者職業を返します。
     *
     * @return 使用者職業
     */
    public RString get使用者職業() {
        return entity.getShiyosha_Shokugyo();
    }

    /**
     * 負傷年月日を返します。
     *
     * @return 負傷年月日
     */
    public FlexibleDate get負傷年月日() {
        return entity.getFushoYMD();
    }

    /**
     * 負傷時間を返します。
     *
     * @return 負傷時間
     */
    public RString get負傷時間() {
        return entity.getFushoTime();
    }

    /**
     * 負傷時の場所を返します。
     *
     * @return 負傷時の場所
     */
    public RString get負傷時の場所() {
        return entity.getFushoJi_Basho();
    }

    /**
     * 発病原因_負傷時状況を返します。
     *
     * @return 発病原因_負傷時状況
     */
    public RString get発病原因_負傷時状況() {
        return entity.getHasshoGeiin_FushoJiJokyo();
    }

    /**
     * 自賠責保険契約会社名を返します。
     *
     * @return 自賠責保険契約会社名
     */
    public AtenaMeisho get自賠責保険契約会社名() {
        return entity.getJibaisekiHoken_KeiyakuKaishaMei();
    }

    /**
     * 自賠責保険証明書番号を返します。
     *
     * @return 自賠責保険証明書番号
     */
    public RString get自賠責保険証明書番号() {
        return entity.getJibaisekiHoken_ShomeishoNo();
    }

    /**
     * 自賠責保険契約者住所を返します。
     *
     * @return 自賠責保険契約者住所
     */
    public RString get自賠責保険契約者住所() {
        return entity.getJibaisekiHoken_KeiyakushaJusho();
    }

    /**
     * 所有者住所を返します。
     *
     * @return 所有者住所
     */
    public RString get所有者住所() {
        return entity.getShoyushaJusho();
    }

    /**
     * 所有者氏名を返します。
     *
     * @return 所有者氏名
     */
    public AtenaMeisho get所有者氏名() {
        return entity.getShoyushaShimei();
    }

    /**
     * 登録番号を返します。
     *
     * @return 登録番号
     */
    public RString get登録番号() {
        return entity.getTorokuNo();
    }

    /**
     * 車台番号を返します。
     *
     * @return 車台番号
     */
    public RString get車台番号() {
        return entity.getShadaiNo();
    }

    /**
     * 任意保険対人保障有無を返します。
     *
     * @return 任意保険対人保障有無
     */
    public RString get任意保険対人保障有無() {
        return entity.getNiniHoken_TaijinHoshoUmu();
    }

    /**
     * 任意保険対人保障保険契約会社名を返します。
     *
     * @return 任意保険対人保障保険契約会社名
     */
    public AtenaMeisho get任意保険対人保障保険契約会社名() {
        return entity.getNiniHoken_TaijinHoshoKaishaMei();
    }

    /**
     * 任意保険対人保障保険契約会社連絡先を返します。
     *
     * @return 任意保険対人保障保険契約会社連絡先
     */
    public TelNo get任意保険対人保障保険契約会社連絡先() {
        return entity.getNiniHoken_TaijinHoshoKaishaTelNo();
    }

    /**
     * 任意保険対人保障保険契約会社担当者を返します。
     *
     * @return 任意保険対人保障保険契約会社担当者
     */
    public AtenaMeisho get任意保険対人保障保険契約会社担当者() {
        return entity.getNiniHoken_TaijinHoshoKaishaTantosha();
    }

    /**
     * 示談成立有無を返します。
     *
     * @return 示談成立有無
     */
    public RString get示談成立有無() {
        return entity.getJidan_SeiritsuUmu();
    }

    /**
     * 示談成立年月日を返します。
     *
     * @return 示談成立年月日
     */
    public FlexibleDate get示談成立年月日() {
        return entity.getJidan_SeiritsuYMD();
    }

    /**
     * 損害賠償交渉経過を返します。
     *
     * @return 損害賠償交渉経過
     */
    public RString get損害賠償交渉経過() {
        return entity.getSongaiBaishoKoshoKeika();
    }

    /**
     * 事故発生状況報告書有無を返します。
     *
     * @return 事故発生状況報告書有無
     */
    public RString get事故発生状況報告書有無() {
        return entity.getJikoHasseiJokyoHokokushoUmu();
    }

    /**
     * 念書兼同意書有無を返します。
     *
     * @return 念書兼同意書有無
     */
    public RString get念書兼同意書有無() {
        return entity.getNensho_DoishoUmu();
    }

    /**
     * 誓約書有無を返します。
     *
     * @return 誓約書有無
     */
    public RString get誓約書有無() {
        return entity.getSeiyakushoUmu();
    }

    /**
     * 交通事故証明書有無を返します。
     *
     * @return 交通事故証明書有無
     */
    public RString get交通事故証明書有無() {
        return entity.getKotsuJikoShomeishoUmu();
    }

    /**
     * 人身事故証明書入手不能理由書有無を返します。
     *
     * @return 人身事故証明書入手不能理由書有無
     */
    public RString get人身事故証明書入手不能理由書有無() {
        return entity.getJinshinJikoShomeisho_NyushuFunoRiyushoUmu();
    }

    /**
     * 示談書写し有無を返します。
     *
     * @return 示談書写し有無
     */
    public RString get示談書写し有無() {
        return entity.getJidanshoUtsushiUmu();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     */
    public void set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
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
     * 届出年月日を設定します。
     *
     * @param 届出年月日 届出年月日
     */
    public void set届出年月日(FlexibleDate 届出年月日) {
        requireNonNull(届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("届出年月日"));
        entity.setTodokedeYMD(届出年月日);
    }

    /**
     * 届出人郵便番号を設定します。
     *
     * @param 届出人郵便番号 届出人郵便番号
     */
    public void set届出人郵便番号(YubinNo 届出人郵便番号) {
        requireNonNull(届出人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人郵便番号"));
        entity.setTodokedenin_YubinNo(届出人郵便番号);
    }

    /**
     * 届出人住所を設定します。
     *
     * @param 届出人住所 届出人住所
     */
    public void set届出人住所(RString 届出人住所) {
        requireNonNull(届出人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人住所"));
        entity.setTodokedenin_Jusho(届出人住所);
    }

    /**
     * 届出人氏名カナを設定します。
     *
     * @param 届出人氏名カナ 届出人氏名カナ
     */
    public void set届出人氏名カナ(AtenaKanaMeisho 届出人氏名カナ) {
        requireNonNull(届出人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人氏名カナ"));
        entity.setTodokedenin_ShimeiKana(届出人氏名カナ);
    }

    /**
     * 届出人氏名を設定します。
     *
     * @param 届出人氏名 届出人氏名
     */
    public void set届出人氏名(AtenaMeisho 届出人氏名) {
        requireNonNull(届出人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人氏名"));
        entity.setTodokedenin_Shimei(届出人氏名);
    }

    /**
     * 届出人電話番号を設定します。
     *
     * @param 届出人電話番号 届出人電話番号
     */
    public void set届出人電話番号(TelNo 届出人電話番号) {
        requireNonNull(届出人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人電話番号"));
        entity.setTodokedenin_TelNo(届出人電話番号);
    }

    /**
     * 届出人との続柄を設定します。
     *
     * @param 届出人との続柄 届出人との続柄
     */
    public void set届出人との続柄(RString 届出人との続柄) {
        requireNonNull(届出人との続柄, UrSystemErrorMessages.値がnull.getReplacedMessage("届出人との続柄"));
        entity.setTodokedenin_Zokugara(届出人との続柄);
    }

    /**
     * 要介護状態区分を設定します。
     *
     * @param 要介護状態区分 要介護状態区分
     */
    public void set要介護状態区分(Code 要介護状態区分) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        entity.setYokaigoJotaiKubun(要介護状態区分);
    }

    /**
     * 認定有効期間開始年月日を設定します。
     *
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     */
    public void set認定有効期間開始年月日(FlexibleDate 認定有効期間開始年月日) {
        requireNonNull(認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間開始年月日"));
        entity.setNinteiYukoKaishiYMD(認定有効期間開始年月日);
    }

    /**
     * 認定有効期間終了年月日を設定します。
     *
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     */
    public void set認定有効期間終了年月日(FlexibleDate 認定有効期間終了年月日) {
        requireNonNull(認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間終了年月日"));
        entity.setNinteiYukoShuryoYMD(認定有効期間終了年月日);
    }

    /**
     * 加害者郵便番号を設定します。
     *
     * @param 加害者郵便番号 加害者郵便番号
     */
    public void set加害者郵便番号(YubinNo 加害者郵便番号) {
        requireNonNull(加害者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者郵便番号"));
        entity.setKagaisha_YubinNo(加害者郵便番号);
    }

    /**
     * 加害者住所を設定します。
     *
     * @param 加害者住所 加害者住所
     */
    public void set加害者住所(RString 加害者住所) {
        requireNonNull(加害者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者住所"));
        entity.setKagaisha_Jusho(加害者住所);
    }

    /**
     * 加害者氏名カナを設定します。
     *
     * @param 加害者氏名カナ 加害者氏名カナ
     */
    public void set加害者氏名カナ(AtenaKanaMeisho 加害者氏名カナ) {
        requireNonNull(加害者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者氏名カナ"));
        entity.setKagaisha_ShimeiKana(加害者氏名カナ);
    }

    /**
     * 加害者氏名を設定します。
     *
     * @param 加害者氏名 加害者氏名
     */
    public void set加害者氏名(AtenaMeisho 加害者氏名) {
        requireNonNull(加害者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者氏名"));
        entity.setKagansha_Shimei(加害者氏名);
    }

    /**
     * 加害者生年月日を設定します。
     *
     * @param 加害者生年月日 加害者生年月日
     */
    public void set加害者生年月日(FlexibleDate 加害者生年月日) {
        requireNonNull(加害者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者生年月日"));
        entity.setKagaisha_UmareYMD(加害者生年月日);
    }

    /**
     * 加害者電話番号を設定します。
     *
     * @param 加害者電話番号 加害者電話番号
     */
    public void set加害者電話番号(TelNo 加害者電話番号) {
        requireNonNull(加害者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者電話番号"));
        entity.setKagaisha_TelNo(加害者電話番号);
    }

    /**
     * 加害者職業を設定します。
     *
     * @param 加害者職業 加害者職業
     */
    public void set加害者職業(RString 加害者職業) {
        requireNonNull(加害者職業, UrSystemErrorMessages.値がnull.getReplacedMessage("加害者職業"));
        entity.setKagaisha_Shokugyo(加害者職業);
    }

    /**
     * 使用者郵便番号を設定します。
     *
     * @param 使用者郵便番号 使用者郵便番号
     */
    public void set使用者郵便番号(YubinNo 使用者郵便番号) {
        requireNonNull(使用者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者郵便番号"));
        entity.setShiyosha_YubinNo(使用者郵便番号);
    }

    /**
     * 使用者住所を設定します。
     *
     * @param 使用者住所 使用者住所
     */
    public void set使用者住所(RString 使用者住所) {
        requireNonNull(使用者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者住所"));
        entity.setShiyosha_Jusho(使用者住所);
    }

    /**
     * 使用者氏名カナを設定します。
     *
     * @param 使用者氏名カナ 使用者氏名カナ
     */
    public void set使用者氏名カナ(AtenaKanaMeisho 使用者氏名カナ) {
        requireNonNull(使用者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者氏名カナ"));
        entity.setShiyosha_ShimeiKana(使用者氏名カナ);
    }

    /**
     * 使用者氏名を設定します。
     *
     * @param 使用者氏名 使用者氏名
     */
    public void set使用者氏名(AtenaMeisho 使用者氏名) {
        requireNonNull(使用者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者氏名"));
        entity.setShiyosha_Shimei(使用者氏名);
    }

    /**
     * 使用者生年月日を設定します。
     *
     * @param 使用者生年月日 使用者生年月日
     */
    public void set使用者生年月日(FlexibleDate 使用者生年月日) {
        requireNonNull(使用者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者生年月日"));
        entity.setShiyosha_UmareYMD(使用者生年月日);
    }

    /**
     * 使用者電話番号を設定します。
     *
     * @param 使用者電話番号 使用者電話番号
     */
    public void set使用者電話番号(TelNo 使用者電話番号) {
        requireNonNull(使用者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者電話番号"));
        entity.setShiyosha_TelNo(使用者電話番号);
    }

    /**
     * 使用者職業を設定します。
     *
     * @param 使用者職業 使用者職業
     */
    public void set使用者職業(RString 使用者職業) {
        requireNonNull(使用者職業, UrSystemErrorMessages.値がnull.getReplacedMessage("使用者職業"));
        entity.setShiyosha_Shokugyo(使用者職業);
    }

    /**
     * 負傷年月日を設定します。
     *
     * @param 負傷年月日 負傷年月日
     */
    public void set負傷年月日(FlexibleDate 負傷年月日) {
        requireNonNull(負傷年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負傷年月日"));
        entity.setFushoYMD(負傷年月日);
    }

    /**
     * 負傷時間を設定します。
     *
     * @param 負傷時間 負傷時間
     */
    public void set負傷時間(RString 負傷時間) {
        requireNonNull(負傷時間, UrSystemErrorMessages.値がnull.getReplacedMessage("負傷時間"));
        entity.setFushoTime(負傷時間);
    }

    /**
     * 負傷時の場所を設定します。
     *
     * @param 負傷時の場所 負傷時の場所
     */
    public void set負傷時の場所(RString 負傷時の場所) {
        requireNonNull(負傷時の場所, UrSystemErrorMessages.値がnull.getReplacedMessage("負傷時の場所"));
        entity.setFushoJi_Basho(負傷時の場所);
    }

    /**
     * 発病原因_負傷時状況を設定します。
     *
     * @param 発病原因_負傷時状況 発病原因_負傷時状況
     */
    public void set発病原因_負傷時状況(RString 発病原因_負傷時状況) {
        requireNonNull(発病原因_負傷時状況, UrSystemErrorMessages.値がnull.getReplacedMessage("発病原因_負傷時状況"));
        entity.setHasshoGeiin_FushoJiJokyo(発病原因_負傷時状況);
    }

    /**
     * 自賠責保険契約会社名を設定します。
     *
     * @param 自賠責保険契約会社名 自賠責保険契約会社名
     */
    public void set自賠責保険契約会社名(AtenaMeisho 自賠責保険契約会社名) {
        requireNonNull(自賠責保険契約会社名, UrSystemErrorMessages.値がnull.getReplacedMessage("自賠責保険契約会社名"));
        entity.setJibaisekiHoken_KeiyakuKaishaMei(自賠責保険契約会社名);
    }

    /**
     * 自賠責保険証明書番号を設定します。
     *
     * @param 自賠責保険証明書番号 自賠責保険証明書番号
     */
    public void set自賠責保険証明書番号(RString 自賠責保険証明書番号) {
        requireNonNull(自賠責保険証明書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自賠責保険証明書番号"));
        entity.setJibaisekiHoken_ShomeishoNo(自賠責保険証明書番号);
    }

    /**
     * 自賠責保険契約者住所を設定します。
     *
     * @param 自賠責保険契約者住所 自賠責保険契約者住所
     */
    public void set自賠責保険契約者住所(RString 自賠責保険契約者住所) {
        requireNonNull(自賠責保険契約者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("自賠責保険契約者住所"));
        entity.setJibaisekiHoken_KeiyakushaJusho(自賠責保険契約者住所);
    }

    /**
     * 所有者住所を設定します。
     *
     * @param 所有者住所 所有者住所
     */
    public void set所有者住所(RString 所有者住所) {
        requireNonNull(所有者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("所有者住所"));
        entity.setShoyushaJusho(所有者住所);
    }

    /**
     * 所有者氏名を設定します。
     *
     * @param 所有者氏名 所有者氏名
     */
    public void set所有者氏名(AtenaMeisho 所有者氏名) {
        requireNonNull(所有者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("所有者氏名"));
        entity.setShoyushaShimei(所有者氏名);
    }

    /**
     * 登録番号を設定します。
     *
     * @param 登録番号 登録番号
     */
    public void set登録番号(RString 登録番号) {
        requireNonNull(登録番号, UrSystemErrorMessages.値がnull.getReplacedMessage("登録番号"));
        entity.setTorokuNo(登録番号);
    }

    /**
     * 車台番号を設定します。
     *
     * @param 車台番号 車台番号
     */
    public void set車台番号(RString 車台番号) {
        requireNonNull(車台番号, UrSystemErrorMessages.値がnull.getReplacedMessage("車台番号"));
        entity.setShadaiNo(車台番号);
    }

    /**
     * 任意保険対人保障有無を設定します。
     *
     * @param 任意保険対人保障有無 任意保険対人保障有無
     */
    public void set任意保険対人保障有無(RString 任意保険対人保障有無) {
        requireNonNull(任意保険対人保障有無, UrSystemErrorMessages.値がnull.getReplacedMessage("任意保険対人保障有無"));
        entity.setNiniHoken_TaijinHoshoUmu(任意保険対人保障有無);
    }

    /**
     * 任意保険対人保障保険契約会社名を設定します。
     *
     * @param 任意保険対人保障保険契約会社名 任意保険対人保障保険契約会社名
     */
    public void set任意保険対人保障保険契約会社名(AtenaMeisho 任意保険対人保障保険契約会社名) {
        requireNonNull(任意保険対人保障保険契約会社名, UrSystemErrorMessages.値がnull.getReplacedMessage("任意保険対人保障保険契約会社名"));
        entity.setNiniHoken_TaijinHoshoKaishaMei(任意保険対人保障保険契約会社名);
    }

    /**
     * 任意保険対人保障保険契約会社連絡先を設定します。
     *
     * @param 任意保険対人保障保険契約会社連絡先 任意保険対人保障保険契約会社連絡先
     */
    public void set任意保険対人保障保険契約会社連絡先(TelNo 任意保険対人保障保険契約会社連絡先) {
        requireNonNull(任意保険対人保障保険契約会社連絡先, UrSystemErrorMessages.値がnull.getReplacedMessage("任意保険対人保障保険契約会社連絡先"));
        entity.setNiniHoken_TaijinHoshoKaishaTelNo(任意保険対人保障保険契約会社連絡先);
    }

    /**
     * 任意保険対人保障保険契約会社担当者を設定します。
     *
     * @param 任意保険対人保障保険契約会社担当者 任意保険対人保障保険契約会社担当者
     */
    public void set任意保険対人保障保険契約会社担当者(AtenaMeisho 任意保険対人保障保険契約会社担当者) {
        requireNonNull(任意保険対人保障保険契約会社担当者, UrSystemErrorMessages.値がnull.getReplacedMessage("任意保険対人保障保険契約会社担当者"));
        entity.setNiniHoken_TaijinHoshoKaishaTantosha(任意保険対人保障保険契約会社担当者);
    }

    /**
     * 示談成立有無を設定します。
     *
     * @param 示談成立有無 示談成立有無
     */
    public void set示談成立有無(RString 示談成立有無) {
        requireNonNull(示談成立有無, UrSystemErrorMessages.値がnull.getReplacedMessage("示談成立有無"));
        entity.setJidan_SeiritsuUmu(示談成立有無);
    }

    /**
     * 示談成立年月日を設定します。
     *
     * @param 示談成立年月日 示談成立年月日
     */
    public void set示談成立年月日(FlexibleDate 示談成立年月日) {
        requireNonNull(示談成立年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談成立年月日"));
        entity.setJidan_SeiritsuYMD(示談成立年月日);
    }

    /**
     * 損害賠償交渉経過を設定します。
     *
     * @param 損害賠償交渉経過 損害賠償交渉経過
     */
    public void set損害賠償交渉経過(RString 損害賠償交渉経過) {
        requireNonNull(損害賠償交渉経過, UrSystemErrorMessages.値がnull.getReplacedMessage("損害賠償交渉経過"));
        entity.setSongaiBaishoKoshoKeika(損害賠償交渉経過);
    }

    /**
     * 事故発生状況報告書有無を設定します。
     *
     * @param 事故発生状況報告書有無 事故発生状況報告書有無
     */
    public void set事故発生状況報告書有無(RString 事故発生状況報告書有無) {
        requireNonNull(事故発生状況報告書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("事故発生状況報告書有無"));
        entity.setJikoHasseiJokyoHokokushoUmu(事故発生状況報告書有無);
    }

    /**
     * 念書兼同意書有無を設定します。
     *
     * @param 念書兼同意書有無 念書兼同意書有無
     */
    public void set念書兼同意書有無(RString 念書兼同意書有無) {
        requireNonNull(念書兼同意書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("念書兼同意書有無"));
        entity.setNensho_DoishoUmu(念書兼同意書有無);
    }

    /**
     * 誓約書有無を設定します。
     *
     * @param 誓約書有無 誓約書有無
     */
    public void set誓約書有無(RString 誓約書有無) {
        requireNonNull(誓約書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("誓約書有無"));
        entity.setSeiyakushoUmu(誓約書有無);
    }

    /**
     * 交通事故証明書有無を設定します。
     *
     * @param 交通事故証明書有無 交通事故証明書有無
     */
    public void set交通事故証明書有無(RString 交通事故証明書有無) {
        requireNonNull(交通事故証明書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("交通事故証明書有無"));
        entity.setKotsuJikoShomeishoUmu(交通事故証明書有無);
    }

    /**
     * 人身事故証明書入手不能理由書有無を設定します。
     *
     * @param 人身事故証明書入手不能理由書有無 人身事故証明書入手不能理由書有無
     */
    public void set人身事故証明書入手不能理由書有無(RString 人身事故証明書入手不能理由書有無) {
        requireNonNull(人身事故証明書入手不能理由書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("人身事故証明書入手不能理由書有無"));
        entity.setJinshinJikoShomeisho_NyushuFunoRiyushoUmu(人身事故証明書入手不能理由書有無);
    }

    /**
     * 示談書写し有無を設定します。
     *
     * @param 示談書写し有無 示談書写し有無
     */
    public void set示談書写し有無(RString 示談書写し有無) {
        requireNonNull(示談書写し有無, UrSystemErrorMessages.値がnull.getReplacedMessage("示談書写し有無"));
        entity.setJidanshoUtsushiUmu(示談書写し有無);
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
