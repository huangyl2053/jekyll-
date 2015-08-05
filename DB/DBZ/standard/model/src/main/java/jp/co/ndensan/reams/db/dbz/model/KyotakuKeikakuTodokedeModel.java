/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画届出のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyotakuKeikakuTodokedeModel implements Serializable {

    private DbT3005KyotakuKeikakuTodokedeEntity entity;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuTodokedeModel() {
        entity = new DbT3005KyotakuKeikakuTodokedeEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3005KyotakuKeikakuTodokedeEntity
     */
    public KyotakuKeikakuTodokedeModel(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3005KyotakuKeikakuTodokedeEntityを返します。
     *
     * @return DbT3005KyotakuKeikakuTodokedeEntity
     */
    public DbT3005KyotakuKeikakuTodokedeEntity getEntity() {
        return entity;
    }

    /**
     * DbT3005KyotakuKeikakuTodokedeEntityを設定します。
     *
     * @param entity DbT3005KyotakuKeikakuTodokedeEntity
     */
    public void setEntity(DbT3005KyotakuKeikakuTodokedeEntity entity) {
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
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
    }

    /**
     * 届出区分を返します。
     *
     * @return 届出区分
     */
    public RString get届出区分() {
        return entity.getTodokedeKubun();
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
     * 届出者氏名を返します。
     *
     * @return 届出者氏名
     */
    public AtenaMeisho get届出者氏名() {
        return entity.getTodokedeshaShimei();
    }

    /**
     * 届出者氏名カナを返します。
     *
     * @return 届出者氏名カナ
     */
    public AtenaKanaMeisho get届出者氏名カナ() {
        return entity.getTodokedeshaShimeiKana();
    }

    /**
     * 届出者郵便番号を返します。
     *
     * @return 届出者郵便番号
     */
    public YubinNo get届出者郵便番号() {
        return entity.getTodokedeshaYubinNo();
    }

    /**
     * 届出者住所を返します。
     *
     * @return 届出者住所
     */
    public RString get届出者住所() {
        return entity.getTodokedeshaJusho();
    }

    /**
     * 届出者電話番号を返します。
     *
     * @return 届出者電話番号
     */
    public TelNo get届出者電話番号() {
        return entity.getTodokedeshaTelNo();
    }

    /**
     * 届出者関係区分を返します。
     *
     * @return 届出者関係区分
     */
    public RString get届出者関係区分() {
        return entity.getTodokedeshaKankeiKubun();
    }

    /**
     * 暫定区分を返します。
     *
     * @return 暫定区分
     */
    public RString get暫定区分() {
        return entity.getZanteiKubun();
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
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     */
    public void set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
    }

    /**
     * 届出区分を設定します。
     *
     * @param 届出区分 届出区分
     */
    public void set届出区分(RString 届出区分) {
        requireNonNull(届出区分, UrSystemErrorMessages.値がnull.getReplacedMessage("届出区分"));
        entity.setTodokedeKubun(届出区分);
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
     * 届出者氏名を設定します。
     *
     * @param 届出者氏名 届出者氏名
     */
    public void set届出者氏名(AtenaMeisho 届出者氏名) {
        requireNonNull(届出者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者氏名"));
        entity.setTodokedeshaShimei(届出者氏名);
    }

    /**
     * 届出者氏名カナを設定します。
     *
     * @param 届出者氏名カナ 届出者氏名カナ
     */
    public void set届出者氏名カナ(AtenaKanaMeisho 届出者氏名カナ) {
        requireNonNull(届出者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者氏名カナ"));
        entity.setTodokedeshaShimeiKana(届出者氏名カナ);
    }

    /**
     * 届出者郵便番号を設定します。
     *
     * @param 届出者郵便番号 届出者郵便番号
     */
    public void set届出者郵便番号(YubinNo 届出者郵便番号) {
        requireNonNull(届出者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者郵便番号"));
        entity.setTodokedeshaYubinNo(届出者郵便番号);
    }

    /**
     * 届出者住所を設定します。
     *
     * @param 届出者住所 届出者住所
     */
    public void set届出者住所(RString 届出者住所) {
        requireNonNull(届出者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者住所"));
        entity.setTodokedeshaJusho(届出者住所);
    }

    /**
     * 届出者電話番号を設定します。
     *
     * @param 届出者電話番号 届出者電話番号
     */
    public void set届出者電話番号(TelNo 届出者電話番号) {
        requireNonNull(届出者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者電話番号"));
        entity.setTodokedeshaTelNo(届出者電話番号);
    }

    /**
     * 届出者関係区分を設定します。
     *
     * @param 届出者関係区分 届出者関係区分
     */
    public void set届出者関係区分(RString 届出者関係区分) {
        requireNonNull(届出者関係区分, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者関係区分"));
        entity.setTodokedeshaKankeiKubun(届出者関係区分);
    }

    /**
     * 暫定区分を設定します。
     *
     * @param 暫定区分 暫定区分
     */
    public void set暫定区分(RString 暫定区分) {
        requireNonNull(暫定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("暫定区分"));
        entity.setZanteiKubun(暫定区分);
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
