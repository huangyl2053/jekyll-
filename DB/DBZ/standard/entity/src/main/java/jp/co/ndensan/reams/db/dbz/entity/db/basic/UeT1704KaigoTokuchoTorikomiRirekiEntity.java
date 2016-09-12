package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgue")
public class UeT1704KaigoTokuchoTorikomiRirekiEntity
        extends DbTableEntityBase<UeT1704KaigoTokuchoTorikomiRirekiEntity>
        implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("UeT1704KaigoTokuchoTorikomiRireki");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int renban;
    private RString dataShubetsu;
    private RDateTime shoriTimestamp;
    private RString fileName;
    private RDateTime fileTimestamp;

    public RString getInsertDantaiCd() {
        return this.insertDantaiCd;
    }

    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    public int getRenban() {
        return this.renban;
    }

    public void setRenban(@Nonnull int renban) {
        this.renban = renban;
    }

    @CheckForNull
    public RString getDataShubetsu() {
        return this.dataShubetsu;
    }

    public void setDataShubetsu(RString dataShubetsu) {
        this.dataShubetsu = dataShubetsu;
    }

    @CheckForNull
    public RDateTime getShoriTimestamp() {
        return this.shoriTimestamp;
    }

    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    @CheckForNull
    public RString getFileName() {
        return this.fileName;
    }

    public void setFileName(RString fileName) {
        this.fileName = fileName;
    }

    @CheckForNull
    public RDateTime getFileTimestamp() {
        return this.fileTimestamp;
    }

    public void setFileTimestamp(RDateTime fileTimestamp) {
        this.fileTimestamp = fileTimestamp;
    }

    @Override
    public boolean equalsPrimaryKeys(UeT1704KaigoTokuchoTorikomiRirekiEntity other) {
        if (other == null) {
            return false;
        }
        return this.renban == other.renban;
    }

    @Override
    public void shallowCopy(UeT1704KaigoTokuchoTorikomiRirekiEntity entity) {
        this.renban = entity.renban;
        this.dataShubetsu = entity.dataShubetsu;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.fileName = entity.fileName;
        this.fileTimestamp = entity.fileTimestamp;
    }

    @Override
    public RString getMd5() {
        return super.toMd5(new Object[]{Integer.valueOf(this.renban), this.dataShubetsu, this.shoriTimestamp, this.fileName, this.fileTimestamp});
    }
}
