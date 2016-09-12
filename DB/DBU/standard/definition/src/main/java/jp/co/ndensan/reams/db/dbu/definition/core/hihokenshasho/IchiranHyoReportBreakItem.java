package jp.co.ndensan.reams.db.dbu.definition.core.hihokenshasho;

import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.IBreakPageColumnMapping;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票「被保険者台帳一覧表」改頁を表す列挙型です。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 */
public enum IchiranHyoReportBreakItem implements IBreakPageColumnMapping {

    /**
     * jiyu
     */
    jiyu("jiyu", "交付・非交付事由", "list_10");

    private final RString column;
    private final RString item;
    private final RString breakPageName;

    /**
     * コンストラクタです。
     *
     * @param column 項目名
     * @param tableName テーブル名
     */
    IchiranHyoReportBreakItem(String column, String item, String breakPageName) {
        this.column = new RString(column);
        this.item = new RString(item);
        this.breakPageName = new RString(breakPageName);
    }

    @Override
    public RString getColumn() {
        return this.column;
    }

    @Override
    public RString getItem() {
        return this.item;
    }

    @Override
    public RString getBreakPageName() {
        return this.breakPageName;
    }

    @Override
    public IchiranHyoReportBreakItem toValue(RString item) {
        for (IchiranHyoReportBreakItem relateitem : IchiranHyoReportBreakItem.values()) {
            if (relateitem.item.equals(item)) {
                return relateitem;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("該当の項目名").toString());
    }
}
