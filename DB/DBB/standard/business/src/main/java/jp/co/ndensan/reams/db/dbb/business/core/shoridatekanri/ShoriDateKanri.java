/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author cuilin
 */
public class ShoriDateKanri extends ParentModelBase<ShoriDateKanriIdentifier, DbT7022ShoriDateKanriEntity, ShoriDateKanri> implements Serializable {

    private final DbT7022ShoriDateKanriEntity entity;
    private final ShoriDateKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 処理日付管理マスタの新規作成時に使用します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 処理名 処理名
     * @param 年度 年度
     */
    public ShoriDateKanri(SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("処理名"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        this.entity = new DbT7022ShoriDateKanriEntity();
        this.entity.setSubGyomuCode(サブ業務コード);
        this.entity.setShoriName(処理名);
        this.entity.setNendo(年度);
        this.id = new ShoriDateKanriIdentifier(
                サブ業務コード,
                処理名,
                年度
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7022ShoriDateKanriEntity}より{@link ShoriDateKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT7022ShoriDateKanriEntity}
     */
    public ShoriDateKanri(DbT7022ShoriDateKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日付管理マスタ"));
        this.id = new ShoriDateKanriIdentifier(
                entity.getSubGyomuCode(),
                entity.getShoriName(),
                entity.getNendo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7022ShoriDateKanriEntity}
     * @param id {@link ShoriDateKanriIdentifier}
     */
    ShoriDateKanri(
            DbT7022ShoriDateKanriEntity entity,
            ShoriDateKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
    public RString get処理名() {
        return entity.getShoriName();
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
     * 基準日時を返します。
     *
     * @return 基準日時
     */
    public YMDHMS get基準日時() {
        return entity.getKijunTimestamp();
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
     * {@link DbT7022ShoriDateKanriEntity}のクローンを返します。
     *
     * @return {@link DbT7022ShoriDateKanriEntity}のクローン
     */
    @Override
    public DbT7022ShoriDateKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 処理日付管理マスタの識別子{@link ShoriDateKanriIdentifier}を返します。
     *
     * @return 処理日付管理マスタの識別子{@link ShoriDateKanriIdentifier}
     */
    @Override
    public ShoriDateKanriIdentifier identifier() {
        return this.id;
    }

    @Override
    public ShoriDateKanri modifiedModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ShoriDateKanri deleted() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
