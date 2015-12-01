/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteichosaSchedule}の編集を行うビルダークラスです。
 */
public class NinteichosaScheduleBuilder {

    private final DbT5221NinteichosaScheduleEntity entity;
    private final NinteichosaScheduleIdentifier id;

    /**
     * {@link DbT5221NinteichosaScheduleEntity}より{@link NinteichosaSchedule}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5221NinteichosaScheduleEntity}
     * @param id {@link NinteichosaScheduleIdentifier}
     *
     */
    NinteichosaScheduleBuilder(
            DbT5221NinteichosaScheduleEntity entity,
            NinteichosaScheduleIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 認定調査予定年月日を設定します。
     *
     * @param 認定調査予定年月日 認定調査予定年月日
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set認定調査予定年月日(FlexibleDate 認定調査予定年月日) {
        requireNonNull(認定調査予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定年月日"));
        entity.setNinteiChosaYoteiYMD(認定調査予定年月日);
        return this;
    }

    /**
     * 認定調査予定開始時間を設定します。
     *
     * @param 認定調査予定開始時間 認定調査予定開始時間
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set認定調査予定開始時間(RString 認定調査予定開始時間) {
        requireNonNull(認定調査予定開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定開始時間"));
        entity.setNinteiChosaYoteiKaishiTime(認定調査予定開始時間);
        return this;
    }

    /**
     * 認定調査予定終了時間を設定します。
     *
     * @param 認定調査予定終了時間 認定調査予定終了時間
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set認定調査予定終了時間(RString 認定調査予定終了時間) {
        requireNonNull(認定調査予定終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定終了時間"));
        entity.setNinteiChosaYoteiShuryoTime(認定調査予定終了時間);
        return this;
    }

    /**
     * 認定調査時間枠を設定します。
     *
     * @param 認定調査時間枠 認定調査時間枠
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set認定調査時間枠(Code 認定調査時間枠) {
        requireNonNull(認定調査時間枠, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査時間枠"));
        entity.setNinteiChosaJikanWaku(認定調査時間枠);
        return this;
    }

    /**
     * 調査地区コードを設定します。
     *
     * @param 調査地区コード 調査地区コード
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set調査地区コード(Code 調査地区コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        entity.setChosaChikuCode(調査地区コード);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link NinteichosaScheduleBuilder}
     */
//    public NinteichosaScheduleBuilder set認定調査委託先コード(RString 認定調査委託先コード) {
//        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
//        entity.setNinteichosaItakusakiCode(認定調査委託先コード);
//        return this;
//    }
//
//    /**
//     * 認定調査員コードを設定します。
//     *
//     * @param 認定調査員コード 認定調査員コード
//     * @return {@link NinteichosaScheduleBuilder}
//     */
//    public NinteichosaScheduleBuilder set認定調査員コード(RString 認定調査員コード) {
//        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
//        entity.setNinteiChosainNo(認定調査員コード);
//        return this;
//    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 予約状況を設定します。
     *
     * @param 予約状況 予約状況
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set予約状況(Code 予約状況) {
        requireNonNull(予約状況, UrSystemErrorMessages.値がnull.getReplacedMessage("予約状況"));
        entity.setYoyakuJokyo(予約状況);
        return this;
    }

    /**
     * 予約可能フラグを設定します。
     *
     * @param 予約可能フラグ 予約可能フラグ
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set予約可能フラグ(boolean 予約可能フラグ) {
        requireNonNull(予約可能フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("予約可能フラグ"));
        entity.setYoyakuKaoFlag(予約可能フラグ);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 場所を設定します。
     *
     * @param 場所 場所
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set場所(RString 場所) {
        requireNonNull(場所, UrSystemErrorMessages.値がnull.getReplacedMessage("場所"));
        entity.setBasho(場所);
        return this;
    }

    /**
     * 駐車場を設定します。
     *
     * @param 駐車場 駐車場
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set駐車場(RString 駐車場) {
        requireNonNull(駐車場, UrSystemErrorMessages.値がnull.getReplacedMessage("駐車場"));
        entity.setChushajo(駐車場);
        return this;
    }

    /**
     * 立会人１を設定します。
     *
     * @param 立会人１ 立会人１
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set立会人１(RString 立会人１) {
        requireNonNull(立会人１, UrSystemErrorMessages.値がnull.getReplacedMessage("立会人１"));
        entity.setTachiainin1(立会人１);
        return this;
    }

    /**
     * 連絡先１を設定します。
     *
     * @param 連絡先１ 連絡先１
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set連絡先１(TelNo 連絡先１) {
        requireNonNull(連絡先１, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先１"));
        entity.setRenrakusaki1(連絡先１);
        return this;
    }

    /**
     * 立会人２を設定します。
     *
     * @param 立会人２ 立会人２
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set立会人２(RString 立会人２) {
        requireNonNull(立会人２, UrSystemErrorMessages.値がnull.getReplacedMessage("立会人２"));
        entity.setTachiainin2(立会人２);
        return this;
    }

    /**
     * 連絡先２を設定します。
     *
     * @param 連絡先２ 連絡先２
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set連絡先２(TelNo 連絡先２) {
        requireNonNull(連絡先２, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先２"));
        entity.setRenrakusaki2(連絡先２);
        return this;
    }

    /**
     * 対象者メモを設定します。
     *
     * @param 対象者メモ 対象者メモ
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder set対象者メモ(RString 対象者メモ) {
        requireNonNull(対象者メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者メモ"));
        entity.setTaishoshaMemo(対象者メモ);
        return this;
    }

    /**
     * {@link NinteichosaSchedule}のインスタンスを生成します。
     *
     * @return {@link NinteichosaSchedule}のインスタンス
     */
    public NinteichosaSchedule build() {
        return new NinteichosaSchedule(entity, id);
    }
}
