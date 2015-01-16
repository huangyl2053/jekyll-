/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受領委任契約事業者のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class JuryoininKeiyakuJigyoshaModel implements Serializable {

    private DbT3077JuryoininKeiyakuJigyoshaEntity entity;

    /**
     * コンストラクタです。
     */
    public JuryoininKeiyakuJigyoshaModel() {
        entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3077JuryoininKeiyakuJigyoshaEntity
     */
    public JuryoininKeiyakuJigyoshaModel(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3077JuryoininKeiyakuJigyoshaEntityを返します。
     *
     * @return DbT3077JuryoininKeiyakuJigyoshaEntity
     */
    public DbT3077JuryoininKeiyakuJigyoshaEntity getEntity() {
        return entity;
    }

    /**
     * DbT3077JuryoininKeiyakuJigyoshaEntityを設定します。
     *
     * @param entity DbT3077JuryoininKeiyakuJigyoshaEntity
     */
    public void setEntity(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * 事業者契約番号を返します。
     *
     * @return 事業者契約番号
     */
    public RString get事業者契約番号() {
        return entity.getJigyoshaKeiyakuNo();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getKaishiYMD();
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
     * 終了年月日を返します。
     *
     * @return 終了年月日
     */
    public FlexibleDate get終了年月日() {
        return entity.getShuryoYMD();
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
     * 届出者住所を返します。
     *
     * @return 届出者住所
     */
    public RString get届出者住所() {
        return entity.getTodokedeAddress();
    }

    /**
     * 届出者事業者名称を返します。
     *
     * @return 届出者事業者名称
     */
    public RString get届出者事業者名称() {
        return entity.getTodokedeJigyoshaName();
    }

    /**
     * 届出者代表者氏名を返します。
     *
     * @return 届出者代表者氏名
     */
    public RString get届出者代表者氏名() {
        return entity.getTodokedeDaihyoshaName();
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
     * 事業者FAX番号を返します。
     *
     * @return 事業者FAX番号
     */
    public TelNo get事業者FAX番号() {
        return entity.getJigyoshaFaxNo();
    }

    /**
     * 契約登録年月日を返します。
     *
     * @return 契約登録年月日
     */
    public FlexibleDate get契約登録年月日() {
        return entity.getKeiyakuTorokuYMD();
    }

    /**
     * 送付先部署を返します。
     *
     * @return 送付先部署
     */
    public RString get送付先部署() {
        return entity.getSofusakiBusho();
    }

    /**
     * 営業形態を返します。
     *
     * @return 営業形態
     */
    public RString get営業形態() {
        return entity.getEigyoKeitai();
    }

    /**
     * 住宅改修契約有無を返します。
     *
     * @return 住宅改修契約有無
     */
    public boolean get住宅改修契約有無() {
        return entity.getJutakuKaishuKeiyakuUmu();
    }

    /**
     * 特定福祉用具販売契約有無を返します。
     *
     * @return 特定福祉用具販売契約有無
     */
    public boolean get特定福祉用具販売契約有無() {
        return entity.getTokuteiFukushiYoguHanbaiKeiyakuUmu();
    }

    /**
     * 償還払給付契約有無を返します。
     *
     * @return 償還払給付契約有無
     */
    public boolean get償還払給付契約有無() {
        return entity.getShokanbaraiKyufuKeiyakuUmu();
    }

    /**
     * 高額給付契約有無を返します。
     *
     * @return 高額給付契約有無
     */
    public boolean get高額給付契約有無() {
        return entity.getKogakuKyufuKeiyakuUmu();
    }

    /**
     * 契約事業者番号を返します。
     *
     * @return 契約事業者番号
     */
    public JigyoshaNo get契約事業者番号() {
        return entity.getKeiyakuJigyoshaNo();
    }

    /**
     * 取扱確約書有無を返します。
     *
     * @return 取扱確約書有無
     */
    public boolean get取扱確約書有無() {
        return entity.getToriatsukaiKakuyakushoUmu();
    }

    /**
     * 事業者契約番号を設定します。
     *
     * @param 事業者契約番号 事業者契約番号
     */
    public void set事業者契約番号(RString 事業者契約番号) {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        entity.setJigyoshaKeiyakuNo(事業者契約番号);
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     */
    public void set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setKaishiYMD(開始年月日);
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
     * 終了年月日を設定します。
     *
     * @param 終了年月日 終了年月日
     */
    public void set終了年月日(FlexibleDate 終了年月日) {
        requireNonNull(終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月日"));
        entity.setShuryoYMD(終了年月日);
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
     * 届出者住所を設定します。
     *
     * @param 届出者住所 届出者住所
     */
    public void set届出者住所(RString 届出者住所) {
        requireNonNull(届出者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者住所"));
        entity.setTodokedeAddress(届出者住所);
    }

    /**
     * 届出者事業者名称を設定します。
     *
     * @param 届出者事業者名称 届出者事業者名称
     */
    public void set届出者事業者名称(RString 届出者事業者名称) {
        requireNonNull(届出者事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者事業者名称"));
        entity.setTodokedeJigyoshaName(届出者事業者名称);
    }

    /**
     * 届出者代表者氏名を設定します。
     *
     * @param 届出者代表者氏名 届出者代表者氏名
     */
    public void set届出者代表者氏名(RString 届出者代表者氏名) {
        requireNonNull(届出者代表者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者代表者氏名"));
        entity.setTodokedeDaihyoshaName(届出者代表者氏名);
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
     * 事業者FAX番号を設定します。
     *
     * @param 事業者FAX番号 事業者FAX番号
     */
    public void set事業者FAX番号(TelNo 事業者FAX番号) {
        requireNonNull(事業者FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者FAX番号"));
        entity.setJigyoshaFaxNo(事業者FAX番号);
    }

    /**
     * 契約登録年月日を設定します。
     *
     * @param 契約登録年月日 契約登録年月日
     */
    public void set契約登録年月日(FlexibleDate 契約登録年月日) {
        requireNonNull(契約登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("契約登録年月日"));
        entity.setKeiyakuTorokuYMD(契約登録年月日);
    }

    /**
     * 送付先部署を設定します。
     *
     * @param 送付先部署 送付先部署
     */
    public void set送付先部署(RString 送付先部署) {
        requireNonNull(送付先部署, UrSystemErrorMessages.値がnull.getReplacedMessage("送付先部署"));
        entity.setSofusakiBusho(送付先部署);
    }

    /**
     * 営業形態を設定します。
     *
     * @param 営業形態 営業形態
     */
    public void set営業形態(RString 営業形態) {
        requireNonNull(営業形態, UrSystemErrorMessages.値がnull.getReplacedMessage("営業形態"));
        entity.setEigyoKeitai(営業形態);
    }

    /**
     * 住宅改修契約有無を設定します。
     *
     * @param 住宅改修契約有無 住宅改修契約有無
     */
    public void set住宅改修契約有無(boolean 住宅改修契約有無) {
        requireNonNull(住宅改修契約有無, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修契約有無"));
        entity.setJutakuKaishuKeiyakuUmu(住宅改修契約有無);
    }

    /**
     * 特定福祉用具販売契約有無を設定します。
     *
     * @param 特定福祉用具販売契約有無 特定福祉用具販売契約有無
     */
    public void set特定福祉用具販売契約有無(boolean 特定福祉用具販売契約有無) {
        requireNonNull(特定福祉用具販売契約有無, UrSystemErrorMessages.値がnull.getReplacedMessage("特定福祉用具販売契約有無"));
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(特定福祉用具販売契約有無);
    }

    /**
     * 償還払給付契約有無を設定します。
     *
     * @param 償還払給付契約有無 償還払給付契約有無
     */
    public void set償還払給付契約有無(boolean 償還払給付契約有無) {
        requireNonNull(償還払給付契約有無, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払給付契約有無"));
        entity.setShokanbaraiKyufuKeiyakuUmu(償還払給付契約有無);
    }

    /**
     * 高額給付契約有無を設定します。
     *
     * @param 高額給付契約有無 高額給付契約有無
     */
    public void set高額給付契約有無(boolean 高額給付契約有無) {
        requireNonNull(高額給付契約有無, UrSystemErrorMessages.値がnull.getReplacedMessage("高額給付契約有無"));
        entity.setKogakuKyufuKeiyakuUmu(高額給付契約有無);
    }

    /**
     * 契約事業者番号を設定します。
     *
     * @param 契約事業者番号 契約事業者番号
     */
    public void set契約事業者番号(JigyoshaNo 契約事業者番号) {
        requireNonNull(契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者番号"));
        entity.setKeiyakuJigyoshaNo(契約事業者番号);
    }

    /**
     * 取扱確約書有無を設定します。
     *
     * @param 取扱確約書有無 取扱確約書有無
     */
    public void set取扱確約書有無(boolean 取扱確約書有無) {
        requireNonNull(取扱確約書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱確約書有無"));
        entity.setToriatsukaiKakuyakushoUmu(取扱確約書有無);
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
