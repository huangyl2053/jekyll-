/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedule;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain.ChikuNinteiChosainIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedulememo.NinteiChosaScheduleMemo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedulememo.NinteiChosaScheduleMemoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link NinteichosaSchedule}の編集を行うビルダークラスです。
 */
public class NinteichosaScheduleBuilder {

    private final DbT5221NinteichosaScheduleEntity entity;
    private final NinteichosaScheduleIdentifier id;
    private final Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho;
    private final Models<NinteiChosaScheduleMemoIdentifier, NinteiChosaScheduleMemo> ninteiChosaScheduleMemo;
    private final Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> chikuNinteiChosain;

    /**
     * {@link DbT5221NinteichosaScheduleEntity}より{@link NinteichosaSchedule}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5221NinteichosaScheduleEntity}
     * @param id {@link NinteichosaScheduleIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    NinteichosaScheduleBuilder(
            DbT5221NinteichosaScheduleEntity entity,
            NinteichosaScheduleIdentifier id,
            Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseijoho,
            Models<NinteiChosaScheduleMemoIdentifier, NinteiChosaScheduleMemo> ninteichosaschedulememo,
            Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> chikuninteichosain) {
        this.entity = entity.clone();
        this.id = id;
        this.ninteiShinseiJoho = ninteiShinseijoho.clone();
        this.ninteiChosaScheduleMemo = ninteichosaschedulememo.clone();
        this.chikuNinteiChosain = chikuninteichosain.clone();
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
     * 要介護認定申請情報情報のキー情報について判定します。<br>
     * 精神手帳情報に関連できる精神手帳任意項目情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は精神手帳任意項目情報リストに精神手帳任意項目情報{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 要介護認定申請情報 {@link NinteiShinseiJoho}
     * @return {@link NinteichosaScheduleBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosaScheduleBuilder setNinteiShinseiJoho(NinteiShinseiJoho 要介護認定申請情報) {
        if (hasSameIdentifier(要介護認定申請情報.identifier())) {
            ninteiShinseiJoho.add(要介護認定申請情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteiShinseiJohoIdentifier 要介護認定申請情報の識別子) {
        return (entity.getShinseishoKanriNo().equals(要介護認定申請情報の識別子.get申請書管理番号()));
    }

    /**
     * 認定調査スケジュールメモ情報のキー情報について判定します。<br>
     * 精神手帳情報に関連できる届出者情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は届出者情報リストに届出者情報{@link Todokedesha}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査スケジュールメモ情報 {@link NinteiChosaScheduleMemo}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosaScheduleBuilder setTodokedesha(NinteiChosaScheduleMemo  認定調査スケジュールメモ情報) {
        if (hasSameIdentifier(認定調査スケジュールメモ情報.identifier())) {
            ninteiChosaScheduleMemo.add(認定調査スケジュールメモ情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteiChosaScheduleMemoIdentifier 認定調査スケジュールメモ情報の識別子) {
        return (id.get調査地区コード().equals(認定調査スケジュールメモ情報の識別子.get調査地区コード()));
    }
    
    /**
     * 認定調査スケジュールメモ情報のキー情報について判定します。<br>
     * 精神手帳情報に関連できる届出者情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は届出者情報リストに届出者情報{@link Todokedesha}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 地区認定調査員情報 {@link ChikuNinteiChosain}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosaScheduleBuilder setChikuNinteiChosain(ChikuNinteiChosain  地区認定調査員情報) {
        if (hasSameIdentifier(地区認定調査員情報.identifier())) {
            chikuNinteiChosain.add(地区認定調査員情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ChikuNinteiChosainIdentifier 地区認定調査員の識別子) {
        return (id.get調査地区コード().equals(地区認定調査員の識別子.get調査地区コード()));
    }

    /**
     * {@link NinteichosaSchedule}のインスタンスを生成します。
     *
     * @return {@link NinteichosaSchedule}のインスタンス
     */
    public NinteichosaSchedule build() {
        return new NinteichosaSchedule(entity, id, ninteiShinseiJoho, ninteiChosaScheduleMemo,chikuNinteiChosain);
    }
}
