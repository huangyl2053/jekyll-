/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 処理日付マスタのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ShoriDateModel implements Serializable {

    private DbT7022ShoriDateKanriEntity entity;

    /**
     * コンストラクタです。
     */
    public ShoriDateModel() {
        entity = new DbT7022ShoriDateKanriEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     */
    public ShoriDateModel(DbT7022ShoriDateKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7022ShoriDateKanriEntityを返します。
     *
     * @return DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity getEntity() {
        return entity;
    }

    /**
     * DbT7022ShoriDateKanriEntityを設定します。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     */
    public void setEntity(DbT7022ShoriDateKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return entity.getSubGyomuCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 処理名を返します。
     *
     * @return 処理名
     */
    public ShoriName get処理名() {
        return ShoriName.valueOf(entity.getShoriName().toString());
    }

    /**
     * 処理枝番を返します。
     *
     * @return 処理枝番
     */
    public RString get処理枝番() {
        return entity.getShoriEdaban();
    }

    /**
     * 年度を返します。
     *
     * @return 年度
     */
    public FlexibleYear get年度() {
        return entity.getNendo();
    }

    /**
     * 年度内連番を返します。
     *
     * @return 年度内連番
     */
    public RString get年度内連番() {
        return entity.getNendoNaiRenban();
    }

    /**
     * 基準年月日を返します。
     *
     * @return 基準年月日
     */
    public FlexibleDate get基準年月日() {
        return entity.getKijunYMD();
    }

    /**
     * 対象開始年月日を返します。
     *
     * @return 対象開始年月日
     */
    public FlexibleDate get対象開始年月日() {
        return entity.getTaishoKaishiYMD();
    }

    /**
     * 対象終了年月日を返します。
     *
     * @return 対象終了年月日
     */
    public FlexibleDate get対象終了年月日() {
        return entity.getTaishoShuryoYMD();
    }

    /**
     * 対象開始日時を返します。
     *
     * @return 対象開始日時
     */
    public YMDHMS get対象開始日時() {
        return entity.getTaishoKaishiTimestamp();
    }

    /**
     * 対象終了日時を返します。
     *
     * @return 対象終了日時
     */
    public YMDHMS get対象終了日時() {
        return entity.getTaishoShuryoTimestamp();
    }

    /**
     * サブ業務コードを設定します。
     *
     * @param サブ業務コード サブ業務コード
     */
    public void setサブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        entity.setSubGyomuCode(サブ業務コード);
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 処理名を設定します。
     *
     * @param 処理名 処理名
     */
    public void set処理名(ShoriName 処理名) {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("処理名"));
        entity.setShoriName(処理名.toRString());
    }

    /**
     * 処理枝番を設定します。
     *
     * @param 処理枝番 処理枝番
     */
    public void set処理枝番(RString 処理枝番) {
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("処理枝番"));
        entity.setShoriEdaban(処理枝番);
    }

    /**
     * 年度を設定します。
     *
     * @param 年度 年度
     */
    public void set年度(FlexibleYear 年度) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        entity.setNendo(年度);
    }

    /**
     * 年度内連番を設定します。
     *
     * @param 年度内連番 年度内連番
     */
    public void set年度内連番(RString 年度内連番) {
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));
        entity.setNendoNaiRenban(年度内連番);
    }

    /**
     * 基準年月日を設定します。
     *
     * @param 基準年月日 基準年月日
     */
    public void set基準年月日(FlexibleDate 基準年月日) {
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));
        entity.setKijunYMD(基準年月日);
    }

    /**
     * 対象開始年月日を設定します。
     *
     * @param 対象開始年月日 対象開始年月日
     */
    public void set対象開始年月日(FlexibleDate 対象開始年月日) {
        requireNonNull(対象開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象開始年月日"));
        entity.setTaishoKaishiYMD(対象開始年月日);
    }

    /**
     * 対象終了年月日を設定します。
     *
     * @param 対象終了年月日 対象終了年月日
     */
    public void set対象終了年月日(FlexibleDate 対象終了年月日) {
        requireNonNull(対象終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象終了年月日"));
        entity.setTaishoShuryoYMD(対象終了年月日);
    }

    /**
     * 対象開始日時を設定します。
     *
     * @param 対象開始日時 対象開始日時
     */
    public void set対象開始日時(YMDHMS 対象開始日時) {
        requireNonNull(対象開始日時, UrSystemErrorMessages.値がnull.getReplacedMessage("対象開始日時"));
        entity.setTaishoKaishiTimestamp(対象開始日時);
    }

    /**
     * 対象終了日時を設定します。
     *
     * @param 対象終了日時 対象終了日時
     */
    public void set対象終了日時(YMDHMS 対象終了日時) {
        requireNonNull(対象終了日時, UrSystemErrorMessages.値がnull.getReplacedMessage("対象終了日時"));
        entity.setTaishoShuryoTimestamp(対象終了日時);
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
