/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護除外住所地特例対象施設のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KaigoJogaiTokureiTaishoShisetsuModel implements Serializable {

    private DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity;

    /**
     * コンストラクタです。
     */
    public KaigoJogaiTokureiTaishoShisetsuModel() {
        entity = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     */
    public KaigoJogaiTokureiTaishoShisetsuModel(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1005KaigoJogaiTokureiTaishoShisetsuEntityを返します。
     *
     * @return DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     */
    public DbT1005KaigoJogaiTokureiTaishoShisetsuEntity getEntity() {
        return entity;
    }

    /**
     * DbT1005KaigoJogaiTokureiTaishoShisetsuEntityを設定します。
     *
     * @param entity DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     */
    public void setEntity(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        this.entity = entity;
    }

    /**
     * 事業者種別を返します。
     *
     * @return 事業者種別
     */
    public RString get事業者種別() {
        return entity.getJigyoshaShubetsu();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 有効開始年月日を返します。
     *
     * @return 有効開始年月日
     */
    public FlexibleDate get有効開始年月日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了年月日を返します。
     *
     * @return 有効終了年月日
     */
    public FlexibleDate get有効終了年月日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 管内_管外区分を返します。
     *
     * @return 管内_管外区分
     */
    public RString get管内_管外区分() {
        return entity.getKannaiKangaiKubun();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho get事業者名称カナ() {
        return entity.getJigyoshaKanaMeisho();
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
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    public RString get事業者住所() {
        return entity.getJigyoshaJusho();
    }

    /**
     * 事業者住所カナを返します。
     *
     * @return 事業者住所カナ
     */
    public RString get事業者住所カナ() {
        return entity.getJigyoshaKanaJusho();
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
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 異動事由を返します。
     *
     * @return 異動事由
     */
    public RString get異動事由() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    public FlexibleDate get異動年月日() {
        return entity.getIdoYMD();
    }

    /**
     * 代表者名称を返します。
     *
     * @return 代表者名称
     */
    public AtenaMeisho get代表者名称() {
        return entity.getDaihyoshaMeisho();
    }

    /**
     * 代表者名称カナを返します。
     *
     * @return 代表者名称カナ
     */
    public AtenaKanaMeisho get代表者名称カナ() {
        return entity.getDaihyoshaKanaMeisho();
    }

    /**
     * 役職を返します。
     *
     * @return 役職
     */
    public RString get役職() {
        return entity.getYakushoku();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * 事業開始年月日を返します。
     *
     * @return 事業開始年月日
     */
    public FlexibleDate get事業開始年月日() {
        return entity.getJigyoKaishiYMD();
    }

    /**
     * 事業休止年月日を返します。
     *
     * @return 事業休止年月日
     */
    public FlexibleDate get事業休止年月日() {
        return entity.getJigyoKyushiYMD();
    }

    /**
     * 事業廃止年月日を返します。
     *
     * @return 事業廃止年月日
     */
    public FlexibleDate get事業廃止年月日() {
        return entity.getJigyoHaishiYMD();
    }

    /**
     * 事業再開年月日を返します。
     *
     * @return 事業再開年月日
     */
    public FlexibleDate get事業再開年月日() {
        return entity.getJigyoSaikaiYMD();
    }

    /**
     * 事業者種別を設定します。
     *
     * @param 事業者種別 事業者種別
     */
    public void set事業者種別(RString 事業者種別) {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        entity.setJigyoshaShubetsu(事業者種別);
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(RString 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
    }

    /**
     * 有効開始年月日を設定します。
     *
     * @param 有効開始年月日 有効開始年月日
     */
    public void set有効開始年月日(FlexibleDate 有効開始年月日) {
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        entity.setYukoKaishiYMD(有効開始年月日);
    }

    /**
     * 有効終了年月日を設定します。
     *
     * @param 有効終了年月日 有効終了年月日
     */
    public void set有効終了年月日(FlexibleDate 有効終了年月日) {
        requireNonNull(有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月日"));
        entity.setYukoShuryoYMD(有効終了年月日);
    }

    /**
     * 管内_管外区分を設定します。
     *
     * @param 管内_管外区分 管内_管外区分
     */
    public void set管内_管外区分(RString 管内_管外区分) {
        requireNonNull(管内_管外区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管内_管外区分"));
        entity.setKannaiKangaiKubun(管内_管外区分);
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    public void set事業者名称(AtenaMeisho 事業者名称) {
        requireNonNull(事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称"));
        entity.setJigyoshaMeisho(事業者名称);
    }

    /**
     * 事業者名称カナを設定します。
     *
     * @param 事業者名称カナ 事業者名称カナ
     */
    public void set事業者名称カナ(AtenaKanaMeisho 事業者名称カナ) {
        requireNonNull(事業者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称カナ"));
        entity.setJigyoshaKanaMeisho(事業者名称カナ);
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
     * 事業者住所を設定します。
     *
     * @param 事業者住所 事業者住所
     */
    public void set事業者住所(RString 事業者住所) {
        requireNonNull(事業者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所"));
        entity.setJigyoshaJusho(事業者住所);
    }

    /**
     * 事業者住所カナを設定します。
     *
     * @param 事業者住所カナ 事業者住所カナ
     */
    public void set事業者住所カナ(RString 事業者住所カナ) {
        requireNonNull(事業者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所カナ"));
        entity.setJigyoshaKanaJusho(事業者住所カナ);
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
     * FAX番号を設定します。
     *
     * @param FAX番号 FAX番号
     */
    public void setFAX番号(TelNo FAX番号) {
        requireNonNull(FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(FAX番号);
    }

    /**
     * 異動事由を設定します。
     *
     * @param 異動事由 異動事由
     */
    public void set異動事由(RString 異動事由) {
        requireNonNull(異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由"));
        entity.setIdoJiyuCode(異動事由);
    }

    /**
     * 異動年月日を設定します。
     *
     * @param 異動年月日 異動年月日
     */
    public void set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
    }

    /**
     * 代表者名称を設定します。
     *
     * @param 代表者名称 代表者名称
     */
    public void set代表者名称(AtenaMeisho 代表者名称) {
        requireNonNull(代表者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名称"));
        entity.setDaihyoshaMeisho(代表者名称);
    }

    /**
     * 代表者名称カナを設定します。
     *
     * @param 代表者名称カナ 代表者名称カナ
     */
    public void set代表者名称カナ(AtenaKanaMeisho 代表者名称カナ) {
        requireNonNull(代表者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名称カナ"));
        entity.setDaihyoshaKanaMeisho(代表者名称カナ);
    }

    /**
     * 役職を設定します。
     *
     * @param 役職 役職
     */
    public void set役職(RString 役職) {
        requireNonNull(役職, UrSystemErrorMessages.値がnull.getReplacedMessage("役職"));
        entity.setYakushoku(役職);
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     */
    public void set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
    }

    /**
     * 事業開始年月日を設定します。
     *
     * @param 事業開始年月日 事業開始年月日
     */
    public void set事業開始年月日(FlexibleDate 事業開始年月日) {
        requireNonNull(事業開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業開始年月日"));
        entity.setJigyoKaishiYMD(事業開始年月日);
    }

    /**
     * 事業休止年月日を設定します。
     *
     * @param 事業休止年月日 事業休止年月日
     */
    public void set事業休止年月日(FlexibleDate 事業休止年月日) {
        requireNonNull(事業休止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業休止年月日"));
        entity.setJigyoKyushiYMD(事業休止年月日);
    }

    /**
     * 事業廃止年月日を設定します。
     *
     * @param 事業廃止年月日 事業廃止年月日
     */
    public void set事業廃止年月日(FlexibleDate 事業廃止年月日) {
        requireNonNull(事業廃止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業廃止年月日"));
        entity.setJigyoHaishiYMD(事業廃止年月日);
    }

    /**
     * 事業再開年月日を設定します。
     *
     * @param 事業再開年月日 事業再開年月日
     */
    public void set事業再開年月日(FlexibleDate 事業再開年月日) {
        requireNonNull(事業再開年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業再開年月日"));
        entity.setJigyoSaikaiYMD(事業再開年月日);
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
