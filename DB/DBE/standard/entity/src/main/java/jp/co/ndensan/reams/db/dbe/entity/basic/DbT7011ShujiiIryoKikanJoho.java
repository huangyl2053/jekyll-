package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

public enum DbT7011ShujiiIryoKikanJoho implements IColumnDefinition {

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shichosonCode(5, 0),
    kaigoIryokikanCode(10, 0),
    iryokikanCode(10, 0),
    iryokikanJokyo(1, 0),
    kikanKubunCode(2147483647, 0);
    private final int maxLength;
    private final int scale;

    private DbT7011ShujiiIryoKikanJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getScale() {
        return scale;
    }
}
