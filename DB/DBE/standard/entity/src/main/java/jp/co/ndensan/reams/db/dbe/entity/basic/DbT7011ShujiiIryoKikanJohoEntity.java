package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

public class DbT7011ShujiiIryoKikanJohoEntity implements IDbAccessable {

    @TableName
    public final static String TABLE_NAME = "DbT7011ShujiiIryoKikanJoho";
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted;
    private int updateCount;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shichosonCode;
    @PrimaryKey
    private RString kaigoIryokikanCode;
    private RString iryokikanCode;
    private boolean iryokikanJokyo;
    private RString kikanKubunCode;

    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    public RDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(RDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public RString getInsertReamsLoginId() {
        return insertReamsLoginId;
    }

    public void setInsertReamsLoginId(RString insertReamsLoginId) {
        this.insertReamsLoginId = insertReamsLoginId;
    }

    public UUID getInsertContextId() {
        return insertContextId;
    }

    public void setInsertContextId(UUID insertContextId) {
        this.insertContextId = insertContextId;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(RDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public RString getLastUpdateReamsLoginId() {
        return lastUpdateReamsLoginId;
    }

    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    public RString getKaigoIryokikanCode() {
        return kaigoIryokikanCode;
    }

    public void setKaigoIryokikanCode(RString kaigoIryokikanCode) {
        this.kaigoIryokikanCode = kaigoIryokikanCode;
    }

    public RString getIryokikanCode() {
        return iryokikanCode;
    }

    public void setIryokikanCode(RString iryokikanCode) {
        this.iryokikanCode = iryokikanCode;
    }

    public boolean getIryokikanJokyo() {
        return iryokikanJokyo;
    }

    public void setIryokikanJokyo(boolean iryokikanJokyo) {
        this.iryokikanJokyo = iryokikanJokyo;
    }

    public RString getKikanKubunCode() {
        return kikanKubunCode;
    }

    public void setKikanKubunCode(RString kikanKubunCode) {
        this.kikanKubunCode = kikanKubunCode;
    }

    /**
     * コードマスタから名称を取得する。
     *
     * @return 医療機関区分コードに対応する名称
     */
    public RString getIryoKikanKubunMeisho() {
        //TODO n8178 城間篤人
        //コード種別に入るべき値を調べて、後日そちらに変更予定。現在は仮の値が入っている。 2014年2月末
        RString コード種別 = new RString("21");
        return CodeMaster.getCodeMeisho(コード種別, kikanKubunCode);
    }

    /**
     * コードマスタから略称を取得する。
     *
     * @return 医療機関区分コードに対応する略称
     */
    public RString getIryoKikanKubunRyakusho() {
        //TODO n8178 城間篤人
        //略称が必要か否か後日確認 2014年2/4まで
        //コード種別に入るべき値を調べて、後日そちらに変更予定。現在は仮の値が入っている。 2014年2月末
        RString コード種別 = new RString("21");
        return CodeMaster.getCodeRyakusho(コード種別, kikanKubunCode);
    }
}
