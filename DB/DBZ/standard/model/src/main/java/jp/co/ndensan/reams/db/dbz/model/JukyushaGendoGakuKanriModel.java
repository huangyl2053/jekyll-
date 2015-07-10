/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受給者限度額管理のモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class JukyushaGendoGakuKanriModel implements Serializable {

    private DbT7116JukyushaGendoGakuKanriEntity entity;

    /**
     * コンストラクタです。
     */
    public JukyushaGendoGakuKanriModel() {
        entity = new DbT7116JukyushaGendoGakuKanriEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7116JukyushaGendoGakuKanriEntity
     */
    public JukyushaGendoGakuKanriModel(DbT7116JukyushaGendoGakuKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7116JukyushaGendoGakuKanriEntityを返します。
     *
     * @return DbT7116JukyushaGendoGakuKanriEntity
     */
    public DbT7116JukyushaGendoGakuKanriEntity getEntity() {
        return entity;
    }

    /**
     * DbT7116JukyushaGendoGakuKanriEntityを設定します。
     *
     * @param entity DbT7116JukyushaGendoGakuKanriEntity
     */
    public void setEntity(DbT7116JukyushaGendoGakuKanriEntity entity) {
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
     * 識別区分を返します。
     *
     * @return 識別区分
     */
    public RString get識別区分() {
        return entity.getShikibetsuKubun();
    }

    /**
     * 有効開始年月を返します。
     *
     * @return 有効開始年月
     */
    public FlexibleYearMonth get有効開始年月() {
        return entity.getYukoKaishiYM();
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
     * 有効終了年月を返します。
     *
     * @return 有効終了年月
     */
    public FlexibleYearMonth get有効終了年月() {
        return entity.getYukoShuryoYM();
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        return entity.getYoKaigoJotaiKubun();
    }

    /**
     * 拡大倍数を返します。
     *
     * @return 拡大倍数
     */
    public RString get拡大倍数() {
        return entity.getKakudaiBaisu();
    }

    /**
     * 切り分け単位数を返します。
     *
     * @return 切り分け単位数
     */
    public Decimal get切り分け単位数() {
        return entity.getKiriwakeTaniSu();
    }

    /**
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    public FlexibleDate get登録年月日() {
        return entity.getTorokuYMD();
    }

    /**
     * 変更年月日を返します。
     *
     * @return 変更年月日
     */
    public FlexibleDate get変更年月日() {
        return entity.getHenkoYMD();
    }

    /**
     * 限度額管理期間数を返します。
     *
     * @return 限度額管理期間数
     */
    public RString get限度額管理期間数() {
        return entity.getGendoGakuKanriKikanSu();
    }

    /**
     * 新体系管理区分を返します。
     *
     * @return 新体系管理区分
     */
    public RString get新体系管理区分() {
        return entity.getShinTaikeiKanriKubun();
    }

    /**
     * 新体系拡大適用有無を返します。
     *
     * @return 新体系拡大適用有無
     */
    public RString get新体系拡大適用有無() {
        return entity.getShinTaikeiKakudaiTekiyoUmu();
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
     * 識別区分を設定します。
     *
     * @param 識別区分 識別区分
     */
    public void set識別区分(RString 識別区分) {
        requireNonNull(識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("識別区分"));
        entity.setShikibetsuKubun(識別区分);
    }

    /**
     * 有効開始年月を設定します。
     *
     * @param 有効開始年月 有効開始年月
     */
    public void set有効開始年月(FlexibleYearMonth 有効開始年月) {
        requireNonNull(有効開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月"));
        entity.setYukoKaishiYM(有効開始年月);
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
     * 有効終了年月を設定します。
     *
     * @param 有効終了年月 有効終了年月
     */
    public void set有効終了年月(FlexibleYearMonth 有効終了年月) {
        requireNonNull(有効終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月"));
        entity.setYukoShuryoYM(有効終了年月);
    }

    /**
     * 要介護状態区分を設定します。
     *
     * @param 要介護状態区分 要介護状態区分
     */
    public void set要介護状態区分(RString 要介護状態区分) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        entity.setYoKaigoJotaiKubun(要介護状態区分);
    }

    /**
     * 拡大倍数を設定します。
     *
     * @param 拡大倍数 拡大倍数
     */
    public void set拡大倍数(RString 拡大倍数) {
        requireNonNull(拡大倍数, UrSystemErrorMessages.値がnull.getReplacedMessage("拡大倍数"));
        entity.setKakudaiBaisu(拡大倍数);
    }

    /**
     * 切り分け単位数を設定します。
     *
     * @param 切り分け単位数 切り分け単位数
     */
    public void set切り分け単位数(Decimal 切り分け単位数) {
        requireNonNull(切り分け単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("切り分け単位数"));
        entity.setKiriwakeTaniSu(切り分け単位数);
    }

    /**
     * 登録年月日を設定します。
     *
     * @param 登録年月日 登録年月日
     */
    public void set登録年月日(FlexibleDate 登録年月日) {
        requireNonNull(登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録年月日"));
        entity.setTorokuYMD(登録年月日);
    }

    /**
     * 変更年月日を設定します。
     *
     * @param 変更年月日 変更年月日
     */
    public void set変更年月日(FlexibleDate 変更年月日) {
        requireNonNull(変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("変更年月日"));
        entity.setHenkoYMD(変更年月日);
    }

    /**
     * 限度額管理期間数を設定します。
     *
     * @param 限度額管理期間数 限度額管理期間数
     */
    public void set限度額管理期間数(RString 限度額管理期間数) {
        requireNonNull(限度額管理期間数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理期間数"));
        entity.setGendoGakuKanriKikanSu(限度額管理期間数);
    }

    /**
     * 新体系管理区分を設定します。
     *
     * @param 新体系管理区分 新体系管理区分
     */
    public void set新体系管理区分(RString 新体系管理区分) {
        requireNonNull(新体系管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("新体系管理区分"));
        entity.setShinTaikeiKanriKubun(新体系管理区分);
    }

    /**
     * 新体系拡大適用有無を設定します。
     *
     * @param 新体系拡大適用有無 新体系拡大適用有無
     */
    public void set新体系拡大適用有無(RString 新体系拡大適用有無) {
        requireNonNull(新体系拡大適用有無, UrSystemErrorMessages.値がnull.getReplacedMessage("新体系拡大適用有無"));
        entity.setShinTaikeiKakudaiTekiyoUmu(新体系拡大適用有無);
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
